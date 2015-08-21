/**
* Description:
* An object invokes a method, then passes the result as a parameter for a method.
* The receiver can also invoke this method. Remove the parameter and let the 
* receiver invoke the method.
*
* Most of the results do not match the description. For those that match, the 
* target doesn't suggest how to do it. And usually the parameter can't be removed,
* because it needs parameterization. 
*/

---------------Library-------------------
method: org.eclipse.compare.internal.patch.Utilities.getProject(org.eclipse.compare.internal.core.patch.DiffProject;)org.eclipse.core.resources.IProject;1
public static IProject getProject(DiffProject diffProject) {
    return ResourcesPlugin.getWorkspace().getRoot().getProject(diffProject.getName());
}
method: org.eclipse.compare.internal.core.patch.DiffProject.getName()java.lang.String;1
public String getName() {
    return this.project;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
//false positive. The callee should at least takes one parameter for this refactoring.

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSRefactoring.getPropertyFileHandle()org.eclipse.core.resources.IFile;1
public IFile getPropertyFileHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getFile(getPropertyFilePath());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
//false positive. The callee should at least takes one parameter for this refactoring.

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.SingleFolderTagSource.getLocation()org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;1
public ICVSRepositoryLocation getLocation() {
    RepositoryManager mgr = CVSUIPlugin.getPlugin().getRepositoryManager();
    ICVSRepositoryLocation location = mgr.getRepositoryLocationFor(getFolder());
    return location;
}
method: org.eclipse.team.internal.ccvs.ui.tags.SingleFolderTagSource.getFolder()org.eclipse.team.internal.ccvs.core.ICVSFolder;1
public ICVSFolder getFolder() {
    return folder;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
//false positive. The callee should at least takes one parameter for this refactoring.
---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.ViewerUpdateMonitor.getUpdateSchedulingRule()org.eclipse.core.runtime.jobs.ISchedulingRule;1
protected ISchedulingRule getUpdateSchedulingRule() {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(getContentProvider());
}
method: org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory.newSerialPerObjectRule(java.lang.Object;)org.eclipse.core.runtime.jobs.ISchedulingRule;2
public ISchedulingRule newSerialPerObjectRule(Object lock) {    //newSerialPerObjectRule() {   
    return new  SerialPerObjectRule(lock);                      //return new SerialPerObjectRule(getContentProvider());}
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaModelOperation.newJavaElementDelta()org.eclipse.jdt.internal.core.JavaElementDelta;1
public JavaElementDelta newJavaElementDelta() {
    return new  JavaElementDelta(getJavaModel());
}
method: org.eclipse.jdt.internal.core.JavaModelOperation.getJavaModel()org.eclipse.jdt.core.IJavaModel;1
public IJavaModel getJavaModel() {
    return JavaModelManager.getJavaModelManager().getJavaModel();
}
//it's opportunity.
---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.ViewerUpdateMonitor.getUpdateSchedulingRule()org.eclipse.core.runtime.jobs.ISchedulingRule;1
protected ISchedulingRule getUpdateSchedulingRule() {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(getContentProvider());
}
method: org.eclipse.debug.internal.ui.viewers.model.ViewerUpdateMonitor.getContentProvider()org.eclipse.debug.internal.ui.viewers.model.TreeModelContentProvider;1
protected TreeModelContentProvider getContentProvider() {
    return fContentProvider;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}
// false positive.
---------------Library-------------------
method: org.eclipse.jdt.internal.junit.wizards.NewTestSuiteCreationWizard.initializeDefaultPageImageDescriptor()V1
@Override
protected void initializeDefaultPageImageDescriptor() {
    setDefaultPageImageDescriptor(JUnitPlugin.getImageDescriptor("wizban/newtest_wiz.png"));
}
method: org.eclipse.jface.wizard.Wizard.setDefaultPageImageDescriptor(org.eclipse.jface.resource.ImageDescriptor;)V2
public void setDefaultPageImageDescriptor(ImageDescriptor imageDescriptor) {
    defaultImageDescriptor = imageDescriptor;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Link$2.getDefaultAction(org.eclipse.swt.accessibility.AccessibleControlEvent;)V2
@Override
public void getDefaultAction(AccessibleControlEvent e) {
    e.result = SWT.getMessage("SWT_Press");
}
method: org.eclipse.swt.SWT.getMessage(java.lang.String;)java.lang.String;1
public static String getMessage(String key) {
    return Compatibility.getMessage(key);
}
//false positive. In this case, the callee takes one parameter, but this parameter can not be removed.
---------------Library-------------------
method: org.eclipse.jsch.internal.ui.JSchUIPlugin.getImageDescriptorFromExtension(org.eclipse.core.runtime.IExtension;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public static ImageDescriptor getImageDescriptorFromExtension(IExtension extension, String subdirectoryAndFilename) {
    URL fullPathString = FileLocator.find(Platform.getBundle(extension.getNamespaceIdentifier()), new  Path(subdirectoryAndFilename), null);
    return ImageDescriptor.createFromURL(fullPathString);
}
method: org.eclipse.core.runtime.FileLocator.find(org.osgi.framework.Bundle;org.eclipse.core.runtime.IPath;java.util.Map;)java.net.URL;3
public static URL find(Bundle bundle, IPath path, Map override) {
    return FindSupport.find(bundle, path, override);
}
---------------Client-------------------
method: org.eclipse.team.ui.TeamImages.getImageDescriptorFromExtension(org.eclipse.core.runtime.IExtension;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public static ImageDescriptor getImageDescriptorFromExtension(IExtension extension, String subdirectoryAndFilename) {
    return TeamUIPlugin.getImageDescriptorFromExtension(extension, subdirectoryAndFilename);
}
method: org.eclipse.team.internal.ui.TeamUIPlugin.getImageDescriptorFromExtension(org.eclipse.core.runtime.IExtension;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public static ImageDescriptor getImageDescriptorFromExtension(IExtension extension, String subdirectoryAndFilename) {
    URL fullPathString = FileLocator.find(Platform.getBundle(extension.getNamespaceIdentifier()), new  Path(subdirectoryAndFilename), null);
    return ImageDescriptor.createFromURL(fullPathString);
}
// false positive. The parameters of the callee can not be removed, because these parameters can not be retrieved
// by calling a method inside the callee.
---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setArch(java.lang.String;)V2
public void setArch(String arch) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fArch;
    this.fArch = arch;
    firePropertyChanged(P_ARCH, oldValue, arch);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}
// false positive. The parameters of the callee can not be removed, the method needs these 
// parameter for parameterization.
---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne$NameGroup.postSetFocus()V1
public void postSetFocus() {
    fNameField.postSetFocusOnDialogField(getShell().getDisplay());
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField.postSetFocusOnDialogField(org.eclipse.swt.widgets.Display;)V2
public void postSetFocusOnDialogField(Display display) {
    if (display != null) {
        display.asyncExec(new  Runnable() {

            public void run() {
                setFocus();
            }
        });
    }
}
---------------Client-------------------
method: org.eclipse.jface.viewers.TableViewerEditor.create(org.eclipse.jface.viewers.TableViewer;org.eclipse.jface.viewers.SWTFocusCellManager;org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;I)V4
public static void create(TableViewer viewer, SWTFocusCellManager focusCellManager, ColumnViewerEditorActivationStrategy editorActivationStrategy, int feature) {
    TableViewerEditor editor = new  TableViewerEditor(viewer, focusCellManager, editorActivationStrategy, feature);
    viewer.setColumnViewerEditor(editor);
    if (focusCellManager != null) {
        focusCellManager.init();
    }
}
method: org.eclipse.jface.viewers.SWTFocusCellManager.init()V1
void init() {
    this.cellHighlighter.init();
    this.navigationStrategy.init();
}
// it's opportunity. The callee in Library can remove the parameter by calling getShell().getDisplay() instead.
// However, this is not suggested by the Client.

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.JavaPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}
// false positive.
---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setOS(java.lang.String;)V2
public void setOS(String os) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fOs;
    this.fOs = os;
    firePropertyChanged(P_OS, oldValue, os);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.IntroduceIndirectionInputPage$2.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    getIntroduceIndirectionRefactoring().setEnableUpdateReferences(enableReferencesCheckBox.getSelection());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.IntroduceIndirectionRefactoring.setEnableUpdateReferences(Z)V2
public void setEnableUpdateReferences(boolean updateReferences) {
    fUpdateReferences = updateReferences;
}
---------------Client-------------------
method: org.eclipse.swt.custom.StyledText$12.getCharacterCount(org.eclipse.swt.accessibility.AccessibleTextEvent;)V2
@Override
public void getCharacterCount(AccessibleTextEvent e) {
    e.count = StyledText.this.getCharCount();
}
method: org.eclipse.swt.custom.StyledText.getCharCount()I1
public int getCharCount() {
    checkWidget();
    return content.getCharCount();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.PDEPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    ResourcesPlugin.getPlugin().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.ui.internal.console.ConsolePluginImages.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getImageDescriptor(String key) {
    return getImageRegistry().getDescriptor(key);
}
method: org.eclipse.jface.resource.ImageRegistry.getDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public ImageDescriptor getDescriptor(String key) {
    Entry entry = getEntry(key);
    if (entry == null) {
        return null;
    }
    return entry.descriptor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActivePage()org.eclipse.ui.IWorkbenchPage;0
public static IWorkbenchPage getActivePage() {
    return getDefault().internalGetActivePage();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.internalGetActivePage()org.eclipse.ui.IWorkbenchPage;1
private IWorkbenchPage internalGetActivePage() {
    IWorkbenchWindow window = getWorkbench().getActiveWorkbenchWindow();
    if (window == null)
        return null;
    return window.getActivePage();
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSUIPlugin.getActivePage()org.eclipse.ui.IWorkbenchPage;0
public static IWorkbenchPage getActivePage() {
    return TeamUIPlugin.getActivePage();
}
method: org.eclipse.team.internal.ui.TeamUIPlugin.getActivePage()org.eclipse.ui.IWorkbenchPage;0
public static IWorkbenchPage getActivePage() {
    IWorkbenchWindow window = getPlugin().getWorkbench().getActiveWorkbenchWindow();
    if (window == null)
        return null;
    return window.getActivePage();
}

---------------Library-------------------
method: org.eclipse.ui.activities.WorkbenchActivityHelper.getIdentifier(org.eclipse.ui.IPluginContribution;)org.eclipse.ui.activities.IIdentifier;1
public static IIdentifier getIdentifier(IPluginContribution contribution) {
    IWorkbenchActivitySupport workbenchActivitySupport = PlatformUI.getWorkbench().getActivitySupport();
    IIdentifier identifier = workbenchActivitySupport.getActivityManager().getIdentifier(createUnifiedId(contribution));
    return identifier;
}
method: org.eclipse.ui.internal.activities.ws.WorkbenchActivitySupport.getActivityManager()org.eclipse.ui.activities.IActivityManager;1
@Override
public IActivityManager getActivityManager() {
    return proxyActivityManager;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.correction.CorrectionCommandHandler.getDocument()org.eclipse.jface.text.IDocument;1
private IDocument getDocument() {
    return JavaUI.getDocumentProvider().getDocument(fEditor.getEditorInput());
}
method: org.eclipse.jdt.ui.JavaUI.getDocumentProvider()org.eclipse.ui.texteditor.IDocumentProvider;0
public static IDocumentProvider getDocumentProvider() {
    return JavaPlugin.getDefault().getCompilationUnitDocumentProvider();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setWS(java.lang.String;)V2
public void setWS(String ws) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fWs;
    this.fWs = ws;
    firePropertyChanged(P_WS, oldValue, ws);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.Utils.getTypeName(org.eclipse.team.ui.synchronize.ISynchronizeParticipant;)java.lang.String;1
public static String getTypeName(ISynchronizeParticipant participant) {
    ISynchronizeManager manager = TeamUI.getSynchronizeManager();
    return manager.getParticipantDescriptor(participant.getId()).getName();
}
method: org.eclipse.team.internal.ui.registry.SynchronizeParticipantDescriptor.getName()java.lang.String;1
public String getName() {
    return label;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.Utils.getTypeName(org.eclipse.team.ui.synchronize.ISynchronizeParticipant;)java.lang.String;1
public static String getTypeName(ISynchronizeParticipant participant) {
    ISynchronizeManager manager = TeamUI.getSynchronizeManager();
    return manager.getParticipantDescriptor(participant.getId()).getName();
}
method: org.eclipse.team.internal.ui.synchronize.SynchronizeManager.getParticipantDescriptor(java.lang.String;)org.eclipse.team.ui.synchronize.ISynchronizeParticipantDescriptor;2
public ISynchronizeParticipantDescriptor getParticipantDescriptor(String id) {
    return participantRegistry.find(id);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.AbstractJavaElementRenameChange.getModifiedElement()java.lang.Object;1
@Override
public Object getModifiedElement() {
    return JavaCore.create(getResource());
}
method: org.eclipse.jdt.internal.corext.refactoring.AbstractJavaElementRenameChange.getResource()org.eclipse.core.resources.IResource;1
protected final IResource getResource() {
    return ResourcesPlugin.getWorkspace().getRoot().findMember(fResourcePath);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.Utils.getTypeName(org.eclipse.team.ui.synchronize.ISynchronizeParticipant;)java.lang.String;1
public static String getTypeName(ISynchronizeParticipant participant) {
    ISynchronizeManager manager = TeamUI.getSynchronizeManager();
    return manager.getParticipantDescriptor(participant.getId()).getName();
}
method: org.eclipse.team.ui.synchronize.AbstractSynchronizeParticipant.getId()java.lang.String;1
public String getId() {
    return fId;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceMethod.hashCode()I1
public int hashCode() {
    int hash = super.hashCode();
    for (int i = 0, length = this.parameterTypes.length; i < length; i++) {
        hash = Util.combineHashCodes(hash, this.parameterTypes[i].hashCode());
    }
    return hash;
}
method: org.eclipse.jdt.internal.core.util.Util.combineHashCodes(II)I2
public static int combineHashCodes(int hashCode1, int hashCode2) {
    return hashCode1 * 17 + hashCode2;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.MultiList.hashCode()I1
public int hashCode() {
    getterCalled();
    int result = 1;
    for (int i = 0; i < lists.length; i++) {
        result = result * 31 + lists[i].hashCode();
    }
    return result;
}
method: org.eclipse.core.databinding.observable.list.MultiList.getterCalled()V1
private void getterCalled() {
    ObservableTracker.getterCalled(this);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.CVSRepositoryPropertiesPage.getOldLabel(org.eclipse.team.internal.ccvs.core.connection.CVSRepositoryLocation;)java.lang.String;2
private String getOldLabel(CVSRepositoryLocation location) {
    return CVSUIPlugin.getPlugin().getRepositoryManager().getRepositoryRootFor(location).getName();
}
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryRoot.getName()java.lang.String;1
public String getName() {
    return name;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteCategoryDefinition.setName(java.lang.String;)V2
public void setName(String name) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.name;
    this.name = name;
    firePropertyChanged(P_NAME, oldValue, name);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureData.setFilter(java.lang.String;)V2
public void setFilter(String filter) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.filter;
    this.filter = filter;
    firePropertyChanged(P_FILTER, oldValue, filter);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.JavaDebugImages.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getImageDescriptor(String key) {
    return getImageRegistry().getDescriptor(key);
}
method: org.eclipse.jface.resource.ImageRegistry.getDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public ImageDescriptor getDescriptor(String key) {
    Entry entry = getEntry(key);
    if (entry == null) {
        return null;
    }
    return entry.descriptor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.provisional.ViewerInputService$1.update(org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerInputUpdate;)V2
@Override
public void update(IViewerInputUpdate update) {
    update.setInputElement(null);
    update.done();
}
method: org.eclipse.debug.internal.ui.viewers.model.ViewerInputUpdate.setInputElement(java.lang.Object;)V2
@Override
public void setInputElement(Object element) {
    fInputElement = element;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.renderings.AbstractTableRenderingLabelProvider.dispose()V1
@Override
public void dispose() {
    fRendering = null;
    super.dispose();
}
method: org.eclipse.jface.viewers.BaseLabelProvider.dispose()V1
@Override
public void dispose() {
    clearListeners();
}

---------------Library-------------------
method: org.eclipse.team.ui.mapping.SynchronizationOperation.clearContextBusy(org.eclipse.core.runtime.IProgressMonitor;)V2
private void clearContextBusy(final IProgressMonitor monitor) {
    final IJobManager jobManager = Job.getJobManager();
    final IJobChangeListener listener = new  JobChangeAdapter() {

        public void done(IJobChangeEvent event) {
            Job[] jobs = jobManager.find(getContext());
            if (jobs.length == 0) {
                final IResourceDiffTree diffTree = getContext().getDiffTree();
                diffTree.clearBusy(null);
                jobManager.removeJobChangeListener(this);
            }
        }
    };
    jobManager.addJobChangeListener(listener);
}
method: org.eclipse.core.internal.jobs.JobManager.addJobChangeListener(org.eclipse.core.runtime.jobs.IJobChangeListener;)V2
@Override
public void addJobChangeListener(IJobChangeListener listener) {
    jobListeners.add(listener);
}
---------------Client-------------------
method: org.eclipse.debug.ui.StringVariableSelectionDialog$3.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    editVariables();
}
method: org.eclipse.debug.ui.StringVariableSelectionDialog.editVariables()V1
protected void editVariables() {
    final Display display = DebugUIPlugin.getStandardDisplay();
    BusyIndicator.showWhile(display, new  Runnable() {

        @Override
        public void run() {
            if (showVariablesPage()) {
                final IStringVariable[] elements = VariablesPlugin.getDefault().getStringVariableManager().getVariables();
                display.asyncExec(new  Runnable() {

                    @Override
                    public void run() {
                        setListElements(elements);
                    }
                });
            }
        }
    });
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setColocationAffinity(java.lang.String;)V2
public void setColocationAffinity(String newValue) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fColocationAffinity;
    this.fColocationAffinity = newValue;
    firePropertyChanged(P_COLLOCATION_AFFINITY, oldValue, newValue);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.core.internal.filebuffers.ExtensionsRegistry.log(org.eclipse.core.runtime.IStatus;)V2
private void log(IStatus status) {
    ILog log = FileBuffersPlugin.getDefault().getLog();
    log.log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.CreateElementInCUOperation.getCompilationUnit()org.eclipse.jdt.core.ICompilationUnit;1
protected ICompilationUnit getCompilationUnit() {
    return getCompilationUnitFor(getParentElement());
}
method: org.eclipse.jdt.internal.core.JavaModelOperation.getCompilationUnitFor(org.eclipse.jdt.core.IJavaElement;)org.eclipse.jdt.core.ICompilationUnit;2
protected ICompilationUnit getCompilationUnitFor(IJavaElement element) {
    return ((JavaElement) element).getCompilationUnit();
}
---------------Client-------------------
method: org.eclipse.e4.ui.internal.workbench.ConfigurationElementAdapter.getPropIds(java.lang.Object;)Ajava.lang.String;2
@Override
public String[] getPropIds(Object element) {
    IConfigurationElement ice = (IConfigurationElement) element;
    return ice.getAttributeNames();
}
method: org.eclipse.core.internal.registry.ConfigurationElementHandle.getAttributeNames()Ajava.lang.String;1
public String[] getAttributeNames() {
    return getConfigurationElement().getAttributeNames();
}

---------------Library-------------------
method: org.eclipse.pde.core.plugin.PluginRegistry.getActiveModels(Z)Aorg.eclipse.pde.core.plugin.IPluginModelBase;1
public static IPluginModelBase[] getActiveModels(boolean includeFragments) {
    return PDECore.getDefault().getModelManager().getActiveModels(includeFragments);
}
method: org.eclipse.pde.internal.core.PDECore.getModelManager()org.eclipse.pde.internal.core.PluginModelManager;1
public PluginModelManager getModelManager() {
    return PluginModelManager.getInstance();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.JavaStatusContextViewer.newJavaDocument(java.lang.String;)org.eclipse.jface.text.IDocument;2
private IDocument newJavaDocument(String source) {
    IDocument result = new  Document(source);
    JavaTextTools textTools = JavaPlugin.getDefault().getJavaTextTools();
    textTools.setupJavaDocumentPartitioner(result);
    return result;
}
method: org.eclipse.jdt.ui.text.JavaTextTools.setupJavaDocumentPartitioner(org.eclipse.jface.text.IDocument;)V2
public void setupJavaDocumentPartitioner(IDocument document) {
    setupJavaDocumentPartitioner(document, IDocumentExtension3.DEFAULT_PARTITIONING);
}
---------------Client-------------------
method: org.eclipse.compare.internal.patch.PatchCompareEditorInput.initializeImageCache(org.eclipse.compare.patch.PatchConfiguration;)org.eclipse.jface.resource.LocalResourceManager;1
private static LocalResourceManager initializeImageCache(PatchConfiguration patchConfiguration) {
    LocalResourceManager imageCache = new  LocalResourceManager(JFaceResources.getResources());
    patchConfiguration.setProperty(IMAGE_CACHE_KEY, imageCache);
    return imageCache;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ExtractConstantWizard$ExtractConstantInputPage$2.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    getExtractConstantRefactoring().setReplaceAllOccurrences(checkBox.getSelection());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractConstantRefactoring.setReplaceAllOccurrences(Z)V2
public void setReplaceAllOccurrences(boolean replaceAllOccurrences) {
    fReplaceAllOccurrences = replaceAllOccurrences;
}
---------------Client-------------------
method: org.eclipse.swt.custom.StyledText$12.getCharacterCount(org.eclipse.swt.accessibility.AccessibleTextEvent;)V2
@Override
public void getCharacterCount(AccessibleTextEvent e) {
    e.count = StyledText.this.getCharCount();
}
method: org.eclipse.swt.custom.StyledText.getCharCount()I1
public int getCharCount() {
    checkWidget();
    return content.getCharCount();
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbItemDropDown.notifySelection(org.eclipse.jface.viewers.ISelection;)V2
@Override
public void notifySelection(ISelection selection) {
    fParent.getViewer().fireMenuSelection(selection);
}
method: org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbViewer.fireMenuSelection(org.eclipse.jface.viewers.ISelection;)V2
void fireMenuSelection(ISelection selection) {
    fireOpen(new  OpenEvent(this, selection));
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.Site.setAssociateSitesURL(java.lang.String;)V2
public void setAssociateSitesURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.associateSitesUrl;
    this.associateSitesUrl = url;
    firePropertyChanged(P_ASSOCIATE_SITES_URL, oldValue, url);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.actions.RelaunchActionDelegate.doAction(java.lang.Object;)V2
@Override
protected void doAction(Object object) {
    ILaunch launch = DebugUIPlugin.getLaunch(object);
    if (launch != null) {
        relaunch(launch.getLaunchConfiguration(), launch.getLaunchMode());
    }
}
method: org.eclipse.debug.internal.ui.actions.RelaunchActionDelegate.relaunch(org.eclipse.debug.core.ILaunchConfiguration;java.lang.String;)V2
public static void relaunch(ILaunchConfiguration config, String mode) {
    DebugUITools.launch(config, mode);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.product.FeatureSection.handleRemoveAll()V1
private void handleRemoveAll() {
    IProduct product = getProduct();
    product.removeFeatures(product.getFeatures());
}
method: org.eclipse.pde.internal.ui.editor.product.FeatureSection.getProduct()org.eclipse.pde.internal.core.iproduct.IProduct;1
private IProduct getProduct() {
    return getModel().getProduct();
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.actions.FoldingToggleRulerAction.menuAboutToShow(org.eclipse.jface.action.IMenuManager;)V2
@Override
public void menuAboutToShow(IMenuManager manager) {
    update();
    super.menuAboutToShow(manager);
}
method: org.eclipse.ui.texteditor.AbstractRulerActionDelegate.menuAboutToShow(org.eclipse.jface.action.IMenuManager;)V2
public void menuAboutToShow(IMenuManager manager) {
    update();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.CheckedListDialogField.checkStateChanged()V1
private void checkStateChanged() {
    super.dialogFieldChanged();
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField.dialogFieldChanged()V1
@Override
public void dialogFieldChanged() {
    super.dialogFieldChanged();
    updateButtonState();
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.ResourceModelLabelProvider.getDiff(java.lang.Object;)org.eclipse.team.core.diff.IDiff;2
protected IDiff getDiff(Object elementOrPath) {
    IResource resource = getResource(elementOrPath);
    IResourceDiffTree tree = getDiffTree(elementOrPath);
    if (tree != null && resource != null) {
        IDiff delta = tree.getDiff(resource.getFullPath());
        return delta;
    }
    return null;
}
method: org.eclipse.team.internal.ui.mapping.ResourceModelLabelProvider.getDiffTree(java.lang.Object;)org.eclipse.team.core.mapping.IResourceDiffTree;2
protected IResourceDiffTree getDiffTree(Object elementOrPath) {
    ISynchronizationContext context = getContext();
    if (context != null)
        return context.getDiffTree();
    return null;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.provisional.Factory.fieldDescriptor(java.lang.String;java.lang.String;)org.eclipse.pde.api.tools.internal.provisional.descriptors.IFieldDescriptor;2
public static IFieldDescriptor fieldDescriptor(String typename, String name) {
    IReferenceTypeDescriptor type = typeDescriptor(typename);
    return type.getField(name);
}
method: org.eclipse.pde.api.tools.internal.provisional.Factory.typeDescriptor(java.lang.String;)org.eclipse.pde.api.tools.internal.provisional.descriptors.IReferenceTypeDescriptor;1
public static IReferenceTypeDescriptor typeDescriptor(String fullyQualifiedName) {
    String packageName = Signatures.getPackageName(fullyQualifiedName);
    String typeName = Signatures.getTypeName(fullyQualifiedName);
    return packageDescriptor(packageName).getType(typeName);
}

---------------Library-------------------
method: org.eclipse.swt.internal.mozilla.IIDStore.GetIID(java.lang.Class;)org.eclipse.swt.internal.mozilla.nsID;1
public static nsID GetIID(Class<?> clazz) {
    return GetIID(clazz, MozillaVersion.GetCurrentVersion());
}
method: org.eclipse.swt.internal.mozilla.IIDStore.GetIID(java.lang.Class;I)org.eclipse.swt.internal.mozilla.nsID;2
public static nsID GetIID(Class<?> clazz, int version) {
    return GetIID(clazz, version, false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.ClasspathEntry.getResolvedEntry()org.eclipse.jdt.core.IClasspathEntry;1
public IClasspathEntry getResolvedEntry() {
    return JavaCore.getResolvedClasspathEntry(this);
}
method: org.eclipse.jdt.core.JavaCore.getResolvedClasspathEntry(org.eclipse.jdt.core.IClasspathEntry;)org.eclipse.jdt.core.IClasspathEntry;1
public static IClasspathEntry getResolvedClasspathEntry(IClasspathEntry entry) {
    return JavaModelManager.getJavaModelManager().resolveVariableEntry(entry, false);
}

---------------Library-------------------
method: org.eclipse.team.ui.mapping.SynchronizationContentProvider.getConfiguration()org.eclipse.team.ui.synchronize.ISynchronizePageConfiguration;1
protected ISynchronizePageConfiguration getConfiguration() {
    ICommonContentExtensionSite extensionSite = getExtensionSite();
    if (extensionSite != null)
        return (ISynchronizePageConfiguration) extensionSite.getExtensionStateModel().getProperty(ITeamContentProviderManager.P_SYNCHRONIZATION_PAGE_CONFIGURATION);
    return null;
}
method: org.eclipse.ui.internal.navigator.extensions.ExtensionStateModel.getProperty(java.lang.String;)java.lang.Object;2
public Object getProperty(String aPropertyName) {
    return values.get(aPropertyName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.delegates.DelegateMethodCreator.getDeclarationBinding()org.eclipse.jdt.core.dom.IBinding;1
@Override
protected IBinding getDeclarationBinding() {
    final MethodDeclaration declaration = (MethodDeclaration) getDeclaration();
    return declaration.resolveBinding();
}
method: org.eclipse.jdt.core.dom.MethodDeclaration.resolveBinding()org.eclipse.jdt.core.dom.IMethodBinding;1
public IMethodBinding resolveBinding() {
    return this.ast.getBindingResolver().resolveMethod(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.Site.setMirrorsURL(java.lang.String;)V2
public void setMirrorsURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.mirrorsUrl;
    this.mirrorsUrl = url;
    firePropertyChanged(P_MIRRORS_URL, oldValue, url);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.core.plugin.PluginRegistry.findEntry(java.lang.String;)org.eclipse.pde.core.plugin.ModelEntry;1
public static ModelEntry findEntry(String id) {
    return PDECore.getDefault().getModelManager().findEntry(id);
}
method: org.eclipse.pde.internal.core.PDECore.getModelManager()org.eclipse.pde.internal.core.PluginModelManager;1
public PluginModelManager getModelManager() {
    return PluginModelManager.getInstance();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.core.databinding.beans.PojoObservables.setFactory(org.eclipse.core.databinding.observable.Realm;java.lang.String;java.lang.Class;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;3
public static IObservableFactory setFactory(final Realm realm, final String propertyName, final Class elementType) {
    return PojoProperties.set(propertyName, elementType).setFactory(realm);
}
method: org.eclipse.core.databinding.property.set.SetProperty.setFactory(org.eclipse.core.databinding.observable.Realm;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;2
public IObservableFactory setFactory(final Realm realm) {
    return new  IObservableFactory() {

        public IObservable createObservable(Object target) {
            return observe(realm, target);
        }
    };
}
---------------Client-------------------
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.createState()org.eclipse.osgi.service.resolver.State;1
public State createState() {
    return internalCreateState();
}
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.internalCreateState()org.eclipse.osgi.internal.resolver.StateImpl;1
private StateImpl internalCreateState() {
    StateImpl state = new  UserState();
    state.setFactory(this);
    return state;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureInfo.setURL(java.lang.String;)V2
public void setURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.url;
    this.url = url;
    firePropertyChanged(P_URL, oldValue, url);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.WorkspaceFeatureModelManager.removeListeners()V1
protected void removeListeners() {
    PDECore.getWorkspace().removeResourceChangeListener(this);
    super.removeListeners();
}
method: org.eclipse.pde.internal.core.AbstractModelManager.removeListeners()V1
protected void removeListeners() {
    fListeners.clear();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.enableLogout()V1
protected void enableLogout() {
    buttonClearPassword.setEnabled(InternalExchangeUtils.isLoggedIn());
}
method: org.eclipse.equinox.internal.security.storage.friends.InternalExchangeUtils.isLoggedIn()Z0
public static boolean isLoggedIn() {
    return PasswordProviderSelector.getInstance().isLoggedIn();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.util.PluginWorkingSet.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.jface.dialogs.DialogPage.dispose()V1
@Override
public void dispose() {
    if (image != null) {
        image.dispose();
        image = null;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.SynchronizePageDropDownAction.dispose()V1
public void dispose() {
    if (menuManager != null) {
        menuManager.dispose();
        menuManager = null;
    }
    TeamUI.getSynchronizeManager().removeSynchronizeParticipantListener(this);
}
method: org.eclipse.team.ui.TeamUI.getSynchronizeManager()org.eclipse.team.ui.synchronize.ISynchronizeManager;0
public static ISynchronizeManager getSynchronizeManager() {
    return TeamUIPlugin.getPlugin().getSynchronizeManager();
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.WizardNewProjectCreationPage.getProjectHandle()org.eclipse.core.resources.IProject;1
public IProject getProjectHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.core.databinding.beans.BeansObservables.listFactory(org.eclipse.core.databinding.observable.Realm;java.lang.String;java.lang.Class;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;3
public static IObservableFactory listFactory(final Realm realm, final String propertyName, final Class elementType) {
    return BeanProperties.list(propertyName, elementType).listFactory(realm);
}
method: org.eclipse.core.databinding.property.list.ListProperty.listFactory(org.eclipse.core.databinding.observable.Realm;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;2
public IObservableFactory listFactory(final Realm realm) {
    return new  IObservableFactory() {

        public IObservable createObservable(Object target) {
            return observe(realm, target);
        }
    };
}
---------------Client-------------------
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.createState()org.eclipse.osgi.service.resolver.State;1
public State createState() {
    return internalCreateState();
}
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.internalCreateState()org.eclipse.osgi.internal.resolver.StateImpl;1
private StateImpl internalCreateState() {
    StateImpl state = new  UserState();
    state.setFactory(this);
    return state;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover.addLinkListener(org.eclipse.jface.internal.text.html.BrowserInformationControl;)V1
private static void addLinkListener(final BrowserInformationControl control) {
    control.addLocationListener(JavaElementLinks.createLocationListener(new  JavaElementLinks.ILinkHandler() {

        public void handleJavadocViewLink(IJavaElement linkTarget) {
            control.notifyDelayedInputChange(null);
            control.setVisible(false);
            control.dispose();
            try {
                JavadocView view = (JavadocView) JavaPlugin.getActivePage().showView(JavaUI.ID_JAVADOC_VIEW);
                view.setInput(linkTarget);
            } catch (PartInitException e) {
                JavaPlugin.log(e);
            }
        }

        public void handleInlineJavadocLink(IJavaElement linkTarget) {
            JavadocBrowserInformationControlInput hoverInfo = getHoverInfo(new IJavaElement[] { linkTarget }, null, null, (JavadocBrowserInformationControlInput) control.getInput());
            if (control.hasDelayedInputChangeListener())
                control.notifyDelayedInputChange(hoverInfo);
            else
                control.setInput(hoverInfo);
        }

        public void handleDeclarationLink(IJavaElement linkTarget) {
            control.notifyDelayedInputChange(null);
            control.dispose();
            try {
                openDeclaration(linkTarget);
            } catch (PartInitException e) {
                JavaPlugin.log(e);
            } catch (JavaModelException e) {
                JavaPlugin.log(e);
            }
        }

        public boolean handleExternalLink(URL url, Display display) {
            control.notifyDelayedInputChange(null);
            control.dispose();
            OpenBrowserUtil.open(url, display);
            return true;
        }

        public void handleTextSet() {
        }
    }));
}
method: org.eclipse.jface.internal.text.html.BrowserInformationControl.addLocationListener(org.eclipse.swt.browser.LocationListener;)V2
public void addLocationListener(LocationListener listener) {
    fBrowser.addLocationListener(listener);
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.commands.actions.TerminateAllAction.dispose()V1
@Override
public void dispose() {
    getLaunchManager().removeLaunchListener(this);
    super.dispose();
}
method: org.eclipse.debug.internal.ui.commands.actions.TerminateAllAction.getLaunchManager()org.eclipse.debug.core.ILaunchManager;1
private ILaunchManager getLaunchManager() {
    return DebugPlugin.getDefault().getLaunchManager();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.JavaAttributeWizard.selectAndReveal(org.eclipse.core.resources.IResource;)V2
protected void selectAndReveal(IResource newResource) {
    BasicNewResourceWizard.selectAndReveal(newResource, PDEPlugin.getActiveWorkbenchWindow());
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getActiveWorkbenchWindow()org.eclipse.ui.IWorkbenchWindow;0
public static IWorkbenchWindow getActiveWorkbenchWindow() {
    return getDefault().getWorkbench().getActiveWorkbenchWindow();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.JavaUIPreferenceInitializer.initializeDefaultPreferences()V1
@Override
public void initializeDefaultPreferences() {
    IPreferenceStore store = PreferenceConstants.getPreferenceStore();
    EditorsUI.useAnnotationsPreferencePage(store);
    EditorsUI.useQuickDiffPreferencePage(store);
    PreferenceConstants.initializeDefaultValues(store);
}
method: org.eclipse.ui.editors.text.EditorsUI.useAnnotationsPreferencePage(org.eclipse.jface.preference.IPreferenceStore;)V1
public static void useAnnotationsPreferencePage(IPreferenceStore store) {
    MarkerAnnotationPreferences.useAnnotationsPreferencePage(store);
}
---------------Client-------------------
method: org.eclipse.search.internal.ui.SearchPlugin.beep()V0
public static void beep() {
    getActiveWorkbenchShell().getDisplay().beep();
}
method: org.eclipse.search.internal.ui.SearchPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null)
        return window.getShell();
    return null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.toc.text.TocDocumentHandler.error(org.xml.sax.SAXParseException;)V2
public void error(SAXParseException e) throws SAXException {
    fModel.addError(e);
    super.error(e);
}
method: org.eclipse.pde.internal.core.text.DocumentHandler.error(org.xml.sax.SAXParseException;)V2
public void error(SAXParseException e) throws SAXException {
    generateErrorElementHierarchy();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage$1.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    controlChanged();
}
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage.controlChanged()V1
public void controlChanged() {
    setPageComplete(validate());
}

---------------Library-------------------
method: org.eclipse.core.databinding.beans.BeansObservables.setFactory(org.eclipse.core.databinding.observable.Realm;java.lang.String;java.lang.Class;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;3
public static IObservableFactory setFactory(final Realm realm, final String propertyName, final Class elementType) {
    return BeanProperties.set(propertyName, elementType).setFactory(realm);
}
method: org.eclipse.core.databinding.property.set.SetProperty.setFactory(org.eclipse.core.databinding.observable.Realm;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;2
public IObservableFactory setFactory(final Realm realm) {
    return new  IObservableFactory() {

        public IObservable createObservable(Object target) {
            return observe(realm, target);
        }
    };
}
---------------Client-------------------
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.createState()org.eclipse.osgi.service.resolver.State;1
public State createState() {
    return internalCreateState();
}
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.internalCreateState()org.eclipse.osgi.internal.resolver.StateImpl;1
private StateImpl internalCreateState() {
    StateImpl state = new  UserState();
    state.setFactory(this);
    return state;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.PluginLibrary.setType(java.lang.String;)V2
public void setType(String type) throws CoreException {
    ensureModelEditable();
    String oldValue = fType;
    fType = type;
    firePropertyChanged(P_TYPE, oldValue, type);
}
method: org.eclipse.pde.internal.core.plugin.PluginObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jdt.launching.JavaRuntime.getJavaModel()org.eclipse.jdt.core.IJavaModel;0
private static IJavaModel getJavaModel() {
    return JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.ui.forms.widgets.ScrolledForm.setBusy(Z)V2
public void setBusy(boolean busy) {
    content.setBusy(busy);
    reflow(true);
}
method: org.eclipse.ui.forms.widgets.Form.setBusy(Z)V2
public void setBusy(boolean busy) {
    head.setBusy(busy);
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.ResourceDragAndDropEditor.loadDefault()V1
public void loadDefault() {
    folderPref.loadDefault();
    virtualFolderPref.loadDefault();
}
method: org.eclipse.ui.internal.ide.ResourceDragAndDropEditor$PreferenceGroup.loadDefault()V1
public void loadDefault() {
    String value = getStoredValue(true);
    updateState(value);
}

---------------Library-------------------
method: org.eclipse.ui.views.contentoutline.ContentOutline.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    getSelectionProvider().selectionChanged(event);
}
method: org.eclipse.ui.part.PageBookView$SelectionProvider.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(final SelectionChangedEvent event) {
    fSelectionListener.selectionChanged(event);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage$1.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    controlChanged();
}
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage.controlChanged()V1
public void controlChanged() {
    setPageComplete(validate());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction.getMenu(org.eclipse.swt.widgets.Control;)org.eclipse.swt.widgets.Menu;2
public Menu getMenu(Control parent) {
    setMenu(new  Menu(parent));
    fillMenu(fMenu);
    initMenu(fMenu);
    return fMenu;
}
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction.initMenu(org.eclipse.swt.widgets.Menu;)V2
protected void initMenu(Menu menu) {
    menu.addMenuListener(new  MenuAdapter() {

        @Override
        public void menuShown(MenuEvent e) {
            Menu m = (Menu) e.widget;
            MenuItem[] items = m.getItems();
            for (int i = 0; i < items.length; i++) {
                items[i].dispose();
            }
            fillMenu(m);
        }
    });
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.outline.QuickOutlinePopupDialog.createTitleControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createTitleControl(Composite parent) {
    createUIWidgetFilterText(parent);
    createUIListenersFilterText();
    return fFilterText;
}
method: org.eclipse.pde.internal.ui.editor.outline.QuickOutlinePopupDialog.createUIListenersFilterText()V1
private void createUIListenersFilterText() {
    fFilterText.addKeyListener(new  KeyListener() {

        public void keyPressed(KeyEvent e) {
            if (e.keyCode == 0x0D) {
                gotoSelectedElement();
            } else if (e.keyCode == SWT.ARROW_DOWN) {
                fTreeViewer.getTree().setFocus();
            } else if (e.keyCode == SWT.ARROW_UP) {
                fTreeViewer.getTree().setFocus();
            } else if (e.character == 0x1B) {
                dispose();
            }
        }

        public void keyReleased(KeyEvent e) {
        }
    });
    fFilterText.addModifyListener(new  ModifyListener() {

        public void modifyText(ModifyEvent e) {
            String text = ((Text) e.widget).getText();
            int length = text.length();
            if (length > 0) {
                if (text.charAt(length - 1) != '*') {
                    text = text + '*';
                }
                if (text.charAt(0) != '*') {
                    text = '*' + text;
                }
            }
            setMatcherString(text, true);
        }
    });
}

---------------Library-------------------
method: org.eclipse.ui.actions.GlobalBuildAction.getWorkspaceProjects()Aorg.eclipse.core.resources.IProject;1
IProject[] getWorkspaceProjects() {
    return ResourcesPlugin.getWorkspace().getRoot().getProjects();
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.ui.editors.text.EditorsUI.getSpellingService()org.eclipse.ui.texteditor.spelling.SpellingService;0
public static SpellingService getSpellingService() {
    return EditorsPlugin.getDefault().getSpellingService();
}
method: org.eclipse.ui.internal.editors.text.EditorsPlugin.getSpellingService()org.eclipse.ui.texteditor.spelling.SpellingService;1
public SpellingService getSpellingService() {
    if (fSpellingService == null)
        fSpellingService = new  SpellingService(getPreferenceStore());
    return fSpellingService;
}
---------------Client-------------------
method: org.eclipse.compare.CompareConfiguration.getResourceManager()org.eclipse.jface.resource.ResourceManager;1
private synchronized ResourceManager getResourceManager() {
    if (fResourceManager == null) {
        fResourceManager = new  LocalResourceManager(JFaceResources.getResources());
    }
    return fResourceManager;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ChangeSignatureWizard$ChangeSignatureInputPage$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    processor.setDeprecateDelegates(fDeprecateDelegateCheckBox.getSelection());
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.ChangeSignatureProcessor.setDeprecateDelegates(Z)V2
public void setDeprecateDelegates(boolean deprecate) {
    fDelegateDeprecation = deprecate;
}
---------------Client-------------------
method: org.eclipse.swt.custom.StyledText$12.getCharacterCount(org.eclipse.swt.accessibility.AccessibleTextEvent;)V2
@Override
public void getCharacterCount(AccessibleTextEvent e) {
    e.count = StyledText.this.getCharCount();
}
method: org.eclipse.swt.custom.StyledText.getCharCount()I1
public int getCharCount() {
    checkWidget();
    return content.getCharCount();
}

---------------Library-------------------
method: org.eclipse.core.runtime.Platform.getResourceBundle(org.osgi.framework.Bundle;)java.util.ResourceBundle;1
public static ResourceBundle getResourceBundle(Bundle bundle) throws MissingResourceException {
    return InternalPlatform.getDefault().getResourceBundle(bundle);
}
method: org.eclipse.core.internal.runtime.InternalPlatform.getResourceBundle(org.osgi.framework.Bundle;)java.util.ResourceBundle;2
public ResourceBundle getResourceBundle(Bundle bundle) {
    return ResourceTranslator.getResourceBundle(bundle);
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.TableEditorImpl.cancelEditing()V1
public void cancelEditing() {
    if (fCellEditor != null) {
        setEditor(null, null, 0);
        fCellEditor.removeListener(fCellEditorListener);
        CellEditor oldEditor = fCellEditor;
        fCellEditor = null;
        oldEditor.deactivate();
    }
}
method: org.eclipse.jface.viewers.CellEditor.removeListener(org.eclipse.jface.viewers.ICellEditorListener;)V2
public void removeListener(ICellEditorListener listener) {
    listeners.remove(listener);
}
---------------Client-------------------
method: org.eclipse.jface.viewers.TableTreeViewer$TableTreeEditorImpl$3.cancelEditor()V1
@Override
public void cancelEditor() {
    TableTreeEditorImpl.this.cancelEditing();
}
method: org.eclipse.jface.viewers.TableTreeViewer$TableTreeEditorImpl.cancelEditing()V1
public void cancelEditing() {
    if (cellEditor != null) {
        setEditor(null, null, 0);
        cellEditor.removeListener(cellEditorListener);
        CellEditor oldEditor = cellEditor;
        cellEditor = null;
        oldEditor.deactivate();
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.PreferencesAccess$WorkingCopyPreferencesAccess.getProjectScope(org.eclipse.core.resources.IProject;)org.eclipse.core.runtime.preferences.IScopeContext;2
@Override
public IScopeContext getProjectScope(IProject project) {
    return getWorkingCopyScopeContext(super.getProjectScope(project));
}
method: org.eclipse.jdt.internal.ui.preferences.PreferencesAccess.getProjectScope(org.eclipse.core.resources.IProject;)org.eclipse.core.runtime.preferences.IScopeContext;2
public IScopeContext getProjectScope(IProject project) {
    return new  ProjectScope(project);
}
---------------Client-------------------
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.createState()org.eclipse.osgi.service.resolver.State;1
public State createState() {
    return internalCreateState();
}
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.internalCreateState()org.eclipse.osgi.internal.resolver.StateImpl;1
private StateImpl internalCreateState() {
    StateImpl state = new  UserState();
    state.setFactory(this);
    return state;
}

---------------Library-------------------
method: org.eclipse.jdt.core.JavaCore.create(org.eclipse.core.resources.IProject;)org.eclipse.jdt.core.IJavaProject;1
public static IJavaProject create(IProject project) {
    if (project == null) {
        return null;
    }
    JavaModel javaModel = JavaModelManager.getJavaModelManager().getJavaModel();
    return javaModel.getJavaProject(project);
}
method: org.eclipse.jdt.internal.core.JavaModelManager.getJavaModel()org.eclipse.jdt.internal.core.JavaModel;1
public final JavaModel getJavaModel() {
    return this.javaModel;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}

---------------Library-------------------
method: org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard.initializeDefaultPageImageDescriptor()V1
protected void initializeDefaultPageImageDescriptor() {
    ImageDescriptor desc = IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/newfile_wiz.png");
    setDefaultPageImageDescriptor(desc);
}
method: org.eclipse.jface.wizard.Wizard.setDefaultPageImageDescriptor(org.eclipse.jface.resource.ImageDescriptor;)V2
public void setDefaultPageImageDescriptor(ImageDescriptor imageDescriptor) {
    defaultImageDescriptor = imageDescriptor;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Link$2.getDefaultAction(org.eclipse.swt.accessibility.AccessibleControlEvent;)V2
@Override
public void getDefaultAction(AccessibleControlEvent e) {
    e.result = SWT.getMessage("SWT_Press");
}
method: org.eclipse.swt.SWT.getMessage(java.lang.String;)java.lang.String;1
public static String getMessage(String key) {
    return Compatibility.getMessage(key);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.PluginRebuilder.stop()V1
public void stop() {
    PDECore.getDefault().getModelManager().removeStateDeltaListener(this);
    JavaCore.removePreProcessingResourceChangedListener(this);
}
method: org.eclipse.jdt.core.JavaCore.removePreProcessingResourceChangedListener(org.eclipse.core.resources.IResourceChangeListener;)V1
public static void removePreProcessingResourceChangedListener(IResourceChangeListener listener) {
    JavaModelManager.getDeltaState().removePreResourceChangedListener(listener);
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.search.ui.NewSearchUI.getSearchResultView()org.eclipse.search.ui.ISearchResultViewPart;0
public static ISearchResultViewPart getSearchResultView() {
    return InternalSearchUI.getInstance().getSearchViewManager().getActiveSearchView();
}
method: org.eclipse.search2.internal.ui.InternalSearchUI.getSearchViewManager()org.eclipse.search2.internal.ui.SearchViewManager;1
public SearchViewManager getSearchViewManager() {
    return fSearchViewManager;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setApplication(java.lang.String;)V2
public void setApplication(String newValue) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fApplication;
    this.fApplication = newValue;
    firePropertyChanged(P_APPLICATION, oldValue, newValue);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteArchive.setPath(java.lang.String;)V2
public void setPath(String path) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.path;
    this.path = path;
    firePropertyChanged(P_PATH, oldValue, path);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchShortcutExtension.getImageDescriptor()org.eclipse.jface.resource.ImageDescriptor;1
public ImageDescriptor getImageDescriptor() {
    if (fImageDescriptor == null) {
        fImageDescriptor = DebugUIPlugin.getImageDescriptor(getConfigurationElement(), "icon");
        if (fImageDescriptor == null) {
            fImageDescriptor = ImageDescriptor.getMissingImageDescriptor();
        }
    }
    return fImageDescriptor;
}
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchShortcutExtension.getConfigurationElement()org.eclipse.core.runtime.IConfigurationElement;1
public IConfigurationElement getConfigurationElement() {
    return fConfig;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.breakpoints.BreakpointOrganizerExtension.getImageDescriptor()org.eclipse.jface.resource.ImageDescriptor;1
@Override
public ImageDescriptor getImageDescriptor() {
    if (fDescriptor == null) {
        fDescriptor = DebugUIPlugin.getImageDescriptor(fElement, ATTR_ICON);
        if (fDescriptor == null) {
            fDescriptor = ImageDescriptor.getMissingImageDescriptor();
        }
    }
    return fDescriptor;
}
method: org.eclipse.jface.resource.ImageDescriptor.getMissingImageDescriptor()org.eclipse.jface.resource.ImageDescriptor;0
public static ImageDescriptor getMissingImageDescriptor() {
    return MissingImageDescriptor.getInstance();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteDescription.setText(java.lang.String;)V2
public void setText(String text) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.text;
    this.text = text;
    firePropertyChanged(P_TEXT, oldValue, text);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ltk.internal.core.refactoring.resource.undostates.FolderUndoState.createResourceHandle()org.eclipse.core.resources.IResource;1
public IResource createResourceHandle() {
    IWorkspaceRoot workspaceRoot = getWorkspace().getRoot();
    IPath folderPath = parent.getFullPath().append(name);
    return workspaceRoot.getFolder(folderPath);
}
method: org.eclipse.ltk.internal.core.refactoring.resource.undostates.AbstractResourceUndoState.getWorkspace()org.eclipse.core.resources.IWorkspace;1
IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.LazyJavaCompletionProposal.computeImage()org.eclipse.swt.graphics.Image;1
protected Image computeImage() {
    return JavaPlugin.getImageDescriptorRegistry().get(fInvocationContext.getLabelProvider().createImageDescriptor(fProposal));
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getImageDescriptorRegistry()org.eclipse.jdt.internal.ui.viewsupport.ImageDescriptorRegistry;0
public static ImageDescriptorRegistry getImageDescriptorRegistry() {
    return getDefault().internalGetImageDescriptorRegistry();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.templates.TemplateSelectionPage.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.jface.dialogs.DialogPage.dispose()V1
@Override
public void dispose() {
    if (image != null) {
        image.dispose();
        image = null;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.SynchronizePageDropDownAction.dispose()V1
public void dispose() {
    if (menuManager != null) {
        menuManager.dispose();
        menuManager = null;
    }
    TeamUI.getSynchronizeManager().removeSynchronizeParticipantListener(this);
}
method: org.eclipse.team.ui.TeamUI.getSynchronizeManager()org.eclipse.team.ui.synchronize.ISynchronizeManager;0
public static ISynchronizeManager getSynchronizeManager() {
    return TeamUIPlugin.getPlugin().getSynchronizeManager();
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.list.AbstractObservableList.fireStale()V1
protected void fireStale() {
    checkRealm();
    changeSupport.fireEvent(new  StaleEvent(this));
}
method: org.eclipse.core.databinding.observable.ChangeSupport.fireEvent(org.eclipse.core.databinding.observable.ObservableEvent;)V2
public void fireEvent(ObservableEvent event) {
    super.fireEvent(event);
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.IntroduceParameterRefactoring.setParameterName(java.lang.String;)V2
public void setParameterName(String name) {
    Assert.isNotNull(name);
    fParameter.setNewName(name);
}
method: org.eclipse.jdt.internal.corext.refactoring.ParameterInfo.setNewName(java.lang.String;)V2
public void setNewName(String newName) {
    Assert.isNotNull(newName);
    fNewName = newName;
}
---------------Client-------------------
method: org.eclipse.jface.text.MarginPainter.setMarginRulerColumn(I)V2
public void setMarginRulerColumn(int width) {
    fMarginWidth = width;
    initialize();
}
method: org.eclipse.jface.text.MarginPainter.initialize()V1
public void initialize() {
    computeWidgetX();
    fTextWidget.redraw();
}

---------------Library-------------------
method: org.eclipse.core.runtime.Platform.getResourceString(org.osgi.framework.Bundle;java.lang.String;java.util.ResourceBundle;)java.lang.String;3
public static String getResourceString(Bundle bundle, String value, ResourceBundle resourceBundle) {
    return InternalPlatform.getDefault().getResourceString(bundle, value, resourceBundle);
}
method: org.eclipse.core.internal.runtime.InternalPlatform.getResourceString(org.osgi.framework.Bundle;java.lang.String;java.util.ResourceBundle;)java.lang.String;4
public String getResourceString(Bundle bundle, String value, ResourceBundle resourceBundle) {
    return ResourceTranslator.getResourceString(bundle, value, resourceBundle);
}
---------------Client-------------------
method: org.eclipse.search.internal.ui.SearchResultViewEntry.getAdapter(java.lang.Class;)java.lang.Object;2
public Object getAdapter(Class adapter) {
    return super.getAdapter(adapter);
}
method: org.eclipse.core.runtime.PlatformObject.getAdapter(java.lang.Class;)java.lang.Object;2
public Object getAdapter(Class adapter) {
    return AdapterManager.getDefault().getAdapter(this, adapter);
}

---------------Library-------------------
method: org.eclipse.core.externaltools.internal.ExternalToolsCore.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setOS(java.lang.String;)V2
public void setOS(String os) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fOs;
    this.fOs = os;
    firePropertyChanged(P_OS, oldValue, os);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.compare.PropertiesStructureCreator$PropertyNode.getImage()org.eclipse.swt.graphics.Image;1
public Image getImage() {
    return CompareUI.getImage(getType());
}
method: org.eclipse.jdt.internal.ui.compare.PropertiesStructureCreator$PropertyNode.getType()java.lang.String;1
public String getType() {
    return "properties2";
}
---------------Client-------------------
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return getClasspathImage();
}
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab.getClasspathImage()org.eclipse.swt.graphics.Image;0
public static Image getClasspathImage() {
    return JavaDebugImages.get(JavaDebugImages.IMG_OBJS_CLASSPATH);
}

---------------Library-------------------
method: org.eclipse.compare.internal.core.ComparePlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Workspace.removeSaveParticipant(java.lang.String;)V2
public void removeSaveParticipant(String pluginId) {
    Assert.isNotNull(pluginId, "Plugin id must not be null");
    saveManager.removeParticipant(pluginId);
}
method: org.eclipse.core.internal.resources.SaveManager.removeParticipant(java.lang.String;)V2
public void removeParticipant(String pluginId) {
    saveParticipants.remove(pluginId);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.ResourceTree.failed(org.eclipse.core.runtime.IStatus;)V2
public void failed(IStatus reason) {
    Assert.isLegal(isValid);
    multistatus.add(reason);
}
method: org.eclipse.core.runtime.Assert.isLegal(Z)Z1
public static boolean isLegal(boolean expression) {
    return isLegal(expression, "");
}

---------------Library-------------------
method: org.eclipse.osgi.container.ModuleRevision.getWiring()org.eclipse.osgi.container.ModuleWiring;1
@Override
public ModuleWiring getWiring() {
    return revisions.getContainer().getWiring(this);
}
method: org.eclipse.osgi.container.ModuleContainer.getWiring(org.eclipse.osgi.container.ModuleRevision;)org.eclipse.osgi.container.ModuleWiring;2
ModuleWiring getWiring(ModuleRevision revision) {
    return moduleDatabase.getWiring(revision);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.SourceFirstPackageSelectionDialogField.getSelected()org.eclipse.jdt.core.IPackageFragment;1
public IPackageFragment getSelected() {
    IPackageFragment res = fPackageSelection.getPackageFragment();
    return res;
}
method: org.eclipse.jdt.internal.ui.refactoring.nls.PackageFragmentSelection.getPackageFragment()org.eclipse.jdt.core.IPackageFragment;1
public IPackageFragment getPackageFragment() {
    return calculateFragment(fDialogField.getSelectedFragmentRoot());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpDocumentHandler.error(org.xml.sax.SAXParseException;)V2
public void error(SAXParseException e) throws SAXException {
    fModel.addError(e);
    super.error(e);
}
method: org.eclipse.pde.internal.core.text.DocumentHandler.error(org.xml.sax.SAXParseException;)V2
public void error(SAXParseException e) throws SAXException {
    generateErrorElementHierarchy();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage$1.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    controlChanged();
}
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage.controlChanged()V1
public void controlChanged() {
    setPageComplete(validate());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.Site.setDescription(org.eclipse.pde.internal.core.isite.ISiteDescription;)V2
public void setDescription(ISiteDescription description) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.description;
    this.description = description;
    firePropertyChanged(P_DESCRIPTION, oldValue, description);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jface.text.source.LineNumberChangeRulerColumn.setHover(org.eclipse.jface.text.source.IAnnotationHover;)V2
public void setHover(IAnnotationHover hover) {
    fRevisionPainter.setHover(hover);
    fDiffPainter.setHover(hover);
}
method: org.eclipse.jface.internal.text.source.DiffPainter.setHover(org.eclipse.jface.text.source.IAnnotationHover;)V2
public void setHover(IAnnotationHover hover) {
    fHover = hover;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.setRoot(java.lang.Object;)V2
public void setRoot(Object newRoot) {
    this.fRoot = newRoot;
    initialize();
}
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.initialize()V1
protected void initialize() {
    fTreeViewer.setInput(fRoot);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RemoteViewPart.getWorkingSet()org.eclipse.ui.IWorkingSet;1
protected IWorkingSet getWorkingSet() {
    return getContentProvider().getWorkingSet();
}
method: org.eclipse.team.internal.ccvs.ui.repo.RemoteViewPart.getContentProvider()org.eclipse.team.internal.ccvs.ui.model.RemoteContentProvider;1
public RemoteContentProvider getContentProvider() {
    if (contentProvider == null) {
        contentProvider = new  RemoteContentProvider();
    }
    return contentProvider;
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.getTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;1
protected PreferenceTransferElement[] getTransfers() {
    if (transfers == null) {
        transfers = PreferenceTransferManager.getPreferenceTransfers();
    }
    return transfers;
}
method: org.eclipse.ui.internal.preferences.PreferenceTransferManager.getPreferenceTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;0
public static PreferenceTransferElement[] getPreferenceTransfers() {
    return new  PreferenceTransferRegistryReader(IWorkbenchRegistryConstants.PL_PREFERENCE_TRANSFER).getPreferenceTransfers();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.manipulation.JavaManipulationPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.Openable.getBufferFactory()org.eclipse.jdt.core.IBufferFactory;1
public IBufferFactory getBufferFactory() {
    return getBufferManager().getDefaultBufferFactory();
}
method: org.eclipse.jdt.internal.core.Openable.getBufferManager()org.eclipse.jdt.internal.core.BufferManager;1
protected BufferManager getBufferManager() {
    return BufferManager.getDefaultBufferManager();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSPropertyFileModifier.getFileHandle(org.eclipse.core.runtime.IPath;)org.eclipse.core.resources.IFile;1
private static IFile getFileHandle(IPath propertyFilePath) {
    if (propertyFilePath == null)
        return null;
    return ResourcesPlugin.getWorkspace().getRoot().getFile(propertyFilePath);
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setFilter(java.lang.String;)V2
public void setFilter(String filter) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fFilter;
    this.fFilter = filter;
    firePropertyChanged(P_FILTER, oldValue, filter);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.internal.cheatsheets.views.ViewItem.getSkipImage()org.eclipse.swt.graphics.Image;1
Image getSkipImage() {
    return CheatSheetPlugin.getPlugin().getImage(ICheatSheetResource.CHEATSHEET_ITEM_SKIP);
}
method: org.eclipse.ui.internal.cheatsheets.CheatSheetPlugin.getImage(java.lang.String;)org.eclipse.swt.graphics.Image;2
public Image getImage(String key) {
    Image image = getImageRegistry().get(key);
    return image;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.ui.internal.markers.ApiQuickFixProcessor$UnknownAnnotationQuickFix.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return ApiUIPlugin.getSharedImage(IApiToolsConstants.IMG_OBJ_CHANGE_CORRECTION);
}
method: org.eclipse.pde.api.tools.ui.internal.ApiUIPlugin.getSharedImage(java.lang.String;)org.eclipse.swt.graphics.Image;1
public static Image getSharedImage(String key) {
    return getDefault().getImageRegistry().get(key);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.registry.TeamContentProviderDescriptor.getParentPreferences()org.osgi.service.prefs.Preferences;1
public Preferences getParentPreferences() {
    return TeamUIPlugin.getPlugin().getInstancePreferences().node(PREF_TEAM_CONTENT_DESCRIPTORS);
}
method: org.eclipse.team.internal.ui.TeamUIPlugin.getInstancePreferences()org.osgi.service.prefs.Preferences;1
public org.osgi.service.prefs.Preferences getInstancePreferences() {
    return InstanceScope.INSTANCE.getNode(getBundle().getSymbolicName());
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberChangeSetManager.getParentPreferences()org.osgi.service.prefs.Preferences;0
private static Preferences getParentPreferences() {
    return getTeamPreferences().node(PREF_CHANGE_SETS);
}
method: org.eclipse.team.internal.core.subscribers.SubscriberChangeSetManager.getTeamPreferences()org.osgi.service.prefs.Preferences;0
private static Preferences getTeamPreferences() {
    return InstanceScope.INSTANCE.getNode(TeamPlugin.getPlugin().getBundle().getSymbolicName());
}

---------------Library-------------------
method: org.eclipse.team.ui.synchronize.TeamStateProvider.getDecoratorId(java.lang.String;)java.lang.String;2
private String getDecoratorId(String providerId) {
    TeamDecoratorDescription decoratorDescription = TeamDecoratorManager.getInstance().getDecoratorDescription(providerId);
    if (decoratorDescription != null)
        return decoratorDescription.getDecoratorId();
    return null;
}
method: org.eclipse.team.internal.ui.registry.TeamDecoratorDescription.getDecoratorId()java.lang.String;1
public String getDecoratorId() {
    return decoratorId;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}

---------------Library-------------------
method: org.eclipse.ui.internal.editors.text.SelectResourcesBlock.treeExpanded(org.eclipse.jface.viewers.TreeExpansionEvent;)V2
public void treeExpanded(TreeExpansionEvent event) {
    expandTreeElement(event.getElement());
}
method: org.eclipse.ui.internal.editors.text.SelectResourcesBlock.expandTreeElement(java.lang.Object;)V2
private void expandTreeElement(final Object element) {
    BusyIndicator.showWhile(treeViewer.getControl().getDisplay(), new  Runnable() {

        public void run() {
            if (expandedTreeNodes.contains(element))
                checkNewTreeElements(treeContentProvider.getChildren(element));
            else {
                expandedTreeNodes.add(element);
                if (whiteCheckedTreeItems.contains(element)) {
                    Object[] children = treeContentProvider.getChildren(element);
                    for (int i = 0; i < children.length; ++i) {
                        if (!whiteCheckedTreeItems.contains(children[i])) {
                            Object child = children[i];
                            setWhiteChecked(child, true);
                            treeViewer.setChecked(child, true);
                            checkedStateStore.put(child, new  ArrayList());
                        }
                    }
                    setListForWhiteSelection(element);
                }
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoriesView$1.repositoriesChanged(Aorg.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;)V2
public void repositoriesChanged(ICVSRepositoryLocation[] roots) {
    refresh();
}
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoriesView$1.refresh()V1
private void refresh() {
    Display display = getViewer().getControl().getDisplay();
    display.asyncExec(new  Runnable() {

        public void run() {
            RepositoriesView.this.refreshViewer();
        }
    });
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.navigator.JavaNavigatorContentProvider.dispose()V1
@Override
public void dispose() {
    super.dispose();
    fStateModel.removePropertyChangeListener(fLayoutPropertyListener);
}
method: org.eclipse.ui.internal.navigator.extensions.ExtensionStateModel.removePropertyChangeListener(org.eclipse.jface.util.IPropertyChangeListener;)V2
public void removePropertyChangeListener(IPropertyChangeListener aListener) {
    removeListenerObject(aListener);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AccessRuleEntryDialog$TypeRulesAdapter.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    doStatusLineUpdate();
}
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AccessRuleEntryDialog.doStatusLineUpdate()V1
protected void doStatusLineUpdate() {
    checkIfPatternValid();
    updateStatus(fPatternStatus);
}

---------------Library-------------------
method: org.eclipse.jetty.io.nio.SelectChannelEndPoint.cancelTimeout(org.eclipse.jetty.util.thread.Timeout$Task;)V2
public void cancelTimeout(Task task) {
    getSelectSet().cancelTimeout(task);
}
method: org.eclipse.jetty.io.nio.SelectorManager$SelectSet.cancelTimeout(org.eclipse.jetty.util.thread.Timeout$Task;)V2
public void cancelTimeout(Timeout.Task task) {
    task.cancel();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.CheckedListDialogField.checkStateChanged()V1
private void checkStateChanged() {
    super.dialogFieldChanged();
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField.dialogFieldChanged()V1
@Override
public void dialogFieldChanged() {
    super.dialogFieldChanged();
    updateButtonState();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setImageName(java.lang.String;)V2
public void setImageName(String imageName) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fImageName;
    this.fImageName = imageName;
    firePropertyChanged(P_IMAGE, oldValue, imageName);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.views.tasklist.TaskListContentProvider.dispose()V1
public void dispose() {
    if (input != null) {
        input.getWorkspace().removeResourceChangeListener(this);
        input = null;
    }
}
method: org.eclipse.core.internal.resources.Workspace.removeResourceChangeListener(org.eclipse.core.resources.IResourceChangeListener;)V2
public void removeResourceChangeListener(IResourceChangeListener listener) {
    notificationManager.removeListener(listener);
}
---------------Client-------------------
method: org.apache.lucene.index.StoredFieldsWriterPerThread.abort()V1
public void abort() {
    if (doc != null) {
        doc.abort();
        doc = null;
    }
}
method: org.apache.lucene.index.StoredFieldsWriter$PerDoc.abort()V1
@Override
void abort() {
    reset();
    free(this);
}

---------------Library-------------------
method: org.eclipse.help.internal.base.HelpBasePlugin.logStatus(org.eclipse.core.runtime.IStatus;)V1
public static synchronized void logStatus(IStatus errorStatus) {
    HelpBasePlugin.getDefault().getLog().log(errorStatus);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.ui.internal.AggregateWorkingSet.setComponents(Aorg.eclipse.ui.IWorkingSet;)V2
void setComponents(IWorkingSet[] components) {
    internalSetComponents(components);
    constructElements(true);
}
method: org.eclipse.ui.internal.AggregateWorkingSet.internalSetComponents(Aorg.eclipse.ui.IWorkingSet;)V2
private void internalSetComponents(IWorkingSet[] components) {
    this.components = components;
}
---------------Client-------------------
method: org.apache.lucene.index.IndexWriter.setPayloadProcessorProvider(org.apache.lucene.index.PayloadProcessorProvider;)V2
public void setPayloadProcessorProvider(PayloadProcessorProvider pcp) {
    ensureOpen();
    payloadProcessorProvider = pcp;
}
method: org.apache.lucene.index.IndexWriter.ensureOpen()V1
protected final void ensureOpen() throws AlreadyClosedException {
    ensureOpen(true);
}

---------------Library-------------------
method: org.eclipse.ui.editors.text.EditorsUI.getHyperlinkDetectorRegistry()org.eclipse.ui.texteditor.HyperlinkDetectorRegistry;0
public static HyperlinkDetectorRegistry getHyperlinkDetectorRegistry() {
    return EditorsPlugin.getDefault().getHyperlinkDetectorRegistry();
}
method: org.eclipse.ui.internal.editors.text.EditorsPlugin.getHyperlinkDetectorRegistry()org.eclipse.ui.texteditor.HyperlinkDetectorRegistry;1
public synchronized HyperlinkDetectorRegistry getHyperlinkDetectorRegistry() {
    if (fHyperlinkDetectorRegistry == null)
        fHyperlinkDetectorRegistry = new  HyperlinkDetectorRegistry(getPreferenceStore());
    return fHyperlinkDetectorRegistry;
}
---------------Client-------------------
method: org.eclipse.compare.CompareConfiguration.getResourceManager()org.eclipse.jface.resource.ResourceManager;1
private synchronized ResourceManager getResourceManager() {
    if (fResourceManager == null) {
        fResourceManager = new  LocalResourceManager(JFaceResources.getResources());
    }
    return fResourceManager;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteCategory.setName(java.lang.String;)V2
public void setName(String name) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.name;
    this.name = name;
    firePropertyChanged(P_NAME, oldValue, name);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.frameworkadmin.equinox.EclipseLauncherParser.getFrameworkJar(java.util.List;java.net.URI;org.eclipse.equinox.internal.provisional.frameworkadmin.LauncherData;)V4
private void getFrameworkJar(List<String> lines, URI launcherFolder, LauncherData launcherData) {
    File fwJar = launcherData.getFwJar();
    if (fwJar != null)
        return;
    URI location = ParserUtils.getFrameworkJar(lines, launcherFolder);
    if (location != null)
        launcherData.setFwJar(URIUtil.toFile(location));
}
method: org.eclipse.equinox.internal.provisional.frameworkadmin.LauncherData.setFwJar(java.io.File;)V2
public void setFwJar(File fwJar) {
    this.fwJar = fwJar;
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.history.RefactoringPropertyPage.setVisible(Z)V2
public void setVisible(final boolean visible) {
    fHasProjectHistory = hasSharedRefactoringHistory();
    super.setVisible(visible);
}
method: org.eclipse.ltk.internal.ui.refactoring.history.RefactoringPropertyPage.hasSharedRefactoringHistory()Z1
private boolean hasSharedRefactoringHistory() {
    final IProject project = getCurrentProject();
    if (project != null)
        return RefactoringHistoryService.hasSharedRefactoringHistory(project);
    return false;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.templates.TemplatesPageImages.getDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getDescriptor(String key) {
    return getImageRegistry().getDescriptor(key);
}
method: org.eclipse.jface.resource.ImageRegistry.getDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public ImageDescriptor getDescriptor(String key) {
    Entry entry = getEntry(key);
    if (entry == null) {
        return null;
    }
    return entry.descriptor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.CrossPlatformExportPage$PlatformPart.updateCounter(I)V2
@Override
public void updateCounter(int count) {
    super.updateCounter(count);
    pageChanged();
}
method: org.eclipse.pde.internal.ui.parts.WizardCheckboxTablePart.updateCounter(I)V2
protected void updateCounter(int amount) {
    counter = amount;
    updateCounterLabel();
}
---------------Client-------------------
method: org.eclipse.jface.text.MarginPainter.setMarginRulerColumn(I)V2
public void setMarginRulerColumn(int width) {
    fMarginWidth = width;
    initialize();
}
method: org.eclipse.jface.text.MarginPainter.initialize()V1
public void initialize() {
    computeWidgetX();
    fTextWidget.redraw();
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareUIPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.FieldAccess;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(FieldAccess node, ITypeBinding type) {
    Expression exp = node.getExpression();
    if (exp == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        exp = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, FieldAccess.EXPRESSION_PROPERTY, exp, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else if (exp instanceof Name) {
        rewriteName((Name) exp, type);
    } else {
        rewriteExpression(node, exp, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.dom.ASTNodeFactory.newName(org.eclipse.jdt.core.dom.AST;java.lang.String;)org.eclipse.jdt.core.dom.Name;2
public static Name newName(AST ast, String qualifiedName) {
    return ast.newName(qualifiedName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.MethodInvocation;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(MethodInvocation node, ITypeBinding type) {
    Expression exp = node.getExpression();
    if (exp == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        exp = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, MethodInvocation.EXPRESSION_PROPERTY, exp, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else if (exp instanceof Name) {
        rewriteName((Name) exp, type);
    } else {
        rewriteExpression(node, exp, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.CompilationUnitRewrite.getAST()org.eclipse.jdt.core.dom.AST;1
public AST getAST() {
    return getRoot().getAST();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.Site.setDigestURL(java.lang.String;)V2
public void setDigestURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.digestUrl;
    this.digestUrl = url;
    firePropertyChanged(P_DIGEST_URL, oldValue, url);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.core.variables.VariablesPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.pde.core.plugin.PluginRegistry.findModel(java.lang.String;)org.eclipse.pde.core.plugin.IPluginModelBase;1
public static IPluginModelBase findModel(String id) {
    return PDECore.getDefault().getModelManager().findModel(id);
}
method: org.eclipse.pde.internal.core.PDECore.getModelManager()org.eclipse.pde.internal.core.PluginModelManager;1
public PluginModelManager getModelManager() {
    return PluginModelManager.getInstance();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.ExecutionEnvironmentSection$1.linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent;)V2
public void linkActivated(HyperlinkEvent e) {
    SWTFactory.showPreferencePage(PDEPlugin.getActiveWorkbenchShell(), "org.eclipse.jdt.debug.ui.jreProfiles", null);
}
method: org.eclipse.pde.internal.ui.SWTFactory.showPreferencePage(org.eclipse.swt.widgets.Shell;java.lang.String;java.lang.Object;)I3
public static int showPreferencePage(Shell shell, String id, Object data) {
    return PreferencesUtil.createPreferenceDialogOn(shell, id, new String[] { id }, data).open();
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.actions.ViewManagementAction.run(org.eclipse.jface.action.IAction;)V2
@Override
public void run(IAction action) {
    SWTFactory.showPreferencePage("org.eclipse.debug.ui.ViewManagementPreferencePage");
}
method: org.eclipse.debug.internal.ui.SWTFactory.showPreferencePage(java.lang.String;)V1
public static void showPreferencePage(String id) {
    PreferencesUtil.createPreferenceDialogOn(DebugUIPlugin.getShell(), id, new String[] { id }, null).open();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.wizards.NewTestCaseCreationWizard.initializeDefaultPageImageDescriptor()V1
@Override
protected void initializeDefaultPageImageDescriptor() {
    setDefaultPageImageDescriptor(JUnitPlugin.getImageDescriptor("wizban/newtest_wiz.png"));
}
method: org.eclipse.jface.wizard.Wizard.setDefaultPageImageDescriptor(org.eclipse.jface.resource.ImageDescriptor;)V2
public void setDefaultPageImageDescriptor(ImageDescriptor imageDescriptor) {
    defaultImageDescriptor = imageDescriptor;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Link$2.getDefaultAction(org.eclipse.swt.accessibility.AccessibleControlEvent;)V2
@Override
public void getDefaultAction(AccessibleControlEvent e) {
    e.result = SWT.getMessage("SWT_Press");
}
method: org.eclipse.swt.SWT.getMessage(java.lang.String;)java.lang.String;1
public static String getMessage(String key) {
    return Compatibility.getMessage(key);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.undo.ProjectDescription.createResourceHandle()org.eclipse.core.resources.IResource;1
public IResource createResourceHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getProject(getName());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.team.internal.core.subscribers.BatchingLock.resourceChanged(org.eclipse.core.resources.IResource;)V2
public void resourceChanged(IResource resource) {
    ThreadInfo info = getThreadInfo();
    Assert.isNotNull(info, "Folder changed outside of resource lock");
    info.addChangedResource(resource);
}
method: org.eclipse.team.internal.core.subscribers.BatchingLock$ThreadInfo.addChangedResource(org.eclipse.core.resources.IResource;)V2
public void addChangedResource(IResource resource) {
    changedResources.add(resource);
}
---------------Client-------------------
method: org.eclipse.jface.text.templates.TemplateContextType.removeResolver(org.eclipse.jface.text.templates.TemplateVariableResolver;)V2
public void removeResolver(TemplateVariableResolver resolver) {
    Assert.isNotNull(resolver);
    fResolvers.remove(resolver.getType());
}
method: org.eclipse.core.runtime.Assert.isNotNull(java.lang.Object;)V1
public static void isNotNull(Object object) {
    isNotNull(object, "");
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ExtractInterfaceWizard$ExtractInterfaceInputPage$10.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    processor.setAbstract(fDeclareAbstractCheckbox.getSelection());
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.ExtractInterfaceProcessor.setAbstract(Z)V2
public final void setAbstract(final boolean declare) {
    fAbstract = declare;
}
---------------Client-------------------
method: org.eclipse.swt.custom.StyledText$12.getCharacterCount(org.eclipse.swt.accessibility.AccessibleTextEvent;)V2
@Override
public void getCharacterCount(AccessibleTextEvent e) {
    e.count = StyledText.this.getCharCount();
}
method: org.eclipse.swt.custom.StyledText.getCharCount()I1
public int getCharCount() {
    checkWidget();
    return content.getCharCount();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.FindBrokenNLSKeysAction.getCompilationUnit(org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;)org.eclipse.jdt.core.ICompilationUnit;1
private static ICompilationUnit getCompilationUnit(JavaEditor editor) {
    IWorkingCopyManager manager = JavaPlugin.getDefault().getWorkingCopyManager();
    ICompilationUnit cu = manager.getWorkingCopy(editor.getEditorInput());
    return cu;
}
method: org.eclipse.ui.part.EditorPart.getEditorInput()org.eclipse.ui.IEditorInput;1
@Override
public IEditorInput getEditorInput() {
    return editorInput;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.PullUpMethodPage.initializeRefactoring()V1
private void initializeRefactoring() {
    fProcessor.setDeletedMethods(getCheckedMethods());
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.PullUpRefactoringProcessor.setDeletedMethods(Aorg.eclipse.jdt.core.IMethod;)V2
public void setDeletedMethods(final IMethod[] methods) {
    Assert.isNotNull(methods);
    fDeletedMethods = methods;
}
---------------Client-------------------
method: org.eclipse.jface.text.MarginPainter.setMarginRulerColumn(I)V2
public void setMarginRulerColumn(int width) {
    fMarginWidth = width;
    initialize();
}
method: org.eclipse.jface.text.MarginPainter.initialize()V1
public void initialize() {
    computeWidgetX();
    fTextWidget.redraw();
}

---------------Library-------------------
method: org.eclipse.search.core.text.TextSearchScope.newSearchScope(Aorg.eclipse.core.resources.IResource;java.util.regex.Pattern;Z)org.eclipse.search.core.text.TextSearchScope;3
public static TextSearchScope newSearchScope(IResource[] rootResources, Pattern fileNamePattern, boolean visitDerivedResources) {
    FileNamePatternSearchScope scope = FileNamePatternSearchScope.newSearchScope(new  String(), rootResources, visitDerivedResources);
    scope.setFileNamePattern(fileNamePattern);
    return scope;
}
method: org.eclipse.search.internal.core.text.FileNamePatternSearchScope.newSearchScope(java.lang.String;Aorg.eclipse.core.resources.IResource;Z)org.eclipse.search.internal.core.text.FileNamePatternSearchScope;3
public static FileNamePatternSearchScope newSearchScope(String description, IResource[] resources, boolean includeDerived) {
    return new  FileNamePatternSearchScope(description, removeRedundantEntries(resources, includeDerived), includeDerived);
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parsePropertyValue(java.lang.String;)org.w3c.dom.css.CSSValue;2
@Override
public CSSValue parsePropertyValue(String value) throws IOException {
    Reader reader = new  StringReader(value);
    return parsePropertyValue(reader);
}
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parsePropertyValue(java.io.Reader;)org.w3c.dom.css.CSSValue;2
@Override
public CSSValue parsePropertyValue(Reader reader) throws IOException {
    InputSource source = new  InputSource();
    source.setCharacterStream(reader);
    return parsePropertyValue(source);
}

---------------Library-------------------
method: org.apache.commons.logging.LogFactory.getLog(java.lang.Class;)org.apache.commons.logging.Log;1
public static Log getLog(Class clazz) throws LogConfigurationException {
    return (getFactory().getInstance(clazz));
}
method: org.apache.commons.logging.impl.LogFactoryImpl.getInstance(java.lang.Class;)org.apache.commons.logging.Log;2
public Log getInstance(Class clazz) throws LogConfigurationException {
    return (getInstance(clazz.getName()));
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.LocationValidator.toString(java.net.URI;)java.lang.String;2
private String toString(URI uri) {
    try {
        return EFS.getStore(uri).toString();
    } catch (CoreException e) {
        return uri.toString();
    }
}
method: org.eclipse.core.filesystem.EFS.getStore(java.net.URI;)org.eclipse.core.filesystem.IFileStore;1
public static IFileStore getStore(URI uri) throws CoreException {
    return InternalFileSystemCore.getInstance().getStore(uri);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.jres.JREsPreferencePage.getJavaModel()org.eclipse.jdt.core.IJavaModel;1
protected IJavaModel getJavaModel() {
    return JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.history.RefactoringHistoryErrorPage.createControl(org.eclipse.swt.widgets.Composite;)V2
public void createControl(final Composite parent) {
    super.createControl(parent);
    fViewer.setFilter(fFilter);
}
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringStatusViewer.setFilter(org.eclipse.ltk.internal.ui.refactoring.RefactoringStatusEntryFilter;)V2
public void setFilter(final RefactoringStatusEntryFilter filter) {
    fFilter = filter;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.setRoot(java.lang.Object;)V2
public void setRoot(Object newRoot) {
    this.fRoot = newRoot;
    initialize();
}
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.initialize()V1
protected void initialize() {
    fTreeViewer.setInput(fRoot);
}

---------------Library-------------------
method: org.eclipse.ui.ide.undo.AbstractWorkspaceOperation.getUndoSchedulingRule()org.eclipse.core.runtime.jobs.ISchedulingRule;1
protected ISchedulingRule getUndoSchedulingRule() {
    return getWorkspace().getRoot();
}
method: org.eclipse.ui.ide.undo.AbstractWorkspaceOperation.getWorkspace()org.eclipse.core.resources.IWorkspace;1
protected IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.FeatureExportWizardPage.getListElements()Ajava.lang.Object;1
public Object[] getListElements() {
    FeatureModelManager manager = PDECore.getDefault().getFeatureModelManager();
    return manager.getWorkspaceModels();
}
method: org.eclipse.pde.internal.core.PDECore.getFeatureModelManager()org.eclipse.pde.internal.core.FeatureModelManager;1
public synchronized FeatureModelManager getFeatureModelManager() {
    if (fFeatureModelManager == null)
        fFeatureModelManager = new  FeatureModelManager();
    return fFeatureModelManager;
}
---------------Client-------------------
method: org.eclipse.compare.CompareConfiguration.getResourceManager()org.eclipse.jface.resource.ResourceManager;1
private synchronized ResourceManager getResourceManager() {
    if (fResourceManager == null) {
        fResourceManager = new  LocalResourceManager(JFaceResources.getResources());
    }
    return fResourceManager;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.JavadocConfigurationBlock.setFocus()V1
public void setFocus() {
    fURLField.postSetFocusOnDialogField(fShell.getDisplay());
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField.postSetFocusOnDialogField(org.eclipse.swt.widgets.Display;)V2
public void postSetFocusOnDialogField(Display display) {
    if (display != null) {
        display.asyncExec(new  Runnable() {

            public void run() {
                setFocus();
            }
        });
    }
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.map.ComputedObservableMap$2.handleStale(org.eclipse.core.databinding.observable.StaleEvent;)V2
public void handleStale(StaleEvent staleEvent) {
    fireStale();
}
method: org.eclipse.core.databinding.observable.map.AbstractObservableMap.fireStale()V1
protected void fireStale() {
    checkRealm();
    changeSupport.fireEvent(new  StaleEvent(this));
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFolder.setTag(org.eclipse.team.internal.ccvs.core.CVSTag;)V2
public void setTag(CVSTag tag) {
    MutableFolderSyncInfo newInfo = folderInfo.cloneMutable();
    newInfo.setTag(tag);
    setFolderSyncInfo(newInfo);
}
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFolder.setFolderSyncInfo(org.eclipse.team.internal.ccvs.core.syncinfo.FolderSyncInfo;)V2
public void setFolderSyncInfo(FolderSyncInfo folderInfo) {
    this.folderInfo = folderInfo.asImmutable();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.ImportPage.setDestinationValue(java.lang.String;)V2
@Override
protected void setDestinationValue(String selectedFileName) {
    oldDestination = getDestinationValue();
    super.setDestinationValue(selectedFileName);
}
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.AbstractPage.getDestinationValue()java.lang.String;1
protected String getDestinationValue() {
    return destinationNameField.getText().trim();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFolder.setTag(org.eclipse.team.internal.ccvs.core.CVSTag;)V2
public void setTag(CVSTag tag) {
    MutableFolderSyncInfo newInfo = folderInfo.cloneMutable();
    newInfo.setTag(tag);
    setFolderSyncInfo(newInfo);
}
method: org.eclipse.team.internal.ccvs.core.syncinfo.MutableFolderSyncInfo.setTag(org.eclipse.team.internal.ccvs.core.CVSTag;)V2
public void setTag(CVSTag tag) {
    super.setTag(tag);
}
---------------Client-------------------
method: org.eclipse.pde.internal.runtime.registry.RegistryFilteredTree.updateToolbar(Z)V2
protected void updateToolbar(boolean visible) {
    super.updateToolbar(visible);
    browser.updateTitle();
}
method: org.eclipse.pde.internal.runtime.registry.RegistryBrowser.updateTitle()V1
public void updateTitle() {
    setContentDescription(getTitleSummary());
}

---------------Library-------------------
method: org.eclipse.team.ui.synchronize.WorkingSetScope.setWorkingSets(Aorg.eclipse.ui.IWorkingSet;)V2
protected void setWorkingSets(IWorkingSet[] sets) {
    this.sets = sets;
    PlatformUI.getWorkbench().getWorkingSetManager().addPropertyChangeListener(this);
}
method: org.eclipse.ui.internal.AbstractWorkingSetManager.addPropertyChangeListener(org.eclipse.jface.util.IPropertyChangeListener;)V2
@Override
public void addPropertyChangeListener(IPropertyChangeListener listener) {
    addListenerObject(listener);
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.dialogs.BuildOrderPreferencePage.init(org.eclipse.ui.IWorkbench;)V2
public void init(IWorkbench workbench) {
    this.workbench = workbench;
    setPreferenceStore(PrefUtil.getInternalPreferenceStore());
}
method: org.eclipse.ui.internal.util.PrefUtil.getInternalPreferenceStore()org.eclipse.jface.preference.IPreferenceStore;0
public static IPreferenceStore getInternalPreferenceStore() {
    return WorkbenchPlugin.getDefault().getPreferenceStore();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteArchive.setURL(java.lang.String;)V2
public void setURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.url;
    this.url = url;
    firePropertyChanged(P_URL, oldValue, url);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.console.MessageConsole.createPage(org.eclipse.ui.console.IConsoleView;)org.eclipse.ui.part.IPageBookViewPage;2
@Override
public IPageBookViewPage createPage(IConsoleView view) {
    IOConsolePage page = (IOConsolePage) super.createPage(view);
    page.setReadOnly();
    return page;
}
method: org.eclipse.ui.console.IOConsole.createPage(org.eclipse.ui.console.IConsoleView;)org.eclipse.ui.part.IPageBookViewPage;2
@Override
public IPageBookViewPage createPage(IConsoleView view) {
    return new  IOConsolePage(this, view);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.JavaEditorBreadcrumb.createContextMenuActionGroup(org.eclipse.jface.viewers.ISelectionProvider;)org.eclipse.ui.actions.ActionGroup;2
@Override
protected ActionGroup createContextMenuActionGroup(ISelectionProvider selectionProvider) {
    return new  JavaEditorBreadcrumbActionGroup(getJavaEditor(), selectionProvider);
}
method: org.eclipse.jdt.internal.ui.javaeditor.JavaEditorBreadcrumb.getJavaEditor()org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;1
private JavaEditor getJavaEditor() {
    return (JavaEditor) getTextEditor();
}

---------------Library-------------------
method: org.eclipse.core.internal.plugins.PluginDescriptor.getExtensions()Aorg.eclipse.core.runtime.IExtension;1
public IExtension[] getExtensions() {
    return org.eclipse.core.internal.runtime.InternalPlatform.getDefault().getRegistry().getExtensions(getId());
}
method: org.eclipse.core.internal.runtime.InternalPlatform.getRegistry()org.eclipse.core.runtime.IExtensionRegistry;1
public IExtensionRegistry getRegistry() {
    return RegistryFactory.getRegistry();
}
---------------Client-------------------
method: org.eclipse.help.HelpSystem.getIndex()org.eclipse.help.IIndex;0
public static IIndex getIndex() {
    return HelpPlugin.getIndexManager().getIndex(Platform.getNL());
}
method: org.eclipse.core.runtime.Platform.getNL()java.lang.String;0
public static String getNL() {
    return InternalPlatform.getDefault().getNL();
}

---------------Library-------------------
method: org.eclipse.team.core.variants.PersistantResourceVariantByteStore.dispose()V1
public void dispose() {
    getSynchronizer().remove(getSyncName());
}
method: org.eclipse.team.core.variants.PersistantResourceVariantByteStore.getSynchronizer()org.eclipse.core.resources.ISynchronizer;1
private ISynchronizer getSynchronizer() {
    return ResourcesPlugin.getWorkspace().getSynchronizer();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.JavaAttributeWizard.selectAndReveal(org.eclipse.core.resources.IResource;)V2
protected void selectAndReveal(IResource newResource) {
    BasicNewResourceWizard.selectAndReveal(newResource, PDEPlugin.getActiveWorkbenchWindow());
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getActiveWorkbenchWindow()org.eclipse.ui.IWorkbenchWindow;0
public static IWorkbenchWindow getActiveWorkbenchWindow() {
    return getDefault().getWorkbench().getActiveWorkbenchWindow();
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Workspace.getDescription()org.eclipse.core.resources.IWorkspaceDescription;1
public IWorkspaceDescription getDescription() {
    WorkspaceDescription workingCopy = defaultWorkspaceDescription();
    description.copyTo(workingCopy);
    return workingCopy;
}
method: org.eclipse.core.internal.resources.WorkspacePreferences.copyTo(org.eclipse.core.internal.resources.WorkspaceDescription;)V2
public void copyTo(WorkspaceDescription target) {
    copyFromTo(this, target);
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.ui.internal.application.CompatibilityWorkbenchWindowAdvisor.preWindowShellClose()Z1
@Override
public boolean preWindowShellClose() {
    return wbAdvisor.preWindowShellClose(getWindowConfigurer());
}
method: org.eclipse.ui.application.WorkbenchAdvisor.preWindowShellClose(org.eclipse.ui.application.IWorkbenchWindowConfigurer;)Z2
@Deprecated
public boolean preWindowShellClose(IWorkbenchWindowConfigurer configurer) {
    return true;
}
---------------Client-------------------
method: org.eclipse.ui.wizards.datatransfer.ZipFileImportWizard.performCancel()Z1
public boolean performCancel() {
    return mainPage.cancel();
}
method: org.eclipse.ui.internal.wizards.datatransfer.WizardArchiveFileResourceImportPage1.cancel()Z1
public boolean cancel() {
    disposeStructureProvider();
    return true;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.ToolBarElement.item(I)org.w3c.dom.Node;2
@Override
public Node item(int index) {
    return getElement(getToolBar().getItem(index));
}
method: org.eclipse.e4.ui.css.core.dom.ElementAdapter.getElement(java.lang.Object;)org.w3c.dom.Element;2
protected Element getElement(Object widget) {
    return engine.getElement(widget);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CreatePackageDeclarationOperation.generateResultHandle()org.eclipse.jdt.core.IJavaElement;1
protected IJavaElement generateResultHandle() {
    return getCompilationUnit().getPackageDeclaration(this.name);
}
method: org.eclipse.jdt.internal.core.CreateElementInCUOperation.getCompilationUnit()org.eclipse.jdt.core.ICompilationUnit;1
protected ICompilationUnit getCompilationUnit() {
    return getCompilationUnitFor(getParentElement());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.actions.breakpoints.EnableBreakpointsAction.dispose()V1
public void dispose() {
    DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
    getView().getViewSite().getPage().removePartListener(this);
}
method: org.eclipse.debug.internal.ui.actions.breakpoints.EnableBreakpointsAction.getView()org.eclipse.ui.IViewPart;1
protected IViewPart getView() {
    return fView;
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.CommonViewerAdvisor.dispose()V1
public void dispose() {
    TeamUI.getTeamContentProviderManager().removePropertyChangeListener(this);
    getConfiguration().removePropertyChangeListener(this);
    actionService.dispose();
    super.dispose();
}
method: org.eclipse.team.ui.TeamUI.getTeamContentProviderManager()org.eclipse.team.ui.mapping.ITeamContentProviderManager;0
public static ITeamContentProviderManager getTeamContentProviderManager() {
    return TeamContentProviderManager.getInstance();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.Activator.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    if (status != null)
        ResourcesPlugin.getPlugin().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.launching.JavaRuntime.substitute(java.lang.String;)java.lang.String;1
private static String substitute(String expression) throws CoreException {
    return VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(expression);
}
method: org.eclipse.core.internal.variables.StringVariableManager.performStringSubstitution(java.lang.String;)java.lang.String;2
@Override
public String performStringSubstitution(String expression) throws CoreException {
    return performStringSubstitution(expression, true);
}
---------------Client-------------------
method: org.eclipse.core.runtime.Platform.getPluginStateLocation(org.eclipse.core.runtime.Plugin;)org.eclipse.core.runtime.IPath;1
@Deprecated
public static IPath getPluginStateLocation(Plugin plugin) {
    return plugin.getStateLocation();
}
method: org.eclipse.core.runtime.Plugin.getStateLocation()org.eclipse.core.runtime.IPath;1
public final IPath getStateLocation() throws IllegalStateException {
    return InternalPlatform.getDefault().getStateLocation(getBundle(), true);
}

---------------Library-------------------
method: org.eclipse.jdt.launching.JavaRuntime.substitute(java.lang.String;)java.lang.String;1
private static String substitute(String expression) throws CoreException {
    return VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(expression);
}
method: org.eclipse.core.variables.VariablesPlugin.getStringVariableManager()org.eclipse.core.variables.IStringVariableManager;1
public IStringVariableManager getStringVariableManager() {
    return StringVariableManager.getDefault();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.ui.internal.ObjectActionContributorReader.readPopupContributors(org.eclipse.ui.internal.ObjectActionContributorManager;)V2
public void readPopupContributors(ObjectActionContributorManager mng) {
    setManager(mng);
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    readRegistry(registry, PlatformUI.PLUGIN_ID, IWorkbenchRegistryConstants.PL_POPUP_MENU);
}
method: org.eclipse.ui.internal.ObjectActionContributorReader.setManager(org.eclipse.ui.internal.ObjectActionContributorManager;)V2
public void setManager(ObjectActionContributorManager mng) {
    manager = mng;
}
---------------Client-------------------
method: org.eclipse.ui.internal.registry.EditorRegistryReader.addEditors(org.eclipse.ui.internal.registry.EditorRegistry;)V2
protected void addEditors(EditorRegistry registry) {
    IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
    this.editorRegistry = registry;
    readRegistry(extensionRegistry, PlatformUI.PLUGIN_ID, IWorkbenchRegistryConstants.PL_EDITOR);
}
method: org.eclipse.core.runtime.Platform.getExtensionRegistry()org.eclipse.core.runtime.IExtensionRegistry;0
public static IExtensionRegistry getExtensionRegistry() {
    return RegistryFactory.getRegistry();
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.WizardNewFolderMainPage.createFolderHandle(org.eclipse.core.runtime.IPath;)org.eclipse.core.resources.IFolder;2
protected IFolder createFolderHandle(IPath folderPath) {
    return IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getFolder(folderPath);
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}

---------------Library-------------------
method: org.eclipse.ltk.internal.core.refactoring.resource.undostates.ProjectUndoState.createResourceHandle()org.eclipse.core.resources.IResource;1
public IResource createResourceHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getProject(getName());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.ui.internal.cheatsheets.actions.CheatSheetMenuAction.dispose()V1
public void dispose() {
    setMenu(null);
    CheatSheetPlugin.getPlugin().getCheatSheetHistory().removeListener(this);
}
method: org.eclipse.ui.internal.cheatsheets.actions.CheatSheetMenuAction.setMenu(org.eclipse.swt.widgets.Menu;)V2
private void setMenu(Menu menu) {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fMenu = menu;
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.SynchronizePageDropDownAction.dispose()V1
public void dispose() {
    if (menuManager != null) {
        menuManager.dispose();
        menuManager = null;
    }
    TeamUI.getSynchronizeManager().removeSynchronizeParticipantListener(this);
}
method: org.eclipse.team.ui.TeamUI.getSynchronizeManager()org.eclipse.team.ui.synchronize.ISynchronizeManager;0
public static ISynchronizeManager getSynchronizeManager() {
    return TeamUIPlugin.getPlugin().getSynchronizeManager();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.feature.BasePluginListPage.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.jface.dialogs.DialogPage.dispose()V1
@Override
public void dispose() {
    if (image != null) {
        image.dispose();
        image = null;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.SynchronizePageDropDownAction.dispose()V1
public void dispose() {
    if (menuManager != null) {
        menuManager.dispose();
        menuManager = null;
    }
    TeamUI.getSynchronizeManager().removeSynchronizeParticipantListener(this);
}
method: org.eclipse.team.ui.TeamUI.getSynchronizeManager()org.eclipse.team.ui.synchronize.ISynchronizeManager;0
public static ISynchronizeManager getSynchronizeManager() {
    return TeamUIPlugin.getPlugin().getSynchronizeManager();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.IntroduceFactoryInputPage$2.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    boolean isChecked = protectCtorCB.getSelection();
    getUseFactoryRefactoring().setProtectConstructor(isChecked);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.IntroduceFactoryRefactoring.setProtectConstructor(Z)V2
public void setProtectConstructor(boolean protectConstructor) {
    fProtectConstructor = protectConstructor;
}
---------------Client-------------------
method: org.eclipse.swt.custom.StyledText$12.getCharacterCount(org.eclipse.swt.accessibility.AccessibleTextEvent;)V2
@Override
public void getCharacterCount(AccessibleTextEvent e) {
    e.count = StyledText.this.getCharCount();
}
method: org.eclipse.swt.custom.StyledText.getCharCount()I1
public int getCharCount() {
    checkWidget();
    return content.getCharCount();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.toc.TocTreeSection.makeNewTocTopic(org.eclipse.pde.internal.ua.core.toc.text.TocObject;org.eclipse.core.resources.IFile;)org.eclipse.pde.internal.ua.core.toc.text.TocTopic;3
private TocTopic makeNewTocTopic(TocObject parent, IFile file) {
    return fModel.getFactory().createTocTopic(file);
}
method: org.eclipse.pde.internal.ua.core.toc.text.TocDocumentFactory.createTocTopic(org.eclipse.core.resources.IFile;)org.eclipse.pde.internal.ua.core.toc.text.TocTopic;2
public TocTopic createTocTopic(IFile file) {
    return new  TocTopic(fModel, file);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.MarkerDelta.getMarker()org.eclipse.core.resources.IMarker;1
public IMarker getMarker() {
    return new  Marker(resource, getId());
}
method: org.eclipse.core.internal.resources.MarkerDelta.getId()J1
public long getId() {
    return info.getId();
}

---------------Library-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberSyncInfoCollector.setFilter(org.eclipse.team.core.synchronize.SyncInfoFilter;)V2
public void setFilter(SyncInfoFilter filter) {
    filteredInput.setFilter(filter);
    filteredInput.reset();
}
method: org.eclipse.team.internal.core.subscribers.SyncSetInput.setFilter(org.eclipse.team.core.synchronize.SyncInfoFilter;)V2
public void setFilter(SyncInfoFilter filter) {
    this.filter = filter;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$FileTextDragListener.dragSetData(org.eclipse.swt.dnd.DragSourceEvent;)V2
public void dragSetData(DragSourceEvent event) {
    event.data = element.getText();
}
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$ContentTypeElement.getText()java.lang.String;1
protected String getText() {
    return text.getText();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.AbstractPage$ImportExportFilteredTree.doCreateRefreshJob()org.eclipse.ui.progress.WorkbenchJob;1
@Override
protected WorkbenchJob doCreateRefreshJob() {
    WorkbenchJob job = super.doCreateRefreshJob();
    job.addJobChangeListener(new  JobChangeAdapter() {

        @Override
        public void aboutToRun(IJobChangeEvent event) {
            Display.getDefault().syncExec(new  Runnable() {

                public void run() {
                    Object[] checked = viewer.getCheckedElements();
                    if (checkState == null)
                        checkState = new  ArrayList<Object>(checked.length);
                    for (int i = 0; i < checked.length; i++) if (!viewer.getGrayed(checked[i]))
                        if (!checkState.contains(checked[i]))
                            checkState.add(checked[i]);
                }
            });
        }

        @Override
        public void done(IJobChangeEvent event) {
            if (event.getResult().isOK()) {
                Display.getDefault().asyncExec(new  Runnable() {

                    public void run() {
                        if (viewer == null || viewer.getTree().isDisposed())
                            return;
                        if (checkState == null)
                            return;
                        viewer.setCheckedElements(new Object[0]);
                        viewer.setGrayedElements(new Object[0]);
                        Iterator<Object> iter = checkState.iterator();
                        while (iter.hasNext()) {
                            viewer.setChecked(iter.next(), true);
                        }
                        updatePageCompletion();
                    }
                });
            }
        }
    });
    return job;
}
method: org.eclipse.core.runtime.jobs.Job.addJobChangeListener(org.eclipse.core.runtime.jobs.IJobChangeListener;)V2
@Override
public final void addJobChangeListener(IJobChangeListener listener) {
    super.addJobChangeListener(listener);
}
---------------Client-------------------
method: org.apache.lucene.index.IndexReader.getCommitUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> getCommitUserData(Directory directory) throws CorruptIndexException, IOException {
    return SegmentInfos.readCurrentUserData(directory);
}
method: org.apache.lucene.index.SegmentInfos.readCurrentUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> readCurrentUserData(Directory directory) throws CorruptIndexException, IOException {
    SegmentInfos sis = new  SegmentInfos();
    sis.read(directory);
    return sis.getUserData();
}

---------------Library-------------------
method: org.eclipse.jface.layout.GridDataFactory.generate(org.eclipse.swt.widgets.Control;II)V3
public static void generate(Control theControl, int hSpan, int vSpan) {
    defaultsFor(theControl).span(hSpan, vSpan).applyTo(theControl);
}
method: org.eclipse.jface.layout.GridDataFactory.applyTo(org.eclipse.swt.widgets.Control;)V2
public void applyTo(Control control) {
    control.setLayoutData(create());
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.setContents(org.eclipse.core.resources.IFile;org.eclipse.core.runtime.IProgressMonitor;)V3
public void setContents(IFile file, IProgressMonitor monitor) throws TeamException, CoreException {
    setContents(file.getContents(), monitor);
}
method: org.eclipse.core.internal.resources.File.getContents()java.io.InputStream;1
public InputStream getContents() throws CoreException {
    return getContents(getLocalManager().isLightweightAutoRefreshEnabled());
}

---------------Library-------------------
method: org.eclipse.ui.internal.application.CompatibilityWorkbenchWindowAdvisor.createWindowContents(org.eclipse.swt.widgets.Shell;)V2
@Override
public void createWindowContents(Shell shell) {
    wbAdvisor.createWindowContents(getWindowConfigurer(), shell);
}
method: org.eclipse.ui.application.WorkbenchAdvisor.createWindowContents(org.eclipse.ui.application.IWorkbenchWindowConfigurer;org.eclipse.swt.widgets.Shell;)V3
@Deprecated
public void createWindowContents(IWorkbenchWindowConfigurer configurer, Shell shell) {
    ((WorkbenchWindowConfigurer) configurer).createDefaultContents(shell);
}
---------------Client-------------------
method: org.eclipse.jface.internal.databinding.swt.CComboEditableProperty.doSetBooleanValue(java.lang.Object;Z)V3
void doSetBooleanValue(Object source, boolean value) {
    ((CCombo) source).setEditable(value);
}
method: org.eclipse.swt.custom.CCombo.setEditable(Z)V2
public void setEditable(boolean editable) {
    checkWidget();
    text.setEditable(editable);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setNL(java.lang.String;)V2
public void setNL(String nl) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fNl;
    this.fNl = nl;
    firePropertyChanged(P_NL, oldValue, nl);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.internal.dialogs.WorkbenchPreferenceNode.getCategory()java.lang.String;1
public String getCategory() {
    return getConfigurationElement().getAttribute(CategorizedPageRegistryReader.ATT_CATEGORY);
}
method: org.eclipse.core.internal.registry.ConfigurationElementHandle.getAttribute(java.lang.String;)java.lang.String;2
public String getAttribute(String propertyName) {
    return getConfigurationElement().getAttribute(propertyName);
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.set.AbstractObservableSet.toArray(Ajava.lang.Object;)Ajava.lang.Object;2
public Object[] toArray(Object[] a) {
    getterCalled();
    return getWrappedSet().toArray(a);
}
method: org.eclipse.core.databinding.observable.set.AbstractObservableSet.getterCalled()V1
protected void getterCalled() {
    ObservableTracker.getterCalled(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.PluginExtension.setPoint(java.lang.String;)V2
public void setPoint(String point) throws CoreException {
    ensureModelEditable();
    String oldValue = fPoint;
    fPoint = point;
    firePropertyChanged(P_POINT, oldValue, point);
}
method: org.eclipse.pde.internal.core.plugin.PluginObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.internal.util.BundleUtility.find(java.lang.String;java.lang.String;)java.net.URL;2
public static URL find(String bundleId, String path) {
    return find(Platform.getBundle(bundleId), path);
}
method: org.eclipse.ui.internal.util.BundleUtility.find(org.osgi.framework.Bundle;java.lang.String;)java.net.URL;2
public static URL find(Bundle bundle, String path) {
    if (bundle == null) {
        return null;
    }
    return Platform.find(bundle, new  Path(path));
}
---------------Client-------------------
method: org.apache.lucene.index.IndexReader.getCommitUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> getCommitUserData(Directory directory) throws CorruptIndexException, IOException {
    return SegmentInfos.readCurrentUserData(directory);
}
method: org.apache.lucene.index.SegmentInfos.readCurrentUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> readCurrentUserData(Directory directory) throws CorruptIndexException, IOException {
    SegmentInfos sis = new  SegmentInfos();
    sis.read(directory);
    return sis.getUserData();
}

---------------Library-------------------
method: org.eclipse.ui.help.WorkbenchHelp.setHelp(org.eclipse.jface.action.IAction;org.eclipse.ui.help.IContextComputer;)V2
@Deprecated
public static void setHelp(IAction action, final IContextComputer computer) {
    WorkbenchHelpSystem.getInstance().setHelp(action, computer);
}
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem.setHelp(org.eclipse.jface.action.IAction;org.eclipse.ui.help.IContextComputer;)V3
@Deprecated
public void setHelp(IAction action, final IContextComputer computer) {
    action.setHelpListener(new  HelpListener() {

        @Override
        public void helpRequested(HelpEvent event) {
            Object[] helpContexts = computer.computeContexts(event);
            if (helpContexts != null && helpContexts.length > 0 && getHelpUI() != null) {
                IContext context = null;
                if (helpContexts[0] instanceof String) {
                    context = HelpSystem.getContext((String) helpContexts[0]);
                } else if (helpContexts[0] instanceof IContext) {
                    context = (IContext) helpContexts[0];
                }
                if (context != null) {
                    Point point = computePopUpLocation(event.widget.getDisplay());
                    displayContext(context, point.x, point.y);
                }
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.internal.databinding.provisional.swt.SWTUtil.logException(java.lang.Exception;)V1
public static void logException(final Exception t) {
    SafeRunnable.run(new  SafeRunnable() {

        public void run() throws Exception {
            throw t;
        }

        public void handleException(Throwable e) {
        }
    });
}
method: org.eclipse.jface.util.SafeRunnable.run(org.eclipse.core.runtime.ISafeRunnable;)V1
public static void run(ISafeRunnable runnable) {
    getRunner().run(runnable);
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.list.AbstractObservableList.fireChange()V1
protected void fireChange() {
    checkRealm();
    changeSupport.fireEvent(new  ChangeEvent(this));
}
method: org.eclipse.core.databinding.observable.ChangeSupport.fireEvent(org.eclipse.core.databinding.observable.ObservableEvent;)V2
public void fireEvent(ObservableEvent event) {
    super.fireEvent(event);
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteFeature.setURL(java.lang.String;)V2
public void setURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fUrl;
    this.fUrl = url;
    firePropertyChanged(P_TYPE, oldValue, url);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.compare.structuremergeviewer.SharedDocumentAdapterWrapper.disconnect(java.lang.Object;)V2
public void disconnect(Object element) {
    IEditorInput input = getDocumentKey(element);
    if (input == null)
        return;
    IDocumentProvider provider = SharedDocumentAdapter.getDocumentProvider(input);
    if (provider == null)
        return;
    disconnect(provider, input);
}
method: org.eclipse.compare.structuremergeviewer.SharedDocumentAdapterWrapper.disconnect(org.eclipse.ui.texteditor.IDocumentProvider;org.eclipse.ui.IEditorInput;)V3
public void disconnect(IDocumentProvider provider, IEditorInput documentKey) {
    wrappedAdapter.disconnect(provider, documentKey);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.DocumentAdapter.set(java.lang.String;)V2
public void set(String text) {
    super.set(text);
    this.buffer.setContents(text);
}
method: org.eclipse.jface.text.AbstractDocument.set(java.lang.String;)V2
public void set(String text) {
    set(text, getNextModificationStamp());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.PluginObject.setName(java.lang.String;)V2
public void setName(String name) throws CoreException {
    ensureModelEditable();
    String oldValue = this.fName;
    this.fName = name;
    firePropertyChanged(P_NAME, oldValue, name);
}
method: org.eclipse.pde.internal.core.plugin.PluginObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.debug.ui.DebugUITools.getLastLaunch(java.lang.String;)org.eclipse.debug.core.ILaunchConfiguration;1
public static ILaunchConfiguration getLastLaunch(String groupId) {
    return DebugUIPlugin.getDefault().getLaunchConfigurationManager().getLastLaunch(groupId);
}
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchConfigurationManager.getLastLaunch(java.lang.String;)org.eclipse.debug.core.ILaunchConfiguration;2
public ILaunchConfiguration getLastLaunch(String groupId) {
    LaunchHistory history = getLaunchHistory(groupId);
    if (history != null) {
        return history.getRecentLaunch();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPage.getNewJavaProject()org.eclipse.jdt.core.IJavaProject;1
public IJavaProject getNewJavaProject() {
    return JavaCore.create(getProjectHandle());
}
method: org.eclipse.jdt.core.JavaCore.create(org.eclipse.core.resources.IProject;)org.eclipse.jdt.core.IJavaProject;1
public static IJavaProject create(IProject project) {
    if (project == null) {
        return null;
    }
    JavaModel javaModel = JavaModelManager.getJavaModelManager().getJavaModel();
    return javaModel.getJavaProject(project);
}

---------------Library-------------------
method: org.eclipse.ltk.ui.refactoring.resource.RenameResourceWizard$RenameResourceRefactoringConfigurationPage.initializeRefactoring()V1
private void initializeRefactoring() {
    fRefactoringProcessor.setNewResourceName(fNameField.getText());
}
method: org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor.setNewResourceName(java.lang.String;)V2
public void setNewResourceName(String newName) {
    Assert.isNotNull(newName);
    fNewResourceName = newName;
}
---------------Client-------------------
method: org.eclipse.swt.custom.CCombo$6.getValue(org.eclipse.swt.accessibility.AccessibleControlEvent;)V2
@Override
public void getValue(AccessibleControlEvent e) {
    e.result = getText();
}
method: org.eclipse.swt.custom.CCombo.getText()java.lang.String;1
public String getText() {
    checkWidget();
    return text.getText();
}

---------------Library-------------------
method: org.eclipse.jdt.ui.text.java.correction.CUCorrectionProposal.getPreviewContent()java.lang.String;1
public String getPreviewContent() throws CoreException {
    return getTextChange().getPreviewContent(new  NullProgressMonitor());
}
method: org.eclipse.ltk.core.refactoring.TextChange.getPreviewContent(org.eclipse.core.runtime.IProgressMonitor;)java.lang.String;2
public String getPreviewContent(IProgressMonitor pm) throws CoreException {
    return getPreviewDocument(pm).get();
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.mappings.ModelUpdateOperation.createParticipant()org.eclipse.team.ui.synchronize.ModelSynchronizeParticipant;1
protected ModelSynchronizeParticipant createParticipant() {
    return new  WorkspaceModelParticipant(createMergeContext());
}
method: org.eclipse.team.internal.ccvs.ui.mappings.ModelUpdateOperation.createMergeContext()org.eclipse.team.core.mapping.provider.SynchronizationContext;1
protected SynchronizationContext createMergeContext() {
    return WorkspaceSubscriberContext.createContext(getScopeManager(), getMergeType());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.IdentifiablePluginObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    String oldValue = fID;
    fID = id;
    firePropertyChanged(P_ID, oldValue, id);
}
method: org.eclipse.pde.internal.core.plugin.PluginObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.team.internal.core.subscribers.RootResourceSynchronizationScope.getProjects()Aorg.eclipse.core.resources.IProject;1
public IProject[] getProjects() {
    return ResourcesPlugin.getWorkspace().getRoot().getProjects();
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.MultipleFolderSelectionDialog.cancelPressed()V1
@Override
protected void cancelPressed() {
    setSelectionResult(null);
    super.cancelPressed();
}
method: org.eclipse.ui.dialogs.SelectionDialog.setSelectionResult(Ajava.lang.Object;)V2
protected void setSelectionResult(Object[] newResult) {
    result = newResult;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.renderings.AbstractTableRenderingLabelProvider.dispose()V1
@Override
public void dispose() {
    fRendering = null;
    super.dispose();
}
method: org.eclipse.jface.viewers.BaseLabelProvider.dispose()V1
@Override
public void dispose() {
    clearListeners();
}

---------------Library-------------------
method: org.eclipse.team.internal.core.subscribers.WorkingSetFilteredSyncInfoCollector.setFilter(org.eclipse.team.core.synchronize.SyncInfoFilter;)V2
public void setFilter(SyncInfoFilter filter) {
    filteredInput.setFilter(filter);
    filteredInput.reset();
}
method: org.eclipse.team.internal.core.subscribers.SyncSetInput.setFilter(org.eclipse.team.core.synchronize.SyncInfoFilter;)V2
public void setFilter(SyncInfoFilter filter) {
    this.filter = filter;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$FileTextDragListener.dragSetData(org.eclipse.swt.dnd.DragSourceEvent;)V2
public void dragSetData(DragSourceEvent event) {
    event.data = element.getText();
}
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$ContentTypeElement.getText()java.lang.String;1
protected String getText() {
    return text.getText();
}

---------------Library-------------------
method: org.eclipse.ant.internal.launching.AntLaunching.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.ExtensionsSection$9.doCreateRefreshJob()org.eclipse.ui.progress.WorkbenchJob;1
@Override
protected WorkbenchJob doCreateRefreshJob() {
    final WorkbenchJob job = super.doCreateRefreshJob();
    job.addJobChangeListener(new  JobChangeAdapter() {

        private ISelection selection;

        private boolean aboutToRunPassed = false;

        @Override
        public void scheduled(IJobChangeEvent event) {
            ((ExtensionsPatternFilter) fFilteredTree.getPatternFilter()).clearMatchingLeafs();
            selection = fExtensionTree.getSelection();
        }

        @Override
        public void aboutToRun(IJobChangeEvent event) {
            aboutToRunPassed = true;
        }

        @Override
        public void done(IJobChangeEvent event) {
            if (aboutToRunPassed) {
                try {
                    fFilteredTree.setRedraw(false);
                    ExtensionsPatternFilter extensionsPatternFilter = ((ExtensionsPatternFilter) fFilteredTree.getPatternFilter());
                    fExtensionTree.collapseAll();
                    Object[] leafs = extensionsPatternFilter.getMatchingLeafsAsArray();
                    for (int i = 0; i < leafs.length; i++) {
                        fExtensionTree.expandToLevel(leafs[i], 0);
                    }
                    if (selection != null && !(selection.isEmpty())) {
                        fExtensionTree.setSelection(selection, true);
                    }
                } finally {
                    fFilteredTree.setRedraw(true);
                }
            }
        }
    });
    return job;
}
method: org.eclipse.core.runtime.jobs.Job.addJobChangeListener(org.eclipse.core.runtime.jobs.IJobChangeListener;)V2
@Override
public final void addJobChangeListener(IJobChangeListener listener) {
    super.addJobChangeListener(listener);
}
---------------Client-------------------
method: org.apache.lucene.index.IndexReader.getCommitUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> getCommitUserData(Directory directory) throws CorruptIndexException, IOException {
    return SegmentInfos.readCurrentUserData(directory);
}
method: org.apache.lucene.index.SegmentInfos.readCurrentUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> readCurrentUserData(Directory directory) throws CorruptIndexException, IOException {
    SegmentInfos sis = new  SegmentInfos();
    sis.read(directory);
    return sis.getUserData();
}

---------------Library-------------------
method: org.eclipse.ui.views.bookmarkexplorer.BookmarkLabelProvider.dispose()V1
public void dispose() {
    if (image != null) {
        JFaceResources.getResources().destroyImage(desc);
        image = null;
    }
}
method: org.eclipse.jface.resource.ResourceManager.destroyImage(org.eclipse.jface.resource.ImageDescriptor;)V2
public final void destroyImage(ImageDescriptor descriptor) {
    destroy(descriptor);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.JavaOutlinePage$ChildrenProvider.dispose()V1
public void dispose() {
    if (fListener != null) {
        JavaCore.removeElementChangedListener(fListener);
        fListener = null;
    }
}
method: org.eclipse.jdt.core.JavaCore.removeElementChangedListener(org.eclipse.jdt.core.IElementChangedListener;)V1
public static void removeElementChangedListener(IElementChangedListener listener) {
    JavaModelManager.getDeltaState().removeElementChangedListener(listener);
}

---------------Library-------------------
method: org.eclipse.core.resources.mapping.ResourceMapping.getModelProvider()org.eclipse.core.resources.mapping.ModelProvider;1
public final ModelProvider getModelProvider() {
    try {
        return ModelProviderManager.getDefault().getModelProvider(getModelProviderId());
    } catch (CoreException e) {
        throw new  IllegalStateException(e.getMessage());
    }
}
method: org.eclipse.core.internal.resources.mapping.ModelProviderManager.getModelProvider(java.lang.String;)org.eclipse.core.resources.mapping.ModelProvider;2
public ModelProvider getModelProvider(String modelProviderId) throws CoreException {
    IModelProviderDescriptor desc = getDescriptor(modelProviderId);
    if (desc == null)
        return null;
    return desc.getModelProvider();
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.ui.internal.ApiImageDescriptor.getImageData(java.lang.String;)org.eclipse.swt.graphics.ImageData;2
private ImageData getImageData(String imageDescriptorKey) {
    return ApiUIPlugin.getImageDescriptor(imageDescriptorKey).getImageData();
}
method: org.eclipse.pde.api.tools.ui.internal.ApiUIPlugin.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getImageDescriptor(String key) {
    return getDefault().getImageRegistry().getDescriptor(key);
}

---------------Library-------------------
method: org.eclipse.equinox.p2.ui.RepositoryManipulationPage.getElements()Aorg.eclipse.equinox.internal.p2.ui.model.MetadataRepositoryElement;1
MetadataRepositoryElement[] getElements() {
    return getInput().getElements();
}
method: org.eclipse.equinox.p2.ui.RepositoryManipulationPage.getInput()org.eclipse.equinox.p2.ui.RepositoryManipulationPage$CachedMetadataRepositories;1
CachedMetadataRepositories getInput() {
    if (input == null)
        input = new  CachedMetadataRepositories();
    return input;
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.getTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;1
protected PreferenceTransferElement[] getTransfers() {
    if (transfers == null) {
        transfers = PreferenceTransferManager.getPreferenceTransfers();
    }
    return transfers;
}
method: org.eclipse.ui.internal.preferences.PreferenceTransferManager.getPreferenceTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;0
public static PreferenceTransferElement[] getPreferenceTransfers() {
    return new  PreferenceTransferRegistryReader(IWorkbenchRegistryConstants.PL_PREFERENCE_TRANSFER).getPreferenceTransfers();
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.elements.adapters.RegisterGroupProxy$Update.done()V1
@Override
public void done() {
    fViewerUpdate.setStatus(getStatus());
    fViewerUpdate.done();
}
method: org.eclipse.debug.internal.core.commands.Request.setStatus(org.eclipse.core.runtime.IStatus;)V2
@Override
public void setStatus(IStatus status) {
    fStatus = status;
}
---------------Client-------------------
method: org.eclipse.swt.custom.StyledText$12.getCharacterCount(org.eclipse.swt.accessibility.AccessibleTextEvent;)V2
@Override
public void getCharacterCount(AccessibleTextEvent e) {
    e.count = StyledText.this.getCharCount();
}
method: org.eclipse.swt.custom.StyledText.getCharCount()I1
public int getCharCount() {
    checkWidget();
    return content.getCharCount();
}

---------------Library-------------------
method: org.eclipse.ui.internal.progress.WorkbenchSiteProgressService$1.done(org.eclipse.core.runtime.jobs.IJobChangeEvent;)V2
@Override
public void done(IJobChangeEvent event) {
    Job job = event.getJob();
    decrementBusy(job);
    job.removeJobChangeListener(this);
}
method: org.eclipse.core.runtime.jobs.Job.removeJobChangeListener(org.eclipse.core.runtime.jobs.IJobChangeListener;)V2
@Override
public final void removeJobChangeListener(IJobChangeListener listener) {
    super.removeJobChangeListener(listener);
}
---------------Client-------------------
method: org.eclipse.pde.internal.runtime.registry.RegistryFilteredTree.updateToolbar(Z)V2
protected void updateToolbar(boolean visible) {
    super.updateToolbar(visible);
    browser.updateTitle();
}
method: org.eclipse.pde.internal.runtime.registry.RegistryBrowser.updateTitle()V1
public void updateTitle() {
    setContentDescription(getTitleSummary());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.AbstractExtensions.setSchemaVersion(java.lang.String;)V2
public void setSchemaVersion(String schemaVersion) throws CoreException {
    ensureModelEditable();
    String oldValue = fSchemaVersion;
    fSchemaVersion = schemaVersion;
    firePropertyChanged(IPluginBase.P_SCHEMA_VERSION, oldValue, schemaVersion);
}
method: org.eclipse.pde.internal.core.plugin.PluginObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSelectChannelConnector.newConnection(java.nio.channels.SocketChannel;org.eclipse.jetty.io.AsyncEndPoint;)org.eclipse.jetty.io.nio.AsyncConnection;3
@Override
protected AsyncConnection newConnection(SocketChannel channel, AsyncEndPoint endpoint) {
    try {
        SSLEngine engine = createSSLEngine(channel);
        SslConnection connection = newSslConnection(endpoint, engine);
        AsyncConnection delegate = newPlainConnection(channel, connection.getSslEndPoint());
        connection.getSslEndPoint().setConnection(delegate);
        connection.setAllowRenegotiate(_sslContextFactory.isAllowRenegotiate());
        return connection;
    } catch (IOException e) {
        throw new  RuntimeIOException(e);
    }
}
method: org.eclipse.jetty.server.ssl.SslSelectChannelConnector.newSslConnection(org.eclipse.jetty.io.AsyncEndPoint;javax.net.ssl.SSLEngine;)org.eclipse.jetty.io.nio.SslConnection;3
protected SslConnection newSslConnection(AsyncEndPoint endpoint, SSLEngine engine) {
    return new  SslConnection(engine, endpoint);
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.validation.ValidatedObservableList.remove(I)java.lang.Object;2
public Object remove(int index) {
    checkRealm();
    Object element = wrappedList.remove(index);
    ListDiff diff = Diffs.createListDiff(Diffs.createListDiffEntry(index, false, element));
    updateTargetList(diff);
    fireListChange(diff);
    return element;
}
method: org.eclipse.core.databinding.observable.list.ObservableList.fireListChange(org.eclipse.core.databinding.observable.list.ListDiff;)V2
protected void fireListChange(ListDiff diff) {
    super.fireChange();
    fireEvent(new  ListChangeEvent(this, diff));
}

---------------Library-------------------
method: org.eclipse.ui.internal.progress.AnimationItem$3.widgetDisposed(org.eclipse.swt.events.DisposeEvent;)V2
@Override
public void widgetDisposed(DisposeEvent e) {
    AnimationManager.getInstance().removeItem(AnimationItem.this);
}
method: org.eclipse.ui.internal.progress.AnimationManager.removeItem(org.eclipse.ui.internal.progress.AnimationItem;)V2
void removeItem(final AnimationItem item) {
    animationProcessor.removeItem(item);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    InternalExchangeUtils.passwordProvidersReset();
    enableLogout();
}
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.enableLogout()V1
protected void enableLogout() {
    buttonClearPassword.setEnabled(InternalExchangeUtils.isLoggedIn());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.code.ExtractMethodInputPage.setVisibility(java.lang.Integer;)V2
private void setVisibility(Integer visibility) {
    fRefactoring.setVisibility(visibility.intValue());
    updatePreview(getText());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractMethodRefactoring.setVisibility(I)V2
public void setVisibility(int visibility) {
    fVisibility = visibility;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.ImportPage.setDestinationValue(java.lang.String;)V2
@Override
protected void setDestinationValue(String selectedFileName) {
    oldDestination = getDestinationValue();
    super.setDestinationValue(selectedFileName);
}
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.AbstractPage.getDestinationValue()java.lang.String;1
protected String getDestinationValue() {
    return destinationNameField.getText().trim();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setVersion(java.lang.String;)V2
public void setVersion(String version) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fVersion;
    this.fVersion = version;
    firePropertyChanged(P_VERSION, oldValue, version);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.debug.ui.actions.RunToLineHandler.getBreakpointManager()org.eclipse.debug.core.IBreakpointManager;1
private IBreakpointManager getBreakpointManager() {
    return getDebugPlugin().getBreakpointManager();
}
method: org.eclipse.debug.ui.actions.RunToLineHandler.getDebugPlugin()org.eclipse.debug.core.DebugPlugin;1
private DebugPlugin getDebugPlugin() {
    return DebugPlugin.getDefault();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.TeamUIPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getPlugin().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.imports.FeatureImportWizardPage.dispose()V1
@Override
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.jface.dialogs.DialogPage.dispose()V1
@Override
public void dispose() {
    if (image != null) {
        image.dispose();
        image = null;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.SynchronizePageDropDownAction.dispose()V1
public void dispose() {
    if (menuManager != null) {
        menuManager.dispose();
        menuManager = null;
    }
    TeamUI.getSynchronizeManager().removeSynchronizeParticipantListener(this);
}
method: org.eclipse.team.ui.TeamUI.getSynchronizeManager()org.eclipse.team.ui.synchronize.ISynchronizeManager;0
public static ISynchronizeManager getSynchronizeManager() {
    return TeamUIPlugin.getPlugin().getSynchronizeManager();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.ProvSDKUIActivator.getPolicy()org.eclipse.equinox.p2.ui.Policy;1
Policy getPolicy() {
    return getProvisioningUI().getPolicy();
}
method: org.eclipse.equinox.internal.p2.ui.sdk.ProvSDKUIActivator.getProvisioningUI()org.eclipse.equinox.p2.ui.ProvisioningUI;1
public ProvisioningUI getProvisioningUI() {
    return ProvisioningUI.getDefaultUI();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.jdt.ui.JavaUI.getColorManager()org.eclipse.jdt.ui.text.IColorManager;0
public static IColorManager getColorManager() {
    return JavaPlugin.getDefault().getJavaTextTools().getColorManager();
}
method: org.eclipse.jdt.ui.text.JavaTextTools.getColorManager()org.eclipse.jdt.ui.text.IColorManager;1
public IColorManager getColorManager() {
    return fColorManager;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.ui.views.contentoutline.ContentOutline.addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener;)V2
public void addSelectionChangedListener(ISelectionChangedListener listener) {
    getSelectionProvider().addSelectionChangedListener(listener);
}
method: org.eclipse.ui.part.PageBookView$SelectionProvider.addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener;)V2
@Override
public void addSelectionChangedListener(ISelectionChangedListener listener) {
    fSelectionListener.addSelectionChangedListener(listener);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage$1.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    controlChanged();
}
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage.controlChanged()V1
public void controlChanged() {
    setPageComplete(validate());
}

---------------Library-------------------
method: org.eclipse.ltk.internal.core.refactoring.RefactoringCorePlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringUIPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.reorg.ReorgPolicyFactory$PackageFragmentRootsReorgPolicy.getDestinationJavaProject()org.eclipse.jdt.core.IJavaProject;1
protected IJavaProject getDestinationJavaProject() {
    return getDestinationAsJavaProject(getJavaElementDestination());
}
method: org.eclipse.jdt.internal.corext.refactoring.reorg.ReorgPolicyFactory$PackageFragmentRootsReorgPolicy.getDestinationAsJavaProject(org.eclipse.jdt.core.IJavaElement;)org.eclipse.jdt.core.IJavaProject;2
private IJavaProject getDestinationAsJavaProject(IJavaElement javaElementDestination) {
    if (javaElementDestination == null)
        return null;
    else
        return javaElementDestination.getJavaProject();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.model.TestCaseElement.getTestClassName()java.lang.String;1
public String getTestClassName() {
    return getClassName();
}
method: org.eclipse.jdt.internal.junit.model.TestElement.getClassName()java.lang.String;1
public String getClassName() {
    return extractClassName(getTestName());
}

---------------Library-------------------
method: org.eclipse.ui.ide.undo.AbstractWorkspaceOperation.getWorkspaceRuleFactory()org.eclipse.core.resources.IResourceRuleFactory;1
protected IResourceRuleFactory getWorkspaceRuleFactory() {
    return getWorkspace().getRuleFactory();
}
method: org.eclipse.core.internal.resources.Workspace.getRuleFactory()org.eclipse.core.resources.IResourceRuleFactory;1
public IResourceRuleFactory getRuleFactory() {
    if (ruleFactory == null)
        ruleFactory = new  Rules(this);
    return ruleFactory;
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.getTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;1
protected PreferenceTransferElement[] getTransfers() {
    if (transfers == null) {
        transfers = PreferenceTransferManager.getPreferenceTransfers();
    }
    return transfers;
}
method: org.eclipse.ui.internal.preferences.PreferenceTransferManager.getPreferenceTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;0
public static PreferenceTransferElement[] getPreferenceTransfers() {
    return new  PreferenceTransferRegistryReader(IWorkbenchRegistryConstants.PL_PREFERENCE_TRANSFER).getPreferenceTransfers();
}

---------------Library-------------------
method: org.eclipse.ui.ide.undo.AbstractWorkspaceOperation.getWorkspaceRuleFactory()org.eclipse.core.resources.IResourceRuleFactory;1
protected IResourceRuleFactory getWorkspaceRuleFactory() {
    return getWorkspace().getRuleFactory();
}
method: org.eclipse.ui.ide.undo.AbstractWorkspaceOperation.getWorkspace()org.eclipse.core.resources.IWorkspace;1
protected IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Project.getContentTypeMatcher()org.eclipse.core.runtime.content.IContentTypeMatcher;1
public IContentTypeMatcher getContentTypeMatcher() throws CoreException {
    return workspace.getContentDescriptionManager().getContentTypeMatcher(this);
}
method: org.eclipse.core.internal.resources.ContentDescriptionManager.getContentTypeMatcher(org.eclipse.core.internal.resources.Project;)org.eclipse.core.runtime.content.IContentTypeMatcher;2
public IContentTypeMatcher getContentTypeMatcher(Project project) throws CoreException {
    return projectContentTypes.getMatcherFor(project);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.SourceFirstPackageSelectionDialogField.getSelected()org.eclipse.jdt.core.IPackageFragment;1
public IPackageFragment getSelected() {
    IPackageFragment res = fPackageSelection.getPackageFragment();
    return res;
}
method: org.eclipse.jdt.internal.ui.refactoring.nls.PackageFragmentSelection.getPackageFragment()org.eclipse.jdt.core.IPackageFragment;1
public IPackageFragment getPackageFragment() {
    return calculateFragment(fDialogField.getSelectedFragmentRoot());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.LaunchingPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaModelOperation.addDelta(org.eclipse.jdt.core.IJavaElementDelta;)V2
protected void addDelta(IJavaElementDelta delta) {
    JavaModelManager.getJavaModelManager().getDeltaProcessor().registerJavaModelDelta(delta);
}
method: org.eclipse.jdt.internal.core.JavaModelManager.getDeltaProcessor()org.eclipse.jdt.internal.core.DeltaProcessor;1
public DeltaProcessor getDeltaProcessor() {
    return this.deltaState.getDeltaProcessor();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.enableLogout()V1
protected void enableLogout() {
    buttonClearPassword.setEnabled(InternalExchangeUtils.isLoggedIn());
}
method: org.eclipse.equinox.internal.security.storage.friends.InternalExchangeUtils.isLoggedIn()Z0
public static boolean isLoggedIn() {
    return PasswordProviderSelector.getInstance().isLoggedIn();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.target.AbstractBundleContainer.resolveVariables(java.lang.String;)java.lang.String;2
protected String resolveVariables(String text) throws CoreException {
    IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();
    return manager.performStringSubstitution(text);
}
method: org.eclipse.core.internal.variables.StringVariableManager.performStringSubstitution(java.lang.String;)java.lang.String;2
@Override
public String performStringSubstitution(String expression) throws CoreException {
    return performStringSubstitution(expression, true);
}
---------------Client-------------------
method: org.eclipse.core.runtime.Platform.getPluginStateLocation(org.eclipse.core.runtime.Plugin;)org.eclipse.core.runtime.IPath;1
@Deprecated
public static IPath getPluginStateLocation(Plugin plugin) {
    return plugin.getStateLocation();
}
method: org.eclipse.core.runtime.Plugin.getStateLocation()org.eclipse.core.runtime.IPath;1
public final IPath getStateLocation() throws IllegalStateException {
    return InternalPlatform.getDefault().getStateLocation(getBundle(), true);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.target.AbstractBundleContainer.resolveVariables(java.lang.String;)java.lang.String;2
protected String resolveVariables(String text) throws CoreException {
    IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();
    return manager.performStringSubstitution(text);
}
method: org.eclipse.core.variables.VariablesPlugin.getStringVariableManager()org.eclipse.core.variables.IStringVariableManager;1
public IStringVariableManager getStringVariableManager() {
    return StringVariableManager.getDefault();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.map.AbstractObservableMap.fireStale()V1
protected void fireStale() {
    checkRealm();
    changeSupport.fireEvent(new  StaleEvent(this));
}
method: org.eclipse.core.databinding.observable.ChangeSupport.fireEvent(org.eclipse.core.databinding.observable.ObservableEvent;)V2
public void fireEvent(ObservableEvent event) {
    super.fireEvent(event);
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.jface.viewers.TableTreeViewer$TableTreeEditorImpl.applyEditorValue()V1
public void applyEditorValue() {
    CellEditor c = this.cellEditor;
    if (c != null) {
        this.cellEditor = null;
        Item t = this.tableItem;
        if (t != null && !t.isDisposed()) {
            saveEditorValue(c, t);
        }
        setEditor(null, null, 0);
        c.removeListener(cellEditorListener);
        Control control = c.getControl();
        if (control != null) {
            if (mouseListener != null) {
                control.removeMouseListener(mouseListener);
            }
            if (focusListener != null) {
                control.removeFocusListener(focusListener);
            }
        }
        c.deactivate();
    }
}
method: org.eclipse.jface.viewers.CellEditor.removeListener(org.eclipse.jface.viewers.ICellEditorListener;)V2
public void removeListener(ICellEditorListener listener) {
    listeners.remove(listener);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.TableEditorImpl$1.focusLost(org.eclipse.swt.events.FocusEvent;)V2
@Override
public void focusLost(FocusEvent e) {
    applyEditorValue();
}
method: org.eclipse.debug.internal.ui.viewers.TableEditorImpl.applyEditorValue()V1
public void applyEditorValue() {
    CellEditor c = fCellEditor;
    if (c != null) {
        fCellEditor = null;
        Item t = fTableItem;
        if (t != null && !t.isDisposed()) {
            saveEditorValue(c, t);
        }
        setEditor(null, null, 0);
        c.removeListener(fCellEditorListener);
        Control control = c.getControl();
        if (control != null) {
            if (fMouseListener != null) {
                control.removeMouseListener(fMouseListener);
            }
            if (fFocusListener != null) {
                control.removeFocusListener(fFocusListener);
            }
        }
        c.deactivate();
    }
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.AntUIPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.junit.JUnitCore.addTestRunListener(org.eclipse.jdt.junit.TestRunListener;)V1
public static void addTestRunListener(TestRunListener listener) {
    JUnitCorePlugin.getDefault().getNewTestRunListeners().add(listener);
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getNewTestRunListeners()org.eclipse.core.runtime.ListenerList;1
public ListenerList getNewTestRunListeners() {
    loadTestRunListeners();
    return fNewTestRunListeners;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.enableLogout()V1
protected void enableLogout() {
    buttonClearPassword.setEnabled(InternalExchangeUtils.isLoggedIn());
}
method: org.eclipse.equinox.internal.security.storage.friends.InternalExchangeUtils.isLoggedIn()Z0
public static boolean isLoggedIn() {
    return PasswordProviderSelector.getInstance().isLoggedIn();
}

---------------Library-------------------
method: org.eclipse.jdt.junit.JUnitCore.removeTestRunListener(org.eclipse.jdt.junit.TestRunListener;)V1
public static void removeTestRunListener(TestRunListener listener) {
    JUnitCorePlugin.getDefault().getNewTestRunListeners().remove(listener);
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getNewTestRunListeners()org.eclipse.core.runtime.ListenerList;1
public ListenerList getNewTestRunListeners() {
    loadTestRunListeners();
    return fNewTestRunListeners;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.enableLogout()V1
protected void enableLogout() {
    buttonClearPassword.setEnabled(InternalExchangeUtils.isLoggedIn());
}
method: org.eclipse.equinox.internal.security.storage.friends.InternalExchangeUtils.isLoggedIn()Z0
public static boolean isLoggedIn() {
    return PasswordProviderSelector.getInstance().isLoggedIn();
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ArrayType.getComponentType()org.eclipse.jdt.core.dom.Type;1
public Type getComponentType() {
    supportedOnlyIn2_3_4();
    return internalGetType(COMPONENT_TYPE_PROPERTY);
}
method: org.eclipse.jdt.core.dom.ArrayType.internalGetType(org.eclipse.jdt.core.dom.ChildPropertyDescriptor;)org.eclipse.jdt.core.dom.Type;2
private Type internalGetType(ChildPropertyDescriptor property) {
    if (this.type == null) {
        synchronized (this) {
            if (this.type == null) {
                preLazyInit();
                this.type = new  SimpleType(this.ast);
                postLazyInit(this.type, property);
            }
        }
    }
    return this.type;
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.ClassInstanceCreation.getName()org.eclipse.jdt.core.dom.Name;1
public Name getName() {
    return internalGetName();
}
method: org.eclipse.jdt.core.dom.ClassInstanceCreation.internalGetName()org.eclipse.jdt.core.dom.Name;1
Name internalGetName() {
    supportedOnlyIn2();
    if (this.typeName == null) {
        synchronized (this) {
            if (this.typeName == null) {
                preLazyInit();
                this.typeName = new  SimpleName(this.ast);
                postLazyInit(this.typeName, NAME_PROPERTY);
            }
        }
    }
    return this.typeName;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.browsing.PackagesView.setInput(java.lang.Object;)V2
@Override
protected void setInput(Object input) {
    setViewerWrapperInput(input);
    super.updateTitle();
}
method: org.eclipse.jdt.internal.ui.browsing.PackagesView.setViewerWrapperInput(java.lang.Object;)V2
private void setViewerWrapperInput(Object input) {
    fWrappedViewer.setViewerInput(input);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage$1.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    controlChanged();
}
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage.controlChanged()V1
public void controlChanged() {
    setPageComplete(validate());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.shared.target.AddFeatureContainersPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.jface.dialogs.DialogPage.dispose()V1
@Override
public void dispose() {
    if (image != null) {
        image.dispose();
        image = null;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.SynchronizePageDropDownAction.dispose()V1
public void dispose() {
    if (menuManager != null) {
        menuManager.dispose();
        menuManager = null;
    }
    TeamUI.getSynchronizeManager().removeSynchronizeParticipantListener(this);
}
method: org.eclipse.team.ui.TeamUI.getSynchronizeManager()org.eclipse.team.ui.synchronize.ISynchronizeManager;0
public static ISynchronizeManager getSynchronizeManager() {
    return TeamUIPlugin.getPlugin().getSynchronizeManager();
}

---------------Library-------------------
method: org.eclipse.ui.views.contentoutline.ContentOutline.removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener;)V2
public void removeSelectionChangedListener(ISelectionChangedListener listener) {
    getSelectionProvider().removeSelectionChangedListener(listener);
}
method: org.eclipse.ui.part.PageBookView$SelectionProvider.removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener;)V2
@Override
public void removeSelectionChangedListener(ISelectionChangedListener listener) {
    fSelectionListener.removeSelectionChangedListener(listener);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage$1.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    controlChanged();
}
method: org.eclipse.pde.internal.ui.wizards.exports.TargetDefinitionExportWizardPage.controlChanged()V1
public void controlChanged() {
    setPageComplete(validate());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.update.MemoryBlockProxy.installed(org.eclipse.jface.viewers.Viewer;)V2
@Override
public void installed(Viewer viewer) {
    super.installed(viewer);
    setInstalled(true);
}
method: org.eclipse.debug.internal.ui.viewers.provisional.AbstractModelProxy.setInstalled(Z)V2
protected synchronized void setInstalled(boolean installed) {
    fInstalled = installed;
}
---------------Client-------------------
method: org.apache.lucene.index.IndexWriter.setPayloadProcessorProvider(org.apache.lucene.index.PayloadProcessorProvider;)V2
public void setPayloadProcessorProvider(PayloadProcessorProvider pcp) {
    ensureOpen();
    payloadProcessorProvider = pcp;
}
method: org.apache.lucene.index.IndexWriter.ensureOpen()V1
protected final void ensureOpen() throws AlreadyClosedException {
    ensureOpen(true);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.fix.LinkedProposalModel.setEndPosition(org.eclipse.jdt.core.dom.rewrite.ITrackedNodePosition;)V2
public void setEndPosition(ITrackedNodePosition position) {
    setEndPosition(LinkedProposalPositionGroup.createPositionInformation(position, 1));
}
method: org.eclipse.jdt.internal.corext.fix.LinkedProposalModel.setEndPosition(org.eclipse.jdt.internal.corext.fix.LinkedProposalPositionGroup$PositionInformation;)V2
public void setEndPosition(PositionInformation position) {
    fEndPosition = position;
}
---------------Client-------------------
method: org.apache.lucene.index.IndexWriter.setPayloadProcessorProvider(org.apache.lucene.index.PayloadProcessorProvider;)V2
public void setPayloadProcessorProvider(PayloadProcessorProvider pcp) {
    ensureOpen();
    payloadProcessorProvider = pcp;
}
method: org.apache.lucene.index.IndexWriter.ensureOpen()V1
protected final void ensureOpen() throws AlreadyClosedException {
    ensureOpen(true);
}

---------------Library-------------------
method: org.eclipse.jface.databinding.viewers.ViewersObservables.observeDelayedValue(ILorg.eclipse.jface.databinding.viewers.IViewerObservableValue;)org.eclipse.jface.databinding.viewers.IViewerObservableValue;2
public static IViewerObservableValue observeDelayedValue(int delay, IViewerObservableValue observable) {
    return new  ViewerObservableValueDecorator(Observables.observeDelayedValue(delay, observable), observable.getViewer());
}
method: org.eclipse.core.databinding.observable.Observables.observeDelayedValue(ILorg.eclipse.core.databinding.observable.value.IObservableValue;)org.eclipse.core.databinding.observable.value.IObservableValue;2
public static IObservableValue observeDelayedValue(int delay, IObservableValue observable) {
    return new  DelayedObservableValue(delay, observable);
}
---------------Client-------------------
method: org.eclipse.core.internal.filesystem.local.LocalFileSystem.getStore(org.eclipse.core.runtime.IPath;)org.eclipse.core.filesystem.IFileStore;2
public IFileStore getStore(IPath path) {
    return new  LocalFile(path.toFile());
}
method: org.eclipse.core.runtime.Path.toFile()java.io.File;1
public File toFile() {
    return new  File(toOSString());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.AllCleanUpsAction.getCleanUps(Aorg.eclipse.jdt.core.ICompilationUnit;)Aorg.eclipse.jdt.ui.cleanup.ICleanUp;2
@Override
protected ICleanUp[] getCleanUps(ICompilationUnit[] units) {
    return JavaPlugin.getDefault().getCleanUpRegistry().createCleanUps();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getCleanUpRegistry()org.eclipse.jdt.internal.corext.fix.CleanUpRegistry;1
public synchronized CleanUpRegistry getCleanUpRegistry() {
    if (fCleanUpRegistry == null)
        fCleanUpRegistry = new  CleanUpRegistry();
    return fCleanUpRegistry;
}
---------------Client-------------------
method: org.eclipse.compare.CompareConfiguration.getResourceManager()org.eclipse.jface.resource.ResourceManager;1
private synchronized ResourceManager getResourceManager() {
    if (fResourceManager == null) {
        fResourceManager = new  LocalResourceManager(JFaceResources.getResources());
    }
    return fResourceManager;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    ResourcesPlugin.getPlugin().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.map.AbstractObservableMap.fireChange()V1
protected void fireChange() {
    checkRealm();
    changeSupport.fireEvent(new  ChangeEvent(this));
}
method: org.eclipse.core.databinding.observable.ChangeSupport.fireEvent(org.eclipse.core.databinding.observable.ObservableEvent;)V2
public void fireEvent(ObservableEvent event) {
    super.fireEvent(event);
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.pde.internal.runtime.PDERuntimePlugin.getActivePage()org.eclipse.ui.IWorkbenchPage;0
public static IWorkbenchPage getActivePage() {
    return getDefault().internalGetActivePage();
}
method: org.eclipse.pde.internal.runtime.PDERuntimePlugin.internalGetActivePage()org.eclipse.ui.IWorkbenchPage;1
private IWorkbenchPage internalGetActivePage() {
    return getWorkbench().getActiveWorkbenchWindow().getActivePage();
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSUIPlugin.getActivePage()org.eclipse.ui.IWorkbenchPage;0
public static IWorkbenchPage getActivePage() {
    return TeamUIPlugin.getActivePage();
}
method: org.eclipse.team.internal.ui.TeamUIPlugin.getActivePage()org.eclipse.ui.IWorkbenchPage;0
public static IWorkbenchPage getActivePage() {
    IWorkbenchWindow window = getPlugin().getWorkbench().getActiveWorkbenchWindow();
    if (window == null)
        return null;
    return window.getActivePage();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.MethodRef;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(MethodRef node, ITypeBinding type) {
    Name qualifier = node.getQualifier();
    if (qualifier == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        qualifier = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, MethodRef.QUALIFIER_PROPERTY, qualifier, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else {
        rewriteName(qualifier, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.dom.ASTNodeFactory.newName(org.eclipse.jdt.core.dom.AST;java.lang.String;)org.eclipse.jdt.core.dom.Name;2
public static Name newName(AST ast, String qualifiedName) {
    return ast.newName(qualifiedName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.MemberRef;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(MemberRef node, ITypeBinding type) {
    Name qualifier = node.getQualifier();
    if (qualifier == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        qualifier = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, MemberRef.QUALIFIER_PROPERTY, qualifier, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else {
        rewriteName(qualifier, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.CompilationUnitRewrite.getAST()org.eclipse.jdt.core.dom.AST;1
public AST getAST() {
    return getRoot().getAST();
}

---------------Library-------------------
method: org.eclipse.ui.activities.WorkbenchActivityHelper.getTriggerPoint(java.lang.String;)org.eclipse.ui.activities.ITriggerPoint;1
private static ITriggerPoint getTriggerPoint(String id) {
    return PlatformUI.getWorkbench().getActivitySupport().getTriggerPointManager().getTriggerPoint(id);
}
method: org.eclipse.ui.internal.activities.ws.WorkbenchActivitySupport.getTriggerPointManager()org.eclipse.ui.activities.ITriggerPointManager;1
@Override
public ITriggerPointManager getTriggerPointManager() {
    return triggerPointManager;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setWS(java.lang.String;)V2
public void setWS(String ws) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fWs;
    this.fWs = ws;
    firePropertyChanged(P_WS, oldValue, ws);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.team.ui.mapping.SynchronizationContentProvider.getContext()org.eclipse.team.core.mapping.ISynchronizationContext;1
protected ISynchronizationContext getContext() {
    ICommonContentExtensionSite extensionSite = getExtensionSite();
    if (extensionSite != null)
        return (ISynchronizationContext) extensionSite.getExtensionStateModel().getProperty(ITeamContentProviderManager.P_SYNCHRONIZATION_CONTEXT);
    return null;
}
method: org.eclipse.ui.internal.navigator.extensions.ExtensionStateModel.getProperty(java.lang.String;)java.lang.Object;2
public Object getProperty(String aPropertyName) {
    return values.get(aPropertyName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.delegates.DelegateMethodCreator.getDeclarationBinding()org.eclipse.jdt.core.dom.IBinding;1
@Override
protected IBinding getDeclarationBinding() {
    final MethodDeclaration declaration = (MethodDeclaration) getDeclaration();
    return declaration.resolveBinding();
}
method: org.eclipse.jdt.core.dom.MethodDeclaration.resolveBinding()org.eclipse.jdt.core.dom.IMethodBinding;1
public IMethodBinding resolveBinding() {
    return this.ast.getBindingResolver().resolveMethod(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureData.setNL(java.lang.String;)V2
public void setNL(String nl) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.nl;
    this.nl = nl;
    firePropertyChanged(P_NL, oldValue, nl);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.CompositeDebugImageDescriptor.getSize()org.eclipse.swt.graphics.Point;1
@Override
protected Point getSize() {
    if (fSize == null) {
        ImageData data = getBaseImage().getImageData();
        setSize(new  Point(data.width, data.height));
    }
    return fSize;
}
method: org.eclipse.debug.internal.ui.CompositeDebugImageDescriptor.setSize(org.eclipse.swt.graphics.Point;)V2
protected void setSize(Point size) {
    fSize = size;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.ChangeSignatureProcessor$OccurrenceUpdate.getImportRemover()org.eclipse.jdt.internal.corext.refactoring.structure.ImportRemover;1
protected final ImportRemover getImportRemover() {
    return fCuRewrite.getImportRemover();
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.CompilationUnitRewrite.getImportRemover()org.eclipse.jdt.internal.corext.refactoring.structure.ImportRemover;1
public ImportRemover getImportRemover() {
    if (fImportRemover == null) {
        fImportRemover = new  ImportRemover(fCu.getJavaProject(), getRoot());
    }
    return fImportRemover;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureData.setOS(java.lang.String;)V2
public void setOS(String os) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.os;
    this.os = os;
    firePropertyChanged(P_OS, oldValue, os);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.ui.internal.menus.DynamicToolBarContributionItem.createControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
@Override
public Control createControl(Composite parent) {
    WorkbenchWindowControlContribution contributionItem = getContributionItem();
    if (contributionItem != null)
        return contributionItem.delegateCreateControl(parent);
    return null;
}
method: org.eclipse.ui.menus.WorkbenchWindowControlContribution.delegateCreateControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
public Control delegateCreateControl(Composite parent) {
    return createControl(parent);
}
---------------Client-------------------
method: org.eclipse.e4.ui.model.application.ui.impl.UIElementImpl.getLocalizedAccessibilityPhrase()java.lang.String;1
public String getLocalizedAccessibilityPhrase() {
    return LocalizationHelper.getLocalizedAccessibilityPhrase(this);
}
method: org.eclipse.e4.ui.model.LocalizationHelper.getLocalizedAccessibilityPhrase(org.eclipse.e4.ui.model.application.ui.MUIElement;)java.lang.String;1
public static String getLocalizedAccessibilityPhrase(MUIElement element) {
    String key = element.getAccessibilityPhrase();
    if (key == null)
        return null;
    return getLocalized(key, element);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.ui.internal.AptUIPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.DebugPluginImages.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getImageDescriptor(String key) {
    return getImageRegistry().getDescriptor(key);
}
method: org.eclipse.jface.resource.ImageRegistry.getDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public ImageDescriptor getDescriptor(String key) {
    Entry entry = getEntry(key);
    if (entry == null) {
        return null;
    }
    return entry.descriptor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.compare.ManifestStructureCreator$ManifestNode.getImage()org.eclipse.swt.graphics.Image;1
public Image getImage() {
    return CompareUI.getImage(getType());
}
method: org.eclipse.pde.internal.ui.compare.ManifestStructureCreator$ManifestNode.getType()java.lang.String;1
public String getType() {
    return "MF2";
}
---------------Client-------------------
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return getClasspathImage();
}
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab.getClasspathImage()org.eclipse.swt.graphics.Image;0
public static Image getClasspathImage() {
    return JavaDebugImages.get(JavaDebugImages.IMG_OBJS_CLASSPATH);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteDescription.setURL(java.lang.String;)V2
public void setURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.url;
    this.url = url;
    firePropertyChanged(P_URL, oldValue, url);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.core.databinding.beans.PojoObservables.listFactory(org.eclipse.core.databinding.observable.Realm;java.lang.String;java.lang.Class;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;3
public static IObservableFactory listFactory(final Realm realm, final String propertyName, final Class elementType) {
    return PojoProperties.list(propertyName, elementType).listFactory(realm);
}
method: org.eclipse.core.databinding.property.list.ListProperty.listFactory(org.eclipse.core.databinding.observable.Realm;)org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;2
public IObservableFactory listFactory(final Realm realm) {
    return new  IObservableFactory() {

        public IObservable createObservable(Object target) {
            return observe(realm, target);
        }
    };
}
---------------Client-------------------
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.createState()org.eclipse.osgi.service.resolver.State;1
public State createState() {
    return internalCreateState();
}
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.internalCreateState()org.eclipse.osgi.internal.resolver.StateImpl;1
private StateImpl internalCreateState() {
    StateImpl state = new  UserState();
    state.setFactory(this);
    return state;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.launcher.SourceLookupBlock.dispose()V1
@Override
public void dispose() {
    fPathViewer.removeEntriesChangedListener(this);
    super.dispose();
}
method: org.eclipse.jdt.internal.debug.ui.launcher.RuntimeClasspathViewer.removeEntriesChangedListener(org.eclipse.jdt.internal.debug.ui.launcher.IEntriesChangedListener;)V2
public void removeEntriesChangedListener(IEntriesChangedListener listener) {
    fListeners.remove(listener);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AccessRuleEntryDialog$TypeRulesAdapter.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    doStatusLineUpdate();
}
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AccessRuleEntryDialog.doStatusLineUpdate()V1
protected void doStatusLineUpdate() {
    checkIfPatternValid();
    updateStatus(fPatternStatus);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.TableSection.getRenameAction()org.eclipse.jface.action.IAction;1
protected IAction getRenameAction() {
    return getTablePart().getRenameAction();
}
method: org.eclipse.pde.internal.ui.parts.EditableTablePart.getRenameAction()org.eclipse.jface.action.IAction;1
public IAction getRenameAction() {
    if (renameAction == null)
        renameAction = new  RenameAction();
    return renameAction;
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.getTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;1
protected PreferenceTransferElement[] getTransfers() {
    if (transfers == null) {
        transfers = PreferenceTransferManager.getPreferenceTransfers();
    }
    return transfers;
}
method: org.eclipse.ui.internal.preferences.PreferenceTransferManager.getPreferenceTransfers()Aorg.eclipse.ui.internal.preferences.PreferenceTransferElement;0
public static PreferenceTransferElement[] getPreferenceTransfers() {
    return new  PreferenceTransferRegistryReader(IWorkbenchRegistryConstants.PL_PREFERENCE_TRANSFER).getPreferenceTransfers();
}

---------------Library-------------------
method: org.eclipse.pde.core.plugin.PluginRegistry.getAllModels(Z)Aorg.eclipse.pde.core.plugin.IPluginModelBase;1
public static IPluginModelBase[] getAllModels(boolean includeFragments) {
    return PDECore.getDefault().getModelManager().getAllModels(includeFragments);
}
method: org.eclipse.pde.internal.core.PDECore.getModelManager()org.eclipse.pde.internal.core.PluginModelManager;1
public PluginModelManager getModelManager() {
    return PluginModelManager.getInstance();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.jface.text.source.ChangeRulerColumn.setHover(org.eclipse.jface.text.source.IAnnotationHover;)V2
public void setHover(IAnnotationHover hover) {
    fRevisionPainter.setHover(hover);
    fDiffPainter.setHover(hover);
}
method: org.eclipse.jface.internal.text.source.DiffPainter.setHover(org.eclipse.jface.text.source.IAnnotationHover;)V2
public void setHover(IAnnotationHover hover) {
    fHover = hover;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.setRoot(java.lang.Object;)V2
public void setRoot(Object newRoot) {
    this.fRoot = newRoot;
    initialize();
}
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.initialize()V1
protected void initialize() {
    fTreeViewer.setInput(fRoot);
}

---------------Library-------------------
method: org.eclipse.core.internal.plugins.PluginDescriptor.getExtensionPoints()Aorg.eclipse.core.runtime.IExtensionPoint;1
public IExtensionPoint[] getExtensionPoints() {
    return InternalPlatform.getDefault().getRegistry().getExtensionPoints(getId());
}
method: org.eclipse.core.internal.runtime.InternalPlatform.getRegistry()org.eclipse.core.runtime.IExtensionRegistry;1
public IExtensionRegistry getRegistry() {
    return RegistryFactory.getRegistry();
}
---------------Client-------------------
method: org.eclipse.help.HelpSystem.getIndex()org.eclipse.help.IIndex;0
public static IIndex getIndex() {
    return HelpPlugin.getIndexManager().getIndex(Platform.getNL());
}
method: org.eclipse.core.runtime.Platform.getNL()java.lang.String;0
public static String getNL() {
    return InternalPlatform.getDefault().getNL();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureData.setWS(java.lang.String;)V2
public void setWS(String ws) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.ws;
    this.ws = ws;
    firePropertyChanged(P_WS, oldValue, ws);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jface.viewers.TableTreeViewer$TableTreeEditorImpl.cancelEditing()V1
public void cancelEditing() {
    if (cellEditor != null) {
        setEditor(null, null, 0);
        cellEditor.removeListener(cellEditorListener);
        CellEditor oldEditor = cellEditor;
        cellEditor = null;
        oldEditor.deactivate();
    }
}
method: org.eclipse.jface.viewers.CellEditor.removeListener(org.eclipse.jface.viewers.ICellEditorListener;)V2
public void removeListener(ICellEditorListener listener) {
    listeners.remove(listener);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousTableViewer.cancelEditing()V1
public void cancelEditing() {
    fTableEditorImpl.cancelEditing();
}
method: org.eclipse.debug.internal.ui.viewers.TableEditorImpl.cancelEditing()V1
public void cancelEditing() {
    if (fCellEditor != null) {
        setEditor(null, null, 0);
        fCellEditor.removeListener(fCellEditorListener);
        CellEditor oldEditor = fCellEditor;
        fCellEditor = null;
        oldEditor.deactivate();
    }
}

---------------Library-------------------
method: org.eclipse.jface.window.ApplicationWindow.getFont()org.eclipse.swt.graphics.Font;1
protected Font getFont() {
    return JFaceResources.getFont(getSymbolicFontName());
}
method: org.eclipse.jface.window.ApplicationWindow.getSymbolicFontName()java.lang.String;1
public String getSymbolicFontName() {
    return JFaceResources.TEXT_FONT;
}
---------------Client-------------------
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return getClasspathImage();
}
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab.getClasspathImage()org.eclipse.swt.graphics.Image;0
public static Image getClasspathImage() {
    return JavaDebugImages.get(JavaDebugImages.IMG_OBJS_CLASSPATH);
}

---------------Library-------------------
method: org.eclipse.ui.internal.editors.text.EditorsPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.apache.batik.util.gui.DropDownComponent$2.itemsWereRemoved(org.apache.batik.util.gui.DropDownComponent$ScrollablePopupMenuEvent;)V2
public void itemsWereRemoved(ScrollablePopupMenuEvent ev) {
    updateMainButtonTooltip(ev.getDetails());
}
method: org.apache.batik.util.gui.DropDownComponent.updateMainButtonTooltip(java.lang.String;)V2
public void updateMainButtonTooltip(String newTooltip) {
    mainButton.setToolTipText(newTooltip);
}
---------------Client-------------------
method: org.eclipse.equinox.p2.ui.InstalledSoftwarePage$1.addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener;)V2
public void addSelectionChangedListener(ISelectionChangedListener listener) {
    installedIUGroup.getStructuredViewer().addSelectionChangedListener(listener);
}
method: org.eclipse.equinox.internal.p2.ui.dialogs.InstalledIUGroup.getStructuredViewer()org.eclipse.jface.viewers.StructuredViewer;1
public StructuredViewer getStructuredViewer() {
    return super.getStructuredViewer();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureData.setArch(java.lang.String;)V2
public void setArch(String arch) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.arch;
    this.arch = arch;
    firePropertyChanged(P_ARCH, oldValue, arch);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.getIntro()org.eclipse.ui.intro.IIntroPart;0
public static IIntroPart getIntro() {
    IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
    return introPart;
}
method: org.eclipse.ui.internal.WorkbenchIntroManager.getIntro()org.eclipse.ui.intro.IIntroPart;1
@Override
public IIntroPart getIntro() {
    return introPart;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.launcher.JUnitMigrationDelegate.getJavaModel()org.eclipse.jdt.core.IJavaModel;0
private static IJavaModel getJavaModel() {
    return JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.jdt.ui.JavaUI.getWorkingCopyManager()org.eclipse.jdt.ui.IWorkingCopyManager;0
public static IWorkingCopyManager getWorkingCopyManager() {
    return JavaPlugin.getDefault().getWorkingCopyManager();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getWorkingCopyManager()org.eclipse.jdt.internal.ui.javaeditor.WorkingCopyManager;1
public synchronized WorkingCopyManager getWorkingCopyManager() {
    if (fWorkingCopyManager == null) {
        ICompilationUnitDocumentProvider provider = getCompilationUnitDocumentProvider();
        fWorkingCopyManager = new  WorkingCopyManager(provider);
    }
    return fWorkingCopyManager;
}
---------------Client-------------------
method: org.eclipse.compare.CompareConfiguration.getResourceManager()org.eclipse.jface.resource.ResourceManager;1
private synchronized ResourceManager getResourceManager() {
    if (fResourceManager == null) {
        fResourceManager = new  LocalResourceManager(JFaceResources.getResources());
    }
    return fResourceManager;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering.addListeners()V1
private void addListeners() {
    DebugUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
    addRenderingToSyncService();
    JFaceResources.getFontRegistry().addListener(this);
}
method: org.eclipse.jface.resource.ResourceRegistry.addListener(org.eclipse.jface.util.IPropertyChangeListener;)V2
public void addListener(IPropertyChangeListener listener) {
    addListenerObject(listener);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.packageview.PackageExplorerContentProvider.dispose()V1
@Override
public void dispose() {
    super.dispose();
    JavaCore.removeElementChangedListener(this);
    JavaPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
}
method: org.eclipse.jdt.core.JavaCore.removeElementChangedListener(org.eclipse.jdt.core.IElementChangedListener;)V1
public static void removeElementChangedListener(IElementChangedListener listener) {
    JavaModelManager.getDeltaState().removeElementChangedListener(listener);
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.getIntroModelRoot()org.eclipse.ui.internal.intro.impl.model.IntroModelRoot;1
public IntroModelRoot getIntroModelRoot() {
    return getExtensionPointManager().getCurrentModel();
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.getExtensionPointManager()org.eclipse.ui.internal.intro.impl.model.loader.ExtensionPointManager;1
public ExtensionPointManager getExtensionPointManager() {
    return ExtensionPointManager.getInst();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.comp.CompCSWorkspaceModel.fireModelChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
public void fireModelChanged(IModelChangedEvent event) {
    setDirty(true);
    super.fireModelChanged(event);
}
method: org.eclipse.pde.internal.ua.core.cheatsheet.comp.CompCSWorkspaceModel.setDirty(Z)V2
public void setDirty(boolean dirty) {
    fDirty = dirty;
}
---------------Client-------------------
method: org.apache.lucene.index.IndexWriter.setPayloadProcessorProvider(org.apache.lucene.index.PayloadProcessorProvider;)V2
public void setPayloadProcessorProvider(PayloadProcessorProvider pcp) {
    ensureOpen();
    payloadProcessorProvider = pcp;
}
method: org.apache.lucene.index.IndexWriter.ensureOpen()V1
protected final void ensureOpen() throws AlreadyClosedException {
    ensureOpen(true);
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$ExternalResourcesProject.getTmpProject()org.eclipse.core.resources.IProject;1
private IProject getTmpProject() {
    return ResourcesPlugin.getWorkspace().getRoot().getProject(TMP_PROJECT_NAME);
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}

---------------Library-------------------
method: org.eclipse.ui.ide.undo.AbstractWorkspaceOperation.getExecuteSchedulingRule()org.eclipse.core.runtime.jobs.ISchedulingRule;1
protected ISchedulingRule getExecuteSchedulingRule() {
    return getWorkspace().getRoot();
}
method: org.eclipse.ui.ide.undo.AbstractWorkspaceOperation.getWorkspace()org.eclipse.core.resources.IWorkspace;1
protected IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.getSharedColors()org.eclipse.jface.text.source.ISharedTextColors;1
private ISharedTextColors getSharedColors() {
    return EditorsUI.getSharedTextColors();
}
method: org.eclipse.ui.editors.text.EditorsUI.getSharedTextColors()org.eclipse.jface.text.source.ISharedTextColors;0
public static ISharedTextColors getSharedTextColors() {
    return EditorsPlugin.getDefault().getSharedTextColors();
}

---------------Library-------------------
method: org.eclipse.help.internal.HelpPlugin.logStatus(org.eclipse.core.runtime.IStatus;)V1
private static synchronized void logStatus(IStatus errorStatus) {
    HelpPlugin.getDefault().getLog().log(errorStatus);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.actions.breakpointGroups.SelectBreakpointWorkingsetDialog.addViewerListeners(org.eclipse.jface.viewers.StructuredViewer;)V2
@Override
protected void addViewerListeners(StructuredViewer viewer) {
    CheckboxTableViewer checkViewer = getCheckBoxTableViewer();
    if (checkViewer != null) {
        checkViewer.addCheckStateListener(new  ICheckStateListener() {

            @Override
            public void checkStateChanged(CheckStateChangedEvent event) {
                getCheckBoxTableViewer().setCheckedElements(new Object[] { event.getElement() });
                getButton(IDialogConstants.OK_ID).setEnabled(true);
            }
        });
    }
}
method: org.eclipse.jface.viewers.CheckboxTableViewer.addCheckStateListener(org.eclipse.jface.viewers.ICheckStateListener;)V2
@Override
public void addCheckStateListener(ICheckStateListener listener) {
    checkStateListeners.add(listener);
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.JUnitPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareOutlinePage.dispose()V1
public void dispose() {
    super.dispose();
    if (fCreator != null)
        fCreator.removePropertyChangeListener(this);
    fCreator = null;
}
method: org.eclipse.compare.internal.OutlineViewerCreator.removePropertyChangeListener(org.eclipse.jface.util.IPropertyChangeListener;)V2
public void removePropertyChangeListener(IPropertyChangeListener listener) {
    listeners.remove(listener);
}
---------------Client-------------------
method: org.apache.lucene.index.StoredFieldsWriterPerThread.abort()V1
public void abort() {
    if (doc != null) {
        doc.abort();
        doc = null;
    }
}
method: org.apache.lucene.index.StoredFieldsWriter$PerDoc.abort()V1
@Override
void abort() {
    reset();
    free(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setNL(java.lang.String;)V2
public void setNL(String nl) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fNl;
    this.fNl = nl;
    firePropertyChanged(P_NL, oldValue, nl);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.team.core.mapping.DelegatingStorageMerger.findAndWrapStreamMerger(org.eclipse.core.resources.IStorage;)org.eclipse.team.core.mapping.IStorageMerger;2
private IStorageMerger findAndWrapStreamMerger(IStorage target) {
    IStreamMergerDelegate mergerDelegate = TeamPlugin.getPlugin().getMergerDelegate();
    if (mergerDelegate != null) {
        IStorageMerger merger = mergerDelegate.findMerger(target);
        return merger;
    }
    return null;
}
method: org.eclipse.team.internal.core.TeamPlugin.getMergerDelegate()org.eclipse.team.internal.core.mapping.IStreamMergerDelegate;1
public IStreamMergerDelegate getMergerDelegate() {
    return mergerDelegate;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.BaseExportWizardPage$ExportPart.updateCounter(I)V2
public void updateCounter(int count) {
    super.updateCounter(count);
    pageChanged();
}
method: org.eclipse.pde.internal.ui.parts.WizardCheckboxTablePart.updateCounter(I)V2
protected void updateCounter(int amount) {
    counter = amount;
    updateCounterLabel();
}
---------------Client-------------------
method: org.eclipse.jface.text.MarginPainter.setMarginRulerColumn(I)V2
public void setMarginRulerColumn(int width) {
    fMarginWidth = width;
    initialize();
}
method: org.eclipse.jface.text.MarginPainter.initialize()V1
public void initialize() {
    computeWidgetX();
    fTextWidget.redraw();
}

---------------Library-------------------
method: org.eclipse.ui.internal.cheatsheets.views.ViewItem.getCompleteImage()org.eclipse.swt.graphics.Image;1
Image getCompleteImage() {
    return CheatSheetPlugin.getPlugin().getImage(ICheatSheetResource.CHEATSHEET_ITEM_COMPLETE);
}
method: org.eclipse.ui.internal.cheatsheets.CheatSheetPlugin.getImage(java.lang.String;)org.eclipse.swt.graphics.Image;2
public Image getImage(String key) {
    Image image = getImageRegistry().get(key);
    return image;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.ui.internal.markers.ApiQuickFixProcessor$UnknownAnnotationQuickFix.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return ApiUIPlugin.getSharedImage(IApiToolsConstants.IMG_OBJ_CHANGE_CORRECTION);
}
method: org.eclipse.pde.api.tools.ui.internal.ApiUIPlugin.getSharedImage(java.lang.String;)org.eclipse.swt.graphics.Image;1
public static Image getSharedImage(String key) {
    return getDefault().getImageRegistry().get(key);
}

---------------Library-------------------
method: org.eclipse.core.internal.refresh.RefreshManager.propertyChange(org.eclipse.core.runtime.Preferences$PropertyChangeEvent;)V2
public void propertyChange(PropertyChangeEvent event) {
    String property = event.getProperty();
    if (ResourcesPlugin.PREF_AUTO_REFRESH.equals(property)) {
        Preferences preferences = ResourcesPlugin.getPlugin().getPluginPreferences();
        boolean autoRefresh = preferences.getBoolean(ResourcesPlugin.PREF_AUTO_REFRESH);
        manageAutoRefresh(autoRefresh);
    }
}
method: org.eclipse.core.runtime.Preferences$PropertyChangeEvent.getProperty()java.lang.String;1
public String getProperty() {
    return propertyName;
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.dialogs.WelcomeEditor$10.propertyChange(org.eclipse.jface.util.PropertyChangeEvent;)V2
public void propertyChange(PropertyChangeEvent event) {
    if (JFaceResources.HEADER_FONT.equals(event.getProperty())) {
        messageLabel.setFont(JFaceResources.getHeaderFont());
    }
}
method: org.eclipse.jface.resource.JFaceResources.getHeaderFont()org.eclipse.swt.graphics.Font;0
public static Font getHeaderFont() {
    return getFontRegistry().get(HEADER_FONT);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.event.Activator.stop(org.osgi.framework.BundleContext;)V2
public void stop(BundleContext bundleContext) {
    if (eventAdmin != null) {
        eventAdminService.unregister();
        eventAdmin.deactivate(bundleContext);
    }
}
method: org.eclipse.equinox.internal.event.EventComponent.deactivate(org.osgi.framework.BundleContext;)V2
void deactivate(BundleContext context) {
    eventRedeliverer.close();
    eventAdmin.stop();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.text.ChangeAwareSourceViewerConfiguration.dispose()V1
public void dispose() {
    if (fQuickAssistant != null)
        fQuickAssistant.dispose();
}
method: org.eclipse.pde.internal.ui.editor.text.PDEQuickAssistAssistant.dispose()V1
public void dispose() {
    fCreateImage.dispose();
    fRemoveImage.dispose();
    fRenameImage.dispose();
}

---------------Library-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.internal.ui.contexts.DebugContextManager.getContextService(org.eclipse.ui.IWorkbenchWindow;)org.eclipse.debug.ui.contexts.IDebugContextService;2
@Override
public IDebugContextService getContextService(IWorkbenchWindow window) {
    return createService(window);
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoriesSortingActionGroup.setComparatorOrder(I)V2
void setComparatorOrder(int orderBy) {
    comparator.setOrder(orderBy);
    firePropertyChange(comparator);
}
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryComparator.setOrder(I)V2
public void setOrder(int orderBy) {
    this.orderBy = orderBy;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.setRoot(java.lang.Object;)V2
public void setRoot(Object newRoot) {
    this.fRoot = newRoot;
    initialize();
}
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.initialize()V1
protected void initialize() {
    fTreeViewer.setInput(fRoot);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.CVSProviderPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getPlugin().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.product.ProductDefinitionOperation.modifyExistingFile(org.eclipse.core.resources.IFile;org.eclipse.core.runtime.IProgressMonitor;)V3
private void modifyExistingFile(IFile file, IProgressMonitor monitor) throws CoreException {
    IStatus status = PDEPlugin.getWorkspace().validateEdit(new IFile[] { file }, getShell());
    if (status.getSeverity() != IStatus.OK)
        throw new  CoreException(new  Status(IStatus.ERROR, "org.eclipse.pde.ui", IStatus.ERROR, NLS.bind(PDEUIMessages.ProductDefinitionOperation_readOnly, fPluginId), null));
    ModelModification mod = new  ModelModification(file) {

        protected void modifyModel(IBaseModel model, IProgressMonitor monitor) throws CoreException {
            if (!(model instanceof IPluginModelBase))
                return;
            IPluginExtension extension = findProductExtension((IPluginModelBase) model);
            if (extension == null)
                insertNewExtension((IPluginModelBase) model);
            else
                modifyExistingExtension(extension);
            updateSplashHandler((IPluginModelBase) model, monitor);
            updateSplashProgress((IPluginModelBase) model, monitor);
        }
    };
    PDEModelUtility.modifyModel(mod, monitor);
}
method: org.eclipse.pde.internal.ui.wizards.product.BaseManifestOperation.getShell()org.eclipse.swt.widgets.Shell;1
protected Shell getShell() {
    return fShell;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.product.ProductIntroOperation.modifyExistingFile(org.eclipse.core.resources.IFile;org.eclipse.core.runtime.IProgressMonitor;)V3
private void modifyExistingFile(IFile file, IProgressMonitor monitor) throws CoreException {
    IStatus status = PDEPlugin.getWorkspace().validateEdit(new IFile[] { file }, fShell);
    if (status.getSeverity() != IStatus.OK)
        throw new  CoreException(new  Status(IStatus.ERROR, "org.eclipse.pde.ui", IStatus.ERROR, NLS.bind(PDEUIMessages.ProductDefinitionOperation_readOnly, fPluginId), null));
    ModelModification mod = new  ModelModification(file) {

        protected void modifyModel(IBaseModel model, IProgressMonitor monitor) throws CoreException {
            if (!(model instanceof IPluginModelBase))
                return;
            IPluginModelBase pluginModel = (IPluginModelBase) model;
            IPluginExtension extension = getExtension(pluginModel, INTRO_POINT);
            if (extension == null) {
                extension = createIntroExtension(pluginModel);
                pluginModel.getPluginBase().add(extension);
            } else {
                extension.add(createIntroExtensionContent(extension));
                extension.add(createIntroBindingExtensionContent(extension));
            }
            extension = getExtension(pluginModel, INTRO_CONFIG_POINT);
            if (extension == null) {
                extension = createIntroConfigExtension(pluginModel);
                pluginModel.getPluginBase().add(extension);
            } else {
                extension.add(createIntroConfigExtensionContent(extension));
            }
        }
    };
    PDEModelUtility.modifyModel(mod, monitor);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.mappings.WorkspaceSubscriberContext$8.getProjects()Aorg.eclipse.core.resources.IProject;1
public IProject[] getProjects() {
    return ResourcesPlugin.getWorkspace().getRoot().getProjects();
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.launcher.FeatureBlock$3.doCreateRefreshJob()org.eclipse.ui.progress.WorkbenchJob;1
@Override
protected WorkbenchJob doCreateRefreshJob() {
    WorkbenchJob job = super.doCreateRefreshJob();
    job.addJobChangeListener(new  JobChangeAdapter() {

        @Override
        public void done(IJobChangeEvent event) {
            if (event.getResult().isOK()) {
                getDisplay().asyncExec(new  Runnable() {

                    public void run() {
                        fTree.getControl().setRedraw(false);
                        fTree.removeFilter(fSelectedOnlyFilter);
                        fTree.restoreLeafCheckState();
                        fTree.addFilter(fSelectedOnlyFilter);
                        fTree.getControl().setRedraw(true);
                    }
                });
            }
        }
    });
    return job;
}
method: org.eclipse.core.runtime.jobs.Job.addJobChangeListener(org.eclipse.core.runtime.jobs.IJobChangeListener;)V2
@Override
public final void addJobChangeListener(IJobChangeListener listener) {
    super.addJobChangeListener(listener);
}
---------------Client-------------------
method: org.apache.lucene.index.IndexReader.getCommitUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> getCommitUserData(Directory directory) throws CorruptIndexException, IOException {
    return SegmentInfos.readCurrentUserData(directory);
}
method: org.apache.lucene.index.SegmentInfos.readCurrentUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> readCurrentUserData(Directory directory) throws CorruptIndexException, IOException {
    SegmentInfos sis = new  SegmentInfos();
    sis.read(directory);
    return sis.getUserData();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.delegates.DelegateMethodCreator.createExpressionStatement(org.eclipse.jdt.core.dom.MethodInvocation;)org.eclipse.jdt.core.dom.ExpressionStatement;2
private ExpressionStatement createExpressionStatement(final MethodInvocation invocation) {
    Assert.isNotNull(invocation);
    return invocation.getAST().newExpressionStatement(invocation);
}
method: org.eclipse.jdt.core.dom.AST.newExpressionStatement(org.eclipse.jdt.core.dom.Expression;)org.eclipse.jdt.core.dom.ExpressionStatement;2
public ExpressionStatement newExpressionStatement(Expression expression) {
    ExpressionStatement result = new  ExpressionStatement(this);
    result.setExpression(expression);
    return result;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractConstantRefactoring.getConstantTypeName()java.lang.String;1
private String getConstantTypeName() throws JavaModelException {
    return ASTNodes.asString(getConstantType());
}
method: org.eclipse.jdt.internal.corext.dom.ASTNodes.asString(org.eclipse.jdt.core.dom.ASTNode;)java.lang.String;1
public static String asString(ASTNode node) {
    ASTFlattener flattener = new  ASTFlattener();
    node.accept(flattener);
    return flattener.getResult();
}

---------------Library-------------------
method: org.eclipse.ui.wizards.newresource.BasicNewFolderResourceWizard.initializeDefaultPageImageDescriptor()V1
protected void initializeDefaultPageImageDescriptor() {
    ImageDescriptor desc = IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/newfolder_wiz.png");
    setDefaultPageImageDescriptor(desc);
}
method: org.eclipse.jface.wizard.Wizard.setDefaultPageImageDescriptor(org.eclipse.jface.resource.ImageDescriptor;)V2
public void setDefaultPageImageDescriptor(ImageDescriptor imageDescriptor) {
    defaultImageDescriptor = imageDescriptor;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Link$2.getDefaultAction(org.eclipse.swt.accessibility.AccessibleControlEvent;)V2
@Override
public void getDefaultAction(AccessibleControlEvent e) {
    e.result = SWT.getMessage("SWT_Press");
}
method: org.eclipse.swt.SWT.getMessage(java.lang.String;)java.lang.String;1
public static String getMessage(String key) {
    return Compatibility.getMessage(key);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.connection.CVSRepositoryLocation.getParentPreferences()org.osgi.service.prefs.Preferences;0
public static Preferences getParentPreferences() {
    return CVSProviderPlugin.getPlugin().getInstancePreferences().node(PREF_REPOSITORIES_NODE);
}
method: org.eclipse.team.internal.ccvs.core.CVSProviderPlugin.getInstancePreferences()org.osgi.service.prefs.Preferences;1
public org.osgi.service.prefs.Preferences getInstancePreferences() {
    return InstanceScope.INSTANCE.getNode(getBundle().getSymbolicName());
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberChangeSetManager.getParentPreferences()org.osgi.service.prefs.Preferences;0
private static Preferences getParentPreferences() {
    return getTeamPreferences().node(PREF_CHANGE_SETS);
}
method: org.eclipse.team.internal.core.subscribers.SubscriberChangeSetManager.getTeamPreferences()org.osgi.service.prefs.Preferences;0
private static Preferences getTeamPreferences() {
    return InstanceScope.INSTANCE.getNode(TeamPlugin.getPlugin().getBundle().getSymbolicName());
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringWizardDialog.configureShell(org.eclipse.swt.widgets.Shell;)V2
protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    getRefactoringWizard().getRefactoring().setValidationContext(newShell);
}
method: org.eclipse.ltk.core.refactoring.Refactoring.setValidationContext(java.lang.Object;)V2
public final void setValidationContext(Object context) {
    fValidationContext = context;
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.history.RefactoringPropertyPage.setVisible(Z)V2
public void setVisible(final boolean visible) {
    fHasProjectHistory = hasSharedRefactoringHistory();
    super.setVisible(visible);
}
method: org.eclipse.ltk.internal.ui.refactoring.history.RefactoringPropertyPage.hasSharedRefactoringHistory()Z1
private boolean hasSharedRefactoringHistory() {
    final IProject project = getCurrentProject();
    if (project != null)
        return RefactoringHistoryService.hasSharedRefactoringHistory(project);
    return false;
}

---------------Library-------------------
method: org.eclipse.ui.externaltools.internal.launchConfigurations.ExternalToolsMainTab.getValue(java.lang.String;)java.lang.String;2
private String getValue(String expression) throws CoreException {
    IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();
    return manager.performStringSubstitution(expression);
}
method: org.eclipse.core.internal.variables.StringVariableManager.performStringSubstitution(java.lang.String;)java.lang.String;2
@Override
public String performStringSubstitution(String expression) throws CoreException {
    return performStringSubstitution(expression, true);
}
---------------Client-------------------
method: org.eclipse.core.runtime.Platform.getPluginStateLocation(org.eclipse.core.runtime.Plugin;)org.eclipse.core.runtime.IPath;1
@Deprecated
public static IPath getPluginStateLocation(Plugin plugin) {
    return plugin.getStateLocation();
}
method: org.eclipse.core.runtime.Plugin.getStateLocation()org.eclipse.core.runtime.IPath;1
public final IPath getStateLocation() throws IllegalStateException {
    return InternalPlatform.getDefault().getStateLocation(getBundle(), true);
}

---------------Library-------------------
method: org.eclipse.ui.externaltools.internal.launchConfigurations.ExternalToolsMainTab.getValue(java.lang.String;)java.lang.String;2
private String getValue(String expression) throws CoreException {
    IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();
    return manager.performStringSubstitution(expression);
}
method: org.eclipse.core.variables.VariablesPlugin.getStringVariableManager()org.eclipse.core.variables.IStringVariableManager;1
public IStringVariableManager getStringVariableManager() {
    return StringVariableManager.getDefault();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.CompliancePreferencePage.setVisible(Z)V2
@Override
public void setVisible(boolean visible) {
    super.setVisible(visible);
    if (visible && fConfigurationBlock != null) {
        fConfigurationBlock.refreshComplianceSettings();
    }
}
method: org.eclipse.jface.dialogs.DialogPage.setVisible(Z)V2
@Override
public void setVisible(boolean visible) {
    control.setVisible(visible);
}
---------------Client-------------------
method: org.eclipse.ui.internal.forms.widgets.FormHeading$MessageRegion.updateToolTip(java.lang.String;)V2
public void updateToolTip(String toolTip) {
    Control control = getMessageControl();
    if (control != null)
        control.setToolTipText(toolTip);
}
method: org.eclipse.ui.internal.forms.widgets.FormHeading$MessageRegion.getMessageControl()org.eclipse.swt.widgets.Control;1
public Control getMessageControl() {
    if (needHyperlink() && messageHyperlink != null)
        return messageHyperlink;
    return messageLabel;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.processSequential(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;3
protected GenericSequentialFlowInfo processSequential(ASTNode parent, ASTNode node1) {
    GenericSequentialFlowInfo result = createSequential(parent);
    if (node1 != null)
        result.merge(getFlowInfo(node1), fFlowContext);
    return result;
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo.merge(org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowContext;)V3
public void merge(FlowInfo info, FlowContext context) {
    if (info == null)
        return;
    mergeSequential(info, context);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.navigator.JavaNavigatorLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object element) {
    return delegeteLabelProvider.getText(element);
}
method: org.eclipse.jdt.internal.ui.packageview.PackageExplorerLabelProvider.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(Object element) {
    String text = getSpecificText(element);
    if (text != null) {
        return decorateText(text, element);
    }
    return super.getText(element);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousRequestMonitor.getUpdateSchedulingRule()org.eclipse.core.runtime.jobs.ISchedulingRule;1
protected ISchedulingRule getUpdateSchedulingRule() {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(getModel().getViewer());
}
method: org.eclipse.debug.internal.ui.viewers.AsynchronousModel.getViewer()org.eclipse.debug.internal.ui.viewers.AsynchronousViewer;1
protected AsynchronousViewer getViewer() {
    return fViewer;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousRequestMonitor.getUpdateSchedulingRule()org.eclipse.core.runtime.jobs.ISchedulingRule;1
protected ISchedulingRule getUpdateSchedulingRule() {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(getModel().getViewer());
}
method: org.eclipse.debug.internal.ui.viewers.AsynchronousRequestMonitor.getModel()org.eclipse.debug.internal.ui.viewers.AsynchronousModel;1
protected AsynchronousModel getModel() {
    return fModel;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousRequestMonitor.getUpdateSchedulingRule()org.eclipse.core.runtime.jobs.ISchedulingRule;1
protected ISchedulingRule getUpdateSchedulingRule() {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(getModel().getViewer());
}
method: org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory.newSerialPerObjectRule(java.lang.Object;)org.eclipse.core.runtime.jobs.ISchedulingRule;2
public ISchedulingRule newSerialPerObjectRule(Object lock) {
    return new  SerialPerObjectRule(lock);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.commands.actions.TerminateAllAction.getContext()org.eclipse.jface.viewers.ISelection;1
@Override
protected ISelection getContext() {
    return new  StructuredSelection(getLaunchManager().getLaunches());
}
method: org.eclipse.debug.internal.ui.commands.actions.TerminateAllAction.getLaunchManager()org.eclipse.debug.core.ILaunchManager;1
private ILaunchManager getLaunchManager() {
    return DebugPlugin.getDefault().getLaunchManager();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.WhileStatement;)V2
@Override
public void endVisit(WhileStatement node) {
    if (skipNode(node))
        return;
    WhileFlowInfo info = createWhile();
    setFlowInfo(node, info);
    info.mergeCondition(getFlowInfo(node.getExpression()), fFlowContext);
    info.mergeAction(getFlowInfo(node.getBody()), fFlowContext);
    info.removeLabel(null);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.WhileFlowInfo.mergeAction(org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowContext;)V3
public void mergeAction(FlowInfo info, FlowContext context) {
    if (info == null)
        return;
    info.mergeEmptyCondition(context);
    mergeSequential(info, context);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.InputFlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.DoStatement;)V2
@Override
public void endVisit(DoStatement node) {
    super.endVisit(node);
    handleLoopReentrance(node);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.DoStatement;)V2
@Override
public void endVisit(DoStatement node) {
    if (skipNode(node))
        return;
    DoWhileFlowInfo info = createDoWhile();
    setFlowInfo(node, info);
    info.mergeAction(getFlowInfo(node.getBody()), fFlowContext);
    info.mergeCondition(getFlowInfo(node.getExpression()), fFlowContext);
    info.removeLabel(null);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.product.WorkspaceProductModel.fireModelChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
public void fireModelChanged(IModelChangedEvent event) {
    setDirty(true);
    super.fireModelChanged(event);
}
method: org.eclipse.pde.internal.core.product.WorkspaceProductModel.setDirty(Z)V2
public void setDirty(boolean dirty) {
    fDirty = dirty;
}
---------------Client-------------------
method: org.apache.lucene.index.IndexWriter.setPayloadProcessorProvider(org.apache.lucene.index.PayloadProcessorProvider;)V2
public void setPayloadProcessorProvider(PayloadProcessorProvider pcp) {
    ensureOpen();
    payloadProcessorProvider = pcp;
}
method: org.apache.lucene.index.IndexWriter.ensureOpen()V1
protected final void ensureOpen() throws AlreadyClosedException {
    ensureOpen(true);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getImageDescriptor(String key) {
    return getImageRegistry().getDescriptor(key);
}
method: org.eclipse.jface.resource.ImageRegistry.getDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public ImageDescriptor getDescriptor(String key) {
    Entry entry = getEntry(key);
    if (entry == null) {
        return null;
    }
    return entry.descriptor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setProviderName(java.lang.String;)V2
public void setProviderName(String providerName) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fProviderName;
    this.fProviderName = providerName;
    firePropertyChanged(P_PROVIDER, oldValue, providerName);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.undo.FolderDescription.createResourceHandle()org.eclipse.core.resources.IResource;1
public IResource createResourceHandle() {
    IWorkspaceRoot workspaceRoot = getWorkspace().getRoot();
    IPath folderPath = parent.getFullPath().append(name);
    return workspaceRoot.getFolder(folderPath);
}
method: org.eclipse.ui.internal.ide.undo.AbstractResourceDescription.getWorkspace()org.eclipse.core.resources.IWorkspace;1
IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.LazyJavaCompletionProposal.computeImage()org.eclipse.swt.graphics.Image;1
protected Image computeImage() {
    return JavaPlugin.getImageDescriptorRegistry().get(fInvocationContext.getLabelProvider().createImageDescriptor(fProposal));
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getImageDescriptorRegistry()org.eclipse.jdt.internal.ui.viewsupport.ImageDescriptorRegistry;0
public static ImageDescriptorRegistry getImageDescriptorRegistry() {
    return getDefault().internalGetImageDescriptorRegistry();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.mappings.ModelMergeOperation.createMergeContext()org.eclipse.team.core.mapping.provider.SynchronizationContext;1
protected SynchronizationContext createMergeContext() {
    return MergeSubscriberContext.createContext(getScopeManager(), subscriber);
}
method: org.eclipse.team.internal.ccvs.ui.mappings.MergeSubscriberContext.createContext(org.eclipse.team.core.mapping.ISynchronizationScopeManager;org.eclipse.team.core.subscribers.Subscriber;)org.eclipse.team.internal.ccvs.ui.mappings.MergeSubscriberContext;2
public static MergeSubscriberContext createContext(ISynchronizationScopeManager manager, Subscriber subscriber) {
    MergeSubscriberContext mergeContext = new  MergeSubscriberContext(subscriber, manager);
    mergeContext.initialize();
    return mergeContext;
}
---------------Client-------------------
method: org.eclipse.osgi.framework.eventmgr.EventListeners.entrySet()java.util.Set;1
Set<Map.Entry<K, V>> entrySet() {
    return list.entrySet();
}
method: org.eclipse.osgi.framework.eventmgr.CopyOnWriteIdentityMap.entrySet()java.util.Set;1
public Set<Map.Entry<K, V>> entrySet() {
    return new  Snapshot<K, V>(entries()).entrySet();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.PluginImport.setVersion(java.lang.String;)V2
public void setVersion(String version) throws CoreException {
    ensureModelEditable();
    String oldValue = this.version;
    this.version = version;
    firePropertyChanged(P_VERSION, oldValue, version);
}
method: org.eclipse.pde.internal.core.plugin.PluginObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.ActiveChangeSetCollector.dispose()V1
public void dispose() {
    getActiveChangeSetManager().removeListener(activeChangeSetListener);
}
method: org.eclipse.team.internal.core.subscribers.ChangeSetManager.removeListener(org.eclipse.team.internal.core.subscribers.IChangeSetChangeListener;)V2
public void removeListener(IChangeSetChangeListener listener) {
    listeners.remove(listener);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AccessRuleEntryDialog$TypeRulesAdapter.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    doStatusLineUpdate();
}
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AccessRuleEntryDialog.doStatusLineUpdate()V1
protected void doStatusLineUpdate() {
    checkIfPatternValid();
    updateStatus(fPatternStatus);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.MethodInvocation;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(MethodInvocation node, ITypeBinding type) {
    Expression exp = node.getExpression();
    if (exp == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        exp = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, MethodInvocation.EXPRESSION_PROPERTY, exp, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else if (exp instanceof Name) {
        rewriteName((Name) exp, type);
    } else {
        rewriteExpression(node, exp, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.dom.ASTNodeFactory.newName(org.eclipse.jdt.core.dom.AST;java.lang.String;)org.eclipse.jdt.core.dom.Name;2
public static Name newName(AST ast, String qualifiedName) {
    return ast.newName(qualifiedName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.FieldAccess;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(FieldAccess node, ITypeBinding type) {
    Expression exp = node.getExpression();
    if (exp == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        exp = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, FieldAccess.EXPRESSION_PROPERTY, exp, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else if (exp instanceof Name) {
        rewriteName((Name) exp, type);
    } else {
        rewriteExpression(node, exp, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.CompilationUnitRewrite.getAST()org.eclipse.jdt.core.dom.AST;1
public AST getAST() {
    return getRoot().getAST();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.toc.TocTreeSection.makeNewTocLink(org.eclipse.pde.internal.ua.core.toc.text.TocObject;org.eclipse.core.resources.IFile;)org.eclipse.pde.internal.ua.core.toc.text.TocLink;3
private TocLink makeNewTocLink(TocObject parent, IFile file) {
    return fModel.getFactory().createTocLink(file);
}
method: org.eclipse.pde.internal.ua.core.toc.text.TocDocumentFactory.createTocLink(org.eclipse.core.resources.IFile;)org.eclipse.pde.internal.ua.core.toc.text.TocLink;2
public TocLink createTocLink(IFile file) {
    return new  TocLink(fModel, file);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.MarkerDelta.getMarker()org.eclipse.core.resources.IMarker;1
public IMarker getMarker() {
    return new  Marker(resource, getId());
}
method: org.eclipse.core.internal.resources.MarkerDelta.getId()J1
public long getId() {
    return info.getId();
}

---------------Library-------------------
method: org.eclipse.search.core.text.TextSearchEngine.create()org.eclipse.search.core.text.TextSearchEngine;0
public static TextSearchEngine create() {
    return SearchPlugin.getDefault().getTextSearchEngineRegistry().getPreferred();
}
method: org.eclipse.search.internal.ui.SearchPlugin.getTextSearchEngineRegistry()org.eclipse.search.internal.core.text.TextSearchEngineRegistry;1
public TextSearchEngineRegistry getTextSearchEngineRegistry() {
    if (fTextSearchEngineRegistry == null) {
        fTextSearchEngineRegistry = new  TextSearchEngineRegistry();
    }
    return fTextSearchEngineRegistry;
}
---------------Client-------------------
method: org.eclipse.compare.CompareConfiguration.getResourceManager()org.eclipse.jface.resource.ResourceManager;1
private synchronized ResourceManager getResourceManager() {
    if (fResourceManager == null) {
        fResourceManager = new  LocalResourceManager(JFaceResources.getResources());
    }
    return fResourceManager;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.memory.MemoryBlocksTreeViewPane$1.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
@Override
public void selectionChanged(SelectionChangedEvent event) {
    ISelection treeSelected = event.getSelection();
    fSelectionProvider.setSelection(treeSelected);
}
method: org.eclipse.debug.internal.ui.views.memory.ViewPaneSelectionProvider.setSelection(org.eclipse.jface.viewers.ISelection;)V2
@Override
public void setSelection(ISelection selection) {
    fSelection = selection;
    fireChanged();
}
---------------Client-------------------
method: org.eclipse.ui.internal.editors.text.SelectResourcesDialog$5.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    handleSelectFileTypes();
}
method: org.eclipse.ui.internal.editors.text.SelectResourcesDialog.handleSelectFileTypes()V1
protected void handleSelectFileTypes() {
    Object[] acceptedFileTypes = queryFileTypes();
    if (acceptedFileTypes != null) {
        fAcceptedFileTypes = Arrays.asList(acceptedFileTypes);
        filterSelection();
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureInstallHandler.setLibrary(java.lang.String;)V2
public void setLibrary(String library) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fLibrary;
    this.fLibrary = library;
    firePropertyChanged(P_LIBRARY, oldValue, library);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.core.plugin.PluginRegistry.findModel(org.eclipse.osgi.service.resolver.BundleDescription;)org.eclipse.pde.core.plugin.IPluginModelBase;1
public static IPluginModelBase findModel(BundleDescription desc) {
    return PDECore.getDefault().getModelManager().findModel(desc);
}
method: org.eclipse.pde.internal.core.PDECore.getModelManager()org.eclipse.pde.internal.core.PluginModelManager;1
public PluginModelManager getModelManager() {
    return PluginModelManager.getInstance();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.ChangeSignatureProcessor.setNewReturnTypeName(java.lang.String;)V2
public void setNewReturnTypeName(String newReturnTypeName) {
    Assert.isNotNull(newReturnTypeName);
    fReturnTypeInfo.setNewTypeName(newReturnTypeName);
}
method: org.eclipse.jdt.internal.corext.refactoring.ReturnTypeInfo.setNewTypeName(java.lang.String;)V2
public void setNewTypeName(String type) {
    Assert.isNotNull(type);
    fNewTypeName = type;
}
---------------Client-------------------
method: org.eclipse.jface.text.MarginPainter.setMarginRulerColumn(I)V2
public void setMarginRulerColumn(int width) {
    fMarginWidth = width;
    initialize();
}
method: org.eclipse.jface.text.MarginPainter.initialize()V1
public void initialize() {
    computeWidgetX();
    fTextWidget.redraw();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.PDECore.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    if (status != null)
        ResourcesPlugin.getPlugin().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.RefreshSubscriberParticipantJob.handleProgressGroupSet(org.eclipse.core.runtime.IProgressMonitor;I)V3
protected void handleProgressGroupSet(IProgressMonitor group, int ticks) {
    getCollector().setProgressGroup(group, ticks);
}
method: org.eclipse.team.internal.core.subscribers.SubscriberSyncInfoCollector.setProgressGroup(org.eclipse.core.runtime.IProgressMonitor;I)V3
public void setProgressGroup(IProgressMonitor monitor, int ticks) {
    getEventHandler().setProgressGroupHint(monitor, ticks);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.ClassScope.resolveTypeParameter(org.eclipse.jdt.internal.compiler.ast.TypeParameter;)V2
void resolveTypeParameter(TypeParameter typeParameter) {
    typeParameter.resolve(this);
}
method: org.eclipse.jdt.internal.compiler.ast.TypeParameter.resolve(org.eclipse.jdt.internal.compiler.lookup.ClassScope;)V2
public void resolve(ClassScope scope) {
    internalResolve(scope, scope.enclosingSourceType().isStatic());
}

---------------Library-------------------
method: org.eclipse.compare.internal.patch.PreviewPatchPage2$19.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    fInput.setShowMatched(showMatched.getSelection());
    rebuildTree();
}
method: org.eclipse.compare.internal.patch.PatchCompareEditorInput.setShowMatched(Z)V2
protected void setShowMatched(boolean show) {
    showMatched = show;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.ImportFromInstallationPage$2$1.run()V1
public void run() {
    des = getDestinationValue();
}
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.AbstractPage.getDestinationValue()java.lang.String;1
protected String getDestinationValue() {
    return destinationNameField.getText().trim();
}

---------------Library-------------------
method: org.eclipse.search.internal.ui.SearchResultView$2.run()V1
public void run() {
    getViewer().setGotoMarkerAction(gotoMarkerAction);
}
method: org.eclipse.search.internal.ui.SearchResultViewer.setGotoMarkerAction(org.eclipse.jface.action.IAction;)V2
void setGotoMarkerAction(IAction gotoMarkerAction) {
    fGotoMarkerAction = gotoMarkerAction;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$FileTextDragListener.dragSetData(org.eclipse.swt.dnd.DragSourceEvent;)V2
public void dragSetData(DragSourceEvent event) {
    event.data = element.getText();
}
method: org.eclipse.compare.internal.CompareWithOtherResourceDialog$ContentTypeElement.getText()java.lang.String;1
protected String getText() {
    return text.getText();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.rename.RenamePackageProcessor.getNewPackage()org.eclipse.jdt.core.IPackageFragment;1
private IPackageFragment getNewPackage() {
    IPackageFragmentRoot root = getPackageFragmentRoot();
    return root.getPackageFragment(getNewElementName());
}
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.getPackageFragment(java.lang.String;)org.eclipse.jdt.core.IPackageFragment;2
public IPackageFragment getPackageFragment(String packageName) {
    String[] pkgName = Util.getTrimmedSimpleNames(packageName);
    return getPackageFragment(pkgName);
}
---------------Client-------------------
method: org.eclipse.compare.internal.patch.WorkspaceFileDiffResult.getTargetFile()org.eclipse.core.resources.IFile;1
public IFile getTargetFile() {
    return getPatcher().getTargetFile(getDiff());
}
method: org.eclipse.compare.internal.patch.WorkspaceFileDiffResult.getPatcher()org.eclipse.compare.internal.patch.Patcher;1
protected Patcher getPatcher() {
    return Patcher.getPatcher(getConfiguration());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.ImportPage.setDestinationValue(java.lang.String;)V2
@Override
protected void setDestinationValue(String selectedFileName) {
    oldDestination = getDestinationValue();
    super.setDestinationValue(selectedFileName);
}
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.AbstractPage.setDestinationValue(java.lang.String;)V2
protected void setDestinationValue(String selectedFileName) {
    destinationNameField.setText(selectedFileName);
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberSyncInfoCollector.setRoots(Aorg.eclipse.core.resources.IResource;)V2
public void setRoots(IResource[] roots) {
    this.roots = roots;
    reset();
}
method: org.eclipse.team.internal.core.subscribers.SubscriberSyncInfoCollector.reset()V1
public void reset() {
    eventHandler.reset(getRoots());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.scheduler.migration.MigrationPage$ImportExportFilteredTree.doCreateRefreshJob()org.eclipse.ui.progress.WorkbenchJob;1
@Override
protected WorkbenchJob doCreateRefreshJob() {
    WorkbenchJob job = super.doCreateRefreshJob();
    job.addJobChangeListener(new  JobChangeAdapter() {

        @Override
        public void aboutToRun(IJobChangeEvent event) {
            Display.getDefault().syncExec(new  Runnable() {

                public void run() {
                    Object[] checked = viewer.getCheckedElements();
                    if (checkState == null)
                        checkState = new  ArrayList<Object>(checked.length);
                    for (int i = 0; i < checked.length; i++) if (!viewer.getGrayed(checked[i]))
                        if (!checkState.contains(checked[i]))
                            checkState.add(checked[i]);
                }
            });
        }

        @Override
        public void done(IJobChangeEvent event) {
            if (event.getResult().isOK()) {
                Display.getDefault().asyncExec(new  Runnable() {

                    public void run() {
                        if (viewer == null || viewer.getTree().isDisposed())
                            return;
                        if (checkState == null)
                            return;
                        viewer.setCheckedElements(new Object[0]);
                        viewer.setGrayedElements(new Object[0]);
                        Iterator<Object> iter = checkState.iterator();
                        while (iter.hasNext()) {
                            viewer.setChecked(iter.next(), true);
                        }
                        updatePageCompletion();
                    }
                });
            }
        }
    });
    return job;
}
method: org.eclipse.core.runtime.jobs.Job.addJobChangeListener(org.eclipse.core.runtime.jobs.IJobChangeListener;)V2
@Override
public final void addJobChangeListener(IJobChangeListener listener) {
    super.addJobChangeListener(listener);
}
---------------Client-------------------
method: org.apache.lucene.index.IndexReader.getCommitUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> getCommitUserData(Directory directory) throws CorruptIndexException, IOException {
    return SegmentInfos.readCurrentUserData(directory);
}
method: org.apache.lucene.index.SegmentInfos.readCurrentUserData(org.apache.lucene.store.Directory;)java.util.Map;1
public static Map<String, String> readCurrentUserData(Directory directory) throws CorruptIndexException, IOException {
    SegmentInfos sis = new  SegmentInfos();
    sis.read(directory);
    return sis.getUserData();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setArch(java.lang.String;)V2
public void setArch(String arch) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fArch;
    this.fArch = arch;
    firePropertyChanged(P_ARCH, oldValue, arch);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.tools.UpdateBuildpathWizardPage.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.jface.dialogs.DialogPage.dispose()V1
@Override
public void dispose() {
    if (image != null) {
        image.dispose();
        image = null;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.SynchronizePageDropDownAction.dispose()V1
public void dispose() {
    if (menuManager != null) {
        menuManager.dispose();
        menuManager = null;
    }
    TeamUI.getSynchronizeManager().removeSynchronizeParticipantListener(this);
}
method: org.eclipse.team.ui.TeamUI.getSynchronizeManager()org.eclipse.team.ui.synchronize.ISynchronizeManager;0
public static ISynchronizeManager getSynchronizeManager() {
    return TeamUIPlugin.getPlugin().getSynchronizeManager();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSRefactoring.getAccessorClassFileHandle()org.eclipse.core.resources.IFile;1
public IFile getAccessorClassFileHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getFile(getAccessorClassFilePath());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSRefactoring.getAccessorClassFileHandle()org.eclipse.core.resources.IFile;1
public IFile getAccessorClassFileHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getFile(getAccessorClassFilePath());
}
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSRefactoring.getAccessorClassFilePath()org.eclipse.core.runtime.IPath;1
public IPath getAccessorClassFilePath() {
    return getAccessorCUPath();
}
---------------Client-------------------
method: org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne$LocationGroup.getDefaultPath(java.lang.String;)java.lang.String;2
protected String getDefaultPath(String name) {
    final IPath path = Platform.getLocation().append(name);
    return path.toOSString();
}
method: org.eclipse.core.runtime.Platform.getLocation()org.eclipse.core.runtime.IPath;0
public static IPath getLocation() throws IllegalStateException {
    return InternalPlatform.getDefault().getLocation();
}

---------------Library-------------------
method: org.eclipse.ui.console.ConsolePlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteCategoryDefinition.setDescription(org.eclipse.pde.internal.core.isite.ISiteDescription;)V2
public void setDescription(ISiteDescription description) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.description;
    this.description = description;
    firePropertyChanged(P_DESCRIPTION, oldValue, description);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.Site.setURL(java.lang.String;)V2
public void setURL(String url) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.url;
    this.url = url;
    firePropertyChanged(P_URL, oldValue, url);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.bundle.BundlePluginBase.getTranslatedName()java.lang.String;1
public String getTranslatedName() {
    return getResourceString(getName());
}
method: org.eclipse.pde.internal.core.bundle.BundlePluginBase.getResourceString(java.lang.String;)java.lang.String;2
public String getResourceString(String key) {
    return model.getResourceString(key);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.search.NLSSearchResult.getTooltip()java.lang.String;1
public String getTooltip() {
    return getLabel();
}
method: org.eclipse.jdt.internal.ui.refactoring.nls.search.NLSSearchResult.getLabel()java.lang.String;1
public String getLabel() {
    return fQuery.getResultLabel(getMatchCount());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.MemberRef;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(MemberRef node, ITypeBinding type) {
    Name qualifier = node.getQualifier();
    if (qualifier == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        qualifier = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, MemberRef.QUALIFIER_PROPERTY, qualifier, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else {
        rewriteName(qualifier, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.dom.ASTNodeFactory.newName(org.eclipse.jdt.core.dom.AST;java.lang.String;)org.eclipse.jdt.core.dom.Name;2
public static Name newName(AST ast, String qualifiedName) {
    return ast.newName(qualifiedName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveStaticMemberAnalyzer.rewrite(org.eclipse.jdt.core.dom.MethodRef;org.eclipse.jdt.core.dom.ITypeBinding;)V3
protected void rewrite(MethodRef node, ITypeBinding type) {
    Name qualifier = node.getQualifier();
    if (qualifier == null) {
        ImportRewriteContext context = new  ContextSensitiveImportRewriteContext(node, fCuRewrite.getImportRewrite());
        Type result = fCuRewrite.getImportRewrite().addImport(type, fCuRewrite.getAST(), context);
        fCuRewrite.getImportRemover().registerAddedImport(type.getQualifiedName());
        qualifier = ASTNodeFactory.newName(fCuRewrite.getAST(), ASTFlattener.asString(result));
        fCuRewrite.getASTRewrite().set(node, MethodRef.QUALIFIER_PROPERTY, qualifier, fCuRewrite.createGroupDescription(REFERENCE_UPDATE));
        fNeedsImport = true;
    } else {
        rewriteName(qualifier, type);
    }
    fProcessed.add(node.getName());
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.CompilationUnitRewrite.getAST()org.eclipse.jdt.core.dom.AST;1
public AST getAST() {
    return getRoot().getAST();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.Site.setType(java.lang.String;)V2
public void setType(String type) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.type;
    this.type = type;
    firePropertyChanged(P_TYPE, oldValue, type);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setName(java.lang.String;)V2
public void setName(String name) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fName;
    this.fName = name;
    firePropertyChanged(P_NAME, oldValue, name);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchConfigurationTabImageDescriptor.getSize()org.eclipse.swt.graphics.Point;1
@Override
protected Point getSize() {
    if (fSize == null) {
        ImageData data = getBaseImage().getImageData();
        setSize(new  Point(data.width, data.height));
    }
    return fSize;
}
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchConfigurationTabImageDescriptor.setSize(org.eclipse.swt.graphics.Point;)V2
protected void setSize(Point size) {
    fSize = size;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.ChangeSignatureProcessor$OccurrenceUpdate.getImportRemover()org.eclipse.jdt.internal.corext.refactoring.structure.ImportRemover;1
protected final ImportRemover getImportRemover() {
    return fCuRewrite.getImportRemover();
}
method: org.eclipse.jdt.internal.corext.refactoring.structure.CompilationUnitRewrite.getImportRemover()org.eclipse.jdt.internal.corext.refactoring.structure.ImportRemover;1
public ImportRemover getImportRemover() {
    if (fImportRemover == null) {
        fImportRemover = new  ImportRemover(fCu.getJavaProject(), getRoot());
    }
    return fImportRemover;
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.E4Workbench.getServiceContext()org.eclipse.e4.core.contexts.IEclipseContext;0
public static IEclipseContext getServiceContext() {
    return EclipseContextFactory.getServiceContext(Activator.getDefault().getContext());
}
method: org.eclipse.e4.ui.internal.workbench.Activator.getContext()org.osgi.framework.BundleContext;1
public BundleContext getContext() {
    return context;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.team.ui.mapping.SynchronizationContentProvider.getScope()org.eclipse.team.core.mapping.ISynchronizationScope;1
protected ISynchronizationScope getScope() {
    ICommonContentExtensionSite extensionSite = getExtensionSite();
    if (extensionSite != null)
        return (ISynchronizationScope) extensionSite.getExtensionStateModel().getProperty(ITeamContentProviderManager.P_SYNCHRONIZATION_SCOPE);
    return null;
}
method: org.eclipse.ui.internal.navigator.extensions.ExtensionStateModel.getProperty(java.lang.String;)java.lang.Object;2
public Object getProperty(String aPropertyName) {
    return values.get(aPropertyName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.delegates.DelegateMethodCreator.getDeclarationBinding()org.eclipse.jdt.core.dom.IBinding;1
@Override
protected IBinding getDeclarationBinding() {
    final MethodDeclaration declaration = (MethodDeclaration) getDeclaration();
    return declaration.resolveBinding();
}
method: org.eclipse.jdt.core.dom.MethodDeclaration.resolveBinding()org.eclipse.jdt.core.dom.IMethodBinding;1
public IMethodBinding resolveBinding() {
    return this.ast.getBindingResolver().resolveMethod(this);
}

---------------Library-------------------
method: org.eclipse.ui.wizards.datatransfer.WizardExternalProjectImportPage.getProjectHandle()org.eclipse.core.resources.IProject;1
public IProject getProjectHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.ui.wizards.datatransfer.WizardExternalProjectImportPage.getProjectHandle()org.eclipse.core.resources.IProject;1
public IProject getProjectHandle() {
    return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
}
method: org.eclipse.ui.wizards.datatransfer.WizardExternalProjectImportPage.getProjectName()java.lang.String;1
public String getProjectName() {
    return getProjectNameFieldValue();
}
---------------Client-------------------
method: org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne$LocationGroup.getDefaultPath(java.lang.String;)java.lang.String;2
protected String getDefaultPath(String name) {
    final IPath path = Platform.getLocation().append(name);
    return path.toOSString();
}
method: org.eclipse.core.runtime.Platform.getLocation()org.eclipse.core.runtime.IPath;0
public static IPath getLocation() throws IllegalStateException {
    return InternalPlatform.getDefault().getLocation();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureInstallHandler.setHandlerName(java.lang.String;)V2
public void setHandlerName(String handlerName) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fHandlerName;
    this.fHandlerName = handlerName;
    firePropertyChanged(P_HANDLER_NAME, oldValue, handlerName);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.apache.batik.util.gui.DropDownComponent$2.itemsWereAdded(org.apache.batik.util.gui.DropDownComponent$ScrollablePopupMenuEvent;)V2
public void itemsWereAdded(ScrollablePopupMenuEvent ev) {
    updateMainButtonTooltip(ev.getDetails());
}
method: org.apache.batik.util.gui.DropDownComponent.updateMainButtonTooltip(java.lang.String;)V2
public void updateMainButtonTooltip(String newTooltip) {
    mainButton.setToolTipText(newTooltip);
}
---------------Client-------------------
method: org.eclipse.equinox.p2.ui.InstalledSoftwarePage$1.addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener;)V2
public void addSelectionChangedListener(ISelectionChangedListener listener) {
    installedIUGroup.getStructuredViewer().addSelectionChangedListener(listener);
}
method: org.eclipse.equinox.internal.p2.ui.dialogs.InstalledIUGroup.getStructuredViewer()org.eclipse.jface.viewers.StructuredViewer;1
public StructuredViewer getStructuredViewer() {
    return super.getStructuredViewer();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteObject.setLabel(java.lang.String;)V2
public void setLabel(String newLabel) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.label;
    label = newLabel;
    firePropertyChanged(P_LABEL, oldValue, newLabel);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.RefactoringScopeFactory.createRelatedProjectsScope(org.eclipse.jdt.core.IJavaProject;I)org.eclipse.jdt.core.search.IJavaSearchScope;2
public static IJavaSearchScope createRelatedProjectsScope(IJavaProject project, int includeMask) throws CoreException {
    IJavaProject[] projects = getRelatedProjects(project);
    return SearchEngine.createJavaSearchScope(projects, includeMask);
}
method: org.eclipse.jdt.core.search.SearchEngine.createJavaSearchScope(Aorg.eclipse.jdt.core.IJavaElement;I)org.eclipse.jdt.core.search.IJavaSearchScope;2
public static IJavaSearchScope createJavaSearchScope(IJavaElement[] elements, int includeMask) {
    return BasicSearchEngine.createJavaSearchScope(elements, includeMask);
}
---------------Client-------------------
method: org.eclipse.e4.ui.model.application.ui.impl.UIElementImpl.getLocalizedAccessibilityPhrase()java.lang.String;1
public String getLocalizedAccessibilityPhrase() {
    return LocalizationHelper.getLocalizedAccessibilityPhrase(this);
}
method: org.eclipse.e4.ui.model.LocalizationHelper.getLocalizedAccessibilityPhrase(org.eclipse.e4.ui.model.application.ui.MUIElement;)java.lang.String;1
public static String getLocalizedAccessibilityPhrase(MUIElement element) {
    String key = element.getAccessibilityPhrase();
    if (key == null)
        return null;
    return getLocalized(key, element);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.SiteDescription.setName(java.lang.String;)V2
public void setName(String name) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.name;
    this.name = name;
    firePropertyChanged(P_URL, oldValue, name);
}
method: org.eclipse.pde.internal.core.site.SiteObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.TableEditorImpl.applyEditorValue()V1
public void applyEditorValue() {
    CellEditor c = fCellEditor;
    if (c != null) {
        fCellEditor = null;
        Item t = fTableItem;
        if (t != null && !t.isDisposed()) {
            saveEditorValue(c, t);
        }
        setEditor(null, null, 0);
        c.removeListener(fCellEditorListener);
        Control control = c.getControl();
        if (control != null) {
            if (fMouseListener != null) {
                control.removeMouseListener(fMouseListener);
            }
            if (fFocusListener != null) {
                control.removeFocusListener(fFocusListener);
            }
        }
        c.deactivate();
    }
}
method: org.eclipse.jface.viewers.CellEditor.removeListener(org.eclipse.jface.viewers.ICellEditorListener;)V2
public void removeListener(ICellEditorListener listener) {
    listeners.remove(listener);
}
---------------Client-------------------
method: org.eclipse.jface.viewers.TableTreeViewer$TableTreeEditorImpl$1.focusLost(org.eclipse.swt.events.FocusEvent;)V2
@Override
public void focusLost(FocusEvent e) {
    applyEditorValue();
}
method: org.eclipse.jface.viewers.TableTreeViewer$TableTreeEditorImpl.applyEditorValue()V1
public void applyEditorValue() {
    CellEditor c = this.cellEditor;
    if (c != null) {
        this.cellEditor = null;
        Item t = this.tableItem;
        if (t != null && !t.isDisposed()) {
            saveEditorValue(c, t);
        }
        setEditor(null, null, 0);
        c.removeListener(cellEditorListener);
        Control control = c.getControl();
        if (control != null) {
            if (mouseListener != null) {
                control.removeMouseListener(mouseListener);
            }
            if (focusListener != null) {
                control.removeFocusListener(focusListener);
            }
        }
        c.deactivate();
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.Feature.setPlugin(java.lang.String;)V2
public void setPlugin(String plugin) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.fPlugin;
    this.fPlugin = plugin;
    firePropertyChanged(P_PLUGIN, oldValue, plugin);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.wizards.newresource.BasicNewResourceWizard.initializeDefaultPageImageDescriptor()V1
protected void initializeDefaultPageImageDescriptor() {
    ImageDescriptor desc = IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/new_wiz.png");
    setDefaultPageImageDescriptor(desc);
}
method: org.eclipse.jface.wizard.Wizard.setDefaultPageImageDescriptor(org.eclipse.jface.resource.ImageDescriptor;)V2
public void setDefaultPageImageDescriptor(ImageDescriptor imageDescriptor) {
    defaultImageDescriptor = imageDescriptor;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Link$2.getDefaultAction(org.eclipse.swt.accessibility.AccessibleControlEvent;)V2
@Override
public void getDefaultAction(AccessibleControlEvent e) {
    e.result = SWT.getMessage("SWT_Press");
}
method: org.eclipse.swt.SWT.getMessage(java.lang.String;)java.lang.String;1
public static String getMessage(String key) {
    return Compatibility.getMessage(key);
}

---------------Library-------------------
method: org.eclipse.ui.externaltools.internal.model.ExternalToolsImages.getImageDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor getImageDescriptor(String key) {
    return getImageRegistry().getDescriptor(key);
}
method: org.eclipse.jface.resource.ImageRegistry.getDescriptor(java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
public ImageDescriptor getDescriptor(String key) {
    Entry entry = getEntry(key);
    if (entry == null) {
        return null;
    }
    return entry.descriptor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.keys.FormalKeyFormatter.format(org.eclipse.ui.keys.Key;)java.lang.String;2
@Override
public String format(Key key) {
    return key.toString();
}
method: org.eclipse.ui.keys.Key.toString()java.lang.String;1
@Override
public final String toString() {
    final IKeyLookup lookup = KeyLookupFactory.getDefault();
    return lookup.formalNameLookup(key);
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.browser.embedded.EmbeddedBrowserAdapter.uiSetLocation(II)V3
private void uiSetLocation(int x, int y) {
    getBrowser().setLocation(x, y);
}
method: org.eclipse.help.ui.internal.browser.embedded.EmbeddedBrowser.setLocation(II)V3
public void setLocation(int x, int y) {
    shell.setLocation(x, y);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.MethodScope.resolveTypeParameter(org.eclipse.jdt.internal.compiler.ast.TypeParameter;)V2
void resolveTypeParameter(TypeParameter typeParameter) {
    typeParameter.resolve(this);
}
method: org.eclipse.jdt.internal.compiler.ast.TypeParameter.resolve(org.eclipse.jdt.internal.compiler.lookup.BlockScope;)V2
public void resolve(BlockScope scope) {
    internalResolve(scope, scope.methodScope().isStatic);
}

---------------Library-------------------
method: org.eclipse.search.internal.ui.SearchPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getDefault().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction.getMenu(org.eclipse.swt.widgets.Menu;)org.eclipse.swt.widgets.Menu;2
public Menu getMenu(Menu parent) {
    setMenu(new  Menu(parent));
    fillMenu(fMenu);
    initMenu(fMenu);
    return fMenu;
}
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction.initMenu(org.eclipse.swt.widgets.Menu;)V2
protected void initMenu(Menu menu) {
    menu.addMenuListener(new  MenuAdapter() {

        @Override
        public void menuShown(MenuEvent e) {
            Menu m = (Menu) e.widget;
            MenuItem[] items = m.getItems();
            for (int i = 0; i < items.length; i++) {
                items[i].dispose();
            }
            fillMenu(m);
        }
    });
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.outline.QuickOutlinePopupDialog.createTitleControl(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
protected Control createTitleControl(Composite parent) {
    createUIWidgetFilterText(parent);
    createUIListenersFilterText();
    return fFilterText;
}
method: org.eclipse.pde.internal.ui.editor.outline.QuickOutlinePopupDialog.createUIListenersFilterText()V1
private void createUIListenersFilterText() {
    fFilterText.addKeyListener(new  KeyListener() {

        public void keyPressed(KeyEvent e) {
            if (e.keyCode == 0x0D) {
                gotoSelectedElement();
            } else if (e.keyCode == SWT.ARROW_DOWN) {
                fTreeViewer.getTree().setFocus();
            } else if (e.keyCode == SWT.ARROW_UP) {
                fTreeViewer.getTree().setFocus();
            } else if (e.character == 0x1B) {
                dispose();
            }
        }

        public void keyReleased(KeyEvent e) {
        }
    });
    fFilterText.addModifyListener(new  ModifyListener() {

        public void modifyText(ModifyEvent e) {
            String text = ((Text) e.widget).getText();
            int length = text.length();
            if (length > 0) {
                if (text.charAt(length - 1) != '*') {
                    text = text + '*';
                }
                if (text.charAt(0) != '*') {
                    text = '*' + text;
                }
            }
            setMatcherString(text, true);
        }
    });
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureInfo.setDescription(java.lang.String;)V2
public void setDescription(String description) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.description;
    this.description = description;
    firePropertyChanged(P_DESC, oldValue, description);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.WizardNewFileCreationPage.createFileHandle(org.eclipse.core.runtime.IPath;)org.eclipse.core.resources.IFile;2
protected IFile createFileHandle(IPath filePath) {
    return IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getFile(filePath);
}
method: org.eclipse.core.internal.resources.Workspace.getRoot()org.eclipse.core.resources.IWorkspaceRoot;1
public IWorkspaceRoot getRoot() {
    return defaultRoot;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.DebugCommandAction.getDebugContextService()org.eclipse.debug.ui.contexts.IDebugContextService;1
protected IDebugContextService getDebugContextService() {
    return DebugUITools.getDebugContextManager().getContextService(fWindow);
}
method: org.eclipse.debug.ui.DebugUITools.getDebugContextManager()org.eclipse.debug.ui.contexts.IDebugContextManager;0
public static IDebugContextManager getDebugContextManager() {
    return DebugContextManager.getDefault();
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.ExtensionsSort.getId(org.eclipse.core.runtime.IExtension;)org.osgi.framework.Bundle;2
@Override
protected Bundle getId(IExtension extension) {
    IContributor contributor = extension.getContributor();
    return Activator.getDefault().getBundleForName(contributor.getName());
}
method: org.eclipse.core.runtime.spi.RegistryContributor.getName()java.lang.String;1
public String getName() {
    return hostName;
}
---------------Client-------------------
method: org.eclipse.pde.launching.PDESourcePathProvider.getJavaProjects(org.eclipse.debug.core.ILaunchConfiguration;)Aorg.eclipse.core.resources.IProject;2
private IProject[] getJavaProjects(ILaunchConfiguration configuration) throws CoreException {
    IProject[] projects = LaunchPluginValidator.getAffectedProjects(configuration);
    return PDELaunchingPlugin.getWorkspace().computeProjectOrder(projects).projects;
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getWorkspace()org.eclipse.core.resources.IWorkspace;0
public static IWorkspace getWorkspace() {
    return ResourcesPlugin.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.ExtensionsSort.getId(org.eclipse.core.runtime.IExtension;)org.osgi.framework.Bundle;2
@Override
protected Bundle getId(IExtension extension) {
    IContributor contributor = extension.getContributor();
    return Activator.getDefault().getBundleForName(contributor.getName());
}
method: org.eclipse.e4.ui.internal.workbench.Activator.getBundleForName(java.lang.String;)org.osgi.framework.Bundle;2
public Bundle getBundleForName(String bundleName) {
    return bundleFinder.findBundle(bundleName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.AbstractJavaElementRenameChange.getModifiedElement()java.lang.Object;1
@Override
public Object getModifiedElement() {
    return JavaCore.create(getResource());
}
method: org.eclipse.jdt.internal.corext.refactoring.AbstractJavaElementRenameChange.getResource()org.eclipse.core.resources.IResource;1
protected final IResource getResource() {
    return ResourcesPlugin.getWorkspace().getRoot().findMember(fResourcePath);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.buildpath.ClasspathModifier.getResource(org.eclipse.core.runtime.IPath;org.eclipse.jdt.core.IJavaProject;)org.eclipse.core.resources.IResource;2
private static IResource getResource(IPath path, IJavaProject project) {
    return project.getProject().getWorkspace().getRoot().findMember(path);
}
method: org.eclipse.core.internal.resources.Container.findMember(org.eclipse.core.runtime.IPath;)org.eclipse.core.resources.IResource;2
public IResource findMember(IPath childPath) {
    return findMember(childPath, false);
}
---------------Client-------------------
method: org.eclipse.ui.internal.intro.impl.model.util.BundleUtil.getResourceLocation(java.lang.String;org.eclipse.core.runtime.IConfigurationElement;)java.lang.String;2
public static String getResourceLocation(String resource, IConfigurationElement element) {
    Bundle bundle = getBundleFromConfigurationElement(element);
    return getResolvedResourceLocation(resource, bundle, false);
}
method: org.eclipse.ui.internal.intro.impl.model.util.BundleUtil.getBundleFromConfigurationElement(org.eclipse.core.runtime.IConfigurationElement;)org.osgi.framework.Bundle;1
public static Bundle getBundleFromConfigurationElement(IConfigurationElement cfg) {
    return Platform.getBundle(cfg.getContributor().getName());
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.list.AbstractObservableList.fireListChange(org.eclipse.core.databinding.observable.list.ListDiff;)V2
protected void fireListChange(ListDiff diff) {
    fireChange();
    changeSupport.fireEvent(new  ListChangeEvent(this, diff));
}
method: org.eclipse.core.databinding.observable.ChangeSupport.fireEvent(org.eclipse.core.databinding.observable.ObservableEvent;)V2
public void fireEvent(ObservableEvent event) {
    super.fireEvent(event);
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.SearchResultsPart.refilter()V1
public void refilter() {
    updateResultSections();
}
method: org.eclipse.help.ui.internal.views.SearchResultsPart.updateResultSections()V1
private void updateResultSections() {
    BusyIndicator.showWhile(container.getDisplay(), new  Runnable() {

        public void run() {
            for (int i = 0; i < results.size(); i++) {
                EngineResultSection section = (EngineResultSection) results.get(i);
                section.updateResults(false);
            }
            reflow();
        }
    });
}

---------------Library-------------------
method: org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard.initializeDefaultPageImageDescriptor()V1
protected void initializeDefaultPageImageDescriptor() {
    ImageDescriptor desc = IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/newprj_wiz.png");
    setDefaultPageImageDescriptor(desc);
}
method: org.eclipse.jface.wizard.Wizard.setDefaultPageImageDescriptor(org.eclipse.jface.resource.ImageDescriptor;)V2
public void setDefaultPageImageDescriptor(ImageDescriptor imageDescriptor) {
    defaultImageDescriptor = imageDescriptor;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Link$2.getDefaultAction(org.eclipse.swt.accessibility.AccessibleControlEvent;)V2
@Override
public void getDefaultAction(AccessibleControlEvent e) {
    e.result = SWT.getMessage("SWT_Press");
}
method: org.eclipse.swt.SWT.getMessage(java.lang.String;)java.lang.String;1
public static String getMessage(String key) {
    return Compatibility.getMessage(key);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.actions.breakpointGroups.CopyBreakpointsActionDelegate.init(org.eclipse.ui.IViewPart;)V2
@Override
public void init(IViewPart view) {
    super.init(view);
    DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
}
method: org.eclipse.debug.internal.ui.actions.AbstractDebugActionDelegate.init(org.eclipse.ui.IViewPart;)V2
@Override
public void init(IViewPart view) {
    fViewPart = view;
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.dialogs.BuildOrderPreferencePage.init(org.eclipse.ui.IWorkbench;)V2
public void init(IWorkbench workbench) {
    this.workbench = workbench;
    setPreferenceStore(PrefUtil.getInternalPreferenceStore());
}
method: org.eclipse.ui.internal.util.PrefUtil.getInternalPreferenceStore()org.eclipse.jface.preference.IPreferenceStore;0
public static IPreferenceStore getInternalPreferenceStore() {
    return WorkbenchPlugin.getDefault().getPreferenceStore();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSUIPlugin.log(org.eclipse.core.runtime.IStatus;)V1
public static void log(IStatus status) {
    getPlugin().getLog().log(status);
}
method: org.eclipse.core.runtime.Plugin.getLog()org.eclipse.core.runtime.ILog;1
public final ILog getLog() {
    return InternalPlatform.getDefault().getLog(getBundle());
}
---------------Client-------------------
method: org.eclipse.ui.intro.config.CustomizableIntroPart.setFocus()V1
public void setFocus() {
    handleSetFocus(IntroPlugin.isIntroStandby());
}
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.isIntroStandby()Z0
public static boolean isIntroStandby() {
    return PlatformUI.getWorkbench().getIntroManager().isIntroStandby(getIntro());
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Filter.isFirst()Z1
public boolean isFirst() {
    IFilterMatcherDescriptor descriptor = project.getWorkspace().getFilterMatcherDescriptor(getId());
    if (descriptor != null)
        return descriptor.isFirstOrdering();
    return false;
}
method: org.eclipse.core.internal.resources.Workspace.getFilterMatcherDescriptor(java.lang.String;)org.eclipse.core.resources.IFilterMatcherDescriptor;2
public IFilterMatcherDescriptor getFilterMatcherDescriptor(String filterMatcherId) {
    return filterManager.getFilterDescriptor(filterMatcherId);
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.resource.RenameResourceWizard$RenameResourceRefactoringConfigurationPage.performFinish()Z1
protected boolean performFinish() {
    initializeRefactoring();
    storeSettings();
    return super.performFinish();
}
method: org.eclipse.ltk.ui.refactoring.resource.RenameResourceWizard$RenameResourceRefactoringConfigurationPage.initializeRefactoring()V1
private void initializeRefactoring() {
    fRefactoringProcessor.setNewResourceName(fNameField.getText());
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureObject.setLabel(java.lang.String;)V2
public void setLabel(String newLabel) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.label;
    label = newLabel;
    firePropertyChanged(P_LABEL, oldValue, newLabel);
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.firePropertyChanged(java.lang.String;java.lang.Object;java.lang.Object;)V4
protected void firePropertyChanged(String property, Object oldValue, Object newValue) {
    firePropertyChanged(this, property, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureChild.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    super.setId(id);
}
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.setId(java.lang.String;)V2
public void setId(String id) throws CoreException {
    ensureModelEditable();
    Object oldValue = this.id;
    this.id = id;
    firePropertyChanged(this, P_ID, oldValue, id);
}

---------------Library-------------------
method: org.eclipse.pde.core.plugin.PluginRegistry.findModel(org.eclipse.core.resources.IProject;)org.eclipse.pde.core.plugin.IPluginModelBase;1
public static IPluginModelBase findModel(IProject project) {
    return PDECore.getDefault().getModelManager().findModel(project);
}
method: org.eclipse.pde.internal.core.PDECore.getModelManager()org.eclipse.pde.internal.core.PluginModelManager;1
public PluginModelManager getModelManager() {
    return PluginModelManager.getInstance();
}
---------------Client-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.getTocs()Aorg.eclipse.help.IToc;1
@Deprecated
@Override
public IToc[] getTocs() {
    return HelpSystem.getTocs();
}
method: org.eclipse.help.HelpSystem.getTocs()Aorg.eclipse.help.IToc;0
public static IToc[] getTocs() {
    return HelpPlugin.getTocManager().getTocs(Platform.getNL());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.director.app.DirectorApplication.setSystemProperty(java.lang.String;java.lang.String;)V3
private void setSystemProperty(String key, String value) {
    EnvironmentInfo env = (EnvironmentInfo) ServiceHelper.getService(Activator.getContext(), EnvironmentInfo.class.getName());
    if (env != null) {
        env.setProperty(key, value);
    } else {
        System.getProperties().put(key, value);
    }
}
method: org.eclipse.equinox.internal.p2.core.helpers.ServiceHelper.getService(org.osgi.framework.BundleContext;java.lang.String;)java.lang.Object;2
public static Object getService(BundleContext context, String name) {
    if (context == null)
        return null;
    ServiceReference<?> reference = context.getServiceReference(name);
    if (reference == null)
        return null;
    Object result = context.getService(reference);
    context.ungetService(reference);
    return result;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.app.Activator.setProperty(java.lang.String;java.lang.String;)V2
static void setProperty(String key, String value) {
    EnvironmentInfo envInfo = getEnvironmentInfo();
    if (envInfo != null)
        envInfo.setProperty(key, value);
    else
        System.getProperties().setProperty(key, value);
}
method: org.eclipse.equinox.internal.app.Activator.getEnvironmentInfo()org.eclipse.osgi.service.environment.EnvironmentInfo;0
private static EnvironmentInfo getEnvironmentInfo() {
    BundleContext bc = Activator.getContext();
    if (bc == null)
        return null;
    ServiceReference infoRef = bc.getServiceReference(EnvironmentInfo.class.getName());
    if (infoRef == null)
        return null;
    EnvironmentInfo envInfo = (EnvironmentInfo) bc.getService(infoRef);
    if (envInfo == null)
        return null;
    bc.ungetService(infoRef);
    return envInfo;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.quickdiff.QuickDiff.getDefaultProvider()org.eclipse.ui.texteditor.quickdiff.ReferenceProviderDescriptor;1
public ReferenceProviderDescriptor getDefaultProvider() {
    QuickDiffExtensionsRegistry registry = TextEditorPlugin.getDefault().getQuickDiffExtensionRegistry();
    if (registry != null)
        return registry.getDefaultProvider();
    return null;
}
method: org.eclipse.ui.internal.texteditor.TextEditorPlugin.getQuickDiffExtensionRegistry()org.eclipse.ui.internal.texteditor.quickdiff.QuickDiffExtensionsRegistry;1
public QuickDiffExtensionsRegistry getQuickDiffExtensionRegistry() {
    return fQuickDiffExtensionRegistry;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart$RunnerViewHistory.getHistoryEntries()java.util.List;1
@Override
public List<TestRunSession> getHistoryEntries() {
    return JUnitCorePlugin.getModel().getTestRunSessions();
}
method: org.eclipse.jdt.internal.junit.JUnitCorePlugin.getModel()org.eclipse.jdt.internal.junit.model.JUnitModel;0
public static JUnitModel getModel() {
    return getDefault().fJUnitModel;
}

---------------Library-------------------
method: org.eclipse.search.ui.text.TextSearchQueryProvider.getPreferred()org.eclipse.search.ui.text.TextSearchQueryProvider;0
public static TextSearchQueryProvider getPreferred() {
    return SearchPlugin.getDefault().getTextSearchQueryProviderRegistry().getPreferred();
}
method: org.eclipse.search.internal.ui.SearchPlugin.getTextSearchQueryProviderRegistry()org.eclipse.search2.internal.ui.text2.TextSearchQueryProviderRegistry;1
public TextSearchQueryProviderRegistry getTextSearchQueryProviderRegistry() {
    if (fTextSearchQueryProviderRegistry == null) {
        fTextSearchQueryProviderRegistry = new  TextSearchQueryProviderRegistry();
    }
    return fTextSearchQueryProviderRegistry;
}
---------------Client-------------------
method: org.eclipse.compare.CompareConfiguration.getResourceManager()org.eclipse.jface.resource.ResourceManager;1
private synchronized ResourceManager getResourceManager() {
    if (fResourceManager == null) {
        fResourceManager = new  LocalResourceManager(JFaceResources.getResources());
    }
    return fResourceManager;
}
method: org.eclipse.jface.resource.JFaceResources.getResources()org.eclipse.jface.resource.ResourceManager;0
public static ResourceManager getResources() {
    return getResources(Display.getCurrent());
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.ChooseWorkspaceDialog.cancelPressed()V1
protected void cancelPressed() {
    launchData.workspaceSelected(null);
    super.cancelPressed();
}
method: org.eclipse.ui.internal.ide.ChooseWorkspaceData.workspaceSelected(java.lang.String;)V2
public void workspaceSelected(String dir) {
    selection = dir;
}
---------------Client-------------------
method: org.eclipse.jface.text.source.AnnotationBarHoverManager$Closer.controlMoved(org.eclipse.swt.events.ControlEvent;)V2
public void controlMoved(ControlEvent event) {
    hideInformationControl();
}
method: org.eclipse.jface.text.source.AnnotationBarHoverManager.hideInformationControl()V1
protected void hideInformationControl() {
    fCurrentHover = null;
    super.hideInformationControl();
}

