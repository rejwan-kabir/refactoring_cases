/**
* You have a complicated expression. Put the result of the expression, or parts of 
* the expression, in a temporary variable with a name that explains the purpose.
* 
* The variable to extract suggested by the results are usually too trivial to be useful.
*/
---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.model.viewer.IntroModelContentProvider.getParent(java.lang.Object;)java.lang.Object;2
public Object getParent(Object element) {
    AbstractIntroElement introElement = null;
    if (element instanceof AbstractIntroElement) {
        introElement = (AbstractIntroElement) element;
        return introElement.getParent();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getFile(org.eclipse.team.core.diff.IDiff;)org.eclipse.core.resources.IFile;2
protected IFile getFile(IDiff diff) {
    IResource resource = ResourceDiffTree.getResourceFor(diff);
    if (resource instanceof IFile) {
        IFile file = (IFile) resource;
        return file;
    }
    return null;
}
// not opportunity. no complicated expression to extract.

---------------Library-------------------
method: org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker.checkFilesToBeChanged(Aorg.eclipse.core.resources.IFile;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.ltk.core.refactoring.RefactoringStatus;2
public static RefactoringStatus checkFilesToBeChanged(IFile[] files, IProgressMonitor monitor) throws CoreException {
    ResourceChangeChecker checker = new  ResourceChangeChecker();
    for (int i = 0; i < files.length; i++) {
        checker.getDeltaFactory().change(files[i]);
    }
    return checker.check(monitor);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.PushDownRefactoringProcessor.checkAbstractMembersInDestinationClasses(Aorg.eclipse.jdt.core.IMember;Aorg.eclipse.jdt.core.IType;)org.eclipse.ltk.core.refactoring.RefactoringStatus;3
private RefactoringStatus checkAbstractMembersInDestinationClasses(IMember[] membersToPushDown, IType[] destinationClassesForAbstract) throws JavaModelException {
    RefactoringStatus result = new  RefactoringStatus();
    IMember[] abstractMembersToPushDown = getAbstractMembers(membersToPushDown);
    for (int index = 0; index < destinationClassesForAbstract.length; index++) {
        result.merge(MemberCheckUtil.checkMembersInDestinationType(abstractMembersToPushDown, destinationClassesForAbstract[index]));
    }
    return result;
}
// not opportunity. The target doesn't suggest what expression to extract.
---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.launch.DebugElementHelper.getBackground(java.lang.Object;)org.eclipse.swt.graphics.RGB;1
public static RGB getBackground(Object element) {
    Color color = getPresentation().getBackground(element);
    if (color != null) {
        return color.getRGB();    //---->RGB rgb = color.getRGB();
    }                             //---->return rgb;
    return null;
}
---------------Client-------------------
method: org.eclipse.team.core.mapping.DelegatingStorageMerger.findAndWrapStreamMerger(org.eclipse.core.resources.IStorage;)org.eclipse.team.core.mapping.IStorageMerger;2
private IStorageMerger findAndWrapStreamMerger(IStorage target) {
    IStreamMergerDelegate mergerDelegate = TeamPlugin.getPlugin().getMergerDelegate();
    if (mergerDelegate != null) {
        IStorageMerger merger = mergerDelegate.findMerger(target);
        return merger;
    }
    return null;
}
// it's opportunity. This case suggests that in the library the code: return color.getRGB()
// can be refactored as shown in the comment. However, it's too trivial to be useful.

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.workingsets.WorkingSetFilter.isEnclosing(org.eclipse.jdt.internal.ui.packageview.PackageFragmentRootContainer;)Z2
private boolean isEnclosing(PackageFragmentRootContainer container) {
    IAdaptable[] roots = container.getChildren();
    for (int i = 0; i < roots.length; i++) {
        if (isEnclosing(roots[i])) {            //---->IAdaptable root = roots[i]
            return true;                        //---->if(isEnclosing(root)) ...
        }
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.AbstractSynchronizationScope.contains(org.eclipse.core.resources.IResource;)Z2
public boolean contains(IResource resource) {
    ResourceTraversal[] traversals = getTraversals();
    for (int i = 0; i < traversals.length; i++) {
        ResourceTraversal traversal = traversals[i];    // put the element into a temporary variable
        if (traversal.contains(resource))
            return true;
    }
    return false;
}
// it's opportunity. shown as the comment.
---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.correction.SerialVersionHashOperation.getSortedInterfacesNames(org.eclipse.jdt.core.util.IClassFileReader;)AAC1
private static char[][] getSortedInterfacesNames(IClassFileReader cfReader) {
    char[][] interfaceNames = cfReader.getInterfaceNames();
    Arrays.sort(interfaceNames, new  Comparator<char[]>() {     //Comparator<char[]> comparator = new Comparator<char[]>{...}
        public int compare(char[] o1, char[] o2) {              //Arrays.sort(interfaceNames, comparator);
            return CharOperation.compareTo(o1, o2);
        }
    });
    return interfaceNames;
}
---------------Client-------------------
method: org.eclipse.emf.ecore.util.EcoreUtil.copy(org.eclipse.emf.ecore.EObject;)org.eclipse.emf.ecore.EObject;1
public static <T extends EObject> T copy(T eObject) {
    Copier copier = new  Copier();
    EObject result = copier.copy(eObject);
    copier.copyReferences();
    @SuppressWarnings("unchecked") T t = (T) result;
    return t;
}
// it's opportunity. put the result of new expression to a temporary variable.
---------------Library-------------------
method: org.eclipse.ui.views.properties.PropertySheetSorter.sort(Aorg.eclipse.ui.views.properties.IPropertySheetEntry;)V2
public void sort(IPropertySheetEntry[] entries) {
    Arrays.sort(entries, new  Comparator() {        //Comparator<char[]> comparator = new Comparator<char[]>{...}
        public int compare(Object a, Object b) {    //Arrays.sort(entries, comparator);
            return PropertySheetSorter.this.compare((IPropertySheetEntry) a, (IPropertySheetEntry) b);
        }
    });
}
---------------Client-------------------
method: org.eclipse.jetty.http.PathMap.writeExternal(java.io.ObjectOutput;)V2
public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
    HashMap map = new  HashMap(this);
    out.writeObject(map);
}
// it's opportunity. put the result of new expression to a temporary variable.
---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.DiffNodeWorkbenchAdapter.getImageDescriptor(java.lang.Object;)org.eclipse.jface.resource.ImageDescriptor;2
public ImageDescriptor getImageDescriptor(Object o) {
    DiffNode node = getDiffNode(o);
    if (node instanceof ISynchronizeModelElement) {                     
        return ((ISynchronizeModelElement) node).getImageDescriptor(o); //IsynchoronizeModelElement e = (ISynchronizeModelElement)node;        
    }                                                                   //return e.getImageDescriptor(o);
    return null;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.DelegatingModelPresentation.getBackground(java.lang.Object;)org.eclipse.swt.graphics.Color;2
@Override
public Color getBackground(Object element) {
    IDebugModelPresentation presentation = getConfiguredPresentation(element);
    if (presentation instanceof IColorProvider) {
        IColorProvider colorProvider = (IColorProvider) presentation;
        return colorProvider.getBackground(element);
    }
    return null;
}
//it's opportunity. put the result of cast expression to a temporary variable.
---------------Library-------------------
method: org.eclipse.pde.internal.ui.shared.FilteredCheckboxTree.doCreateRefreshJob()org.eclipse.ui.progress.WorkbenchJob;1
protected WorkbenchJob doCreateRefreshJob() {
    WorkbenchJob filterJob = super.doCreateRefreshJob();
    filterJob.addJobChangeListener(new  JobChangeAdapter() {

        public void done(IJobChangeEvent event) {
            if (event.getResult().isOK()) {
                getDisplay().asyncExec(new  Runnable() {

                    public void run() {
                        if (checkboxViewer.getTree().isDisposed())
                            return;
                        checkboxViewer.restoreLeafCheckState();
                    }
                });
            }
        }
    });
    return filterJob;
}
---------------Client-------------------
method: org.eclipse.ui.internal.menus.ActionSet.createExpression(org.eclipse.core.runtime.IConfigurationElement;)org.eclipse.core.expressions.Expression;2
protected Expression createExpression(IConfigurationElement configElement) {
    String actionSetId = MenuHelper.getId(configElement);
    Set<String> associatedPartIds = actionSetPartAssociations(actionSetId);
    return new  ActionSetAndPartExpression(actionSetId, associatedPartIds);
}
// false positive.
---------------Library-------------------
method: org.eclipse.ant.internal.ui.dtd.Parser.getXMLReader()org.xml.sax.XMLReader;1
private XMLReader getXMLReader() throws ParseError {
    SAXParser parser = null;
    try {
        parser = SAXParserFactory.newInstance().newSAXParser(); //SAXParserFactory factory = SAXParserFactory.newInstance();
        return parser.getXMLReader();                           //parser = factory.newSAXParser();
    } catch (ParserConfigurationException e) {                  //return parser.getXMLReader();
        throw new  ParseError(e.getMessage());
    } catch (SAXException e) {
        throw new  ParseError(e.getMessage());
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.variables.StringVariableManager.getDocument()org.w3c.dom.Document;1
private Document getDocument() throws ParserConfigurationException {
    DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = dfactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    return doc;
}
//it's opportunity.
---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.schema.FilteredSchemaAttributeSelectionDialog.getElementName(java.lang.Object;)java.lang.String;2
public String getElementName(Object item) {
    if (item instanceof ISchemaAttribute) {
        ISchemaAttribute attribute = (ISchemaAttribute) item;
        return attribute.getName();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getFile(org.eclipse.team.core.diff.IDiff;)org.eclipse.core.resources.IFile;2
protected IFile getFile(IDiff diff) {
    IResource resource = ResourceDiffTree.getResourceFor(diff);
    if (resource instanceof IFile) {
        IFile file = (IFile) resource;
        return file;
    }
    return null;
}
// false positive.

---------------Library-------------------
method: org.eclipse.swt.widgets.ToolBar.setForegroundColor(org.eclipse.swt.internal.gtk.GdkColor;)V2
@Override
void setForegroundColor(GdkColor color) {
    super.setForegroundColor(color);
    ToolItem[] items = getItems();
    for (int i = 0; i < items.length; i++) {
        items[i].setForegroundColor(color);     //ToolItem item = items[i];
    }                                           //item.setForegroudColor(color);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Menu.reskinChildren(I)V2
@Override
void reskinChildren(int flags) {
    MenuItem[] items = getItems();
    for (int i = 0; i < items.length; i++) {
        MenuItem item = items[i];
        item.reskin(flags);
    }
    super.reskinChildren(flags);
}
//it's opportunity. 
---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.ActionTaskProperties.run()V1
public void run() {
    DialogMarkerProperties dialog = new  DialogTaskProperties(part.getSite().getShell());
    dialog.setMarker(getSelectedMarker());          //IMarker marker = getSelectedMarker();
    dialog.open();                                  //dialog.setMarker(marker);
}
---------------Client-------------------
method: org.eclipse.ui.views.markers.internal.ActionProblemProperties.run()V1
public void run() {
    IMarker marker = getSelectedMarker();
    DialogMarkerProperties dialog = new  DialogProblemProperties(part.getSite().getShell());
    dialog.setMarker(marker);
    dialog.open();
}
//it's opportunity.

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.ResourceModelParticipantAction.getChangeSet(org.eclipse.jface.viewers.TreePath;)org.eclipse.team.internal.core.subscribers.DiffChangeSet;2
private DiffChangeSet getChangeSet(TreePath path) {
    Object o = path.getFirstSegment();
    if (o instanceof DiffChangeSet) {
        return (DiffChangeSet) o;   //DiffChangeSet changeSet = (DiffChangeSet) o;
    }                               //return changeSet;
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getFile(org.eclipse.team.core.diff.IDiff;)org.eclipse.core.resources.IFile;2
protected IFile getFile(IDiff diff) {
    IResource resource = ResourceDiffTree.getResourceFor(diff);
    if (resource instanceof IFile) {
        IFile file = (IFile) resource;
        return file;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.search.dependencies.CalculateUsesAction.getOperation()org.eclipse.pde.internal.ui.search.dependencies.CalculateUsesOperation;1
protected CalculateUsesOperation getOperation() {
    return new  CalculateUsesOperation(fProject, fModel) {

        protected void handleSetUsesDirectives(final Map<String, HashSet<String>> pkgsAndUses) {
            Display.getDefault().asyncExec(new  Runnable() {

                public void run() {
                    if (pkgsAndUses.isEmpty())
                        return;
                    setUsesDirectives(pkgsAndUses);
                }
            });
        }
    };
    // CalculateUseOperation operation = new CalculateUsesOperation()...;
    // return operation;
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.history.CompareFileRevisionEditorInput.createCompareInput()org.eclipse.compare.structuremergeviewer.ICompareInput;1
private ICompareInput createCompareInput() {
    MyDiffNode input = new  MyDiffNode(left, right);
    return input;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RefreshRemoteProjectWizard.promptForDeepRefresh(Aorg.eclipse.team.internal.ccvs.core.ICVSRemoteResource;)Z2
private boolean promptForDeepRefresh(final ICVSRemoteResource[] folders) {
    final boolean[] prompt = new boolean[] { false };
    getShell().getDisplay().syncExec(new  Runnable() {

        public void run() {
            MessageDialog dialog = new  MessageDialog(getShell(), CVSUIMessages.RefreshRemoteProjectWizard_0, null, getNoTagsMessage(folders), MessageDialog.INFORMATION, new String[] { CVSUIMessages.RefreshRemoteProjectWizard_1, CVSUIMessages.RefreshRemoteProjectWizard_2 }, 1);
            int code = dialog.open();
            if (code == 0) {
                prompt[0] = true;
            }
        }
    });
    // Runnable runnable = new Runnable() {...}
    // getShell().getDisplay().syncExec(runnable);
    return prompt[0];
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.MergeAllOperation$1.promptToContinue(org.eclipse.core.runtime.IStatus;)Z2
private boolean promptToContinue(final IStatus status) {
    final boolean[] result = new boolean[] { false };
    Runnable runnable = new  Runnable() {

        public void run() {
            ErrorDialog dialog = new  ErrorDialog(getShell(), TeamUIMessages.ModelMergeOperation_0, TeamUIMessages.ModelMergeOperation_1, status, IStatus.ERROR | IStatus.WARNING | IStatus.INFO) {

                protected void createButtonsForButtonBar(Composite parent) {
                    createButton(parent, IDialogConstants.YES_ID, IDialogConstants.YES_LABEL, false);
                    createButton(parent, IDialogConstants.NO_ID, IDialogConstants.NO_LABEL, true);
                    createDetailsButton(parent);
                }

                protected void buttonPressed(int id) {
                    if (id == IDialogConstants.YES_ID)
                        super.buttonPressed(IDialogConstants.OK_ID);
                    else if (id == IDialogConstants.NO_ID)
                        super.buttonPressed(IDialogConstants.CANCEL_ID);
                    super.buttonPressed(id);
                }
            };
            int code = dialog.open();
            result[0] = code == 0;
        }
    };
    getShell().getDisplay().syncExec(runnable);
    return (result[0]);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTColorHelper.getRGB(java.lang.String;)org.eclipse.swt.graphics.RGB;1
public static RGB getRGB(String name) {
    RGBColor color = CSS2ColorHelper.getRGBColor(name);
    if (color != null) {
        return getRGB(color);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.core.diff.provider.Diff.toDiffString()java.lang.String;1
public String toDiffString() {
    int kind = getKind();
    String label = SyncInfoToDiffConverter.diffKindToString(kind);
    return label;
}
// false positive

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.buildpath.ClasspathModifier.getValidator(java.util.List;org.eclipse.jdt.core.IJavaProject;)org.eclipse.jdt.internal.ui.wizards.buildpaths.newsourcepage.ClasspathModifierQueries$OutputFolderValidator;2
public static OutputFolderValidator getValidator(final List<?> newElements, final IJavaProject project) throws JavaModelException {
    return new  OutputFolderValidator(newElements, project) {           //OutputFolderValidator validator = new OutputFolderValidation(){}
                                                                        //return validator;
        @Override
        public boolean validate(IPath outputLocation) {
            for (int i = 0; i < newElements.size(); i++) {
                if (isInvalid(newElements.get(i), outputLocation))
                    return false;
            }
            for (int i = 0; i < fEntries.length; i++) {
                if (isInvalid(fEntries[i], outputLocation))
                    return false;
            }
            return true;
        }

        private boolean isInvalid(Object object, IPath outputLocation) {
            IPath path = null;
            if (object instanceof IFolder)
                path = getFolderPath(object);
            else if (object instanceof IJavaElement)
                path = getJavaElementPath(object);
            else if (object instanceof IClasspathEntry)
                path = getCPEntryPath(object);
            return isSubFolderOf(path, outputLocation);
        }

        private IPath getFolderPath(Object element) {
            return ((IFolder) element).getFullPath();
        }

        private IPath getJavaElementPath(Object element) {
            return ((IJavaElement) element).getPath();
        }

        private IPath getCPEntryPath(Object entry) {
            return ((IClasspathEntry) entry).getPath();
        }

        private boolean isSubFolderOf(IPath path1, IPath path2) {
            if (path1 == null || path2 == null) {
                if (path1 == null && path2 == null)
                    return true;
                return false;
            }
            return path2.matchingFirstSegments(path1) == path2.segmentCount();
        }
    };
}
---------------Client-------------------
method: org.eclipse.emf.ecore.change.impl.ChangeFactoryImpl.createFeatureChange(org.eclipse.emf.ecore.EStructuralFeature;java.lang.Object;Z)org.eclipse.emf.ecore.change.FeatureChange;4
public FeatureChange createFeatureChange(EStructuralFeature feature, Object oldValue, boolean oldIsSet) {
    FeatureChangeImpl featureChange = new  FeatureChangeImpl(feature, oldValue, oldIsSet);
    return featureChange;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.ENotificationImpl.isFeatureUnsettable()Z1
@Override
protected boolean isFeatureUnsettable() {
    Object feature = getFeature();
    if (feature instanceof EStructuralFeature) {               
        return ((EStructuralFeature) feature).isUnsettable();   //EStructuralFeature structuralFeature = (EStructuralFeature)feature;
    }                                                           //return structuralFeature.isUnsettable();
    return false;
}
---------------Client-------------------
method: org.eclipse.compare.internal.patch.HunkDiffNode.isManuallyMerged()Z1
public boolean isManuallyMerged() {
    Object left = getLeft();
    if (left instanceof UnmatchedHunkTypedElement) {
        UnmatchedHunkTypedElement element = (UnmatchedHunkTypedElement) left;
        return element.isManuallyMerged();
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.OperatorExpression.get_OR_OR()AI0
public static final int[] get_OR_OR() {
    return get_AND_AND();
}
---------------Client-------------------
method: org.eclipse.ui.wizards.datatransfer.WizardExternalProjectImportPage.getWorkspace()org.eclipse.core.resources.IWorkspace;1
private IWorkspace getWorkspace() {
    IWorkspace workspace = IDEWorkbenchPlugin.getPluginWorkspace();
    return workspace;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.NLSAccessorConfigurationDialog.createStringButtonField(java.lang.String;java.lang.String;org.eclipse.jdt.internal.ui.refactoring.nls.NLSAccessorConfigurationDialog$AccessorAdapter;)org.eclipse.jdt.internal.ui.wizards.dialogfields.StringButtonDialogField;4
private StringButtonDialogField createStringButtonField(String label, String button, AccessorAdapter adapter) {
    StringButtonDialogField field = new  StringButtonDialogField(adapter);
    field.setDialogFieldListener(adapter);
    field.setLabelText(label);
    field.setButtonLabel(button);
    return field;
}
---------------Client-------------------
method: org.eclipse.equinox.p2.publisher.eclipse.EclipseInstallAction.computeRootFileAdvice(java.lang.String;)org.eclipse.equinox.p2.publisher.IPublisherAdvice;2
protected IPublisherAdvice computeRootFileAdvice(String configSpec) {
    File root = computeRootFileRoot(configSpec);
    File[] inclusions = computeRootFileInclusions(configSpec);
    File[] exclusions = computeRootFileExclusions(configSpec);
    return new  RootFilesAdvice(root, inclusions, exclusions, configSpec);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.build.BuildEditor.getAdapter(java.lang.Class;)java.lang.Object;2
@Override
public Object getAdapter(Class key) {
    if (key.equals(IPropertySheetPage.class)) {
        return null;
    }
    return super.getAdapter(key);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.ContentType.getDefaultProperty(org.eclipse.core.runtime.QualifiedName;)java.lang.String;2
public String getDefaultProperty(QualifiedName key) {
    String propertyValue = internalGetDefaultProperty(key);
    if ("".equals(propertyValue))
        return null;
    return propertyValue;
}

---------------Library-------------------
method: org.eclipse.jface.wizard.Wizard.getNextPage(org.eclipse.jface.wizard.IWizardPage;)org.eclipse.jface.wizard.IWizardPage;2
@Override
public IWizardPage getNextPage(IWizardPage page) {
    int index = pages.indexOf(page);
    if (index == pages.size() - 1 || index == -1) {
        return null;
    }
    return pages.get(index + 1);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.comp.CompCSTaskGroup.getNextSibling(org.eclipse.pde.internal.ua.core.icheatsheet.comp.ICompCSTaskObject;)org.eclipse.pde.internal.ua.core.icheatsheet.comp.ICompCSTaskObject;2
public ICompCSTaskObject getNextSibling(ICompCSTaskObject taskObject) {
    int position = fFieldTaskObjects.indexOf(taskObject);
    int lastIndex = fFieldTaskObjects.size() - 1;
    if ((position == -1) || (position == lastIndex)) {
        return null;
    }
    return (ICompCSTaskObject) fFieldTaskObjects.get(position + 1);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.callhierarchy.SearchScopeActionGroup.getWorkingSetNames(Aorg.eclipse.ui.IWorkingSet;)Ajava.lang.String;2
private String[] getWorkingSetNames(IWorkingSet[] sets) {
    String[] result = new String[sets.length];
    for (int i = 0; i < sets.length; i++) {
        result[i] = sets[i].getName();
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.jface.resource.FontDescriptor.copy(Aorg.eclipse.swt.graphics.FontData;)Aorg.eclipse.swt.graphics.FontData;1
public static FontData[] copy(FontData[] original) {
    FontData[] result = new FontData[original.length];
    for (int i = 0; i < original.length; i++) {
        FontData next = original[i];
        result[i] = copy(next);
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.ui.model.BaseWorkbenchContentProvider.getParent(java.lang.Object;)java.lang.Object;2
@Override
public Object getParent(Object element) {
    IWorkbenchAdapter adapter = getAdapter(element);
    if (adapter != null) {
        return adapter.getParent(element);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.eclipse.Util.getArtifactFile(org.eclipse.equinox.p2.core.IProvisioningAgent;org.eclipse.equinox.p2.metadata.IArtifactKey;org.eclipse.equinox.p2.engine.IProfile;)java.io.File;3
public static File getArtifactFile(IProvisioningAgent agent, IArtifactKey artifactKey, IProfile profile) {
    IFileArtifactRepository aggregatedView = getAggregatedBundleRepository(agent, profile);
    File bundleJar = aggregatedView.getArtifactFile(artifactKey);
    return bundleJar;
}

---------------Library-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberResourceCollector.isDescendantOfRoot(org.eclipse.core.resources.IResource;Aorg.eclipse.core.resources.IResource;)Z3
private boolean isDescendantOfRoot(IResource resource, IResource[] roots) {
    for (int i = 0; i < roots.length; i++) {
        IResource root = roots[i];
        if (root.getFullPath().isPrefixOf(resource.getFullPath())) {
            return true;
        }
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.ui.internal.dnd.SwtUtil.intersectsAnyMonitor(org.eclipse.swt.widgets.Display;org.eclipse.swt.graphics.Rectangle;)Z2
public static boolean intersectsAnyMonitor(Display display, Rectangle someRectangle) {
    Monitor[] monitors = display.getMonitors();
    for (int idx = 0; idx < monitors.length; idx++) {
        Monitor mon = monitors[idx];
        if (mon.getClientArea().intersects(someRectangle)) {
            return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.CleanUpAction.getCompilationUnit(org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;)org.eclipse.jdt.core.ICompilationUnit;1
private static ICompilationUnit getCompilationUnit(JavaEditor editor) {
    IJavaElement element = JavaUI.getEditorInputJavaElement(editor.getEditorInput());
    if (!(element instanceof ICompilationUnit))
        return null;
    return (ICompilationUnit) element;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.view.NodesView$ViewContentProvider.getParent(java.lang.Object;)java.lang.Object;2
public Object getParent(Object child) {
    if (!(child instanceof ISecurePreferences))
        return null;
    ISecurePreferences node = (ISecurePreferences) child;
    ISecurePreferences parentNode = node.parent();
    if (parentNode == null)
        return null;
    return node.parent();
}

---------------Library-------------------
method: org.eclipse.jface.viewers.AbstractTreeViewer.internalCollectExpandedItems(java.util.List;org.eclipse.swt.widgets.Widget;)V3
private void internalCollectExpandedItems(List result, Widget widget) {
    Item[] items = getChildren(widget);
    for (int i = 0; i < items.length; i++) {
        Item item = items[i];
        if (item.getData() != null) {
            if (getExpanded(item)) {
                result.add(item);
            }
            internalCollectExpandedItems(result, item);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jface.viewers.AbstractTreeViewer.internalCollectVisibleExpanded(java.util.ArrayList;org.eclipse.swt.widgets.Widget;)V3
private void internalCollectVisibleExpanded(ArrayList result, Widget widget) {
    Item[] items = getChildren(widget);
    for (int i = 0; i < items.length; i++) {
        Item item = items[i];
        if (getExpanded(item)) {
            Object data = item.getData();
            if (data != null) {
                result.add(data);
            }
            internalCollectVisibleExpanded(result, item);
        }
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.compare.ManifestStructureCreator.getContents(java.lang.Object;Z)java.lang.String;3
public String getContents(Object node, boolean ignoreWhitespace) {
    if (node instanceof IStreamContentAccessor) {
        IStreamContentAccessor sca = (IStreamContentAccessor) node;
        try {
            return readString(sca);
        } catch (CoreException ex) {
        }
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getFile(org.eclipse.team.core.diff.IDiff;)org.eclipse.core.resources.IFile;2
protected IFile getFile(IDiff diff) {
    IResource resource = ResourceDiffTree.getResourceFor(diff);
    if (resource instanceof IFile) {
        IFile file = (IFile) resource;
        return file;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.descriptors.MemberDescriptorImpl.getPackage()org.eclipse.pde.api.tools.internal.provisional.descriptors.IPackageDescriptor;1
@Override
public IPackageDescriptor getPackage() {
    IElementDescriptor parent = getParent();
    while (!(parent instanceof IPackageDescriptor)) {
        parent = ((MemberDescriptorImpl) parent).getParent();
    }
    return (IPackageDescriptor) parent;
}
---------------Client-------------------
method: org.eclipse.ui.internal.PartSite.getTopLevelModelWindow(org.eclipse.e4.ui.model.application.ui.basic.MWindow;)org.eclipse.e4.ui.model.application.ui.basic.MWindow;2
private MWindow getTopLevelModelWindow(MWindow window) {
    EObject previousParent = (EObject) window;
    EObject parent = previousParent.eContainer();
    while (!(parent instanceof MApplication)) {
        previousParent = parent;
        parent = parent.eContainer();
    }
    return (MWindow) previousParent;
}

---------------Library-------------------
method: org.eclipse.jface.text.PaintManager.textChanged(org.eclipse.jface.text.TextEvent;)V2
public void textChanged(TextEvent event) {
    if (!event.getViewerRedrawState())
        return;
    Control control = fTextViewer.getTextWidget();
    if (control != null) {
        control.getDisplay().asyncExec(new  Runnable() {

            public void run() {
                if (fTextViewer != null)
                    paint(IPainter.TEXT_CHANGE);
            }
        });
    }
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.launchConfigurations.VariableInputDialog.getVariable()V1
private void getVariable() {
    StringVariableSelectionDialog variableDialog = new  StringVariableSelectionDialog(getShell());
    int returnCode = variableDialog.open();
    if (returnCode == IDialogConstants.OK_ID) {
        String variable = variableDialog.getVariableExpression();
        if (variable != null) {
            fText.insert(variable);
        }
    }
}

---------------Library-------------------
method: org.eclipse.osgi.internal.loader.SystemBundleLoader.findLocalClass(java.lang.String;)java.lang.Class;2
public Class<?> findLocalClass(String name) {
    try {
        return classLoader.loadClass(name);
    } catch (ClassNotFoundException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.jobs.InternalJob.getProperty(org.eclipse.core.runtime.QualifiedName;)java.lang.Object;2
protected Object getProperty(QualifiedName key) {
    Map temp = properties;
    if (temp == null)
        return null;
    return temp.get(key);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewContainerWizardPage$2.select(org.eclipse.jface.viewers.Viewer;java.lang.Object;java.lang.Object;)Z4
@Override
public boolean select(Viewer viewer, Object parent, Object element) {
    if (element instanceof IPackageFragmentRoot) {
        try {
            return (((IPackageFragmentRoot) element).getKind() == IPackageFragmentRoot.K_SOURCE);
        } catch (JavaModelException e) {
            JavaPlugin.log(e.getStatus());
            return false;
        }
    }
    return super.select(viewer, parent, element);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.SourceContainerDialog$JavaTypedViewerFilter.select(org.eclipse.jface.viewers.Viewer;java.lang.Object;java.lang.Object;)Z4
@Override
public boolean select(Viewer viewer, Object parent, Object element) {
    if (element instanceof IPackageFragmentRoot) {
        IPackageFragmentRoot fragmentRoot = (IPackageFragmentRoot) element;
        try {
            return (fragmentRoot.getKind() == IPackageFragmentRoot.K_SOURCE);
        } catch (JavaModelException e) {
            return false;
        }
    }
    return super.select(viewer, parent, element);
}

---------------Library-------------------
method: org.eclipse.ltk.ui.refactoring.UserInputWizardPage.canFlipToNextPage()Z1
public boolean canFlipToNextPage() {
    if (fIsLastUserInputPage) {
        return isPageComplete();
    } else {
        return super.canFlipToNextPage();
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.debug.ui.jres.EEVMPage.isPageComplete()Z1
@Override
public boolean isPageComplete() {
    boolean complete = super.isPageComplete();
    if (complete) {
        return fLibraryBlock.isPageComplete();
    }
    return complete;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchShortcutExtension.getLaunchConfigurations(org.eclipse.ui.IEditorPart;)Aorg.eclipse.debug.core.ILaunchConfiguration;2
@Override
public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {
    ILaunchShortcut delegate = getDelegate();
    if (delegate instanceof ILaunchShortcut2) {
        return ((ILaunchShortcut2) delegate).getLaunchConfigurations(editorpart);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.LazyModelPresentation.getBackground(java.lang.Object;)org.eclipse.swt.graphics.Color;2
@Override
public Color getBackground(Object element) {
    IDebugModelPresentation presentation = getPresentation();
    if (presentation instanceof IColorProvider) {
        IColorProvider colorProvider = (IColorProvider) presentation;
        return colorProvider.getBackground(element);
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.compare.CompareViewerPane.getToolBarManager(org.eclipse.swt.widgets.Composite;)org.eclipse.jface.action.ToolBarManager;1
public static ToolBarManager getToolBarManager(Composite parent) {
    if (parent instanceof CompareViewerPane) {
        CompareViewerPane pane = (CompareViewerPane) parent;
        return pane.getToolBarManager();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getFile(org.eclipse.team.core.diff.IDiff;)org.eclipse.core.resources.IFile;2
protected IFile getFile(IDiff diff) {
    IResource resource = ResourceDiffTree.getResourceFor(diff);
    if (resource instanceof IFile) {
        IFile file = (IFile) resource;
        return file;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.text.edits.TextEdit.getRoot()org.eclipse.text.edits.TextEdit;1
public final TextEdit getRoot() {
    TextEdit result = this;
    while (result.fParent != null) {
        result = result.fParent;
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.jface.text.TreeLineTracker.successorDown(org.eclipse.jface.text.TreeLineTracker$Node;)org.eclipse.jface.text.TreeLineTracker$Node;2
private Node successorDown(Node node) {
    Node child = node.left;
    while (child != null) {
        node = child;
        child = node.left;
    }
    return node;
}

---------------Library-------------------
method: org.eclipse.ui.internal.registry.PropertyPagesRegistryReader.findNode(java.lang.String;)java.lang.Object;2
@Override
Object findNode(String id) {
    Iterator iterator = pages.iterator();
    while (iterator.hasNext()) {
        RegistryPageContributor next = (RegistryPageContributor) iterator.next();
        if (next.getPageId().equals(id))
            return next;
    }
    return null;
}
---------------Client-------------------
method: org.apache.lucene.document.Document.getFieldable(java.lang.String;)org.apache.lucene.document.Fieldable;2
public Fieldable getFieldable(String name) {
    for (Fieldable field : fields) {
        if (field.name().equals(name))
            return field;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpObject.getModel()org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpModel;1
public CtxHelpModel getModel() {
    final IModel sharedModel = getSharedModel();
    if (sharedModel instanceof CtxHelpModel) {
        return (CtxHelpModel) sharedModel;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getFile(org.eclipse.team.core.diff.IDiff;)org.eclipse.core.resources.IFile;2
protected IFile getFile(IDiff diff) {
    IResource resource = ResourceDiffTree.getResourceFor(diff);
    if (resource instanceof IFile) {
        IFile file = (IFile) resource;
        return file;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2$HistoryCopyVisitor.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry sourceEntry) {
    IPath destinationPath = destination.append(sourceEntry.getPath().removeFirstSegments(source.segmentCount()));
    HistoryEntry destinationEntry = new  HistoryEntry(destinationPath, (HistoryEntry) sourceEntry);
    changes.add(destinationEntry);
    return CONTINUE;
}
---------------Client-------------------
method: org.eclipse.core.internal.properties.PropertyManager2$PropertyCopyVisitor.visit(org.eclipse.core.internal.localstore.Bucket$Entry;)I2
public int visit(Entry entry) {
    PropertyEntry sourceEntry = (PropertyEntry) entry;
    IPath destinationPath = destination.append(sourceEntry.getPath().removeFirstSegments(source.segmentCount()));
    PropertyEntry destinationEntry = new  PropertyEntry(destinationPath, sourceEntry);
    changes.add(destinationEntry);
    return CONTINUE;
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.FindExceptionOccurrencesAction.run(org.eclipse.jface.text.ITextSelection;)V2
@Override
public final void run(ITextSelection ts) {
    ITypeRoot input = getEditorInput(fEditor);
    if (!ActionUtil.isProcessable(getShell(), input))
        return;
    FindOccurrencesEngine engine = FindOccurrencesEngine.create(new  ExceptionOccurrencesFinder());
    try {
        String result = engine.run(input, ts.getOffset(), ts.getLength());
        if (result != null)
            showMessage(getShell(), fEditor, result);
    } catch (JavaModelException e) {
        JavaPlugin.log(e);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.ui.actions.FindOccurrencesInFileAction.run(org.eclipse.jface.text.ITextSelection;)V2
@Override
public final void run(ITextSelection ts) {
    ITypeRoot input = getEditorInput(fEditor);
    if (!ActionUtil.isProcessable(getShell(), input))
        return;
    OccurrencesFinder finder = new  OccurrencesFinder();
    FindOccurrencesEngine engine = FindOccurrencesEngine.create(finder);
    try {
        String result = engine.run(input, ts.getOffset(), ts.getLength());
        if (result != null)
            showMessage(getShell(), fEditor, result);
    } catch (JavaModelException e) {
        JavaPlugin.log(e);
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.feature.RequiresSection.handleNewFeature()V1
private void handleNewFeature() {
    BusyIndicator.showWhile(fPluginViewer.getTable().getDisplay(), new  Runnable() {

        public void run() {
            IFeatureModel[] allModels = PDECore.getDefault().getFeatureModelManager().getModels();
            ArrayList<IFeatureModel> newModels = new  ArrayList<IFeatureModel>();
            for (int i = 0; i < allModels.length; i++) {
                if (canAdd(allModels[i]))
                    newModels.add(allModels[i]);
            }
            IFeatureModel[] candidateModels = newModels.toArray(new IFeatureModel[newModels.size()]);
            FeatureSelectionDialog dialog = new  FeatureSelectionDialog(fPluginViewer.getTable().getShell(), candidateModels, true);
            if (dialog.open() == Window.OK) {
                Object[] models = dialog.getResult();
                try {
                    doAdd(models);
                } catch (CoreException e) {
                    PDECore.log(e);
                }
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.category.CategorySection.handleNewBundle()V1
private void handleNewBundle() {
    final Control control = fCategoryViewer.getControl();
    BusyIndicator.showWhile(control.getDisplay(), new  Runnable() {

        public void run() {
            IPluginModelBase[] allModels = PluginRegistry.getAllModels();
            ArrayList<IPluginModelBase> newModels = new  ArrayList<IPluginModelBase>();
            for (int i = 0; i < allModels.length; i++) {
                if (canAdd(allModels[i]))
                    newModels.add(allModels[i]);
            }
            IPluginModelBase[] candidateModels = newModels.toArray(new IPluginModelBase[newModels.size()]);
            PluginSelectionDialog dialog = new  PluginSelectionDialog(fCategoryViewer.getTree().getShell(), candidateModels, true);
            if (dialog.open() == Window.OK) {
                Object[] models = dialog.getResult();
                try {
                    doAddBundles(models);
                } catch (CoreException e) {
                    PDEPlugin.log(e);
                }
            }
        }
    });
}

---------------Library-------------------
method: org.eclipse.debug.ui.actions.AddMemoryRenderingActionDelegate.getAddMemoryRenderingTarget(java.lang.Object;)org.eclipse.debug.ui.actions.IAddMemoryRenderingsTarget;2
private IAddMemoryRenderingsTarget getAddMemoryRenderingTarget(Object elmt) {
    IAddMemoryRenderingsTarget target = null;
    if (elmt instanceof IAddMemoryRenderingsTarget) {
        target = (IAddMemoryRenderingsTarget) elmt;
    } else if (elmt instanceof IAdaptable) {
        target = (IAddMemoryRenderingsTarget) ((IAdaptable) elmt).getAdapter(IAddMemoryRenderingsTarget.class);
    }
    return target;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousModel.getContentAdapter(java.lang.Object;)org.eclipse.debug.internal.ui.viewers.provisional.IAsynchronousContentAdapter;2
protected IAsynchronousContentAdapter getContentAdapter(Object element) {
    IAsynchronousContentAdapter adapter = null;
    if (element instanceof IAsynchronousContentAdapter) {
        adapter = (IAsynchronousContentAdapter) element;
    } else if (element instanceof IAdaptable) {
        IAdaptable adaptable = (IAdaptable) element;
        adapter = (IAsynchronousContentAdapter) adaptable.getAdapter(IAsynchronousContentAdapter.class);
    }
    return adapter;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.wizards.GlobalRefreshWizardSelectionPage$MyLabelProvider.getText(java.lang.Object;)java.lang.String;2
public String getText(Object element) {
    if (element instanceof SynchronizeWizardDescription) {
        SynchronizeWizardDescription descriptor = (SynchronizeWizardDescription) element;
        return descriptor.getName();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getFile(org.eclipse.team.core.diff.IDiff;)org.eclipse.core.resources.IFile;2
protected IFile getFile(IDiff diff) {
    IResource resource = ResourceDiffTree.getResourceFor(diff);
    if (resource instanceof IFile) {
        IFile file = (IFile) resource;
        return file;
    }
    return null;
}

---------------Library-------------------
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
---------------Client-------------------
method: org.eclipse.pde.internal.ui.templates.rcp.ViewRCPTemplate.createViewExtension()V1
private void createViewExtension() throws CoreException {
    IPluginBase plugin = model.getPluginBase();
    String id = plugin.getId();
    IPluginExtension extension = createExtension("org.eclipse.ui.views", true);
    IPluginElement view = model.getPluginFactory().createElement(extension);
    view.setName("view");
    view.setAttribute("class", getStringOption(KEY_PACKAGE_NAME) + ".View");
    view.setAttribute("name", "View");
    view.setAttribute("id", id + ".view");
    extension.add(view);
    if (!extension.isInTheModel())
        plugin.add(extension);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.app.EclipseAppContainer.callMethod(java.lang.Object;java.lang.String;Ajava.lang.Class;Ajava.lang.Object;)java.lang.Object;4
static Object callMethod(Object obj, String methodName, Class[] argTypes, Object[] args) {
    try {
        return callMethodWithException(obj, methodName, argTypes, args);
    } catch (Throwable t) {
        Activator.log(new  FrameworkLogEntry(Activator.PI_APP, FrameworkLogEntry.ERROR, 0, "Error in invoking method.", 0, t, null));
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.imports.PluginImportWizardExpressPage$TablePart.createStructuredViewer(org.eclipse.swt.widgets.Composite;ILorg.eclipse.ui.forms.widgets.FormToolkit;)org.eclipse.jface.viewers.StructuredViewer;4
protected StructuredViewer createStructuredViewer(Composite parent, int style, FormToolkit toolkit) {
    StructuredViewer viewer = super.createStructuredViewer(parent, style, toolkit);
    return viewer;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveInnerToTopRefactoring.getParameterNamesOfAllConstructors(org.eclipse.jdt.core.IType;)Ajava.lang.String;1
private static String[] getParameterNamesOfAllConstructors(IType type) throws JavaModelException {
    IMethod[] constructors = JavaElementUtil.getAllConstructors(type);
    Set<String> result = new  HashSet<String>();
    for (int i = 0; i < constructors.length; i++) {
        result.addAll(Arrays.asList(constructors[i].getParameterNames()));
    }
    return result.toArray(new String[result.size()]);
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.operations.TagOperation.getProjects()Aorg.eclipse.core.resources.IProject;1
private IProject[] getProjects() {
    ResourceMapping[] mappings = getSelectedMappings();
    Set projects = new  HashSet();
    for (int i = 0; i < mappings.length; i++) {
        ResourceMapping mapping = mappings[i];
        projects.addAll(Arrays.asList(mapping.getProjects()));
    }
    return (IProject[]) projects.toArray(new IProject[projects.size()]);
}

---------------Library-------------------
method: org.eclipse.ui.internal.dialogs.WizardCollectionElement.findWizard(java.lang.String;Z)org.eclipse.ui.internal.dialogs.WorkbenchWizardElement;3
public WorkbenchWizardElement findWizard(String searchId, boolean recursive) {
    Object[] wizards = getWizards();
    for (int i = 0; i < wizards.length; ++i) {
        WorkbenchWizardElement currentWizard = (WorkbenchWizardElement) wizards[i];
        if (currentWizard.getId().equals(searchId)) {
            return currentWizard;
        }
    }
    if (!recursive) {
        return null;
    }
    for (Iterator iterator = children.iterator(); iterator.hasNext(); ) {
        WizardCollectionElement child = (WizardCollectionElement) iterator.next();
        WorkbenchWizardElement result = child.findWizard(searchId, true);
        if (result != null) {
            return result;
        }
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.cheatsheets.registry.CheatSheetCollectionElement.findCheatSheet(java.lang.String;Z)org.eclipse.ui.internal.cheatsheets.registry.CheatSheetElement;3
public CheatSheetElement findCheatSheet(String searchId, boolean recursive) {
    Object[] cheatsheets = getCheatSheets();
    for (int i = 0; i < cheatsheets.length; ++i) {
        CheatSheetElement currentCheatSheet = (CheatSheetElement) cheatsheets[i];
        if (currentCheatSheet.getID().equals(searchId))
            return currentCheatSheet;
    }
    if (!recursive)
        return null;
    for (Iterator iterator = childCollections.iterator(); iterator.hasNext(); ) {
        CheatSheetCollectionElement child = (CheatSheetCollectionElement) iterator.next();
        CheatSheetElement result = child.findCheatSheet(searchId, true);
        if (result != null)
            return result;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditorMessages.getString(java.lang.String;)java.lang.String;1
public static String getString(String key) {
    try {
        return fgResourceBundle.getString(key);
    } catch (MissingResourceException e) {
        return '!' + key + '!';
    }
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.preferences.ICPreferences.getDefaultNode(java.lang.String;)org.eclipse.core.runtime.preferences.IEclipsePreferences;1
public static IEclipsePreferences getDefaultNode(String plugin) {
    IEclipsePreferences p = DefaultScope.INSTANCE.getNode(plugin);
    return p;
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
method: org.eclipse.team.internal.ccvs.ui.wizards.CVSWizardPage.createPasswordField(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Text;1
public static Text createPasswordField(Composite parent) {
    Text text = new  Text(parent, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
    return layoutTextField(text);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.Fea