****Number of pairs: 829
---------------Library-------------------
method: org.eclipse.search.internal.ui.SearchResultView.setContentDescription(java.lang.String;)V2
protected void setContentDescription(String title) {
    super.setContentDescription(title);
}
method: org.eclipse.ui.part.ViewPart.setContentDescription(java.lang.String;)V2
@Override
protected void setContentDescription(String description) {
    if (compatibilityTitleListener != null) {
        removePropertyListener(compatibilityTitleListener);
        compatibilityTitleListener = null;
    }
    super.setContentDescription(description);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.MenuItem.releaseChildren(Z)V2
@Override
void releaseChildren(boolean destroy) {
    if (menu != null) {
        menu.release(false);
        menu = null;
    }
    super.releaseChildren(destroy);
}
//false, the setContentDescription() can't be inlined becasuse it belongs to the super class.
---------------Library-------------------
method: org.eclipse.core.internal.registry.ExtensionRegistry.addListener(org.eclipse.core.runtime.IRegistryEventListener;)V2
public void addListener(IRegistryEventListener listener) {
    addListenerInternal(listener, null);
}
method: org.eclipse.core.internal.registry.ExtensionRegistry.addListenerInternal(java.util.EventListener;java.lang.String;)V3
private void addListenerInternal(EventListener listener, String filter) {
    synchronized (listeners) {
        listeners.add(new  ListenerInfo(listener, filter));
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.registry.ExtensionRegistry.removeListener(org.eclipse.core.runtime.IRegistryEventListener;)V2
public void removeListener(IRegistryEventListener listener) {
    synchronized (listeners) {
        listeners.remove(new  ListenerInfo(listener, null));
    }
}
//true

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.updateFilters(java.util.Collection;Z)V3
void updateFilters(Collection filters, boolean andFilters) {
    setAndFilters(andFilters);
    this.filters = filters;
    enabledFilters = FILTERS_CHANGED;
    writeFiltersPreference();
    requestMarkerUpdate();
}
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.requestMarkerUpdate()V1
void requestMarkerUpdate() {
    if (builder != null) {
        builder.scheduleUpdate(0L);
    }
}

---------------Client-------------------
method: org.eclipse.swt.widgets.DateTime.updateControl()V1
void updateControl() {
    if (text != null) {
        String string = getFormattedString(style);
        ignoreVerify = true;
        text.setText(string);
        ignoreVerify = false;
    }
    redraw();
}
//true

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.typehierarchy.TypeHierarchyViewPart.setMemberFilter(Aorg.eclipse.jdt.core.IMember;)V2
private void setMemberFilter(IMember[] memberFilter) {
    Assert.isNotNull(fAllViewers);
    for (int i = 0; i < fAllViewers.length; i++) {
        fAllViewers[i].setMemberFilter(memberFilter);
    }
}
method: org.eclipse.jdt.internal.ui.typehierarchy.TypeHierarchyViewer.setMemberFilter(Aorg.eclipse.jdt.core.IMember;)V2
public void setMemberFilter(IMember[] memberFilter) {
    TypeHierarchyContentProvider contentProvider = getHierarchyContentProvider();
    if (contentProvider != null) {
        contentProvider.setMemberFilter(memberFilter);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.commands.QueryByTag.refreshTags()V1
private void refreshTags() {
    fTagsCombo.removeAll();
    String[] tags = fTagManager.getTags();
    for (int i = 0; i < tags.length; i++) {
        fTagsCombo.add(tags[i]);
    }
}
//false, the setMemberFilter() can't be inlined becasuse it belongs to another class.


---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyArgumentListopt()V1
protected void consumeEmptyArgumentListopt() {
    pushOnExpressionStackLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnExpressionStackLengthStack(I)V2
protected void pushOnExpressionStackLengthStack(int pos) {
    int stackLength = this.expressionLengthStack.length;
    if (++this.expressionLengthPtr >= stackLength) {
        System.arraycopy(this.expressionLengthStack, 0, this.expressionLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.expressionLengthStack[this.expressionLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}
//true
---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractMethodRefactoring$UsedNamesCollector.visit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;)Z2
@Override
public boolean visit(AnnotationTypeDeclaration node) {
    return visitType(node);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractMethodRefactoring$UsedNamesCollector.visitType(org.eclipse.jdt.core.dom.AbstractTypeDeclaration;)Z2
private boolean visitType(AbstractTypeDeclaration node) {
    result.add(node.getName().getIdentifier());
    return false;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.SimpleLicenseManager.accept(org.eclipse.equinox.p2.metadata.ILicense;)Z2
public boolean accept(ILicense license) {
    accepted.add(license.getUUID());
    updatePreferences();
    return true;
}
//true

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor.updateEditorImage(org.eclipse.ant.internal.ui.model.AntModel;)V2
private void updateEditorImage(AntModel model) {
    Image titleImage = getTitleImage();
    if (titleImage == null) {
        return;
    }
    AntProjectNode node = model.getProjectNode();
    if (node != null) {
        postImageChange(node);
    }
}
method: org.eclipse.ant.internal.ui.editor.AntEditor.postImageChange(org.eclipse.ant.internal.ui.model.AntElementNode;)V2
private void postImageChange(final AntElementNode node) {
    Shell shell = getSite().getShell();
    if (shell != null && !shell.isDisposed()) {
        shell.getDisplay().asyncExec(new  Runnable() {

            @Override
            public void run() {
                if (getSite().getShell() == null || getSite().getShell().isDisposed()) {
                    return;
                }
                Image titleImage = getTitleImage();
                Image newImage = node.getImage();
                if (titleImage != newImage) {
                    setTitleImage(newImage);
                }
            }
        });
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.ChangeSetActionGroup.syncExec(java.lang.Runnable;)V2
private void syncExec(final Runnable runnable) {
    final Control ctrl = getConfiguration().getPage().getViewer().getControl();
    if (ctrl != null && !ctrl.isDisposed()) {
        ctrl.getDisplay().syncExec(new  Runnable() {

            public void run() {
                if (!ctrl.isDisposed()) {
                    runnable.run();
                }
            }
        });
    }
}
//true

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.PlainJarBuilder.writeFile(org.eclipse.core.resources.IFile;org.eclipse.core.runtime.IPath;)V3
public void writeFile(IFile resource, IPath destinationPath) throws CoreException {
    fJarWriter.write(resource, destinationPath);
}
method: org.eclipse.jdt.ui.jarpackager.JarWriter3.write(org.eclipse.core.resources.IFile;org.eclipse.core.runtime.IPath;)V3
public void write(IFile resource, IPath destinationPath) throws CoreException {
    try {
        if (fJarPackage.areDirectoryEntriesIncluded())
            addDirectories(resource, destinationPath);
        addFile(resource, destinationPath);
    } catch (IOException ex) {
        String message = null;
        if (ex.getLocalizedMessage() != null)
            message = Messages.format(JarPackagerMessages.JarWriter_writeProblemWithMessage, new Object[] { BasicElementLabels.getPathLabel(resource.getFullPath(), false), ex.getLocalizedMessage() });
        else
            message = Messages.format(JarPackagerMessages.JarWriter_writeProblem, BasicElementLabels.getPathLabel(resource.getFullPath(), false));
        throw JarPackagerUtil.createCoreException(message, ex);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsConstraintCreator.createWildcardConstraint(org.eclipse.jdt.internal.corext.refactoring.typeconstraints.types.WildcardType;org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.CollectionElementVariable2;org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;)V4
private void createWildcardConstraint(WildcardType typeArgument, CollectionElementVariable2 argElementCv, ConstraintVariable2 paramElementCv) {
    if (typeArgument.isExtendsWildcardType())
        fTCModel.createSubtypeConstraint(argElementCv, paramElementCv);
    else
        fTCModel.createSubtypeConstraint(paramElementCv, argElementCv);
}
//false, the write() can't be inlined becasuse it belongs to another class.
---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeLeftParen()V1
protected void consumeLeftParen() {
    pushOnIntStack(this.lParenPos);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeElidedLeftBraceAndReturn()V1
protected void consumeElidedLeftBraceAndReturn() {
    int stackLength = this.stateStackLengthStack.length;
    if (++this.valueLambdaNestDepth >= stackLength) {
        System.arraycopy(this.stateStackLengthStack, 0, this.stateStackLengthStack = new int[stackLength + 4], 0, stackLength);
    }
    this.stateStackLengthStack[this.valueLambdaNestDepth] = this.stateStackTop;
}
//true

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.JavaPlugin.getDialogSettingsSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
public IDialogSettings getDialogSettingsSection(String name) {
    IDialogSettings dialogSettings = getDialogSettings();
    IDialogSettings section = dialogSettings.getSection(name);
    if (section == null) {
        section = dialogSettings.addNewSection(name);
    }
    return section;
}
method: org.eclipse.jface.dialogs.DialogSettings.addNewSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
@Override
public IDialogSettings addNewSection(String sectionName) {
    DialogSettings section = new  DialogSettings(sectionName);
    addSection(section);
    return section;
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}
//false, the addNewSection() can't be inlined becasuse it belongs to another class.

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.ModelServiceImpl.getContainingContext(org.eclipse.e4.ui.model.application.ui.MUIElement;)org.eclipse.e4.core.contexts.IEclipseContext;2
@Override
public IEclipseContext getContainingContext(MUIElement element) {
    return ModelUtils.getContainingContext(element);
}
method: org.eclipse.e4.ui.model.internal.ModelUtils.getContainingContext(org.eclipse.e4.ui.model.application.MApplicationElement;)org.eclipse.e4.core.contexts.IEclipseContext;1
public static IEclipseContext getContainingContext(MApplicationElement element) {
    MApplicationElement curParent = getParent(element);
    while (curParent != null) {
        if (curParent instanceof MContext) {
            return ((MContext) curParent).getContext();
        }
        curParent = getParent(curParent);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.DependencyAnalysisSection.getPlugin()org.eclipse.pde.core.plugin.IPlugin;1
protected IPlugin getPlugin() {
    IBaseModel model = getPage().getModel();
    IPlugin plugin = null;
    if (model instanceof IPluginModel) {
        plugin = ((IPluginModel) model).getPlugin();
    }
    return plugin;
}
//false, the getContainingContext() can't be inlined becasuse it belongs to another class.

---------------Library-------------------
method: org.eclipse.jface.text.rules.RuleBasedPartitioner.getLegalContentTypes()Ajava.lang.String;1
public String[] getLegalContentTypes() {
    return TextUtilities.copy(fLegalContentTypes);
}
method: org.eclipse.jface.text.TextUtilities.copy(Ajava.lang.String;)Ajava.lang.String;1
public static String[] copy(String[] array) {
    if (array != null) {
        String[] copy = new String[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.getSelectedResources()Aorg.eclipse.core.resources.IResource;1
IResource[] getSelectedResources() {
    IResource[] selected = selectedResources;
    IResource[] resources = new IResource[selected.length];
    System.arraycopy(selected, 0, resources, 0, selected.length);
    return resources;
}
//false, the copy() can't be inlined becasuse it belongs to another class.
---------------Library-------------------
method: org.eclipse.ui.internal.navigator.resources.plugin.NavigatorUIPluginImages.setLocalImageDescriptors(org.eclipse.jface.action.IAction;java.lang.String;)V2
public static void setLocalImageDescriptors(IAction action, String iconName) {
    setImageDescriptors(action, "lcl16/", iconName);
}
method: org.eclipse.ui.internal.navigator.resources.plugin.NavigatorUIPluginImages.setImageDescriptors(org.eclipse.jface.action.IAction;java.lang.String;java.lang.String;)V3
public static void setImageDescriptors(IAction action, String type, String relPath) {
    action.setImageDescriptor(create("e" + type, relPath));
}
---------------Client-------------------
method: org.apache.batik.css.dom.CSSOMSVGPaint$AbstractModificationHandler.uriChanged(java.lang.String;)V2
public void uriChanged(String uri) {
    textChanged("url(" + uri + ") none");
}
//true
---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.PostfixLabelProvider.getImage(java.lang.Object;)org.eclipse.swt.graphics.Image;2
@Override
public Image getImage(Object element) {
    Image image = super.getImage(element);
    if (image != null)
        return image;
    return getParticipantImage(element);
}
method: org.eclipse.jdt.internal.ui.search.SearchLabelProvider.getParticipantImage(java.lang.Object;)org.eclipse.swt.graphics.Image;2
protected Image getParticipantImage(Object element) {
    ILabelProvider lp = getLabelProvider(element);
    if (lp == null)
        return null;
    return lp.getImage(element);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.DelegatingModelPresentation.getText(java.lang.Object;)java.lang.String;2
@Override
public String getText(Object item) {
    IDebugModelPresentation lp = getConfiguredPresentation(item);
    if (lp != null) {
        return lp.getText(item);
    }
    return getDefaultText(item);
}
//true
---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.provisional.TreeModelViewer.resetColumnSizes(Ajava.lang.String;)V2
@Override
public void resetColumnSizes(String[] columnIds) {
    super.resetColumnSizes(columnIds);
}
method: org.eclipse.debug.internal.ui.viewers.model.InternalTreeModelViewer.resetColumnSizes(Ajava.lang.String;)V2
public void resetColumnSizes(String[] columnIds) {
    for (int i = 0; i < columnIds.length; i++) {
        fColumnSizes.remove(columnIds[i]);
    }
}
---------------Client-------------------
method: org.eclipse.ui.ide.dialogs.ResourceTreeAndListGroup$2.filterElements(Ajava.lang.Object;org.eclipse.core.runtime.IProgressMonitor;)V3
public void filterElements(Object[] elements, IProgressMonitor monitor) {
    for (int i = 0; i < elements.length; i++) {
        returnValue.add(elements[i]);
    }
}
//false, the write() can't be inlined becasuse it belongs to super class.

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.toc.TocEditor.contributeToToolbar(org.eclipse.jface.action.IToolBarManager;)V2
public void contributeToToolbar(IToolBarManager manager) {
    if (WorkspaceModelManager.isPluginProject(getCommonProject()) && getAggregateModel().isEditable()) {
        manager.add(createUIControlConRegisterCS());
    }
}
method: org.eclipse.pde.internal.ua.ui.editor.toc.TocEditor.createUIControlConRegisterCS()org.eclipse.jface.action.ControlContribution;1
private ControlContribution createUIControlConRegisterCS() {
    return new  ControlContribution("Register") {

        protected Control createControl(Composite parent) {
            createUIImageHyperlinkRegisterToc(parent);
            createUIListenerImageHyperlinkRegisterToc();
            return fImageHyperlinkRegisterTOC;
        }
    };
}
---------------Client-------------------
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpEditor.contributeToToolbar(org.eclipse.jface.action.IToolBarManager;)V2
public void contributeToToolbar(IToolBarManager manager) {
    if (WorkspaceModelManager.isPluginProject(getCommonProject()) && getAggregateModel().isEditable()) {
        manager.add(new  ControlContribution("Register") {

            protected Control createControl(Composite parent) {
                ImageHyperlink fImageHyperlinkRegisterTOC = new  ImageHyperlink(parent, SWT.NONE);
                fImageHyperlinkRegisterTOC.setText(CtxHelpMessages.CtxHelpEditor_text);
                fImageHyperlinkRegisterTOC.setUnderlined(true);
                fImageHyperlinkRegisterTOC.setForeground(getToolkit().getHyperlinkGroup().getForeground());
                fImageHyperlinkRegisterTOC.addHyperlinkListener(new  IHyperlinkListener() {

                    public void linkActivated(HyperlinkEvent e) {
                        handleRegisterCtxHelpFile();
                    }

                    public void linkEntered(HyperlinkEvent e) {
                        ((ImageHyperlink) e.getSource()).setForeground(getToolkit().getHyperlinkGroup().getActiveForeground());
                        getEditorSite().getActionBars().getStatusLineManager().setMessage(CtxHelpMessages.CtxHelpEditor_text);
                    }

                    public void linkExited(HyperlinkEvent e) {
                        ((ImageHyperlink) e.getSource()).setForeground(getToolkit().getHyperlinkGroup().getForeground());
                        getEditorSite().getActionBars().getStatusLineManager().setMessage(null);
                    }
                });
                return fImageHyperlinkRegisterTOC;
            }
        });
    }
}
//true
---------------Library-------------------
method: org.eclipse.emf.ecore.impl.EPackageImpl.addEParameter(org.eclipse.emf.ecore.EOperation;org.eclipse.emf.ecore.EClassifier;java.lang.String;II)V6
protected void addEParameter(EOperation owner, EClassifier type, String name, int lowerBound, int upperBound) {
    EParameter p = internalAddEParameter(owner, type, name);
    p.setLowerBound(lowerBound);
    p.setUpperBound(upperBound);
}
method: org.eclipse.emf.ecore.impl.EPackageImpl.internalAddEParameter(org.eclipse.emf.ecore.EOperation;org.eclipse.emf.ecore.EClassifier;java.lang.String;)org.eclipse.emf.ecore.EParameter;4
private EParameter internalAddEParameter(EOperation owner, EClassifier type, String name) {
    EParameter p = ecoreFactory.createEParameter();
    p.setEType(type);
    p.setName(name);
    owner.getEParameters().add(p);
    return p;
}
---------------Client-------------------
method: org.eclipse.emf.ecore.impl.EPackageImpl.addEParameter(org.eclipse.emf.ecore.EOperation;org.eclipse.emf.ecore.EGenericType;java.lang.String;II)V6
@Deprecated
protected void addEParameter(EOperation owner, EGenericType type, String name, int lowerBound, int upperBound) {
    EParameter p = ecoreFactory.createEParameter();
    p.setEGenericType(type);
    p.setName(name);
    owner.getEParameters().add(p);
    p.setLowerBound(lowerBound);
    p.setUpperBound(upperBound);
}
//true
---------------Library-------------------
method: org.eclipse.jdt.internal.ui.viewsupport.SelectionProviderMediator$InternalListener.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    doSelectionChanged(event);
}
method: org.eclipse.jdt.internal.ui.viewsupport.SelectionProviderMediator.doSelectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
final void doSelectionChanged(SelectionChangedEvent event) {
    ISelectionProvider provider = event.getSelectionProvider();
    if (provider == fViewerInFocus) {
        fireSelectionChanged();
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event e) {
    Widget source = e.widget;
    if (source == destinationBrowseButton) {
        handleDestinationBrowseButtonPressed();
    }
    updatePageCompletion();
}
//true

---------------Library-------------------
method: org.eclipse.jdt.launching.JavaRuntime.newRuntimeContainerClasspathEntry(org.eclipse.core.runtime.IPath;I)org.eclipse.jdt.launching.IRuntimeClasspathEntry;2
public static IRuntimeClasspathEntry newRuntimeContainerClasspathEntry(IPath path, int classpathProperty) throws CoreException {
    return newRuntimeContainerClasspathEntry(path, classpathProperty, null);
}
method: org.eclipse.jdt.launching.JavaRuntime.newRuntimeContainerClasspathEntry(org.eclipse.core.runtime.IPath;ILorg.eclipse.jdt.core.IJavaProject;)org.eclipse.jdt.launching.IRuntimeClasspathEntry;3
public static IRuntimeClasspathEntry newRuntimeContainerClasspathEntry(IPath path, int classpathProperty, IJavaProject project) throws CoreException {
    RuntimeClasspathEntry entry = new  RuntimeClasspathEntry(JavaCore.newContainerEntry(path), classpathProperty);
    entry.setJavaProject(project);
    return entry;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.bundle.ExportPackageHeader.addPackage(java.lang.String;)org.eclipse.pde.internal.core.text.bundle.ExportPackageObject;2
public ExportPackageObject addPackage(String id) {
    ExportPackageObject obj = new  ExportPackageObject(this, id, null, getVersionAttribute());
    addManifestElement(obj);
    return obj;
}
//true
---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.AbstractConfigurationBlockPreferenceAndPropertyPage.dispose()V1
@Override
public void dispose() {
    fConfigurationBlock.dispose();
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
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.toc.text.TocModel.getRoot()org.eclipse.pde.core.IWritable;1
protected IWritable getRoot() {
    return getToc();
}
method: org.eclipse.pde.internal.ua.core.toc.text.TocModel.getToc()org.eclipse.pde.internal.ua.core.toc.text.Toc;1
public Toc getToc() {
    if (fToc == null) {
        fToc = getFactory().createToc();
    }
    return fToc;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntProjectNodeProxy.getLabel()java.lang.String;1
@Override
public String getLabel() {
    if (fProject == null) {
        parseBuildFile();
    }
    fName = super.getLabel();
    return fName;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.targetdefinition.DefinitionPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.ProblemsView.getUndoContext()org.eclipse.core.commands.operations.IUndoContext;1
protected IUndoContext getUndoContext() {
    return WorkspaceUndoUtil.getProblemsUndoContext();
}
method: org.eclipse.ui.ide.undo.WorkspaceUndoUtil.getProblemsUndoContext()org.eclipse.core.commands.operations.IUndoContext;0
public static IUndoContext getProblemsUndoContext() {
    if (problemsUndoContext == null) {
        problemsUndoContext = new  ObjectUndoContext(new  Object(), "Problems Context");
        problemsUndoContext.addMatch(getWorkspaceUndoContext());
    }
    return problemsUndoContext;
}
---------------Client-------------------
method: org.eclipse.debug.ui.DebugUITools.getBreakpointsUndoContext()org.eclipse.core.commands.operations.IUndoContext;0
public static synchronized IUndoContext getBreakpointsUndoContext() {
    if (fgBreakpointsUndoContext == null) {
        fgBreakpointsUndoContext = new  ObjectUndoContext(new  Object(), "Breakpoints Context");
        fgBreakpointsUndoContext.addMatch(WorkspaceUndoUtil.getWorkspaceUndoContext());
    }
    return fgBreakpointsUndoContext;
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.views.AllTopicsPart$1.treeCollapsed(org.eclipse.jface.viewers.TreeExpansionEvent;)V2
public void treeCollapsed(TreeExpansionEvent event) {
    postUpdate(event.getElement());
}
method: org.eclipse.help.ui.internal.views.HyperlinkTreePart.postUpdate(java.lang.Object;)V2
protected void postUpdate(final Object obj) {
    treeViewer.getControl().getDisplay().asyncExec(new  Runnable() {

        public void run() {
            treeViewer.update(obj, null);
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumePushLeftBrace()V1
protected void consumePushLeftBrace() {
    pushOnIntStack(this.endPosition);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeElidedLeftBraceAndReturn()V1
protected void consumeElidedLeftBraceAndReturn() {
    int stackLength = this.stateStackLengthStack.length;
    if (++this.valueLambdaNestDepth >= stackLength) {
        System.arraycopy(this.stateStackLengthStack, 0, this.stateStackLengthStack = new int[stackLength + 4], 0, stackLength);
    }
    this.stateStackLengthStack[this.valueLambdaNestDepth] = this.stateStackTop;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.provisional.AsynchronousContentAdapter.getRetrieveChildrenRule(java.lang.Object;org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;)org.eclipse.core.runtime.jobs.ISchedulingRule;3
protected ISchedulingRule getRetrieveChildrenRule(Object parent, IPresentationContext context) {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(context);
}
method: org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory.getDefault()org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory;0
public static AsynchronousSchedulingRuleFactory getDefault() {
    if (fgFactory == null) {
        fgFactory = new  AsynchronousSchedulingRuleFactory();
    }
    return fgFactory;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.create()V1
@Override
public void create() {
    super.create();
    pattern.setFocus();
}
method: org.eclipse.ui.dialogs.SelectionStatusDialog.create()V1
@Override
public void create() {
    super.create();
    if (fLastStatus != null) {
        updateStatus(fLastStatus);
    }
}
---------------Client-------------------
method: org.eclipse.ui.intro.contentproviders.EclipseRSSViewer$2.run()V1
public void run() {
    IIntroURL introUrl = IntroURLFactory.createIntroURL(url);
    if (introUrl != null) {
        introUrl.execute();
        return;
    }
    openBrowser(url);
}

---------------Library-------------------
method: org.eclipse.jface.viewers.ColumnViewer.updateCell(org.eclipse.jface.viewers.ViewerRow;ILjava.lang.Object;)org.eclipse.jface.viewers.ViewerCell;4
ViewerCell updateCell(ViewerRow rowItem, int column, Object element) {
    cell.update(rowItem, column, element);
    return cell;
}
method: org.eclipse.jface.viewers.ViewerCell.update(org.eclipse.jface.viewers.ViewerRow;ILjava.lang.Object;)V4
void update(ViewerRow rowItem, int column, Object element) {
    row = rowItem;
    columnIndex = column;
    this.element = element;
}
---------------Client-------------------
method: org.objectweb.asm.tree.InsnList$InsnListIterator.previous()java.lang.Object;1
public Object previous() {
    AbstractInsnNode result = prev;
    next = result;
    prev = result.prev;
    remove = result;
    return result;
}

---------------Library-------------------
method: org.eclipse.e4.ui.workbench.swt.internal.copy.FilteredTree.doCreateRefreshJob()org.eclipse.e4.ui.workbench.swt.internal.copy.BasicUIJob;1
protected BasicUIJob doCreateRefreshJob() {
    return new  BasicUIJob("Refresh Filter", parent.getDisplay()) {

        @Override
        public IStatus runInUIThread(IProgressMonitor monitor) {
            if (treeViewer.getControl().isDisposed()) {
                return Status.CANCEL_STATUS;
            }
            String text = getFilterString();
            if (text == null) {
                return Status.OK_STATUS;
            }
            boolean initial = initialText != null && initialText.equals(text);
            if (initial) {
                patternFilter.setPattern(null);
            } else if (text != null) {
                patternFilter.setPattern(text);
            }
            Control redrawFalseControl = treeComposite != null ? treeComposite : treeViewer.getControl();
            try {
                redrawFalseControl.setRedraw(false);
                if (!narrowingDown) {
                    TreeItem[] is = treeViewer.getTree().getItems();
                    for (int i = 0; i < is.length; i++) {
                        TreeItem item = is[i];
                        if (item.getExpanded()) {
                            treeViewer.setExpandedState(item.getData(), false);
                        }
                    }
                }
                treeViewer.refresh(true);
                if (text.length() > 0 && !initial) {
                    TreeItem[] items = getViewer().getTree().getItems();
                    int treeHeight = getViewer().getTree().getBounds().height;
                    int numVisibleItems = treeHeight / getViewer().getTree().getItemHeight();
                    long stopTime = SOFT_MAX_EXPAND_TIME + System.currentTimeMillis();
                    boolean cancel = false;
                    if (items.length > 0 && recursiveExpand(items, monitor, stopTime, new int[] { numVisibleItems })) {
                        cancel = true;
                    }
                    updateToolbar(true);
                    if (cancel) {
                        return Status.CANCEL_STATUS;
                    }
                } else {
                    updateToolbar(false);
                }
            } finally {
                TreeItem[] items = getViewer().getTree().getItems();
                if (items.length > 0 && getViewer().getTree().getSelectionCount() == 0) {
                    treeViewer.getTree().setTopItem(items[0]);
                }
                redrawFalseControl.setRedraw(true);
            }
            return Status.OK_STATUS;
        }

        private boolean recursiveExpand(TreeItem[] items, IProgressMonitor monitor, long cancelTime, int[] numItemsLeft) {
            boolean canceled = false;
            for (int i = 0; !canceled && i < items.length; i++) {
                TreeItem item = items[i];
                boolean visible = numItemsLeft[0]-- >= 0;
                if (monitor.isCanceled() || (!visible && System.currentTimeMillis() > cancelTime)) {
                    canceled = true;
                } else {
                    Object itemData = item.getData();
                    if (itemData != null) {
                        if (!item.getExpanded()) {
                            treeViewer.setExpandedState(itemData, true);
                        }
                        TreeItem[] children = item.getItems();
                        if (items.length > 0) {
                            canceled = recursiveExpand(children, monitor, cancelTime, numItemsLeft);
                        }
                    }
                }
            }
            return canceled;
        }
    };
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.VersionFormat.toString()java.lang.String;1
public synchronized String toString() {
    if (fmtString == null) {
        StringBuffer sb = new  StringBuffer();
        toString(sb);
    }
    return fmtString;
}

---------------Library-------------------
method: org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring.setProcessor(org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;)V2
public void setProcessor(RefactoringProcessor processor) {
    processor.setRefactoring(this);
    fProcessor = processor;
}
method: org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor.setRefactoring(org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;)V2
void setRefactoring(ProcessorBasedRefactoring refactoring) {
    Assert.isTrue(fRefactoring == null, "The refactoring can only be set once");
    Assert.isNotNull(refactoring);
    fRefactoring = refactoring;
}
---------------Client-------------------
method: org.eclipse.jdt.core.refactoring.descriptors.MoveDescriptor.setMoveMembers(Aorg.eclipse.jdt.core.IMember;)V2
public void setMoveMembers(final IMember[] members) {
    Assert.isNotNull(members);
    Assert.isTrue(fMovePolicy == null, "Clients must only call one of the 'setMoveXXX' methods.");
    fMembers = members;
    fMovePolicy = POLICY_MOVE_MEMBERS;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptySwitchBlock()V1
protected void consumeEmptySwitchBlock() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.ui.internal.dialogs.DialogUtil.inRegularFontMode(org.eclipse.swt.widgets.Composite;)Z1
public static boolean inRegularFontMode(Composite parent) {
    return availableRows(parent) > 50;
}
method: org.eclipse.ui.internal.dialogs.DialogUtil.availableRows(org.eclipse.swt.widgets.Composite;)I1
public static int availableRows(Composite parent) {
    int fontHeight = (parent.getFont().getFontData())[0].getHeight();
    int displayHeight = parent.getDisplay().getClientArea().height;
    return displayHeight / fontHeight;
}
---------------Client-------------------
method: org.eclipse.ui.internal.editors.text.SelectResourcesDialog.useHeightHint(org.eclipse.swt.widgets.Composite;)Z2
private boolean useHeightHint(Composite parent) {
    int fontHeight = (parent.getFont().getFontData())[0].getHeight();
    int displayHeight = parent.getDisplay().getClientArea().height;
    return (displayHeight / fontHeight) > 50;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTFontHelper.storeDefaultFont(org.eclipse.swt.widgets.Control;)V1
public static void storeDefaultFont(Control control) {
    storeDefaultFont(control, control.getFont());
}
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTFontHelper.storeDefaultFont(org.eclipse.swt.widgets.Widget;org.eclipse.swt.graphics.Font;)V2
private static void storeDefaultFont(Widget widget, Font font) {
    if (widget.getData(DEFAULT_FONT) == null) {
        widget.setData(DEFAULT_FONT, font);
    }
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Composite.layout(Aorg.eclipse.swt.widgets.Control;)V2
public void layout(Control[] changed) {
    checkWidget();
    if (changed == null)
        error(SWT.ERROR_INVALID_ARGUMENT);
    layout(changed, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpPage.modelChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
public void modelChanged(IModelChangedEvent event) {
    fBlock.modelChanged(event);
}
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpBlock.modelChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
public void modelChanged(IModelChangedEvent event) {
    if (fMasterSection != null) {
        fMasterSection.modelChanged(event);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AddSourceFolderWizardPage$LinkFields.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    if (fAdapter != null) {
        fAdapter.dialogFieldChanged(fLinkLocation);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.model.TestRunListenerAdapter.sessionEnded(J)V2
public void sessionEnded(long elapsedTime) {
    fireSessionFinished();
    fSession.swapOut();
}
method: org.eclipse.jdt.internal.junit.model.TestRunListenerAdapter.fireSessionFinished()V1
private void fireSessionFinished() {
    Object[] listeners = getListeners();
    for (int i = 0; i < listeners.length; i++) {
        ((TestRunListener) listeners[i]).sessionFinished(fSession);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction$2.menuShown(org.eclipse.swt.events.MenuEvent;)V2
@Override
public void menuShown(MenuEvent e) {
    Menu m = (Menu) e.widget;
    MenuItem[] items = m.getItems();
    for (int i = 0; i < items.length; i++) {
        items[i].dispose();
    }
    fillMenu(m);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSURI.decodeAuthority(java.lang.String;)java.lang.String;1
private static String decodeAuthority(String authority) {
    authority = decode('/', '!', authority);
    authority = decode('@', '~', authority);
    authority = decode(':', '_', authority);
    return authority;
}
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSURI.decode(CCLjava.lang.String;)java.lang.String;3
private static String decode(char encodedChar, char encoding, String string) {
    String reuslt = string.replace(encoding, encodedChar);
    return reuslt.replaceAll(new  String(new char[] { encodedChar, encodedChar }), new  String(new char[] { encoding }));
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSURI.encode(CCLjava.lang.String;)java.lang.String;4
private String encode(char charToEncode, char encoding, String string) {
    String result = string.replaceAll(new  String(new char[] { encoding }), new  String(new char[] { encoding, encoding }));
    return result.replace(charToEncode, encoding);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbItem.setSelected(Z)V2
void setSelected(boolean selected) {
    fDetailsBlock.setSelected(selected);
}
method: org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbItemDetails.setSelected(Z)V2
public void setSelected(boolean selected) {
    if (selected == fSelected)
        return;
    fSelected = selected;
    updateSelection();
}
---------------Client-------------------
method: org.eclipse.ui.internal.EditorMenuManager.setEnabledAllowed(Z)V2
public void setEnabledAllowed(boolean enabledAllowed) {
    if (this.enabledAllowed == enabledAllowed) {
        return;
    }
    this.enabledAllowed = enabledAllowed;
    overrides.updateEnabledAllowed();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.toc.TocTreeSection.dispose()V1
public void dispose() {
    PDEUserAssistanceUIPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ua.ui.PDEUserAssistanceUIPlugin.getLabelProvider()org.eclipse.pde.internal.ua.ui.PDEUserAssistanceLabelProvider;1
public PDEUserAssistanceLabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDEUserAssistanceLabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.ui.internal.WorkingSetManager.addRecentWorkingSet(org.eclipse.ui.IWorkingSet;)V2
@Override
public void addRecentWorkingSet(IWorkingSet workingSet) {
    internalAddRecentWorkingSet(workingSet);
    saveState();
}
method: org.eclipse.ui.internal.WorkingSetManager.saveState()V1
private void saveState() {
    if (restoreInProgress) {
        savePending = true;
        return;
    }
    File stateFile = getWorkingSetStateFile();
    if (stateFile == null) {
        return;
    }
    try {
        saveState(stateFile);
    } catch (IOException e) {
        stateFile.delete();
        handleInternalError(e, WorkbenchMessages.ProblemSavingWorkingSetState_title, WorkbenchMessages.ProblemSavingWorkingSetState_message);
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.AbstractSynchronizePage.init(org.eclipse.team.ui.synchronize.ISynchronizePageSite;)V2
public void init(ISynchronizePageSite site) {
    this.site = site;
    IDialogSettings settings = getSettings();
    if (settings != null) {
        try {
            int mode = settings.getInt(ISynchronizePageConfiguration.P_MODE);
            if (mode != 0) {
                configuration.setMode(mode);
            }
        } catch (NumberFormatException e) {
        }
    }
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.actions.RefreshAction$1.keyReleased(org.eclipse.swt.events.KeyEvent;)V2
public void keyReleased(KeyEvent e) {
    handleKeyReleased(e);
}
method: org.eclipse.equinox.internal.p2.ui.actions.RefreshAction.handleKeyReleased(org.eclipse.swt.events.KeyEvent;)V2
public void handleKeyReleased(KeyEvent event) {
    if (event.keyCode == SWT.F5 && event.stateMask == 0) {
        refresh();
    }
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathBlock$2.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
@Override
public void keyPressed(KeyEvent event) {
    if (event.character == SWT.DEL && event.stateMask == 0) {
        remove();
    }
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;6
public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth, org.hamcrest.Matcher<? super T> sixth) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third, fourth, fifth, sixth);
}
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;6
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth, Matcher<? super T> sixth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    matchers.add(sixth);
    return anyOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;6
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth, Matcher<? super T> sixth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(6);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    matchers.add(sixth);
    return allOf(matchers);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.views.dependencies.DependenciesView$ShowLoopsAction.run()V1
@Override
public void run() {
    LoopDialog dialog = new  LoopDialog(PDEPlugin.getActiveWorkbenchShell(), fLoops);
    dialog.open();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareUIPlugin$4.run()V1
public void run() {
    CompareDialog dialog = new  CompareDialog(PlatformUI.getWorkbench().getModalDialogShellProvider().getShell(), input);
    dialog.open();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.exports.BaseExportWizard.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.mapping.ResourceChangeDescriptionFactory.fail(org.eclipse.core.runtime.CoreException;)V2
private void fail(CoreException e) {
    Policy.log(e.getStatus().getSeverity(), "An internal error occurred while accumulating a change description.", e);
}
method: org.eclipse.core.internal.utils.Policy.log(ILjava.lang.String;java.lang.Throwable;)V3
public static void log(int severity, String message, Throwable t) {
    if (message == null)
        message = "";
    log(new  Status(severity, ResourcesPlugin.PI_RESOURCES, 1, message, t));
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.HistoryStore2.log(org.eclipse.core.runtime.CoreException;)V2
private void log(CoreException e) {
    IStatus status = e.getStatus();
    if (status.getException() == null)
        status = new  Status(IStatus.ERROR, ResourcesPlugin.PI_RESOURCES, IResourceStatus.FAILED_WRITE_METADATA, "Internal error in history store", e);
    Policy.log(status);
}

---------------Library-------------------
method: org.eclipse.ui.internal.keys.NewKeysPreferencePage$CategoryFilterTree.filterCategories(Z)V2
public void filterCategories(boolean b) {
    filter.filterCategories(b);
    textChanged();
}
method: org.eclipse.ui.internal.keys.CategoryPatternFilter.filterCategories(Z)V2
public void filterCategories(boolean b) {
    filterCategories = b;
    if (filterCategories) {
        setPattern("org.eclipse.ui.keys.optimization.false");
    } else {
        setPattern("org.eclipse.ui.keys.optimization.true");
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ComboDialogField.setText(java.lang.String;)V2
public void setText(String text) {
    fText = text;
    if (isOkToUse(fComboControl)) {
        fComboControl.setText(text);
    } else {
        dialogFieldChanged();
    }
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEEnum_UniqueEnumeratorNames(org.eclipse.emf.ecore.EEnum;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEEnum_UniqueEnumeratorNames(EEnum eEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    EList<EEnumLiteral> eLiterals = eEnum.getELiterals();
    Map<String, List<EEnumLiteral>> keys = new  HashMap<String, List<EEnumLiteral>>();
    for (EEnumLiteral eEnumLiteral : eLiterals) {
        String name = eEnumLiteral.getName();
        if (name != null) {
            String key = name.replace("_", "").toUpperCase();
            List<EEnumLiteral> eEnumLiterals = keys.get(key);
            if (eEnumLiterals == null) {
                eEnumLiterals = new  ArrayList<EEnumLiteral>();
                keys.put(key, eEnumLiterals);
            }
            eEnumLiterals.add(eEnumLiteral);
            if (eEnumLiterals.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EEnumLiteral>> entry : keys.entrySet()) {
            List<EEnumLiteral> eEnumLiterals = entry.getValue();
            if (eEnumLiterals.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(eEnum);
                for (EEnumLiteral eEnumLiteral : eEnumLiterals) {
                    names.add(eEnumLiteral.getName());
                    objects.add(eEnumLiteral);
                }
                objects.add(EcorePackage.Literals.EENUM__ELITERALS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumDissimilarEnumeratorNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumUniqueEnumeratorNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}
method: org.eclipse.emf.ecore.impl.ENamedElementImpl.getName()java.lang.String;1
public String getName() {
    return getNameGen();
}
---------------Client-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEPackage_UniqueClassifierNames(org.eclipse.emf.ecore.EPackage;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEPackage_UniqueClassifierNames(EPackage ePackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    Map<String, List<EClassifier>> keys = new  HashMap<String, List<EClassifier>>();
    for (EClassifier eClassifier : ePackage.getEClassifiers()) {
        String name = eClassifier.getName();
        if (name != null) {
            String key = name.replace("_", "").toLowerCase();
            List<EClassifier> eClassifiers = keys.get(key);
            if (eClassifiers == null) {
                eClassifiers = new  ArrayList<EClassifier>();
                keys.put(key, eClassifiers);
            }
            eClassifiers.add(eClassifier);
            if (eClassifiers.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EClassifier>> entry : keys.entrySet()) {
            List<EClassifier> eClassifiers = entry.getValue();
            if (eClassifiers.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(ePackage);
                for (EClassifier eClassifier : eClassifiers) {
                    names.add(eClassifier.getName());
                    objects.add(eClassifier);
                }
                objects.add(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageDissimilarClassifierNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageUniqueClassifierNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEEnum_UniqueEnumeratorNames(org.eclipse.emf.ecore.EEnum;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEEnum_UniqueEnumeratorNames(EEnum eEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    EList<EEnumLiteral> eLiterals = eEnum.getELiterals();
    Map<String, List<EEnumLiteral>> keys = new  HashMap<String, List<EEnumLiteral>>();
    for (EEnumLiteral eEnumLiteral : eLiterals) {
        String name = eEnumLiteral.getName();
        if (name != null) {
            String key = name.replace("_", "").toUpperCase();
            List<EEnumLiteral> eEnumLiterals = keys.get(key);
            if (eEnumLiterals == null) {
                eEnumLiterals = new  ArrayList<EEnumLiteral>();
                keys.put(key, eEnumLiterals);
            }
            eEnumLiterals.add(eEnumLiteral);
            if (eEnumLiterals.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EEnumLiteral>> entry : keys.entrySet()) {
            List<EEnumLiteral> eEnumLiterals = entry.getValue();
            if (eEnumLiterals.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(eEnum);
                for (EEnumLiteral eEnumLiteral : eEnumLiterals) {
                    names.add(eEnumLiteral.getName());
                    objects.add(eEnumLiteral);
                }
                objects.add(EcorePackage.Literals.EENUM__ELITERALS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumDissimilarEnumeratorNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumUniqueEnumeratorNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}
method: org.eclipse.emf.ecore.impl.ENamedElementImpl.getName()java.lang.String;1
public String getName() {
    return getNameGen();
}
---------------Client-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEPackage_UniqueClassifierNames(org.eclipse.emf.ecore.EPackage;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEPackage_UniqueClassifierNames(EPackage ePackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    Map<String, List<EClassifier>> keys = new  HashMap<String, List<EClassifier>>();
    for (EClassifier eClassifier : ePackage.getEClassifiers()) {
        String name = eClassifier.getName();
        if (name != null) {
            String key = name.replace("_", "").toLowerCase();
            List<EClassifier> eClassifiers = keys.get(key);
            if (eClassifiers == null) {
                eClassifiers = new  ArrayList<EClassifier>();
                keys.put(key, eClassifiers);
            }
            eClassifiers.add(eClassifier);
            if (eClassifiers.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EClassifier>> entry : keys.entrySet()) {
            List<EClassifier> eClassifiers = entry.getValue();
            if (eClassifiers.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(ePackage);
                for (EClassifier eClassifier : eClassifiers) {
                    names.add(eClassifier.getName());
                    objects.add(eClassifier);
                }
                objects.add(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageDissimilarClassifierNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageUniqueClassifierNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.jface.resource.JFaceResources.getDialogFontDescriptor()org.eclipse.jface.resource.FontDescriptor;0
public static FontDescriptor getDialogFontDescriptor() {
    return getFontRegistry().getDescriptor(DIALOG_FONT);
}
method: org.eclipse.jface.resource.JFaceResources.getFontRegistry()org.eclipse.jface.resource.FontRegistry;0
public static FontRegistry getFontRegistry() {
    if (fontRegistry == null) {
        fontRegistry = new  FontRegistry("org.eclipse.jface.resource.jfacefonts");
    }
    return fontRegistry;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.apache.lucene.search.FieldCache$CacheEntry.estimateSize()V1
public void estimateSize() {
    estimateSize(new  RamUsageEstimator(false));
}
method: org.apache.lucene.search.FieldCache$CacheEntry.estimateSize(org.apache.lucene.util.RamUsageEstimator;)V2
public void estimateSize(RamUsageEstimator ramCalc) {
    long size = ramCalc.estimateRamUsage(getValue());
    setEstimatedSize(RamUsageEstimator.humanReadableUnits(size, new  DecimalFormat("0.#")));
}
---------------Client-------------------
method: org.eclipse.ui.internal.navigator.filters.CustomizationTab.createInstructionsLabel(java.lang.String;)V2
protected void createInstructionsLabel(String labelText) {
    Label extensionsInstructionLabel = new  Label(this, SWT.BOLD | SWT.WRAP);
    GridData gridData = new  GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);
    extensionsInstructionLabel.setLayoutData(gridData);
    extensionsInstructionLabel.setFont(getFont());
    extensionsInstructionLabel.setText(labelText);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor.doSetSelection(org.eclipse.jface.viewers.ISelection;)V2
@Override
protected void doSetSelection(ISelection selection) {
    super.doSetSelection(selection);
    synchronizeOutlinePage(true);
}
method: org.eclipse.ant.internal.ui.editor.AntEditor.synchronizeOutlinePage(Z)V2
public void synchronizeOutlinePage(boolean checkIfOutlinePageActive) {
    if (getSelectionProvider() == null) {
        return;
    }
    AntElementNode node = getNode();
    synchronizeOutlinePage(node, checkIfOutlinePageActive);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.frameworkadmin.equinox.EclipseLauncherParser.getPersistentDataLocation(java.util.List;java.net.URI;java.net.URI;org.eclipse.equinox.internal.provisional.frameworkadmin.LauncherData;)V5
private void getPersistentDataLocation(List<String> lines, URI osgiInstallArea, URI configArea, LauncherData launcherData) {
    if (launcherData.getFwPersistentDataLocation() == null) {
        launcherData.setFwPersistentDataLocation(URIUtil.toFile(configArea), ParserUtils.isArgumentSet(EquinoxConstants.OPTION_CLEAN, lines));
    }
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor.doSetSelection(org.eclipse.jface.viewers.ISelection;)V2
@Override
protected void doSetSelection(ISelection selection) {
    super.doSetSelection(selection);
    synchronizeOutlinePage(true);
}
method: org.eclipse.ui.texteditor.AbstractTextEditor.doSetSelection(org.eclipse.jface.viewers.ISelection;)V2
protected void doSetSelection(ISelection selection) {
    if (selection instanceof ITextSelection) {
        ITextSelection textSelection = (ITextSelection) selection;
        selectAndReveal(textSelection.getOffset(), textSelection.getLength());
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor.configureToggleCommentAction()V1
private void configureToggleCommentAction() {
    IAction action = getAction("ToggleComment");
    if (action instanceof ToggleCommentAction) {
        ISourceViewer sourceViewer = getSourceViewer();
        SourceViewerConfiguration configuration = getSourceViewerConfiguration();
        ((ToggleCommentAction) action).configure(sourceViewer, configuration);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.decorators.DecorationScheduler.clearResults()V1
void clearResults() {
    if (clearJob == null) {
        clearJob = getClearJob();
    }
    clearJob.schedule();
}
method: org.eclipse.ui.internal.decorators.DecorationScheduler.getClearJob()org.eclipse.core.runtime.jobs.Job;1
private Job getClearJob() {
    Job clear = new  Job(WorkbenchMessages.DecorationScheduler_ClearResultsJob) {

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            resultCache.clear();
            return Status.OK_STATUS;
        }

        @Override
        public boolean shouldRun() {
            return PlatformUI.isWorkbenchRunning();
        }
    };
    clear.setSystem(true);
    return clear;
}
---------------Client-------------------
method: org.eclipse.ui.actions.CopyProjectOperation.recordError(org.eclipse.core.runtime.CoreException;)V2
private void recordError(CoreException error) {
    if (errorStatus == null) {
        errorStatus = new  MultiStatus(PlatformUI.PLUGIN_ID, IStatus.ERROR, IDEWorkbenchMessages.CopyProjectOperation_copyFailedMessage, error);
    }
    errorStatus.merge(error.getStatus());
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;)Z2
public boolean visit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration node) {
    visitBodyDeclaration(node);
    return true;
}
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visitBodyDeclaration(org.eclipse.jdt.core.dom.BodyDeclaration;)V2
private void visitBodyDeclaration(final BodyDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)Z2
public boolean visit(SingleVariableDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.team.core.variants.PersistantResourceVariantByteStore.isVariantKnown(org.eclipse.core.resources.IResource;)Z2
public boolean isVariantKnown(IResource resource) throws TeamException {
    return internalGetSyncBytes(resource) != null;
}
method: org.eclipse.team.core.variants.PersistantResourceVariantByteStore.internalGetSyncBytes(org.eclipse.core.resources.IResource;)AB2
private byte[] internalGetSyncBytes(IResource resource) throws TeamException {
    try {
        return getSynchronizer().getSyncInfo(getSyncName(), resource);
    } catch (CoreException e) {
        throw TeamException.asTeamException(e);
    }
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.model.ViewerStateTracker.isDeltaInParent(org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDelta;org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;)Z3
private boolean isDeltaInParent(IModelDelta delta, ModelDelta destParent) {
    return destParent.getChildDelta(delta.getElement(), delta.getIndex()) != null;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathContentProvider.removeAll()V1
public void removeAll() {
    model.removeAll();
    refresh();
}
method: org.eclipse.ant.internal.ui.preferences.ClasspathModel.removeAll()V1
public void removeAll() {
    if (fAntHomeEntry != null) {
        fAntHomeEntry.removeAll();
    }
    if (fUserGlobalEntry != null) {
        fUserGlobalEntry.removeAll();
    }
}
---------------Client-------------------
method: org.eclipse.jface.resource.FontRegistry$FontRecord.dispose()V1
void dispose() {
    baseFont.dispose();
    if (boldFont != null) {
        boldFont.dispose();
    }
    if (italicFont != null) {
        italicFont.dispose();
    }
}

---------------Library-------------------
method: org.eclipse.search.internal.ui.SearchResultView.getDisplay()org.eclipse.swt.widgets.Display;1
Display getDisplay() {
    return fViewer.getControl().getDisplay();
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.ToolItem.getParent()org.eclipse.swt.widgets.ToolBar;1
public ToolBar getParent() {
    checkWidget();
    if (parent == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return parent;
}

---------------Library-------------------
method: org.eclipse.search2.internal.ui.QueryManager.queryStarting(org.eclipse.search.ui.ISearchQuery;)V2
public void queryStarting(ISearchQuery query) {
    fireStarting(query);
}
method: org.eclipse.search2.internal.ui.QueryManager.fireStarting(org.eclipse.search.ui.ISearchQuery;)V2
public void fireStarting(ISearchQuery query) {
    Set copiedListeners = new  HashSet();
    synchronized (fListeners) {
        copiedListeners.addAll(fListeners);
    }
    Iterator listeners = copiedListeners.iterator();
    while (listeners.hasNext()) {
        IQueryListener l = (IQueryListener) listeners.next();
        l.queryStarting(query);
    }
}
---------------Client-------------------
method: org.eclipse.search.ui.text.AbstractTextSearchResult.fireChange(org.eclipse.search.ui.SearchResultEvent;)V2
protected void fireChange(SearchResultEvent e) {
    HashSet copiedListeners = new  HashSet();
    synchronized (fListeners) {
        copiedListeners.addAll(fListeners);
    }
    Iterator listeners = copiedListeners.iterator();
    while (listeners.hasNext()) {
        ((ISearchResultListener) listeners.next()).searchResultChanged(e);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.registry.EditorDescriptor.getPluginId()java.lang.String;1
@Override
public String getPluginId() {
    return getPluginID();
}
method: org.eclipse.ui.internal.registry.EditorDescriptor.getPluginID()java.lang.String;1
public String getPluginID() {
    if (configurationElement != null) {
        return configurationElement.getNamespace();
    }
    return pluginIdentifier;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.noMoreAvailableSpaceForConstant(org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;)V2
public void noMoreAvailableSpaceForConstant(TypeDeclaration typeDeclaration) {
    this.handle(IProblem.TooManyBytesForStringConstant, new String[] { new  String(typeDeclaration.binding.readableName()) }, new String[] { new  String(typeDeclaration.binding.shortReadableName()) }, ProblemSeverities.Abort | ProblemSeverities.Error | ProblemSeverities.Fatal, typeDeclaration.sourceStart, typeDeclaration.sourceEnd);
}
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.handle(IAjava.lang.String;Ajava.lang.String;III)V7
private void handle(int problemId, String[] problemArguments, String[] messageArguments, int severity, int problemStartPosition, int problemEndPosition) {
    this.handle(problemId, problemArguments, 0, messageArguments, severity, problemStartPosition, problemEndPosition);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.illegalTypeForExplicitThis(org.eclipse.jdt.internal.compiler.ast.Receiver;org.eclipse.jdt.internal.compiler.lookup.TypeBinding;)V3
public void illegalTypeForExplicitThis(Receiver receiver, TypeBinding expectedType) {
    this.handle(IProblem.IllegalTypeForExplicitThis, new String[] { new  String(expectedType.readableName()) }, new String[] { new  String(expectedType.shortReadableName()) }, receiver.type.sourceStart, receiver.type.sourceEnd);
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.observable.DelayedObservableValue.makeDirty()V1
private void makeDirty() {
    if (!dirty) {
        dirty = true;
        fireStale();
    }
    cancelScheduledUpdate();
    scheduleUpdate();
}
method: org.eclipse.core.internal.databinding.observable.DelayedObservableValue.cancelScheduledUpdate()V1
private void cancelScheduledUpdate() {
    if (updater != null) {
        updater.cancel();
        updater = null;
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.browser.WebBrowserEditor.dispose()V1
public void dispose() {
    if (image != null && !image.isDisposed())
        image.dispose();
    image = null;
    super.dispose();
    disposed = true;
}

---------------Library-------------------
method: org.eclipse.ui.internal.decorators.LightweightDecoratorManager.getDecorations(java.lang.Object;org.eclipse.ui.internal.decorators.DecorationBuilder;)V3
public void getDecorations(Object element, DecorationBuilder decoration) {
    LightweightDecoratorDefinition[] decorators = getDecoratorsFor(element);
    for (int i = 0; i < decorators.length; i++) {
        LightweightDecoratorDefinition dd = decorators[i];
        decoration.setCurrentDefinition(dd);
        decorate(element, decoration, dd);
    }
}
method: org.eclipse.ui.internal.decorators.LightweightDecoratorManager.decorate(java.lang.Object;org.eclipse.ui.internal.decorators.DecorationBuilder;org.eclipse.ui.internal.decorators.LightweightDecoratorDefinition;)V4
private void decorate(Object element, DecorationBuilder decoration, LightweightDecoratorDefinition decorator) {
    runnable.setValues(element, decoration, decorator);
    SafeRunner.run(runnable);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addDefaultAbstractMethods()V1
public void addDefaultAbstractMethods() {
    MethodBinding[] defaultAbstractMethods = this.referenceBinding.getDefaultAbstractMethods();
    for (int i = 0, max = defaultAbstractMethods.length; i < max; i++) {
        MethodBinding methodBinding = defaultAbstractMethods[i];
        generateMethodInfoHeader(methodBinding);
        int methodAttributeOffset = this.contentsOffset;
        int attributeNumber = generateMethodInfoAttributes(methodBinding);
        completeMethodInfo(methodBinding, methodAttributeOffset, attributeNumber);
    }
}

---------------Library-------------------
method: org.eclipse.ltk.internal.core.refactoring.resource.ResourceModifications.addCopy(org.eclipse.core.resources.IResource;org.eclipse.ltk.core.refactoring.participants.CopyArguments;)V3
public void addCopy(IResource copy, CopyArguments arguments) {
    if (fCopy == null) {
        fCopy = new  ArrayList(2);
        fCopyArguments = new  ArrayList(2);
    }
    fCopy.add(copy);
    fCopyArguments.add(arguments);
    addCopyDelta(copy, arguments);
}
method: org.eclipse.ltk.internal.core.refactoring.resource.ResourceModifications.addCopyDelta(org.eclipse.core.resources.IResource;org.eclipse.ltk.core.refactoring.participants.CopyArguments;)V3
public void addCopyDelta(IResource copy, CopyArguments arguments) {
    if (fIgnoreCount == 0) {
        IPath destination = ((IResource) arguments.getDestination()).getFullPath().append(copy.getName());
        internalAdd(new  CopyDescription(copy, destination));
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.participants.ResourceModifications.addMove(org.eclipse.core.resources.IResource;org.eclipse.ltk.core.refactoring.participants.MoveArguments;)V3
public void addMove(IResource move, MoveArguments arguments) {
    if (fMove == null) {
        fMove = new  ArrayList<IResource>(2);
        fMoveArguments = new  ArrayList<MoveArguments>(2);
    }
    fMove.add(move);
    fMoveArguments.add(arguments);
    if (fIgnoreCount == 0) {
        IPath destination = ((IResource) arguments.getDestination()).getFullPath().append(move.getName());
        internalAdd(new  MoveDescription(move, destination));
    }
}

---------------Library-------------------
method: org.eclipse.swt.custom.TableTree.computeSize(IIZ)org.eclipse.swt.graphics.Point;4
@Override
public Point computeSize(int wHint, int hHint, boolean changed) {
    checkWidget();
    return table.computeSize(wHint, hHint, changed);
}
method: org.eclipse.swt.widgets.Table.computeSize(IIZ)org.eclipse.swt.graphics.Point;4
@Override
public Point computeSize(int wHint, int hHint, boolean changed) {
    checkWidget();
    if (wHint != SWT.DEFAULT && wHint < 0)
        wHint = 0;
    if (hHint != SWT.DEFAULT && hHint < 0)
        hHint = 0;
    Point size = computeNativeSize(handle, wHint, hHint, changed);
    if (size.x == 0 && wHint == SWT.DEFAULT)
        size.x = DEFAULT_WIDTH;
    if (OS.GTK3 && size.y == 0 && hHint == SWT.DEFAULT) {
        size.y = getItemCount() * getItemHeight();
    }
    if (size.y == 0 && hHint == SWT.DEFAULT)
        size.y = DEFAULT_HEIGHT;
    Rectangle trim = computeTrim(0, 0, size.x, size.y);
    size.x = trim.width;
    size.y = trim.height;
    return size;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.List.computeSize(IIZ)org.eclipse.swt.graphics.Point;4
@Override
public Point computeSize(int wHint, int hHint, boolean changed) {
    checkWidget();
    if (wHint != SWT.DEFAULT && wHint < 0)
        wHint = 0;
    if (hHint != SWT.DEFAULT && hHint < 0)
        hHint = 0;
    OS.gtk_widget_realize(handle);
    Point size = computeNativeSize(handle, wHint, hHint, changed);
    if (size.x == 0 && wHint == SWT.DEFAULT)
        size.x = DEFAULT_WIDTH;
    if (OS.GTK3 && size.y == 0 && hHint == SWT.DEFAULT) {
        size.y = getItemCount() * getItemHeight();
    }
    if (size.y == 0 && hHint == SWT.DEFAULT)
        size.y = DEFAULT_HEIGHT;
    Rectangle trim = computeTrim(0, 0, size.x, size.y);
    size.x = trim.width;
    size.y = trim.height;
    return size;
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.ui.internal.ApiUIPlugin.getDialogSettingsSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
public IDialogSettings getDialogSettingsSection(String name) {
    IDialogSettings dialogSettings = getDialogSettings();
    IDialogSettings section = dialogSettings.getSection(name);
    if (section == null) {
        section = dialogSettings.addNewSection(name);
    }
    return section;
}
method: org.eclipse.jface.dialogs.DialogSettings.addNewSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
@Override
public IDialogSettings addNewSection(String sectionName) {
    DialogSettings section = new  DialogSettings(sectionName);
    addSection(section);
    return section;
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.AddUnimplementedConstructorsAction$AddUnimplementedConstructorsValidator.validate(Ajava.lang.Object;)org.eclipse.core.runtime.IStatus;2
public IStatus validate(Object[] selection) {
    int count = countSelectedMethods(selection);
    if (count == 0)
        return new  StatusInfo(IStatus.ERROR, "");
    String message = Messages.format(ActionMessages.AddUnimplementedConstructorsAction_methods_selected, new Object[] { String.valueOf(count), String.valueOf(fEntries) });
    return new  StatusInfo(IStatus.INFO, message);
}
method: org.eclipse.jdt.ui.actions.AddUnimplementedConstructorsAction$AddUnimplementedConstructorsValidator.countSelectedMethods(Ajava.lang.Object;)I2
private int countSelectedMethods(Object[] selection) {
    int count = 0;
    for (int i = 0; i < selection.length; i++) {
        if (selection[i] instanceof IMethodBinding)
            count++;
    }
    return count;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.dialogs.OverrideMethodDialog$OverrideMethodValidator.validate(Ajava.lang.Object;)org.eclipse.core.runtime.IStatus;2
public IStatus validate(Object[] selection) {
    int count = 0;
    for (int index = 0; index < selection.length; index++) {
        if (selection[index] instanceof IMethodBinding)
            count++;
    }
    if (count == 0)
        return new  StatusInfo(IStatus.ERROR, "");
    return new  StatusInfo(IStatus.INFO, Messages.format(JavaUIMessages.OverrideMethodDialog_selectioninfo_more, new String[] { String.valueOf(count), String.valueOf(fNumMethods) }));
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSDefinitionPage.getSelection()org.eclipse.jface.viewers.ISelection;1
public ISelection getSelection() {
    return fBlock.getSelection();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSBlock.getSelection()org.eclipse.jface.viewers.ISelection;1
public ISelection getSelection() {
    if (fMasterSection != null) {
        return fMasterSection.getSelection();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.equinox.p2.ui.ProvisioningUI.getLicenseManager()org.eclipse.equinox.p2.ui.LicenseManager;1
public LicenseManager getLicenseManager() {
    return (LicenseManager) ServiceHelper.getService(ProvUIActivator.getContext(), LicenseManager.class.getName());
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
method: org.eclipse.ui.internal.views.markers.TasksView.getUndoContext()org.eclipse.core.commands.operations.IUndoContext;1
protected IUndoContext getUndoContext() {
    return WorkspaceUndoUtil.getTasksUndoContext();
}
method: org.eclipse.ui.ide.undo.WorkspaceUndoUtil.getTasksUndoContext()org.eclipse.core.commands.operations.IUndoContext;0
public static IUndoContext getTasksUndoContext() {
    if (tasksUndoContext == null) {
        tasksUndoContext = new  ObjectUndoContext(new  Object(), "Tasks Context");
        tasksUndoContext.addMatch(getWorkspaceUndoContext());
    }
    return tasksUndoContext;
}
---------------Client-------------------
method: org.eclipse.debug.ui.DebugUITools.getBreakpointsUndoContext()org.eclipse.core.commands.operations.IUndoContext;0
public static synchronized IUndoContext getBreakpointsUndoContext() {
    if (fgBreakpointsUndoContext == null) {
        fgBreakpointsUndoContext = new  ObjectUndoContext(new  Object(), "Breakpoints Context");
        fgBreakpointsUndoContext.addMatch(WorkspaceUndoUtil.getWorkspaceUndoContext());
    }
    return fgBreakpointsUndoContext;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractMethodRefactoring$UsedNamesCollector.visit(org.eclipse.jdt.core.dom.EnumDeclaration;)Z2
@Override
public boolean visit(EnumDeclaration node) {
    return visitType(node);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractMethodRefactoring$UsedNamesCollector.visitType(org.eclipse.jdt.core.dom.AbstractTypeDeclaration;)Z2
private boolean visitType(AbstractTypeDeclaration node) {
    result.add(node.getName().getIdentifier());
    return false;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.SimpleLicenseManager.accept(org.eclipse.equinox.p2.metadata.ILicense;)Z2
public boolean accept(ILicense license) {
    accepted.add(license.getUUID());
    updatePreferences();
    return true;
}

---------------Library-------------------
method: org.eclipse.ui.internal.WorkingSetManager.restoreWorkingSetState(org.eclipse.ui.IMemento;)V2
@Override
protected void restoreWorkingSetState(IMemento memento) {
    super.restoreWorkingSetState(memento);
    saveState();
}
method: org.eclipse.ui.internal.WorkingSetManager.saveState()V1
private void saveState() {
    if (restoreInProgress) {
        savePending = true;
        return;
    }
    File stateFile = getWorkingSetStateFile();
    if (stateFile == null) {
        return;
    }
    try {
        saveState(stateFile);
    } catch (IOException e) {
        stateFile.delete();
        handleInternalError(e, WorkbenchMessages.ProblemSavingWorkingSetState_title, WorkbenchMessages.ProblemSavingWorkingSetState_message);
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.AbstractSynchronizePage.init(org.eclipse.team.ui.synchronize.ISynchronizePageSite;)V2
public void init(ISynchronizePageSite site) {
    this.site = site;
    IDialogSettings settings = getSettings();
    if (settings != null) {
        try {
            int mode = settings.getInt(ISynchronizePageConfiguration.P_MODE);
            if (mode != 0) {
                configuration.setMode(mode);
            }
        } catch (NumberFormatException e) {
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.ui.StandardJavaElementContentProvider.getJavaProjects(org.eclipse.jdt.core.IJavaModel;)Ajava.lang.Object;2
protected Object[] getJavaProjects(IJavaModel jm) throws JavaModelException {
    return jm.getJavaProjects();
}
method: org.eclipse.jdt.internal.core.JavaModel.getJavaProjects()Aorg.eclipse.jdt.core.IJavaProject;1
public IJavaProject[] getJavaProjects() throws JavaModelException {
    ArrayList list = getChildrenOfType(JAVA_PROJECT);
    IJavaProject[] array = new IJavaProject[list.size()];
    list.toArray(array);
    return array;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.CompilationUnit.getPackageDeclarations()Aorg.eclipse.jdt.core.IPackageDeclaration;1
public IPackageDeclaration[] getPackageDeclarations() throws JavaModelException {
    ArrayList list = getChildrenOfType(PACKAGE_DECLARATION);
    IPackageDeclaration[] array = new IPackageDeclaration[list.size()];
    list.toArray(array);
    return array;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider.getImageLabel(org.eclipse.jface.resource.ImageDescriptor;)org.eclipse.swt.graphics.Image;2
private Image getImageLabel(ImageDescriptor descriptor) {
    if (descriptor == null)
        return null;
    return getRegistry().get(descriptor);
}
method: org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider.getRegistry()org.eclipse.jdt.internal.ui.viewsupport.ImageDescriptorRegistry;1
private ImageDescriptorRegistry getRegistry() {
    if (fRegistry == null) {
        fRegistry = JavaPlugin.getImageDescriptorRegistry();
    }
    return fRegistry;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.search.JavaSearchPage.getDialogSettings()org.eclipse.jface.dialogs.IDialogSettings;1
private IDialogSettings getDialogSettings() {
    if (fDialogSettings == null) {
        fDialogSettings = JavaPlugin.getDefault().getDialogSettingsSection(PAGE_NAME);
    }
    return fDialogSettings;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyTypeArguments()V1
protected void consumeEmptyTypeArguments() {
    pushOnGenericsLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnGenericsLengthStack(I)V2
protected void pushOnGenericsLengthStack(int pos) {
    int stackLength = this.genericsLengthStack.length;
    if (++this.genericsLengthPtr >= stackLength) {
        System.arraycopy(this.genericsLengthStack, 0, this.genericsLengthStack = new int[stackLength + GenericsStackIncrement], 0, stackLength);
    }
    this.genericsLengthStack[this.genericsLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.ClasspathContainerSelectionPage$2.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
public void doubleClick(DoubleClickEvent event) {
    doDoubleClick();
}
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.ClasspathContainerSelectionPage.doDoubleClick()V1
protected void doDoubleClick() {
    if (canFlipToNextPage()) {
        getContainer().showPage(getNextPage());
    }
}
---------------Client-------------------
method: org.eclipse.ui.forms.FormColors.initializeSectionToolBarColors()V1
public void initializeSectionToolBarColors() {
    if (colorRegistry.containsKey(IFormColors.TB_BG))
        return;
    createTitleBarGradientColors();
    createTitleBarOutlineColors();
    createTwistieColors();
}

---------------Library-------------------
method: org.eclipse.ui.internal.layout.CellData.setHint(ILorg.eclipse.swt.graphics.Point;)org.eclipse.ui.internal.layout.CellData;3
public CellData setHint(int hintType, Point hint) {
    return setHint(hintType, hint.x, hint.y);
}
method: org.eclipse.ui.internal.layout.CellData.setHint(III)org.eclipse.ui.internal.layout.CellData;4
public CellData setHint(int hintType, int horizontal, int vertical) {
    this.hintType = hintType;
    this.heightHint = vertical;
    this.widthHint = horizontal;
    return this;
}
---------------Client-------------------
method: org.objectweb.asm.tree.InsnList$InsnListIterator.previous()java.lang.Object;1
public Object previous() {
    AbstractInsnNode result = prev;
    next = result;
    prev = result.prev;
    remove = result;
    return result;
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.JobListeners.sleeping(org.eclipse.core.runtime.jobs.Job;)V2
public void sleeping(Job job) {
    doNotify(sleeping, newEvent(job));
}
method: org.eclipse.core.internal.jobs.JobListeners.newEvent(org.eclipse.core.runtime.jobs.Job;)org.eclipse.core.internal.jobs.JobChangeEvent;1
static JobChangeEvent newEvent(Job job) {
    JobChangeEvent instance = new  JobChangeEvent();
    instance.job = job;
    return instance;
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory.init(org.eclipse.e4.core.contexts.IEclipseContext;)V2
@PostConstruct
public void init(IEclipseContext context) {
    this.context = context;
    this.context.set(SHARED_ELEMENTS_STORE, new  HashMap<MUIElement, Set<MPlaceholder>>());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.template.java.CodeTemplates.getCodeTemplate(java.lang.String;)org.eclipse.jface.text.templates.Template;1
public static Template getCodeTemplate(String name) {
    return getInstance().getFirstTemplate(name);
}
method: org.eclipse.jdt.internal.corext.template.java.CodeTemplates.getInstance()org.eclipse.jdt.internal.corext.template.java.CodeTemplates;0
public static CodeTemplates getInstance() {
    if (fgTemplates == null)
        fgTemplates = new  CodeTemplates();
    return fgTemplates;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.filesystem.LogEntryCache.findRevison(Aorg.eclipse.team.internal.ccvs.core.ILogEntry;java.lang.String;)org.eclipse.team.internal.ccvs.core.ICVSRemoteFile;3
ICVSRemoteFile findRevison(ILogEntry[] allLogs, String predecessorRevision) throws TeamException {
    for (int i = 0; i < allLogs.length; i++) {
        ILogEntry entry = allLogs[i];
        ICVSRemoteFile file = entry.getRemoteFile();
        if (file.getRevision().equals(predecessorRevision)) {
            return file;
        }
    }
    return null;
}
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.getRevision()java.lang.String;1
public String getRevision() {
    try {
        return ResourceSyncInfo.getRevision(syncBytes);
    } catch (CVSException e) {
        CVSProviderPlugin.log(e);
        return ResourceSyncInfo.ADDED_REVISION;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.ExtractClassRefactoring.getField(java.lang.String;)org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field;2
private Field getField(String name) {
    Field[] fields = fDescriptor.getFields();
    for (int i = 0; i < fields.length; i++) {
        Field field = fields[i];
        if (field.getFieldName().equals(name))
            return field;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.MarkerResolutionSelectionDialog$3.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
public void doubleClick(DoubleClickEvent event) {
    okPressed();
}
method: org.eclipse.ui.dialogs.MarkerResolutionSelectionDialog.okPressed()V1
protected void okPressed() {
    IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
    setResult(selection.toList());
    super.okPressed();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.site.SiteEditor$1.run()V1
public void run() {
    handleBuild(((ISiteModel) getAggregateModel()).getSite().getFeatures());
}

---------------Library-------------------
method: org.eclipse.ecf.core.ContainerFactory.createContainer(java.lang.String;java.lang.String;)org.eclipse.ecf.core.IContainer;3
public IContainer createContainer(String containerTypeDescriptionName, String containerId) throws ContainerCreateException {
    return createContainer(getDescriptionByNameWithException(containerTypeDescriptionName), containerId);
}
method: org.eclipse.ecf.core.ContainerFactory.getDescriptionByNameWithException(java.lang.String;)org.eclipse.ecf.core.ContainerTypeDescription;2
private ContainerTypeDescription getDescriptionByNameWithException(String containerTypeDescriptionName) throws ContainerCreateException {
    ContainerTypeDescription typeDescription = getDescriptionByName(containerTypeDescriptionName);
    if (typeDescription == null)
        throw new  ContainerCreateException("Container type description with name=" + containerTypeDescriptionName + " not found.  This may indicate that the desired provider is not available or not startable within runtime.");
    return typeDescription;
}
---------------Client-------------------
method: org.eclipse.ecf.core.identity.IDFactory.createID(java.lang.String;Ajava.lang.Object;)org.eclipse.ecf.core.identity.ID;3
public ID createID(String namespaceName, Object[] args) throws IDCreateException {
    Namespace n = getNamespaceByName(namespaceName);
    if (n == null)
        throw new  IDCreateException("Namespace " + namespaceName + " not found");
    return createID(n, args);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.target.TargetDefinitionContentPage$16.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    StringVariableSelectionDialog dialog = new  StringVariableSelectionDialog(getShell());
    dialog.open();
    String variable = dialog.getVariableExpression();
    if (variable != null) {
        textControl.insert(variable);
    }
}
method: org.eclipse.jface.wizard.WizardPage.getShell()org.eclipse.swt.widgets.Shell;1
@Override
public Shell getShell() {
    IWizardContainer container = getContainer();
    if (container == null) {
        return null;
    }
    return container.getShell();
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.launchConfigurations.ExternalToolsBuilderTab$10.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    StringVariableSelectionDialog dialog = new  StringVariableSelectionDialog(getShell());
    dialog.open();
    String variable = dialog.getVariableExpression();
    if (variable != null) {
        fFileText.insert(variable);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaModelOperation.copyResources(Aorg.eclipse.core.resources.IResource;org.eclipse.core.runtime.IPath;)V3
protected void copyResources(IResource[] resources, IPath container) throws JavaModelException {
    IProgressMonitor subProgressMonitor = getSubProgressMonitor(resources.length);
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    try {
        for (int i = 0, length = resources.length; i < length; i++) {
            IResource resource = resources[i];
            IPath destination = container.append(resource.getName());
            if (root.findMember(destination) == null) {
                resource.copy(destination, false, subProgressMonitor);
            }
        }
        setAttribute(HAS_MODIFIED_RESOURCE_ATTR, TRUE);
    } catch (CoreException e) {
        throw new  JavaModelException(e);
    }
}
method: org.eclipse.jdt.internal.core.JavaModelOperation.getSubProgressMonitor(I)org.eclipse.core.runtime.IProgressMonitor;2
protected IProgressMonitor getSubProgressMonitor(int workAmount) {
    IProgressMonitor sub = null;
    if (this.progressMonitor != null) {
        sub = new  SubProgressMonitor(this.progressMonitor, workAmount, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
    }
    return sub;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaModelOperation.moveResources(Aorg.eclipse.core.resources.IResource;org.eclipse.core.runtime.IPath;)V3
protected void moveResources(IResource[] resources, IPath container) throws JavaModelException {
    IProgressMonitor subProgressMonitor = null;
    if (this.progressMonitor != null) {
        subProgressMonitor = new  SubProgressMonitor(this.progressMonitor, resources.length, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
    }
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    try {
        for (int i = 0, length = resources.length; i < length; i++) {
            IResource resource = resources[i];
            IPath destination = container.append(resource.getName());
            if (root.findMember(destination) == null) {
                resource.move(destination, false, subProgressMonitor);
            }
        }
        setAttribute(HAS_MODIFIED_RESOURCE_ATTR, TRUE);
    } catch (CoreException e) {
        throw new  JavaModelException(e);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.LazyJavaCompletionProposal.computeSortString()java.lang.String;1
protected String computeSortString() {
    return getDisplayString();
}
method: org.eclipse.jdt.internal.ui.text.java.LazyJavaCompletionProposal.getDisplayString()java.lang.String;1
@Override
public String getDisplayString() {
    if (!fDisplayStringComputed)
        setStyledDisplayString(computeDisplayString());
    return super.getDisplayString();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.JavaStringAutoIndentStrategy.getExtraIndentAfterNewLine()java.lang.String;1
private String getExtraIndentAfterNewLine() {
    int formatterContinuationIndentationSize = getContinuationIndentationSize();
    int binaryAlignmentValue = getBinaryOperatorAlignmentStyle();
    int indentSize = formatterContinuationIndentationSize;
    if (binaryAlignmentValue == DefaultCodeFormatterConstants.INDENT_BY_ONE) {
        indentSize = 1;
    } else if (binaryAlignmentValue == DefaultCodeFormatterConstants.INDENT_ON_COLUMN) {
    }
    return CodeFormatterUtil.createIndentString(indentSize, fProject);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Container.findMember(org.eclipse.core.runtime.IPath;)org.eclipse.core.resources.IResource;2
public IResource findMember(IPath childPath) {
    return findMember(childPath, false);
}
method: org.eclipse.core.internal.resources.Container.findMember(org.eclipse.core.runtime.IPath;Z)org.eclipse.core.resources.IResource;3
public IResource findMember(IPath childPath, boolean phantom) {
    childPath = getFullPath().append(childPath);
    ResourceInfo info = workspace.getResourceInfo(childPath, phantom, false);
    return (info == null) ? null : workspace.newResource(childPath, info.getType());
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Container.findMember(java.lang.String;Z)org.eclipse.core.resources.IResource;3
public IResource findMember(String memberPath, boolean phantom) {
    IPath childPath = getFullPath().append(memberPath);
    ResourceInfo info = workspace.getResourceInfo(childPath, phantom, false);
    return info == null ? null : workspace.newResource(childPath, info.getType());
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseStyleDeclaration(java.io.Reader;)org.w3c.dom.css.CSSStyleDeclaration;2
@Override
public CSSStyleDeclaration parseStyleDeclaration(Reader reader) throws IOException {
    InputSource source = new  InputSource();
    source.setCharacterStream(reader);
    return parseStyleDeclaration(source);
}
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseStyleDeclaration(org.w3c.css.sac.InputSource;)org.w3c.dom.css.CSSStyleDeclaration;2
@Override
public CSSStyleDeclaration parseStyleDeclaration(InputSource source) throws IOException {
    checkInputSource(source);
    CSSParser parser = makeCSSParser();
    CSSStyleDeclaration styleDeclaration = parser.parseStyleDeclaration(source);
    return styleDeclaration;
}
---------------Client-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyProviderUtil.createProxy(java.lang.String;java.lang.String;I)org.eclipse.core.net.proxy.IProxyData;3
private static IProxyData createProxy(String scheme, String host, int port) {
    String type = resolveProxyType(scheme);
    ProxyData proxy = new  ProxyData(type);
    proxy.setHost(host);
    proxy.setPort(port);
    proxy.setSource("WINDOWS_IE");
    return proxy;
}

---------------Library-------------------
method: org.eclipse.ui.internal.handlers.CloseAllPerspectivesHandler.execute(org.eclipse.core.commands.ExecutionEvent;)java.lang.Object;2
@Override
public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
    if (window != null) {
        IWorkbenchPage page = window.getActivePage();
        if (page != null) {
            page.closeAllPerspectives(true, true);
        }
    }
    return null;
}
method: org.eclipse.ui.internal.WorkbenchPage.closeAllPerspectives(ZZ)V3
@Override
public void closeAllPerspectives(boolean saveEditors, boolean closePage) {
    boolean okToProceed = closeAllEditors(true);
    if (okToProceed) {
        List<MPerspective> kids = new  ArrayList<MPerspective>(_perspectiveStack.getChildren());
        MPerspective curPersp = _perspectiveStack.getSelectedElement();
        for (MPerspective persp : kids) {
            if (persp != curPersp) {
                closePerspective(getPerspectiveDesc(persp.getElementId()), persp.getElementId(), false);
            }
        }
        if (curPersp != null) {
            closePerspective(getPerspectiveDesc(curPersp.getElementId()), curPersp.getElementId(), false);
        }
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.checkInputSource(org.w3c.css.sac.InputSource;)V2
private void checkInputSource(InputSource source) throws IOException {
    Reader reader = source.getCharacterStream();
    InputStream stream = source.getByteStream();
    if (reader == null && stream == null) {
        throw new  IOException("CharacterStream or ByteStream cannot be null for the InputSource.");
    }
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.ComputedSet$1.getAdditions()java.util.Set;1
public Set getAdditions() {
    return getDelegate().getAdditions();
}
method: org.eclipse.core.databinding.observable.set.ComputedSet$1.getDelegate()org.eclipse.core.databinding.observable.set.SetDiff;1
private SetDiff getDelegate() {
    if (delegate == null)
        delegate = Diffs.computeSetDiff(oldSet, getSet());
    return delegate;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.ComputedList$1.getDifferences()Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;1
public ListDiffEntry[] getDifferences() {
    if (differences == null)
        differences = Diffs.computeListDiff(oldList, getList()).getDifferences();
    return differences;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.AbstractPluginModelBase.dispose()V1
public void dispose() {
    fBundleDescription = null;
    super.dispose();
}
method: org.eclipse.pde.internal.core.AbstractNLModel.dispose()V1
public void dispose() {
    if (fNLHelper != null) {
        fNLHelper.dispose();
        fNLHelper = null;
    }
    super.dispose();
}
---------------Client-------------------
method: org.eclipse.jface.internal.text.html.BrowserInformationControl.handleDispose()V1
protected void handleDispose() {
    if (fTextLayout != null) {
        fTextLayout.dispose();
        fTextLayout = null;
    }
    fBrowser = null;
    super.handleDispose();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElementAttribute$1.getParentClasspassEntry()org.eclipse.jdt.core.IClasspathEntry;1
@Override
public IClasspathEntry getParentClasspassEntry() {
    return getParent().getClasspathEntry();
}
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement.getClasspathEntry()org.eclipse.jdt.core.IClasspathEntry;1
public IClasspathEntry getClasspathEntry() {
    if (fCachedEntry == null) {
        fCachedEntry = newClasspathEntry();
    }
    return fCachedEntry;
}
---------------Client-------------------
method: org.eclipse.team.ui.synchronize.ParticipantPageCompareEditorInput.getTitleImage()org.eclipse.swt.graphics.Image;1
public Image getTitleImage() {
    if (titleImage == null) {
        titleImage = participant.getImageDescriptor().createImage();
    }
    return titleImage;
}

---------------Library-------------------
method: org.eclipse.search.internal.ui.SearchPlugin.getDialogSettingsSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
public IDialogSettings getDialogSettingsSection(String name) {
    IDialogSettings dialogSettings = getDialogSettings();
    IDialogSettings section = dialogSettings.getSection(name);
    if (section == null) {
        section = dialogSettings.addNewSection(name);
    }
    return section;
}
method: org.eclipse.jface.dialogs.DialogSettings.addNewSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
@Override
public IDialogSettings addNewSection(String sectionName) {
    DialogSettings section = new  DialogSettings(sectionName);
    addSection(section);
    return section;
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.SingleMemberAnnotation;)V2
@Override
public void endVisit(SingleMemberAnnotation node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getValue());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ChangeTypeWizard$ChangeTypeInputPage.dispose()V1
@Override
public void dispose() {
    fTreeViewer = null;
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
method: org.eclipse.debug.ui.actions.RulerToggleBreakpointActionDelegate.dispose()V1
@Override
public void dispose() {
    if (fDelegate != null) {
        fDelegate.dispose();
    }
    fDelegate = null;
    fEditor = null;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.quickdiff.ReferenceProviderDescriptor.createProvider()org.eclipse.ui.texteditor.quickdiff.IQuickDiffReferenceProvider;1
public IQuickDiffReferenceProvider createProvider() {
    try {
        IQuickDiffReferenceProvider impl = (IQuickDiffReferenceProvider) fConfiguration.createExecutableExtension(CLASS_ATTRIBUTE);
        impl.setId(getId());
        return impl;
    } catch (CoreException e) {
        return null;
    }
}
method: org.eclipse.ui.texteditor.quickdiff.ReferenceProviderDescriptor.getId()java.lang.String;1
public String getId() {
    if (fId == null) {
        fId = fConfiguration.getAttribute(ID_ATTRIBUTE);
        Assert.isNotNull(fId);
    }
    return fId;
}
---------------Client-------------------
method: org.eclipse.search.internal.ui.SearchPageDescriptor.createObject(org.eclipse.search.ui.ISearchPageContainer;)org.eclipse.search.ui.ISearchPage;2
public ISearchPage createObject(ISearchPageContainer container) throws CoreException {
    if (fCreatedPage == null) {
        fCreatedPage = (ISearchPage) fElement.createExecutableExtension(CLASS_ATTRIBUTE);
        fCreatedPage.setTitle(getLabel());
        fCreatedPage.setContainer(container);
    }
    return fCreatedPage;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.ASTRewriteAnalyzer.getEditGroup(org.eclipse.jdt.internal.core.dom.rewrite.RewriteEvent;)org.eclipse.text.edits.TextEditGroup;2
final TextEditGroup getEditGroup(RewriteEvent change) {
    return this.eventStore.getEventEditGroup(change);
}
method: org.eclipse.jdt.internal.core.dom.rewrite.RewriteEventStore.getEventEditGroup(org.eclipse.jdt.internal.core.dom.rewrite.RewriteEvent;)org.eclipse.text.edits.TextEditGroup;2
public TextEditGroup getEventEditGroup(RewriteEvent event) {
    if (this.editGroups == null) {
        return null;
    }
    return (TextEditGroup) this.editGroups.get(event);
}
---------------Client-------------------
method: org.eclipse.jface.resource.AbstractResourceManager.find(org.eclipse.jface.resource.DeviceResourceDescriptor;)java.lang.Object;2
@Override
public Object find(DeviceResourceDescriptor descriptor) {
    if (map == null) {
        return null;
    }
    RefCount refCount = map.get(descriptor);
    if (refCount == null)
        return null;
    return refCount.resource;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.launcher.PluginStatusDialog.getDialogBoundsSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getDialogBoundsSettings() {
    return getDialogSettings();
}
method: org.eclipse.pde.internal.ui.launcher.PluginStatusDialog.getDialogSettings()org.eclipse.jface.dialogs.IDialogSettings;1
private IDialogSettings getDialogSettings() {
    IDialogSettings settings = PDEPlugin.getDefault().getDialogSettings();
    IDialogSettings section = settings.getSection(getDialogSectionName());
    if (section == null)
        section = settings.addNewSection(getDialogSectionName());
    return section;
}
---------------Client-------------------
method: org.eclipse.ui.internal.quickaccess.QuickAccessContents.getDialogSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getDialogSettings() {
    final IDialogSettings workbenchDialogSettings = WorkbenchPlugin.getDefault().getDialogSettings();
    IDialogSettings result = workbenchDialogSettings.getSection(getId());
    if (result == null) {
        result = workbenchDialogSettings.addNewSection(getId());
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Workspace.getNatureDescriptors()Aorg.eclipse.core.resources.IProjectNatureDescriptor;1
public IProjectNatureDescriptor[] getNatureDescriptors() {
    return natureManager.getNatureDescriptors();
}
method: org.eclipse.core.internal.resources.NatureManager.getNatureDescriptors()Aorg.eclipse.core.resources.IProjectNatureDescriptor;1
public synchronized IProjectNatureDescriptor[] getNatureDescriptors() {
    lazyInitialize();
    Collection<IProjectNatureDescriptor> values = descriptors.values();
    return values.toArray(new IProjectNatureDescriptor[values.size()]);
}
---------------Client-------------------
method: org.eclipse.core.internal.variables.StringVariableManager.getDynamicVariables()Aorg.eclipse.core.variables.IDynamicVariable;1
@Override
public synchronized IDynamicVariable[] getDynamicVariables() {
    initialize();
    return fDynamicVariables.values().toArray(new IDynamicVariable[fDynamicVariables.size()]);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceTypeElementInfo.getInterfaceNames()AAC1
public char[][] getInterfaceNames() {
    if (isAnonymous()) {
        return null;
    }
    return this.superInterfaceNames;
}
method: org.eclipse.jdt.internal.core.SourceTypeElementInfo.isAnonymous()Z1
@Override
public boolean isAnonymous() {
    try {
        return this.handle.isAnonymous();
    } catch (JavaModelException e) {
        return false;
    }
}
---------------Client-------------------
method: org.eclipse.equinox.p2.publisher.AdviceFileParser.getProperties()java.util.Map;1
public Map<String, String> getProperties() {
    if (adviceProperties.isEmpty())
        return null;
    return adviceProperties;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.SharingWizardSyncPage.diffsChanged(org.eclipse.team.core.diff.IDiffChangeEvent;org.eclipse.core.runtime.IProgressMonitor;)V3
public void diffsChanged(IDiffChangeEvent event, IProgressMonitor monitor) {
    showErrors(event.getErrors());
    updatePage();
}
method: org.eclipse.team.internal.ccvs.ui.wizards.SharingWizardSyncPage.updatePage()V1
private void updatePage() {
    Display.getDefault().syncExec(new  Runnable() {

        public void run() {
            if (pageBook.isDisposed())
                return;
            if (getDiffTree().isEmpty()) {
                pageBook.showPage(noChangesPage);
            } else {
                pageBook.showPage(syncPage);
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.console.AntConsoleColorProvider.propertyChange(org.eclipse.jface.util.PropertyChangeEvent;)V2
@Override
public void propertyChange(PropertyChangeEvent event) {
    final String streamId = getStreamId(event.getProperty());
    if (streamId != null) {
        AntUIPlugin.getStandardDisplay().asyncExec(new  Runnable() {

            @Override
            public void run() {
                IOConsoleOutputStream stream = getConsole().getStream(streamId);
                if (stream != null) {
                    stream.setColor(getColor(streamId));
                }
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.jface.viewers.deferred.DeferredContentProvider.dispose()V1
@Override
public void dispose() {
    setProvider(null);
}
method: org.eclipse.jface.viewers.deferred.DeferredContentProvider.setProvider(org.eclipse.jface.viewers.deferred.BackgroundContentProvider;)V2
private void setProvider(BackgroundContentProvider newProvider) {
    if (provider != null) {
        provider.dispose();
    }
    provider = newProvider;
}
---------------Client-------------------
method: org.apache.lucene.index.StoredFieldsWriterPerThread.abort()V1
public void abort() {
    if (doc != null) {
        doc.abort();
        doc = null;
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.NewLibraryPluginProjectWizard.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions.getEclipseDefaultSettings()org.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions;0
public static DefaultCodeFormatterOptions getEclipseDefaultSettings() {
    DefaultCodeFormatterOptions options = new  DefaultCodeFormatterOptions();
    options.setEclipseDefaultSettings();
    return options;
}
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions.setEclipseDefaultSettings()V1
public void setEclipseDefaultSettings() {
    setJavaConventionsSettings();
    this.tab_char = TAB;
    this.tab_size = 4;
}
---------------Client-------------------
method: org.eclipse.core.internal.jobs.LockManager$LockState.suspend(org.eclipse.core.internal.jobs.OrderedLock;)org.eclipse.core.internal.jobs.LockManager$LockState;1
protected static LockState suspend(OrderedLock lock) {
    LockState state = new  LockState();
    state.lock = lock;
    state.depth = lock.forceRelease();
    return state;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.CSAbstractEditor.contributeToToolbar(org.eclipse.jface.action.IToolBarManager;)V2
public void contributeToToolbar(IToolBarManager manager) {
    if (WorkspaceModelManager.isPluginProject(getCommonProject()) && getAggregateModel().isEditable())
        manager.add(createUIControlConRegisterCS());
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.CSAbstractEditor.createUIControlConRegisterCS()org.eclipse.jface.action.ControlContribution;1
private ControlContribution createUIControlConRegisterCS() {
    return new  ControlContribution("Register") {

        protected Control createControl(Composite parent) {
            createUIImageHyperlinkRegisterCS(parent);
            createUIListenerImageHyperlinkRegisterCS();
            return fImageHyperlinkRegisterCS;
        }
    };
}
---------------Client-------------------
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpEditor.contributeToToolbar(org.eclipse.jface.action.IToolBarManager;)V2
public void contributeToToolbar(IToolBarManager manager) {
    if (WorkspaceModelManager.isPluginProject(getCommonProject()) && getAggregateModel().isEditable()) {
        manager.add(new  ControlContribution("Register") {

            protected Control createControl(Composite parent) {
                ImageHyperlink fImageHyperlinkRegisterTOC = new  ImageHyperlink(parent, SWT.NONE);
                fImageHyperlinkRegisterTOC.setText(CtxHelpMessages.CtxHelpEditor_text);
                fImageHyperlinkRegisterTOC.setUnderlined(true);
                fImageHyperlinkRegisterTOC.setForeground(getToolkit().getHyperlinkGroup().getForeground());
                fImageHyperlinkRegisterTOC.addHyperlinkListener(new  IHyperlinkListener() {

                    public void linkActivated(HyperlinkEvent e) {
                        handleRegisterCtxHelpFile();
                    }

                    public void linkEntered(HyperlinkEvent e) {
                        ((ImageHyperlink) e.getSource()).setForeground(getToolkit().getHyperlinkGroup().getActiveForeground());
                        getEditorSite().getActionBars().getStatusLineManager().setMessage(CtxHelpMessages.CtxHelpEditor_text);
                    }

                    public void linkExited(HyperlinkEvent e) {
                        ((ImageHyperlink) e.getSource()).setForeground(getToolkit().getHyperlinkGroup().getForeground());
                        getEditorSite().getActionBars().getStatusLineManager().setMessage(null);
                    }
                });
                return fImageHyperlinkRegisterTOC;
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.isCheckMissingExportPackageVersion()Z1
protected boolean isCheckMissingExportPackageVersion() {
    return CompilerFlags.getFlag(fProject, CompilerFlags.P_MISSING_VERSION_EXP_PKG) != CompilerFlags.IGNORE;
}
method: org.eclipse.pde.internal.core.builders.CompilerFlags.getFlag(org.eclipse.core.resources.IProject;java.lang.String;)I2
public static int getFlag(IProject project, String flagId) {
    try {
        return Integer.parseInt(getString(project, flagId));
    } catch (NumberFormatException nfe) {
        return 0;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.hierarchy.ChangeCollector.hasVisibilityChange(org.eclipse.jdt.core.IType;)Z2
private boolean hasVisibilityChange(IType type) throws JavaModelException {
    int existingFlags = this.hierarchy.getCachedFlags(type);
    int newFlags = type.getFlags();
    return existingFlags != newFlags;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.DelegatingFeatureMap.basicIndexOf(org.eclipse.emf.ecore.EStructuralFeature;java.lang.Object;)I3
public int basicIndexOf(EStructuralFeature feature, Object object) {
    return indexOf(feature, object, false);
}
method: org.eclipse.emf.ecore.util.DelegatingFeatureMap.indexOf(org.eclipse.emf.ecore.EStructuralFeature;java.lang.Object;Z)I4
protected int indexOf(EStructuralFeature feature, Object object, boolean resolve) {
    FeatureMapUtil.Validator validator = FeatureMapUtil.getValidator(owner.eClass(), feature);
    int result = 0;
    if (FeatureMapUtil.isFeatureMap(feature)) {
        for (int i = 0, size = delegateSize(); i < size; ++i) {
            Entry entry = delegateGet(i);
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.equals(object)) {
                    return result;
                }
                ++result;
            }
        }
    } else if (object != null) {
        int size = delegateSize();
        for (int i = 0; i < size; ++i) {
            Entry entry = delegateGet(i);
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (object.equals(entry.getValue())) {
                    return result;
                }
                ++result;
            }
        }
        if (resolve) {
            result = 0;
            for (int i = 0; i < size; ++i) {
                Entry entry = delegateGet(i);
                if (validator.isValid(entry.getEStructuralFeature())) {
                    if (object == resolveProxy((EObject) entry.getValue())) {
                        return result;
                    }
                    ++result;
                }
            }
        }
    } else {
        for (int i = 0, size = delegateSize(); i < size; ++i) {
            Entry entry = delegateGet(i);
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.getValue() == null) {
                    return result;
                }
                ++result;
            }
        }
    }
    return -1;
}
---------------Client-------------------
method: org.eclipse.emf.ecore.util.DelegatingFeatureMap.lastIndexOf(org.eclipse.emf.ecore.EStructuralFeature;java.lang.Object;Z)I4
protected int lastIndexOf(EStructuralFeature feature, Object object, boolean resolve) {
    FeatureMapUtil.Validator validator = FeatureMapUtil.getValidator(owner.eClass(), feature);
    int result = -1;
    int count = 0;
    if (FeatureMapUtil.isFeatureMap(feature)) {
        for (int i = 0, size = delegateSize(); i < size; ++i) {
            Entry entry = delegateGet(i);
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.equals(object)) {
                    result = count;
                }
                ++count;
            }
        }
    } else if (object != null) {
        int size = delegateSize();
        for (int i = 0; i < size; ++i) {
            Entry entry = delegateGet(i);
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (object.equals(entry.getValue())) {
                    result = count;
                }
                ++count;
            }
        }
        if (resolve) {
            result = -1;
            count = 0;
            for (int i = 0; i < size; ++i) {
                Entry entry = delegateGet(i);
                if (validator.isValid(entry.getEStructuralFeature())) {
                    if (object == resolveProxy((EObject) entry.getValue())) {
                        result = count;
                    }
                    ++count;
                }
            }
        }
    } else {
        for (int i = 0, size = delegateSize(); i < size; ++i) {
            Entry entry = delegateGet(i);
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.getValue() == null) {
                    result = count;
                }
                ++count;
            }
        }
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.core.internal.localstore.FileSystemResourceManager.hasSavedContent(org.eclipse.core.resources.IProject;)Z2
public boolean hasSavedContent(IProject project) {
    return getStore(project).fetchInfo().exists();
}
method: org.eclipse.core.internal.localstore.FileSystemResourceManager.getStore(org.eclipse.core.resources.IResource;)org.eclipse.core.filesystem.IFileStore;2
public IFileStore getStore(IResource target) {
    try {
        return getStoreRoot(target).createStore(target.getFullPath(), target);
    } catch (CoreException e) {
        return EFS.getNullFileSystem().getStore(target.getFullPath());
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.ImportReferencesCollector.visit(org.eclipse.jdt.core.dom.ExpressionMethodReference;)Z2
@Override
public boolean visit(ExpressionMethodReference node) {
    evalQualifyingExpression(node.getExpression(), node.getName());
    doVisitChildren(node.typeArguments());
    return false;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.views.actions.RunTargetAction.launch(org.eclipse.ant.internal.ui.model.AntElementNode;)V2
public void launch(AntElementNode node) {
    AntLaunchShortcut shortcut = new  AntLaunchShortcut();
    shortcut.setShowDialog(false);
    shortcut.launch(node, ILaunchManager.RUN_MODE);
}
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
method: org.eclipse.core.internal.plugins.PluginDescriptor.throwException(java.lang.String;java.lang.Throwable;)V3
private void throwException(String message, Throwable exception) throws CoreException {
    IStatus status = new  Status(IStatus.ERROR, Platform.PI_RUNTIME, Platform.PLUGIN_ERROR, message, exception);
    logError(status);
    throw new  CoreException(status);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.schema.SchemaSpecSection$2.textValueChanged(org.eclipse.pde.internal.ui.parts.FormEntry;)V2
public void textValueChanged(FormEntry text) {
    schema.setPointId(text.getValue());
}
method: org.eclipse.pde.internal.core.schema.Schema.setPointId(java.lang.String;)V2
public void setPointId(String newId) {
    String oldValue = fPointID;
    fPointID = newId;
    fireModelObjectChanged(this, P_POINT, oldValue, newId);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.schema.SchemaAttribute.setBasedOn(java.lang.String;)V2
public void setBasedOn(String newBasedOn) {
    String oldValue = basedOn;
    basedOn = newBasedOn;
    getSchema().fireModelObjectChanged(this, P_BASED_ON, oldValue, basedOn);
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareEditorSelectionProvider$InternalListener.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    doSelectionChanged(event);
}
method: org.eclipse.compare.internal.CompareEditorSelectionProvider.doSelectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
final void doSelectionChanged(SelectionChangedEvent event) {
    ISelectionProvider provider = event.getSelectionProvider();
    if (provider == fViewerInFocus) {
        fireSelectionChanged();
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event e) {
    Widget source = e.widget;
    if (source == destinationBrowseButton) {
        handleDestinationBrowseButtonPressed();
    }
    updatePageCompletion();
}

---------------Library-------------------
method: org.eclipse.jface.text.ConfigurableLineTracker.getLegalLineDelimiters()Ajava.lang.String;1
public String[] getLegalLineDelimiters() {
    return TextUtilities.copy(fDelimiters);
}
method: org.eclipse.jface.text.TextUtilities.copy(Ajava.lang.String;)Ajava.lang.String;1
public static String[] copy(String[] array) {
    if (array != null) {
        String[] copy = new String[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.getSelectedResources()Aorg.eclipse.core.resources.IResource;1
IResource[] getSelectedResources() {
    IResource[] selected = selectedResources;
    IResource[] resources = new IResource[selected.length];
    System.arraycopy(selected, 0, resources, 0, selected.length);
    return resources;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameInputWizardPage.saveBooleanSetting(java.lang.String;org.eclipse.swt.widgets.Button;)V3
protected void saveBooleanSetting(String key, Button checkBox) {
    if (checkBox != null)
        getRefactoringSettings().put(key, checkBox.getSelection());
}
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Text.addSegmentListener(org.eclipse.swt.events.SegmentListener;)V2
public void addSegmentListener(SegmentListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    addListener(SWT.Segments, new  TypedListener(listener));
    clearSegments(true);
    applySegments();
}

---------------Library-------------------
method: org.eclipse.help.internal.browser.BrowserManager.isAlwaysUseExternal()Z1
public boolean isAlwaysUseExternal() {
    if (!isEmbeddedBrowserPresent()) {
        return true;
    }
    return alwaysUseExternal;
}
method: org.eclipse.help.internal.browser.BrowserManager.isEmbeddedBrowserPresent()Z1
public boolean isEmbeddedBrowserPresent() {
    if (!initialized) {
        init();
    }
    return internalBrowserDesc != null;
}
---------------Client-------------------
method: org.eclipse.jface.text.link.LinkedModeModel.isChanging()Z1
private boolean isChanging() {
    return fIsChanging || fParentEnvironment != null && fParentEnvironment.isChanging();
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;3
public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third);
}
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;3
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    return anyOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;3
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(3);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    return allOf(matchers);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField$ListViewerAdapter.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
public void doubleClick(DoubleClickEvent event) {
    doDoubleClick(event);
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField.doDoubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
protected void doDoubleClick(DoubleClickEvent event) {
    if (fListAdapter != null) {
        fListAdapter.doubleClicked(this);
    }
}
---------------Client-------------------
method: org.eclipse.compare.structuremergeviewer.StructureRootNode.dispose()V1
public void dispose() {
    if (fAdapter != null) {
        fAdapter.disconnect(fInput);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.ParenthesizedExpression;)V2
@Override
public void endVisit(ParenthesizedExpression node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getExpression());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.provisional.AsynchronousContentAdapter.getIsContainerRule(java.lang.Object;org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;)org.eclipse.core.runtime.jobs.ISchedulingRule;3
protected ISchedulingRule getIsContainerRule(Object parent, IPresentationContext context) {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(context);
}
method: org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory.getDefault()org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory;0
public static AsynchronousSchedulingRuleFactory getDefault() {
    if (fgFactory == null) {
        fgFactory = new  AsynchronousSchedulingRuleFactory();
    }
    return fgFactory;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ecf.internal.core.identity.Activator.getBundle()org.osgi.framework.Bundle;1
Bundle getBundle() {
    if (context == null)
        return null;
    return context.getBundle();
}
method: org.eclipse.osgi.internal.framework.BundleContextImpl.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    checkValid();
    return getBundleImpl();
}
---------------Client-------------------
method: org.eclipse.pde.core.target.TargetFeature.getId()java.lang.String;1
public String getId() {
    if (featureModel == null)
        return null;
    return featureModel.getFeature().getId();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.util.SWTUtil.setDefaultVisibleItemCount(org.eclipse.swt.widgets.Combo;)V1
public static void setDefaultVisibleItemCount(Combo combo) {
    combo.setVisibleItemCount(COMBO_VISIBLE_ITEM_COUNT);
}
method: org.eclipse.swt.widgets.Combo.setVisibleItemCount(I)V2
public void setVisibleItemCount(int count) {
    checkWidget();
    if (count < 0)
        return;
    visibleCount = count;
}
---------------Client-------------------
method: org.eclipse.swt.custom.PopupList.setMinimumWidth(I)V2
public void setMinimumWidth(int width) {
    if (width < 0)
        SWT.error(SWT.ERROR_INVALID_ARGUMENT);
    minimumWidth = width;
}

---------------Library-------------------
method: org.eclipse.jface.viewers.ListViewer.listDeselectAll()V1
@Override
protected void listDeselectAll() {
    list.deselectAll();
}
method: org.eclipse.swt.widgets.List.deselectAll()V1
public void deselectAll() {
    checkWidget();
    long selection = OS.gtk_tree_view_get_selection(handle);
    OS.g_signal_handlers_block_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
    OS.gtk_tree_selection_unselect_all(selection);
    OS.g_signal_handlers_unblock_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.List.removeAll()V1
public void removeAll() {
    checkWidget();
    long selection = OS.gtk_tree_view_get_selection(handle);
    OS.g_signal_handlers_block_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
    OS.gtk_list_store_clear(modelHandle);
    OS.g_signal_handlers_unblock_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
}

---------------Library-------------------
method: org.eclipse.swt.widgets.TreeItem.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    font = null;
    cellFont = null;
}
method: org.eclipse.swt.widgets.Item.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    text = null;
    image = null;
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.observable.masterdetail.SetDetailValueObservableMap.dispose()V1
public synchronized void dispose() {
    super.dispose();
    observableValueFactory = null;
    detailObservableValueMap = null;
    detailStaleListener = null;
    staleDetailObservables = null;
}

---------------Library-------------------
method: org.eclipse.ui.help.WorkbenchHelp.createHelpListener(org.eclipse.ui.commands.ICommand;)org.eclipse.swt.events.HelpListener;1
public static HelpListener createHelpListener(ICommand command) {
    return WorkbenchHelpSystem.getInstance().createHelpListener(command);
}
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem.getInstance()org.eclipse.ui.internal.help.WorkbenchHelpSystem;0
public static WorkbenchHelpSystem getInstance() {
    if (instance == null) {
        instance = new  WorkbenchHelpSystem();
    }
    return instance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeReferenceType()V1
protected void consumeReferenceType() {
    pushOnIntStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.jface.text.quickassist.QuickAssistAssistant.setStatusLineVisible(Z)V2
public void setStatusLineVisible(boolean show) {
    fQuickAssistAssistantImpl.setStatusLineVisible(show);
}
method: org.eclipse.jface.text.contentassist.ContentAssistant.setStatusLineVisible(Z)V2
public void setStatusLineVisible(boolean show) {
    fIsStatusLineVisible = show;
    if (fProposalPopup != null)
        fProposalPopup.setStatusLineVisible(show);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.dialogs.MultiElementListSelectionDialog.setComparator(java.util.Comparator;)V2
public void setComparator(Comparator<?> comparator) {
    fComparator = comparator;
    if (fFilteredList != null)
        fFilteredList.setComparator(fComparator);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.jarpackagerfat.FatJarPackageWizardPage.dispose()V1
@Override
public void dispose() {
    super.dispose();
    if (fLauchConfigurationModel != null) {
        for (int i = 0, size = fLauchConfigurationModel.size(); i < size; i++) {
            LaunchConfigurationElement element = fLauchConfigurationModel.get(i);
            element.dispose();
        }
    }
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
method: org.eclipse.swt.accessibility.Accessible.release()V1
void release() {
    if (children != null) {
        for (int i = 0; i < children.size(); i++) {
            Accessible child = (Accessible) children.elementAt(i);
            child.dispose();
        }
    }
    if (accessibleObject != null) {
        accessibleObject.release();
        accessibleObject = null;
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.TreeListDialogField$TreeViewerAdapter.doubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
public void doubleClick(DoubleClickEvent event) {
    doDoubleClick(event);
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.TreeListDialogField.doDoubleClick(org.eclipse.jface.viewers.DoubleClickEvent;)V2
protected void doDoubleClick(DoubleClickEvent event) {
    if (fTreeAdapter != null) {
        fTreeAdapter.doubleClicked(this);
    }
}
---------------Client-------------------
method: org.eclipse.compare.structuremergeviewer.StructureRootNode.dispose()V1
public void dispose() {
    if (fAdapter != null) {
        fAdapter.disconnect(fInput);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyForInitopt()V1
protected void consumeEmptyForInitopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
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
method: org.eclipse.ui.internal.console.ConsoleDropDownAction.dispose()V1
@Override
public void dispose() {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fView = null;
    ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.util.PluginWorkingSet.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsConstraintCreator.endVisit(org.eclipse.jdt.core.dom.StringLiteral;)V2
@Override
public void endVisit(StringLiteral node) {
    ITypeBinding typeBinding = node.resolveTypeBinding();
    ImmutableTypeVariable2 cv = fTCModel.makeImmutableTypeVariable(typeBinding, null);
    setConstraintVariable(node, cv);
}
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsTCModel.makeImmutableTypeVariable(org.eclipse.jdt.core.dom.ITypeBinding;org.eclipse.jdt.core.dom.Expression;)org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ImmutableTypeVariable2;3
public ImmutableTypeVariable2 makeImmutableTypeVariable(ITypeBinding typeBinding, Expression expression) {
    TType type = getBoxedType(typeBinding, expression);
    if (type == null)
        return null;
    return makeImmutableTypeVariable(type);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.deleteResource(ZLorg.eclipse.core.runtime.MultiStatus;)V3
public void deleteResource(boolean convertToPhantom, MultiStatus status) throws CoreException {
    super.deleteResource(convertToPhantom, status);
    clearHistory(null);
    workspace.getMetaArea().delete(this);
}

---------------Library-------------------
method: org.eclipse.ui.internal.editors.text.TextEditorDefaultsPreferencePage.dispose()V1
public void dispose() {
    if (fOverlayStore != null) {
        fOverlayStore.stop();
        fOverlayStore = null;
    }
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
method: org.eclipse.core.internal.runtime.InternalPlatform.stopServices()V1
private void stopServices() {
    if (legacyPreferencesService != null) {
        legacyPreferencesService.unregister();
        legacyPreferencesService = null;
    }
    if (customPreferencesService != null) {
        customPreferencesService.unregister();
        customPreferencesService = null;
    }
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;6
public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<? super T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth, org.hamcrest.Matcher<? super T> sixth) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third, fourth, fifth, sixth);
}
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;6
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth, Matcher<? super T> sixth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(6);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    matchers.add(sixth);
    return allOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;6
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth, Matcher<? super T> sixth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    matchers.add(sixth);
    return anyOf(matchers);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.ThisExpression;)V2
@Override
public void endVisit(ThisExpression node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getQualifier());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.ui.wizards.datatransfer.ZipFileImportWizard.performFinish()Z1
public boolean performFinish() {
    return mainPage.finish();
}
method: org.eclipse.ui.internal.wizards.datatransfer.WizardArchiveFileResourceImportPage1.finish()Z1
public boolean finish() {
    if (!super.finish()) {
        return false;
    }
    disposeStructureProvider();
    return true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractConstantRefactoring.insertFirst()Z1
private boolean insertFirst() throws JavaModelException {
    if (!isDeclarationLocationComputed())
        computeConstantDeclarationLocation();
    return fInsertFirst;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.nls.ExternalizeStringsWizardPage.dispose()V1
@Override
public void dispose() {
    fColorManager.dispose();
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
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.XMLModelReconciler.getStructuralFeature(org.eclipse.emf.ecore.EObject;java.lang.String;)org.eclipse.emf.ecore.EStructuralFeature;2
private static EStructuralFeature getStructuralFeature(EObject object, String featureName) {
    for (EStructuralFeature sf : object.eClass().getEAllStructuralFeatures()) {
        if (sf.getName().equals(featureName)) {
            return sf;
        }
    }
    return null;
}
method: org.eclipse.emf.ecore.impl.ENamedElementImpl.getName()java.lang.String;1
public String getName() {
    return getNameGen();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.target.ExportTargetJob.getCapability(org.eclipse.equinox.p2.metadata.IInstallableUnit;java.lang.String;)java.lang.String;3
private String getCapability(IInstallableUnit iu, String namespace) {
    for (Iterator<?> i = iu.getProvidedCapabilities().iterator(); i.hasNext(); ) {
        IProvidedCapability capability = (IProvidedCapability) i.next();
        if (capability.getNamespace().equals(namespace))
            return capability.getName();
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.CTabItemElement.computeStaticPseudoInstances()V1
@Override
protected void computeStaticPseudoInstances() {
    super.computeStaticPseudoInstances();
    super.addStaticPseudoInstance("selected");
}
method: org.eclipse.e4.ui.css.core.dom.ElementAdapter.addStaticPseudoInstance(java.lang.String;)V2
public void addStaticPseudoInstance(String pseudoE) {
    if (staticPseudoInstances == null)
        staticPseudoInstances = new  ArrayList();
    staticPseudoInstances.add(pseudoE);
}
---------------Client-------------------
method: org.eclipse.jface.resource.ResourceManager.disposeExec(java.lang.Runnable;)V2
public void disposeExec(Runnable r) {
    Assert.isNotNull(r);
    if (disposeExecs == null) {
        disposeExecs = new  ArrayList<Runnable>();
    }
    disposeExecs.add(r);
}

---------------Library-------------------
method: org.eclipse.debug.core.model.RuntimeProcess.fireChangeEvent()V1
protected void fireChangeEvent() {
    fireEvent(new  DebugEvent(this, DebugEvent.CHANGE));
}
method: org.eclipse.debug.core.model.RuntimeProcess.fireEvent(org.eclipse.debug.core.DebugEvent;)V2
protected void fireEvent(DebugEvent event) {
    DebugPlugin manager = DebugPlugin.getDefault();
    if (manager != null) {
        manager.fireDebugEventSet(new DebugEvent[] { event });
    }
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.actions.expressions.EnableWatchExpressionAction.fireWatchExpressionChanged(org.eclipse.debug.core.model.IWatchExpression;)V2
private void fireWatchExpressionChanged(IWatchExpression expression) {
    DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { new  DebugEvent(expression, DebugEvent.CHANGE) });
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.ProposalSorterRegistry.informUser(org.eclipse.core.runtime.IStatus;)V2
private void informUser(IStatus status) {
    JavaPlugin.log(status);
    String title = JavaTextMessages.CompletionProposalComputerRegistry_error_dialog_title;
    String message = status.getMessage();
    MessageDialog.openError(JavaPlugin.getActiveWorkbenchShell(), title, message);
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.ActivityPersistanceHelper.loadEnabledStates()V1
void loadEnabledStates() {
    loadEnabledStates(Collections.EMPTY_SET, PlatformUI.getWorkbench().getActivitySupport().getActivityManager().getDefinedActivityIds());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.toc.text.TocDocumentHandler.error(org.xml.sax.SAXParseException;)V2
public void error(SAXParseException e) throws SAXException {
    fModel.addError(e);
    super.error(e);
}
method: org.eclipse.pde.internal.ua.core.toc.text.TocModel.addError(java.lang.Exception;)V2
public void addError(Exception e) {
    if (fErrors == null) {
        fErrors = new  ArrayList(1);
    }
    if (!fErrors.contains(e)) {
        fErrors.add(e);
    }
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering.addMenuListener(org.eclipse.jface.action.IMenuListener;)V2
private void addMenuListener(IMenuListener menuListener) {
    if (fMenuListeners == null) {
        fMenuListeners = new  ArrayList<IMenuListener>();
    }
    if (!fMenuListeners.contains(menuListener)) {
        fMenuMgr.addMenuListener(menuListener);
        fMenuListeners.add(menuListener);
    }
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.DocumentCSSImpl.setCSSStyleDeclarationList(java.util.List;II)V4
protected void setCSSStyleDeclarationList(List list, int selectorType, int conditionType) {
    Integer key = getKey(selectorType, conditionType);
    getStyleDeclarationMap().put(key, list);
}
method: org.eclipse.e4.ui.css.core.impl.dom.DocumentCSSImpl.getStyleDeclarationMap()java.util.Map;1
protected Map getStyleDeclarationMap() {
    if (styleDeclarationMap == null) {
        styleDeclarationMap = new  HashMap();
    }
    return styleDeclarationMap;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.ApiJavadocTag.setApplicableTo(IILjava.lang.String;)V4
@Override
public void setApplicableTo(int type, int member, String comment) {
    if (fTagItems == null) {
        fTagItems = new  HashMap<Integer, String>(6);
    }
    fTagItems.put(getTagKey(type, member), comment);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.isCheckDeprecated()Z1
protected boolean isCheckDeprecated() {
    return CompilerFlags.getFlag(fProject, CompilerFlags.P_DEPRECATED) != CompilerFlags.IGNORE;
}
method: org.eclipse.pde.internal.core.builders.CompilerFlags.getFlag(org.eclipse.core.resources.IProject;java.lang.String;)I2
public static int getFlag(IProject project, String flagId) {
    try {
        return Integer.parseInt(getString(project, flagId));
    } catch (NumberFormatException nfe) {
        return 0;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.hierarchy.ChangeCollector.hasVisibilityChange(org.eclipse.jdt.core.IType;)Z2
private boolean hasVisibilityChange(IType type) throws JavaModelException {
    int existingFlags = this.hierarchy.getCachedFlags(type);
    int newFlags = type.getFlags();
    return existingFlags != newFlags;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.TypeDeclarationStatement;)V2
@Override
public void endVisit(TypeDeclarationStatement node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getDeclaration());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.WorkingSetManager.addWorkingSet(org.eclipse.ui.IWorkingSet;)V2
@Override
public void addWorkingSet(IWorkingSet workingSet) {
    super.addWorkingSet(workingSet);
    saveState();
}
method: org.eclipse.ui.internal.WorkingSetManager.saveState()V1
private void saveState() {
    if (restoreInProgress) {
        savePending = true;
        return;
    }
    File stateFile = getWorkingSetStateFile();
    if (stateFile == null) {
        return;
    }
    try {
        saveState(stateFile);
    } catch (IOException e) {
        stateFile.delete();
        handleInternalError(e, WorkbenchMessages.ProblemSavingWorkingSetState_title, WorkbenchMessages.ProblemSavingWorkingSetState_message);
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.AbstractSynchronizePage.init(org.eclipse.team.ui.synchronize.ISynchronizePageSite;)V2
public void init(ISynchronizePageSite site) {
    this.site = site;
    IDialogSettings settings = getSettings();
    if (settings != null) {
        try {
            int mode = settings.getInt(ISynchronizePageConfiguration.P_MODE);
            if (mode != 0) {
                configuration.setMode(mode);
            }
        } catch (NumberFormatException e) {
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.TokenScanner.readToToken(II)V3
public void readToToken(int tok, int offset) throws CoreException {
    setOffset(offset);
    readToToken(tok);
}
method: org.eclipse.jdt.internal.core.dom.rewrite.TokenScanner.readToToken(I)V2
public void readToToken(int tok) throws CoreException {
    int curr = 0;
    do {
        curr = readNext(false);
    } while (curr != tok);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.CollectingSearchRequestor.acceptSearchMatch(org.eclipse.jdt.core.search.SearchMatch;)V2
@Override
public void acceptSearchMatch(SearchMatch match) throws CoreException {
    if (!filterMatch(match))
        collectMatch(match);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticFactoryMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticFactoryMethod(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForFactoryMethod(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Resource.getStore()org.eclipse.core.filesystem.IFileStore;1
public IFileStore getStore() {
    return getLocalManager().getStore(this);
}
method: org.eclipse.core.internal.localstore.FileSystemResourceManager.getStore(org.eclipse.core.resources.IResource;)org.eclipse.core.filesystem.IFileStore;2
public IFileStore getStore(IResource target) {
    try {
        return getStoreRoot(target).createStore(target.getFullPath(), target);
    } catch (CoreException e) {
        return EFS.getNullFileSystem().getStore(target.getFullPath());
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.StubUtility2.suggestParameterName(org.eclipse.jdt.core.ICompilationUnit;org.eclipse.jdt.core.dom.IVariableBinding;Ajava.lang.String;)java.lang.String;3
private static String suggestParameterName(ICompilationUnit unit, IVariableBinding binding, String[] excluded) {
    String name = StubUtility.getBaseName(binding, unit.getJavaProject());
    return StubUtility.suggestArgumentName(unit.getJavaProject(), name, excluded);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeFormalParameterListopt()V1
protected void consumeFormalParameterListopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.plugin.XMLTextChangeListener.getWritableString(java.lang.String;)java.lang.String;2
private String getWritableString(String source) {
    return PDEXMLHelper.getWritableString(source);
}
method: org.eclipse.pde.internal.core.util.PDEXMLHelper.getWritableString(java.lang.String;)java.lang.String;1
public static String getWritableString(String source) {
    if (source == null)
        return "";
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.getWritableString(java.lang.String;)java.lang.String;2
private String getWritableString(String source) {
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.AnonymousClassDeclaration;)V2
@Override
public void endVisit(AnonymousClassDeclaration node) {
    if (skipNode(node))
        return;
    FlowInfo info = processSequential(node, node.bodyDeclarations());
    info.setNoReturn();
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.processSequential(org.eclipse.jdt.core.dom.ASTNode;java.util.List;)org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;3
protected GenericSequentialFlowInfo processSequential(ASTNode parent, List<? extends ASTNode> nodes) {
    GenericSequentialFlowInfo result = createSequential(parent);
    process(result, nodes);
    return result;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.LabeledStatement;)V2
@Override
public void endVisit(LabeledStatement node) {
    if (skipNode(node))
        return;
    FlowInfo info = assignFlowInfo(node, node.getBody());
    if (info != null)
        info.removeLabel(node.getLabel());
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.html.SWTHTMLElementProvider.getElement(java.lang.Object;org.eclipse.e4.ui.css.core.engine.CSSEngine;)org.w3c.dom.Element;3
@Override
public Element getElement(Object element, CSSEngine engine) {
    if (element instanceof Widget) {
        Widget widget = (Widget) element;
        return SWTElementHelpers.getHTMLElement(widget, engine);
    }
    return null;
}
method: org.eclipse.e4.ui.css.swt.helpers.SWTElementHelpers.getHTMLElement(org.eclipse.swt.widgets.Widget;org.eclipse.e4.ui.css.core.engine.CSSEngine;)org.w3c.dom.Element;2
public static Element getHTMLElement(Widget widget, CSSEngine engine) {
    try {
        return getElement(widget, engine, SWTHTMLElement.class);
    } catch (Exception e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.core.runtime.spi.RegistryStrategy.processChangeEvent(Ajava.lang.Object;java.util.Map;java.lang.Object;)org.eclipse.core.runtime.IStatus;3
public static final IStatus processChangeEvent(Object[] listeners, Map deltas, Object registry) {
    if (registry instanceof ExtensionRegistry)
        return ((ExtensionRegistry) registry).processChangeEvent(listeners, deltas);
    return null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.frameworkadmin.equinox.EquinoxBundlesState.composeNewState(org.eclipse.equinox.internal.provisional.frameworkadmin.LauncherData;org.eclipse.equinox.internal.provisional.frameworkadmin.ConfigData;Aorg.eclipse.equinox.frameworkadmin.BundleInfo;)V4
private void composeNewState(LauncherData launcherData, ConfigData configData, BundleInfo[] bInfos) {
    this.composeNewState(launcherData, configData, configData.getProperties(), bInfos);
}
method: org.eclipse.equinox.internal.provisional.frameworkadmin.ConfigData.getProperties()java.util.Properties;1
public Properties getProperties() {
    Properties ret = new  Properties();
    ret.putAll(properties);
    return ret;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.ds.Resolver.removeFromSatisfiedList(org.eclipse.equinox.internal.ds.model.ServiceComponentProp;)V2
public void removeFromSatisfiedList(ServiceComponentProp scp) {
    Vector tmp = new  Vector();
    tmp.addElement(scp);
    mgr.enqueueWork(this, Resolver.DISPOSE, tmp, false);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.ResourceDragAndDropEditor$PreferenceGroup.doLoad()V1
public void doLoad() {
    String resourcePreference = getStoredValue(false);
    updateState(resourcePreference);
}
method: org.eclipse.ui.internal.ide.ResourceDragAndDropEditor$PreferenceGroup.updateState(java.lang.String;)V2
private void updateState(String value) {
    for (int i = 0; i < labels.length; i++) {
        if (value.equals(buttons[i].getData()))
            buttons[i].setSelection(true);
    }
}
---------------Client-------------------
method: org.eclipse.swt.custom.PopupList.select(java.lang.String;)V2
public void select(String string) {
    String[] items = list.getItems();
    if (string != null) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].startsWith(string)) {
                int index = list.indexOf(items[i]);
                list.select(index);
                break;
            }
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.noMoreAvailableSpaceInConstantPool(org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;)V2
public void noMoreAvailableSpaceInConstantPool(TypeDeclaration typeDeclaration) {
    this.handle(IProblem.TooManyConstantsInConstantPool, new String[] { new  String(typeDeclaration.binding.readableName()) }, new String[] { new  String(typeDeclaration.binding.shortReadableName()) }, ProblemSeverities.Abort | ProblemSeverities.Error | ProblemSeverities.Fatal, typeDeclaration.sourceStart, typeDeclaration.sourceEnd);
}
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.handle(IAjava.lang.String;Ajava.lang.String;III)V7
private void handle(int problemId, String[] problemArguments, String[] messageArguments, int severity, int problemStartPosition, int problemEndPosition) {
    this.handle(problemId, problemArguments, 0, messageArguments, severity, problemStartPosition, problemEndPosition);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.illegalTypeForExplicitThis(org.eclipse.jdt.internal.compiler.ast.Receiver;org.eclipse.jdt.internal.compiler.lookup.TypeBinding;)V3
public void illegalTypeForExplicitThis(Receiver receiver, TypeBinding expectedType) {
    this.handle(IProblem.IllegalTypeForExplicitThis, new String[] { new  String(expectedType.readableName()) }, new String[] { new  String(expectedType.shortReadableName()) }, receiver.type.sourceStart, receiver.type.sourceEnd);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpTreeSection.dispose()V1
public void dispose() {
    PDEUserAssistanceUIPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ua.ui.PDEUserAssistanceUIPlugin.getLabelProvider()org.eclipse.pde.internal.ua.ui.PDEUserAssistanceLabelProvider;1
public PDEUserAssistanceLabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDEUserAssistanceLabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.WildcardType.setBound(org.eclipse.jdt.core.dom.Type;Z)V3
public void setBound(Type type, boolean isUpperBound) {
    setBound(type);
    setUpperBound(isUpperBound);
}
method: org.eclipse.jdt.core.dom.WildcardType.setUpperBound(Z)V2
public void setUpperBound(boolean isUpperBound) {
    preValueChange(UPPER_BOUND_PROPERTY);
    this.isUpperBound = isUpperBound;
    postValueChange(UPPER_BOUND_PROPERTY);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.debug.ui.jres.EEVMPage.setSelection(org.eclipse.jdt.launching.VMStandin;)V2
@Override
public void setSelection(VMStandin vm) {
    super.setSelection(vm);
    fVM = vm;
    setTitle(JREMessages.EEVMPage_6);
    setDescription(JREMessages.EEVMPage_7);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.NewJavaProjectPreferencePage.decodeJRELibraryDescription(java.lang.String;)java.lang.String;1
public static String decodeJRELibraryDescription(String encoded) {
    int end = encoded.indexOf(' ');
    if (end != -1) {
        return decode(encoded.substring(0, end));
    }
    return "";
}
method: org.eclipse.jdt.internal.ui.preferences.NewJavaProjectPreferencePage.decode(java.lang.String;)java.lang.String;1
private static String decode(String str) {
    try {
        return URLDecoder.decode(str, ENCODING);
    } catch (UnsupportedEncodingException e) {
        JavaPlugin.log(e);
    }
    return "";
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.commands.CommandCopyFilter.filter(java.lang.String;ZLjava.lang.String;)java.lang.String;4
public final String filter(String serializedCommand, boolean surroundWithMarkup, String markupLabel) {
    if (surroundWithMarkup)
        return markup(escape(serializedCommand), markupLabel);
    return escape(serializedCommand);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.Disassembler.decodeStringValue(AC)java.lang.String;1
static String decodeStringValue(char[] chars) {
    StringBuffer buffer = new  StringBuffer();
    for (int i = 0, max = chars.length; i < max; i++) {
        char c = chars[i];
        escapeChar(buffer, c);
    }
    return buffer.toString();
}
method: org.eclipse.jdt.internal.core.util.Disassembler.escapeChar(java.lang.StringBuffer;C)V2
private static void escapeChar(StringBuffer buffer, char c) {
    switch(c) {
        case '\b':
            buffer.append("\\b");
            break;
        case '\t':
            buffer.append("\\t");
            break;
        case '\n':
            buffer.append("\\n");
            break;
        case '\f':
            buffer.append("\\f");
            break;
        case '\r':
            buffer.append("\\r");
            break;
        case '\0':
            buffer.append("\\0");
            break;
        case '\1':
            buffer.append("\\1");
            break;
        case '\2':
            buffer.append("\\2");
            break;
        case '\3':
            buffer.append("\\3");
            break;
        case '\4':
            buffer.append("\\4");
            break;
        case '\5':
            buffer.append("\\5");
            break;
        case '\6':
            buffer.append("\\6");
            break;
        case '\7':
            buffer.append("\\7");
            break;
        default:
            buffer.append(c);
    }
}
---------------Client-------------------
method: org.eclipse.equinox.p2.internal.repository.comparator.java.Disassembler.decodeStringValue(AC)java.lang.String;1
static String decodeStringValue(char[] chars) {
    StringBuffer buffer = new  StringBuffer();
    for (int i = 0, max = chars.length; i < max; i++) {
        char c = chars[i];
        switch(c) {
            case '\b':
                buffer.append("\\b");
                break;
            case '\t':
                buffer.append("\\t");
                break;
            case '\n':
                buffer.append("\\n");
                break;
            case '\f':
                buffer.append("\\f");
                break;
            case '\r':
                buffer.append("\\r");
                break;
            case '\0':
                buffer.append("\\0");
                break;
            case '\1':
                buffer.append("\\1");
                break;
            case '\2':
                buffer.append("\\2");
                break;
            case '\3':
                buffer.append("\\3");
                break;
            case '\4':
                buffer.append("\\4");
                break;
            case '\5':
                buffer.append("\\5");
                break;
            case '\6':
                buffer.append("\\6");
                break;
            case '\7':
                buffer.append("\\7");
                break;
            default:
                buffer.append(c);
        }
    }
    return buffer.toString();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.CVSRepositoryPropertiesPage.createPasswordField(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Text;2
protected Text createPasswordField(Composite parent) {
    Text text = new  Text(parent, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
    return layoutTextField(text);
}
method: org.eclipse.team.internal.ccvs.ui.repo.CVSRepositoryPropertiesPage.layoutTextField(org.eclipse.swt.widgets.Text;)org.eclipse.swt.widgets.Text;2
protected Text layoutTextField(Text text) {
    GridData data = new  GridData(GridData.FILL_HORIZONTAL);
    data.verticalAlignment = GridData.CENTER;
    data.grabExcessVerticalSpace = false;
    data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
    data.horizontalSpan = 2;
    text.setLayoutData(data);
    return text;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.TagSelectionArea.createText(org.eclipse.swt.widgets.Composite;I)org.eclipse.swt.widgets.Text;3
private Text createText(Composite parent, int horizontalSpan) {
    Text text = new  Text(parent, SWT.SEARCH);
    GridData data = new  GridData();
    data.horizontalSpan = horizontalSpan;
    data.horizontalAlignment = GridData.FILL;
    data.grabExcessHorizontalSpace = true;
    data.widthHint = 0;
    text.setLayoutData(data);
    return text;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.TokenScanner.readToToken(II)V3
public void readToToken(int tok, int offset) throws CoreException {
    setOffset(offset);
    readToToken(tok);
}
method: org.eclipse.jdt.internal.corext.dom.TokenScanner.readToToken(I)V2
public void readToToken(int tok) throws CoreException {
    int curr = 0;
    do {
        curr = readNext(false);
    } while (curr != tok);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.CollectingSearchRequestor.acceptSearchMatch(org.eclipse.jdt.core.search.SearchMatch;)V2
@Override
public void acceptSearchMatch(SearchMatch match) throws CoreException {
    if (!filterMatch(match))
        collectMatch(match);
}

---------------Library-------------------
method: org.eclipse.jetty.io.UncheckedPrintWriter.print(C)V2
@Override
public void print(char c) {
    this.write(c);
}
method: org.eclipse.jetty.io.UncheckedPrintWriter.write(I)V2
@Override
public void write(int c) {
    try {
        synchronized (lock) {
            isOpen();
            out.write(c);
        }
    } catch (InterruptedIOException x) {
        Thread.currentThread().interrupt();
    } catch (IOException ex) {
        setError(ex);
    }
}
---------------Client-------------------
method: org.eclipse.jetty.io.nio.RandomAccessFileBuffer.clear()V1
@Override
public void clear() {
    try {
        synchronized (_file) {
            super.clear();
            _file.setLength(0);
        }
    } catch (Exception e) {
        throw new  RuntimeException(e);
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.FeatureObject.getWritableString(java.lang.String;)java.lang.String;2
protected String getWritableString(String source) {
    return PDEXMLHelper.getWritableString(source);
}
method: org.eclipse.pde.internal.core.util.PDEXMLHelper.getWritableString(java.lang.String;)java.lang.String;1
public static String getWritableString(String source) {
    if (source == null)
        return "";
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.getWritableString(java.lang.String;)java.lang.String;2
private String getWritableString(String source) {
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.getSelectedCommandName()java.lang.String;1
protected String getSelectedCommandName() {
    return fCommandDetails.getCommandName();
}
method: org.eclipse.pde.internal.ui.commands.CommandDetails.getCommandName()java.lang.String;1
public String getCommandName() {
    if (fSelectedCommand != null)
        try {
            return fSelectedCommand.getName();
        } catch (NotDefinedException e) {
            return fSelectedCommand.getId();
        }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.SimpleType;)V2
@Override
public void endVisit(SimpleType node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getName());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.jface.commands.ActionHandler.addHandlerListener(org.eclipse.core.commands.IHandlerListener;)V2
@Override
public final void addHandlerListener(final IHandlerListener handlerListener) {
    if (!hasListeners()) {
        attachListener();
    }
    super.addHandlerListener(handlerListener);
}
method: org.eclipse.jface.commands.ActionHandler.attachListener()V1
private final void attachListener() {
    if (propertyChangeListener == null) {
        propertyChangeListener = new  IPropertyChangeListener() {

            @Override
            public final void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
                final String property = propertyChangeEvent.getProperty();
                fireHandlerChanged(new  HandlerEvent(ActionHandler.this, IAction.ENABLED.equals(property), IAction.HANDLED.equals(property)));
            }
        };
    }
    this.action.addPropertyChangeListener(propertyChangeListener);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.nls.ModelChange.addXMLChange(org.eclipse.core.resources.IFile;org.eclipse.pde.internal.ui.nls.ModelChangeElement;)V3
private void addXMLChange(IFile file, ModelChangeElement change) {
    if (fXMLCoupling == null) {
        fXMLCoupling = new  ModelChangeFile(file, this);
    }
    if (!fXMLCoupling.getFile().equals(file)) {
        return;
    }
    fXMLCoupling.add(change);
}

---------------Library-------------------
method: org.eclipse.ui.forms.widgets.ImageHyperlink.handleEnter(org.eclipse.swt.widgets.Event;)V2
protected void handleEnter(Event e) {
    state = HOVER;
    super.handleEnter(e);
}
method: org.eclipse.ui.forms.widgets.AbstractHyperlink.handleEnter(org.eclipse.swt.widgets.Event;)V2
protected void handleEnter(Event e) {
    redraw();
    if (listeners == null)
        return;
    int size = listeners.size();
    HyperlinkEvent he = new  HyperlinkEvent(this, getHref(), getText(), e.stateMask);
    Object[] listenerList = listeners.getListeners();
    for (int i = 0; i < size; i++) {
        IHyperlinkListener listener = (IHyperlinkListener) listenerList[i];
        listener.linkEntered(he);
    }
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.AbstractHyperlink.handleExit(org.eclipse.swt.widgets.Event;)V2
protected void handleExit(Event e) {
    armed = false;
    redraw();
    if (listeners == null)
        return;
    int size = listeners.size();
    HyperlinkEvent he = new  HyperlinkEvent(this, getHref(), getText(), e.stateMask);
    Object[] listenerList = listeners.getListeners();
    for (int i = 0; i < size; i++) {
        IHyperlinkListener listener = (IHyperlinkListener) listenerList[i];
        listener.linkExited(he);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.ResourceDragAndDropEditor$PreferenceGroup.loadDefault()V1
public void loadDefault() {
    String value = getStoredValue(true);
    updateState(value);
}
method: org.eclipse.ui.internal.ide.ResourceDragAndDropEditor$PreferenceGroup.updateState(java.lang.String;)V2
private void updateState(String value) {
    for (int i = 0; i < labels.length; i++) {
        if (value.equals(buttons[i].getData()))
            buttons[i].setSelection(true);
    }
}
---------------Client-------------------
method: org.eclipse.swt.custom.PopupList.select(java.lang.String;)V2
public void select(String string) {
    String[] items = list.getItems();
    if (string != null) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].startsWith(string)) {
                int index = list.indexOf(items[i]);
                list.select(index);
                break;
            }
        }
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.model.AbstractIntroPage.findDomChild(java.lang.String;)org.w3c.dom.Element;2
public Element findDomChild(String id) {
    return findDomChild(id, "*");
}
method: org.eclipse.ui.internal.intro.impl.model.AbstractIntroPage.findDomChild(java.lang.String;java.lang.String;)org.w3c.dom.Element;3
public Element findDomChild(String id, String localElementName) {
    if (!loaded)
        loadChildren();
    return ModelUtil.getElementById(dom, id, localElementName);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.launchConfigurations.SetTargetsDialog.getTargetsSelected()java.lang.String;1
protected String getTargetsSelected() {
    String defaultValue = null;
    if (!fTargetsTab.isTargetSelected()) {
        defaultValue = IAntCoreConstants.EMPTY_STRING;
    }
    try {
        return fConfiguration.getAttribute(IAntLaunchConstants.ATTR_ANT_TARGETS, defaultValue);
    } catch (CoreException e) {
        return defaultValue;
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticConstructorAccessMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticConstructorAccessMethod(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForConstructorAccess(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.context.XMLInputContext.getWritableAttributeNodeValue(java.lang.String;)java.lang.String;2
protected String getWritableAttributeNodeValue(String source) {
    return PDEXMLHelper.getWritableString(source);
}
method: org.eclipse.pde.internal.core.util.PDEXMLHelper.getWritableString(java.lang.String;)java.lang.String;1
public static String getWritableString(String source) {
    if (source == null)
        return "";
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.getWritableString(java.lang.String;)java.lang.String;2
private String getWritableString(String source) {
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}

---------------Library-------------------
method: org.eclipse.emf.common.util.ECollections$2.listIterator()java.util.ListIterator;1
public ListIterator<Map.Entry<K, V>> listIterator() {
    return listView().listIterator();
}
method: org.eclipse.emf.common.util.ECollections$2.listView()java.util.List;1
protected List<Map.Entry<K, V>> listView() {
    if (listView == null) {
        listView = new  AbstractList<Map.Entry<K, V>>() {

            @Override
            public Map.Entry<K, V> get(int index) {
                return basicGet(index);
            }

            @Override
            public int size() {
                return map.size();
            }
        };
    }
    return listView;
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.TypeBinding.getKey()java.lang.String;1
public String getKey() {
    if (this.key == null) {
        this.key = new  String(this.binding.computeUniqueKey());
    }
    return this.key;
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.extensions.NavigatorContentExtension$3.run()V1
public void run() throws Exception {
    if (contentProvider != null) {
        contentProvider.dispose();
    }
}
method: org.eclipse.ui.internal.navigator.extensions.SafeDelegateTreeContentProvider.dispose()V1
public void dispose() {
    SafeRunner.run(new  NavigatorSafeRunnable() {

        public void run() throws Exception {
            contentProvider.dispose();
        }
    });
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.extension.PointSelectionPage$6.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    if (fCurrentPoint != null)
        new  ShowDescriptionAction(fCurrentPoint, true).run();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.ExtensionsSection.resolveObjectName(java.lang.Object;)java.lang.String;2
private String resolveObjectName(Object obj) {
    return resolveObjectName(getSchemaRegistry(), obj);
}
method: org.eclipse.pde.internal.ui.editor.plugin.ExtensionsSection.getSchemaRegistry()org.eclipse.pde.internal.core.schema.SchemaRegistry;1
private SchemaRegistry getSchemaRegistry() {
    if (fSchemaRegistry == null)
        fSchemaRegistry = PDECore.getDefault().getSchemaRegistry();
    return fSchemaRegistry;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.viewsupport.StorageLabelProvider.getDefaultImage()org.eclipse.swt.graphics.Image;1
private Image getDefaultImage() {
    if (fDefaultImage == null)
        fDefaultImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
    return fDefaultImage;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTFontHelper.storeDefaultFont(org.eclipse.swt.custom.CTabItem;)V1
public static void storeDefaultFont(CTabItem item) {
    storeDefaultFont(item, item.getFont());
}
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTFontHelper.storeDefaultFont(org.eclipse.swt.widgets.Widget;org.eclipse.swt.graphics.Font;)V2
private static void storeDefaultFont(Widget widget, Font font) {
    if (widget.getData(DEFAULT_FONT) == null) {
        widget.setData(DEFAULT_FONT, font);
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTCursorHelper.storeDefaultCursor(org.eclipse.swt.widgets.Control;)V1
public static void storeDefaultCursor(Control control) {
    if (control.getData(DEFAULT_CURSOR) == null) {
        control.setData(DEFAULT_CURSOR, control.getCursor());
    }
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.storage.PasswordManagement.recoveryNode(org.eclipse.equinox.internal.security.storage.SecurePreferences;java.lang.String;)org.eclipse.equinox.internal.security.storage.SecurePreferences;2
private static SecurePreferences recoveryNode(SecurePreferences root, String moduleID) {
    return root.node(PASSWORD_RECOVERY_NODE).node(moduleID);
}
method: org.eclipse.equinox.internal.security.storage.SecurePreferences.node(java.lang.String;)org.eclipse.equinox.internal.security.storage.SecurePreferences;2
public SecurePreferences node(String pathName) {
    checkRemoved();
    validatePath(pathName);
    return navigateToNode(pathName, true);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.getActiveBuildConfig()org.eclipse.core.resources.IBuildConfiguration;1
public IBuildConfiguration getActiveBuildConfig() throws CoreException {
    ResourceInfo info = getResourceInfo(false, false);
    int flags = getFlags(info);
    checkAccessible(flags);
    return internalGetActiveBuildConfig();
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.AbstractOpenWizardAction.getShell()org.eclipse.swt.widgets.Shell;1
protected Shell getShell() {
    if (fShell == null) {
        return JavaPlugin.getActiveWorkbenchShell();
    }
    return fShell;
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.model.CVSModelElement.getRunnableContext()org.eclipse.jface.operation.IRunnableContext;1
public IRunnableContext getRunnableContext() {
    if (runnableContext == null) {
        return PlatformUI.getWorkbench().getProgressService();
    }
    return runnableContext;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.NewFragmentProjectWizard.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringCore.getRefactoringContribution(java.lang.String;)org.eclipse.ltk.core.refactoring.RefactoringContribution;1
public static RefactoringContribution getRefactoringContribution(String id) {
    return RefactoringContributionManager.getInstance().getRefactoringContribution(id);
}
method: org.eclipse.ltk.internal.core.refactoring.history.RefactoringContributionManager.getInstance()org.eclipse.ltk.internal.core.refactoring.history.RefactoringContributionManager;0
public static RefactoringContributionManager getInstance() {
    if (fInstance == null)
        fInstance = new  RefactoringContributionManager();
    return fInstance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.isCheckUnknownClass()Z1
protected boolean isCheckUnknownClass() {
    return CompilerFlags.getFlag(fProject, CompilerFlags.P_UNKNOWN_CLASS) != CompilerFlags.IGNORE;
}
method: org.eclipse.pde.internal.core.builders.CompilerFlags.getFlag(org.eclipse.core.resources.IProject;java.lang.String;)I2
public static int getFlag(IProject project, String flagId) {
    try {
        return Integer.parseInt(getString(project, flagId));
    } catch (NumberFormatException nfe) {
        return 0;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.hierarchy.ChangeCollector.hasVisibilityChange(org.eclipse.jdt.core.IType;)Z2
private boolean hasVisibilityChange(IType type) throws JavaModelException {
    int existingFlags = this.hierarchy.getCachedFlags(type);
    int newFlags = type.getFlags();
    return existingFlags != newFlags;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.parts.FormBrowser.setText(java.lang.String;)V2
public void setText(String text) {
    this.text = text;
    if (formText != null)
        formText.setText(text);
}
method: org.eclipse.ui.forms.widgets.ScrolledFormText.setText(java.lang.String;)V2
public void setText(String text) {
    this.text = text;
    loadText(text);
    reflow(true);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.RenameDialog.setOldName(java.lang.String;)V2
public void setOldName(String oldName) {
    this.oldName = oldName;
    addOldName(oldName);
    if (text != null)
        text.setText(oldName);
    this.newName = oldName;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.FieldInfoWithTypeAnnotation.reset()V1
protected void reset() {
    if (this.typeAnnotations != null)
        for (int i = 0, max = this.typeAnnotations.length; i < max; i++) this.typeAnnotations[i].reset();
    super.reset();
}
method: org.eclipse.jdt.internal.compiler.classfmt.FieldInfoWithAnnotation.reset()V1
protected void reset() {
    if (this.annotations != null)
        for (int i = 0, max = this.annotations.length; i < max; i++) this.annotations[i].reset();
    super.reset();
}
---------------Client-------------------
method: org.eclipse.core.runtime.model.ConfigurationElementModel.markReadOnly()V1
public void markReadOnly() {
    super.markReadOnly();
    if (children != null)
        for (int i = 0; i < children.length; i++) children[i].markReadOnly();
    if (properties != null)
        for (int i = 0; i < properties.length; i++) properties[i].markReadOnly();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.isCheckUnresolvedImports()Z1
protected boolean isCheckUnresolvedImports() {
    return CompilerFlags.getFlag(fProject, CompilerFlags.P_UNRESOLVED_IMPORTS) != CompilerFlags.IGNORE;
}
method: org.eclipse.pde.internal.core.builders.CompilerFlags.getFlag(org.eclipse.core.resources.IProject;java.lang.String;)I2
public static int getFlag(IProject project, String flagId) {
    try {
        return Integer.parseInt(getString(project, flagId));
    } catch (NumberFormatException nfe) {
        return 0;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.hierarchy.ChangeCollector.hasVisibilityChange(org.eclipse.jdt.core.IType;)Z2
private boolean hasVisibilityChange(IType type) throws JavaModelException {
    int existingFlags = this.hierarchy.getCachedFlags(type);
    int newFlags = type.getFlags();
    return existingFlags != newFlags;
}

---------------Library-------------------
method: org.apache.batik.util.gui.CSSMediaPanel.showDialog(java.awt.Component;java.lang.String;)I2
public static int showDialog(Component parent, String title) {
    return showDialog(parent, title, "");
}
method: org.apache.batik.util.gui.CSSMediaPanel.showDialog(java.awt.Component;java.lang.String;java.lang.String;)I3
public static int showDialog(Component parent, String title, String media) {
    Dialog dialog = new  Dialog(parent, title, media);
    dialog.setModal(true);
    dialog.pack();
    dialog.setVisible(true);
    return dialog.getReturnCode();
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.Policy.getDebugOption(java.lang.String;)Z1
private static boolean getDebugOption(String option) {
    return "true".equalsIgnoreCase(Platform.getDebugOption(IDEWorkbenchPlugin.IDE_WORKBENCH + option));
}

---------------Library-------------------
method: org.eclipse.ui.internal.ErrorViewPart.setPartName(java.lang.String;)V2
@Override
public void setPartName(String newName) {
    super.setPartName(newName);
}
method: org.eclipse.ui.part.ViewPart.setPartName(java.lang.String;)V2
@Override
protected void setPartName(String partName) {
    if (compatibilityTitleListener != null) {
        removePropertyListener(compatibilityTitleListener);
        compatibilityTitleListener = null;
    }
    super.setPartName(partName);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.MenuItem.releaseChildren(Z)V2
@Override
void releaseChildren(boolean destroy) {
    if (menu != null) {
        menu.release(false);
        menu = null;
    }
    super.releaseChildren(destroy);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.TypeLiteral;)V2
@Override
public void endVisit(TypeLiteral node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getType());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.operations.RemoteLogOperation$LogEntryCache.findRevison(Aorg.eclipse.team.internal.ccvs.core.ILogEntry;java.lang.String;)org.eclipse.team.internal.ccvs.core.ICVSRemoteFile;3
private ICVSRemoteFile findRevison(ILogEntry[] allLogs, String predecessorRevision) throws TeamException {
    for (int i = 0; i < allLogs.length; i++) {
        ILogEntry entry = allLogs[i];
        ICVSRemoteFile file = entry.getRemoteFile();
        if (file.getRevision().equals(predecessorRevision)) {
            return file;
        }
    }
    return null;
}
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.getRevision()java.lang.String;1
public String getRevision() {
    try {
        return ResourceSyncInfo.getRevision(syncBytes);
    } catch (CVSException e) {
        CVSProviderPlugin.log(e);
        return ResourceSyncInfo.ADDED_REVISION;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.ExtractClassRefactoring.getField(java.lang.String;)org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field;2
private Field getField(String name) {
    Field[] fields = fDescriptor.getFields();
    for (int i = 0; i < fields.length; i++) {
        Field field = fields[i];
        if (field.getFieldName().equals(name))
            return field;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.TagSelectionArea$7.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
public void keyPressed(KeyEvent event) {
    handleKeyPressed(event);
}
method: org.eclipse.team.internal.ccvs.ui.tags.TagSelectionArea.handleKeyPressed(org.eclipse.swt.events.KeyEvent;)V2
public void handleKeyPressed(KeyEvent event) {
    if (event.character == SWT.DEL && event.stateMask == 0) {
        deleteDateTag();
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.debug.ui.JavaDetailFormattersPreferencePage$5.keyPressed(org.eclipse.swt.events.KeyEvent;)V2
@Override
public void keyPressed(KeyEvent event) {
    if (event.character == SWT.DEL && event.stateMask == 0) {
        removeTypes();
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.JarOptionsPage$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    handleDescriptionFileBrowseButtonPressed();
}
method: org.eclipse.jdt.internal.ui.jarpackager.JarOptionsPage.handleDescriptionFileBrowseButtonPressed()V1
protected void handleDescriptionFileBrowseButtonPressed() {
    SaveAsDialog dialog = new  SaveAsDialog(getContainer().getShell());
    dialog.create();
    dialog.getShell().setText(JarPackagerMessages.JarOptionsPage_saveAsDialog_title);
    dialog.setMessage(JarPackagerMessages.JarOptionsPage_saveAsDialog_message);
    dialog.setOriginalFile(createFileHandle(fJarPackage.getDescriptionLocation()));
    if (dialog.open() == Window.OK) {
        IPath path = dialog.getResult();
        path = path.removeFileExtension().addFileExtension(JarPackagerUtil.DESCRIPTION_EXTENSION);
        fDescriptionFileText.setText(path.toString());
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.JarManifestWizardPage.handleNewManifestFileBrowseButtonPressed()V1
protected void handleNewManifestFileBrowseButtonPressed() {
    SaveAsDialog dialog = new  SaveAsDialog(getContainer().getShell());
    dialog.create();
    dialog.getShell().setText(JarPackagerMessages.JarManifestWizardPage_saveAsDialog_title);
    dialog.setMessage(JarPackagerMessages.JarManifestWizardPage_saveAsDialog_message);
    dialog.setOriginalFile(createFileHandle(fJarPackage.getManifestLocation()));
    if (dialog.open() == Window.OK) {
        fJarPackage.setManifestLocation(dialog.getResult());
        fNewManifestFileText.setText(dialog.getResult().toString());
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.toString()java.lang.String;1
public String toString() {
    return super.toString() + " " + getRevision();
}
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.getRevision()java.lang.String;1
public String getRevision() {
    try {
        return ResourceSyncInfo.getRevision(syncBytes);
    } catch (CVSException e) {
        CVSProviderPlugin.log(e);
        return ResourceSyncInfo.ADDED_REVISION;
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.getRepositoryRelativePath()java.lang.String;1
public String getRepositoryRelativePath() {
    String parentPath = parent.getRepositoryRelativePath();
    return parentPath + Session.SERVER_SEPARATOR + getName();
}

---------------Library-------------------
method: org.eclipse.jface.fieldassist.ControlDecoration.hide()V1
public void hide() {
    if (visible) {
        visible = false;
        hideHover();
        update();
    }
}
method: org.eclipse.jface.fieldassist.ControlDecoration.hideHover()V1
public void hideHover() {
    if (hover != null) {
        hover.setVisible(false);
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.log.EventDetailsDialogAction.setComparator(java.util.Comparator;)V2
public void setComparator(Comparator comparator) {
    this.comparator = comparator;
    if (propertyDialog != null && propertyDialog.isOpen())
        propertyDialog.setComparator(comparator);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.LambdaExpression.compareTo(org.eclipse.equinox.internal.p2.metadata.expression.Expression;)I2
public int compareTo(Expression e) {
    int cmp = super.compareTo(e);
    if (cmp == 0)
        cmp = each.compareTo(((LambdaExpression) e).each);
    return cmp;
}
method: org.eclipse.equinox.internal.p2.metadata.expression.Unary.compareTo(org.eclipse.equinox.internal.p2.metadata.expression.Expression;)I2
public int compareTo(Expression e) {
    int cmp = super.compareTo(e);
    if (cmp == 0)
        cmp = operand.compareTo(((Unary) e).operand);
    return cmp;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.Member.compareTo(org.eclipse.equinox.internal.p2.metadata.expression.Expression;)I2
public int compareTo(Expression e) {
    int cmp = super.compareTo(e);
    if (cmp == 0) {
        cmp = name.compareTo(((Member) e).name);
        if (cmp == 0)
            cmp = compare(argExpressions, ((Member) e).argExpressions);
    }
    return cmp;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.LambdaExpression.compareTo(org.eclipse.equinox.internal.p2.metadata.expression.Expression;)I2
public int compareTo(Expression e) {
    int cmp = super.compareTo(e);
    if (cmp == 0)
        cmp = each.compareTo(((LambdaExpression) e).each);
    return cmp;
}
method: org.eclipse.equinox.internal.p2.metadata.expression.Variable.compareTo(org.eclipse.equinox.internal.p2.metadata.expression.Expression;)I2
public int compareTo(Expression e) {
    int cmp = super.compareTo(e);
    if (cmp == 0)
        cmp = name.compareTo(((Variable) e).name);
    return cmp;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.Member.compareTo(org.eclipse.equinox.internal.p2.metadata.expression.Expression;)I2
public int compareTo(Expression e) {
    int cmp = super.compareTo(e);
    if (cmp == 0) {
        cmp = name.compareTo(((Member) e).name);
        if (cmp == 0)
            cmp = compare(argExpressions, ((Member) e).argExpressions);
    }
    return cmp;
}

---------------Library-------------------
method: org.apache.lucene.index.FilterIndexReader.doClose()V1
@Override
protected void doClose() throws IOException {
    in.close();
}
method: org.apache.lucene.index.IndexReader.close()V1
public final synchronized void close() throws IOException {
    if (!closed) {
        decRef();
        closed = true;
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.EditorMenuManager.setEnabledAllowed(Z)V2
public void setEnabledAllowed(boolean enabledAllowed) {
    if (this.enabledAllowed == enabledAllowed) {
        return;
    }
    this.enabledAllowed = enabledAllowed;
    overrides.updateEnabledAllowed();
}

---------------Library-------------------
method: org.eclipse.ui.internal.ShowFastViewContribution$2.widgetDisposed(org.eclipse.swt.events.DisposeEvent;)V2
@Override
public void widgetDisposed(DisposeEvent e) {
    ref.removePropertyListener(propertyListener);
}
method: org.eclipse.ui.internal.WorkbenchPartReference.removePropertyListener(org.eclipse.ui.IPropertyListener;)V2
@Override
public void removePropertyListener(IPropertyListener listener) {
    if (isDisposed()) {
        return;
    }
    propChangeListeners.remove(listener);
}
---------------Client-------------------
method: org.eclipse.jface.viewers.deferred.BackgroundContentProvider.refresh()V1
public void refresh() {
    if (updator.isDisposed()) {
        return;
    }
    model.requestUpdate(listener);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.memory.renderings.TableRenderingContentProvider.getContentBaseAddress()java.math.BigInteger;1
public BigInteger getContentBaseAddress() {
    return fInput.getContentBaseAddress();
}
method: org.eclipse.debug.internal.ui.views.memory.renderings.TableRenderingContentInput.getContentBaseAddress()java.math.BigInteger;1
public BigInteger getContentBaseAddress() {
    if (fMemoryBlockBaseAddress == null) {
        try {
            updateContentBaseAddress();
        } catch (DebugException e) {
            fMemoryBlockBaseAddress = new  BigInteger("0");
        }
    }
    return fMemoryBlockBaseAddress;
}
---------------Client-------------------
method: org.eclipse.emf.ecore.change.impl.FeatureChangeImpl.getFeatureName()java.lang.String;1
public String getFeatureName() {
    return feature == null ? featureName : feature.getName();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.isCheckMissingImportPackageVersion()Z1
protected boolean isCheckMissingImportPackageVersion() {
    return CompilerFlags.getFlag(fProject, CompilerFlags.P_MISSING_VERSION_IMP_PKG) != CompilerFlags.IGNORE;
}
method: org.eclipse.pde.internal.core.builders.CompilerFlags.getFlag(org.eclipse.core.resources.IProject;java.lang.String;)I2
public static int getFlag(IProject project, String flagId) {
    try {
        return Integer.parseInt(getString(project, flagId));
    } catch (NumberFormatException nfe) {
        return 0;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.hierarchy.ChangeCollector.hasVisibilityChange(org.eclipse.jdt.core.IType;)Z2
private boolean hasVisibilityChange(IType type) throws JavaModelException {
    int existingFlags = this.hierarchy.getCachedFlags(type);
    int newFlags = type.getFlags();
    return existingFlags != newFlags;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.ContributedJavadocWizardPage.createControl(org.eclipse.swt.widgets.Composite;)V2
public void createControl(Composite parent) {
    Control createContents = getPage().createContents(parent);
    setControl(createContents);
}
method: org.eclipse.jdt.internal.ui.javadocexport.ContributedJavadocWizardPage$ErrorJavadocExportWizardPage.createContents(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
@Override
public Control createContents(Composite parent) {
    Label label = new  Label(parent, SWT.NONE);
    label.setText(JavadocExportMessages.ContributedJavadocWizardPage_error_create_page);
    return label;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.ui.internal.markers.OpenPropertyPageResolution.run(org.eclipse.core.resources.IMarker;)V2
@Override
public void run(IMarker marker) {
    UIJob job = new  UIJob(MarkerMessages.OpenPropertyPageResolution_opening_property_page_job_name) {

        @Override
        public IStatus runInUIThread(IProgressMonitor monitor) {
            SWTFactory.showPropertiesDialog(ApiUIPlugin.getShell(), fPageId, fElement, null);
            return Status.OK_STATUS;
        }
    };
    job.setSystem(true);
    job.setPriority(Job.INTERACTIVE);
    job.schedule();
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.swt.ResourceUtility.imageDescriptorFromURI(org.eclipse.emf.common.util.URI;)org.eclipse.jface.resource.ImageDescriptor;2
@Override
public ImageDescriptor imageDescriptorFromURI(URI iconPath) {
    try {
        return ImageDescriptor.createFromURL(new  URL(iconPath.toString()));
    } catch (MalformedURLException e) {
        System.err.println("iconURI \"" + iconPath.toString() + "\" is invalid, no image will be shown");
        return null;
    }
}
method: org.eclipse.jface.resource.ImageDescriptor.createFromURL(java.net.URL;)org.eclipse.jface.resource.ImageDescriptor;1
public static ImageDescriptor createFromURL(URL url) {
    if (url == null) {
        return getMissingImageDescriptor();
    }
    return new  URLImageDescriptor(url);
}
---------------Client-------------------
method: org.eclipse.ltk.internal.core.refactoring.Changes.asCoreException(org.eclipse.jface.text.BadLocationException;)org.eclipse.core.runtime.CoreException;1
public static CoreException asCoreException(BadLocationException e) {
    String message = e.getMessage();
    if (message == null)
        message = "BadLocationException";
    return new  CoreException(new  Status(IStatus.ERROR, RefactoringCorePlugin.getPluginId(), IRefactoringCoreStatusCodes.BAD_LOCATION, message, e));
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.JobListeners.awake(org.eclipse.core.runtime.jobs.Job;)V2
public void awake(Job job) {
    doNotify(awake, newEvent(job));
}
method: org.eclipse.core.internal.jobs.JobListeners.newEvent(org.eclipse.core.runtime.jobs.Job;)org.eclipse.core.internal.jobs.JobChangeEvent;1
static JobChangeEvent newEvent(Job job) {
    JobChangeEvent instance = new  JobChangeEvent();
    instance.job = job;
    return instance;
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory.init(org.eclipse.e4.core.contexts.IEclipseContext;)V2
@PostConstruct
public void init(IEclipseContext context) {
    this.context = context;
    this.context.set(SHARED_ELEMENTS_STORE, new  HashMap<MUIElement, Set<MPlaceholder>>());
}

---------------Library-------------------
method: org.eclipse.pde.ui.templates.AbstractChoiceOption.setValue(java.lang.Object;)V2
public void setValue(Object value) {
    setValue(value, true);
}
method: org.eclipse.pde.ui.templates.AbstractChoiceOption.setValue(java.lang.Object;Z)V3
protected void setValue(Object value, boolean updateControl) {
    super.setValue(value);
    if (updateControl) {
        setOptionValue(value);
    }
}
---------------Client-------------------
method: org.eclipse.text.edits.CopySourceEdit.accept0(org.eclipse.text.edits.TextEditVisitor;)V2
protected void accept0(TextEditVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChildren(visitor);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExceptionAnalyzer.handleExceptions(org.eclipse.jdt.core.dom.IMethodBinding;org.eclipse.jdt.core.dom.ASTNode;)Z3
private boolean handleExceptions(IMethodBinding binding, ASTNode node) {
    if (binding == null)
        return true;
    addExceptions(binding.getExceptionTypes(), node.getAST());
    return true;
}
method: org.eclipse.jdt.internal.corext.refactoring.util.AbstractExceptionAnalyzer.addExceptions(Aorg.eclipse.jdt.core.dom.ITypeBinding;org.eclipse.jdt.core.dom.AST;)V3
protected void addExceptions(ITypeBinding[] exceptions, AST ast) {
    if (exceptions == null)
        return;
    for (int i = 0; i < exceptions.length; i++) {
        addException(exceptions[i], ast);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.surround.ExceptionAnalyzer.handleExceptions(org.eclipse.jdt.core.dom.IMethodBinding;org.eclipse.jdt.core.dom.ASTNode;)Z3
private boolean handleExceptions(IMethodBinding binding, ASTNode node) {
    if (binding == null)
        return true;
    ITypeBinding[] exceptions = binding.getExceptionTypes();
    for (int i = 0; i < exceptions.length; i++) {
        addException(exceptions[i], node.getAST());
    }
    return true;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.CompositeModelProvider.handleChange(org.eclipse.team.core.synchronize.SyncInfo;)V2
protected void handleChange(SyncInfo info) {
    handleRemoval(info.getLocal());
    handleAddition(info);
}
method: org.eclipse.team.internal.ui.synchronize.CompositeModelProvider.handleRemoval(org.eclipse.core.resources.IResource;)V2
protected void handleRemoval(IResource resource) {
    ISynchronizeModelProvider[] providers = getProvidersContaining(resource);
    for (int i = 0; i < providers.length; i++) {
        ISynchronizeModelProvider provider = providers[i];
        removeFromProvider(resource, provider);
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.cheatsheets.registry.RegistryReader.readRegistry(org.eclipse.core.runtime.IExtensionRegistry;java.lang.String;java.lang.String;)V4
void readRegistry(IExtensionRegistry registry, String pluginId, String extensionPoint) {
    IExtensionPoint point = registry.getExtensionPoint(pluginId, extensionPoint);
    if (point != null) {
        IExtension[] extensions = point.getExtensions();
        extensions = orderExtensions(extensions);
        for (int i = 0; i < extensions.length; i++) readExtension(extensions[i]);
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.CVSSyncInfo.getLocalContentIdentifier()java.lang.String;1
public String getLocalContentIdentifier() {
    ResourceSyncInfo info = getSyncInfoForLocal(getCVSFile());
    return info != null ? info.getRevision() : null;
}
method: org.eclipse.team.internal.ccvs.core.CVSSyncInfo.getSyncInfoForLocal(org.eclipse.team.internal.ccvs.core.ICVSFile;)org.eclipse.team.internal.ccvs.core.syncinfo.ResourceSyncInfo;1
private static ResourceSyncInfo getSyncInfoForLocal(ICVSFile cvsFile) {
    if (cvsFile == null)
        return null;
    try {
        return cvsFile.getSyncInfo();
    } catch (CVSException e) {
        CVSProviderPlugin.log(e);
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.pde.ui.templates.AbstractChoiceOption.getChoice()java.lang.String;1
public String getChoice() {
    return getValue() != null ? getValue().toString() : null;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTNode.postLazyInit(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ChildPropertyDescriptor;)V3
final void postLazyInit(ASTNode newChild, ChildPropertyDescriptor property) {
    newChild.setParent(this, property);
    this.ast.reenableEvents();
}
method: org.eclipse.jdt.core.dom.ASTNode.setParent(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;)V3
final void setParent(ASTNode parent, StructuralPropertyDescriptor property) {
    this.ast.modifying();
    this.parent = parent;
    this.location = property;
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.ProgressIndicator.beginAnimatedTask()V1
public void beginAnimatedTask() {
    done();
    layout.topControl = indeterminateProgressBar;
    layout();
    animated = true;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering$5.handlePresentationFailure(org.eclipse.debug.internal.ui.viewers.model.provisional.IStatusMonitor;org.eclipse.core.runtime.IStatus;)V3
@Override
public void handlePresentationFailure(IStatusMonitor monitor, IStatus status) {
    showMessage(status.getMessage());
}
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering.showMessage(java.lang.String;)V2
protected void showMessage(final String message) {
    fSwitchPageJob.setShowMessagePage(true);
    fSwitchPageJob.setMessage(message);
    fSwitchPageJob.schedule();
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering$1.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
@Override
public void selectionChanged(SelectionChangedEvent event) {
    updateSyncTopAddress(getTopVisibleAddress());
    updateSyncSelectedAddress(getSelectedAddress());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.memory.MemoryViewSynchronizationService.getSynchronizedProperty(org.eclipse.debug.core.model.IMemoryBlock;java.lang.String;)java.lang.Object;3
public Object getSynchronizedProperty(IMemoryBlock memoryBlock, String propertyId) {
    SynchronizeInfo info = fSynchronizeInfo.get(memoryBlock);
    if (info != null) {
        Object value = info.getProperty(propertyId);
        return value;
    }
    return null;
}
method: org.eclipse.debug.internal.ui.views.memory.SynchronizeInfo.getProperty(java.lang.String;)java.lang.Object;2
public Object getProperty(String propertyId) {
    if (propertyId == null)
        return null;
    Object value = fProperties.get(propertyId);
    return value;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.LRUCache.get(java.lang.Object;)java.lang.Object;2
public Object get(Object key) {
    LRUCacheEntry entry = (LRUCacheEntry) this.entryTable.get(key);
    if (entry == null) {
        return null;
    }
    updateTimestamp(entry);
    return entry.value;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.ContributedJavadocWizardPage.dispose()V1
@Override
public void dispose() {
    if (fPage != null) {
        fPage.dispose();
        fPage = null;
    }
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
method: org.eclipse.core.internal.runtime.InternalPlatform.stopServices()V1
private void stopServices() {
    if (legacyPreferencesService != null) {
        legacyPreferencesService.unregister();
        legacyPreferencesService = null;
    }
    if (customPreferencesService != null) {
        customPreferencesService.unregister();
        customPreferencesService = null;
    }
}

---------------Library-------------------
method: org.eclipse.emf.common.notify.impl.AdapterFactoryImpl.adaptNew(org.eclipse.emf.common.notify.Notifier;java.lang.Object;)org.eclipse.emf.common.notify.Adapter;3
public Adapter adaptNew(Notifier target, Object type) {
    Adapter adapter = createAdapter(target, type);
    associate(adapter, target);
    return adapter;
}
method: org.eclipse.emf.common.notify.impl.AdapterFactoryImpl.associate(org.eclipse.emf.common.notify.Adapter;org.eclipse.emf.common.notify.Notifier;)V3
protected void associate(Adapter adapter, Notifier target) {
    if (adapter != null) {
        target.eAdapters().add(adapter);
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.intro.impl.model.util.ModelUtil.createAndAppendChild(org.w3c.dom.Element;java.lang.String;java.util.Properties;)org.w3c.dom.Element;3
public static Element createAndAppendChild(Element parentElement, String elementName, Properties attributes) {
    Element element = createElement(parentElement.getOwnerDocument(), elementName, attributes);
    parentElement.appendChild(element);
    return element;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.category.CategorySection.initialize()V1
public void initialize() {
    refresh();
    FeatureModelManager mng = PDECore.getDefault().getFeatureModelManager();
    mng.addFeatureModelListener(this);
}
method: org.eclipse.pde.internal.core.PDECore.getFeatureModelManager()org.eclipse.pde.internal.core.FeatureModelManager;1
public synchronized FeatureModelManager getFeatureModelManager() {
    if (fFeatureModelManager == null)
        fFeatureModelManager = new  FeatureModelManager();
    return fFeatureModelManager;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.CompareInputChangeNotifier.fireChanges(Aorg.eclipse.compare.structuremergeviewer.ICompareInput;)V2
protected void fireChanges(ICompareInput[] inputs) {
    for (int i = 0; i < inputs.length; i++) {
        ICompareInput input = inputs[i];
        fireChange(input);
    }
}
method: org.eclipse.team.internal.ui.mapping.CompareInputChangeNotifier.fireChange(org.eclipse.compare.structuremergeviewer.ICompareInput;)V2
protected void fireChange(ICompareInput input) {
    if (input instanceof AbstractCompareInput) {
        AbstractCompareInput ci = (AbstractCompareInput) input;
        ci.update();
    }
}
---------------Client-------------------
method: org.eclipse.search.ui.text.AbstractTextSearchViewPage.updateFilterActions(Aorg.eclipse.jface.action.IAction;)V2
private void updateFilterActions(IAction[] filterActions) {
    if (filterActions != null) {
        for (int i = 0; i < filterActions.length; i++) {
            IAction curr = filterActions[i];
            if (curr instanceof IUpdate) {
                ((IUpdate) curr).update();
            }
        }
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.EclipseResource.getSyncInfo()org.eclipse.team.internal.ccvs.core.syncinfo.ResourceSyncInfo;1
public ResourceSyncInfo getSyncInfo() throws CVSException {
    return EclipseSynchronizer.getInstance().getResourceSync(resource);
}
method: org.eclipse.team.internal.ccvs.core.resources.EclipseSynchronizer.getResourceSync(org.eclipse.core.resources.IResource;)org.eclipse.team.internal.ccvs.core.syncinfo.ResourceSyncInfo;2
public ResourceSyncInfo getResourceSync(IResource resource) throws CVSException {
    byte[] info = getSyncBytes(resource);
    if (info == null)
        return null;
    return new  ResourceSyncInfo(info);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.ImportFromInstallationPage$1.call()java.lang.Boolean;1
public Boolean call() throws Exception {
    Display.getDefault().syncExec(new  Runnable() {

        public void run() {
            validated = ImportFromInstallationPage.super.validateDestinationGroup();
        }
    });
    return validated;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumePrimitiveType()V1
protected void consumePrimitiveType() {
    pushOnIntStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.ui.internal.decorators.DecoratorManager.update(java.lang.String;)V2
@Override
public void update(String decoratorId) {
    IBaseLabelProvider provider = getBaseLabelProvider(decoratorId);
    if (provider != null) {
        scheduler.clearResults();
        fireListeners(new  LabelProviderChangedEvent(provider));
    }
}
method: org.eclipse.ui.internal.decorators.DecorationScheduler.clearResults()V1
void clearResults() {
    if (clearJob == null) {
        clearJob = getClearJob();
    }
    clearJob.schedule();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.NewAnnotationCreationWizard.addPages()V1
@Override
public void addPages() {
    super.addPages();
    if (fPage == null) {
        fPage = new  NewAnnotationWizardPage();
        fPage.init(getSelection());
    }
    addPage(fPage);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering$12.getLabel(java.lang.Object;)java.lang.String;2
@Override
public String getLabel(Object o) {
    return AbstractAsyncTableRendering.this.getLabel();
}
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering.getLabel()java.lang.String;1
@Override
public String getLabel() {
    if (fLabel == null) {
        fLabel = DebugUIMessages.AbstractAsyncTableRendering_1;
        updateRenderingLabel(isVisible());
    }
    return fLabel;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.CaptureBinding.genericTypeSignature()AC1
public char[] genericTypeSignature() {
    if (this.genericTypeSignature == null) {
        this.genericTypeSignature = CharOperation.concat(TypeConstants.WILDCARD_CAPTURE, this.wildcard.genericTypeSignature());
    }
    return this.genericTypeSignature;
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.AptPlugin.stop(org.osgi.framework.BundleContext;)V2
public void stop(BundleContext context) throws Exception {
    super.stop(context);
}
method: org.eclipse.core.runtime.Plugin.stop(org.osgi.framework.BundleContext;)V2
public void stop(BundleContext context) throws Exception {
    if (this.debugTracker != null) {
        this.debugTracker.close();
        this.debugTracker = null;
    }
}
---------------Client-------------------
method: org.eclipse.debug.internal.core.InputStreamMonitor.close()V1
public void close() {
    if (fThread != null) {
        Thread thread = fThread;
        fThread = null;
        thread.interrupt();
    }
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
method: org.eclipse.ui.internal.console.ConsoleDropDownAction.dispose()V1
@Override
public void dispose() {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fView = null;
    ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.templates.TemplateSelectionPage.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.builder.Reference.fieldReference(org.eclipse.pde.api.tools.internal.provisional.model.IApiMember;java.lang.String;java.lang.String;I)org.eclipse.pde.api.tools.internal.builder.Reference;4
public static Reference fieldReference(IApiMember origin, String typeName, String fieldName, int kind) {
    return fieldReference(origin, typeName, fieldName, kind, 0);
}
method: org.eclipse.pde.api.tools.internal.builder.Reference.fieldReference(org.eclipse.pde.api.tools.internal.provisional.model.IApiMember;java.lang.String;java.lang.String;II)org.eclipse.pde.api.tools.internal.builder.Reference;5
public static Reference fieldReference(IApiMember origin, String typeName, String fieldName, int kind, int flags) {
    Reference ref = new  Reference();
    ref.fSourceMember = origin;
    ref.fTypeName = typeName;
    ref.fMemberName = fieldName;
    ref.fKind = kind;
    ref.fType = IReference.T_FIELD_REFERENCE;
    ref.fFlags = flags;
    return ref;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.builder.Reference.typeReference(org.eclipse.pde.api.tools.internal.provisional.model.IApiMember;java.lang.String;java.lang.String;II)org.eclipse.pde.api.tools.internal.builder.Reference;5
public static Reference typeReference(IApiMember origin, String typeName, String signature, int kind, int flags) {
    Reference ref = new  Reference();
    ref.fSourceMember = origin;
    ref.fTypeName = typeName;
    ref.fKind = kind;
    ref.fType = IReference.T_TYPE_REFERENCE;
    ref.fSignature = signature;
    ref.fFlags = flags;
    return ref;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.schema.SchemaSpecSection$1.textValueChanged(org.eclipse.pde.internal.ui.parts.FormEntry;)V2
public void textValueChanged(FormEntry text) {
    schema.setPluginId(text.getValue());
}
method: org.eclipse.pde.internal.core.schema.Schema.setPluginId(java.lang.String;)V2
public void setPluginId(String newId) {
    String oldValue = fPluginID;
    fPluginID = newId;
    fireModelObjectChanged(this, P_PLUGIN, oldValue, newId);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.schema.SchemaAttribute.setBasedOn(java.lang.String;)V2
public void setBasedOn(String newBasedOn) {
    String oldValue = basedOn;
    basedOn = newBasedOn;
    getSchema().fireModelObjectChanged(this, P_BASED_ON, oldValue, basedOn);
}

---------------Library-------------------
method: org.eclipse.core.resources.refresh.RefreshProvider.createPollingMonitor(org.eclipse.core.resources.IResource;)org.eclipse.core.resources.refresh.IRefreshMonitor;2
protected IRefreshMonitor createPollingMonitor(IResource resource) {
    return super.createPollingMonitor(resource);
}
method: org.eclipse.core.internal.refresh.InternalRefreshProvider.createPollingMonitor(org.eclipse.core.resources.IResource;)org.eclipse.core.resources.refresh.IRefreshMonitor;2
protected IRefreshMonitor createPollingMonitor(IResource resource) {
    PollingMonitor monitor = ((Workspace) resource.getWorkspace()).getRefreshManager().monitors.pollMonitor;
    monitor.monitor(resource);
    return monitor;
}
---------------Client-------------------
method: org.eclipse.core.internal.watson.ElementTree.getParent()org.eclipse.core.internal.watson.ElementTree;1
public ElementTree getParent() {
    DeltaDataTree parentTree = tree.getParent();
    if (parentTree == null) {
        return null;
    }
    return (ElementTree) parentTree.getData(tree.rootKey());
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IContainer;2
public IContainer[] findContainersForLocationURI(URI location) {
    return findContainersForLocationURI(location, NONE);
}
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;I)Aorg.eclipse.core.resources.IContainer;3
public IContainer[] findContainersForLocationURI(URI location, int memberFlags) {
    if (!location.isAbsolute())
        throw new  IllegalArgumentException();
    return (IContainer[]) getLocalManager().allResourcesFor(location, false, memberFlags);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findFilesForLocationURI(java.net.URI;I)Aorg.eclipse.core.resources.IFile;3
public IFile[] findFilesForLocationURI(URI location, int memberFlags) {
    if (!location.isAbsolute())
        throw new  IllegalArgumentException();
    return (IFile[]) getLocalManager().allResourcesFor(location, true, memberFlags);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeForInit()V1
protected void consumeForInit() {
    pushOnAstLengthStack(-1);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyEnumDeclarations()V1
protected void consumeEmptyEnumDeclarations() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.product.UpdatesSection.refresh()V1
@Override
public void refresh() {
    fRepositoryTable.refresh();
    updateButtons();
    super.refresh();
}
method: org.eclipse.ui.forms.AbstractFormPart.refresh()V1
public void refresh() {
    stale = false;
    dirty = false;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.ProjectApiDescription.clean()V1
public synchronized void clean() {
    fPackageMap.clear();
    fPackageTimeStamp = -1L;
    fInSynch = false;
    modified();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.Initializer;)V2
@Override
public void endVisit(Initializer node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getBody());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.core.internal.runtime.AdapterManager.unregisterAllAdapters()V1
public synchronized void unregisterAllAdapters() {
    factories.clear();
    flushLookup();
}
method: org.eclipse.core.internal.runtime.AdapterManager.flushLookup()V1
public synchronized void flushLookup() {
    adapterLookup = null;
    classLookup = null;
    classSearchOrderLookup = null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.PullUpMethodPage$PullUpHierarchyContentProvider.dispose()V1
public void dispose() {
    fHierarchy = null;
    fTypeToMemberArray.clear();
    fTypeToMemberArray = null;
    fDeclaringType = null;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.dialogs.ResourceMappingResourceDisplayArea$ResourceTraversalElement.isTraversalRoot(org.eclipse.core.resources.IResource;)Z2
private boolean isTraversalRoot(IResource resource) {
    return ResourceMappingResourceDisplayArea.isTraversalRoot(traversal, resource);
}
method: org.eclipse.team.internal.ui.dialogs.ResourceMappingResourceDisplayArea.isTraversalRoot(org.eclipse.core.resources.mapping.ResourceTraversal;org.eclipse.core.resources.IResource;)Z2
static boolean isTraversalRoot(ResourceTraversal traversal, IResource resource) {
    IResource[] resources = traversal.getResources();
    for (int i = 0; i < resources.length; i++) {
        IResource root = resources[i];
        if (root.equals(resource)) {
            return true;
        }
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.MoveInstanceMethodProcessor.getTargetIndex()I1
protected final int getTargetIndex() {
    final IVariableBinding[] targets = getPossibleTargets();
    int result = -1;
    for (int index = 0; index < targets.length; index++) {
        if (Bindings.equals(fTarget, targets[index])) {
            result = index;
            break;
        }
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.pde.launching.AbstractPDELaunchConfiguration.manageLaunch(org.eclipse.debug.core.ILaunch;)V2
protected void manageLaunch(ILaunch launch) {
    PDELaunchingPlugin.getDefault().getLaunchListener().manage(launch);
}
method: org.eclipse.pde.internal.launching.launcher.LaunchListener.manage(org.eclipse.debug.core.ILaunch;)V2
public void manage(ILaunch launch) {
    if (managedLaunches.size() == 0)
        hookListener(true);
    if (!managedLaunches.contains(launch))
        managedLaunches.add(launch);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.ViewPaneRenderingMgr.removeMemoryBlockRendering(org.eclipse.debug.ui.memory.IMemoryRendering;)V2
public void removeMemoryBlockRendering(IMemoryRendering rendering) {
    if (rendering == null) {
        return;
    }
    if (!fRenderings.contains(rendering)) {
        return;
    }
    fRenderings.remove(rendering);
    if (fRenderings.size() == 0) {
        DebugPlugin.getDefault().removeDebugEventListener(this);
    }
    storeRenderings();
}

---------------Library-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.displayHelp(org.eclipse.help.IContext;II)V4
@Deprecated
@Override
public void displayHelp(IContext context, int x, int y) {
    displayContext(context, x, y);
}
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem$CompatibilityIHelpImplementation.displayContext(org.eclipse.help.IContext;II)V4
@Deprecated
@Override
public void displayContext(IContext context, int x, int y) {
    AbstractHelpUI helpUI = getHelpUI();
    if (helpUI != null) {
        helpUI.displayContext(context, x, y);
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.properties.PropertyBucket.load(java.lang.String;java.io.File;Z)V4
public void load(String newProjectName, File baseLocation, boolean force) throws CoreException {
    qualifierIndex.clear();
    super.load(newProjectName, baseLocation, force);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMImport.getDetailedNode()org.eclipse.jdt.internal.core.jdom.DOMNode;1
protected DOMNode getDetailedNode() {
    return (DOMNode) getFactory().createImport(getContents());
}
method: org.eclipse.jdt.core.jdom.DOMFactory.createImport(java.lang.String;)org.eclipse.jdt.core.jdom.IDOMImport;2
public IDOMImport createImport(String sourceCode) {
    if (sourceCode == null) {
        return null;
    }
    return (new  DOMBuilder()).createImport(sourceCode.toCharArray());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMethod.getRawParameterNames()Ajava.lang.String;1
public String[] getRawParameterNames() throws JavaModelException {
    IBinaryMethod info = (IBinaryMethod) getElementInfo();
    int paramCount = Signature.getParameterCount(new  String(info.getMethodDescriptor()));
    return getRawParameterNames(paramCount);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.viewsupport.ColoredViewersManager$1.run()V1
public void run() {
    updateAllViewers();
}
method: org.eclipse.jdt.internal.ui.viewsupport.ColoredViewersManager.updateAllViewers()V1
protected final void updateAllViewers() {
    for (Iterator<ColoringLabelProvider> iterator = fManagedLabelProviders.iterator(); iterator.hasNext(); ) {
        ColoringLabelProvider lp = iterator.next();
        lp.update();
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.dialogs.ProjectLinkedResourcePage$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    TabFolder source = (TabFolder) e.getSource();
    if (source.getSelectionIndex() == 1)
        switchToLinkedResources();
    else
        switchToPathVariables();
}

---------------Library-------------------
method: org.eclipse.debug.core.model.RuntimeProcess.fireCreationEvent()V1
protected void fireCreationEvent() {
    fireEvent(new  DebugEvent(this, DebugEvent.CREATE));
}
method: org.eclipse.debug.core.model.RuntimeProcess.fireEvent(org.eclipse.debug.core.DebugEvent;)V2
protected void fireEvent(DebugEvent event) {
    DebugPlugin manager = DebugPlugin.getDefault();
    if (manager != null) {
        manager.fireDebugEventSet(new DebugEvent[] { event });
    }
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.actions.expressions.EnableWatchExpressionAction.fireWatchExpressionChanged(org.eclipse.debug.core.model.IWatchExpression;)V2
private void fireWatchExpressionChanged(IWatchExpression expression) {
    DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { new  DebugEvent(expression, DebugEvent.CHANGE) });
}

---------------Library-------------------
method: org.eclipse.ant.core.AntCorePlugin.getNewClassLoader(Z)java.lang.ClassLoader;2
public ClassLoader getNewClassLoader(boolean allowLoading) {
    AntCorePreferences corePreferences = getPreferences();
    URL[] urls = corePreferences.getURLs();
    return getNewClassLoader(allowLoading, urls);
}
method: org.eclipse.ant.core.AntCorePlugin.getNewClassLoader(ZAjava.net.URL;)java.net.URLClassLoader;3
public URLClassLoader getNewClassLoader(boolean allowLoading, URL[] urls) {
    AntCorePreferences corePreferences = getPreferences();
    ClassLoader[] pluginLoaders = corePreferences.getPluginClassLoaders();
    AntClassLoader loader = new  AntClassLoader(urls, pluginLoaders);
    loader.allowPluginClassLoadersToLoadAnt(allowLoading);
    return loader;
}
---------------Client-------------------
method: org.eclipse.jface.resource.FontDescriptor.copy(org.eclipse.swt.graphics.FontData;)org.eclipse.swt.graphics.FontData;1
public static FontData copy(FontData next) {
    FontData result = new  FontData(next.getName(), next.getHeight(), next.getStyle());
    result.setLocale(next.getLocale());
    return result;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.JUnitClasspathFixProcessor$JUnitClasspathFixProposal.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_LIBRARY);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.IntroduceIndirectionRefactoring.updateIntermediaryVisibility(org.eclipse.jdt.internal.corext.refactoring.code.IntroduceIndirectionRefactoring$NoOverrideProgressMonitor;)org.eclipse.ltk.core.refactoring.RefactoringStatus;2
private RefactoringStatus updateIntermediaryVisibility(NoOverrideProgressMonitor monitor) throws JavaModelException {
    return rewriteVisibility(fIntermediaryAdjustments, fRewrites, monitor);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.IntroduceIndirectionRefactoring.rewriteVisibility(java.util.Map;java.util.Map;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.ltk.core.refactoring.RefactoringStatus;4
private RefactoringStatus rewriteVisibility(Map<IMember, IncomingMemberVisibilityAdjustment> adjustments, Map<ICompilationUnit, CompilationUnitRewrite> rewrites, IProgressMonitor monitor) throws JavaModelException {
    RefactoringStatus status = new  RefactoringStatus();
    fAdjustor.setRewrites(rewrites);
    fAdjustor.setAdjustments(adjustments);
    fAdjustor.setStatus(status);
    fAdjustor.rewriteVisibility(monitor);
    return status;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.util.TarEntry.clone()java.lang.Object;1
@Override
public Object clone() {
    TarEntry entry = new  TarEntry(this.name, this.filepos);
    entry.setFileType(this.type);
    entry.setMode(this.mode);
    entry.setSize(this.size);
    entry.setTime(this.time);
    return entry;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.util.PluginWorkingSet$WorkingSetLabelProvider.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.AntUIPlugin.getDialogSettingsSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
public IDialogSettings getDialogSettingsSection(String name) {
    IDialogSettings dialogSettings = getDialogSettings();
    IDialogSettings section = dialogSettings.getSection(name);
    if (section == null) {
        section = dialogSettings.addNewSection(name);
    }
    return section;
}
method: org.eclipse.jface.dialogs.DialogSettings.addNewSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
@Override
public IDialogSettings addNewSection(String sectionName) {
    DialogSettings section = new  DialogSettings(sectionName);
    addSection(section);
    return section;
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.readState(java.io.DataInputStream;)org.eclipse.osgi.service.resolver.State;2
public State readState(DataInputStream stream) throws IOException {
    return internalReadStateDeprecated(internalCreateState(), stream, -1);
}
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.internalCreateState()org.eclipse.osgi.internal.resolver.StateImpl;1
private StateImpl internalCreateState() {
    StateImpl state = new  UserState();
    state.setFactory(this);
    return state;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.CheckoutAsMainPage.createRadioButton(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Button;4
protected Button createRadioButton(Composite parent, String label, int span) {
    Button radio = super.createRadioButton(parent, label, span);
    radio.addSelectionListener(new  SelectionAdapter() {

        public void widgetSelected(SelectionEvent e) {
            updateEnablements();
        }
    });
    return radio;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.comp.CompCSObject.getCompCS()org.eclipse.pde.internal.ua.core.icheatsheet.comp.ICompCS;1
public ICompCS getCompCS() {
    return fModel.getCompCS();
}
method: org.eclipse.pde.internal.ua.core.cheatsheet.comp.CompCSModel.getCompCS()org.eclipse.pde.internal.ua.core.icheatsheet.comp.ICompCS;1
public ICompCS getCompCS() {
    if (fCompCS == null) {
        fCompCS = getFactory().createCompCS();
    }
    return fCompCS;
}
---------------Client-------------------
method: org.eclipse.team.ui.synchronize.ParticipantPageCompareEditorInput.getTitleImage()org.eclipse.swt.graphics.Image;1
public Image getTitleImage() {
    if (titleImage == null) {
        titleImage = participant.getImageDescriptor().createImage();
    }
    return titleImage;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskDetails.hookListeners()V1
public void hookListeners() {
    createListenersNameEntry();
    createListenersPathEntry();
    createListenersSkipButton();
    fEnclosingTextSection.hookListeners();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskDetails.createListenersNameEntry()V1
private void createListenersNameEntry() {
    fNameEntry.setFormEntryListener(new  FormEntryAdapter(this) {

        public void textValueChanged(FormEntry entry) {
            if (fDataTask == null) {
                return;
            }
            fDataTask.setFieldName(fNameEntry.getValue());
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskDetails.hookListeners()V1
public void hookListeners() {
    createListenersNameEntry();
    createListenersPathEntry();
    createListenersSkipButton();
    fEnclosingTextSection.hookListeners();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskDetails.createListenersPathEntry()V1
private void createListenersPathEntry() {
    fPathEntry.setFormEntryListener(new  FormEntryAdapter(this) {

        public void browseButtonSelected(FormEntry entry) {
            if (fDataTask == null) {
                return;
            }
            handleButtonEventPathEntry(entry);
        }

        public void linkActivated(HyperlinkEvent e) {
            if (fDataTask == null) {
                return;
            }
            handleLinkEventPathEntry(convertPathRelativeToAbs(fPathEntry.getValue(), fDataTask.getModel().getUnderlyingResource().getFullPath().toPortableString()));
        }

        public void textValueChanged(FormEntry entry) {
            if (fDataTask == null) {
                return;
            }
            handleTextEventPathEntry(entry.getValue());
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskDetails.hookListeners()V1
public void hookListeners() {
    createListenersNameEntry();
    createListenersPathEntry();
    createListenersSkipButton();
    fEnclosingTextSection.hookListeners();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskDetails.createListenersSkipButton()V1
private void createListenersSkipButton() {
    fSkip.addSelectionListener(new  SelectionAdapter() {

        public void widgetSelected(SelectionEvent e) {
            if (fDataTask == null) {
                return;
            }
            fDataTask.setFieldSkip(fSkip.getSelection());
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.views.AllTopicsPart$1.treeExpanded(org.eclipse.jface.viewers.TreeExpansionEvent;)V2
public void treeExpanded(TreeExpansionEvent event) {
    postUpdate(event.getElement());
}
method: org.eclipse.help.ui.internal.views.HyperlinkTreePart.postUpdate(java.lang.Object;)V2
protected void postUpdate(final Object obj) {
    treeViewer.getControl().getDisplay().asyncExec(new  Runnable() {

        public void run() {
            treeViewer.update(obj, null);
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;4
public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<? super T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third, fourth);
}
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;4
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(4);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    return allOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;4
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    return anyOf(matchers);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.chooseSuperClass()org.eclipse.jdt.core.IType;1
protected IType chooseSuperClass() {
    IJavaProject project = getJavaProject();
    if (project == null) {
        return null;
    }
    IJavaElement[] elements = new IJavaElement[] { project };
    IJavaSearchScope scope = SearchEngine.createJavaSearchScope(elements);
    FilteredTypesSelectionDialog dialog = new  FilteredTypesSelectionDialog(getShell(), false, getWizard().getContainer(), scope, IJavaSearchConstants.CLASS);
    dialog.setTitle(NewWizardMessages.NewTypeWizardPage_SuperClassDialog_title);
    dialog.setMessage(NewWizardMessages.NewTypeWizardPage_SuperClassDialog_message);
    dialog.setInitialPattern(getSuperClass());
    if (dialog.open() == Window.OK) {
        return (IType) dialog.getFirstResult();
    }
    return null;
}
method: org.eclipse.jdt.ui.wizards.NewContainerWizardPage.getJavaProject()org.eclipse.jdt.core.IJavaProject;1
public IJavaProject getJavaProject() {
    IPackageFragmentRoot root = getPackageFragmentRoot();
    if (root != null) {
        return root.getJavaProject();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.chooseEnclosingType()org.eclipse.jdt.core.IType;1
protected IType chooseEnclosingType() {
    IPackageFragmentRoot root = getPackageFragmentRoot();
    if (root == null) {
        return null;
    }
    IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { root });
    FilteredTypesSelectionDialog dialog = new  FilteredTypesSelectionDialog(getShell(), false, getWizard().getContainer(), scope, IJavaSearchConstants.TYPE);
    dialog.setTitle(NewWizardMessages.NewTypeWizardPage_ChooseEnclosingTypeDialog_title);
    dialog.setMessage(NewWizardMessages.NewTypeWizardPage_ChooseEnclosingTypeDialog_description);
    dialog.setInitialPattern(Signature.getSimpleName(getEnclosingTypeText()));
    if (dialog.open() == Window.OK) {
        return (IType) dialog.getFirstResult();
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.value.DuplexingObservableValue.addValueChangeListener(org.eclipse.core.databinding.observable.value.IValueChangeListener;)V2
public synchronized void addValueChangeListener(IValueChangeListener listener) {
    super.addValueChangeListener(listener);
    computeValueForListeners();
}
method: org.eclipse.core.databinding.observable.value.DuplexingObservableValue.computeValueForListeners()V1
private void computeValueForListeners() {
    getRealm().exec(new  Runnable() {

        public void run() {
            if (hasListeners()) {
                getValue();
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.viewers.StructuredViewer.addDragSupport(IAorg.eclipse.swt.dnd.Transfer;org.eclipse.swt.dnd.DragSourceListener;)V4
public void addDragSupport(int operations, Transfer[] transferTypes, DragSourceListener listener) {
    Control myControl = getControl();
    final DragSource dragSource = new  DragSource(myControl, operations);
    dragSource.setTransfer(transferTypes);
    dragSource.addDragListener(listener);
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;5
public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third, fourth, fifth);
}
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;5
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    return anyOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;5
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(5);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    return allOf(matchers);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.feature.PortabilitySection.refresh()V1
public void refresh() {
    setValue(IEnvironment.P_OS);
    setValue(IEnvironment.P_WS);
    setValue(IEnvironment.P_ARCH);
    setValue(IEnvironment.P_NL);
    super.refresh();
}
method: org.eclipse.ui.forms.AbstractFormPart.refresh()V1
public void refresh() {
    stale = false;
    dirty = false;
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.launchConfigurations.ExternalToolsMainTab.initializeFrom(org.eclipse.debug.core.ILaunchConfiguration;)V2
@Override
public void initializeFrom(ILaunchConfiguration configuration) {
    fInitializing = true;
    updateLocation(configuration);
    updateWorkingDirectory(configuration);
    updateArgument(configuration);
    fInitializing = false;
    setDirty(false);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.AbstractTreeViewerAdvisor.hasChange(Z)Z2
protected boolean hasChange(boolean next) {
    return hasChange((TreeViewer) getViewer(), next);
}
method: org.eclipse.team.internal.ui.synchronize.AbstractTreeViewerAdvisor.hasChange(org.eclipse.jface.viewers.TreeViewer;Z)Z2
private static boolean hasChange(TreeViewer viewer, boolean next) {
    TreeItem item = getCurrentItem(viewer);
    if (item != null) {
        return hasNextPrev(viewer, item, next);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExceptionAnalyzer.visit(org.eclipse.jdt.core.dom.MethodInvocation;)Z2
@Override
public boolean visit(MethodInvocation node) {
    return handleExceptions((IMethodBinding) node.getName().resolveBinding(), node);
}

---------------Library-------------------
method: org.eclipse.pde.ui.launcher.TestTab.dispose()V1
public void dispose() {
    junitLaunchTab.dispose();
}
method: org.eclipse.jdt.junit.launcher.JUnitLaunchConfigurationTab.dispose()V1
@Override
public void dispose() {
    super.dispose();
    fTestIcon.dispose();
    fJavaElementLabelProvider.dispose();
}
---------------Client-------------------
method: org.apache.batik.util.gui.MemoryMonitor$CloseButtonAction.actionPerformed(java.awt.event.ActionEvent;)V2
public void actionPerformed(ActionEvent e) {
    panel.getRepaintThread().safeSuspend();
    dispose();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;)V2
@Override
public void endVisit(AnnotationTypeDeclaration node) {
    if (skipNode(node))
        return;
    GenericSequentialFlowInfo info = processSequential(node, node.bodyDeclarations());
    info.setNoReturn();
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.processSequential(org.eclipse.jdt.core.dom.ASTNode;java.util.List;)org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;3
protected GenericSequentialFlowInfo processSequential(ASTNode parent, List<? extends ASTNode> nodes) {
    GenericSequentialFlowInfo result = createSequential(parent);
    process(result, nodes);
    return result;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.LabeledStatement;)V2
@Override
public void endVisit(LabeledStatement node) {
    if (skipNode(node))
        return;
    FlowInfo info = assignFlowInfo(node, node.getBody());
    if (info != null)
        info.removeLabel(node.getLabel());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.visit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;)Z2
@Override
public boolean visit(AnnotationTypeDeclaration node) {
    if (node.getJavadoc() != null) {
        node.getJavadoc().accept(this);
    }
    printModifiers(node.modifiers());
    this.fBuffer.append("@interface ");
    node.getName().accept(this);
    this.fBuffer.append(" {");
    for (Iterator<BodyDeclaration> it = node.bodyDeclarations().iterator(); it.hasNext(); ) {
        BodyDeclaration d = it.next();
        d.accept(this);
    }
    this.fBuffer.append("}");
    return false;
}
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.printModifiers(java.util.List;)V2
private void printModifiers(List<IExtendedModifier> ext) {
    for (Iterator<IExtendedModifier> it = ext.iterator(); it.hasNext(); ) {
        ASTNode p = (ASTNode) it.next();
        p.accept(this);
        this.fBuffer.append(" ");
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.dom.ASTFlattener.visit(org.eclipse.jdt.core.dom.ForStatement;)Z2
@Override
public boolean visit(ForStatement node) {
    this.fBuffer.append("for (");
    for (Iterator<Expression> it = node.initializers().iterator(); it.hasNext(); ) {
        Expression e = it.next();
        e.accept(this);
    }
    this.fBuffer.append("; ");
    if (node.getExpression() != null) {
        node.getExpression().accept(this);
    }
    this.fBuffer.append("; ");
    for (Iterator<Expression> it = node.updaters().iterator(); it.hasNext(); ) {
        Expression e = it.next();
        e.accept(this);
    }
    this.fBuffer.append(") ");
    node.getBody().accept(this);
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.debug.ui.launchConfigurations.AppletMainTab.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_CLASS);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.model.IntroPartPresentation.registryChanged(org.eclipse.core.runtime.IRegistryChangeEvent;)V2
public void registryChanged(IRegistryChangeEvent event) {
    if (implementation != null)
        implementation.registryChanged(event);
}
method: org.eclipse.ui.internal.intro.impl.model.AbstractIntroPartImplementation.registryChanged(org.eclipse.core.runtime.IRegistryChangeEvent;)V2
public void registryChanged(IRegistryChangeEvent event) {
    history.clear();
    handleRegistryChanged(event);
}
---------------Client-------------------
method: org.eclipse.core.internal.filebuffers.FileStoreTextFileBuffer.connected()V1
protected void connected() {
    super.connected();
    if (fAnnotationModel != null)
        fAnnotationModel.connect(fDocument);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticEnumValuesMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticEnumValuesMethod(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForEnumValues(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.ui.views.contentoutline.ContentOutline.setSelection(org.eclipse.jface.viewers.ISelection;)V2
public void setSelection(ISelection selection) {
    getSelectionProvider().setSelection(selection);
}
method: org.eclipse.ui.part.PageBookView$SelectionProvider.setSelection(org.eclipse.jface.viewers.ISelection;)V2
@Override
public void setSelection(ISelection selection) {
    IPage currentPage = getCurrentPage();
    if (currentPage == null) {
        return;
    }
    IPageSite site = getPageSite(currentPage);
    if (site == null) {
        return;
    }
    ISelectionProvider selProvider = site.getSelectionProvider();
    if (selProvider != null) {
        selProvider.setSelection(selection);
    }
}
---------------Client-------------------
method: org.eclipse.ui.activities.ActivitiesPreferencePage.performDefaults()V1
@Override
protected void performDefaults() {
    enabler.restoreDefaults();
    activityPromptButton.setSelection(getPreferenceStore().getDefaultBoolean(IPreferenceConstants.SHOULD_PROMPT_FOR_ENABLEMENT));
    super.performDefaults();
}

---------------Library-------------------
method: org.eclipse.jface.preference.StringFieldEditor.showErrorMessage()V1
public void showErrorMessage() {
    showErrorMessage(errorMessage);
}
method: org.eclipse.jface.preference.FieldEditor.showErrorMessage(java.lang.String;)V2
protected void showErrorMessage(String msg) {
    if (page != null) {
        page.setErrorMessage(msg);
    }
}
---------------Client-------------------
method: org.eclipse.compare.structuremergeviewer.StructureRootNode.dispose()V1
public void dispose() {
    if (fAdapter != null) {
        fAdapter.disconnect(fInput);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.editors.text.EditorsPlugin.getDialogSettingsSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
public IDialogSettings getDialogSettingsSection(String name) {
    IDialogSettings dialogSettings = getDialogSettings();
    IDialogSettings section = dialogSettings.getSection(name);
    if (section == null) {
        section = dialogSettings.addNewSection(name);
    }
    return section;
}
method: org.eclipse.jface.dialogs.DialogSettings.addNewSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
@Override
public IDialogSettings addNewSection(String sectionName) {
    DialogSettings section = new  DialogSettings(sectionName);
    addSection(section);
    return section;
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.search.dependencies.DependencyExtentSearchResultPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Link.setFontDescription(J)V2
@Override
void setFontDescription(long font) {
    super.setFontDescription(font);
    layout.setFont(Font.gtk_new(display, font));
}
method: org.eclipse.swt.graphics.Font.gtk_new(org.eclipse.swt.graphics.Device;J)org.eclipse.swt.graphics.Font;2
public static Font gtk_new(Device device, long handle) {
    Font font = new  Font(device);
    font.handle = handle;
    return font;
}
---------------Client-------------------
method: org.eclipse.ui.views.properties.PropertySheetPage.setActionBars(org.eclipse.ui.IActionBars;)V2
public void setActionBars(IActionBars actionBars) {
    super.setActionBars(actionBars);
    cellEditorActionHandler = new  CellEditorActionHandler(actionBars);
    cellEditorActionHandler.setCopyAction(copyAction);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpDocumentHandler.error(org.xml.sax.SAXParseException;)V2
public void error(SAXParseException e) throws SAXException {
    fModel.addError(e);
    super.error(e);
}
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpModel.addError(java.lang.Exception;)V2
public void addError(Exception e) {
    if (fErrors == null) {
        fErrors = new  ArrayList(1);
    }
    if (!fErrors.contains(e)) {
        fErrors.add(e);
    }
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering.addMenuListener(org.eclipse.jface.action.IMenuListener;)V2
private void addMenuListener(IMenuListener menuListener) {
    if (fMenuListeners == null) {
        fMenuListeners = new  ArrayList<IMenuListener>();
    }
    if (!fMenuListeners.contains(menuListener)) {
        fMenuMgr.addMenuListener(menuListener);
        fMenuListeners.add(menuListener);
    }
}

---------------Library-------------------
method: org.eclipse.osgi.internal.log.EquinoxLogWriter.writeMessage(org.eclipse.osgi.framework.log.FrameworkLogEntry;)V2
private void writeMessage(FrameworkLogEntry entry) throws IOException {
    write(MESSAGE);
    writeSpace();
    writeln(entry.getMessage());
}
method: org.eclipse.osgi.internal.log.EquinoxLogWriter.write(java.lang.String;)V2
private void write(String message) throws IOException {
    if (message != null) {
        writer.write(message);
        if (consoleLog)
            System.out.print(message);
    }
}
---------------Client-------------------
method: org.eclipse.jface.preference.BooleanPropertyAction$1.propertyChange(org.eclipse.jface.util.PropertyChangeEvent;)V2
@Override
public void propertyChange(PropertyChangeEvent event) {
    if (finalProprety.equals(event.getProperty())) {
        setChecked(Boolean.TRUE.equals(event.getNewValue()));
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskGroupDetails.hookListeners()V1
public void hookListeners() {
    createListenersNameEntry();
    createListenersKindCombo();
    createListenersSkipButton();
    fEnclosingTextSection.hookListeners();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskGroupDetails.createListenersKindCombo()V1
private void createListenersKindCombo() {
    fKindCombo.addSelectionListener(new  SelectionAdapter() {

        public void widgetSelected(SelectionEvent e) {
            if (fDataTaskGroup == null) {
                return;
            }
            String selection = fKindCombo.getSelection();
            if (selection.equals(F_KIND_VALUE_CHOICE)) {
                fDataTaskGroup.setFieldKind(ICompCSConstants.ATTRIBUTE_VALUE_CHOICE);
            } else if (selection.equals(F_KIND_VALUE_SEQUENCE)) {
                fDataTaskGroup.setFieldKind(ICompCSConstants.ATTRIBUTE_VALUE_SEQUENCE);
            } else if (selection.equals(F_KIND_VALUE_SET)) {
                fDataTaskGroup.setFieldKind(ICompCSConstants.ATTRIBUTE_VALUE_SET);
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskGroupDetails.hookListeners()V1
public void hookListeners() {
    createListenersNameEntry();
    createListenersKindCombo();
    createListenersSkipButton();
    fEnclosingTextSection.hookListeners();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskGroupDetails.createListenersNameEntry()V1
private void createListenersNameEntry() {
    fNameEntry.setFormEntryListener(new  FormEntryAdapter(this) {

        public void textValueChanged(FormEntry entry) {
            if (fDataTaskGroup == null) {
                return;
            }
            fDataTaskGroup.setFieldName(fNameEntry.getValue());
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskGroupDetails.hookListeners()V1
public void hookListeners() {
    createListenersNameEntry();
    createListenersKindCombo();
    createListenersSkipButton();
    fEnclosingTextSection.hookListeners();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSTaskGroupDetails.createListenersSkipButton()V1
private void createListenersSkipButton() {
    fSkip.addSelectionListener(new  SelectionAdapter() {

        public void widgetSelected(SelectionEvent e) {
            if (fDataTaskGroup == null) {
                return;
            }
            fDataTaskGroup.setFieldSkip(fSkip.getSelection());
        }
    });
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.EditorAreaDropAdapter.drop(org.eclipse.swt.dnd.DropTargetEvent;)V2
public void drop(final DropTargetEvent event) {
    Display d = window.getShell().getDisplay();
    final IWorkbenchPage page = window.getActivePage();
    if (page != null) {
        d.asyncExec(new  Runnable() {

            public void run() {
                asyncDrop(event, page);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.targetdefinition.EnvironmentPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyMemberValuePairsopt()V1
protected void consumeEmptyMemberValuePairsopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.team.internal.core.FileContentManager.getDefaultExtensionMappings()Aorg.eclipse.team.core.IStringMapping;1
public IStringMapping[] getDefaultExtensionMappings() {
    return getStringMappings(fPluginExtensionMappings.referenceMap());
}
method: org.eclipse.team.internal.core.PluginStringMappings.referenceMap()java.util.Map;1
public Map referenceMap() {
    if (fMappings == null) {
        fMappings = loadPluginPatterns();
    }
    return fMappings;
}
---------------Client-------------------
method: org.eclipse.team.ui.synchronize.ParticipantPageCompareEditorInput.getTitleImage()org.eclipse.swt.graphics.Image;1
public Image getTitleImage() {
    if (titleImage == null) {
        titleImage = participant.getImageDescriptor().createImage();
    }
    return titleImage;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeInputFileObject.openReader(Z)java.io.Reader;2
@Override
public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
    return new  BufferedReader(new  InputStreamReader(openInputStream()));
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeInputFileObject.openInputStream()java.io.InputStream;1
@Override
public InputStream openInputStream() throws IOException {
    try {
        return _file.getContents();
    } catch (CoreException e) {
        throw new  IOException(e);
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.filesystem.local.LocalFile.getChild(org.eclipse.core.runtime.IPath;)org.eclipse.core.filesystem.IFileStore;2
public IFileStore getChild(IPath path) {
    return new  LocalFile(new  File(file, path.toOSString()));
}

---------------Library-------------------
method: org.eclipse.swt.custom.CLabel.setFont(org.eclipse.swt.graphics.Font;)V2
@Override
public void setFont(Font font) {
    super.setFont(font);
    redraw();
}
method: org.eclipse.swt.widgets.Canvas.setFont(org.eclipse.swt.graphics.Font;)V2
@Override
public void setFont(Font font) {
    checkWidget();
    if (caret != null)
        caret.setFont(font);
    super.setFont(font);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor.doSetInput(org.eclipse.ui.IEditorInput;)V2
@Override
protected void doSetInput(IEditorInput input) throws CoreException {
    super.doSetInput(input);
    configureToggleCommentAction();
    if (fJavaEditorErrorTickUpdater != null)
        fJavaEditorErrorTickUpdater.updateEditorImage(getInputJavaElement());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties.setProperty(java.lang.String;java.lang.String;)java.lang.Object;3
public Object setProperty(String key, String value) {
    init();
    return propertyMap.put(key, value);
}
method: org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties.init()V1
private void init() {
    if (propertyMap == null) {
        propertyMap = new  LinkedHashMap<String, String>();
    }
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.setLocalizedProperty(java.lang.String;java.lang.String;)java.lang.String;3
public String setLocalizedProperty(String key, String value) {
    if (localizedProperties == null)
        localizedProperties = new  OrderedProperties();
    return localizedProperties.put(key, value);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.VariableBlock.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fControl != null) {
        return fControl.getShell();
    }
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getShell()org.eclipse.swt.widgets.Shell;1
final Shell getShell() {
    if (fEditor != null)
        return fEditor.getEditorSite().getShell();
    return JavaPlugin.getActiveWorkbenchShell();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExceptionAnalyzer.visit(org.eclipse.jdt.core.dom.SuperMethodInvocation;)Z2
@Override
public boolean visit(SuperMethodInvocation node) {
    return handleExceptions((IMethodBinding) node.getName().resolveBinding(), node);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.ExceptionAnalyzer.handleExceptions(org.eclipse.jdt.core.dom.IMethodBinding;org.eclipse.jdt.core.dom.ASTNode;)Z3
private boolean handleExceptions(IMethodBinding binding, ASTNode node) {
    if (binding == null)
        return true;
    addExceptions(binding.getExceptionTypes(), node.getAST());
    return true;
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.MarkerDelta.isSubtypeOf(java.lang.String;)Z2
public boolean isSubtypeOf(String superType) {
    return ((Workspace) getResource().getWorkspace()).getMarkerManager().isSubtype(getType(), superType);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatter.formatExpression(java.lang.String;ILjava.lang.String;Aorg.eclipse.jface.text.IRegion;Z)org.eclipse.text.edits.TextEdit;6
private TextEdit formatExpression(String source, int indentationLevel, String lineSeparator, IRegion[] regions, boolean includeComments) {
    Expression expression = this.codeSnippetParsingUtil.parseExpression(source.toCharArray(), getDefaultCompilerOptions(), true);
    if (expression == null) {
        return null;
    }
    return internalFormatExpression(source, indentationLevel, lineSeparator, expression, regions, includeComments);
}
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatter.internalFormatExpression(java.lang.String;ILjava.lang.String;org.eclipse.jdt.internal.compiler.ast.Expression;Aorg.eclipse.jface.text.IRegion;Z)org.eclipse.text.edits.TextEdit;7
private TextEdit internalFormatExpression(String source, int indentationLevel, String lineSeparator, Expression expression, IRegion[] regions, boolean includeComments) {
    if (lineSeparator != null) {
        this.preferences.line_separator = lineSeparator;
    } else {
        this.preferences.line_separator = Util.LINE_SEPARATOR;
    }
    this.preferences.initial_indentation_level = indentationLevel;
    this.newCodeFormatter = new  CodeFormatterVisitor(this.preferences, this.options, regions, this.codeSnippetParsingUtil, includeComments);
    TextEdit textEdit = this.newCodeFormatter.format(source, expression);
    return textEdit;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatter.formatCompilationUnit(java.lang.String;ILjava.lang.String;Aorg.eclipse.jface.text.IRegion;Z)org.eclipse.text.edits.TextEdit;6
private TextEdit formatCompilationUnit(String source, int indentationLevel, String lineSeparator, IRegion[] regions, boolean includeComments) {
    CompilationUnitDeclaration compilationUnitDeclaration = this.codeSnippetParsingUtil.parseCompilationUnit(source.toCharArray(), getDefaultCompilerOptions(), true);
    if (lineSeparator != null) {
        this.preferences.line_separator = lineSeparator;
    } else {
        this.preferences.line_separator = Util.LINE_SEPARATOR;
    }
    this.preferences.initial_indentation_level = indentationLevel;
    this.newCodeFormatter = new  CodeFormatterVisitor(this.preferences, this.options, regions, this.codeSnippetParsingUtil, includeComments);
    return this.newCodeFormatter.format(source, compilationUnitDeclaration);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.infoviews.SourceView.getControl()org.eclipse.swt.widgets.Control;1
@Override
protected Control getControl() {
    return fViewer.getControl();
}
method: org.eclipse.jface.text.source.SourceViewer.getControl()org.eclipse.swt.widgets.Control;1
public Control getControl() {
    if (fComposite != null)
        return fComposite;
    return super.getControl();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jface.internal.text.html.HTMLPrinter.addParagraph(java.lang.StringBuffer;java.io.Reader;)V2
public static void addParagraph(StringBuffer buffer, Reader paragraphReader) {
    if (paragraphReader != null)
        addParagraph(buffer, read(paragraphReader));
}
method: org.eclipse.jface.internal.text.html.HTMLPrinter.addParagraph(java.lang.StringBuffer;java.lang.String;)V2
public static void addParagraph(StringBuffer buffer, String paragraph) {
    if (paragraph != null) {
        buffer.append("<p>");
        buffer.append(paragraph);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.Annotation.toStringName(java.lang.StringBuffer;)V2
protected void toStringName(StringBuffer buffer) {
    buffer.append('@');
    buffer.append(getElementName());
}

---------------Library-------------------
method: org.apache.batik.css.parser.Parser.setLocale(java.util.Locale;)V2
public void setLocale(Locale locale) throws CSSException {
    localizableSupport.setLocale(locale);
}
method: org.apache.batik.i18n.LocalizableSupport.setLocale(java.util.Locale;)V2
public void setLocale(Locale l) {
    if (locale != l) {
        locale = l;
        resourceBundles.clear();
        lastResourceClass = null;
    }
}
---------------Client-------------------
method: org.apache.lucene.analysis.standard.ClassicTokenizerImpl.yyclose()V1
public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;
    zzEndRead = zzStartRead;
    if (zzReader != null)
        zzReader.close();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.shared.target.AddBundleContainerSelectionPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Label;2
public static Label createLabel(Composite parent, String message) {
    return createLabel(parent, message, 1);
}
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createLabel(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Label;3
public static Label createLabel(Composite parent, String message, int span) {
    final Label label = new  Label(parent, SWT.WRAP);
    if (message != null)
        label.setText(message);
    label.setLayoutData(createHFillGridData(span));
    return label;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocWizardPage.createCombo(org.eclipse.swt.widgets.Composite;ILjava.lang.String;org.eclipse.swt.layout.GridData;)org.eclipse.swt.widgets.Combo;5
protected Combo createCombo(Composite composite, int style, String message, GridData gd) {
    Combo combo = new  Combo(composite, style);
    SWTUtil.setDefaultVisibleItemCount(combo);
    if (message != null)
        combo.setText(message);
    combo.setLayoutData(gd);
    return combo;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeRightParen()V1
protected void consumeRightParen() {
    pushOnIntStack(this.rParenPos);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeElidedLeftBraceAndReturn()V1
protected void consumeElidedLeftBraceAndReturn() {
    int stackLength = this.stateStackLengthStack.length;
    if (++this.valueLambdaNestDepth >= stackLength) {
        System.arraycopy(this.stateStackLengthStack, 0, this.stateStackLengthStack = new int[stackLength + 4], 0, stackLength);
    }
    this.stateStackLengthStack[this.valueLambdaNestDepth] = this.stateStackTop;
}

---------------Library-------------------
method: org.eclipse.ui.part.MultiEditor$1.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event event) {
    if (event.type == SWT.Activate) {
        activateEditor(e);
    }
}
method: org.eclipse.ui.part.MultiEditor.activateEditor(org.eclipse.ui.IEditorPart;)V2
@Override
public void activateEditor(IEditorPart part) {
    IEditorPart oldEditor = getActiveEditor();
    super.activateEditor(part);
    updateGradient(oldEditor);
}
---------------Client-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceImpl$ContentsEList.loaded()V1
protected void loaded() {
    if (!ResourceImpl.this.isLoaded()) {
        Notification notification = ResourceImpl.this.setLoaded(true);
        if (notification != null) {
            ResourceImpl.this.eNotify(notification);
        }
    }
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.InternalTreeModelViewer.getDisplay()org.eclipse.swt.widgets.Display;1
@Override
public Display getDisplay() {
    Control control = getControl();
    if (control != null) {
        return control.getDisplay();
    }
    return null;
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.HelpActivitySupport$ActivityDescriptor.getShowAllMessage()java.lang.String;1
public String getShowAllMessage() {
    if (config == null)
        return null;
    IConfigurationElement child = getChild("showAllMessage");
    if (child != null)
        return child.getValue();
    return null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.dialogs.AvailableIUPatternFilter.setPattern(java.lang.String;)V2
public void setPattern(String patternString) {
    super.setPattern(patternString);
    this.patternString = patternString;
}
method: org.eclipse.ui.dialogs.PatternFilter.setPattern(java.lang.String;)V2
public void setPattern(String patternString) {
    if ("org.eclipse.ui.keys.optimization.true".equals(patternString)) {
        useEarlyReturnIfMatcherIsNull = true;
        return;
    } else if ("org.eclipse.ui.keys.optimization.false".equals(patternString)) {
        useEarlyReturnIfMatcherIsNull = false;
        return;
    }
    clearCaches();
    if (patternString == null || patternString.equals("")) {
        matcher = null;
    } else {
        String pattern = patternString + "*";
        if (includeLeadingWildcard) {
            pattern = "*" + pattern;
        }
        matcher = new  StringMatcher(pattern, true, false);
    }
}
---------------Client-------------------
method: org.eclipse.jface.text.templates.TemplateTranslator.fail(java.lang.String;)V2
private void fail(String message) throws TemplateException {
    fErrorMessage = message;
    throw new  TemplateException(message);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntClasspathLabelProvider.getJarImage()org.eclipse.swt.graphics.Image;1
private Image getJarImage() {
    return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_JAR);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.internal.PerspectiveTracker.pageActivated(org.eclipse.ui.IWorkbenchPage;)V2
@Override
public void pageActivated(IWorkbenchPage page) {
    update();
}
method: org.eclipse.ui.internal.PerspectiveTracker.update()V1
private void update() {
    if (window != null) {
        IPerspectiveDescriptor persp = null;
        IWorkbenchPage page = window.getActivePage();
        if (page != null) {
            persp = page.getPerspective();
        }
        update(persp);
    }
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.updateDescription()V1
protected void updateDescription() {
    PasswordProviderDescription selectedModule = getSelectedModule();
    if (selectedModule != null && detailsText != null)
        detailsText.setText(selectedModule.getDescription());
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.formatter.XmlDocumentFormattingStrategy.formatterStops()V1
@Override
public void formatterStops() {
    super.formatterStops();
    fDocuments.clear();
}
method: org.eclipse.jface.text.formatter.ContextBasedFormattingStrategy.formatterStops()V1
public void formatterStops() {
    fPreferences.clear();
    fCurrentPreferences = null;
}
---------------Client-------------------
method: org.apache.lucene.analysis.shingle.ShingleMatrixFilter.reset()V1
@Override
public void reset() throws IOException {
    permutations = null;
    shinglesSeen.clear();
    input.reset();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.ProjectsWorkbookPage.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fSWTControl != null) {
        return fSWTControl.getShell();
    }
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getShell()org.eclipse.swt.widgets.Shell;1
final Shell getShell() {
    if (fEditor != null)
        return fEditor.getEditorSite().getShell();
    return JavaPlugin.getActiveWorkbenchShell();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart.getDisplay()org.eclipse.swt.widgets.Display;1
private Display getDisplay() {
    return getViewSite().getShell().getDisplay();
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.swt.browser.Browser.evaluate(java.lang.String;)java.lang.Object;2
public Object evaluate(String script) throws SWTException {
    checkWidget();
    if (script == null)
        SWT.error(SWT.ERROR_NULL_ARGUMENT);
    return webBrowser.evaluate(script);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMField.offset(I)V2
protected void offset(int offset) {
    super.offset(offset);
    offsetRange(this.fInitializerRange, offset);
    offsetRange(this.fTypeRange, offset);
}
method: org.eclipse.jdt.internal.core.jdom.DOMMember.offset(I)V2
protected void offset(int offset) {
    super.offset(offset);
    offsetRange(this.fCommentRange, offset);
    offsetRange(this.fModifierRange, offset);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMMethod.offset(I)V2
protected void offset(int offset) {
    super.offset(offset);
    offsetRange(this.fBodyRange, offset);
    offsetRange(this.fExceptionRange, offset);
    offsetRange(this.fParameterRange, offset);
    offsetRange(this.fReturnTypeRange, offset);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpDocumentHandler.startDocument()V1
public void startDocument() throws SAXException {
    fModel.purgeErrors();
    super.startDocument();
}
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpModel.purgeErrors()V1
public void purgeErrors() {
    if (fErrors != null) {
        fErrors.clear();
    }
}
---------------Client-------------------
method: org.apache.lucene.index.SegmentTermDocs.close()V1
public void close() throws IOException {
    freqStream.close();
    if (skipListReader != null)
        skipListReader.close();
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;2
public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<? super T> first, org.hamcrest.Matcher<? super T> second) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second);
}
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;2
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(2);
    matchers.add(first);
    matchers.add(second);
    return allOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;2
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    return anyOf(matchers);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTImageHelper.storeDefaultImage(org.eclipse.swt.widgets.Item;)V1
public static void storeDefaultImage(Item item) {
    storeDefaultImage(item, DEFAULT_IMAGE, item.getImage());
}
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTImageHelper.storeDefaultImage(org.eclipse.swt.widgets.Widget;java.lang.String;org.eclipse.swt.graphics.Image;)V3
private static void storeDefaultImage(Widget widget, String imageName, Image image) {
    if (widget.getData(imageName) == null) {
        widget.setData(imageName, image);
    }
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Composite.layout(Aorg.eclipse.swt.widgets.Control;)V2
public void layout(Control[] changed) {
    checkWidget();
    if (changed == null)
        error(SWT.ERROR_INVALID_ARGUMENT);
    layout(changed, SWT.NONE);
}

---------------Library-------------------
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.addStorageHookFactory(org.eclipse.osgi.internal.hookregistry.StorageHookFactory;)V2
public void addStorageHookFactory(StorageHookFactory<?, ?, ?> storageHookFactory) {
    add(storageHookFactory, storageHookFactories);
}
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.add(java.lang.Object;java.util.List;)V3
private <H> void add(H hook, List<H> hooks) {
    if (initialized)
        throw new  IllegalStateException("Cannot add hooks dynamically.");
    hooks.add(hook);
}
---------------Client-------------------
method: org.eclipse.emf.common.command.CompoundCommand.append(org.eclipse.emf.common.command.Command;)V2
public void append(Command command) {
    if (isPrepared) {
        throw new  IllegalStateException("The command is already prepared");
    }
    if (command != null) {
        commandList.add(command);
    }
}

---------------Library-------------------
method: org.eclipse.debug.ui.WorkingDirectoryBlock.setOtherWorkingDirectoryText(java.lang.String;)V2
protected final void setOtherWorkingDirectoryText(String dir) {
    if (dir != null) {
        fOtherWorkingText.setText(dir);
        fUseDefaultDirButton.setSelection(false);
        fUseOtherDirButton.setSelection(true);
        handleUseOtherWorkingDirButtonSelected();
    }
}
method: org.eclipse.debug.ui.WorkingDirectoryBlock.handleUseOtherWorkingDirButtonSelected()V1
private void handleUseOtherWorkingDirButtonSelected() {
    fOtherWorkingText.setEnabled(true);
    fWorkspaceButton.setEnabled(true);
    fVariablesButton.setEnabled(true);
    fFileSystemButton.setEnabled(true);
    updateLaunchConfigurationDialog();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository.initialize(org.eclipse.equinox.p2.repository.metadata.spi.AbstractMetadataRepository$RepositoryState;)V2
public void initialize(RepositoryState state) {
    setName(state.Name);
    setType(state.Type);
    setVersion(state.Version.toString());
    setProvider(state.Provider);
    setDescription(state.Description);
    setLocation(state.Location);
    setProperties(state.Properties);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.dialogs.AvailableIUGroup.getViewerGridData()org.eclipse.swt.layout.GridData;1
protected GridData getViewerGridData() {
    GridData data = super.getViewerGridData();
    data.heightHint = convertHeightInCharsToPixels(ILayoutConstants.DEFAULT_TABLE_HEIGHT);
    return data;
}
method: org.eclipse.equinox.internal.p2.ui.dialogs.StructuredIUGroup.getViewerGridData()org.eclipse.swt.layout.GridData;1
protected GridData getViewerGridData() {
    GridData data = new  GridData(GridData.FILL_BOTH);
    data.grabExcessHorizontalSpace = true;
    data.grabExcessVerticalSpace = true;
    return data;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.CVSWizardPage.layoutTextField(org.eclipse.swt.widgets.Text;)org.eclipse.swt.widgets.Text;1
public static Text layoutTextField(Text text) {
    GridData data = new  GridData(GridData.FILL_HORIZONTAL);
    data.verticalAlignment = GridData.CENTER;
    data.grabExcessVerticalSpace = false;
    data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
    text.setLayoutData(data);
    return text;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExceptionAnalyzer.visit(org.eclipse.jdt.core.dom.MethodInvocation;)Z2
@Override
public boolean visit(MethodInvocation node) {
    return handleExceptions((IMethodBinding) node.getName().resolveBinding(), node);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.ExceptionAnalyzer.handleExceptions(org.eclipse.jdt.core.dom.IMethodBinding;org.eclipse.jdt.core.dom.ASTNode;)Z3
private boolean handleExceptions(IMethodBinding binding, ASTNode node) {
    if (binding == null)
        return true;
    addExceptions(binding.getExceptionTypes(), node.getAST());
    return true;
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.MarkerDelta.isSubtypeOf(java.lang.String;)Z2
public boolean isSubtypeOf(String superType) {
    return ((Workspace) getResource().getWorkspace()).getMarkerManager().isSubtype(getType(), superType);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.License.hashCode()I1
public int hashCode() {
    return getUUID().hashCode();
}
method: org.eclipse.equinox.internal.p2.metadata.License.getUUID()java.lang.String;1
public synchronized String getUUID() {
    if (digest == null)
        digest = calculateLicenseDigest().toString(16);
    return digest;
}
---------------Client-------------------
method: org.eclipse.ecf.internal.provider.filetransfer.Activator.pluginExcluded(java.lang.String;)Z2
boolean pluginExcluded(String pluginId) {
    if (excludedPlugins == null) {
        excludedPlugins = parseExcludedPlugins();
    }
    List l = Arrays.asList(excludedPlugins);
    return l.contains(pluginId);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.TodoTaskConfigurationBlock.setEnabled(Z)V2
public void setEnabled(boolean isEnabled) {
    fTodoTasksList.setEnabled(isEnabled);
    fCaseSensitiveCheckBox.setEnabled(isEnabled);
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField.setEnabled(Z)V2
public final void setEnabled(boolean enabled) {
    if (enabled != fEnabled) {
        fEnabled = enabled;
        updateEnableState();
    }
}
---------------Client-------------------
method: org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport.saveCellEditorValue(org.eclipse.jface.viewers.CellEditor;org.eclipse.jface.viewers.ViewerCell;)V3
protected final void saveCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
    if (dirty) {
        editingState.binding.updateTargetToModel();
        dirty = false;
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.misc.CheckboxTreeAndListGroup.initialCheckTreeItem(java.lang.Object;)V2
public void initialCheckTreeItem(Object element) {
    treeItemChecked(element, true);
}
method: org.eclipse.ui.internal.ide.misc.CheckboxTreeAndListGroup.treeItemChecked(java.lang.Object;Z)V3
protected void treeItemChecked(Object treeElement, boolean state) {
    setTreeChecked(treeElement, state);
    Object parent = treeContentProvider.getParent(treeElement);
    if (parent == null) {
        return;
    }
    if (state) {
        grayCheckHierarchy(parent);
    } else {
        ungrayCheckHierarchy(parent);
    }
    updateHierarchy(treeElement);
}
---------------Client-------------------
method: org.eclipse.ui.internal.editors.text.SelectResourcesBlock.treeItemChecked(java.lang.Object;Z)V3
private void treeItemChecked(Object treeElement, boolean state) {
    setTreeChecked(treeElement, state);
    Object parent = treeContentProvider.getParent(treeElement);
    if (parent == null)
        return;
    if (state)
        grayCheckHierarchy(parent);
    else
        ungrayCheckHierarchy(parent);
    grayUpdateHierarchy(parent);
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.JobListeners.running(org.eclipse.core.runtime.jobs.Job;)V2
public void running(Job job) {
    doNotify(running, newEvent(job));
}
method: org.eclipse.core.internal.jobs.JobListeners.newEvent(org.eclipse.core.runtime.jobs.Job;)org.eclipse.core.internal.jobs.JobChangeEvent;1
static JobChangeEvent newEvent(Job job) {
    JobChangeEvent instance = new  JobChangeEvent();
    instance.job = job;
    return instance;
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory.init(org.eclipse.e4.core.contexts.IEclipseContext;)V2
@PostConstruct
public void init(IEclipseContext context) {
    this.context = context;
    this.context.set(SHARED_ELEMENTS_STORE, new  HashMap<MUIElement, Set<MPlaceholder>>());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.ClipboardOperationAction.getDisplay()org.eclipse.swt.widgets.Display;1
private Display getDisplay() {
    Shell shell = getShell();
    if (shell != null) {
        return shell.getDisplay();
    }
    return null;
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.HelpActivitySupport$ActivityDescriptor.getShowAllMessage()java.lang.String;1
public String getShowAllMessage() {
    if (config == null)
        return null;
    IConfigurationElement child = getChild("showAllMessage");
    if (child != null)
        return child.getValue();
    return null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.frameworkadmin.equinox.EquinoxBundlesState.isResolved(org.eclipse.equinox.frameworkadmin.BundleInfo;)Z2
public boolean isResolved(BundleInfo bInfo) {
    URI realLocation = bInfo.getLocation();
    BundleDescription description = getBundleByLocation(realLocation);
    if (description == null)
        return false;
    return description.isResolved();
}
method: org.eclipse.equinox.internal.frameworkadmin.equinox.EquinoxBundlesState.getBundleByLocation(java.net.URI;)org.eclipse.osgi.service.resolver.BundleDescription;2
private BundleDescription getBundleByLocation(URI location) {
    if (location == null)
        return null;
    return locationStateIndex.get(location);
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring$ProcessorChange.internalProcessOnCancel(org.eclipse.ltk.core.refactoring.Change;)Z2
protected boolean internalProcessOnCancel(Change change) {
    RefactoringParticipant participant = (RefactoringParticipant) fParticipantMap.get(change);
    if (participant == null)
        return false;
    return participant.getDescriptor().processOnCancel();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.SemanticHighlightingPresenter.inputDocumentChanged(org.eclipse.jface.text.IDocument;org.eclipse.jface.text.IDocument;)V3
public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
    manageDocument(newInput);
}
method: org.eclipse.jdt.internal.ui.javaeditor.SemanticHighlightingPresenter.manageDocument(org.eclipse.jface.text.IDocument;)V2
private void manageDocument(IDocument document) {
    if (document != null) {
        document.addPositionCategory(getPositionCategory());
        document.addPositionUpdater(fPositionUpdater);
        document.addDocumentListener(this);
    }
}
---------------Client-------------------
method: org.eclipse.ui.views.markers.internal.MarkerView.initToolBar(org.eclipse.jface.action.IToolBarManager;)V2
protected void initToolBar(IToolBarManager tbm) {
    tbm.add(deleteAction);
    tbm.add(getFilterAction());
    tbm.update(false);
}

---------------Library-------------------
method: org.apache.lucene.index.ParallelReader.doCommit(java.util.Map;)V2
@Override
protected void doCommit(Map<String, String> commitUserData) throws IOException {
    for (final IndexReader reader : readers) reader.commit(commitUserData);
}
method: org.apache.lucene.index.IndexReader.commit(java.util.Map;)V2
public final synchronized void commit(Map<String, String> commitUserData) throws IOException {
    doCommit(commitUserData);
    hasChanges = false;
}
---------------Client-------------------
method: org.eclipse.help.internal.search.ProgressDistributor.setTaskName(java.lang.String;)V2
public synchronized void setTaskName(String name) {
    taskName = name;
    for (Iterator<IProgressMonitor> it = monitors.iterator(); it.hasNext(); ) {
        IProgressMonitor m = it.next();
        m.setTaskName(name);
    }
}

---------------Library-------------------
method: org.eclipse.equinox.p2.publisher.eclipse.BundlesAction.acquirePluginConverter()org.eclipse.osgi.service.pluginconversion.PluginConverter;0
private static PluginConverter acquirePluginConverter() {
    return (PluginConverter) ServiceHelper.getService(Activator.getContext(), PluginConverter.class.getName());
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
method: org.eclipse.jdt.internal.corext.fix.NullAnnotationsRewriteOperations.getDeclaringNode(org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.core.dom.ASTNode;1
private static ASTNode getDeclaringNode(ASTNode selectedNode) {
    return ASTNodes.getParent(selectedNode, ASTNode.METHOD_DECLARATION);
}
method: org.eclipse.jdt.internal.corext.dom.ASTNodes.getParent(org.eclipse.jdt.core.dom.ASTNode;I)org.eclipse.jdt.core.dom.ASTNode;2
public static ASTNode getParent(ASTNode node, int nodeType) {
    do {
        node = node.getParent();
    } while (node != null && node.getNodeType() != nodeType);
    return node;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.correction.java.QuickFixProcessor.getParent(org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.core.dom.ASTNode;1
private static ASTNode getParent(ASTNode node) {
    do {
        node = node.getParent();
    } while (node != null && node.getNodeType() != ASTNode.IMPORT_DECLARATION);
    return node;
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewContainerWizardPage.getMaxFieldWidth()I1
protected int getMaxFieldWidth() {
    return convertWidthInCharsToPixels(40);
}
method: org.eclipse.jface.dialogs.DialogPage.convertWidthInCharsToPixels(I)I2
protected int convertWidthInCharsToPixels(int chars) {
    if (fontMetrics == null) {
        return 0;
    }
    return Dialog.convertWidthInCharsToPixels(fontMetrics, chars);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart.isExpandable(java.lang.Object;)Z2
boolean isExpandable(Object element) {
    if (fViewer == null)
        return false;
    return fViewer.isExpandable(element);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.CodeTemplatePreferencePage.performDefaults()V1
@Override
protected void performDefaults() {
    super.performDefaults();
    if (fCodeTemplateConfigurationBlock != null) {
        fCodeTemplateConfigurationBlock.performDefaults();
    }
}
method: org.eclipse.jdt.internal.ui.preferences.CodeTemplateBlock.performDefaults()V1
@Override
public void performDefaults() {
    fTemplateStore.restoreDefaults();
    fCodeTemplateTree.refresh();
    super.performDefaults();
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberSyncInfoCollector.dispose()V1
public void dispose() {
    eventHandler.shutdown();
    subscriberInput.disconnect();
    if (filteredInput != null) {
        filteredInput.disconnect();
    }
    super.dispose();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.participants.ResourceModifications.addCopy(org.eclipse.core.resources.IResource;org.eclipse.ltk.core.refactoring.participants.CopyArguments;)V3
public void addCopy(IResource copy, CopyArguments arguments) {
    if (fCopy == null) {
        fCopy = new  ArrayList<IResource>(2);
        fCopyArguments = new  ArrayList<CopyArguments>(2);
    }
    fCopy.add(copy);
    fCopyArguments.add(arguments);
    addCopyDelta(copy, arguments);
}
method: org.eclipse.jdt.internal.corext.refactoring.participants.ResourceModifications.addCopyDelta(org.eclipse.core.resources.IResource;org.eclipse.ltk.core.refactoring.participants.CopyArguments;)V3
public void addCopyDelta(IResource copy, CopyArguments arguments) {
    if (fIgnoreCount == 0) {
        IPath destination = ((IResource) arguments.getDestination()).getFullPath().append(copy.getName());
        internalAdd(new  CopyDescription(copy, destination));
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.participants.ResourceModifications.addMove(org.eclipse.core.resources.IResource;org.eclipse.ltk.core.refactoring.participants.MoveArguments;)V3
public void addMove(IResource move, MoveArguments arguments) {
    if (fMove == null) {
        fMove = new  ArrayList<IResource>(2);
        fMoveArguments = new  ArrayList<MoveArguments>(2);
    }
    fMove.add(move);
    fMoveArguments.add(arguments);
    if (fIgnoreCount == 0) {
        IPath destination = ((IResource) arguments.getDestination()).getFullPath().append(move.getName());
        internalAdd(new  MoveDescription(move, destination));
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.PerspectiveTracker.perspectiveActivated(org.eclipse.ui.IWorkbenchPage;org.eclipse.ui.IPerspectiveDescriptor;)V3
@Override
public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
    update();
}
method: org.eclipse.ui.internal.PerspectiveTracker.update()V1
private void update() {
    if (window != null) {
        IPerspectiveDescriptor persp = null;
        IWorkbenchPage page = window.getActivePage();
        if (page != null) {
            persp = page.getPerspective();
        }
        update(persp);
    }
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.updateDescription()V1
protected void updateDescription() {
    PasswordProviderDescription selectedModule = getSelectedModule();
    if (selectedModule != null && detailsText != null)
        detailsText.setText(selectedModule.getDescription());
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTRGBConverterImpl.convert(java.lang.Object;org.eclipse.e4.ui.css.core.engine.CSSEngine;java.lang.Object;org.eclipse.e4.ui.css.core.dom.properties.converters.ICSSValueConverterConfig;)java.lang.String;5
@Override
public String convert(Object value, CSSEngine engine, Object context, ICSSValueConverterConfig config) throws Exception {
    RGB color = (RGB) value;
    RGBColor rgbColor = CSSSWTColorHelper.getRGBColor(color);
    return CSS2ColorHelper.getColorStringValue(rgbColor, config);
}
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTColorHelper.getRGBColor(org.eclipse.swt.graphics.RGB;)org.w3c.dom.css.RGBColor;1
public static RGBColor getRGBColor(RGB color) {
    int red = color.red;
    int green = color.green;
    int blue = color.blue;
    return new  CSS2RGBColorImpl(red, green, blue);
}
---------------Client-------------------
method: org.eclipse.ui.internal.dnd.DragUtil.getEventLoc(org.eclipse.swt.widgets.Event;)org.eclipse.swt.graphics.Point;1
public static Point getEventLoc(Event event) {
    Control ctrl = (Control) event.widget;
    return ctrl.toDisplay(new  Point(event.x, event.y));
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.DialogUtil.inRegularFontMode(org.eclipse.swt.widgets.Composite;)Z1
public static boolean inRegularFontMode(Composite parent) {
    return availableRows(parent) > 50;
}
method: org.eclipse.ui.internal.ide.DialogUtil.availableRows(org.eclipse.swt.widgets.Composite;)I1
public static int availableRows(Composite parent) {
    int fontHeight = (parent.getFont().getFontData())[0].getHeight();
    int displayHeight = parent.getDisplay().getClientArea().height;
    return displayHeight / fontHeight;
}
---------------Client-------------------
method: org.eclipse.ui.internal.editors.text.SelectResourcesDialog.useHeightHint(org.eclipse.swt.widgets.Composite;)Z2
private boolean useHeightHint(Composite parent) {
    int fontHeight = (parent.getFont().getFontData())[0].getHeight();
    int displayHeight = parent.getDisplay().getClientArea().height;
    return (displayHeight / fontHeight) > 50;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTImageHelper.storeDefaultImage(org.eclipse.swt.widgets.Shell;)V1
public static void storeDefaultImage(Shell shell) {
    storeDefaultImage(shell, DEFAULT_IMAGE, shell.getImage());
}
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTImageHelper.storeDefaultImage(org.eclipse.swt.widgets.Widget;java.lang.String;org.eclipse.swt.graphics.Image;)V3
private static void storeDefaultImage(Widget widget, String imageName, Image image) {
    if (widget.getData(imageName) == null) {
        widget.setData(imageName, image);
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTCursorHelper.storeDefaultCursor(org.eclipse.swt.widgets.Control;)V1
public static void storeDefaultCursor(Control control) {
    if (control.getData(DEFAULT_CURSOR) == null) {
        control.setData(DEFAULT_CURSOR, control.getCursor());
    }
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.ui.internal.actions.ExportDialog.okPressed()V1
@Override
protected void okPressed() {
    saveWidgetState();
    super.okPressed();
}
method: org.eclipse.pde.api.tools.ui.internal.actions.ExportDialog.saveWidgetState()V1
void saveWidgetState() {
    IDialogSettings rootsettings = ApiUIPlugin.getDefault().getDialogSettings();
    IDialogSettings settings = rootsettings.getSection(SETTINGS_SECTION);
    if (settings == null) {
        settings = rootsettings.addNewSection(SETTINGS_SECTION);
    }
    settings.put(REPORT_PATH_STATE, getValue());
}
---------------Client-------------------
method: org.eclipse.ui.views.tasklist.TaskAction.storeValue()V1
protected void storeValue() {
    IDialogSettings workbenchSettings = TaskList.getPlugin().getDialogSettings();
    IDialogSettings settings = workbenchSettings.getSection("TaskAction");
    if (settings == null) {
        settings = workbenchSettings.addNewSection("TaskAction");
    }
    settings.put(getId(), isChecked());
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.update.ThreadEventHandler.indexOf(org.eclipse.debug.core.model.IStackFrame;)I2
protected int indexOf(IStackFrame frame) {
    try {
        return indexOf(frame.getThread().getStackFrames(), frame);
    } catch (DebugException e) {
        return -1;
    }
}
method: org.eclipse.debug.internal.ui.viewers.update.DebugEventHandler.indexOf(Ajava.lang.Object;java.lang.Object;)I3
protected int indexOf(Object[] list, Object element) {
    for (int i = 0; i < list.length; i++) {
        if (element.equals(list[i])) {
            return i;
        }
    }
    return -1;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.containsPackage(org.eclipse.pde.internal.core.builders.IHeader;java.lang.String;)Z3
private boolean containsPackage(IHeader header, String name) {
    if (header != null) {
        ManifestElement[] elements = header.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getValue().equals(name))
                return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.LibrariesWorkbookPage.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fSWTControl != null) {
        return fSWTControl.getShell();
    }
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getShell()org.eclipse.swt.widgets.Shell;1
final Shell getShell() {
    if (fEditor != null)
        return fEditor.getEditorSite().getShell();
    return JavaPlugin.getActiveWorkbenchShell();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathsBlock.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fSWTWidget != null) {
        return fSWTWidget.getShell();
    }
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getShell()org.eclipse.swt.widgets.Shell;1
final Shell getShell() {
    if (fEditor != null)
        return fEditor.getEditorSite().getShell();
    return JavaPlugin.getActiveWorkbenchShell();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.TagConfigurationDialog.getStandardButtonData(org.eclipse.swt.widgets.Button;)org.eclipse.swt.layout.GridData;2
private GridData getStandardButtonData(Button button) {
    GridData data = new  GridData();
    data.heightHint = convertVerticalDLUsToPixels(IDialogConstants.BUTTON_HEIGHT);
    return data;
}
method: org.eclipse.jface.dialogs.Dialog.convertVerticalDLUsToPixels(I)I2
protected int convertVerticalDLUsToPixels(int dlus) {
    if (fontMetrics == null) {
        return 0;
    }
    return convertVerticalDLUsToPixels(fontMetrics, dlus);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.model.ArtifactRepositoryElement.getQueryable()org.eclipse.equinox.p2.query.IQueryable;1
public IQueryable<?> getQueryable() {
    if (queryable == null)
        queryable = getRepository(new  NullProgressMonitor());
    return queryable;
}

---------------Library-------------------
method: org.eclipse.jface.text.DefaultTextHover.getAnnotationModel(org.eclipse.jface.text.source.ISourceViewer;)org.eclipse.jface.text.source.IAnnotationModel;2
private IAnnotationModel getAnnotationModel(ISourceViewer viewer) {
    if (viewer instanceof ISourceViewerExtension2) {
        ISourceViewerExtension2 extension = (ISourceViewerExtension2) viewer;
        return extension.getVisualAnnotationModel();
    }
    return viewer.getAnnotationModel();
}
method: org.eclipse.jface.text.source.SourceViewer.getAnnotationModel()org.eclipse.jface.text.source.IAnnotationModel;1
public IAnnotationModel getAnnotationModel() {
    if (fVisualAnnotationModel instanceof IAnnotationModelExtension) {
        IAnnotationModelExtension extension = (IAnnotationModelExtension) fVisualAnnotationModel;
        return extension.getAnnotationModel(MODEL_ANNOTATION_MODEL);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.SwitchMemoryBlockAction.getViewer()org.eclipse.jface.viewers.StructuredViewer;1
private StructuredViewer getViewer() {
    if (fView instanceof MemoryView) {
        MemoryView memView = (MemoryView) fView;
        IMemoryViewPane pane = memView.getViewPane(MemoryBlocksTreeViewPane.PANE_ID);
        if (pane instanceof MemoryBlocksTreeViewPane) {
            StructuredViewer viewer = ((MemoryBlocksTreeViewPane) pane).getViewer();
            return viewer;
        }
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.ui.ide.dialogs.ResourceTreeAndListGroup.initialCheckTreeItem(java.lang.Object;)V2
public void initialCheckTreeItem(Object element) {
    treeItemChecked(element, true);
    selectAndReveal(element);
}
method: org.eclipse.ui.ide.dialogs.ResourceTreeAndListGroup.selectAndReveal(java.lang.Object;)V2
private void selectAndReveal(Object treeElement) {
    treeViewer.reveal(treeElement);
    IStructuredSelection selection = new  StructuredSelection(treeElement);
    treeViewer.setSelection(selection);
}
---------------Client-------------------
method: org.eclipse.ui.internal.cheatsheets.dialogs.CheatSheetCategoryBasedSelectionDialog.selectPreviouslySelectedCheatSheet(org.eclipse.ui.internal.cheatsheets.registry.CheatSheetCollectionElement;)V2
protected void selectPreviouslySelectedCheatSheet(CheatSheetCollectionElement category) {
    String cheatsheetId = settings.get(STORE_SELECTED_CHEATSHEET_ID);
    if (cheatsheetId == null)
        return;
    CheatSheetElement cheatsheet = category.findCheatSheet(cheatsheetId, false);
    if (cheatsheet == null)
        return;
    treeViewer.setSelection(new  StructuredSelection(cheatsheet));
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.EnumConstantDeclaration;)Z2
public boolean visit(org.eclipse.jdt.core.dom.EnumConstantDeclaration node) {
    visitBodyDeclaration(node);
    return true;
}
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visitBodyDeclaration(org.eclipse.jdt.core.dom.BodyDeclaration;)V2
private void visitBodyDeclaration(final BodyDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)Z2
public boolean visit(SingleVariableDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.ui.internal.dialogs.ViewContentProvider.getElements(java.lang.Object;)Ajava.lang.Object;2
@Override
public Object[] getElements(Object element) {
    return getChildren(element);
}
method: org.eclipse.ui.internal.dialogs.ViewContentProvider.getChildren(java.lang.Object;)Ajava.lang.Object;2
@Override
public Object[] getChildren(Object element) {
    Object[] children = childMap.get(element);
    if (children == null) {
        children = createChildren(element);
        childMap.put(element, children);
    }
    return children;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.CodeAssistAdvancedConfigurationBlock.getImage(org.eclipse.jface.resource.ImageDescriptor;)org.eclipse.swt.graphics.Image;2
private Image getImage(ImageDescriptor imgDesc) {
    if (imgDesc == null)
        return null;
    Image img = fImages.get(imgDesc);
    if (img == null) {
        img = imgDesc.createImage(false);
        fImages.put(imgDesc, img);
    }
    return img;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.hierarchy.TypeHierarchy.getAllSubtypes(org.eclipse.jdt.core.IType;)Aorg.eclipse.jdt.core.IType;2
public IType[] getAllSubtypes(IType type) {
    return getAllSubtypesForType(type);
}
method: org.eclipse.jdt.internal.core.hierarchy.TypeHierarchy.getAllSubtypesForType(org.eclipse.jdt.core.IType;)Aorg.eclipse.jdt.core.IType;2
private IType[] getAllSubtypesForType(IType type) {
    ArrayList subTypes = new  ArrayList();
    getAllSubtypesForType0(type, subTypes);
    IType[] subClasses = new IType[subTypes.size()];
    subTypes.toArray(subClasses);
    return subClasses;
}
---------------Client-------------------
method: org.eclipse.ui.views.markers.internal.MarkerType.getAllSubTypes()Aorg.eclipse.ui.views.markers.internal.MarkerType;1
public MarkerType[] getAllSubTypes() {
    List subTypes = new  ArrayList();
    addSubTypes(subTypes, this);
    MarkerType[] subs = new MarkerType[subTypes.size()];
    subTypes.toArray(subs);
    return subs;
}

---------------Library-------------------
method: org.eclipse.ecf.core.ContainerFactory.createContainer(java.lang.String;Ajava.lang.Object;)org.eclipse.ecf.core.IContainer;3
public IContainer createContainer(String containerTypeDescriptionName, Object[] parameters) throws ContainerCreateException {
    return createContainer(getDescriptionByNameWithException(containerTypeDescriptionName), parameters);
}
method: org.eclipse.ecf.core.ContainerFactory.getDescriptionByNameWithException(java.lang.String;)org.eclipse.ecf.core.ContainerTypeDescription;2
private ContainerTypeDescription getDescriptionByNameWithException(String containerTypeDescriptionName) throws ContainerCreateException {
    ContainerTypeDescription typeDescription = getDescriptionByName(containerTypeDescriptionName);
    if (typeDescription == null)
        throw new  ContainerCreateException("Container type description with name=" + containerTypeDescriptionName + " not found.  This may indicate that the desired provider is not available or not startable within runtime.");
    return typeDescription;
}
---------------Client-------------------
method: org.eclipse.ecf.core.identity.IDFactory.createID(java.lang.String;Ajava.lang.Object;)org.eclipse.ecf.core.identity.ID;3
public ID createID(String namespaceName, Object[] args) throws IDCreateException {
    Namespace n = getNamespaceByName(namespaceName);
    if (n == null)
        throw new  IDCreateException("Namespace " + namespaceName + " not found");
    return createID(n, args);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatter.formatClassBodyDeclarations(java.lang.String;ILjava.lang.String;Aorg.eclipse.jface.text.IRegion;Z)org.eclipse.text.edits.TextEdit;6
private TextEdit formatClassBodyDeclarations(String source, int indentationLevel, String lineSeparator, IRegion[] regions, boolean includeComments) {
    ASTNode[] bodyDeclarations = this.codeSnippetParsingUtil.parseClassBodyDeclarations(source.toCharArray(), getDefaultCompilerOptions(), true);
    if (bodyDeclarations == null) {
        return null;
    }
    return internalFormatClassBodyDeclarations(source, indentationLevel, lineSeparator, bodyDeclarations, regions, includeComments);
}
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatter.internalFormatClassBodyDeclarations(java.lang.String;ILjava.lang.String;Aorg.eclipse.jdt.internal.compiler.ast.ASTNode;Aorg.eclipse.jface.text.IRegion;Z)org.eclipse.text.edits.TextEdit;7
private TextEdit internalFormatClassBodyDeclarations(String source, int indentationLevel, String lineSeparator, ASTNode[] bodyDeclarations, IRegion[] regions, boolean includeComments) {
    if (lineSeparator != null) {
        this.preferences.line_separator = lineSeparator;
    } else {
        this.preferences.line_separator = Util.LINE_SEPARATOR;
    }
    this.preferences.initial_indentation_level = indentationLevel;
    this.newCodeFormatter = new  CodeFormatterVisitor(this.preferences, this.options, regions, this.codeSnippetParsingUtil, includeComments);
    return this.newCodeFormatter.format(source, bodyDeclarations);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.formatter.DefaultCodeFormatter.formatCompilationUnit(java.lang.String;ILjava.lang.String;Aorg.eclipse.jface.text.IRegion;Z)org.eclipse.text.edits.TextEdit;6
private TextEdit formatCompilationUnit(String source, int indentationLevel, String lineSeparator, IRegion[] regions, boolean includeComments) {
    CompilationUnitDeclaration compilationUnitDeclaration = this.codeSnippetParsingUtil.parseCompilationUnit(source.toCharArray(), getDefaultCompilerOptions(), true);
    if (lineSeparator != null) {
        this.preferences.line_separator = lineSeparator;
    } else {
        this.preferences.line_separator = Util.LINE_SEPARATOR;
    }
    this.preferences.initial_indentation_level = indentationLevel;
    this.newCodeFormatter = new  CodeFormatterVisitor(this.preferences, this.options, regions, this.codeSnippetParsingUtil, includeComments);
    return this.newCodeFormatter.format(source, compilationUnitDeclaration);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticArrayClone(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticArrayClone(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForArrayClone(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.LockManager$LockState.suspend(org.eclipse.core.internal.jobs.OrderedLock;)org.eclipse.core.internal.jobs.LockManager$LockState;1
protected static LockState suspend(OrderedLock lock) {
    LockState state = new  LockState();
    state.lock = lock;
    state.depth = lock.forceRelease();
    return state;
}
method: org.eclipse.core.internal.jobs.OrderedLock.forceRelease()I1
protected int forceRelease() {
    int oldDepth = depth;
    doRelease();
    return oldDepth;
}
---------------Client-------------------
method: org.eclipse.ui.internal.navigator.NavigatorPlugin.safeEvaluate(org.eclipse.core.expressions.Expression;org.eclipse.core.expressions.IEvaluationContext;)org.eclipse.core.expressions.EvaluationResult;2
public static EvaluationResult safeEvaluate(Expression expression, IEvaluationContext scope) {
    Evaluator evaluator = new  Evaluator();
    evaluator.expression = expression;
    evaluator.scope = scope;
    SafeRunner.run(evaluator);
    return evaluator.result;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMType.getDetailedNode()org.eclipse.jdt.internal.core.jdom.DOMNode;1
protected DOMNode getDetailedNode() {
    return (DOMNode) getFactory().createType(getContents());
}
method: org.eclipse.jdt.core.jdom.DOMFactory.createType(java.lang.String;)org.eclipse.jdt.core.jdom.IDOMType;2
public IDOMType createType(String sourceCode) {
    if (sourceCode == null) {
        return null;
    }
    return (new  DOMBuilder()).createType(sourceCode.toCharArray());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMethod.getRawParameterNames()Ajava.lang.String;1
public String[] getRawParameterNames() throws JavaModelException {
    IBinaryMethod info = (IBinaryMethod) getElementInfo();
    int paramCount = Signature.getParameterCount(new  String(info.getMethodDescriptor()));
    return getRawParameterNames(paramCount);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaProject.getNonJavaResources()Ajava.lang.Object;1
public Object[] getNonJavaResources() throws JavaModelException {
    return ((JavaProjectElementInfo) getElementInfo()).getNonJavaResources(this);
}
method: org.eclipse.jdt.internal.core.JavaProjectElementInfo.getNonJavaResources(org.eclipse.jdt.internal.core.JavaProject;)Ajava.lang.Object;2
Object[] getNonJavaResources(JavaProject project) {
    if (this.nonJavaResources == null) {
        this.nonJavaResources = computeNonJavaResources(project);
    }
    return this.nonJavaResources;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMethod.getReturnType()java.lang.String;1
public String getReturnType() throws JavaModelException {
    if (this.returnType == null) {
        IBinaryMethod info = (IBinaryMethod) getElementInfo();
        this.returnType = getReturnType(info);
    }
    return this.returnType;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.ResourceFilterEditDialog.getFilters()Aorg.eclipse.ui.ide.dialogs.UIResourceFilterDescription;1
public UIResourceFilterDescription[] getFilters() {
    return resourceFilterGroup.getFilters();
}
method: org.eclipse.ui.internal.ide.dialogs.ResourceFilterGroup.getFilters()Aorg.eclipse.ui.ide.dialogs.UIResourceFilterDescription;1
public UIResourceFilterDescription[] getFilters() {
    FilterCopy[] newFilters = filters.getChildren();
    UIResourceFilterDescription[] result = new UIResourceFilterDescription[newFilters.length];
    for (int i = 0; i < newFilters.length; i++) {
        result[i] = newFilters[i];
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.debug.ui.jres.LibraryContentProvider.getLibraries()Aorg.eclipse.jdt.launching.LibraryLocation;1
public LibraryLocation[] getLibraries() {
    LibraryLocation[] locations = new LibraryLocation[fLibraries.length];
    for (int i = 0; i < locations.length; i++) {
        locations[i] = fLibraries[i].toLibraryLocation();
    }
    return locations;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.SelectionButtonDialogFieldGroup.updateEnableState()V1
@Override
protected void updateEnableState() {
    super.updateEnableState();
    if (fButtons != null) {
        boolean enabled = isEnabled();
        for (int i = 0; i < fButtons.length; i++) {
            Button button = fButtons[i];
            if (isOkToUse(button)) {
                button.setEnabled(enabled && fButtonsEnabled[i]);
            }
        }
    }
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField.updateEnableState()V1
protected void updateEnableState() {
    if (fLabel != null) {
        fLabel.setEnabled(fEnabled);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.wizards.MethodStubsSelectionButtonGroup.updateEnableState()V1
protected void updateEnableState() {
    if (fLabel != null) {
        fLabel.setEnabled(fEnabled);
    }
    if (fButtons != null) {
        boolean enabled = isEnabled();
        for (int i = 0; i < fButtons.length; i++) {
            Button button = fButtons[i];
            if (isOkToUse(button)) {
                button.setEnabled(enabled && fButtonsEnabled[i]);
            }
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.FindBrokenNLSKeysAction.getCompilationUnit(org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;)org.eclipse.jdt.core.ICompilationUnit;1
private static ICompilationUnit getCompilationUnit(JavaEditor editor) {
    IWorkingCopyManager manager = JavaPlugin.getDefault().getWorkingCopyManager();
    ICompilationUnit cu = manager.getWorkingCopy(editor.getEditorInput());
    return cu;
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
method: org.eclipse.jdt.internal.core.search.JavaSearchDocument.getFile()org.eclipse.core.resources.IFile;1
private IFile getFile() {
    if (this.file == null)
        this.file = ResourcesPlugin.getWorkspace().getRoot().getFile(new  Path(getPath()));
    return this.file;
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.search.LocalHelpPage$3.checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent;)V2
public void checkStateChanged(CheckStateChangedEvent event) {
    handleCheckStateChange(event, contentTree, contentTreeContentProvider);
}
method: org.eclipse.help.ui.internal.search.LocalHelpPage.handleCheckStateChange(org.eclipse.jface.viewers.CheckStateChangedEvent;org.eclipse.jface.viewers.CheckboxTreeViewer;org.eclipse.jface.viewers.ITreeContentProvider;)V4
void handleCheckStateChange(final CheckStateChangedEvent event, final CheckboxTreeViewer tree, final ITreeContentProvider contentProvider) {
    BusyIndicator.showWhile(getShell().getDisplay(), new  Runnable() {

        public void run() {
            Object element = event.getElement();
            boolean state = event.getChecked();
            tree.setGrayed(element, false);
            if (isExpandable(element, contentProvider))
                setSubtreeChecked(element, state, state, tree, contentProvider);
            updateParentState(element, state, tree, contentProvider);
        }
    });
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoriesView$1$1.run()V1
public void run() {
    refreshViewer();
    getViewer().setSelection(new  StructuredSelection(root));
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSelectChannelConnector.setKeyPassword(java.lang.String;)V2
@Deprecated
public void setKeyPassword(String password) {
    _sslContextFactory.setKeyManagerPassword(password);
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.setKeyManagerPassword(java.lang.String;)V2
public void setKeyManagerPassword(String password) {
    checkNotStarted();
    _keyManagerPassword = Password.getPassword(KEYPASSWORD_PROPERTY, password, null);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.WorkspacePluginModelManager.processModelChanges()V1
@Override
protected void processModelChanges() {
    super.processModelChanges();
    processModelChanges("org.eclipse.pde.internal.core.IExtensionDeltaEvent", fChangedExtensions);
    fChangedExtensions = null;
}

---------------Library-------------------
method: org.eclipse.ui.internal.handlers.HandlerPersistence.dispose()V1
@Override
public final void dispose() {
    super.dispose();
    clearActivations(handlerService);
}
method: org.eclipse.ui.internal.services.RegistryPersistence.dispose()V1
@Override
public void dispose() {
    final IExtensionRegistry registry = Platform.getExtensionRegistry();
    registry.removeRegistryChangeListener(registryChangeListener);
    registryListenerAttached = false;
}
---------------Client-------------------
method: org.eclipse.jface.bindings.keys.KeySequenceText.clear()V1
public void clear() {
    final KeySequence oldKeySequence = keySequence;
    keySequence = KeySequence.getInstance();
    text.setText(EMPTY_STRING);
    firePropertyChangeEvent(oldKeySequence);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyClassBodyDeclarationsopt()V1
protected void consumeEmptyClassBodyDeclarationsopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.FileSelectionDialog$2.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    selectionGroup.setAllSelections(false);
}
method: org.eclipse.ui.internal.ide.misc.CheckboxTreeAndListGroup.setAllSelections(Z)V2
public void setAllSelections(final boolean selection) {
    BusyIndicator.showWhile(treeViewer.getControl().getDisplay(), new  Runnable() {

        public void run() {
            setTreeChecked(root, selection);
            listViewer.setAllChecked(selection);
        }
    });
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.breadcrumb.TreeViewerDropDown$5.treeExpanded(org.eclipse.jface.viewers.TreeExpansionEvent;)V2
@Override
public void treeExpanded(TreeExpansionEvent event) {
    tree.setRedraw(false);
    new  UIJob(tree.getDisplay(), IInternalDebugCoreConstants.EMPTY_STRING) {

        {
            setSystem(true);
        }

        @Override
        public IStatus runInUIThread(IProgressMonitor monitor) {
            if (!tree.isDisposed()) {
                try {
                    fDropDownSite.updateSize();
                } finally {
                    tree.setRedraw(true);
                }
            }
            return Status.OK_STATUS;
        }
    }.schedule();
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.provisional.Factory.methodDescriptor(java.lang.String;java.lang.String;java.lang.String;)org.eclipse.pde.api.tools.internal.provisional.descriptors.IMethodDescriptor;3
public static IMethodDescriptor methodDescriptor(String typename, String name, String signature) {
    IReferenceTypeDescriptor type = typeDescriptor(typename);
    return type.getMethod(name, signature);
}
method: org.eclipse.pde.api.tools.internal.provisional.Factory.typeDescriptor(java.lang.String;)org.eclipse.pde.api.tools.internal.provisional.descriptors.IReferenceTypeDescriptor;1
public static IReferenceTypeDescriptor typeDescriptor(String fullyQualifiedName) {
    String packageName = Signatures.getPackageName(fullyQualifiedName);
    String typeName = Signatures.getTypeName(fullyQualifiedName);
    return packageDescriptor(packageName).getType(typeName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.HierarchyProcessor.getUnindentedText(java.lang.String;org.eclipse.jdt.core.ICompilationUnit;)java.lang.String;2
protected static String getUnindentedText(final String text, final ICompilationUnit declaringCu) throws JavaModelException {
    final String[] lines = Strings.convertIntoLines(text);
    Strings.trimIndentation(lines, declaringCu.getJavaProject(), false);
    return Strings.concatenate(lines, StubUtility.getLineDelimiterUsed(declaringCu));
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.ResourceModelContentProvider.propertyChanged(org.eclipse.team.core.diff.IDiffTree;IAorg.eclipse.core.runtime.IPath;)V4
public void propertyChanged(IDiffTree tree, final int property, final IPath[] paths) {
    Utils.syncExec(new  Runnable() {

        public void run() {
            ISynchronizationContext context = getContext();
            if (context != null) {
                updateLabels(context, paths);
            }
        }
    }, (StructuredViewer) getViewer());
}
method: org.eclipse.team.internal.ui.Utils.syncExec(java.lang.Runnable;org.eclipse.jface.viewers.StructuredViewer;)V2
public static void syncExec(final Runnable r, StructuredViewer v) {
    if (v == null)
        return;
    final Control ctrl = v.getControl();
    syncExec(r, ctrl);
}
---------------Client-------------------
method: org.eclipse.core.databinding.ListBinding.updateModelToTarget()V1
public void updateModelToTarget() {
    final IObservableList modelList = (IObservableList) getModel();
    modelList.getRealm().exec(new  Runnable() {

        public void run() {
            ListDiff diff = Diffs.computeListDiff(Collections.EMPTY_LIST, modelList);
            doUpdate(modelList, (IObservableList) getTarget(), diff, modelToTarget, true, true);
        }
    });
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.ResourceFilterGroup.setFilters(Aorg.eclipse.core.resources.IResourceFilterDescription;)V2
public void setFilters(IResourceFilterDescription[] filters) {
    initialFilters = new UIResourceFilterDescription[filters.length];
    for (int i = 0; i < filters.length; i++) initialFilters[i] = UIResourceFilterDescription.wrap(filters[i]);
}
method: org.eclipse.ui.ide.dialogs.UIResourceFilterDescription.wrap(org.eclipse.core.resources.IResourceFilterDescription;)org.eclipse.ui.ide.dialogs.UIResourceFilterDescription;1
public static UIResourceFilterDescription wrap(final IResourceFilterDescription iResourceFilterDescription) {
    return new  UIResourceFilterDescription() {

        public FileInfoMatcherDescription getFileInfoMatcherDescription() {
            return iResourceFilterDescription.getFileInfoMatcherDescription();
        }

        public IPath getPath() {
            return iResourceFilterDescription.getResource().getProjectRelativePath();
        }

        public IProject getProject() {
            return iResourceFilterDescription.getResource().getProject();
        }

        public int getType() {
            return iResourceFilterDescription.getType();
        }
    };
}
---------------Client-------------------
method: org.eclipse.ant.core.AntCorePreferences.setAntURLs(Ajava.net.URL;)V2
@Deprecated
public void setAntURLs(URL[] urls) {
    antHomeEntries = new IAntClasspathEntry[urls.length];
    for (int i = 0; i < urls.length; i++) {
        URL url = urls[i];
        IAntClasspathEntry entry = new  AntClasspathEntry(url);
        antHomeEntries[i] = entry;
    }
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.swt.WorkbenchSWTActivator.getStateLocationOrNull()org.eclipse.core.runtime.IPath;1
private IPath getStateLocationOrNull() {
    try {
        return InternalPlatform.getDefault().getStateLocation(context.getBundle(), true);
    } catch (IllegalStateException e) {
        return null;
    }
}
method: org.eclipse.osgi.internal.framework.BundleContextImpl.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    checkValid();
    return getBundleImpl();
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker.check(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.ltk.core.refactoring.RefactoringStatus;2
public RefactoringStatus check(IProgressMonitor monitor) throws CoreException {
    IStatus status = ResourceChangeValidator.getValidator().validateChange(fDeltaFactory.getDelta(), monitor);
    return createFrom(status);
}

---------------Library-------------------
method: org.apache.jasper.xmlparser.XMLString.setValues(org.apache.jasper.xmlparser.XMLString;)V2
public void setValues(XMLString s) {
    setValues(s.ch, s.offset, s.length);
}
method: org.apache.jasper.xmlparser.XMLString.setValues(ACII)V4
public void setValues(char[] ch, int offset, int length) {
    this.ch = ch;
    this.offset = offset;
    this.length = length;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.breakpoints.BreakpointContainer.copyOrganizers(org.eclipse.debug.internal.ui.views.breakpoints.BreakpointContainer;org.eclipse.debug.internal.ui.views.breakpoints.BreakpointContainer;)V2
public static void copyOrganizers(BreakpointContainer destContainer, BreakpointContainer sourceContainer) {
    destContainer.fNesting = sourceContainer.fNesting;
    destContainer.fOrganizer = sourceContainer.fOrganizer;
    destContainer.fCategory = sourceContainer.fCategory;
}

---------------Library-------------------
method: org.eclipse.ui.internal.registry.WorkingSetRegistry.load()V1
public void load() {
    WorkingSetRegistryReader reader = new  WorkingSetRegistryReader();
    reader.readWorkingSets(Platform.getExtensionRegistry(), this);
}
method: org.eclipse.ui.internal.registry.WorkingSetRegistryReader.readWorkingSets(org.eclipse.core.runtime.IExtensionRegistry;org.eclipse.ui.internal.registry.WorkingSetRegistry;)V3
public void readWorkingSets(IExtensionRegistry in, WorkingSetRegistry out) {
    registry = out;
    readRegistry(in, PlatformUI.PLUGIN_ID, IWorkbenchRegistryConstants.PL_WORKINGSETS);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.extension.ExtensionEditorWizard.loadWizardCollection()V1
private void loadWizardCollection() {
    NewExtensionRegistryReader reader = new  NewExtensionRegistryReader(true);
    wizards = reader.readRegistry(PDEPlugin.getPluginId(), PLUGIN_POINT, true);
}

---------------Library-------------------
method: org.eclipse.ant.core.AntCorePlugin.getNewClassLoader()java.lang.ClassLoader;1
public ClassLoader getNewClassLoader() {
    AntCorePreferences corePreferences = getPreferences();
    return getNewClassLoader(false, corePreferences.getURLs());
}
method: org.eclipse.ant.core.AntCorePlugin.getNewClassLoader(ZAjava.net.URL;)java.net.URLClassLoader;3
public URLClassLoader getNewClassLoader(boolean allowLoading, URL[] urls) {
    AntCorePreferences corePreferences = getPreferences();
    ClassLoader[] pluginLoaders = corePreferences.getPluginClassLoaders();
    AntClassLoader loader = new  AntClassLoader(urls, pluginLoaders);
    loader.allowPluginClassLoadersToLoadAnt(allowLoading);
    return loader;
}
---------------Client-------------------
method: org.eclipse.jface.resource.FontDescriptor.copy(org.eclipse.swt.graphics.FontData;)org.eclipse.swt.graphics.FontData;1
public static FontData copy(FontData next) {
    FontData result = new  FontData(next.getName(), next.getHeight(), next.getStyle());
    result.setLocale(next.getLocale());
    return result;
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
method: org.eclipse.core.databinding.Binding$1.handleDispose(org.eclipse.core.databinding.observable.DisposeEvent;)V2
public void handleDispose(DisposeEvent staleEvent) {
    Binding.this.context.getValidationRealm().exec(new  Runnable() {

        public void run() {
            if (!isDisposed())
                dispose();
        }
    });
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.tooManyMethods(org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;)V2
public void tooManyMethods(TypeDeclaration typeDeclaration) {
    this.handle(IProblem.TooManyMethods, new String[] { new  String(typeDeclaration.binding.readableName()) }, new String[] { new  String(typeDeclaration.binding.shortReadableName()) }, ProblemSeverities.Abort | ProblemSeverities.Error | ProblemSeverities.Fatal, typeDeclaration.sourceStart, typeDeclaration.sourceEnd);
}
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.handle(IAjava.lang.String;Ajava.lang.String;III)V7
private void handle(int problemId, String[] problemArguments, String[] messageArguments, int severity, int problemStartPosition, int problemEndPosition) {
    this.handle(problemId, problemArguments, 0, messageArguments, severity, problemStartPosition, problemEndPosition);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.illegalTypeForExplicitThis(org.eclipse.jdt.internal.compiler.ast.Receiver;org.eclipse.jdt.internal.compiler.lookup.TypeBinding;)V3
public void illegalTypeForExplicitThis(Receiver receiver, TypeBinding expectedType) {
    this.handle(IProblem.IllegalTypeForExplicitThis, new String[] { new  String(expectedType.readableName()) }, new String[] { new  String(expectedType.shortReadableName()) }, receiver.type.sourceStart, receiver.type.sourceEnd);
}

---------------Library-------------------
method: org.apache.felix.gogo.shell.Builtin.format(org.apache.felix.service.command.CommandSession;java.lang.Object;)java.lang.CharSequence;3
public CharSequence format(CommandSession session, Object arg) {
    CharSequence result = session.format(arg, Converter.INSPECT);
    System.out.println(result);
    return result;
}
method: org.apache.felix.gogo.runtime.CommandSessionImpl.format(java.lang.Object;I)java.lang.CharSequence;3
public CharSequence format(Object result, int inspect) {
    try {
        return format(result, inspect, this);
    } catch (Exception e) {
        return "<can not format " + result + ":" + e;
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.parts.WizardCheckboxTablePart.createStructuredViewer(org.eclipse.swt.widgets.Composite;ILorg.eclipse.ui.forms.widgets.FormToolkit;)org.eclipse.jface.viewers.StructuredViewer;4
protected StructuredViewer createStructuredViewer(Composite parent, int style, FormToolkit toolkit) {
    StructuredViewer viewer = super.createStructuredViewer(parent, style, toolkit);
    viewer.setComparator(ListUtil.NAME_COMPARATOR);
    return viewer;
}

---------------Library-------------------
method: org.eclipse.ui.actions.DeleteResourceAction.confirmDelete(Aorg.eclipse.core.resources.IResource;)Z2
private boolean confirmDelete(IResource[] resources) {
    if (containsOnlyProjects(resources)) {
        return confirmDeleteProjects(resources);
    }
    return confirmDeleteNonProjects(resources);
}
method: org.eclipse.ui.actions.DeleteResourceAction.containsOnlyProjects(Aorg.eclipse.core.resources.IResource;)Z2
private boolean containsOnlyProjects(IResource[] resources) {
    int types = getSelectedResourceTypes(resources);
    return types == IResource.PROJECT;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.TypeInfoFilter.matchesCachedResult(org.eclipse.jdt.core.search.TypeNameMatch;)Z2
public boolean matchesCachedResult(TypeNameMatch type) {
    if (!(matchesPackage(type) && matchesFilterExtension(type)))
        return false;
    return matchesName(type);
}

---------------Library-------------------
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
---------------Client-------------------
method: org.eclipse.debug.ui.StringVariableSelectionDialog.okPressed()V1
@Override
protected void okPressed() {
    fArgumentValue = fArgumentText.getText().trim();
    super.okPressed();
}

---------------Library-------------------
method: org.apache.felix.gogo.runtime.threadio.ThreadPrintStream.append(C)java.io.PrintStream;2
public PrintStream append(char c) {
    return getCurrent().append(c);
}
method: org.apache.felix.gogo.runtime.threadio.ThreadPrintStream.getCurrent()java.io.PrintStream;1
public PrintStream getCurrent() {
    PrintStream out = map.get();
    if (out != null) {
        return out;
    }
    return dflt;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareUIPlugin$CompareRegistry.searchAll(java.lang.String;)java.util.List;2
List searchAll(String extension) {
    if (fExtensionMap != null)
        return (List) fExtensionMap.get(normalizeCase(extension));
    return null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.wizards.cheatsheet.NewCategoryNameDialog.createUINameField(org.eclipse.swt.widgets.Composite;)V2
private void createUINameField(Composite parent) {
    createUINameLabel(parent);
    createUINameText(parent);
}
method: org.eclipse.pde.internal.ua.ui.wizards.cheatsheet.NewCategoryNameDialog.createUINameText(org.eclipse.swt.widgets.Composite;)V2
private void createUINameText(Composite parent) {
    int style = SWT.BORDER;
    fNameText = new  Text(parent, style);
    fNameText.setLayoutData(new  GridData(GridData.FILL_HORIZONTAL));
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.cleanup.CleanUpTabPage.intent(org.eclipse.swt.widgets.Composite;)V2
protected void intent(Composite group) {
    Label l = new  Label(group, SWT.NONE);
    GridData gd = new  GridData();
    gd.widthHint = fPixelConverter.convertWidthInCharsToPixels(4);
    l.setLayoutData(gd);
}

---------------Library-------------------
method: org.eclipse.compare.SharedDocumentAdapter.getDocumentProvider(org.eclipse.ui.IEditorInput;)org.eclipse.ui.texteditor.IDocumentProvider;1
public static IDocumentProvider getDocumentProvider(IEditorInput input) {
    return DocumentProviderRegistry.getDefault().getDocumentProvider(input);
}
method: org.eclipse.ui.texteditor.DocumentProviderRegistry.getDefault()org.eclipse.ui.texteditor.DocumentProviderRegistry;0
public static DocumentProviderRegistry getDefault() {
    if (fgRegistry == null)
        fgRegistry = new  DocumentProviderRegistry();
    return fgRegistry;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.impl.AssistParser.consumeClassBodyopt()V1
protected void consumeClassBodyopt() {
    super.consumeClassBodyopt();
    popElement(K_SELECTOR);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeClassBodyopt()V1
protected void consumeClassBodyopt() {
    pushOnAstStack(null);
    this.endPosition = this.rParenPos;
}
---------------Client-------------------
method: org.apache.lucene.analysis.br.BrazilianAnalyzer.setStemExclusionTable(Ajava.lang.String;)V2
@Deprecated
public void setStemExclusionTable(String... exclusionlist) {
    excltable = StopFilter.makeStopSet(matchVersion, exclusionlist);
    setPreviousTokenStream(null);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.SWTFactory.createScrolledComposite(org.eclipse.swt.widgets.Composite;IIII)org.eclipse.ui.forms.widgets.SharedScrolledComposite;5
public static SharedScrolledComposite createScrolledComposite(Composite parent, int columns, int hspan, int marginwidth, int marginheight) {
    return createScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL, columns, hspan, marginwidth, marginheight);
}
method: org.eclipse.pde.internal.ui.SWTFactory.createScrolledComposite(org.eclipse.swt.widgets.Composite;IIIII)org.eclipse.ui.forms.widgets.SharedScrolledComposite;6
public static SharedScrolledComposite createScrolledComposite(Composite parent, int style, int columns, int hspan, int marginwidth, int marginheight) {
    SharedScrolledComposite comp = new  SharedScrolledComposite(parent, style) {
    };
    GridLayout layout = new  GridLayout(columns, false);
    layout.marginHeight = marginheight;
    layout.marginWidth = marginwidth;
    comp.setLayout(layout);
    GridData gd = new  GridData(GridData.FILL_BOTH);
    gd.horizontalSpan = hspan;
    comp.setLayoutData(gd);
    comp.setExpandHorizontal(true);
    comp.setExpandVertical(true);
    return comp;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.ui.internal.SWTFactory.createScrolledComposite(org.eclipse.swt.widgets.Composite;IIII)org.eclipse.ui.forms.widgets.SharedScrolledComposite;5
public static SharedScrolledComposite createScrolledComposite(Composite parent, int columns, int hspan, int marginwidth, int marginheight) {
    SharedScrolledComposite comp = new  SharedScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL) {
    };
    GridLayout layout = new  GridLayout(columns, false);
    layout.marginHeight = marginheight;
    layout.marginWidth = marginwidth;
    comp.setLayout(layout);
    GridData gd = new  GridData(GridData.FILL_BOTH);
    gd.horizontalSpan = hspan;
    comp.setLayoutData(gd);
    comp.setExpandHorizontal(true);
    comp.setExpandVertical(true);
    return comp;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.site.VersionableObject.restoreProperty(java.lang.String;java.lang.Object;java.lang.Object;)V4
public void restoreProperty(String name, Object oldValue, Object newValue) throws CoreException {
    if (name.equals(P_VERSION)) {
        setVersion(newValue != null ? newValue.toString() : null);
    } else
        super.restoreProperty(name, oldValue, newValue);
}
method: org.eclipse.pde.internal.core.site.IdentifiableObject.restoreProperty(java.lang.String;java.lang.Object;java.lang.Object;)V4
public void restoreProperty(String name, Object oldValue, Object newValue) throws CoreException {
    if (name.equals(P_ID)) {
        setId(newValue != null ? newValue.toString() : null);
    } else
        super.restoreProperty(name, oldValue, newValue);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureInfo.restoreProperty(java.lang.String;java.lang.Object;java.lang.Object;)V4
public void restoreProperty(String name, Object oldValue, Object newValue) throws CoreException {
    if (name.equals(P_DESC)) {
        setDescription(newValue != null ? newValue.toString() : null);
    } else if (name.equals(P_URL)) {
        setURL(newValue != null ? newValue.toString() : null);
    } else
        super.restoreProperty(name, oldValue, newValue);
}

---------------Library-------------------
method: org.apache.felix.gogo.runtime.threadio.ThreadPrintStream.append(java.lang.CharSequence;)java.io.PrintStream;2
public PrintStream append(CharSequence csq) {
    return getCurrent().append(csq);
}
method: org.apache.felix.gogo.runtime.threadio.ThreadPrintStream.getCurrent()java.io.PrintStream;1
public PrintStream getCurrent() {
    PrintStream out = map.get();
    if (out != null) {
        return out;
    }
    return dflt;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareUIPlugin$CompareRegistry.searchAll(java.lang.String;)java.util.List;2
List searchAll(String extension) {
    if (fExtensionMap != null)
        return (List) fExtensionMap.get(normalizeCase(extension));
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.reorg.ReorgPolicyFactory$NewNameProposer.isNewNameOk(org.eclipse.jdt.core.IPackageFragmentRoot;java.lang.String;)Z2
private static boolean isNewNameOk(IPackageFragmentRoot root, String newName) {
    return !root.getPackageFragment(newName).exists();
}
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.getPackageFragment(java.lang.String;)org.eclipse.jdt.core.IPackageFragment;2
public IPackageFragment getPackageFragment(String packageName) {
    String[] pkgName = Util.getTrimmedSimpleNames(packageName);
    return getPackageFragment(pkgName);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.ResourceTree.isNameChange(org.eclipse.core.resources.IProject;org.eclipse.core.resources.IProjectDescription;)Z3
private boolean isNameChange(IProject project, IProjectDescription description) {
    return !project.getName().equals(description.getName());
}

---------------Library-------------------
method: org.eclipse.equinox.p2.ui.RepositoryManipulationPage$27.getKnownRepositories(org.eclipse.equinox.p2.operations.ProvisioningSession;)Ajava.net.URI;2
public URI[] getKnownRepositories(ProvisioningSession session) {
    return RepositoryManipulationPage.this.getKnownRepositories();
}
method: org.eclipse.equinox.p2.ui.RepositoryManipulationPage.getKnownRepositories()Ajava.net.URI;1
URI[] getKnownRepositories() {
    MetadataRepositoryElement[] elements = getElements();
    URI[] locations = new URI[elements.length];
    for (int i = 0; i < elements.length; i++) locations[i] = elements[i].getLocation();
    return locations;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPUserLibraryElement$UpdatedClasspathContainer.getClasspathEntries()Aorg.eclipse.jdt.core.IClasspathEntry;1
public IClasspathEntry[] getClasspathEntries() {
    CPListElement[] children = getChildren();
    IClasspathEntry[] entries = new IClasspathEntry[children.length];
    for (int i = 0; i < entries.length; i++) {
        entries[i] = children[i].getClasspathEntry();
    }
    return entries;
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.MarkerFilter.findMarkerType(java.lang.String;)org.eclipse.ui.views.markers.internal.MarkerType;2
MarkerType findMarkerType(String typeName) {
    return MarkerTypesModel.getInstance().getType(typeName);
}
method: org.eclipse.ui.views.markers.internal.MarkerTypesModel.getInstance()org.eclipse.ui.views.markers.internal.MarkerTypesModel;0
public static MarkerTypesModel getInstance() {
    if (instance == null) {
        instance = new  MarkerTypesModel();
    }
    return instance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.rebuildFilters()V1
protected void rebuildFilters() {
    filters = FILTERS_CHANGED;
    enabledFilters = FILTERS_CHANGED;
    requestMarkerUpdate();
}
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.requestMarkerUpdate()V1
void requestMarkerUpdate() {
    if (builder != null) {
        builder.scheduleUpdate(0L);
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.ProjectInfo.setDescription(org.eclipse.core.internal.resources.ProjectDescription;)V2
public void setDescription(ProjectDescription value) {
    if (description != null) {
        ICommand[] oldSpec = description.buildSpec;
        ICommand[] newSpec = value.buildSpec;
        value.buildSpec = oldSpec;
        value.setBuildSpec(newSpec);
    }
    description = value;
}

---------------Library-------------------
method: org.eclipse.ui.internal.WWinPluginAction.setChecked(Z)V2
@Override
public void setChecked(boolean checked) {
    super.setChecked(checked);
    if (retargetAction != null) {
        retargetAction.setChecked(checked);
    }
}
method: org.eclipse.ui.actions.RetargetAction.setChecked(Z)V2
@Override
public void setChecked(boolean checked) {
    super.setChecked(checked);
    if (handler != null) {
        handler.setChecked(checked);
    }
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.ExpandableComposite.setFont(org.eclipse.swt.graphics.Font;)V2
public void setFont(Font font) {
    super.setFont(font);
    if (textLabel != null)
        textLabel.setFont(font);
    if (toggle != null)
        toggle.setFont(font);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticFieldWriteAccessMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticFieldWriteAccessMethod(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForFieldWriteAccess(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.apache.felix.gogo.shell.Activator.start(org.osgi.framework.BundleContext;)V2
public void start(final BundleContext ctxt) throws Exception {
    context = ctxt;
    commandProcessorTracker = processorTracker();
}
method: org.apache.felix.gogo.shell.Activator.processorTracker()org.osgi.util.tracker.ServiceTracker;1
private ServiceTracker processorTracker() {
    ServiceTracker t = new  ServiceTracker(context, CommandProcessor.class.getName(), null) {

        @Override
        public Object addingService(ServiceReference reference) {
            CommandProcessor processor = (CommandProcessor) super.addingService(reference);
            startShell(context, processor);
            return processor;
        }

        @Override
        public void removedService(ServiceReference reference, Object service) {
            if (thread != null) {
                thread.interrupt();
            }
            super.removedService(reference, service);
        }
    };
    t.open();
    return t;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.jsp.jasper.registry.Activator.start(org.osgi.framework.BundleContext;)V2
public void start(BundleContext context) throws Exception {
    this.context = context;
    packageAdminTracker = new  ServiceTracker(context, PackageAdmin.class.getName(), this);
    packageAdminTracker.open();
}

---------------Library-------------------
method: org.eclipse.ui.internal.BrandingProperties.getImage(java.lang.String;org.osgi.framework.Bundle;)org.eclipse.jface.resource.ImageDescriptor;2
public static ImageDescriptor getImage(String value, Bundle definingBundle) {
    URL url = getUrl(value, definingBundle);
    return url == null ? null : ImageDescriptor.createFromURL(url);
}
method: org.eclipse.ui.internal.BrandingProperties.getUrl(java.lang.String;org.osgi.framework.Bundle;)java.net.URL;2
public static URL getUrl(String value, Bundle definingBundle) {
    try {
        if (value != null) {
            return new  URL(value);
        }
    } catch (MalformedURLException e) {
        if (definingBundle != null) {
            return Platform.find(definingBundle, new  Path(value));
        }
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.core.internal.model.RegistryResolver.getVersionIdentifier(org.eclipse.core.runtime.model.PluginPrerequisiteModel;)org.eclipse.core.runtime.PluginVersionIdentifier;2
private PluginVersionIdentifier getVersionIdentifier(PluginPrerequisiteModel prereq) {
    String version = prereq.getVersion();
    return version == null ? null : new  PluginVersionIdentifier(version);
}

---------------Library-------------------
method: org.eclipse.swt.widgets.TableItem.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    font = null;
    cellFont = null;
}
method: org.eclipse.swt.widgets.Item.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    text = null;
    image = null;
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.observable.masterdetail.SetDetailValueObservableMap.dispose()V1
public synchronized void dispose() {
    super.dispose();
    observableValueFactory = null;
    detailObservableValueMap = null;
    detailStaleListener = null;
    staleDetailObservables = null;
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.HelpActivitySupport.getShowAllMessage()java.lang.String;1
public String getShowAllMessage() {
    return activityDescriptor.getShowAllMessage();
}
method: org.eclipse.help.ui.internal.HelpActivitySupport$ActivityDescriptor.getShowAllMessage()java.lang.String;1
public String getShowAllMessage() {
    if (config == null)
        return null;
    IConfigurationElement child = getChild("showAllMessage");
    if (child != null)
        return child.getValue();
    return null;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.ToolItem.getParent()org.eclipse.swt.widgets.ToolBar;1
public ToolBar getParent() {
    checkWidget();
    if (parent == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return parent;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.mappings.ChangeSetActionProvider.syncExec(java.lang.Runnable;)V2
void syncExec(final Runnable runnable) {
    final Control ctrl = getSynchronizePageConfiguration().getPage().getViewer().getControl();
    Utils.syncExec(runnable, ctrl);
}
method: org.eclipse.team.internal.ui.Utils.syncExec(java.lang.Runnable;org.eclipse.swt.widgets.Control;)V2
public static void syncExec(final Runnable r, final Control ctrl) {
    if (ctrl != null && !ctrl.isDisposed()) {
        ctrl.getDisplay().syncExec(new  Runnable() {

            public void run() {
                if (!ctrl.isDisposed()) {
                    BusyIndicator.showWhile(ctrl.getDisplay(), r);
                }
            }
        });
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.ChangeSetActionGroup.syncExec(java.lang.Runnable;)V2
private void syncExec(final Runnable runnable) {
    final Control ctrl = getConfiguration().getPage().getViewer().getControl();
    if (ctrl != null && !ctrl.isDisposed()) {
        ctrl.getDisplay().syncExec(new  Runnable() {

            public void run() {
                if (!ctrl.isDisposed()) {
                    runnable.run();
                }
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Control.getAccessible()org.eclipse.swt.accessibility.Accessible;1
public Accessible getAccessible() {
    checkWidget();
    return _getAccessible();
}
method: org.eclipse.swt.widgets.Control._getAccessible()org.eclipse.swt.accessibility.Accessible;1
Accessible _getAccessible() {
    if (accessible == null) {
        accessible = Accessible.internal_new_Accessible(this);
    }
    return accessible;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$DiagnosticWrapper.getChildren()java.util.List;1
public List<Diagnostic> getChildren() {
    if (unmodifiableWrappedChildren == null) {
        unmodifiableWrappedChildren = Collections.unmodifiableList(basicGetChildren());
    }
    return unmodifiableWrappedChildren;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSPerspective.createInitialLayout(org.eclipse.ui.IPageLayout;)V2
public void createInitialLayout(IPageLayout layout) {
    defineActions(layout);
    defineLayout(layout);
}
method: org.eclipse.team.internal.ccvs.ui.CVSPerspective.defineActions(org.eclipse.ui.IPageLayout;)V2
public void defineActions(IPageLayout layout) {
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.project");
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
    layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
    layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
    layout.addShowViewShortcut(IHistoryView.VIEW_ID);
    layout.addShowViewShortcut(RepositoriesView.VIEW_ID);
    layout.addShowViewShortcut(ISynchronizeView.VIEW_ID);
    layout.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective");
    layout.addPerspectiveShortcut("org.eclipse.team.ui.TeamSynchronizingPerspective");
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.target.TargetPlatformService.initializeEnvironmentInfo(org.eclipse.pde.internal.core.PDEPreferencesManager;org.eclipse.pde.core.target.ITargetDefinition;)V3
@SuppressWarnings("deprecation")
private void initializeEnvironmentInfo(PDEPreferencesManager preferences, ITargetDefinition target) {
    target.setOS(getValueOrNull(preferences.getString(ICoreConstants.OS)));
    target.setWS(getValueOrNull(preferences.getString(ICoreConstants.WS)));
    target.setNL(getValueOrNull(preferences.getString(ICoreConstants.NL)));
    target.setArch(getValueOrNull(preferences.getString(ICoreConstants.ARCH)));
}

---------------Library-------------------
method: org.eclipse.jface.contentassist.SubjectControlContentAssistant.install(org.eclipse.jface.contentassist.IContentAssistSubjectControl;)V2
public void install(IContentAssistSubjectControl contentAssistSubjectControl) {
    Assert.isNotNull(contentAssistSubjectControl);
    super.install(contentAssistSubjectControl);
}
method: org.eclipse.jface.text.contentassist.ContentAssistant.install(org.eclipse.jface.contentassist.IContentAssistSubjectControl;)V2
protected void install(IContentAssistSubjectControl contentAssistSubjectControl) {
    fContentAssistSubjectControl = contentAssistSubjectControl;
    fContentAssistSubjectControlAdapter = new  ContentAssistSubjectControlAdapter(fContentAssistSubjectControl);
    install();
}
---------------Client-------------------
method: org.eclipse.ui.internal.cheatsheets.views.Page.init(org.eclipse.swt.widgets.Display;)V2
protected void init(Display display) {
    toolkit = new  FormToolkit(display);
    backgroundColor = toolkit.getColors().getBackground();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.ImportPage$P2ImportIUPatternFilter.setPattern(java.lang.String;)V2
public void setPattern(String patternString) {
    super.setPattern(patternString);
    this.patternString = patternString;
}
method: org.eclipse.ui.dialogs.PatternFilter.setPattern(java.lang.String;)V2
public void setPattern(String patternString) {
    if ("org.eclipse.ui.keys.optimization.true".equals(patternString)) {
        useEarlyReturnIfMatcherIsNull = true;
        return;
    } else if ("org.eclipse.ui.keys.optimization.false".equals(patternString)) {
        useEarlyReturnIfMatcherIsNull = false;
        return;
    }
    clearCaches();
    if (patternString == null || patternString.equals("")) {
        matcher = null;
    } else {
        String pattern = patternString + "*";
        if (includeLeadingWildcard) {
            pattern = "*" + pattern;
        }
        matcher = new  StringMatcher(pattern, true, false);
    }
}
---------------Client-------------------
method: org.eclipse.jface.text.templates.TemplateTranslator.fail(java.lang.String;)V2
private void fail(String message) throws TemplateException {
    fErrorMessage = message;
    throw new  TemplateException(message);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexWriter.addDocuments(java.util.Collection;org.apache.lucene.analysis.Analyzer;)V3
public void addDocuments(Collection<Document> docs, Analyzer analyzer) throws CorruptIndexException, IOException {
    updateDocuments(null, docs, analyzer);
}
method: org.apache.lucene.index.IndexWriter.updateDocuments(org.apache.lucene.index.Term;java.util.Collection;org.apache.lucene.analysis.Analyzer;)V4
public void updateDocuments(Term delTerm, Collection<Document> docs, Analyzer analyzer) throws CorruptIndexException, IOException {
    ensureOpen();
    try {
        boolean success = false;
        boolean doFlush = false;
        try {
            doFlush = docWriter.updateDocuments(docs, analyzer, delTerm);
            success = true;
        } finally {
            if (!success && infoStream != null) {
                message("hit exception updating document");
            }
        }
        if (doFlush) {
            flush(true, false);
        }
    } catch (OutOfMemoryError oom) {
        handleOOM(oom, "updateDocuments");
    }
}
---------------Client-------------------
method: org.apache.lucene.index.IndexWriter.addDocument(org.apache.lucene.document.Document;org.apache.lucene.analysis.Analyzer;)V3
public void addDocument(Document doc, Analyzer analyzer) throws CorruptIndexException, IOException {
    ensureOpen();
    boolean doFlush = false;
    boolean success = false;
    try {
        try {
            doFlush = docWriter.updateDocument(doc, analyzer, null);
            success = true;
        } finally {
            if (!success && infoStream != null)
                message("hit exception adding document");
        }
        if (doFlush)
            flush(true, false);
    } catch (OutOfMemoryError oom) {
        handleOOM(oom, "addDocument");
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.ImportDeclaration;)V2
@Override
public void endVisit(ImportDeclaration node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getName());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.apache.lucene.util.NumericUtils.longToPrefixCoded(J)java.lang.String;1
public static String longToPrefixCoded(final long val) {
    return longToPrefixCoded(val, 0);
}
method: org.apache.lucene.util.NumericUtils.longToPrefixCoded(JI)java.lang.String;2
public static String longToPrefixCoded(final long val, final int shift) {
    final char[] buffer = new char[BUF_SIZE_LONG];
    final int len = longToPrefixCoded(val, shift, buffer);
    return new  String(buffer, 0, len);
}
---------------Client-------------------
method: org.apache.lucene.util.NumericUtils.intToPrefixCoded(II)java.lang.String;2
public static String intToPrefixCoded(final int val, final int shift) {
    final char[] buffer = new char[BUF_SIZE_INT];
    final int len = intToPrefixCoded(val, shift, buffer);
    return new  String(buffer, 0, len);
}

---------------Library-------------------
method: org.eclipse.team.internal.core.importing.BundleImporterExtension.performImport(Aorg.eclipse.team.core.ScmUrlImportDescription;org.eclipse.core.runtime.IProgressMonitor;)Aorg.eclipse.core.resources.IProject;3
public IProject[] performImport(ScmUrlImportDescription[] descriptions, IProgressMonitor monitor) throws CoreException {
    return getDelegate().performImport(descriptions, monitor);
}
method: org.eclipse.team.internal.core.importing.BundleImporterExtension.getDelegate()org.eclipse.team.core.importing.provisional.IBundleImporterDelegate;1
private synchronized IBundleImporterDelegate getDelegate() throws CoreException {
    if (delegate == null) {
        delegate = new  BundleImporterDelegate() {

            private Set supportedValues;

            private RepositoryProviderType providerType;

            protected Set getSupportedValues() {
                if (supportedValues == null) {
                    IConfigurationElement[] supported = element.getChildren("supports");
                    supportedValues = new  HashSet(supported.length);
                    for (int i = 0; i < supported.length; i++) {
                        supportedValues.add(supported[i].getAttribute("prefix"));
                    }
                }
                return supportedValues;
            }

            protected RepositoryProviderType getProviderType() {
                if (providerType == null)
                    providerType = RepositoryProviderType.getProviderType(element.getAttribute("repository"));
                return providerType;
            }
        };
    }
    return delegate;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.setLocalizedProperty(java.lang.String;java.lang.String;)java.lang.String;3
public String setLocalizedProperty(String key, String value) {
    if (localizedProperties == null)
        localizedProperties = new  OrderedProperties();
    return localizedProperties.put(key, value);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.ASTRewriteAnalyzer.isInsertBoundToPrevious(org.eclipse.jdt.core.dom.ASTNode;)Z2
final boolean isInsertBoundToPrevious(ASTNode node) {
    return this.eventStore.isInsertBoundToPrevious(node);
}
method: org.eclipse.jdt.internal.core.dom.rewrite.RewriteEventStore.isInsertBoundToPrevious(org.eclipse.jdt.core.dom.ASTNode;)Z2
public boolean isInsertBoundToPrevious(ASTNode node) {
    if (this.insertBoundToPrevious != null) {
        return this.insertBoundToPrevious.contains(node);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jface.text.TextSelection.getStartLine()I1
public int getStartLine() {
    try {
        if (fDocument != null)
            return fDocument.getLineOfOffset(fOffset);
    } catch (BadLocationException x) {
    }
    return -1;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.update.ThreadEventHandler.indexOf(org.eclipse.debug.core.model.IThread;)I2
protected int indexOf(IThread thread) {
    try {
        return indexOf(thread.getDebugTarget().getThreads(), thread);
    } catch (DebugException e) {
    }
    return -1;
}
method: org.eclipse.debug.internal.ui.viewers.update.DebugEventHandler.indexOf(Ajava.lang.Object;java.lang.Object;)I3
protected int indexOf(Object[] list, Object element) {
    for (int i = 0; i < list.length; i++) {
        if (element.equals(list[i])) {
            return i;
        }
    }
    return -1;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.containsPackage(org.eclipse.pde.internal.core.builders.IHeader;java.lang.String;)Z3
private boolean containsPackage(IHeader header, String name) {
    if (header != null) {
        ManifestElement[] elements = header.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getValue().equals(name))
                return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jface.text.rules.FastPartitioner.getLegalContentTypes()Ajava.lang.String;1
public String[] getLegalContentTypes() {
    return TextUtilities.copy(fLegalContentTypes);
}
method: org.eclipse.jface.text.TextUtilities.copy(Ajava.lang.String;)Ajava.lang.String;1
public static String[] copy(String[] array) {
    if (array != null) {
        String[] copy = new String[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.getSelectedResources()Aorg.eclipse.core.resources.IResource;1
IResource[] getSelectedResources() {
    IResource[] selected = selectedResources;
    IResource[] resources = new IResource[selected.length];
    System.arraycopy(selected, 0, resources, 0, selected.length);
    return resources;
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.model.ApiModelCache.flushCaches()V1
public void flushCaches() {
    if (fRootCache != null) {
        fRootCache.flush();
    }
    flushMemberCache();
}
method: org.eclipse.pde.api.tools.internal.model.ApiModelCache.flushMemberCache()V1
private void flushMemberCache() {
    if (this.fMemberTypeCache != null) {
        this.fMemberTypeCache.flush();
    }
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.ClasspathModel.removeAll()V1
public void removeAll() {
    if (fAntHomeEntry != null) {
        fAntHomeEntry.removeAll();
    }
    if (fUserGlobalEntry != null) {
        fUserGlobalEntry.removeAll();
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.refactoring.JUnitRenameParticipant$ChangeList.addAttributeChange(org.eclipse.jdt.internal.junit.refactoring.LaunchConfigurationContainer;java.lang.String;java.lang.String;)V4
public void addAttributeChange(LaunchConfigurationContainer config, String attributeName, String newValue) {
    addChange(new  LaunchConfigSetAttributeChange(config, attributeName, newValue, shouldFlagWarnings()));
}
method: org.eclipse.jdt.internal.junit.refactoring.JUnitRenameParticipant$ChangeList.addChange(org.eclipse.ltk.core.refactoring.Change;)V2
public void addChange(Change change) {
    if (change != null) {
        fChanges.add(change);
        fShouldFlagWarnings = false;
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.intro.impl.model.History.pushToHistory(java.lang.Object;)V2
private void pushToHistory(Object location) {
    history.add(new  HistoryObject(location));
    navigationLocation = getHistoryEndPosition();
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.memory.renderings.AsyncVirtualContentTableViewer.setTopIndex(java.lang.Object;)V2
public void setTopIndex(Object key) {
    fPendingTopIndexKey = key;
    attemptSetTopIndex();
}
method: org.eclipse.debug.internal.ui.views.memory.renderings.AsyncVirtualContentTableViewer.attemptSetTopIndex()V1
protected synchronized void attemptSetTopIndex() {
    if (fPendingTopIndexKey != null) {
        Object remaining = doAttemptSetTopIndex(fPendingTopIndexKey);
        if (remaining == null) {
            fPendingTopIndexKey = remaining;
        }
    }
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.views.RenameDialog.setOldName(java.lang.String;)V2
public void setOldName(String oldName) {
    this.oldName = oldName;
    if (text != null)
        text.setText(oldName);
    this.newName = oldName;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.SourceContainerWorkbookPage.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fSWTControl != null) {
        return fSWTControl.getShell();
    }
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getShell()org.eclipse.swt.widgets.Shell;1
final Shell getShell() {
    if (fEditor != null)
        return fEditor.getEditorSite().getShell();
    return JavaPlugin.getActiveWorkbenchShell();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.SynchronizerSyncInfoCache.getCachedFolderSync(org.eclipse.core.resources.IContainer;Z)org.eclipse.team.internal.ccvs.core.syncinfo.FolderSyncInfo;3
FolderSyncInfo getCachedFolderSync(IContainer container, boolean threadSafeAccess) throws CVSException {
    byte[] bytes = internalGetCachedSyncBytes(container);
    if (bytes == null)
        return null;
    return FolderSyncInfo.getFolderSyncInfo(bytes);
}
method: org.eclipse.team.internal.ccvs.core.resources.SynchronizerSyncInfoCache.internalGetCachedSyncBytes(org.eclipse.core.resources.IContainer;)AB2
private byte[] internalGetCachedSyncBytes(IContainer container) throws CVSException {
    try {
        return getWorkspaceSynchronizer().getSyncInfo(FOLDER_SYNC_KEY, container);
    } catch (CoreException e) {
        throw CVSException.wrapException(e);
    }
}
---------------Client-------------------
method: org.eclipse.osgi.internal.serviceregistry.ServiceRegistry.getService(org.eclipse.osgi.internal.framework.BundleContextImpl;org.eclipse.osgi.internal.serviceregistry.ServiceReferenceImpl;)java.lang.Object;3
public <S> S getService(BundleContextImpl context, ServiceReferenceImpl<S> reference) {
    checkGetServicePermission(reference);
    return reference.getRegistration().getService(context, ServiceConsumer.singletonConsumer);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeVariableDeclaratorIdParameter()V1
protected void consumeVariableDeclaratorIdParameter() {
    pushOnIntStack(1);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.mappings.ModelUpdateOperation.createMergeContext()org.eclipse.team.core.mapping.provider.SynchronizationContext;1
protected SynchronizationContext createMergeContext() {
    return WorkspaceSubscriberContext.createContext(getScopeManager(), getMergeType());
}
method: org.eclipse.team.internal.ccvs.ui.mappings.WorkspaceSubscriberContext.createContext(org.eclipse.team.core.mapping.ISynchronizationScopeManager;I)org.eclipse.team.internal.ccvs.ui.mappings.WorkspaceSubscriberContext;2
public static WorkspaceSubscriberContext createContext(ISynchronizationScopeManager manager, int type) {
    CVSWorkspaceSubscriber subscriber = CVSProviderPlugin.getPlugin().getCVSWorkspaceSubscriber();
    WorkspaceSubscriberContext mergeContext = new  WorkspaceSubscriberContext(subscriber, manager, type);
    mergeContext.initialize();
    return mergeContext;
}
---------------Client-------------------
method: org.eclipse.pde.core.plugin.TargetPlatform.getDefaultLocation()java.lang.String;0
public static String getDefaultLocation() {
    Location location = Platform.getInstallLocation();
    if (location != null) {
        URL url = Platform.getInstallLocation().getURL();
        IPath path = new  Path(url.getFile()).removeTrailingSeparator();
        return path.toOSString();
    }
    return "";
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.launcher.SourceLookupBlock$2.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent evt) {
    setDirty(true);
    updateLaunchConfigurationDialog();
}
method: org.eclipse.jdt.internal.debug.ui.launcher.SourceLookupBlock.updateLaunchConfigurationDialog()V1
@Override
protected void updateLaunchConfigurationDialog() {
    if (getLaunchConfigurationDialog() != null) {
        super.updateLaunchConfigurationDialog();
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.ViewerActionBuilder$ViewerContribution.dispose()V1
@Override
public void dispose() {
    if (selProvider != null) {
        selProvider.removeSelectionChangedListener(this);
    }
    disposeActions();
    super.dispose();
}

---------------Library-------------------
method: org.eclipse.ui.internal.Perspective.getPerspectiveExtensionActionSets()java.util.ArrayList;1
protected ArrayList getPerspectiveExtensionActionSets() {
    return page.getPerspectiveExtensionActionSets(descriptor.getOriginalId());
}
method: org.eclipse.ui.internal.registry.PerspectiveDescriptor.getOriginalId()java.lang.String;1
public String getOriginalId() {
    if (originalId == null) {
        originalId = getId();
    }
    return originalId;
}
---------------Client-------------------
method: org.eclipse.ui.texteditor.quickdiff.ReferenceProviderDescriptor.getId()java.lang.String;1
public String getId() {
    if (fId == null) {
        fId = fConfiguration.getAttribute(ID_ATTRIBUTE);
        Assert.isNotNull(fId);
    }
    return fId;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsConstraintCreator.endVisit(org.eclipse.jdt.core.dom.ThisExpression;)V2
@Override
public void endVisit(ThisExpression node) {
    ITypeBinding typeBinding = node.resolveTypeBinding();
    ImmutableTypeVariable2 cv = fTCModel.makeImmutableTypeVariable(typeBinding, null);
    setConstraintVariable(node, cv);
}
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsTCModel.makeImmutableTypeVariable(org.eclipse.jdt.core.dom.ITypeBinding;org.eclipse.jdt.core.dom.Expression;)org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ImmutableTypeVariable2;3
public ImmutableTypeVariable2 makeImmutableTypeVariable(ITypeBinding typeBinding, Expression expression) {
    TType type = getBoxedType(typeBinding, expression);
    if (type == null)
        return null;
    return makeImmutableTypeVariable(type);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.deleteResource(ZLorg.eclipse.core.runtime.MultiStatus;)V3
public void deleteResource(boolean convertToPhantom, MultiStatus status) throws CoreException {
    super.deleteResource(convertToPhantom, status);
    clearHistory(null);
    workspace.getMetaArea().delete(this);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ClassFile.isClass()Z1
public boolean isClass() throws JavaModelException {
    return getType().isClass();
}
method: org.eclipse.jdt.internal.core.ClassFile.getType()org.eclipse.jdt.core.IType;1
public IType getType() {
    if (this.binaryType == null) {
        this.binaryType = new  BinaryType(this, getTypeName());
    }
    return this.binaryType;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.plugin.Extensions.isValid()Z1
public boolean isValid() {
    if (fValid == null) {
        fValid = new  Boolean(hasRequiredAttributes());
    }
    return fValid.booleanValue();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.CompletionProposalComputerRegistry.informUser(org.eclipse.core.runtime.IStatus;)V2
private void informUser(IStatus status) {
    JavaPlugin.log(status);
    String title = JavaTextMessages.CompletionProposalComputerRegistry_error_dialog_title;
    String message = status.getMessage();
    MessageDialog.openError(JavaPlugin.getActiveWorkbenchShell(), title, message);
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.ActivityPersistanceHelper.loadEnabledStates()V1
void loadEnabledStates() {
    loadEnabledStates(Collections.EMPTY_SET, PlatformUI.getWorkbench().getActivitySupport().getActivityManager().getDefinedActivityIds());
}

---------------Library-------------------
method: org.eclipse.jface.text.TextViewerUndoManager.reset()V1
public void reset() {
    if (isConnected())
        fDocumentUndoManager.reset();
}
method: org.eclipse.text.undo.DocumentUndoManager.reset()V1
public void reset() {
    if (isConnected()) {
        shutdown();
        initialize();
    }
}
---------------Client-------------------
method: org.eclipse.swt.graphics.Transform.invert()V1
public void invert() {
    if (isDisposed())
        SWT.error(SWT.ERROR_GRAPHIC_DISPOSED);
    if (Cairo.cairo_matrix_invert(handle) != 0) {
        SWT.error(SWT.ERROR_CANNOT_INVERT_MATRIX);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.NavigatorContentServiceLabelProvider.labelProviderChanged(org.eclipse.jface.viewers.LabelProviderChangedEvent;)V2
public void labelProviderChanged(LabelProviderChangedEvent event) {
    fireLabelProviderChanged(event);
}
method: org.eclipse.ui.internal.navigator.NavigatorContentServiceLabelProvider.fireLabelProviderChanged(org.eclipse.jface.viewers.LabelProviderChangedEvent;)V2
protected void fireLabelProviderChanged(final LabelProviderChangedEvent event) {
    Object[] theListeners = getListeners();
    for (int i = 0; i < theListeners.length; ++i) {
        final ILabelProviderListener l = (ILabelProviderListener) theListeners[i];
        SafeRunner.run(new  SafeRunnable() {

            public void run() {
                l.labelProviderChanged(event);
            }
        });
    }
}
---------------Client-------------------
method: org.eclipse.ui.part.IntroPart.firePropertyChange(I)V2
protected void firePropertyChange(final int propertyId) {
    Object[] array = getListeners();
    for (int nX = 0; nX < array.length; nX++) {
        final IPropertyListener l = (IPropertyListener) array[nX];
        Platform.run(new  SafeRunnable() {

            @Override
            public void run() {
                l.propertyChanged(this, propertyId);
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.ui.internal.markers.SinceTagResolution.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_JAVADOCTAG);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
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
method: org.eclipse.ui.internal.console.ConsoleDropDownAction.dispose()V1
@Override
public void dispose() {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fView = null;
    ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
}

---------------Library-------------------
method: org.eclipse.ltk.core.refactoring.resource.ResourceChange$ValidationState.initializeResource(org.eclipse.core.resources.IResource;)V2
private void initializeResource(IResource resource) {
    fKind = RESOURCE;
    fDirty = false;
    fReadOnly = Resources.isReadOnly(resource);
    fModificationStamp = resource.getModificationStamp();
}
method: org.eclipse.ltk.internal.core.refactoring.Resources.isReadOnly(org.eclipse.core.resources.IResource;)Z1
public static boolean isReadOnly(IResource resource) {
    ResourceAttributes resourceAttributes = resource.getResourceAttributes();
    if (resourceAttributes == null)
        return false;
    return resourceAttributes.isReadOnly();
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSDecoration.initialize(org.eclipse.core.runtime.Preferences;java.lang.String;java.lang.String;java.lang.String;)V5
private void initialize(Preferences preferences, String fileFormater, String folderFormatter, String projectFormatter) {
    this.preferences = preferences;
    this.fileFormatter = updateOldDirtyFlag(fileFormater);
    this.folderFormatter = updateOldDirtyFlag(folderFormatter);
    this.projectFormatter = updateOldDirtyFlag(projectFormatter);
}

---------------Library-------------------
method: org.apache.lucene.search.spans.SpanTermQuery.hashCode()I1
@Override
public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((term == null) ? 0 : term.hashCode());
    return result;
}
method: org.apache.lucene.search.Query.hashCode()I1
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Float.floatToIntBits(boost);
    return result;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.ElementValuePairInfo.hashCode()I1
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + CharOperation.hashCode(this.name);
    result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
    return result;
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;3
public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<? super T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third);
}
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;3
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(3);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    return allOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;3
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    return anyOf(matchers);
}

---------------Library-------------------
method: org.eclipse.team.ui.synchronize.TeamStateProvider.getProviderIds(Aorg.eclipse.core.resources.IProject;)Ajava.lang.String;2
private String[] getProviderIds(IProject[] projects) {
    Set providerIds = new  HashSet();
    for (int i = 0; i < projects.length; i++) {
        IProject project = projects[i];
        String id = getProviderId(project);
        if (id != null)
            providerIds.add(id);
    }
    return (String[]) providerIds.toArray(new String[providerIds.size()]);
}
method: org.eclipse.team.ui.synchronize.TeamStateProvider.getProviderId(org.eclipse.core.resources.IProject;)java.lang.String;2
private String getProviderId(IProject project) {
    RepositoryProvider provider = RepositoryProvider.getProvider(project);
    if (provider != null)
        return provider.getID();
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.core.mapping.AbstractResourceMappingScope.getModelProviders()Aorg.eclipse.core.resources.mapping.ModelProvider;1
public ModelProvider[] getModelProviders() {
    Set result = new  HashSet();
    ResourceMapping[] mappings = getMappings();
    for (int i = 0; i < mappings.length; i++) {
        ResourceMapping mapping = mappings[i];
        ModelProvider modelProvider = mapping.getModelProvider();
        if (modelProvider != null)
            result.add(modelProvider);
    }
    return (ModelProvider[]) result.toArray(new ModelProvider[result.size()]);
}

---------------Library-------------------
method: org.eclipse.team.internal.core.subscribers.SubscriberSyncInfoCollector.reset()V1
public void reset() {
    eventHandler.reset(getRoots());
}
method: org.eclipse.team.internal.core.subscribers.SubscriberSyncInfoCollector.getRoots()Aorg.eclipse.core.resources.IResource;1
public IResource[] getRoots() {
    if (roots == null) {
        return super.getRoots();
    } else {
        return roots;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.callhierarchy.CallHierarchyViewer.cancelJobs()V1
void cancelJobs() {
    if (fPart == null)
        return;
    fContentProvider.cancelJobs(fPart.getCurrentMethodWrappers());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialogTabPage.createLabel(ILorg.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Label;4
protected static Label createLabel(int numColumns, Composite parent, String text, int gridDataStyle) {
    final Label label = new  Label(parent, SWT.WRAP);
    label.setFont(parent.getFont());
    label.setText(text);
    PixelConverter pixelConverter = new  PixelConverter(parent);
    label.setLayoutData(createGridData(numColumns, gridDataStyle, pixelConverter.convertHorizontalDLUsToPixels(150)));
    return label;
}
method: org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialogTabPage.createGridData(III)org.eclipse.swt.layout.GridData;3
protected static GridData createGridData(int numColumns, int style, int widthHint) {
    final GridData gd = new  GridData(style);
    gd.horizontalSpan = numColumns;
    gd.widthHint = widthHint;
    return gd;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.AntCodeFormatterPreferencePage.createGroup(ILorg.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Group;4
private Group createGroup(int numColumns, Composite parent, String text) {
    final Group group = new  Group(parent, SWT.NONE);
    GridData gd = new  GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = numColumns;
    gd.widthHint = 0;
    group.setLayoutData(gd);
    group.setFont(parent.getFont());
    final GridLayout layout = new  GridLayout(numColumns, false);
    group.setLayout(layout);
    group.setText(text);
    return group;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.actions.RefactoringActions.getEnclosingType(org.eclipse.jdt.internal.ui.javaeditor.JavaTextSelection;)org.eclipse.jdt.core.IType;1
public static IType getEnclosingType(JavaTextSelection selection) throws JavaModelException {
    return convertToEnclosingType(selection.resolveEnclosingElement());
}
method: org.eclipse.jdt.internal.ui.refactoring.actions.RefactoringActions.convertToEnclosingType(org.eclipse.jdt.core.IJavaElement;)org.eclipse.jdt.core.IType;1
private static IType convertToEnclosingType(IJavaElement element) {
    if (element == null)
        return null;
    if (!(element instanceof IType))
        element = element.getAncestor(IJavaElement.TYPE);
    return (IType) element;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.At.evaluateAsIterator(org.eclipse.equinox.p2.metadata.expression.IEvaluationContext;)java.util.Iterator;2
public Iterator<?> evaluateAsIterator(IEvaluationContext context) {
    Object value = evaluate(context);
    if (!(value instanceof Iterator<?>))
        value = RepeatableIterator.create(value);
    return (Iterator<?>) value;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryField.getConstant()java.lang.Object;1
public Object getConstant() throws JavaModelException {
    IBinaryField info = (IBinaryField) getElementInfo();
    return convertConstant(info.getConstant());
}
method: org.eclipse.jdt.internal.compiler.classfmt.FieldInfo.getConstant()org.eclipse.jdt.internal.compiler.impl.Constant;1
public Constant getConstant() {
    if (this.constant == null) {
        readConstantAttribute();
    }
    return this.constant;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.InlineMethodRefactoring.getMethod()org.eclipse.jdt.core.IMethod;1
public IMethod getMethod() {
    if (fSourceProvider == null)
        return null;
    IMethodBinding binding = fSourceProvider.getDeclaration().resolveBinding();
    if (binding == null)
        return null;
    return (IMethod) binding.getJavaElement();
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.AntCompletionProposal.toString()java.lang.String;1
@Override
public String toString() {
    return getDisplayString();
}
method: org.eclipse.ant.internal.ui.editor.AntCompletionProposal.getDisplayString()java.lang.String;1
@Override
public String getDisplayString() {
    if (fDisplayString != null) {
        return fDisplayString;
    }
    return fReplacementString;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.RecoveredElement.parser()org.eclipse.jdt.internal.compiler.parser.Parser;1
public Parser parser() {
    RecoveredElement current = this;
    while (current != null) {
        if (current.recoveringParser != null) {
            return current.recoveringParser;
        }
        current = current.parent;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.property.list.SelfListProperty.doUpdateList(java.lang.Object;org.eclipse.core.databinding.observable.list.ListDiff;)V3
protected void doUpdateList(Object source, ListDiff diff) {
    diff.applyTo((List) source);
}
method: org.eclipse.core.databinding.observable.list.ListDiff.applyTo(java.util.List;)V2
public void applyTo(final List list) {
    accept(new  ListDiffVisitor() {

        public void handleAdd(int index, Object element) {
            list.add(index, element);
        }

        public void handleRemove(int index, Object element) {
            list.remove(index);
        }

        public void handleReplace(int index, Object oldElement, Object newElement) {
            list.set(index, newElement);
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.fieldassist.ComboContentAdapter.setCursorPosition(org.eclipse.swt.widgets.Control;I)V3
@Override
public void setCursorPosition(Control control, int index) {
    ((Combo) control).setSelection(new  Point(index, index));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyInterfaceMemberDeclarationsopt()V1
protected void consumeEmptyInterfaceMemberDeclarationsopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.JavaPluginImages.createManagedFromKey(java.lang.String;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
private static ImageDescriptor createManagedFromKey(String prefix, String key) {
    return createManaged(prefix, key.substring(NAME_PREFIX_LENGTH), key);
}
method: org.eclipse.jdt.internal.ui.JavaPluginImages.createManaged(java.lang.String;java.lang.String;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;3
private static ImageDescriptor createManaged(String prefix, String name, String key) {
    ImageDescriptor result = create(prefix, name, true);
    if (fgAvoidSWTErrorMap == null) {
        fgAvoidSWTErrorMap = new  HashMap<String, ImageDescriptor>();
    }
    fgAvoidSWTErrorMap.put(key, result);
    if (fgImageRegistry != null) {
        JavaPlugin.logErrorMessage("Image registry already defined");
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringPluginImages.createManaged(java.lang.String;java.lang.String;)org.eclipse.jface.resource.ImageDescriptor;2
private static ImageDescriptor createManaged(String prefix, String name) {
    ImageDescriptor result = create(prefix, name.substring(NAME_PREFIX_LENGTH), true);
    if (fgAvoidSWTErrorMap == null) {
        fgAvoidSWTErrorMap = new  HashMap();
    }
    fgAvoidSWTErrorMap.put(name, result);
    if (fgImageRegistry != null) {
        RefactoringUIPlugin.logErrorMessage("Image registry already defined");
    }
    return result;
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
method: org.eclipse.ui.internal.console.ConsoleDropDownAction.dispose()V1
@Override
public void dispose() {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fView = null;
    ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.feature.BasePluginListPage.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.team.ui.synchronize.TeamStateProvider.internalIsDecorationEnabled(java.lang.String;)Z2
private boolean internalIsDecorationEnabled(String providerId) {
    String decoratorId = getDecoratorId(providerId);
    if (decoratorId != null) {
        return PlatformUI.getWorkbench().getDecoratorManager().getEnabled(decoratorId);
    }
    return false;
}
method: org.eclipse.ui.internal.decorators.DecoratorManager.getEnabled(java.lang.String;)Z2
@Override
public boolean getEnabled(String decoratorId) {
    DecoratorDefinition definition = getDecoratorDefinition(decoratorId);
    if (definition == null) {
        return false;
    }
    return definition.isEnabled();
}
---------------Client-------------------
method: org.eclipse.ui.activities.WorkbenchActivityHelper.allowUseOf(java.lang.Object;)Z1
@Deprecated
public static boolean allowUseOf(Object object) {
    return allowUseOf(PlatformUI.getWorkbench().getActivitySupport().getTriggerPointManager().getTriggerPoint(ITriggerPointManager.UNKNOWN_TRIGGER_POINT_ID), object);
}

---------------Library-------------------
method: org.eclipse.search.ui.text.AbstractTextSearchViewPage.showCurrentMatch(Z)Z2
private boolean showCurrentMatch(boolean activateEditor) {
    Match currentMatch = getCurrentMatch();
    if (currentMatch != null) {
        showMatch(currentMatch, activateEditor);
        return true;
    }
    return false;
}
method: org.eclipse.search.ui.text.AbstractTextSearchViewPage.showMatch(org.eclipse.search.ui.text.Match;Z)V3
private void showMatch(final Match match, final boolean activateEditor) {
    ISafeRunnable runnable = new  ISafeRunnable() {

        public void handleException(Throwable exception) {
            if (exception instanceof PartInitException) {
                PartInitException pie = (PartInitException) exception;
                ErrorDialog.openError(getSite().getShell(), SearchMessages.DefaultSearchViewPage_show_match, SearchMessages.DefaultSearchViewPage_error_no_editor, pie.getStatus());
            }
        }

        public void run() throws Exception {
            IRegion location = getCurrentMatchLocation(match);
            showMatch(match, location.getOffset(), location.getLength(), activateEditor);
        }
    };
    SafeRunner.run(runnable);
}
---------------Client-------------------
method: org.eclipse.jface.preference.PreferenceDialog.close()Z1
@Override
public boolean close() {
    SafeRunnable runnable = new  SafeRunnable() {

        @Override
        public void run() throws Exception {
            List<IPreferenceNode> nodes = preferenceManager.getElements(PreferenceManager.PRE_ORDER);
            for (int i = 0; i < nodes.size(); i++) {
                IPreferenceNode node = nodes.get(i);
                node.disposeResources();
            }
        }

        @Override
        public void handleException(Throwable e) {
            super.handleException(e);
            clearSelectedNode();
        }
    };
    SafeRunner.run(runnable);
    return super.close();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.GotoReferencedTestAction.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fWorkbench != null)
        return fWorkbench.getShell();
    return JUnitPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.junit.ui.JUnitPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow workBenchWindow = getActiveWorkbenchWindow();
    if (workBenchWindow == null)
        return null;
    return workBenchWindow.getShell();
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.SwitchMemoryBlockAction.getDebugContext()org.eclipse.core.runtime.IAdaptable;1
private IAdaptable getDebugContext() {
    if (fView != null) {
        return DebugUITools.getPartDebugContext(fView.getSite());
    } else {
        return DebugUITools.getDebugContext();
    }
}

---------------Library-------------------
method: org.eclipse.ui.wizards.datatransfer.WizardExternalProjectImportPage.getProjectName()java.lang.String;1
public String getProjectName() {
    return getProjectNameFieldValue();
}
method: org.eclipse.ui.wizards.datatransfer.WizardExternalProjectImportPage.getProjectNameFieldValue()java.lang.String;1
private String getProjectNameFieldValue() {
    if (projectNameField == null) {
        return "";
    }
    return projectNameField.getText().trim();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.apt.util.Archive.allPackages()java.util.Set;1
public Set<String> allPackages() {
    if (this.packagesCache == null) {
        this.initialize();
    }
    return this.packagesCache.keySet();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.SourceAttachmentBlock.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fSWTWidget != null) {
        return fSWTWidget.getShell();
    }
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getShell()org.eclipse.swt.widgets.Shell;1
final Shell getShell() {
    if (fEditor != null)
        return fEditor.getEditorSite().getShell();
    return JavaPlugin.getActiveWorkbenchShell();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.VariablePathDialogField.getShell()org.eclipse.swt.widgets.Shell;1
private Shell getShell() {
    if (fBrowseVariableButton != null) {
        return fBrowseVariableButton.getShell();
    }
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.SwitchMemoryBlockAction.getDebugContext()org.eclipse.core.runtime.IAdaptable;1
private IAdaptable getDebugContext() {
    if (fView != null) {
        return DebugUITools.getPartDebugContext(fView.getSite());
    } else {
        return DebugUITools.getDebugContext();
    }
}

---------------Library-------------------
method: org.eclipse.ltk.core.refactoring.RefactoringContribution.getId()java.lang.String;1
public String getId() {
    return RefactoringContributionManager.getInstance().getRefactoringId(this);
}
method: org.eclipse.ltk.internal.core.refactoring.history.RefactoringContributionManager.getInstance()org.eclipse.ltk.internal.core.refactoring.history.RefactoringContributionManager;0
public static RefactoringContributionManager getInstance() {
    if (fInstance == null)
        fInstance = new  RefactoringContributionManager();
    return fInstance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.Utils.syncExec(java.lang.Runnable;org.eclipse.jface.viewers.StructuredViewer;)V2
public static void syncExec(final Runnable r, StructuredViewer v) {
    if (v == null)
        return;
    final Control ctrl = v.getControl();
    syncExec(r, ctrl);
}
method: org.eclipse.team.internal.ui.Utils.syncExec(java.lang.Runnable;org.eclipse.swt.widgets.Control;)V2
public static void syncExec(final Runnable r, final Control ctrl) {
    if (ctrl != null && !ctrl.isDisposed()) {
        ctrl.getDisplay().syncExec(new  Runnable() {

            public void run() {
                if (!ctrl.isDisposed()) {
                    BusyIndicator.showWhile(ctrl.getDisplay(), r);
                }
            }
        });
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.Utils.asyncExec(java.lang.Runnable;org.eclipse.jface.viewers.StructuredViewer;)V2
public static void asyncExec(final Runnable r, StructuredViewer v) {
    if (v == null)
        return;
    final Control ctrl = v.getControl();
    if (ctrl != null && !ctrl.isDisposed()) {
        ctrl.getDisplay().asyncExec(new  Runnable() {

            public void run() {
                if (!ctrl.isDisposed()) {
                    BusyIndicator.showWhile(ctrl.getDisplay(), r);
                }
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.ecf.internal.provider.filetransfer.Activator.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    if (context == null)
        return null;
    return context.getBundle();
}
method: org.eclipse.osgi.internal.framework.BundleContextImpl.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    checkValid();
    return getBundleImpl();
}
---------------Client-------------------
method: org.eclipse.pde.core.target.TargetFeature.getId()java.lang.String;1
public String getId() {
    if (featureModel == null)
        return null;
    return featureModel.getFeature().getId();
}

---------------Library-------------------
method: org.eclipse.jface.viewers.TreeViewer.handleTreeCollapse(org.eclipse.swt.events.TreeEvent;)V2
@Override
protected void handleTreeCollapse(TreeEvent event) {
    if (isCellEditorActive()) {
        applyEditorValue();
    }
    super.handleTreeCollapse(event);
}
method: org.eclipse.jface.viewers.ColumnViewer.applyEditorValue()V1
protected void applyEditorValue() {
    if (viewerEditor != null) {
        viewerEditor.applyEditorValue();
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.JavaOutlinePage.doPropertyChange(org.eclipse.jface.util.PropertyChangeEvent;)V2
private void doPropertyChange(PropertyChangeEvent event) {
    if (fOutlineViewer != null) {
        if (MembersOrderPreferenceCache.isMemberOrderProperty(event.getProperty())) {
            fOutlineViewer.refresh(false);
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.classpath.ClasspathContentProvider.removeAll()V1
public void removeAll() {
    model.removeAll();
    refresh();
}
method: org.eclipse.jdt.internal.debug.ui.classpath.ClasspathModel.removeAll()V1
public void removeAll() {
    if (bootstrapEntries != null) {
        bootstrapEntries.removeAll();
    }
    if (userEntries != null) {
        userEntries.removeAll();
    }
}
---------------Client-------------------
method: org.eclipse.jface.resource.FontRegistry$FontRecord.dispose()V1
void dispose() {
    baseFont.dispose();
    if (boldFont != null) {
        boldFont.dispose();
    }
    if (italicFont != null) {
        italicFont.dispose();
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.util.StringUtil.concat(java.lang.String;java.lang.String;java.lang.String;java.lang.String;java.lang.String;)java.lang.StringBuffer;5
public static StringBuffer concat(String string1, String string2, String string3, String string4, String string5) {
    StringBuffer buffer = concat(string1, string2, string3, string4);
    buffer.append(string5);
    return buffer;
}
method: org.eclipse.ui.internal.intro.impl.util.StringUtil.concat(java.lang.String;java.lang.String;java.lang.String;java.lang.String;)java.lang.StringBuffer;4
public static StringBuffer concat(String string1, String string2, String string3, String string4) {
    StringBuffer buffer = concat(string1, string2, string3);
    buffer.append(string4);
    return buffer;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.select.SelectionOnReferenceExpressionName.printExpression(ILjava.lang.StringBuffer;)java.lang.StringBuffer;3
public StringBuffer printExpression(int indent, StringBuffer output) {
    output.append("<SelectionOnReferenceExpressionName:");
    super.printExpression(indent, output);
    return output.append('>');
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;4
public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third, fourth);
}
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;4
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    return anyOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;4
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(4);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    return allOf(matchers);
}

---------------Library-------------------
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.addActivatorHookFactory(org.eclipse.osgi.internal.hookregistry.ActivatorHookFactory;)V2
public void addActivatorHookFactory(ActivatorHookFactory activatorHookFactory) {
    add(activatorHookFactory, activatorHookFactories);
}
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.add(java.lang.Object;java.util.List;)V3
private <H> void add(H hook, List<H> hooks) {
    if (initialized)
        throw new  IllegalStateException("Cannot add hooks dynamically.");
    hooks.add(hook);
}
---------------Client-------------------
method: org.eclipse.emf.common.command.CompoundCommand.append(org.eclipse.emf.common.command.Command;)V2
public void append(Command command) {
    if (isPrepared) {
        throw new  IllegalStateException("The command is already prepared");
    }
    if (command != null) {
        commandList.add(command);
    }
}

---------------Library-------------------
method: org.eclipse.jface.resource.JFaceResources.getTextFontDescriptor()org.eclipse.jface.resource.FontDescriptor;0
public static FontDescriptor getTextFontDescriptor() {
    return getFontRegistry().getDescriptor(TEXT_FONT);
}
method: org.eclipse.jface.resource.JFaceResources.getFontRegistry()org.eclipse.jface.resource.FontRegistry;0
public static FontRegistry getFontRegistry() {
    if (fontRegistry == null) {
        fontRegistry = new  FontRegistry("org.eclipse.jface.resource.jfacefonts");
    }
    return fontRegistry;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.internal.util.Util.safeCopy(java.util.SortedMap;java.lang.Class;java.lang.Class;)java.util.SortedMap;3
public static SortedMap safeCopy(SortedMap sortedMap, Class keyClass, Class valueClass) {
    return safeCopy(sortedMap, keyClass, valueClass, false, false);
}
method: org.eclipse.ui.internal.util.Util.safeCopy(java.util.SortedMap;java.lang.Class;java.lang.Class;ZZ)java.util.SortedMap;5
public static SortedMap safeCopy(SortedMap sortedMap, Class keyClass, Class valueClass, boolean allowNullKeys, boolean allowNullValues) {
    if (sortedMap == null || keyClass == null || valueClass == null) {
        throw new  NullPointerException();
    }
    sortedMap = Collections.unmodifiableSortedMap(new  TreeMap(sortedMap));
    Iterator iterator = sortedMap.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry) iterator.next();
        assertInstance(entry.getKey(), keyClass, allowNullKeys);
        assertInstance(entry.getValue(), valueClass, allowNullValues);
    }
    return sortedMap;
}
---------------Client-------------------
method: org.eclipse.core.internal.commands.util.Util.safeCopy(java.util.Map;java.lang.Class;java.lang.Class;ZZ)java.util.Map;5
public static final Map safeCopy(final Map map, final Class keyClass, final Class valueClass, final boolean allowNullKeys, final boolean allowNullValues) {
    if (map == null || keyClass == null || valueClass == null) {
        throw new  NullPointerException();
    }
    final Map copy = Collections.unmodifiableMap(new  HashMap(map));
    final Iterator iterator = copy.entrySet().iterator();
    while (iterator.hasNext()) {
        final Map.Entry entry = (Map.Entry) iterator.next();
        assertInstance(entry.getKey(), keyClass, allowNullKeys);
        assertInstance(entry.getValue(), valueClass, allowNullValues);
    }
    return map;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.JarPackageWizardPage.getSelectedElements()Ajava.lang.Object;1
private Object[] getSelectedElements() {
    return getSelectedResources().toArray();
}
method: org.eclipse.ui.dialogs.WizardExportResourcesPage.getSelectedResources()java.util.List;1
protected List getSelectedResources() {
    Iterator resourcesToExportIterator = this.getSelectedResourcesIterator();
    List resourcesToExport = new  ArrayList();
    while (resourcesToExportIterator.hasNext()) {
        resourcesToExport.add(resourcesToExportIterator.next());
    }
    return resourcesToExport;
}
---------------Client-------------------
method: org.eclipse.core.internal.preferences.EclipsePreferences$SortedProperties.keys()java.util.Enumeration;1
public synchronized Enumeration keys() {
    TreeSet set = new  TreeSet();
    for (Enumeration e = super.keys(); e.hasMoreElements(); ) set.add(e.nextElement());
    return Collections.enumeration(set);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor.isActivePart()Z1
private boolean isActivePart() {
    IWorkbenchPart part = getActivePart();
    return part != null && part.equals(this);
}
method: org.eclipse.ant.internal.ui.editor.AntEditor.getActivePart()org.eclipse.ui.IWorkbenchPart;1
private IWorkbenchPart getActivePart() {
    IWorkbenchWindow window = getSite().getWorkbenchWindow();
    IPartService service = window.getPartService();
    return service.getActivePart();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor.isActiveEditor()Z1
protected final boolean isActiveEditor() {
    IWorkbenchWindow window = getSite().getWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();
    if (page == null)
        return false;
    IEditorPart activeEditor = page.getActiveEditor();
    return activeEditor != null && activeEditor.equals(this);
}

---------------Library-------------------
method: org.apache.lucene.index.IndexReader.flush(java.util.Map;)V2
public final synchronized void flush(Map<String, String> commitUserData) throws IOException {
    ensureOpen();
    commit(commitUserData);
}
method: org.apache.lucene.index.IndexReader.commit(java.util.Map;)V2
public final synchronized void commit(Map<String, String> commitUserData) throws IOException {
    doCommit(commitUserData);
    hasChanges = false;
}
---------------Client-------------------
method: org.eclipse.debug.ui.actions.LaunchAsAction.initialize(org.eclipse.jface.action.IAction;)V2
private void initialize(IAction action) {
    fAction = action;
    action.setEnabled(existsShortcutsForMode());
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.EclipseSynchronizer.folderChanged(org.eclipse.core.resources.IContainer;)V2
private void folderChanged(IContainer folder) {
    resourceLock.folderChanged(folder);
}
method: org.eclipse.team.internal.ccvs.core.syncinfo.ReentrantLock.folderChanged(org.eclipse.core.resources.IContainer;)V2
public void folderChanged(IContainer folder) {
    CVSThreadInfo info = (CVSThreadInfo) getThreadInfo();
    Assert.isNotNull(info, "Folder changed outside of resource lock");
    info.addChangedFolder(folder);
}
---------------Client-------------------
method: org.eclipse.jface.dialogs.ImageAndMessageArea.setFont(org.eclipse.swt.graphics.Font;)V2
@Override
public void setFont(Font font) {
    super.setFont(font);
    ((Text) messageField.getControl()).setFont(font);
}

---------------Library-------------------
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
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.processSequential(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;3
protected GenericSequentialFlowInfo processSequential(ASTNode parent, ASTNode node1) {
    GenericSequentialFlowInfo result = createSequential(parent);
    if (node1 != null)
        result.merge(getFlowInfo(node1), fFlowContext);
    return result;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.SourceLocationManager.getBundleManifestLocations()java.util.Collection;1
public Collection<SourceLocation> getBundleManifestLocations() {
    return getBundleManifestLocator().getSourceLocations();
}
method: org.eclipse.pde.internal.core.SourceLocationManager.getBundleManifestLocator()org.eclipse.pde.internal.core.BundleManifestSourceLocationManager;1
private BundleManifestSourceLocationManager getBundleManifestLocator() {
    if (fBundleManifestLocator == null) {
        fBundleManifestLocator = initializeBundleManifestLocations();
    }
    return fBundleManifestLocator;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$DiagnosticWrapper.getChildren()java.util.List;1
public List<Diagnostic> getChildren() {
    if (unmodifiableWrappedChildren == null) {
        unmodifiableWrappedChildren = Collections.unmodifiableList(basicGetChildren());
    }
    return unmodifiableWrappedChildren;
}

---------------Library-------------------
method: org.eclipse.ui.plugin.AbstractUIPlugin.saveDialogSettings()V1
protected void saveDialogSettings() {
    if (dialogSettings == null) {
        return;
    }
    try {
        IPath path = getStateLocationOrNull();
        if (path == null) {
            return;
        }
        String readWritePath = path.append(FN_DIALOG_SETTINGS).toOSString();
        dialogSettings.save(readWritePath);
    } catch (IOException e) {
    } catch (IllegalStateException e) {
    }
}
method: org.eclipse.ui.plugin.AbstractUIPlugin.getStateLocationOrNull()org.eclipse.core.runtime.IPath;1
private IPath getStateLocationOrNull() {
    try {
        return getStateLocation();
    } catch (IllegalStateException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.internal.workbench.swt.WorkbenchSWTActivator.saveDialogSettings()V1
protected void saveDialogSettings() {
    if (dialogSettings == null) {
        return;
    }
    try {
        IPath path = getStateLocationOrNull();
        if (path == null) {
            return;
        }
        String readWritePath = path.append(FN_DIALOG_SETTINGS).toOSString();
        dialogSettings.save(readWritePath);
    } catch (IOException e) {
    } catch (IllegalStateException e) {
    }
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.provisional.AsynchronousLabelAdapter.getLabelRule(java.lang.Object;org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;)org.eclipse.core.runtime.jobs.ISchedulingRule;3
protected ISchedulingRule getLabelRule(Object element, IPresentationContext context) {
    return AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(context);
}
method: org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory.getDefault()org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory;0
public static AsynchronousSchedulingRuleFactory getDefault() {
    if (fgFactory == null) {
        fgFactory = new  AsynchronousSchedulingRuleFactory();
    }
    return fgFactory;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.core.compiler.CharOperation.indexOf(CAC)I2
public static final int indexOf(char toBeFound, char[] array) {
    return indexOf(toBeFound, array, 0);
}
method: org.eclipse.jdt.core.compiler.CharOperation.indexOf(CACI)I3
public static final int indexOf(char toBeFound, char[] array, int start) {
    for (int i = start; i < array.length; i++) if (toBeFound == array[i])
        return i;
    return -1;
}
---------------Client-------------------
method: org.eclipse.jface.internal.text.link.contentassist.ContentAssistant2$AutoAssistListener.contains(ACC)Z3
private boolean contains(char[] characters, char character) {
    if (characters != null) {
        for (int i = 0; i < characters.length; i++) {
            if (character == characters[i])
                return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;5
public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<? super T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third, fourth, fifth);
}
method: org.hamcrest.core.AllOf.allOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.Matcher;5
@Factory
public static <T> Matcher<T> allOf(Matcher<? super T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>(5);
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    return allOf(matchers);
}
---------------Client-------------------
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;5
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second, Matcher<? super T> third, Matcher<? super T> fourth, Matcher<? super T> fifth) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    matchers.add(third);
    matchers.add(fourth);
    matchers.add(fifth);
    return anyOf(matchers);
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareEditorSelectionProvider$InternalPostSelectionListener.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    doPostSelectionChanged(event);
}
method: org.eclipse.compare.internal.CompareEditorSelectionProvider.doPostSelectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
final void doPostSelectionChanged(SelectionChangedEvent event) {
    ISelectionProvider provider = event.getSelectionProvider();
    if (provider == fViewerInFocus) {
        firePostSelectionChanged();
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event e) {
    Widget source = e.widget;
    if (source == destinationBrowseButton) {
        handleDestinationBrowseButtonPressed();
    }
    updatePageCompletion();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.search.PluginSearchResultPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.JavaSearchPage.dispose()V1
@Override
public void dispose() {
    writeConfiguration();
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
method: org.eclipse.ant.internal.ui.preferences.MessageLine.dispose()V1
@Override
public void dispose() {
    if (fErrorMsgAreaBackground != null) {
        fErrorMsgAreaBackground.dispose();
        fErrorMsgAreaBackground = null;
    }
    super.dispose();
}

---------------Library-------------------
method: org.eclipse.e4.core.internal.di.osgi.LogHelper.logError(java.lang.String;java.lang.Throwable;)V2
public static void logError(String msg, Throwable e) {
    log(msg, FrameworkLogEntry.ERROR, e);
}
method: org.eclipse.e4.core.internal.di.osgi.LogHelper.log(java.lang.String;ILjava.lang.Throwable;)V3
public static void log(String msg, int severity, Throwable e) {
    FrameworkLog log = DIActivator.getDefault().getFrameworkLog();
    FrameworkLogEntry logEntry = new  FrameworkLogEntry(plugin_name, severity, 0, msg, 0, e, null);
    log.log(logEntry);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.preferences.AddToJavaSearchJob.clearAll()V0
public static void clearAll() {
    Job.getJobManager().cancel(JOB_FAMILY_ID);
    AddToJavaSearchJob job = new  AddToJavaSearchJob(null, false);
    job.schedule();
}

---------------Library-------------------
method: org.apache.batik.css.engine.value.RGBColorValue.toString()java.lang.String;1
public String toString() {
    return getCssText();
}
method: org.apache.batik.css.engine.value.RGBColorValue.getCssText()java.lang.String;1
public String getCssText() {
    return "rgb(" + red.getCssText() + ", " + green.getCssText() + ", " + blue.getCssText() + ')';
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.RGBColorImpl.getCssText()java.lang.String;1
@Override
public String getCssText() {
    return "rgb(" + red.getCssText() + ", " + green.getCssText() + ", " + blue.getCssText() + ")";
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
method: org.eclipse.core.internal.databinding.beans.BeanPropertyListenerSupport.log(ILjava.lang.String;java.lang.Throwable;)V3
private static void log(int severity, String message, Throwable throwable) {
    if (BeansObservables.DEBUG) {
        Policy.getLog().log(new  Status(severity, Policy.JFACE_DATABINDING, IStatus.OK, message, throwable));
    }
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.DialogTaskProperties.updateEnablement()V1
protected void updateEnablement() {
    super.updateEnablement();
    priorityCombo.setEnabled(isEditable());
    completedCheckbox.setEnabled(isEditable());
}
method: org.eclipse.ui.views.markers.internal.DialogMarkerProperties.isEditable()Z1
protected boolean isEditable() {
    if (marker == null) {
        return true;
    }
    return Util.isEditable(marker);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.NLSAccessorConfigurationDialog.initAccessorClassFields()V1
private void initAccessorClassFields() {
    String accessorClassName = fRefactoring.getAccessorClassName();
    if (accessorClassName == null) {
        accessorClassName = NLSRefactoring.DEFAULT_ACCESSOR_CLASSNAME;
    }
    fAccessorClassName.setText(accessorClassName);
    fSubstitutionPattern.setText(fRefactoring.getSubstitutionPattern());
}

---------------Library-------------------
method: org.eclipse.ui.internal.ErrorEditorPart.setPartName(java.lang.String;)V2
@Override
public void setPartName(String newName) {
    super.setPartName(newName);
}
method: org.eclipse.ui.part.EditorPart.setPartName(java.lang.String;)V2
@Override
protected void setPartName(String partName) {
    if (compatibilityTitleListener != null) {
        removePropertyListener(compatibilityTitleListener);
        compatibilityTitleListener = null;
    }
    super.setPartName(partName);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.MenuItem.releaseChildren(Z)V2
@Override
void releaseChildren(boolean destroy) {
    if (menu != null) {
        menu.release(false);
        menu = null;
    }
    super.releaseChildren(destroy);
}

---------------Library-------------------
method: org.eclipse.swt.custom.CTabFolderRenderer.drawBorder(org.eclipse.swt.graphics.GC;AI)V3
void drawBorder(GC gc, int[] shape) {
    gc.setForeground(parent.getDisplay().getSystemColor(BORDER1_COLOR));
    gc.drawPolyline(shape);
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.SourceFirstPackageSelectionDialogField.setDefaults(org.eclipse.jdt.core.IPackageFragment;org.eclipse.jdt.core.ICompilationUnit;)V3
private void setDefaults(IPackageFragment fragment, ICompilationUnit cu) {
    IJavaElement element = fragment;
    if (element == null) {
        element = cu;
    }
    fSourceFolderSelection.setRoot(searchSourcePackageFragmentRoot(element));
    fPackageSelection.setPackageFragment(searchPackageFragment(element));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMMethod.getDetailedNode()org.eclipse.jdt.internal.core.jdom.DOMNode;1
protected DOMNode getDetailedNode() {
    return (DOMNode) getFactory().createMethod(getContents());
}
method: org.eclipse.jdt.core.jdom.DOMFactory.createMethod(java.lang.String;)org.eclipse.jdt.core.jdom.IDOMMethod;2
public IDOMMethod createMethod(String sourceCode) {
    if (sourceCode == null) {
        return null;
    }
    return (new  DOMBuilder()).createMethod(sourceCode.toCharArray());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMethod.getRawParameterNames()Ajava.lang.String;1
public String[] getRawParameterNames() throws JavaModelException {
    IBinaryMethod info = (IBinaryMethod) getElementInfo();
    int paramCount = Signature.getParameterCount(new  String(info.getMethodDescriptor()));
    return getRawParameterNames(paramCount);
}

---------------Library-------------------
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaJRETab.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_LIBRARY);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.externaltools.internal.ui.TreeAndListGroup$1.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
@Override
public void selectionChanged(SelectionChangedEvent event) {
    notifySelectionListeners(event);
}
method: org.eclipse.ui.externaltools.internal.ui.TreeAndListGroup.notifySelectionListeners(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
protected void notifySelectionListeners(SelectionChangedEvent event) {
    for (ISelectionChangedListener listener : selectionChangedListeners) {
        listener.selectionChanged(event);
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.ValidationStatusMap.removeElementChangeListener()V1
private void removeElementChangeListener() {
    for (Iterator it = dependencies.iterator(); it.hasNext(); ) {
        IObservableValue observableValue = (IObservableValue) it.next();
        observableValue.removeChangeListener(markDirtyChangeListener);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.StorageEditorInput.getImageDescriptor()org.eclipse.jface.resource.ImageDescriptor;1
public ImageDescriptor getImageDescriptor() {
    return JavaUI.getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_CUNIT);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.validation.ValidatedObservableList.listIterator()java.util.ListIterator;1
public ListIterator listIterator() {
    return listIterator(0);
}
method: org.eclipse.core.internal.databinding.validation.ValidatedObservableList.listIterator(I)java.util.ListIterator;2
public ListIterator listIterator(int index) {
    getterCalled();
    final ListIterator wrappedIterator = wrappedList.listIterator(index);
    return new  ListIterator() {

        int lastIndex = -1;

        Object last = null;

        public void add(Object o) {
            wrappedIterator.add(o);
            lastIndex = previousIndex();
            ListDiff diff = Diffs.createListDiff(Diffs.createListDiffEntry(lastIndex, true, o));
            updateTargetList(diff);
            fireListChange(diff);
        }

        public boolean hasNext() {
            return wrappedIterator.hasNext();
        }

        public boolean hasPrevious() {
            return wrappedIterator.hasPrevious();
        }

        public Object next() {
            last = wrappedIterator.next();
            lastIndex = previousIndex();
            return last;
        }

        public int nextIndex() {
            return wrappedIterator.nextIndex();
        }

        public Object previous() {
            last = wrappedIterator.previous();
            lastIndex = nextIndex();
            return last;
        }

        public int previousIndex() {
            return wrappedIterator.previousIndex();
        }

        public void remove() {
            wrappedIterator.remove();
            ListDiff diff = Diffs.createListDiff(Diffs.createListDiffEntry(lastIndex, false, last));
            lastIndex = -1;
            updateTargetList(diff);
            fireListChange(diff);
        }

        public void set(Object o) {
            wrappedIterator.set(o);
            ListDiff diff = Diffs.createListDiff(Diffs.createListDiffEntry(lastIndex, false, last), Diffs.createListDiffEntry(lastIndex, true, o));
            last = o;
            updateTargetList(diff);
            fireListChange(diff);
        }
    };
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.PasteAction$TextPaster$1.getContents()java.io.InputStream;1
public InputStream getContents() throws CoreException {
    try {
        return new  ByteArrayInputStream(text.getBytes(getCharset()));
    } catch (UnsupportedEncodingException e) {
        throw new  CoreException(new  Status(IStatus.ERROR, JavaPlugin.getPluginId(), IJavaStatusConstants.INTERNAL_ERROR, JavaUIMessages.JavaPlugin_internal_error, e));
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.java.JavaStringAutoIndentStrategy.getExtraIndentAfterNewLine()java.lang.String;1
private String getExtraIndentAfterNewLine() {
    int formatterContinuationIndentationSize = getContinuationIndentationSize();
    int binaryAlignmentValue = getBinaryOperatorAlignmentStyle();
    int indentSize = formatterContinuationIndentationSize;
    if (binaryAlignmentValue == DefaultCodeFormatterConstants.INDENT_BY_ONE) {
        indentSize = 1;
    } else if (binaryAlignmentValue == DefaultCodeFormatterConstants.INDENT_ON_COLUMN) {
    }
    return CodeFormatterUtil.createIndentString(indentSize, fProject);
}
method: org.eclipse.jdt.internal.ui.text.java.JavaStringAutoIndentStrategy.getBinaryOperatorAlignmentStyle()I1
private int getBinaryOperatorAlignmentStyle() {
    String binaryAlignmentValue = getCoreFormatterOption(DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_BINARY_EXPRESSION);
    return DefaultCodeFormatterConstants.getIndentStyle(binaryAlignmentValue);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.TableItem.getBackground()org.eclipse.swt.graphics.Color;1
public Color getBackground() {
    checkWidget();
    if (!parent.checkData(this))
        error(SWT.ERROR_WIDGET_DISPOSED);
    return _getBackground();
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.TypeDeclaration.superInterfaces()java.util.List;1
public List superInterfaces() {
    return internalSuperInterfaces();
}
method: org.eclipse.jdt.core.dom.TypeDeclaration.internalSuperInterfaces()java.util.List;1
final List internalSuperInterfaces() {
    if (this.superInterfaceNames == null) {
        supportedOnlyIn2();
    }
    return this.superInterfaceNames;
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.ProjectDescription.getLocation()org.eclipse.core.runtime.IPath;1
public IPath getLocation() {
    if (location == null)
        return null;
    return FileUtil.toPath(location);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.equals(java.lang.Object;)Z2
public boolean equals(Object target) {
    if (this == target)
        return true;
    if (!(target instanceof RemoteFile))
        return false;
    RemoteFile remote = (RemoteFile) target;
    return super.equals(target) && remote.getRevision().equals(getRevision());
}
method: org.eclipse.team.internal.ccvs.core.resources.RemoteFile.getRevision()java.lang.String;1
public String getRevision() {
    try {
        return ResourceSyncInfo.getRevision(syncBytes);
    } catch (CVSException e) {
        CVSProviderPlugin.log(e);
        return ResourceSyncInfo.ADDED_REVISION;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.equals(java.lang.Object;)Z2
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (!(o instanceof PackageFragmentRoot))
        return false;
    PackageFragmentRoot other = (PackageFragmentRoot) o;
    return resource().equals(other.resource()) && this.parent.equals(other.parent);
}

---------------Library-------------------
method: org.eclipse.core.internal.registry.ExtensionRegistry.addRegistryChangeListener(org.eclipse.core.runtime.IRegistryChangeListener;)V2
public void addRegistryChangeListener(IRegistryChangeListener listener) {
    addListenerInternal(listener, null);
}
method: org.eclipse.core.internal.registry.ExtensionRegistry.addListenerInternal(java.util.EventListener;java.lang.String;)V3
private void addListenerInternal(EventListener listener, String filter) {
    synchronized (listeners) {
        listeners.add(new  ListenerInfo(listener, filter));
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.registry.ExtensionRegistry.removeListener(org.eclipse.core.runtime.IRegistryEventListener;)V2
public void removeListener(IRegistryEventListener listener) {
    synchronized (listeners) {
        listeners.remove(new  ListenerInfo(listener, null));
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.ImportReferencesCollector.visit(org.eclipse.jdt.core.dom.QualifiedType;)Z2
@Override
public boolean visit(QualifiedType node) {
    doVisitNode(node.getQualifier());
    visitAnnotations(node);
    return false;
}
method: org.eclipse.jdt.internal.corext.codemanipulation.ImportReferencesCollector.doVisitNode(org.eclipse.jdt.core.dom.ASTNode;)V2
private void doVisitNode(ASTNode node) {
    if (node != null) {
        node.accept(this);
    }
}
---------------Client-------------------
method: org.eclipse.team.core.mapping.ChangeTracker.isModified(org.eclipse.core.resources.IFile;)Z2
protected boolean isModified(IFile file) throws CoreException {
    IChangeGroupingRequestor collector = getCollector(file.getProject());
    if (collector != null)
        return collector.isModified(file);
    return false;
}

---------------Library-------------------
method: org.eclipse.team.core.Team.createMerger(java.lang.String;)org.eclipse.team.core.mapping.IStorageMerger;1
public static IStorageMerger createMerger(String extension) {
    return StorageMergerRegistry.getInstance().createStreamMerger(extension);
}
method: org.eclipse.team.internal.core.StorageMergerRegistry.getInstance()org.eclipse.team.internal.core.StorageMergerRegistry;0
public static StorageMergerRegistry getInstance() {
    if (instance == null) {
        instance = new  StorageMergerRegistry();
    }
    return instance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor.installOverrideIndicator(Z)V2
@Override
protected void installOverrideIndicator(boolean provideAST) {
    super.installOverrideIndicator(provideAST);
    if (fOverrideIndicatorManager == null)
        return;
    addReconcileListener(fOverrideIndicatorManager);
}
method: org.eclipse.jdt.internal.ui.javaeditor.JavaEditor.installOverrideIndicator(Z)V2
protected void installOverrideIndicator(boolean provideAST) {
    uninstallOverrideIndicator();
    IAnnotationModel model = getDocumentProvider().getAnnotationModel(getEditorInput());
    final ITypeRoot inputElement = getInputJavaElement();
    if (model == null || inputElement == null)
        return;
    fOverrideIndicatorManager = new  OverrideIndicatorManager(model, inputElement, null);
    if (provideAST) {
        CompilationUnit ast = SharedASTProvider.getAST(inputElement, SharedASTProvider.WAIT_ACTIVE_ONLY, getProgressMonitor());
        fOverrideIndicatorManager.reconciled(ast, true, getProgressMonitor());
    }
}
---------------Client-------------------
method: org.apache.batik.css.dom.CSSOMValue.setCssText(java.lang.String;)V2
public void setCssText(String cssText) throws DOMException {
    if (handler == null) {
        throw new  DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR, "");
    } else {
        handler.textChanged(cssText);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.LambdaExpression;)V2
@Override
public void endVisit(LambdaExpression node) {
    if (skipNode(node))
        return;
    GenericSequentialFlowInfo info = createSequential(node);
    process(info, node.parameters());
    process(info, node.getBody());
    info.setNoReturn();
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.createSequential(org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;2
protected GenericSequentialFlowInfo createSequential(ASTNode parent) {
    GenericSequentialFlowInfo result = createSequential();
    setFlowInfo(parent, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.EnumDeclaration;)V2
@Override
public void endVisit(EnumDeclaration node) {
    if (skipNode(node))
        return;
    GenericSequentialFlowInfo info = processSequential(node, node.superInterfaceTypes());
    process(info, node.enumConstants());
    process(info, node.bodyDeclarations());
    info.setNoReturn();
}

---------------Library-------------------
method: org.eclipse.jface.resource.JFaceResources.getHeaderFontDescriptor()org.eclipse.jface.resource.FontDescriptor;0
public static FontDescriptor getHeaderFontDescriptor() {
    return getFontRegistry().getDescriptor(HEADER_FONT);
}
method: org.eclipse.jface.resource.JFaceResources.getFontRegistry()org.eclipse.jface.resource.FontRegistry;0
public static FontRegistry getFontRegistry() {
    if (fontRegistry == null) {
        fontRegistry = new  FontRegistry("org.eclipse.jface.resource.jfacefonts");
    }
    return fontRegistry;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Diffs$4.getChangedKeys()java.util.Set;1
public Set getChangedKeys() {
    return getLazyDiff().getChangedKeys();
}
method: org.eclipse.core.databinding.observable.Diffs$4.getLazyDiff()org.eclipse.core.databinding.observable.map.MapDiff;1
private MapDiff getLazyDiff() {
    if (lazyDiff == null) {
        lazyDiff = computeMapDiff(oldMap, newMap);
    }
    return lazyDiff;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.Diffs$1.getDifferences()Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;1
public ListDiffEntry[] getDifferences() {
    if (lazyDiff == null) {
        lazyDiff = Diffs.computeListDiff(oldList, newList);
    }
    return lazyDiff.getDifferences();
}

---------------Library-------------------
method: org.eclipse.ui.internal.progress.ProgressMonitorFocusJobDialog$3$7.run()V1
@Override
public void run() {
    getProgressMonitor().setTaskName(finalName);
}
method: org.eclipse.ui.internal.progress.ProgressMonitorJobsDialog.getProgressMonitor()org.eclipse.core.runtime.IProgressMonitor;1
@Override
public IProgressMonitor getProgressMonitor() {
    if (wrapperedMonitor == null) {
        createWrapperedMonitor();
    }
    return wrapperedMonitor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.menus.PulldownDelegateWidgetProxy$1.widgetDisposed(org.eclipse.swt.events.DisposeEvent;)V2
@Override
public void widgetDisposed(DisposeEvent e) {
    if (e.widget == widget) {
        dispose();
        widget = null;
    }
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;)Z2
public boolean visit(AnnotationTypeMemberDeclaration node) {
    visitBodyDeclaration(node);
    return true;
}
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visitBodyDeclaration(org.eclipse.jdt.core.dom.BodyDeclaration;)V2
private void visitBodyDeclaration(final BodyDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)Z2
public boolean visit(SingleVariableDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.ASTRewriteAnalyzer.isCollapsed(org.eclipse.jdt.core.dom.ASTNode;)Z2
private final boolean isCollapsed(ASTNode node) {
    return this.nodeInfos.isCollapsed(node);
}
method: org.eclipse.jdt.internal.core.dom.rewrite.NodeInfoStore.isCollapsed(org.eclipse.jdt.core.dom.ASTNode;)Z2
public boolean isCollapsed(ASTNode node) {
    if (this.collapsedNodes != null) {
        return this.collapsedNodes.contains(node);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jface.text.TextSelection.getStartLine()I1
public int getStartLine() {
    try {
        if (fDocument != null)
            return fDocument.getLineOfOffset(fOffset);
    } catch (BadLocationException x) {
    }
    return -1;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.updatesite.SiteCategory$1.compare(org.eclipse.equinox.internal.p2.updatesite.SiteCategory;org.eclipse.equinox.internal.p2.updatesite.SiteCategory;)I3
public int compare(SiteCategory cat1, SiteCategory cat2) {
    if (cat1.equals(cat2))
        return 0;
    return cat1.getName().compareTo(cat2.getName());
}
method: org.eclipse.equinox.internal.p2.updatesite.SiteCategory.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    boolean result = false;
    if (obj instanceof SiteCategory) {
        SiteCategory otherCategory = (SiteCategory) obj;
        result = getName().equalsIgnoreCase(otherCategory.getName());
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.InstructionPointerContext.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object other) {
    if (other instanceof InstructionPointerContext) {
        InstructionPointerContext otherContext = (InstructionPointerContext) other;
        if (getAnnotation().equals(otherContext.getAnnotation())) {
            return getEditor().equals(otherContext.getEditor());
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.getMemberMatches(java.lang.String;java.util.List;)V2
private static void getMemberMatches(final String s, final List<Object> matches) throws InterruptedException {
    executeRunnable(new  IRunnableWithProgress() {

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            doMemberSearch(s, matches, true, true, true, monitor, 100);
        }
    });
}
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.executeRunnable(org.eclipse.jface.operation.IRunnableWithProgress;)V1
private static void executeRunnable(IRunnableWithProgress runnableWithProgress) throws InterruptedException {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnableWithProgress);
    } catch (InvocationTargetException e) {
        JDIDebugUIPlugin.log(e);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart.importTestRunSession(java.lang.String;)V1
static void importTestRunSession(final String url) {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new  IRunnableWithProgress() {

            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                JUnitModel.importTestRunSession(url, monitor);
            }
        });
    } catch (InterruptedException e) {
    } catch (InvocationTargetException e) {
        CoreException ce = (CoreException) e.getCause();
        StatusManager.getManager().handle(ce.getStatus(), StatusManager.SHOW | StatusManager.LOG);
    }
}

---------------Library-------------------
method: org.eclipse.compare.internal.patch.HunkTypedElement.getHunkOverlayImage(org.eclipse.swt.graphics.Image;org.eclipse.jface.resource.LocalResourceManager;java.lang.String;Z)org.eclipse.swt.graphics.Image;4
private static Image getHunkOverlayImage(Image baseImage, LocalResourceManager imageCache, String path, boolean onLeft) {
    ImageDescriptor desc = new  DiffImageDescriptor(baseImage, CompareUIPlugin.getImageDescriptor(path), ICompareUIConstants.COMPARE_IMAGE_WIDTH, onLeft);
    Image image = imageCache.createImage(desc);
    return image;
}
method: org.eclipse.jface.resource.ResourceManager.createImage(org.eclipse.jface.resource.ImageDescriptor;)org.eclipse.swt.graphics.Image;2
public final Image createImage(ImageDescriptor descriptor) {
    Assert.isNotNull(descriptor);
    return (Image) create(descriptor);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.SourceType.getSuperclassTypeSignature()java.lang.String;1
public String getSuperclassTypeSignature() throws JavaModelException {
    SourceTypeElementInfo info = (SourceTypeElementInfo) getElementInfo();
    char[] superclassName = info.getSuperclassName();
    if (superclassName == null) {
        return null;
    }
    return new  String(Signature.createTypeSignature(superclassName, false));
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.nls.NLSFragmentGenerator.join(java.lang.String;Ajava.lang.String;)java.lang.String;3
private String join(String delimiter, String[] parts) {
    return join(delimiter, parts, 0, parts.length);
}
method: org.eclipse.pde.internal.ui.nls.NLSFragmentGenerator.join(java.lang.String;Ajava.lang.String;II)java.lang.String;5
private String join(String delimiter, String[] parts, int offset, int n) {
    StringBuffer builder = new  StringBuffer();
    for (int i = offset; i < n; i++) {
        builder.append(parts[i]);
        if (i < parts.length - 1) {
            builder.append(delimiter);
        }
    }
    return builder.toString();
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.search.ConsumerReportConvertor$ConsumerReportVisitor.formatMessages(Ajava.lang.String;)java.lang.String;2
private String formatMessages(String[] messages) {
    if (messages != null) {
        StringBuffer buffer = new  StringBuffer();
        for (int i = 0; i < messages.length; i++) {
            buffer.append(messages[i]);
            if (i < messages.length - 1) {
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.auth.ConfigurationFactory.readProvider(org.eclipse.core.runtime.IConfigurationElement;)javax.security.auth.login.Configuration;2
private Configuration readProvider(IConfigurationElement element) {
    if (!ELEM_PROVIDER.equals(element.getName())) {
        reportError(SecAuthMessages.unexpectedConfigElement, element.getName(), element, null);
        return null;
    }
    try {
        return (Configuration) element.createExecutableExtension(ATTR_PROVIDER_CLASS);
    } catch (CoreException e) {
        reportError(SecAuthMessages.instantiationFailed, element.getAttribute(ATTR_PROVIDER_CLASS), element, e);
        return null;
    }
}
method: org.eclipse.equinox.internal.security.auth.ConfigurationFactory.reportError(java.lang.String;java.lang.String;org.eclipse.core.runtime.IConfigurationElement;java.lang.Throwable;)V5
private void reportError(String template, String arg, IConfigurationElement element, Throwable e) {
    String supplier = element.getContributor().getName();
    String message = NLS.bind(template, arg, supplier);
    AuthPlugin.getDefault().logError(message, e);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.auth.ext.loader.ExtLoginModuleLoader.readEntry(org.eclipse.core.runtime.IConfigurationElement;)javax.security.auth.spi.LoginModule;1
private static LoginModule readEntry(IConfigurationElement element) {
    if (!ELEM_MODULE.equals(element.getName())) {
        String supplier = element.getContributor().getName();
        String message = NLS.bind(SecAuthMessages.unexpectedConfigElement, element.getName(), supplier);
        AuthPlugin.getDefault().logError(message, null);
        return null;
    }
    try {
        LoginModule module = (LoginModule) element.createExecutableExtension(ATTR_MODULE_CLASS);
        return module;
    } catch (CoreException e) {
        String supplier = element.getContributor().getName();
        String message = NLS.bind(SecAuthMessages.instantiationFailed, element.getAttribute(ATTR_MODULE_CLASS), supplier);
        AuthPlugin.getDefault().logError(message, e);
        return null;
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyCatchesopt()V1
protected void consumeEmptyCatchesopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.ui.forms.DetailsPart.refresh()V1
public void refresh() {
    IDetailsPage page = getCurrentPage();
    if (page != null)
        page.refresh();
}
method: org.eclipse.ui.forms.DetailsPart.getCurrentPage()org.eclipse.ui.forms.IDetailsPage;1
public IDetailsPage getCurrentPage() {
    Control control = pageBook.getCurrentPage();
    if (control != null) {
        Object data = control.getData();
        if (data instanceof IDetailsPage)
            return (IDetailsPage) data;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.SmartBackspaceManager$BackspaceListener.beginChange()V1
private void beginChange() {
    ITextViewer viewer = fViewer;
    if (viewer instanceof TextViewer) {
        TextViewer v = (TextViewer) viewer;
        v.getRewriteTarget().beginCompoundChange();
    }
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSocketConnector.setKeyPassword(java.lang.String;)V2
@Deprecated
public void setKeyPassword(String password) {
    _sslContextFactory.setKeyManagerPassword(password);
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.setKeyManagerPassword(java.lang.String;)V2
public void setKeyManagerPassword(String password) {
    checkNotStarted();
    _keyManagerPassword = Password.getPassword(KEYPASSWORD_PROPERTY, password, null);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.WorkspacePluginModelManager.processModelChanges()V1
@Override
protected void processModelChanges() {
    super.processModelChanges();
    processModelChanges("org.eclipse.pde.internal.core.IExtensionDeltaEvent", fChangedExtensions);
    fChangedExtensions = null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.builders.DSMarkerFactory.createMarker(org.eclipse.core.resources.IFile;)org.eclipse.core.resources.IMarker;2
public IMarker createMarker(IFile file) throws CoreException {
    return createMarker(file, NO_RESOLUTION, "");
}
method: org.eclipse.pde.internal.ds.core.builders.DSMarkerFactory.createMarker(org.eclipse.core.resources.IFile;ILjava.lang.String;)org.eclipse.core.resources.IMarker;4
public IMarker createMarker(IFile file, int id, String category) throws CoreException {
    IMarker marker = file.createMarker(MARKER_ID);
    marker.setAttribute("id", id);
    marker.setAttribute("categoryId", category);
    return marker;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.CompletionEngine.createNonGenericTypeSignature(ACAC)AC2
public static char[] createNonGenericTypeSignature(char[] qualifiedPackageName, char[] qualifiedTypeName) {
    return Signature.createCharArrayTypeSignature(CharOperation.concat(qualifiedPackageName, CharOperation.replaceOnCopy(qualifiedTypeName, '.', '$'), '.'), true);
}

---------------Library-------------------
method: org.eclipse.jface.resource.ArrayFontDescriptor.getFontData()Aorg.eclipse.swt.graphics.FontData;1
@Override
public FontData[] getFontData() {
    return copy(data);
}
method: org.eclipse.jface.resource.FontDescriptor.copy(Aorg.eclipse.swt.graphics.FontData;)Aorg.eclipse.swt.graphics.FontData;1
public static FontData[] copy(FontData[] original) {
    FontData[] result = new FontData[original.length];
    for (int i = 0; i < original.length; i++) {
        FontData next = original[i];
        result[i] = copy(next);
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.dialogs.ResourceFilterGroup.getFilters()Aorg.eclipse.ui.ide.dialogs.UIResourceFilterDescription;1
public UIResourceFilterDescription[] getFilters() {
    FilterCopy[] newFilters = filters.getChildren();
    UIResourceFilterDescription[] result = new UIResourceFilterDescription[newFilters.length];
    for (int i = 0; i < newFilters.length; i++) {
        result[i] = newFilters[i];
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.getElementName()java.lang.String;1
public String getElementName() {
    IResource res = resource();
    if (res instanceof IFolder)
        return ((IFolder) res).getName();
    return "";
}
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.resource()org.eclipse.core.resources.IResource;1
public IResource resource() {
    if (this.resource != null)
        return this.resource;
    return super.resource();
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.ModelCompareEditorInput.createSaveable()org.eclipse.ui.Saveable;1
protected Saveable createSaveable() {
    if (input instanceof ISynchronizationCompareInput) {
        ISynchronizationCompareInput mci = (ISynchronizationCompareInput) input;
        SaveableComparison compareModel = mci.getSaveable();
        if (compareModel != null)
            return compareModel;
    }
    return super.createSaveable();
}

---------------Library-------------------
method: org.eclipse.ui.forms.FormColors.initializeFormHeaderColors()V1
protected void initializeFormHeaderColors() {
    if (colorRegistry.containsKey(IFormColors.H_BOTTOM_KEYLINE2))
        return;
    createFormHeaderColors();
}
method: org.eclipse.ui.forms.FormColors.createFormHeaderColors()V1
private void createFormHeaderColors() {
    createFormHeaderGradientColors();
    createFormHeaderKeylineColors();
    createFormHeaderDNDColors();
}
---------------Client-------------------
method: org.eclipse.ui.forms.FormColors.initializeSectionToolBarColors()V1
public void initializeSectionToolBarColors() {
    if (colorRegistry.containsKey(IFormColors.TB_BG))
        return;
    createTitleBarGradientColors();
    createTitleBarOutlineColors();
    createTwistieColors();
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.beans.BeanSetPropertyDecorator.doUpdateSet(java.lang.Object;org.eclipse.core.databinding.observable.set.SetDiff;)V3
protected void doUpdateSet(Object source, SetDiff diff) {
    delegate.updateSet(source, diff);
}
method: org.eclipse.core.databinding.property.set.SetProperty.updateSet(java.lang.Object;org.eclipse.core.databinding.observable.set.SetDiff;)V3
public final void updateSet(Object source, SetDiff diff) {
    if (source != null && !diff.isEmpty()) {
        doUpdateSet(source, diff);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.views.dependencies.DependenciesViewPage.setSelection(org.eclipse.jface.viewers.IStructuredSelection;)V2
protected void setSelection(IStructuredSelection selection) {
    if (selection != null && !selection.isEmpty())
        fViewer.setSelection(selection, true);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyAnnotationTypeMemberDeclarationsopt()V1
protected void consumeEmptyAnnotationTypeMemberDeclarationsopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.infoviews.JavadocView.addLinkListener(org.eclipse.swt.browser.Browser;)V2
private void addLinkListener(Browser browser) {
    browser.addLocationListener(JavaElementLinks.createLocationListener(new  JavaElementLinks.ILinkHandler() {

        public void handleDeclarationLink(IJavaElement target) {
            try {
                JavadocHover.openDeclaration(target);
            } catch (PartInitException e) {
                JavaPlugin.log(e);
            } catch (JavaModelException e) {
                JavaPlugin.log(e);
            }
        }

        public boolean handleExternalLink(final URL url, Display display) {
            if (fCurrent == null || !(fCurrent.getInputElement() instanceof URL && url.toExternalForm().equals(((URL) fCurrent.getInputElement()).toExternalForm()))) {
                fCurrent = new  URLBrowserInput(fCurrent, url);
                if (fBackAction != null) {
                    fBackAction.update();
                    fForthAction.update();
                }
                if (fInputSelectionProvider != null)
                    fInputSelectionProvider.setSelection(new  StructuredSelection(url));
            }
            return false;
        }

        public void handleInlineJavadocLink(IJavaElement target) {
            JavaElementBrowserInput newInput = new  JavaElementBrowserInput(fCurrent, target);
            JavadocView.this.setInput(newInput);
        }

        public void handleJavadocViewLink(IJavaElement target) {
            handleInlineJavadocLink(target);
        }

        public void handleTextSet() {
            IJavaElement input = getOrignalInput();
            if (input == null)
                return;
            if (fCurrent == null || !fCurrent.getInputElement().equals(input)) {
                fCurrent = new  JavaElementBrowserInput(null, input);
                if (fBackAction != null) {
                    fBackAction.update();
                    fForthAction.update();
                }
            }
        }
    }));
}
method: org.eclipse.swt.browser.Browser.addLocationListener(org.eclipse.swt.browser.LocationListener;)V2
public void addLocationListener(LocationListener listener) {
    checkWidget();
    if (listener == null)
        SWT.error(SWT.ERROR_NULL_ARGUMENT);
    webBrowser.addLocationListener(listener);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.RenderingViewPane.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
@Override
public void widgetSelected(SelectionEvent e) {
    if (getTopMemoryTab() == null) {
        return;
    }
    IMemoryRendering rendering = getTopMemoryTab().getRendering();
    if (rendering != null) {
        fSelectionProvider.setSelection(new  StructuredSelection(rendering));
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.ClasspathUtilCore.hasExtensibleAPI(org.eclipse.pde.core.plugin.IPluginModelBase;)Z1
public static boolean hasExtensibleAPI(IPluginModelBase model) {
    IPluginBase pluginBase = model.getPluginBase();
    if (pluginBase instanceof IPlugin)
        return hasExtensibleAPI((IPlugin) pluginBase);
    return false;
}
method: org.eclipse.pde.internal.core.ClasspathUtilCore.hasExtensibleAPI(org.eclipse.pde.core.plugin.IPlugin;)Z1
private static boolean hasExtensibleAPI(IPlugin plugin) {
    if (plugin instanceof Plugin)
        return ((Plugin) plugin).hasExtensibleAPI();
    if (plugin instanceof BundlePlugin)
        return ((BundlePlugin) plugin).hasExtensibleAPI();
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.Checks.isEnumCase(org.eclipse.jdt.core.dom.ASTNode;)Z1
public static boolean isEnumCase(ASTNode node) {
    if (node instanceof SwitchCase) {
        final SwitchCase caze = (SwitchCase) node;
        final Expression expression = caze.getExpression();
        if (expression instanceof Name) {
            final Name name = (Name) expression;
            final IBinding binding = name.resolveBinding();
            if (binding instanceof IVariableBinding) {
                IVariableBinding variableBinding = (IVariableBinding) binding;
                return variableBinding.isEnumConstant();
            }
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.value.ComputedValue.addValueChangeListener(org.eclipse.core.databinding.observable.value.IValueChangeListener;)V2
public synchronized void addValueChangeListener(IValueChangeListener listener) {
    super.addValueChangeListener(listener);
    computeValueForListeners();
}
method: org.eclipse.core.databinding.observable.value.ComputedValue.computeValueForListeners()V1
private void computeValueForListeners() {
    getRealm().exec(new  Runnable() {

        public void run() {
            if (dependencies == null) {
                if (hasListeners()) {
                    getValue();
                }
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.viewers.StructuredViewer.addDragSupport(IAorg.eclipse.swt.dnd.Transfer;org.eclipse.swt.dnd.DragSourceListener;)V4
public void addDragSupport(int operations, Transfer[] transferTypes, DragSourceListener listener) {
    Control myControl = getControl();
    final DragSource dragSource = new  DragSource(myControl, operations);
    dragSource.setTransfer(transferTypes);
    dragSource.addDragListener(listener);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.FieldDeclaration;)Z2
public boolean visit(org.eclipse.jdt.core.dom.FieldDeclaration node) {
    visitBodyDeclaration(node);
    return true;
}
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visitBodyDeclaration(org.eclipse.jdt.core.dom.BodyDeclaration;)V2
private void visitBodyDeclaration(final BodyDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)Z2
public boolean visit(SingleVariableDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.registry.ProjectImageRegistry.load()V1
public void load() {
    ProjectImageRegistryReader reader = new  ProjectImageRegistryReader();
    reader.readProjectNatureImages(Platform.getExtensionRegistry(), this);
}
method: org.eclipse.ui.internal.ide.registry.ProjectImageRegistryReader.readProjectNatureImages(org.eclipse.core.runtime.IExtensionRegistry;org.eclipse.ui.internal.ide.registry.ProjectImageRegistry;)V3
public void readProjectNatureImages(IExtensionRegistry in, ProjectImageRegistry out) {
    registry = out;
    readRegistry(in, IDEWorkbenchPlugin.IDE_WORKBENCH, IDEWorkbenchPlugin.PL_PROJECT_NATURE_IMAGES);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.extension.ExtensionEditorWizard.loadWizardCollection()V1
private void loadWizardCollection() {
    NewExtensionRegistryReader reader = new  NewExtensionRegistryReader(true);
    wizards = reader.readRegistry(PDEPlugin.getPluginId(), PLUGIN_POINT, true);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMPackage.getDetailedNode()org.eclipse.jdt.internal.core.jdom.DOMNode;1
protected DOMNode getDetailedNode() {
    return (DOMNode) getFactory().createPackage(getContents());
}
method: org.eclipse.jdt.core.jdom.DOMFactory.createPackage(java.lang.String;)org.eclipse.jdt.core.jdom.IDOMPackage;2
public IDOMPackage createPackage(String sourceCode) {
    if (sourceCode == null) {
        return null;
    }
    return (new  DOMBuilder()).createPackage(sourceCode.toCharArray());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMethod.getRawParameterNames()Ajava.lang.String;1
public String[] getRawParameterNames() throws JavaModelException {
    IBinaryMethod info = (IBinaryMethod) getElementInfo();
    int paramCount = Signature.getParameterCount(new  String(info.getMethodDescriptor()));
    return getRawParameterNames(paramCount);
}

---------------Library-------------------
method: org.eclipse.core.internal.dtree.DeltaDataTree.createChild(org.eclipse.core.runtime.IPath;java.lang.String;java.lang.Object;)V4
public void createChild(IPath parentKey, String localName, Object data) {
    if (isImmutable())
        handleImmutableTree();
    addChild(parentKey, localName, new  DataTreeNode(localName, data));
}
method: org.eclipse.core.internal.dtree.DeltaDataTree.addChild(org.eclipse.core.runtime.IPath;java.lang.String;org.eclipse.core.internal.dtree.AbstractDataTreeNode;)V4
protected void addChild(IPath parentKey, String localName, AbstractDataTreeNode childNode) {
    if (!includes(parentKey))
        handleNotFound(parentKey);
    childNode.setName(localName);
    this.assembleNode(parentKey, new  NoDataDeltaNode(parentKey.lastSegment(), childNode));
}
---------------Client-------------------
method: org.eclipse.core.internal.dtree.DeltaDataTree.deleteChild(org.eclipse.core.runtime.IPath;java.lang.String;)V3
public void deleteChild(IPath parentKey, String localName) {
    if (isImmutable())
        handleImmutableTree();
    IPath childKey = parentKey.append(localName);
    if (!includes(childKey))
        handleNotFound(childKey);
    assembleNode(parentKey, new  NoDataDeltaNode(parentKey.lastSegment(), new  DeletedNode(localName)));
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.site.CategorySection.refresh()V1
public void refresh() {
    fCategoryViewer.refresh();
    updateButtons();
    super.refresh();
}
method: org.eclipse.ui.forms.AbstractFormPart.refresh()V1
public void refresh() {
    stale = false;
    dirty = false;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.ProjectApiDescription.clean()V1
public synchronized void clean() {
    fPackageMap.clear();
    fPackageTimeStamp = -1L;
    fInSynch = false;
    modified();
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.model.AntProjectNodeProxy.toString()java.lang.String;1
@Override
public String toString() {
    return getLabel();
}
method: org.eclipse.ant.internal.ui.model.AntProjectNodeProxy.getLabel()java.lang.String;1
@Override
public String getLabel() {
    if (fProject == null) {
        parseBuildFile();
    }
    fName = super.getLabel();
    return fName;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareUIPlugin.getResourceBundle()java.util.ResourceBundle;1
public ResourceBundle getResourceBundle() {
    if (fResourceBundle == null)
        fResourceBundle = Platform.getResourceBundle(getBundle());
    return fResourceBundle;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.EclipseSynchronizer.getName(AB)java.lang.String;2
private String getName(byte[] syncBytes) throws CVSException {
    return ResourceSyncInfo.getName(syncBytes);
}
method: org.eclipse.team.internal.ccvs.core.syncinfo.ResourceSyncInfo.getName(AB)java.lang.String;1
public static String getName(byte[] syncBytes) throws CVSException {
    String name = Util.getSubstring(syncBytes, SEPARATOR_BYTE, 1, false);
    if (name == null) {
        throw new  CVSException(NLS.bind(CVSMessages.ResourceSyncInfo_malformedSyncBytes, new String[] { new  String(syncBytes) }));
    }
    return name;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.syncinfo.ResourceSyncInfo.getTagBytes(AB)AB1
public static byte[] getTagBytes(byte[] syncBytes) throws CVSException {
    byte[] tag = Util.getBytesForSlot(syncBytes, SEPARATOR_BYTE, 5, true);
    if (tag == null) {
        throw new  CVSException(NLS.bind(CVSMessages.ResourceSyncInfo_malformedSyncBytes, new String[] { new  String(syncBytes) }));
    }
    return tag;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaModelOperation.deleteResource(org.eclipse.core.resources.IResource;I)V3
protected void deleteResource(IResource resource, int flags) throws JavaModelException {
    try {
        resource.delete(flags, getSubProgressMonitor(1));
        setAttribute(HAS_MODIFIED_RESOURCE_ATTR, TRUE);
    } catch (CoreException e) {
        throw new  JavaModelException(e);
    }
}
method: org.eclipse.jdt.internal.core.JavaModelOperation.getSubProgressMonitor(I)org.eclipse.core.runtime.IProgressMonitor;2
protected IProgressMonitor getSubProgressMonitor(int workAmount) {
    IProgressMonitor sub = null;
    if (this.progressMonitor != null) {
        sub = new  SubProgressMonitor(this.progressMonitor, workAmount, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
    }
    return sub;
}
---------------Client-------------------
method: org.eclipse.jface.text.source.projection.ProjectionViewer.internalInvalidateTextPresentation(II)V3
private void internalInvalidateTextPresentation(int offset, int length) {
    if (fCommandQueue != null) {
        fCommandQueue.add(new  ProjectionCommand(offset, length));
    } else {
        invalidateTextPresentation(offset, length);
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.views.plugins.PluginsView$CollapseAllAction.run()V1
@Override
public void run() {
    fTreeViewer.collapseAll();
}
method: org.eclipse.jface.viewers.AbstractTreeViewer.collapseAll()V1
public void collapseAll() {
    Object root = getRoot();
    if (root != null) {
        collapseToLevel(root, ALL_LEVELS);
    }
}
---------------Client-------------------
method: org.eclipse.ui.actions.CopyProjectAction.displayError(java.lang.String;)V2
void displayError(String message) {
    MessageDialog.openError(this.shellProvider.getShell(), getErrorsTitle(), message);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.toc.text.TocDocumentHandler.getRootNode()org.eclipse.pde.internal.core.text.IDocumentElementNode;1
protected IDocumentElementNode getRootNode() {
    return (IDocumentElementNode) fModel.getToc();
}
method: org.eclipse.pde.internal.ua.core.toc.text.TocModel.getToc()org.eclipse.pde.internal.ua.core.toc.text.Toc;1
public Toc getToc() {
    if (fToc == null) {
        fToc = getFactory().createToc();
    }
    return fToc;
}
---------------Client-------------------
method: org.eclipse.team.ui.synchronize.ParticipantPageCompareEditorInput.getTitleImage()org.eclipse.swt.graphics.Image;1
public Image getTitleImage() {
    if (titleImage == null) {
        titleImage = participant.getImageDescriptor().createImage();
    }
    return titleImage;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.TagSource.create(Aorg.eclipse.core.resources.IResource;)org.eclipse.team.internal.ccvs.ui.tags.TagSource;1
public static TagSource create(IResource[] resources) {
    return create(getCVSResources(getProjects(resources)));
}
method: org.eclipse.team.internal.ccvs.ui.tags.TagSource.getProjects(Aorg.eclipse.core.resources.IResource;)Aorg.eclipse.core.resources.IResource;1
private static IResource[] getProjects(IResource[] resources) {
    Set result = new  HashSet();
    for (int i = 0; i < resources.length; i++) {
        IResource resource = resources[i];
        result.add(resource.getProject());
    }
    return (IResource[]) result.toArray(new IResource[result.size()]);
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.operations.RepositoryProviderOperation.getTraversalRoots()Aorg.eclipse.core.resources.IResource;1
protected IResource[] getTraversalRoots() {
    List result = new  ArrayList();
    ResourceTraversal[] traversals = getTraversals();
    for (int i = 0; i < traversals.length; i++) {
        ResourceTraversal traversal = traversals[i];
        result.addAll(Arrays.asList(traversal.getResources()));
    }
    return (IResource[]) result.toArray(new IResource[result.size()]);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.wizards.cheatsheet.NewCategoryNameDialog.createUI(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Composite;2
private Composite createUI(Composite parent) {
    Composite container = createUIContainer(parent);
    createUIInstructionLabel(container);
    createUINameField(container);
    applyDialogFont(container);
    return container;
}
method: org.eclipse.pde.internal.ua.ui.wizards.cheatsheet.NewCategoryNameDialog.createUINameField(org.eclipse.swt.widgets.Composite;)V2
private void createUINameField(Composite parent) {
    createUINameLabel(parent);
    createUINameText(parent);
}
---------------Client-------------------
method: org.eclipse.jface.viewers.ColumnViewer.getRawChildren(java.lang.Object;)Ajava.lang.Object;2
@Override
protected Object[] getRawChildren(Object parent) {
    boolean oldBusy = isBusy();
    setBusy(true);
    try {
        return super.getRawChildren(parent);
    } finally {
        setBusy(oldBusy);
    }
}

---------------Library-------------------
method: org.eclipse.ui.progress.DeferredTreeContentManager$5.add(Ajava.lang.Object;org.eclipse.core.runtime.IProgressMonitor;)V3
@Override
public void add(Object[] elements, IProgressMonitor monitor) {
    addChildren(parent, elements, monitor);
}
method: org.eclipse.ui.progress.DeferredTreeContentManager.addChildren(java.lang.Object;Ajava.lang.Object;org.eclipse.core.runtime.IProgressMonitor;)V4
protected void addChildren(final Object parent, final Object[] children, IProgressMonitor monitor) {
    WorkbenchJob updateJob = new  WorkbenchJob(ProgressMessages.DeferredTreeContentManager_AddingChildren) {

        @Override
        public IStatus runInUIThread(IProgressMonitor updateMonitor) {
            if (treeViewer.getControl().isDisposed() || updateMonitor.isCanceled()) {
                return Status.CANCEL_STATUS;
            }
            treeViewer.add(parent, children);
            return Status.OK_STATUS;
        }
    };
    updateJob.setSystem(true);
    updateJob.schedule();
}
---------------Client-------------------
method: org.eclipse.ui.internal.dialogs.ExportWizard.addPages()V1
@Override
public void addPages() {
    addPage(new  SelectionPage(this.theWorkbench, this.selection, getAvailableExportWizards(), WorkbenchMessages.ExportWizard_selectDestination));
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.builder.Reference.typeReference(org.eclipse.pde.api.tools.internal.provisional.model.IApiMember;java.lang.String;java.lang.String;I)org.eclipse.pde.api.tools.internal.builder.Reference;4
public static Reference typeReference(IApiMember origin, String typeName, String signature, int kind) {
    return typeReference(origin, typeName, signature, kind, 0);
}
method: org.eclipse.pde.api.tools.internal.builder.Reference.typeReference(org.eclipse.pde.api.tools.internal.provisional.model.IApiMember;java.lang.String;java.lang.String;II)org.eclipse.pde.api.tools.internal.builder.Reference;5
public static Reference typeReference(IApiMember origin, String typeName, String signature, int kind, int flags) {
    Reference ref = new  Reference();
    ref.fSourceMember = origin;
    ref.fTypeName = typeName;
    ref.fKind = kind;
    ref.fType = IReference.T_TYPE_REFERENCE;
    ref.fSignature = signature;
    ref.fFlags = flags;
    return ref;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.builder.Reference.fieldReference(org.eclipse.pde.api.tools.internal.provisional.model.IApiMember;java.lang.String;java.lang.String;II)org.eclipse.pde.api.tools.internal.builder.Reference;5
public static Reference fieldReference(IApiMember origin, String typeName, String fieldName, int kind, int flags) {
    Reference ref = new  Reference();
    ref.fSourceMember = origin;
    ref.fTypeName = typeName;
    ref.fMemberName = fieldName;
    ref.fKind = kind;
    ref.fType = IReference.T_FIELD_REFERENCE;
    ref.fFlags = flags;
    return ref;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.xmi.impl.SAXWrapper.startDocument()V1
@Override
public void startDocument() throws SAXException {
    handler.startDocument();
}
method: org.eclipse.emf.ecore.xmi.impl.XMLHandler.startDocument()V1
@Override
public void startDocument() {
    isRoot = true;
    helper.pushContext();
    needsPushContext = true;
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.rebuildFilters()V1
protected void rebuildFilters() {
    filters = FILTERS_CHANGED;
    enabledFilters = FILTERS_CHANGED;
    requestMarkerUpdate();
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.BasicFeatureMap.basicIndexOf(org.eclipse.emf.ecore.EStructuralFeature;java.lang.Object;)I3
public int basicIndexOf(EStructuralFeature feature, Object object) {
    return indexOf(feature, object, false);
}
method: org.eclipse.emf.ecore.util.BasicFeatureMap.indexOf(org.eclipse.emf.ecore.EStructuralFeature;java.lang.Object;Z)I4
protected int indexOf(EStructuralFeature feature, Object object, boolean resolve) {
    FeatureMapUtil.Validator validator = FeatureMapUtil.getValidator(owner.eClass(), feature);
    int result = 0;
    Entry[] entries = (Entry[]) data;
    if (FeatureMapUtil.isFeatureMap(feature)) {
        for (int i = 0; i < size; ++i) {
            Entry entry = entries[i];
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.equals(object)) {
                    return result;
                }
                ++result;
            }
        }
    } else if (object != null) {
        for (int i = 0; i < size; ++i) {
            Entry entry = entries[i];
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (object.equals(entry.getValue())) {
                    return result;
                }
                ++result;
            }
        }
        if (resolve) {
            result = 0;
            for (int i = 0; i < size; ++i) {
                Entry entry = entries[i];
                if (validator.isValid(entry.getEStructuralFeature())) {
                    if (object == resolveProxy((EObject) entry.getValue())) {
                        return result;
                    }
                    ++result;
                }
            }
        }
    } else {
        for (int i = 0; i < size; ++i) {
            Entry entry = entries[i];
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.getValue() == null) {
                    return result;
                }
                ++result;
            }
        }
    }
    return -1;
}
---------------Client-------------------
method: org.eclipse.emf.ecore.util.BasicFeatureMap.lastIndexOf(org.eclipse.emf.ecore.EStructuralFeature;java.lang.Object;Z)I4
protected int lastIndexOf(EStructuralFeature feature, Object object, boolean resolve) {
    FeatureMapUtil.Validator validator = FeatureMapUtil.getValidator(owner.eClass(), feature);
    int result = -1;
    int count = 0;
    Entry[] entries = (Entry[]) data;
    if (FeatureMapUtil.isFeatureMap(feature)) {
        for (int i = 0; i < size; ++i) {
            Entry entry = entries[i];
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.equals(object)) {
                    result = count;
                }
                ++count;
            }
        }
    } else if (object != null) {
        for (int i = 0; i < size; ++i) {
            Entry entry = entries[i];
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (object.equals(entry.getValue())) {
                    result = count;
                }
                ++count;
            }
        }
        if (resolve) {
            result = -1;
            count = 0;
            for (int i = 0; i < size; ++i) {
                Entry entry = entries[i];
                if (validator.isValid(entry.getEStructuralFeature())) {
                    if (object == resolveProxy((EObject) entry.getValue())) {
                        result = count;
                    }
                    ++count;
                }
            }
        }
    } else {
        for (int i = 0; i < size; ++i) {
            Entry entry = entries[i];
            if (validator.isValid(entry.getEStructuralFeature())) {
                if (entry.getValue() == null) {
                    result = count;
                }
                ++count;
            }
        }
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSocketConnector.setTrustPassword(java.lang.String;)V2
@Deprecated
public void setTrustPassword(String password) {
    _sslContextFactory.setTrustStorePassword(password);
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.setTrustStorePassword(java.lang.String;)V2
public void setTrustStorePassword(String password) {
    checkNotStarted();
    _trustStorePassword = Password.getPassword(PASSWORD_PROPERTY, password, null);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.WorkspacePluginModelManager.processModelChanges()V1
@Override
protected void processModelChanges() {
    super.processModelChanges();
    processModelChanges("org.eclipse.pde.internal.core.IExtensionDeltaEvent", fChangedExtensions);
    fChangedExtensions = null;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.SingleFileTagSource.getLocation()org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;1
public ICVSRepositoryLocation getLocation() {
    RepositoryManager mgr = CVSUIPlugin.getPlugin().getRepositoryManager();
    ICVSRepositoryLocation location = mgr.getRepositoryLocationFor(file);
    return location;
}
method: org.eclipse.team.internal.ccvs.ui.CVSUIPlugin.getRepositoryManager()org.eclipse.team.internal.ccvs.ui.repo.RepositoryManager;1
public synchronized RepositoryManager getRepositoryManager() {
    if (repositoryManager == null) {
        repositoryManager = new  RepositoryManager();
        repositoryManager.startup();
    }
    return repositoryManager;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.AntEditor.getOutlinePage()org.eclipse.ant.internal.ui.editor.outline.AntEditorContentOutlinePage;1
private AntEditorContentOutlinePage getOutlinePage() {
    if (fOutlinePage == null) {
        fOutlinePage = new  AntEditorContentOutlinePage(AntModelCore.getDefault(), this);
        fOutlinePage.addPostSelectionChangedListener(fSelectionChangedListener);
        setOutlinePageInput();
    }
    return fOutlinePage;
}

---------------Library-------------------
method: org.eclipse.core.internal.plugins.InternalPlatform.getPluginDescriptor(java.lang.String;)org.eclipse.core.runtime.IPluginDescriptor;1
public static IPluginDescriptor getPluginDescriptor(String pluginId) {
    return getPluginRegistry().getPluginDescriptor(pluginId);
}
method: org.eclipse.core.internal.plugins.InternalPlatform.getPluginRegistry()org.eclipse.core.runtime.IPluginRegistry;0
public static IPluginRegistry getPluginRegistry() {
    if (registry == null) {
        registry = new  PluginRegistry();
    }
    return registry;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyArrayInitializeropt()V1
protected void consumeEmptyArrayInitializeropt() {
    pushOnExpressionStackLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnExpressionStackLengthStack(I)V2
protected void pushOnExpressionStackLengthStack(int pos) {
    int stackLength = this.expressionLengthStack.length;
    if (++this.expressionLengthPtr >= stackLength) {
        System.arraycopy(this.expressionLengthStack, 0, this.expressionLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.expressionLengthStack[this.expressionLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEPackage_UniqueClassifierNames(org.eclipse.emf.ecore.EPackage;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEPackage_UniqueClassifierNames(EPackage ePackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    Map<String, List<EClassifier>> keys = new  HashMap<String, List<EClassifier>>();
    for (EClassifier eClassifier : ePackage.getEClassifiers()) {
        String name = eClassifier.getName();
        if (name != null) {
            String key = name.replace("_", "").toLowerCase();
            List<EClassifier> eClassifiers = keys.get(key);
            if (eClassifiers == null) {
                eClassifiers = new  ArrayList<EClassifier>();
                keys.put(key, eClassifiers);
            }
            eClassifiers.add(eClassifier);
            if (eClassifiers.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EClassifier>> entry : keys.entrySet()) {
            List<EClassifier> eClassifiers = entry.getValue();
            if (eClassifiers.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(ePackage);
                for (EClassifier eClassifier : eClassifiers) {
                    names.add(eClassifier.getName());
                    objects.add(eClassifier);
                }
                objects.add(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageDissimilarClassifierNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageUniqueClassifierNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}
method: org.eclipse.emf.ecore.impl.ENamedElementImpl.getName()java.lang.String;1
public String getName() {
    return getNameGen();
}
---------------Client-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEEnum_UniqueEnumeratorNames(org.eclipse.emf.ecore.EEnum;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEEnum_UniqueEnumeratorNames(EEnum eEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    EList<EEnumLiteral> eLiterals = eEnum.getELiterals();
    Map<String, List<EEnumLiteral>> keys = new  HashMap<String, List<EEnumLiteral>>();
    for (EEnumLiteral eEnumLiteral : eLiterals) {
        String name = eEnumLiteral.getName();
        if (name != null) {
            String key = name.replace("_", "").toUpperCase();
            List<EEnumLiteral> eEnumLiterals = keys.get(key);
            if (eEnumLiterals == null) {
                eEnumLiterals = new  ArrayList<EEnumLiteral>();
                keys.put(key, eEnumLiterals);
            }
            eEnumLiterals.add(eEnumLiteral);
            if (eEnumLiterals.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EEnumLiteral>> entry : keys.entrySet()) {
            List<EEnumLiteral> eEnumLiterals = entry.getValue();
            if (eEnumLiterals.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(eEnum);
                for (EEnumLiteral eEnumLiteral : eEnumLiterals) {
                    names.add(eEnumLiteral.getName());
                    objects.add(eEnumLiteral);
                }
                objects.add(EcorePackage.Literals.EENUM__ELITERALS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumDissimilarEnumeratorNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumUniqueEnumeratorNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEPackage_UniqueClassifierNames(org.eclipse.emf.ecore.EPackage;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEPackage_UniqueClassifierNames(EPackage ePackage, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    Map<String, List<EClassifier>> keys = new  HashMap<String, List<EClassifier>>();
    for (EClassifier eClassifier : ePackage.getEClassifiers()) {
        String name = eClassifier.getName();
        if (name != null) {
            String key = name.replace("_", "").toLowerCase();
            List<EClassifier> eClassifiers = keys.get(key);
            if (eClassifiers == null) {
                eClassifiers = new  ArrayList<EClassifier>();
                keys.put(key, eClassifiers);
            }
            eClassifiers.add(eClassifier);
            if (eClassifiers.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EClassifier>> entry : keys.entrySet()) {
            List<EClassifier> eClassifiers = entry.getValue();
            if (eClassifiers.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(ePackage);
                for (EClassifier eClassifier : eClassifiers) {
                    names.add(eClassifier.getName());
                    objects.add(eClassifier);
                }
                objects.add(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageDissimilarClassifierNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageUniqueClassifierNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}
method: org.eclipse.emf.ecore.impl.ENamedElementImpl.getName()java.lang.String;1
public String getName() {
    return getNameGen();
}
---------------Client-------------------
method: org.eclipse.emf.ecore.util.EcoreValidator.validateEEnum_UniqueEnumeratorNames(org.eclipse.emf.ecore.EEnum;org.eclipse.emf.common.util.DiagnosticChain;java.util.Map;)Z4
public boolean validateEEnum_UniqueEnumeratorNames(EEnum eEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = true;
    EList<EEnumLiteral> eLiterals = eEnum.getELiterals();
    Map<String, List<EEnumLiteral>> keys = new  HashMap<String, List<EEnumLiteral>>();
    for (EEnumLiteral eEnumLiteral : eLiterals) {
        String name = eEnumLiteral.getName();
        if (name != null) {
            String key = name.replace("_", "").toUpperCase();
            List<EEnumLiteral> eEnumLiterals = keys.get(key);
            if (eEnumLiterals == null) {
                eEnumLiterals = new  ArrayList<EEnumLiteral>();
                keys.put(key, eEnumLiterals);
            }
            eEnumLiterals.add(eEnumLiteral);
            if (eEnumLiterals.size() > 1) {
                if (diagnostics == null) {
                    return false;
                } else {
                    result = false;
                }
            }
        }
    }
    if (!result) {
        for (Map.Entry<String, List<EEnumLiteral>> entry : keys.entrySet()) {
            List<EEnumLiteral> eEnumLiterals = entry.getValue();
            if (eEnumLiterals.size() > 1) {
                List<String> names = new  UniqueEList<String>();
                List<Object> objects = new  ArrayList<Object>();
                objects.add(eEnum);
                for (EEnumLiteral eEnumLiteral : eEnumLiterals) {
                    names.add(eEnumLiteral.getName());
                    objects.add(eEnumLiteral);
                }
                objects.add(EcorePackage.Literals.EENUM__ELITERALS);
                if (names.size() == objects.size() - 2) {
                    diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumDissimilarEnumeratorNames_diagnostic", names.toArray(new Object[names.size()]), objects.toArray(new Object[objects.size()]), context));
                } else {
                    diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, "_UI_EEnumUniqueEnumeratorNames_diagnostic", new Object[] { names.get(0) }, objects.toArray(new Object[objects.size()]), context));
                }
            }
        }
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Diffs$2.getRemovals()java.util.Set;1
public Set getRemovals() {
    return getLazyDiff().getRemovals();
}
method: org.eclipse.core.databinding.observable.Diffs$2.getLazyDiff()org.eclipse.core.databinding.observable.set.SetDiff;1
private SetDiff getLazyDiff() {
    if (lazyDiff == null) {
        lazyDiff = computeSetDiff(oldSet, newSet);
    }
    return lazyDiff;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.Diffs$1.getDifferences()Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;1
public ListDiffEntry[] getDifferences() {
    if (lazyDiff == null) {
        lazyDiff = Diffs.computeListDiff(oldList, newList);
    }
    return lazyDiff.getDifferences();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.jarpackagerfat.FatJarBuilder.writeFile(org.eclipse.core.resources.IFile;org.eclipse.core.runtime.IPath;)V3
public void writeFile(IFile resource, IPath destinationPath) throws CoreException {
    fJarWriter.write(resource, destinationPath);
}
method: org.eclipse.jdt.ui.jarpackager.JarWriter3.write(org.eclipse.core.resources.IFile;org.eclipse.core.runtime.IPath;)V3
public void write(IFile resource, IPath destinationPath) throws CoreException {
    try {
        if (fJarPackage.areDirectoryEntriesIncluded())
            addDirectories(resource, destinationPath);
        addFile(resource, destinationPath);
    } catch (IOException ex) {
        String message = null;
        if (ex.getLocalizedMessage() != null)
            message = Messages.format(JarPackagerMessages.JarWriter_writeProblemWithMessage, new Object[] { BasicElementLabels.getPathLabel(resource.getFullPath(), false), ex.getLocalizedMessage() });
        else
            message = Messages.format(JarPackagerMessages.JarWriter_writeProblem, BasicElementLabels.getPathLabel(resource.getFullPath(), false));
        throw JarPackagerUtil.createCoreException(message, ex);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsConstraintCreator.createWildcardConstraint(org.eclipse.jdt.internal.corext.refactoring.typeconstraints.types.WildcardType;org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.CollectionElementVariable2;org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;)V4
private void createWildcardConstraint(WildcardType typeArgument, CollectionElementVariable2 argElementCv, ConstraintVariable2 paramElementCv) {
    if (typeArgument.isExtendsWildcardType())
        fTCModel.createSubtypeConstraint(argElementCv, paramElementCv);
    else
        fTCModel.createSubtypeConstraint(paramElementCv, argElementCv);
}

---------------Library-------------------
method: org.eclipse.ui.actions.CompoundContributionItem.dispose()V1
@Override
public void dispose() {
    disposeOldItems();
    super.dispose();
}
method: org.eclipse.ui.actions.CompoundContributionItem.disposeOldItems()V1
private void disposeOldItems() {
    if (oldItems != null) {
        for (int i = 0; i < oldItems.length; i++) {
            IContributionItem oldItem = oldItems[i];
            oldItem.dispose();
        }
        oldItems = null;
    }
}
---------------Client-------------------
method: org.eclipse.debug.core.sourcelookup.containers.CompositeSourceContainer.dispose()V1
@Override
public void dispose() {
    super.dispose();
    if (fContainers != null) {
        for (int i = 0; i < fContainers.length; i++) {
            ISourceContainer container = fContainers[i];
            container.dispose();
        }
    }
    fContainers = null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.extension.ExtensionEditorWizard.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.CVSRepositoryPropertiesPage.createTextField(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Text;2
protected Text createTextField(Composite parent) {
    Text text = new  Text(parent, SWT.SINGLE | SWT.BORDER);
    return layoutTextField(text);
}
method: org.eclipse.team.internal.ccvs.ui.repo.CVSRepositoryPropertiesPage.layoutTextField(org.eclipse.swt.widgets.Text;)org.eclipse.swt.widgets.Text;2
protected Text layoutTextField(Text text) {
    GridData data = new  GridData(GridData.FILL_HORIZONTAL);
    data.verticalAlignment = GridData.CENTER;
    data.grabExcessVerticalSpace = false;
    data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
    data.horizontalSpan = 2;
    text.setLayoutData(data);
    return text;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.TagSelectionArea.createText(org.eclipse.swt.widgets.Composite;I)org.eclipse.swt.widgets.Text;3
private Text createText(Composite parent, int horizontalSpan) {
    Text text = new  Text(parent, SWT.SEARCH);
    GridData data = new  GridData();
    data.horizontalSpan = horizontalSpan;
    data.horizontalAlignment = GridData.FILL;
    data.grabExcessHorizontalSpace = true;
    data.widthHint = 0;
    text.setLayoutData(data);
    return text;
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
method: org.eclipse.ui.internal.console.ConsoleDropDownAction.dispose()V1
@Override
public void dispose() {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fView = null;
    ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.imports.FeatureImportWizardPage.dispose()V1
@Override
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.views.imagebrowser.ImageBrowserView.dispose()V1
@Override
public void dispose() {
    disposeImages();
}
method: org.eclipse.pde.internal.ui.views.imagebrowser.ImageBrowserView.disposeImages()V1
private void disposeImages() {
    for (Image image : displayedImages) {
        image.dispose();
    }
    displayedImages.clear();
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.renderers.swt.SWTPartRenderer$3.run()V1
@Override
public void run() {
    for (Image image : imageMap.values()) {
        image.dispose();
    }
}

---------------Library-------------------
method: org.apache.lucene.analysis.query.QueryAutoStopWordAnalyzer.addStopWords(org.apache.lucene.index.IndexReader;)I2
@Deprecated
public int addStopWords(IndexReader reader) throws IOException {
    return addStopWords(reader, defaultMaxDocFreqPercent);
}
method: org.apache.lucene.analysis.query.QueryAutoStopWordAnalyzer.addStopWords(org.apache.lucene.index.IndexReader;F)I3
@Deprecated
public int addStopWords(IndexReader reader, float maxPercentDocs) throws IOException {
    int numStopWords = 0;
    Collection<String> fieldNames = reader.getFieldNames(IndexReader.FieldOption.INDEXED);
    for (Iterator<String> iter = fieldNames.iterator(); iter.hasNext(); ) {
        String fieldName = iter.next();
        numStopWords += addStopWords(reader, fieldName, maxPercentDocs);
    }
    return numStopWords;
}
---------------Client-------------------
method: org.apache.lucene.analysis.query.QueryAutoStopWordAnalyzer.addStopWords(org.apache.lucene.index.IndexReader;I)I3
@Deprecated
public int addStopWords(IndexReader reader, int maxDocFreq) throws IOException {
    int numStopWords = 0;
    Collection<String> fieldNames = reader.getFieldNames(IndexReader.FieldOption.INDEXED);
    for (Iterator<String> iter = fieldNames.iterator(); iter.hasNext(); ) {
        String fieldName = iter.next();
        numStopWords += addStopWords(reader, fieldName, maxDocFreq);
    }
    return numStopWords;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.value.DuplexingObservableValue.addChangeListener(org.eclipse.core.databinding.observable.IChangeListener;)V2
public synchronized void addChangeListener(IChangeListener listener) {
    super.addChangeListener(listener);
    computeValueForListeners();
}
method: org.eclipse.core.databinding.observable.value.DuplexingObservableValue.computeValueForListeners()V1
private void computeValueForListeners() {
    getRealm().exec(new  Runnable() {

        public void run() {
            if (hasListeners()) {
                getValue();
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.viewers.StructuredViewer.addDragSupport(IAorg.eclipse.swt.dnd.Transfer;org.eclipse.swt.dnd.DragSourceListener;)V4
public void addDragSupport(int operations, Transfer[] transferTypes, DragSourceListener listener) {
    Control myControl = getControl();
    final DragSource dragSource = new  DragSource(myControl, operations);
    dragSource.setTransfer(transferTypes);
    dragSource.addDragListener(listener);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.TypeDeclaration;)Z2
public boolean visit(org.eclipse.jdt.core.dom.TypeDeclaration node) {
    visitBodyDeclaration(node);
    return true;
}
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visitBodyDeclaration(org.eclipse.jdt.core.dom.BodyDeclaration;)V2
private void visitBodyDeclaration(final BodyDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)Z2
public boolean visit(SingleVariableDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.osgi.container.Module.isTriggerSet()Z1
private boolean isTriggerSet() {
    ModuleLoader loader = getCurrentLoader();
    return loader == null ? false : loader.isTriggerSet();
}
method: org.eclipse.osgi.container.Module.getCurrentLoader()org.eclipse.osgi.container.ModuleLoader;1
private ModuleLoader getCurrentLoader() {
    ModuleRevision current = getCurrentRevision();
    if (current == null) {
        return null;
    }
    ModuleWiring wiring = current.getWiring();
    if (wiring == null) {
        return null;
    }
    try {
        return wiring.getModuleLoader();
    } catch (UnsupportedOperationException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.PDESection.isEditable()Z1
public boolean isEditable() {
    IBaseModel model = getPage().getPDEEditor().getAggregateModel();
    return model == null ? false : model.isEditable();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.InternalClassFileEditorInput.getToolTipText()java.lang.String;1
public String getToolTipText() {
    return fClassFile.getType().getFullyQualifiedName();
}
method: org.eclipse.jdt.internal.core.ClassFile.getType()org.eclipse.jdt.core.IType;1
public IType getType() {
    if (this.binaryType == null) {
        this.binaryType = new  BinaryType(this, getTypeName());
    }
    return this.binaryType;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.map.DecoratingObservableMap.entrySet()java.util.Set;1
public Set entrySet() {
    getterCalled();
    if (entrySet == null) {
        entrySet = new  BackedSet(decorated.entrySet());
    }
    return entrySet;
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.ViewerColumnsDialog.performDefaults()V1
protected void performDefaults() {
    refreshViewers();
    super.performDefaults();
}
method: org.eclipse.ui.internal.views.markers.ViewerColumnsDialog.refreshViewers()V1
void refreshViewers() {
    if (nonVisibleViewer != null) {
        nonVisibleViewer.refresh();
    }
    if (visibleViewer != null) {
        visibleViewer.refresh();
    }
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.history.BrowseRefactoringHistoryLabelProvider.dispose()V1
public void dispose() {
    if (fDelegateLabelProvider != null) {
        fDelegateLabelProvider.dispose();
    }
    if (fWorkbenchLabelProvider != null) {
        fWorkbenchLabelProvider.dispose();
    }
    super.dispose();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.resources.SessionPropertySyncInfoCache.safeSetSessionProperty(org.eclipse.core.resources.IResource;org.eclipse.core.runtime.QualifiedName;java.lang.Object;)V4
void safeSetSessionProperty(IResource resource, QualifiedName key, Object value) throws CVSException {
    try {
        resource.setSessionProperty(key, value);
    } catch (CoreException e) {
        throw CVSException.wrapException(e);
    }
}
method: org.eclipse.core.internal.resources.Resource.setSessionProperty(org.eclipse.core.runtime.QualifiedName;java.lang.Object;)V3
public void setSessionProperty(QualifiedName key, Object value) throws CoreException {
    ResourceInfo info = checkAccessibleAndLocal(DEPTH_ZERO);
    info.setSessionProperty(key, value);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ua.core.cheatsheet.comp.CompCS.write(java.lang.String;java.io.PrintWriter;)V3
public void write(String indent, PrintWriter writer) {
    try {
        XMLPrintHandler.printHead(writer, ATTRIBUTE_VALUE_ENCODING);
        super.write(indent, writer);
    } catch (IOException e) {
    }
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Diffs$4.getAddedKeys()java.util.Set;1
public Set getAddedKeys() {
    return getLazyDiff().getAddedKeys();
}
method: org.eclipse.core.databinding.observable.Diffs$4.getLazyDiff()org.eclipse.core.databinding.observable.map.MapDiff;1
private MapDiff getLazyDiff() {
    if (lazyDiff == null) {
        lazyDiff = computeMapDiff(oldMap, newMap);
    }
    return lazyDiff;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.Diffs$1.getDifferences()Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;1
public ListDiffEntry[] getDifferences() {
    if (lazyDiff == null) {
        lazyDiff = Diffs.computeListDiff(oldList, newList);
    }
    return lazyDiff.getDifferences();
}

---------------Library-------------------
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.addBundleFileWrapperFactoryHook(org.eclipse.osgi.internal.hookregistry.BundleFileWrapperFactoryHook;)V2
public void addBundleFileWrapperFactoryHook(BundleFileWrapperFactoryHook factory) {
    add(factory, bundleFileWrapperFactoryHooks);
}
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.add(java.lang.Object;java.util.List;)V3
private <H> void add(H hook, List<H> hooks) {
    if (initialized)
        throw new  IllegalStateException("Cannot add hooks dynamically.");
    hooks.add(hook);
}
---------------Client-------------------
method: org.eclipse.emf.common.command.CompoundCommand.append(org.eclipse.emf.common.command.Command;)V2
public void append(Command command) {
    if (isPrepared) {
        throw new  IllegalStateException("The command is already prepared");
    }
    if (command != null) {
        commandList.add(command);
    }
}

---------------Library-------------------
method: org.eclipse.equinox.p2.engine.ProvisioningContext.getMetadata(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.equinox.p2.query.IQueryable;2
public IQueryable<IInstallableUnit> getMetadata(IProgressMonitor monitor) {
    return QueryUtil.compoundQueryable(getLoadedMetadataRepositories(monitor));
}
method: org.eclipse.equinox.p2.query.QueryUtil.compoundQueryable(java.util.Collection;)org.eclipse.equinox.p2.query.IQueryable;1
public static <T> IQueryable<T> compoundQueryable(Collection<? extends IQueryable<T>> queryables) {
    return new  CompoundQueryable<T>(queryables.toArray(new IQueryable[queryables.size()]));
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.util.Changes.getModifiedFiles(Aorg.eclipse.ltk.core.refactoring.Change;)Aorg.eclipse.core.resources.IFile;1
public static IFile[] getModifiedFiles(Change[] changes) {
    List<IFile> result = new  ArrayList<IFile>();
    getModifiedFiles(result, changes);
    return result.toArray(new IFile[result.size()]);
}

---------------Library-------------------
method: org.eclipse.ui.internal.progress.ProgressMonitorFocusJobDialog$3$4.run()V1
@Override
public void run() {
    getProgressMonitor().internalWorked(finalWork);
}
method: org.eclipse.ui.internal.progress.ProgressMonitorJobsDialog.getProgressMonitor()org.eclipse.core.runtime.IProgressMonitor;1
@Override
public IProgressMonitor getProgressMonitor() {
    if (wrapperedMonitor == null) {
        createWrapperedMonitor();
    }
    return wrapperedMonitor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.menus.PulldownDelegateWidgetProxy$1.widgetDisposed(org.eclipse.swt.events.DisposeEvent;)V2
@Override
public void widgetDisposed(DisposeEvent e) {
    if (e.widget == widget) {
        dispose();
        widget = null;
    }
}

---------------Library-------------------
method: org.eclipse.jface.internal.text.link.contentassist.ContentAssistant2.showContextInformation()java.lang.String;1
public String showContextInformation() {
    return fContextInfoPopup.showContextProposals(false);
}
method: org.eclipse.jface.internal.text.link.contentassist.ContextInformationPopup2.showContextProposals(Z)java.lang.String;2
public String showContextProposals(final boolean autoActivated) {
    final StyledText styledText = fViewer.getTextWidget();
    BusyIndicator.showWhile(styledText.getDisplay(), new  Runnable() {

        public void run() {
            int position = fViewer.getSelectedRange().x;
            IContextInformation[] contexts = computeContextInformation(position);
            int count = (contexts == null ? 0 : contexts.length);
            if (count == 1) {
                internalShowContextInfo(contexts[0], position);
            } else if (count > 0) {
                if (fLineDelimiter == null)
                    fLineDelimiter = styledText.getLineDelimiter();
                createContextSelector();
                setContexts(contexts);
                displayContextSelector();
                hideContextInfoPopup();
            }
        }
    });
    return getErrorMessage();
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.GenerateDiffFileWizard$LocationPage.getAllOutOfSync()org.eclipse.team.core.synchronize.SyncInfoSet;1
private SyncInfoSet getAllOutOfSync() throws CVSException {
    final SubscriberSyncInfoCollector syncInfoCollector = fParticipant.getSubscriberSyncInfoCollector();
    class WaitForChangesJob extends Job {

        LocationPage fLocationPage;

        public WaitForChangesJob(LocationPage page) {
            super("");
            fLocationPage = page;
        }

        public IStatus run(IProgressMonitor monitor) {
            monitor.beginTask(CVSUIMessages.CommitWizard_4, IProgressMonitor.UNKNOWN);
            syncInfoCollector.waitForCollector(monitor);
            Utils.syncExec(new  Runnable() {

                public void run() {
                    fLocationPage.initCheckedItems();
                    fLocationPage.canValidate = true;
                    fLocationPage.validatePage();
                }
            }, getControl());
            monitor.done();
            return Status.OK_STATUS;
        }
    }
    WaitForChangesJob job = new  WaitForChangesJob(this);
    job.setSystem(true);
    job.schedule();
    return fParticipant.getSyncInfoSet();
}

---------------Library-------------------
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createHVFillGridData()org.eclipse.swt.layout.GridData;0
public static GridData createHVFillGridData() {
    return createHVFillGridData(1);
}
method: org.eclipse.jsch.internal.ui.preference.SWTUtils.createHVFillGridData(I)org.eclipse.swt.layout.GridData;1
public static GridData createHVFillGridData(int span) {
    final GridData gd = createGridData(0, 0, true, true);
    gd.horizontalSpan = span;
    return gd;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.InternalTargetFilter.filter(org.eclipse.jface.viewers.Viewer;java.lang.Object;Ajava.lang.Object;)Ajava.lang.Object;4
@Override
public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
    fFiltered = 0;
    return super.filter(viewer, parent, elements);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering.handlePageSizeChanged(I)V2
private void handlePageSizeChanged(int pageSize) {
    fPageSize = pageSize;
    fContentDescriptor.setNumLines(pageSize);
    refresh();
}
method: org.eclipse.debug.internal.ui.memory.provisional.AbstractAsyncTableRendering.refresh()V1
@Override
public void refresh() {
    if (!fIsCreated) {
        return;
    }
    fTableViewer.refresh();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.NewLibraryPluginCreationPage$PropertiesListener.modifyText(org.eclipse.swt.events.ModifyEvent;)V2
public void modifyText(ModifyEvent e) {
    if (!fBlocked) {
        fChanged = true;
        setPageComplete(validatePage());
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSMasterTreeSection.handleAddSubStepAction()V1
private void handleAddSubStepAction() {
    ISimpleCSObject csObject = getCurrentSelection();
    if (csObject == null) {
        return;
    }
    fAddSubStepAction.setDataObject(csObject);
    fAddSubStepAction.run();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.actions.SimpleCSAddSubStepAction.run()V1
public void run() {
    if (fItem == null) {
        return;
    }
    ISimpleCSSubItem newSubItem = createNewSubItem();
    insertNewSubItem(newSubItem);
}
---------------Client-------------------
method: org.eclipse.ui.internal.cheatsheets.composite.views.CompositeCheatSheetPage.showDescription(org.eclipse.ui.internal.provisional.cheatsheets.ICompositeCheatSheetTask;)V2
private void showDescription(final ICompositeCheatSheetTask task) {
    if (descriptionPanel == null) {
        createDescriptionPanel();
    }
    descriptionPanel.showDescription(task);
    setCurrentEditor(descriptionPanel.getControl());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.viewsupport.SelectionProviderMediator$InternalPostSelectionListener.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    doPostSelectionChanged(event);
}
method: org.eclipse.jdt.internal.ui.viewsupport.SelectionProviderMediator.doPostSelectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
final void doPostSelectionChanged(SelectionChangedEvent event) {
    ISelectionProvider provider = event.getSelectionProvider();
    if (provider == fViewerInFocus) {
        firePostSelectionChanged();
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.handleEvent(org.eclipse.swt.widgets.Event;)V2
@Override
public void handleEvent(Event e) {
    Widget source = e.widget;
    if (source == destinationBrowseButton) {
        handleDestinationBrowseButtonPressed();
    }
    updatePageCompletion();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractMethodRefactoring$UsedNamesCollector.visit(org.eclipse.jdt.core.dom.TypeDeclaration;)Z2
@Override
public boolean visit(TypeDeclaration node) {
    return visitType(node);
}
method: org.eclipse.jdt.internal.corext.refactoring.code.ExtractMethodRefactoring$UsedNamesCollector.visitType(org.eclipse.jdt.core.dom.AbstractTypeDeclaration;)Z2
private boolean visitType(AbstractTypeDeclaration node) {
    result.add(node.getName().getIdentifier());
    return false;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.SimpleLicenseManager.accept(org.eclipse.equinox.p2.metadata.ILicense;)Z2
public boolean accept(ILicense license) {
    accepted.add(license.getUUID());
    updatePreferences();
    return true;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.process(org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;java.util.List;)V3
protected void process(GenericSequentialFlowInfo info, List<? extends ASTNode> nodes) {
    if (nodes == null)
        return;
    for (Iterator<? extends ASTNode> iter = nodes.iterator(); iter.hasNext(); ) {
        info.merge(getFlowInfo(iter.next()), fFlowContext);
    }
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo.merge(org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowContext;)V3
public void merge(FlowInfo info, FlowContext context) {
    if (info == null)
        return;
    mergeSequential(info, context);
}
---------------Client-------------------
method: org.eclipse.search.internal.ui.SearchManager.handleUpdateMatch(org.eclipse.core.resources.IMarker;)V2
private void handleUpdateMatch(IMarker marker) {
    SearchResultViewEntry entry = findEntry(marker);
    if (entry != null) {
        Iterator iter = fListeners.iterator();
        while (iter.hasNext()) ((SearchResultViewer) iter.next()).handleUpdateMatch(entry, false);
    }
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.ComputedSet.addChangeListener(org.eclipse.core.databinding.observable.IChangeListener;)V2
public synchronized void addChangeListener(IChangeListener listener) {
    super.addChangeListener(listener);
    computeSetForListeners();
}
method: org.eclipse.core.databinding.observable.set.ComputedSet.computeSetForListeners()V1
private void computeSetForListeners() {
    getRealm().exec(new  Runnable() {

        public void run() {
            if (dependencies == null) {
                getSet();
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.viewers.StructuredViewer.addDragSupport(IAorg.eclipse.swt.dnd.Transfer;org.eclipse.swt.dnd.DragSourceListener;)V4
public void addDragSupport(int operations, Transfer[] transferTypes, DragSourceListener listener) {
    Control myControl = getControl();
    final DragSource dragSource = new  DragSource(myControl, operations);
    dragSource.setTransfer(transferTypes);
    dragSource.addDragListener(listener);
}

---------------Library-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem.search(java.lang.String;)V2
@Override
public void search(String expression) {
    AbstractHelpUI helpUI = getHelpUI();
    if (helpUI != null) {
        helpUI.search(expression);
    }
}
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem.getHelpUI()org.eclipse.ui.help.AbstractHelpUI;1
private AbstractHelpUI getHelpUI() {
    if (!isInitialized) {
        isInitialized = initializePluggableHelpUI();
    }
    return pluggableHelpUI;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.util.xml.XmlSerializer.closeOpeningTag()V1
private void closeOpeningTag() throws IOException {
    if (!this.closed) {
        writeAttributes();
        closed = true;
        writer.write(">");
    }
}

---------------Library-------------------
method: org.eclipse.equinox.internal.util.ref.TimerRef.removeListener(org.eclipse.equinox.internal.util.timer.TimerListener;I)V2
public static void removeListener(TimerListener listener, int event) {
    if (timer == null)
        return;
    timer.removeListener(listener, event);
}
method: org.eclipse.equinox.internal.util.impl.tpt.timer.TimerFactory.removeListener(org.eclipse.equinox.internal.util.timer.TimerListener;I)V3
public void removeListener(TimerListener listener, int event) {
    TimerImpl tmp = timer;
    if (tmp == null)
        throw new  RuntimeException("This is a zombie!");
    tmp.removeListener(listener, event);
}
---------------Client-------------------
method: org.eclipse.equinox.http.jetty.internal.Activator.startServer(java.lang.String;java.util.Dictionary;)V2
public static synchronized void startServer(String pid, Dictionary<String, ?> settings) throws Exception {
    if (staticServerManager == null)
        throw new  IllegalStateException("Inactive");
    staticServerManager.updated(pid, settings);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.product.SplashLocationSection.refresh()V1
public void refresh() {
    ISplashInfo info = getSplashInfo();
    fPluginEntry.setValue(info.getLocation(), true);
    super.refresh();
}
method: org.eclipse.pde.internal.ui.parts.FormEntry.setValue(java.lang.String;Z)V3
public void setValue(String value, boolean blockNotification) {
    fIgnoreModify = blockNotification;
    setValue(value);
    fIgnoreModify = false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathsBlock.initializeTimeStamps()V1
public void initializeTimeStamps() {
    IFile file = fCurrJProject.getProject().getFile(".classpath");
    fFileTimeStamp = file.getModificationStamp();
    fUserSettingsTimeStamp = getEncodedSettings();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginObjectNode.getWritableString(java.lang.String;)java.lang.String;2
public String getWritableString(String source) {
    return PDEXMLHelper.getWritableString(source);
}
method: org.eclipse.pde.internal.core.util.PDEXMLHelper.getWritableString(java.lang.String;)java.lang.String;1
public static String getWritableString(String source) {
    if (source == null)
        return "";
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.getWritableString(java.lang.String;)java.lang.String;2
private String getWritableString(String source) {
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.editor.text.NotifyingReconciler.initialProcess()V1
@Override
protected void initialProcess() {
    super.initialProcess();
    notifyReconcilingParticipants();
}
method: org.eclipse.jface.text.reconciler.MonoReconciler.initialProcess()V1
protected void initialProcess() {
    if (fStrategy instanceof IReconcilingStrategyExtension) {
        IReconcilingStrategyExtension extension = (IReconcilingStrategyExtension) fStrategy;
        extension.initialReconcile();
    }
}
---------------Client-------------------
method: org.eclipse.equinox.p2.operations.ProvisioningJob$DoubleProgressMonitor.clearBlocked()V1
public void clearBlocked() {
    super.clearBlocked();
    if (additionalMonitor instanceof IProgressMonitorWithBlocking)
        ((IProgressMonitorWithBlocking) additionalMonitor).clearBlocked();
}

---------------Library-------------------
method: org.eclipse.team.core.diff.provider.DiffTree.getProperty(org.eclipse.core.runtime.IPath;I)Z3
public boolean getProperty(IPath path, int property) {
    return pathTree.getProperty(path, property);
}
method: org.eclipse.team.internal.core.mapping.PathTree.getProperty(org.eclipse.core.runtime.IPath;I)Z3
public synchronized boolean getProperty(IPath path, int property) {
    if (path.segmentCount() == 0)
        return false;
    Node node = getNode(path);
    if (node == null)
        return false;
    return (node.hasFlag(property));
}
---------------Client-------------------
method: org.eclipse.swt.widgets.TableItem.getImageIndent()I1
public int getImageIndent() {
    checkWidget();
    if (!parent.checkData(this))
        error(SWT.ERROR_WIDGET_DISPOSED);
    return 0;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.VersionableObject.parse(org.w3c.dom.Node;)V2
protected void parse(Node node) {
    super.parse(node);
    version = getNodeAttribute(node, "version");
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.getNodeAttribute(org.w3c.dom.Node;java.lang.String;)java.lang.String;3
String getNodeAttribute(Node node, String name) {
    Node attribute = node.getAttributes().getNamedItem(name);
    if (attribute != null)
        return attribute.getNodeValue();
    return null;
}
---------------Client-------------------
method: org.eclipse.team.ui.synchronize.AbstractSynchronizeParticipant.init(java.lang.String;org.eclipse.ui.IMemento;)V3
public void init(String secondaryId, IMemento memento) throws PartInitException {
    setSecondaryId(secondaryId);
    pinned = Boolean.valueOf(memento.getString(CTX_PINNED)).booleanValue();
}

---------------Library-------------------
method: org.eclipse.search.internal.core.text.FileCharSequenceProvider$FileCharSequence.close()V1
public void close() throws IOException {
    clearReader();
}
method: org.eclipse.search.internal.core.text.FileCharSequenceProvider$FileCharSequence.clearReader()V1
private void clearReader() throws IOException {
    if (fReader != null) {
        fReader.close();
    }
    fReader = null;
    fReaderPos = Integer.MAX_VALUE;
}
---------------Client-------------------
method: org.eclipse.jetty.server.bio.SocketConnector.close()V1
public void close() throws IOException {
    if (_serverSocket != null)
        _serverSocket.close();
    _serverSocket = null;
    _localPort = -2;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.tooManyFields(org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;)V2
public void tooManyFields(TypeDeclaration typeDeclaration) {
    this.handle(IProblem.TooManyFields, new String[] { new  String(typeDeclaration.binding.readableName()) }, new String[] { new  String(typeDeclaration.binding.shortReadableName()) }, ProblemSeverities.Abort | ProblemSeverities.Error | ProblemSeverities.Fatal, typeDeclaration.sourceStart, typeDeclaration.sourceEnd);
}
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.handle(IAjava.lang.String;Ajava.lang.String;III)V7
private void handle(int problemId, String[] problemArguments, String[] messageArguments, int severity, int problemStartPosition, int problemEndPosition) {
    this.handle(problemId, problemArguments, 0, messageArguments, severity, problemStartPosition, problemEndPosition);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.illegalTypeForExplicitThis(org.eclipse.jdt.internal.compiler.ast.Receiver;org.eclipse.jdt.internal.compiler.lookup.TypeBinding;)V3
public void illegalTypeForExplicitThis(Receiver receiver, TypeBinding expectedType) {
    this.handle(IProblem.IllegalTypeForExplicitThis, new String[] { new  String(expectedType.readableName()) }, new String[] { new  String(expectedType.shortReadableName()) }, receiver.type.sourceStart, receiver.type.sourceEnd);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.JavaEditorColoringConfigurationBlock.dispose()V1
@Override
public void dispose() {
    uninstallSemanticHighlighting();
    fColorManager.dispose();
    super.dispose();
}
method: org.eclipse.jdt.internal.ui.preferences.JavaEditorColoringConfigurationBlock.uninstallSemanticHighlighting()V1
private void uninstallSemanticHighlighting() {
    if (fSemanticHighlightingManager != null) {
        fSemanticHighlightingManager.uninstall();
        fSemanticHighlightingManager = null;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.PropertiesFileEditorPreferencePage.dispose()V1
@Override
public void dispose() {
    if (fOverlayStore != null) {
        fOverlayStore.stop();
        fOverlayStore = null;
    }
    fColorManager.dispose();
    super.dispose();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryManager.addTags(org.eclipse.team.internal.ccvs.core.ICVSResource;Aorg.eclipse.team.internal.ccvs.core.CVSTag;)V3
public void addTags(ICVSResource resource, CVSTag[] tags) throws CVSException {
    RepositoryRoot root = getRepositoryRootFor(resource);
    String remotePath = RepositoryRoot.getRemotePathFor(resource);
    root.addTags(remotePath, tags);
    broadcastRepositoryChange(root);
}
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryManager.getRepositoryRootFor(org.eclipse.team.internal.ccvs.core.ICVSResource;)org.eclipse.team.internal.ccvs.ui.repo.RepositoryRoot;2
private RepositoryRoot getRepositoryRootFor(ICVSResource resource) throws CVSException {
    ICVSRepositoryLocation location = internalGetRepositoryLocationFor(resource);
    if (location == null)
        return null;
    return getRepositoryRootFor(location);
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.wizards.ProjectSelectionPage.createControl(org.eclipse.swt.widgets.Composite;)V2
public void createControl(Composite parent) {
    Composite composite = SWTUtils.createHVFillComposite(parent, SWTUtils.MARGINS_DIALOG, 2);
    createProjectList(composite);
    createShareButton(composite);
    updateEnablements();
    setControl(composite);
}

---------------Library-------------------
method: org.eclipse.debug.ui.memory.AbstractMemoryRendering.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return decorateImage(null);
}
method: org.eclipse.debug.ui.memory.AbstractMemoryRendering.decorateImage(org.eclipse.swt.graphics.Image;)org.eclipse.swt.graphics.Image;2
protected Image decorateImage(Image image) {
    if (fLabelDecorator != null)
        return fLabelDecorator.decorateImage(image, this);
    return image;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryEncodingPropertyPage$OSGIPreferenceStore.getDefaultString(java.lang.String;)java.lang.String;2
public String getDefaultString(String name) {
    if (defaults != null) {
        return defaults.get(name, null);
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.CheckoutWizard$1.createControl(org.eclipse.swt.widgets.Composite;)V2
public void createControl(Composite parent) {
    Composite composite = createComposite(parent, 1, false);
    setControl(composite);
}
method: org.eclipse.team.internal.ccvs.ui.wizards.CVSWizardPage.createComposite(org.eclipse.swt.widgets.Composite;IZ)org.eclipse.swt.widgets.Composite;4
protected Composite createComposite(Composite parent, int numColumns, boolean grabExcess) {
    final Composite composite = new  Composite(parent, SWT.NULL);
    composite.setLayout(new  GridLayout(numColumns, false));
    composite.setLayoutData(new  GridData(SWT.FILL, SWT.FILL, grabExcess, grabExcess));
    return composite;
}
---------------Client-------------------
method: org.eclipse.ui.internal.preferences.WorkingSetPropertyPage$ReadOnlyPage.createControl(org.eclipse.swt.widgets.Composite;)V2
@Override
public void createControl(Composite parent) {
    Composite composite = new  Composite(parent, SWT.NONE);
    composite.setLayoutData(new  GridData(SWT.FILL, SWT.FILL, true, true));
    composite.setLayout(new  GridLayout(1, false));
    setControl(composite);
}

---------------Library-------------------
method: org.eclipse.swt.widgets.TabFolder.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    if (imageList != null)
        imageList.dispose();
    imageList = null;
}
method: org.eclipse.swt.widgets.Composite.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    if (imHandle != 0)
        OS.g_object_unref(imHandle);
    imHandle = 0;
    layout = null;
    tabList = null;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Button.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    if (groupHandle != 0)
        OS.g_object_unref(groupHandle);
    groupHandle = 0;
    if (imageList != null)
        imageList.dispose();
    imageList = null;
    image = null;
    text = null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpModel.getRoot()org.eclipse.pde.core.IWritable;1
protected IWritable getRoot() {
    return getCtxHelpRoot();
}
method: org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpModel.getCtxHelpRoot()org.eclipse.pde.internal.ua.core.ctxhelp.text.CtxHelpRoot;1
public CtxHelpRoot getCtxHelpRoot() {
    if (fRoot == null) {
        fRoot = getFactory().createRoot();
    }
    return fRoot;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntProjectNodeProxy.getLabel()java.lang.String;1
@Override
public String getLabel() {
    if (fProject == null) {
        parseBuildFile();
    }
    fName = super.getLabel();
    return fName;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTImageHelper.storeDefaultImage(org.eclipse.swt.widgets.Button;)V1
public static void storeDefaultImage(Button button) {
    storeDefaultImage(button, DEFAULT_IMAGE, button.getImage());
}
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTImageHelper.storeDefaultImage(org.eclipse.swt.widgets.Widget;java.lang.String;org.eclipse.swt.graphics.Image;)V3
private static void storeDefaultImage(Widget widget, String imageName, Image image) {
    if (widget.getData(imageName) == null) {
        widget.setData(imageName, image);
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTCursorHelper.storeDefaultCursor(org.eclipse.swt.widgets.Control;)V1
public static void storeDefaultCursor(Control control) {
    if (control.getData(DEFAULT_CURSOR) == null) {
        control.setData(DEFAULT_CURSOR, control.getCursor());
    }
}

---------------Library-------------------
method: org.eclipse.jface.resource.JFaceResources.getFontDescriptor(java.lang.String;)org.eclipse.jface.resource.FontDescriptor;1
public static FontDescriptor getFontDescriptor(String symbolicName) {
    return getFontRegistry().getDescriptor(symbolicName);
}
method: org.eclipse.jface.resource.JFaceResources.getFontRegistry()org.eclipse.jface.resource.FontRegistry;0
public static FontRegistry getFontRegistry() {
    if (fontRegistry == null) {
        fontRegistry = new  FontRegistry("org.eclipse.jface.resource.jfacefonts");
    }
    return fontRegistry;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jface.text.link.LinkedModeModel.hasInstalledModel(Aorg.eclipse.jface.text.IDocument;)Z1
public static boolean hasInstalledModel(IDocument[] documents) {
    return LinkedModeManager.hasManager(documents);
}
method: org.eclipse.jface.text.link.LinkedModeManager.hasManager(Aorg.eclipse.jface.text.IDocument;)Z1
public static boolean hasManager(IDocument[] documents) {
    for (int i = 0; i < documents.length; i++) {
        if (hasManager(documents[i]))
            return true;
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.java.LazyGenericTypeProposal.hasAmbiguousProposals(Aorg.eclipse.jdt.internal.ui.text.java.LazyGenericTypeProposal$TypeArgumentProposal;)Z2
private boolean hasAmbiguousProposals(TypeArgumentProposal[] typeArgumentProposals) {
    boolean hasAmbiguousProposals = false;
    for (int i = 0; i < typeArgumentProposals.length; i++) {
        if (typeArgumentProposals[i].isAmbiguous()) {
            hasAmbiguousProposals = true;
            break;
        }
    }
    return hasAmbiguousProposals;
}

---------------Library-------------------
method: org.eclipse.jface.resource.StringConverter.asArray(java.lang.String;Ajava.lang.String;)Ajava.lang.String;2
public static String[] asArray(String value, String[] dflt) {
    try {
        return asArray(value);
    } catch (DataFormatException e) {
        return dflt;
    }
}
method: org.eclipse.jface.resource.StringConverter.asArray(java.lang.String;)Ajava.lang.String;1
public static String[] asArray(String value) throws DataFormatException {
    ArrayList<String> list = new  ArrayList<String>();
    StringTokenizer stok = new  StringTokenizer(value);
    while (stok.hasMoreTokens()) {
        list.add(stok.nextToken());
    }
    String result[] = new String[list.size()];
    list.toArray(result);
    return result;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.frameworkadmin.utils.Utils.getClauses(java.lang.String;)Ajava.lang.String;1
public static String[] getClauses(String header) {
    StringTokenizer token = new  StringTokenizer(header, ",");
    List<String> list = new  LinkedList<String>();
    while (token.hasMoreTokens()) {
        list.add(token.nextToken());
    }
    String[] ret = new String[list.size()];
    list.toArray(ret);
    return ret;
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.EnumDeclaration;)Z2
public boolean visit(org.eclipse.jdt.core.dom.EnumDeclaration node) {
    visitBodyDeclaration(node);
    return true;
}
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visitBodyDeclaration(org.eclipse.jdt.core.dom.BodyDeclaration;)V2
private void visitBodyDeclaration(final BodyDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)Z2
public boolean visit(SingleVariableDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSelectChannelConnector.setPassword(java.lang.String;)V2
@Deprecated
public void setPassword(String password) {
    _sslContextFactory.setKeyStorePassword(password);
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.setKeyStorePassword(java.lang.String;)V2
public void setKeyStorePassword(String password) {
    checkNotStarted();
    _keyStorePassword = Password.getPassword(PASSWORD_PROPERTY, password, null);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.WorkspacePluginModelManager.processModelChanges()V1
@Override
protected void processModelChanges() {
    super.processModelChanges();
    processModelChanges("org.eclipse.pde.internal.core.IExtensionDeltaEvent", fChangedExtensions);
    fChangedExtensions = null;
}

---------------Library-------------------
method: org.eclipse.search2.internal.ui.QueryManager.queryFinished(org.eclipse.search.ui.ISearchQuery;)V2
public void queryFinished(ISearchQuery query) {
    fireFinished(query);
}
method: org.eclipse.search2.internal.ui.QueryManager.fireFinished(org.eclipse.search.ui.ISearchQuery;)V2
public void fireFinished(ISearchQuery query) {
    Set copiedListeners = new  HashSet();
    synchronized (fListeners) {
        copiedListeners.addAll(fListeners);
    }
    Iterator listeners = copiedListeners.iterator();
    while (listeners.hasNext()) {
        IQueryListener l = (IQueryListener) listeners.next();
        l.queryFinished(query);
    }
}
---------------Client-------------------
method: org.eclipse.search.ui.text.AbstractTextSearchResult.fireChange(org.eclipse.search.ui.SearchResultEvent;)V2
protected void fireChange(SearchResultEvent e) {
    HashSet copiedListeners = new  HashSet();
    synchronized (fListeners) {
        copiedListeners.addAll(fListeners);
    }
    Iterator listeners = copiedListeners.iterator();
    while (listeners.hasNext()) {
        ((ISearchResultListener) listeners.next()).searchResultChanged(e);
    }
}

---------------Library-------------------
method: org.eclipse.jface.bindings.BindingManager.isPerfectMatch(org.eclipse.jface.bindings.TriggerSequence;)Z2
public final boolean isPerfectMatch(final TriggerSequence trigger) {
    return getActiveBindings().containsKey(trigger);
}
method: org.eclipse.jface.bindings.BindingManager.getActiveBindings()java.util.Map;1
private final Map getActiveBindings() {
    if (activeBindings == null) {
        recomputeBindings();
    }
    return activeBindings;
}
---------------Client-------------------
method: org.eclipse.help.internal.HelpData.isSortOthers()Z1
public synchronized boolean isSortOthers() {
    if (sortMode == null) {
        loadHelpData();
    }
    return "true".equals(sortMode);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.samples.SampleWizard.dispose()V1
@Override
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.TwoPaneElementSelector.handleEmptyList()V1
@Override
protected void handleEmptyList() {
    super.handleEmptyList();
    fLowerList.setEnabled(false);
}
method: org.eclipse.ui.dialogs.AbstractElementListSelectionDialog.handleEmptyList()V1
protected void handleEmptyList() {
    fMessage.setEnabled(false);
    fFilterText.setEnabled(false);
    fFilteredList.setEnabled(false);
    updateOkState();
}
---------------Client-------------------
method: org.eclipse.debug.ui.WorkingDirectoryBlock.handleUseOtherWorkingDirButtonSelected()V1
private void handleUseOtherWorkingDirButtonSelected() {
    fOtherWorkingText.setEnabled(true);
    fWorkspaceButton.setEnabled(true);
    fVariablesButton.setEnabled(true);
    fFileSystemButton.setEnabled(true);
    updateLaunchConfigurationDialog();
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.ChangeSetModelProvider$1.defaultSetChanged(org.eclipse.team.internal.core.subscribers.ChangeSet;org.eclipse.team.internal.core.subscribers.ChangeSet;)V3
public void defaultSetChanged(final ChangeSet previousDefault, final ChangeSet set) {
    refreshLabel(previousDefault);
    refreshLabel(set);
}
method: org.eclipse.team.internal.ui.synchronize.ChangeSetModelProvider.refreshLabel(org.eclipse.team.internal.core.subscribers.ChangeSet;)V2
public void refreshLabel(ChangeSet set) {
    ISynchronizeModelElement node = getModelElement(set);
    if (node != null) {
        getViewer().refresh(node);
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.application.dialogs.IDEStartupPreferencePage.performDefaults()V1
protected void performDefaults() {
    IPreferenceStore store = getIDEPreferenceStore();
    refreshButton.setSelection(store.getDefaultBoolean(IDEInternalPreferences.REFRESH_WORKSPACE_ON_STARTUP));
    exitPromptButton.setSelection(store.getDefaultBoolean(IDEInternalPreferences.EXIT_PROMPT_ON_CLOSE_LAST_WINDOW));
    super.performDefaults();
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.ChangeSetModelProvider$1.defaultSetChanged(org.eclipse.team.internal.core.subscribers.ChangeSet;org.eclipse.team.internal.core.subscribers.ChangeSet;)V3
public void defaultSetChanged(final ChangeSet previousDefault, final ChangeSet set) {
    refreshLabel(previousDefault);
    refreshLabel(set);
}
method: org.eclipse.team.internal.ui.synchronize.ChangeSetModelProvider.refreshLabel(org.eclipse.team.internal.core.subscribers.ChangeSet;)V2
public void refreshLabel(ChangeSet set) {
    ISynchronizeModelElement node = getModelElement(set);
    if (node != null) {
        getViewer().refresh(node);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.correction.ChooseManifestClassResolution.createChange(org.eclipse.pde.internal.core.text.bundle.BundleModel;)V2
protected void createChange(BundleModel model) {
    IManifestHeader header = model.getBundle().getManifestHeader(fHeader);
    String type = PDEJavaHelperUI.selectType(fResource, IJavaElementSearchConstants.CONSIDER_CLASSES);
    if (type != null)
        header.setValue(type);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.ChangeSetModelProvider$1.defaultSetChanged(org.eclipse.team.internal.core.subscribers.ChangeSet;org.eclipse.team.internal.core.subscribers.ChangeSet;)V3
public void defaultSetChanged(final ChangeSet previousDefault, final ChangeSet set) {
    refreshLabel(previousDefault);
    refreshLabel(set);
}
method: org.eclipse.team.internal.ui.synchronize.ChangeSetModelProvider.refreshLabel(org.eclipse.team.internal.core.subscribers.ChangeSet;)V2
public void refreshLabel(ChangeSet set) {
    ISynchronizeModelElement node = getModelElement(set);
    if (node != null) {
        getViewer().refresh(node);
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.application.dialogs.IDEStartupPreferencePage.performDefaults()V1
protected void performDefaults() {
    IPreferenceStore store = getIDEPreferenceStore();
    refreshButton.setSelection(store.getDefaultBoolean(IDEInternalPreferences.REFRESH_WORKSPACE_ON_STARTUP));
    exitPromptButton.setSelection(store.getDefaultBoolean(IDEInternalPreferences.EXIT_PROMPT_ON_CLOSE_LAST_WINDOW));
    super.performDefaults();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.AbstractPage$11.hasChildren(java.lang.Object;)Z2
@Override
public boolean hasChildren(Object element) {
    if (element instanceof InstalledIUElement)
        return false;
    return super.hasChildren(element);
}
method: org.eclipse.equinox.internal.p2.ui.viewers.ProvElementContentProvider.hasChildren(java.lang.Object;)Z2
public boolean hasChildren(Object element) {
    if (element instanceof ProvElement)
        return ((ProvElement) element).hasChildren(element);
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.filters.EmptyLibraryContainerFilter.select(org.eclipse.jface.viewers.Viewer;java.lang.Object;java.lang.Object;)Z4
@Override
public boolean select(Viewer viewer, Object parentElement, Object element) {
    if (element instanceof PackageFragmentRootContainer && viewer instanceof ProblemTreeViewer) {
        return ((ProblemTreeViewer) viewer).hasFilteredChildren(element);
    }
    return true;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.ExportPackageVisibilitySection.refresh()V1
public void refresh() {
    update(null);
    super.refresh();
}
method: org.eclipse.ui.forms.AbstractFormPart.refresh()V1
public void refresh() {
    stale = false;
    dirty = false;
}
---------------Client-------------------
method: org.eclipse.ui.dialogs.FilteredItemsSelectionDialog$GranualProgressMonitor.setTaskName(java.lang.String;)V2
@Override
public void setTaskName(String name) {
    super.setTaskName(name);
    this.name = name;
    this.subName = null;
}

---------------Library-------------------
method: org.eclipse.osgi.internal.loader.SystemBundleLoader.findClass(java.lang.String;)java.lang.Class;2
public Class<?> findClass(String name) throws ClassNotFoundException {
    Class<?> result = findLocalClass(name);
    if (result == null)
        throw new  ClassNotFoundException(name);
    return result;
}
method: org.eclipse.osgi.internal.loader.SystemBundleLoader.findLocalClass(java.lang.String;)java.lang.Class;2
public Class<?> findLocalClass(String name) {
    try {
        return classLoader.loadClass(name);
    } catch (ClassNotFoundException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.equinox.p2.engine.spi.Memento.get(java.lang.String;)java.lang.Object;2
public Object get(String key) {
    if (key == null)
        throw new  NullPointerException();
    return mementoMap.get(key);
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSocketConnector.setPassword(java.lang.String;)V2
@Deprecated
public void setPassword(String password) {
    _sslContextFactory.setKeyStorePassword(password);
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.setKeyStorePassword(java.lang.String;)V2
public void setKeyStorePassword(String password) {
    checkNotStarted();
    _keyStorePassword = Password.getPassword(PASSWORD_PROPERTY, password, null);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.WorkspacePluginModelManager.processModelChanges()V1
@Override
protected void processModelChanges() {
    super.processModelChanges();
    processModelChanges("org.eclipse.pde.internal.core.IExtensionDeltaEvent", fChangedExtensions);
    fChangedExtensions = null;
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.CompatibilityMarkerFieldFilterGroup.getID()java.lang.String;1
public String getID() {
    return problemFilter.getId();
}
method: org.eclipse.ui.views.markers.internal.ProblemFilter.getId()java.lang.String;1
public String getId() {
    if (contributionDescriptor == null) {
        return null;
    }
    return contributionDescriptor.getLocalId();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.EngineSession.getCurrentOperandId()java.lang.String;1
private String getCurrentOperandId() {
    if (currentRecord == null)
        return EMPTY_STRING;
    return currentRecord.operand.toString();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeArguments()V1
protected void consumeArguments() {
    pushOnIntStack(this.rParenPos);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeElidedLeftBraceAndReturn()V1
protected void consumeElidedLeftBraceAndReturn() {
    int stackLength = this.stateStackLengthStack.length;
    if (++this.valueLambdaNestDepth >= stackLength) {
        System.arraycopy(this.stateStackLengthStack, 0, this.stateStackLengthStack = new int[stackLength + 4], 0, stackLength);
    }
    this.stateStackLengthStack[this.valueLambdaNestDepth] = this.stateStackTop;
}

---------------Library-------------------
method: org.eclipse.ui.internal.themes.WorkbenchThemeManager$WorkbenchThemeChangedHandler.getContext()org.eclipse.e4.core.contexts.IEclipseContext;1
private IEclipseContext getContext() {
    return WorkbenchThemeManager.getInstance().context;
}
method: org.eclipse.ui.internal.themes.WorkbenchThemeManager.getInstance()org.eclipse.ui.internal.themes.WorkbenchThemeManager;0
public static synchronized WorkbenchThemeManager getInstance() {
    if (instance == null) {
        instance = new  WorkbenchThemeManager();
    }
    return instance;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.repository.Credentials.getRemembered()java.util.Map;0
private static synchronized Map<String, HostEntry> getRemembered() {
    if (remembered == null)
        remembered = Collections.synchronizedMap(new  HashMap<String, HostEntry>());
    return remembered;
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
method: org.eclipse.jdt.core.dom.ClassInstanceCreation.getType()org.eclipse.jdt.core.dom.Type;1
public Type getType() {
    unsupportedIn2();
    if (this.type == null) {
        synchronized (this) {
            if (this.type == null) {
                preLazyInit();
                this.type = new  SimpleType(this.ast);
                postLazyInit(this.type, TYPE_PROPERTY);
            }
        }
    }
    return this.type;
}

---------------Library-------------------
method: org.eclipse.emf.common.notify.impl.AdapterFactoryImpl.adaptAllNew(org.eclipse.emf.common.notify.Notifier;)V2
public void adaptAllNew(Notifier target) {
    Adapter adapter = createAdapter(target);
    associate(adapter, target);
}
method: org.eclipse.emf.common.notify.impl.AdapterFactoryImpl.associate(org.eclipse.emf.common.notify.Adapter;org.eclipse.emf.common.notify.Notifier;)V3
protected void associate(Adapter adapter, Notifier target) {
    if (adapter != null) {
        target.eAdapters().add(adapter);
    }
}
---------------Client-------------------
method: org.eclipse.jetty.servlet.ServletMapping.dump(java.lang.Appendable;java.lang.String;)V3
public void dump(Appendable out, String indent) throws IOException {
    out.append(String.valueOf(this)).append("\n");
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
method: org.eclipse.ui.internal.console.ConsoleDropDownAction.dispose()V1
@Override
public void dispose() {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fView = null;
    ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.shared.target.AddFeatureContainersPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.MoveAction.getSelectedMembers(org.eclipse.jface.viewers.IStructuredSelection;)Aorg.eclipse.jdt.core.IMember;1
private static IMember[] getSelectedMembers(IStructuredSelection selection) {
    if (selection.isEmpty())
        return null;
    for (Iterator<?> iter = selection.iterator(); iter.hasNext(); ) {
        if (!(iter.next() instanceof IMember))
            return null;
    }
    return convertToMemberArray(selection.toArray());
}
method: org.eclipse.jdt.ui.actions.MoveAction.convertToMemberArray(Ajava.lang.Object;)Aorg.eclipse.jdt.core.IMember;1
private static IMember[] convertToMemberArray(Object[] obj) {
    if (obj == null)
        return null;
    Set<Object> memberSet = new  HashSet<Object>();
    memberSet.addAll(Arrays.asList(obj));
    return memberSet.toArray(new IMember[memberSet.size()]);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.actions.MoveStaticMembersAction.getSelectedMembers(org.eclipse.jface.viewers.IStructuredSelection;)Aorg.eclipse.jdt.core.IMember;1
private static IMember[] getSelectedMembers(IStructuredSelection selection) {
    if (selection.isEmpty())
        return null;
    for (final Iterator<?> iterator = selection.iterator(); iterator.hasNext(); ) {
        if (!(iterator.next() instanceof IMember))
            return null;
    }
    Set<IMember> memberSet = new  HashSet<IMember>();
    @SuppressWarnings("unchecked") List<IMember> selectionList = (List<IMember>) (List<?>) Arrays.asList(selection.toArray());
    memberSet.addAll(selectionList);
    return memberSet.toArray(new IMember[memberSet.size()]);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.storage.SecurePreferencesWrapper.remove(java.lang.String;)V2
public void remove(String key) {
    node.remove(key);
}
method: org.eclipse.equinox.internal.security.storage.SecurePreferences.remove(java.lang.String;)V2
public synchronized void remove(String key) {
    checkRemoved();
    if (values != null) {
        values.remove(key);
        markModified();
    }
}
---------------Client-------------------
method: org.eclipse.ui.intro.contentproviders.EclipseRSSViewer$2.run()V1
public void run() {
    IIntroURL introUrl = IntroURLFactory.createIntroURL(url);
    if (introUrl != null) {
        introUrl.execute();
        return;
    }
    openBrowser(url);
}

---------------Library-------------------
method: org.eclipse.jetty.util.ajax.JSON.appendJSON(java.lang.StringBuffer;org.eclipse.jetty.util.ajax.JSON$Convertible;)V3
@Deprecated
public void appendJSON(final StringBuffer buffer, Convertible converter) {
    appendJSON((Appendable) buffer, converter);
}
method: org.eclipse.jetty.util.ajax.JSON.appendJSON(java.lang.Appendable;org.eclipse.jetty.util.ajax.JSON$Convertible;)V3
public void appendJSON(final Appendable buffer, Convertible converter) {
    ConvertableOutput out = new  ConvertableOutput(buffer);
    converter.toJSON(out);
    out.complete();
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.AbstractDebugCheckboxSelectionDialog.addViewerListeners(org.eclipse.jface.viewers.StructuredViewer;)V2
@Override
protected void addViewerListeners(StructuredViewer viewer) {
    getCheckBoxTableViewer().addCheckStateListener(new  DefaultCheckboxListener());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.indexing.AbstractIndexer.addDefaultConstructorDeclaration(ACACII)V5
public void addDefaultConstructorDeclaration(char[] typeName, char[] packageName, int typeModifiers, int extraFlags) {
    addIndexEntry(CONSTRUCTOR_DECL, ConstructorPattern.createDefaultDeclarationIndexKey(CharOperation.lastSegment(typeName, '.'), packageName, typeModifiers, extraFlags));
}
method: org.eclipse.jdt.internal.core.search.matching.ConstructorPattern.createDefaultDeclarationIndexKey(ACACII)AC4
public static char[] createDefaultDeclarationIndexKey(char[] typeName, char[] packageName, int typeModifiers, int extraFlags) {
    return createDeclarationIndexKey(typeName, -1, null, null, null, 0, packageName, typeModifiers, extraFlags);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.ManifestErrorReporter.reportUnknownAttribute(org.w3c.dom.Element;java.lang.String;I)V4
protected void reportUnknownAttribute(Element element, String attName, int severity) {
    String message = NLS.bind(PDECoreMessages.Builders_Manifest_attribute, attName);
    report(message, getLine(element, attName), severity, PDEMarkerFactory.P_ILLEGAL_XML_NODE, element, attName, PDEMarkerFactory.CAT_OTHER);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchConfigurationManager.getLastLaunch(java.lang.String;)org.eclipse.debug.core.ILaunchConfiguration;2
public ILaunchConfiguration getLastLaunch(String groupId) {
    LaunchHistory history = getLaunchHistory(groupId);
    if (history != null) {
        return history.getRecentLaunch();
    }
    return null;
}
method: org.eclipse.debug.internal.ui.launchConfigurations.LaunchHistory.getRecentLaunch()org.eclipse.debug.core.ILaunchConfiguration;1
public synchronized ILaunchConfiguration getRecentLaunch() {
    ILaunchConfiguration[] history = getCompleteLaunchHistory();
    if (history.length > 0) {
        return history[0];
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.typehierarchy.TypeHierarchyViewer.containsElements()java.lang.Object;1
public Object containsElements() {
    TypeHierarchyContentProvider contentProvider = getHierarchyContentProvider();
    if (contentProvider != null) {
        Object[] elements = contentProvider.getElements(null);
        if (elements.length > 0) {
            return elements[0];
        }
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.ExpressionFactory.pipe(Aorg.eclipse.equinox.p2.metadata.expression.IExpression;)org.eclipse.equinox.p2.metadata.expression.IExpression;2
public IExpression pipe(IExpression... operands) {
    return Pipe.createPipe(convertArray(operands));
}
method: org.eclipse.equinox.internal.p2.metadata.expression.ExpressionFactory.convertArray(Aorg.eclipse.equinox.p2.metadata.expression.IExpression;)Aorg.eclipse.equinox.internal.p2.metadata.expression.Expression;1
protected static Expression[] convertArray(IExpression[] operands) {
    Expression[] ops = new Expression[operands.length];
    System.arraycopy(operands, 0, ops, 0, operands.length);
    return ops;
}
---------------Client-------------------
method: org.eclipse.ltk.core.refactoring.TextChange.getTextEditChangeGroups()Aorg.eclipse.ltk.core.refactoring.TextEditChangeGroup;1
public TextEditChangeGroup[] getTextEditChangeGroups() {
    final TextEditBasedChangeGroup[] groups = getChangeGroups();
    final TextEditChangeGroup[] result = new TextEditChangeGroup[groups.length];
    System.arraycopy(groups, 0, result, 0, groups.length);
    return result;
}

---------------Library-------------------
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem.displayHelp()V1
@Override
public void displayHelp() {
    AbstractHelpUI helpUI = getHelpUI();
    if (helpUI != null) {
        helpUI.displayHelp();
    }
}
method: org.eclipse.ui.internal.help.WorkbenchHelpSystem.getHelpUI()org.eclipse.ui.help.AbstractHelpUI;1
private AbstractHelpUI getHelpUI() {
    if (!isInitialized) {
        isInitialized = initializePluggableHelpUI();
    }
    return pluggableHelpUI;
}
---------------Client-------------------
method: org.eclipse.ui.dialogs.FilteredItemsSelectionDialog$8.getName(org.eclipse.swt.accessibility.AccessibleEvent;)V2
@Override
public void getName(AccessibleEvent e) {
    if (e.childID == ACC.CHILDID_SELF) {
        e.result = LegacyActionTools.removeMnemonics(listLabel.getText());
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.themes.WorkbenchThemeManager$ThemeRegistryModifiedHandler.getContext()org.eclipse.e4.core.contexts.IEclipseContext;1
private IEclipseContext getContext() {
    return WorkbenchThemeManager.getInstance().context;
}
method: org.eclipse.ui.internal.themes.WorkbenchThemeManager.getInstance()org.eclipse.ui.internal.themes.WorkbenchThemeManager;0
public static synchronized WorkbenchThemeManager getInstance() {
    if (instance == null) {
        instance = new  WorkbenchThemeManager();
    }
    return instance;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.repository.Credentials.getRemembered()java.util.Map;0
private static synchronized Map<String, HostEntry> getRemembered() {
    if (remembered == null)
        remembered = Collections.synchronizedMap(new  HashMap<String, HostEntry>());
    return remembered;
}

---------------Library-------------------
method: org.eclipse.jetty.io.View.clear()V1
@Override
public void clear() {
    setMarkIndex(-1);
    setGetIndex(0);
    setPutIndex(_buffer.getIndex());
    setGetIndex(_buffer.getIndex());
}
method: org.eclipse.jetty.io.AbstractBuffer.setGetIndex(I)V2
public void setGetIndex(int getIndex) {
    _get = getIndex;
    _hash = 0;
}
---------------Client-------------------
method: org.eclipse.ui.forms.FormColors.initialize()V1
protected void initialize() {
    background = display.getSystemColor(SWT.COLOR_LIST_BACKGROUND);
    foreground = display.getSystemColor(SWT.COLOR_LIST_FOREGROUND);
    initializeColorTable();
    updateBorderColor();
}

---------------Library-------------------
method: org.hamcrest.CoreMatchers.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;2
public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second);
}
method: org.hamcrest.core.AnyOf.anyOf(org.hamcrest.Matcher;org.hamcrest.Matcher;)org.hamcrest.core.AnyOf;2
@Factory
public static <T> AnyOf<T> anyOf(Matcher<T> first, Matcher<? super T> second) {
    List<Matcher<? super T>> matchers = new  ArrayList<Matcher<? super T>>();
    matchers.add(first);
    matchers.add(second);
    return anyOf(matchers);
}
---------------Client-------------------
method: org.eclipse.equinox.p2.query.QueryUtil.createPipeQuery(org.eclipse.equinox.p2.query.IQuery;org.eclipse.equinox.p2.query.IQuery;)org.eclipse.equinox.p2.query.IQuery;2
public static <T> IQuery<T> createPipeQuery(IQuery<? extends T> query1, IQuery<? extends T> query2) {
    ArrayList<IQuery<? extends T>> queries = new  ArrayList<IQuery<? extends T>>(2);
    queries.add(query1);
    queries.add(query2);
    return createPipeQuery(queries);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.dialogs.InstallWizard.planChanged()V1
protected void planChanged() {
    super.planChanged();
    synchSelections(getOperationSelectionsPage());
}
method: org.eclipse.equinox.internal.p2.ui.dialogs.InstallWizard.getOperationSelectionsPage()org.eclipse.equinox.internal.p2.ui.dialogs.ISelectableIUsPage;1
protected ISelectableIUsPage getOperationSelectionsPage() {
    IWizardPage page = getContainer().getCurrentPage();
    if (page instanceof ISelectableIUsPage)
        return (ISelectableIUsPage) page;
    return mainPage;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.AbstractDebugListSelectionDialog.okPressed()V1
@Override
protected void okPressed() {
    ISelection selection = fViewer.getSelection();
    if (selection instanceof IStructuredSelection) {
        setResult(((IStructuredSelection) selection).toList());
    }
    super.okPressed();
}

---------------Library-------------------
method: org.eclipse.core.internal.runtime.InternalPlatform.getBooleanOption(java.lang.String;Z)Z3
public boolean getBooleanOption(String option, boolean defaultValue) {
    String value = getOption(option);
    if (value == null)
        return defaultValue;
    return value.equalsIgnoreCase("true");
}
method: org.eclipse.core.internal.runtime.InternalPlatform.getOption(java.lang.String;)java.lang.String;2
public String getOption(String option) {
    DebugOptions options = getDebugOptions();
    if (options != null)
        return options.getOption(option);
    return null;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.plugin.TemplateWizardHelper.getFlag(org.eclipse.pde.internal.ui.wizards.WizardElement;java.lang.String;Z)Z3
public static boolean getFlag(WizardElement element, String name, boolean defaultValue) {
    IConfigurationElement config = element.getConfigurationElement();
    String value = config.getAttribute(name);
    if (value == null)
        return defaultValue;
    return value.equalsIgnoreCase("true");
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.DialogTaskFilter.updateEnabledState(Z)V2
protected void updateEnabledState(boolean enabled) {
    super.updateEnabledState(enabled);
    descriptionGroup.updateEnablement(enabled);
    priorityGroup.updateEnablement(enabled);
    statusGroup.updateEnablement(enabled);
}
method: org.eclipse.ui.views.markers.internal.DialogTaskFilter$DescriptionGroup.updateEnablement(Z)V2
public void updateEnablement(boolean enabled) {
    descriptionLabel.setEnabled(enabled);
    combo.setEnabled(enabled);
    description.setEnabled(enabled);
}
---------------Client-------------------
method: org.eclipse.jdt.ui.actions.JavaSearchActionGroup.setContext(org.eclipse.ui.actions.ActionContext;)V2
@Override
public void setContext(ActionContext context) {
    fReferencesGroup.setContext(context);
    fDeclarationsGroup.setContext(context);
    fImplementorsGroup.setContext(context);
    fReadAccessGroup.setContext(context);
    fWriteAccessGroup.setContext(context);
    fOccurrencesGroup.setContext(context);
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.TableView.buildComparator()org.eclipse.jface.viewers.ViewerComparator;1
protected ViewerComparator buildComparator() {
    return createTableComparator();
}
method: org.eclipse.ui.views.markers.internal.TableView.createTableComparator()org.eclipse.ui.views.markers.internal.TableComparator;1
TableComparator createTableComparator() {
    TableComparator sorter = TableComparator.createTableSorter(getSortingFields());
    sorter.restoreState(getDialogSettings());
    return sorter;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.PDELabelProvider.getSystemBundleInfo()java.lang.String;1
private String getSystemBundleInfo() {
    IPluginBase systemBundle = PluginRegistry.findModel(SYSTEM_BUNDLE).getPluginBase();
    return NLS.bind(" [{0}]", systemBundle.getId());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField$ListViewerAdapter.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    doListSelected(event);
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField.doListSelected(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
protected void doListSelected(SelectionChangedEvent event) {
    updateButtonState();
    if (fListAdapter != null) {
        fListAdapter.selectionChanged(this);
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.filebuffers.FileStoreTextFileBuffer.connected()V1
protected void connected() {
    super.connected();
    if (fAnnotationModel != null)
        fAnnotationModel.connect(fDocument);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.reorg.ReorgPolicyFactory$MovePackagesPolicy.checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor;org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;org.eclipse.jdt.internal.corext.refactoring.reorg.IReorgQueries;)org.eclipse.ltk.core.refactoring.RefactoringStatus;4
@Override
public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context, IReorgQueries reorgQueries) throws CoreException {
    try {
        RefactoringStatus status = super.checkFinalConditions(pm, context, reorgQueries);
        confirmMovingReadOnly(reorgQueries);
        return status;
    } catch (JavaModelException e) {
        throw e;
    } catch (CoreException e) {
        throw new  JavaModelException(e);
    }
}
method: org.eclipse.jdt.internal.corext.refactoring.reorg.ReorgPolicyFactory$PackagesReorgPolicy.checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor;org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;org.eclipse.jdt.internal.corext.refactoring.reorg.IReorgQueries;)org.eclipse.ltk.core.refactoring.RefactoringStatus;4
@Override
public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context, IReorgQueries reorgQueries) throws CoreException {
    confirmOverwriting(reorgQueries);
    RefactoringStatus refactoringStatus = super.checkFinalConditions(pm, context, reorgQueries);
    return refactoringStatus;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.fix.StringCleanUp.createFix(org.eclipse.jdt.core.dom.CompilationUnit;Aorg.eclipse.jdt.ui.text.java.IProblemLocation;)org.eclipse.jdt.ui.cleanup.ICleanUpFix;3
@Override
protected ICleanUpFix createFix(CompilationUnit compilationUnit, IProblemLocation[] problems) throws CoreException {
    if (compilationUnit == null)
        return null;
    return StringFix.createCleanUp(compilationUnit, problems, isEnabled(CleanUpConstants.ADD_MISSING_NLS_TAGS), isEnabled(CleanUpConstants.REMOVE_UNNECESSARY_NLS_TAGS));
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.ActionResolveMarker.getMarkerDescription()java.lang.String;1
private String getMarkerDescription() {
    return Util.getProperty(IMarker.MESSAGE, getSelectedMarker());
}
method: org.eclipse.ui.views.markers.internal.MarkerSelectionProviderAction.getSelectedMarker()org.eclipse.core.resources.IMarker;1
IMarker getSelectedMarker() {
    ConcreteMarker selection = (ConcreteMarker) getStructuredSelection().getFirstElement();
    return selection.getMarker();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ds.ui.editor.sections.DSPropertiesSection.getDSContext()org.eclipse.pde.internal.ds.ui.editor.DSInputContext;1
private DSInputContext getDSContext() {
    InputContextManager manager = getPage().getPDEEditor().getContextManager();
    return (DSInputContext) manager.findContext(DSInputContext.CONTEXT_ID);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.scheduler.migration.MigrationPage$9.hasChildren(java.lang.Object;)Z2
@Override
public boolean hasChildren(Object element) {
    if (element instanceof InstalledIUElement)
        return false;
    return super.hasChildren(element);
}
method: org.eclipse.equinox.internal.p2.ui.viewers.ProvElementContentProvider.hasChildren(java.lang.Object;)Z2
public boolean hasChildren(Object element) {
    if (element instanceof ProvElement)
        return ((ProvElement) element).hasChildren(element);
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.filters.EmptyLibraryContainerFilter.select(org.eclipse.jface.viewers.Viewer;java.lang.Object;java.lang.Object;)Z4
@Override
public boolean select(Viewer viewer, Object parentElement, Object element) {
    if (element instanceof PackageFragmentRootContainer && viewer instanceof ProblemTreeViewer) {
        return ((ProblemTreeViewer) viewer).hasFilteredChildren(element);
    }
    return true;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.ResourceModelContentProvider.getTraversalCalculator()org.eclipse.team.internal.ui.mapping.ResourceModelTraversalCalculator;1
protected ResourceModelTraversalCalculator getTraversalCalculator() {
    return ResourceModelTraversalCalculator.getTraversalCalculator(getConfiguration());
}
method: org.eclipse.team.ui.mapping.SynchronizationContentProvider.getConfiguration()org.eclipse.team.ui.synchronize.ISynchronizePageConfiguration;1
protected ISynchronizePageConfiguration getConfiguration() {
    ICommonContentExtensionSite extensionSite = getExtensionSite();
    if (extensionSite != null)
        return (ISynchronizePageConfiguration) extensionSite.getExtensionStateModel().getProperty(ITeamContentProviderManager.P_SYNCHRONIZATION_PAGE_CONFIGURATION);
    return null;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ds.ui.editor.sections.DSPropertiesSection.getDSContext()org.eclipse.pde.internal.ds.ui.editor.DSInputContext;1
private DSInputContext getDSContext() {
    InputContextManager manager = getPage().getPDEEditor().getContextManager();
    return (DSInputContext) manager.findContext(DSInputContext.CONTEXT_ID);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticArrayConstructor(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticArrayConstructor(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForArrayConstructor(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Diffs$4.getRemovedKeys()java.util.Set;1
public Set getRemovedKeys() {
    return getLazyDiff().getRemovedKeys();
}
method: org.eclipse.core.databinding.observable.Diffs$4.getLazyDiff()org.eclipse.core.databinding.observable.map.MapDiff;1
private MapDiff getLazyDiff() {
    if (lazyDiff == null) {
        lazyDiff = computeMapDiff(oldMap, newMap);
    }
    return lazyDiff;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.Diffs$1.getDifferences()Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;1
public ListDiffEntry[] getDifferences() {
    if (lazyDiff == null) {
        lazyDiff = Diffs.computeListDiff(oldList, newList);
    }
    return lazyDiff.getDifferences();
}

---------------Library-------------------
method: org.eclipse.jdt.debug.ui.launchConfigurations.JavaMainTab.getImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_CLASS);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.internal.menus.ContributionFactoryGenerator$1.run()V1
@Override
public void run() {
    root.release();
}
method: org.eclipse.ui.internal.menus.ContributionRoot.release()V1
public void release() {
    for (Iterator<IContributionItem> itemIter = itemsToExpressions.keySet().iterator(); itemIter.hasNext(); ) {
        IContributionItem item = itemIter.next();
        item.dispose();
    }
    itemsToExpressions.clear();
    topLevelItems.clear();
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.CompositeModelProvider.clearProviders()V1
private void clearProviders() {
    for (Iterator iter = providers.iterator(); iter.hasNext(); ) {
        ISynchronizeModelProvider provider = (ISynchronizeModelProvider) iter.next();
        provider.dispose();
    }
    providers.clear();
    resourceToElements.clear();
    elementToProvider.clear();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.formatter.JavaPreview.getControl()org.eclipse.swt.widgets.Control;1
public Control getControl() {
    return fSourceViewer.getControl();
}
method: org.eclipse.jface.text.source.SourceViewer.getControl()org.eclipse.swt.widgets.Control;1
public Control getControl() {
    if (fComposite != null)
        return fComposite;
    return super.getControl();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMInitializer.getDetailedNode()org.eclipse.jdt.internal.core.jdom.DOMNode;1
protected DOMNode getDetailedNode() {
    return (DOMNode) getFactory().createInitializer(getContents());
}
method: org.eclipse.jdt.core.jdom.DOMFactory.createInitializer(java.lang.String;)org.eclipse.jdt.core.jdom.IDOMInitializer;2
public IDOMInitializer createInitializer(String sourceCode) {
    if (sourceCode == null) {
        return null;
    }
    return (new  DOMBuilder()).createInitializer(sourceCode.toCharArray());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMethod.getRawParameterNames()Ajava.lang.String;1
public String[] getRawParameterNames() throws JavaModelException {
    IBinaryMethod info = (IBinaryMethod) getElementInfo();
    int paramCount = Signature.getParameterCount(new  String(info.getMethodDescriptor()));
    return getRawParameterNames(paramCount);
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.ui.internal.properties.ApiErrorsWarningsPropertyPage.dispose()V1
@Override
public void dispose() {
    block.dispose();
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
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.DefaultHelpUI.resolve(java.lang.String;Z)java.net.URL;3
public URL resolve(String href, boolean documentOnly) {
    return BaseHelpSystem.resolve(href, documentOnly);
}
method: org.eclipse.help.internal.base.BaseHelpSystem.resolve(java.lang.String;Z)java.net.URL;2
public static URL resolve(String href, boolean documentOnly) {
    String url = null;
    if (href == null || href.indexOf("://") != -1 || isFileProtocol(href))
        url = href;
    else {
        BaseHelpSystem.ensureWebappRunning();
        String base = getBase(documentOnly);
        if (href.startsWith("/"))
            url = base + href;
        else
            url = base + "/" + href;
    }
    try {
        return new  URL(url);
    } catch (MalformedURLException e) {
        return null;
    }
}
---------------Client-------------------
method: org.eclipse.help.internal.base.BaseHelpSystem.resolve(java.lang.String;java.lang.String;)java.net.URL;2
public static URL resolve(String href, String servlet) {
    String url = null;
    if (href == null || href.indexOf("://") != -1 || isFileProtocol(href)) {
        url = href;
    } else {
        BaseHelpSystem.ensureWebappRunning();
        String base = getBase(servlet);
        if (href.startsWith("/")) {
            url = base + href;
        } else {
            url = base + "/" + href;
        }
    }
    try {
        return new  URL(url);
    } catch (MalformedURLException e) {
        return null;
    }
}

---------------Library-------------------
method: org.eclipse.pde.launching.JUnitLaunchConfigurationDelegate.manageLaunch(org.eclipse.debug.core.ILaunch;)V2
protected void manageLaunch(ILaunch launch) {
    PDELaunchingPlugin.getDefault().getLaunchListener().manage(launch);
}
method: org.eclipse.pde.internal.launching.launcher.LaunchListener.manage(org.eclipse.debug.core.ILaunch;)V2
public void manage(ILaunch launch) {
    if (managedLaunches.size() == 0)
        hookListener(true);
    if (!managedLaunches.contains(launch))
        managedLaunches.add(launch);
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.ViewPaneRenderingMgr.removeMemoryBlockRendering(org.eclipse.debug.ui.memory.IMemoryRendering;)V2
public void removeMemoryBlockRendering(IMemoryRendering rendering) {
    if (rendering == null) {
        return;
    }
    if (!fRenderings.contains(rendering)) {
        return;
    }
    fRenderings.remove(rendering);
    if (fRenderings.size() == 0) {
        DebugPlugin.getDefault().removeDebugEventListener(this);
    }
    storeRenderings();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.feature.FeatureSpecPage.createContents(org.eclipse.swt.widgets.Composite;)V2
protected void createContents(Composite container) {
    Group group = new  Group(container, SWT.NULL);
    group.setLayout(new  GridLayout(2, false));
    GridData gd = new  GridData(GridData.FILL_HORIZONTAL);
    gd.verticalIndent = 10;
    group.setLayoutData(gd);
    group.setText(PDEUIMessages.BaseFeatureSpecPage_featurePropertiesGroup_title);
    Label label = new  Label(group, SWT.NULL);
    label.setText(PDEUIMessages.NewFeatureWizard_SpecPage_id);
    fFeatureIdText = new  Text(group, SWT.BORDER);
    fFeatureIdText.setLayoutData(new  GridData(GridData.FILL_HORIZONTAL));
    createCommonInput(group);
    label = new  Label(group, SWT.NULL);
    label.setText(PDEUIMessages.NewFeatureWizard_SpecPage_provider);
    fFeatureProviderCombo = new  Combo(group, SWT.BORDER | SWT.DROP_DOWN);
    fFeatureProviderCombo.setLayoutData(new  GridData(GridData.FILL_HORIZONTAL));
    BundleProviderHistoryUtil.loadHistory(fFeatureProviderCombo, getDialogSettings());
    createInstallHandlerText(group);
}
method: org.eclipse.pde.internal.ui.wizards.feature.AbstractFeatureSpecPage.createInstallHandlerText(org.eclipse.swt.widgets.Composite;)V2
protected void createInstallHandlerText(Composite parent) {
    Label libraryLabel = new  Label(parent, SWT.NULL);
    libraryLabel.setText(PDEUIMessages.NewFeatureWizard_SpecPage_library);
    fLibraryText = new  Text(parent, SWT.SINGLE | SWT.BORDER);
    fLibraryText.setLayoutData(new  GridData(GridData.FILL_HORIZONTAL));
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.feature.PatchSpecPage.createTopGroup(org.eclipse.swt.widgets.Composite;)V2
protected void createTopGroup(Composite container) {
    Group patchGroup = new  Group(container, SWT.NULL);
    patchGroup.setLayout(new  GridLayout(2, false));
    GridData gd = new  GridData(GridData.FILL_HORIZONTAL);
    gd.verticalIndent = 10;
    patchGroup.setLayoutData(gd);
    patchGroup.setText(PDEUIMessages.NewFeatureWizard_SpecPage_patchProperties);
    Label label = new  Label(patchGroup, SWT.NULL);
    label.setText(PDEUIMessages.NewFeaturePatch_SpecPage_id);
    fPatchIdText = new  Text(patchGroup, SWT.BORDER);
    fPatchIdText.setLayoutData(new  GridData(GridData.FILL_HORIZONTAL));
    label = new  Label(patchGroup, SWT.NULL);
    label.setText(PDEUIMessages.NewFeaturePatch_SpecPage_name);
    fPatchNameText = new  Text(patchGroup, SWT.BORDER);
    fPatchNameText.setLayoutData(new  GridData(GridData.FILL_HORIZONTAL));
    label = new  Label(patchGroup, SWT.NULL);
    label.setText(PDEUIMessages.NewFeaturePatch_SpecPage_provider);
    fPatchProviderCombo = new  Combo(patchGroup, SWT.BORDER | SWT.DROP_DOWN);
    fPatchProviderCombo.setLayoutData(new  GridData(GridData.FILL_HORIZONTAL));
    BundleProviderHistoryUtil.loadHistory(fPatchProviderCombo, getDialogSettings());
    createInstallHandlerText(patchGroup);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.ui.SecurityStatusControl.getDisplay(org.eclipse.ui.IWorkbenchWindow;)org.eclipse.swt.widgets.Display;1
private static Display getDisplay(IWorkbenchWindow window) {
    if (null != window) {
        Shell shell = window.getShell();
        if (null != shell)
            return shell.getDisplay();
    }
    return null;
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.HelpActivitySupport$ActivityDescriptor.getShowAllMessage()java.lang.String;1
public String getShowAllMessage() {
    if (config == null)
        return null;
    IConfigurationElement child = getChild("showAllMessage");
    if (child != null)
        return child.getValue();
    return null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.PDEPlugin.getDialogSettingsSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
public IDialogSettings getDialogSettingsSection(String name) {
    IDialogSettings dialogSettings = getDialogSettings();
    IDialogSettings section = dialogSettings.getSection(name);
    if (section == null) {
        section = dialogSettings.addNewSection(name);
    }
    return section;
}
method: org.eclipse.jface.dialogs.DialogSettings.addNewSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
@Override
public IDialogSettings addNewSection(String sectionName) {
    DialogSettings section = new  DialogSettings(sectionName);
    addSection(section);
    return section;
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.WidgetElement.getEngine(org.eclipse.swt.widgets.Widget;)org.eclipse.e4.ui.css.core.engine.CSSEngine;1
public static CSSEngine getEngine(Widget widget) {
    return getEngine(widget.getDisplay());
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.help.ui.internal.HelpActivitySupport$ActivityDescriptor.getShowAllMessage()java.lang.String;1
public String getShowAllMessage() {
    if (config == null)
        return null;
    IConfigurationElement child = getChild("showAllMessage");
    if (child != null)
        return child.getValue();
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.ui.text.JavaTextTools.setupJavaDocumentPartitioner(org.eclipse.jface.text.IDocument;)V2
public void setupJavaDocumentPartitioner(IDocument document) {
    setupJavaDocumentPartitioner(document, IDocumentExtension3.DEFAULT_PARTITIONING);
}
method: org.eclipse.jdt.ui.text.JavaTextTools.setupJavaDocumentPartitioner(org.eclipse.jface.text.IDocument;java.lang.String;)V3
public void setupJavaDocumentPartitioner(IDocument document, String partitioning) {
    IDocumentPartitioner partitioner = createDocumentPartitioner();
    if (document instanceof IDocumentExtension3) {
        IDocumentExtension3 extension3 = (IDocumentExtension3) document;
        extension3.setDocumentPartitioner(partitioning, partitioner);
    } else {
        document.setDocumentPartitioner(partitioner);
    }
    partitioner.connect(document);
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.editor.text.AntStorageDocumentProvider.setupDocument(java.lang.Object;org.eclipse.jface.text.IDocument;)V3
@Override
protected void setupDocument(Object element, IDocument document) {
    if (document != null) {
        IDocumentPartitioner partitioner = createDocumentPartitioner();
        if (document instanceof IDocumentExtension3) {
            IDocumentExtension3 extension3 = (IDocumentExtension3) document;
            extension3.setDocumentPartitioner(AntDocumentSetupParticipant.ANT_PARTITIONING, partitioner);
        } else {
            document.setDocumentPartitioner(partitioner);
        }
        partitioner.connect(document);
    }
}

---------------Library-------------------
method: org.apache.lucene.util.NumericUtils.intToPrefixCoded(I)java.lang.String;1
public static String intToPrefixCoded(final int val) {
    return intToPrefixCoded(val, 0);
}
method: org.apache.lucene.util.NumericUtils.intToPrefixCoded(II)java.lang.String;2
public static String intToPrefixCoded(final int val, final int shift) {
    final char[] buffer = new char[BUF_SIZE_INT];
    final int len = intToPrefixCoded(val, shift, buffer);
    return new  String(buffer, 0, len);
}
---------------Client-------------------
method: org.apache.lucene.util.NumericUtils.longToPrefixCoded(JI)java.lang.String;2
public static String longToPrefixCoded(final long val, final int shift) {
    final char[] buffer = new char[BUF_SIZE_LONG];
    final int len = longToPrefixCoded(val, shift, buffer);
    return new  String(buffer, 0, len);
}

---------------Library-------------------
method: org.eclipse.debug.ui.AbstractLaunchConfigurationTab.getUpdateJob()org.eclipse.core.runtime.jobs.Job;1
private Job getUpdateJob() {
    if (fRereshJob == null) {
        fRereshJob = createUpdateJob();
        fRereshJob.setSystem(true);
    }
    return fRereshJob;
}
method: org.eclipse.debug.ui.AbstractLaunchConfigurationTab.createUpdateJob()org.eclipse.core.runtime.jobs.Job;1
protected Job createUpdateJob() {
    return new  WorkbenchJob(getControl().getDisplay(), "Update LCD") {

        @Override
        public IStatus runInUIThread(IProgressMonitor monitor) {
            if (!getControl().isDisposed()) {
                updateLaunchConfigurationDialog();
            }
            return Status.OK_STATUS;
        }

        @Override
        public boolean shouldRun() {
            return !getControl().isDisposed();
        }
    };
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.AnnotationBinding.getKey()java.lang.String;1
public String getKey() {
    if (this.key == null) {
        String recipientKey = getRecipientKey();
        this.key = new  String(this.binding.computeUniqueKey(recipientKey.toCharArray()));
    }
    return this.key;
}

---------------Library-------------------
method: org.eclipse.equinox.p2.engine.ProvisioningContext.getArtifactKeys(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.equinox.p2.query.IQueryable;2
public IQueryable<IArtifactKey> getArtifactKeys(IProgressMonitor monitor) {
    return QueryUtil.compoundQueryable(getLoadedArtifactRepositories(monitor));
}
method: org.eclipse.equinox.p2.query.QueryUtil.compoundQueryable(java.util.Collection;)org.eclipse.equinox.p2.query.IQueryable;1
public static <T> IQueryable<T> compoundQueryable(Collection<? extends IQueryable<T>> queryables) {
    return new  CompoundQueryable<T>(queryables.toArray(new IQueryable[queryables.size()]));
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.util.Changes.getModifiedFiles(Aorg.eclipse.ltk.core.refactoring.Change;)Aorg.eclipse.core.resources.IFile;1
public static IFile[] getModifiedFiles(Change[] changes) {
    List<IFile> result = new  ArrayList<IFile>();
    getModifiedFiles(result, changes);
    return result.toArray(new IFile[result.size()]);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.complete.CompletionParser.consumeEnterAnonymousClassBody(Z)V2
protected void consumeEnterAnonymousClassBody(boolean qualified) {
    popElement(K_SELECTOR_QUALIFIER);
    popElement(K_SELECTOR_INVOCATION_TYPE);
    super.consumeEnterAnonymousClassBody(qualified);
}
method: org.eclipse.jdt.internal.codeassist.impl.AssistParser.consumeEnterAnonymousClassBody(Z)V2
protected void consumeEnterAnonymousClassBody(boolean qualified) {
    super.consumeEnterAnonymousClassBody(qualified);
    popElement(K_SELECTOR);
    pushOnElementStack(K_TYPE_DELIMITER);
}
---------------Client-------------------
method: org.eclipse.core.expressions.ExpressionInfo.merge(org.eclipse.core.expressions.ExpressionInfo;)V2
public void merge(ExpressionInfo other) {
    mergeDefaultVariableAccess(other);
    mergeSystemPropertyAccess(other);
    mergeAccessedVariableNames(other);
    mergeAccessedPropertyNames(other);
    mergeMisbehavingExpressionTypes(other);
}

---------------Library-------------------
method: org.eclipse.ui.views.navigator.CollapseAllAction.run()V1
public void run() {
    getNavigator().getViewer().collapseAll();
}
method: org.eclipse.jface.viewers.AbstractTreeViewer.collapseAll()V1
public void collapseAll() {
    Object root = getRoot();
    if (root != null) {
        collapseToLevel(root, ALL_LEVELS);
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.synchronize.SynchronizeModelManager.saveProviderSettings(java.lang.String;)V2
protected void saveProviderSettings(String id) {
    IDialogSettings pageSettings = getConfiguration().getSite().getPageSettings();
    if (pageSettings != null) {
        pageSettings.put(P_LAST_PROVIDER, id);
    }
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Diffs$2.getAdditions()java.util.Set;1
public Set getAdditions() {
    return getLazyDiff().getAdditions();
}
method: org.eclipse.core.databinding.observable.Diffs$2.getLazyDiff()org.eclipse.core.databinding.observable.set.SetDiff;1
private SetDiff getLazyDiff() {
    if (lazyDiff == null) {
        lazyDiff = computeSetDiff(oldSet, newSet);
    }
    return lazyDiff;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.Diffs$1.getDifferences()Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;1
public ListDiffEntry[] getDifferences() {
    if (lazyDiff == null) {
        lazyDiff = Diffs.computeListDiff(oldList, newList);
    }
    return lazyDiff.getDifferences();
}

---------------Library-------------------
method: org.eclipse.pde.api.tools.internal.comparator.SignatureDescriptor.setClassBound(java.lang.String;)V2
public void setClassBound(String bound) {
    this.currentTypeParameterDescriptor.setClassBound(bound);
}
method: org.eclipse.pde.api.tools.internal.comparator.TypeParameterDescriptor.setClassBound(java.lang.String;)V2
public void setClassBound(String bound) {
    if (JAVA_LANG_OBJECT.equals(bound)) {
        return;
    }
    this.classBound = bound;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.sourcelookup.SourceLookupResult.updateArtifact(java.lang.Object;)V2
public void updateArtifact(Object artifact) {
    if (fArtifact.equals(artifact)) {
        fArtifact = artifact;
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.targetdefinition.ContentPage.dispose()V1
public void dispose() {
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
    super.dispose();
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.equinox.p2.internal.repository.comparator.java.Signature.appendArrayTypeSignature(ACIZLjava.lang.StringBuffer;)I4
private static int appendArrayTypeSignature(char[] string, int start, boolean fullyQualifyTypeNames, StringBuffer buffer) {
    return appendArrayTypeSignature(string, start, fullyQualifyTypeNames, buffer, false);
}
method: org.eclipse.equinox.p2.internal.repository.comparator.java.Signature.appendArrayTypeSignature(ACIZLjava.lang.StringBuffer;Z)I5
private static int appendArrayTypeSignature(char[] string, int start, boolean fullyQualifyTypeNames, StringBuffer buffer, boolean isVarArgs) {
    int length = string.length;
    if (start >= length - 1) {
        throw new  IllegalArgumentException();
    }
    char c = string[start];
    if (c != C_ARRAY) {
        throw new  IllegalArgumentException();
    }
    int index = start;
    c = string[++index];
    while (c == C_ARRAY) {
        if (index >= length - 1) {
            throw new  IllegalArgumentException();
        }
        c = string[++index];
    }
    int e = appendTypeSignature(string, index, fullyQualifyTypeNames, buffer);
    for (int i = 1, dims = index - start; i < dims; i++) {
        buffer.append('[').append(']');
    }
    if (isVarArgs) {
        buffer.append('.').append('.').append('.');
    } else {
        buffer.append('[').append(']');
    }
    return e;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.Util.appendArrayTypeSignatureForAnchor(ACILjava.lang.StringBuffer;Z)I4
private static int appendArrayTypeSignatureForAnchor(char[] string, int start, StringBuffer buffer, boolean isVarArgs) {
    int length = string.length;
    if (start >= length - 1) {
        throw new  IllegalArgumentException();
    }
    char c = string[start];
    if (c != Signature.C_ARRAY) {
        throw new  IllegalArgumentException();
    }
    int index = start;
    c = string[++index];
    while (c == Signature.C_ARRAY) {
        if (index >= length - 1) {
            throw new  IllegalArgumentException();
        }
        c = string[++index];
    }
    int e = appendTypeSignatureForAnchor(string, index, buffer, false);
    for (int i = 1, dims = index - start; i < dims; i++) {
        buffer.append('[').append(']');
    }
    if (isVarArgs) {
        buffer.append('.').append('.').append('.');
    } else {
        buffer.append('[').append(']');
    }
    return e;
}

---------------Library-------------------
method: org.eclipse.ui.internal.texteditor.SWTUtil.setDefaultVisibleItemCount(org.eclipse.swt.widgets.Combo;)V1
public static void setDefaultVisibleItemCount(Combo combo) {
    combo.setVisibleItemCount(COMBO_VISIBLE_ITEM_COUNT);
}
method: org.eclipse.swt.widgets.Combo.setVisibleItemCount(I)V2
public void setVisibleItemCount(int count) {
    checkWidget();
    if (count < 0)
        return;
    visibleCount = count;
}
---------------Client-------------------
method: org.eclipse.swt.custom.PopupList.setMinimumWidth(I)V2
public void setMinimumWidth(int width) {
    if (width < 0)
        SWT.error(SWT.ERROR_INVALID_ARGUMENT);
    minimumWidth = width;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parsePropertyValue(java.io.Reader;)org.w3c.dom.css.CSSValue;2
@Override
public CSSValue parsePropertyValue(Reader reader) throws IOException {
    InputSource source = new  InputSource();
    source.setCharacterStream(reader);
    return parsePropertyValue(source);
}
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parsePropertyValue(org.w3c.css.sac.InputSource;)org.w3c.dom.css.CSSValue;2
@Override
public CSSValue parsePropertyValue(InputSource source) throws IOException {
    checkInputSource(source);
    CSSParser parser = makeCSSParser();
    return parser.parsePropertyValue(source);
}
---------------Client-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyProviderUtil.createProxy(java.lang.String;java.lang.String;I)org.eclipse.core.net.proxy.IProxyData;3
private static IProxyData createProxy(String scheme, String host, int port) {
    String type = resolveProxyType(scheme);
    ProxyData proxy = new  ProxyData(type);
    proxy.setHost(host);
    proxy.setPort(port);
    proxy.setSource("WINDOWS_IE");
    return proxy;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.refresh.win32.Win32Monitor$LinkedResourceHandle.postRefreshRequest()V1
public void postRefreshRequest() {
    postRefreshRequest(resource);
}
method: org.eclipse.core.internal.resources.refresh.win32.Win32Monitor$Handle.postRefreshRequest(org.eclipse.core.resources.IResource;)V2
protected void postRefreshRequest(IResource resource) {
    if (!resource.isSynchronized(IResource.DEPTH_INFINITE))
        refreshResult.refresh(resource);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.refactoring.LaunchConfigRenameChange.alterLaunchConfiguration(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;)V2
@Override
protected void alterLaunchConfiguration(ILaunchConfigurationWorkingCopy copy) throws CoreException {
    if (!fLaunchManager.isExistingLaunchConfigurationName(fNewName))
        copy.rename(fNewName);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.site.NewArchiveDialog.createButtonsForButtonBar(org.eclipse.swt.widgets.Composite;)V2
protected void createButtonsForButtonBar(Composite parent) {
    super.createButtonsForButtonBar(parent);
    dialogChanged();
}
method: org.eclipse.jface.dialogs.StatusDialog.createButtonsForButtonBar(org.eclipse.swt.widgets.Composite;)V2
@Override
protected void createButtonsForButtonBar(Composite parent) {
    fOkButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
}
---------------Client-------------------
method: org.eclipse.ui.internal.dialogs.SelectPerspectiveDialog.createButtonsForButtonBar(org.eclipse.swt.widgets.Composite;)V2
@Override
protected void createButtonsForButtonBar(Composite parent) {
    okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    updateButtons();
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.product.ProductObject.getWritableString(java.lang.String;)java.lang.String;2
public String getWritableString(String source) {
    return PDEXMLHelper.getWritableString(source);
}
method: org.eclipse.pde.internal.core.util.PDEXMLHelper.getWritableString(java.lang.String;)java.lang.String;1
public static String getWritableString(String source) {
    if (source == null)
        return "";
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.getWritableString(java.lang.String;)java.lang.String;2
private String getWritableString(String source) {
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}

---------------Library-------------------
method: org.eclipse.ui.navigator.CommonViewer.removeWithoutRefresh(Ajava.lang.Object;)V2
protected void removeWithoutRefresh(Object[] elements) {
    super.remove(elements);
}
method: org.eclipse.jface.viewers.AbstractTreeViewer.remove(Ajava.lang.Object;)V2
public void remove(final Object[] elementsOrTreePaths) {
    assertElementsNotNull(elementsOrTreePaths);
    if (elementsOrTreePaths.length == 0) {
        return;
    }
    if (checkBusy())
        return;
    preservingSelection(new  Runnable() {

        @Override
        public void run() {
            internalRemove(elementsOrTreePaths);
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.viewers.AbstractTreeViewer.remove(java.lang.Object;Ajava.lang.Object;)V3
public void remove(final Object parent, final Object[] elements) {
    assertElementsNotNull(elements);
    if (elements.length == 0) {
        return;
    }
    if (checkBusy())
        return;
    preservingSelection(new  Runnable() {

        @Override
        public void run() {
            internalRemove(parent, elements);
        }
    });
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.ActionOpenMarker.reportError(java.lang.String;)V2
private void reportError(String message) {
    IStatus status = new  Status(IStatus.ERROR, IDEWorkbenchPlugin.IDE_WORKBENCH, message);
    reportStatus(status);
}
method: org.eclipse.ui.views.markers.internal.ActionOpenMarker.reportStatus(org.eclipse.core.runtime.IStatus;)V2
private void reportStatus(IStatus status) {
    StatusAdapter adapter = new  StatusAdapter(status);
    adapter.setProperty(StatusAdapter.TITLE_PROPERTY, MarkerMessages.OpenMarker_errorTitle);
    StatusManager.getManager().handle(adapter, StatusManager.SHOW);
}
---------------Client-------------------
method: org.eclipse.ui.internal.WorkingSetManager.handleInternalError(java.lang.Exception;java.lang.String;java.lang.String;)V4
private void handleInternalError(Exception exp, String title, String message) {
    Status status = new  Status(IStatus.ERROR, WorkbenchPlugin.PI_WORKBENCH, message, exp);
    StatusAdapter sa = new  StatusAdapter(status);
    sa.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, title);
    StatusManager.getManager().handle(sa, StatusManager.SHOW | StatusManager.LOG);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseStyleDeclaration(java.io.InputStream;)org.w3c.dom.css.CSSStyleDeclaration;2
@Override
public CSSStyleDeclaration parseStyleDeclaration(InputStream stream) throws IOException {
    InputSource source = new  InputSource();
    source.setByteStream(stream);
    return parseStyleDeclaration(source);
}
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseStyleDeclaration(org.w3c.css.sac.InputSource;)org.w3c.dom.css.CSSStyleDeclaration;2
@Override
public CSSStyleDeclaration parseStyleDeclaration(InputSource source) throws IOException {
    checkInputSource(source);
    CSSParser parser = makeCSSParser();
    CSSStyleDeclaration styleDeclaration = parser.parseStyleDeclaration(source);
    return styleDeclaration;
}
---------------Client-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyProviderUtil.createProxy(java.lang.String;java.lang.String;I)org.eclipse.core.net.proxy.IProxyData;3
private static IProxyData createProxy(String scheme, String host, int port) {
    String type = resolveProxyType(scheme);
    ProxyData proxy = new  ProxyData(type);
    proxy.setHost(host);
    proxy.setPort(port);
    proxy.setSource("WINDOWS_IE");
    return proxy;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.deprecatedField(org.eclipse.jdt.internal.compiler.lookup.FieldBinding;org.eclipse.jdt.internal.compiler.ast.ASTNode;)V3
public void deprecatedField(FieldBinding field, ASTNode location) {
    int severity = computeSeverity(IProblem.UsingDeprecatedField);
    if (severity == ProblemSeverities.Ignore)
        return;
    this.handle(IProblem.UsingDeprecatedField, new String[] { new  String(field.declaringClass.readableName()), new  String(field.name) }, new String[] { new  String(field.declaringClass.shortReadableName()), new  String(field.name) }, severity, nodeSourceStart(field, location), nodeSourceEnd(field, location));
}
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.handle(IAjava.lang.String;Ajava.lang.String;III)V7
private void handle(int problemId, String[] problemArguments, String[] messageArguments, int severity, int problemStartPosition, int problemEndPosition) {
    this.handle(problemId, problemArguments, 0, messageArguments, severity, problemStartPosition, problemEndPosition);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.indirectAccessToStaticField(org.eclipse.jdt.internal.compiler.ast.ASTNode;org.eclipse.jdt.internal.compiler.lookup.FieldBinding;)V3
public void indirectAccessToStaticField(ASTNode location, FieldBinding field) {
    int severity = computeSeverity(IProblem.IndirectAccessToStaticField);
    if (severity == ProblemSeverities.Ignore)
        return;
    this.handle(IProblem.IndirectAccessToStaticField, new String[] { new  String(field.declaringClass.readableName()), new  String(field.name) }, new String[] { new  String(field.declaringClass.shortReadableName()), new  String(field.name) }, severity, nodeSourceStart(field, location), nodeSourceEnd(field, location));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.UserLibraryPreferencePage$UserLibraryAdapter.doubleClicked(org.eclipse.jdt.internal.ui.wizards.dialogfields.TreeListDialogField;)V2
public void doubleClicked(TreeListDialogField<CPUserLibraryElement> field) {
    doDoubleClicked(field);
}
method: org.eclipse.jdt.internal.ui.preferences.UserLibraryPreferencePage.doDoubleClicked(org.eclipse.jdt.internal.ui.wizards.dialogfields.TreeListDialogField;)V2
protected void doDoubleClicked(TreeListDialogField<CPUserLibraryElement> field) {
    List<Object> selected = field.getSelectedElements();
    if (canEdit(selected)) {
        doEdit(field.getSelectedElements());
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.cheatsheets.views.ViewItem.setAsNormalCollapsed()V1
void setAsNormalCollapsed() {
    setBold(false);
    setColorAsCurrent(false);
    if (mainItemComposite.isExpanded())
        setCollapsed();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyExpression()V1
protected void consumeEmptyExpression() {
    pushOnExpressionStackLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnExpressionStackLengthStack(I)V2
protected void pushOnExpressionStackLengthStack(int pos) {
    int stackLength = this.expressionLengthStack.length;
    if (++this.expressionLengthPtr >= stackLength) {
        System.arraycopy(this.expressionLengthStack, 0, this.expressionLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.expressionLengthStack[this.expressionLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findFilesForLocationURI(java.net.URI;)Aorg.eclipse.core.resources.IFile;2
public IFile[] findFilesForLocationURI(URI location) {
    return findFilesForLocationURI(location, NONE);
}
method: org.eclipse.core.internal.resources.WorkspaceRoot.findFilesForLocationURI(java.net.URI;I)Aorg.eclipse.core.resources.IFile;3
public IFile[] findFilesForLocationURI(URI location, int memberFlags) {
    if (!location.isAbsolute())
        throw new  IllegalArgumentException();
    return (IFile[]) getLocalManager().allResourcesFor(location, true, memberFlags);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkspaceRoot.findContainersForLocationURI(java.net.URI;I)Aorg.eclipse.core.resources.IContainer;3
public IContainer[] findContainersForLocationURI(URI location, int memberFlags) {
    if (!location.isAbsolute())
        throw new  IllegalArgumentException();
    return (IContainer[]) getLocalManager().allResourcesFor(location, false, memberFlags);
}

---------------Library-------------------
method: org.eclipse.ui.forms.DetailsPart.commit(Z)V2
public void commit(boolean onSave) {
    IDetailsPage page = getCurrentPage();
    if (page != null)
        page.commit(onSave);
}
method: org.eclipse.ui.forms.DetailsPart.getCurrentPage()org.eclipse.ui.forms.IDetailsPage;1
public IDetailsPage getCurrentPage() {
    Control control = pageBook.getCurrentPage();
    if (control != null) {
        Object data = control.getData();
        if (data instanceof IDetailsPage)
            return (IDetailsPage) data;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.e4.ui.internal.workbench.renderers.swt.BasicPartList.gotoSelectedElement()V1
@Override
protected void gotoSelectedElement() {
    Object selectedElement = getSelectedElement();
    dispose();
    if (selectedElement instanceof MPart) {
        partService.activate((MPart) selectedElement);
    }
}

---------------Library-------------------
method: org.eclipse.ui.views.tasklist.TaskList.markersChanged()V1
void markersChanged() {
    updateStatusMessage();
    updateTitle();
}
method: org.eclipse.ui.views.tasklist.TaskList.updateTitle()V1
void updateTitle() {
    TaskListContentProvider provider = (TaskListContentProvider) getTableViewer().getContentProvider();
    String summary = provider.getTitleSummary();
    setContentDescription(summary);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.schema.SchemaFormPage.handleModelEventWorldChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
private void handleModelEventWorldChanged(IModelChangedEvent event) {
    ISchema schema = (ISchema) getModel();
    getManagedForm().getForm().setText(schema.getName());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ds.core.text.DSModel.getRoot()org.eclipse.pde.core.IWritable;1
protected IWritable getRoot() {
    return (IWritable) getDSComponent();
}
method: org.eclipse.pde.internal.ds.core.text.DSModel.getDSComponent()org.eclipse.pde.internal.ds.core.IDSComponent;1
public IDSComponent getDSComponent() {
    if (fComponent == null) {
        fComponent = getFactory().createComponent();
    }
    return fComponent;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.model.AntProjectNodeProxy.getLabel()java.lang.String;1
@Override
public String getLabel() {
    if (fProject == null) {
        parseBuildFile();
    }
    fName = super.getLabel();
    return fName;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.Diffs.createListDiff(org.eclipse.core.databinding.observable.list.ListDiffEntry;org.eclipse.core.databinding.observable.list.ListDiffEntry;)org.eclipse.core.databinding.observable.list.ListDiff;2
public static ListDiff createListDiff(ListDiffEntry difference1, ListDiffEntry difference2) {
    return createListDiff(new ListDiffEntry[] { difference1, difference2 });
}
method: org.eclipse.core.databinding.observable.Diffs.createListDiff(Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;)org.eclipse.core.databinding.observable.list.ListDiff;1
public static ListDiff createListDiff(final ListDiffEntry[] differences) {
    return new  ListDiff() {

        public ListDiffEntry[] getDifferences() {
            return differences;
        }
    };
}
---------------Client-------------------
method: org.eclipse.equinox.p2.query.QueryUtil.compoundQueryable(org.eclipse.equinox.p2.query.IQueryable;org.eclipse.equinox.p2.query.IQueryable;)org.eclipse.equinox.p2.query.IQueryable;2
@SuppressWarnings("unchecked")
public static <T> IQueryable<T> compoundQueryable(IQueryable<T> query1, IQueryable<T> query2) {
    return new  CompoundQueryable<T>(new IQueryable[] { query1, query2 });
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.getTypeMatches(java.lang.String;java.util.List;)V2
private static void getTypeMatches(final String typeName, final List<Object> matches) throws InterruptedException {
    executeRunnable(new  IRunnableWithProgress() {

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            doTypeSearch(typeName, matches, monitor);
        }
    });
}
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.executeRunnable(org.eclipse.jface.operation.IRunnableWithProgress;)V1
private static void executeRunnable(IRunnableWithProgress runnableWithProgress) throws InterruptedException {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnableWithProgress);
    } catch (InvocationTargetException e) {
        JDIDebugUIPlugin.log(e);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart.importTestRunSession(java.lang.String;)V1
static void importTestRunSession(final String url) {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new  IRunnableWithProgress() {

            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                JUnitModel.importTestRunSession(url, monitor);
            }
        });
    } catch (InterruptedException e) {
    } catch (InvocationTargetException e) {
        CoreException ce = (CoreException) e.getCause();
        StatusManager.getManager().handle(ce.getStatus(), StatusManager.SHOW | StatusManager.LOG);
    }
}

---------------Library-------------------
method: org.eclipse.jface.internal.databinding.swt.ToolItemEnabledProperty.doGetBooleanValue(java.lang.Object;)Z2
public boolean doGetBooleanValue(Object source) {
    return ((ToolItem) source).getEnabled();
}
method: org.eclipse.swt.widgets.ToolItem.getEnabled()Z1
public boolean getEnabled() {
    checkWidget();
    long topHandle = topHandle();
    return gtk_widget_get_sensitive(topHandle);
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.CommonViewerAdvisor.isOpenable(org.eclipse.jface.viewers.ISelection;)Z2
private boolean isOpenable(ISelection selection) {
    IStructuredSelection ss = (IStructuredSelection) selection;
    Object object = ss.getFirstElement();
    if (object == null)
        return false;
    return getParticipant().hasCompareInputFor(object);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameCuWizard.validateNewName(java.lang.String;)org.eclipse.ltk.core.refactoring.RefactoringStatus;2
@Override
protected RefactoringStatus validateNewName(String newName) {
    String fullName = JavaModelUtil.getRenamedCUName(getCompilationUnit(), newName);
    return super.validateNewName(fullName);
}
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameRefactoringWizard.validateNewName(java.lang.String;)org.eclipse.ltk.core.refactoring.RefactoringStatus;2
protected RefactoringStatus validateNewName(String newName) {
    INameUpdating ref = getNameUpdating();
    ref.setNewElementName(newName);
    try {
        return ref.checkNewElementName(newName);
    } catch (CoreException e) {
        JavaPlugin.log(e);
        return RefactoringStatus.createFatalErrorStatus(RefactoringMessages.RenameRefactoringWizard_internal_error);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.PDEFormPage.createUISectionContainer(org.eclipse.swt.widgets.Composite;I)org.eclipse.swt.widgets.Composite;3
public Composite createUISectionContainer(Composite parent, int columns) {
    Composite container = getManagedForm().getToolkit().createComposite(parent);
    container.setLayout(FormLayoutFactory.createSectionClientGridLayout(false, columns));
    return container;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.reorg.ReorgPolicyFactory$MovePackageFragmentRootsPolicy.checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor;org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;org.eclipse.jdt.internal.corext.refactoring.reorg.IReorgQueries;)org.eclipse.ltk.core.refactoring.RefactoringStatus;4
@Override
public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context, IReorgQueries reorgQueries) throws CoreException {
    try {
        RefactoringStatus status = super.checkFinalConditions(pm, context, reorgQueries);
        confirmMovingReadOnly(reorgQueries);
        return status;
    } catch (JavaModelException e) {
        throw e;
    } catch (CoreException e) {
        throw new  JavaModelException(e);
    }
}
method: org.eclipse.jdt.internal.corext.refactoring.reorg.ReorgPolicyFactory$PackageFragmentRootsReorgPolicy.checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor;org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;org.eclipse.jdt.internal.corext.refactoring.reorg.IReorgQueries;)org.eclipse.ltk.core.refactoring.RefactoringStatus;4
@Override
public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context, IReorgQueries reorgQueries) throws CoreException {
    confirmOverwriting(reorgQueries);
    RefactoringStatus status = super.checkFinalConditions(pm, context, reorgQueries);
    return status;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.fix.StringCleanUp.createFix(org.eclipse.jdt.core.dom.CompilationUnit;Aorg.eclipse.jdt.ui.text.java.IProblemLocation;)org.eclipse.jdt.ui.cleanup.ICleanUpFix;3
@Override
protected ICleanUpFix createFix(CompilationUnit compilationUnit, IProblemLocation[] problems) throws CoreException {
    if (compilationUnit == null)
        return null;
    return StringFix.createCleanUp(compilationUnit, problems, isEnabled(CleanUpConstants.ADD_MISSING_NLS_TAGS), isEnabled(CleanUpConstants.REMOVE_UNNECESSARY_NLS_TAGS));
}

---------------Library-------------------
method: org.apache.lucene.analysis.compound.HyphenationCompoundWordTokenFilter.getHyphenationTree(java.io.File;)org.apache.lucene.analysis.compound.hyphenation.HyphenationTree;1
public static HyphenationTree getHyphenationTree(File hyphenationFile) throws Exception {
    return getHyphenationTree(new  InputSource(hyphenationFile.toURL().toExternalForm()));
}
method: org.apache.lucene.analysis.compound.HyphenationCompoundWordTokenFilter.getHyphenationTree(org.xml.sax.InputSource;)org.apache.lucene.analysis.compound.hyphenation.HyphenationTree;1
public static HyphenationTree getHyphenationTree(InputSource hyphenationSource) throws Exception {
    HyphenationTree tree = new  HyphenationTree();
    tree.loadPatterns(hyphenationSource);
    return tree;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField.createTableViewer(org.eclipse.swt.widgets.Composite;)org.eclipse.jface.viewers.TableViewer;2
protected TableViewer createTableViewer(Composite parent) {
    Table table = new  Table(parent, getListStyle());
    table.setFont(parent.getFont());
    return new  TableViewer(table);
}

---------------Library-------------------
method: org.eclipse.jface.text.source.DefaultAnnotationHover.getAnnotationModel(org.eclipse.jface.text.source.ISourceViewer;)org.eclipse.jface.text.source.IAnnotationModel;2
private IAnnotationModel getAnnotationModel(ISourceViewer viewer) {
    if (viewer instanceof ISourceViewerExtension2) {
        ISourceViewerExtension2 extension = (ISourceViewerExtension2) viewer;
        return extension.getVisualAnnotationModel();
    }
    return viewer.getAnnotationModel();
}
method: org.eclipse.jface.text.source.SourceViewer.getAnnotationModel()org.eclipse.jface.text.source.IAnnotationModel;1
public IAnnotationModel getAnnotationModel() {
    if (fVisualAnnotationModel instanceof IAnnotationModelExtension) {
        IAnnotationModelExtension extension = (IAnnotationModelExtension) fVisualAnnotationModel;
        return extension.getAnnotationModel(MODEL_ANNOTATION_MODEL);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.views.memory.SwitchMemoryBlockAction.getViewer()org.eclipse.jface.viewers.StructuredViewer;1
private StructuredViewer getViewer() {
    if (fView instanceof MemoryView) {
        MemoryView memView = (MemoryView) fView;
        IMemoryViewPane pane = memView.getViewPane(MemoryBlocksTreeViewPane.PANE_ID);
        if (pane instanceof MemoryBlocksTreeViewPane) {
            StructuredViewer viewer = ((MemoryBlocksTreeViewPane) pane).getViewer();
            return viewer;
        }
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.resources.actions.EditActionProvider.dispose()V1
@Override
public void dispose() {
    editGroup.dispose();
}
method: org.eclipse.ui.internal.navigator.resources.actions.EditActionGroup.dispose()V1
@Override
public void dispose() {
    if (clipboard != null) {
        clipboard.dispose();
        clipboard = null;
    }
    super.dispose();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.codeSnippetMissingClass(java.lang.String;II)V4
public void codeSnippetMissingClass(String missing, int start, int end) {
    String[] arguments = new String[] { missing };
    this.handle(IProblem.CodeSnippetMissingClass, arguments, arguments, ProblemSeverities.Error | ProblemSeverities.Abort | ProblemSeverities.Fatal, start, end);
}
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.handle(IAjava.lang.String;Ajava.lang.String;III)V7
private void handle(int problemId, String[] problemArguments, String[] messageArguments, int severity, int problemStartPosition, int problemEndPosition) {
    this.handle(problemId, problemArguments, 0, messageArguments, severity, problemStartPosition, problemEndPosition);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.parseErrorInsertToCompletePhrase(IILjava.lang.String;)V4
public void parseErrorInsertToCompletePhrase(int start, int end, String inserted) {
    String[] arguments = new String[] { inserted };
    this.handle(IProblem.ParsingErrorInsertToCompletePhrase, arguments, arguments, start, end);
}

---------------Library-------------------
method: org.eclipse.osgi.internal.module.GenericConstraint.getNameSpace()java.lang.String;1
public String getNameSpace() {
    return ((GenericSpecification) getVersionConstraint()).getType();
}
method: org.eclipse.osgi.internal.resolver.GenericSpecificationImpl.getType()java.lang.String;1
public String getType() {
    synchronized (this.monitor) {
        return type;
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.CharsetDeltaJob.removeFromQueue()org.eclipse.core.internal.resources.CharsetDeltaJob$ICharsetListenerFilter;1
private ICharsetListenerFilter removeFromQueue() {
    synchronized (work) {
        return work.remove();
    }
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.MarkerFilter.getMarkerType(java.lang.String;)org.eclipse.ui.views.markers.internal.MarkerType;2
public MarkerType getMarkerType(String id) {
    return MarkerTypesModel.getInstance().getType(id);
}
method: org.eclipse.ui.views.markers.internal.MarkerTypesModel.getInstance()org.eclipse.ui.views.markers.internal.MarkerTypesModel;0
public static MarkerTypesModel getInstance() {
    if (instance == null) {
        instance = new  MarkerTypesModel();
    }
    return instance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.ds.impl.ComponentContextImpl.enableComponent(java.lang.String;)V2
public void enableComponent(String name) {
    mgr.enableComponent(name, scp.bc.getBundle());
}
method: org.eclipse.osgi.internal.framework.BundleContextImpl.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    checkValid();
    return getBundleImpl();
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.WorkManager.startup(org.eclipse.core.runtime.IProgressMonitor;)V2
public void startup(IProgressMonitor monitor) {
    jobManager.beginRule(workspace.getRoot(), monitor);
    lock.acquire();
}

---------------Library-------------------
method: org.eclipse.equinox.console.common.ConsoleInputScanner.printPrompt()V1
protected void printPrompt() throws IOException {
    echo('o');
    echo('s');
    echo('g');
    echo('i');
    echo('>');
    echo(SPACE);
    echoBuff();
    flush();
}
method: org.eclipse.equinox.console.common.Scanner.echo(I)V2
protected void echo(int b) throws IOException {
    if (isEchoEnabled) {
        toTelnet.write(b);
    }
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer$TextOperationAction.run()V1
public void run() {
    if (isEnabled())
        getSourceViewer().doOperation(fOperationCode);
}

---------------Library-------------------
method: org.eclipse.ui.internal.util.Util.safeCopy(java.util.Map;java.lang.Class;java.lang.Class;)java.util.Map;3
public static Map safeCopy(Map map, Class keyClass, Class valueClass) {
    return safeCopy(map, keyClass, valueClass, false, false);
}
method: org.eclipse.ui.internal.util.Util.safeCopy(java.util.Map;java.lang.Class;java.lang.Class;ZZ)java.util.Map;5
public static Map safeCopy(Map map, Class keyClass, Class valueClass, boolean allowNullKeys, boolean allowNullValues) {
    if (map == null || keyClass == null || valueClass == null) {
        throw new  NullPointerException();
    }
    map = Collections.unmodifiableMap(new  HashMap(map));
    Iterator iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry) iterator.next();
        assertInstance(entry.getKey(), keyClass, allowNullKeys);
        assertInstance(entry.getValue(), valueClass, allowNullValues);
    }
    return map;
}
---------------Client-------------------
method: org.eclipse.core.internal.commands.util.Util.safeCopy(java.util.Map;java.lang.Class;java.lang.Class;ZZ)java.util.Map;5
public static final Map safeCopy(final Map map, final Class keyClass, final Class valueClass, final boolean allowNullKeys, final boolean allowNullValues) {
    if (map == null || keyClass == null || valueClass == null) {
        throw new  NullPointerException();
    }
    final Map copy = Collections.unmodifiableMap(new  HashMap(map));
    final Iterator iterator = copy.entrySet().iterator();
    while (iterator.hasNext()) {
        final Map.Entry entry = (Map.Entry) iterator.next();
        assertInstance(entry.getKey(), keyClass, allowNullKeys);
        assertInstance(entry.getValue(), valueClass, allowNullValues);
    }
    return map;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parsePropertyValue(java.io.InputStream;)org.w3c.dom.css.CSSValue;2
@Override
public CSSValue parsePropertyValue(InputStream stream) throws IOException {
    InputSource source = new  InputSource();
    source.setByteStream(stream);
    return parsePropertyValue(source);
}
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parsePropertyValue(org.w3c.css.sac.InputSource;)org.w3c.dom.css.CSSValue;2
@Override
public CSSValue parsePropertyValue(InputSource source) throws IOException {
    checkInputSource(source);
    CSSParser parser = makeCSSParser();
    return parser.parsePropertyValue(source);
}
---------------Client-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyProviderUtil.createProxy(java.lang.String;java.lang.String;I)org.eclipse.core.net.proxy.IProxyData;3
private static IProxyData createProxy(String scheme, String host, int port) {
    String type = resolveProxyType(scheme);
    ProxyData proxy = new  ProxyData(type);
    proxy.setHost(host);
    proxy.setPort(port);
    proxy.setSource("WINDOWS_IE");
    return proxy;
}

---------------Library-------------------
method: org.eclipse.debug.internal.core.ResourceFactory.saveState(org.eclipse.debug.internal.core.XMLMemento;org.eclipse.core.resources.IResource;)V2
public static void saveState(XMLMemento memento, IResource res) {
    memento.putString(TAG_PATH, res.getFullPath().toString());
    memento.putString(TAG_TYPE, Integer.toString(res.getType()));
}
method: org.eclipse.debug.internal.core.XMLMemento.putString(java.lang.String;java.lang.String;)V3
public void putString(String key, String value) {
    if (value == null) {
        return;
    }
    element.setAttribute(key, value);
}
---------------Client-------------------
method: org.eclipse.ui.internal.ide.model.ResourceFactory.saveState(org.eclipse.ui.IMemento;)V2
public void saveState(IMemento memento) {
    memento.putString(TAG_PATH, res.getFullPath().toString());
    memento.putString(TAG_TYPE, Integer.toString(res.getType()));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.JarPackageActionDelegate.getShell()org.eclipse.swt.widgets.Shell;1
protected Shell getShell() {
    if (fShell != null)
        return fShell;
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.compare.internal.CompareEditorSelectionProvider.getSelection()org.eclipse.jface.viewers.ISelection;1
public ISelection getSelection() {
    if (fViewerInFocus != null) {
        return fViewerInFocus.getSelection();
    }
    return TextSelection.emptySelection();
}

---------------Library-------------------
method: org.eclipse.ui.forms.DetailsPart.setFocus()V1
public void setFocus() {
    IDetailsPage page = getCurrentPage();
    if (page != null)
        page.setFocus();
}
method: org.eclipse.ui.forms.DetailsPart.getCurrentPage()org.eclipse.ui.forms.IDetailsPage;1
public IDetailsPage getCurrentPage() {
    Control control = pageBook.getCurrentPage();
    if (control != null) {
        Object data = control.getData();
        if (data instanceof IDetailsPage)
            return (IDetailsPage) data;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.text.SmartBackspaceManager$BackspaceListener.beginChange()V1
private void beginChange() {
    ITextViewer viewer = fViewer;
    if (viewer instanceof TextViewer) {
        TextViewer v = (TextViewer) viewer;
        v.getRewriteTarget().beginCompoundChange();
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.dialogs.EditorsPreferencePage.createSpace(org.eclipse.swt.widgets.Composite;)V2
protected void createSpace(Composite parent) {
    WorkbenchPreferencePage.createSpace(parent);
}
method: org.eclipse.ui.internal.dialogs.WorkbenchPreferencePage.createSpace(org.eclipse.swt.widgets.Composite;)V1
protected static void createSpace(Composite parent) {
    Label vfiller = new  Label(parent, SWT.LEFT);
    GridData gridData = new  GridData();
    gridData = new  GridData();
    gridData.horizontalAlignment = GridData.BEGINNING;
    gridData.grabExcessHorizontalSpace = false;
    gridData.verticalAlignment = GridData.CENTER;
    gridData.grabExcessVerticalSpace = false;
    vfiller.setLayoutData(gridData);
}
---------------Client-------------------
method: org.eclipse.jdt.junit.wizards.NewTestCaseWizardPageTwo.createSpacer(org.eclipse.swt.widgets.Composite;)V2
private void createSpacer(Composite container) {
    Label spacer = new  Label(container, SWT.NONE);
    GridData data = new  GridData();
    data.horizontalSpan = 2;
    data.horizontalAlignment = GridData.FILL;
    data.verticalAlignment = GridData.BEGINNING;
    data.heightHint = 4;
    spacer.setLayoutData(data);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyBlockStatementsopt()V1
protected void consumeEmptyBlockStatementsopt() {
    pushOnAstLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.ui.part.MultiPageEditorPart.getItem(I)org.eclipse.swt.custom.CTabItem;2
private CTabItem getItem(int pageIndex) {
    return getTabFolder().getItem(pageIndex);
}
method: org.eclipse.swt.custom.CTabFolder.getItem(I)org.eclipse.swt.custom.CTabItem;2
public CTabItem getItem(int index) {
    if (index < 0 || index >= items.length)
        SWT.error(SWT.ERROR_INVALID_RANGE);
    return items[index];
}
---------------Client-------------------
method: org.eclipse.swt.custom.TableTree.getItem(I)org.eclipse.swt.custom.TableTreeItem;2
public TableTreeItem getItem(int index) {
    checkWidget();
    int count = items.length;
    if (!(0 <= index && index < count))
        SWT.error(SWT.ERROR_INVALID_RANGE);
    return items[index];
}

---------------Library-------------------
method: org.eclipse.equinox.p2.internal.repository.comparator.java.CharOperation.indexOf(CAC)I2
public static final int indexOf(char toBeFound, char[] array) {
    return indexOf(toBeFound, array, 0);
}
method: org.eclipse.equinox.p2.internal.repository.comparator.java.CharOperation.indexOf(CACI)I3
public static final int indexOf(char toBeFound, char[] array, int start) {
    for (int i = start; i < array.length; i++) if (toBeFound == array[i])
        return i;
    return -1;
}
---------------Client-------------------
method: org.eclipse.jface.internal.text.link.contentassist.ContentAssistant2$AutoAssistListener.contains(ACC)Z3
private boolean contains(char[] characters, char character) {
    if (characters != null) {
        for (int i = 0; i < characters.length; i++) {
            if (character == characters[i])
                return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.SWTFactory.createRadioButton(org.eclipse.swt.widgets.Composite;java.lang.String;)org.eclipse.swt.widgets.Button;2
public static Button createRadioButton(Composite parent, String label) {
    return createRadioButton(parent, label, 1);
}
method: org.eclipse.pde.internal.ui.SWTFactory.createRadioButton(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Button;3
public static Button createRadioButton(Composite parent, String label, int hspan) {
    Button button = new  Button(parent, SWT.RADIO);
    button.setFont(parent.getFont());
    if (label != null) {
        button.setText(label);
    }
    GridData gd = new  GridData();
    gd.horizontalSpan = hspan;
    button.setLayoutData(gd);
    SWTFactory.setButtonDimensionHint(button);
    return button;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.SWTFactory.createRadioButton(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Button;3
public static Button createRadioButton(Composite parent, String label, int hspan) {
    Button button = new  Button(parent, SWT.RADIO);
    button.setFont(parent.getFont());
    if (label != null) {
        button.setText(label);
    }
    GridData gd = new  GridData(GridData.BEGINNING);
    gd.horizontalSpan = hspan;
    button.setLayoutData(gd);
    setButtonDimensionHint(button);
    return button;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.indirectAccessToStaticField(org.eclipse.jdt.internal.compiler.ast.ASTNode;org.eclipse.jdt.internal.compiler.lookup.FieldBinding;)V3
public void indirectAccessToStaticField(ASTNode location, FieldBinding field) {
    int severity = computeSeverity(IProblem.IndirectAccessToStaticField);
    if (severity == ProblemSeverities.Ignore)
        return;
    this.handle(IProblem.IndirectAccessToStaticField, new String[] { new  String(field.declaringClass.readableName()), new  String(field.name) }, new String[] { new  String(field.declaringClass.shortReadableName()), new  String(field.name) }, severity, nodeSourceStart(field, location), nodeSourceEnd(field, location));
}
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.handle(IAjava.lang.String;Ajava.lang.String;III)V7
private void handle(int problemId, String[] problemArguments, String[] messageArguments, int severity, int problemStartPosition, int problemEndPosition) {
    this.handle(problemId, problemArguments, 0, messageArguments, severity, problemStartPosition, problemEndPosition);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.deprecatedField(org.eclipse.jdt.internal.compiler.lookup.FieldBinding;org.eclipse.jdt.internal.compiler.ast.ASTNode;)V3
public void deprecatedField(FieldBinding field, ASTNode location) {
    int severity = computeSeverity(IProblem.UsingDeprecatedField);
    if (severity == ProblemSeverities.Ignore)
        return;
    this.handle(IProblem.UsingDeprecatedField, new String[] { new  String(field.declaringClass.readableName()), new  String(field.name) }, new String[] { new  String(field.declaringClass.shortReadableName()), new  String(field.name) }, severity, nodeSourceStart(field, location), nodeSourceEnd(field, location));
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.product.AboutSection.handleModelEventWorldChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
private void handleModelEventWorldChanged(IModelChangedEvent event) {
    refresh();
}
method: org.eclipse.pde.internal.ui.editor.product.AboutSection.refresh()V1
public void refresh() {
    fImageEntry.setValue(getAboutInfo().getImagePath(), true);
    fTextEntry.setValue(getAboutInfo().getText(), true);
    super.refresh();
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.WatchEditPreferencePage.initialize()V1
protected void initialize() {
    super.initialize();
    promptEditor.setEnabled(isEditEnabled(), getFieldEditorParent());
    updateEditor.setEnabled(isEditEnabled(), getFieldEditorParent());
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.ComputedSet$1.getRemovals()java.util.Set;1
public Set getRemovals() {
    return getDelegate().getRemovals();
}
method: org.eclipse.core.databinding.observable.set.ComputedSet$1.getDelegate()org.eclipse.core.databinding.observable.set.SetDiff;1
private SetDiff getDelegate() {
    if (delegate == null)
        delegate = Diffs.computeSetDiff(oldSet, getSet());
    return delegate;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.ComputedList$1.getDifferences()Aorg.eclipse.core.databinding.observable.list.ListDiffEntry;1
public ListDiffEntry[] getDifferences() {
    if (differences == null)
        differences = Diffs.computeListDiff(oldList, getList()).getDifferences();
    return differences;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumePushPosition()V1
protected void consumePushPosition() {
    pushOnIntStack(this.endPosition);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeElidedLeftBraceAndReturn()V1
protected void consumeElidedLeftBraceAndReturn() {
    int stackLength = this.stateStackLengthStack.length;
    if (++this.valueLambdaNestDepth >= stackLength) {
        System.arraycopy(this.stateStackLengthStack, 0, this.stateStackLengthStack = new int[stackLength + 4], 0, stackLength);
    }
    this.stateStackLengthStack[this.valueLambdaNestDepth] = this.stateStackTop;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.JUnitPlugin.getDialogSettingsSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
public IDialogSettings getDialogSettingsSection(String name) {
    IDialogSettings dialogSettings = getDialogSettings();
    IDialogSettings section = dialogSettings.getSection(name);
    if (section == null) {
        section = dialogSettings.addNewSection(name);
    }
    return section;
}
method: org.eclipse.jface.dialogs.DialogSettings.addNewSection(java.lang.String;)org.eclipse.jface.dialogs.IDialogSettings;2
@Override
public IDialogSettings addNewSection(String sectionName) {
    DialogSettings section = new  DialogSettings(sectionName);
    addSection(section);
    return section;
}
---------------Client-------------------
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryManager.addDateTag(org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;org.eclipse.team.internal.ccvs.core.CVSTag;)V3
public void addDateTag(ICVSRepositoryLocation location, CVSTag tag) {
    if (tag == null)
        return;
    RepositoryRoot root = getRepositoryRootFor(location);
    root.addDateTag(tag);
    broadcastRepositoryChange(root);
}
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryRoot.addDateTag(org.eclipse.team.internal.ccvs.core.CVSTag;)V2
public void addDateTag(CVSTag tag) {
    if (!dateTags.contains(tag)) {
        dateTags.add(tag);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.jarpackager.CheckboxTreeAndListGroup.ungrayCheckHierarchy(java.lang.Object;)V2
protected void ungrayCheckHierarchy(Object treeElement) {
    if (!determineShouldBeAtLeastGrayChecked(treeElement))
        fCheckedStateStore.remove(treeElement);
    Object parent = fTreeContentProvider.getParent(treeElement);
    if (parent != null)
        ungrayCheckHierarchy(parent);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaTextViewer.getControl()org.eclipse.swt.widgets.Control;1
@Override
public Control getControl() {
    return fSourceViewer.getControl();
}
method: org.eclipse.jface.text.source.SourceViewer.getControl()org.eclipse.swt.widgets.Control;1
public Control getControl() {
    if (fComposite != null)
        return fComposite;
    return super.getControl();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jetty.http.HttpFields.putDateField(java.lang.String;J)V3
public void putDateField(String name, long date) {
    Buffer n = HttpHeaders.CACHE.lookup(name);
    putDateField(n, date);
}
method: org.eclipse.jetty.http.HttpFields.putDateField(org.eclipse.jetty.io.Buffer;J)V3
public void putDateField(Buffer name, long date) {
    String d = formatDate(date);
    Buffer v = new  ByteArrayBuffer(d);
    put(name, v);
}
---------------Client-------------------
method: org.eclipse.jetty.http.HttpFields.addDateField(java.lang.String;J)V3
public void addDateField(String name, long date) {
    String d = formatDate(date);
    Buffer n = HttpHeaders.CACHE.lookup(name);
    Buffer v = new  ByteArrayBuffer(d);
    add(n, v);
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSelectChannelConnector.getSslContext()javax.net.ssl.SSLContext;1
@Deprecated
public SSLContext getSslContext() {
    return _sslContextFactory.getSslContext();
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.getSslContext()javax.net.ssl.SSLContext;1
public SSLContext getSslContext() {
    if (!isStarted())
        throw new  IllegalStateException(getState());
    return _context;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.frameworkadmin.utils.SimpleBundlesState.getExpectedState()Aorg.eclipse.equinox.frameworkadmin.BundleInfo;1
public BundleInfo[] getExpectedState() throws FrameworkAdminRuntimeException {
    if (!fwAdmin.isActive())
        throw new  FrameworkAdminRuntimeException("FrameworkAdmin creates this object is no more available.", FrameworkAdminRuntimeException.FRAMEWORKADMIN_UNAVAILABLE);
    return Utils.getBundleInfosFromList(this.bundleInfosList);
}

---------------Library-------------------
method: org.eclipse.jface.viewers.ColumnViewer.getCell(org.eclipse.swt.graphics.Point;)org.eclipse.jface.viewers.ViewerCell;2
public ViewerCell getCell(Point point) {
    ViewerRow row = getViewerRow(point);
    if (row != null) {
        return row.getCell(point);
    }
    return null;
}
method: org.eclipse.jface.viewers.ColumnViewer.getViewerRow(org.eclipse.swt.graphics.Point;)org.eclipse.jface.viewers.ViewerRow;2
protected ViewerRow getViewerRow(Point point) {
    Item item = getItemAt(point);
    if (item != null) {
        return getViewerRowFromItem(item);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.StructuredViewerSection.createClientContainer(org.eclipse.swt.widgets.Composite;ILorg.eclipse.ui.forms.widgets.FormToolkit;)org.eclipse.swt.widgets.Composite;4
protected Composite createClientContainer(Composite parent, int span, FormToolkit toolkit) {
    Composite container = toolkit.createComposite(parent);
    container.setLayout(FormLayoutFactory.createSectionClientGridLayout(false, span));
    return container;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.util.SuperTypeHierarchyCache$HierarchyCacheEntry.dispose()V1
public void dispose() {
    if (fTypeHierarchy != null) {
        fTypeHierarchy.removeTypeHierarchyChangedListener(this);
        fTypeHierarchy = null;
    }
}
method: org.eclipse.jdt.internal.core.hierarchy.TypeHierarchy.removeTypeHierarchyChangedListener(org.eclipse.jdt.core.ITypeHierarchyChangedListener;)V2
public synchronized void removeTypeHierarchyChangedListener(ITypeHierarchyChangedListener listener) {
    ArrayList listeners = this.changeListeners;
    if (listeners == null) {
        return;
    }
    listeners.remove(listener);
    if (listeners.isEmpty()) {
        JavaCore.removeElementChangedListener(this);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo.removeLabel(org.eclipse.jdt.core.dom.SimpleName;)V2
protected void removeLabel(SimpleName label) {
    if (fBranches != null) {
        fBranches.remove(makeString(label));
        if (fBranches.isEmpty())
            fBranches = null;
    }
}

---------------Library-------------------
method: org.eclipse.jface.viewers.deferred.BackgroundContentProvider.setLimit(I)V2
public void setLimit(int limit) {
    this.limit = limit;
    refresh();
}
method: org.eclipse.jface.viewers.deferred.BackgroundContentProvider.refresh()V1
public void refresh() {
    if (updator.isDisposed()) {
        return;
    }
    model.requestUpdate(listener);
}
---------------Client-------------------
method: org.eclipse.compare.CompareViewerPane$4.getName(org.eclipse.swt.accessibility.AccessibleEvent;)V2
public void getName(AccessibleEvent e) {
    if (e.childID != ACC.CHILDID_SELF) {
        ToolItem item = tb.getItem(e.childID);
        if (item != null) {
            String toolTip = item.getToolTipText();
            if (toolTip != null) {
                e.result = toolTip;
            }
        }
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.search.dependencies.CalculateUsesAction.run()V1
public void run() {
    Job job = createJob();
    job.setUser(true);
    job.setProperty(IProgressConstants.ICON_PROPERTY, PDEPluginImages.DESC_PSEARCH_OBJ.createImage());
    job.schedule();
}
method: org.eclipse.pde.internal.ui.search.dependencies.CalculateUsesAction.createJob()org.eclipse.core.runtime.jobs.Job;1
protected Job createJob() {
    return new  WorkspaceJob(PDEUIMessages.CalculateUsesAction_jobName) {

        public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
            CalculateUsesOperation op = getOperation();
            try {
                op.run(monitor);
            } catch (InvocationTargetException e) {
            } catch (InterruptedException e) {
            } finally {
                monitor.done();
            }
            return new  Status(IStatus.OK, PDEPlugin.getPluginId(), IStatus.OK, "", null);
        }
    };
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.search.dependencies.AddNewDependenciesAction.run()V1
public void run() {
    Job job = new  WorkspaceJob(PDEUIMessages.DependencyManagementSection_jobName) {

        public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
            try {
                AddNewDependenciesOperation op = getOperation();
                op.run(monitor);
                if (!op.foundNewDependencies())
                    Display.getDefault().asyncExec(new  Runnable() {

                        public void run() {
                            MessageDialog.openInformation(PDEPlugin.getActiveWorkbenchShell(), PDEUIMessages.AddNewDependenciesAction_title, PDEUIMessages.AddNewDependenciesAction_notFound);
                        }
                    });
            } catch (InvocationTargetException e) {
            } catch (InterruptedException e) {
            } finally {
                monitor.done();
            }
            return new  Status(IStatus.OK, PDEPlugin.getPluginId(), IStatus.OK, "", null);
        }
    };
    job.setUser(true);
    job.setProperty(IProgressConstants.ICON_PROPERTY, PDEPluginImages.DESC_PSEARCH_OBJ.createImage());
    job.schedule();
}

---------------Library-------------------
method: org.eclipse.ui.part.MultiPageEditorSite.registerContextMenu(org.eclipse.jface.action.MenuManager;org.eclipse.jface.viewers.ISelectionProvider;Z)V4
@Override
public final void registerContextMenu(final MenuManager menuManager, final ISelectionProvider selectionProvider, final boolean includeEditorInput) {
    registerContextMenu(getId(), menuManager, selectionProvider, includeEditorInput);
}
method: org.eclipse.ui.part.MultiPageEditorSite.registerContextMenu(java.lang.String;org.eclipse.jface.action.MenuManager;org.eclipse.jface.viewers.ISelectionProvider;Z)V5
@Override
public final void registerContextMenu(final String menuId, final MenuManager menuManager, final ISelectionProvider selectionProvider, final boolean includeEditorInput) {
    if (menuExtenders == null) {
        menuExtenders = new  ArrayList(1);
    }
    PartSite.registerContextMenu(menuId, menuManager, selectionProvider, includeEditorInput, editor, context, menuExtenders);
}
---------------Client-------------------
method: org.eclipse.ui.part.PageSite.registerContextMenu(java.lang.String;org.eclipse.jface.action.MenuManager;org.eclipse.jface.viewers.ISelectionProvider;)V4
@Override
public void registerContextMenu(String menuID, MenuManager menuMgr, ISelectionProvider selProvider) {
    if (menuExtenders == null) {
        menuExtenders = new  ArrayList(1);
    }
    PartSite.registerContextMenu(menuID, menuMgr, selProvider, false, parentSite.getPart(), e4Context, menuExtenders);
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.NavigatorPlugin.start(org.osgi.framework.BundleContext;)V2
public void start(BundleContext context) throws Exception {
    super.start(context);
    context.addBundleListener(bundleListener);
}
method: org.eclipse.ui.plugin.AbstractUIPlugin.start(org.osgi.framework.BundleContext;)V2
@Override
public void start(BundleContext context) throws Exception {
    super.start(context);
    final BundleContext fc = context;
    bundleListener = new  BundleListener() {

        @Override
        public void bundleChanged(BundleEvent event) {
            if (event.getBundle() == getBundle()) {
                if (event.getType() == BundleEvent.STARTED) {
                    if (getBundle().getState() == Bundle.ACTIVE) {
                        refreshPluginActions();
                    }
                    fc.removeBundleListener(this);
                }
            }
        }
    };
    context.addBundleListener(bundleListener);
}
---------------Client-------------------
method: org.apache.batik.css.engine.CSSEngine$StyleSheetDocumentHandler.startMedia(org.w3c.css.sac.SACMediaList;)V2
public void startMedia(SACMediaList media) throws CSSException {
    MediaRule mr = new  MediaRule();
    mr.setMediaList(media);
    mr.setParent(styleSheet);
    styleSheet.append(mr);
    styleSheet = mr;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.ArrayInitializer;)V2
@Override
public void endVisit(ArrayInitializer node) {
    if (skipNode(node))
        return;
    processSequential(node, node.expressions());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.processSequential(org.eclipse.jdt.core.dom.ASTNode;java.util.List;)org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;3
protected GenericSequentialFlowInfo processSequential(ASTNode parent, List<? extends ASTNode> nodes) {
    GenericSequentialFlowInfo result = createSequential(parent);
    process(result, nodes);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.details.SimpleCSCommandComboPart.getValue(java.lang.String;)java.lang.String;2
public String getValue(String key) {
    return SimpleCSCommandManager.Instance().get(key);
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSCommandManager.Instance()org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSCommandManager;0
public static SimpleCSCommandManager Instance() {
    if (fPinstance == null) {
        fPinstance = new  SimpleCSCommandManager();
    }
    return fPinstance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.WizardNewProjectCreationPage.getLocationURI()java.net.URI;1
public URI getLocationURI() {
    return locationArea.getProjectLocationURI();
}
method: org.eclipse.ui.internal.ide.dialogs.ProjectContentsLocationArea.getProjectLocationURI()java.net.URI;1
public URI getProjectLocationURI() {
    FileSystemConfiguration configuration = getSelectedConfiguration();
    if (configuration == null) {
        return null;
    }
    return configuration.getContributor().getURI(locationPathField.getText());
}
---------------Client-------------------
method: org.eclipse.osgi.internal.framework.BundleContextImpl.createFilter(java.lang.String;)org.osgi.framework.Filter;2
public Filter createFilter(String filter) throws InvalidSyntaxException {
    checkValid();
    return FilterImpl.newInstance(filter, container.getConfiguration().getDebug().DEBUG_FILTER);
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntRuntimePreferencePage.setButtonLayoutData(org.eclipse.swt.widgets.Button;)org.eclipse.swt.layout.GridData;2
@Override
protected GridData setButtonLayoutData(Button button) {
    return super.setButtonLayoutData(button);
}
method: org.eclipse.jface.dialogs.DialogPage.setButtonLayoutData(org.eclipse.swt.widgets.Button;)org.eclipse.swt.layout.GridData;2
protected GridData setButtonLayoutData(Button button) {
    GridData data = new  GridData(GridData.HORIZONTAL_ALIGN_FILL);
    int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
    Point minSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
    data.widthHint = Math.max(widthHint, minSize.x);
    button.setLayoutData(data);
    return data;
}
---------------Client-------------------
method: org.eclipse.ui.internal.activities.ws.ActivityEnabler.setButtonLayoutData(org.eclipse.swt.widgets.Button;org.eclipse.swt.graphics.FontMetrics;)org.eclipse.swt.layout.GridData;3
private GridData setButtonLayoutData(Button button, FontMetrics fontMetrics) {
    GridData data = new  GridData(GridData.HORIZONTAL_ALIGN_FILL);
    int widthHint = Dialog.convertHorizontalDLUsToPixels(fontMetrics, IDialogConstants.BUTTON_WIDTH);
    Point minSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
    data.widthHint = Math.max(widthHint, minSize.x);
    button.setLayoutData(data);
    return data;
}

---------------Library-------------------
method: org.eclipse.ui.internal.intro.impl.IntroPlugin.getIntroModelRoot()org.eclipse.ui.internal.intro.impl.model.IntroModelRoot;1
public IntroModelRoot getIntroModelRoot() {
    return getExtensionPointManager().getCurrentModel();
}
method: org.eclipse.ui.internal.intro.impl.model.loader.ExtensionPointManager.getCurrentModel()org.eclipse.ui.internal.intro.impl.model.IntroModelRoot;1
public IntroModelRoot getCurrentModel() {
    if (currentModel == null)
        loadCurrentModel();
    return currentModel;
}
---------------Client-------------------
method: org.eclipse.pde.core.target.TargetFeature.getId()java.lang.String;1
public String getId() {
    if (featureModel == null)
        return null;
    return featureModel.getFeature().getId();
}

---------------Library-------------------
method: org.eclipse.e4.core.internal.di.Requestor.getRequestingObjectClass()java.lang.Class;1
public Class<?> getRequestingObjectClass() {
    Object object = getRequestingObject();
    if (object == null)
        return null;
    return object.getClass();
}
method: org.eclipse.e4.core.internal.di.Requestor.getRequestingObject()java.lang.Object;1
public Object getRequestingObject() {
    if (objectRef == null)
        return null;
    return objectRef.get();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.EngineSession.getCurrentPhaseId()java.lang.String;1
private String getCurrentPhaseId() {
    if (currentPhase == null)
        return EMPTY_STRING;
    return currentPhase.getClass().getName();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.LibraryVisibilitySection$TableLabelProvider.getColumnImage(java.lang.Object;I)org.eclipse.swt.graphics.Image;3
public Image getColumnImage(Object obj, int index) {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PACKAGE);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.WildcardType;)V2
@Override
public void endVisit(WildcardType node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getBound());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.e4.ui.workbench.swt.internal.copy.ViewContentProvider.getElements(java.lang.Object;)Ajava.lang.Object;2
@Override
public Object[] getElements(Object element) {
    return getChildren(element);
}
method: org.eclipse.e4.ui.workbench.swt.internal.copy.ViewContentProvider.getChildren(java.lang.Object;)Ajava.lang.Object;2
@Override
public Object[] getChildren(Object element) {
    Object[] children = (Object[]) childMap.get(element);
    if (children == null) {
        children = createChildren(element);
        childMap.put(element, children);
    }
    return children;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.CodeAssistAdvancedConfigurationBlock.getImage(org.eclipse.jface.resource.ImageDescriptor;)org.eclipse.swt.graphics.Image;2
private Image getImage(ImageDescriptor imgDesc) {
    if (imgDesc == null)
        return null;
    Image img = fImages.get(imgDesc);
    if (img == null) {
        img = imgDesc.createImage(false);
        fImages.put(imgDesc, img);
    }
    return img;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.value.ComputedValue.makeDirty()V1
protected final void makeDirty() {
    if (!dirty) {
        dirty = true;
        stopListening();
        final Object oldValue = cachedValue;
        fireValueChange(new  ValueDiff() {

            public Object getOldValue() {
                return oldValue;
            }

            public Object getNewValue() {
                return getValue();
            }
        });
    }
}
method: org.eclipse.core.databinding.observable.value.AbstractObservableValue.fireValueChange(org.eclipse.core.databinding.observable.value.ValueDiff;)V2
protected void fireValueChange(ValueDiff diff) {
    super.fireChange();
    fireEvent(new  ValueChangeEvent(this, diff));
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.ComputedList.makeDirty()V1
private void makeDirty() {
    if (!dirty) {
        dirty = true;
        makeStale();
        stopListening();
        final List oldList = new  ArrayList(cachedList);
        fireListChange(new  ListDiff() {

            ListDiffEntry[] differences;

            public ListDiffEntry[] getDifferences() {
                if (differences == null)
                    differences = Diffs.computeListDiff(oldList, getList()).getDifferences();
                return differences;
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.preferences.HelpContentPreferencePage.setButtonLayoutData(org.eclipse.swt.widgets.Button;)org.eclipse.swt.layout.GridData;2
protected GridData setButtonLayoutData(Button button) {
    return super.setButtonLayoutData(button);
}
method: org.eclipse.jface.dialogs.DialogPage.setButtonLayoutData(org.eclipse.swt.widgets.Button;)org.eclipse.swt.layout.GridData;2
protected GridData setButtonLayoutData(Button button) {
    GridData data = new  GridData(GridData.HORIZONTAL_ALIGN_FILL);
    int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
    Point minSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
    data.widthHint = Math.max(widthHint, minSize.x);
    button.setLayoutData(data);
    return data;
}
---------------Client-------------------
method: org.eclipse.ui.internal.activities.ws.ActivityEnabler.setButtonLayoutData(org.eclipse.swt.widgets.Button;org.eclipse.swt.graphics.FontMetrics;)org.eclipse.swt.layout.GridData;3
private GridData setButtonLayoutData(Button button, FontMetrics fontMetrics) {
    GridData data = new  GridData(GridData.HORIZONTAL_ALIGN_FILL);
    int widthHint = Dialog.convertHorizontalDLUsToPixels(fontMetrics, IDialogConstants.BUTTON_WIDTH);
    Point minSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
    data.widthHint = Math.max(widthHint, minSize.x);
    button.setLayoutData(data);
    return data;
}

---------------Library-------------------
method: org.eclipse.ui.internal.PerspectiveBarManager.ensureVisible(org.eclipse.ui.internal.PerspectiveBarContributionItem;)V2
private void ensureVisible(PerspectiveBarContributionItem contribItem) {
    relocate(contribItem, 1);
}
method: org.eclipse.ui.internal.PerspectiveBarManager.relocate(org.eclipse.ui.internal.PerspectiveBarContributionItem;I)V3
void relocate(PerspectiveBarContributionItem contribItem, int index) {
    PerspectiveBarContributionItem newItem = new  PerspectiveBarContributionItem(contribItem.getPerspective(), contribItem.getPage());
    removeItem(contribItem);
    contribItem.dispose();
    contribItem = null;
    insert(index, newItem);
    update(false);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.fix.SerialVersionDefaultOperation.addLinkedPositions(org.eclipse.jdt.core.dom.rewrite.ASTRewrite;org.eclipse.jdt.core.dom.VariableDeclarationFragment;org.eclipse.jdt.internal.corext.fix.LinkedProposalModel;)V4
@Override
protected void addLinkedPositions(final ASTRewrite rewrite, final VariableDeclarationFragment fragment, final LinkedProposalModel positionGroups) {
    Assert.isNotNull(rewrite);
    Assert.isNotNull(fragment);
    final Expression initializer = fragment.getInitializer();
    if (initializer != null) {
        LinkedProposalPositionGroup group = new  LinkedProposalPositionGroup(GROUP_INITIALIZER);
        group.addPosition(rewrite.track(initializer), true);
        positionGroups.addPositionGroup(group);
    }
}

---------------Library-------------------
method: org.eclipse.ui.activities.ActivitiesPreferencePage.performDefaults()V1
@Override
protected void performDefaults() {
    enabler.restoreDefaults();
    activityPromptButton.setSelection(getPreferenceStore().getDefaultBoolean(IPreferenceConstants.SHOULD_PROMPT_FOR_ENABLEMENT));
    super.performDefaults();
}
method: org.eclipse.ui.internal.activities.ws.ActivityEnabler.restoreDefaults()V1
public void restoreDefaults() {
    Set defaultEnabled = new  HashSet();
    Set activityIds = activitySupport.getDefinedActivityIds();
    for (Iterator i = activityIds.iterator(); i.hasNext(); ) {
        String activityId = (String) i.next();
        IActivity activity = activitySupport.getActivity(activityId);
        try {
            if (activity.isDefaultEnabled()) {
                defaultEnabled.add(activityId);
            }
        } catch (NotDefinedException e) {
        }
    }
    setEnabledStates(defaultEnabled);
}
---------------Client-------------------
method: org.eclipse.ui.activities.ActivityCategoryPreferencePage.performDefaults()V1
@Override
protected void performDefaults() {
    super.performDefaults();
    activityPromptButton.setSelection(getPreferenceStore().getDefaultBoolean(IPreferenceConstants.SHOULD_PROMPT_FOR_ENABLEMENT));
    Set defaultEnabled = new  HashSet();
    Set activityIds = workingCopy.getDefinedActivityIds();
    for (Iterator i = activityIds.iterator(); i.hasNext(); ) {
        String activityId = (String) i.next();
        IActivity activity = workingCopy.getActivity(activityId);
        try {
            if (activity.isDefaultEnabled()) {
                defaultEnabled.add(activityId);
            }
        } catch (NotDefinedException e) {
        }
    }
    workingCopy.setEnabledActivityIds(defaultEnabled);
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Widget.isValidThread()Z1
boolean isValidThread() {
    return getDisplay().isValidThread();
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.InternalLanguageElementNode.hasOneGroupCategory(java.util.List;)Z2
boolean hasOneGroupCategory(List categories) {
    if (fChildren == null)
        return false;
    return getGroupCategorySet().containsOneCategory(categories);
}

---------------Library-------------------
method: org.eclipse.core.commands.Command.removeCommandListener(org.eclipse.core.commands.ICommandListener;)V2
public final void removeCommandListener(final ICommandListener commandListener) {
    if (commandListener == null) {
        throw new  NullPointerException("Cannot remove a null command listener");
    }
    removeListenerObject(commandListener);
}
method: org.eclipse.core.commands.common.EventManager.removeListenerObject(java.lang.Object;)V2
protected final synchronized void removeListenerObject(final Object listener) {
    if (listenerList != null) {
        listenerList.remove(listener);
        if (listenerList.isEmpty()) {
            listenerList = null;
        }
    }
}
---------------Client-------------------
method: org.eclipse.core.commands.Command.removeExecutionListener(org.eclipse.core.commands.IExecutionListener;)V2
public final void removeExecutionListener(final IExecutionListener executionListener) {
    if (executionListener == null) {
        throw new  NullPointerException("Cannot remove a null execution listener");
    }
    if (executionListeners != null) {
        executionListeners.remove(executionListener);
        if (executionListeners.isEmpty()) {
            executionListeners = null;
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.core.Signature.appendArrayTypeSignature(ACIZLjava.lang.StringBuffer;)I4
private static int appendArrayTypeSignature(char[] string, int start, boolean fullyQualifyTypeNames, StringBuffer buffer) {
    return appendArrayTypeSignature(string, start, fullyQualifyTypeNames, buffer, false);
}
method: org.eclipse.jdt.core.Signature.appendArrayTypeSignature(ACIZLjava.lang.StringBuffer;Z)I5
private static int appendArrayTypeSignature(char[] string, int start, boolean fullyQualifyTypeNames, StringBuffer buffer, boolean isVarArgs) {
    int length = string.length;
    if (start >= length - 1) {
        throw new  IllegalArgumentException();
    }
    char c = string[start];
    if (c != C_ARRAY) {
        throw new  IllegalArgumentException();
    }
    int index = start;
    c = string[++index];
    while (c == C_ARRAY) {
        if (index >= length - 1) {
            throw new  IllegalArgumentException();
        }
        c = string[++index];
    }
    int e = appendTypeSignature(string, index, fullyQualifyTypeNames, buffer);
    for (int i = 1, dims = index - start; i < dims; i++) {
        buffer.append('[').append(']');
    }
    if (isVarArgs) {
        buffer.append('.').append('.').append('.');
    } else {
        buffer.append('[').append(']');
    }
    return e;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.util.Util.appendArrayTypeSignatureForAnchor(ACILjava.lang.StringBuffer;Z)I4
private static int appendArrayTypeSignatureForAnchor(char[] string, int start, StringBuffer buffer, boolean isVarArgs) {
    int length = string.length;
    if (start >= length - 1) {
        throw new  IllegalArgumentException();
    }
    char c = string[start];
    if (c != Signature.C_ARRAY) {
        throw new  IllegalArgumentException();
    }
    int index = start;
    c = string[++index];
    while (c == Signature.C_ARRAY) {
        if (index >= length - 1) {
            throw new  IllegalArgumentException();
        }
        c = string[++index];
    }
    int e = appendTypeSignatureForAnchor(string, index, buffer, false);
    for (int i = 1, dims = index - start; i < dims; i++) {
        buffer.append('[').append(']');
    }
    if (isVarArgs) {
        buffer.append('.').append('.').append('.');
    } else {
        buffer.append('[').append(']');
    }
    return e;
}

---------------Library-------------------
method: org.apache.lucene.analysis.compound.hyphenation.PatternParser.parse(java.lang.String;)V2
public void parse(String filename) throws HyphenationException {
    parse(new  InputSource(filename));
}
method: org.apache.lucene.analysis.compound.hyphenation.PatternParser.parse(org.xml.sax.InputSource;)V2
public void parse(InputSource source) throws HyphenationException {
    try {
        parser.parse(source);
    } catch (FileNotFoundException fnfe) {
        throw new  HyphenationException("File not found: " + fnfe.getMessage());
    } catch (IOException ioe) {
        throw new  HyphenationException(ioe.getMessage());
    } catch (SAXException e) {
        throw new  HyphenationException(errMsg);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.util.BusyIndicatorRunnableContext$BusyRunnable$ThreadContext.run()V1
@Override
public void run() {
    try {
        fRunnable.run(new  NullProgressMonitor());
    } catch (InvocationTargetException e) {
        fThrowable = e;
    } catch (InterruptedException e) {
        fThrowable = e;
    } catch (ThreadDeath e) {
        fThrowable = e;
        throw e;
    } catch (RuntimeException e) {
        fThrowable = e;
    } catch (Error e) {
        fThrowable = e;
    }
}

---------------Library-------------------
method: org.eclipse.ecf.internal.core.ECFPlugin.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    if (context == null)
        return null;
    return context.getBundle();
}
method: org.eclipse.osgi.internal.framework.BundleContextImpl.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    checkValid();
    return getBundleImpl();
}
---------------Client-------------------
method: org.eclipse.pde.core.target.TargetFeature.getId()java.lang.String;1
public String getId() {
    if (featureModel == null)
        return null;
    return featureModel.getFeature().getId();
}

---------------Library-------------------
method: org.eclipse.emf.ecore.util.EcoreUtil$ContentTreeIterator.getResourceChildren(org.eclipse.emf.ecore.resource.Resource;)java.util.Iterator;2
protected Iterator<EObject> getResourceChildren(Resource resource) {
    return resource.getContents().iterator();
}
method: org.eclipse.emf.ecore.resource.impl.ResourceImpl.getContents()org.eclipse.emf.common.util.EList;1
public EList<EObject> getContents() {
    if (contents == null) {
        contents = new  ContentsEList<EObject>();
    }
    return contents;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.search.UseReportConverter.getReportsRoot()java.io.File;1
protected File getReportsRoot() {
    if (this.reportsRoot == null) {
        this.reportsRoot = new  File(getXmlLocation());
    }
    return this.reportsRoot;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.repository.CacheManager.setEventBus(org.eclipse.equinox.internal.provisional.p2.core.eventbus.IProvisioningEventBus;)V2
public void setEventBus(IProvisioningEventBus newBus) {
    registerRepoEventListener(newBus);
}
method: org.eclipse.equinox.internal.p2.repository.CacheManager.registerRepoEventListener(org.eclipse.equinox.internal.provisional.p2.core.eventbus.IProvisioningEventBus;)V2
private void registerRepoEventListener(IProvisioningEventBus eventBus) {
    if (busListener == null) {
        busListener = new  SynchronousProvisioningListener() {

            public void notify(EventObject o) {
                if (o instanceof RepositoryEvent) {
                    RepositoryEvent event = (RepositoryEvent) o;
                    if (RepositoryEvent.REMOVED == event.getKind() && IRepository.TYPE_METADATA == event.getRepositoryType()) {
                        deleteCache(event.getRepositoryLocation());
                    }
                }
            }
        };
    }
    eventBus.addListener(busListener);
}
---------------Client-------------------
method: org.eclipse.help.internal.base.remote.RemoteHelp.addPreferenceChangeListener(org.eclipse.core.runtime.preferences.IEclipsePreferences$IPreferenceChangeListener;)V1
public static void addPreferenceChangeListener(IPreferenceChangeListener listener) {
    if (listeners == null) {
        listeners = new  ListenerList();
    }
    listeners.add(listener);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeAssignmentOperator(I)V2
protected void consumeAssignmentOperator(int pos) {
    pushOnIntStack(pos);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.jface.dialogs.MessageDialog.getMinimumMessageWidth()I1
protected int getMinimumMessageWidth() {
    return convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
}
method: org.eclipse.jface.dialogs.Dialog.convertHorizontalDLUsToPixels(I)I2
protected int convertHorizontalDLUsToPixels(int dlus) {
    if (fontMetrics == null) {
        return 0;
    }
    return convertHorizontalDLUsToPixels(fontMetrics, dlus);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart.isExpandable(java.lang.Object;)Z2
boolean isExpandable(Object element) {
    if (fViewer == null)
        return false;
    return fViewer.isExpandable(element);
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.EAnnotationImpl.setSource(java.lang.String;)V2
public void setSource(String newSource) {
    setSourceGen(newSource == null ? null : newSource.intern());
}
method: org.eclipse.emf.ecore.impl.EAnnotationImpl.setSourceGen(java.lang.String;)V2
public void setSourceGen(String newSource) {
    String oldSource = source;
    source = newSource;
    if (eNotificationRequired())
        eNotify(new  ENotificationImpl(this, Notification.SET, EcorePackage.EANNOTATION__SOURCE, oldSource, source));
}
---------------Client-------------------
method: org.eclipse.e4.ui.model.application.impl.ApplicationElementImpl.setContributorURI(java.lang.String;)V2
public void setContributorURI(String newContributorURI) {
    String oldContributorURI = contributorURI;
    contributorURI = (newContributorURI == null) ? null : newContributorURI.intern();
    if (eNotificationRequired())
        eNotify(new  ENotificationImpl(this, Notification.SET, ApplicationPackageImpl.APPLICATION_ELEMENT__CONTRIBUTOR_URI, oldContributorURI, contributorURI));
}

---------------Library-------------------
method: org.eclipse.compare.CompareConfiguration$DefaultLabelProvider.labelProviderChanged(org.eclipse.jface.viewers.LabelProviderChangedEvent;)V2
public void labelProviderChanged(LabelProviderChangedEvent event) {
    fireLabelProviderChanged(new  LabelProviderChangedEvent(this, event.getElements()));
}
method: org.eclipse.jface.viewers.LabelProviderChangedEvent.getElements()Ajava.lang.Object;1
public Object[] getElements() {
    if (this.elements == null) {
        return null;
    } else {
        return this.elements;
    }
}
---------------Client-------------------
method: org.eclipse.jface.internal.databinding.viewers.ObservableCollectionContentProvider.asyncUpdateRealizedElements()V1
private void asyncUpdateRealizedElements() {
    if (realizedElements == null)
        return;
    display.asyncExec(new  Runnable() {

        public void run() {
            if (realizedElements != null) {
                realizedElements.addAll(knownElements);
            }
        }
    });
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.commands.CommandList$1.run()V1
@Override
public void run() {
    fTreeViewer.collapseAll();
}
method: org.eclipse.jface.viewers.AbstractTreeViewer.collapseAll()V1
public void collapseAll() {
    Object root = getRoot();
    if (root != null) {
        collapseToLevel(root, ALL_LEVELS);
    }
}
---------------Client-------------------
method: org.eclipse.ui.actions.CopyProjectAction.displayError(java.lang.String;)V2
void displayError(String message) {
    MessageDialog.openError(this.shellProvider.getShell(), getErrorsTitle(), message);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.internalPath()org.eclipse.core.runtime.IPath;1
public IPath internalPath() {
    return resource().getFullPath();
}
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.resource()org.eclipse.core.resources.IResource;1
public IResource resource() {
    if (this.resource != null)
        return this.resource;
    return super.resource();
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormText.getSelectionText()java.lang.String;1
public String getSelectionText() {
    checkWidget();
    if (selData != null)
        return selData.getSelectionText();
    return "";
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticEnumInitializationMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticEnumInitializationMethod(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForEnumInitializationMethod(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.jface.viewers.Viewer$1.helpRequested(org.eclipse.swt.events.HelpEvent;)V2
@Override
public void helpRequested(HelpEvent event) {
    handleHelpRequest(event);
}
method: org.eclipse.jface.viewers.Viewer.handleHelpRequest(org.eclipse.swt.events.HelpEvent;)V2
protected void handleHelpRequest(HelpEvent event) {
    Object oldData = event.data;
    event.data = this;
    fireHelpRequested(event);
    event.data = oldData;
}
---------------Client-------------------
method: org.tartarus.snowball.ext.ArmenianStemmer.copy_from(org.tartarus.snowball.ext.ArmenianStemmer;)V2
private void copy_from(ArmenianStemmer other) {
    I_p2 = other.I_p2;
    I_pV = other.I_pV;
    super.copy_from(other);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.model.ProfileElement.getQueryable()org.eclipse.equinox.p2.query.IQueryable;1
public IQueryable<?> getQueryable() {
    return ProvUI.getProfileRegistry(getProvisioningUI().getSession()).getProfile(profileId);
}
method: org.eclipse.equinox.internal.p2.engine.SimpleProfileRegistry.getProfile(java.lang.String;)org.eclipse.equinox.p2.engine.IProfile;2
public synchronized IProfile getProfile(String id) {
    Profile profile = internalGetProfile(id);
    if (profile == null)
        return null;
    return profile.snapshot();
}
---------------Client-------------------
method: org.eclipse.ui.internal.commands.CommandManagerLegacyWrapper.getPerfectMatch(org.eclipse.ui.keys.KeySequence;)java.lang.String;2
@Override
public String getPerfectMatch(KeySequence keySequence) {
    try {
        final org.eclipse.jface.bindings.keys.KeySequence sequence = org.eclipse.jface.bindings.keys.KeySequence.getInstance(keySequence.toString());
        final Binding binding = bindingManager.getPerfectMatch(sequence);
        if (binding == null) {
            return null;
        }
        return binding.getParameterizedCommand().getId();
    } catch (final ParseException e) {
        return null;
    }
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.breakpoints.BreakpointsViewer.refresh()V1
@Override
public void refresh() {
    super.refresh();
    initializeCheckedState();
}
method: org.eclipse.debug.internal.ui.views.breakpoints.BreakpointsViewer.initializeCheckedState()V1
private void initializeCheckedState() {
    TreeItem[] items = getTree().getItems();
    for (int i = 0; i < items.length; i++) {
        updateCheckedState(items[i]);
    }
}
---------------Client-------------------
method: org.eclipse.jface.wizard.WizardDialog.setDisplayCursor(org.eclipse.swt.graphics.Cursor;)V2
private void setDisplayCursor(Cursor c) {
    Shell[] shells = getShell().getDisplay().getShells();
    for (int i = 0; i < shells.length; i++) {
        shells[i].setCursor(c);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.JavaOutlinePage$2.menuAboutToShow(org.eclipse.jface.action.IMenuManager;)V2
public void menuAboutToShow(IMenuManager m) {
    contextMenuAboutToShow(m);
}
method: org.eclipse.jdt.internal.ui.javaeditor.JavaOutlinePage.contextMenuAboutToShow(org.eclipse.jface.action.IMenuManager;)V2
protected void contextMenuAboutToShow(IMenuManager menu) {
    JavaPlugin.createStandardGroups(menu);
    IStructuredSelection selection = (IStructuredSelection) getSelection();
    fActionGroups.setContext(new  ActionContext(selection));
    fActionGroups.fillContextMenu(menu);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.feature.IncludedFeaturesSection.handleSelectAll()V1
private void handleSelectAll() {
    IStructuredContentProvider provider = (IStructuredContentProvider) fIncludesViewer.getContentProvider();
    Object[] elements = provider.getElements(fIncludesViewer.getInput());
    StructuredSelection ssel = new  StructuredSelection(elements);
    fIncludesViewer.setSelection(ssel);
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.TextEditGroupNode.hasOneGroupCategory(java.util.List;)Z2
boolean hasOneGroupCategory(List categories) {
    return fChangeGroup.getGroupCategorySet().containsOneCategory(categories);
}
method: org.eclipse.ltk.core.refactoring.GroupCategorySet.containsOneCategory(java.util.List;)Z2
public boolean containsOneCategory(List categories) {
    for (Iterator iter = categories.iterator(); iter.hasNext(); ) {
        GroupCategory category = (GroupCategory) iter.next();
        if (contains(category))
            return true;
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.CVSHistorySearchFilter.authorMatch(org.eclipse.team.internal.ccvs.core.filehistory.CVSFileRevision;)Z2
protected boolean authorMatch(CVSFileRevision revision) {
    String author = revision.getAuthor();
    if (author != null) {
        Iterator iter = searchStrings.iterator();
        while (iter.hasNext()) {
            String nextString = (String) iter.next();
            if (!((author.indexOf(nextString)) == -1))
                return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.swt.widgets.ToolBar.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    if (imageList != null)
        imageList.dispose();
    imageList = null;
}
method: org.eclipse.swt.widgets.Composite.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    if (imHandle != 0)
        OS.g_object_unref(imHandle);
    imHandle = 0;
    layout = null;
    tabList = null;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Button.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    if (groupHandle != 0)
        OS.g_object_unref(groupHandle);
    groupHandle = 0;
    if (imageList != null)
        imageList.dispose();
    imageList = null;
    image = null;
    text = null;
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSocketConnector.getSslContext()javax.net.ssl.SSLContext;1
@Deprecated
public SSLContext getSslContext() {
    return _sslContextFactory.getSslContext();
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.getSslContext()javax.net.ssl.SSLContext;1
public SSLContext getSslContext() {
    if (!isStarted())
        throw new  IllegalStateException(getState());
    return _context;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.frameworkadmin.utils.SimpleBundlesState.getExpectedState()Aorg.eclipse.equinox.frameworkadmin.BundleInfo;1
public BundleInfo[] getExpectedState() throws FrameworkAdminRuntimeException {
    if (!fwAdmin.isActive())
        throw new  FrameworkAdminRuntimeException("FrameworkAdmin creates this object is no more available.", FrameworkAdminRuntimeException.FRAMEWORKADMIN_UNAVAILABLE);
    return Utils.getBundleInfosFromList(this.bundleInfosList);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.compare.PropertiesFileViewer.getControl()org.eclipse.swt.widgets.Control;1
@Override
public Control getControl() {
    return fSourceViewer.getControl();
}
method: org.eclipse.jface.text.source.SourceViewer.getControl()org.eclipse.swt.widgets.Control;1
public Control getControl() {
    if (fComposite != null)
        return fComposite;
    return super.getControl();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticMethodAccessMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticMethodAccessMethod(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForMethodAccess(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.ltk.internal.ui.refactoring.RefactoringWizardDialog.configureShell(org.eclipse.swt.widgets.Shell;)V2
protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    getRefactoringWizard().getRefactoring().setValidationContext(newShell);
}
method: org.eclipse.jface.wizard.WizardDialog.configureShell(org.eclipse.swt.widgets.Shell;)V2
@Override
protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.addHelpListener(new  HelpListener() {

        @Override
        public void helpRequested(HelpEvent event) {
            if (currentPage != null) {
                currentPage.performHelp();
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.participants.ResourceModifications.buildMoveDelta(org.eclipse.core.resources.mapping.IResourceChangeDescriptionFactory;org.eclipse.core.resources.IResource;org.eclipse.ltk.core.refactoring.participants.RenameArguments;)V3
public static void buildMoveDelta(IResourceChangeDescriptionFactory builder, IResource resource, RenameArguments args) {
    IPath newPath = resource.getFullPath().removeLastSegments(1).append(args.getNewName());
    new  MoveDescription(resource, newPath).buildDelta(builder);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.properties.CompilersPropertyPage.dispose()V1
public void dispose() {
    fBlock.dispose();
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
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.PDEFormEditor.updateUndo(org.eclipse.jface.action.IAction;org.eclipse.jface.action.IAction;)V3
void updateUndo(IAction undoAction, IAction redoAction) {
    IModelUndoManager undoManager = fInputContextManager.getUndoManager();
    if (undoManager != null)
        undoManager.setActions(undoAction, redoAction);
}
method: org.eclipse.pde.internal.ui.editor.ModelUndoManager.setActions(org.eclipse.jface.action.IAction;org.eclipse.jface.action.IAction;)V3
public void setActions(IAction undoAction, IAction redoAction) {
    this.undoAction = undoAction;
    this.redoAction = redoAction;
    updateActions();
}
---------------Client-------------------
method: org.eclipse.ui.internal.HeapStatus.setMark()V1
private void setMark() {
    updateStats();
    mark = usedMem;
    hasChanged = true;
    redraw();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.jres.ExecutionEnvironmentsLabelProvider.getImage(java.lang.Object;)org.eclipse.swt.graphics.Image;2
@Override
public Image getImage(Object element) {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_LIBRARY);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.memory.renderings.AsyncTableRenderingViewer.getKey(I)java.lang.Object;2
public Object getKey(int index) {
    AbstractVirtualContentTableModel model = getVirtualContentModel();
    if (model != null) {
        Object key = model.getKey(index);
        return key;
    }
    return null;
}
method: org.eclipse.debug.internal.ui.views.memory.renderings.TableRenderingModel.getKey(I)java.lang.Object;2
@Override
public Object getKey(int idx) {
    Object elmt = getElement(idx);
    if (elmt instanceof MemorySegment) {
        return ((MemorySegment) elmt).getAddress();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.views.dependencies.OpenDependenciesAction.execute(org.eclipse.core.commands.ExecutionEvent;)java.lang.Object;2
public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection = HandlerUtil.getCurrentSelection(event);
    if (selection instanceof IStructuredSelection) {
        IStructuredSelection ssel = (IStructuredSelection) selection;
        openDependencies(ssel.getFirstElement());
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.plugin.PluginObject.getWritableString(java.lang.String;)java.lang.String;2
public String getWritableString(String source) {
    return PDEXMLHelper.getWritableString(source);
}
method: org.eclipse.pde.internal.core.util.PDEXMLHelper.getWritableString(java.lang.String;)java.lang.String;1
public static String getWritableString(String source) {
    if (source == null)
        return "";
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.builders.XMLErrorReporter.getWritableString(java.lang.String;)java.lang.String;2
private String getWritableString(String source) {
    StringBuffer buf = new  StringBuffer();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch(c) {
            case '&':
                buf.append("&amp;");
                break;
            case '<':
                buf.append("&lt;");
                break;
            case '>':
                buf.append("&gt;");
                break;
            case '\'':
                buf.append("&apos;");
                break;
            case '\"':
                buf.append("&quot;");
                break;
            default:
                buf.append(c);
                break;
        }
    }
    return buf.toString();
}

---------------Library-------------------
method: org.eclipse.ui.internal.wizards.preferences.WizardPreferencesPage.dispose()V1
@Override
public void dispose() {
    super.dispose();
    transfers = null;
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
method: org.eclipse.debug.ui.actions.RulerToggleBreakpointActionDelegate.dispose()V1
@Override
public void dispose() {
    if (fDelegate != null) {
        fDelegate.dispose();
    }
    fDelegate = null;
    fEditor = null;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.AbstractTextEditor$ElementStateListener$2.run()V1
public void run() {
    enableSanityChecking(true);
    firePropertyChange(PROP_DIRTY);
}
method: org.eclipse.ui.texteditor.AbstractTextEditor.enableSanityChecking(Z)V2
protected void enableSanityChecking(boolean enable) {
    synchronized (this) {
        fIsSanityCheckEnabled = enable;
    }
}
---------------Client-------------------
method: org.eclipse.jface.text.source.projection.ProjectionSummary$Summarizer.reset()V1
public void reset() {
    synchronized (fLock) {
        fReset = true;
        fProgressMonitor.setCanceled(true);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.keys.KeyBindingState.setCurrentSequence(org.eclipse.jface.bindings.keys.KeySequence;)V2
void setCurrentSequence(KeySequence sequence) {
    currentSequence = sequence;
    updateStatusLines();
}
method: org.eclipse.ui.internal.keys.KeyBindingState.updateStatusLines()V1
private void updateStatusLines() {
    StatusLineContributionItem statusLine = getStatusLine();
    if (statusLine != null) {
        statusLine.setText(getCurrentSequence().format());
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ExtractConstantWizard$ExtractConstantInputPage.setAccessModifier(java.lang.String;)V2
private void setAccessModifier(String accessModifier) {
    getExtractConstantRefactoring().setVisibility(accessModifier);
    fAccessModifier = accessModifier;
    updateContentAssistImage();
    updatePreviewLabel();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.model.TestRunListenerAdapter.sessionStopped(J)V2
public void sessionStopped(long elapsedTime) {
    fireSessionFinished();
    fSession.swapOut();
}
method: org.eclipse.jdt.internal.junit.model.TestRunListenerAdapter.fireSessionFinished()V1
private void fireSessionFinished() {
    Object[] listeners = getListeners();
    for (int i = 0; i < listeners.length; i++) {
        ((TestRunListener) listeners[i]).sessionFinished(fSession);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction$2.menuShown(org.eclipse.swt.events.MenuEvent;)V2
@Override
public void menuShown(MenuEvent e) {
    Menu m = (Menu) e.widget;
    MenuItem[] items = m.getItems();
    for (int i = 0; i < items.length; i++) {
        items[i].dispose();
    }
    fillMenu(m);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.CodeTemplateBlock.exportAll()V1
private void exportAll() {
    export(fTemplateStore.getTemplateData());
}
method: org.eclipse.jdt.internal.ui.viewsupport.ProjectTemplateStore.getTemplateData()Aorg.eclipse.jface.text.templates.persistence.TemplatePersistenceData;1
public TemplatePersistenceData[] getTemplateData() {
    if (fProjectStore != null) {
        return fProjectStore.getTemplateData(true);
    } else {
        return fInstanceStore.getTemplateData(true);
    }
}
---------------Client-------------------
method: org.eclipse.ant.internal.launching.debug.model.AntThread.setPropertiesValid(Z)V2
private void setPropertiesValid(boolean valid) {
    if (fUserProperties != null) {
        fUserProperties.setValid(valid);
        fSystemProperties.setValid(valid);
        fRuntimeProperties.setValid(valid);
    }
}

---------------Library-------------------
method: org.eclipse.help.internal.base.HelpBasePlugin.stop(org.osgi.framework.BundleContext;)V2
public void stop(BundleContext context) throws Exception {
    BaseHelpSystem.shutdown();
    this.context = null;
    plugin = null;
    super.stop(context);
}
method: org.eclipse.core.runtime.Plugin.stop(org.osgi.framework.BundleContext;)V2
public void stop(BundleContext context) throws Exception {
    if (this.debugTracker != null) {
        this.debugTracker.close();
        this.debugTracker = null;
    }
}
---------------Client-------------------
method: org.eclipse.ecf.internal.filetransfer.Activator.stop(org.osgi.framework.BundleContext;)V2
public void stop(BundleContext ctxt) throws Exception {
    if (extensionRegistryTracker != null) {
        extensionRegistryTracker.close();
        extensionRegistryTracker = null;
    }
    plugin = null;
    this.context = null;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.core.toc.text.TocDocumentHandler.startDocument()V1
public void startDocument() throws SAXException {
    fModel.purgeErrors();
    super.startDocument();
}
method: org.eclipse.pde.internal.ua.core.toc.text.TocModel.purgeErrors()V1
public void purgeErrors() {
    if (fErrors != null) {
        fErrors.clear();
    }
}
---------------Client-------------------
method: org.apache.lucene.index.SegmentTermDocs.close()V1
public void close() throws IOException {
    freqStream.close();
    if (skipListReader != null)
        skipListReader.close();
}

---------------Library-------------------
method: org.eclipse.swt.widgets.TaskItem.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    overlayImage = null;
    overlayText = null;
}
method: org.eclipse.swt.widgets.Item.releaseWidget()V1
@Override
void releaseWidget() {
    super.releaseWidget();
    text = null;
    image = null;
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.observable.masterdetail.SetDetailValueObservableMap.dispose()V1
public synchronized void dispose() {
    super.dispose();
    observableValueFactory = null;
    detailObservableValueMap = null;
    detailStaleListener = null;
    staleDetailObservables = null;
}

---------------Library-------------------
method: org.eclipse.search2.internal.ui.text2.RetrieverAction.getActivePart()org.eclipse.ui.IWorkbenchPart;1
private IWorkbenchPart getActivePart() {
    IWorkbenchPage page = getWorkbenchPage();
    if (page != null) {
        return page.getActivePart();
    }
    return null;
}
method: org.eclipse.search2.internal.ui.text2.FindInRecentScopeActionDelegate.getWorkbenchPage()org.eclipse.ui.IWorkbenchPage;1
protected IWorkbenchPage getWorkbenchPage() {
    if (fWindow != null) {
        return fWindow.getActivePage();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.forms.widgets.FormText.getSelectionText()java.lang.String;1
public String getSelectionText() {
    checkWidget();
    if (selData != null)
        return selData.getSelectionText();
    return "";
}

---------------Library-------------------
method: org.eclipse.debug.ui.AbstractLaunchConfigurationTab.createPushButton(org.eclipse.swt.widgets.Composite;java.lang.String;org.eclipse.swt.graphics.Image;)org.eclipse.swt.widgets.Button;4
protected Button createPushButton(Composite parent, String label, Image image) {
    return SWTFactory.createPushButton(parent, label, image);
}
method: org.eclipse.debug.internal.ui.SWTFactory.createPushButton(org.eclipse.swt.widgets.Composite;java.lang.String;org.eclipse.swt.graphics.Image;)org.eclipse.swt.widgets.Button;3
public static Button createPushButton(Composite parent, String label, Image image) {
    Button button = new  Button(parent, SWT.PUSH);
    button.setFont(parent.getFont());
    if (image != null) {
        button.setImage(image);
    }
    if (label != null) {
        button.setText(label);
    }
    GridData gd = new  GridData();
    button.setLayoutData(gd);
    setButtonDimensionHint(button);
    return button;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.SWTFactory.createPushButton(org.eclipse.swt.widgets.Composite;java.lang.String;org.eclipse.swt.graphics.Image;I)org.eclipse.swt.widgets.Button;4
public static Button createPushButton(Composite parent, String label, Image image, int fill) {
    Button button = new  Button(parent, SWT.PUSH);
    button.setFont(parent.getFont());
    if (image != null) {
        button.setImage(image);
    }
    if (label != null) {
        button.setText(label);
    }
    GridData gd = new  GridData(fill);
    button.setLayoutData(gd);
    setButtonDimensionHint(button);
    return button;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.getMethodMatches(java.lang.String;java.util.List;)V2
private static void getMethodMatches(final String s, final List<Object> matches) throws InterruptedException {
    executeRunnable(new  IRunnableWithProgress() {

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            doMemberSearch(s, matches, true, true, false, monitor, 100);
        }
    });
}
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.executeRunnable(org.eclipse.jface.operation.IRunnableWithProgress;)V1
private static void executeRunnable(IRunnableWithProgress runnableWithProgress) throws InterruptedException {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnableWithProgress);
    } catch (InvocationTargetException e) {
        JDIDebugUIPlugin.log(e);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart.importTestRunSession(java.lang.String;)V1
static void importTestRunSession(final String url) {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new  IRunnableWithProgress() {

            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                JUnitModel.importTestRunSession(url, monitor);
            }
        });
    } catch (InterruptedException e) {
    } catch (InvocationTargetException e) {
        CoreException ce = (CoreException) e.getCause();
        StatusManager.getManager().handle(ce.getStatus(), StatusManager.SHOW | StatusManager.LOG);
    }
}

---------------Library-------------------
method: org.eclipse.search.internal.ui.SearchPlugin.beep()V0
public static void beep() {
    getActiveWorkbenchShell().getDisplay().beep();
}
method: org.eclipse.swt.widgets.Widget.getDisplay()org.eclipse.swt.widgets.Display;1
public Display getDisplay() {
    Display display = this.display;
    if (display == null)
        error(SWT.ERROR_WIDGET_DISPOSED);
    return display;
}
---------------Client-------------------
method: org.eclipse.equinox.p2.ui.RepositoryManipulationPage.init(org.eclipse.ui.IWorkbench;)V2
public void init(IWorkbench workbench) {
    noDefaultAndApplyButton();
    if (ui == null) {
        setProvisioningUI(ProvisioningUI.getDefaultUI());
    }
}

---------------Library-------------------
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.addClassLoaderHook(org.eclipse.osgi.internal.hookregistry.ClassLoaderHook;)V2
public void addClassLoaderHook(ClassLoaderHook classLoaderHook) {
    add(classLoaderHook, classLoaderHooks);
}
method: org.eclipse.osgi.internal.hookregistry.HookRegistry.add(java.lang.Object;java.util.List;)V3
private <H> void add(H hook, List<H> hooks) {
    if (initialized)
        throw new  IllegalStateException("Cannot add hooks dynamically.");
    hooks.add(hook);
}
---------------Client-------------------
method: org.eclipse.emf.common.command.CompoundCommand.append(org.eclipse.emf.common.command.Command;)V2
public void append(Command command) {
    if (isPrepared) {
        throw new  IllegalStateException("The command is already prepared");
    }
    if (command != null) {
        commandList.add(command);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getShell()org.eclipse.swt.widgets.Shell;1
final Shell getShell() {
    if (fEditor != null)
        return fEditor.getEditorSite().getShell();
    return JavaPlugin.getActiveWorkbenchShell();
}
method: org.eclipse.jdt.internal.ui.JavaPlugin.getActiveWorkbenchShell()org.eclipse.swt.widgets.Shell;0
public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
        return window.getShell();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.CommitWizard.getPart()org.eclipse.ui.IWorkbenchPart;1
private IWorkbenchPart getPart() {
    if (part != null)
        return part;
    return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart();
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryManager.removeTags(org.eclipse.team.internal.ccvs.core.ICVSFolder;Aorg.eclipse.team.internal.ccvs.core.CVSTag;)V3
public void removeTags(ICVSFolder project, CVSTag[] tags) throws CVSException {
    RepositoryRoot root = getRepositoryRootFor(project);
    String remotePath = RepositoryRoot.getRemotePathFor(project);
    root.removeTags(remotePath, tags);
    broadcastRepositoryChange(root);
}
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoryManager.getRepositoryRootFor(org.eclipse.team.internal.ccvs.core.ICVSResource;)org.eclipse.team.internal.ccvs.ui.repo.RepositoryRoot;2
private RepositoryRoot getRepositoryRootFor(ICVSResource resource) throws CVSException {
    ICVSRepositoryLocation location = internalGetRepositoryLocationFor(resource);
    if (location == null)
        return null;
    return getRepositoryRootFor(location);
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.wizards.ProjectSelectionPage.createControl(org.eclipse.swt.widgets.Composite;)V2
public void createControl(Composite parent) {
    Composite composite = SWTUtils.createHVFillComposite(parent, SWTUtils.MARGINS_DIALOG, 2);
    createProjectList(composite);
    createShareButton(composite);
    updateEnablements();
    setControl(composite);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseSelectors(java.io.Reader;)org.w3c.css.sac.SelectorList;2
@Override
public SelectorList parseSelectors(Reader reader) throws IOException {
    InputSource source = new  InputSource();
    source.setCharacterStream(reader);
    return parseSelectors(source);
}
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseSelectors(org.w3c.css.sac.InputSource;)org.w3c.css.sac.SelectorList;2
@Override
public SelectorList parseSelectors(InputSource source) throws IOException {
    checkInputSource(source);
    CSSParser parser = makeCSSParser();
    SelectorList list = parser.parseSelectors(source);
    return list;
}
---------------Client-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyProviderUtil.createProxy(java.lang.String;java.lang.String;I)org.eclipse.core.net.proxy.IProxyData;3
private static IProxyData createProxy(String scheme, String host, int port) {
    String type = resolveProxyType(scheme);
    ProxyData proxy = new  ProxyData(type);
    proxy.setHost(host);
    proxy.setPort(port);
    proxy.setSource("WINDOWS_IE");
    return proxy;
}

---------------Library-------------------
method: org.eclipse.team.internal.core.subscribers.CheckedInChangeSet.remove(Aorg.eclipse.core.resources.IResource;)V2
public void remove(IResource[] resources) {
    for (int i = 0; i < resources.length; i++) {
        IResource resource = resources[i];
        remove(resource);
    }
}
method: org.eclipse.team.internal.core.subscribers.CheckedInChangeSet.remove(org.eclipse.core.resources.IResource;)V2
public void remove(IResource resource) {
    if (contains(resource)) {
        set.remove(resource);
    }
}
---------------Client-------------------
method: org.eclipse.jface.viewers.deferred.BackgroundContentProvider.flush(Ajava.lang.Object;org.eclipse.jface.viewers.deferred.LazySortedCollection;)V3
private void flush(Object[] toFlush, LazySortedCollection collection) {
    for (int i = 0; i < toFlush.length; i++) {
        Object item = toFlush[i];
        if (collection.contains(item)) {
            updator.clear(item);
        }
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.ProjectLinkedResourcePage.dispose()V1
public void dispose() {
    pathVariablesGroup.dispose();
    linkedResourceEditor.dispose();
    super.dispose();
}
method: org.eclipse.ui.internal.ide.dialogs.LinkedResourceEditor.dispose()V1
public void dispose() {
    fixedImg.dispose();
    brokenImg.dispose();
    absoluteImg.dispose();
}
---------------Client-------------------
method: org.eclipse.ui.actions.TextActionHandler.updateActionsEnableState()V1
private void updateActionsEnableState() {
    textCutAction.updateEnabledState();
    textCopyAction.updateEnabledState();
    textPasteAction.updateEnabledState();
    textSelectAllAction.updateEnabledState();
    textDeleteAction.updateEnabledState();
}

---------------Library-------------------
method: org.eclipse.ui.views.navigator.ResourceNavigator.getAdapter(java.lang.Class;)java.lang.Object;2
public Object getAdapter(Class adapter) {
    if (adapter == IShowInSource.class) {
        return getShowInSource();
    }
    if (adapter == IShowInTarget.class) {
        return getShowInTarget();
    }
    return null;
}
method: org.eclipse.ui.views.navigator.ResourceNavigator.getShowInSource()org.eclipse.ui.part.IShowInSource;1
protected IShowInSource getShowInSource() {
    return new  IShowInSource() {

        public ShowInContext getShowInContext() {
            return new  ShowInContext(getViewer().getInput(), getViewer().getSelection());
        }
    };
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.callhierarchy.MethodWrapper.getAdapter(java.lang.Class;)java.lang.Object;2
@Override
public Object getAdapter(Class adapter) {
    if (adapter == IJavaElement.class) {
        return getMember();
    } else if (adapter == IWorkbenchAdapter.class) {
        return new  MethodWrapperWorkbenchAdapter(this);
    } else {
        return null;
    }
}

---------------Library-------------------
method: org.eclipse.ui.views.navigator.ResourceNavigator.getAdapter(java.lang.Class;)java.lang.Object;2
public Object getAdapter(Class adapter) {
    if (adapter == IShowInSource.class) {
        return getShowInSource();
    }
    if (adapter == IShowInTarget.class) {
        return getShowInTarget();
    }
    return null;
}
method: org.eclipse.ui.views.navigator.ResourceNavigator.getShowInTarget()org.eclipse.ui.part.IShowInTarget;1
protected IShowInTarget getShowInTarget() {
    return new  IShowInTarget() {

        public boolean show(ShowInContext context) {
            ArrayList toSelect = new  ArrayList();
            ISelection sel = context.getSelection();
            if (sel instanceof IStructuredSelection) {
                IStructuredSelection ssel = (IStructuredSelection) sel;
                for (Iterator i = ssel.iterator(); i.hasNext(); ) {
                    Object o = i.next();
                    if (o instanceof IResource) {
                        toSelect.add(o);
                    } else if (o instanceof IMarker) {
                        IResource r = ((IMarker) o).getResource();
                        if (r.getType() != IResource.ROOT) {
                            toSelect.add(r);
                        }
                    } else if (o instanceof IAdaptable) {
                        IAdaptable adaptable = (IAdaptable) o;
                        o = adaptable.getAdapter(IResource.class);
                        if (o instanceof IResource) {
                            toSelect.add(o);
                        } else {
                            o = adaptable.getAdapter(IMarker.class);
                            if (o instanceof IMarker) {
                                IResource r = ((IMarker) o).getResource();
                                if (r.getType() != IResource.ROOT) {
                                    toSelect.add(r);
                                }
                            }
                        }
                    }
                }
            }
            if (toSelect.isEmpty()) {
                Object input = context.getInput();
                if (input instanceof IAdaptable) {
                    IAdaptable adaptable = (IAdaptable) input;
                    Object o = adaptable.getAdapter(IResource.class);
                    if (o instanceof IResource) {
                        toSelect.add(o);
                    }
                }
            }
            if (!toSelect.isEmpty()) {
                selectReveal(new  StructuredSelection(toSelect));
                return true;
            }
            return false;
        }
    };
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.callhierarchy.MethodWrapper.getAdapter(java.lang.Class;)java.lang.Object;2
@Override
public Object getAdapter(Class adapter) {
    if (adapter == IJavaElement.class) {
        return getMember();
    } else if (adapter == IWorkbenchAdapter.class) {
        return new  MethodWrapperWorkbenchAdapter(this);
    } else {
        return null;
    }
}

---------------Library-------------------
method: org.eclipse.swt.browser.Mozilla.findBrowser(J)org.eclipse.swt.browser.Browser;1
static Browser findBrowser(long handle) {
    return MozillaDelegate.findBrowser(handle);
}
method: org.eclipse.swt.browser.MozillaDelegate.findBrowser(J)org.eclipse.swt.browser.Browser;1
static Browser findBrowser(long handle) {
    long parent = OS.gtk_widget_get_parent(handle);
    Display display = Display.getCurrent();
    return (Browser) display.findWidget(parent);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSPropertyFileModifier.getPropertyFile(org.eclipse.core.runtime.IPath;)org.eclipse.core.resources.IFile;1
private static IFile getPropertyFile(IPath propertyFilePath) {
    return (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(propertyFilePath);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.AbstractConfigurationBlockPreferenceAndPropertyPage.performDefaults()V1
@Override
public void performDefaults() {
    fConfigurationBlock.performDefaults();
    super.performDefaults();
}
method: org.eclipse.jdt.internal.ui.preferences.PropertyAndPreferencePage.performDefaults()V1
@Override
protected void performDefaults() {
    if (useProjectSettings()) {
        enableProjectSpecificSettings(false);
    }
    super.performDefaults();
}
---------------Client-------------------
method: org.eclipse.ui.forms.FormColors.initializeSectionToolBarColors()V1
public void initializeSectionToolBarColors() {
    if (colorRegistry.containsKey(IFormColors.TB_BG))
        return;
    createTitleBarGradientColors();
    createTitleBarOutlineColors();
    createTwistieColors();
}

---------------Library-------------------
method: org.eclipse.ui.part.MultiPageEditorPart.setFocus()V1
@Override
public void setFocus() {
    setFocus(getActivePage());
}
method: org.eclipse.ui.part.MultiPageEditorPart.getActivePage()I1
public int getActivePage() {
    CTabFolder tabFolder = getTabFolder();
    if (tabFolder != null && !tabFolder.isDisposed()) {
        return tabFolder.getSelectionIndex();
    }
    return -1;
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.AsynchronousViewer.handleSelect(org.eclipse.swt.events.SelectionEvent;)V2
@Override
protected void handleSelect(SelectionEvent event) {
    Control control = getControl();
    if (control != null && !control.isDisposed()) {
        updateSelection(newSelectionFromWidget());
    }
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.beans.PojoSetPropertyDecorator.doUpdateSet(java.lang.Object;org.eclipse.core.databinding.observable.set.SetDiff;)V3
protected void doUpdateSet(Object source, SetDiff diff) {
    delegate.updateSet(source, diff);
}
method: org.eclipse.core.databinding.property.set.SetProperty.updateSet(java.lang.Object;org.eclipse.core.databinding.observable.set.SetDiff;)V3
public final void updateSet(Object source, SetDiff diff) {
    if (source != null && !diff.isEmpty()) {
        doUpdateSet(source, diff);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.views.dependencies.DependenciesViewPage.setSelection(org.eclipse.jface.viewers.IStructuredSelection;)V2
protected void setSelection(IStructuredSelection selection) {
    if (selection != null && !selection.isEmpty())
        fViewer.setSelection(selection, true);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.operations.TagInRepositoryOperation.getTagSource()org.eclipse.team.internal.ccvs.ui.tags.TagSource;1
public TagSource getTagSource() {
    return TagSource.create(getCVSResources());
}
method: org.eclipse.team.internal.ccvs.ui.operations.RemoteOperation.getCVSResources()Aorg.eclipse.team.internal.ccvs.core.ICVSResource;1
public ICVSResource[] getCVSResources() {
    ICVSResource[] cvsResources = new ICVSResource[remoteResources.length];
    for (int i = 0; i < remoteResources.length; i++) {
        cvsResources[i] = remoteResources[i];
    }
    return cvsResources;
}
---------------Client-------------------
method: org.eclipse.osgi.internal.permadmin.SecurityTable.getEncodedRows()Ajava.lang.String;1
String[] getEncodedRows() {
    String[] encoded = new String[rows.length];
    for (int i = 0; i < rows.length; i++) encoded[i] = rows[i].getEncoded();
    return encoded;
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.JobListeners.aboutToRun(org.eclipse.core.runtime.jobs.Job;)V2
public void aboutToRun(Job job) {
    doNotify(aboutToRun, newEvent(job));
}
method: org.eclipse.core.internal.jobs.JobListeners.newEvent(org.eclipse.core.runtime.jobs.Job;)org.eclipse.core.internal.jobs.JobChangeEvent;1
static JobChangeEvent newEvent(Job job) {
    JobChangeEvent instance = new  JobChangeEvent();
    instance.job = job;
    return instance;
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory.init(org.eclipse.e4.core.contexts.IEclipseContext;)V2
@PostConstruct
public void init(IEclipseContext context) {
    this.context = context;
    this.context.set(SHARED_ELEMENTS_STORE, new  HashMap<MUIElement, Set<MPlaceholder>>());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.PDELabelProvider.getObjectImage(org.eclipse.pde.internal.core.text.bundle.PackageObject;)org.eclipse.swt.graphics.Image;2
public Image getObjectImage(PackageObject obj) {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PACKAGE);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.ClasspathUtilCore.isPatchFragment(org.eclipse.pde.core.plugin.IPluginModelBase;)Z1
public static boolean isPatchFragment(IPluginModelBase model) {
    IPluginBase pluginBase = model.getPluginBase();
    if (pluginBase instanceof IFragment)
        return isPatchFragment((IFragment) pluginBase);
    return false;
}
method: org.eclipse.pde.internal.core.ClasspathUtilCore.isPatchFragment(org.eclipse.pde.core.plugin.IFragment;)Z1
private static boolean isPatchFragment(IFragment fragment) {
    if (fragment instanceof Fragment)
        return ((Fragment) fragment).isPatch();
    if (fragment instanceof BundleFragment)
        return ((BundleFragment) fragment).isPatch();
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.Checks.isEnumCase(org.eclipse.jdt.core.dom.ASTNode;)Z1
public static boolean isEnumCase(ASTNode node) {
    if (node instanceof SwitchCase) {
        final SwitchCase caze = (SwitchCase) node;
        final Expression expression = caze.getExpression();
        if (expression instanceof Name) {
            final Name name = (Name) expression;
            final IBinding binding = name.resolveBinding();
            if (binding instanceof IVariableBinding) {
                IVariableBinding variableBinding = (IVariableBinding) binding;
                return variableBinding.isEnumConstant();
            }
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsConstraintCreator.endVisit(org.eclipse.jdt.core.dom.TypeLiteral;)V2
@Override
public void endVisit(TypeLiteral node) {
    ITypeBinding typeBinding = node.resolveTypeBinding();
    ImmutableTypeVariable2 cv = fTCModel.makeImmutableTypeVariable(typeBinding, null);
    setConstraintVariable(node, cv);
}
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsTCModel.makeImmutableTypeVariable(org.eclipse.jdt.core.dom.ITypeBinding;org.eclipse.jdt.core.dom.Expression;)org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ImmutableTypeVariable2;3
public ImmutableTypeVariable2 makeImmutableTypeVariable(ITypeBinding typeBinding, Expression expression) {
    TType type = getBoxedType(typeBinding, expression);
    if (type == null)
        return null;
    return makeImmutableTypeVariable(type);
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Project.deleteResource(ZLorg.eclipse.core.runtime.MultiStatus;)V3
public void deleteResource(boolean convertToPhantom, MultiStatus status) throws CoreException {
    super.deleteResource(convertToPhantom, status);
    clearHistory(null);
    workspace.getMetaArea().delete(this);
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSURI.ensureRegistryBasedAuthority(java.lang.String;)java.lang.String;2
private String ensureRegistryBasedAuthority(String authority) {
    authority = encode('/', '!', authority);
    authority = encode('@', '~', authority);
    authority = encode(':', '_', authority);
    return authority;
}
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSURI.encode(CCLjava.lang.String;)java.lang.String;4
private String encode(char charToEncode, char encoding, String string) {
    String result = string.replaceAll(new  String(new char[] { encoding }), new  String(new char[] { encoding, encoding }));
    return result.replace(charToEncode, encoding);
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSURI.decode(CCLjava.lang.String;)java.lang.String;3
private static String decode(char encodedChar, char encoding, String string) {
    String reuslt = string.replace(encoding, encodedChar);
    return reuslt.replaceAll(new  String(new char[] { encodedChar, encodedChar }), new  String(new char[] { encoding }));
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Button.releaseHandle()V1
@Override
void releaseHandle() {
    super.releaseHandle();
    boxHandle = imageHandle = labelHandle = arrowHandle = 0;
}
method: org.eclipse.swt.widgets.Control.releaseHandle()V1
@Override
void releaseHandle() {
    super.releaseHandle();
    fixedHandle = 0;
    parent = null;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.TableColumn.releaseHandle()V1
@Override
void releaseHandle() {
    super.releaseHandle();
    handle = buttonHandle = labelHandle = imageHandle = 0;
    modelIndex = -1;
    parent = null;
}

---------------Library-------------------
method: org.eclipse.jface.fieldassist.DecoratedField$1.mouseExit(org.eclipse.swt.events.MouseEvent;)V2
@Override
public void mouseExit(MouseEvent event) {
    hideHover();
}
method: org.eclipse.jface.fieldassist.DecoratedField.hideHover()V1
public void hideHover() {
    if (hover != null) {
        hover.setVisible(false);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.AddSourceFolderWizardPage$LinkFields.dialogFieldChanged(org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;)V2
public void dialogFieldChanged(DialogField field) {
    if (fAdapter != null) {
        fAdapter.dialogFieldChanged(fLinkLocation);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.MethodDeclaration.thrownExceptions()java.util.List;1
public List thrownExceptions() {
    return internalThrownExceptions();
}
method: org.eclipse.jdt.core.dom.MethodDeclaration.internalThrownExceptions()java.util.List;1
List internalThrownExceptions() {
    if (this.thrownExceptions == null) {
        supportedOnlyIn2_3_4();
    }
    return this.thrownExceptions;
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.ProjectDescription.getLocation()org.eclipse.core.runtime.IPath;1
public IPath getLocation() {
    if (location == null)
        return null;
    return FileUtil.toPath(location);
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.properties.providers.CSSPropertyHandlerLazyProviderImpl.getCSSProperties(java.lang.Object;)java.util.Collection;2
@Override
public Collection<String> getCSSProperties(Object element) {
    Map<String, List<ICSSPropertyHandler>> propertyHandlers = getPropertyToHandlersMap();
    return propertyHandlers.keySet();
}
method: org.eclipse.e4.ui.css.core.dom.properties.providers.CSSPropertyHandlerLazyProviderImpl.getPropertyToHandlersMap()java.util.Map;1
protected Map<String, List<ICSSPropertyHandler>> getPropertyToHandlersMap() {
    if (propertyToHandlersMap == null)
        propertyToHandlersMap = new  HashMap<String, List<ICSSPropertyHandler>>();
    return propertyToHandlersMap;
}
---------------Client-------------------
method: org.eclipse.pde.api.tools.internal.search.UseReportConverter.getReportsRoot()java.io.File;1
protected File getReportsRoot() {
    if (this.reportsRoot == null) {
        this.reportsRoot = new  File(getXmlLocation());
    }
    return this.reportsRoot;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.product.UpdatesSection.modelChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
public void modelChanged(IModelChangedEvent e) {
    fRepositoryTable.setInput(getProduct());
    fRepositoryTable.refresh();
    updateButtons();
    clearEditors();
}
method: org.eclipse.pde.internal.ui.editor.product.UpdatesSection.clearEditors()V1
private void clearEditors() {
    Control oldEditor = fEnabledColumnEditor.getEditor();
    if (oldEditor != null && !oldEditor.isDisposed())
        oldEditor.dispose();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.callhierarchy.DeferredMethodWrapper$1.run()V1
public void run() {
    CallHierarchyViewPart viewPart = fProvider.getViewPart();
    if (viewPart != null && !viewPart.getViewer().getControl().isDisposed())
        fProvider.collapseAndRefresh(methodWrapper);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.nls.ExternalizeWizardPage.getNextPage()org.eclipse.jface.wizard.IWizardPage;1
@Override
public IWizardPage getNextPage() {
    return super.getNextPage();
}
method: org.eclipse.ltk.ui.refactoring.UserInputWizardPage.getNextPage()org.eclipse.jface.wizard.IWizardPage;1
public IWizardPage getNextPage() {
    if (fIsLastUserInputPage)
        return computeSuccessorPage();
    else
        return super.getNextPage();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.RenameTypeWizardSimilarElementsPage.getPreviousPage()org.eclipse.jface.wizard.IWizardPage;1
@Override
public IWizardPage getPreviousPage() {
    if (fWasInitialized)
        initializeRefFromUI();
    return super.getPreviousPage();
}

---------------Library-------------------
method: org.eclipse.team.core.Team.createMerger(org.eclipse.core.runtime.content.IContentType;)org.eclipse.team.core.mapping.IStorageMerger;1
public static IStorageMerger createMerger(IContentType type) {
    return StorageMergerRegistry.getInstance().createStreamMerger(type);
}
method: org.eclipse.team.internal.core.StorageMergerRegistry.getInstance()org.eclipse.team.internal.core.StorageMergerRegistry;0
public static StorageMergerRegistry getInstance() {
    if (instance == null) {
        instance = new  StorageMergerRegistry();
    }
    return instance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ClassFile.isInterface()Z1
public boolean isInterface() throws JavaModelException {
    return getType().isInterface();
}
method: org.eclipse.jdt.internal.core.ClassFile.getType()org.eclipse.jdt.core.IType;1
public IType getType() {
    if (this.binaryType == null) {
        this.binaryType = new  BinaryType(this, getTypeName());
    }
    return this.binaryType;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.plugin.Extensions.isValid()Z1
public boolean isValid() {
    if (fValid == null) {
        fValid = new  Boolean(hasRequiredAttributes());
    }
    return fValid.booleanValue();
}

---------------Library-------------------
method: org.eclipse.ui.views.markers.internal.DialogMarkerProperties.updateEnablement()V1
protected void updateEnablement() {
    descriptionText.setEditable(isEditable());
}
method: org.eclipse.ui.views.markers.internal.DialogMarkerProperties.isEditable()Z1
protected boolean isEditable() {
    if (marker == null) {
        return true;
    }
    return Util.isEditable(marker);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.callhierarchy.CallHierarchyViewer.cancelJobs()V1
void cancelJobs() {
    if (fPart == null)
        return;
    fContentProvider.cancelJobs(fPart.getCurrentMethodWrappers());
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.compare.PluginStructureCreator$1.dispose()V1
public void dispose() {
    labelProvider.dispose();
    resources.dispose();
    super.dispose();
}
method: org.eclipse.compare.structuremergeviewer.StructureRootNode.dispose()V1
public void dispose() {
    if (fAdapter != null) {
        fAdapter.disconnect(fInput);
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.browser.BrowserViewer$2.changed(org.eclipse.swt.browser.StatusTextEvent;)V2
public void changed(StatusTextEvent event) {
    if (container != null) {
        IStatusLineManager status = container.getActionBars().getStatusLineManager();
        status.setMessage(event.text);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.jres.JREsLabelProvider.getImage(java.lang.Object;)org.eclipse.swt.graphics.Image;2
@Override
public Image getImage(Object element) {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_LIBRARY);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.feature.IdentifiableObject.parse(org.w3c.dom.Node;)V2
protected void parse(Node node) {
    super.parse(node);
    id = getNodeAttribute(node, "id");
}
method: org.eclipse.pde.internal.core.feature.FeatureObject.getNodeAttribute(org.w3c.dom.Node;java.lang.String;)java.lang.String;3
String getNodeAttribute(Node node, String name) {
    Node attribute = node.getAttributes().getNamedItem(name);
    if (attribute != null)
        return attribute.getNodeValue();
    return null;
}
---------------Client-------------------
method: org.eclipse.team.ui.synchronize.AbstractSynchronizeParticipant.init(java.lang.String;org.eclipse.ui.IMemento;)V3
public void init(String secondaryId, IMemento memento) throws PartInitException {
    setSecondaryId(secondaryId);
    pinned = Boolean.valueOf(memento.getString(CTX_PINNED)).booleanValue();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.PackageDeclaration;)V2
@Override
public void endVisit(PackageDeclaration node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getName());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.jface.text.JFaceTextUtil.getPartialBottomIndex(org.eclipse.jface.text.ITextViewer;)I1
public static int getPartialBottomIndex(ITextViewer viewer) {
    StyledText textWidget = viewer.getTextWidget();
    int widgetBottom = getPartialBottomIndex(textWidget);
    return widgetLine2ModelLine(viewer, widgetBottom);
}
method: org.eclipse.jface.text.JFaceTextUtil.getPartialBottomIndex(org.eclipse.swt.custom.StyledText;)I1
public static int getPartialBottomIndex(StyledText widget) {
    int lastPixel = computeLastVisiblePixel(widget);
    int bottom = widget.getLineIndex(lastPixel);
    return bottom;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.ImportReferencesCollector.visit(org.eclipse.jdt.core.dom.CreationReference;)Z2
@Override
public boolean visit(CreationReference node) {
    doVisitNode(node.getType());
    doVisitChildren(node.typeArguments());
    return false;
}

---------------Library-------------------
method: org.eclipse.e4.ui.internal.workbench.swt.WorkbenchSWTActivator.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    if (context == null)
        return null;
    return context.getBundle();
}
method: org.eclipse.osgi.internal.framework.BundleContextImpl.getBundle()org.osgi.framework.Bundle;1
public Bundle getBundle() {
    checkValid();
    return getBundleImpl();
}
---------------Client-------------------
method: org.eclipse.pde.core.target.TargetFeature.getId()java.lang.String;1
public String getId() {
    if (featureModel == null)
        return null;
    return featureModel.getFeature().getId();
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.MethodDeclaration;)Z2
public boolean visit(MethodDeclaration node) {
    visitBodyDeclaration(node);
    return true;
}
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visitBodyDeclaration(org.eclipse.jdt.core.dom.BodyDeclaration;)V2
private void visitBodyDeclaration(final BodyDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.apt.core.internal.util.Visitors$AnnotatedNodeVisitor.visit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)Z2
public boolean visit(SingleVariableDeclaration node) {
    final List<IExtendedModifier> extMods = node.modifiers();
    List<Annotation> annos = null;
    for (IExtendedModifier extMod : extMods) {
        if (extMod.isAnnotation()) {
            if (annos == null) {
                annos = new  ArrayList<Annotation>(2);
                _result.put(node, annos);
            }
            annos.add((Annotation) extMod);
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.LinkedResourcesPreferencePage.dispose()V1
public void dispose() {
    pathVariablesGroup.dispose();
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
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.LinkedResourcesPreferencePage.dispose()V1
public void dispose() {
    pathVariablesGroup.dispose();
    super.dispose();
}
method: org.eclipse.ui.internal.ide.dialogs.PathVariablesGroup.dispose()V1
public void dispose() {
    if (imageUnkown != null) {
        imageUnkown.dispose();
        imageUnkown = null;
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.CommentTemplateEditDialog.validateInput()V1
protected void validateInput() {
    String errorMessage = null;
    if (validator != null) {
        errorMessage = validator.isValid(text.getText());
    }
    setErrorMessage(errorMessage);
}
method: org.eclipse.team.internal.ccvs.ui.CommentTemplateEditDialog.setErrorMessage(java.lang.String;)V2
public void setErrorMessage(String errorMessage) {
    errorMessageText.setText(errorMessage == null ? "" : errorMessage);
    okButton.setEnabled(errorMessage == null);
    errorMessageText.getParent().update();
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.actions.variables.ChangeVariableValueInputDialog.validateInput()V1
protected void validateInput() {
    String errorMessage = null;
    if (validator != null) {
        errorMessage = validator.isValid(text.getText());
    }
    errorMessageLabel.setText(errorMessage == null ? IInternalDebugCoreConstants.EMPTY_STRING : errorMessage);
    okButton.setEnabled(errorMessage == null);
    errorMessageLabel.getParent().update();
}

---------------Library-------------------
method: org.eclipse.swt.graphics.TextLayout.getTextDirection()I1
public int getTextDirection() {
    return getOrientation();
}
method: org.eclipse.swt.graphics.TextLayout.getOrientation()I1
public int getOrientation() {
    checkLayout();
    int baseDir = OS.pango_context_get_base_dir(context);
    return baseDir == OS.PANGO_DIRECTION_RTL ? SWT.RIGHT_TO_LEFT : SWT.LEFT_TO_RIGHT;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Spinner.getTextLimit()I1
public int getTextLimit() {
    checkWidget();
    int limit = OS.gtk_entry_get_max_length(handle);
    return limit == 0 ? 0xFFFF : limit;
}

---------------Library-------------------
method: org.eclipse.ui.internal.cheatsheets.CheatSheetHistory.add(java.lang.String;)V2
public void add(String id) {
    CheatSheetElement element = reg.findCheatSheet(id);
    if (element != null)
        add(element);
}
method: org.eclipse.ui.internal.cheatsheets.registry.CheatSheetRegistryReader.findCheatSheet(java.lang.String;)org.eclipse.ui.internal.cheatsheets.registry.CheatSheetElement;2
public CheatSheetElement findCheatSheet(String id) {
    Object[] cheatsheetsList = getCheatSheets().getChildren();
    for (int nX = 0; nX < cheatsheetsList.length; nX++) {
        CheatSheetCollectionElement collection = (CheatSheetCollectionElement) cheatsheetsList[nX];
        CheatSheetElement element = collection.findCheatSheet(id, true);
        if (element != null)
            return element;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.select.SelectionOnArgumentName.resolve(org.eclipse.jdt.internal.compiler.lookup.BlockScope;)V2
public void resolve(BlockScope scope) {
    super.resolve(scope);
    throw new  SelectionNodeFound(this.binding);
}

---------------Library-------------------
method: org.eclipse.e4.core.internal.di.osgi.LogHelper.logWarning(java.lang.String;java.lang.Throwable;)V2
public static void logWarning(String msg, Throwable e) {
    log(msg, FrameworkLogEntry.WARNING, e);
}
method: org.eclipse.e4.core.internal.di.osgi.LogHelper.log(java.lang.String;ILjava.lang.Throwable;)V3
public static void log(String msg, int severity, Throwable e) {
    FrameworkLog log = DIActivator.getDefault().getFrameworkLog();
    FrameworkLogEntry logEntry = new  FrameworkLogEntry(plugin_name, severity, 0, msg, 0, e, null);
    log.log(logEntry);
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.preferences.AddToJavaSearchJob.clearAll()V0
public static void clearAll() {
    Job.getJobManager().cancel(JOB_FAMILY_ID);
    AddToJavaSearchJob job = new  AddToJavaSearchJob(null, false);
    job.schedule();
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.refactoring.PDERenameParticipant.addBundleManifestChange(org.eclipse.ltk.core.refactoring.CompositeChange;org.eclipse.core.runtime.IProgressMonitor;)V3
protected void addBundleManifestChange(CompositeChange result, IProgressMonitor pm) throws CoreException {
    addBundleManifestChange(PDEProject.getManifest(fProject), result, pm);
}
method: org.eclipse.pde.internal.ui.refactoring.PDERenameParticipant.addBundleManifestChange(org.eclipse.core.resources.IFile;org.eclipse.ltk.core.refactoring.CompositeChange;org.eclipse.core.runtime.IProgressMonitor;)V4
protected void addBundleManifestChange(IFile file, CompositeChange result, IProgressMonitor pm) throws CoreException {
    if (file.exists()) {
        Change change = BundleManifestChange.createRenameChange(file, fElements.keySet().toArray(), getNewNames(), pm);
        if (change != null)
            result.add(change);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.refactoring.PDERenameParticipant.addBuildPropertiesChange(org.eclipse.ltk.core.refactoring.CompositeChange;org.eclipse.core.runtime.IProgressMonitor;)V3
protected void addBuildPropertiesChange(CompositeChange result, IProgressMonitor pm) throws CoreException {
    IFile file = PDEProject.getBuildProperties(fProject);
    if (file.exists()) {
        Change change = BuildPropertiesChange.createRenameChange(file, fElements.keySet().toArray(), getNewNames(), pm);
        if (change != null)
            result.add(change);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.getNameMatches(java.lang.String;java.util.List;)V2
private static void getNameMatches(final String s, final List<Object> matches) throws InterruptedException {
    executeRunnable(new  IRunnableWithProgress() {

        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            SubMonitor progress = SubMonitor.convert(monitor, 100);
            progress.beginTask(TASK_NAME, 100);
            doTypeSearch(s, matches, progress.newChild(34));
            doMemberSearch(s, matches, true, false, true, progress.newChild(34), 66);
        }
    });
}
method: org.eclipse.jdt.internal.debug.ui.actions.OpenFromClipboardAction.executeRunnable(org.eclipse.jface.operation.IRunnableWithProgress;)V1
private static void executeRunnable(IRunnableWithProgress runnableWithProgress) throws InterruptedException {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnableWithProgress);
    } catch (InvocationTargetException e) {
        JDIDebugUIPlugin.log(e);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart.importTestRunSession(java.lang.String;)V1
static void importTestRunSession(final String url) {
    try {
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new  IRunnableWithProgress() {

            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                JUnitModel.importTestRunSession(url, monitor);
            }
        });
    } catch (InterruptedException e) {
    } catch (InvocationTargetException e) {
        CoreException ce = (CoreException) e.getCause();
        StatusManager.getManager().handle(ce.getStatus(), StatusManager.SHOW | StatusManager.LOG);
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.views.markers.BookmarksView.getUndoContext()org.eclipse.core.commands.operations.IUndoContext;1
protected IUndoContext getUndoContext() {
    return WorkspaceUndoUtil.getBookmarksUndoContext();
}
method: org.eclipse.ui.ide.undo.WorkspaceUndoUtil.getBookmarksUndoContext()org.eclipse.core.commands.operations.IUndoContext;0
public static IUndoContext getBookmarksUndoContext() {
    if (bookmarksUndoContext == null) {
        bookmarksUndoContext = new  ObjectUndoContext(new  Object(), "Bookmarks Context");
        bookmarksUndoContext.addMatch(getWorkspaceUndoContext());
    }
    return bookmarksUndoContext;
}
---------------Client-------------------
method: org.eclipse.debug.ui.DebugUITools.getBreakpointsUndoContext()org.eclipse.core.commands.operations.IUndoContext;0
public static synchronized IUndoContext getBreakpointsUndoContext() {
    if (fgBreakpointsUndoContext == null) {
        fgBreakpointsUndoContext = new  ObjectUndoContext(new  Object(), "Breakpoints Context");
        fgBreakpointsUndoContext.addMatch(WorkspaceUndoUtil.getWorkspaceUndoContext());
    }
    return fgBreakpointsUndoContext;
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
method: org.eclipse.ui.internal.console.ConsoleDropDownAction.dispose()V1
@Override
public void dispose() {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fView = null;
    ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.wizards.tools.UpdateBuildpathWizardPage.dispose()V1
public void dispose() {
    super.dispose();
    PDEPlugin.getDefault().getLabelProvider().disconnect(this);
}
method: org.eclipse.pde.internal.ui.PDEPlugin.getLabelProvider()org.eclipse.pde.internal.ui.PDELabelProvider;1
public PDELabelProvider getLabelProvider() {
    if (fLabelProvider == null)
        fLabelProvider = new  PDELabelProvider();
    return fLabelProvider;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.pde.internal.runtime.registry.RegistryBrowser$17.run()V1
public void run() {
    fTreeViewer.collapseAll();
}
method: org.eclipse.jface.viewers.AbstractTreeViewer.collapseAll()V1
public void collapseAll() {
    Object root = getRoot();
    if (root != null) {
        collapseToLevel(root, ALL_LEVELS);
    }
}
---------------Client-------------------
method: org.eclipse.ui.actions.CopyProjectAction.displayError(java.lang.String;)V2
void displayError(String message) {
    MessageDialog.openError(this.shellProvider.getShell(), getErrorsTitle(), message);
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.ResourceModelProviderOperation.getTargetDiffs()Aorg.eclipse.team.core.diff.IDiff;1
protected IDiff[] getTargetDiffs() {
    return getFileDeltas(getTreePathsOrElements());
}
method: org.eclipse.team.internal.ui.mapping.ResourceModelProviderOperation.getTreePathsOrElements()Ajava.lang.Object;1
private Object[] getTreePathsOrElements() {
    if (selection instanceof ITreeSelection) {
        ITreeSelection ts = (ITreeSelection) selection;
        return ts.getPaths();
    }
    return getElements();
}
---------------Client-------------------
method: org.eclipse.ui.internal.dialogs.ViewLabelProvider.getForeground(java.lang.Object;)org.eclipse.swt.graphics.Color;2
@Override
public Color getForeground(Object element) {
    if (element instanceof IViewDescriptor) {
        IWorkbenchPage activePage = window.getActivePage();
        if (activePage != null) {
            if (activePage.findViewReference(((IViewDescriptor) element).getId()) != null) {
                return dimmedForeground;
            }
        }
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.SynchronizeModelProvider.handleChanges(org.eclipse.team.core.synchronize.ISyncInfoTreeChangeEvent;org.eclipse.core.runtime.IProgressMonitor;)V3
protected final void handleChanges(ISyncInfoTreeChangeEvent event, IProgressMonitor monitor) {
    super.handleChanges(event, monitor);
}
method: org.eclipse.team.internal.ui.synchronize.AbstractSynchronizeModelProvider.handleChanges(org.eclipse.team.core.synchronize.ISyncInfoTreeChangeEvent;org.eclipse.core.runtime.IProgressMonitor;)V3
protected void handleChanges(ISyncInfoTreeChangeEvent event, IProgressMonitor monitor) {
    handleResourceChanges(event);
    handleResourceRemovals(event);
    handleResourceAdditions(event);
}
---------------Client-------------------
method: org.eclipse.jdt.ui.actions.DeclarationsSearchGroup.registerAction(org.eclipse.jdt.ui.actions.SelectionDispatchAction;org.eclipse.jface.viewers.ISelectionProvider;org.eclipse.jface.viewers.ISelection;org.eclipse.jface.viewers.ISelectionProvider;)V5
private void registerAction(SelectionDispatchAction action, ISelectionProvider provider, ISelection selection, ISelectionProvider specialSelectionProvider) {
    action.update(selection);
    provider.addSelectionChangedListener(action);
    if (specialSelectionProvider != null)
        action.setSpecialSelectionProvider(specialSelectionProvider);
}

---------------Library-------------------
method: org.eclipse.debug.core.model.RuntimeProcess.fireTerminateEvent()V1
protected void fireTerminateEvent() {
    fireEvent(new  DebugEvent(this, DebugEvent.TERMINATE));
}
method: org.eclipse.debug.core.model.RuntimeProcess.fireEvent(org.eclipse.debug.core.DebugEvent;)V2
protected void fireEvent(DebugEvent event) {
    DebugPlugin manager = DebugPlugin.getDefault();
    if (manager != null) {
        manager.fireDebugEventSet(new DebugEvent[] { event });
    }
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.actions.expressions.EnableWatchExpressionAction.fireWatchExpressionChanged(org.eclipse.debug.core.model.IWatchExpression;)V2
private void fireWatchExpressionChanged(IWatchExpression expression) {
    DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { new  DebugEvent(expression, DebugEvent.CHANGE) });
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.FilteredTree.clearText()V1
protected void clearText() {
    setFilterText("");
    textChanged();
}
method: org.eclipse.ui.dialogs.FilteredTree.setFilterText(java.lang.String;)V2
protected void setFilterText(String string) {
    if (filterText != null) {
        filterText.setText(string);
        selectAll();
    }
}
---------------Client-------------------
method: org.eclipse.debug.ui.memory.AbstractTableRendering.updateLabels()V1
@Override
public void updateLabels() {
    updateRenderingLabel(true);
    if (fTableViewer != null) {
        setColumnHeadings();
        fTableViewer.refresh();
    }
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl.setTypedKey(java.lang.String;)V2
public void setTypedKey(String newKey) {
    setTypedKeyGen(newKey == null ? null : newKey.intern());
}
method: org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl.setTypedKeyGen(java.lang.String;)V2
public void setTypedKeyGen(String newKey) {
    String oldKey = key;
    key = newKey;
    if (eNotificationRequired())
        eNotify(new  ENotificationImpl(this, Notification.SET, EcorePackage.ESTRING_TO_STRING_MAP_ENTRY__KEY, oldKey, key));
}
---------------Client-------------------
method: org.eclipse.e4.ui.model.application.impl.ApplicationElementImpl.setContributorURI(java.lang.String;)V2
public void setContributorURI(String newContributorURI) {
    String oldContributorURI = contributorURI;
    contributorURI = (newContributorURI == null) ? null : newContributorURI.intern();
    if (eNotificationRequired())
        eNotify(new  ENotificationImpl(this, Notification.SET, ApplicationPackageImpl.APPLICATION_ELEMENT__CONTRIBUTOR_URI, oldContributorURI, contributorURI));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeZeroTypeAnnotations()V1
protected void consumeZeroTypeAnnotations() {
    pushOnTypeAnnotationLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnTypeAnnotationLengthStack(I)V2
protected void pushOnTypeAnnotationLengthStack(int pos) {
    int stackLength = this.typeAnnotationLengthStack.length;
    if (++this.typeAnnotationLengthPtr >= stackLength) {
        System.arraycopy(this.typeAnnotationLengthStack, 0, this.typeAnnotationLengthStack = new int[stackLength + TypeAnnotationStackIncrement], 0, stackLength);
    }
    this.typeAnnotationLengthStack[this.typeAnnotationLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnAstLengthStack(I)V2
protected void pushOnAstLengthStack(int pos) {
    int stackLength = this.astLengthStack.length;
    if (++this.astLengthPtr >= stackLength) {
        System.arraycopy(this.astLengthStack, 0, this.astLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.astLengthStack[this.astLengthPtr] = pos;
}

---------------Library-------------------
method: org.eclipse.ui.dialogs.FileSelectionDialog$1.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    selectionGroup.setAllSelections(true);
}
method: org.eclipse.ui.internal.ide.misc.CheckboxTreeAndListGroup.setAllSelections(Z)V2
public void setAllSelections(final boolean selection) {
    BusyIndicator.showWhile(treeViewer.getControl().getDisplay(), new  Runnable() {

        public void run() {
            setTreeChecked(root, selection);
            listViewer.setAllChecked(selection);
        }
    });
}
---------------Client-------------------
method: org.eclipse.debug.internal.ui.viewers.breadcrumb.TreeViewerDropDown$5.treeExpanded(org.eclipse.jface.viewers.TreeExpansionEvent;)V2
@Override
public void treeExpanded(TreeExpansionEvent event) {
    tree.setRedraw(false);
    new  UIJob(tree.getDisplay(), IInternalDebugCoreConstants.EMPTY_STRING) {

        {
            setSystem(true);
        }

        @Override
        public IStatus runInUIThread(IProgressMonitor monitor) {
            if (!tree.isDisposed()) {
                try {
                    fDropDownSite.updateSize();
                } finally {
                    tree.setRedraw(true);
                }
            }
            return Status.OK_STATUS;
        }
    }.schedule();
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseSelectors(java.io.InputStream;)org.w3c.css.sac.SelectorList;2
@Override
public SelectorList parseSelectors(InputStream stream) throws IOException {
    InputSource source = new  InputSource();
    source.setByteStream(stream);
    return parseSelectors(source);
}
method: org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine.parseSelectors(org.w3c.css.sac.InputSource;)org.w3c.css.sac.SelectorList;2
@Override
public SelectorList parseSelectors(InputSource source) throws IOException {
    checkInputSource(source);
    CSSParser parser = makeCSSParser();
    SelectorList list = parser.parseSelectors(source);
    return list;
}
---------------Client-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyProviderUtil.createProxy(java.lang.String;java.lang.String;I)org.eclipse.core.net.proxy.IProxyData;3
private static IProxyData createProxy(String scheme, String host, int port) {
    String type = resolveProxyType(scheme);
    ProxyData proxy = new  ProxyData(type);
    proxy.setHost(host);
    proxy.setPort(port);
    proxy.setSource("WINDOWS_IE");
    return proxy;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyForUpdateopt()V1
protected void consumeEmptyForUpdateopt() {
    pushOnExpressionStackLengthStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnExpressionStackLengthStack(I)V2
protected void pushOnExpressionStackLengthStack(int pos) {
    int stackLength = this.expressionLengthStack.length;
    if (++this.expressionLengthPtr >= stackLength) {
        System.arraycopy(this.expressionLengthStack, 0, this.expressionLengthStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.expressionLengthStack[this.expressionLengthPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.AbstractTextEditor$ElementStateListener$5.run()V1
public void run() {
    enableSanityChecking(true);
    close(false);
}
method: org.eclipse.ui.texteditor.AbstractTextEditor.enableSanityChecking(Z)V2
protected void enableSanityChecking(boolean enable) {
    synchronized (this) {
        fIsSanityCheckEnabled = enable;
    }
}
---------------Client-------------------
method: org.eclipse.jface.text.source.projection.ProjectionSummary$Summarizer.reset()V1
public void reset() {
    synchronized (fLock) {
        fReset = true;
        fProgressMonitor.setCanceled(true);
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.FlatModelProvider.handleResourceRemovals(org.eclipse.team.core.synchronize.ISyncInfoTreeChangeEvent;)V2
protected void handleResourceRemovals(ISyncInfoTreeChangeEvent event) {
    IResource[] resources = event.getRemovedResources();
    removeFromViewer(resources);
}
method: org.eclipse.team.internal.ui.synchronize.SynchronizeModelProvider.removeFromViewer(Aorg.eclipse.core.resources.IResource;)V2
protected void removeFromViewer(IResource[] resources) {
    List elements = new  ArrayList();
    for (int i = 0; i < resources.length; i++) {
        IResource resource = resources[i];
        ISynchronizeModelElement element = getModelObject(resource);
        if (element != null) {
            elements.add(element);
        }
    }
    if (!elements.isEmpty()) {
        removeFromViewer((ISynchronizeModelElement[]) elements.toArray(new ISynchronizeModelElement[elements.size()]));
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.core.subscribers.ActiveChangeSet.add(Aorg.eclipse.core.resources.IResource;)V2
public void add(IResource[] resources) throws CoreException {
    List toAdd = new  ArrayList();
    for (int i = 0; i < resources.length; i++) {
        IResource resource = resources[i];
        IDiff diff = getManager().getDiff(resource);
        if (diff != null) {
            toAdd.add(diff);
        }
    }
    if (!toAdd.isEmpty()) {
        add((IDiff[]) toAdd.toArray(new IDiff[toAdd.size()]));
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.ExtractConstantWizard$ExtractConstantInputPage.saveBooleanSetting(java.lang.String;org.eclipse.swt.widgets.Button;)V3
private void saveBooleanSetting(String key, Button checkBox) {
    if (checkBox != null)
        getRefactoringSettings().put(key, checkBox.getSelection());
}
method: org.eclipse.ltk.ui.refactoring.RefactoringWizardPage.getRefactoringSettings()org.eclipse.jface.dialogs.IDialogSettings;1
protected IDialogSettings getRefactoringSettings() {
    IDialogSettings settings = getDialogSettings();
    if (settings == null)
        return null;
    IDialogSettings result = settings.getSection(REFACTORING_SETTINGS);
    if (result == null) {
        result = new  DialogSettings(REFACTORING_SETTINGS);
        settings.addSection(result);
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Text.addSegmentListener(org.eclipse.swt.events.SegmentListener;)V2
public void addSegmentListener(SegmentListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    addListener(SWT.Segments, new  TypedListener(listener));
    clearSegments(true);
    applySegments();
}

---------------Library-------------------
method: org.eclipse.jface.text.rules.DefaultPartitioner.getLegalContentTypes()Ajava.lang.String;1
public String[] getLegalContentTypes() {
    return TextUtilities.copy(fLegalContentTypes);
}
method: org.eclipse.jface.text.TextUtilities.copy(Ajava.lang.String;)Ajava.lang.String;1
public static String[] copy(String[] array) {
    if (array != null) {
        String[] copy = new String[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.getSelectedResources()Aorg.eclipse.core.resources.IResource;1
IResource[] getSelectedResources() {
    IResource[] selected = selectedResources;
    IResource[] resources = new IResource[selected.length];
    System.arraycopy(selected, 0, resources, 0, selected.length);
    return resources;
}

---------------Library-------------------
method: org.eclipse.swt.internal.image.PngDecodingDataStream.assertImageDataAtEnd()V1
void assertImageDataAtEnd() throws IOException {
    lzBlockReader.assertCompressedDataAtEnd();
}
method: org.eclipse.swt.internal.image.PngLzBlockReader.assertCompressedDataAtEnd()V1
void assertCompressedDataAtEnd() throws IOException {
    assertBlockAtEnd();
    while (!isLastBlock) {
        readNextBlockHeader();
        assertBlockAtEnd();
    }
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Combo.setListVisible(Z)V2
public void setListVisible(boolean visible) {
    checkWidget();
    if (visible) {
        OS.gtk_combo_box_popup(handle);
    } else {
        OS.gtk_combo_box_popdown(handle);
    }
}

---------------Library-------------------
method: org.eclipse.help.ui.internal.search.LocalHelpPage$5.checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent;)V2
public void checkStateChanged(CheckStateChangedEvent event) {
    handleCheckStateChange(event, criteriaTree, criteriaTreeContentProvider);
}
method: org.eclipse.help.ui.internal.search.LocalHelpPage.handleCheckStateChange(org.eclipse.jface.viewers.CheckStateChangedEvent;org.eclipse.jface.viewers.CheckboxTreeViewer;org.eclipse.jface.viewers.ITreeContentProvider;)V4
void handleCheckStateChange(final CheckStateChangedEvent event, final CheckboxTreeViewer tree, final ITreeContentProvider contentProvider) {
    BusyIndicator.showWhile(getShell().getDisplay(), new  Runnable() {

        public void run() {
            Object element = event.getElement();
            boolean state = event.getChecked();
            tree.setGrayed(element, false);
            if (isExpandable(element, contentProvider))
                setSubtreeChecked(element, state, state, tree, contentProvider);
            updateParentState(element, state, tree, contentProvider);
        }
    });
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.repo.RepositoriesView$1$1.run()V1
public void run() {
    refreshViewer();
    getViewer().setSelection(new  StructuredSelection(root));
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginDocumentHandler.startDocument()V1
public void startDocument() throws SAXException {
    super.startDocument();
    fSchemaVersion = null;
}
method: org.eclipse.pde.internal.core.text.DocumentHandler.startDocument()V1
public void startDocument() throws SAXException {
    fDocumentNodeStack.clear();
    fHighestOffset = 0;
    fLastError = null;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.Bucket.flush()V1
public void flush() {
    projectName = null;
    location = null;
    entries.clear();
    needSaving = false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.JUnitAddLibraryProposal.getImage()org.eclipse.swt.graphics.Image;1
public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_LIBRARY);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.value.ComputedValue.addChangeListener(org.eclipse.core.databinding.observable.IChangeListener;)V2
public synchronized void addChangeListener(IChangeListener listener) {
    super.addChangeListener(listener);
    computeValueForListeners();
}
method: org.eclipse.core.databinding.observable.value.ComputedValue.computeValueForListeners()V1
private void computeValueForListeners() {
    getRealm().exec(new  Runnable() {

        public void run() {
            if (dependencies == null) {
                if (hasListeners()) {
                    getValue();
                }
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.viewers.StructuredViewer.addDragSupport(IAorg.eclipse.swt.dnd.Transfer;org.eclipse.swt.dnd.DragSourceListener;)V4
public void addDragSupport(int operations, Transfer[] transferTypes, DragSourceListener listener) {
    Control myControl = getControl();
    final DragSource dragSource = new  DragSource(myControl, operations);
    dragSource.setTransfer(transferTypes);
    dragSource.addDragListener(listener);
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.getModifiedResource()org.eclipse.core.resources.IResource;1
public IResource getModifiedResource() {
    IType enclosing = getEnclosingType();
    if (enclosing != null) {
        return enclosing.getResource();
    }
    IPackageFragment pack = getPackageFragment();
    if (pack != null) {
        String cuName = getCompilationUnitName(getTypeNameWithoutParameters());
        return pack.getCompilationUnit(cuName).getResource();
    }
    return null;
}
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.getEnclosingType()org.eclipse.jdt.core.IType;1
public IType getEnclosingType() {
    if (isEnclosingTypeSelected()) {
        return fCurrEnclosingType;
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.ui.internal.dialogs.WorkbenchWizardSelectionPage.getNextPage()org.eclipse.jface.wizard.IWizardPage;1
@Override
public IWizardPage getNextPage() {
    ITriggerPoint triggerPoint = getWorkbench().getActivitySupport().getTriggerPointManager().getTriggerPoint(triggerPointId);
    if (triggerPoint == null || WorkbenchActivityHelper.allowUseOf(triggerPoint, getSelectedNode())) {
        return super.getNextPage();
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.ui.views.navigator.ResourceNavigator$6.open(org.eclipse.jface.viewers.ISelection;Z)V3
protected void open(ISelection selection, boolean activate) {
    handleOpen(selection);
}
method: org.eclipse.ui.views.navigator.ResourceNavigator.handleOpen(org.eclipse.jface.viewers.ISelection;)V2
protected void handleOpen(ISelection selection) {
    if (selection instanceof IStructuredSelection) {
        getActionGroup().runDefaultAction((IStructuredSelection) selection);
    }
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.history.RefactoringHistoryControl$1.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public final void selectionChanged(final SelectionChangedEvent event) {
    final ISelection selection = event.getSelection();
    if (selection instanceof IStructuredSelection)
        handleSelectionChanged((IStructuredSelection) selection);
}

---------------Library-------------------
method: org.eclipse.emf.common.util.ECollections.toEList(java.util.Iterator;)org.eclipse.emf.common.util.EList;1
public static <T> EList<T> toEList(Iterator<? extends T> iterator) {
    return ECollections.newBasicEList(iterator);
}
method: org.eclipse.emf.common.util.ECollections.newBasicEList(java.util.Iterator;)org.eclipse.emf.common.util.BasicEList;1
public static <T> BasicEList<T> newBasicEList(Iterator<? extends T> iterator) {
    BasicEList<T> result = new  BasicEList<T>();
    while (iterator.hasNext()) {
        result.add(iterator.next());
    }
    return result;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.QueryResult.iteratorToSet(java.util.Iterator;)java.util.Set;2
private Set<T> iteratorToSet(Iterator<T> iter) {
    HashSet<T> set = new  HashSet<T>();
    while (iter.hasNext()) set.add(iter.next());
    return set;
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.builders.BundleErrorReporter.isCheckNoRequiredAttr()Z1
protected boolean isCheckNoRequiredAttr() {
    return CompilerFlags.getFlag(fProject, CompilerFlags.P_NO_REQUIRED_ATT) != CompilerFlags.IGNORE;
}
method: org.eclipse.pde.internal.core.builders.CompilerFlags.getFlag(org.eclipse.core.resources.IProject;java.lang.String;)I2
public static int getFlag(IProject project, String flagId) {
    try {
        return Integer.parseInt(getString(project, flagId));
    } catch (NumberFormatException nfe) {
        return 0;
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.hierarchy.ChangeCollector.hasVisibilityChange(org.eclipse.jdt.core.IType;)Z2
private boolean hasVisibilityChange(IType type) throws JavaModelException {
    int existingFlags = this.hierarchy.getCachedFlags(type);
    int newFlags = type.getFlags();
    return existingFlags != newFlags;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.CTabFolderElement.computeStaticPseudoInstances()V1
@Override
protected void computeStaticPseudoInstances() {
    super.computeStaticPseudoInstances();
    super.addStaticPseudoInstance("selected");
}
method: org.eclipse.e4.ui.css.core.dom.ElementAdapter.addStaticPseudoInstance(java.lang.String;)V2
public void addStaticPseudoInstance(String pseudoE) {
    if (staticPseudoInstances == null)
        staticPseudoInstances = new  ArrayList();
    staticPseudoInstances.add(pseudoE);
}
---------------Client-------------------
method: org.eclipse.jface.resource.ResourceManager.disposeExec(java.lang.Runnable;)V2
public void disposeExec(Runnable r) {
    Assert.isNotNull(r);
    if (disposeExecs == null) {
        disposeExecs = new  ArrayList<Runnable>();
    }
    disposeExecs.add(r);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaProject.findType(java.lang.String;java.lang.String;)org.eclipse.jdt.core.IType;3
public IType findType(String packageName, String typeQualifiedName) throws JavaModelException {
    return findType(packageName, typeQualifiedName, DefaultWorkingCopyOwner.PRIMARY);
}
method: org.eclipse.jdt.internal.core.JavaProject.findType(java.lang.String;java.lang.String;org.eclipse.jdt.core.WorkingCopyOwner;)org.eclipse.jdt.core.IType;4
public IType findType(String packageName, String typeQualifiedName, WorkingCopyOwner owner) throws JavaModelException {
    NameLookup lookup = newNameLookup(owner);
    return findType(packageName, typeQualifiedName, lookup, false, null);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.CodeFormatterUtil.reformat(ILjava.lang.String;Aorg.eclipse.jface.text.IRegion;ILjava.lang.String;java.util.Map;)org.eclipse.text.edits.TextEdit;6
public static TextEdit reformat(int kind, String source, IRegion[] regions, int indentationLevel, String lineSeparator, Map<String, String> options) {
    return ToolFactory.createCodeFormatter(options, ToolFactory.M_FORMAT_EXISTING).format(kind, source, regions, indentationLevel, lineSeparator);
}

---------------Library-------------------
method: org.eclipse.ui.internal.ide.dialogs.ResourceFilterPage.dispose()V1
public void dispose() {
    groupWidget.dispose();
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
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.search.internal.ui.text.TextSearchPage.dispose()V1
public void dispose() {
    writeConfiguration();
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
method: org.eclipse.ant.internal.ui.preferences.MessageLine.dispose()V1
@Override
public void dispose() {
    if (fErrorMsgAreaBackground != null) {
        fErrorMsgAreaBackground.dispose();
        fErrorMsgAreaBackground = null;
    }
    super.dispose();
}

---------------Library-------------------
method: org.eclipse.ui.internal.ViewIntroAdapterPart.getTitleImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getTitleImage() {
    return introPart.getTitleImage();
}
method: org.eclipse.ui.part.IntroPart.getTitleImage()org.eclipse.swt.graphics.Image;1
@Override
public Image getTitleImage() {
    if (titleImage != null) {
        return titleImage;
    }
    return getDefaultImage();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.textChanged(org.eclipse.jface.text.TextEvent;)V2
public void textChanged(TextEvent event) {
    updateContentDependantActions();
}
method: org.eclipse.compare.internal.MergeSourceViewer.updateContentDependantActions()V1
void updateContentDependantActions() {
    Iterator e = fActions.values().iterator();
    while (e.hasNext()) {
        Object next = e.next();
        if (next instanceof MergeViewerAction) {
            MergeViewerAction action = (MergeViewerAction) next;
            if (action.isContentDependent())
                action.update();
        }
    }
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    Iterator e = fActions.values().iterator();
    while (e.hasNext()) {
        Object next = e.next();
        if (next instanceof MergeViewerAction) {
            MergeViewerAction action = (MergeViewerAction) next;
            if (action.isSelectionDependent())
                action.update();
        }
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.BrandingProperties.getURLs(java.lang.String;org.osgi.framework.Bundle;)Ajava.net.URL;2
public static URL[] getURLs(String value, Bundle definingBundle) {
    if (value == null) {
        return null;
    }
    StringTokenizer tokens = new  StringTokenizer(value, ",");
    ArrayList array = new  ArrayList(10);
    while (tokens.hasMoreTokens()) {
        array.add(getUrl(tokens.nextToken().trim(), definingBundle));
    }
    return (URL[]) array.toArray(new URL[array.size()]);
}
method: org.eclipse.ui.internal.BrandingProperties.getUrl(java.lang.String;org.osgi.framework.Bundle;)java.net.URL;2
public static URL getUrl(String value, Bundle definingBundle) {
    try {
        if (value != null) {
            return new  URL(value);
        }
    } catch (MalformedURLException e) {
        if (definingBundle != null) {
            return Platform.find(definingBundle, new  Path(value));
        }
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.callhierarchy.CallHierarchy.parseList(java.lang.String;)Aorg.eclipse.jdt.internal.ui.util.StringMatcher;1
private static StringMatcher[] parseList(String listString) {
    List<StringMatcher> list = new  ArrayList<StringMatcher>(10);
    StringTokenizer tokenizer = new  StringTokenizer(listString, ",");
    while (tokenizer.hasMoreTokens()) {
        String textFilter = tokenizer.nextToken().trim();
        list.add(new  StringMatcher(textFilter, false, false));
    }
    return list.toArray(new StringMatcher[list.size()]);
}

---------------Library-------------------
method: org.eclipse.ui.internal.actions.SelectWorkingSetsAction$ManageWorkingSetsAction.run()V1
@Override
public void run() {
    SelectWorkingSetsAction.this.run(this);
}
method: org.eclipse.ui.internal.actions.SelectWorkingSetsAction.run(org.eclipse.jface.action.IAction;)V2
@Override
public void run(IAction action) {
    ConfigureWindowWorkingSetsDialog dialog = new  ConfigureWindowWorkingSetsDialog(getWindow());
    if (dialog.open() == Window.OK) {
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.swt.internal.copy.ShowViewDialog.popUp(java.lang.String;)V2
private void popUp(final String description) {
    new  PopupDialog(filteredTree.getShell(), PopupDialog.HOVER_SHELLSTYLE, true, false, false, false, false, null, null) {

        private static final int CURSOR_SIZE = 15;

        @Override
        protected Point getInitialLocation(Point initialSize) {
            Display display = getShell().getDisplay();
            Point location = display.getCursorLocation();
            location.x += CURSOR_SIZE;
            location.y += CURSOR_SIZE;
            return location;
        }

        @Override
        protected Control createDialogArea(Composite parent) {
            Label label = new  Label(parent, SWT.WRAP);
            label.setText(description);
            label.addFocusListener(new  FocusAdapter() {

                @Override
                public void focusLost(FocusEvent event) {
                    close();
                }
            });
            GridData gd = new  GridData(GridData.BEGINNING | GridData.FILL_BOTH);
            gd.horizontalIndent = PopupDialog.POPUP_HORIZONTALSPACING;
            gd.verticalIndent = PopupDialog.POPUP_VERTICALSPACING;
            label.setLayoutData(gd);
            return label;
        }
    }.open();
}

---------------Library-------------------
method: org.eclipse.ui.internal.editors.text.AccessibilityPreferencePage.dispose()V1
public void dispose() {
    if (fOverlayStore != null) {
        fOverlayStore.stop();
        fOverlayStore = null;
    }
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
method: org.eclipse.core.internal.runtime.InternalPlatform.stopServices()V1
private void stopServices() {
    if (legacyPreferencesService != null) {
        legacyPreferencesService.unregister();
        legacyPreferencesService = null;
    }
    if (customPreferencesService != null) {
        customPreferencesService.unregister();
        customPreferencesService = null;
    }
}

---------------Library-------------------
method: org.eclipse.compare.CompareUI.getResourceBundle()java.util.ResourceBundle;0
public static ResourceBundle getResourceBundle() {
    return CompareUIPlugin.getDefault().getResourceBundle();
}
method: org.eclipse.compare.internal.CompareUIPlugin.getResourceBundle()java.util.ResourceBundle;1
public ResourceBundle getResourceBundle() {
    if (fResourceBundle == null)
        fResourceBundle = Platform.getResourceBundle(getBundle());
    return fResourceBundle;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.model.JavaSynchronizationContentProvider.getModelRoot()java.lang.Object;1
@Override
protected Object getModelRoot() {
    if (fModelRoot == null)
        fModelRoot = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
    return fModelRoot;
}

---------------Library-------------------
method: org.eclipse.debug.ui.WorkingDirectoryBlock.setDefaultWorkingDirectoryText(java.lang.String;)V2
protected final void setDefaultWorkingDirectoryText(String dir) {
    if (dir != null) {
        fWorkingDirText.setText(dir);
        fUseDefaultDirButton.setSelection(true);
        handleUseDefaultWorkingDirButtonSelected();
    }
}
method: org.eclipse.debug.ui.WorkingDirectoryBlock.handleUseDefaultWorkingDirButtonSelected()V1
private void handleUseDefaultWorkingDirButtonSelected() {
    fWorkspaceButton.setEnabled(false);
    fOtherWorkingText.setEnabled(false);
    fVariablesButton.setEnabled(false);
    fFileSystemButton.setEnabled(false);
    fUseOtherDirButton.setSelection(false);
}
---------------Client-------------------
method: org.eclipse.ui.trace.internal.TracingPreferencePage.setEnableTracingOutputFile(Z)V2
private void setEnableTracingOutputFile(boolean enable) {
    tracingOutputFileButton.setSelection(enable);
    tracingFileText.setEnabled(enable);
    maximumFileSizeSpinner.setEnabled(enable);
    maximumFileCountSpinner.setEnabled(enable);
    tracingFileBrowseButton.setEnabled(enable);
    tracingFileMaxCountLabel.setEnabled(enable);
    tracingFileMaxSizeLabel.setEnabled(enable);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.ConstructorInvocation;)V2
@Override
public void endVisit(ConstructorInvocation node) {
    if (skipNode(node))
        return;
    processSequential(node, node.arguments());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.processSequential(org.eclipse.jdt.core.dom.ASTNode;java.util.List;)org.eclipse.jdt.internal.corext.refactoring.code.flow.GenericSequentialFlowInfo;3
protected GenericSequentialFlowInfo processSequential(ASTNode parent, List<? extends ASTNode> nodes) {
    GenericSequentialFlowInfo result = createSequential(parent);
    process(result, nodes);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.endVisit(org.eclipse.jdt.core.dom.ExpressionStatement;)V2
@Override
public void endVisit(ExpressionStatement node) {
    if (skipNode(node))
        return;
    assignFlowInfo(node, node.getExpression());
}
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowAnalyzer.assignFlowInfo(org.eclipse.jdt.core.dom.ASTNode;org.eclipse.jdt.core.dom.ASTNode;)org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;3
protected FlowInfo assignFlowInfo(ASTNode target, ASTNode source) {
    FlowInfo result = getFlowInfo(source);
    setFlowInfo(target, result);
    return result;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.text.plugin.PluginLibraryNode.removeContentFilter(org.eclipse.pde.internal.core.text.plugin.PluginElementNode;)V2
public void removeContentFilter(PluginElementNode node) {
    removeChildNode(node);
    if (isInTheModel()) {
        node.setInTheModel(false);
        fireStructureChanged(node, IModelChangedEvent.REMOVE);
    }
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.CompCSPage.getSelection()org.eclipse.jface.viewers.ISelection;1
public ISelection getSelection() {
    return fBlock.getSelection();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.CompCSBlock.getSelection()org.eclipse.jface.viewers.ISelection;1
public ISelection getSelection() {
    if (fMasterSection != null) {
        return fMasterSection.getSelection();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration.getCompilationUnitDeclaration()org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;1
public CompilationUnitDeclaration getCompilationUnitDeclaration() {
    if (this.scope != null) {
        return this.scope.compilationUnitScope().referenceContext;
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.consumeEmptyDimsopt()V1
protected void consumeEmptyDimsopt() {
    pushOnIntStack(0);
}
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushOnIntStack(I)V2
protected void pushOnIntStack(int pos) {
    int stackLength = this.intStack.length;
    if (++this.intPtr >= stackLength) {
        System.arraycopy(this.intStack, 0, this.intStack = new int[stackLength + StackIncrement], 0, stackLength);
    }
    this.intStack[this.intPtr] = pos;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.Parser.pushIdentifier(I)V2
protected void pushIdentifier(int flag) {
    int stackLength = this.identifierLengthStack.length;
    if (++this.identifierLengthPtr >= stackLength) {
        System.arraycopy(this.identifierLengthStack, 0, this.identifierLengthStack = new int[stackLength + 10], 0, stackLength);
    }
    this.identifierLengthStack[this.identifierLengthPtr] = flag;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.site.CategorySection.initialize()V1
public void initialize() {
    refresh();
    FeatureModelManager mng = PDECore.getDefault().getFeatureModelManager();
    mng.addFeatureModelListener(this);
}
method: org.eclipse.pde.internal.core.PDECore.getFeatureModelManager()org.eclipse.pde.internal.core.FeatureModelManager;1
public synchronized FeatureModelManager getFeatureModelManager() {
    if (fFeatureModelManager == null)
        fFeatureModelManager = new  FeatureModelManager();
    return fFeatureModelManager;
}
---------------Client-------------------
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin$DebugPluginUtil.addListener()V1
public void addListener() {
    if (fLaunchConfigurationListener == null) {
        fLaunchConfigurationListener = new  LaunchConfigurationListener();
    }
    DebugPlugin.getDefault().getLaunchManager().addLaunchConfigurationListener(fLaunchConfigurationListener);
}

---------------Library-------------------
method: org.eclipse.pde.ui.launcher.OSGiLaunchShortcut.initializeConfiguration(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;)V2
protected void initializeConfiguration(ILaunchConfigurationWorkingCopy configuration) {
    OSGiFrameworkManager manager = PDELaunchingPlugin.getDefault().getOSGiFrameworkManager();
    manager.getDefaultInitializer().initialize(configuration);
}
method: org.eclipse.pde.internal.launching.PDELaunchingPlugin.getOSGiFrameworkManager()org.eclipse.pde.internal.launching.launcher.OSGiFrameworkManager;1
public OSGiFrameworkManager getOSGiFrameworkManager() {
    if (fOSGiFrameworkManager == null)
        fOSGiFrameworkManager = new  OSGiFrameworkManager();
    return fOSGiFrameworkManager;
}
---------------Client-------------------
method: org.eclipse.ui.internal.views.markers.MarkerContentGenerator.initializePreferenceListener()V1
private void initializePreferenceListener() {
    if (filterPreferenceListener == null) {
        filterPreferenceListener = new  IPropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent event) {
                if (event.getProperty().equals(getMementoPreferenceName())) {
                    rebuildFilters();
                }
            }
        };
        IDEWorkbenchPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(filterPreferenceListener);
    }
}

---------------Library-------------------
method: org.eclipse.jetty.server.ssl.SslSelectChannelConnector.setTrustPassword(java.lang.String;)V2
@Deprecated
public void setTrustPassword(String password) {
    _sslContextFactory.setTrustStorePassword(password);
}
method: org.eclipse.jetty.util.ssl.SslContextFactory.setTrustStorePassword(java.lang.String;)V2
public void setTrustStorePassword(String password) {
    checkNotStarted();
    _trustStorePassword = Password.getPassword(PASSWORD_PROPERTY, password, null);
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.WorkspacePluginModelManager.processModelChanges()V1
@Override
protected void processModelChanges() {
    super.processModelChanges();
    processModelChanges("org.eclipse.pde.internal.core.IExtensionDeltaEvent", fChangedExtensions);
    fChangedExtensions = null;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.Container.findMember(java.lang.String;)org.eclipse.core.resources.IResource;2
public IResource findMember(String memberPath) {
    return findMember(memberPath, false);
}
method: org.eclipse.core.internal.resources.Container.findMember(java.lang.String;Z)org.eclipse.core.resources.IResource;3
public IResource findMember(String memberPath, boolean phantom) {
    IPath childPath = getFullPath().append(memberPath);
    ResourceInfo info = workspace.getResourceInfo(childPath, phantom, false);
    return info == null ? null : workspace.newResource(childPath, info.getType());
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.Container.findMember(org.eclipse.core.runtime.IPath;Z)org.eclipse.core.resources.IResource;3
public IResource findMember(IPath childPath, boolean phantom) {
    childPath = getFullPath().append(childPath);
    ResourceInfo info = workspace.getResourceInfo(childPath, phantom, false);
    return (info == null) ? null : workspace.newResource(childPath, info.getType());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaHistoryActionImpl.getFile(java.lang.Object;)org.eclipse.core.resources.IFile;2
final IFile getFile(Object input) {
    return JavaElementHistoryPageSource.getInstance().getFile(input);
}
method: org.eclipse.jdt.internal.ui.compare.JavaElementHistoryPageSource.getInstance()org.eclipse.jdt.internal.ui.compare.JavaElementHistoryPageSource;0
public static JavaElementHistoryPageSource getInstance() {
    if (instance == null)
        instance = new  JavaElementHistoryPageSource();
    return instance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement.toString()java.lang.String;1
@Override
public String toString() {
    return getClasspathEntry().toString();
}
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement.getClasspathEntry()org.eclipse.jdt.core.IClasspathEntry;1
public IClasspathEntry getClasspathEntry() {
    if (fCachedEntry == null) {
        fCachedEntry = newClasspathEntry();
    }
    return fCachedEntry;
}
---------------Client-------------------
method: org.eclipse.emf.common.util.BasicDiagnostic$DiagnosticWrapper.getChildren()java.util.List;1
public List<Diagnostic> getChildren() {
    if (unmodifiableWrappedChildren == null) {
        unmodifiableWrappedChildren = Collections.unmodifiableList(basicGetChildren());
    }
    return unmodifiableWrappedChildren;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.schema.SchemaJavaAttributeDetails.commit(Z)V2
public void commit(boolean onSave) {
    super.commit(onSave);
    fClassEntry.commit();
    fInterfaceEntry.commit();
}
method: org.eclipse.pde.internal.ui.editor.schema.SchemaAttributeDetails.commit(Z)V2
public void commit(boolean onSave) {
    super.commit(onSave);
    fName.commit();
    fValue.commit();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.feature.DataPortabilitySection.commit(Z)V2
@Override
public void commit(boolean onSave) {
    fOsText.commit();
    fWsText.commit();
    fNlText.commit();
    fArchText.commit();
    super.commit(onSave);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.debug.ui.jres.JREsPreferencePage.dispose()V1
@Override
public void dispose() {
    super.dispose();
    fJREBlock.dispose();
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
method: org.eclipse.pde.internal.ui.commands.CommandComposerPart.dispose()V1
public void dispose() {
    fCommandDetails.dispose();
    if (fCommandImage != null) {
        fCommandImage.dispose();
        fCommandImage = null;
    }
}

---------------Library-------------------
method: org.eclipse.jdt.ui.actions.CCPActionGroup.dispose()V1
@Override
public void dispose() {
    super.dispose();
    deregisterActionsAsSelectionChangeListeners();
}
method: org.eclipse.jdt.ui.actions.CCPActionGroup.deregisterActionsAsSelectionChangeListeners()V1
private void deregisterActionsAsSelectionChangeListeners() {
    ISelectionProvider provider = fSelectionProvider;
    for (int i = 0; i < fActions.length; i++) {
        provider.removeSelectionChangedListener(fActions[i]);
    }
}
---------------Client-------------------
method: org.eclipse.ui.internal.editors.text.AccessibilityPreferencePage$2.widgetSelected(org.eclipse.swt.events.SelectionEvent;)V2
public void widgetSelected(SelectionEvent e) {
    boolean state = master.getSelection();
    for (int i = 0; i < slaves.length; i++) {
        slaves[i].setEnabled(state);
    }
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.actions.PinParticipantAction.dispose()V1
public void dispose() {
    if (participant != null) {
        participant.removePropertyChangeListener(this);
    }
}
method: org.eclipse.team.ui.synchronize.AbstractSynchronizeParticipant.removePropertyChangeListener(org.eclipse.jface.util.IPropertyChangeListener;)V2
public void removePropertyChangeListener(IPropertyChangeListener listener) {
    if (fChangeHandler != null) {
        fChangeHandler.removePropertyChangeListener(listener);
    }
}
---------------Client-------------------
method: org.eclipse.jface.preference.FontFieldEditor.applyFont()V1
@Override
protected void applyFont() {
    if (chosenFont != null && previewer != null) {
        previewer.setFont(chosenFont);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.setEnclosingTypeSelection(ZZ)V3
public void setEnclosingTypeSelection(boolean isSelected, boolean canBeModified) {
    fEnclosingTypeSelection.setSelection(isSelected);
    fEnclosingTypeSelection.setEnabled(canBeModified);
    updateEnableState();
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField.setEnabled(Z)V2
public final void setEnabled(boolean enabled) {
    if (enabled != fEnabled) {
        fEnabled = enabled;
        updateEnableState();
    }
}
---------------Client-------------------
method: org.eclipse.jface.action.ToolBarManager$1.getName(org.eclipse.swt.accessibility.AccessibleEvent;)V2
@Override
public void getName(AccessibleEvent e) {
    if (e.childID != ACC.CHILDID_SELF) {
        ToolItem item = toolBar.getItem(e.childID);
        if (item != null) {
            String toolTip = item.getToolTipText();
            if (toolTip != null) {
                e.result = toolTip;
            }
        }
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.ui.JUnitQuickFixProcessor$AddAssertProposal.getImage()org.eclipse.swt.graphics.Image;1
public Image getImage() {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_IMPDECL);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.plugin.ImportPackageSection$ImportPackageDialogLabelProvider.getImage(java.lang.Object;)org.eclipse.swt.graphics.Image;2
@Override
public Image getImage(Object element) {
    return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PACKAGE);
}
method: org.eclipse.jdt.ui.JavaUI.getSharedImages()org.eclipse.jdt.ui.ISharedImages;0
public static ISharedImages getSharedImages() {
    if (fgSharedImages == null)
        fgSharedImages = new  SharedImages();
    return fgSharedImages;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathsBlock.doUpdateUI()V1
protected void doUpdateUI() {
    fBuildPathDialogField.refresh();
    fClassPathList.refresh();
    doStatusLineUpdate();
}
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathsBlock.doStatusLineUpdate()V1
private void doStatusLineUpdate() {
    if (Display.getCurrent() != null) {
        IStatus res = findMostSevereStatus();
        fContext.statusChanged(res);
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.tags.BranchPromptDialog$3.handleEvent(org.eclipse.swt.widgets.Event;)V2
public void handleEvent(Event event) {
    versionTag = versionText.getText();
    updateEnablements();
}

---------------Library-------------------
method: org.eclipse.compare.internal.CompareDialog.getInitialSize()org.eclipse.swt.graphics.Point;1
protected Point getInitialSize() {
    Point initialSize = super.getInitialSize();
    if (hasSettings) {
        return initialSize;
    }
    return getDefaultSize();
}
method: org.eclipse.compare.internal.CompareDialog.getDefaultSize()org.eclipse.swt.graphics.Point;1
protected Point getDefaultSize() {
    int width = 0;
    int height = 0;
    Shell shell = getParentShell();
    if (shell != null) {
        Point parentSize = shell.getSize();
        width = parentSize.x - 100;
        height = parentSize.y - 100;
    }
    if (width < 700)
        width = 700;
    if (height < 500)
        height = 500;
    return new  Point(width, height);
}
---------------Client-------------------
method: org.eclipse.team.ui.SaveablePartDialog.getInitialSize()org.eclipse.swt.graphics.Point;1
protected Point getInitialSize() {
    Point initialSize = super.getInitialSize();
    if (hasSettings) {
        return initialSize;
    }
    int width = 0;
    int height = 0;
    Shell shell = getParentShell();
    if (shell != null) {
        Point parentSize = shell.getSize();
        width = parentSize.x - 100;
        height = parentSize.y - 100;
    }
    if (width < 700)
        width = 700;
    if (height < 500)
        height = 500;
    return new  Point(width, height);
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.CompCSMasterTreeSection.createTree(org.eclipse.swt.widgets.Composite;org.eclipse.ui.forms.widgets.FormToolkit;)V3
private void createTree(Composite container, FormToolkit toolkit) {
    TreePart treePart = getTreePart();
    createViewerPartControl(container, SWT.SINGLE, 2, toolkit);
    fTreeViewer = treePart.getTreeViewer();
    fTreeViewer.setContentProvider(new  CompCSContentProvider());
    fTreeViewer.setLabelProvider(PDEUserAssistanceUIPlugin.getDefault().getLabelProvider());
    PDEUserAssistanceUIPlugin.getDefault().getLabelProvider().connect(this);
    createTreeListeners();
}
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.CompCSMasterTreeSection.createTreeListeners()V1
private void createTreeListeners() {
    fTreeViewer.addPostSelectionChangedListener(getPage().getPDEEditor().new  PDEFormEditorChangeListener());
}
---------------Client-------------------
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpTreeSection.createTree(org.eclipse.swt.widgets.Composite;org.eclipse.ui.forms.widgets.FormToolkit;)V3
private void createTree(Composite container, FormToolkit toolkit) {
    TreePart treePart = getTreePart();
    createViewerPartControl(container, SWT.MULTI, 2, toolkit);
    fTree = treePart.getTreeViewer();
    fTree.setContentProvider(new  CtxHelpContentProvider());
    fTree.setLabelProvider(PDEUserAssistanceUIPlugin.getDefault().getLabelProvider());
    PDEUserAssistanceUIPlugin.getDefault().getLabelProvider().connect(this);
    fTree.addPostSelectionChangedListener(getPage().getPDEEditor().new  PDEFormEditorChangeListener());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticFieldReadAccessMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticFieldReadAccessMethod(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForFieldReadAccess(methodBinding);
    completeCodeAttributeForSyntheticMethod(methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}
method: org.eclipse.jdt.internal.compiler.ClassFile.completeCodeAttributeForSyntheticMethod(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;IAI)V4
public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding binding, int codeAttributeOffset, int[] startLineIndexes) {
    this.completeCodeAttributeForSyntheticMethod(false, binding, codeAttributeOffset, startLineIndexes);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ClassFile.addSyntheticSwitchTable(org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;)V2
public void addSyntheticSwitchTable(SyntheticMethodBinding methodBinding) {
    generateMethodInfoHeader(methodBinding);
    int methodAttributeOffset = this.contentsOffset;
    int attributeNumber = generateMethodInfoAttributes(methodBinding);
    int codeAttributeOffset = this.contentsOffset;
    attributeNumber++;
    generateCodeAttributeHeader();
    this.codeStream.init(this);
    this.codeStream.generateSyntheticBodyForSwitchTable(methodBinding);
    completeCodeAttributeForSyntheticMethod(true, methodBinding, codeAttributeOffset, ((SourceTypeBinding) methodBinding.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
    this.contents[methodAttributeOffset++] = (byte) (attributeNumber >> 8);
    this.contents[methodAttributeOffset] = (byte) attributeNumber;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.viewers.model.provisional.VirtualTree.setData(java.lang.Object;)V2
@Override
public void setData(Object data) {
    super.setData(data);
    setHasItems(data != null);
}
method: org.eclipse.debug.internal.ui.viewers.model.provisional.VirtualTree.setHasItems(Z)V2
@Override
public void setHasItems(boolean hasChildren) {
    super.setHasItems(hasChildren);
    if (hasChildren) {
        setExpanded(true);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.ui.actions.OpenSuperImplementationAction.selectionChanged(org.eclipse.jface.viewers.IStructuredSelection;)V2
@Override
public void selectionChanged(IStructuredSelection selection) {
    IMethod method = getMethod(selection);
    setEnabled(method != null && checkMethod(method));
}

---------------Library-------------------
method: org.eclipse.ui.internal.progress.ProgressMonitorFocusJobDialog$3$8.run()V1
@Override
public void run() {
    getProgressMonitor().subTask(finalName);
}
method: org.eclipse.ui.internal.progress.ProgressMonitorJobsDialog.getProgressMonitor()org.eclipse.core.runtime.IProgressMonitor;1
@Override
public IProgressMonitor getProgressMonitor() {
    if (wrapperedMonitor == null) {
        createWrapperedMonitor();
    }
    return wrapperedMonitor;
}
---------------Client-------------------
method: org.eclipse.ui.internal.menus.PulldownDelegateWidgetProxy$1.widgetDisposed(org.eclipse.swt.events.DisposeEvent;)V2
@Override
public void widgetDisposed(DisposeEvent e) {
    if (e.widget == widget) {
        dispose();
        widget = null;
    }
}

---------------Library-------------------
method: org.eclipse.ui.internal.PerspectiveTracker.pageClosed(org.eclipse.ui.IWorkbenchPage;)V2
@Override
public void pageClosed(IWorkbenchPage page) {
    update();
}
method: org.eclipse.ui.internal.PerspectiveTracker.update()V1
private void update() {
    if (window != null) {
        IPerspectiveDescriptor persp = null;
        IWorkbenchPage page = window.getActivePage();
        if (page != null) {
            persp = page.getPerspective();
        }
        update(persp);
    }
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.ui.storage.TabPassword.updateDescription()V1
protected void updateDescription() {
    PasswordProviderDescription selectedModule = getSelectedModule();
    if (selectedModule != null && detailsText != null)
        detailsText.setText(selectedModule.getDescription());
}

---------------Library-------------------
method: org.eclipse.team.internal.ui.mapping.ResourceModelContentProvider.diffsChanged(org.eclipse.team.core.diff.IDiffChangeEvent;org.eclipse.core.runtime.IProgressMonitor;)V3
public void diffsChanged(final IDiffChangeEvent event, IProgressMonitor monitor) {
    Utils.syncExec(new  Runnable() {

        public void run() {
            handleChange(event);
        }
    }, (StructuredViewer) getViewer());
}
method: org.eclipse.team.internal.ui.Utils.syncExec(java.lang.Runnable;org.eclipse.jface.viewers.StructuredViewer;)V2
public static void syncExec(final Runnable r, StructuredViewer v) {
    if (v == null)
        return;
    final Control ctrl = v.getControl();
    syncExec(r, ctrl);
}
---------------Client-------------------
method: org.eclipse.core.databinding.ListBinding.updateModelToTarget()V1
public void updateModelToTarget() {
    final IObservableList modelList = (IObservableList) getModel();
    modelList.getRealm().exec(new  Runnable() {

        public void run() {
            ListDiff diff = Diffs.computeListDiff(Collections.EMPTY_LIST, modelList);
            doUpdate(modelList, (IObservableList) getTarget(), diff, modelToTarget, true, true);
        }
    });
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.TreeListDialogField$TreeViewerAdapter.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
public void selectionChanged(SelectionChangedEvent event) {
    doListSelected(event);
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.TreeListDialogField.doListSelected(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
protected void doListSelected(SelectionChangedEvent event) {
    updateButtonState();
    if (fTreeAdapter != null) {
        fTreeAdapter.selectionChanged(this);
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.filebuffers.FileStoreTextFileBuffer.connected()V1
protected void connected() {
    super.connected();
    if (fAnnotationModel != null)
        fAnnotationModel.connect(fDocument);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.runner.FailedComparison.sendMessages(org.eclipse.jdt.internal.junit.runner.MessageSender;)V2
void sendMessages(MessageSender sender) {
    sender.sendMessage(MessageIds.EXPECTED_START);
    sender.sendMessage(getExpected());
    sender.sendMessage(MessageIds.EXPECTED_END);
    sender.sendMessage(MessageIds.ACTUAL_START);
    sender.sendMessage(getActual());
    sender.sendMessage(MessageIds.ACTUAL_END);
}
method: org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.sendMessage(java.lang.String;)V2
public void sendMessage(String msg) {
    if (fWriter == null)
        return;
    fWriter.println(msg);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Caret.releaseParent()V1
@Override
void releaseParent() {
    super.releaseParent();
    if (this == parent.getCaret())
        parent.setCaret(null);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction.dispose()V1
public void dispose() {
    setMenu(null);
    disposeSubmenuActions();
}
method: org.eclipse.jdt.internal.ui.actions.OccurrencesSearchMenuAction.setMenu(org.eclipse.swt.widgets.Menu;)V2
private void setMenu(Menu menu) {
    if (fMenu != null) {
        fMenu.dispose();
    }
    fMenu = menu;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.preferences.MessageLine.dispose()V1
@Override
public void dispose() {
    if (fErrorMsgAreaBackground != null) {
        fErrorMsgAreaBackground.dispose();
        fErrorMsgAreaBackground = null;
    }
    super.dispose();
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.filters.UpdateActiveFiltersOperation.execute(org.eclipse.core.runtime.IProgressMonitor;org.eclipse.core.runtime.IAdaptable;)org.eclipse.core.runtime.IStatus;3
public IStatus execute(IProgressMonitor monitor, IAdaptable info) {
    contentService.getFilterService().activateFilterIdsAndUpdateViewer(filterIdsToActivate);
    return Status.OK_STATUS;
}
method: org.eclipse.ui.internal.navigator.NavigatorContentService.getFilterService()org.eclipse.ui.navigator.INavigatorFilterService;1
public INavigatorFilterService getFilterService() {
    if (navigatorFilterService == null) {
        navigatorFilterService = new  NavigatorFilterService(this);
    }
    return navigatorFilterService;
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.target.EditTargetNode.getWizard()org.eclipse.jface.wizard.IWizard;1
public IWizard getWizard() {
    if (fWizard == null) {
        fWizard = new  EditTargetDefinitionWizard(fDefinition, false);
        fWizard.setWindowTitle(PDEUIMessages.EditTargetNode_0);
    }
    return fWizard;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.wizards.toc.RegisterTocOperation.createExtensionToc(org.eclipse.pde.core.plugin.IPluginModelBase;)org.eclipse.pde.core.plugin.IPluginExtension;2
private IPluginExtension createExtensionToc(IPluginModelBase model) throws CoreException {
    IPluginExtension extension = model.getFactory().createExtension();
    extension.setPoint(F_TOC_EXTENSION_POINT_ID);
    createExtensionChildren(extension);
    return extension;
}
method: org.eclipse.pde.internal.ua.ui.wizards.toc.RegisterTocOperation.createExtensionChildren(org.eclipse.pde.core.plugin.IPluginExtension;)V2
private void createExtensionChildren(IPluginExtension extension) throws CoreException {
    IPluginElement tocElement = createElementToc(extension);
    if (tocElement != null) {
        extension.add(tocElement);
    }
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.wizards.product.ProductIntroOperation.createIntroConfigExtension(org.eclipse.pde.core.plugin.IPluginModelBase;)org.eclipse.pde.core.plugin.IPluginExtension;2
private IPluginExtension createIntroConfigExtension(IPluginModelBase model) throws CoreException {
    IPluginExtension extension = model.getFactory().createExtension();
    extension.setPoint(INTRO_CONFIG_POINT);
    extension.add(createIntroConfigExtensionContent(extension));
    return extension;
}

---------------Library-------------------
method: org.eclipse.ui.internal.forms.widgets.FormHeading.setFont(org.eclipse.swt.graphics.Font;)V2
public void setFont(Font font) {
    super.setFont(font);
    titleRegion.setFont(font);
}
method: org.eclipse.swt.widgets.Canvas.setFont(org.eclipse.swt.graphics.Font;)V2
@Override
public void setFont(Font font) {
    checkWidget();
    if (caret != null)
        caret.setFont(font);
    super.setFont(font);
}
---------------Client-------------------
method: org.eclipse.jdt.ui.actions.RenameAction.selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent;)V2
@Override
public void selectionChanged(SelectionChangedEvent event) {
    fRenameJavaElement.selectionChanged(event);
    if (fRenameResource != null)
        fRenameResource.selectionChanged(event);
    setEnabled(computeEnabledState());
}

---------------Library-------------------
method: org.eclipse.core.runtime.Preferences.validatePreferenceVersions(org.eclipse.core.runtime.IPath;)org.eclipse.core.runtime.IStatus;1
public static IStatus validatePreferenceVersions(IPath file) {
    PreferencesService service = PreferencesService.getDefault();
    return service.validateVersions(file);
}
method: org.eclipse.core.internal.preferences.PreferencesService.getDefault()org.eclipse.core.internal.preferences.PreferencesService;0
public static PreferencesService getDefault() {
    if (instance == null)
        instance = new  PreferencesService();
    return instance;
}
---------------Client-------------------
method: org.eclipse.ant.internal.ui.AntUIImages.getImage(org.eclipse.jface.resource.CompositeImageDescriptor;)org.eclipse.swt.graphics.Image;1
public static Image getImage(CompositeImageDescriptor imageDescriptor) {
    if (imageDescriptorRegistry == null) {
        imageDescriptorRegistry = new  ImageDescriptorRegistry();
    }
    return imageDescriptorRegistry.get(imageDescriptor);
}

---------------Library-------------------
method: org.eclipse.pde.internal.core.text.bundle.RequiredExecutionEnvironmentHeader.addExecutionEnvironments(Aorg.eclipse.pde.internal.core.text.bundle.ExecutionEnvironment;)V2
public void addExecutionEnvironments(ExecutionEnvironment[] envs) {
    addManifestElements(envs);
}
method: org.eclipse.pde.internal.core.text.bundle.CompositeManifestHeader.addManifestElements(Aorg.eclipse.pde.internal.core.text.bundle.PDEManifestElement;)V2
protected void addManifestElements(PDEManifestElement[] elements) {
    for (int i = 0; i < elements.length; i++) addManifestElement(elements[i], false);
    update(false);
    fireStructureChanged(elements, IModelChangedEvent.INSERT);
}
---------------Client-------------------
method: org.eclipse.ltk.internal.ui.refactoring.history.RefactoringHistoryControl$RefactoringHistoryTreeViewer.setSubTreeGrayed(java.lang.Object;Z)V3
private void setSubTreeGrayed(final Object element, final boolean grayed) {
    setElementGrayed(element, grayed);
    final Object[] children = getChildren(element);
    for (int index = 0; index < children.length; index++) {
        setSubTreeGrayed(children[index], grayed);
    }
}

---------------Library-------------------
method: org.eclipse.help.internal.util.URLCoder.decode(java.lang.String;)java.lang.String;1
public static String decode(String s) {
    try {
        return new  String(urlDecode(s), "UTF8");
    } catch (UnsupportedEncodingException uee) {
        return null;
    }
}
method: org.eclipse.help.internal.util.URLCoder.urlDecode(java.lang.String;)AB1
private static byte[] urlDecode(String encodedURL) {
    int len = encodedURL.length();
    ByteArrayOutputStream os = new  ByteArrayOutputStream(len);
    for (int i = 0; i < len; ) {
        switch(encodedURL.charAt(i)) {
            case '%':
                if (len >= i + 3) {
                    os.write(Integer.parseInt(encodedURL.substring(i + 1, i + 3), 16));
                }
                i += 3;
                break;
            case '+':
                os.write(' ');
                i++;
                break;
            default:
                os.write(encodedURL.charAt(i++));
                break;
        }
    }
    return os.toByteArray();
}
---------------Client-------------------
method: org.eclipse.ui.internal.intro.impl.model.url.IntroURLParser.urlDecode(java.lang.String;)java.lang.String;1
private static String urlDecode(String encodedURL) {
    int len = encodedURL.length();
    ByteArrayOutputStream os = new  ByteArrayOutputStream(len);
    try {
        for (int i = 0; i < len; ) {
            switch(encodedURL.charAt(i)) {
                case '%':
                    if (len >= i + 3) {
                        os.write(Integer.parseInt(encodedURL.substring(i + 1, i + 3), 16));
                    }
                    i += 3;
                    break;
                case '+':
                    os.write(' ');
                    i++;
                    break;
                default:
                    os.write(encodedURL.charAt(i++));
                    break;
            }
        }
        return new  String(os.toByteArray(), "UTF8");
    } catch (UnsupportedEncodingException ex) {
        return null;
    }
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.ComputedSet.addSetChangeListener(org.eclipse.core.databinding.observable.set.ISetChangeListener;)V2
public synchronized void addSetChangeListener(ISetChangeListener listener) {
    super.addSetChangeListener(listener);
    computeSetForListeners();
}
method: org.eclipse.core.databinding.observable.set.ComputedSet.computeSetForListeners()V1
private void computeSetForListeners() {
    getRealm().exec(new  Runnable() {

        public void run() {
            if (dependencies == null) {
                getSet();
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.jface.viewers.StructuredViewer.addDragSupport(IAorg.eclipse.swt.dnd.Transfer;org.eclipse.swt.dnd.DragSourceListener;)V4
public void addDragSupport(int operations, Transfer[] transferTypes, DragSourceListener listener) {
    Control myControl = getControl();
    final DragSource dragSource = new  DragSource(myControl, operations);
    dragSource.setTransfer(transferTypes);
    dragSource.addDragListener(listener);
}

---------------Library-------------------
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.readState(java.io.File;)org.eclipse.osgi.service.resolver.State;2
public State readState(File stateDirectory) throws IOException {
    return internalReadState(internalCreateState(), stateDirectory, -1);
}
method: org.eclipse.osgi.internal.resolver.StateObjectFactoryImpl.internalCreateState()org.eclipse.osgi.internal.resolver.StateImpl;1
private StateImpl internalCreateState() {
    StateImpl state = new  UserState();
    state.setFactory(this);
    return state;
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.CheckoutAsMainPage.createRadioButton(org.eclipse.swt.widgets.Composite;java.lang.String;I)org.eclipse.swt.widgets.Button;4
protected Button createRadioButton(Composite parent, String label, int span) {
    Button radio = super.createRadioButton(parent, label, span);
    radio.addSelectionListener(new  SelectionAdapter() {

        public void widgetSelected(SelectionEvent e) {
            updateEnablements();
        }
    });
    return radio;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JavaProject.findType(java.lang.String;java.lang.String;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IType;4
public IType findType(String packageName, String typeQualifiedName, IProgressMonitor progressMonitor) throws JavaModelException {
    return findType(packageName, typeQualifiedName, DefaultWorkingCopyOwner.PRIMARY, progressMonitor);
}
method: org.eclipse.jdt.internal.core.JavaProject.findType(java.lang.String;java.lang.String;org.eclipse.jdt.core.WorkingCopyOwner;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.jdt.core.IType;5
public IType findType(String packageName, String typeQualifiedName, WorkingCopyOwner owner, IProgressMonitor progressMonitor) throws JavaModelException {
    NameLookup lookup = newNameLookup(owner);
    return findType(packageName, typeQualifiedName, lookup, true, progressMonitor);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.CodeFormatterUtil.reformat(ILjava.lang.String;Aorg.eclipse.jface.text.IRegion;ILjava.lang.String;java.util.Map;)org.eclipse.text.edits.TextEdit;6
public static TextEdit reformat(int kind, String source, IRegion[] regions, int indentationLevel, String lineSeparator, Map<String, String> options) {
    return ToolFactory.createCodeFormatter(options, ToolFactory.M_FORMAT_EXISTING).format(kind, source, regions, indentationLevel, lineSeparator);
}

