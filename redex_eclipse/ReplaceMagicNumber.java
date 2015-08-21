/**
* You have a literal number with a particular meaning. Create a constant,
* name it after the meaning, and replace the number with it.
*
* Most results contain literals that can be replaced by constants with 
* meaningful name, but boolean literal and string literal are not suitable
* for this kind of refactoring. The query doesn't rule out thses kinds of 
* literal, which results in many false positives.
*/
---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.AptPlugin.getAptProject(org.eclipse.jdt.core.IJavaProject;)org.eclipse.jdt.apt.core.internal.AptProject;1
public static AptProject getAptProject(IJavaProject javaProject) {
    return getAptProject(javaProject, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}
// false positive. boolean literal is not magic number.
---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.JavaStepFilterPreferencePage$10.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event e) {
    fTableViewer.setAllChecked(false);
}
---------------Client-------------------
method: org.eclipse.ui.internal.forms.widgets.FormHeading$5.mouseExit(org.eclipse.swt.events.MouseEvent;)V2
public void mouseExit(MouseEvent e) {
    titleRegion.setHoverState(TitleRegion.STATE_NORMAL);
}
// false positive.

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.StubUtility.removeTypeArguments(java.lang.String;)java.lang.String;1
private static String removeTypeArguments(String baseName) {
    int idx = baseName.indexOf('<');
    if (idx != -1) {
        return baseName.substring(0, idx);
    }
    return baseName;
}
---------------Client-------------------
method: org.eclipse.ui.internal.browser.WebBrowserUtil.decodeId(java.lang.String;)java.lang.String;1
public static String decodeId(String encodedId) {
    int sep = encodedId.lastIndexOf(STYLE_SEP);
    if (sep != -1) {
        return encodedId.substring(0, sep);
    }
    return encodedId;
}
// it's opportunity. it's reasonable to create a constant for '<' and give it a name as the Client does.
---------------Library-------------------
method: org.eclipse.team.internal.ui.ProjectSetImporter.isValidProjectSetString(java.lang.String;)Z1
public static boolean isValidProjectSetString(String psfContent) {
    if (psfContent == null) {
        return false;
    }
    try {
        return stringToXMLMemento(psfContent).getString("version") != null;
    } catch (InvocationTargetException e) {
        return false;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.model.JavaModelLabelProvider.isInJavaProject(org.eclipse.core.resources.IFolder;)Z1
private static boolean isInJavaProject(IFolder folder) {
    try {
        return folder.getProject().getNature(JavaCore.NATURE_ID) != null;
    } catch (CoreException e) {
        return false;
    }
}
// it's opportunity. String literal can be replaced by constant.

---------------Library-------------------
method: org.eclipse.jdt.core.dom.SynchronizedStatement.memSize()I1
int memSize() {
    return super.memSize() + 2 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}
// it's opportunity. the number in the Library can be replaced by a constant with more meaningful name.
---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.processing.JobManager.activateProcessing()V1
public void activateProcessing() {
    this.activated = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}
// false positive.
---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyArgumentListopt()V1
protected void consumeEmptyArgumentListopt() {
    pushOnExpressionStackLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}
// it's opportunity. the number in the Library can be replaced by a constant with more meaningful name.

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyClassificationHandler.applyCSSPropertyClear(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyClear(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("clear");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}
// false positive.
---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.ModuleSelectionPage$1.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event event) {
    updateEnablements(false);
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.ui.FileSelectionDialog$4.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
@Override
public void doubleClick(DoubleClickEvent event) {
    buttonPressed(IDialogConstants.OK_ID);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexWriter$ReaderPool.release(org.apache.lucene.index.SegmentReader;)Z2
public synchronized boolean release(SegmentReader sr) throws IOException {
    return release(sr, false);
}
---------------Client-------------------
method: org.eclipse.team.core.variants.SessionResourceVariantByteStore.deleteBytes(org.eclipse.core.resources.IResource;)Z2
public boolean deleteBytes(IResource resource) throws TeamException {
    return flushBytes(resource, IResource.DEPTH_ZERO);
}

---------------Library-------------------
method: org.apache.jasper.compiler.TagLibraryInfoImpl.toString()java.lang.String;1
public String toString() {
    StringWriter sw = new  StringWriter();
    PrintWriter out = new  PrintWriter(sw);
    print("tlibversion", tlibversion, out);
    print("jspversion", jspversion, out);
    print("shortname", shortname, out);
    print("urn", urn, out);
    print("info", info, out);
    print("uri", uri, out);
    print("tagLibraryValidator", tagLibraryValidator.toString(), out);
    for (int i = 0; i < tags.length; i++) out.println(tags[i].toString());
    for (int i = 0; i < tagFiles.length; i++) out.println(tagFiles[i].toString());
    for (int i = 0; i < functions.length; i++) out.println(functions[i].toString());
    return sw.toString();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}
// false positive

---------------Library-------------------
method: org.eclipse.core.databinding.ValidationStatusProvider.dispose()V1
public void dispose() {
    disposed = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}
// false positive
---------------Library-------------------
method: org.eclipse.osgi.compatibility.state.PlatformAdminImpl.createResolver()org.eclipse.osgi.service.resolver.Resolver;1
@Override
public Resolver createResolver() {
    return new  ResolverImpl(false);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}
// false positive

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousViewer.setSelectionToWidget(java.util.List;Z)V3
@Override
protected final void setSelectionToWidget(List l, boolean reveal) {
    throw new  IllegalArgumentException("This method should not be called");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}
// false positive

---------------Library-------------------
method: org.apache.lucene.analysis.tokenattributes.PositionIncrementAttributeImpl.clear()V1
@Override
public void clear() {
    this.positionIncrement = 1;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}
// false positive

---------------Library-------------------
method: org.eclipse.core.internal.boot.PlatformURLConnection.connect()V1
public void connect() throws IOException {
    connect(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}
// false positive

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.getNotFoundMessage()java.lang.String;1
public String getNotFoundMessage() {
    String scope = getScope();
    if (scope.equals(ServletResources.getString("All", request))) {
        return ServletResources.getString("Nothing_found", request);
    } else {
        return NLS.bind(ServletResources.getString("Nothing_found_in_scope", request), scope);
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}
// false positive

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.imports.BaseImportWizardSecondPage.modelsChanged(org.eclipse.pde.core.IModelProviderEvent;)V2
public void modelsChanged(IModelProviderEvent event) {
    fRefreshNeeded = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ChangeSignatureWizard$ChangeSignatureInputPage$7.parameterChanged(org.eclipse.jdt.internal.corext.refactoring.ParameterInfo;)V2
public void parameterChanged(ParameterInfo parameter) {
    update(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.compare.internal.patch.PatchFileDiffNode.getLeftElement(org.eclipse.compare.internal.core.patch.FileDiffResult;)org.eclipse.compare.ITypedElement;1
private static ITypedElement getLeftElement(FileDiffResult result) {
    return new  PatchFileTypedElement(result, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.model.WorkbenchLabelProvider.getBackground(java.lang.Object;)org.eclipse.swt.graphics.Color;2
@Override
public Color getBackground(Object element) {
    return getColor(element, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.CompilationUnitResolver.initializeParser()V1
public void initializeParser() {
    this.parser = new  CommentRecorderParser(this.problemReporter, false);
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringWizardDialog2.createMessageBox()V1
private void createMessageBox() {
    fMessageBox = new  MessageBox(fStatusContainer, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.osgi.internal.module.ResolverBundle.setUninstalled()V1
void setUninstalled() {
    uninstalled = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.compare.internal.core.patch.LineReader.ignoreSingleCR()V1
public void ignoreSingleCR() {
    this.fIgnoreSingleCR = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.VMListener.defaultVMInstallChanged(org.eclipse.jdt.launching.IVMInstall;org.eclipse.jdt.launching.IVMInstall;)V3
public void defaultVMInstallChanged(IVMInstall previous, IVMInstall current) {
    fChanged = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.OpenBrowserUtil$1.run()V1
public void run() {
    internalOpen(url, false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.browsing.LogicalPackage.isDefaultPackage()Z1
public boolean isDefaultPackage() {
    return fName.length() == 0;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$StatusWrapper.isOK()Z1
public boolean isOK() {
    return diagnostic.getSeverity() == OK;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMImport.toString()java.lang.String;1
public String toString() {
    return "IMPORT: " + getName();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.ui.internal.console.PatternMatchListenerExtension.getEnablementExpression()org.eclipse.core.expressions.Expression;1
public Expression getEnablementExpression() throws CoreException {
    if (fEnablementExpression == null) {
        IConfigurationElement[] elements = fConfig.getChildren(ExpressionTagNames.ENABLEMENT);
        if (elements.length == 0) {
            String message = MessageFormat.format("{0} " + getLocalId() + " {1} " + getPluginId() + " {2}", new Object[] { ConsoleMessages.PatternMatchListenerExtension_3, ConsoleMessages.PatternMatchListenerExtension_4, ConsoleMessages.PatternMatchListenerExtension_5 });
            ConsolePlugin.log(new  Status(IStatus.WARNING, ConsolePlugin.getUniqueIdentifier(), IStatus.OK, message, null));
        }
        IConfigurationElement enablement = elements.length > 0 ? elements[0] : null;
        if (enablement != null) {
            fEnablementExpression = ExpressionConverter.getDefault().perform(enablement);
        }
    }
    return fEnablementExpression;
}
---------------Client-------------------
method: org.eclipse.ant.internal.launching.launchConfigurations.AntLaunchDelegate.configureAntRunner(org.eclipse.debug.core.ILaunchConfiguration;org.eclipse.core.runtime.IPath;java.lang.String;java.lang.StringBuffer;Ajava.lang.String;java.util.Map;Ajava.lang.String;Ajava.lang.String;Ajava.net.URL;java.lang.String;Z)org.eclipse.ant.core.AntRunner;12
private AntRunner configureAntRunner(ILaunchConfiguration configuration, IPath location, String baseDir, StringBuffer idProperty, String[] arguments, Map<String, String> userProperties, String[] propertyFiles, String[] targets, URL[] customClasspath, String antHome, boolean setInputHandler) throws CoreException {
    int argLength = 1;
    if (arguments != null) {
        argLength += arguments.length;
    }
    if (baseDir != null && baseDir.length() > 0) {
        argLength++;
    }
    String[] runnerArgs = new String[argLength];
    if (arguments != null) {
        System.arraycopy(arguments, 0, runnerArgs, 0, arguments.length);
    }
    if (baseDir != null && baseDir.length() > 0) {
        runnerArgs[runnerArgs.length - 2] = BASE_DIR_PREFIX + baseDir;
    }
    runnerArgs[runnerArgs.length - 1] = idProperty.toString();
    AntRunner runner = new  AntRunner();
    runner.setBuildFileLocation(location.toOSString());
    boolean captureOutput = ExternalToolsCoreUtil.getCaptureOutput(configuration);
    if (captureOutput) {
        if (fMode.equals(ILaunchManager.DEBUG_MODE)) {
            runner.addBuildLogger(ANT_DEBUG_LOGGER_CLASS);
        } else {
            runner.addBuildLogger(ANT_LOGGER_CLASS);
        }
    } else {
        runner.addBuildLogger(NULL_LOGGER_CLASS);
    }
    if (setInputHandler) {
        runner.setInputHandler(INPUT_HANDLER_CLASS);
    } else {
        runner.setInputHandler("");
    }
    runner.setArguments(runnerArgs);
    if (userProperties != null) {
        runner.addUserProperties(userProperties);
    }
    if (propertyFiles != null) {
        runner.setPropertyFiles(propertyFiles);
    }
    if (targets != null) {
        runner.setExecutionTargets(targets);
    }
    if (customClasspath != null) {
        runner.setCustomClasspath(customClasspath);
    }
    if (antHome != null) {
        runner.setAntHome(antHome);
    }
    return runner;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.ui.Activator.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getImageDescriptor(String relativePath) {
    return imageDescriptorFromPlugin("org.eclipse.equinox.security.ui", "icons" + relativePath);
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.ViewsPlugin.getViewImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getViewImageDescriptor(String relativePath) {
    return imageDescriptorFromPlugin(PLUGIN_ID, ICONS_PATH + relativePath);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.history.LocalHistoryPage.refreshHistory(Z)V2
private void refreshHistory(boolean refetch) {
    if (Policy.DEBUG_HISTORY) {
        String time = new  SimpleDateFormat("m:ss.SSS").format(new  Date(System.currentTimeMillis()));
        System.out.println(time + ": LocalHistoryPage#refreshHistory, refetch = " + refetch);
    }
    if (refreshFileHistoryJob.getState() != Job.NONE) {
        refreshFileHistoryJob.cancel();
    }
    IHistoryPageSite parentSite = getHistoryPageSite();
    Utils.schedule(refreshFileHistoryJob, getWorkbenchSite(parentSite));
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;java.lang.Throwable;)V3
public void debug(Object message, Throwable t) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message), t);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeInputFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    throw new  IllegalStateException("Writing to a non-generated file is not permitted");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.events.BuildCommand.getArguments()java.util.Map;1
public Map<String, String> getArguments() {
    return getArguments(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.jface.internal.text.link.contentassist.ContentAssistant2$1.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  DefaultInformationControl(parent, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.ui.internal.use.ApiUsePatternTab$5.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
@Override
public void keyPressed(KeyEvent event) {
    if (event.character == SWT.DEL && event.stateMask == 0) {
        doRemove();
    }
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.ui.internal.preferences.ApiBaselinePreferencePage$1.keyReleased(org.eclipse.swt.events.KeyEvent;)V2
@Override
public void keyReleased(KeyEvent e) {
    if (e.stateMask == SWT.NONE && e.keyCode == SWT.DEL) {
        doRemove();
    }
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.getWorkingSets()Aorg.eclipse.help.internal.workingset.WorkingSet;1
private WorkingSet[] getWorkingSets() {
    String[] scopes = request.getParameterValues("scope");
    if (scopes == null) {
        return null;
    }
    ArrayList workingSetCol = new  ArrayList(scopes.length);
    for (int s = 0; s < scopes.length; s++) {
        WorkingSet ws = wsmgr.getWorkingSet(scopes[s]);
        if (ws != null) {
            workingSetCol.add(ws);
        }
    }
    if (workingSetCol.size() == 0) {
        return null;
    }
    return (WorkingSet[]) workingSetCol.toArray(new WorkingSet[workingSetCol.size()]);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Label.createWidget(I)V2
@Override
void createWidget(int index) {
    super.createWidget(index);
    text = "";
}
---------------Client-------------------
method: org.eclipse.ui.navigator.CommonNavigator.setLinkingEnabled(Z)V2
public final void setLinkingEnabled(boolean toEnableLinking) {
    isLinkingEnabled = toEnableLinking;
    firePropertyChange(IS_LINKING_ENABLED_PROPERTY);
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringStatusViewer$NextProblem.run()V1
public void run() {
    revealElement(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.ds.Reference.isRequired()Z1
public boolean isRequired() {
    return cardinalityLow == 1;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.isInfo()Z1
public boolean isInfo() {
    return fSeverity == IStatus.INFO;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.Binding.computeUniqueKey()AC1
public char[] computeUniqueKey() {
    return computeUniqueKey(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextNestedType()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextNestedType() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_NESTED_TYPE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.CompletionEngine.setSourceAndTokenRange(II)V3
private void setSourceAndTokenRange(int start, int end) {
    this.setSourceAndTokenRange(start, end, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.formatter.Scribe.printComment(II)V3
void printComment(int kind, int trailing) {
    printComment(kind, trailing, PRESERVE_EMPTY_LINES_KEEP_LAST_NEW_LINES_INDENTATION);
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.FilteredItemsSelectionDialog$ContentProvider.stopReloadingCache()V1
public void stopReloadingCache() {
    reset = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader.read(java.io.InputStream;java.lang.String;)org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;2
public static ClassFileReader read(InputStream stream, String fileName) throws ClassFormatException, IOException {
    return read(stream, fileName, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.updatesite.VersionSuffixGenerator.getMinor(org.eclipse.equinox.p2.metadata.Version;)I1
private static int getMinor(Version v) {
    return getIntSegment(v, 1);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.SimpleLog.isTraceEnabled()Z1
public final boolean isTraceEnabled() {
    return isLevelEnabled(SimpleLog.LOG_LEVEL_TRACE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptySwitchBlock()V1
protected void consumeEmptySwitchBlock() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.visit(org.eclipse.jdt.core.dom.StringLiteral;)Z2
@Override
public boolean visit(StringLiteral node) {
    this.fBuffer.append(node.getEscapedValue());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.TypeReference.resolveType(org.eclipse.jdt.internal.compiler.lookup.BlockScope;)org.eclipse.jdt.internal.compiler.lookup.TypeBinding;2
public final TypeBinding resolveType(BlockScope blockScope) {
    return resolveType(blockScope, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ActionExpression$SingleExpression.equals(java.lang.Object;)Z2
@Override
public final boolean equals(final Object object) {
    if (object instanceof SingleExpression) {
        final SingleExpression that = (SingleExpression) object;
        return Util.equals(this.child, that.child);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.CompareResultDialog$CompareElement.getContents()java.io.InputStream;1
public InputStream getContents() {
    try {
        return new  ByteArrayInputStream(fContent.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
        return new  ByteArrayInputStream(fContent.getBytes());
    }
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.TextEditChangePreviewViewer$CompareElement.getContents()java.io.InputStream;1
public InputStream getContents() throws CoreException {
    try {
        return new  ByteArrayInputStream(fContent.getBytes(ENCODING));
    } catch (UnsupportedEncodingException e) {
        return new  ByteArrayInputStream(fContent.getBytes());
    }
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBackgroundHandler.applyCSSPropertyBackgroundImage(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBackgroundImage(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("background-image");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.expressions.ExpressionInfo.markDefaultVariableAccessed()V1
public void markDefaultVariableAccessed() {
    fHasDefaultVariableAccess = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtSecondaryTypeStart()Z1
boolean isAtSecondaryTypeStart() {
    return this.index < this.source.length && this.source[this.index] == '~';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.FieldReference.analyseCode(org.eclipse.jdt.internal.compiler.lookup.BlockScope;org.eclipse.jdt.internal.compiler.flow.FlowContext;org.eclipse.jdt.internal.compiler.flow.FlowInfo;)org.eclipse.jdt.internal.compiler.flow.FlowInfo;4
public FlowInfo analyseCode(BlockScope currentScope, FlowContext flowContext, FlowInfo flowInfo) {
    return analyseCode(currentScope, flowContext, flowInfo, true);
}
---------------Client-------------------
method: org.eclipse.ui.internal.operations.AdvancedValidationUserApprover.proceedExecuting(org.eclipse.core.commands.operations.IUndoableOperation;org.eclipse.core.commands.operations.IOperationHistory;org.eclipse.core.runtime.IAdaptable;)org.eclipse.core.runtime.IStatus;4
@Override
public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable uiInfo) {
    return proceedWithOperation(operation, history, uiInfo, EXECUTING);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.text.DSService.getServiceFactory()Z1
public boolean getServiceFactory() {
    return getBooleanAttributeValue(ATTRIBUTE_SERVICE_FACTORY, false);
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.MarkerUtilities.getSeverity(org.eclipse.core.resources.IMarker;)I1
public static int getSeverity(IMarker marker) {
    return getIntAttribute(marker, IMarker.SEVERITY, IMarker.SEVERITY_INFO);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.ReorgQueries$SkipQuery.confirm(java.lang.String;Ajava.lang.Object;)Z3
public boolean confirm(String question, Object[] elements) throws OperationCanceledException {
    throw new  UnsupportedOperationException("Not supported for skip queries");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtTypeParameterStart()Z1
boolean isAtTypeParameterStart() {
    return this.index < this.source.length && this.source[this.index] == 'T';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.core.internal.utils.KeyedHashSet.shouldGrow()Z1
private boolean shouldGrow() {
    return elementCount > elements.length * 0.75;
}
---------------Client-------------------
method: org.eclipse.core.internal.events.NodeIDMap.shouldGrow()Z1
private boolean shouldGrow() {
    return elementCount > ids.length * LOAD_FACTOR;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository.addReferences(java.util.Collection;)V2
public synchronized void addReferences(Collection<? extends IRepositoryReference> references) {
    throw new  UnsupportedOperationException("Cannot add References to a composite repository");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.actions.UnzipAction.undo(java.util.Map;)org.eclipse.core.runtime.IStatus;2
public IStatus undo(Map<String, Object> parameters) {
    return CleanupzipAction.cleanupzip(parameters, false);
}
---------------Client-------------------
method: org.eclipse.ui.trace.internal.providers.TracingComponentLabelProvider.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(final Object element) {
    return TracingComponentLabelProvider.getLabel(TracingConstants.LABEL_COLUMN_INDEX, element);
}

---------------Library-------------------
method: org.eclipse.jface.resource.ImageDescriptor.createImage()org.eclipse.swt.graphics.Image;1
public Image createImage() {
    return createImage(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.parts.WizardCheckboxTablePart.createControl(org.eclipse.swt.widgets.Composite;)V2
public void createControl(Composite parent) {
    createControl(parent, 2);
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.UnifiedTree.accept(org.eclipse.core.internal.localstore.IUnifiedTreeVisitor;)V2
public void accept(IUnifiedTreeVisitor visitor) throws CoreException {
    accept(visitor, IResource.DEPTH_INFINITE);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.FindImplementOccurrencesAction.selectionChanged(org.eclipse.jface.viewers.IStructuredSelection;)V2
@Override
public void selectionChanged(IStructuredSelection selection) {
    setEnabled(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository.getArtifact(org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;java.io.OutputStream;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.IStatus;4
public IStatus getArtifact(IArtifactDescriptor descriptor, OutputStream destination, IProgressMonitor monitor) {
    return getRawOrNormalArtifact(descriptor, destination, monitor, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.createImport(java.lang.String;org.eclipse.jdt.core.IJavaElement;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IImportDeclaration;4
public IImportDeclaration createImport(String importName, IJavaElement sibling, IProgressMonitor monitor) throws JavaModelException {
    return createImport(importName, sibling, Flags.AccDefault, monitor);
}

---------------Library-------------------
method: org.eclipse.jsch.internal.core.JSchLocation.getUsername()java.lang.String;1
public String getUsername() {
    return user == null ? "" : user;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.storage.friends.PasswordProviderDescription.getDescription()java.lang.String;1
public String getDescription() {
    return (description == null) ? EMPTY_STRING : description;
}

---------------Library-------------------
method: org.apache.batik.util.gui.resource.JToolbarButton$MouseListener.mouseExited(java.awt.event.MouseEvent;)V2
public void mouseExited(MouseEvent ev) {
    setBorderPainted(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.debug.internal.core.OutputStreamMonitor.flushContents()V1
@Override
public synchronized void flushContents() {
    fContents.setLength(0);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderRightStyle(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderRightStyle(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-right-style");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.launchConfigurations.AntLaunchShortcut.launch(org.eclipse.ant.internal.ui.model.AntElementNode;java.lang.String;)V3
public void launch(AntElementNode node, String mode) {
    String selectedTargetName = null;
    if (node instanceof AntTargetNode) {
        AntTargetNode targetNode = (AntTargetNode) node;
        if (targetNode.isDefaultTarget()) {
            selectedTargetName = DEFAULT_TARGET;
        } else {
            selectedTargetName = targetNode.getTarget().getName() + ',';
        }
    } else if (node instanceof AntProjectNode) {
        selectedTargetName = DEFAULT_TARGET;
    } else if (node instanceof AntTaskNode) {
        AntTaskNode taskNode = (AntTaskNode) node;
        selectedTargetName = taskNode.getTask().getOwningTarget().getName();
    }
    IFile file = node.getBuildFileResource();
    if (file != null) {
        launch(file.getFullPath(), file.getProject(), mode, selectedTargetName);
        return;
    }
    IWorkbenchPage page = AntUIPlugin.getActiveWorkbenchWindow().getActivePage();
    IPath filePath = null;
    IEditorPart editor = page.getActiveEditor();
    if (editor != null) {
        IEditorInput editorInput = editor.getEditorInput();
        ILocationProvider locationProvider = (ILocationProvider) editorInput.getAdapter(ILocationProvider.class);
        if (locationProvider != null) {
            filePath = locationProvider.getPath(editorInput);
            if (filePath != null) {
                launch(filePath, null, mode, selectedTargetName);
                return;
            }
        }
    }
    antFileNotFound();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.ObjectMap.clear()V1
@Override
public void clear() {
    elements = null;
    count = 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.setOK()V1
public void setOK() {
    fStatusMessage = null;
    fSeverity = IStatus.OK;
}

---------------Library-------------------
method: org.eclipse.equinox.http.jetty.internal.HttpServerManager.createJettyCustomizer(java.util.Dictionary;)org.eclipse.equinox.http.jetty.JettyCustomizer;2
private JettyCustomizer createJettyCustomizer(@SuppressWarnings("rawtypes") Dictionary dictionary) {
    String customizerClass = (String) dictionary.get(JettyConstants.CUSTOMIZER_CLASS);
    if (null == customizerClass)
        return null;
    try {
        return (JettyCustomizer) Class.forName(customizerClass).newInstance();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.list.DecoratingObservableList.listIterator()java.util.ListIterator;1
public ListIterator listIterator() {
    return listIterator(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextArrayDimension()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextArrayDimension() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_ARRAY_DIMENSION);
}

---------------Library-------------------
method: org.eclipse.text.edits.TextEditProcessor.createSourceComputationProcessor(org.eclipse.jface.text.IDocument;org.eclipse.text.edits.TextEdit;I)org.eclipse.text.edits.TextEditProcessor;3
static TextEditProcessor createSourceComputationProcessor(IDocument document, TextEdit root, int style) {
    return new  TextEditProcessor(document, root, style, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.JavaUIStatus.createInfo(ILjava.lang.String;java.lang.Throwable;)org.eclipse.core.runtime.IStatus;3
public static IStatus createInfo(int code, String message, Throwable throwable) {
    return new  JavaUIStatus(IStatus.INFO, code, message, throwable);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.ClasspathUtilCore.getSourceZipName(java.lang.String;)java.lang.String;1
public static String getSourceZipName(String libraryName) {
    int dot = libraryName.lastIndexOf('.');
    return (dot != -1) ? libraryName.substring(0, dot) + "src.zip" : libraryName;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.imports.PluginImportOperation.getSourceDirName(java.lang.String;)java.lang.String;2
private String getSourceDirName(String libraryName) {
    int dot = libraryName.lastIndexOf('.');
    return (dot != -1) ? libraryName.substring(0, dot) + DEFAULT_SOURCE_DIR : libraryName;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleSheetImpl.getType()java.lang.String;1
@Override
public String getType() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jface.text.link.LinkedModeModel.tryInstall()Z1
public boolean tryInstall() throws BadLocationException {
    return install(false);
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpParser.isComplete()Z1
public boolean isComplete() {
    return isState(STATE_END);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.BookmarksData.addBookmark()V1
public void addBookmark() {
    String bookmarkURL = request.getParameter("bookmark");
    if (bookmarkURL != null && bookmarkURL.length() > 0 && !bookmarkURL.equals("about:blank")) {
        String title = request.getParameter("title");
        if (title == null) {
            return;
        }
        BookmarkManager manager = BaseHelpSystem.getBookmarkManager();
        manager.addBookmark(bookmarkURL, title);
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCSRunObject.getRequired()Z1
public boolean getRequired() {
    return getBooleanAttributeValue(ATTRIBUTE_REQUIRED, true);
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.MarkerUtilities.getPriority(org.eclipse.core.resources.IMarker;)I1
public static int getPriority(IMarker marker) {
    return getIntAttribute(marker, IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.core.refactoring.BreakpointRenameFieldParticipant.createChange(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.ltk.core.refactoring.Change;2
@Override
public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
    List<Change> changes = new  ArrayList<Change>();
    IResource resource = getBreakpointContainer();
    IMarker[] markers = resource.findMarkers(JavaWatchpoint.JAVA_WATCHPOINT, true, IResource.DEPTH_INFINITE);
    gatherChanges(markers, changes, getArguments().getNewName());
    if (changes.size() > 1) {
        return new  CompositeChange(RefactoringMessages.BreakpointRenameParticipant_1, changes.toArray(new Change[changes.size()]));
    } else if (changes.size() == 1) {
        return changes.get(0);
    }
    return null;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.formatter.Scribe.printNextToken(AI)V2
public void printNextToken(int[] expectedTokenTypes) {
    printNextToken(expectedTokenTypes, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.apache.lucene.analysis.CharTokenizer.isTokenChar(I)Z2
protected boolean isTokenChar(int c) {
    throw new  UnsupportedOperationException("since LUCENE_31 subclasses of CharTokenizer must implement isTokenChar(int)");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jface.text.source.AnnotationModel.modifyAnnotationPosition(org.eclipse.jface.text.source.Annotation;org.eclipse.jface.text.Position;)V3
public void modifyAnnotationPosition(Annotation annotation, Position position) {
    modifyAnnotationPosition(annotation, position, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.genericInferenceError(java.lang.String;org.eclipse.jdt.internal.compiler.lookup.InvocationSite;)V3
public void genericInferenceError(String message, InvocationSite invocationSite) {
    genericInferenceProblem(message, invocationSite, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.createTempWorkingSets()Aorg.eclipse.help.internal.workingset.WorkingSet;1
private WorkingSet[] createTempWorkingSets() {
    String[] scopes = request.getParameterValues("scope");
    if (scopes == null) {
        return new WorkingSet[0];
    }
    if (scopes.length == HelpPlugin.getTocManager().getTocs(getLocale()).length) {
        return null;
    }
    ArrayList tocs = new  ArrayList(scopes.length);
    for (int s = 0; s < scopes.length; s++) {
        AdaptableToc toc = wsmgr.getAdaptableToc(scopes[s]);
        if (toc != null) {
            tocs.add(toc);
        }
    }
    AdaptableToc[] adaptableTocs = (AdaptableToc[]) tocs.toArray(new AdaptableToc[tocs.size()]);
    WorkingSet[] workingSets = new WorkingSet[1];
    workingSets[0] = wsmgr.createWorkingSet("temp", adaptableTocs);
    return workingSets;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.ui.intro.contentproviders.AlwaysWelcomeCheckbox.dispose()V1
public void dispose() {
    disposed = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jface.action.MenuManager.updateAll(Z)V2
@Override
public void updateAll(boolean force) {
    update(force, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.setHasInitializer(Z)V2
protected void setHasInitializer(boolean hasInitializer) {
    setMask(MASK_FIELD_HAS_INITIALIZER, hasInitializer);
}

---------------Library-------------------
method: org.eclipse.jetty.util.StringUtil.nonNull(java.lang.String;)java.lang.String;1
public static String nonNull(String s) {
    if (s == null)
        return "";
    return s;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.project.ProjectModifyOperation.getTargetVersion(java.lang.String;)java.lang.String;2
private String getTargetVersion(String targetVersion) {
    if (targetVersion == null) {
        return ICoreConstants.TARGET_VERSION_LATEST;
    }
    return targetVersion;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.apt.model.TypesImpl.capture(javax.lang.model.type.TypeMirror;)javax.lang.model.type.TypeMirror;2
@Override
public TypeMirror capture(TypeMirror t) {
    throw new  UnsupportedOperationException("NYI: TypesImpl.capture(...)");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.RectImpl.getBottom()org.w3c.dom.css.CSSPrimitiveValue;1
@Override
public CSSPrimitiveValue getBottom() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.bindings.internal.Util.assertInstance(java.lang.Object;java.lang.Class;)V2
public static final void assertInstance(final Object object, final Class<?> c) {
    assertInstance(object, c, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.e4.ui.widgets.ImageBasedFrame$4.controlResized(org.eclipse.swt.events.ControlEvent;)V2
public void controlResized(ControlEvent e) {
    pack(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocStandardWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(STYLESHEETSTATUS);
}

---------------Library-------------------
method: org.eclipse.ui.internal.wizards.datatransfer.MinimizedFileSystemElement.setPopulated()V1
public void setPopulated() {
    this.populated = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.BrowserViewer$1.mouseDown(org.eclipse.swt.events.MouseEvent;)V2
public void mouseDown(MouseEvent e) {
    setURL("http://www.eclipse.org");
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.dialogs.OverrideMethodDialog$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    openCodeTempatePage(CodeTemplateContextType.OVERRIDECOMMENT_ID);
}

---------------Library-------------------
method: org.eclipse.ui.navigator.CommonViewer.refresh(java.lang.Object;)V2
public void refresh(Object element) {
    refresh(element, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.ds.ScrServiceImpl.dispose()V1
public void dispose() {
    disposed = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ChangeSignatureWizard$ChangeSignatureInputPage$7.parameterListChanged()V1
public void parameterListChanged() {
    update(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.LayoutData.getContentURL()java.lang.String;1
public String getContentURL() {
    String navHref = request.getParameter("nav");
    if (navHref != null) {
        return "../nav" + navHref;
    }
    String topicHref = request.getParameter("topic");
    if (topicHref == null || topicHref.length() == 0) {
        if (BaseHelpSystem.getMode() != BaseHelpSystem.MODE_INFOCENTER && RemoteStatusData.isAnyRemoteHelpUnavailable()) {
            return "../topic/" + HelpWebappPlugin.PLUGIN_ID + '/' + MissingContentManager.REMOTE_STATUS_HREF;
        }
        if (MissingContentManager.getInstance().isUnresolvedPlaceholders()) {
            String helpMissingPage = MissingContentManager.getInstance().getHelpMissingPage(false);
            if (helpMissingPage != null) {
                return "../topic" + helpMissingPage;
            }
        }
        return UrlUtil.getHelpURL(preferences.getHelpHome());
    } else {
        TocData tocData = new  TocData(context, request, response);
        String topic = tocData.getSelectedTopicWithPath();
        if (topic == null || !UrlUtil.isValidTopicParamOrWasOpenedFromHelpDisplay(topic)) {
            return UrlUtil.getHelpURL(preferences.getHelpHome());
        }
        return topic;
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtTypeWithCaptureStart()Z1
boolean isAtTypeWithCaptureStart() {
    return this.index < this.source.length && this.source[this.index] == '&';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList$Unsettable.didChange()V1
@Override
protected void didChange() {
    isSet = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.apache.lucene.search.NumericRangeQuery$NumericRangeTermEnum.setEnum(org.apache.lucene.index.TermEnum;)V2
@Override
protected void setEnum(TermEnum tenum) {
    throw new  UnsupportedOperationException("not implemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Decorations.createWidget(I)V2
@Override
void createWidget(int index) {
    super.createWidget(index);
    text = "";
}
---------------Client-------------------
method: org.eclipse.ui.navigator.CommonNavigator.setLinkingEnabled(Z)V2
public final void setLinkingEnabled(boolean toEnableLinking) {
    isLinkingEnabled = toEnableLinking;
    firePropertyChange(IS_LINKING_ENABLED_PROPERTY);
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.BrowserExt.getParameters()java.lang.String;1
public String getParameters() {
    return element.getAttribute("parameters");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.build.RuntimeInstallJob.createInstallableUnitPatch(org.eclipse.equinox.p2.metadata.IInstallableUnit;org.eclipse.equinox.p2.metadata.Version;org.eclipse.equinox.p2.engine.IProfile;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.equinox.p2.metadata.IInstallableUnitPatch;5
private IInstallableUnitPatch createInstallableUnitPatch(IInstallableUnit existingIU, Version newVersion, IProfile profile, IProgressMonitor monitor) {
    InstallableUnitPatchDescription iuPatchDescription = new  MetadataFactory.InstallableUnitPatchDescription();
    String id = existingIU.getId();
    iuPatchDescription.setId(id + ".patch");
    iuPatchDescription.setProperty(IInstallableUnit.PROP_NAME, NLS.bind(PDEUIMessages.RuntimeInstallJob_installPatchName, id));
    iuPatchDescription.setProperty(IInstallableUnit.PROP_DESCRIPTION, PDEUIMessages.RuntimeInstallJob_installPatchDescription);
    Version patchVersion = Version.createOSGi(1, 0, 0, QualifierReplacer.getDateQualifier());
    iuPatchDescription.setVersion(patchVersion);
    iuPatchDescription.setUpdateDescriptor(MetadataFactory.createUpdateDescriptor(iuPatchDescription.getId(), new  VersionRange(Version.createOSGi(0, 0, 0), true, patchVersion, false), 0, null));
    ArrayList<IProvidedCapability> list = new  ArrayList<IProvidedCapability>(1);
    list.add(MetadataFactory.createProvidedCapability(IInstallableUnit.NAMESPACE_IU_ID, iuPatchDescription.getId(), iuPatchDescription.getVersion()));
    iuPatchDescription.addProvidedCapabilities(list);
    IRequirement applyTo = MetadataFactory.createRequirement(IInstallableUnit.NAMESPACE_IU_ID, id, null, null, false, false);
    IRequirement newValue = MetadataFactory.createRequirement(IInstallableUnit.NAMESPACE_IU_ID, id, new  VersionRange(newVersion, true, newVersion, true), null, false, false);
    iuPatchDescription.setRequirementChanges(new IRequirementChange[] { MetadataFactory.createRequirementChange(applyTo, newValue) });
    iuPatchDescription.setApplicabilityScope(new IRequirement[0][0]);
    IQueryResult<?> queryMatches = profile.query(QueryUtil.createMatchQuery("requirements.exists(rc | $0 ~= rc)", new Object[] { existingIU }), monitor);
    if (!queryMatches.isEmpty()) {
        IInstallableUnit lifecycleUnit = (IInstallableUnit) queryMatches.iterator().next();
        iuPatchDescription.setLifeCycle(MetadataFactory.createRequirement(IInstallableUnit.NAMESPACE_IU_ID, lifecycleUnit.getId(), new  VersionRange(lifecycleUnit.getVersion(), true, lifecycleUnit.getVersion(), true), null, false, false, false));
    }
    iuPatchDescription.setProperty(InstallableUnitDescription.PROP_TYPE_PATCH, Boolean.TRUE.toString());
    return MetadataFactory.createInstallableUnitPatch(iuPatchDescription);
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicExtendedMetaData$EClassExtendedMetaDataImpl.setMaxExclusiveFacet(java.lang.String;)V2
public void setMaxExclusiveFacet(String literal) {
    throw new  UnsupportedOperationException("Can't set the max exclusive of an EClass");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.dtree.NoDataDeltaNode.isEmptyDelta()Z1
boolean isEmptyDelta() {
    return this.size() == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaModelStatus.isOK()Z1
public boolean isOK() {
    return getCode() == OK;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.NaiveASTFlattener.visit(org.eclipse.jdt.core.dom.SimpleName;)Z2
public boolean visit(SimpleName node) {
    this.buffer.append(node.getIdentifier());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.selectionactions.SelectionHistory$1.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    if (fSelectionChangeListenerCounter == 0)
        flush();
}
---------------Client-------------------
method: org.eclipse.search.ui.text.AbstractTextSearchViewPage$7.run()V1
public void run() {
    if (!control.isDisposed())
        runnable.run();
}

---------------Library-------------------
method: org.eclipse.osgi.internal.framework.OSGiFrameworkHooks.initEnd()V1
public void initEnd() {
    resolverHookFactory.inInit = false;
}
---------------Client-------------------
method: org.eclipse.swt.internal.image.JPEGDecoder.finish_input_pass(org.eclipse.swt.internal.image.JPEGDecoder$jpeg_decompress_struct;)V1
static void finish_input_pass(jpeg_decompress_struct cinfo) {
    cinfo.inputctl.consume_input = INPUT_CONSUME_INPUT;
}

---------------Library-------------------
method: org.eclipse.osgi.internal.module.MappedList.get(java.lang.Object;)java.util.List;2
public List<V> get(K key) {
    return get(key, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object element) {
    return getColumnText(element, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Observables.proxyObservableValue(org.eclipse.core.databinding.observable.value.IObservableValue;)org.eclipse.core.databinding.observable.value.IObservableValue;1
public static IObservableValue proxyObservableValue(IObservableValue target) {
    return new  DecoratingObservableValue(target, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameInformationPopup$PopupVisibilityManager.viewportChanged(I)V2
public void viewportChanged(int verticalOffset) {
    updatePopupLocation(true);
    updateVisibility();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameTypeWizardSimilarElementsOptionsDialog$1.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    updateLabel();
    fSelectedStrategy = RenamingNameSuggestor.STRATEGY_EXACT;
}

---------------Library-------------------
method: org.apache.lucene.search.FieldCacheImpl.getInts(org.apache.lucene.index.IndexReader;java.lang.String;org.apache.lucene.search.FieldCache$IntParser;)AI4
public int[] getInts(IndexReader reader, String field, IntParser parser) throws IOException {
    return getInts(reader, field, parser, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.createImport(java.lang.String;org.eclipse.jdt.core.IJavaElement;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IImportDeclaration;4
public IImportDeclaration createImport(String importName, IJavaElement sibling, IProgressMonitor monitor) throws JavaModelException {
    return createImport(importName, sibling, Flags.AccDefault, monitor);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCSItem.addSubItem(ILorg.eclipse.pde.internal.ua.core.cheatsheet.simple.ISimpleCSSubItemObject;)V3
public void addSubItem(int index, ISimpleCSSubItemObject subitem) {
    addChildNode((IDocumentElementNode) subitem, index, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleErrorToken(java.lang.String;Z)V3
protected void handleErrorToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.search2.internal.ui.SearchViewManager.activateSearchView(Z)org.eclipse.search.ui.ISearchResultViewPart;2
public ISearchResultViewPart activateSearchView(boolean avoidPinnedViews) {
    return activateSearchView(avoidPinnedViews, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSConditionFactory.createNegativeCondition(org.w3c.css.sac.Condition;)org.w3c.css.sac.NegativeCondition;2
public NegativeCondition createNegativeCondition(Condition condition) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.WebBrowserPreferencePage$BrowserTableLabelProvider.notNull(java.lang.String;)java.lang.String;2
protected String notNull(String s) {
    if (s == null)
        return "";
    return s;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.project.ProjectModifyOperation.getTargetVersion(java.lang.String;)java.lang.String;2
private String getTargetVersion(String targetVersion) {
    if (targetVersion == null) {
        return ICoreConstants.TARGET_VERSION_LATEST;
    }
    return targetVersion;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.RuntimeClasspathEntryResolver.getRuntimeClasspathEntryId()java.lang.String;1
public String getRuntimeClasspathEntryId() {
    return fConfigurationElement.getAttribute("runtimeClasspathEntryId");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xml.type.internal.RegEx$Token.sortRanges()V1
protected void sortRanges() {
    throw new  RuntimeException("Not supported.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$FileTextDragListener.dragFinished(org.eclipse.swt.dnd.DragSourceEvent;)V2
public void dragFinished(DragSourceEvent event) {
    element.setText("");
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.dialogs.OverrideMethodDialog$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    openCodeTempatePage(CodeTemplateContextType.OVERRIDECOMMENT_ID);
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.model.loader.IntroContentParser$1.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(""));
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
@Override
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(IAntCoreConstants.EMPTY_STRING));
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Observables.proxyObservableMap(org.eclipse.core.databinding.observable.map.IObservableMap;)org.eclipse.core.databinding.observable.map.IObservableMap;1
public static IObservableMap proxyObservableMap(IObservableMap target) {
    return new  DecoratingObservableMap(target, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.syncinfo.ResourceSyncInfo.setTag(ABAB)AB2
public static byte[] setTag(byte[] syncBytes, byte[] tagBytes) throws CVSException {
    return setSlot(syncBytes, 5, tagBytes);
}
---------------Client-------------------
method: org.eclipse.jdt.core.NamingConventions.removePrefixAndSuffixForLocalVariableName(org.eclipse.jdt.core.IJavaProject;AC)AC2
public static char[] removePrefixAndSuffixForLocalVariableName(IJavaProject javaProject, char[] localName) {
    return InternalNamingConventions.removeVariablePrefixAndSuffix(VK_LOCAL, javaProject, localName);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.AboutInfo.getVersionId()java.lang.String;1
public String getVersionId() {
    return bundleGroupProperties == null ? "" : bundleGroupProperties.getFeatureVersion();
}
---------------Client-------------------
method: org.eclipse.ui.internal.themes.Theme.getId()java.lang.String;1
@Override
public String getId() {
    return descriptor == null ? IThemeManager.DEFAULT_THEME : descriptor.getId();
}

---------------Library-------------------
method: org.eclipse.osgi.internal.container.ComputeNodeOrder$Digraph.freeze()V1
public void freeze() {
    if (!initialized) {
        initialized = true;
        DFS();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.text.DSComponent.addPropertyElement(org.eclipse.pde.internal.ds.core.IDSProperty;)V2
public void addPropertyElement(IDSProperty property) {
    this.addChildNode(property, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.SourceViewerInformationControl$1.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
public void keyPressed(KeyEvent e) {
    if (e.character == 0x1B)
        fShell.dispose();
}
---------------Client-------------------
method: org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter$LinkListInformationControl$5.keyTraversed(org.eclipse.swt.events.TraverseEvent;)V2
public void keyTraversed(TraverseEvent e) {
    if (e.keyCode == SWT.ESC) {
        fManager.hideInformationControl();
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.batch.ClasspathDirectory.toString()java.lang.String;1
public String toString() {
    return "ClasspathDirectory " + this.path;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager$CustomProfile.getID()java.lang.String;1
@Override
public String getID() {
    return ID_PREFIX + fName;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.provisional.p2.directorywatcher.RepositoryListener.changed(java.io.File;)Z2
public boolean changed(File file) {
    return process(file, false);
}
---------------Client-------------------
method: org.eclipse.team.core.variants.SessionResourceVariantByteStore.deleteBytes(org.eclipse.core.resources.IResource;)Z2
public boolean deleteBytes(IResource resource) throws TeamException {
    return flushBytes(resource, IResource.DEPTH_ZERO);
}

---------------Library-------------------
method: org.eclipse.ui.ide.undo.CreateFileOperation$1.getCharset()java.lang.String;1
public String getCharset() {
    try {
        return file.getCharset(false);
    } catch (CoreException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathPage.getAntHomeEntries()Aorg.eclipse.ant.core.IAntClasspathEntry;1
protected IAntClasspathEntry[] getAntHomeEntries() {
    return fModel.getEntries(ClasspathModel.ANT_HOME);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.wizards.TeamWizardPage.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
protected Label createLabel(Composite parent, String text) {
    return createIndentedLabel(parent, text, 0);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.GenerateHashCodeEqualsAction.checkSuperClass(org.eclipse.jdt.core.dom.ITypeBinding;)org.eclipse.ltk.core.refactoring.RefactoringStatus;2
@Override
RefactoringStatus checkSuperClass(ITypeBinding superclass) {
    return checkHashCodeEqualsExists(superclass, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.hasErrors()Z1
public boolean hasErrors() {
    return this.numberOfErrors != 0;
}
---------------Client-------------------
method: org.eclipse.jetty.http.AbstractGenerator.isCommitted()Z1
public boolean isCommitted() {
    return _state != STATE_HEADER;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.change.impl.ResourceChangeImpl.apply(Z)V2
protected void apply(boolean reverse) {
    process(reverse, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.setHasInitializer(Z)V2
protected void setHasInitializer(boolean hasInitializer) {
    setMask(MASK_FIELD_HAS_INITIALIZER, hasInitializer);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.model.AntProjectNodeProxy.parseBuildFile()V1
public void parseBuildFile() {
    parseBuildFile(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSValueImpl.getStringValue()java.lang.String;1
@Override
public String getStringValue() throws DOMException {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.equinox.http.jetty.internal.HttpServerManager.createHttpConnector(java.util.Dictionary;)org.eclipse.jetty.server.Connector;2
private Connector createHttpConnector(@SuppressWarnings("rawtypes") Dictionary dictionary) {
    Boolean httpEnabled = null;
    Object httpEnabledObj = dictionary.get(JettyConstants.HTTP_ENABLED);
    if (httpEnabledObj instanceof Boolean) {
        httpEnabled = (Boolean) httpEnabledObj;
    } else if (httpEnabledObj instanceof String) {
        httpEnabled = Boolean.parseBoolean(httpEnabledObj.toString());
    }
    if (httpEnabled != null && !httpEnabled.booleanValue())
        return null;
    Integer httpPort = null;
    Object httpPortObj = dictionary.get(JettyConstants.HTTP_PORT);
    if (httpPortObj instanceof Integer) {
        httpPort = (Integer) httpPortObj;
    } else if (httpPortObj instanceof String) {
        httpPort = Integer.valueOf(httpPortObj.toString());
    }
    if (httpPort == null)
        return null;
    Boolean nioEnabled = null;
    Object nioEnabledObj = dictionary.get(JettyConstants.HTTP_NIO);
    if (nioEnabledObj instanceof Boolean) {
        nioEnabled = (Boolean) nioEnabledObj;
    } else if (nioEnabledObj instanceof String) {
        nioEnabled = Boolean.parseBoolean(nioEnabledObj.toString());
    }
    if (nioEnabled == null)
        nioEnabled = getDefaultNIOEnablement();
    Connector connector;
    if (nioEnabled.booleanValue())
        connector = new  SelectChannelConnector();
    else
        connector = new  SocketConnector();
    connector.setPort(httpPort.intValue());
    String httpHost = (String) dictionary.get(JettyConstants.HTTP_HOST);
    if (httpHost != null) {
        connector.setHost(httpHost);
    }
    if (connector.getPort() == 0) {
        try {
            connector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return connector;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.emf.common.util.BasicEList.isEmpty()Z1
@Override
public boolean isEmpty() {
    return size == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.ImportRewriteAnalyzer$PackageEntry.isComment()Z1
public boolean isComment() {
    return "!".equals(this.name);
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.hasRootProjectElement()Z1
protected boolean hasRootProjectElement() {
    return PROJECT.equals(fTopElementFound);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.record(org.eclipse.jdt.core.compiler.CategorizedProblem;org.eclipse.jdt.internal.compiler.impl.ReferenceContext;)V3
public void record(CategorizedProblem newProblem, ReferenceContext referenceContext) {
    record(newProblem, referenceContext, true);
    return;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.genericInferenceError(java.lang.String;org.eclipse.jdt.internal.compiler.lookup.InvocationSite;)V3
public void genericInferenceError(String message, InvocationSite invocationSite) {
    genericInferenceProblem(message, invocationSite, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTNode.internalGetSetBooleanProperty(org.eclipse.jdt.core.dom.SimplePropertyDescriptor;ZZ)Z4
boolean internalGetSetBooleanProperty(SimplePropertyDescriptor property, boolean get, boolean value) {
    throw new  RuntimeException("Node does not have this property");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ecf.core.status.SerializableStatus.setMessage(java.lang.String;)V2
protected void setMessage(String message) {
    if (message == null)
        this.message = "";
    else
        this.message = message;
}
---------------Client-------------------
method: org.eclipse.ant.core.AntRunner.setBuildFileLocation(java.lang.String;)V2
public void setBuildFileLocation(String buildFileLocation) {
    if (buildFileLocation == null) {
        this.buildFileLocation = IAntCoreConstants.DEFAULT_BUILD_FILENAME;
    } else {
        this.buildFileLocation = buildFileLocation;
    }
}

---------------Library-------------------
method: org.eclipse.jface.text.projection.ProjectionDocumentManager.documentChanged(org.eclipse.jface.text.DocumentEvent;)V2
public void documentChanged(DocumentEvent event) {
    fireDocumentEvent(false, event);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyTypeArguments()V1
protected void consumeEmptyTypeArguments() {
    pushOnGenericsLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.FeatureModelManager.targetReloaded()V1
public void targetReloaded() {
    fReloadExternalNeeded = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.apache.lucene.store.DataInput.setModifiedUTF8StringsMode()V1
public void setModifiedUTF8StringsMode() {
    preUTF8Strings = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ecf.core.util.Base64.encode(AB)java.lang.String;1
public static String encode(byte[] bytes) {
    try {
        return new  String(encodeToCharArray(bytes), "ISO8859_1");
    } catch (UnsupportedEncodingException e) {
        throw new  NullPointerException("Do not have ISO8859_1 encoder");
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.plugin.WorkspaceExtensionsModel.createNLResourceHelper()org.eclipse.pde.internal.core.NLResourceHelper;1
protected NLResourceHelper createNLResourceHelper() {
    return new  NLResourceHelper(Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME, getNLLookupLocations());
}

---------------Library-------------------
method: org.eclipse.pde.internal.launching.launcher.LaunchListener.shutdown()V1
public void shutdown() {
    hookListener(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ActionExpression$OrExpression.equals(java.lang.Object;)Z2
@Override
public final boolean equals(final Object object) {
    if (object instanceof OrExpression) {
        final OrExpression that = (OrExpression) object;
        return Util.equals(this.list, that.list);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.shared.target.AddBundleContainerSelectionPage$AbstractBundleContainerNode.getExtent()org.eclipse.swt.graphics.Point;1
public Point getExtent() {
    return new  Point(-1, -1);
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.renderers.swt.TrimmedPartLayout.computeSize(org.eclipse.swt.widgets.Composite;IIZ)org.eclipse.swt.graphics.Point;5
@Override
protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
    return new  Point(SWT.DEFAULT, SWT.DEFAULT);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleSheetImpl.setDisabled(Z)V2
@Override
public void setDisabled(boolean disabled) {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.RecentSettingsStore$ProjectData.setDestination(java.lang.String;)V2
public void setDestination(String destination) {
    if (destination == null)
        fDestinationDir = "";
    else
        fDestinationDir = destination;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.ChangeHoverInformationControl.setStartingPartitionType(java.lang.String;)V2
public void setStartingPartitionType(String partition) {
    if (partition == null)
        fPartition = IDocument.DEFAULT_CONTENT_TYPE;
    else
        fPartition = partition;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleSheetImpl.getTitle()java.lang.String;1
@Override
public String getTitle() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryMethod.toStringName(java.lang.StringBuffer;)V2
protected void toStringName(StringBuffer buffer) {
    toStringName(buffer, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.jface.action.ContributionManager.prependToGroup(java.lang.String;org.eclipse.jface.action.IContributionItem;)V3
@Override
public void prependToGroup(String groupName, IContributionItem item) {
    addToGroup(groupName, item, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.create(org.eclipse.core.resources.IProjectDescription;org.eclipse.core.runtime.IProgressMonitor;)V3
public void create(IProjectDescription description, IProgressMonitor monitor) throws CoreException {
    create(description, IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.ToolbarData.getRestoreTooltip()java.lang.String;1
public String getRestoreTooltip() {
    return ServletResources.getString("restore", request);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMNode.getStartPosition()I1
public int getStartPosition() {
    return this.fSourceRange[0];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckInitialConditionsTicks()I1
public int getCheckInitialConditionsTicks() {
    return fValues[CHECK_INITIAL_CONDITIONS];
}

---------------Library-------------------
method: org.apache.lucene.analysis.StopFilter.makeStopSet(org.apache.lucene.util.Version;Ajava.lang.String;)java.util.Set;2
public static final Set<Object> makeStopSet(Version matchVersion, String... stopWords) {
    return makeStopSet(matchVersion, stopWords, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.NewLibraryPluginCreationPage$4.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event event) {
    PreferencesUtil.createPreferenceDialogOn(getShell(), "org.eclipse.jdt.debug.ui.jreProfiles", new String[] { "org.eclipse.jdt.debug.ui.jreProfiles" }, null).open();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.launcher.WorkspaceDataBlock$4.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    PreferencesUtil.createPreferenceDialogOn(configureDefaults.getShell(), MainPreferencePage.ID, new String[] { MainPreferencePage.ID }, null).open();
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.File.getCharset()java.lang.String;1
public String getCharset() throws CoreException {
    return getCharset(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.help.search.SearchParticipantXML$XMLHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(""));
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
@Override
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(IAntCoreConstants.EMPTY_STRING));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.indexing.IndexManager.indexLibrary(org.eclipse.core.runtime.IPath;org.eclipse.core.resources.IProject;java.net.URL;)V4
public void indexLibrary(IPath path, IProject requestingProject, URL indexURL) {
    this.indexLibrary(path, requestingProject, indexURL, false);
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.properties.css2.CSSPropertyMarginSWTHandler.applyCSSPropertyMarginTop(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyMarginTop(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    setMargin(element, TOP, value, pseudo);
}

---------------Library-------------------
method: org.eclipse.jface.internal.text.html.BrowserInformationControl$4.run()V1
public void run() {
    fCompleted = true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.jetty.continuation.ContinuationFilter.debug(java.lang.String;java.lang.Throwable;)V3
private void debug(String string, Throwable th) {
    if (_debug) {
        if (th instanceof ContinuationThrowable)
            _context.log(string + ":" + th);
        else
            _context.log(string, th);
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.ecf.internal.ssl.ECFTrustManager.checkClientTrusted(Ajava.security.cert.X509Certificate;java.lang.String;)V3
public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
    throw new  UnsupportedOperationException("Not implemented yet");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.JUnitPreferencePage$8.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event e) {
    checkAllFilters(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.core.internal.runtime.InternalPlatform.getStateLocation(org.osgi.framework.Bundle;)org.eclipse.core.runtime.IPath;2
public IPath getStateLocation(Bundle bundle) {
    return getStateLocation(bundle, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSRuleImpl.getCssText()java.lang.String;1
@Override
public String getCssText() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.scheduler.AutomaticUpdatesPopup.close()Z1
public boolean close() {
    return close(true);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.SimpleLog.isTraceEnabled()Z1
public final boolean isTraceEnabled() {
    return isLevelEnabled(SimpleLog.LOG_LEVEL_TRACE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameInformationPopup$PopupVisibilityManager.controlResized(org.eclipse.swt.events.ControlEvent;)V2
public void controlResized(ControlEvent e) {
    updatePopupLocation(true);
    updateVisibility();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameTypeWizardSimilarElementsOptionsDialog$1.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    updateLabel();
    fSelectedStrategy = RenamingNameSuggestor.STRATEGY_EXACT;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.history.GenericHistoryView.showHistoryPageFor(java.lang.Object;ZZLorg.eclipse.team.ui.history.IHistoryPageSource;)org.eclipse.team.ui.history.IHistoryPage;5
public IHistoryPage showHistoryPageFor(Object object, boolean refresh, boolean force, IHistoryPageSource pageSource) {
    lastSelectedElement = null;
    if (Policy.DEBUG_HISTORY) {
        String time = new  SimpleDateFormat("m:ss.SSS").format(new  Date(System.currentTimeMillis()));
        System.out.println(time + ": GenericHistoryView#showHistoryPageFor, the object to show is: " + object);
    }
    if (!checkIfPageIsVisible())
        return null;
    pageSource = getPageSourceFor(object, pageSource);
    if (pageSource == null || !pageSource.canShowHistoryFor(object))
        return null;
    IHistoryPage existingPage = checkForExistingPage(object, refresh, force, pageSource);
    if (existingPage != null) {
        return existingPage;
    }
    if (isViewPinned() && !force) {
        return handlePinnedView(object, refresh, pageSource);
    }
    HistoryPageSourceWorkbenchPart part = new  HistoryPageSourceWorkbenchPart(object, pageSource, getViewSite());
    super.partActivated(part);
    if (Policy.DEBUG_HISTORY) {
        String time = new  SimpleDateFormat("m:ss.SSS").format(new  Date(System.currentTimeMillis()));
        System.out.println(time + ": GenericHistoryView#showHistoryPageFor, the page showing the history is: " + getHistoryPage());
    }
    return getHistoryPage();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;java.lang.Throwable;)V3
public void debug(Object message, Throwable t) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message), t);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Container.findMember(org.eclipse.core.runtime.IPath;)org.eclipse.core.resources.IResource;2
public IResource findMember(IPath childPath) {
    return findMember(childPath, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.core.internal.utils.FileUtil.isPrefixOf(java.net.URI;java.net.URI;)Z2
public static boolean isPrefixOf(URI location1, URI location2) {
    return computeOverlap(location1, location2, false);
}
---------------Client-------------------
method: org.eclipse.team.core.variants.SessionResourceVariantByteStore.deleteBytes(org.eclipse.core.resources.IResource;)Z2
public boolean deleteBytes(IResource resource) throws TeamException {
    return flushBytes(resource, IResource.DEPTH_ZERO);
}

---------------Library-------------------
method: org.eclipse.emf.common.archive.ArchiveURLConnection.connect()V1
@Override
public void connect() throws IOException {
    connected = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.BookmarksData.removeBookmark()V1
public void removeBookmark() {
    String bookmarkURL = request.getParameter("bookmark");
    if (bookmarkURL != null && bookmarkURL.length() > 0 && !bookmarkURL.equals("about:blank")) {
        String title = request.getParameter("title");
        if (title == null) {
            return;
        }
        BookmarkManager manager = BaseHelpSystem.getBookmarkManager();
        manager.removeBookmark(bookmarkURL, title);
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.ImportRewriteAnalyzer$PackageEntry.isDefaultPackage()Z1
public boolean isDefaultPackage() {
    return this.name.length() == 0;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$StatusWrapper.isOK()Z1
public boolean isOK() {
    return diagnostic.getSeverity() == OK;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.EditorsView$EditorsComparator.extractDate(java.lang.String;)J2
private long extractDate(String dateString) {
    if (dateString != null) {
        for (int i = 0; i < dateFormats.length; i++) {
            dateFormats[i].setLenient(true);
            try {
                return dateFormats[i].parse(dateString).getTime();
            } catch (ParseException ex) {
            }
        }
    }
    return -1;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.actions.CleanupcopyAction.execute(java.util.Map;)org.eclipse.core.runtime.IStatus;2
public IStatus execute(Map<String, Object> parameters) {
    return cleanupcopy(parameters, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTNode.internalGetSetIntProperty(org.eclipse.jdt.core.dom.SimplePropertyDescriptor;ZI)I4
int internalGetSetIntProperty(SimplePropertyDescriptor property, boolean get, int value) {
    throw new  RuntimeException("Node does not have this property");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.debug.internal.core.commands.Request.cancel()V1
@Override
public synchronized void cancel() {
    fCanceled = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.impl.IntConstant.toString()java.lang.String;1
public String toString() {
    return "(int)" + this.value;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager$CustomProfile.getID()java.lang.String;1
@Override
public String getID() {
    return ID_PREFIX + fName;
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.builder.BaseApiAnalyzer.checkApiUsage(org.eclipse.pde.api.tools.internal.provisional.builder.IBuildContext;org.eclipse.pde.api.tools.internal.provisional.model.IApiComponent;org.eclipse.core.runtime.IProgressMonitor;)V4
private void checkApiUsage(final IBuildContext context, final IApiComponent component, IProgressMonitor monitor) {
    if (ignoreApiUsageScan()) {
        if (ApiPlugin.DEBUG_API_ANALYZER) {
            System.out.println("Ignoring API usage scan");
        }
        return;
    }
    IApiTypeContainer scope = null;
    if (context.hasTypes()) {
        String[] typenames = getApiUseTypes(context);
        if (typenames.length < 1) {
            monitor.done();
            return;
        }
        scope = getSearchScope(component, typenames);
    } else {
        scope = getSearchScope(component, null);
    }
    SubMonitor localMonitor = SubMonitor.convert(monitor, MessageFormat.format(BuilderMessages.checking_api_usage, new Object[] { component.getSymbolicName() }), 2);
    ReferenceAnalyzer analyzer = new  ReferenceAnalyzer();
    try {
        long start = System.currentTimeMillis();
        IApiProblem[] illegal = analyzer.analyze(component, scope, localMonitor.newChild(2));
        Util.updateMonitor(localMonitor);
        long end = System.currentTimeMillis();
        if (ApiPlugin.DEBUG_API_ANALYZER) {
            System.out.println("API usage scan: " + (end - start) + " ms\t" + illegal.length + " problems");
        }
        for (int i = 0; i < illegal.length; i++) {
            addProblem(illegal[i]);
        }
        Util.updateMonitor(localMonitor);
    } catch (CoreException ce) {
        if (ApiPlugin.DEBUG_API_ANALYZER) {
            ApiPlugin.log(ce);
        }
    } finally {
        if (monitor != null) {
            monitor.done();
        }
    }
}
---------------Client-------------------
method: org.eclipse.ant.internal.launching.launchConfigurations.AntLaunchDelegate.configureAntRunner(org.eclipse.debug.core.ILaunchConfiguration;org.eclipse.core.runtime.IPath;java.lang.String;java.lang.StringBuffer;Ajava.lang.String;java.util.Map;Ajava.lang.String;Ajava.lang.String;Ajava.net.URL;java.lang.String;Z)org.eclipse.ant.core.AntRunner;12
private AntRunner configureAntRunner(ILaunchConfiguration configuration, IPath location, String baseDir, StringBuffer idProperty, String[] arguments, Map<String, String> userProperties, String[] propertyFiles, String[] targets, URL[] customClasspath, String antHome, boolean setInputHandler) throws CoreException {
    int argLength = 1;
    if (arguments != null) {
        argLength += arguments.length;
    }
    if (baseDir != null && baseDir.length() > 0) {
        argLength++;
    }
    String[] runnerArgs = new String[argLength];
    if (arguments != null) {
        System.arraycopy(arguments, 0, runnerArgs, 0, arguments.length);
    }
    if (baseDir != null && baseDir.length() > 0) {
        runnerArgs[runnerArgs.length - 2] = BASE_DIR_PREFIX + baseDir;
    }
    runnerArgs[runnerArgs.length - 1] = idProperty.toString();
    AntRunner runner = new  AntRunner();
    runner.setBuildFileLocation(location.toOSString());
    boolean captureOutput = ExternalToolsCoreUtil.getCaptureOutput(configuration);
    if (captureOutput) {
        if (fMode.equals(ILaunchManager.DEBUG_MODE)) {
            runner.addBuildLogger(ANT_DEBUG_LOGGER_CLASS);
        } else {
            runner.addBuildLogger(ANT_LOGGER_CLASS);
        }
    } else {
        runner.addBuildLogger(NULL_LOGGER_CLASS);
    }
    if (setInputHandler) {
        runner.setInputHandler(INPUT_HANDLER_CLASS);
    } else {
        runner.setInputHandler("");
    }
    runner.setArguments(runnerArgs);
    if (userProperties != null) {
        runner.addUserProperties(userProperties);
    }
    if (propertyFiles != null) {
        runner.setPropertyFiles(propertyFiles);
    }
    if (targets != null) {
        runner.setExecutionTargets(targets);
    }
    if (customClasspath != null) {
        runner.setCustomClasspath(customClasspath);
    }
    if (antHome != null) {
        runner.setAntHome(antHome);
    }
    return runner;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaElement.toStringWithAncestors()java.lang.String;1
public String toStringWithAncestors() {
    return toStringWithAncestors(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleRuleImpl.getSelectorText()java.lang.String;1
@Override
public String getSelectorText() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.OccurrencesSearchResultPage.getDialogSettings()org.eclipse.jface.dialogs.IDialogSettings;1
private IDialogSettings getDialogSettings() {
    return JavaPlugin.getDefault().getDialogSettingsSection("OccurrencesSearchResultPage");
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathLabelProvider.getJarImage()org.eclipse.swt.graphics.Image;1
private Image getJarImage() {
    return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_JAR);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousViewer.attemptPendingUpdates()V1
protected void attemptPendingUpdates() {
    attemptSelection(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.NaiveASTFlattener.visit(org.eclipse.jdt.core.dom.TextElement;)Z2
public boolean visit(TextElement node) {
    this.buffer.append(node.getText());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.jface.text.hyperlink.URLHyperlink.getHyperlinkText()java.lang.String;1
public String getHyperlinkText() {
    return MessageFormat.format(HyperlinkMessages.getString("URLHyperlink.hyperlinkText"), new Object[] { fURLString });
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsTCModel.createElementEqualsConstraints(org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;)V3
public void createElementEqualsConstraints(ConstraintVariable2 cv, ConstraintVariable2 initializerCv) {
    internalCreateElementEqualsConstraints(cv, initializerCv, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.create(org.eclipse.core.resources.IProjectDescription;org.eclipse.core.runtime.IProgressMonitor;)V3
public void create(IProjectDescription description, IProgressMonitor monitor) throws CoreException {
    create(description, IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.MethodDeclaration.memSize()I1
int memSize() {
    return super.memSize() + 13 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.help.internal.search.LocalSearchManager.trimQuery(java.lang.String;)java.lang.String;1
public static String trimQuery(String href) {
    int qloc = href.indexOf('?');
    if (qloc != -1)
        return href.substring(0, qloc);
    return href;
}
---------------Client-------------------
method: org.eclipse.ui.internal.browser.WebBrowserUtil.decodeId(java.lang.String;)java.lang.String;1
public static String decodeId(String encodedId) {
    int sep = encodedId.lastIndexOf(STYLE_SEP);
    if (sep != -1) {
        return encodedId.substring(0, sep);
    }
    return encodedId;
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSSelectorFactory.createCommentSelector(java.lang.String;)org.w3c.css.sac.CharacterDataSelector;2
public CharacterDataSelector createCommentSelector(String data) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createHFillGroup(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Group;3
public static Group createHFillGroup(Composite parent, String text, int margins) {
    return createHFillGroup(parent, text, margins, 1);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.correction.java.FindClassResolutionsOperation$AbstractClassResolutionCollector.addRequireBundleModification(org.eclipse.core.resources.IProject;org.eclipse.osgi.service.resolver.ExportPackageDescription;I)java.lang.Object;4
public Object addRequireBundleModification(IProject project, ExportPackageDescription desc, int relevance) {
    return JavaResolutionFactory.createRequireBundleProposal(project, desc, JavaResolutionFactory.TYPE_JAVA_COMPLETION, relevance);
}

---------------Library-------------------
method: org.eclipse.ui.internal.layout.Row.fixed()org.eclipse.ui.internal.layout.Row;0
public static Row fixed() {
    return new  Row(false);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.refactoring.PDERenameParticipant.updateBuildProperties()Z1
protected boolean updateBuildProperties() {
    return containsElement(false);
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpParser.isComplete()Z1
public boolean isComplete() {
    return isState(STATE_END);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.actions.JavaVariableValueEditor.saveVariable(org.eclipse.debug.core.model.IVariable;java.lang.String;org.eclipse.swt.widgets.Shell;)Z4
public boolean saveVariable(IVariable variable, String expression, Shell shell) {
    if (expression.length() == 1 && variable instanceof IJavaVariable) {
        IJavaVariable javaVariable = (IJavaVariable) variable;
        try {
            if (javaVariable.getJavaType() != null && javaVariable.getJavaType().getSignature() == Signature.SIG_CHAR) {
                javaVariable.setValue(expression);
                return true;
            }
        } catch (DebugException e) {
            JDIDebugUIPlugin.statusDialog(e.getStatus());
        }
    }
    IVariableValueEditor editor = new  JavaObjectValueEditor();
    return editor.saveVariable(variable, expression, shell);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.core.internal.utils.FileUtil.isPrefixOf(org.eclipse.core.runtime.IPath;org.eclipse.core.runtime.IPath;)Z2
public static boolean isPrefixOf(IPath location1, IPath location2) {
    return computeOverlap(location1, location2, false);
}
---------------Client-------------------
method: org.eclipse.team.core.variants.SessionResourceVariantByteStore.deleteBytes(org.eclipse.core.resources.IResource;)Z2
public boolean deleteBytes(IResource resource) throws TeamException {
    return flushBytes(resource, IResource.DEPTH_ZERO);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.osgi.HelloServiceComponentTemplate.updateModel(org.eclipse.core.runtime.IProgressMonitor;)V2
protected void updateModel(IProgressMonitor monitor) {
    setManifestHeader("Service-Component", "OSGI-INF/*.xml");
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.launcher.EquinoxInitializer.initializeTracing(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;)V2
private void initializeTracing(ILaunchConfigurationWorkingCopy configuration) {
    configuration.setAttribute(IPDELauncherConstants.TRACING_CHECKED, IPDELauncherConstants.TRACING_NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderTopWidth(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderTopWidth(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-top-width");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.util.ObjectVector.copyInto(Ajava.lang.Object;)V2
public void copyInto(Object[] targetArray) {
    this.copyInto(targetArray, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xml.type.internal.RegEx$Token.mergeRanges(org.eclipse.emf.ecore.xml.type.internal.RegEx$Token;)V2
protected void mergeRanges(Token tok) {
    throw new  RuntimeException("Not supported.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.product.ProductPlugin.setVersion(java.lang.String;)V2
public void setVersion(String version) {
    String old = fVersion;
    fVersion = version;
    if (isEditable())
        firePropertyChanged("version", old, fVersion);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.product.AboutInfo.setImagePath(java.lang.String;)V2
public void setImagePath(String path) {
    String old = fImagePath;
    fImagePath = path;
    if (isEditable())
        firePropertyChanged(P_IMAGE, old, fImagePath);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.osgi.HelloServiceComponentTemplateWizard.getImportPackages()Ajava.lang.String;1
public String[] getImportPackages() {
    return new String[] { "org.osgi.framework;version=\"1.3.0\"", "org.osgi.util.tracker;version=\"1.3.1\"", "org.eclipse.osgi.framework.console;version=\"1.0.0\"" };
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxySelector.getProviders()Ajava.lang.String;0
public static String[] getProviders() {
    return new String[] { DIRECT_PROVIDER, ECLIPSE_PROVIDER, NATIVE_PROVIDER };
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.BasicEObjectImpl.eGet(org.eclipse.emf.ecore.EStructuralFeature;Z)java.lang.Object;3
public Object eGet(EStructuralFeature eFeature, boolean resolve) {
    return eGet(eFeature, resolve, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.correction.java.FindClassResolutionsOperation$AbstractClassResolutionCollector.addRequireBundleModification(org.eclipse.core.resources.IProject;org.eclipse.osgi.service.resolver.ExportPackageDescription;I)java.lang.Object;4
public Object addRequireBundleModification(IProject project, ExportPackageDescription desc, int relevance) {
    return JavaResolutionFactory.createRequireBundleProposal(project, desc, JavaResolutionFactory.TYPE_JAVA_COMPLETION, relevance);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.VMListener.vmRemoved(org.eclipse.jdt.launching.IVMInstall;)V2
public void vmRemoved(IVMInstall vm) {
    fChanged = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.CombinedWordRule$CharacterBuffer.toString()java.lang.String;1
@Override
public String toString() {
    return new  String(fContent, 0, fLength);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover$InformationControlCreator.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  AnnotationExpansionControl(parent, SWT.NONE, fAnnotationAccess);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.JavaReconcilingStrategy.reconcile(org.eclipse.jface.text.IRegion;)V2
public void reconcile(IRegion partition) {
    reconcile(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.apache.lucene.store.BufferedIndexOutput.flushBuffer(ABI)V3
private void flushBuffer(byte[] b, int len) throws IOException {
    flushBuffer(b, 0, len);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleWarningToken(java.lang.String;Z)V3
protected void handleWarningToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Warning);
}

---------------Library-------------------
method: org.eclipse.ui.internal.contexts.SlaveContextService.activateContext(java.lang.String;org.eclipse.core.expressions.Expression;)org.eclipse.ui.contexts.IContextActivation;3
@Override
public IContextActivation activateContext(String contextId, Expression expression) {
    return activateContext(contextId, expression, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.ds.Reference.isRequiredFor(org.eclipse.equinox.internal.ds.model.ServiceComponent;)Z2
final boolean isRequiredFor(ServiceComponent cd) {
    return cardinalityLow == 1;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.isInfo()Z1
public boolean isInfo() {
    return fSeverity == IStatus.INFO;
}

---------------Library-------------------
method: org.eclipse.compare.CompareEditorInput.setContainer(org.eclipse.compare.ICompareContainer;)V2
public void setContainer(ICompareContainer container) {
    Assert.isNotNull(container);
    this.fContainer = container;
    fContainerProvided = true;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.setInfo(java.lang.String;)V2
public void setInfo(String infoMessage) {
    Assert.isNotNull(infoMessage);
    fStatusMessage = infoMessage;
    fSeverity = IStatus.INFO;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSValueListImpl.setCssText(java.lang.String;)V2
@Override
public void setCssText(String arg0) throws DOMException {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.objectweb.asm.TypeReference.getTypeParameterIndex()I1
public int getTypeParameterIndex() {
    return (value & 0x00FF0000) >> 16;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.problems.ApiProblem.getElementKind()I1
@Override
public int getElementKind() {
    return (fId & ELEMENT_KIND_MASK) >> OFFSET_ELEMENT;
}

---------------Library-------------------
method: org.apache.jasper.runtime.JspWriterImpl.write(ZABLjava.lang.String;)V4
public void write(boolean bytesOK, byte buf[], String str) throws IOException {
    ensureOpen();
    if (bufferSize == 0 && bytesOK) {
        initByteOut();
        if (implementsByteWriter) {
            write(buf, 0, buf.length);
            return;
        }
    }
    write(str);
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.core.internal.events.ResourceDelta.accept(org.eclipse.core.resources.IResourceDeltaVisitor;Z)V3
public void accept(IResourceDeltaVisitor visitor, boolean includePhantoms) throws CoreException {
    accept(visitor, includePhantoms ? IContainer.INCLUDE_PHANTOMS : 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Resource.delete(ZLorg.eclipse.core.runtime.IProgressMonitor;)V3
public void delete(boolean force, IProgressMonitor monitor) throws CoreException {
    delete(force ? IResource.FORCE : IResource.NONE, monitor);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.isOptimized()Z1
@Deprecated
public boolean isOptimized() {
    throw new  UnsupportedOperationException("This reader does not support this method.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.jasper.runtime.JspWriterImpl.hasData()Z1
public boolean hasData() {
    if (bufferSize != 0 && nextChar != 0) {
        return true;
    }
    return false;
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.skipSpaces()I1
protected int skipSpaces() {
    do {
        nextChar();
    } while (current != -1 && XMLUtilities.isXMLSpace((char) current));
    return current;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.visit(org.eclipse.jdt.core.dom.CharacterLiteral;)Z2
@Override
public boolean visit(CharacterLiteral node) {
    this.fBuffer.append(node.getEscapedValue());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.internal.theme.ThemeEngine.setTheme(org.eclipse.e4.ui.css.swt.theme.ITheme;Z)V3
@Override
public void setTheme(ITheme theme, boolean restore) {
    setTheme(theme, restore, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleWarningToken(java.lang.String;Z)V3
protected void handleWarningToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Warning);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceType.getTypeQualifiedName(C)java.lang.String;2
public String getTypeQualifiedName(char enclosingTypeSeparator) {
    try {
        return getTypeQualifiedName(enclosingTypeSeparator, false);
    } catch (JavaModelException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.nls.InternationalizeWizardLocalePage.modelsChanged(org.eclipse.pde.core.IModelProviderEvent;)V2
public void modelsChanged(IModelProviderEvent event) {
    fRefreshNeeded = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.ObjectMap.isEmpty()Z1
@Override
public boolean isEmpty() {
    return count == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.ui.internal.keys.model.ConflictModel.updateConflictsFor(org.eclipse.ui.internal.keys.model.BindingElement;org.eclipse.ui.internal.keys.model.BindingElement;)V3
public void updateConflictsFor(BindingElement oldValue, BindingElement newValue) {
    updateConflictsFor(oldValue, newValue, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.create(org.eclipse.core.resources.IProjectDescription;org.eclipse.core.runtime.IProgressMonitor;)V3
public void create(IProjectDescription description, IProgressMonitor monitor) throws CoreException {
    create(description, IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousViewer.setSelection(org.eclipse.jface.viewers.ISelection;Z)V3
@Override
public synchronized void setSelection(ISelection selection, boolean reveal) {
    setSelection(selection, reveal, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleWarningToken(java.lang.String;Z)V3
protected void handleWarningToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Warning);
}

---------------Library-------------------
method: org.eclipse.jface.util.Util.assertInstance(java.lang.Object;java.lang.Class;)V2
public static final void assertInstance(final Object object, final Class<?> c) {
    assertInstance(object, c, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.getQueryExceptionMessage()java.lang.String;1
public String getQueryExceptionMessage() {
    if (queryException == null) {
        return null;
    }
    return ServletResources.getString("searchTooComplex", request);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.apt.model.Factory.getModifiers(ILjavax.lang.model.element.ElementKind;)java.util.Set;2
public static Set<Modifier> getModifiers(int modifiers, ElementKind kind) {
    return getModifiers(modifiers, kind, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceImpl.getAllProperContents(org.eclipse.emf.ecore.EObject;)org.eclipse.emf.common.util.TreeIterator;2
protected TreeIterator<EObject> getAllProperContents(EObject eObject) {
    return EcoreUtil.getAllProperContents(eObject, false);
}
---------------Client-------------------
method: org.eclipse.ui.trace.internal.providers.TracingComponentLabelProvider.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(final Object element) {
    return TracingComponentLabelProvider.getLabel(TracingConstants.LABEL_COLUMN_INDEX, element);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.builders.DSMarkerFactory.createMarker(org.eclipse.core.resources.IFile;ILjava.lang.String;)org.eclipse.core.resources.IMarker;4
public IMarker createMarker(IFile file, int id, String category) throws CoreException {
    IMarker marker = file.createMarker(MARKER_ID);
    marker.setAttribute("id", id);
    marker.setAttribute("categoryId", category);
    return marker;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.PDEMarkerFactory.createMarker(org.eclipse.core.resources.IFile;ILjava.lang.String;)org.eclipse.core.resources.IMarker;4
public IMarker createMarker(IFile file, int id, String category) throws CoreException {
    IMarker marker = file.createMarker(MARKER_ID);
    marker.setAttribute(PROBLEM_ID, id);
    marker.setAttribute(CAT_ID, category);
    return marker;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.actions.CleanupzipAction.execute(java.util.Map;)org.eclipse.core.runtime.IStatus;2
public IStatus execute(Map<String, Object> parameters) {
    return cleanupzip(parameters, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtWildcardStart()Z1
boolean isAtWildcardStart() {
    return this.index < this.source.length && this.source[this.index] == '{';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.hasProblems()Z1
public boolean hasProblems() {
    return this.problemCount != 0;
}
---------------Client-------------------
method: org.eclipse.jetty.http.AbstractGenerator.isCommitted()Z1
public boolean isCommitted() {
    return _state != STATE_HEADER;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.AssertStatement.memSize()I1
int memSize() {
    return super.memSize() + 2 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginObjectNode.appendAttribute(java.lang.StringBuffer;java.lang.String;)V3
protected void appendAttribute(StringBuffer buffer, String attrName) {
    appendAttribute(buffer, attrName, "");
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.deprecatedType(org.eclipse.jdt.internal.compiler.lookup.TypeBinding;org.eclipse.jdt.internal.compiler.ast.ASTNode;)V3
public void deprecatedType(TypeBinding type, ASTNode location) {
    deprecatedType(type, location, Integer.MAX_VALUE);
}

---------------Library-------------------
method: org.eclipse.jetty.util.security.Credential$Crypt.crypt(java.lang.String;java.lang.String;)java.lang.String;2
public static String crypt(String user, String pw) {
    return "CRYPT:" + UnixCrypt.crypt(pw, user);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository.getActualLocation(java.net.URI;java.lang.String;)java.net.URI;2
private static URI getActualLocation(URI base, String extension) {
    return URIUtil.append(base, CONTENT_FILENAME + extension);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.WebappPreferences.setHighlightDefault(Z)V2
public void setHighlightDefault(boolean highlight) {
    setBooleanPreference("default_highlight", highlight);
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.util.AptConfig.setProcessDuringReconcile(org.eclipse.jdt.core.IJavaProject;Z)V2
public static void setProcessDuringReconcile(IJavaProject jproject, boolean enabled) {
    setBoolean(jproject, AptPreferenceConstants.APT_RECONCILEENABLED, enabled);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.JDIModelPresentation.getJavaPatternBreakpointText(IJavaPatternBreakpoint;)java.lang.String;2
protected String getJavaPatternBreakpointText(@SuppressWarnings("deprecation") IJavaPatternBreakpoint breakpoint) throws CoreException {
    IResource resource = breakpoint.getMarker().getResource();
    IMember member = BreakpointUtils.getMember(breakpoint);
    StringBuffer label = new  StringBuffer(resource.getName());
    appendLineNumber(breakpoint, label);
    appendHitCount(breakpoint, label);
    appendSuspendPolicy(breakpoint, label);
    appendThreadFilter(breakpoint, label);
    if (member != null) {
        label.append(" - ");
        label.append(getJavaLabelProvider().getText(member));
    }
    return label.toString();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.apache.jasper.runtime.BodyContentImpl.setWriter(java.io.Writer;)V2
void setWriter(Writer writer) {
    this.writer = writer;
    if (writer != null) {
        if (bufferSize != 0) {
            bufferSizeSave = bufferSize;
            bufferSize = 0;
        }
    } else {
        bufferSize = bufferSizeSave;
        clearBody();
    }
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.validation.ValidatedObservableMap.makeStale()V1
private void makeStale() {
    if (!stale) {
        stale = true;
        fireStale();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.change.impl.FeatureChangeImpl.apply(org.eclipse.emf.ecore.EObject;)V2
public void apply(EObject originalObject) {
    apply(originalObject, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.TableComparator.getTopPriority()I1
public int getTopPriority() {
    return priorities[0];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckInitialConditionsTicks()I1
public int getCheckInitialConditionsTicks() {
    return fValues[CHECK_INITIAL_CONDITIONS];
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.JavaSearchDocument.toString()java.lang.String;1
public String toString() {
    return "SearchDocument for " + getPath();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.ToolbarButton.isMenu()Z1
public boolean isMenu() {
    return "menu".equals(action);
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.hasRootProjectElement()Z1
protected boolean hasRootProjectElement() {
    return PROJECT.equals(fTopElementFound);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.NameConventionConfigurationBlock$NameConventionLabelProvider.getImage(java.lang.Object;)org.eclipse.swt.graphics.Image;2
@Override
public Image getImage(Object element) {
    return getColumnImage(element, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.model.TypeStructureBuilder$AnnotationDefaultVisitor.visitArray(java.lang.String;)org.objectweb.asm.AnnotationVisitor;2
@Override
public AnnotationVisitor visitArray(String name) {
    trace = true;
    return this;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.builder.ReferenceExtractor$ClassFileSignatureVisitor.visitSuperclass()org.objectweb.asm.signature.SignatureVisitor;1
@Override
public SignatureVisitor visitSuperclass() {
    this.kind = IReference.REF_EXTENDS;
    return this;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment.createBinaryTypeFrom(org.eclipse.jdt.internal.compiler.env.IBinaryType;org.eclipse.jdt.internal.compiler.lookup.PackageBinding;org.eclipse.jdt.internal.compiler.env.AccessRestriction;)org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;4
public BinaryTypeBinding createBinaryTypeFrom(IBinaryType binaryType, PackageBinding packageBinding, AccessRestriction accessRestriction) {
    return createBinaryTypeFrom(binaryType, packageBinding, true, accessRestriction);
}
---------------Client-------------------
method: org.eclipse.ui.internal.operations.AdvancedValidationUserApprover.proceedExecuting(org.eclipse.core.commands.operations.IUndoableOperation;org.eclipse.core.commands.operations.IOperationHistory;org.eclipse.core.runtime.IAdaptable;)org.eclipse.core.runtime.IStatus;4
@Override
public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable uiInfo) {
    return proceedWithOperation(operation, history, uiInfo, EXECUTING);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.frameworkadmin.utils.Utils.getTokens(java.lang.String;java.lang.String;)Ajava.lang.String;2
public static String[] getTokens(String msg, String delim) {
    return getTokens(msg, delim, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.filesystem.FileSystemSupportRegistry.hasOneFileSystem()Z1
public boolean hasOneFileSystem() {
    return registeredContributions.size() == 0;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$StatusWrapper.isOK()Z1
public boolean isOK() {
    return diagnostic.getSeverity() == OK;
}

---------------Library-------------------
method: org.eclipse.jface.text.source.AnnotationModel$1.documentChanged(org.eclipse.jface.text.DocumentEvent;)V2
public void documentChanged(DocumentEvent event) {
    fDocumentChanged = true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.OccurrencesSearchResultPage.configureTreeViewer(org.eclipse.jface.viewers.TreeViewer;)V2
@Override
protected void configureTreeViewer(TreeViewer viewer) {
    throw new  IllegalStateException("Doesn't support tree mode.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jface.viewers.deferred.IntHashMap.get(java.lang.Object;)I2
public int get(Object key) {
    return get(key, 0);
}
---------------Client-------------------
method: org.eclipse.team.core.variants.SessionResourceVariantByteStore.deleteBytes(org.eclipse.core.resources.IResource;)Z2
public boolean deleteBytes(IResource resource) throws TeamException {
    return flushBytes(resource, IResource.DEPTH_ZERO);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.search.NLSSearchResultPage.configureTreeViewer(org.eclipse.jface.viewers.TreeViewer;)V2
@Override
protected void configureTreeViewer(TreeViewer viewer) {
    throw new  IllegalStateException("Doesn't support tree mode.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.CompCSEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeReferenceType()V1
protected void consumeReferenceType() {
    pushOnIntStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.ListSelectionArea$3.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    listViewer.setAllChecked(false);
}
---------------Client-------------------
method: org.eclipse.ui.internal.forms.widgets.FormHeading$5.mouseExit(org.eclipse.swt.events.MouseEvent;)V2
public void mouseExit(MouseEvent e) {
    titleRegion.setHoverState(TitleRegion.STATE_NORMAL);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.launcher.JUnitRuntimeClasspathEntry.developmentModeEntry()org.eclipse.jdt.internal.junit.launcher.JUnitRuntimeClasspathEntry;1
public JUnitRuntimeClasspathEntry developmentModeEntry() {
    return new  JUnitRuntimeClasspathEntry(getPluginId(), "bin");
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.plugin.WorkspaceExtensionsModel.createNLResourceHelper()org.eclipse.pde.internal.core.NLResourceHelper;1
protected NLResourceHelper createNLResourceHelper() {
    return new  NLResourceHelper(Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME, getNLLookupLocations());
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.MarkerUpdateJob.setClean()V1
void setClean() {
    this.clean = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.model.AntPropertyNode.computeIdentifierOffsets(java.lang.String;)java.util.List;2
@Override
public List<Integer> computeIdentifierOffsets(String identifier) {
    if (!getTask().getTaskName().equals("property")) {
        return super.computeIdentifierOffsets(identifier);
    }
    String textToSearch = getAntModel().getText(getOffset(), getLength());
    if (textToSearch == null || textToSearch.length() == 0 || identifier.length() == 0) {
        return null;
    }
    List<Integer> results = new  ArrayList<Integer>();
    if (fBaseLabel != null) {
        if (fBaseLabel.equals(identifier)) {
            int nameOffset = textToSearch.indexOf(IAntCoreConstants.NAME);
            nameOffset = textToSearch.indexOf(identifier, nameOffset + 1);
            results.add(new  Integer(getOffset() + nameOffset));
        }
    }
    if (fValue != null) {
        int valueOffset = textToSearch.indexOf(fOccurrencesStartingPoint);
        int endOffset = getOffset() + getLength();
        while (valueOffset < endOffset) {
            valueOffset = textToSearch.indexOf(identifier, valueOffset);
            if (valueOffset == -1 || valueOffset > endOffset) {
                break;
            }
            results.add(new  Integer(getOffset() + valueOffset));
            valueOffset += identifier.length();
        }
    }
    return results;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.ui.internal.PluginActionBuilder.getTargetID(org.eclipse.core.runtime.IConfigurationElement;)java.lang.String;2
protected String getTargetID(IConfigurationElement element) {
    String value = element.getAttribute(IWorkbenchRegistryConstants.ATT_TARGET_ID);
    return value != null ? value : "???";
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.bundle.Bundle.getLocalization()java.lang.String;1
public String getLocalization() {
    String localization = getHeader(Constants.BUNDLE_LOCALIZATION);
    return localization != null ? localization : Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyForInitopt()V1
protected void consumeEmptyForInitopt() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceFieldElementInfo.getTypeSignature()java.lang.String;1
protected String getTypeSignature() {
    return Signature.createTypeSignature(this.typeName, false);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathPage.getAntHomeEntries()Aorg.eclipse.ant.core.IAntClasspathEntry;1
protected IAntClasspathEntry[] getAntHomeEntries() {
    return fModel.getEntries(ClasspathModel.ANT_HOME);
}

---------------Library-------------------
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createText(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Text;1
public static Text createText(Composite parent) {
    return createText(parent, 1);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.VariableDeclarationStatement.memSize()I1
int memSize() {
    return super.memSize() + 4 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.ModelUndoManager.isUndoable()Z1
public boolean isUndoable() {
    return cursor >= 0;
}
---------------Client-------------------
method: org.eclipse.jetty.util.security.Constraint.hasDataConstraint()Z1
public boolean hasDataConstraint() {
    return _dataConstraint >= DC_NONE;
}

---------------Library-------------------
method: org.apache.lucene.index.DirectoryReader$ReaderCommit.delete()V1
@Override
public void delete() {
    throw new  UnsupportedOperationException("This IndexCommit does not support deletions");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.jasper.xmlparser.XMLChar.isMarkup(I)Z1
public static boolean isMarkup(int c) {
    return c == '<' || c == '&' || c == '%';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.PasteAction$TypedSourcePaster$PasteTypedSourcesRefactoring.canPasteToCu(I)Z1
private static boolean canPasteToCu(int elementType) {
    return elementType == IJavaElement.PACKAGE_DECLARATION || elementType == IJavaElement.TYPE || elementType == IJavaElement.IMPORT_DECLARATION;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.IntroduceIndirectionRefactoring.adjustVisibility(org.eclipse.jdt.core.IMember;org.eclipse.jdt.core.dom.Modifier$ModifierKeyword;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.ltk.core.refactoring.RefactoringStatus;4
private RefactoringStatus adjustVisibility(IMember whoToAdjust, ModifierKeyword neededVisibility, IProgressMonitor monitor) throws CoreException {
    return adjustVisibility(whoToAdjust, neededVisibility, false, monitor);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.createImport(java.lang.String;org.eclipse.jdt.core.IJavaElement;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IImportDeclaration;4
public IImportDeclaration createImport(String importName, IJavaElement sibling, IProgressMonitor monitor) throws JavaModelException {
    return createImport(importName, sibling, Flags.AccDefault, monitor);
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.ComputedSet.makeStale()V1
private void makeStale() {
    if (!stale) {
        stale = true;
        fireStale();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.callhierarchy.CallHierarchy.getCallerRoots(Aorg.eclipse.jdt.core.IMember;)Aorg.eclipse.jdt.internal.corext.callhierarchy.MethodWrapper;2
public MethodWrapper[] getCallerRoots(IMember[] members) {
    return getRoots(members, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.apache.jasper.runtime.BodyContentImpl.main(Ajava.lang.String;)V1
public static void main(String[] args) throws Exception {
    char[] buff = { 'f', 'o', 'o', 'b', 'a', 'r', 'b', 'a', 'z', 'y' };
    BodyContentImpl bodyContent = new  BodyContentImpl(new  JspWriterImpl(null, 100, false));
    bodyContent.println(buff);
    System.out.println(bodyContent.getString());
    bodyContent.writeOut(new  PrintWriter(System.out));
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.skipSpaces()I1
protected int skipSpaces() {
    do {
        nextChar();
    } while (current != -1 && XMLUtilities.isXMLSpace((char) current));
    return current;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.SynchronizeModelUpdateHandler.processEvent(org.eclipse.team.internal.core.BackgroundEventHandler$Event;org.eclipse.core.runtime.IProgressMonitor;)V3
protected void processEvent(Event event, IProgressMonitor monitor) throws CoreException {
    switch(event.getType()) {
        case BackgroundEventHandler.RUNNABLE_EVENT:
            executeRunnable(event, monitor);
            break;
        case MARKERS_CHANGED:
            long start = System.currentTimeMillis();
            ISynchronizeModelElement[] elements = getChangedElements(event);
            for (int i = 0; i < elements.length; i++) {
                ISynchronizeModelElement element = elements[i];
                propagateProblemMarkers(element);
                updateParentLabels(element);
            }
            if (DEBUG) {
                long time = System.currentTimeMillis() - start;
                DateFormat TIME_FORMAT = new  SimpleDateFormat("m:ss.SSS");
                String took = TIME_FORMAT.format(new  Date(time));
                System.out.println(took + " for " + elements.length + " files");
            }
            break;
        case BUSY_STATE_CHANGED:
            BusyStateChangeEvent e = (BusyStateChangeEvent) event;
            queueForLabelUpdate(e.getElement());
            if (e.isBusy()) {
                dispatchEarly = true;
            }
            break;
        case RESET:
            pendingLabelUpdates.clear();
            provider.reset();
            break;
        case SYNC_INFO_SET_CHANGED:
            handleChanges(((SyncInfoSetChangeEvent) event).getEvent(), monitor);
        default:
            break;
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyClassificationHandler.applyCSSPropertyPosition(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyPosition(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("position");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.CTabItemElement.computeStaticPseudoInstances()V1
@Override
protected void computeStaticPseudoInstances() {
    super.computeStaticPseudoInstances();
    super.addStaticPseudoInstance("selected");
}
---------------Client-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSSourcePage.initializeEditor()V1
protected void initializeEditor() {
    super.initializeEditor();
    setHelpContextId(IHelpContextIds.SIMPLE_CS_EDITOR);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.schema.Schema.processDeprecated(java.lang.String;)Z2
private boolean processDeprecated(String value) {
    return value != null && "true".equals(value);
}
---------------Client-------------------
method: org.eclipse.e4.ui.internal.workbench.URIHelper.isPlatformURI(java.lang.String;)Z1
public static boolean isPlatformURI(String uri) {
    return uri != null && uri.startsWith(PLATFORM_SCHEMA);
}

---------------Library-------------------
method: org.eclipse.help.internal.browser.BrowserManager.createBrowser()org.eclipse.help.browser.IBrowser;1
public IBrowser createBrowser() {
    return createBrowser(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.ui.views.tasklist.TaskSorter.getTopPriority()I1
public int getTopPriority() {
    return priorities[0];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckInitialConditionsTicks()I1
public int getCheckInitialConditionsTicks() {
    return fValues[CHECK_INITIAL_CONDITIONS];
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaModelManager.getVariableAndContainersFile()java.io.File;1
private File getVariableAndContainersFile() {
    return JavaCore.getPlugin().getStateLocation().append("variablesAndContainers.dat").toFile();
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.FactoryPathUtil.getFileForWorkspace()java.io.File;0
private static File getFileForWorkspace() {
    return AptPlugin.getPlugin().getStateLocation().append(FACTORYPATH_FILE).toFile();
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSElementSelector.toString()java.lang.String;1
public String toString() {
    String name = getLocalName();
    if (name == null) {
        return "*";
    }
    return name;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.build.BuildEditor.computeInitialPageId()java.lang.String;1
@Override
protected String computeInitialPageId() {
    String firstPageId = super.computeInitialPageId();
    if (firstPageId == null) {
        return BuildPage.PAGE_ID;
    }
    return firstPageId;
}

---------------Library-------------------
method: org.eclipse.ui.editors.text.DefaultEncodingSupport.setEncoding(java.lang.String;)V2
public void setEncoding(String encoding) {
    setEncoding(encoding, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.rows.ExtensionAttributeRow.isDeprecated()Z1
protected boolean isDeprecated() {
    if (att instanceof ISchemaAttribute)
        return ((ISchemaAttribute) att).isDeprecated();
    return false;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.rows.ExtensionAttributeRow.getUse()I1
protected int getUse() {
    if (att instanceof ISchemaAttribute)
        return ((ISchemaAttribute) att).getUse();
    return ISchemaAttribute.OPTIONAL;
}

---------------Library-------------------
method: org.eclipse.core.internal.dtree.NodeComparison.isUnchanged()Z1
boolean isUnchanged() {
    return userInt == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart.selectNextFailure()V1
public void selectNextFailure() {
    fTestViewer.selectFailure(true);
}
---------------Client-------------------
method: org.eclipse.jface.text.link.LinkedModeUI$Closer.inputDocumentAboutToBeChanged(org.eclipse.jface.text.IDocument;org.eclipse.jface.text.IDocument;)V3
public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
    leave(ILinkedModeListener.EXIT_ALL);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.dialogs.AvailableIUsPage$5.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event event) {
    setAllChecked(false);
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.ui.FileSelectionDialog$4.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
@Override
public void doubleClick(DoubleClickEvent event) {
    buttonPressed(IDialogConstants.OK_ID);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyFontHandler.applyCSSPropertyFontVariant(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyFontVariant(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("font-variant");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginObjectNode.toString()java.lang.String;1
public String toString() {
    return write(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextArrayDimension()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextArrayDimension() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_ARRAY_DIMENSION);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMNode.getEndPosition()I1
public int getEndPosition() {
    return this.fSourceRange[1];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckFinalConditionsTicks()I1
public int getCheckFinalConditionsTicks() {
    return fValues[CHECK_FINAL_CONDITIONS];
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.model.AbstractIntroPage.injectSharedStyle()Z1
public boolean injectSharedStyle() {
    return this.sharedStyle.equals("true") ? true : false;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.formatter.FormattingPreferences.useSpacesInsteadOfTabs()Z1
public boolean useSpacesInsteadOfTabs() {
    return !fPrefs.getBoolean(AntEditorPreferenceConstants.FORMATTER_TAB_CHAR);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.ToolbarData.loadButtons()V1
private void loadButtons() {
    String[] names = request.getParameterValues("name");
    String[] tooltips = request.getParameterValues("tooltip");
    String[] images = request.getParameterValues("image");
    String[] actions = request.getParameterValues("action");
    String[] params = request.getParameterValues("param");
    String[] states = request.getParameterValues("state");
    if (names == null || tooltips == null || images == null || actions == null || params == null || states == null || names.length != tooltips.length || names.length != images.length || names.length != actions.length || names.length != params.length || names.length != states.length) {
        buttons = new ToolbarButton[0];
        scriptFiles = new String[0];
        return;
    }
    List buttonList = new  ArrayList();
    for (int i = 0; i < names.length; i++) {
        if ("".equals(names[i]))
            buttonList.add(new  ToolbarButton());
        else {
            Matcher matcher = jsNamePattern.matcher(names[i]);
            if (matcher.matches())
                buttonList.add(new  ToolbarButton(names[i], ServletResources.getString(tooltips[i], request), preferences.getImagesDirectory() + "/e_" + images[i], actions[i], params[i], states[i]));
        }
    }
    addExtensionButtons(buttonList);
    if (isIE() || isMozilla() && "1.2.1".compareTo(getMozillaVersion()) <= 0 || (isSafari() && "120".compareTo(getSafariVersion()) <= 0)) {
        buttonList.add(new  ToolbarButton("maximize_restore", getMaximizeTooltip(), preferences.getImagesDirectory() + "/" + "maximize.gif", "restore_maximize", null, "off"));
    }
    buttons = (ToolbarButton[]) buttonList.toArray(new ToolbarButton[buttonList.size()]);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.core.runtime.Status.setMessage(java.lang.String;)V2
protected void setMessage(String message) {
    if (message == null)
        this.message = "";
    else
        this.message = message;
}
---------------Client-------------------
method: org.eclipse.ant.core.AntRunner.setBuildFileLocation(java.lang.String;)V2
public void setBuildFileLocation(String buildFileLocation) {
    if (buildFileLocation == null) {
        this.buildFileLocation = IAntCoreConstants.DEFAULT_BUILD_FILENAME;
    } else {
        this.buildFileLocation = buildFileLocation;
    }
}

---------------Library-------------------
method: org.eclipse.swt.browser.WebKit.isBackEnabled()Z1
@Override
public boolean isBackEnabled() {
    return WebKitGTK.webkit_web_view_can_go_back(webView) != 0;
}
---------------Client-------------------
method: org.eclipse.core.internal.events.BuildManager.isAutobuildBuildPending()Z1
public boolean isAutobuildBuildPending() {
    return autoBuildJob.getState() != Job.NONE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceType.getFullyQualifiedName(C)java.lang.String;2
public String getFullyQualifiedName(char enclosingTypeSeparator) {
    try {
        return getFullyQualifiedName(enclosingTypeSeparator, false);
    } catch (JavaModelException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.eclipse.jface.fieldassist.ContentProposalAdapter.openProposalPopup()V1
protected void openProposalPopup() {
    openProposalPopup(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCSPerformWhen.addExecutable(org.eclipse.pde.internal.ua.core.cheatsheet.simple.ISimpleCSRunObject;)V2
public void addExecutable(ISimpleCSRunObject executable) {
    addChildNode((IDocumentElementNode) executable, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.ui.model.WorkbenchLabelProvider.getForeground(java.lang.Object;)org.eclipse.swt.graphics.Color;2
@Override
public Color getForeground(Object element) {
    return getColor(element, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.ui.forms.widgets.ScrolledPageBook.removePage(java.lang.Object;)V2
public void removePage(Object key) {
    removePage(key, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.apache.jasper.compiler.Compiler.isOutDated()Z1
public boolean isOutDated() {
    return isOutDated(true);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.SimpleLog.isTraceEnabled()Z1
public final boolean isTraceEnabled() {
    return isLevelEnabled(SimpleLog.LOG_LEVEL_TRACE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeFormalParameterListopt()V1
protected void consumeFormalParameterListopt() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.TypeDeclaration.memSize()I1
int memSize() {
    return super.memSize() + 6 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSDocumentHandlerImpl.startMedia(org.w3c.css.sac.SACMediaList;)V2
@Override
public void startMedia(SACMediaList media) throws CSSException {
    ignore = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringStatusViewer$PreviousProblem.run()V1
public void run() {
    revealElement(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.extensions.RegistryReader.getDescription(org.eclipse.core.runtime.IConfigurationElement;)java.lang.String;2
protected String getDescription(IConfigurationElement config) {
    IConfigurationElement[] children = config.getChildren(TAG_DESCRIPTION);
    if (children.length >= 1) {
        return children[0].getValue();
    }
    return "";
}
---------------Client-------------------
method: org.eclipse.ui.internal.cheatsheets.registry.RegistryReader.getDescription(org.eclipse.core.runtime.IConfigurationElement;)java.lang.String;2
String getDescription(IConfigurationElement config) {
    IConfigurationElement[] children = config.getChildren(TAG_DESCRIPTION);
    if (children.length >= 1) {
        return children[0].getValue();
    }
    return ICheatSheetResource.EMPTY_STRING;
}

---------------Library-------------------
method: org.eclipse.ui.menus.MenuUtil.menuAddition(java.lang.String;)java.lang.String;1
public static String menuAddition(String id) {
    return menuAddition(id, "after", "additions");
}
---------------Client-------------------
method: org.eclipse.jdt.core.JavaConventions.validateClassFileName(java.lang.String;)org.eclipse.core.runtime.IStatus;1
public static IStatus validateClassFileName(String name) {
    return validateClassFileName(name, CompilerOptions.VERSION_1_3, CompilerOptions.VERSION_1_3);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicExtendedMetaData$EClassExtendedMetaDataImpl.setMemberTypes(java.util.List;)V2
public void setMemberTypes(List<EDataType> memberTypes) {
    throw new  UnsupportedOperationException("Can't set the member types of an EClass");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.AntSourceViewerInformationControl$1.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
@Override
public void keyPressed(KeyEvent e) {
    if (e.character == 0x1B)
        fShell.dispose();
}
---------------Client-------------------
method: org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter$LinkListInformationControl$5.keyTraversed(org.eclipse.swt.events.TraverseEvent;)V2
public void keyTraversed(TraverseEvent e) {
    if (e.keyCode == SWT.ESC) {
        fManager.hideInformationControl();
    }
}

---------------Library-------------------
method: org.apache.lucene.search.FieldCacheImpl.getFloats(org.apache.lucene.index.IndexReader;java.lang.String;org.apache.lucene.search.FieldCache$FloatParser;)AF4
public float[] getFloats(IndexReader reader, String field, FloatParser parser) throws IOException {
    return getFloats(reader, field, parser, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.createImport(java.lang.String;org.eclipse.jdt.core.IJavaElement;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IImportDeclaration;4
public IImportDeclaration createImport(String importName, IJavaElement sibling, IProgressMonitor monitor) throws JavaModelException {
    return createImport(importName, sibling, Flags.AccDefault, monitor);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.extension.PointSelectionPage$PointLabelProvider.getImage(java.lang.Object;)org.eclipse.swt.graphics.Image;2
public Image getImage(Object obj) {
    return getColumnImage(obj, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.pde.launching.EquinoxLaunchConfiguration.saveConfigurationFile(org.eclipse.debug.core.ILaunchConfiguration;)V2
private void saveConfigurationFile(ILaunchConfiguration configuration) throws CoreException {
    Properties properties = new  Properties();
    properties.setProperty("osgi.install.area", "file:" + TargetPlatform.getLocation());
    properties.setProperty("osgi.configuration.cascaded", "false");
    properties.put("osgi.framework", LaunchConfigurationHelper.getBundleURL(IPDEBuildConstants.BUNDLE_OSGI, fAllBundles, false));
    int start = configuration.getAttribute(IPDELauncherConstants.DEFAULT_START_LEVEL, 4);
    properties.put("osgi.bundles.defaultStartLevel", Integer.toString(start));
    boolean autostart = configuration.getAttribute(IPDELauncherConstants.DEFAULT_AUTO_START, true);
    String bundles = null;
    if (fAllBundles.containsKey(IPDEBuildConstants.BUNDLE_SIMPLE_CONFIGURATOR)) {
        IPluginModelBase updateConfiguratorBundle = fAllBundles.get(IPDEBuildConstants.BUNDLE_UPDATE_CONFIGURATOR);
        if (updateConfiguratorBundle != null) {
            String startLevel = fModels.get(updateConfiguratorBundle);
            if (startLevel != null && startLevel.equals(BundleLauncherHelper.DEFAULT_UPDATE_CONFIGURATOR_START_LEVEL)) {
                fModels.put(updateConfiguratorBundle, "4:false");
            }
        }
        URL bundlesTxt = P2Utils.writeBundlesTxt(fModels, start, autostart, getConfigDir(configuration), null);
        if (bundlesTxt != null) {
            properties.setProperty("org.eclipse.equinox.simpleconfigurator.configUrl", bundlesTxt.toString());
            if (fAllBundles.get(IPDEBuildConstants.BUNDLE_UPDATE_CONFIGURATOR) != null) {
                properties.setProperty("org.eclipse.update.reconcile", "false");
            }
        }
        StringBuffer buffer = new  StringBuffer();
        IPluginModelBase model = fAllBundles.get(IPDEBuildConstants.BUNDLE_SIMPLE_CONFIGURATOR);
        buffer.append(LaunchConfigurationHelper.getBundleURL(model, true));
        appendStartData(buffer, fModels.get(model), autostart);
        bundles = buffer.toString();
    } else {
        bundles = getBundles(autostart);
    }
    if (bundles.length() > 0)
        properties.put("osgi.bundles", bundles);
    if (!"3.3".equals(configuration.getAttribute(IPDEConstants.LAUNCHER_PDE_VERSION, ""))) {
        properties.put("eclipse.ignoreApp", "true");
        properties.put("osgi.noShutdown", "true");
    }
    LaunchConfigurationHelper.save(new  File(getConfigDir(configuration), "config.ini"), properties);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.OmniVersion.getMajor()I1
public int getMajor() {
    return getIntElement(0);
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpParser.isComplete()Z1
public boolean isComplete() {
    return isState(STATE_END);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction$5.getDialogBoundsSettings()org.eclipse.jface.dialogs.IDialogSettings;1
@Override
protected IDialogSettings getDialogBoundsSettings() {
    IDialogSettings settings = JDIDebugUIPlugin.getDefault().getDialogSettings();
    return DialogSettings.getOrCreateSection(settings, "OpenFromClipboardAction_dialogBounds");
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.launcher.OSGiFrameworkManager.getDefaultFramework()java.lang.String;1
public String getDefaultFramework() {
    PDEPreferencesManager store = PDELaunchingPlugin.getDefault().getPreferenceManager();
    return store.getString(ILaunchingPreferenceConstants.DEFAULT_OSGI_FRAMEOWRK);
}

---------------Library-------------------
method: org.eclipse.osgi.framework.eventmgr.CopyOnWriteIdentityMap.isEmpty()Z1
public boolean isEmpty() {
    return size() == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaModelStatus.isOK()Z1
public boolean isOK() {
    return getCode() == OK;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.ContentAssistProcessor.clearState()V1
private void clearState() {
    fErrorMessage = null;
    fNumberOfComputedResults = 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.setOK()V1
public void setOK() {
    fStatusMessage = null;
    fSeverity = IStatus.OK;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.JavaDetailFormattersManager$Key.hashCode()I1
@Override
public int hashCode() {
    return fTypeName.hashCode() / 2 + fDebugTarget.hashCode() / 2;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.conversion.DateConversionSupport.parse(java.lang.String;)java.util.Date;2
protected Date parse(String str) {
    for (int formatterIdx = 0; formatterIdx < formatters.length; formatterIdx++) {
        Date parsed = parse(str, formatterIdx);
        if (parsed != null) {
            return parsed;
        }
    }
    return null;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.DocumentObject.reset()V1
public void reset() {
    fModel = null;
    fInTheModel = false;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.setOK()V1
public void setOK() {
    fStatusMessage = null;
    fSeverity = IStatus.OK;
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.PrintData.getTopic()org.eclipse.help.ITopic;1
private ITopic getTopic() {
    String topicParam = request.getParameter("topic");
    String anchorParam = request.getParameter("anchor");
    if (anchorParam != null) {
        topicParam = topicParam + '#' + anchorParam;
    }
    if (topicParam != null && topicParam.length() > 0) {
        if (topicParam.startsWith("/../nav/")) {
            String navPath = topicParam.substring(8);
            StringTokenizer tok = new  StringTokenizer(navPath, "_");
            int index = Integer.parseInt(tok.nextToken());
            ITopic topic = HelpPlugin.getTocManager().getTocs(getLocale())[index].getTopic(null);
            while (tok.hasMoreTokens()) {
                index = Integer.parseInt(tok.nextToken());
                topic = topic.getSubtopics()[index];
            }
            return topic;
        } else {
            IToc[] tocs = HelpPlugin.getTocManager().getTocs(getLocale());
            for (int i = 0; i < tocs.length; ++i) {
                ITopic topic = tocs[i].getTopic(topicParam);
                if (topic != null) {
                    return topic;
                }
                topic = tocs[i].getTopic(null);
                if (topicParam.equals(topic.getHref())) {
                    return topic;
                }
            }
        }
        return null;
    }
    return getToc().getTopic(null);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.WorkingSetData.getDefaultName()java.lang.String;1
public String getDefaultName() {
    for (int i = 1; i < 100; i++) {
        String name = ServletResources.getString("DefaultScopeName", request) + i;
        if (wsmgr.getWorkingSet(name) == null) {
            return name;
        }
    }
    return "";
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.environments.Analyzer.getDelegate()org.eclipse.jdt.launching.environments.IExecutionEnvironmentAnalyzerDelegate;1
private IExecutionEnvironmentAnalyzerDelegate getDelegate() throws CoreException {
    if (fDelegate == null) {
        fDelegate = (IExecutionEnvironmentAnalyzerDelegate) fElement.createExecutableExtension("class");
    }
    return fDelegate;
}
---------------Client-------------------
method: org.eclipse.debug.internal.core.BreakpointImportParticipantDelegate.getDelegate()org.eclipse.debug.core.model.IBreakpointImportParticipant;1
public IBreakpointImportParticipant getDelegate() throws CoreException {
    if (fParticipant == null) {
        fParticipant = (IBreakpointImportParticipant) fElement.createExecutableExtension(IConfigurationElementConstants.PARTICIPANT);
    }
    return fParticipant;
}

---------------Library-------------------
method: org.eclipse.core.internal.filebuffers.FileStoreFileBuffer.isDisconnected()Z1
protected boolean isDisconnected() {
    return fReferenceCount <= 0;
}
---------------Client-------------------
method: org.eclipse.jetty.io.AbstractBuffer.isImmutable()Z1
public boolean isImmutable() {
    return _access <= IMMUTABLE;
}

---------------Library-------------------
method: org.apache.lucene.index.ByteSliceReader.length()J1
@Override
public long length() {
    throw new  RuntimeException("not implemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringPluginImages.createUnManaged(java.lang.String;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
private static ImageDescriptor createUnManaged(String prefix, String name) {
    return create(prefix, name, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.osgi.framework.util.KeyedHashSet.isEmpty()Z1
public boolean isEmpty() {
    return elementCount == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicFeatureMap.basicToArray(org.eclipse.emf.ecore.EStructuralFeature;Ajava.lang.Object;)Ajava.lang.Object;3
public <T> T[] basicToArray(EStructuralFeature feature, T[] array) {
    return toArray(feature, array, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.DelegatingEcoreEList$Unsettable.didChange()V1
@Override
protected void didChange() {
    isSet = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Widget.fixMnemonic(java.lang.String;)AC2
char[] fixMnemonic(String string) {
    return fixMnemonic(string, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CounterImpl.getListStyle()java.lang.String;1
@Override
public String getListStyle() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.queryParser.QueryParser.getBooleanQuery(java.util.List;)org.apache.lucene.search.Query;2
protected Query getBooleanQuery(List<BooleanClause> clauses) throws ParseException {
    return getBooleanQuery(clauses, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.JavaUI.createPackageDialog(org.eclipse.swt.widgets.Shell;org.eclipse.jdt.core.IJavaProject;I)org.eclipse.ui.dialogs.SelectionDialog;3
public static SelectionDialog createPackageDialog(Shell parent, IJavaProject project, int style) throws JavaModelException {
    return createPackageDialog(parent, project, style, "");
}
---------------Client-------------------
method: org.eclipse.compare.internal.patch.HunkTypedElement.getHunkErrorImage(org.eclipse.swt.graphics.Image;org.eclipse.jface.resource.LocalResourceManager;Z)org.eclipse.swt.graphics.Image;3
public static Image getHunkErrorImage(Image baseImage, LocalResourceManager imageCache, boolean onLeft) {
    return getHunkOverlayImage(baseImage, imageCache, ICompareUIConstants.ERROR_OVERLAY, onLeft);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexWriter$FlushControl.waitUpdate(II)Z3
public synchronized boolean waitUpdate(int docInc, int delInc) {
    return waitUpdate(docInc, delInc, false);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Control.showMenu(II)Z3
boolean showMenu(int x, int y) {
    return showMenu(x, y, SWT.MENU_MOUSE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.text.PDETextHover.getHoverRegion(org.eclipse.jface.text.ITextViewer;I)org.eclipse.jface.text.IRegion;3
public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
    return new  Region(offset, 0);
}
---------------Client-------------------
method: org.eclipse.jface.bindings.keys.KeyStroke.getInstance(I)org.eclipse.jface.bindings.keys.KeyStroke;1
public static final KeyStroke getInstance(final int naturalKey) {
    return new  KeyStroke(NO_KEY, naturalKey);
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.model.util.BundleUtil.getResolvedResourceLocation(java.lang.String;org.osgi.framework.Bundle;)java.lang.String;2
public static String getResolvedResourceLocation(String resource, Bundle bundle) {
    return getResolvedResourceLocation(resource, bundle, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.PropertyFileDocumentModel.insert(org.eclipse.jdt.internal.corext.refactoring.nls.KeyValuePair;)org.eclipse.text.edits.InsertEdit;2
private InsertEdit insert(KeyValuePair keyValuePair) {
    KeyValuePairModell keyValuePairModell = new  KeyValuePairModell(keyValuePair);
    int index = findInsertPosition(keyValuePairModell);
    KeyValuePairModell insertHere = fKeyValuePairs.get(index);
    int offset = insertHere.fOffset;
    String extra = "";
    if (insertHere instanceof LastKeyValuePair && ((LastKeyValuePair) insertHere).needsNewLine()) {
        extra = fLineDelimiter;
        ((LastKeyValuePair) insertHere).resetNeedsNewLine();
        offset -= insertHere.fLeadingWhiteSpaces;
    } else if (index > 0) {
        String beforeKey = fKeyValuePairs.get(index - 1).fKey;
        String afterKey = insertHere.fKey;
        String key = keyValuePair.fKey;
        int distBefore = NLSUtil.invertDistance(key, beforeKey);
        int distAfter = NLSUtil.invertDistance(key, afterKey);
        if (distBefore > distAfter) {
            offset -= insertHere.fLeadingWhiteSpaces;
        } else if (distBefore == distAfter && Collator.getInstance().compare(beforeKey, afterKey) < 0) {
            offset -= insertHere.fLeadingWhiteSpaces;
        } else {
            keyValuePairModell.fLeadingWhiteSpaces = insertHere.fLeadingWhiteSpaces;
            insertHere.fLeadingWhiteSpaces = 0;
        }
    }
    String text = extra + keyValuePairModell.getKeyValueText();
    keyValuePairModell.fOffset = offset;
    keyValuePairModell.fLength = text.length();
    fKeyValuePairs.add(index, keyValuePairModell);
    return new  InsertEdit(offset, text);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;java.lang.Throwable;)V3
public void debug(Object message, Throwable t) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message), t);
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSSelectorFactory.createCDataSectionSelector(java.lang.String;)org.w3c.css.sac.CharacterDataSelector;2
public CharacterDataSelector createCDataSectionSelector(String data) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceMethod.toStringName(java.lang.StringBuffer;)V2
protected void toStringName(StringBuffer buffer) {
    toStringName(buffer, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMType.getCloseBodyPosition()I1
int getCloseBodyPosition() {
    return this.fCloseBodyRange[0];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckInitialConditionsTicks()I1
public int getCheckInitialConditionsTicks() {
    return fValues[CHECK_INITIAL_CONDITIONS];
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewClassWizardPage.isCreateMain()Z1
public boolean isCreateMain() {
    return fMethodStubsButtons.isSelected(0);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.ToolItem.setFocus()Z1
boolean setFocus() {
    return OS.gtk_widget_child_focus(handle, OS.GTK_DIR_TAB_FORWARD);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.ControlElement$1.focusLost(org.eclipse.swt.events.FocusEvent;)V2
@Override
public void focusLost(FocusEvent e) {
    ControlElement.this.hasFocus = false;
    doApplyStyles();
}
---------------Client-------------------
method: org.apache.batik.util.gui.CSSMediaPanel$AddMediumDialog$OKButtonAction.actionPerformed(java.awt.event.ActionEvent;)V2
public void actionPerformed(ActionEvent e) {
    returnCode = OK_OPTION;
    dispose();
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Shell.forceActive()V1
public void forceActive() {
    checkWidget();
    bringToTop(true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.JavaElementChangeListener.start()V1
public void start() {
    JavaCore.addElementChangedListener(this, ElementChangedEvent.POST_CHANGE);
    load();
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.JobManager.printState(I)java.lang.String;1
public static String printState(int state) {
    switch(state) {
        case Job.NONE:
            return "NONE";
        case Job.WAITING:
            return "WAITING";
        case Job.SLEEPING:
            return "SLEEPING";
        case Job.RUNNING:
            return "RUNNING";
        case InternalJob.BLOCKED:
            return "BLOCKED";
        case InternalJob.YIELDING:
            return "YIELDING";
        case InternalJob.ABOUT_TO_RUN:
            return "ABOUT_TO_RUN";
        case InternalJob.ABOUT_TO_SCHEDULE:
            return "ABOUT_TO_SCHEDULE";
    }
    return "UNKNOWN";
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.provisional.VisibilityModifiers.getVisibilityName(I)java.lang.String;1
public static String getVisibilityName(int visibility) {
    switch(visibility) {
        case ALL_VISIBILITIES:
            {
                return "ALL_VISIBILITIES";
            }
        case API:
            {
                return "API";
            }
        case PRIVATE:
            {
                return "PRIVATE";
            }
        case PRIVATE_PERMISSIBLE:
            {
                return "PRIVATE_PERMISSIBLE";
            }
        case UseReportConverter.FRAGMENT_PERMISSIBLE:
            {
                return "FRAGMENT_PERMISSIBLE";
            }
        case SPI:
            {
                return "SPI";
            }
        case ILLEGAL_API:
            {
                return "ILLEGAL_API";
            }
        case 0:
            {
                return "INHERITED";
            }
        default:
            break;
    }
    return Util.UNKNOWN_VISIBILITY;
}

---------------Library-------------------
method: org.eclipse.jetty.servlet.ServletMapping.toString()java.lang.String;1
public String toString() {
    return (_pathSpecs == null ? "[]" : Arrays.asList(_pathSpecs).toString()) + "=>" + _servletName;
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences$Relation.toString()java.lang.String;1
@Override
public String toString() {
    return from.toString() + "->" + (to == null ? IAntCoreConstants.EMPTY_STRING : to.toString());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.OmniVersion.getMicro()I1
public int getMicro() {
    return getIntElement(2);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.SimpleLog.isDebugEnabled()Z1
public final boolean isDebugEnabled() {
    return isLevelEnabled(SimpleLog.LOG_LEVEL_DEBUG);
}

---------------Library-------------------
method: org.eclipse.ecf.core.BaseContainer.connect(org.eclipse.ecf.core.identity.ID;org.eclipse.ecf.core.security.IConnectContext;)V3
public void connect(ID targetID, IConnectContext connectContext) throws ContainerConnectException {
    throw new  ContainerConnectException("Connect not supported");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.osgi.framework.util.Headers.setReadOnly()V1
public synchronized void setReadOnly() {
    readOnly = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.launchConfigurations.PerspectiveManager.shouldSwitchPerspective(org.eclipse.ui.IWorkbenchWindow;java.lang.String;java.lang.String;)Z4
private boolean shouldSwitchPerspective(IWorkbenchWindow window, String perspectiveId, String preferenceKey) {
    if (isCurrentPerspective(window, perspectiveId)) {
        return false;
    }
    String perspectiveName = getPerspectiveLabel(perspectiveId);
    if (perspectiveName == null) {
        return false;
    }
    String perspectiveDesc = getPerspectiveDescription(perspectiveId);
    Object[] args;
    if (perspectiveDesc != null) {
        args = new String[] { perspectiveName, perspectiveDesc };
    } else {
        args = new String[] { perspectiveName };
    }
    String switchPerspective = DebugUIPlugin.getDefault().getPreferenceStore().getString(preferenceKey);
    if (MessageDialogWithToggle.ALWAYS.equals(switchPerspective)) {
        return true;
    } else if (MessageDialogWithToggle.NEVER.equals(switchPerspective)) {
        return false;
    }
    Shell shell = window.getShell();
    if (shell == null || fPrompting) {
        return false;
    }
    fPrompting = true;
    Shell modal = getModalDialogOpen(shell);
    if (shell.getMinimized()) {
        shell.setMinimized(false);
        if (modal != null) {
            modal.setFocus();
        }
    }
    if (DebugUIPlugin.getDefault().getPreferenceStore().getBoolean(IDebugUIConstants.PREF_ACTIVATE_WORKBENCH)) {
        if (modal == null) {
            shell.forceActive();
        }
    }
    String message = IInternalDebugCoreConstants.EMPTY_STRING;
    if (IInternalDebugUIConstants.PREF_SWITCH_PERSPECTIVE_ON_SUSPEND.equals(preferenceKey)) {
        if (getPerspectiveDescription(perspectiveId) != null) {
            message = LaunchConfigurationsMessages.PerspectiveManager_suspend_description;
        } else {
            message = LaunchConfigurationsMessages.PerspectiveManager_13;
        }
    } else if (IInternalDebugUIConstants.PREF_SWITCH_TO_PERSPECTIVE.equals(preferenceKey)) {
        if (getPerspectiveDescription(perspectiveId) != null) {
            message = LaunchConfigurationsMessages.PerspectiveManager_launch_description;
        } else {
            message = LaunchConfigurationsMessages.PerspectiveManager_15;
        }
    }
    MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(shell, LaunchConfigurationsMessages.PerspectiveManager_12, MessageFormat.format(message, args), null, false, DebugUIPlugin.getDefault().getPreferenceStore(), preferenceKey);
    boolean answer = (dialog.getReturnCode() == IDialogConstants.YES_ID);
    synchronized (this) {
        fPrompting = false;
        notifyAll();
    }
    if (isCurrentPerspective(window, perspectiveId)) {
        answer = false;
    }
    return answer;
}
---------------Client-------------------
method: org.eclipse.ant.internal.launching.launchConfigurations.AntLaunchDelegate.configureAntRunner(org.eclipse.debug.core.ILaunchConfiguration;org.eclipse.core.runtime.IPath;java.lang.String;java.lang.StringBuffer;Ajava.lang.String;java.util.Map;Ajava.lang.String;Ajava.lang.String;Ajava.net.URL;java.lang.String;Z)org.eclipse.ant.core.AntRunner;12
private AntRunner configureAntRunner(ILaunchConfiguration configuration, IPath location, String baseDir, StringBuffer idProperty, String[] arguments, Map<String, String> userProperties, String[] propertyFiles, String[] targets, URL[] customClasspath, String antHome, boolean setInputHandler) throws CoreException {
    int argLength = 1;
    if (arguments != null) {
        argLength += arguments.length;
    }
    if (baseDir != null && baseDir.length() > 0) {
        argLength++;
    }
    String[] runnerArgs = new String[argLength];
    if (arguments != null) {
        System.arraycopy(arguments, 0, runnerArgs, 0, arguments.length);
    }
    if (baseDir != null && baseDir.length() > 0) {
        runnerArgs[runnerArgs.length - 2] = BASE_DIR_PREFIX + baseDir;
    }
    runnerArgs[runnerArgs.length - 1] = idProperty.toString();
    AntRunner runner = new  AntRunner();
    runner.setBuildFileLocation(location.toOSString());
    boolean captureOutput = ExternalToolsCoreUtil.getCaptureOutput(configuration);
    if (captureOutput) {
        if (fMode.equals(ILaunchManager.DEBUG_MODE)) {
            runner.addBuildLogger(ANT_DEBUG_LOGGER_CLASS);
        } else {
            runner.addBuildLogger(ANT_LOGGER_CLASS);
        }
    } else {
        runner.addBuildLogger(NULL_LOGGER_CLASS);
    }
    if (setInputHandler) {
        runner.setInputHandler(INPUT_HANDLER_CLASS);
    } else {
        runner.setInputHandler("");
    }
    runner.setArguments(runnerArgs);
    if (userProperties != null) {
        runner.addUserProperties(userProperties);
    }
    if (propertyFiles != null) {
        runner.setPropertyFiles(propertyFiles);
    }
    if (targets != null) {
        runner.setExecutionTargets(targets);
    }
    if (customClasspath != null) {
        runner.setCustomClasspath(customClasspath);
    }
    if (antHome != null) {
        runner.setAntHome(antHome);
    }
    return runner;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.correction.JavaCorrectionProcessor$1.assistSessionEnded(org.eclipse.jface.text.contentassist.ContentAssistEvent;)V2
public void assistSessionEnded(ContentAssistEvent event) {
    fAssistant.setStatusLineVisible(false);
}
---------------Client-------------------
method: org.eclipse.ui.internal.forms.widgets.FormHeading$5.mouseExit(org.eclipse.swt.events.MouseEvent;)V2
public void mouseExit(MouseEvent e) {
    titleRegion.setHoverState(TitleRegion.STATE_NORMAL);
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.FallbackScrolledComposite$1.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event e) {
    reflow(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.LibrarySection.checkSourceRootEntry()V1
private void checkSourceRootEntry() {
    IPluginModelBase pluginModel = getModel();
    IPluginLibrary[] libraries = pluginModel.getPluginBase().getLibraries();
    for (int i = 0; i < libraries.length; i++) if (libraries[i].getName().equals("."))
        return;
    IBuildModel model = getBuildModel();
    if (model == null)
        return;
    IBuildEntry[] entires = model.getBuild().getBuildEntries();
    for (int i = 0; i < entires.length; i++) {
        if (entires[i].getName().equals(PROPERTY_SOURCE_PREFIX + '.')) {
            IPluginLibrary library = pluginModel.getPluginFactory().createLibrary();
            try {
                library.setName(".");
                pluginModel.getPluginBase().add(library);
            } catch (CoreException e) {
            }
        }
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.ant.core.AntCorePlugin.getNewClassLoader(Ajava.net.URL;)java.net.URLClassLoader;2
public URLClassLoader getNewClassLoader(URL[] urls) {
    return getNewClassLoader(false, urls);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.FindReplaceDialog$FindModifyListener.ignoreNextEvent()V1
private void ignoreNextEvent() {
    fIgnoreNextEvent = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.ui.storage.view.ValuesView$TableLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object element) {
    return getColumnText(element, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.LayoutData.getCurrentView()org.eclipse.help.webapp.AbstractView;1
public AbstractView getCurrentView() {
    String name = request.getParameter("view");
    views = getViews();
    for (int i = 0; i < views.length; i++) if (views[i].getName().equals(name))
        return views[i];
    return null;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.apache.batik.util.gui.CSSMediaPanel.showDialog(java.awt.Component;java.lang.String;)I2
public static int showDialog(Component parent, String title) {
    return showDialog(parent, title, "");
}
---------------Client-------------------
method: org.eclipse.osgi.internal.resolver.StateHelperImpl.isResolvable(org.eclipse.osgi.service.resolver.HostSpecification;)Z2
public boolean isResolvable(HostSpecification specification) {
    return isBundleConstraintResolvable(specification, BundleRevision.HOST_NAMESPACE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ClassFile.getBinaryTypeInfo(org.eclipse.core.resources.IFile;)org.eclipse.jdt.internal.compiler.env.IBinaryType;2
public IBinaryType getBinaryTypeInfo(IFile file) throws JavaModelException {
    return getBinaryTypeInfo(file, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference.analyseCode(org.eclipse.jdt.internal.compiler.lookup.BlockScope;org.eclipse.jdt.internal.compiler.flow.FlowContext;org.eclipse.jdt.internal.compiler.flow.FlowInfo;)org.eclipse.jdt.internal.compiler.flow.FlowInfo;4
public FlowInfo analyseCode(BlockScope currentScope, FlowContext flowContext, FlowInfo flowInfo) {
    return analyseCode(currentScope, flowContext, flowInfo, true);
}
---------------Client-------------------
method: org.eclipse.ui.internal.operations.AdvancedValidationUserApprover.proceedExecuting(org.eclipse.core.commands.operations.IUndoableOperation;org.eclipse.core.commands.operations.IOperationHistory;org.eclipse.core.runtime.IAdaptable;)org.eclipse.core.runtime.IStatus;4
@Override
public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable uiInfo) {
    return proceedWithOperation(operation, history, uiInfo, EXECUTING);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSPageRuleImpl.getSelectorText()java.lang.String;1
@Override
public String getSelectorText() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.product.SplashConfigurationSection$7.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    applySpinners(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.osgi.HelloOSGiNewWizard.getImportPackages()Ajava.lang.String;1
public String[] getImportPackages() {
    return new String[] { "org.osgi.framework;version=\"1.3.0\"" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntElementAdapterFactory.getAdapterList()Ajava.lang.Class;1
@Override
public Class[] getAdapterList() {
    return new Class[] { IResource.class };
}

---------------Library-------------------
method: org.eclipse.jetty.util.MultiPartInputStream$MultiPart.write(I)V2
protected void write(int b) throws IOException {
    if (MultiPartInputStream.this._config.getMaxFileSize() > 0 && _size + 1 > MultiPartInputStream.this._config.getMaxFileSize())
        throw new  IllegalStateException("Multipart Mime part " + _name + " exceeds max filesize");
    if (MultiPartInputStream.this._config.getFileSizeThreshold() > 0 && _size + 1 > MultiPartInputStream.this._config.getFileSizeThreshold() && _file == null)
        createFile();
    _out.write(b);
    _size++;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.MinimizedFileSystemElement.setPopulated()V1
protected void setPopulated() {
    this.populated = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.removed(org.eclipse.jdt.core.IJavaElement;)V2
public void removed(IJavaElement element) {
    removed(element, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.apache.jasper.runtime.JspWriterImpl.shouldOutputBytes()Z1
boolean shouldOutputBytes() {
    if (bufferSize > 0) {
        return false;
    }
    try {
        initByteOut();
    } catch (IOException ex) {
    }
    return implementsByteWriter;
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.ui.templates.AbstractTemplateSection.markPagesAdded()V1
protected void markPagesAdded() {
    pagesAdded = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSPseudoClassCondition.toString()java.lang.String;1
public String toString() {
    return ":" + getValue();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.updatesite.VersionSuffixGenerator.getMicro(org.eclipse.equinox.p2.metadata.Version;)I1
private static int getMicro(Version v) {
    return getIntSegment(v, 2);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.SimpleLog.isDebugEnabled()Z1
public final boolean isDebugEnabled() {
    return isLevelEnabled(SimpleLog.LOG_LEVEL_DEBUG);
}

---------------Library-------------------
method: org.apache.batik.css.parser.DefaultClassCondition.toString()java.lang.String;1
public String toString() {
    return "." + getValue();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createCheckBox(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Button;2
public static Button createCheckBox(Composite parent, String message) {
    return createCheckBox(parent, message, 1);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.actions.CleanupcopyAction.undo(java.util.Map;)org.eclipse.core.runtime.IStatus;2
public IStatus undo(Map<String, Object> parameters) {
    return CopyAction.copy(parameters, false);
}
---------------Client-------------------
method: org.eclipse.ui.trace.internal.providers.TracingComponentLabelProvider.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(final Object element) {
    return TracingComponentLabelProvider.getLabel(TracingConstants.LABEL_COLUMN_INDEX, element);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.SuperInterfaceSelectionDialog.getDialogBoundsSettings()org.eclipse.jface.dialogs.IDialogSettings;1
@Override
protected IDialogSettings getDialogBoundsSettings() {
    return JavaPlugin.getDefault().getDialogSettingsSection("DialogBounds_SuperInterfaceSelectionDialog");
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathLabelProvider.getJarImage()org.eclipse.swt.graphics.Image;1
private Image getJarImage() {
    return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_JAR);
}

---------------Library-------------------
method: org.eclipse.osgi.framework.util.KeyedHashSet.shouldGrow()Z1
private boolean shouldGrow() {
    return elementCount > elements.length * 0.75;
}
---------------Client-------------------
method: org.eclipse.core.internal.events.NodeIDMap.shouldGrow()Z1
private boolean shouldGrow() {
    return elementCount > ids.length * LOAD_FACTOR;
}

---------------Library-------------------
method: org.eclipse.jface.databinding.viewers.ViewerProperties.singleSelection()org.eclipse.jface.databinding.viewers.IViewerValueProperty;0
public static IViewerValueProperty singleSelection() {
    return new  SelectionProviderSingleSelectionProperty(false);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}

---------------Library-------------------
method: org.eclipse.swt.custom.StyledText.getWordNext(II)I3
int getWordNext(int offset, int movement) {
    return getWordNext(offset, movement, false);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Control.showMenu(II)Z3
boolean showMenu(int x, int y) {
    return showMenu(x, y, SWT.MENU_MOUSE);
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.SearchPattern.trimWildcardCharacters(java.lang.String;)java.lang.String;2
private String trimWildcardCharacters(String pattern) {
    return Util.replaceAll(pattern, "\\*+", "\\*");
}
---------------Client-------------------
method: org.eclipse.jdt.core.JavaConventions.validateClassFileName(java.lang.String;)org.eclipse.core.runtime.IStatus;1
public static IStatus validateClassFileName(String name) {
    return validateClassFileName(name, CompilerOptions.VERSION_1_3, CompilerOptions.VERSION_1_3);
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.views.ScopeSetManager.findSet(java.lang.String;)org.eclipse.help.ui.internal.views.ScopeSet;2
public ScopeSet findSet(String name) {
    return findSet(name, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.CommonNavigatorActionGroup.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
protected final ImageDescriptor getImageDescriptor(String relativePath) {
    return NavigatorPlugin.getImageDescriptor("icons/full/" + relativePath);
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.isCurrent()Z1
public boolean isCurrent() throws CorruptIndexException, IOException {
    throw new  UnsupportedOperationException("This reader does not support this method.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.doOpenIfChanged(Z)org.apache.lucene.index.IndexReader;2
protected IndexReader doOpenIfChanged(boolean openReadOnly) throws CorruptIndexException, IOException {
    throw new  UnsupportedOperationException("This reader does not support reopen().");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.nls.NLSFragmentGenerator.quote(java.lang.String;)java.lang.String;2
private String quote(String pattern) {
    return "\\Q" + pattern + "\\E";
}
---------------Client-------------------
method: org.eclipse.ui.intro.contentproviders.EclipseRSSViewer.createExternalURL(java.lang.String;)java.lang.String;2
private String createExternalURL(String url) {
    try {
        return INTRO_SHOW_IN_BROWSER + URLEncoder.encode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        return INTRO_SHOW_IN_BROWSER + url;
    }
}

---------------Library-------------------
method: org.eclipse.pde.ui.templates.AbstractChoiceOption.setValue(java.lang.Object;)V2
public void setValue(Object value) {
    setValue(value, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.text.DSComponent.getEnabled()Z1
public boolean getEnabled() {
    return getBooleanAttributeValue(ATTRIBUTE_COMPONENT_ENABLED, true);
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.MarkerUtilities.getPriority(org.eclipse.core.resources.IMarker;)I1
public static int getPriority(IMarker marker) {
    return getIntAttribute(marker, IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSPageRuleImpl.setStyle(org.eclipse.e4.ui.css.core.impl.dom.CSSStyleDeclarationImpl;)V2
public void setStyle(CSSStyleDeclarationImpl decl) {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMType.getOpenBodyEnd()I1
int getOpenBodyEnd() {
    return this.fOpenBodyRange[1];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckFinalConditionsTicks()I1
public int getCheckFinalConditionsTicks() {
    return fValues[CHECK_FINAL_CONDITIONS];
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.ApiDescription.setRestrictions(org.eclipse.pde.api.tools.internal.provisional.descriptors.IElementDescriptor;I)org.eclipse.core.runtime.IStatus;3
@Override
public IStatus setRestrictions(IElementDescriptor element, int restrictions) {
    ManifestNode node = findNode(element, true);
    if (node != null) {
        if (ApiPlugin.DEBUG_API_DESCRIPTION) {
            StringBuffer buffer = new  StringBuffer();
            buffer.append("Setting restrictions for manifest node: ");
            buffer.append(node);
            buffer.append(" to be ");
            buffer.append(RestrictionModifiers.getRestrictionText(restrictions));
            System.out.println(buffer.toString());
        }
        modified();
        node.restrictions = restrictions;
        return Status.OK_STATUS;
    }
    return new  Status(IStatus.ERROR, ApiPlugin.PLUGIN_ID, ELEMENT_NOT_FOUND, MessageFormat.format("Failed to set API restriction: {0} not found in {1}", new Object[] { element.toString(), fOwningComponentId }), null);
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMType.toString()java.lang.String;1
public String toString() {
    return "TYPE: " + getName();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.complete.CompletionParser.stopRecordingIdentifiers()V1
public void stopRecordingIdentifiers() {
    this.record = true;
    this.skipRecord = false;
}
---------------Client-------------------
method: org.eclipse.jdt.ui.text.java.correction.ChangeCorrectionProposal$1.keyTraversed(org.eclipse.swt.events.TraverseEvent;)V2
public void keyTraversed(TraverseEvent e) {
    e.doit = true;
    e.detail = SWT.TRAVERSE_NONE;
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.BuildPathDialogAccess.configureSourceAttachment(org.eclipse.swt.widgets.Shell;org.eclipse.jdt.core.IClasspathEntry;)org.eclipse.jdt.core.IClasspathEntry;2
public static IClasspathEntry configureSourceAttachment(Shell shell, IClasspathEntry initialEntry) {
    return configureSourceAttachment(shell, initialEntry, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jface.text.source.projection.ProjectionAnnotation.markCollapsed()V1
public void markCollapsed() {
    fIsCollapsed = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.SynchronizerSyncInfoCache.flush(org.eclipse.core.resources.IProject;)V2
void flush(IProject project) throws CVSException {
    purgeCache(project, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.FinishResult.createInterrupted()org.eclipse.ltk.internal.ui.refactoring.FinishResult;0
public static FinishResult createInterrupted() {
    return new  FinishResult(1);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.SuperReference.implicitSuperConstructorCall()org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;0
public static ExplicitConstructorCall implicitSuperConstructorCall() {
    return new  ExplicitConstructorCall(ExplicitConstructorCall.ImplicitSuper);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleSheetImpl.getDisabled()Z1
@Override
public boolean getDisabled() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.ContributionsAnalyzer.trace(java.lang.String;java.lang.Throwable;)V2
public static void trace(String msg, Throwable error) {
    Activator.trace("/trace/menus", msg, error);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.update.ExpressionManagerModelProxy.expressionsRemoved(Aorg.eclipse.debug.core.model.IExpression;)V2
@Override
public void expressionsRemoved(IExpression[] expressions) {
    updateExpressions(expressions, IModelDelta.REMOVED | IModelDelta.UNINSTALL);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSConditionFactoryImpl.createOrCondition(org.w3c.css.sac.Condition;org.w3c.css.sac.Condition;)org.w3c.css.sac.CombinatorCondition;3
@Override
public CombinatorCondition createOrCondition(Condition first, Condition second) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.extensions.NavigatorViewerDescriptor.consumeContentBinding(org.eclipse.core.runtime.IConfigurationElement;)V2
public void consumeContentBinding(IConfigurationElement element) {
    consumeBinding(element, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.getMatchesInScopeMessage()java.lang.String;1
public String getMatchesInScopeMessage() {
    String scope = getScope();
    return NLS.bind(ServletResources.getString("matchesInScope", request), "" + getResultsCount(), scope);
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathBlock.setValidated()V1
public void setValidated() {
    validated = 2;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.Bucket$Entry.delete()V1
public void delete() {
    state = STATE_DELETED;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.SharingWizard.getNextPage(org.eclipse.jface.wizard.IWizardPage;)org.eclipse.jface.wizard.IWizardPage;2
public IWizardPage getNextPage(IWizardPage page) {
    return getNextPage(page, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumePrimitiveType()V1
protected void consumePrimitiveType() {
    pushOnIntStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.search.ui.text.AbstractTextSearchViewPage.gotoNextMatch()V1
public void gotoNextMatch() {
    gotoNextMatch(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.environments.ExecutionEnvironment.getId()java.lang.String;1
public String getId() {
    return fElement.getAttribute("id");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.EnumConstantDeclaration.memSize()I1
int memSize() {
    return super.memSize() + 3 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSConditionFactory.createOrCondition(org.w3c.css.sac.Condition;org.w3c.css.sac.Condition;)org.w3c.css.sac.CombinatorCondition;3
public CombinatorCondition createOrCondition(Condition first, Condition second) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSMediaRuleImpl.getCssRules()org.w3c.dom.css.CSSRuleList;1
@Override
public CSSRuleList getCssRules() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.validation.ValidatedObservableList.makeStale()V1
private void makeStale() {
    if (!stale) {
        stale = true;
        fireStale();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.ui.internal.console.IOConsolePartition.clearBuffer()V1
public void clearBuffer() {
    buffer.setLength(0);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.imports.PluginImportHelper.isClassFolder(org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;java.lang.Object;)Z2
private static boolean isClassFolder(IImportStructureProvider provider, Object element) {
    return folderContainsFileExtension(provider, element, ".class");
}
---------------Client-------------------
method: org.eclipse.osgi.internal.resolver.StateHelperImpl.isResolvable(org.eclipse.osgi.service.resolver.HostSpecification;)Z2
public boolean isResolvable(HostSpecification specification) {
    return isBundleConstraintResolvable(specification, BundleRevision.HOST_NAMESPACE);
}

---------------Library-------------------
method: org.eclipse.jface.text.contentassist.PopupCloser.widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetDefaultSelected(SelectionEvent e) {
    fScrollbarClicked = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ui.actions.ScrubLocalAction.updateSelection(org.eclipse.jface.viewers.IStructuredSelection;)Z2
protected boolean updateSelection(IStructuredSelection s) {
    return super.updateSelection(s) && getSelectedNonResources().size() == 0;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.builder.LeakFieldProblemDetector.isApplicable(org.eclipse.pde.api.tools.internal.provisional.IApiAnnotations;)Z2
@Override
protected boolean isApplicable(IApiAnnotations annotations) {
    return super.isApplicable(annotations) && !RestrictionModifiers.isReferenceRestriction(annotations.getRestrictions());
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicExtendedMetaData$EClassExtendedMetaDataImpl.setMaxLengthFacet(I)V2
public void setMaxLengthFacet(int maxLength) {
    throw new  UnsupportedOperationException("Can't set the max length of an EClass");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.registry.KeyedHashSet.isEmpty()Z1
public boolean isEmpty() {
    return elementCount == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeForInit()V1
protected void consumeForInit() {
    pushOnAstLengthStack(-1);
}
---------------Client-------------------
method: org.eclipse.jface.viewers.AbstractTreeViewer.expandAll()V1
public void expandAll() {
    expandToLevel(ALL_LEVELS);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSElementSelectorImpl.toString()java.lang.String;1
@Override
public String toString() {
    String name = getLocalName();
    if (name == null) {
        return "*";
    }
    return name;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.build.BuildEditor.computeInitialPageId()java.lang.String;1
@Override
protected String computeInitialPageId() {
    String firstPageId = super.computeInitialPageId();
    if (firstPageId == null) {
        return BuildPage.PAGE_ID;
    }
    return firstPageId;
}

---------------Library-------------------
method: org.eclipse.ui.internal.themes.ColorsAndFontsPreferencePage.fomatDescription(org.eclipse.ui.internal.themes.ThemeElementDefinition;)java.lang.String;2
private String fomatDescription(ThemeElementDefinition definition) {
    String description = definition.getDescription() != null ? definition.getDescription() : "";
    if (isAvailableInCurrentTheme(definition)) {
        return description;
    }
    return MessageFormat.format(RESOURCE_BUNDLE.getString("definitionNotAvailInTheme"), new Object[] { description }).trim();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyEnumDeclarations()V1
protected void consumeEmptyEnumDeclarations() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.batch.ClasspathSourceJar.findClass(ACLjava.lang.String;java.lang.String;)org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;4
public NameEnvironmentAnswer findClass(char[] typeName, String qualifiedPackageName, String qualifiedBinaryFileName) {
    return findClass(typeName, qualifiedPackageName, qualifiedBinaryFileName, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.createImport(java.lang.String;org.eclipse.jdt.core.IJavaElement;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IImportDeclaration;4
public IImportDeclaration createImport(String importName, IJavaElement sibling, IProgressMonitor monitor) throws JavaModelException {
    return createImport(importName, sibling, Flags.AccDefault, monitor);
}

---------------Library-------------------
method: org.eclipse.ui.trace.internal.TracingPreferencePage$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    enableTracingButtonSelected(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocStandardWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(STYLESHEETSTATUS);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.datatransfer.EclipseClasspath.getLinkedResourceName(java.lang.String;)java.lang.String;1
public static String getLinkedResourceName(String s) {
    return ExportUtil.removePrefixAndSuffix(s, "${", ".link}");
}
---------------Client-------------------
method: org.eclipse.jdt.core.JavaConventions.validateClassFileName(java.lang.String;)org.eclipse.core.runtime.IStatus;1
public static IStatus validateClassFileName(String name) {
    return validateClassFileName(name, CompilerOptions.VERSION_1_3, CompilerOptions.VERSION_1_3);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.ResourceFilterGroup$4.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    handleAdd(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.ControlElement$1.focusGained(org.eclipse.swt.events.FocusEvent;)V2
@Override
public void focusGained(FocusEvent e) {
    ControlElement.this.hasFocus = true;
    doApplyStyles();
}
---------------Client-------------------
method: org.apache.batik.util.gui.CSSMediaPanel$AddMediumDialog$CancelButtonAction.actionPerformed(java.awt.event.ActionEvent;)V2
public void actionPerformed(ActionEvent e) {
    returnCode = CANCEL_OPTION;
    dispose();
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.NavigatorContentService.findDescriptorsWithPossibleChild(java.lang.Object;)java.util.Set;2
public Set findDescriptorsWithPossibleChild(Object anElement) {
    return findDescriptorsWithPossibleChild(anElement, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.compare.contentmergeviewer.ContentMergeViewer$6.run()V1
public void run() {
    copy(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicFeatureMap.basicToArray(org.eclipse.emf.ecore.EStructuralFeature;)Ajava.lang.Object;2
public Object[] basicToArray(EStructuralFeature feature) {
    return toArray(feature, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.getAccessLevel()javax.lang.model.element.Modifier;1
@Override
public Modifier getAccessLevel() {
    throw new  UnsupportedOperationException("Not yet implemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.SharedProfilePreferences.doSave(org.eclipse.equinox.p2.core.IProvisioningAgent;)V2
protected void doSave(IProvisioningAgent agent) throws BackingStoreException {
    throw new  BackingStoreException("Can't store in shared install");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.PluginModelManager.isEmpty()Z1
public boolean isEmpty() {
    return getEntryTable().size() == 0;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.ContentPage.isVersionValid(java.lang.String;)Z2
protected boolean isVersionValid(String version) {
    return VersionUtil.validateVersion(version).getSeverity() == IStatus.OK;
}

---------------Library-------------------
method: org.eclipse.ui.internal.util.Util.safeCopy(java.util.Collection;java.lang.Class;)java.util.Collection;2
public static Collection safeCopy(Collection collection, Class c) {
    return safeCopy(collection, c, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.history.FileRevisionEditorInput.getName()java.lang.String;1
public String getName() {
    IFileRevision rev = (IFileRevision) getAdapter(IFileRevision.class);
    if (rev != null)
        return NLS.bind(TeamUIMessages.nameAndRevision, new String[] { rev.getName(), rev.getContentIdentifier() });
    IFileState state = (IFileState) getAdapter(IFileState.class);
    if (state != null)
        return state.getName() + " " + DateFormat.getInstance().format(new  Date(state.getModificationTime()));
    return storage.getName();
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.swt.graphics.Device.getDepth()I1
public int getDepth() {
    checkDevice();
    return 0;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Scrollable.getScrollbarsMode()I1
public int getScrollbarsMode() {
    checkWidget();
    return SWT.NONE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.JavaLogicalStructuresPreferencePage.addLogicalStructure()V1
protected void addLogicalStructure() {
    JavaLogicalStructure logicalStructure = new  JavaLogicalStructure("", true, "", "", new String[0][]);
    if (new  EditLogicalStructureDialog(getShell(), logicalStructure).open() == Window.OK) {
        fLogicalStructuresContentProvider.add(logicalStructure);
        fLogicalStructuresViewer.refresh();
        fLogicalStructuresViewer.setSelection(new  StructuredSelection(logicalStructure));
    }
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.FileSystemUtil.getContentsOfIFile(org.eclipse.core.resources.IFile;)java.lang.String;1
public static String getContentsOfIFile(IFile file) throws IOException, CoreException {
    return getContents(file.getContents(true));
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Resource.getProjectRelativePath()org.eclipse.core.runtime.IPath;1
public IPath getProjectRelativePath() {
    return getFullPath().removeFirstSegments(ICoreConstants.PROJECT_SEGMENT_LENGTH);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.search.dependencies.GatherUnusedDependenciesOperation$Requestor.acceptSearchMatch(org.eclipse.jdt.core.search.SearchMatch;)V2
public void acceptSearchMatch(SearchMatch match) throws CoreException {
    fFound = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.build.BuildEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jface.text.projection.Segment.markForShift()V1
public void markForShift() {
    isMarkedForShift = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.OpenInCompareAction.openCompareEditor(org.eclipse.compare.CompareEditorInput;org.eclipse.ui.IWorkbenchPage;)V2
public static void openCompareEditor(CompareEditorInput input, IWorkbenchPage page) {
    openCompareEditor(input, page, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.ExtensionsSection.fillContextMenu(org.eclipse.pde.internal.ui.editor.PDEFormPage;org.eclipse.pde.core.plugin.IPluginParent;org.eclipse.jface.action.IMenuManager;)org.eclipse.jface.action.IMenuManager;3
static IMenuManager fillContextMenu(PDEFormPage page, final IPluginParent parent, IMenuManager manager) {
    return fillContextMenu(page, parent, manager, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.apache.lucene.index.MultiReader.clone()java.lang.Object;1
@Override
public synchronized Object clone() {
    try {
        return doOpenIfChanged(true);
    } catch (Exception ex) {
        throw new  RuntimeException(ex);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.scheduler.migration.MigrationPage.loadCustomizedSetting()Z0
public static boolean loadCustomizedSetting() {
    IScopeContext[] contexts = new IScopeContext[] { InstanceScope.INSTANCE, DefaultScope.INSTANCE, BundleDefaultsScope.INSTANCE, ConfigurationScope.INSTANCE };
    boolean updateToLatest = Platform.getPreferencesService().getBoolean(AutomaticUpdatePlugin.PLUGIN_ID, "updateToLatest", false, contexts);
    return updateToLatest;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.dialogs.WizardWithLicenses.canBypassLicencePage()Z0
public static boolean canBypassLicencePage() {
    IScopeContext[] contexts = new IScopeContext[] { InstanceScope.INSTANCE, DefaultScope.INSTANCE, BundleDefaultsScope.INSTANCE, ConfigurationScope.INSTANCE };
    boolean bypass = Platform.getPreferencesService().getBoolean(ProvUIActivator.PLUGIN_ID, BYPASS_LICENSE_PAGE, false, contexts);
    return bypass;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.PDELabelProvider.getObjectText(org.eclipse.pde.internal.core.ifeature.IFeatureModel;)java.lang.String;2
public String getObjectText(IFeatureModel obj) {
    return getObjectText(obj, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputFileObject.delete()Z1
@Override
public boolean delete() {
    throw new  IllegalStateException("Deleting a file is not permitted from within an annotation processor");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository.getRawArtifact(org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;java.io.OutputStream;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.IStatus;4
public IStatus getRawArtifact(IArtifactDescriptor descriptor, OutputStream destination, IProgressMonitor monitor) {
    return getRawOrNormalArtifact(descriptor, destination, monitor, true);
}
---------------Client-------------------
method: org.eclipse.ui.internal.operations.AdvancedValidationUserApprover.proceedExecuting(org.eclipse.core.commands.operations.IUndoableOperation;org.eclipse.core.commands.operations.IOperationHistory;org.eclipse.core.runtime.IAdaptable;)org.eclipse.core.runtime.IStatus;4
@Override
public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable uiInfo) {
    return proceedWithOperation(operation, history, uiInfo, EXECUTING);
}

---------------Library-------------------
method: org.apache.lucene.index.ByteSliceReader.seek(J)V2
@Override
public void seek(long pos) {
    throw new  RuntimeException("not implemented");
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetUnion.iterator()java.util.Iterator;1
@Override
public Iterator<TType> iterator() {
    throw new  IllegalStateException("unimplemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.swt.internal.image.JPEGScanHeader.isACProgressiveScan()Z1
public boolean isACProgressiveScan() {
    return getStartOfSpectralSelection() != 0 && getEndOfSpectralSelection() != 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.RefactoringAvailabilityTester.isRenameVirtualMethodAvailable(org.eclipse.jdt.core.IMethod;)Z1
public static boolean isRenameVirtualMethodAvailable(final IMethod method) throws CoreException {
    return isRenameAvailable(method) && MethodChecks.isVirtual(method);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.WorkingSetManagerData.getCriteriaResource()Aorg.eclipse.help.internal.criteria.CriterionResource;1
private CriterionResource[] getCriteriaResource() {
    List category = Arrays.asList(getCriterionIds());
    String[] criteria = request.getParameterValues("criteria");
    if (criteria == null)
        criteria = new String[0];
    Map selectedElements = new  HashMap();
    for (int i = 0; i < criteria.length; ++i) {
        String criterion = criteria[i];
        if (category.contains(criterion)) {
            List allValuesInCategory = Arrays.asList(getCriterionValueIds(criterion));
            if (0 == allValuesInCategory.size()) {
                continue;
            }
            Set elements = (Set) selectedElements.get(criterion);
            if (null == elements) {
                elements = new  HashSet();
            }
            elements.addAll(allValuesInCategory);
            selectedElements.put(criterion, elements);
        } else {
            int len = criterion.length();
            if (criterion.charAt(len - 1) == '_') {
                String indexStr = criterion.substring(criterion.lastIndexOf('_', len - 2) + 1, len - 1);
                int index = 0;
                try {
                    index = Integer.parseInt(indexStr);
                } catch (Exception e) {
                    continue;
                }
                String criterionName = criterion.substring(0, criterion.lastIndexOf('_', len - 2));
                if (category.contains(criterionName)) {
                    String values[] = getCriterionValueIds(criterionName);
                    if (index < 0 || index >= values.length)
                        continue;
                    String selectedValue = values[index];
                    if (null == selectedValue || 0 == selectedValue.length())
                        continue;
                    Set existedElements = (Set) selectedElements.get(criterionName);
                    if (null == existedElements) {
                        existedElements = new  HashSet();
                    }
                    existedElements.add(selectedValue);
                    selectedElements.put(criterionName, existedElements);
                }
            }
        }
    }
    List resources = new  ArrayList();
    for (Iterator iter = selectedElements.keySet().iterator(); iter.hasNext(); ) {
        String key = (String) iter.next();
        Set values = (Set) selectedElements.get(key);
        CriterionResource resource = new  CriterionResource(key, new  ArrayList(values));
        resources.add(resource);
    }
    CriterionResource[] processedResources = new CriterionResource[resources.size()];
    resources.toArray(processedResources);
    return processedResources;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.ltk.core.refactoring.model.AbstractRefactoringDescriptorResourceMapping.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (object instanceof AbstractRefactoringDescriptorResourceMapping) {
        final AbstractRefactoringDescriptorResourceMapping mapping = (AbstractRefactoringDescriptorResourceMapping) object;
        return mapping.fDescriptor.equals(fDescriptor);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.apache.jasper.runtime.PageContextImpl.getAbsolutePathRelativeToContext(java.lang.String;)java.lang.String;2
private final String getAbsolutePathRelativeToContext(String relativeUrlPath) {
    String path = relativeUrlPath;
    if (!path.startsWith("/")) {
        String uri = (String) request.getAttribute("javax.servlet.include.servlet_path");
        if (uri == null)
            uri = ((HttpServletRequest) request).getServletPath();
        String baseURI = uri.substring(0, uri.lastIndexOf('/'));
        path = baseURI + '/' + path;
    }
    return path;
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.search2.internal.ui.text2.DefaultTextSearchQueryProvider.getPreviousFileNamePatterns()Ajava.lang.String;1
private String[] getPreviousFileNamePatterns() {
    return new String[] { "*" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntElementAdapterFactory.getAdapterList()Ajava.lang.Class;1
@Override
public Class[] getAdapterList() {
    return new Class[] { IResource.class };
}

---------------Library-------------------
method: org.apache.lucene.index.ConcurrentMergeScheduler.setSuppressExceptions()V1
void setSuppressExceptions() {
    suppressExceptions = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.SynchronizerSyncInfoCache.flush(org.eclipse.core.resources.IFolder;)V2
void flush(IFolder folder) throws CVSException {
    purgeCache(folder, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createHVFillGroup(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Group;3
public static Group createHVFillGroup(Composite parent, String text, int margins) {
    return createHVFillGroup(parent, text, margins, 1);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.correction.java.FindClassResolutionsOperation$AbstractClassResolutionCollector.addRequireBundleModification(org.eclipse.core.resources.IProject;org.eclipse.osgi.service.resolver.ExportPackageDescription;I)java.lang.Object;4
public Object addRequireBundleModification(IProject project, ExportPackageDescription desc, int relevance) {
    return JavaResolutionFactory.createRequireBundleProposal(project, desc, JavaResolutionFactory.TYPE_JAVA_COMPLETION, relevance);
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.BrowserExt.getExecutable()java.lang.String;1
public String getExecutable() {
    return element.getAttribute("executable");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderTopColor(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderTopColor(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-top-color");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCSRunObject.getConfirm()Z1
public boolean getConfirm() {
    return getBooleanAttributeValue(ATTRIBUTE_CONFIRM, false);
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.MarkerUtilities.getSeverity(org.eclipse.core.resources.IMarker;)I1
public static int getSeverity(IMarker marker) {
    return getIntAttribute(marker, IMarker.SEVERITY, IMarker.SEVERITY_INFO);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BufferFactoryWrapper.toString()java.lang.String;1
public String toString() {
    return "FactoryWrapper for " + this.factory;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager$CustomProfile.getID()java.lang.String;1
@Override
public String getID() {
    return ID_PREFIX + fName;
}

---------------Library-------------------
method: org.eclipse.ui.internal.util.Util.assertInstance(java.lang.Object;java.lang.Class;)V2
public static void assertInstance(Object object, Class c) {
    assertInstance(object, c, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.swt.graphics.TextLayout.getPreviousOffset(II)I3
public int getPreviousOffset(int offset, int movement) {
    return _getOffset(offset, movement, false);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Control.showMenu(II)Z3
boolean showMenu(int x, int y) {
    return showMenu(x, y, SWT.MENU_MOUSE);
}

---------------Library-------------------
method: org.eclipse.jface.text.rules.PatternRule.doEvaluate(org.eclipse.jface.text.rules.ICharacterScanner;)org.eclipse.jface.text.rules.IToken;2
protected IToken doEvaluate(ICharacterScanner scanner) {
    return doEvaluate(scanner, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.TypeContextChecker.parseSuperInterface(java.lang.String;)org.eclipse.jdt.core.dom.Type;1
public static Type parseSuperInterface(String superInterface) {
    return parseSuperType(superInterface, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyFontCompositeHandler.getCSSPropertiesNames(java.lang.String;)Ajava.lang.String;2
@Override
public String[] getCSSPropertiesNames(String property) {
    if ("font".equals(property))
        return FONT_CSSPROPERTIES;
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.search.NLSSearchResultPage.getAdapter(java.lang.Class;)java.lang.Object;2
public Object getAdapter(Class adapter) {
    if (IShowInTargetList.class.equals(adapter)) {
        return JavaSearchResultPage.SHOW_IN_TARGET_LIST;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.ds.Reference.isOptional()Z1
public boolean isOptional() {
    return cardinalityLow == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.LaunchingPlugin$VMChanges.defaultVMInstallChanged(org.eclipse.jdt.launching.IVMInstall;org.eclipse.jdt.launching.IVMInstall;)V3
public void defaultVMInstallChanged(IVMInstall previous, IVMInstall current) {
    fDefaultChanged = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSHintHelper.getAccessorClassReference(org.eclipse.jdt.core.dom.CompilationUnit;org.eclipse.jface.text.IRegion;)org.eclipse.jdt.internal.corext.refactoring.nls.AccessorClassReference;2
public static AccessorClassReference getAccessorClassReference(CompilationUnit astRoot, IRegion region) {
    return getAccessorClassReference(astRoot, region, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.EnumDeclaration.memSize()I1
int memSize() {
    return super.memSize() + 2 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.apache.batik.util.gui.resource.JToolbarToggleButton$MouseListener.mouseEntered(java.awt.event.MouseEvent;)V2
public void mouseEntered(MouseEvent ev) {
    setBorderPainted(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration.getDefaultPrefixes(org.eclipse.jface.text.source.ISourceViewer;java.lang.String;)Ajava.lang.String;3
@Override
public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
    return new String[] { "//", "" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor$3.getShowInTargetIds()Ajava.lang.String;1
@Override
public String[] getShowInTargetIds() {
    return new String[] { JavaUI.ID_PACKAGES, IPageLayout.ID_PROJECT_EXPLORER };
}

---------------Library-------------------
method: org.apache.jasper.runtime.JspWriterImpl.write(java.lang.String;II)V4
public void write(String s, int off, int len) throws IOException {
    ensureOpen();
    if (bufferSize == 0) {
        initOut();
        out.write(s, off, len);
        return;
    }
    int b = off, t = off + len;
    while (b < t) {
        int d = min(bufferSize - nextChar, t - b);
        s.getChars(b, b + d, cb, nextChar);
        b += d;
        nextChar += d;
        if (nextChar >= bufferSize)
            if (autoFlush)
                flushBuffer();
            else
                bufferOverflow();
    }
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.services.WorkbenchSourceProvider.checkActivePart()V1
public final void checkActivePart() {
    checkActivePart(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl.createTextNodeSelector(java.lang.String;)org.w3c.css.sac.CharacterDataSelector;2
@Override
public CharacterDataSelector createTextNodeSelector(String data) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.NavigationHistory$1.partInputChanged(org.eclipse.ui.IWorkbenchPartReference;)V2
@Override
public void partInputChanged(IWorkbenchPartReference partRef) {
    updateNavigationHistory(partRef, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSMediaRuleImpl.getMedia()org.w3c.dom.stylesheets.MediaList;1
@Override
public MediaList getMedia() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.JavaSearchEditorOpener.showWithoutReuse(java.lang.Object;)org.eclipse.ui.IEditorPart;2
private IEditorPart showWithoutReuse(Object element) throws PartInitException {
    try {
        return EditorUtility.openInEditor(element, false);
    } catch (PartInitException e) {
        if (e.getStatus().getCode() != IJavaStatusConstants.EDITOR_NO_EDITOR_INPUT) {
            throw e;
        }
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.trace.internal.providers.TracingComponentLabelProvider.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(final Object element) {
    return TracingComponentLabelProvider.getLabel(TracingConstants.LABEL_COLUMN_INDEX, element);
}

---------------Library-------------------
method: org.eclipse.jetty.util.resource.URLResource.delete()Z1
@Override
public boolean delete() throws SecurityException {
    throw new  SecurityException("Delete not supported");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputFileObject.openInputStream()java.io.InputStream;1
@Override
public InputStream openInputStream() throws IOException {
    throw new  IllegalStateException("Opening an input stream on a generated file is not permitted");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.BrowserExt.getId()java.lang.String;1
public String getId() {
    return element.getAttribute("id");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.TypeFilterPreferencePage$TypeFilterAdapter.canEdit(org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField;)Z2
private boolean canEdit(ListDialogField<String> field) {
    return field.getSelectedElements().size() == 1;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.subscriber.SafeUpdateOperation$3.select(org.eclipse.team.core.synchronize.SyncInfo;)Z2
public boolean select(SyncInfo info) {
    return info.getLocal().getType() == IResource.FILE;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.ds.model.ComponentReference.createBuffer()java.lang.StringBuffer;1
private StringBuffer createBuffer() {
    return new  StringBuffer(400);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.browsing.JavaBrowsingPart.createTitleProvider()org.eclipse.jface.viewers.ILabelProvider;1
protected ILabelProvider createTitleProvider() {
    return new  JavaElementLabelProvider(JavaElementLabelProvider.SHOW_BASICS | JavaElementLabelProvider.SHOW_SMALL_ICONS);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.isScopeRequest()Z1
public boolean isScopeRequest() {
    return (request.getParameter("workingSet") != null);
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.CompletionEngine$10.acceptNameWithoutPrefixAndSuffix(ACI)V3
public void acceptNameWithoutPrefixAndSuffix(char[] name, int reusedCharacters) {
    accept(name, 0, reusedCharacters);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleWarningToken(java.lang.String;Z)V3
protected void handleWarningToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Warning);
}

---------------Library-------------------
method: org.eclipse.swt.dnd.DragSource.dragDataDelete(JJ)V3
void dragDataDelete(long widget, long context) {
    moveData = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.TypeReference.resolveType(org.eclipse.jdt.internal.compiler.lookup.ClassScope;)org.eclipse.jdt.internal.compiler.lookup.TypeBinding;2
public TypeBinding resolveType(ClassScope scope) {
    return resolveType(scope, 0);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.viewers.IUDetailsLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object obj) {
    return getColumnText(obj, PRIMARY_COLUMN);
}

---------------Library-------------------
method: org.eclipse.ui.internal.progress.ProgressViewerContentProvider.refresh()V1
@Override
public void refresh() {
    progressViewer.refresh(true);
}
---------------Client-------------------
method: org.eclipse.jface.text.link.LinkedModeUI$Closer.inputDocumentAboutToBeChanged(org.eclipse.jface.text.IDocument;org.eclipse.jface.text.IDocument;)V3
public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
    leave(ILinkedModeListener.EXIT_ALL);
}

---------------Library-------------------
method: org.apache.lucene.index.ConcurrentMergeScheduler.message(java.lang.String;)V2
protected void message(String message) {
    writer.message("CMS: " + message);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.notifyTestTreeEntry(java.lang.String;)V2
protected void notifyTestTreeEntry(String treeEntry) {
    fSender.sendMessage(MessageIds.TEST_TREE + treeEntry);
}

---------------Library-------------------
method: org.apache.jasper.runtime.JspWriterImpl.clear()V1
public final void clear() throws IOException {
    if ((bufferSize == 0) && (out != null))
        throw new  IllegalStateException(getLocalizeMessage("jsp.error.ise_on_clear"));
    if (flushed)
        throw new  IOException(getLocalizeMessage("jsp.error.attempt_to_clear_flushed_buffer"));
    ensureOpen();
    nextChar = 0;
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.GenerateHashCodeEqualsOperation.getThisAccessForHashCode(java.lang.String;)org.eclipse.jdt.core.dom.Expression;2
private Expression getThisAccessForHashCode(String name) {
    return getThisAccess(name, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.team.ui.mapping.SynchronizationContentProvider.getElements(java.lang.Object;)Ajava.lang.Object;2
public Object[] getElements(Object parent) {
    return internalGetChildren(parent, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.RectImpl.getLeft()org.w3c.dom.css.CSSPrimitiveValue;1
@Override
public CSSPrimitiveValue getLeft() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.DocumentTextNode.getText()java.lang.String;1
public String getText() {
    return fText == null ? "" : fText;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.storage.friends.PasswordProviderDescription.getDescription()java.lang.String;1
public String getDescription() {
    return (description == null) ? EMPTY_STRING : description;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.PluginParent.getChildrenList()java.util.ArrayList;1
protected ArrayList<IPluginObject> getChildrenList() {
    if (fChildren == null)
        fChildren = new  ArrayList<IPluginObject>(1);
    return fChildren;
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.model.KeyController.getEventManager()org.eclipse.core.runtime.ListenerList;1
private ListenerList getEventManager() {
    if (eventManager == null) {
        eventManager = new  ListenerList(ListenerList.IDENTITY);
    }
    return eventManager;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.DocumentHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(""));
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
@Override
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(IAntCoreConstants.EMPTY_STRING));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.NewJavaProjectPreferencePage.getJREVariableEntry()org.eclipse.jdt.core.IClasspathEntry;0
private static IClasspathEntry getJREVariableEntry() {
    return JavaCore.newVariableEntry(new  Path("JRE_LIB"), new  Path("JRE_SRC"), new  Path("JRE_SRCROOT"));
}
---------------Client-------------------
method: org.eclipse.jdt.launching.JavaRuntime.getJREVariableEntry()org.eclipse.jdt.core.IClasspathEntry;0
public static IClasspathEntry getJREVariableEntry() {
    return JavaCore.newVariableEntry(new  Path(JRELIB_VARIABLE), new  Path(JRESRC_VARIABLE), new  Path(JRESRCROOT_VARIABLE));
}

---------------Library-------------------
method: org.apache.lucene.analysis.hunspell.HunspellStemmer$Stem.getStemString()java.lang.String;1
public String getStemString() {
    return new  String(stem, 0, stemLength);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover$InformationControlCreator.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  AnnotationExpansionControl(parent, SWT.NONE, fAnnotationAccess);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBackgroundCompositeHandler.getCSSPropertiesNames(java.lang.String;)Ajava.lang.String;2
@Override
public String[] getCSSPropertiesNames(String property) {
    if ("background".equals(property))
        return BACKROUND_CSSPROPERTIES;
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.search.NLSSearchResultPage.getAdapter(java.lang.Class;)java.lang.Object;2
public Object getAdapter(Class adapter) {
    if (IShowInTargetList.class.equals(adapter)) {
        return JavaSearchResultPage.SHOW_IN_TARGET_LIST;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.AbstractTextEditor.createEmptyNavigationLocation()org.eclipse.ui.INavigationLocation;1
public INavigationLocation createEmptyNavigationLocation() {
    return new  TextSelectionNavigationLocation(this, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.refactoring.descriptors.JavaRefactoringDescriptorUtil.getJavaElement(java.util.Map;java.lang.String;java.lang.String;)org.eclipse.jdt.core.IJavaElement;3
public static IJavaElement getJavaElement(Map map, String attribute, String project) throws IllegalArgumentException {
    return getJavaElement(map, attribute, project, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.apache.jasper.runtime.TldScanner.getTldMap()java.util.Map;1
@SuppressWarnings("unchecked")
Map<URI, List<String>> getTldMap() {
    return (Map<URI, List<String>>) ctxt.getAttribute("com.sun.appserv.tld.map");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyMemberValuePairsopt()V1
protected void consumeEmptyMemberValuePairsopt() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.declaration.DeclarationImpl.isBindingBased()Z1
public boolean isBindingBased() {
    return true;
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.objectweb.asm.TypeReference.getFormalParameterIndex()I1
public int getFormalParameterIndex() {
    return (value & 0x00FF0000) >> 16;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.problems.ApiProblem.getElementKind()I1
@Override
public int getElementKind() {
    return (fId & ELEMENT_KIND_MASK) >> OFFSET_ELEMENT;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.IDEPreferenceInitializer.getHelpSeparatorKey(java.lang.String;)java.lang.String;2
private String getHelpSeparatorKey(String groupId) {
    return "useSeparator." + IWorkbenchActionConstants.M_HELP + "." + groupId;
}
---------------Client-------------------
method: org.eclipse.help.internal.webapp.StatusProducer.getBytes(java.lang.StringBuffer;)java.io.InputStream;1
private static InputStream getBytes(StringBuffer pageBuffer) {
    try {
        return new  ByteArrayInputStream(pageBuffer.toString().getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
        HelpWebappPlugin.logError("JRE error: UTF-8 encoding not supported", e);
        return new  ByteArrayInputStream(pageBuffer.toString().getBytes());
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.text.ManifestConfiguration$1.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  DefaultInformationControl(parent, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.env.AccessRuleSet.toString()java.lang.String;1
public String toString() {
    return toString(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.MatchLocations$MatchLocationSelectionDialog$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    performSelectAction(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocStandardWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(STYLESHEETSTATUS);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.model.AntPropertyNode.isRegionPotentialReference(org.eclipse.jface.text.IRegion;)Z2
@Override
public boolean isRegionPotentialReference(IRegion region) {
    boolean superOK = super.isRegionPotentialReference(region);
    if (!getTask().getTaskName().equals("property") || !superOK) {
        return superOK;
    }
    String textToSearch = getAntModel().getText(getOffset(), getLength());
    if (textToSearch == null) {
        return false;
    }
    int valueOffset = textToSearch.indexOf(fOccurrencesStartingPoint);
    if (valueOffset > -1) {
        valueOffset = textToSearch.indexOf('"', valueOffset);
        if (valueOffset > -1) {
            boolean inValue = region.getOffset() >= (getOffset() + valueOffset);
            if (inValue) {
                if ("{".equals(getAntModel().getText(region.getOffset() - 1, 1)) || "}".equals(getAntModel().getText(region.getOffset() + region.getLength(), 1))) {
                    return true;
                }
                return false;
            }
            return true;
        }
    }
    return false;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.AccessorClassModifier.addKey(org.eclipse.jdt.internal.corext.refactoring.nls.NLSSubstitution;org.eclipse.text.edits.TextEditGroup;)V3
private void addKey(NLSSubstitution sub, TextEditGroup editGroup) {
    if (fListRewrite == null)
        return;
    String key = sub.getKey();
    FieldDeclaration fieldDeclaration = getNewFinalStringFieldDeclaration(key);
    if (fFields.size() == 0) {
        fListRewrite.insertLast(fieldDeclaration, editGroup);
        fFields.add(fieldDeclaration);
    } else {
        ArrayList<String> identifiers = new  ArrayList<String>();
        for (Iterator<FieldDeclaration> iterator = fFields.iterator(); iterator.hasNext(); ) {
            FieldDeclaration field = iterator.next();
            VariableDeclarationFragment fragment = (VariableDeclarationFragment) field.fragments().get(0);
            identifiers.add(fragment.getName().getIdentifier());
        }
        int insertionPosition = NLSUtil.getInsertionPosition(key, identifiers);
        if (insertionPosition < 0) {
            fListRewrite.insertBefore(fieldDeclaration, fFields.get(0), editGroup);
            fFields.add(0, fieldDeclaration);
        } else {
            if (identifiers.size() == insertionPosition + 1) {
                fListRewrite.insertAfter(fieldDeclaration, fFields.get(insertionPosition), editGroup);
            } else {
                String beforeKey = identifiers.get(insertionPosition);
                String afterKey = identifiers.get(insertionPosition + 1);
                int distBefore = NLSUtil.invertDistance(key, beforeKey);
                int distAfter = NLSUtil.invertDistance(key, afterKey);
                if (distBefore > distAfter) {
                    fListRewrite.insertAfter(fieldDeclaration, fFields.get(insertionPosition), editGroup);
                } else if (distBefore == distAfter && Collator.getInstance().compare(beforeKey, afterKey) < 0) {
                    fListRewrite.insertAfter(fieldDeclaration, fFields.get(insertionPosition), editGroup);
                } else {
                    fListRewrite.insertBefore(fieldDeclaration, fFields.get(insertionPosition + 1), editGroup);
                }
            }
            fFields.add(insertionPosition + 1, fieldDeclaration);
        }
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;java.lang.Throwable;)V3
public void debug(Object message, Throwable t) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message), t);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.AbstractExtensionsModel.getExtensions()org.eclipse.pde.core.plugin.IExtensions;1
public IExtensions getExtensions() {
    return getExtensions(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexWriter.optimize(Z)V2
@Deprecated
public void optimize(boolean doWait) throws CorruptIndexException, IOException {
    forceMerge(1, doWait);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.setHasInitializer(Z)V2
protected void setHasInitializer(boolean hasInitializer) {
    setMask(MASK_FIELD_HAS_INITIALIZER, hasInitializer);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.rcp.HelloNonUIRCPTemplate.createApplicationExtension()V1
private void createApplicationExtension() throws CoreException {
    IPluginBase plugin = model.getPluginBase();
    IPluginExtension extension = createExtension("org.eclipse.core.runtime.applications", true);
    extension.setId("application");
    IPluginElement element = model.getPluginFactory().createElement(extension);
    element.setName("application");
    extension.add(element);
    IPluginElement run = model.getPluginFactory().createElement(element);
    run.setName("run");
    run.setAttribute("class", getStringOption(KEY_PACKAGE_NAME) + "." + getStringOption(KEY_APPLICATION_CLASS));
    element.add(run);
    if (!extension.isInTheModel())
        plugin.add(extension);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.templates.rcp.HelloRCPTemplate.createApplicationExtension()V1
private void createApplicationExtension() throws CoreException {
    IPluginBase plugin = model.getPluginBase();
    IPluginExtension extension = createExtension("org.eclipse.core.runtime.applications", true);
    extension.setId(VALUE_APPLICATION_ID);
    IPluginElement element = model.getPluginFactory().createElement(extension);
    element.setName("application");
    extension.add(element);
    IPluginElement run = model.getPluginFactory().createElement(element);
    run.setName("run");
    run.setAttribute("class", getStringOption(KEY_PACKAGE_NAME) + "." + getStringOption(KEY_APPLICATION_CLASS));
    element.add(run);
    if (!extension.isInTheModel())
        plugin.add(extension);
}

---------------Library-------------------
method: org.eclipse.ui.internal.menus.MenuAdditionCacheEntry.inToolbar()Z1
private boolean inToolbar() {
    return location.getScheme().startsWith("toolbar");
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringWizardDialog2.isPreviewPageActive()Z1
private boolean isPreviewPageActive() {
    return IPreviewWizardPage.PAGE_NAME.equals(fCurrentPage.getName());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.ui.storage.view.ValuesView$6.run()V1
public void run() {
    reCodeValue(false);
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.ui.FileSelectionDialog$4.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
@Override
public void doubleClick(DoubleClickEvent event) {
    buttonPressed(IDialogConstants.OK_ID);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.CVSWorkspaceSubscriber.externalSyncInfoChange(Aorg.eclipse.core.resources.IResource;)V2
public void externalSyncInfoChange(IResource[] changedResources) {
    internalResourceSyncInfoChanged(changedResources, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xml.type.internal.QName.setPrefix(java.lang.String;)V2
public void setPrefix(String prefix) {
    if (prefix == null) {
        this.prefix = "";
    } else {
        this.prefix = prefix;
    }
}
---------------Client-------------------
method: org.eclipse.ant.core.AntRunner.setBuildFileLocation(java.lang.String;)V2
public void setBuildFileLocation(String buildFileLocation) {
    if (buildFileLocation == null) {
        this.buildFileLocation = IAntCoreConstants.DEFAULT_BUILD_FILENAME;
    } else {
        this.buildFileLocation = buildFileLocation;
    }
}

---------------Library-------------------
method: org.eclipse.ui.ide.IDE.getEditorDescriptor(org.eclipse.core.resources.IFile;)org.eclipse.ui.IEditorDescriptor;1
public static IEditorDescriptor getEditorDescriptor(IFile file) throws PartInitException {
    return getEditorDescriptor(file, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EDataTypeEList$Unsettable.didChange()V1
@Override
protected void didChange() {
    isSet = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.help.internal.search.InfoCenter$InfoCenterResult.getHref()java.lang.String;1
public String getHref() {
    return node.getAttribute("href");
}
---------------Client-------------------
method: org.eclipse.debug.internal.core.XMLMemento.getID()java.lang.String;1
public String getID() {
    return element.getAttribute(IMementoConstants.TAG_ID);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.WorkingSetData.getOperation()java.lang.String;1
public String getOperation() {
    return request.getParameter("operation");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.search.ManifestEditorOpener.getAttributeMatch(org.eclipse.pde.internal.ui.editor.plugin.ManifestEditor;java.lang.String;org.eclipse.jface.text.IDocument;)org.eclipse.jface.text.IRegion;3
public static IRegion getAttributeMatch(ManifestEditor editor, String value, IDocument document) {
    return getAttributeRegion(document, value, 0);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSPseudoClassConditionImpl.toString()java.lang.String;1
@Override
public String toString() {
    return ":" + getValue();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.ltk.internal.core.refactoring.UndoManager2.changePerformed(org.eclipse.ltk.core.refactoring.Change;)V2
public void changePerformed(Change change) {
    changePerformed(change, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleSheetImpl.getMedia()org.w3c.dom.stylesheets.MediaList;1
@Override
public MediaList getMedia() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareUIPlugin.initializeRegistries()V1
private void initializeRegistries() {
    if (!fRegistriesInitialized) {
        registerExtensions();
        fRegistriesInitialized = true;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.ecf.provider.filetransfer.httpclient4.HttpClientRetrieveFileTransfer.setResumeRequestHeaderValues()V1
protected void setResumeRequestHeaderValues() throws IOException {
    if (this.bytesReceived <= 0 || this.fileLength <= this.bytesReceived)
        throw new  IOException(Messages.HttpClientRetrieveFileTransfer_RESUME_START_ERROR);
    setRangeHeader("bytes=" + this.bytesReceived + "-");
    int maxAge = Integer.getInteger("org.eclipse.ecf.http.cache.max-age", 0);
    if (maxAge == 0) {
        getMethod.addHeader("Cache-Control", "max-age=0");
    } else if (maxAge > 0) {
        getMethod.addHeader("Cache-Control", "max-age=" + maxAge);
    }
    setRequestHeaderValuesFromOptions();
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.skipSpaces()I1
protected int skipSpaces() {
    do {
        nextChar();
    } while (current != -1 && XMLUtilities.isXMLSpace((char) current));
    return current;
}

---------------Library-------------------
method: org.eclipse.ui.internal.console.IOConsolePartition.setReadOnly()V1
public void setReadOnly() {
    readOnly = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.core.externaltools.internal.launchConfigurations.ExternalToolsCoreUtil.isBuilderEnabled(org.eclipse.debug.core.ILaunchConfiguration;)Z1
public static boolean isBuilderEnabled(ILaunchConfiguration configuration) throws CoreException {
    return configuration.getAttribute(IExternalToolConstants.ATTR_BUILDER_ENABLED, true);
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.MarkerUtilities.getPriority(org.eclipse.core.resources.IMarker;)I1
public static int getPriority(IMarker marker) {
    return getIntAttribute(marker, IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.datatransfer.AntBuildfileExportPage.updateEnablement()V1
private void updateEnablement() {
    boolean complete = true;
    if (fSelectedJavaProjects.size() == 0) {
        setErrorMessage(DataTransferMessages.AntBuildfileExportPage_18);
        complete = false;
    }
    try {
        List<String> projectsWithErrors = new  ArrayList<String>();
        List<String> projectsWithWarnings = new  ArrayList<String>();
        findCyclicProjects(getProjects(false), projectsWithErrors, projectsWithWarnings);
        if (projectsWithErrors.size() > 0) {
            String message = DataTransferMessages.AntBuildfileExportPage_cycle_error_in_projects;
            if (projectsWithErrors.size() == 1) {
                message = DataTransferMessages.AntBuildfileExportPage_cycle_error_in_project;
            }
            setErrorMessage(MessageFormat.format(message, new Object[] { ExportUtil.toString(projectsWithErrors, ", ") }));
            complete = false;
        } else if (projectsWithWarnings.size() > 0) {
            String message = DataTransferMessages.AntBuildfileExportPage_cycle_warning_in_projects;
            if (projectsWithWarnings.size() == 1) {
                message = DataTransferMessages.AntBuildfileExportPage_cycle_warning_in_project;
            }
            setMessage(MessageFormat.format(message, new Object[] { ExportUtil.toString(projectsWithWarnings, ", ") }), WARNING);
        } else {
            setMessage(null);
        }
    } catch (CoreException e) {
    }
    if (buildfilenameText.getText().length() == 0) {
        setErrorMessage(DataTransferMessages.AntBuildfileExportPage_19);
        complete = false;
    }
    if (junitdirText.getText().length() == 0) {
        setErrorMessage(DataTransferMessages.AntBuildfileExportPage_20);
        complete = false;
    }
    if (complete) {
        setErrorMessage(null);
    }
    setPageComplete(complete);
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.activities.ws.ActivityEnabler$4.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    toggleTreeEnablement(false);
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.ui.FileSelectionDialog$4.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
@Override
public void doubleClick(DoubleClickEvent event) {
    buttonPressed(IDialogConstants.OK_ID);
}

---------------Library-------------------
method: org.eclipse.jface.text.source.projection.SourceViewerInformationControl$1.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
public void keyPressed(KeyEvent e) {
    if (e.character == 0x1B)
        fShell.dispose();
}
---------------Client-------------------
method: org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter$LinkListInformationControl$5.keyTraversed(org.eclipse.swt.events.TraverseEvent;)V2
public void keyTraversed(TraverseEvent e) {
    if (e.keyCode == SWT.ESC) {
        fManager.hideInformationControl();
    }
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Widget.postEvent(ILorg.eclipse.swt.widgets.Event;)V3
void postEvent(int eventType, Event event) {
    sendEvent(eventType, event, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleWarningToken(java.lang.String;Z)V3
protected void handleWarningToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Warning);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.breadcrumb.BreadcrumbViewer$1.keyTraversed(org.eclipse.swt.events.TraverseEvent;)V2
public void keyTraversed(TraverseEvent e) {
    e.doit = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.correction.SerialVersionHashOperation.getClassName(AC)java.lang.String;1
private static String getClassName(char[] name) {
    return new  String(name).replace('/', '.');
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.changes.RenamePackageChange.createPath(java.lang.String;)org.eclipse.core.runtime.IPath;1
private static IPath createPath(String packageName) {
    return new  Path(packageName.replace('.', IPath.SEPARATOR));
}

---------------Library-------------------
method: org.apache.jasper.compiler.JspRuntimeContext.saveBytecode(java.lang.String;java.lang.String;)V3
public void saveBytecode(String className, String classFileName) {
    byte[] bytecode = getBytecode(className);
    if (bytecode != null) {
        try {
            FileOutputStream fos = new  FileOutputStream(classFileName);
            fos.write(bytecode);
            fos.close();
        } catch (IOException ex) {
            context.log("Error in saving bytecode for " + className + " to " + classFileName, ex);
        }
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.ApiDescription.setVisibility(org.eclipse.pde.api.tools.internal.provisional.descriptors.IElementDescriptor;I)org.eclipse.core.runtime.IStatus;3
@Override
public IStatus setVisibility(IElementDescriptor element, int visibility) {
    ManifestNode node = findNode(element, true);
    if (node != null) {
        if (ApiPlugin.DEBUG_API_DESCRIPTION) {
            StringBuffer buffer = new  StringBuffer();
            buffer.append("Setting visibility for manifest node: ");
            buffer.append(node);
            buffer.append(" to be ");
            buffer.append(VisibilityModifiers.getVisibilityName(visibility));
            System.out.println(buffer.toString());
        }
        modified();
        node.visibility = visibility;
        return Status.OK_STATUS;
    }
    return new  Status(IStatus.ERROR, ApiPlugin.PLUGIN_ID, ELEMENT_NOT_FOUND, MessageFormat.format("Failed to set API visibility: {0} not found in {1}", new Object[] { element.toString(), fOwningComponentId }), null);
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;2
public static Label createLabel(Composite parent, String message) {
    return createLabel(parent, message, 1);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement.createFromExisting(java.lang.Object;org.eclipse.jdt.core.IClasspathEntry;org.eclipse.jdt.core.IJavaProject;)org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement;3
public static CPListElement createFromExisting(Object parent, IClasspathEntry curr, IJavaProject project) {
    return create(parent, curr, false, project);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.exports.FeatureExportOperation.createAntBuildProperties(AAjava.lang.String;)java.util.HashMap;2
protected HashMap<String, String> createAntBuildProperties(String[][] configs) {
    if (fAntBuildProperties == null) {
        fAntBuildProperties = new  HashMap<String, String>(15);
        List<?> defaultProperties = AntCorePlugin.getPlugin().getPreferences().getProperties();
        ListIterator<?> li = defaultProperties.listIterator();
        while (li.hasNext()) {
            Property prop = (Property) li.next();
            fAntBuildProperties.put(prop.getName(), prop.getValue());
        }
        if (fInfo.signingInfo != null) {
            fAntBuildProperties.put(IXMLConstants.PROPERTY_SIGN_ALIAS, fInfo.signingInfo[0]);
            fAntBuildProperties.put(IXMLConstants.PROPERTY_SIGN_KEYSTORE, fInfo.signingInfo[1]);
            fAntBuildProperties.put(IXMLConstants.PROPERTY_SIGN_STOREPASS, fInfo.signingInfo[2]);
            fAntBuildProperties.put(IXMLConstants.PROPERTY_SIGN_KEYPASS, fInfo.signingInfo[3]);
        }
        if (fInfo.jnlpInfo != null) {
            fAntBuildProperties.put(IXMLConstants.PROPERTY_JNLP_CODEBASE, fInfo.jnlpInfo[0]);
            fAntBuildProperties.put(IXMLConstants.PROPERTY_JNLP_J2SE, fInfo.jnlpInfo[1]);
        }
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BUILD_TEMP, fBuildTempLocation + "/destination");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_FEATURE_TEMP_FOLDER, fBuildTempLocation + "/destination");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_INCLUDE_CHILDREN, "true");
        fAntBuildProperties.put("eclipse.running", "true");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_GENERATE_API_DESCRIPTION, "true");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BASE_OS, TargetPlatform.getOS());
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BASE_WS, TargetPlatform.getWS());
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BASE_ARCH, TargetPlatform.getOSArch());
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BASE_NL, TargetPlatform.getNL());
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BOOTCLASSPATH, BuildUtilities.getBootClasspath());
        IExecutionEnvironmentsManager manager = JavaRuntime.getExecutionEnvironmentsManager();
        IExecutionEnvironment[] envs = manager.getExecutionEnvironments();
        for (int i = 0; i < envs.length; i++) {
            String id = envs[i].getId();
            if (id != null)
                fAntBuildProperties.put(id, BuildUtilities.getBootClasspath(id));
        }
        fAntBuildProperties.put(IXMLConstants.PROPERTY_JAVAC_FAIL_ON_ERROR, "false");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_JAVAC_DEBUG_INFO, "on");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_JAVAC_VERBOSE, "false");
        IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(JavaCore.PLUGIN_ID);
        IEclipsePreferences def = DefaultScope.INSTANCE.getNode(JavaCore.PLUGIN_ID);
        String source = prefs.get(JavaCore.COMPILER_SOURCE, null);
        if (source == null) {
            source = def.get(JavaCore.COMPILER_SOURCE, null);
        }
        if (source != null) {
            fAntBuildProperties.put(IXMLConstants.PROPERTY_JAVAC_SOURCE, source);
        }
        String target = prefs.get(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, null);
        if (target == null) {
            target = def.get(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, null);
        }
        if (target != null) {
            fAntBuildProperties.put(IXMLConstants.PROPERTY_JAVAC_TARGET, target);
        }
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BUILD_DIRECTORY, fBuildTempLocation + "/assemblyLocation");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_BUILD_LABEL, ".");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_COLLECTING_FOLDER, ".");
        String prefix = Platform.getOS().equals("macosx") ? "." : "";
        fAntBuildProperties.put(IXMLConstants.PROPERTY_ARCHIVE_PREFIX, prefix);
        fAntBuildProperties.put(IXMLConstants.PROPERTY_TAR_ARGS, "");
        fAntBuildProperties.put(IXMLConstants.PROPERTY_RUN_PACKAGER, "true");
    }
    setP2MetaDataProperties(fAntBuildProperties);
    return fAntBuildProperties;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.apache.batik.css.parser.DefaultPseudoClassCondition.toString()java.lang.String;1
public String toString() {
    return ":" + getValue();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.ui.ide.IDE.openEditor(org.eclipse.ui.IWorkbenchPage;org.eclipse.core.resources.IMarker;)org.eclipse.ui.IEditorPart;2
public static IEditorPart openEditor(IWorkbenchPage page, IMarker marker) throws PartInitException {
    return openEditor(page, marker, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.updatesite.DefaultSiteParser.debug(java.lang.String;)V1
private static void debug(String s) {
    Tracing.debug("DefaultSiteParser: " + s);
}
---------------Client-------------------
method: org.eclipse.equinox.http.jetty.JettyConfigurator.stopServer(java.lang.String;)V1
public static void stopServer(String id) throws Exception {
    checkConfigurationPermission();
    Activator.stopServer(PID_PREFIX + id);
}

---------------Library-------------------
method: org.eclipse.emf.common.util.BasicEMap$BasicEMapIterator.hasNext()Z1
public boolean hasNext() {
    return entryCursor != -1;
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.AnnotationTypeLookup$AnnotationTypeMapping.isMarkerSeverityDefined()Z1
boolean isMarkerSeverityDefined() {
    return fMarkerSeverity != UNDEFINED;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.correction.JavaCorrectionAssistant$1.assistSessionStarted(org.eclipse.jface.text.contentassist.ContentAssistEvent;)V2
public void assistSessionStarted(ContentAssistEvent event) {
    fIsCompletionActive = true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.xml.properties.css2.CSSPropertyTextXMLHandler.retrieveCSSPropertyColor(java.lang.Object;org.eclipse.e4.ui.css.core.engine.CSSEngine;)java.lang.String;3
public String retrieveCSSPropertyColor(Object node, CSSEngine engine) throws Exception {
    Element element = (Element) node;
    return element.getAttribute("color");
}
---------------Client-------------------
method: org.eclipse.ui.internal.statushandlers.StatusHandlerDescriptorsMap.getAsteriskList(java.util.Map;)java.util.List;2
private List getAsteriskList(Map map) {
    Object list = map.get(ASTERISK);
    if (list != null) {
        return (List) list;
    }
    return null;
}

---------------Library-------------------
method: org.apache.batik.css.parser.DefaultConditionFactory.createContentCondition(java.lang.String;)org.w3c.css.sac.ContentCondition;2
public ContentCondition createContentCondition(String data) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.WebappPreferences.setDontConfirmShowAll(Z)V2
public void setDontConfirmShowAll(boolean dontconfirm) {
    setBooleanPreference("dontConfirmShowAll", dontconfirm);
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.util.AptConfig.setProcessDuringReconcile(org.eclipse.jdt.core.IJavaProject;Z)V2
public static void setProcessDuringReconcile(IJavaProject jproject, boolean enabled) {
    setBoolean(jproject, AptPreferenceConstants.APT_RECONCILEENABLED, enabled);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.getNestingKind()javax.lang.model.element.NestingKind;1
@Override
public NestingKind getNestingKind() {
    throw new  UnsupportedOperationException("Not yet implemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.javadoc.JavaDocScanner$HTMLCommentDetector.isWordPart(C)Z2
public boolean isWordPart(char c) {
    return (c == '-' || c == '!' || c == '>');
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.PasteAction$TypedSourcePaster$PasteTypedSourcesRefactoring.canPasteToCu(I)Z1
private static boolean canPasteToCu(int elementType) {
    return elementType == IJavaElement.PACKAGE_DECLARATION || elementType == IJavaElement.TYPE || elementType == IJavaElement.IMPORT_DECLARATION;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.schema.BaseSchemaHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(""));
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
@Override
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(IAntCoreConstants.EMPTY_STRING));
}

---------------Library-------------------
method: org.eclipse.jface.text.DocumentCommand.updateCaret()Z1
private boolean updateCaret() {
    return shiftsCaret && caretOffset != -1;
}
---------------Client-------------------
method: org.eclipse.equinox.p2.internal.repository.tools.RepositoryDescriptor.isMetadata()Z1
public boolean isMetadata() {
    return kind == TYPE_BOTH || kind == IRepository.TYPE_METADATA;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleRuleImpl.getCSSPropertyList()org.eclipse.e4.ui.css.core.dom.CSSPropertyList;1
@Override
public CSSPropertyList getCSSPropertyList() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.getTemplate(java.lang.String;org.eclipse.jdt.core.ICompilationUnit;)java.lang.String;3
protected String getTemplate(String name, ICompilationUnit parentCU) {
    return getTemplate(name, parentCU, 0);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.MarkerInfo.getAttributes()java.util.Map;1
public Map<String, Object> getAttributes() {
    return getAttributes(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.isSearchRequest()Z1
public boolean isSearchRequest() {
    String searchWordParam = request.getParameter("searchWord");
    return (searchWordParam != null && searchWordParam.length() > 0);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.DeltaProcessingState.getTimeStampsFile()java.io.File;1
private File getTimeStampsFile() {
    return JavaCore.getPlugin().getStateLocation().append("externalLibsTimeStamps").toFile();
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.FactoryPathUtil.getFileForWorkspace()java.io.File;0
private static File getFileForWorkspace() {
    return AptPlugin.getPlugin().getStateLocation().append(FACTORYPATH_FILE).toFile();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.OverflowingLRUCache.privateRemoveEntry(org.eclipse.jdt.internal.core.util.LRUCache$LRUCacheEntry;Z)V3
protected void privateRemoveEntry(LRUCacheEntry entry, boolean shuffle) {
    privateRemoveEntry(entry, shuffle, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleErrorToken(java.lang.String;Z)V3
protected void handleErrorToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.team.ui.mapping.SynchronizationContentProvider.getChildren(java.lang.Object;)Ajava.lang.Object;2
public Object[] getChildren(Object parent) {
    return internalGetChildren(parent, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.GenerateHashCodeEqualsOperation.getThisAccessForEquals(java.lang.String;)org.eclipse.jdt.core.dom.Expression;2
private Expression getThisAccessForEquals(String name) {
    return getThisAccess(name, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.director.ProfileChangeRequest.setProfile(org.eclipse.equinox.p2.engine.IProfile;)V2
public void setProfile(IProfile profile) {
    if (profile == null)
        throw new  IllegalArgumentException("Profile cannot be null.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsTCModel.createAssignmentElementConstraints(org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;)V3
public void createAssignmentElementConstraints(ConstraintVariable2 cv, ConstraintVariable2 initializerCv) {
    internalCreateElementEqualsConstraints(cv, initializerCv, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.genericInferenceError(java.lang.String;org.eclipse.jdt.internal.compiler.lookup.InvocationSite;)V3
public void genericInferenceError(String message, InvocationSite invocationSite) {
    genericInferenceProblem(message, invocationSite, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.jetty.io.ByteArrayEndPoint.close()V1
public void close() throws IOException {
    _closed = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSConditionFactoryImpl.createOnlyTypeCondition()org.w3c.css.sac.Condition;1
@Override
public Condition createOnlyTypeCondition() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jface.text.source.LineNumberRulerColumn.getWidth()I1
public int getWidth() {
    return fIndentation[0];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckInitialConditionsTicks()I1
public int getCheckInitialConditionsTicks() {
    return fValues[CHECK_INITIAL_CONDITIONS];
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.getKind()javax.tools.JavaFileObject$Kind;1
@Override
public Kind getKind() {
    throw new  UnsupportedOperationException("Not yet implemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Resource.isFiltered()Z1
public boolean isFiltered() {
    try {
        return isFilteredWithException(false);
    } catch (CoreException e) {
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpParser.isComplete()Z1
public boolean isComplete() {
    return isState(STATE_END);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.misc.CheckboxTreeAndListGroup.initialCheckTreeItem(java.lang.Object;)V2
public void initialCheckTreeItem(Object element) {
    treeItemChecked(element, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.osgi.internal.signedcontent.DigestedInputStream.reset()V1
public synchronized void reset() throws IOException {
    throw new  IOException("Reset not supported");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.parts.MessageLine.setErrorStatus(org.eclipse.core.runtime.IStatus;)V2
public void setErrorStatus(IStatus status) {
    if (status != null) {
        String message = status.getMessage();
        if (message != null && message.length() > 0) {
            setText(message);
            setImage(findImage(status));
            if (fErrorMsgAreaBackground == null) {
                fErrorMsgAreaBackground = new  Color(getDisplay(), ERROR_BACKGROUND_RGB);
            }
            setBackground(fErrorMsgAreaBackground);
            return;
        }
    }
    setText("");
    setImage(null);
    setBackground(fNormalMsgAreaBackground);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.MessageLine.setErrorStatus(org.eclipse.core.runtime.IStatus;)V2
public void setErrorStatus(IStatus status) {
    if (status != null) {
        String message = status.getMessage();
        if (message != null && message.length() > 0) {
            setText(message);
            setImage(findImage(status));
            if (fErrorMsgAreaBackground == null) {
                fErrorMsgAreaBackground = new  Color(getDisplay(), ERROR_BACKGROUND_RGB);
            }
            setBackground(fErrorMsgAreaBackground);
            return;
        }
    }
    setText(IAntCoreConstants.EMPTY_STRING);
    setImage(null);
    setBackground(fNormalMsgAreaBackground);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.tagAsHavingErrors()V1
public void tagAsHavingErrors() {
    this.ignoreFurtherInvestigation = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit$1.removeEldestEntry(java.util.Map$Entry;)Z2
public boolean removeEldestEntry(Map.Entry<IFilterExpression, IMatchExpression<IInstallableUnit>> expr) {
    return size() > 64;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsModel$1.removeEldestEntry(java.util.Map$Entry;)Z2
@Override
protected final boolean removeEldestEntry(Map.Entry<String, TType> entry) {
    return size() > MAX_CACHE;
}

---------------Library-------------------
method: org.eclipse.jface.text.link.LinkedPositionGroup.isEmpty()Z1
public boolean isEmpty() {
    return fPositions.size() == 0;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$StatusWrapper.isOK()Z1
public boolean isOK() {
    return diagnostic.getSeverity() == OK;
}

---------------Library-------------------
method: org.eclipse.jface.text.source.SourceViewerConfiguration.getIndentPrefixes(org.eclipse.jface.text.source.ISourceViewer;java.lang.String;)Ajava.lang.String;3
public String[] getIndentPrefixes(ISourceViewer sourceViewer, String contentType) {
    return new String[] { "\t", "    ", "" };
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxySelector.getProviders()Ajava.lang.String;0
public static String[] getProviders() {
    return new String[] { DIRECT_PROVIDER, ECLIPSE_PROVIDER, NATIVE_PROVIDER };
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EObjectContainmentEList$Unsettable.didChange()V1
@Override
protected void didChange() {
    isSet = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.CallInliner$InlineEvaluator.setResult(Z)Z2
private boolean setResult(boolean result) {
    fResult = result;
    return false;
}
---------------Client-------------------
method: org.eclipse.swt.browser.Mozilla.SetChromeFlags(I)I2
int SetChromeFlags(int aChromeFlags) {
    chromeFlags = aChromeFlags;
    return XPCOM.NS_OK;
}

---------------Library-------------------
method: org.eclipse.e4.ui.workbench.swt.internal.copy.FilteredTree.clearText()V1
protected void clearText() {
    setFilterText("");
    textChanged();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSSourcePage.initializeEditor()V1
protected void initializeEditor() {
    super.initializeEditor();
    setHelpContextId(IHelpContextIds.SIMPLE_CS_EDITOR);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.declaration.ASTBasedAnnotationElementDeclarationImpl.isVarArgs()Z1
public boolean isVarArgs() {
    return false;
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.AbstractObservableSet.fireChange()V1
protected void fireChange() {
    throw new  RuntimeException("fireChange should not be called, use fireSetChange() instead");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.equinox.bidi.custom.StructuredTextTypeHandler.processSpecial(org.eclipse.equinox.bidi.advanced.IStructuredTextExpert;java.lang.String;org.eclipse.equinox.bidi.custom.StructuredTextCharTypes;org.eclipse.equinox.bidi.custom.StructuredTextOffsets;II)I7
public int processSpecial(IStructuredTextExpert expert, String text, StructuredTextCharTypes charTypes, StructuredTextOffsets offsets, int caseNumber, int separLocation) {
    throw new  IllegalStateException("A handler with specialsCount > 0 must have a processSpecial() method.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.store.ChecksumIndexOutput.seek(J)V2
@Override
public void seek(long pos) {
    throw new  RuntimeException("not allowed");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyClassificationHandler.applyCSSPropertyFloat(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyFloat(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("float");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryType.getFullyQualifiedName(C)java.lang.String;2
public String getFullyQualifiedName(char enclosingTypeSeparator) {
    try {
        return getFullyQualifiedName(enclosingTypeSeparator, false);
    } catch (JavaModelException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.objectweb.asm.tree.InsnList.clear()V1
public void clear() {
    removeAll(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.JavaOutlinePage$LexicalSortingAction.run()V1
@Override
public void run() {
    valueChanged(isChecked(), true);
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.ViewerSettingsAndStatusDialog.initializeDialog()V1
protected void initializeDialog() {
    handleStatusUdpate(IStatus.INFO, getDefaultMessage());
}

---------------Library-------------------
method: org.eclipse.jface.internal.databinding.viewers.ObservableCollectionTreeContentProvider.getChildren(java.lang.Object;)Ajava.lang.Object;2
public Object[] getChildren(Object element) {
    return getChildren(element, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.WorkbenchPlugin.log(java.lang.Class;java.lang.String;java.lang.Throwable;)V3
public static void log(Class clazz, String methodName, Throwable t) {
    String msg = MessageFormat.format("Exception in {0}.{1}: {2}", new Object[] { clazz.getName(), methodName, t });
    log(msg, t);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewContainerWizardPage.getMaxFieldWidth()I1
protected int getMaxFieldWidth() {
    return convertWidthInCharsToPixels(40);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.SimpleLog.isFatalEnabled()Z1
public final boolean isFatalEnabled() {
    return isLevelEnabled(SimpleLog.LOG_LEVEL_FATAL);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.LayoutData.getVisibleView()java.lang.String;1
public String getVisibleView() {
    String requestedView = request.getParameter("tab");
    AbstractView[] allViews = getViews();
    for (int i = 0; i < allViews.length; i++) {
        if (allViews[i].getName().equals(requestedView)) {
            return requestedView;
        }
    }
    return "toc";
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.JavaDebugOptionsManager$InitJob.run(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.IStatus;2
@Override
protected IStatus run(IProgressMonitor monitor) {
    MultiStatus status = new  MultiStatus(JDIDebugUIPlugin.getUniqueIdentifier(), IJavaDebugUIConstants.INTERNAL_ERROR, "Java debug options failed to initialize", null);
    try {
        IJavaExceptionBreakpoint bp = JDIDebugModel.createExceptionBreakpoint(ResourcesPlugin.getWorkspace().getRoot(), "java.lang.Error", true, true, false, false, null);
        bp.setPersisted(false);
        bp.addBreakpointListener(SuspendOnCompilationErrorListener.ID_COMPILATION_ERROR_LISTENER);
        setSuspendOnCompilationErrorsBreakpoint(bp);
    } catch (CoreException e) {
        status.add(e.getStatus());
    }
    try {
        IJavaExceptionBreakpoint bp = JDIDebugModel.createExceptionBreakpoint(ResourcesPlugin.getWorkspace().getRoot(), "java.lang.Throwable", false, true, false, false, null);
        ((JavaExceptionBreakpoint) bp).setSuspendOnSubclasses(true);
        bp.setPersisted(false);
        bp.addBreakpointListener(SuspendOnUncaughtExceptionListener.ID_UNCAUGHT_EXCEPTION_LISTENER);
        setSuspendOnUncaughtExceptionBreakpoint(bp);
    } catch (CoreException e) {
        status.add(e.getStatus());
    }
    if (status.getChildren().length == 0) {
        return Status.OK_STATUS;
    }
    return status;
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialogTabPage$DefaultFocusManager.isUsed()Z1
public boolean isUsed() {
    return fIndex != 0;
}
---------------Client-------------------
method: org.eclipse.jetty.http.AbstractGenerator.isCommitted()Z1
public boolean isCommitted() {
    return _state != STATE_HEADER;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.InternalCompletionContext.setExtended()V1
protected void setExtended() {
    this.isExtended = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$StopAction.run()V1
@Override
public void run() {
    stopTest();
    setEnabled(false);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathContentProvider.removeAllGlobalAntClasspathEntries()V1
public void removeAllGlobalAntClasspathEntries() {
    model.removeAll(ClasspathModel.ANT_HOME);
    refresh();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSUtil.getInsertionPosition(java.lang.String;java.util.List;)I2
public static int getInsertionPosition(String key, List<String> keys) {
    int result = 0;
    int invertDistance = Integer.MIN_VALUE;
    int i = 0;
    for (Iterator<String> iterator = keys.iterator(); iterator.hasNext(); ) {
        String string = iterator.next();
        int currentInvertDistance = invertDistance(key, string);
        if (currentInvertDistance > invertDistance) {
            invertDistance = currentInvertDistance;
            if (Collator.getInstance().compare(key, string) >= 0) {
                result = i;
            } else {
                result = i - 1;
            }
        } else if (currentInvertDistance == invertDistance) {
            if (Collator.getInstance().compare(key, string) >= 0) {
                result = i;
            }
        }
        i++;
    }
    return result;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.doOpenIfChanged(org.apache.lucene.index.IndexCommit;)org.apache.lucene.index.IndexReader;2
protected IndexReader doOpenIfChanged(final IndexCommit commit) throws CorruptIndexException, IOException {
    throw new  UnsupportedOperationException("This reader does not support reopen(IndexCommit).");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.infoviews.JavadocView$1.open(org.eclipse.swt.browser.WindowEvent;)V2
public void open(WindowEvent event) {
    event.required = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jface.internal.text.SelectionProcessor$2.replace(org.eclipse.jface.viewers.ISelection;java.lang.String;)org.eclipse.text.edits.TextEdit;3
TextEdit replace(ISelection selection, String replacement) throws BadLocationException {
    return replace(selection, replacement, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.apache.lucene.search.CachingSpanFilter$1.mergeDeletes(org.apache.lucene.index.IndexReader;org.apache.lucene.search.SpanFilterResult;)org.apache.lucene.search.SpanFilterResult;3
@Override
protected SpanFilterResult mergeDeletes(final IndexReader reader, final SpanFilterResult value) {
    throw new  IllegalStateException("DeletesMode.DYNAMIC is not supported");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.added(org.eclipse.jdt.core.IJavaElement;)V2
public void added(IJavaElement element) {
    added(element, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.ui.internal.wizards.datatransfer.WizardFileSystemResourceImportPage1$11.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    entryChanged = true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.osgi.framework.internal.reliablefile.ReliableFileInputStream.reset()V1
public void reset() throws IOException {
    throw new  IOException("reset not supported.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jface.resource.ColorRegistry.put(java.lang.String;org.eclipse.swt.graphics.RGB;)V3
public void put(String symbolicName, RGB colorData) {
    put(symbolicName, colorData, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.genericInferenceError(java.lang.String;org.eclipse.jdt.internal.compiler.lookup.InvocationSite;)V3
public void genericInferenceError(String message, InvocationSite invocationSite) {
    genericInferenceProblem(message, invocationSite, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceMethod.getKey()java.lang.String;1
public String getKey() {
    try {
        return getKey(this, false);
    } catch (JavaModelException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.propertiesfileeditor.PropertiesFileSourceViewerConfiguration.getDefaultPrefixes(org.eclipse.jface.text.source.ISourceViewer;java.lang.String;)Ajava.lang.String;3
@Override
public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
    return new String[] { "#", "" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor$3.getShowInTargetIds()Ajava.lang.String;1
@Override
public String[] getShowInTargetIds() {
    return new String[] { JavaUI.ID_PACKAGES, IPageLayout.ID_PROJECT_EXPLORER };
}

---------------Library-------------------
method: org.eclipse.jface.internal.databinding.viewers.ObservableCollectionTreeContentProvider.getElements(java.lang.Object;)Ajava.lang.Object;2
public Object[] getElements(Object input) {
    return getChildren(input, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.IfStatement.memSize()I1
int memSize() {
    return super.memSize() + 3 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.jdt.junit.launcher.JUnitLaunchConfigurationTab.updateProjectFromConfig(org.eclipse.debug.core.ILaunchConfiguration;)V2
private void updateProjectFromConfig(ILaunchConfiguration config) {
    String projectName = "";
    try {
        projectName = config.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, "");
    } catch (CoreException ce) {
    }
    fProjText.setText(projectName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.debug.ui.launcher.AbstractJavaMainTab.updateProjectFromConfig(org.eclipse.debug.core.ILaunchConfiguration;)V2
private void updateProjectFromConfig(ILaunchConfiguration config) {
    String projectName = EMPTY_STRING;
    try {
        projectName = config.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, EMPTY_STRING);
    } catch (CoreException ce) {
        setErrorMessage(ce.getStatus().getMessage());
    }
    fProjText.setText(projectName);
}

---------------Library-------------------
method: org.eclipse.swt.graphics.GC.stringExtent(java.lang.String;)org.eclipse.swt.graphics.Point;2
public Point stringExtent(String string) {
    return textExtent(string, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.JavaPartitionScanner$EmptyCommentDetector.isWordPart(C)Z2
public boolean isWordPart(char c) {
    return (c == '*' || c == '/');
}
---------------Client-------------------
method: org.eclipse.jface.text.source.AnnotationPainter.isRepaintReason(I)Z2
protected boolean isRepaintReason(int reason) {
    return CONFIGURATION == reason || INTERNAL == reason;
}

---------------Library-------------------
method: org.eclipse.jface.text.MarkSelection.isEmpty()Z1
public boolean isEmpty() {
    return fLength == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration.memSize()I1
int memSize() {
    return super.memSize() + 3 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.jface.text.TextPresentation.getAllStyleRangeIterator()java.util.Iterator;1
public Iterator getAllStyleRangeIterator() {
    return new  FilterIterator(false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ant.core.Property.getValue()java.lang.String;1
public String getValue() {
    return getValue(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.ui.internal.commands.CommandStateProxy.loadState()Z1
private final boolean loadState() {
    return loadState(false);
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpParser.isComplete()Z1
public boolean isComplete() {
    return isState(STATE_END);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.OpenImplementationAction.selectionChanged(org.eclipse.jface.viewers.IStructuredSelection;)V2
@Override
public void selectionChanged(IStructuredSelection selection) {
    setEnabled(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.ide.PerspectiveTemplate.getNewFiles()Ajava.lang.String;1
public String[] getNewFiles() {
    return new String[] { "icons/" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntElementAdapterFactory.getAdapterList()Ajava.lang.Class;1
@Override
public Class[] getAdapterList() {
    return new Class[] { IResource.class };
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.FunctionalExpression.tagAsEllipsisArgument()V1
public void tagAsEllipsisArgument() {
    this.ellipsisArgument = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.core.internal.expressions.TypeExtensionManager.getProperty(java.lang.Object;java.lang.String;java.lang.String;)org.eclipse.core.internal.expressions.Property;4
public Property getProperty(Object receiver, String namespace, String method) throws CoreException {
    return getProperty(receiver, namespace, method, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.createImport(java.lang.String;org.eclipse.jdt.core.IJavaElement;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IImportDeclaration;4
public IImportDeclaration createImport(String importName, IJavaElement sibling, IProgressMonitor monitor) throws JavaModelException {
    return createImport(importName, sibling, Flags.AccDefault, monitor);
}

---------------Library-------------------
method: org.eclipse.update.internal.configurator.PlatformConfiguration$1.accept(java.io.File;)Z2
public boolean accept(File pathname) {
    return pathname.isFile() && pathname.getName().endsWith(".xml");
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.SimpleProfileRegistry$2.accept(java.io.File;)Z2
public boolean accept(File pathname) {
    return pathname.getName().endsWith(PROFILE_EXT) && pathname.isDirectory();
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.stringsubstitution.StringVariablePresentationManager.initialize()V1
private void initialize() {
    fConfigurations = new  HashMap<String, IConfigurationElement>();
    IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(DebugUIPlugin.getUniqueIdentifier(), EXTENSION_POINT_STRING_VARIABLE_PRESENTATIONS);
    IConfigurationElement elements[] = point.getConfigurationElements();
    for (int i = 0; i < elements.length; i++) {
        IConfigurationElement element = elements[i];
        String name = element.getAttribute(ATTR_NAME);
        if (name == null) {
            DebugUIPlugin.logErrorMessage(MessageFormat.format("String variable presentation extension missing required 'variableName' attribute: {0}", new Object[] { element.getDeclaringExtension().getLabel() }));
            continue;
        }
        fConfigurations.put(name, element);
    }
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.ProvisioningPlan.getRemovals()org.eclipse.equinox.p2.query.IQueryable;1
public IQueryable<IInstallableUnit> getRemovals() {
    return new  QueryablePlan(false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.ide.IDE.openEditor(org.eclipse.ui.IWorkbenchPage;org.eclipse.core.resources.IFile;Z)org.eclipse.ui.IEditorPart;3
public static IEditorPart openEditor(IWorkbenchPage page, IFile input, boolean activate) throws PartInitException {
    return openEditor(page, input, activate, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.correction.java.FindClassResolutionsOperation$AbstractClassResolutionCollector.addRequireBundleModification(org.eclipse.core.resources.IProject;org.eclipse.osgi.service.resolver.ExportPackageDescription;I)java.lang.Object;4
public Object addRequireBundleModification(IProject project, ExportPackageDescription desc, int relevance) {
    return JavaResolutionFactory.createRequireBundleProposal(project, desc, JavaResolutionFactory.TYPE_JAVA_COMPLETION, relevance);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.impl.ByteConstant.toString()java.lang.String;1
public String toString() {
    return "(byte)" + this.value;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager$CustomProfile.getID()java.lang.String;1
@Override
public String getID() {
    return ID_PREFIX + fName;
}

---------------Library-------------------
method: org.apache.lucene.index.IndexWriter.keepFullyDeletedSegments()V1
void keepFullyDeletedSegments() {
    keepFullyDeletedSegments = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xml.type.internal.DataValue$XMLChar.isMarkup(I)Z1
public static boolean isMarkup(int c) {
    return c == '<' || c == '&' || c == '%';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.PasteAction$TypedSourcePaster$PasteTypedSourcesRefactoring.canPasteToCu(I)Z1
private static boolean canPasteToCu(int elementType) {
    return elementType == IJavaElement.PACKAGE_DECLARATION || elementType == IJavaElement.TYPE || elementType == IJavaElement.IMPORT_DECLARATION;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.TypeFilterPreferencePage.performDefaults()V1
@Override
protected void performDefaults() {
    initialize(true);
    super.performDefaults();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.JavaElementChangeListener.start()V1
public void start() {
    JavaCore.addElementChangedListener(this, ElementChangedEvent.POST_CHANGE);
    load();
}

---------------Library-------------------
method: org.apache.lucene.store.ChecksumIndexInput.seek(J)V2
@Override
public void seek(long pos) {
    throw new  RuntimeException("not allowed");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.RectImpl.getRight()org.w3c.dom.css.CSSPrimitiveValue;1
@Override
public CSSPrimitiveValue getRight() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.ide.HelpTemplate.getNewFiles()Ajava.lang.String;1
public String[] getNewFiles() {
    return new String[] { "html/", "*.xml" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor$3.getShowInTargetIds()Ajava.lang.String;1
@Override
public String[] getShowInTargetIds() {
    return new String[] { JavaUI.ID_PACKAGES, IPageLayout.ID_PROJECT_EXPLORER };
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl.createCommentSelector(java.lang.String;)org.w3c.css.sac.CharacterDataSelector;2
@Override
public CharacterDataSelector createCommentSelector(String data) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.swt.custom.TableTreeItem.setText(java.lang.String;)V2
@Override
public void setText(String string) {
    setText(0, string);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.formatter.XmlDocumentFormatter.isLineDelimiterChar(C)Z1
public static boolean isLineDelimiterChar(char ch) {
    return ch == '\n' || ch == '\r';
}
---------------Client-------------------
method: org.eclipse.jface.text.source.AnnotationPainter.isRepaintReason(I)Z2
protected boolean isRepaintReason(int reason) {
    return CONFIGURATION == reason || INTERNAL == reason;
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.DialogMarkerFilter.markDirty()V1
void markDirty() {
    dirty = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.core.internal.localstore.Bucket$Entry.isEmpty()Z1
public boolean isEmpty() {
    return getOccurrences() == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.Binding.isValidBinding()Z1
public final boolean isValidBinding() {
    return problemId() == ProblemReasons.NoError;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.variables.VariablesView$9.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event event) {
    fTreeHasFocus = false;
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser.parse()V1
public void parse() {
    parse(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.visit(org.eclipse.jdt.core.dom.NumberLiteral;)Z2
@Override
public boolean visit(NumberLiteral node) {
    this.fBuffer.append(node.getToken());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.TagRefreshButtonArea$1.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event event) {
    refresh(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.DoStatement.memSize()I1
int memSize() {
    return super.memSize() + 2 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.ui.internal.wizards.datatransfer.WizardArchiveFileResourceImportPage1.resetSelection()V1
protected void resetSelection() {
    super.resetSelection();
    setAllSelections(true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.JavaElementChangeListener.start()V1
public void start() {
    JavaCore.addElementChangedListener(this, ElementChangedEvent.POST_CHANGE);
    load();
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.BrowserExt.getOS()java.lang.String;1
public String getOS() {
    String os = element.getAttribute("os");
    if (os == null)
        os = "";
    return os;
}
---------------Client-------------------
method: org.eclipse.ui.internal.registry.WorkingSetDescriptor.getDescription()java.lang.String;1
public String getDescription() {
    String description = configElement.getAttribute(IWorkbenchRegistryConstants.ATT_DESCRIPTION);
    if (description == null)
        description = "";
    return description;
}

---------------Library-------------------
method: org.eclipse.swt.custom.CLabel.setBackground(Aorg.eclipse.swt.graphics.Color;AI)V3
public void setBackground(Color[] colors, int[] percents) {
    setBackground(colors, percents, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.create(org.eclipse.core.resources.IProjectDescription;org.eclipse.core.runtime.IProgressMonitor;)V3
public void create(IProjectDescription description, IProgressMonitor monitor) throws CoreException {
    create(description, IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.ant.core.AntCorePreferences.getCustomPropertyFiles()Ajava.lang.String;1
public String[] getCustomPropertyFiles() {
    return getCustomPropertyFiles(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.team.internal.core.StorageMergerRegistry.initializeRegistry()V1
private void initializeRegistry() {
    if (!fRegistriesInitialized) {
        registerExtensions();
        fRegistriesInitialized = true;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.ui.internal.cheatsheets.views.ViewItem.initialized()V1
public void initialized() {
    initialized = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyClassBodyDeclarationsopt()V1
protected void consumeEmptyClassBodyDeclarationsopt() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.observable.DelayedObservableValue$ValueUpdater.cancel()V1
void cancel() {
    cancel = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jface.text.TextViewer.enabledRedrawing()V1
protected void enabledRedrawing() {
    enabledRedrawing(-1);
}
---------------Client-------------------
method: org.eclipse.jface.viewers.AbstractTreeViewer.expandAll()V1
public void expandAll() {
    expandToLevel(ALL_LEVELS);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.impl.CharConstant.toString()java.lang.String;1
public String toString() {
    return "(char)" + this.value;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager$CustomProfile.getID()java.lang.String;1
@Override
public String getID() {
    return ID_PREFIX + fName;
}

---------------Library-------------------
method: org.eclipse.core.internal.registry.CombinedEventDelta.recordAddition()org.eclipse.core.internal.registry.CombinedEventDelta;0
public static CombinedEventDelta recordAddition() {
    return new  CombinedEventDelta(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.SuperReference.implicitSuperConstructorCall()org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;0
public static ExplicitConstructorCall implicitSuperConstructorCall() {
    return new  ExplicitConstructorCall(ExplicitConstructorCall.ImplicitSuper);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtCaptureStart()Z1
boolean isAtCaptureStart() {
    return this.index < this.source.length && this.source[this.index] == '!';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtFieldOrMethodStart()Z1
boolean isAtFieldOrMethodStart() {
    return this.index < this.source.length && this.source[this.index] == '.';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.jface.text.TextPresentation.mergeStyleRanges(Aorg.eclipse.swt.custom.StyleRange;)V2
public void mergeStyleRanges(StyleRange[] ranges) {
    applyStyleRanges(ranges, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeFilerImpl.createClassFile(java.lang.CharSequence;Ajavax.lang.model.element.Element;)javax.tools.JavaFileObject;3
@Override
public JavaFileObject createClassFile(CharSequence name, Element... originatingElements) throws IOException {
    throw new  UnsupportedOperationException("Creating class files is not yet implemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.plugins.PluginDescriptor.setActive()V1
public synchronized void setActive() {
    this.active = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.application.IDEWorkbenchWindowAdvisor$3.perspectiveDeactivated(org.eclipse.ui.IWorkbenchPage;org.eclipse.ui.IPerspectiveDescriptor;)V3
public void perspectiveDeactivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
    updateTitle(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.emf.common.util.CommonUtil$StringPool$CharSequenceAccessUnit.getInternalizedValue()java.lang.String;1
@Override
public String getInternalizedValue() {
    return new  String(buffer, 0, count);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover$InformationControlCreator.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  AnnotationExpansionControl(parent, SWT.NONE, fAnnotationAccess);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.ContentAssistProcessor$CompletionListener.assistSessionRestarted(org.eclipse.jface.text.contentassist.ContentAssistEvent;)V2
public void assistSessionRestarted(ContentAssistEvent event) {
    fRepetition = 0;
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.osgi.storage.Storage$1.connect()V1
public void connect() throws IOException {
    connected = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaProject.defaultOutputLocation()org.eclipse.core.runtime.IPath;1
protected IPath defaultOutputLocation() {
    return this.project.getFullPath().append("bin");
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.TouchpointManager$TouchpointEntry.getVersion()org.eclipse.equinox.p2.metadata.Version;1
public Version getVersion() {
    try {
        return Version.create(element.getAttribute(ATTRIBUTE_VERSION));
    } catch (InvalidRegistryObjectException e) {
        return null;
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.Activator.getInstallURL()java.net.URL;1
public URL getInstallURL() {
    return getDefault().getBundle().getEntry("/");
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.connection.CVSRepositoryLocation.getParentPreferences()org.osgi.service.prefs.Preferences;0
public static Preferences getParentPreferences() {
    return CVSProviderPlugin.getPlugin().getInstancePreferences().node(PREF_REPOSITORIES_NODE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.XMLDefaultHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(""));
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
@Override
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(IAntCoreConstants.EMPTY_STRING));
}

---------------Library-------------------
method: org.eclipse.equinox.http.jetty.internal.HttpServerManager.createHttpsConnector(java.util.Dictionary;)org.eclipse.jetty.server.Connector;2
@SuppressWarnings("deprecation")
private Connector createHttpsConnector(@SuppressWarnings("rawtypes") Dictionary dictionary) {
    Boolean httpsEnabled = null;
    Object httpsEnabledObj = dictionary.get(JettyConstants.HTTPS_ENABLED);
    if (httpsEnabledObj instanceof Boolean) {
        httpsEnabled = (Boolean) httpsEnabledObj;
    } else if (httpsEnabledObj instanceof String) {
        httpsEnabled = Boolean.parseBoolean(httpsEnabledObj.toString());
    }
    if (httpsEnabled == null || !httpsEnabled.booleanValue())
        return null;
    Integer httpsPort = null;
    Object httpsPortObj = dictionary.get(JettyConstants.HTTPS_PORT);
    if (httpsPortObj instanceof Integer) {
        httpsPort = (Integer) httpsPortObj;
    } else if (httpsPortObj instanceof String) {
        httpsPort = Integer.valueOf(httpsPortObj.toString());
    }
    if (httpsPort == null)
        return null;
    SslSocketConnector sslConnector = new  SslSocketConnector();
    sslConnector.setPort(httpsPort.intValue());
    String httpsHost = (String) dictionary.get(JettyConstants.HTTPS_HOST);
    if (httpsHost != null) {
        sslConnector.setHost(httpsHost);
    }
    String keyStore = (String) dictionary.get(JettyConstants.SSL_KEYSTORE);
    if (keyStore != null)
        sslConnector.setKeystore(keyStore);
    String password = (String) dictionary.get(JettyConstants.SSL_PASSWORD);
    if (password != null)
        sslConnector.setPassword(password);
    String keyPassword = (String) dictionary.get(JettyConstants.SSL_KEYPASSWORD);
    if (keyPassword != null)
        sslConnector.setKeyPassword(keyPassword);
    Object needClientAuth = dictionary.get(JettyConstants.SSL_NEEDCLIENTAUTH);
    if (needClientAuth != null) {
        if (needClientAuth instanceof String)
            needClientAuth = Boolean.valueOf((String) needClientAuth);
        sslConnector.setNeedClientAuth(((Boolean) needClientAuth).booleanValue());
    }
    Object wantClientAuth = dictionary.get(JettyConstants.SSL_WANTCLIENTAUTH);
    if (wantClientAuth != null) {
        if (wantClientAuth instanceof String)
            wantClientAuth = Boolean.valueOf((String) wantClientAuth);
        sslConnector.setWantClientAuth(((Boolean) wantClientAuth).booleanValue());
    }
    String protocol = (String) dictionary.get(JettyConstants.SSL_PROTOCOL);
    if (protocol != null)
        sslConnector.setProtocol(protocol);
    String keystoreType = (String) dictionary.get(JettyConstants.SSL_KEYSTORETYPE);
    if (keystoreType != null)
        sslConnector.setKeystoreType(keystoreType);
    if (sslConnector.getPort() == 0) {
        try {
            sslConnector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return sslConnector;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.swt.internal.mozilla.IIDStore.GetIID(java.lang.Class;I)org.eclipse.swt.internal.mozilla.nsID;2
public static nsID GetIID(Class<?> clazz, int version) {
    return GetIID(clazz, version, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.bindings.internal.KeyAssistDialog.close()Z1
@Override
public boolean close() {
    return close(false);
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpParser.isComplete()Z1
public boolean isComplete() {
    return isState(STATE_END);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.SharedProfilePreferences.save()V1
protected synchronized void save() throws BackingStoreException {
    throw new  BackingStoreException("Can't store in shared install");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.reset()V1
public void reset() {
    this.fBuffer.setLength(0);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.apache.lucene.index.MultiReader.getVersion()J1
@Override
public long getVersion() {
    throw new  UnsupportedOperationException("MultiReader does not support this method.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.JavaReconcilingStrategy.reconcile(org.eclipse.jface.text.reconciler.DirtyRegion;org.eclipse.jface.text.IRegion;)V3
public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
    reconcile(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getHoverLineRange(org.eclipse.jface.text.source.ISourceViewer;I)org.eclipse.jface.text.source.ILineRange;3
public ILineRange getHoverLineRange(ISourceViewer viewer, int lineNumber) {
    return new  LineRange(lineNumber, 1);
}
---------------Client-------------------
method: org.eclipse.emf.ecore.xml.type.internal.RegEx$Op.createChar(I)org.eclipse.emf.ecore.xml.type.internal.RegEx$Op$CharOp;1
static CharOp createChar(int data) {
    if (Op.COUNT)
        Op.nofinstances++;
    return new  CharOp(Op.CHAR, data);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.matching.MatchLocator$WorkingCopyDocument.toString()java.lang.String;1
public String toString() {
    return "WorkingCopyDocument for " + getPath();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.operations.RemoteProjectFolder.hasProjectName()Z1
public boolean hasProjectName() {
    if (isProjectNameEmpty())
        return false;
    return true;
}
---------------Client-------------------
method: org.eclipse.team.core.synchronize.FastSyncInfoFilter.select(org.eclipse.team.core.synchronize.SyncInfo;)Z2
public boolean select(SyncInfo info) {
    return info.getKind() != 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtLocalVariableStart()Z1
boolean isAtLocalVariableStart() {
    return this.index < this.source.length && this.source[this.index] == '#';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.compare.internal.patch.PatchFileDiffNode.getAncestorElement(org.eclipse.compare.internal.core.patch.FileDiffResult;)org.eclipse.compare.ITypedElement;1
public static ITypedElement getAncestorElement(FileDiffResult result) {
    return new  PatchFileTypedElement(result, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ltk.core.refactoring.CompositeChange.markAsSynthetic()V1
public void markAsSynthetic() {
    fIsSynthetic = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathBlock.isValidated()Z1
public boolean isValidated() {
    return validated >= 2;
}
---------------Client-------------------
method: org.apache.lucene.index.FieldsReader.canReadRawDocs()Z1
boolean canReadRawDocs() {
    return format >= FieldsWriter.FORMAT_LUCENE_3_0_NO_COMPRESSED_FIELDS;
}

---------------Library-------------------
method: org.apache.lucene.search.Similarity.lengthNorm(java.lang.String;I)F3
@Deprecated
public final float lengthNorm(String fieldName, int numTokens) {
    throw new  UnsupportedOperationException("please use computeNorm instead");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.toc.TocEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.correction.JavaCorrectionAssistant$1.assistSessionEnded(org.eclipse.jface.text.contentassist.ContentAssistEvent;)V2
public void assistSessionEnded(ContentAssistEvent event) {
    fIsCompletionActive = false;
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.observable.StalenessTracker.addObservable(org.eclipse.core.databinding.observable.IObservable;)V2
public void addObservable(IObservable observable) {
    doAddObservable(observable, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl.createAnyNodeSelector()org.w3c.css.sac.SimpleSelector;1
@Override
public SimpleSelector createAnyNodeSelector() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.index.DirectoryReader.doOpenIfChanged(org.apache.lucene.index.IndexCommit;)org.apache.lucene.index.IndexReader;2
@Override
protected final IndexReader doOpenIfChanged(final IndexCommit commit) throws CorruptIndexException, IOException {
    return doOpenIfChanged(true, commit);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.NavigatorContentService.getExtension(org.eclipse.ui.navigator.INavigatorContentDescriptor;)org.eclipse.ui.internal.navigator.extensions.NavigatorContentExtension;2
public final NavigatorContentExtension getExtension(INavigatorContentDescriptor aDescriptorKey) {
    return getExtension(aDescriptorKey, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.ui.internal.AbstractWorkingSetManager.createWorkingSetSelectionDialog(org.eclipse.swt.widgets.Shell;)org.eclipse.ui.dialogs.IWorkingSetSelectionDialog;2
@Deprecated
@Override
public IWorkingSetSelectionDialog createWorkingSetSelectionDialog(Shell parent) {
    return createWorkingSetSelectionDialog(parent, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.refactoring.descriptors.JavaRefactoringDescriptorUtil.getString(java.util.Map;java.lang.String;)java.lang.String;2
public static String getString(Map map, String attribute) throws IllegalArgumentException {
    return getString(map, attribute, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.progress.DetailedProgressViewer.getSelectionFromWidget()java.util.List;1
@Override
protected List getSelectionFromWidget() {
    return new  ArrayList(0);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.provisional.frameworkadmin.LauncherData.setJvm(java.io.File;)V2
public void setJvm(File file) {
    this.jvm = file;
    if (file == null)
        removeProgramArg("-vm");
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.changedAST(org.eclipse.jdt.core.dom.CompilationUnit;)V2
public void changedAST(CompilationUnit changedAST) {
    this.ast = changedAST;
    changed(F_AST_AFFECTED);
}

---------------Library-------------------
method: org.eclipse.emf.common.util.BasicEMap.isEmpty()Z1
public boolean isEmpty() {
    return size == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.Utils.getAdapter(java.lang.Object;java.lang.Class;)java.lang.Object;2
public static Object getAdapter(Object element, Class adapterType) {
    return getAdapter(element, adapterType, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.osgi.OSGiEventAdminTemplateWizard.getImportPackages()Ajava.lang.String;1
public String[] getImportPackages() {
    return new String[] { "org.osgi.framework;version=\"1.3.0\"", "org.osgi.service.event;version=\"1.2.0\"" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor$3.getShowInTargetIds()Ajava.lang.String;1
@Override
public String[] getShowInTargetIds() {
    return new String[] { JavaUI.ID_PACKAGES, IPageLayout.ID_PROJECT_EXPLORER };
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSSelectorFactory.createRootNodeSelector()org.w3c.css.sac.SimpleSelector;1
public SimpleSelector createRootNodeSelector() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSHistoryFilter.hasComment()Z1
protected boolean hasComment() {
    return !comment.equals("");
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.formatter.FormattingPreferences.useSpacesInsteadOfTabs()Z1
public boolean useSpacesInsteadOfTabs() {
    return !fPrefs.getBoolean(AntEditorPreferenceConstants.FORMATTER_TAB_CHAR);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.reorg.MoveCuUpdateCreator$TypeReference.isQualified()Z1
public boolean isQualified() {
    return fSimpleNameStart != -1;
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.AnnotationTypeLookup$AnnotationTypeMapping.isMarkerSeverityDefined()Z1
boolean isMarkerSeverityDefined() {
    return fMarkerSeverity != UNDEFINED;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.ProjectDescription.getDynamicReferences()Aorg.eclipse.core.resources.IProject;1
public IProject[] getDynamicReferences() {
    return getDynamicReferences(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexWriter.forceMerge(I)V2
public void forceMerge(int maxNumSegments) throws CorruptIndexException, IOException {
    forceMerge(maxNumSegments, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.setHasInitializer(Z)V2
protected void setHasInitializer(boolean hasInitializer) {
    setMask(MASK_FIELD_HAS_INITIALIZER, hasInitializer);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.DependencyLoopFinder.findLoops(org.eclipse.pde.core.plugin.IPlugin;Aorg.eclipse.pde.core.plugin.IPlugin;)Aorg.eclipse.pde.internal.core.builders.DependencyLoop;2
public static DependencyLoop[] findLoops(IPlugin root, IPlugin[] candidates) {
    return findLoops(root, candidates, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.e4.compatibility.E4Util.unsupported(java.lang.String;)V1
public static void unsupported(String msg) throws UnsupportedOperationException {
    if (DEBUG_E4)
        WorkbenchPlugin.log("unsupported: " + msg);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.reconciler.dropins.Activator.trace(java.lang.Object;)V1
public static void trace(Object message) {
    if (Tracing.DEBUG_RECONCILER)
        Tracing.debug(TRACING_PREFIX + message);
}

---------------Library-------------------
method: org.apache.batik.util.resources.ResourceManager.getStringList(java.lang.String;java.lang.String;)java.util.List;3
public List getStringList(String key, String delim) throws MissingResourceException {
    return getStringList(key, delim, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.osgi.framework.eventmgr.EventManager$EventThread.close()V1
void close() {
    running = false;
    interrupt();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.dnd.JdtViewerDropAdapter.handleException(java.lang.Throwable;org.eclipse.swt.dnd.DropTargetEvent;)V3
protected void handleException(Throwable exception, DropTargetEvent event) {
    exception.printStackTrace();
    event.detail = DND.DROP_NONE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ClasspathEntry.kindToString(I)java.lang.String;1
static String kindToString(int kind) {
    switch(kind) {
        case IClasspathEntry.CPE_PROJECT:
            return "src";
        case IClasspathEntry.CPE_SOURCE:
            return "src";
        case IClasspathEntry.CPE_LIBRARY:
            return "lib";
        case IClasspathEntry.CPE_VARIABLE:
            return "var";
        case IClasspathEntry.CPE_CONTAINER:
            return "con";
        case ClasspathEntry.K_OUTPUT:
            return "output";
        default:
            return "unknown";
    }
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.problems.ApiProblem.getVersionProblemKindName(I)java.lang.String;1
public static String getVersionProblemKindName(int kind) {
    switch(kind) {
        case IApiProblem.MINOR_VERSION_CHANGE:
            return "MINOR_VERSION_CHANGE";
        case IApiProblem.MAJOR_VERSION_CHANGE:
            return "MAJOR_VERSION_CHANGE";
        case IApiProblem.MAJOR_VERSION_CHANGE_NO_BREAKAGE:
            return "MAJOR_VERSION_CHANGE_NO_BREAKAGE";
        case IApiProblem.MINOR_VERSION_CHANGE_NO_NEW_API:
            return "MINOR_VERSION_CHANGE_NO_NEW_API";
        case IApiProblem.REEXPORTED_MAJOR_VERSION_CHANGE:
            return "REEXPORTED_MAJOR_VERSION_CHANGE";
        case IApiProblem.REEXPORTED_MINOR_VERSION_CHANGE:
            return "REEXPORTED_MINOR_VERSION_CHANGE";
        default:
            return Util.UNKNOWN_KIND;
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.ProjectReferencePage$1.checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent;)V2
public void checkStateChanged(CheckStateChangedEvent event) {
    modified = true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor.configureToggleCommentAction()V1
private void configureToggleCommentAction() {
    IAction action = getAction("ToggleComment");
    if (action instanceof ToggleCommentAction) {
        ISourceViewer sourceViewer = getSourceViewer();
        SourceViewerConfiguration configuration = getSourceViewerConfiguration();
        ((ToggleCommentAction) action).configure(sourceViewer, configuration);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.propertiesfileeditor.PropertiesFileEditor.configureToggleCommentAction()V1
private void configureToggleCommentAction() {
    IAction action = getAction(IJavaEditorActionDefinitionIds.TOGGLE_COMMENT);
    if (action instanceof ToggleCommentAction) {
        ISourceViewer sourceViewer = getSourceViewer();
        SourceViewerConfiguration configuration = getSourceViewerConfiguration();
        ((ToggleCommentAction) action).configure(sourceViewer, configuration);
    }
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderRight(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderRight(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-right");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.VMListener.vmAdded(org.eclipse.jdt.launching.IVMInstall;)V2
public void vmAdded(IVMInstall vm) {
    fChanged = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.WorkingSetManagerData.editWorkingSet()V1
public void editWorkingSet() throws IOException {
    if (name != null && name.length() > 0) {
        String oldName = request.getParameter("oldName");
        if (oldName == null || oldName.length() == 0)
            oldName = name;
        WorkingSet ws = wsmgr.getWorkingSet(oldName);
        if (ws != null) {
            String[] hrefs = request.getParameterValues("hrefs");
            if (hrefs == null)
                hrefs = new String[0];
            ArrayList selectedElements = new  ArrayList(hrefs.length);
            for (int i = 0; i < hrefs.length; i++) {
                AdaptableHelpResource res = getAdaptableHelpResource(hrefs[i]);
                if (res != null)
                    selectedElements.add(res);
            }
            AdaptableHelpResource[] elements = new AdaptableHelpResource[selectedElements.size()];
            selectedElements.toArray(elements);
            ws.setElements(elements);
            ws.setName(name);
            if (isCriteriaScopeEnabled()) {
                ws.setCriteria(getCriteriaResource());
            }
            wsmgr.workingSetChanged(ws);
        }
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.ui.ide.IDE.getEditorDescriptor(java.lang.String;)org.eclipse.ui.IEditorDescriptor;1
public static IEditorDescriptor getEditorDescriptor(String name) throws PartInitException {
    return getEditorDescriptor(name, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.client.Session.sendGlobalOption(java.lang.String;)V2
public void sendGlobalOption(String option) throws CVSException {
    connection.writeLine("Global_option " + option);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.notifyTestTreeEntry(java.lang.String;)V2
protected void notifyTestTreeEntry(String treeEntry) {
    fSender.sendMessage(MessageIds.TEST_TREE + treeEntry);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.refactoring.PDERenameParticipant.updateManifest()Z1
protected boolean updateManifest() {
    return containsElement(true);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.SimpleLog.isTraceEnabled()Z1
public final boolean isTraceEnabled() {
    return isLevelEnabled(SimpleLog.LOG_LEVEL_TRACE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.ide.MultiPageEditorTemplate.createOptions()V1
private void createOptions() {
    addOption(KEY_PACKAGE_NAME, PDETemplateMessages.MultiPageEditorTemplate_packageName, (String) null, 0);
    addOption("editorClassName", PDETemplateMessages.MultiPageEditorTemplate_className, "MultiPageEditor", 0);
    addOption("contributorClassName", PDETemplateMessages.MultiPageEditorTemplate_contributor, "MultiPageEditorContributor", 0);
    addOption("editorName", PDETemplateMessages.MultiPageEditorTemplate_editorName, PDETemplateMessages.MultiPageEditorTemplate_defaultEditorName, 0);
    addOption("extensions", PDETemplateMessages.MultiPageEditorTemplate_extensions, "mpe", 0);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.templates.ide.PropertyPageTemplate.createOptions()V1
private void createOptions() {
    addOption(KEY_PACKAGE_NAME, PDETemplateMessages.PropertyPageTemplate_packageName, (String) null, 0);
    addOption(KEY_CLASSNAME, PDETemplateMessages.PropertyPageTemplate_pageClass, "SamplePropertyPage", 0);
    addOption(KEY_PAGE_NAME, PDETemplateMessages.PropertyPageTemplate_pageName, PDETemplateMessages.PropertyPageTemplate_defaultPageName, 0);
    addOption(KEY_TARGET_CLASS, PDETemplateMessages.PropertyPageTemplate_targetClass, "org.eclipse.core.resources.IFile", 0);
    addOption(KEY_NAME_FILTER, PDETemplateMessages.PropertyPageTemplate_nameFilter, "*.*", 0);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.CompareInputChangeNotifier$CompareInputConnecton.isDisconnected()Z1
public boolean isDisconnected() {
    return connections == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.swt.custom.CTabFolder.setSelectionBackground(Aorg.eclipse.swt.graphics.Color;AI)V3
public void setSelectionBackground(Color[] colors, int[] percents) {
    setSelectionBackground(colors, percents, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.create(org.eclipse.core.resources.IProjectDescription;org.eclipse.core.runtime.IProgressMonitor;)V3
public void create(IProjectDescription description, IProgressMonitor monitor) throws CoreException {
    create(description, IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.BasicEObjectImpl.eGet(org.eclipse.emf.ecore.EStructuralFeature;)java.lang.Object;2
public Object eGet(EStructuralFeature eFeature) {
    return eGet(eFeature, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.frameworkadmin.equinox.EquinoxBundlesState.getFwJar(org.eclipse.equinox.internal.provisional.frameworkadmin.LauncherData;org.eclipse.equinox.internal.provisional.frameworkadmin.ConfigData;)java.io.File;2
static File getFwJar(LauncherData launcherData, ConfigData configData) {
    return getFwJar(launcherData, configData, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.initialCheckTreeItem(java.lang.Object;)V2
public void initialCheckTreeItem(Object element) {
    treeItemChecked(element, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.builder.WorkQueue.toString()java.lang.String;1
public String toString() {
    return "WorkQueue: " + this.needsCompileList;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager$CustomProfile.getID()java.lang.String;1
@Override
public String getID() {
    return ID_PREFIX + fName;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicExtendedMetaData$EClassExtendedMetaDataImpl.setBaseType(org.eclipse.emf.ecore.EDataType;)V2
public void setBaseType(EDataType baseType) {
    throw new  UnsupportedOperationException("Can't set the base type of an EClass");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.EditorActionBars.activate(Z)V2
@Override
public void activate(boolean forceVisibility) {
    setActive(true, forceVisibility);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.setHasInitializer(Z)V2
protected void setHasInitializer(boolean hasInitializer) {
    setMask(MASK_FIELD_HAS_INITIALIZER, hasInitializer);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.preferences.TargetPlatformPreferenceNode.getLabelText()java.lang.String;1
public String getLabelText() {
    return Platform.getResourceString(PDEPlugin.getDefault().getBundle(), "%preferences.target.name");
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathLabelProvider.getFolderImage()org.eclipse.swt.graphics.Image;1
private Image getFolderImage() {
    return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.JUnitPreferencePage$7.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event e) {
    checkAllFilters(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.jetty.util.BlockingArrayQueue.isEmpty()Z1
@Override
public boolean isEmpty() {
    return _size.get() == 0;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$StatusWrapper.isOK()Z1
public boolean isOK() {
    return diagnostic.getSeverity() == OK;
}

---------------Library-------------------
method: org.eclipse.emf.common.util.CommonUtil$StringPool.getStringBuilder()org.eclipse.emf.common.util.CommonUtil$StringPool$StringsAccessUnit;1
StringsAccessUnit getStringBuilder() {
    return stringsAccessUnits.pop(false);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathPage.getAntHomeEntries()Aorg.eclipse.ant.core.IAntClasspathEntry;1
protected IAntClasspathEntry[] getAntHomeEntries() {
    return fModel.getEntries(ClasspathModel.ANT_HOME);
}

---------------Library-------------------
method: org.eclipse.jface.fieldassist.ControlDecoration.show()V1
public void show() {
    if (!visible) {
        visible = true;
        update();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSMediaRuleImpl.insertRule(java.lang.String;I)I3
@Override
public int insertRule(String rule, int index) throws DOMException {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.ShellElement$1.shellDeactivated(org.eclipse.swt.events.ShellEvent;)V2
@Override
public void shellDeactivated(ShellEvent e) {
    ShellElement.this.isActive = false;
    doApplyStyles();
}
---------------Client-------------------
method: org.apache.batik.util.gui.CSSMediaPanel$AddMediumDialog$OKButtonAction.actionPerformed(java.awt.event.ActionEvent;)V2
public void actionPerformed(ActionEvent e) {
    returnCode = OK_OPTION;
    dispose();
}

---------------Library-------------------
method: org.eclipse.debug.ui.actions.ImportBreakpointsOperation.run(org.eclipse.core.runtime.IProgressMonitor;)V2
@Override
public void run(final IProgressMonitor monitor) throws InvocationTargetException {
    SubMonitor localmonitor = SubMonitor.convert(monitor, ImportExportMessages.ImportOperation_0, 1);
    Reader reader = null;
    try {
        if (fBuffer == null) {
            reader = new  InputStreamReader(new  FileInputStream(fFileName), "UTF-8");
        } else {
            reader = new  StringReader(fBuffer.toString());
        }
        XMLMemento memento = XMLMemento.createReadRoot(reader);
        IMemento[] nodes = memento.getChildren(IImportExportConstants.IE_NODE_BREAKPOINT);
        IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
        localmonitor.setWorkRemaining(nodes.length);
        Map<String, Object> attributes = null;
        IBreakpointImportParticipant[] participants = null;
        for (int i = 0; i < nodes.length; i++) {
            if (localmonitor.isCanceled()) {
                return;
            }
            attributes = collectBreakpointProperties(nodes[i]);
            if (attributes == null) {
                continue;
            }
            IResource resource;
            if (fImportBreakpoints) {
                resource = workspace.findMember((String) attributes.get(IImportExportConstants.IE_NODE_PATH));
            } else {
                resource = workspace;
            }
            if (resource != null) {
                try {
                    participants = fManager.getImportParticipants((String) attributes.get(IImportExportConstants.IE_NODE_TYPE));
                } catch (CoreException ce) {
                }
                IMarker marker = findExistingMarker(attributes, participants);
                if (marker == null) {
                    marker = resource.createMarker((String) attributes.get(IImportExportConstants.IE_NODE_TYPE));
                    restoreBreakpoint(marker, attributes, participants);
                } else {
                    if (fOverwriteAll) {
                        if (!fImportBreakpoints) {
                            marker = resource.createMarker((String) attributes.get(IImportExportConstants.IE_NODE_TYPE));
                        } else {
                            marker.setAttributes(null);
                        }
                        restoreBreakpoint(marker, attributes, participants);
                    }
                }
            }
            fCurrentWorkingSetProperty = null;
            localmonitor.worked(1);
        }
        if (fAdded.size() > 0 && fImportBreakpoints) {
            fManager.addBreakpoints(fAdded.toArray(new IBreakpoint[fAdded.size()]));
        }
    } catch (FileNotFoundException e) {
        throw new  InvocationTargetException(e, MessageFormat.format("Breakpoint import file not found: {0}", new Object[] { fFileName }));
    } catch (UnsupportedEncodingException e) {
        throw new  InvocationTargetException(e, MessageFormat.format("The import file was written in non-UTF-8 encoding.", new Object[] { fFileName }));
    } catch (CoreException ce) {
        throw new  InvocationTargetException(ce, MessageFormat.format("There was a problem importing breakpoints from: {0}", new Object[] { fFileName }));
    } finally {
        localmonitor.done();
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new  InvocationTargetException(e);
            }
        }
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.CVSWizardPage.createWrappingLabel(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Label;4
protected Label createWrappingLabel(Composite parent, String text, int indent) {
    return createWrappingLabel(parent, text, indent, 1);
}
---------------Client-------------------
method: org.eclipse.ui.internal.navigator.extensions.NavigatorContentDescriptorManager.findDescriptorsForPossibleChild(java.lang.Object;org.eclipse.ui.internal.navigator.VisibilityAssistant;Z)java.util.Set;4
public Set findDescriptorsForPossibleChild(Object anElement, VisibilityAssistant aVisibilityAssistant, boolean toComputeOverrides) {
    return findDescriptors(anElement, aVisibilityAssistant, toComputeOverrides, POSSIBLE_CHILD);
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.FiltersConfigurationDialog$14.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    andFilters = true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtCapture18Start()Z1
boolean isAtCapture18Start() {
    return this.index < this.source.length && this.source[this.index] == '^';
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.BindingKeyParser$Scanner.isAtThrownStart()Z1
boolean isAtThrownStart() {
    return this.index < this.source.length && this.source[this.index] == C_THROWN;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.SelectionConverter.getInput(org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;)org.eclipse.jdt.core.ITypeRoot;1
public static ITypeRoot getInput(JavaEditor editor) {
    return getInput(editor, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.client.MTHandler.startNextLine()V1
private void startNextLine() {
    isLineAvailable = false;
    nextLine = null;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.setOK()V1
public void setOK() {
    fStatusMessage = null;
    fSeverity = IStatus.OK;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.CompletionEngine.setTokenRange(II)V3
private void setTokenRange(int start, int end) {
    this.setTokenRange(start, end, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.formatter.Scribe.printComment(II)V3
void printComment(int kind, int trailing) {
    printComment(kind, trailing, PRESERVE_EMPTY_LINES_KEEP_LAST_NEW_LINES_INDENTATION);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.ProjectSetImporter.isValidProjectSetFile(java.lang.String;)Z1
public static boolean isValidProjectSetFile(String filename) {
    try {
        return filenameToXMLMemento(filename).getString("version") != null;
    } catch (InvocationTargetException e) {
        return false;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.model.JavaModelLabelProvider.isInJavaProject(org.eclipse.core.resources.IFolder;)Z1
private static boolean isInJavaProject(IFolder folder) {
    try {
        return folder.getProject().getNature(JavaCore.NATURE_ID) != null;
    } catch (CoreException e) {
        return false;
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.wizards.PatchInaccessibleProjectsPage$4.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    setAllChecked(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jetty.servlet.ServletHolder$SingleThreadedWrapper.destroy()V1
public void destroy() {
    synchronized (this) {
        while (_stack.size() > 0) try {
            (_stack.pop()).destroy();
        } catch (Exception e) {
            LOG.warn(e);
        }
    }
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.apache.lucene.index.SegmentTermPositions.read(AIAI)I3
@Override
public final int read(final int[] docs, final int[] freqs) {
    throw new  UnsupportedOperationException("TermPositions does not support processing multiple documents in one call. Use TermDocs instead.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaReplaceWithEditionAction.createDelegate()org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl;1
@Override
protected JavaHistoryActionImpl createDelegate() {
    return new  JavaReplaceWithEditionActionImpl(false);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.AbstractSequentialInternalEList.basicListIterator()java.util.ListIterator;1
public ListIterator<E> basicListIterator() {
    return basicListIterator(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextArrayDimension()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextArrayDimension() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_ARRAY_DIMENSION);
}

---------------Library-------------------
method: org.eclipse.jetty.security.ConstraintSecurityHandler.checkUserDataPermissions(java.lang.String;org.eclipse.jetty.server.Request;org.eclipse.jetty.server.Response;java.lang.Object;)Z5
protected boolean checkUserDataPermissions(String pathInContext, Request request, Response response, Object constraintInfo) throws IOException {
    if (constraintInfo == null)
        return true;
    RoleInfo roleInfo = (RoleInfo) constraintInfo;
    if (roleInfo.isForbidden())
        return false;
    UserDataConstraint dataConstraint = roleInfo.getUserDataConstraint();
    if (dataConstraint == null || dataConstraint == UserDataConstraint.None) {
        return true;
    }
    AbstractHttpConnection connection = AbstractHttpConnection.getCurrentConnection();
    Connector connector = connection.getConnector();
    if (dataConstraint == UserDataConstraint.Integral) {
        if (connector.isIntegral(request))
            return true;
        if (connector.getIntegralPort() > 0) {
            String scheme = connector.getIntegralScheme();
            int port = connector.getIntegralPort();
            String url = (HttpSchemes.HTTPS.equalsIgnoreCase(scheme) && port == 443) ? "https://" + request.getServerName() + request.getRequestURI() : scheme + "://" + request.getServerName() + ":" + port + request.getRequestURI();
            if (request.getQueryString() != null)
                url += "?" + request.getQueryString();
            response.setContentLength(0);
            response.sendRedirect(url);
        } else
            response.sendError(Response.SC_FORBIDDEN, "!Integral");
        request.setHandled(true);
        return false;
    } else if (dataConstraint == UserDataConstraint.Confidential) {
        if (connector.isConfidential(request))
            return true;
        if (connector.getConfidentialPort() > 0) {
            String scheme = connector.getConfidentialScheme();
            int port = connector.getConfidentialPort();
            String url = (HttpSchemes.HTTPS.equalsIgnoreCase(scheme) && port == 443) ? "https://" + request.getServerName() + request.getRequestURI() : scheme + "://" + request.getServerName() + ":" + port + request.getRequestURI();
            if (request.getQueryString() != null)
                url += "?" + request.getQueryString();
            response.setContentLength(0);
            response.sendRedirect(url);
        } else
            response.sendError(Response.SC_FORBIDDEN, "!Confidential");
        request.setHandled(true);
        return false;
    } else {
        throw new  IllegalArgumentException("Invalid dataConstraint value: " + dataConstraint);
    }
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.apache.lucene.index.TermBuffer.setPreUTF8Strings()V1
void setPreUTF8Strings() {
    preUTF8Strings = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.FinishResult.isException()Z1
public boolean isException() {
    return fValue == 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntModelProblem.isWarning()Z1
@Override
public boolean isWarning() {
    return fSeverity == SEVERITY_WARNING;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.rcp.ViewRCPTemplate.createPerspectiveExtension()V1
private void createPerspectiveExtension() throws CoreException {
    IPluginBase plugin = model.getPluginBase();
    IPluginExtension extension = createExtension("org.eclipse.ui.perspectives", true);
    IPluginElement element = model.getPluginFactory().createElement(extension);
    element.setName("perspective");
    element.setAttribute("class", getStringOption(KEY_PACKAGE_NAME) + ".Perspective");
    element.setAttribute("name", "Perspective");
    element.setAttribute("id", plugin.getId() + ".perspective");
    extension.add(element);
    if (!extension.isInTheModel())
        plugin.add(extension);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.templates.rcp.HelloRCPTemplate.createPerspectiveExtension()V1
private void createPerspectiveExtension() throws CoreException {
    IPluginBase plugin = model.getPluginBase();
    IPluginExtension extension = createExtension("org.eclipse.ui.perspectives", true);
    IPluginElement element = model.getPluginFactory().createElement(extension);
    element.setName("perspective");
    element.setAttribute("class", getStringOption(KEY_PACKAGE_NAME) + ".Perspective");
    element.setAttribute("name", VALUE_PERSPECTIVE_NAME);
    element.setAttribute("id", plugin.getId() + ".perspective");
    extension.add(element);
    if (!extension.isInTheModel())
        plugin.add(extension);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl.getValue(org.eclipse.emf.ecore.EObject;org.eclipse.emf.ecore.EStructuralFeature;)java.lang.Object;3
public Object getValue(EObject obj, EStructuralFeature f) {
    return obj.eGet(f, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderLeft(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderLeft(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-left");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.schema.Schema.processTranslatable(java.lang.String;)Z2
private boolean processTranslatable(String value) {
    return (value != null && "true".equals(value));
}
---------------Client-------------------
method: org.eclipse.e4.ui.internal.workbench.URIHelper.isPlatformURI(java.lang.String;)Z1
public static boolean isPlatformURI(String uri) {
    return uri != null && uri.startsWith(PLATFORM_SCHEMA);
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareEditorSelectionProvider.setSelection(org.eclipse.jface.viewers.ISelection;)V2
public void setSelection(ISelection selection) {
    setSelection(selection, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.SocketListenConnectorProcess$WaitForConnectionJob.run(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.IStatus;2
@Override
protected IStatus run(IProgressMonitor monitor) {
    try {
        Connector.Argument timeout = fArguments.get("timeout");
        if (timeout != null) {
            timeout.setValue("3000");
        }
        VirtualMachine vm = null;
        while (vm == null && !monitor.isCanceled()) {
            try {
                vm = fConnector.accept(fArguments);
            } catch (TransportTimeoutException e) {
            }
        }
        if (monitor.isCanceled()) {
            fConnector.stopListening(fArguments);
            return Status.CANCEL_STATUS;
        }
        ILaunchConfiguration configuration = fLaunch.getLaunchConfiguration();
        boolean allowTerminate = false;
        if (configuration != null) {
            try {
                allowTerminate = configuration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_ALLOW_TERMINATE, false);
            } catch (CoreException e) {
                LaunchingPlugin.log(e);
            }
        }
        Connector.Argument portArg = fArguments.get("port");
        String vmLabel = constructVMLabel(vm, portArg.value(), fLaunch.getLaunchConfiguration());
        IDebugTarget debugTarget = JDIDebugModel.newDebugTarget(fLaunch, vm, vmLabel, null, allowTerminate, true);
        fLaunch.addDebugTarget(debugTarget);
        fLaunch.removeProcess(fWaitProcess);
        return Status.OK_STATUS;
    } catch (IOException e) {
        if (fListeningStopped) {
            return Status.CANCEL_STATUS;
        }
        return getStatus(LaunchingMessages.SocketListenConnectorProcess_4, e, IJavaLaunchConfigurationConstants.ERR_REMOTE_VM_CONNECTION_FAILED);
    } catch (IllegalConnectorArgumentsException e) {
        return getStatus(LaunchingMessages.SocketListenConnectorProcess_4, e, IJavaLaunchConfigurationConstants.ERR_REMOTE_VM_CONNECTION_FAILED);
    } finally {
        stopListening();
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.CompilationUnitElementInfo.getSourceRange()org.eclipse.jdt.core.ISourceRange;1
protected ISourceRange getSourceRange() {
    return new  SourceRange(0, this.sourceLength);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.FailureTableDisplay.newTableItem()org.eclipse.swt.widgets.TableItem;1
TableItem newTableItem() {
    return new  TableItem(fTable, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.dialogs.PluginSelectionDialog.validateItem(java.lang.Object;)org.eclipse.core.runtime.IStatus;2
protected IStatus validateItem(Object item) {
    return new  Status(IStatus.OK, IPDEUIConstants.PLUGIN_ID, 0, "", null);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ds.ui.wizards.DSFileWizardPage.validateLinkedResource()org.eclipse.core.runtime.IStatus;1
protected IStatus validateLinkedResource() {
    return new  Status(IStatus.OK, Activator.PLUGIN_ID, IStatus.OK, "", null);
}

---------------Library-------------------
method: org.eclipse.core.runtime.SubMonitor.convert(org.eclipse.core.runtime.IProgressMonitor;I)org.eclipse.core.runtime.SubMonitor;2
public static SubMonitor convert(IProgressMonitor monitor, int work) {
    return convert(monitor, "", work);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.fix.NullAnnotationsFix.getNonNullAnnotationName(org.eclipse.jdt.core.IJavaElement;Z)java.lang.String;2
public static String getNonNullAnnotationName(IJavaElement javaElement, boolean makeSimple) {
    return getAnnotationName(javaElement, makeSimple, JavaCore.COMPILER_NONNULL_ANNOTATION_NAME);
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Widget.sendEvent(ILorg.eclipse.swt.widgets.Event;)V3
void sendEvent(int eventType, Event event) {
    sendEvent(eventType, event, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleErrorToken(java.lang.String;Z)V3
protected void handleErrorToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.help.internal.index.IndexDocumentReader.prune(org.w3c.dom.Node;)V2
private void prune(Node element) {
    NodeList nodes = element.getChildNodes();
    Node node = nodes.item(0);
    while (node != null) {
        short nodeType = node.getNodeType();
        if (nodeType == Node.TEXT_NODE || nodeType == Node.COMMENT_NODE) {
            Node nodeToDelete = node;
            node = node.getNextSibling();
            element.removeChild(nodeToDelete);
        } else if (nodeType == Node.ELEMENT_NODE) {
            String kind = node.getNodeName();
            if ("topic".equalsIgnoreCase(kind)) {
                fixTopicAttributes((Element) node);
            }
            prune(node);
            node = node.getNextSibling();
        } else {
            node = node.getNextSibling();
        }
    }
}
---------------Client-------------------
method: org.eclipse.help.internal.criteria.CriteriaDefinitionDocumentReader.prune(org.w3c.dom.Node;)V2
private void prune(Node element) {
    NodeList nodes = element.getChildNodes();
    Node node = nodes.item(0);
    while (node != null) {
        short nodeType = node.getNodeType();
        if (nodeType == Node.TEXT_NODE || nodeType == Node.COMMENT_NODE) {
            Node nodeToDelete = node;
            node = node.getNextSibling();
            element.removeChild(nodeToDelete);
        } else if (nodeType == Node.ELEMENT_NODE) {
            String kind = node.getNodeName();
            if (CRITERION_ELEMENT.equalsIgnoreCase(kind)) {
                fixCriterionId((Element) node);
            }
            prune(node);
            node = node.getNextSibling();
        } else {
            node = node.getNextSibling();
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.BasicSearchEngine.createJavaSearchScope(Aorg.eclipse.jdt.core.IJavaElement;)org.eclipse.jdt.core.search.IJavaSearchScope;1
public static IJavaSearchScope createJavaSearchScope(IJavaElement[] elements) {
    return createJavaSearchScope(elements, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.builder.IncrementalImageBuilder.toString()java.lang.String;1
public String toString() {
    return "incremental image builder for:\n\tnew state: " + this.newState;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager$CustomProfile.getID()java.lang.String;1
@Override
public String getID() {
    return ID_PREFIX + fName;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl.saveFeatures(org.eclipse.emf.ecore.EObject;)Z2
protected boolean saveFeatures(EObject o) {
    return saveFeatures(o, false);
}
---------------Client-------------------
method: org.eclipse.team.core.variants.SessionResourceVariantByteStore.deleteBytes(org.eclipse.core.resources.IResource;)Z2
public boolean deleteBytes(IResource resource) throws TeamException {
    return flushBytes(resource, IResource.DEPTH_ZERO);
}

---------------Library-------------------
method: org.eclipse.core.internal.events.AutoBuildJob.forceBuild()V1
public void forceBuild() {
    forceBuild = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.compare.contentmergeviewer.ContentMergeViewer$7.run()V1
public void run() {
    copy(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.getTermInfosIndexDivisor()I1
public int getTermInfosIndexDivisor() {
    throw new  UnsupportedOperationException("This reader does not support this method.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.core.internal.dtree.AbstractDataTree.immutable()V1
public void immutable() {
    immutable = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jface.text.TextViewer.shift(ZZ)V3
protected void shift(boolean useDefaultPrefixes, boolean right) {
    shift(useDefaultPrefixes, right, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.diagnose.RangeUtil$RangeResult.addInterval(II)V3
void addInterval(int start, int end) {
    addInterval(start, end, NO_FLAG);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.ComputeProjectOrder$Digraph.freeze()V1
public void freeze() {
    if (!initialized) {
        initialized = true;
        DFS();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.jetty.util.resource.URLResource.getOutputStream()java.io.OutputStream;1
@Override
public OutputStream getOutputStream() throws java.io.IOException, SecurityException {
    throw new  IOException("Output not supported");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.ControlElement$2.mouseExit(org.eclipse.swt.events.MouseEvent;)V2
@Override
public void mouseExit(MouseEvent e) {
    ControlElement.this.hasMouseHover = false;
    doApplyStyles();
}
---------------Client-------------------
method: org.apache.batik.util.gui.CSSMediaPanel$AddMediumDialog$OKButtonAction.actionPerformed(java.awt.event.ActionEvent;)V2
public void actionPerformed(ActionEvent e) {
    returnCode = OK_OPTION;
    dispose();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.LocalVariable.getHandleMemento(java.lang.StringBuffer;)V2
protected void getHandleMemento(StringBuffer buff) {
    getHandleMemento(buff, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.ecf.provider.filetransfer.httpclient4.HttpClientRetrieveFileTransfer.setRangeHeader(java.lang.String;)V2
private void setRangeHeader(String value) {
    getMethod.addHeader("Range", value);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetUnion.lowerBound()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet;1
@Override
public TypeSet lowerBound() {
    throw new  IllegalStateException("unimplemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSConditionFactory.createPositionalCondition(IZZ)org.w3c.css.sac.PositionalCondition;4
public PositionalCondition createPositionalCondition(int position, boolean typeNode, boolean type) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.provisional.VirtualItem.setNeedsLabelUpdate()V1
public void setNeedsLabelUpdate() {
    fNeedsLabelUpdate = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.core.expressions.ExpressionInfo.markSystemPropertyAccessed()V1
public void markSystemPropertyAccessed() {
    fHasSystemPropertyAccess = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTNode.getNodeType()I1
public final int getNodeType() {
    return this.typeAndFlags >>> 16;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.comparator.Delta.getNewModifiers()I1
@Override
public int getNewModifiers() {
    return (this.modifiers >>> NEW_MODIFIERS_OFFSET);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.servlet.XMLGenerator.println(java.lang.Object;)V2
public void println(Object o) {
    print(o);
    print("\n");
}
---------------Client-------------------
method: org.eclipse.ui.internal.expressions.LegacyActionSetExpression.collectExpressionInfo(org.eclipse.core.expressions.ExpressionInfo;)V2
@Override
public final void collectExpressionInfo(final ExpressionInfo info) {
    super.collectExpressionInfo(info);
    info.addVariableNameAccess(ISources.ACTIVE_CONTEXT_NAME);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyInterfaceMemberDeclarationsopt()V1
protected void consumeEmptyInterfaceMemberDeclarationsopt() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.typesAsString(org.eclipse.jdt.internal.compiler.lookup.MethodBinding;Aorg.eclipse.jdt.internal.compiler.lookup.TypeBinding;Z)java.lang.String;4
private String typesAsString(MethodBinding methodBinding, TypeBinding[] parameters, boolean makeShort) {
    return typesAsString(methodBinding, parameters, makeShort, false);
}
---------------Client-------------------
method: org.eclipse.ui.internal.navigator.extensions.NavigatorContentDescriptorManager.findDescriptorsForTriggerPoint(java.lang.Object;org.eclipse.ui.internal.navigator.VisibilityAssistant;Z)java.util.Set;4
public Set findDescriptorsForTriggerPoint(Object anElement, VisibilityAssistant aVisibilityAssistant, boolean considerOverrides) {
    return findDescriptors(anElement, aVisibilityAssistant, considerOverrides, !POSSIBLE_CHILD);
}

---------------Library-------------------
method: org.eclipse.debug.core.DebugPlugin.getStatusHandler(org.eclipse.core.runtime.IStatus;)org.eclipse.debug.core.IStatusHandler;2
public IStatusHandler getStatusHandler(IStatus status) {
    boolean enabled = Platform.getPreferencesService().getBoolean(DebugPlugin.getUniqueIdentifier(), IInternalDebugCoreConstants.PREF_ENABLE_STATUS_HANDLERS, true, null);
    if (!enabled) {
        return null;
    }
    StatusHandlerKey key = new  StatusHandlerKey(status.getPlugin(), status.getCode());
    if (fStatusHandlers == null) {
        initializeStatusHandlers();
    }
    IConfigurationElement config = fStatusHandlers.get(key);
    if (config != null) {
        try {
            Object handler = config.createExecutableExtension(IConfigurationElementConstants.CLASS);
            if (handler instanceof IStatusHandler) {
                return (IStatusHandler) handler;
            }
            invalidStatusHandler(null, MessageFormat.format("Registered status handler {0} does not implement required interface IStatusHandler.", new Object[] { config.getDeclaringExtension().getUniqueIdentifier() }));
        } catch (CoreException e) {
            log(e);
        }
    }
    return null;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;java.lang.Throwable;)V3
public void debug(Object message, Throwable t) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message), t);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.SwitchStatement.memSize()I1
int memSize() {
    return super.memSize() + 2 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.jface.text.source.AnnotationPainter$2.inputDocumentAboutToBeChanged(org.eclipse.jface.text.IDocument;org.eclipse.jface.text.IDocument;)V3
public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
    fInputDocumentAboutToBeChanged = true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.extension.PointSelectionPage$PointLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object obj) {
    return getColumnText(obj, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter.showHyperlinks(Aorg.eclipse.jface.text.hyperlink.IHyperlink;)V2
public void showHyperlinks(IHyperlink[] hyperlinks) {
    showHyperlinks(hyperlinks, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.osgi.framework.util.Headers.set(java.lang.Object;java.lang.Object;)java.lang.Object;3
public synchronized V set(K key, V value) {
    return set(key, value, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicExtendedMetaData$EClassExtendedMetaDataImpl.setLengthFacet(I)V2
public void setLengthFacet(int length) {
    throw new  UnsupportedOperationException("Can't set the length of an EClass");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.wizards.MethodStubsSelectionButtonGroup.createEmptySpace(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;1
public static Control createEmptySpace(Composite parent) {
    return createEmptySpace(parent, 1);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.JREContainerInitializer.getVMTypeId(org.eclipse.core.runtime.IPath;)java.lang.String;1
public static String getVMTypeId(IPath path) {
    return path.segment(1);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.update.internal.configurator.PlatformConfiguration.configureSite(org.eclipse.update.configurator.IPlatformConfiguration$ISiteEntry;)V2
public void configureSite(ISiteEntry entry) {
    configureSite(entry, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.util.JavaElementResourceMapping$CompilationUnitResourceMapping.getTraversals(org.eclipse.core.resources.mapping.ResourceMappingContext;org.eclipse.core.runtime.IProgressMonitor;)Aorg.eclipse.core.resources.mapping.ResourceTraversal;3
@Override
public ResourceTraversal[] getTraversals(ResourceMappingContext context, IProgressMonitor monitor) throws CoreException {
    return new ResourceTraversal[] { new  ResourceTraversal(new IResource[] { fUnit.getResource() }, IResource.DEPTH_ONE, 0) };
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.mapping.ShallowResourceMapping.getTraversals(org.eclipse.core.resources.mapping.ResourceMappingContext;org.eclipse.core.runtime.IProgressMonitor;)Aorg.eclipse.core.resources.mapping.ResourceTraversal;3
public ResourceTraversal[] getTraversals(ResourceMappingContext context, IProgressMonitor monitor) {
    return new ResourceTraversal[] { new  ResourceTraversal(new IResource[] { container.getResource() }, IResource.DEPTH_ONE, IResource.NONE) };
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.application.IDEWorkbenchWindowAdvisor$3.perspectiveActivated(org.eclipse.ui.IWorkbenchPage;org.eclipse.ui.IPerspectiveDescriptor;)V3
public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
    updateTitle(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.WorkspaceDescription.getBuildOrder()Ajava.lang.String;1
public String[] getBuildOrder() {
    return getBuildOrder(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextNestedType()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextNestedType() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_NESTED_TYPE);
}

---------------Library-------------------
method: org.apache.lucene.search.function.FieldScoreQuery$Type.toString()java.lang.String;1
@Override
public String toString() {
    return getClass().getName() + "::" + typeName;
}
---------------Client-------------------
method: org.eclipse.ecf.core.identity.BaseID.namespaceToExternalForm()java.lang.String;1
protected String namespaceToExternalForm() {
    return namespace.getScheme() + Namespace.SCHEME_SEPARATOR + namespaceGetName();
}

---------------Library-------------------
method: org.objectweb.asm.Label.toString()java.lang.String;1
@Override
public String toString() {
    return "L" + System.identityHashCode(this);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.AbstractJavaScanner.getBoldKey(java.lang.String;)java.lang.String;2
protected String getBoldKey(String colorKey) {
    return colorKey + PreferenceConstants.EDITOR_BOLD_SUFFIX;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.target.TargetDefinition.getAllBundles()Aorg.eclipse.pde.core.target.TargetBundle;1
public TargetBundle[] getAllBundles() {
    return getBundles(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.BackupStore.isEclipseExe(java.io.File;)Z2
private boolean isEclipseExe(File file) {
    return file.getName().equalsIgnoreCase("eclipse.exe") || file.getName().equalsIgnoreCase("eclipsec.exe");
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.JavaSelectMarkerRulerAction2.isBreakpoint(org.eclipse.jface.text.source.Annotation;)Z2
private boolean isBreakpoint(Annotation annotation) {
    return annotation.getType().equals("org.eclipse.debug.core.breakpoint") || annotation.getType().equals(JavaExpandHover.NO_BREAKPOINT_ANNOTATION);
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Observables.proxyObservableList(org.eclipse.core.databinding.observable.list.IObservableList;)org.eclipse.core.databinding.observable.list.IObservableList;1
public static IObservableList proxyObservableList(IObservableList target) {
    return new  DecoratingObservableList(target, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.expressions.AndExpression.equals(java.lang.Object;)Z2
@Override
public final boolean equals(final Object object) {
    if (object instanceof AndExpression) {
        final AndExpression that = (AndExpression) object;
        return equals(this.fExpressions, that.fExpressions);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.eclipse.jface.viewers.DialogCellEditor$1.keyReleased(org.eclipse.swt.events.KeyEvent;)V2
@Override
public void keyReleased(KeyEvent e) {
    if (e.character == '') {
        fireCancelEditor();
    }
}
---------------Client-------------------
method: org.eclipse.equinox.p2.ui.RepositoryManipulationPage$5.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
public void keyPressed(KeyEvent e) {
    if (e.keyCode == SWT.DEL) {
        removeRepositories();
    }
}

---------------Library-------------------
method: org.eclipse.osgi.internal.loader.BundleLoader.findClass(java.lang.String;)java.lang.Class;2
public Class<?> findClass(String name) throws ClassNotFoundException {
    return findClass(name, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.osgi.util.tracker.ServiceTracker.open()V1
public void open() {
    open(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.PatternSearchJob.toString()java.lang.String;1
public String toString() {
    return "searching " + this.pattern.toString();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.ClassFile.getElementName()java.lang.String;1
public String getElementName() {
    return this.name + SuffixConstants.SUFFIX_STRING_class;
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.PrintData.generateToc(java.io.Writer;)V2
private void generateToc(Writer out) throws IOException {
    int tocGenerated = 0;
    out.write("<html>\n");
    out.write("<head>\n");
    out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
    out.write("<title>" + UrlUtil.htmlEncode(getTitle()) + "</title>\n");
    out.write("<link rel=\"stylesheet\" href=\"print.css\" charset=\"utf-8\" type=\"text/css\">\n");
    out.write("</head>\n");
    out.write("<body dir=\"" + (isRTL ? "right" : "left") + "\" onload=\"print()\">\n");
    out.write("<div id=\"toc\">\n");
    out.write("<h1>");
    out.write(getTitle());
    out.write("</h1>\n");
    out.write("<h2>");
    out.write(ServletResources.getString("TocHeading", request));
    out.write("</h2>\n");
    out.write("<div id=\"toc_content\">\n");
    ITopic topic = getTopic();
    String href = topic.getHref();
    if (href != null && href.length() > 0) {
        tocGenerated++;
    }
    ITopic[] subtopics = ScopeUtils.inScopeTopics(topic.getSubtopics(), scope);
    for (int i = 0; i < subtopics.length; ++i) {
        tocGenerated = generateToc(subtopics[i], String.valueOf(i + 1), tocGenerated, out);
    }
    out.write("</div>\n");
    out.write("</div>\n");
    out.write("</body>\n");
    out.write("</html>\n");
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.actions.ToggleBreakpointAdapter.toggleBreakpoints(org.eclipse.ui.IWorkbenchPart;org.eclipse.jface.viewers.ISelection;)V3
public void toggleBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
    ISelection sel = translateToMembers(part, selection);
    if (sel instanceof IStructuredSelection) {
        IMember member = (IMember) ((IStructuredSelection) sel).getFirstElement();
        int mtype = member.getElementType();
        if (mtype == IJavaElement.FIELD || mtype == IJavaElement.METHOD || mtype == IJavaElement.INITIALIZER) {
            if (selection instanceof ITextSelection) {
                ITextSelection ts = (ITextSelection) selection;
                IType declaringType = member.getDeclaringType();
                IResource resource = BreakpointUtils.getBreakpointResource(declaringType);
                IJavaLineBreakpoint breakpoint = JDIDebugModel.lineBreakpointExists(resource, getQualifiedName(declaringType), ts.getStartLine() + 1);
                if (breakpoint != null) {
                    deleteBreakpoint(breakpoint, part, null);
                    return;
                }
                CompilationUnit unit = parseCompilationUnit(getTextEditor(part));
                ValidBreakpointLocationLocator loc = new  ValidBreakpointLocationLocator(unit, ts.getStartLine() + 1, true, true);
                unit.accept(loc);
                if (loc.getLocationType() == ValidBreakpointLocationLocator.LOCATION_METHOD) {
                    toggleMethodBreakpoints(part, sel);
                } else if (loc.getLocationType() == ValidBreakpointLocationLocator.LOCATION_FIELD) {
                    toggleWatchpoints(part, ts);
                } else if (loc.getLocationType() == ValidBreakpointLocationLocator.LOCATION_LINE) {
                    toggleLineBreakpoints(part, ts, false, loc);
                }
            }
        } else if (member.getElementType() == IJavaElement.TYPE) {
            toggleClassBreakpoints(part, sel);
        } else {
            toggleLineBreakpoints(part, selection, true, null);
        }
    }
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.osgi.internal.signedcontent.BERProcessor.endOfSequence()Z1
public boolean endOfSequence() {
    return offset == -1;
}
---------------Client-------------------
method: org.eclipse.equinox.p2.internal.repository.tools.RepositoryDescriptor.isBoth()Z1
public boolean isBoth() {
    return kind == TYPE_BOTH;
}

---------------Library-------------------
method: org.eclipse.pde.internal.launching.launcher.LaunchListener.launchRemoved(org.eclipse.debug.core.ILaunch;)V2
public void launchRemoved(ILaunch launch) {
    update(launch, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.ProjectDescription.getBuildSpec()Aorg.eclipse.core.resources.ICommand;1
public ICommand[] getBuildSpec() {
    return getBuildSpec(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaElementDelta.getAddedChildren()Aorg.eclipse.jdt.core.IJavaElementDelta;1
public IJavaElementDelta[] getAddedChildren() {
    return getChildrenOfType(ADDED);
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.swt.E4Testable.waitForEarlyStartup()V1
private void waitForEarlyStartup() {
    try {
        Job.getJobManager().join("earlyStartup", null);
    } catch (OperationCanceledException e) {
    } catch (InterruptedException e) {
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.testing.WorkbenchTestable.waitForEarlyStartup()V1
private void waitForEarlyStartup() {
    try {
        Job.getJobManager().join(Workbench.EARLY_STARTUP_FAMILY, null);
    } catch (OperationCanceledException e) {
    } catch (InterruptedException e) {
    }
}

---------------Library-------------------
method: org.eclipse.osgi.internal.module.VersionHashMap.remove(org.eclipse.osgi.internal.module.VersionSupplier;)org.eclipse.osgi.internal.module.VersionSupplier;2
public V remove(V toBeRemoved) {
    return contains(toBeRemoved, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl.createCDataSectionSelector(java.lang.String;)org.w3c.css.sac.CharacterDataSelector;2
@Override
public CharacterDataSelector createCDataSectionSelector(String data) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.WorkbenchBrowserSupport.dispose()V1
protected void dispose() {
    activeSupport = null;
    initialized = false;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.setOK()V1
public void setOK() {
    fStatusMessage = null;
    fSeverity = IStatus.OK;
}

---------------Library-------------------
method: org.apache.lucene.search.spans.SpanMultiTermQueryWrapper.getSpans(org.apache.lucene.index.IndexReader;)org.apache.lucene.search.spans.Spans;2
@Override
public Spans getSpans(IndexReader reader) throws IOException {
    throw new  UnsupportedOperationException("Query should have been rewritten");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.views.bookmarkexplorer.BookmarkNavigator$ChangeSortDirectionAction.run()V1
public void run() {
    comparator.setTopPriorityDirection(direction);
    updateSortState();
    viewer.refresh();
    IDialogSettings workbenchSettings = getPlugin().getDialogSettings();
    IDialogSettings settings = workbenchSettings.getSection("BookmarkSortState");
    if (settings == null) {
        settings = workbenchSettings.addNewSection("BookmarkSortState");
    }
    comparator.saveState(settings);
}
---------------Client-------------------
method: org.eclipse.ui.views.tasklist.TaskList$SortByAction.run()V1
public void run() {
    comparator.setTopPriority(column);
    updateSortingState();
    viewer.refresh();
    IDialogSettings workbenchSettings = getPlugin().getDialogSettings();
    IDialogSettings settings = workbenchSettings.getSection(TAG_SORT_SECTION);
    if (settings == null) {
        settings = workbenchSettings.addNewSection(TAG_SORT_SECTION);
    }
    comparator.saveState(settings);
}

---------------Library-------------------
method: org.apache.felix.gogo.runtime.CommandSessionImpl.close()V1
public void close() {
    this.closed = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCS.addItem(ILorg.eclipse.pde.internal.ua.core.cheatsheet.simple.ISimpleCSItem;)V3
public void addItem(int index, ISimpleCSItem item) {
    addChildNode((IDocumentElementNode) item, index, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleErrorToken(java.lang.String;Z)V3
protected void handleErrorToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.jdt.core.SourceRange.toString()java.lang.String;1
public String toString() {
    StringBuffer buffer = new  StringBuffer();
    buffer.append("[offset=");
    buffer.append(this.offset);
    buffer.append(", length=");
    buffer.append(this.length);
    buffer.append("]");
    return buffer.toString();
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.syncinfo.BaserevInfo.getEntryLine()java.lang.String;1
public String getEntryLine() {
    StringBuffer result = new  StringBuffer();
    result.append(BASEREV_PREFIX);
    result.append(name);
    result.append(ResourceSyncInfo.SEPARATOR);
    result.append(revision);
    result.append(ResourceSyncInfo.SEPARATOR);
    return result.toString();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.surround.SurroundWithTryCatchRefactoring.create(org.eclipse.jdt.core.ICompilationUnit;org.eclipse.jface.text.ITextSelection;)org.eclipse.jdt.internal.corext.refactoring.surround.SurroundWithTryCatchRefactoring;2
public static SurroundWithTryCatchRefactoring create(ICompilationUnit cu, ITextSelection selection) {
    return create(cu, selection, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jetty.server.Response.encodeURL(java.lang.String;)java.lang.String;2
public String encodeURL(String url) {
    final Request request = _connection.getRequest();
    SessionManager sessionManager = request.getSessionManager();
    if (sessionManager == null)
        return url;
    HttpURI uri = null;
    if (sessionManager.isCheckingRemoteSessionIdEncoding() && URIUtil.hasScheme(url)) {
        uri = new  HttpURI(url);
        String path = uri.getPath();
        path = (path == null ? "" : path);
        int port = uri.getPort();
        if (port < 0)
            port = HttpSchemes.HTTPS.equalsIgnoreCase(uri.getScheme()) ? 443 : 80;
        if (!request.getServerName().equalsIgnoreCase(uri.getHost()) || request.getServerPort() != port || !path.startsWith(request.getContextPath()))
            return url;
    }
    String sessionURLPrefix = sessionManager.getSessionIdPathParameterNamePrefix();
    if (sessionURLPrefix == null)
        return url;
    if (url == null)
        return null;
    if ((sessionManager.isUsingCookies() && request.isRequestedSessionIdFromCookie()) || !sessionManager.isUsingURLs()) {
        int prefix = url.indexOf(sessionURLPrefix);
        if (prefix != -1) {
            int suffix = url.indexOf("?", prefix);
            if (suffix < 0)
                suffix = url.indexOf("#", prefix);
            if (suffix <= prefix)
                return url.substring(0, prefix);
            return url.substring(0, prefix) + url.substring(suffix);
        }
        return url;
    }
    HttpSession session = request.getSession(false);
    if (session == null)
        return url;
    if (!sessionManager.isValid(session))
        return url;
    String id = sessionManager.getNodeId(session);
    if (uri == null)
        uri = new  HttpURI(url);
    int prefix = url.indexOf(sessionURLPrefix);
    if (prefix != -1) {
        int suffix = url.indexOf("?", prefix);
        if (suffix < 0)
            suffix = url.indexOf("#", prefix);
        if (suffix <= prefix)
            return url.substring(0, prefix + sessionURLPrefix.length()) + id;
        return url.substring(0, prefix + sessionURLPrefix.length()) + id + url.substring(suffix);
    }
    int suffix = url.indexOf('?');
    if (suffix < 0)
        suffix = url.indexOf('#');
    if (suffix < 0) {
        return url + ((HttpSchemes.HTTPS.equalsIgnoreCase(uri.getScheme()) || HttpSchemes.HTTP.equalsIgnoreCase(uri.getScheme())) && uri.getPath() == null ? "/" : "") + sessionURLPrefix + id;
    }
    return url.substring(0, suffix) + ((HttpSchemes.HTTPS.equalsIgnoreCase(uri.getScheme()) || HttpSchemes.HTTP.equalsIgnoreCase(uri.getScheme())) && uri.getPath() == null ? "/" : "") + sessionURLPrefix + id + url.substring(suffix);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderRightWidth(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderRightWidth(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-right-width");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.PluginPathFinder.getFeaturePaths(java.lang.String;)Ajava.net.URL;1
public static URL[] getFeaturePaths(String platformHome) {
    return getPlatformXMLPaths(platformHome, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.repository.MetadataRepositoryManager.loadRepository(java.net.URI;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;3
public IMetadataRepository loadRepository(URI location, IProgressMonitor monitor) throws ProvisionException {
    return loadRepository(location, 0, monitor);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSConditionFactoryImpl.createNegativeCondition(org.w3c.css.sac.Condition;)org.w3c.css.sac.NegativeCondition;2
@Override
public NegativeCondition createNegativeCondition(Condition condition) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.analysis.tokenattributes.KeywordAttributeImpl.hashCode()I1
@Override
public int hashCode() {
    return keyword ? 31 : 37;
}
---------------Client-------------------
method: org.osgi.framework.VersionRange.getLeftType()C1
public char getLeftType() {
    return leftClosed ? LEFT_CLOSED : LEFT_OPEN;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement.createFromExisting(org.eclipse.jdt.core.IClasspathEntry;org.eclipse.jdt.core.IJavaProject;)org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement;2
public static CPListElement createFromExisting(IClasspathEntry curr, IJavaProject project) {
    return create(curr, false, project);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSMediaRuleImpl.setRuleList(org.eclipse.e4.ui.css.core.impl.dom.CSSRuleListImpl;)V2
public void setRuleList(CSSRuleListImpl rules) {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jetty.util.Scanner.getRecursive()Z1
public boolean getRecursive() {
    return _scanDepth == -1;
}
---------------Client-------------------
method: org.eclipse.equinox.p2.internal.repository.tools.RepositoryDescriptor.isBoth()Z1
public boolean isBoth() {
    return kind == TYPE_BOTH;
}

---------------Library-------------------
method: org.apache.batik.css.engine.CSSEngine$DocumentAdapter.throwUnsupportedEx()V1
private void throwUnsupportedEx() {
    throw new  UnsupportedOperationException("you try to use an empty method in Adapter-class");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.RuntimeClasspathEntryResolver.getVariableName()java.lang.String;1
public String getVariableName() {
    return fConfigurationElement.getAttribute("variable");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetUnion.upperBound()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet;1
@Override
public TypeSet upperBound() {
    throw new  IllegalStateException("unimplemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.PluginClassCodeGenerator.getDependencies()Aorg.eclipse.pde.core.plugin.IPluginReference;1
public IPluginReference[] getDependencies() {
    ArrayList<PluginReference> result = new  ArrayList<PluginReference>();
    if (fPluginData.isUIPlugin())
        result.add(new  PluginReference("org.eclipse.ui", null, 0));
    if (!fPluginData.isLegacy() && fPluginData.getOSGiFramework() == null)
        result.add(new  PluginReference(IPDEBuildConstants.BUNDLE_CORE_RUNTIME, null, 0));
    return result.toArray(new IPluginReference[result.size()]);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ForStatement.memSize()I1
int memSize() {
    return super.memSize() + 4 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.osgi.storage.bundlefile.BundleFile.getEntryPaths(java.lang.String;)java.util.Enumeration;2
public Enumeration<String> getEntryPaths(String path) {
    return getEntryPaths(path, false);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.viewers.IUDetailsLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object obj) {
    return getColumnText(obj, PRIMARY_COLUMN);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.dialogs.AvailableIUsPage$4.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event event) {
    setAllChecked(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocStandardWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(STYLESHEETSTATUS);
}

---------------Library-------------------
method: org.eclipse.osgi.internal.module.ResolverConstraint.clearPossibleSuppliers()V1
void clearPossibleSuppliers() {
    possibleSuppliers = null;
    selectedSupplierIndex = 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.setOK()V1
public void setOK() {
    fStatusMessage = null;
    fSeverity = IStatus.OK;
}

---------------Library-------------------
method: org.eclipse.jface.action.StatusLine$4.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    setCanceled(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocStandardWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(STYLESHEETSTATUS);
}

---------------Library-------------------
method: org.eclipse.ecf.core.provider.BaseContainerInstantiator.createInstance(org.eclipse.ecf.core.ContainerTypeDescription;Ajava.lang.Object;)org.eclipse.ecf.core.IContainer;3
public IContainer createInstance(ContainerTypeDescription description, Object[] parameters) throws ContainerCreateException {
    throw new  ContainerCreateException("createInstance not supported");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSHistoryFilter.hasAuthor()Z1
protected boolean hasAuthor() {
    return !author.equals("");
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.formatter.FormattingPreferences.useSpacesInsteadOfTabs()Z1
public boolean useSpacesInsteadOfTabs() {
    return !fPrefs.getBoolean(AntEditorPreferenceConstants.FORMATTER_TAB_CHAR);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.declaration.AnnotationValueImpl.toString()java.lang.String;1
public String toString() {
    return _value == null ? "" : _value.toString();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.text.DSComponent.addPropertiesElement(org.eclipse.pde.internal.ds.core.IDSProperties;)V2
public void addPropertiesElement(IDSProperties properties) {
    this.addChildNode(properties, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jface.action.LegacyActionTools.escapeMnemonics(java.lang.String;)java.lang.String;1
public static final String escapeMnemonics(String text) {
    return Util.replaceAll(text, "&", "&&");
}
---------------Client-------------------
method: org.eclipse.jdt.core.JavaConventions.validateClassFileName(java.lang.String;)org.eclipse.core.runtime.IStatus;1
public static IStatus validateClassFileName(String name) {
    return validateClassFileName(name, CompilerOptions.VERSION_1_3, CompilerOptions.VERSION_1_3);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.RegistryCSSPropertyHandlerProvider.logError(java.lang.String;)V2
protected void logError(String message) {
    RuntimeLog.log(new  Status(IStatus.ERROR, "org.eclipse.e4.ui.css.core", message));
}
---------------Client-------------------
method: org.eclipse.jdt.apt.ui.internal.util.ExceptionHandler.log(java.lang.Throwable;java.lang.String;)V2
public static void log(Throwable t, String message) {
    AptUIPlugin.log(new  Status(IStatus.ERROR, AptUIPlugin.PLUGIN_ID, AptUIPlugin.INTERNAL_ERROR, message, t));
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.ide.BaseEditorTemplate.getNewFiles()Ajava.lang.String;1
public String[] getNewFiles() {
    return new String[] { "icons/" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntElementAdapterFactory.getAdapterList()Ajava.lang.Class;1
@Override
public Class[] getAdapterList() {
    return new Class[] { IResource.class };
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.browsing.JavaBrowsingContentProvider.postRefresh(java.lang.Object;)V2
private void postRefresh(final Object root) {
    postRefresh(root, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.debug.internal.core.LaunchManager.initializeComparators()V1
private synchronized void initializeComparators() {
    if (fComparators == null) {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(DebugPlugin.getUniqueIdentifier(), DebugPlugin.EXTENSION_POINT_LAUNCH_CONFIGURATION_COMPARATORS);
        IConfigurationElement[] infos = extensionPoint.getConfigurationElements();
        fComparators = new  HashMap<String, LaunchConfigurationComparator>(infos.length);
        IConfigurationElement configurationElement = null;
        String attr = null;
        for (int i = 0; i < infos.length; i++) {
            configurationElement = infos[i];
            attr = configurationElement.getAttribute("attribute");
            if (attr != null) {
                fComparators.put(attr, new  LaunchConfigurationComparator(configurationElement));
            } else {
                IStatus s = new  Status(IStatus.ERROR, DebugPlugin.getUniqueIdentifier(), DebugException.INTERNAL_ERROR, MessageFormat.format("Invalid launch configuration comparator extension defined by plug-in {0} - attribute not specified.", new Object[] { configurationElement.getContributor().getName() }), null);
                DebugPlugin.log(s);
            }
        }
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.getScope()java.lang.String;1
public String getScope() {
    if (workingSetName != null && workingSetName.length() != 0)
        return workingSetName;
    if (isSearchRequest()) {
        workingSetName = request.getParameter("scope");
        if (workingSetName == null) {
            workingSetName = request.getParameter("workingSet");
        }
    } else {
        workingSetName = wsmgr.getCurrentWorkingSet();
    }
    if (workingSetName == null || workingSetName.length() == 0 || getMode() == RequestData.MODE_INFOCENTER && wsmgr.getWorkingSet(workingSetName) == null)
        workingSetName = ServletResources.getString("All", request);
    return workingSetName;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.PluginHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(""));
}
---------------Client-------------------
method: org.eclipse.ant.internal.core.contentDescriber.AntHandler.resolveEntity(java.lang.String;java.lang.String;)org.xml.sax.InputSource;3
@Override
public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
    return new  InputSource(new  StringReader(IAntCoreConstants.EMPTY_STRING));
}

---------------Library-------------------
method: org.eclipse.osgi.internal.serviceregistry.ServiceRegistry$10.getHookMethodName()java.lang.String;1
public String getHookMethodName() {
    return added ? "added" : "removed";
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.Equals.getOperator()java.lang.String;1
public String getOperator() {
    return negate ? OPERATOR_NOT_EQUALS : OPERATOR_EQUALS;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSDocumentHandlerImpl.startFontFace()V1
@Override
public void startFontFace() throws CSSException {
    ignore = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jface.text.AbstractDocument.acceptPostNotificationReplaces()V1
public void acceptPostNotificationReplaces() {
    fAcceptPostNotificationReplaces = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.Phase.toString()java.lang.String;1
public String toString() {
    return getClass().getName() + " - " + this.weight;
}
---------------Client-------------------
method: org.eclipse.ecf.core.identity.BaseID.namespaceToExternalForm()java.lang.String;1
protected String namespaceToExternalForm() {
    return namespace.getScheme() + Namespace.SCHEME_SEPARATOR + namespaceGetName();
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.validation.ValidatedObservableValue.doSetValue(java.lang.Object;)V2
protected void doSetValue(Object value) {
    internalSetValue(value, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.FeatureExportWizardPage.doExportMetadata()Z1
protected boolean doExportMetadata() {
    if (fOptionsTab instanceof FeatureOptionsTab) {
        return ((FeatureOptionsTab) fOptionsTab).doExportMetadata();
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.rows.ExtensionAttributeRow.getUse()I1
protected int getUse() {
    if (att instanceof ISchemaAttribute)
        return ((ISchemaAttribute) att).getUse();
    return ISchemaAttribute.OPTIONAL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.LexicalSortingAction.run()V1
@Override
public void run() {
    valueChanged(isChecked(), true);
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.ViewerSettingsAndStatusDialog.initializeDialog()V1
protected void initializeDialog() {
    handleStatusUdpate(IStatus.INFO, getDefaultMessage());
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.wizards.PatchInaccessibleProjectsPage$3.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    setAllChecked(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.BundleVersionRange.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object obj) {
    if (obj instanceof BundleVersionRange) {
        BundleVersionRange range = (BundleVersionRange) obj;
        return fRange.equals(range.fRange);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.eclipse.jdt.core.refactoring.descriptors.JavaRefactoringDescriptor.handleToElement(java.lang.String;java.lang.String;)org.eclipse.jdt.core.IJavaElement;2
protected static IJavaElement handleToElement(final String project, final String handle) {
    return handleToElement(project, handle, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.getMemberDeclarationStartPosition()I1
protected int getMemberDeclarationStartPosition() {
    return this.fTypeRange[0];
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringTickProvider.getCheckInitialConditionsTicks()I1
public int getCheckInitialConditionsTicks() {
    return fValues[CHECK_INITIAL_CONDITIONS];
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.PluginContentPage$3.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event event) {
    PreferencesUtil.createPreferenceDialogOn(getShell(), "org.eclipse.jdt.debug.ui.jreProfiles", new String[] { "org.eclipse.jdt.debug.ui.jreProfiles" }, null).open();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.launcher.WorkspaceDataBlock$4.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    PreferencesUtil.createPreferenceDialogOn(configureDefaults.getShell(), MainPreferencePage.ID, new String[] { MainPreferencePage.ID }, null).open();
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.history.LocalHistoryPage$RefreshFileHistory.run(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.IStatus;2
public IStatus run(IProgressMonitor monitor) {
    try {
        IStatus status = Status.OK_STATUS;
        LocalFileHistory fileHistory = localFileHistory;
        if (fileHistory == null || shutdown)
            return status;
        try {
            fileHistory.refresh(Policy.subMonitorFor(monitor, 50));
        } catch (CoreException ex) {
            status = new  TeamStatus(ex.getStatus().getSeverity(), TeamUIPlugin.ID, ex.getStatus().getCode(), ex.getMessage(), ex, file);
        }
        update(fileHistory.getFileRevisions(), Policy.subMonitorFor(monitor, 50));
        if (status != Status.OK_STATUS) {
            this.setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
            this.setProperty(IProgressConstants.NO_IMMEDIATE_ERROR_PROMPT_PROPERTY, Boolean.TRUE);
        }
        if (Policy.DEBUG_HISTORY) {
            String time = new  SimpleDateFormat("m:ss.SSS").format(new  Date(System.currentTimeMillis()));
            System.out.println(time + ": RefreshFileHistoryJob#run finished, status: " + status);
        }
        return status;
    } finally {
        monitor.done();
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;java.lang.Throwable;)V3
public void debug(Object message, Throwable t) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message), t);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.toString()java.lang.String;1
public String toString() {
    return "FIELD: " + getName();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.jface.databinding.viewers.ViewerProperties.singlePostSelection()org.eclipse.jface.databinding.viewers.IViewerValueProperty;0
public static IViewerValueProperty singlePostSelection() {
    return new  SelectionProviderSingleSelectionProperty(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.SuperReference.implicitSuperConstructorCall()org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;0
public static ExplicitConstructorCall implicitSuperConstructorCall() {
    return new  ExplicitConstructorCall(ExplicitConstructorCall.ImplicitSuper);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.hierarchy.TypeHierarchy.readUntil(java.io.InputStream;B)AB2
protected static byte[] readUntil(InputStream input, byte separator) throws JavaModelException, IOException {
    return readUntil(input, separator, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeInputFileObject.delete()Z1
@Override
public boolean delete() {
    throw new  IllegalStateException("An annotation processor is not permitted to delete resources");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.RefactoringExecutionHelper.perform(ZZ)V3
public void perform(boolean fork, boolean cancelable) throws InterruptedException, InvocationTargetException {
    perform(fork, false, cancelable);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.diagnose.RangeUtil$RangeResult.addInterval(II)V3
void addInterval(int start, int end) {
    addInterval(start, end, NO_FLAG);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceField.getKey()java.lang.String;1
public String getKey() {
    try {
        return getKey(this, false);
    } catch (JavaModelException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.ui.internal.wizards.datatransfer.ArchiveFileExportOperation.exportResource(org.eclipse.core.resources.IResource;)V2
protected void exportResource(IResource exportResource) throws InterruptedException {
    exportResource(exportResource, 1);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.workingsets.WorkingSetConfigurationDialog.selectAll()V1
private void selectAll() {
    fTableViewer.setAllChecked(true);
}
---------------Client-------------------
method: org.eclipse.jface.text.link.LinkedModeUI$Closer.inputDocumentAboutToBeChanged(org.eclipse.jface.text.IDocument;org.eclipse.jface.text.IDocument;)V3
public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
    leave(ILinkedModeListener.EXIT_ALL);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.exports.ProductExportOperation.createBuildPropertiesFile(java.lang.String;AAjava.lang.String;)V3
private void createBuildPropertiesFile(String featureLocation, String[][] configurations) {
    File file = new  File(featureLocation);
    if (!file.exists() || !file.isDirectory())
        file.mkdirs();
    boolean hasLaunchers = PDECore.getDefault().getFeatureModelManager().getDeltaPackFeature() != null;
    Properties properties = new  Properties();
    if (fProduct.includeLaunchers() && !hasLaunchers && configurations.length > 0) {
        String rootPrefix = IBuildPropertiesConstants.ROOT_PREFIX + configurations[0][0] + "." + configurations[0][1] + "." + configurations[0][2];
        properties.put(rootPrefix, getRootFileLocations(hasLaunchers));
        if (TargetPlatform.getOS().equals("macosx")) {
            String plist = createMacInfoPList();
            if (plist != null)
                properties.put(rootPrefix + ".folder." + ECLIPSE_APP_CONTENTS, "absolute:file:" + plist);
            properties.put(rootPrefix + ".folder." + ECLIPSE_APP_MACOS, getLauncherLocations(hasLaunchers));
            properties.put(rootPrefix + ".permissions.755", ECLIPSE_APP_MACOS + "/" + getLauncherName());
        } else {
            properties.put(rootPrefix, getLauncherLocations(hasLaunchers));
            properties.put(rootPrefix + ".permissions.755", getLauncherName());
            if (TargetPlatform.getWS().equals("motif") && TargetPlatform.getOS().equals("linux")) {
                properties.put(rootPrefix + ".permissions.755", "libXm.so.2");
            }
        }
    }
    IJREInfo jreInfo = fProduct.getJREInfo();
    if (jreInfo != null) {
        for (int i = 0; i < configurations.length; i++) {
            String[] config = configurations[i];
            if (!jreInfo.includeJREWithProduct(config[0])) {
                continue;
            }
            File vm = jreInfo.getJVMLocation(config[0]);
            if (vm != null) {
                if (config[0].equals("macosx") && vm.getPath().startsWith(MAC_JAVA_FRAMEWORK)) {
                    continue;
                }
                String rootPrefix = IBuildPropertiesConstants.ROOT_PREFIX + config[0] + "." + config[1] + "." + config[2];
                properties.put(rootPrefix + ".folder.jre", "absolute:" + vm.getAbsolutePath());
                String perms = (String) properties.get(rootPrefix + ".permissions.755");
                if (perms != null) {
                    StringBuffer buffer = new  StringBuffer(perms);
                    buffer.append(",");
                    buffer.append("jre/bin/java");
                    properties.put(rootPrefix + ".permissions.755", buffer.toString());
                }
            }
        }
    }
    if (fInfo.exportSource && fInfo.exportSourceBundle) {
        properties.put(IBuildPropertiesConstants.PROPERTY_INDIVIDUAL_SOURCE, "true");
        List<IPluginModelBase> workspacePlugins = Arrays.asList(PluginRegistry.getWorkspaceModels());
        for (int i = 0; i < fInfo.items.length; i++) {
            if (fInfo.items[i] instanceof IFeatureModel) {
                IFeature feature = ((IFeatureModel) fInfo.items[i]).getFeature();
                properties.put("generate.feature@" + feature.getId().trim() + ".source", feature.getId());
            } else {
                BundleDescription bundle = null;
                if (fInfo.items[i] instanceof IPluginModelBase) {
                    bundle = ((IPluginModelBase) fInfo.items[i]).getBundleDescription();
                }
                if (bundle == null) {
                    if (fInfo.items[i] instanceof BundleDescription)
                        bundle = (BundleDescription) fInfo.items[i];
                }
                if (bundle == null)
                    continue;
                if (workspacePlugins.contains(PluginRegistry.findModel(bundle))) {
                    properties.put("generate.plugin@" + bundle.getSymbolicName().trim() + ".source", bundle.getSymbolicName());
                }
            }
        }
    }
    save(new  File(file, ICoreConstants.BUILD_FILENAME_DESCRIPTOR), properties, "Build Configuration");
}
---------------Client-------------------
method: org.eclipse.ant.internal.launching.launchConfigurations.AntLaunchDelegate.configureAntRunner(org.eclipse.debug.core.ILaunchConfiguration;org.eclipse.core.runtime.IPath;java.lang.String;java.lang.StringBuffer;Ajava.lang.String;java.util.Map;Ajava.lang.String;Ajava.lang.String;Ajava.net.URL;java.lang.String;Z)org.eclipse.ant.core.AntRunner;12
private AntRunner configureAntRunner(ILaunchConfiguration configuration, IPath location, String baseDir, StringBuffer idProperty, String[] arguments, Map<String, String> userProperties, String[] propertyFiles, String[] targets, URL[] customClasspath, String antHome, boolean setInputHandler) throws CoreException {
    int argLength = 1;
    if (arguments != null) {
        argLength += arguments.length;
    }
    if (baseDir != null && baseDir.length() > 0) {
        argLength++;
    }
    String[] runnerArgs = new String[argLength];
    if (arguments != null) {
        System.arraycopy(arguments, 0, runnerArgs, 0, arguments.length);
    }
    if (baseDir != null && baseDir.length() > 0) {
        runnerArgs[runnerArgs.length - 2] = BASE_DIR_PREFIX + baseDir;
    }
    runnerArgs[runnerArgs.length - 1] = idProperty.toString();
    AntRunner runner = new  AntRunner();
    runner.setBuildFileLocation(location.toOSString());
    boolean captureOutput = ExternalToolsCoreUtil.getCaptureOutput(configuration);
    if (captureOutput) {
        if (fMode.equals(ILaunchManager.DEBUG_MODE)) {
            runner.addBuildLogger(ANT_DEBUG_LOGGER_CLASS);
        } else {
            runner.addBuildLogger(ANT_LOGGER_CLASS);
        }
    } else {
        runner.addBuildLogger(NULL_LOGGER_CLASS);
    }
    if (setInputHandler) {
        runner.setInputHandler(INPUT_HANDLER_CLASS);
    } else {
        runner.setInputHandler("");
    }
    runner.setArguments(runnerArgs);
    if (userProperties != null) {
        runner.addUserProperties(userProperties);
    }
    if (propertyFiles != null) {
        runner.setPropertyFiles(propertyFiles);
    }
    if (targets != null) {
        runner.setExecutionTargets(targets);
    }
    if (customClasspath != null) {
        runner.setCustomClasspath(customClasspath);
    }
    if (antHome != null) {
        runner.setAntHome(antHome);
    }
    return runner;
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.swt.PageStyleManager.getProperty(java.lang.String;)java.lang.String;2
public String getProperty(String key) {
    return getProperty(key, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.contextlaunching.LaunchingResourceManager.getLabel(org.eclipse.jface.viewers.IStructuredSelection;org.eclipse.core.resources.IResource;java.util.List;org.eclipse.debug.ui.ILaunchGroup;)java.lang.String;5
protected String getLabel(IStructuredSelection selection, IResource resource, List<LaunchShortcutExtension> shortcuts, ILaunchGroup group) {
    List<LaunchShortcutExtension> sc = pruneShortcuts(shortcuts, resource, group.getMode());
    LaunchConfigurationManager lcm = DebugUIPlugin.getDefault().getLaunchConfigurationManager();
    ILaunchConfiguration config = lcm.isSharedConfig(resource);
    if (config != null) {
        return appendLaunched(config);
    }
    List<ILaunchConfiguration> configs = getParticipatingLaunchConfigurations(selection, resource, sc, group.getMode());
    int csize = configs.size();
    if (csize == 1) {
        return appendLaunched(configs.get(0));
    } else if (csize > 1) {
        config = lcm.getMRUConfiguration(configs, group, resource);
        if (config != null) {
            return appendLaunched(config);
        } else {
            return ContextMessages.ContextRunner_14;
        }
    } else {
        List<LaunchShortcutExtension> exts = fExtCache.get(resource);
        if (exts == null && resource != null) {
            fExtCache.put(resource, sc);
        }
        int esize = sc.size();
        if (esize == 0) {
            if (resource != null && shouldCheckParent()) {
                IProject project = resource.getProject();
                if (project != null && !project.equals(resource)) {
                    return getLabel(selection, project, sc, group);
                }
            } else if (shouldLaunchLast() || resource == null) {
                return getlastLaunchedLabel(group);
            } else {
                return ContextMessages.ContextRunner_15;
            }
        }
        if (esize == 1) {
            if (resource != null) {
                return resource.getName();
            } else {
                return MessageFormat.format(ContextMessages.LaunchingResourceManager_1, new Object[] { sc.get(0).getLabel() });
            }
        } else {
            return ContextMessages.ContextRunner_14;
        }
    }
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.addLibraries(org.osgi.framework.Bundle;java.util.List;)V3
private void addLibraries(Bundle source, List<AntClasspathEntry> destination) throws IOException, MalformedURLException {
    ManifestElement[] libraries = null;
    try {
        libraries = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, source.getHeaders(IAntCoreConstants.EMPTY_STRING).get(Constants.BUNDLE_CLASSPATH));
    } catch (BundleException e) {
        IStatus status = new  Status(IStatus.ERROR, AntCorePlugin.PI_ANTCORE, AntCorePlugin.ERROR_MALFORMED_URL, InternalCoreAntMessages.AntCorePreferences_0, e);
        AntCorePlugin.getPlugin().getLog().log(status);
        return;
    }
    if (libraries == null) {
        return;
    }
    URL url = null;
    for (int i = 0; i < libraries.length; i++) {
        url = source.getEntry(libraries[i].getValue());
        if (url != null) {
            destination.add(new  AntClasspathEntry(FileLocator.toFileURL(url)));
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMPackage.toString()java.lang.String;1
public String toString() {
    return "PACKAGE: " + getName();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.ui.internal.ActionExpression.equals(java.lang.Object;)Z2
@Override
public final boolean equals(final Object object) {
    if (object instanceof ActionExpression) {
        final ActionExpression that = (ActionExpression) object;
        return Util.equals(this.root, that.root);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.apache.commons.logging.impl.WeakHashtable$Entry.setValue(java.lang.Object;)java.lang.Object;2
public Object setValue(Object value) {
    throw new  UnsupportedOperationException("Entry.setValue is not supported.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.RuntimeClasspathProvider.getProvider()org.eclipse.jdt.launching.IRuntimeClasspathProvider;1
protected IRuntimeClasspathProvider getProvider() throws CoreException {
    if (fDelegate == null) {
        fDelegate = (IRuntimeClasspathProvider) fConfigurationElement.createExecutableExtension("class");
    }
    return fDelegate;
}
---------------Client-------------------
method: org.eclipse.debug.internal.core.BreakpointImportParticipantDelegate.getDelegate()org.eclipse.debug.core.model.IBreakpointImportParticipant;1
public IBreakpointImportParticipant getDelegate() throws CoreException {
    if (fParticipant == null) {
        fParticipant = (IBreakpointImportParticipant) fElement.createExecutableExtension(IConfigurationElementConstants.PARTICIPANT);
    }
    return fParticipant;
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSSelectorFactory.createProcessingInstructionSelector(java.lang.String;java.lang.String;)org.w3c.css.sac.ProcessingInstructionSelector;3
public ProcessingInstructionSelector createProcessingInstructionSelector(String target, String data) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.services.ServiceLocator.registerService(java.lang.Class;java.lang.Object;)V3
public final void registerService(final Class api, final Object service) {
    registerService(api, service, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.genericInferenceError(java.lang.String;org.eclipse.jdt.internal.compiler.lookup.InvocationSite;)V3
public void genericInferenceError(String message, InvocationSite invocationSite) {
    genericInferenceProblem(message, invocationSite, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.ui.internal.cheatsheets.registry.Category.getRawParentPath()java.lang.String;1
public String getRawParentPath() {
    return configurationElement == null ? null : configurationElement.getAttribute("parentCategory");
}
---------------Client-------------------
method: org.eclipse.ui.internal.registry.Category.getRawParentPath()java.lang.String;1
public String getRawParentPath() {
    return configurationElement == null ? null : configurationElement.getAttribute(IWorkbenchRegistryConstants.ATT_PARENT_CATEGORY);
}

---------------Library-------------------
method: org.eclipse.jface.text.Position.delete()V1
public void delete() {
    isDeleted = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.change.impl.FeatureChangeImpl.apply(org.eclipse.emf.ecore.EObject;Z)V3
protected void apply(EObject originalObject, boolean reverse) {
    process(originalObject, reverse, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main.handleErrorToken(java.lang.String;Z)V3
protected void handleErrorToken(String token, boolean isEnabling) {
    handleErrorOrWarningToken(token, isEnabling, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.buildpath.BuildPathSupport$JUnitPluginDescription.getBundleLocation(java.lang.String;org.eclipse.osgi.service.resolver.VersionRange;)org.eclipse.core.runtime.IPath;3
private IPath getBundleLocation(String aBundleId, VersionRange aVersionRange) {
    return getBundleLocation(aBundleId, aVersionRange, false);
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormToolkit.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;3
public Label createLabel(Composite parent, String text) {
    return createLabel(parent, text, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.CodeAssistAdvancedConfigurationBlock$DefaultTableLabelProvider.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(Object element) {
    return getColumnText(element, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.DocumentObject.shouldFireEvent()Z1
protected boolean shouldFireEvent() {
    if (isInTheModel() && isEditable()) {
        return true;
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.RefactoringAvailabilityTester.isRenameVirtualMethodAvailable(org.eclipse.jdt.core.IMethod;)Z1
public static boolean isRenameVirtualMethodAvailable(final IMethod method) throws CoreException {
    return isRenameAvailable(method) && MethodChecks.isVirtual(method);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration$4.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  DefaultInformationControl(parent, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta.accept(org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDeltaVisitor;)V2
@Override
public void accept(IModelDeltaVisitor visitor) {
    doAccept(visitor, 0);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.jface.text.TextViewer.redraws()Z1
protected final boolean redraws() {
    return fRedrawCounter <= 0;
}
---------------Client-------------------
method: org.eclipse.jetty.io.AbstractBuffer.isImmutable()Z1
public boolean isImmutable() {
    return _access <= IMMUTABLE;
}

---------------Library-------------------
method: org.apache.jasper.runtime.TldScanner.getTldListenerMap()java.util.Map;1
@SuppressWarnings("unchecked")
Map<URI, List<String>> getTldListenerMap() {
    return (Map<URI, List<String>>) ctxt.getAttribute("com.sun.appserv.tldlistener.map");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.pde.internal.launching.launcher.LaunchArgumentsHelper.constructClasspath(org.eclipse.debug.core.ILaunchConfiguration;)Ajava.lang.String;1
public static String[] constructClasspath(ILaunchConfiguration configuration) throws CoreException {
    double targetVersion = TargetPlatformHelper.getTargetVersion();
    String jarPath = targetVersion >= 3.3 ? getEquinoxStartupPath(IPDEBuildConstants.BUNDLE_EQUINOX_LAUNCHER) : getStartupJarPath();
    if (jarPath == null && targetVersion < 3.3)
        jarPath = getEquinoxStartupPath("org.eclipse.core.launcher");
    if (jarPath == null)
        return null;
    ArrayList<String> entries = new  ArrayList<String>();
    entries.add(jarPath);
    String bootstrap = configuration.getAttribute(IPDELauncherConstants.BOOTSTRAP_ENTRIES, "");
    StringTokenizer tok = new  StringTokenizer(getSubstitutedString(bootstrap), ",");
    while (tok.hasMoreTokens()) entries.add(tok.nextToken().trim());
    return entries.toArray(new String[entries.size()]);
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jface.text.source.projection.ProjectionAnnotationHover.getHoverLineRange(org.eclipse.jface.text.source.ISourceViewer;I)org.eclipse.jface.text.source.ILineRange;3
public ILineRange getHoverLineRange(ISourceViewer viewer, int lineNumber) {
    return new  LineRange(lineNumber, 1);
}
---------------Client-------------------
method: org.eclipse.emf.ecore.xml.type.internal.RegEx$Op.createChar(I)org.eclipse.emf.ecore.xml.type.internal.RegEx$Op$CharOp;1
static CharOp createChar(int data) {
    if (Op.COUNT)
        Op.nofinstances++;
    return new  CharOp(Op.CHAR, data);
}

---------------Library-------------------
method: org.eclipse.core.databinding.validation.MultiValidator$ValidationStatusObservableValue.makeStale()V1
void makeStale() {
    if (!stale) {
        stale = true;
        fireStale();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.dialogs.ResourceMappingSelectionArea$4.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    checkboxViewer.setAllChecked(false);
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.ui.FileSelectionDialog$4.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
@Override
public void doubleClick(DoubleClickEvent event) {
    buttonPressed(IDialogConstants.OK_ID);
}

---------------Library-------------------
method: org.apache.felix.gogo.runtime.Tokenizer.isBlank(C)Z2
private boolean isBlank(char ch) {
    return ' ' == ch || '\t' == ch;
}
---------------Client-------------------
method: org.eclipse.jface.text.source.AnnotationPainter.isRepaintReason(I)Z2
protected boolean isRepaintReason(int reason) {
    return CONFIGURATION == reason || INTERNAL == reason;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage$WorkspaceDialog$3.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    modified = true;
    validateDialog();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameTypeWizardSimilarElementsOptionsDialog$1.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    updateLabel();
    fSelectedStrategy = RenamingNameSuggestor.STRATEGY_EXACT;
}

---------------Library-------------------
method: org.eclipse.ui.internal.browser.BrowserViewer.setURL(java.lang.String;)V2
public void setURL(String url) {
    setURL(url, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntPage.getContentProvider()org.eclipse.ant.internal.ui.preferences.AntContentProvider;1
protected AntContentProvider getContentProvider() {
    return new  AntContentProvider(false);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}

---------------Library-------------------
method: org.eclipse.compare.internal.core.patch.Hunk.getStartPosition()I1
public int getStartPosition() {
    return getStart(false);
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpParser.isComplete()Z1
public boolean isComplete() {
    return isState(STATE_END);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.product.ProductEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.FinishResult.createException()org.eclipse.ltk.internal.ui.refactoring.FinishResult;0
public static FinishResult createException() {
    return new  FinishResult(0);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.hasTasks()Z1
public boolean hasTasks() {
    return this.taskCount != 0;
}
---------------Client-------------------
method: org.eclipse.jetty.http.AbstractGenerator.isCommitted()Z1
public boolean isCommitted() {
    return _state != STATE_HEADER;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ActionExpression$AndExpression.equals(java.lang.Object;)Z2
@Override
public final boolean equals(final Object object) {
    if (object instanceof AndExpression) {
        final AndExpression that = (AndExpression) object;
        return Util.equals(this.list, that.list);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.FilterDescriptor.createFilter()org.eclipse.core.resources.filtermatchers.AbstractFileInfoMatcher;1
public AbstractFileInfoMatcher createFilter() {
    try {
        return (AbstractFileInfoMatcher) element.createExecutableExtension("class");
    } catch (CoreException e) {
        e.printStackTrace();
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.createCompareFilter()org.eclipse.compare.ICompareFilter;1
public ICompareFilter createCompareFilter() {
    try {
        return (ICompareFilter) fConfiguration.createExecutableExtension(CLASS_ATTRIBUTE);
    } catch (CoreException e) {
        CompareUIPlugin.log(e);
    }
    return null;
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSPseudoElementSelector.toString()java.lang.String;1
public String toString() {
    return ":" + getLocalName();
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.FindExceptionOccurrencesAction.selectionChanged(org.eclipse.jface.viewers.IStructuredSelection;)V2
@Override
public void selectionChanged(IStructuredSelection selection) {
    setEnabled(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.callhierarchy.CallHierarchyContentProvider.stripTypeArguments(java.lang.String;)java.lang.String;1
private static String stripTypeArguments(String typeName) {
    int pos = typeName.indexOf('<');
    if (pos != -1)
        return typeName.substring(0, pos);
    return typeName;
}
---------------Client-------------------
method: org.eclipse.ui.internal.browser.WebBrowserUtil.decodeId(java.lang.String;)java.lang.String;1
public static String decodeId(String encodedId) {
    int sep = encodedId.lastIndexOf(STYLE_SEP);
    if (sep != -1) {
        return encodedId.substring(0, sep);
    }
    return encodedId;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.CVSWorkspaceSubscriber.resourceSyncInfoChanged(Aorg.eclipse.core.resources.IResource;)V2
public void resourceSyncInfoChanged(IResource[] changedResources) {
    internalResourceSyncInfoChanged(changedResources, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.apache.batik.util.Base64DecodeStream.close()V1
public void close() throws IOException {
    EOF = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.ui.internal.WorkbenchPlugin.isBidiMessageText()java.lang.Boolean;1
private Boolean isBidiMessageText() {
    String message = WorkbenchMessages.Startup_Loading_Workbench;
    if (message == null)
        return null;
    try {
        boolean isBidi = com.ibm.icu.text.Bidi.requiresBidi(message.toCharArray(), 0, message.length());
        return new  Boolean(isBidi);
    } catch (NoClassDefFoundError e) {
        return null;
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.RecoveredElement.toString()java.lang.String;1
public String toString() {
    return toString(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextArrayDimension()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextArrayDimension() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_ARRAY_DIMENSION);
}

---------------Library-------------------
method: org.eclipse.ui.internal.expressions.ActivePartExpression.equals(java.lang.Object;)Z2
@Override
public final boolean equals(final Object object) {
    if (object instanceof ActivePartExpression) {
        final ActivePartExpression that = (ActivePartExpression) object;
        return equals(this.activePart, that.activePart);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover.getOrder(org.eclipse.jface.text.source.Annotation;)I2
protected int getOrder(Annotation annotation) {
    if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
        IAnnotationAccessExtension extension = (IAnnotationAccessExtension) fAnnotationAccess;
        return extension.getLayer(annotation);
    }
    return IAnnotationAccessExtension.DEFAULT_LAYER;
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.swt.PageForm.reflow()V1
public void reflow() {
    categoryPageBook.reflow(true);
}
---------------Client-------------------
method: org.eclipse.jface.text.link.LinkedModeUI$Closer.inputDocumentAboutToBeChanged(org.eclipse.jface.text.IDocument;org.eclipse.jface.text.IDocument;)V3
public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
    leave(ILinkedModeListener.EXIT_ALL);
}

---------------Library-------------------
method: org.eclipse.team.internal.core.importing.BundleImporterExtension.getName()java.lang.String;1
public String getName() {
    return element.getAttribute("name");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.visit(org.eclipse.jdt.core.dom.TextElement;)Z2
@Override
public boolean visit(TextElement node) {
    this.fBuffer.append(node.getText());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.core.runtime.SubMonitor.convert(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.SubMonitor;1
public static SubMonitor convert(IProgressMonitor monitor) {
    return convert(monitor, "", 0);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.bundle.BundlePluginBase.getName()java.lang.String;1
public String getName() {
    return getValue(Constants.BUNDLE_NAME, false);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.dialogs.ProvisioningOperationWizard.recomputePlan(org.eclipse.jface.operation.IRunnableContext;)V2
public void recomputePlan(IRunnableContext runnableContext) {
    recomputePlan(runnableContext, false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.DialogPage.setMessage(java.lang.String;)V2
public void setMessage(String newMessage) {
    setMessage(newMessage, NONE);
}

---------------Library-------------------
method: org.apache.batik.util.gui.resource.JToolbarButton$MouseListener.mouseEntered(java.awt.event.MouseEvent;)V2
public void mouseEntered(MouseEvent ev) {
    setBorderPainted(true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocSpecificsWizardPage$1.validate()V1
@Override
public void validate() {
    doValidation(OVERVIEWSTATUS);
}

---------------Library-------------------
method: org.apache.jasper.xmlparser.XMLChar.supplemental(CC)I2
public static int supplemental(char h, char l) {
    return (h - 0xD800) * 0x400 + (l - 0xDC00) + 0x10000;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.ScannerHelper.toCodePoint(CC)I2
private static int toCodePoint(char high, char low) {
    return (high - Scanner.HIGH_SURROGATE_MIN_VALUE) * 0x400 + (low - Scanner.LOW_SURROGATE_MIN_VALUE) + 0x10000;
}

---------------Library-------------------
method: org.eclipse.swt.browser.MozillaDelegate.getJSLibraryNames()Ajava.lang.String;0
static String[] getJSLibraryNames() {
    return new String[] { "libxul.so" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntElementAdapterFactory.getAdapterList()Ajava.lang.Class;1
@Override
public Class[] getAdapterList() {
    return new Class[] { IResource.class };
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.JavaIndenter.getReferenceIndentation(I)java.lang.StringBuffer;2
public StringBuffer getReferenceIndentation(int offset) {
    return getReferenceIndentation(offset, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.events.ResourceDelta.getAffectedChildren(I)Aorg.eclipse.core.resources.IResourceDelta;2
public IResourceDelta[] getAffectedChildren(int kindMask) {
    return getAffectedChildren(kindMask, IResource.NONE);
}

---------------Library-------------------
method: org.apache.batik.util.gui.resource.JToolbarToggleButton$MouseListener.mouseExited(java.awt.event.MouseEvent;)V2
public void mouseExited(MouseEvent ev) {
    setBorderPainted(false);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.matching.VariablePattern.mustResolve()Z1
protected boolean mustResolve() {
    return this.findReferences || this.fineGrain != 0;
}
---------------Client-------------------
method: org.eclipse.ant.internal.launching.debug.model.AntDebugTarget.canSuspend()Z1
@Override
public boolean canSuspend() {
    return !fTerminated && !fSuspended;
}

---------------Library-------------------
method: org.eclipse.jface.databinding.dialog.DialogPageSupport$6.handleStale(org.eclipse.core.databinding.observable.StaleEvent;)V2
public void handleStale(StaleEvent staleEvent) {
    currentStatusStale = true;
    handleStatusChanged();
}
---------------Client-------------------
method: org.apache.batik.util.gui.CSSMediaPanel$AddMediumDialog$CancelButtonAction.actionPerformed(java.awt.event.ActionEvent;)V2
public void actionPerformed(ActionEvent e) {
    returnCode = CANCEL_OPTION;
    dispose();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.nls.InternationalizeModelTable.isEmpty()Z1
public boolean isEmpty() {
    return fModels.size() == 0;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$StatusWrapper.isOK()Z1
public boolean isOK() {
    return diagnostic.getSeverity() == OK;
}

---------------Library-------------------
method: org.eclipse.jface.text.contentassist.CompletionProposalPopup$EmptyProposal.getSelection(org.eclipse.jface.text.IDocument;)org.eclipse.swt.graphics.Point;2
public Point getSelection(IDocument document) {
    return new  Point(fOffset, 0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.FailureTableDisplay.newTableItem()org.eclipse.swt.widgets.TableItem;1
TableItem newTableItem() {
    return new  TableItem(fTable, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jface.text.projection.ProjectionDocumentManager.documentAboutToBeChanged(org.eclipse.jface.text.DocumentEvent;)V2
public void documentAboutToBeChanged(DocumentEvent event) {
    fireDocumentEvent(true, event);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.UserLibraryMarkerResolutionGenerator$1.run(org.eclipse.core.resources.IMarker;)V2
public void run(IMarker m) {
    changeToExistingLibrary(shell, path, false, project);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.OptionsConfigurationBlock$5.focusLost(org.eclipse.swt.events.FocusEvent;)V2
public void focusLost(FocusEvent e) {
    highlight(parent, labelControl, comboBox, HIGHLIGHT_NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.javadoc.JavaDocScanner$HTMLCommentDetector.isWordStart(C)Z2
public boolean isWordStart(char c) {
    return (c == '<' || c == '-');
}
---------------Client-------------------
method: org.eclipse.jface.text.source.AnnotationPainter.isRepaintReason(I)Z2
protected boolean isRepaintReason(int reason) {
    return CONFIGURATION == reason || INTERNAL == reason;
}

---------------Library-------------------
method: org.apache.lucene.analysis.tokenattributes.CharTermAttributeImpl.toString()java.lang.String;1
@Override
public String toString() {
    return new  String(termBuffer, 0, termLength);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover$InformationControlCreator.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  AnnotationExpansionControl(parent, SWT.NONE, fAnnotationAccess);
}

---------------Library-------------------
method: org.eclipse.ant.internal.launching.launchConfigurations.AntStreamMonitor.flushContents()V1
@Override
public void flushContents() {
    fContents.setLength(0);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderBottomWidth(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderBottomWidth(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-bottom-width");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBorderHandler.applyCSSPropertyBorderLeftWidth(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBorderLeftWidth(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("border-left-width");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.dialogs.WorkbenchWizardNode.getExtent()org.eclipse.swt.graphics.Point;1
@Override
public Point getExtent() {
    return new  Point(-1, -1);
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.renderers.swt.TrimmedPartLayout.computeSize(org.eclipse.swt.widgets.Composite;IIZ)org.eclipse.swt.graphics.Point;5
@Override
protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
    return new  Point(SWT.DEFAULT, SWT.DEFAULT);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSFontFaceRuleImpl.setStyle(org.eclipse.e4.ui.css.core.impl.dom.CSSStyleDeclarationImpl;)V2
public void setStyle(CSSStyleDeclarationImpl decl) {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.JavaPluginImages.createUnManaged(java.lang.String;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
private static ImageDescriptor createUnManaged(String prefix, String name) {
    return create(prefix, name, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.JavaOutlineInformationControl$LexicalSortingAction.run()V1
@Override
public void run() {
    valueChanged(isChecked(), true);
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.ViewerSettingsAndStatusDialog.initializeDialog()V1
protected void initializeDialog() {
    handleStatusUdpate(IStatus.INFO, getDefaultMessage());
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.rewrite.ASTRewrite.createCopyTarget(org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.core.dom.ASTNode;2
public final ASTNode createCopyTarget(ASTNode node) {
    return createTargetNode(node, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.apache.lucene.index.ByteSliceReader.getFilePointer()J1
@Override
public long getFilePointer() {
    throw new  RuntimeException("not implemented");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scanElement()I1
private int scanElement() {
    while (current != -1) {
        if (current == '>') {
            return CHARACTER_DATA_CONTEXT;
        } else if (XMLUtilities.isXMLSpace((char) current)) {
            return ATTRIBUTE_NAME_CONTEXT;
        }
        nextChar();
    }
    if (current == -1) {
        return EOF_CONTEXT;
    }
    return ELEMENT_CONTEXT;
}

---------------Library-------------------
method: org.eclipse.jface.databinding.viewers.ViewerProperties.multipleSelection()org.eclipse.jface.databinding.viewers.IViewerListProperty;0
public static IViewerListProperty multipleSelection() {
    return new  SelectionProviderMultipleSelectionProperty(false);
}
---------------Client-------------------
method: org.eclipse.compare.rangedifferencer.RangeDifferencer$1.createRangeDifference()org.eclipse.compare.rangedifferencer.RangeDifference;1
protected RangeDifference createRangeDifference() {
    return new  RangeDifference(RangeDifference.NOCHANGE);
}

---------------Library-------------------
method: org.eclipse.jface.internal.databinding.util.JFaceProperty.getBooleanGetterName(java.lang.String;)java.lang.String;1
private static String getBooleanGetterName(String fieldName) {
    return "is" + toMethodSuffix(fieldName);
}
---------------Client-------------------
method: org.eclipse.core.internal.net.ProxyType.getPreferenceNode()java.lang.String;1
private String getPreferenceNode() {
    return PREF_PROXY_DATA_NODE + IPath.SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyCatchesopt()V1
protected void consumeEmptyCatchesopt() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.osgi.container.ModuleWiring.invalidate()V1
void invalidate() {
    invalidate0(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.templates.osgi.HelloOSGiServiceNewWizard.getImportPackages()Ajava.lang.String;1
public String[] getImportPackages() {
    return new String[] { "org.osgi.framework;version=\"1.3.0\"", "org.osgi.util.tracker;version=\"1.3.1\"" };
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor$3.getShowInTargetIds()Ajava.lang.String;1
@Override
public String[] getShowInTargetIds() {
    return new String[] { JavaUI.ID_PACKAGES, IPageLayout.ID_PROJECT_EXPLORER };
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBackgroundHandler.applyCSSPropertyBackgroundPosition(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBackgroundPosition(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("background-position");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ecf.provider.filetransfer.retrieve.UrlConnectionRetrieveFileTransfer.setRangeHeader(java.lang.String;)V2
private void setRangeHeader(String value) {
    urlConnection.setRequestProperty("Range", value);
}
---------------Client-------------------
method: org.apache.batik.util.gui.DropDownComponent$ScrollablePopupMenu.addListener(org.apache.batik.util.gui.DropDownComponent$ScrollablePopupMenuListener;)V2
public void addListener(ScrollablePopupMenuListener listener) {
    eventListeners.add(ScrollablePopupMenuListener.class, listener);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSStyleSheetImpl.insertRule(java.lang.String;I)I3
@Override
public int insertRule(String arg0, int arg1) throws DOMException {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.search.FieldCacheImpl.getShorts(org.apache.lucene.index.IndexReader;java.lang.String;org.apache.lucene.search.FieldCache$ShortParser;)AS4
public short[] getShorts(IndexReader reader, String field, ShortParser parser) throws IOException {
    return getShorts(reader, field, parser, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.createImport(java.lang.String;org.eclipse.jdt.core.IJavaElement;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IImportDeclaration;4
public IImportDeclaration createImport(String importName, IJavaElement sibling, IProgressMonitor monitor) throws JavaModelException {
    return createImport(importName, sibling, Flags.AccDefault, monitor);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.generatedfile.GeneratedFileManager.addGeneratedFileDependency(java.util.Collection;org.eclipse.core.resources.IFile;)V3
public void addGeneratedFileDependency(Collection<IFile> parentFiles, IFile generatedFile) {
    addBuiltFileToMaps(parentFiles, generatedFile, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.create(org.eclipse.core.resources.IProjectDescription;org.eclipse.core.runtime.IProgressMonitor;)V3
public void create(IProjectDescription description, IProgressMonitor monitor) throws CoreException {
    create(description, IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.ui.internal.forms.widgets.SelectionData.markNewLine()V1
public void markNewLine() {
    newLineNeeded = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyAnnotationTypeMemberDeclarationsopt()V1
protected void consumeEmptyAnnotationTypeMemberDeclarationsopt() {
    pushOnAstLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.apache.batik.css.engine.sac.CSSConditionFactory.createOnlyChildCondition()org.w3c.css.sac.Condition;1
public Condition createOnlyChildCondition() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader.read(java.util.zip.ZipFile;java.lang.String;)org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;2
public static ClassFileReader read(java.util.zip.ZipFile zip, String filename) throws ClassFormatException, java.io.IOException {
    return read(zip, filename, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.debug.ui.CommonTab$FavoritesLabelProvider.isLabelProperty(java.lang.Object;java.lang.String;)Z3
@Override
public boolean isLabelProperty(Object element, String property) {
    return false;
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.artifact.repository.simple.SimpleArtifactRepository.initializeAfterLoad(java.net.URI;)V2
public synchronized void initializeAfterLoad(URI repoLocation) {
    this.initializeAfterLoad(repoLocation, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding.setTypeAnnotations(Aorg.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;Z)V3
public void setTypeAnnotations(AnnotationBinding[] annotations, boolean evalNullAnnotations) {
    super.setTypeAnnotations(annotations, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.jarprocessor.Utils$1.accept(java.io.File;)Z2
public boolean accept(File pathname) {
    return pathname.isFile() && pathname.getName().endsWith(".jar");
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.SimpleProfileRegistry$2.accept(java.io.File;)Z2
public boolean accept(File pathname) {
    return pathname.getName().endsWith(PROFILE_EXT) && pathname.isDirectory();
}

---------------Library-------------------
method: org.eclipse.ui.navigator.CommonViewer.toString()java.lang.String;1
public String toString() {
    return contentService.toString() + " Viewer";
}
---------------Client-------------------
method: org.eclipse.ui.internal.navigator.NavigatorActivationService.getPreferenceKey()java.lang.String;1
private String getPreferenceKey() {
    return contentService.getViewerId() + ACTIVATED_EXTENSIONS;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyTextHandler.applyCSSPropertyColor(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyColor(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("color");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceType.getKey()java.lang.String;1
public String getKey() {
    try {
        return getKey(this, false);
    } catch (JavaModelException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.contentassist.XMLContentAssistProcessor.assistSessionStarted(org.eclipse.jface.text.contentassist.ContentAssistEvent;)V2
public void assistSessionStarted(ContentAssistEvent event) {
    fAssistSessionStarted = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.team.ui.synchronize.SubscriberTeamStateProvider.getResourceMappingContext(java.lang.Object;)org.eclipse.core.resources.mapping.ResourceMappingContext;2
public ResourceMappingContext getResourceMappingContext(Object element) {
    return new  SubscriberResourceMappingContext(subscriber, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.FailureTableDisplay.newTableItem()org.eclipse.swt.widgets.TableItem;1
TableItem newTableItem() {
    return new  TableItem(fTable, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jface.text.AbstractInformationControlManager$MyInternalAccessor.setHoverEnrichMode(org.eclipse.jface.text.ITextViewerExtension8$EnrichMode;)V2
public void setHoverEnrichMode(EnrichMode mode) {
    throw new  UnsupportedOperationException("only implemented in AbstractHoverInformationControlManager");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.CreateLinkedResourceGroup.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Composite;2
public Composite createContents(Composite parent) {
    return createContents(parent, true);
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.getContents(org.eclipse.swt.dnd.Transfer;)java.lang.Object;2
public Object getContents(Transfer transfer) {
    return getContents(transfer, DND.CLIPBOARD);
}

---------------Library-------------------
method: org.apache.lucene.analysis.StopFilter.makeStopSet(org.apache.lucene.util.Version;java.util.List;)java.util.Set;2
public static final Set<Object> makeStopSet(Version matchVersion, List<?> stopWords) {
    return makeStopSet(matchVersion, stopWords, false);
}
---------------Client-------------------
method: org.eclipse.jface.action.StatusLineManager.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control createControl(Composite parent) {
    return createControl(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.WorkingSetManagerData.addWorkingSet()V1
public void addWorkingSet() throws IOException {
    if (name != null && name.length() > 0) {
        String[] hrefs = request.getParameterValues("hrefs");
        if (hrefs == null)
            hrefs = new String[0];
        ArrayList selectedElements = new  ArrayList(hrefs.length);
        for (int i = 0; i < hrefs.length; i++) {
            AdaptableHelpResource res = getAdaptableHelpResource(hrefs[i]);
            if (res != null)
                selectedElements.add(res);
        }
        AdaptableHelpResource[] elements = new AdaptableHelpResource[selectedElements.size()];
        selectedElements.toArray(elements);
        WorkingSet ws = null;
        if (!isCriteriaScopeEnabled()) {
            ws = wsmgr.createWorkingSet(name, elements);
        } else {
            CriterionResource[] criteria = getCriteriaResource();
            ws = wsmgr.createWorkingSet(name, elements, criteria);
        }
        wsmgr.addWorkingSet(ws);
    }
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jface.action.ContributionManager.appendToGroup(java.lang.String;org.eclipse.jface.action.IContributionItem;)V3
@Override
public void appendToGroup(String groupName, IContributionItem item) {
    addToGroup(groupName, item, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.genericInferenceError(java.lang.String;org.eclipse.jdt.internal.compiler.lookup.InvocationSite;)V3
public void genericInferenceError(String message, InvocationSite invocationSite) {
    genericInferenceProblem(message, invocationSite, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.actions.CopyAction.undo(java.util.Map;)org.eclipse.core.runtime.IStatus;2
public IStatus undo(Map<String, Object> parameters) {
    return CleanupcopyAction.cleanupcopy(parameters, false);
}
---------------Client-------------------
method: org.eclipse.ui.trace.internal.providers.TracingComponentLabelProvider.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(final Object element) {
    return TracingComponentLabelProvider.getLabel(TracingConstants.LABEL_COLUMN_INDEX, element);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicInternalEList$Unsettable.didChange()V1
@Override
protected void didChange() {
    isSet = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jface.viewers.OwnerDrawLabelProvider.initialize(org.eclipse.jface.viewers.ColumnViewer;org.eclipse.jface.viewers.ViewerColumn;)V3
@Override
protected void initialize(ColumnViewer viewer, ViewerColumn column) {
    this.initialize(viewer, column, true);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.genericInferenceError(java.lang.String;org.eclipse.jdt.internal.compiler.lookup.InvocationSite;)V3
public void genericInferenceError(String message, InvocationSite invocationSite) {
    genericInferenceProblem(message, invocationSite, ProblemSeverities.Error);
}

---------------Library-------------------
method: org.eclipse.jface.text.contentassist.PopupCloser.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    fScrollbarClicked = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl.createRootNodeSelector()org.w3c.css.sac.SimpleSelector;1
@Override
public SimpleSelector createRootNodeSelector() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.batik.css.parser.DefaultSelectorFactory.createAnyNodeSelector()org.w3c.css.sac.SimpleSelector;1
public SimpleSelector createAnyNodeSelector() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.ui.editor.contentassist.DSContentAssistProcessor.assistSessionStarted(org.eclipse.jface.text.contentassist.ContentAssistEvent;)V2
public void assistSessionStarted(ContentAssistEvent event) {
    fAssistSessionStarted = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicExtendedMetaData$EClassExtendedMetaDataImpl.setEnumerationFacet(java.util.List;)V2
public void setEnumerationFacet(List<String> literals) {
    throw new  UnsupportedOperationException("Can't set the enumeration of an EClass");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.propertypages.ThreadFilterEditor.getDebugTargets()Aorg.eclipse.debug.core.model.IDebugTarget;1
protected IDebugTarget[] getDebugTargets() {
    Object input = fThreadViewer.getInput();
    if (!(input instanceof ILaunchManager)) {
        return new IJavaDebugTarget[0];
    }
    ILaunchManager launchManager = (ILaunchManager) input;
    return launchManager.getDebugTargets();
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.getVersion()J1
public long getVersion() {
    throw new  UnsupportedOperationException("This reader does not support this method.");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicExtendedMetaData$EClassExtendedMetaDataImpl.setPatternFacet(java.util.List;)V2
public void setPatternFacet(List<String> pattern) {
    throw new  UnsupportedOperationException("Can't set the pattern of an EClass");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.TeamSynchronizingPerspective.defineActions(org.eclipse.ui.IPageLayout;)V2
public void defineActions(IPageLayout layout) {
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.project");
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
    layout.addShowViewShortcut(ISynchronizeView.VIEW_ID);
    layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
    layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
    layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
    layout.addActionSet("org.eclipse.team.ui.actionSet");
    layout.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective");
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.application.ResourcePerspective.defineActions(org.eclipse.ui.IPageLayout;)V2
public void defineActions(IPageLayout layout) {
    layout.addNewWizardShortcut(BasicNewFolderResourceWizard.WIZARD_ID);
    layout.addNewWizardShortcut(BasicNewFileResourceWizard.WIZARD_ID);
    layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    layout.addShowViewShortcut(IPageLayout.ID_BOOKMARKS);
    layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
    layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
    layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
    layout.addShowViewShortcut(IPageLayout.ID_PROGRESS_VIEW);
    layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
    layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
}

---------------Library-------------------
method: org.eclipse.ui.internal.texteditor.LineNumberColumn.isShowingRevisionInformation()Z1
public boolean isShowingRevisionInformation() {
    if (fDelegate instanceof LineNumberChangeRulerColumn)
        return ((LineNumberChangeRulerColumn) fDelegate).isShowingRevisionInformation();
    return false;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.rows.ExtensionAttributeRow.getUse()I1
protected int getUse() {
    if (att instanceof ISchemaAttribute)
        return ((ISchemaAttribute) att).getUse();
    return ISchemaAttribute.OPTIONAL;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.SaveManager.requestSnapshot()V1
public void requestSnapshot() {
    snapshotRequested = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository.removeAll()V1
@Override
public synchronized void removeAll() {
    throw new  UnsupportedOperationException("Cannot remove IUs from a composite repository");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.FinishResult.isInterrupted()Z1
public boolean isInterrupted() {
    return fValue == 1;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.StatusInfo.isInfo()Z1
public boolean isInfo() {
    return fSeverity == IStatus.INFO;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.ESuperAdapter.isModified()Z1
public boolean isModified() {
    return modifiedState != 0;
}
---------------Client-------------------
method: org.eclipse.jetty.http.AbstractGenerator.isCommitted()Z1
public boolean isCommitted() {
    return _state != STATE_HEADER;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCSConditionalSubItem.addSubItem(org.eclipse.pde.internal.ua.core.cheatsheet.simple.ISimpleCSSubItem;)V2
public void addSubItem(ISimpleCSSubItem subitem) {
    addChildNode((IDocumentElementNode) subitem, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.ui.internal.dnd.SwtUtil.getAncestors(org.eclipse.swt.widgets.Control;)Aorg.eclipse.swt.widgets.Control;1
public static Control[] getAncestors(Control theControl) {
    return getAncestors(theControl, 1);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.jface.internal.text.SelectionProcessor$Implementation.makeReplaceSelection(org.eclipse.jface.viewers.ISelection;java.lang.String;)org.eclipse.jface.viewers.ISelection;3
ISelection makeReplaceSelection(ISelection selection, String replacement) throws BadLocationException {
    return makeEmpty(selection, false);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.viewers.IUDetailsLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object obj) {
    return getColumnText(obj, PRIMARY_COLUMN);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xml.namespace.impl.XMLNamespaceFactoryImpl.init()org.eclipse.emf.ecore.xml.namespace.XMLNamespaceFactory;0
public static XMLNamespaceFactory init() {
    try {
        XMLNamespaceFactory theXMLNamespaceFactory = (XMLNamespaceFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.w3.org/XML/1998/namespace");
        if (theXMLNamespaceFactory != null) {
            return theXMLNamespaceFactory;
        }
    } catch (Exception exception) {
        EcorePlugin.INSTANCE.log(exception);
    }
    return new  XMLNamespaceFactoryImpl();
}
---------------Client-------------------
method: org.eclipse.e4.ui.model.application.commands.impl.CommandsFactoryImpl.init()org.eclipse.e4.ui.model.application.commands.impl.CommandsFactoryImpl;0
public static CommandsFactoryImpl init() {
    try {
        CommandsFactoryImpl theCommandsFactory = (CommandsFactoryImpl) EPackage.Registry.INSTANCE.getEFactory(CommandsPackageImpl.eNS_URI);
        if (theCommandsFactory != null) {
            return theCommandsFactory;
        }
    } catch (Exception exception) {
        EcorePlugin.INSTANCE.log(exception);
    }
    return new  CommandsFactoryImpl();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCSItem.addSubItem(org.eclipse.pde.internal.ua.core.cheatsheet.simple.ISimpleCSSubItemObject;)V2
public void addSubItem(ISimpleCSSubItemObject subitem) {
    addChildNode((IDocumentElementNode) subitem, true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.ui.wizards.datatransfer.PopulateRootOperation.createElement(org.eclipse.ui.dialogs.FileSystemElement;java.lang.Object;)org.eclipse.ui.dialogs.FileSystemElement;3
protected FileSystemElement createElement(FileSystemElement parent, Object fileSystemObject) throws InterruptedException {
    return createElement(parent, fileSystemObject, 2);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.Disassembler.disassemble(org.eclipse.jdt.core.util.IClassFileReader;java.lang.String;)java.lang.String;3
public String disassemble(IClassFileReader classFileReader, String lineSeparator) {
    return disassemble(classFileReader, lineSeparator, ClassFileBytesDisassembler.DEFAULT);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.simple.text.SimpleCSItem.getSkip()Z1
public boolean getSkip() {
    return getBooleanAttributeValue(ATTRIBUTE_SKIP, false);
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.MarkerUtilities.getSeverity(org.eclipse.core.resources.IMarker;)I1
public static int getSeverity(IMarker marker) {
    return getIntAttribute(marker, IMarker.SEVERITY, IMarker.SEVERITY_INFO);
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.FiltersConfigurationDialog$15.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    andFilters = false;
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.PopupDialog$MoveAction.run()V1
@Override
public void run() {
    performTrackerAction(SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.FindReplaceAction$FindReplaceDialogStub.partActivated(org.eclipse.ui.IWorkbenchPartReference;)V2
public void partActivated(IWorkbenchPartReference partRef) {
    partActivated(partRef.getPart(true));
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.mapping.ResourceChangeDescriptionFactory.create(org.eclipse.core.resources.IResource;)V2
public void create(IResource resource) {
    getDelta(resource).setKind(IResourceDelta.ADDED);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.rename.RenameTypeParameterProcessor$RenameTypeParameterVisitor.getResult()org.eclipse.ltk.core.refactoring.Change;1
public Change getResult() throws CoreException {
    return fRewrite.createChange(true);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathPage.getAdditionalEntries()Aorg.eclipse.ant.core.IAntClasspathEntry;1
protected IAntClasspathEntry[] getAdditionalEntries() {
    return fModel.getEntries(ClasspathModel.GLOBAL_USER);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.MatchLocations$MatchLocationSelectionDialog$2.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    performSelectAction(false);
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.ui.FileSelectionDialog$4.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
@Override
public void doubleClick(DoubleClickEvent event) {
    buttonPressed(IDialogConstants.OK_ID);
}

---------------Library-------------------
method: org.apache.batik.css.parser.DefaultElementSelector.toString()java.lang.String;1
public String toString() {
    String name = getLocalName();
    if (name == null) {
        return "*";
    }
    return name;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.build.BuildEditor.computeInitialPageId()java.lang.String;1
@Override
protected String computeInitialPageId() {
    String firstPageId = super.computeInitialPageId();
    if (firstPageId == null) {
        return BuildPage.PAGE_ID;
    }
    return firstPageId;
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.FiltersConfigurationDialog$8.expansionStateChanged(org.eclipse.ui.forms.events.ExpansionEvent;)V2
public void expansionStateChanged(ExpansionEvent e) {
    form.reflow(true);
}
---------------Client-------------------
method: org.eclipse.jface.text.link.LinkedModeUI$Closer.inputDocumentAboutToBeChanged(org.eclipse.jface.text.IDocument;org.eclipse.jface.text.IDocument;)V3
public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
    leave(ILinkedModeListener.EXIT_ALL);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.VMListener.vmChanged(org.eclipse.jdt.launching.PropertyChangeEvent;)V2
public void vmChanged(PropertyChangeEvent event) {
    fChanged = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.compare.internal.Worker$WorkProgressMonitor.cancelTask()V1
public void cancelTask() {
    localCancel = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.SemanticHighlighting.getThemeColorKey()java.lang.String;1
private String getThemeColorKey() {
    return JavaUI.ID_PLUGIN + "." + getPreferenceKey() + "Highlighting";
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.SemanticHighlightings.getBoldPreferenceKey(org.eclipse.jdt.internal.ui.javaeditor.SemanticHighlighting;)java.lang.String;1
public static String getBoldPreferenceKey(SemanticHighlighting semanticHighlighting) {
    return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX + semanticHighlighting.getPreferenceKey() + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_BOLD_SUFFIX;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaTextBufferNode.getContents()java.io.InputStream;1
public InputStream getContents() {
    return new  ByteArrayInputStream(JavaCompareUtilities.getBytes(fDocument.get(), "UTF-16"));
}
---------------Client-------------------
method: org.eclipse.compare.internal.EditionAction$DocumentBufferNode.getContents()java.io.InputStream;1
public InputStream getContents() {
    return new  ByteArrayInputStream(Utilities.getBytes(fDocument.get(), UTF_16));
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.LabeledStatement.memSize()I1
int memSize() {
    return super.memSize() + 2 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyArrayInitializeropt()V1
protected void consumeEmptyArrayInitializeropt() {
    pushOnExpressionStackLengthStack(0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.close()V1
public final synchronized void close() throws IOException {
    if (!closed) {
        decRef();
        closed = true;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.feature.FeatureSpecSection.setIfDefined(org.eclipse.pde.internal.ui.parts.FormEntry;java.lang.String;)V3
private void setIfDefined(FormEntry formText, String value) {
    if (value != null) {
        formText.setValue(value, true);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.warning(org.xml.sax.SAXParseException;)V2
public void warning(SAXParseException exception) throws SAXException {
    addMarker(exception, IMarker.SEVERITY_WARNING);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.NullAnnotationMatching.isAnyMismatch()Z1
public boolean isAnyMismatch() {
    return this.severity != 0;
}
---------------Client-------------------
method: org.eclipse.jetty.http.AbstractGenerator.isCommitted()Z1
public boolean isCommitted() {
    return _state != STATE_HEADER;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.NaiveASTFlattener.visit(org.eclipse.jdt.core.dom.CharacterLiteral;)Z2
public boolean visit(CharacterLiteral node) {
    this.buffer.append(node.getEscapedValue());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryMember.getKey()java.lang.String;1
public String getKey() {
    try {
        return getKey(false);
    } catch (JavaModelException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextArrayDimension()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextArrayDimension() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_ARRAY_DIMENSION);
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.validation.ValidatedObservableSet.makeStale()V1
private void makeStale() {
    if (!stale) {
        stale = true;
        fireStale();
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberDiffTreeEventHandler.start()V1
public synchronized void start() {
    super.start();
    if (state == STATE_NEW)
        state = STATE_STARTED;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.FindReplaceDialog.statusMessage(java.lang.String;)V2
private void statusMessage(String message) {
    statusMessage(false, message);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.open(org.eclipse.core.runtime.IProgressMonitor;)V2
public void open(IProgressMonitor monitor) throws CoreException {
    open(IResource.NONE, monitor);
}

---------------Library-------------------
method: org.eclipse.ui.menus.MenuUtil.toolbarAddition(java.lang.String;)java.lang.String;1
public static String toolbarAddition(String id) {
    return toolbarAddition(id, "after", "additions");
}
---------------Client-------------------
method: org.eclipse.jdt.core.JavaConventions.validateClassFileName(java.lang.String;)org.eclipse.core.runtime.IStatus;1
public static IStatus validateClassFileName(String name) {
    return validateClassFileName(name, CompilerOptions.VERSION_1_3, CompilerOptions.VERSION_1_3);
}

---------------Library-------------------
method: org.eclipse.core.internal.events.AutoBuildJob.avoidBuild()V1
synchronized void avoidBuild() {
    avoidBuild = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyBackgroundHandler.applyCSSPropertyBackgroundRepeat(java.lang.Object;org.w3c.dom.css.CSSValue;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)V5
@Override
public void applyCSSPropertyBackgroundRepeat(Object element, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
    throw new  UnsupportedPropertyException("background-repeat");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl.createNegativeSelector(org.w3c.css.sac.SimpleSelector;)org.w3c.css.sac.NegativeSelector;2
@Override
public NegativeSelector createNegativeSelector(SimpleSelector selector) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.RuntimeClasspathProvider.getIdentifier()java.lang.String;1
public String getIdentifier() {
    return fConfigurationElement.getAttribute("id");
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareFilterDescriptor.getDefinitionId()java.lang.String;1
public String getDefinitionId() {
    return fConfiguration.getAttribute(DEFINITION_ID_ATTRIBUTE);
}

---------------Library-------------------
method: org.apache.batik.css.parser.DefaultSelectorFactory.createRootNodeSelector()org.w3c.css.sac.SimpleSelector;1
public SimpleSelector createRootNodeSelector() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.apache.lucene.util.BytesRef.startsWith(org.apache.lucene.util.BytesRef;)Z2
public boolean startsWith(BytesRef other) {
    return sliceEquals(other, 0);
}
---------------Client-------------------
method: org.eclipse.team.core.variants.SessionResourceVariantByteStore.deleteBytes(org.eclipse.core.resources.IResource;)Z2
public boolean deleteBytes(IResource resource) throws TeamException {
    return flushBytes(resource, IResource.DEPTH_ZERO);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.WhileStatement.memSize()I1
int memSize() {
    return super.memSize() + 2 * 4;
}
---------------Client-------------------
method: org.apache.lucene.index.TermVectorsTermsWriterPerField$TermVectorsPostingsArray.bytesPerPosting()I1
@Override
int bytesPerPosting() {
    return super.bytesPerPosting() + 3 * RamUsageEstimator.NUM_BYTES_INT;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository.removeInstallableUnits(java.util.Collection;)Z2
@Override
public boolean removeInstallableUnits(Collection<IInstallableUnit> installableUnits) {
    throw new  UnsupportedOperationException("Cannot remove IUs from a composite repository");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.util.EscapeUtils.escapeSpecialCharsLeavinggBold(java.lang.String;)java.lang.String;1
public static String escapeSpecialCharsLeavinggBold(String value) {
    return escapeSpecialChars(value, true);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.IconAndMessageDialog.getErrorImage()org.eclipse.swt.graphics.Image;1
public Image getErrorImage() {
    return getSWTImage(SWT.ICON_ERROR);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.TypeReference.getAnnotationsOnDimensions()AAorg.eclipse.jdt.internal.compiler.ast.Annotation;1
public Annotation[][] getAnnotationsOnDimensions() {
    return getAnnotationsOnDimensions(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker.toNextArrayDimension()org.eclipse.jdt.internal.compiler.classfmt.TypeAnnotationWalker;1
public TypeAnnotationWalker toNextArrayDimension() {
    return toNextDetail(AnnotationTargetTypeConstants.NEXT_ARRAY_DIMENSION);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.CreateLinkedResourceGroup.createTextOnlyContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Composite;2
public Composite createTextOnlyContents(Composite parent) {
    return createContents(parent, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EObjectEList$Unsettable.didChange()V1
@Override
protected void didChange() {
    isSet = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.category.CategoryEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EcoreEMap$Unsettable$UnsettableDelegateEObjectContainmentWithInverseEList.didChange()V1
@Override
protected void didChange() {
    isSet = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.util.QualifiedTypeNameHistory.getDefault()org.eclipse.jdt.internal.corext.util.QualifiedTypeNameHistory;0
public static QualifiedTypeNameHistory getDefault() {
    if (fgInstance == null)
        fgInstance = new  QualifiedTypeNameHistory("QualifiedTypeNameHistory.xml");
    return fgInstance;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.PDECore.getPreferencesManager()org.eclipse.pde.internal.core.PDEPreferencesManager;1
public synchronized PDEPreferencesManager getPreferencesManager() {
    if (fPreferenceManager == null) {
        fPreferenceManager = new  PDEPreferencesManager(PLUGIN_ID);
    }
    return fPreferenceManager;
}

---------------Library-------------------
method: org.eclipse.jface.internal.databinding.viewers.ObservableCollectionTreeContentProvider.getOrCreateNode(java.lang.Object;)org.eclipse.jface.internal.databinding.viewers.ObservableCollectionTreeContentProvider$TreeNode;2
protected TreeNode getOrCreateNode(Object element) {
    return getOrCreateNode(element, false);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSPageRuleImpl.getStyle()org.w3c.dom.css.CSSStyleDeclaration;1
@Override
public CSSStyleDeclaration getStyle() {
    throw new  UnsupportedOperationException("NOT YET IMPLEMENTED");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.site.SiteEditor.contextRemoved(org.eclipse.pde.internal.ui.editor.context.InputContext;)V2
public void contextRemoved(InputContext context) {
    close(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.EditorUtility.throwPartInitException(java.lang.String;)V1
private static void throwPartInitException(String message) throws PartInitException {
    throwPartInitException(message, IStatus.OK);
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Observables.proxyObservableSet(org.eclipse.core.databinding.observable.set.IObservableSet;)org.eclipse.core.databinding.observable.set.IObservableSet;1
public static IObservableSet proxyObservableSet(IObservableSet target) {
    return new  DecoratingObservableSet(target, false);
}
---------------Client-------------------
method: org.eclipse.jface.window.Window.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createContents(Composite parent) {
    return new  Composite(parent, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.APTDispatchRunnable.build()V1
private void build() {
    if (!shouldBuild()) {
        if (AptPlugin.DEBUG) {
            String msg;
            if ((_factories == null || _factories.size() == 0) && _dispatchedBatchFactories.isEmpty())
                msg = "no AnnotationProcessoryFactory instances registered.";
            else
                msg = "no files to dispatch to.";
            trace("run():  leaving project " + _aptProject.getJavaProject().getProject() + " early because there are " + msg, null);
        }
        cleanupAllGeneratedFiles();
    } else {
        assert _filesWithAnnotation != null : "should never be invoked unless we are in build mode!";
        EnvCallback buildCallback = new  EnvCallback() {

            public void run(AbstractCompilationEnv env) {
                build((BuildEnv) env);
            }
        };
        boolean split = false;
        if (SPLIT_FILES && !hasBatchFactory()) {
            split = _filesWithAnnotation.length > MAX_FILES_PER_ITERATION ? true : false;
        }
        if (!split) {
            BuildEnv.newBuildEnv(_filesWithAnnotation, _filesWithoutAnnotation, _aptProject.getJavaProject(), buildCallback);
        } else {
            for (int index = 0; index < _filesWithAnnotation.length; ) {
                int numberToProcess = (index + MAX_FILES_PER_ITERATION) > _filesWithAnnotation.length ? _filesWithAnnotation.length - index : MAX_FILES_PER_ITERATION;
                BuildContext[] filesToProcess = new BuildContext[numberToProcess];
                System.arraycopy(_filesWithAnnotation, index, filesToProcess, 0, numberToProcess);
                BuildEnv.newBuildEnv(filesToProcess, _filesWithoutAnnotation, _aptProject.getJavaProject(), buildCallback);
                index += numberToProcess;
            }
        }
    }
    _aptProject.getGeneratedFileManager().writeState();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.apache.lucene.analysis.tokenattributes.CharTermAttributeImpl.term()java.lang.String;1
@Deprecated
public String term() {
    return new  String(termBuffer, 0, termLength);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.AnnotationExpandHover$InformationControlCreator.createInformationControl(org.eclipse.swt.widgets.Shell;)org.eclipse.jface.text.IInformationControl;2
public IInformationControl createInformationControl(Shell parent) {
    return new  AnnotationExpansionControl(parent, SWT.NONE, fAnnotationAccess);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.clone()java.lang.Object;1
@Override
public synchronized Object clone() {
    throw new  UnsupportedOperationException("This reader does not implement clone()");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.FeatureModelManager.getDeltaPackFeature()org.eclipse.pde.internal.core.ifeature.IFeatureModel;1
public IFeatureModel getDeltaPackFeature() {
    IFeatureModel model = findFeatureModel("org.eclipse.equinox.executable");
    if (model == null)
        model = findFeatureModel("org.eclipse.platform.launchers");
    return model;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.nls.InternationalizeWizard.getSettingsSection(org.eclipse.jface.dialogs.IDialogSettings;)org.eclipse.jface.dialogs.IDialogSettings;2
private IDialogSettings getSettingsSection(IDialogSettings master) {
    IDialogSettings setting = master.getSection(STORE_SECTION);
    if (setting == null) {
        setting = master.addNewSection(STORE_SECTION);
    }
    return setting;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.sac.CSSConditionFactoryImpl.createPositionalCondition(IZZ)org.w3c.css.sac.PositionalCondition;4
@Override
public PositionalCondition createPositionalCondition(int position, boolean typeNode, boolean type) throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.help.internal.webapp.data.SearchData.getPreProcessorResults()java.lang.String;1
public String getPreProcessorResults() {
    if (altList == null || altList.isEmpty())
        return "";
    StringBuffer result = new  StringBuffer();
    result.append(ServletResources.getString("AlternateSearchQueries", request));
    result.append("<ul>");
    for (int a = 0; a < altList.size(); a++) result.append("<li>" + (String) altList.get(a) + "</li>");
    result.append("</ul>");
    return result.toString();
}
---------------Client-------------------
method: org.apache.commons.logging.impl.AvalonLogger.debug(java.lang.Object;)V2
public void debug(Object message) {
    if (getLogger().isDebugEnabled())
        getLogger().debug(String.valueOf(message));
}

---------------Library-------------------
method: org.eclipse.jdt.core.search.SearchDocument.requireIndexingResolvedDocument()V1
public void requireIndexingResolvedDocument() {
    this.shouldIndexResolvedDocument = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

---------------Library-------------------
method: org.apache.batik.css.parser.DefaultConditionFactory.createOnlyChildCondition()org.w3c.css.sac.Condition;1
public Condition createOnlyChildCondition() throws CSSException {
    throw new  CSSException("Not implemented in CSS2");
}
---------------Client-------------------
method: org.apache.batik.util.gui.xmleditor.XMLScanner.scan(I)I2
public int scan(int context) {
    nextChar();
    switch(context) {
        case XML_DECLARATION_CONTEXT:
            scanValue = scanXMLDeclaration();
            break;
        case DOCTYPE_CONTEXT:
            scanValue = scanDOCTYPE();
            break;
        case COMMENT_CONTEXT:
            scanValue = scanComment();
            break;
        case ELEMENT_CONTEXT:
            scanValue = scanElement();
            break;
        case ATTRIBUTE_NAME_CONTEXT:
            scanValue = scanAttributeName();
            break;
        case ATTRIBUTE_VALUE_CONTEXT:
            scanValue = scanAttributeValue();
            break;
        case CDATA_CONTEXT:
            scanValue = scanCDATA();
            break;
        default:
            scanValue = scanCharacterData();
            break;
    }
    return position;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.NaiveASTFlattener.visit(org.eclipse.jdt.core.dom.NumberLiteral;)Z2
public boolean visit(NumberLiteral node) {
    this.buffer.append(node.getToken());
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$1.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry fileEntry) {
    allFiles.add(fileEntry.getPath());
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.jface.internal.text.link.contentassist.ContentAssistant2.showContextInformation()java.lang.String;1
public String showContextInformation() {
    return fContextInfoPopup.showContextProposals(false);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathPage.getAntHomeEntries()Aorg.eclipse.ant.core.IAntClasspathEntry;1
protected IAntClasspathEntry[] getAntHomeEntries() {
    return fModel.getEntries(ClasspathModel.ANT_HOME);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.ignoreNextClosingBrace()V1
@Override
protected void ignoreNextClosingBrace() {
    this.ignoreNextClosingBrace = true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.ProfileModificationAction.runCanceled()V1
protected void runCanceled() {
    result = Window.CANCEL;
}

