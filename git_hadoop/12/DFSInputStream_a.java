/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.fs.ByteBufferReadable;
import org.apache.hadoop.fs.ByteBufferUtil;
import org.apache.hadoop.fs.CanSetDropBehind;
import org.apache.hadoop.fs.CanSetReadahead;
import org.apache.hadoop.fs.ChecksumException;
import org.apache.hadoop.fs.FSInputStream;
import org.apache.hadoop.fs.HasEnhancedByteBufferAccess;
import org.apache.hadoop.fs.ReadOption;
import org.apache.hadoop.fs.UnresolvedLinkException;
import org.apache.hadoop.hdfs.client.ClientMmap;
import org.apache.hadoop.hdfs.net.DomainPeer;
import org.apache.hadoop.hdfs.net.Peer;
import org.apache.hadoop.hdfs.net.TcpPeerServer;
import org.apache.hadoop.hdfs.protocol.ClientDatanodeProtocol;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.hdfs.protocol.ExtendedBlock;
import org.apache.hadoop.hdfs.protocol.LocatedBlock;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;
import org.apache.hadoop.hdfs.protocol.datatransfer.InvalidEncryptionKeyException;
import org.apache.hadoop.hdfs.security.token.block.BlockTokenIdentifier;
import org.apache.hadoop.hdfs.security.token.block.InvalidBlockTokenException;
import org.apache.hadoop.hdfs.server.datanode.CachingStrategy;
import org.apache.hadoop.hdfs.server.datanode.ReplicaNotFoundException;
import org.apache.hadoop.io.ByteBufferPool;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RemoteException;
import org.apache.hadoop.net.NetUtils;
import org.apache.hadoop.net.unix.DomainSocket;
import org.apache.hadoop.security.AccessControlException;
import org.apache.hadoop.security.token.SecretManager.InvalidToken;
import org.apache.hadoop.security.token.Token;
import org.apache.hadoop.util.IdentityHashStore;

import com.google.common.annotations.VisibleForTesting;

/****************************************************************
 * DFSInputStream provides bytes from a named file.  It handles 
 * negotiation of the namenode and various datanodes as necessary.
 ****************************************************************/
