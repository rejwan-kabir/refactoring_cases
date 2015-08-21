
public byte[] generateSecureRandom(int bytes) {
	final byte[] data = new byte[bytes];
	random.nextBytes(data);
	return data;
}  

-------------------------------------------------
// Refactor: Change Signature: instead of returning a byte array, take
// a byte array and set the new value in it.

public void generateSecureRandom(byte[] bytes) {
    random.nextBytes(bytes);
} 