@InterfaceAudience.Private
public class DFSInputStream extends FSInputStream
implements ByteBufferReadable, CanSetDropBehind, CanSetReadahead,
    HasEnhancedByteBufferAccess {
  @VisibleForTesting
  static boolean tcpReadsDisabledForTesting = false;
  private final PeerCache peerCache;
  private final DFSClient dfsClient;
  private boolean closed = false;
  private final String src;
  private BlockReader blockReader = null;
  private final boolean verifyChecksum;
  private LocatedBlocks locatedBlocks = null;
  private long lastBlockBeingWrittenLength = 0;
  private DatanodeInfo currentNode = null;
  private LocatedBlock currentLocatedBlock = null;
  private long pos = 0;
  private long blockEnd = -1;
  private CachingStrategy cachingStrategy;
  private final ReadStatistics readStatistics = new ReadStatistics();

  /**
   * Track the ByteBuffers that we have handed out to readers.
   * 
   * The value type can be either ByteBufferPool or ClientMmap, depending on
   * whether we this is a memory-mapped buffer or not.
   */
  private final IdentityHashStore<ByteBuffer, Object>
      extendedReadBuffers = new IdentityHashStore<ByteBuffer, Object>(0);

  public static class ReadStatistics {
    public ReadStatistics() {
      this.totalBytesRead = 0;
      this.totalLocalBytesRead = 0;
      this.totalShortCircuitBytesRead = 0;
      this.totalZeroCopyBytesRead = 0;
    }

    public ReadStatistics(ReadStatistics rhs) {
      this.totalBytesRead = rhs.getTotalBytesRead();
      this.totalLocalBytesRead = rhs.getTotalLocalBytesRead();
      this.totalShortCircuitBytesRead = rhs.getTotalShortCircuitBytesRead();
      this.totalZeroCopyBytesRead = rhs.getTotalZeroCopyBytesRead();
    }

    /**
     * @return The total bytes read.  This will always be at least as
     * high as the other numbers, since it includes all of them.
     */
    public long getTotalBytesRead() {
      return totalBytesRead;
    }

    /**
     * @return The total local bytes read.  This will always be at least
     * as high as totalShortCircuitBytesRead, since all short-circuit
     * reads are also local.
     */
    public long getTotalLocalBytesRead() {
      return totalLocalBytesRead;
    }

    /**
     * @return The total short-circuit local bytes read.
     */
    public long getTotalShortCircuitBytesRead() {
      return totalShortCircuitBytesRead;
    }
    
    /**
     * @return The total number of zero-copy bytes read.
     */
    public long getTotalZeroCopyBytesRead() {
      return totalZeroCopyBytesRead;
    }

    /**
     * @return The total number of bytes read which were not local.
     */
    public long getRemoteBytesRead() {
      return totalBytesRead - totalLocalBytesRead;
    }
    
    void addRemoteBytes(long amt) {
      this.totalBytesRead += amt;
    }

    void addLocalBytes(long amt) {
      this.totalBytesRead += amt;
      this.totalLocalBytesRead += amt;
    }

    void addShortCircuitBytes(long amt) {
      this.totalBytesRead += amt;
      this.totalLocalBytesRead += amt;
      this.totalShortCircuitBytesRead += amt;
    }

    void addZeroCopyBytes(long amt) {
      this.totalBytesRead += amt;
      this.totalLocalBytesRead += amt;
      this.totalShortCircuitBytesRead += amt;
      this.totalZeroCopyBytesRead += amt;
    }
    
    private long totalBytesRead;

    private long totalLocalBytesRead;

    private long totalShortCircuitBytesRead;

    private long totalZeroCopyBytesRead;
  }
  
  private final FileInputStreamCache fileInputStreamCache;

  /**
   * This variable tracks the number of failures since the start of the
   * most recent user-facing operation. That is to say, it should be reset
   * whenever the user makes a call on this stream, and if at any point
   * during the retry logic, the failure count exceeds a threshold,
   * the errors will be thrown back to the operation.
   *
   * Specifically this counts the number of times the client has gone
   * back to the namenode to get a new list of block locations, and is
   * capped at maxBlockAcquireFailures
   */
  private int failures = 0;

  /* XXX Use of CocurrentHashMap is temp fix. Need to fix 
   * parallel accesses to DFSInputStream (through ptreads) properly */
  private final ConcurrentHashMap<DatanodeInfo, DatanodeInfo> deadNodes =
             new ConcurrentHashMap<DatanodeInfo, DatanodeInfo>();
  private int buffersize = 1;
  
  private final byte[] oneByteBuf = new byte[1]; // used for 'int read()'

  void addToDeadNodes(DatanodeInfo dnInfo) {
    deadNodes.put(dnInfo, dnInfo);
  }
  
  DFSInputStream(DFSClient dfsClient, String src, int buffersize, boolean verifyChecksum
                 ) throws IOException, UnresolvedLinkException {
    this.dfsClient = dfsClient;
    this.verifyChecksum = verifyChecksum;
    this.buffersize = buffersize;
    this.src = src;
    this.peerCache = dfsClient.peerCache;
    this.fileInputStreamCache = new FileInputStreamCache(
        dfsClient.getConf().shortCircuitStreamsCacheSize,
        dfsClient.getConf().shortCircuitStreamsCacheExpiryMs);
    this.cachingStrategy =
        dfsClient.getDefaultReadCachingStrategy().duplicate();
    openInfo();
  }

  /**
   * Grab the open-file info from namenode
   */
  synchronized void openInfo() throws IOException, UnresolvedLinkException {
    lastBlockBeingWrittenLength = fetchLocatedBlocksAndGetLastBlockLength();
    int retriesForLastBlockLength = 3;
    while (retriesForLastBlockLength > 0) {
      // Getting last block length as -1 is a special case. When cluster
      // restarts, DNs may not report immediately. At this time partial block
      // locations will not be available with NN for getting the length. Lets
      // retry for 3 times to get the length.
      if (lastBlockBeingWrittenLength == -1) {
        DFSClient.LOG.warn("Last block locations not available. "
            + "Datanodes might not have reported blocks completely."
            + " Will retry for " + retriesForLastBlockLength + " times");
        waitFor(4000);
        lastBlockBeingWrittenLength = fetchLocatedBlocksAndGetLastBlockLength();
      } else {
        break;
      }
      retriesForLastBlockLength--;
    }
    if (retriesForLastBlockLength == 0) {
      throw new IOException("Could not obtain the last block locations.");
    }
  }

  private void waitFor(int waitTime) throws IOException {
    try {
      Thread.sleep(waitTime);
    } catch (InterruptedException e) {
      throw new IOException(
          "Interrupted while getting the last block length.");
    }
  }

  private long fetchLocatedBlocksAndGetLastBlockLength() throws IOException {
    final LocatedBlocks newInfo = dfsClient.getLocatedBlocks(src, 0);
    if (DFSClient.LOG.isDebugEnabled()) {
      DFSClient.LOG.debug("newInfo = " + newInfo);
    }
    if (newInfo == null) {
      throw new IOException("Cannot open filename " + src);
    }

    if (locatedBlocks != null) {
      Iterator<LocatedBlock> oldIter = locatedBlocks.getLocatedBlocks().iterator();
      Iterator<LocatedBlock> newIter = newInfo.getLocatedBlocks().iterator();
      while (oldIter.hasNext() && newIter.hasNext()) {
        if (! oldIter.next().getBlock().equals(newIter.next().getBlock())) {
          throw new IOException("Blocklist for " + src + " has changed!");
        }
      }
    }
    locatedBlocks = newInfo;
    long lastBlockBeingWrittenLength = 0;
    if (!locatedBlocks.isLastBlockComplete()) {
      final LocatedBlock last = locatedBlocks.getLastLocatedBlock();
      if (last != null) {
        if (last.getLocations().length == 0) {
          if (last.getBlockSize() == 0) {
            // if the length is zero, then no data has been written to
            // datanode. So no need to wait for the locations.
            return 0;
          }
          return -1;
        }
        final long len = readBlockLength(last);
        last.getBlock().setNumBytes(len);
        lastBlockBeingWrittenLength = len; 
      }
    }

    currentNode = null;
    return lastBlockBeingWrittenLength;
  }

  /** Read the block length from one of the datanodes. */
  private long readBlockLength(LocatedBlock locatedblock) throws IOException {
    assert locatedblock != null : "LocatedBlock cannot be null";
    int replicaNotFoundCount = locatedblock.getLocations().length;
    
    for(DatanodeInfo datanode : locatedblock.getLocations()) {
      ClientDatanodeProtocol cdp = null;
      
      try {
        cdp = DFSUtil.createClientDatanodeProtocolProxy(datanode,
            dfsClient.getConfiguration(), dfsClient.getConf().socketTimeout,
            dfsClient.getConf().connectToDnViaHostname, locatedblock);
        
        final long n = cdp.getReplicaVisibleLength(locatedblock.getBlock());
        
        if (n >= 0) {
          return n;
        }
      }
      catch(IOException ioe) {
        if (ioe instanceof RemoteException &&
          (((RemoteException) ioe).unwrapRemoteException() instanceof
            ReplicaNotFoundException)) {
          // special case : replica might not be on the DN, treat as 0 length
          replicaNotFoundCount--;
        }
        
        if (DFSClient.LOG.isDebugEnabled()) {
          DFSClient.LOG.debug("Failed to getReplicaVisibleLength from datanode "
              + datanode + " for block " + locatedblock.getBlock(), ioe);
        }
      } finally {
        if (cdp != null) {
          RPC.stopProxy(cdp);
        }
      }
    }

    // Namenode told us about these locations, but none know about the replica
    // means that we hit the race between pipeline creation start and end.
    // we require all 3 because some other exception could have happened
    // on a DN that has it.  we want to report that error
    if (replicaNotFoundCount == 0) {
      return 0;
    }

    throw new IOException("Cannot obtain block length for " + locatedblock);
  }
  
  public synchronized long getFileLength() {
    return locatedBlocks == null? 0:
        locatedBlocks.getFileLength() + lastBlockBeingWrittenLength;
  }

  // Short circuit local reads are forbidden for files that are
  // under construction.  See HDFS-2757.
  synchronized boolean shortCircuitForbidden() {
    return locatedBlocks.isUnderConstruction();
  }

  /**
   * Returns the datanode from which the stream is currently reading.
   */
  public DatanodeInfo getCurrentDatanode() {
    return currentNode;
  }

  /**
   * Returns the block containing the target position. 
   */
  synchronized public ExtendedBlock getCurrentBlock() {
    if (currentLocatedBlock == null){
      return null;
    }
    return currentLocatedBlock.getBlock();
  }

  /**
   * Return collection of blocks that has already been located.
   */
  public synchronized List<LocatedBlock> getAllBlocks() throws IOException {
    return getBlockRange(0, getFileLength());
  }

  /**
   * Get block at the specified position.
   * Fetch it from the namenode if not cached.
   * 
   * @param offset
   * @param updatePosition whether to update current position
   * @return located block
   * @throws IOException
   */
  private synchronized LocatedBlock getBlockAt(long offset,
      boolean updatePosition) throws IOException {
    assert (locatedBlocks != null) : "locatedBlocks is null";

    final LocatedBlock blk;

    //check offset
    if (offset < 0 || offset >= getFileLength()) {
      throw new IOException("offset < 0 || offset >= getFileLength(), offset="
          + offset
          + ", updatePosition=" + updatePosition
          + ", locatedBlocks=" + locatedBlocks);
    }
    else if (offset >= locatedBlocks.getFileLength()) {
      // offset to the portion of the last block,
      // which is not known to the name-node yet;
      // getting the last block 
      blk = locatedBlocks.getLastLocatedBlock();
    }
    else {
      // search cached blocks first
      int targetBlockIdx = locatedBlocks.findBlock(offset);
      if (targetBlockIdx < 0) { // block is not cached
        targetBlockIdx = LocatedBlocks.getInsertIndex(targetBlockIdx);
        // fetch more blocks
        final LocatedBlocks newBlocks = dfsClient.getLocatedBlocks(src, offset);
        assert (newBlocks != null) : "Could not find target position " + offset;
        locatedBlocks.insertRange(targetBlockIdx, newBlocks.getLocatedBlocks());
      }
      blk = locatedBlocks.get(targetBlockIdx);
    }

    // update current position
    if (updatePosition) {
      pos = offset;
      blockEnd = blk.getStartOffset() + blk.getBlockSize() - 1;
      currentLocatedBlock = blk;
    }
    return blk;
  }

  /** Fetch a block from namenode and cache it */
  private synchronized void fetchBlockAt(long offset) throws IOException {
    int targetBlockIdx = locatedBlocks.findBlock(offset);
    if (targetBlockIdx < 0) { // block is not cached
      targetBlockIdx = LocatedBlocks.getInsertIndex(targetBlockIdx);
    }
    // fetch blocks
    final LocatedBlocks newBlocks = dfsClient.getLocatedBlocks(src, offset);
    if (newBlocks == null) {
      throw new IOException("Could not find target position " + offset);
    }
    locatedBlocks.insertRange(targetBlockIdx, newBlocks.getLocatedBlocks());
  }

  /**
   * Get blocks in the specified range.
   * Fetch them from the namenode if not cached. This function
   * will not get a read request beyond the EOF.
   * @param offset
   * @param length
   * @return consequent segment of located blocks
   * @throws IOException
   */
  private synchronized List<LocatedBlock> getBlockRange(long offset, 
                                                        long length) 
                                                      throws IOException {
    // getFileLength(): returns total file length
    // locatedBlocks.getFileLength(): returns length of completed blocks
    if (offset >= getFileLength()) {
      throw new IOException("Offset: " + offset +
        " exceeds file length: " + getFileLength());
    }

    final List<LocatedBlock> blocks;
    final long lengthOfCompleteBlk = locatedBlocks.getFileLength();
    final boolean readOffsetWithinCompleteBlk = offset < lengthOfCompleteBlk;
    final boolean readLengthPastCompleteBlk = offset + length > lengthOfCompleteBlk;

    if (readOffsetWithinCompleteBlk) {
      //get the blocks of finalized (completed) block range
      blocks = getFinalizedBlockRange(offset, 
        Math.min(length, lengthOfCompleteBlk - offset));
    } else {
      blocks = new ArrayList<LocatedBlock>(1);
    }

    // get the blocks from incomplete block range
    if (readLengthPastCompleteBlk) {
       blocks.add(locatedBlocks.getLastLocatedBlock());
    }

    return blocks;
  }

  /**
   * Get blocks in the specified range.
   * Includes only the complete blocks.
   * Fetch them from the namenode if not cached.
   */
  private synchronized List<LocatedBlock> getFinalizedBlockRange(
      long offset, long length) throws IOException {
    assert (locatedBlocks != null) : "locatedBlocks is null";
    List<LocatedBlock> blockRange = new ArrayList<LocatedBlock>();
    // search cached blocks first
    int blockIdx = locatedBlocks.findBlock(offset);
    if (blockIdx < 0) { // block is not cached
      blockIdx = LocatedBlocks.getInsertIndex(blockIdx);
    }
    long remaining = length;
    long curOff = offset;
    while(remaining > 0) {
      LocatedBlock blk = null;
      if(blockIdx < locatedBlocks.locatedBlockCount())
        blk = locatedBlocks.get(blockIdx);
      if (blk == null || curOff < blk.getStartOffset()) {
        LocatedBlocks newBlocks;
        newBlocks = dfsClient.getLocatedBlocks(src, curOff, remaining);
        locatedBlocks.insertRange(blockIdx, newBlocks.getLocatedBlocks());
        continue;
      }
      assert curOff >= blk.getStartOffset() : "Block not found";
      blockRange.add(blk);
      long bytesRead = blk.getStartOffset() + blk.getBlockSize() - curOff;
      remaining -= bytesRead;
      curOff += bytesRead;
      blockIdx++;
    }
    return blockRange;
  }

  /**
   * Open a DataInputStream to a DataNode so that it can be read from.
   * We get block ID and the IDs of the destinations at startup, from the namenode.
   */
  private synchronized DatanodeInfo blockSeekTo(long target) throws IOException {
    if (target >= getFileLength()) {
      throw new IOException("Attempted to read past end of file");
    }

    // Will be getting a new BlockReader.
    if (blockReader != null) {
      blockReader.close();
      blockReader = null;
    }

    //
    // Connect to best DataNode for desired Block, with potential offset
    //
    DatanodeInfo chosenNode = null;
    int refetchToken = 1; // only need to get a new access token once
    int refetchEncryptionKey = 1; // only need to get a new encryption key once
    
    boolean connectFailedOnce = false;

    while (true) {
      //
      // Compute desired block
      //
      LocatedBlock targetBlock = getBlockAt(target, true);
      assert (target==pos) : "Wrong postion " + pos + " expect " + target;
      long offsetIntoBlock = target - targetBlock.getStartOffset();

      DNAddrPair retval = chooseDataNode(targetBlock);
      chosenNode = retval.info;
      InetSocketAddress targetAddr = retval.addr;

      try {
        ExtendedBlock blk = targetBlock.getBlock();
        Token<BlockTokenIdentifier> accessToken = targetBlock.getBlockToken();
        blockReader = getBlockReader(targetAddr, chosenNode, src, blk,
            accessToken, offsetIntoBlock, blk.getNumBytes() - offsetIntoBlock,
            buffersize, verifyChecksum, dfsClient.clientName);
        if(connectFailedOnce) {
          DFSClient.LOG.info("Successfully connected to " + targetAddr +
                             " for " + blk);
        }
        return chosenNode;
      } catch (AccessControlException ex) {
        DFSClient.LOG.warn("Short circuit access failed " + ex);
        dfsClient.disableLegacyBlockReaderLocal();
        continue;
      } catch (IOException ex) {
        if (ex instanceof InvalidEncryptionKeyException && refetchEncryptionKey > 0) {
          DFSClient.LOG.info("Will fetch a new encryption key and retry, " 
              + "encryption key was invalid when connecting to " + targetAddr
              + " : " + ex);
          // The encryption key used is invalid.
          refetchEncryptionKey--;
          dfsClient.clearDataEncryptionKey();
        } else if ((ex instanceof InvalidBlockTokenException || ex instanceof InvalidToken)
            && refetchToken > 0) {
          DFSClient.LOG.info("Will fetch a new access token and retry, " 
              + "access token was invalid when connecting to " + targetAddr
              + " : " + ex);
          /*
           * Get a new access token and retry. Retry is needed in 2 cases. 1)
           * When both NN and DN re-started while DFSClient holding a cached
           * access token. 2) In the case that NN fails to update its
           * access key at pre-set interval (by a wide margin) and
           * subsequently restarts. In this case, DN re-registers itself with
           * NN and receives a new access key, but DN will delete the old
           * access key from its memory since it's considered expired based on
           * the estimated expiration date.
           */
          refetchToken--;
          fetchBlockAt(target);
        } else {
          connectFailedOnce = true;
          DFSClient.LOG.warn("Failed to connect to " + targetAddr + " for block"
            + ", add to deadNodes and continue. " + ex, ex);
          // Put chosen node into dead list, continue
          addToDeadNodes(chosenNode);
        }
      }
    }
  }

  /**
   * Close it down!
   */
  @Override
  public synchronized void close() throws IOException {
    if (closed) {
      return;
    }
    dfsClient.checkOpen();

    if (!extendedReadBuffers.isEmpty()) {
      final StringBuilder builder = new StringBuilder();
      extendedReadBuffers.visitAll(new IdentityHashStore.Visitor<ByteBuffer, Object>() {
        private String prefix = "";
        @Override
        public void accept(ByteBuffer k, Object v) {
          builder.append(prefix).append(k);
          prefix = ", ";
        }
      });
      DFSClient.LOG.warn("closing file " + src + ", but there are still " +
          "unreleased ByteBuffers allocated by read().  " +
          "Please release " + builder.toString() + ".");
    }
    if (blockReader != null) {
      blockReader.close();
      blockReader = null;
    }
    super.close();
    fileInputStreamCache.close();
    closed = true;
  }

  @Override
  public synchronized int read() throws IOException {
    int ret = read( oneByteBuf, 0, 1 );
    return ( ret <= 0 ) ? -1 : (oneByteBuf[0] & 0xff);
  }

  /**
   * Wraps different possible read implementations so that readBuffer can be
   * strategy-agnostic.
   */
  private interface ReaderStrategy {
    public int doRead(BlockReader blockReader, int off, int len,
        ReadStatistics readStatistics) throws ChecksumException, IOException;
  }

  private static void updateReadStatistics(ReadStatistics readStatistics, 
        int nRead, BlockReader blockReader) {
    if (nRead <= 0) return;
    if (blockReader.isShortCircuit()) {
      readStatistics.totalBytesRead += nRead;
      readStatistics.totalLocalBytesRead += nRead;
      readStatistics.totalShortCircuitBytesRead += nRead;
    } else if (blockReader.isLocal()) {
      readStatistics.totalBytesRead += nRead;
      readStatistics.totalLocalBytesRead += nRead;
    } else {
      readStatistics.totalBytesRead += nRead;
    }
  }
  
  /**
   * Used to read bytes into a byte[]
   */
  private static class ByteArrayStrategy implements ReaderStrategy {
    final byte[] buf;

    public ByteArrayStrategy(byte[] buf) {
      this.buf = buf;
    }

    @Override
    public int doRead(BlockReader blockReader, int off, int len,
            ReadStatistics readStatistics) throws ChecksumException, IOException {
        int nRead = blockReader.read(buf, off, len);
        updateReadStatistics(readStatistics, nRead, blockReader);
        return nRead;
    }
  }

  /**
   * Used to read bytes into a user-supplied ByteBuffer
   */
  private static class ByteBufferStrategy implements ReaderStrategy {
    final ByteBuffer buf;
    ByteBufferStrategy(ByteBuffer buf) {
      this.buf = buf;
    }

    @Override
    public int doRead(BlockReader blockReader, int off, int len,
        ReadStatistics readStatistics) throws ChecksumException, IOException {
      int oldpos = buf.position();
      int oldlimit = buf.limit();
      boolean success = false;
      try {
        int ret = blockReader.read(buf);
        success = true;
        updateReadStatistics(readStatistics, ret, blockReader);
        return ret;
      } finally {
        if (!success) {
          // Reset to original state so that retries work correctly.
          buf.position(oldpos);
          buf.limit(oldlimit);
        }
      } 
    }
  }

  /* This is a used by regular read() and handles ChecksumExceptions.
   * name readBuffer() is chosen to imply similarity to readBuffer() in
   * ChecksumFileSystem
   */ 
  private synchronized int readBuffer(ReaderStrategy reader, int off, int len,
      Map<ExtendedBlock, Set<DatanodeInfo>> corruptedBlockMap)
      throws IOException {
    IOException ioe;
    
    /* we retry current node only once. So this is set to true only here.
     * Intention is to handle one common case of an error that is not a
     * failure on datanode or client : when DataNode closes the connection
     * since client is idle. If there are other cases of "non-errors" then
     * then a datanode might be retried by setting this to true again.
     */
    boolean retryCurrentNode = true;

    while (true) {
      // retry as many times as seekToNewSource allows.
      try {
        return reader.doRead(blockReader, off, len, readStatistics);
      } catch ( ChecksumException ce ) {
        DFSClient.LOG.warn("Found Checksum error for "
            + getCurrentBlock() + " from " + currentNode
            + " at " + ce.getPos());        
        ioe = ce;
        retryCurrentNode = false;
        // we want to remember which block replicas we have tried
        addIntoCorruptedBlockMap(getCurrentBlock(), currentNode,
            corruptedBlockMap);
      } catch ( IOException e ) {
        if (!retryCurrentNode) {
          DFSClient.LOG.warn("Exception while reading from "
              + getCurrentBlock() + " of " + src + " from "
              + currentNode, e);
        }
        ioe = e;
      }
      boolean sourceFound = false;
      if (retryCurrentNode) {
        /* possibly retry the same node so that transient errors don't
         * result in application level failures (e.g. Datanode could have
         * closed the connection because the client is idle for too long).
         */ 
        sourceFound = seekToBlockSource(pos);
      } else {
        addToDeadNodes(currentNode);
        sourceFound = seekToNewSource(pos);
      }
      if (!sourceFound) {
        throw ioe;
      }
      retryCurrentNode = false;
    }
  }

  private int readWithStrategy(ReaderStrategy strategy, int off, int len) throws IOException {
    dfsClient.checkOpen();
    if (closed) {
      throw new IOException("Stream closed");
    }
    Map<ExtendedBlock,Set<DatanodeInfo>> corruptedBlockMap 
      = new HashMap<ExtendedBlock, Set<DatanodeInfo>>();
    failures = 0;
    if (pos < getFileLength()) {
      int retries = 2;
      while (retries > 0) {
        try {
          // currentNode can be left as null if previous read had a checksum
          // error on the same block. See HDFS-3067
          if (pos > blockEnd || currentNode == null) {
            currentNode = blockSeekTo(pos);
          }
          int realLen = (int) Math.min(len, (blockEnd - pos + 1L));
          int result = readBuffer(strategy, off, realLen, corruptedBlockMap);
          
          if (result >= 0) {
            pos += result;
          } else {
            // got a EOS from reader though we expect more data on it.
            throw new IOException("Unexpected EOS from the reader");
          }
          if (dfsClient.stats != null && result != -1) {
            dfsClient.stats.incrementBytesRead(result);
          }
          return result;
        } catch (ChecksumException ce) {
          throw ce;            
        } catch (IOException e) {
          if (retries == 1) {
            DFSClient.LOG.warn("DFS Read", e);
          }
          blockEnd = -1;
          if (currentNode != null) { addToDeadNodes(currentNode); }
          if (--retries == 0) {
            throw e;
          }
        } finally {
          // Check if need to report block replicas corruption either read
          // was successful or ChecksumException occured.
          reportCheckSumFailure(corruptedBlockMap, 
              currentLocatedBlock.getLocations().length);
        }
      }
    }
    return -1;
  }

  /**
   * Read the entire buffer.
   */
  @Override
  public synchronized int read(final byte buf[], int off, int len) throws IOException {
    ReaderStrategy byteArrayReader = new ByteArrayStrategy(buf);

    return readWithStrategy(byteArrayReader, off, len);
  }

  @Override
  public synchronized int read(final ByteBuffer buf) throws IOException {
    ReaderStrategy byteBufferReader = new ByteBufferStrategy(buf);

    return readWithStrategy(byteBufferReader, 0, buf.remaining());
  }


  /**
   * Add corrupted block replica into map.
   * @param corruptedBlockMap 
   */
  private void addIntoCorruptedBlockMap(ExtendedBlock blk, DatanodeInfo node, 
      Map<ExtendedBlock, Set<DatanodeInfo>> corruptedBlockMap) {
    Set<DatanodeInfo> dnSet = null;
    if((corruptedBlockMap.containsKey(blk))) {
      dnSet = corruptedBlockMap.get(blk);
    }else {
      dnSet = new HashSet<DatanodeInfo>();
    }
    if (!dnSet.contains(node)) {
      dnSet.add(node);
      corruptedBlockMap.put(blk, dnSet);
    }
  }
      
  private DNAddrPair chooseDataNode(LocatedBlock block)
    throws IOException {
    while (true) {
      DatanodeInfo[] nodes = block.getLocations();
      try {
        DatanodeInfo chosenNode = bestNode(nodes, deadNodes);
        final String dnAddr =
            chosenNode.getXferAddr(dfsClient.getConf().connectToDnViaHostname);
        if (DFSClient.LOG.isDebugEnabled()) {
          DFSClient.LOG.debug("Connecting to datanode " + dnAddr);
        }
        InetSocketAddress targetAddr = NetUtils.createSocketAddr(dnAddr);
        return new DNAddrPair(chosenNode, targetAddr);
      } catch (IOException ie) {
        String blockInfo = block.getBlock() + " file=" + src;
        if (failures >= dfsClient.getMaxBlockAcquireFailures()) {
          throw new BlockMissingException(src, "Could not obtain block: " + blockInfo,
                                          block.getStartOffset());
        }
        
        if (nodes == null || nodes.length == 0) {
          DFSClient.LOG.info("No node available for " + blockInfo);
        }
        DFSClient.LOG.info("Could not obtain " + block.getBlock()
            + " from any node: " + ie
            + ". Will get new block locations from namenode and retry...");
        try {
          // Introducing a random factor to the wait time before another retry.
          // The wait time is dependent on # of failures and a random factor.
          // At the first time of getting a BlockMissingException, the wait time
          // is a random number between 0..3000 ms. If the first retry
          // still fails, we will wait 3000 ms grace period before the 2nd retry.
          // Also at the second retry, the waiting window is expanded to 6000 ms
          // alleviating the request rate from the server. Similarly the 3rd retry
          // will wait 6000ms grace period before retry and the waiting window is
          // expanded to 9000ms. 
          final int timeWindow = dfsClient.getConf().timeWindow;
          double waitTime = timeWindow * failures +       // grace period for the last round of attempt
            timeWindow * (failures + 1) * DFSUtil.getRandom().nextDouble(); // expanding time window for each failure
          DFSClient.LOG.warn("DFS chooseDataNode: got # " + (failures + 1) + " IOException, will wait for " + waitTime + " msec.");
          Thread.sleep((long)waitTime);
        } catch (InterruptedException iex) {
        }
        deadNodes.clear(); //2nd option is to remove only nodes[blockId]
        openInfo();
        block = getBlockAt(block.getStartOffset(), false);
        failures++;
        continue;
      }
    }
  } 
      
  private void fetchBlockByteRange(LocatedBlock block, long start, long end,
      byte[] buf, int offset,
      Map<ExtendedBlock, Set<DatanodeInfo>> corruptedBlockMap)
      throws IOException {
    //
    // Connect to best DataNode for desired Block, with potential offset
    //
    int refetchToken = 1; // only need to get a new access token once
    int refetchEncryptionKey = 1; // only need to get a new encryption key once
    
    while (true) {
      // cached block locations may have been updated by chooseDataNode()
      // or fetchBlockAt(). Always get the latest list of locations at the 
      // start of the loop.
      block = getBlockAt(block.getStartOffset(), false);
      DNAddrPair retval = chooseDataNode(block);
      DatanodeInfo chosenNode = retval.info;
      InetSocketAddress targetAddr = retval.addr;
      BlockReader reader = null;
          
      try {
        Token<BlockTokenIdentifier> blockToken = block.getBlockToken();
            
        int len = (int) (end - start + 1);
        reader = getBlockReader(targetAddr, chosenNode, src, block.getBlock(),
            blockToken, start, len, buffersize, verifyChecksum,
            dfsClient.clientName);
        int nread = reader.readAll(buf, offset, len);
        if (nread != len) {
          throw new IOException("truncated return from reader.read(): " +
                                "excpected " + len + ", got " + nread);
        }
        return;
      } catch (ChecksumException e) {
        DFSClient.LOG.warn("fetchBlockByteRange(). Got a checksum exception for " +
                 src + " at " + block.getBlock() + ":" + 
                 e.getPos() + " from " + chosenNode);
        // we want to remember what we have tried
        addIntoCorruptedBlockMap(block.getBlock(), chosenNode, corruptedBlockMap);
      } catch (AccessControlException ex) {
        DFSClient.LOG.warn("Short circuit access failed " + ex);
        dfsClient.disableLegacyBlockReaderLocal();
        continue;
      } catch (IOException e) {
        if (e instanceof InvalidEncryptionKeyException && refetchEncryptionKey > 0) {
          DFSClient.LOG.info("Will fetch a new encryption key and retry, " 
              + "encryption key was invalid when connecting to " + targetAddr
              + " : " + e);
          // The encryption key used is invalid.
          refetchEncryptionKey--;
          dfsClient.clearDataEncryptionKey();
        } else if ((e instanceof InvalidBlockTokenException || e instanceof InvalidToken)
            && refetchToken > 0) {
          DFSClient.LOG.info("Will get a new access token and retry, "
              + "access token was invalid when connecting to " + targetAddr
              + " : " + e);
          refetchToken--;
          fetchBlockAt(block.getStartOffset());
          continue;
        } else {
          DFSClient.LOG.warn("Failed to connect to " + targetAddr + 
              " for file " + src + " for block " + block.getBlock() + ":" + e);
          if (DFSClient.LOG.isDebugEnabled()) {
            DFSClient.LOG.debug("Connection failure ", e);
          }
        }
      } finally {
        if (reader != null) {
          reader.close();
        }
      }
      // Put chosen node into dead list, continue
      addToDeadNodes(chosenNode);
    }
  }

  private Peer newTcpPeer(InetSocketAddress addr) throws IOException {
    Peer peer = null;
    boolean success = false;
    Socket sock = null;
    try {
      sock = dfsClient.socketFactory.createSocket();
      NetUtils.connect(sock, addr,
        dfsClient.getRandomLocalInterfaceAddr(),
        dfsClient.getConf().socketTimeout);
      peer = TcpPeerServer.peerFromSocketAndKey(sock, 
          dfsClient.getDataEncryptionKey());
      success = true;
      return peer;
    } finally {
      if (!success) {
        IOUtils.closeQuietly(peer);
        IOUtils.closeQuietly(sock);
      }
    }
  }

  /**
   * Retrieve a BlockReader suitable for reading.
   * This method will reuse the cached connection to the DN if appropriate.
   * Otherwise, it will create a new connection.
   * Throwing an IOException from this method is basically equivalent to 
   * declaring the DataNode bad, so we try to connect a lot of different ways
   * before doing that.
   *
   * @param dnAddr  Address of the datanode
   * @param chosenNode Chosen datanode information
   * @param file  File location
   * @param block  The Block object
   * @param blockToken  The access token for security
   * @param startOffset  The read offset, relative to block head
   * @param len  The number of bytes to read
   * @param bufferSize  The IO buffer size (not the client buffer size)
   * @param verifyChecksum  Whether to verify checksum
   * @param clientName  Client name
   * @return New BlockReader instance
   */
  protected BlockReader getBlockReader(InetSocketAddress dnAddr,
                                       DatanodeInfo chosenNode,
                                       String file,
                                       ExtendedBlock block,
                                       Token<BlockTokenIdentifier> blockToken,
                                       long startOffset,
                                       long len,
                                       int bufferSize,
                                       boolean verifyChecksum,
                                       String clientName)
      throws IOException {
    // Firstly, we check to see if we have cached any file descriptors for
    // local blocks.  If so, we can just re-use those file descriptors.
    FileInputStream fis[] = fileInputStreamCache.get(chosenNode, block);
    if (fis != null) {
      if (DFSClient.LOG.isDebugEnabled()) {
        DFSClient.LOG.debug("got FileInputStreams for " + block + " from " +
            "the FileInputStreamCache.");
      }
      return new BlockReaderLocal(dfsClient.getConf(), file,
        block, startOffset, len, fis[0], fis[1], chosenNode, verifyChecksum,
        fileInputStreamCache);
    }
    
    // If the legacy local block reader is enabled and we are reading a local
    // block, try to create a BlockReaderLocalLegacy.  The legacy local block
    // reader implements local reads in the style first introduced by HDFS-2246.
    if ((dfsClient.useLegacyBlockReaderLocal()) &&
        DFSClient.isLocalAddress(dnAddr) &&
        (!shortCircuitForbidden())) {
      try {
        return BlockReaderFactory.getLegacyBlockReaderLocal(dfsClient,
            clientName, block, blockToken, chosenNode, startOffset);
      } catch (IOException e) {
        DFSClient.LOG.warn("error creating legacy BlockReaderLocal.  " +
            "Disabling legacy local reads.", e);
        dfsClient.disableLegacyBlockReaderLocal();
      }
    }

    // Look for cached domain peers.
    int cacheTries = 0;
    DomainSocketFactory dsFactory = dfsClient.getDomainSocketFactory();
    BlockReader reader = null;
    final int nCachedConnRetry = dfsClient.getConf().nCachedConnRetry;
    for (; cacheTries < nCachedConnRetry; ++cacheTries) {
      Peer peer = peerCache.get(chosenNode, true);
      if (peer == null) break;
      try {
        boolean allowShortCircuitLocalReads = dfsClient.getConf().
            shortCircuitLocalReads && (!shortCircuitForbidden());
        reader = BlockReaderFactory.newBlockReader(
            dfsClient.getConf(), file, block, blockToken, startOffset,
            len, verifyChecksum, clientName, peer, chosenNode, 
            dsFactory, peerCache, fileInputStreamCache,
            allowShortCircuitLocalReads, cachingStrategy);
        return reader;
      } catch (IOException ex) {
        DFSClient.LOG.debug("Error making BlockReader with DomainSocket. " +
            "Closing stale " + peer, ex);
      } finally {
        if (reader == null) {
          IOUtils.closeQuietly(peer);
        }
      }
    }

    // Try to create a DomainPeer.
    DomainSocket domSock = dsFactory.create(dnAddr, this);
    if (domSock != null) {
      Peer peer = new DomainPeer(domSock);
      try {
        boolean allowShortCircuitLocalReads = dfsClient.getConf().
            shortCircuitLocalReads && (!shortCircuitForbidden());
        reader = BlockReaderFactory.newBlockReader(
            dfsClient.getConf(), file, block, blockToken, startOffset,
            len, verifyChecksum, clientName, peer, chosenNode,
            dsFactory, peerCache, fileInputStreamCache,
            allowShortCircuitLocalReads, cachingStrategy);
        return reader;
      } catch (IOException e) {
        DFSClient.LOG.warn("failed to connect to " + domSock, e);
      } finally {
        if (reader == null) {
         // If the Peer that we got the error from was a DomainPeer,
         // mark the socket path as bad, so that newDataSocket will not try 
         // to re-open this socket for a while.
         dsFactory.disableDomainSocketPath(domSock.getPath());
         IOUtils.closeQuietly(peer);
        }
      }
    }

    // Look for cached peers.
    for (; cacheTries < nCachedConnRetry; ++cacheTries) {
      Peer peer = peerCache.get(chosenNode, false);
      if (peer == null) break;
      try {
        reader = BlockReaderFactory.newBlockReader(
            dfsClient.getConf(), file, block, blockToken, startOffset,
            len, verifyChecksum, clientName, peer, chosenNode, 
            dsFactory, peerCache, fileInputStreamCache, false,
            cachingStrategy);
        return reader;
      } catch (IOException ex) {
        DFSClient.LOG.debug("Error making BlockReader. Closing stale " +
          peer, ex);
      } finally {
        if (reader == null) {
          IOUtils.closeQuietly(peer);
        }
      }
    }
    if (tcpReadsDisabledForTesting) {
      throw new IOException("TCP reads are disabled.");
    }
    // Try to create a new remote peer.
    Peer peer = newTcpPeer(dnAddr);
    return BlockReaderFactory.newBlockReader(
        dfsClient.getConf(), file, block, blockToken, startOffset,
        len, verifyChecksum, clientName, peer, chosenNode, 
        dsFactory, peerCache, fileInputStreamCache, false,
        cachingStrategy);
  }


  /**
   * Read bytes starting from the specified position.
   * 
   * @param position start read from this position
   * @param buffer read buffer
   * @param offset offset into buffer
   * @param length number of bytes to read
   * 
   * @return actual number of bytes read
   */
  @Override
  public int read(long position, byte[] buffer, int offset, int length)
    throws IOException {
    // sanity checks
    dfsClient.checkOpen();
    if (closed) {
      throw new IOException("Stream closed");
    }
    failures = 0;
    long filelen = getFileLength();
    if ((position < 0) || (position >= filelen)) {
      return -1;
    }
    int realLen = length;
    if ((position + length) > filelen) {
      realLen = (int)(filelen - position);
    }
    
    // determine the block and byte range within the block
    // corresponding to position and realLen
    List<LocatedBlock> blockRange = getBlockRange(position, realLen);
    int remaining = realLen;
    Map<ExtendedBlock,Set<DatanodeInfo>> corruptedBlockMap 
      = new HashMap<ExtendedBlock, Set<DatanodeInfo>>();
    for (LocatedBlock blk : blockRange) {
      long targetStart = position - blk.getStartOffset();
      long bytesToRead = Math.min(remaining, blk.getBlockSize() - targetStart);
      try {
        fetchBlockByteRange(blk, targetStart, 
            targetStart + bytesToRead - 1, buffer, offset, corruptedBlockMap);
      } finally {
        // Check and report if any block replicas are corrupted.
        // BlockMissingException may be caught if all block replicas are
        // corrupted.
        reportCheckSumFailure(corruptedBlockMap, blk.getLocations().length);
      }

      remaining -= bytesToRead;
      position += bytesToRead;
      offset += bytesToRead;
    }
    assert remaining == 0 : "Wrong number of bytes read.";
    if (dfsClient.stats != null) {
      dfsClient.stats.incrementBytesRead(realLen);
    }
    return realLen;
  }
  
  /**
   * DFSInputStream reports checksum failure.
   * Case I : client has tried multiple data nodes and at least one of the
   * attempts has succeeded. We report the other failures as corrupted block to
   * namenode. 
   * Case II: client has tried out all data nodes, but all failed. We
   * only report if the total number of replica is 1. We do not
   * report otherwise since this maybe due to the client is a handicapped client
   * (who can not read).
   * @param corruptedBlockMap map of corrupted blocks
   * @param dataNodeCount number of data nodes who contains the block replicas
   */
  private void reportCheckSumFailure(
      Map<ExtendedBlock, Set<DatanodeInfo>> corruptedBlockMap, 
      int dataNodeCount) {
    if (corruptedBlockMap.isEmpty()) {
      return;
    }
    Iterator<Entry<ExtendedBlock, Set<DatanodeInfo>>> it = corruptedBlockMap
        .entrySet().iterator();
    Entry<ExtendedBlock, Set<DatanodeInfo>> entry = it.next();
    ExtendedBlock blk = entry.getKey();
    Set<DatanodeInfo> dnSet = entry.getValue();
    if (((dnSet.size() < dataNodeCount) && (dnSet.size() > 0))
        || ((dataNodeCount == 1) && (dnSet.size() == dataNodeCount))) {
      DatanodeInfo[] locs = new DatanodeInfo[dnSet.size()];
      int i = 0;
      for (DatanodeInfo dn:dnSet) {
        locs[i++] = dn;
      }
      LocatedBlock [] lblocks = { new LocatedBlock(blk, locs) };
      dfsClient.reportChecksumFailure(src, lblocks);
    }
    corruptedBlockMap.clear();
  }

  @Override
  public long skip(long n) throws IOException {
    if ( n > 0 ) {
      long curPos = getPos();
      long fileLen = getFileLength();
      if( n+curPos > fileLen ) {
        n = fileLen - curPos;
      }
      seek(curPos+n);
      return n;
    }
    return n < 0 ? -1 : 0;
  }

  /**
   * Seek to a new arbitrary location
   */
  @Override
  public synchronized void seek(long targetPos) throws IOException {
    if (targetPos > getFileLength()) {
      throw new IOException("Cannot seek after EOF");
    }
    if (targetPos < 0) {
      throw new IOException("Cannot seek to negative offset");
    }
    if (closed) {
      throw new IOException("Stream is closed!");
    }
    boolean done = false;
    if (pos <= targetPos && targetPos <= blockEnd) {
      //
      // If this seek is to a positive position in the current
      // block, and this piece of data might already be lying in
      // the TCP buffer, then just eat up the intervening data.
      //
      int diff = (int)(targetPos - pos);
      if (diff <= blockReader.available()) {
        try {
          pos += blockReader.skip(diff);
          if (pos == targetPos) {
            done = true;
          }
        } catch (IOException e) {//make following read to retry
          if(DFSClient.LOG.isDebugEnabled()) {
            DFSClient.LOG.debug("Exception while seek to " + targetPos
                + " from " + getCurrentBlock() + " of " + src + " from "
                + currentNode, e);
          }
        }
      }
    }
    if (!done) {
      pos = targetPos;
      blockEnd = -1;
    }
  }

  /**
   * Same as {@link #seekToNewSource(long)} except that it does not exclude
   * the current datanode and might connect to the same node.
   */
  private synchronized boolean seekToBlockSource(long targetPos)
                                                 throws IOException {
    currentNode = blockSeekTo(targetPos);
    return true;
  }
  
  /**
   * Seek to given position on a node other than the current node.  If
   * a node other than the current node is found, then returns true. 
   * If another node could not be found, then returns false.
   */
  @Override
  public synchronized boolean seekToNewSource(long targetPos) throws IOException {
    boolean markedDead = deadNodes.containsKey(currentNode);
    addToDeadNodes(currentNode);
    DatanodeInfo oldNode = currentNode;
    DatanodeInfo newNode = blockSeekTo(targetPos);
    if (!markedDead) {
      /* remove it from deadNodes. blockSeekTo could have cleared 
       * deadNodes and added currentNode again. Thats ok. */
      deadNodes.remove(oldNode);
    }
    if (!oldNode.getDatanodeUuid().equals(newNode.getDatanodeUuid())) {
      currentNode = newNode;
      return true;
    } else {
      return false;
    }
  }
      
  /**
   */
  @Override
  public synchronized long getPos() throws IOException {
    return pos;
  }

  /** Return the size of the remaining available bytes
   * if the size is less than or equal to {@link Integer#MAX_VALUE},
   * otherwise, return {@link Integer#MAX_VALUE}.
   */
  @Override
  public synchronized int available() throws IOException {
    if (closed) {
      throw new IOException("Stream closed");
    }

    final long remaining = getFileLength() - pos;
    return remaining <= Integer.MAX_VALUE? (int)remaining: Integer.MAX_VALUE;
  }

  /**
   * We definitely don't support marks
   */
  @Override
  public boolean markSupported() {
    return false;
  }
  @Override
  public void mark(int readLimit) {
  }
  @Override
  public void reset() throws IOException {
    throw new IOException("Mark/reset not supported");
  }

  /**
   * Pick the best node from which to stream the data.
   * Entries in <i>nodes</i> are already in the priority order
   */
  static DatanodeInfo bestNode(DatanodeInfo nodes[], 
                               AbstractMap<DatanodeInfo, DatanodeInfo> deadNodes)
                               throws IOException {
    if (nodes != null) { 
      for (int i = 0; i < nodes.length; i++) {
        if (!deadNodes.containsKey(nodes[i])) {
          return nodes[i];
        }
      }
    }
    throw new IOException("No live nodes contain current block");
  }

  /** Utility class to encapsulate data node info and its address. */
  static class DNAddrPair {
    DatanodeInfo info;
    InetSocketAddress addr;
    DNAddrPair(DatanodeInfo info, InetSocketAddress addr) {
      this.info = info;
      this.addr = addr;
    }
  }

  /**
   * Get statistics about the reads which this DFSInputStream has done.
   */
  public synchronized ReadStatistics getReadStatistics() {
    return new ReadStatistics(readStatistics);
  }

  private synchronized void closeCurrentBlockReader() {
    if (blockReader == null) return;
    // Close the current block reader so that the new caching settings can 
    // take effect immediately.
    try {
      blockReader.close();
    } catch (IOException e) {
      DFSClient.LOG.error("error closing blockReader", e);
    }
    blockReader = null;
  }

  @Override
  public synchronized void setReadahead(Long readahead)
      throws IOException {
    this.cachingStrategy.setReadahead(readahead);
    closeCurrentBlockReader();
  }

  @Override
  public synchronized void setDropBehind(Boolean dropBehind)
      throws IOException {
    this.cachingStrategy.setDropBehind(dropBehind);
    closeCurrentBlockReader();
  }

  @Override
  public synchronized ByteBuffer read(ByteBufferPool bufferPool,
      int maxLength, EnumSet<ReadOption> opts) 
          throws IOException, UnsupportedOperationException {
    assert(maxLength > 0);
    if (((blockReader == null) || (blockEnd == -1)) &&
          (pos < getFileLength())) {
      /*
       * If we don't have a blockReader, or the one we have has no more bytes
       * left to read, we call seekToBlockSource to get a new blockReader and
       * recalculate blockEnd.  Note that we assume we're not at EOF here
       * (we check this above).
       */
      if ((!seekToBlockSource(pos)) || (blockReader == null)) {
        throw new IOException("failed to allocate new BlockReader " +
            "at position " + pos);
      }
    }
    boolean canSkipChecksums = opts.contains(ReadOption.SKIP_CHECKSUMS);
    if (canSkipChecksums) {
      ByteBuffer buffer = tryReadZeroCopy(maxLength);
      if (buffer != null) {
        return buffer;
      }
    }
    ByteBuffer buffer = ByteBufferUtil.
        fallbackRead(this, bufferPool, maxLength);
    if (buffer != null) {
      extendedReadBuffers.put(buffer, bufferPool);
    }
    return buffer;
  }

  private synchronized ByteBuffer tryReadZeroCopy(int maxLength)
      throws IOException {
    // Java ByteBuffers can't be longer than 2 GB, because they use
    // 4-byte signed integers to represent capacity, etc.
    // So we can't mmap the parts of the block higher than the 2 GB offset.
    // FIXME: we could work around this with multiple memory maps.
    // See HDFS-5101.
    long blockEnd32 = Math.min(Integer.MAX_VALUE, blockEnd);
    long curPos = pos;
    long blockLeft = blockEnd32 - curPos + 1;
    if (blockLeft <= 0) {
      if (DFSClient.LOG.isDebugEnabled()) {
        DFSClient.LOG.debug("unable to perform a zero-copy read from offset " +
          curPos + " of " + src + "; blockLeft = " + blockLeft +
          "; blockEnd32 = " + blockEnd32 + ", blockEnd = " + blockEnd +
          "; maxLength = " + maxLength);
      }
      return null;
    }
    int length = Math.min((int)blockLeft, maxLength);
    long blockStartInFile = currentLocatedBlock.getStartOffset();
    long blockPos = curPos - blockStartInFile;
    long limit = blockPos + length;
    ClientMmap clientMmap =
        blockReader.getClientMmap(currentLocatedBlock,
            dfsClient.getMmapManager());
    if (clientMmap == null) {
      if (DFSClient.LOG.isDebugEnabled()) {
        DFSClient.LOG.debug("unable to perform a zero-copy read from offset " +
          curPos + " of " + src + "; BlockReader#getClientMmap returned " +
          "null.");
      }
      return null;
    }
    seek(pos + length);
    ByteBuffer buffer = clientMmap.getMappedByteBuffer().asReadOnlyBuffer();
    buffer.position((int)blockPos);
    buffer.limit((int)limit);
    clientMmap.ref();
    extendedReadBuffers.put(buffer, clientMmap);
    readStatistics.addZeroCopyBytes(length);
    if (DFSClient.LOG.isDebugEnabled()) {
      DFSClient.LOG.debug("readZeroCopy read " + maxLength + " bytes from " +
          "offset " + curPos + " via the zero-copy read path.  " +
          "blockEnd = " + blockEnd);
    }
    return buffer;
  }

  @Override
  public synchronized void releaseBuffer(ByteBuffer buffer) {
    Object val = extendedReadBuffers.remove(buffer);
    if (val == null) {
      throw new IllegalArgumentException("tried to release a buffer " +
          "that was not created by this stream, " + buffer);
    }
    if (val instanceof ClientMmap) {
      ((ClientMmap)val).unref();
    } else if (val instanceof ByteBufferPool) {
      ((ByteBufferPool)val).putBuffer(buffer);
    }
  }
}
