/**
*  A method returns an object that needs to be downcasted by its callers.
*  Move the downcast to within the method.
*
*  Most cases detected indicate opportunities in which the library method
*  contains a method call that returns an object needs downcast. But to check
*  that whether the refactoring is feasible, we also need to look into the method.
*/
---------------Library-------------------
method: org.eclipse.team.internal.core.StorageMergerRegistry.createStreamMerger(java.lang.String;)org.eclipse.team.core.mapping.IStorageMerger;2
public IStorageMerger createStreamMerger(String type) {
    initializeRegistry();
    StorageMergerDescriptor descriptor = (StorageMergerDescriptor) search(type);
    if (descriptor != null)
        return descriptor.createStreamMerger();
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.NewNameQueries$2$1.createDialogArea(org.eclipse.swt.widgets.Composite;)org.eclipse.swt.widgets.Control;2
@Override
protected Control createDialogArea(Composite parent) {
    Control area = super.createDialogArea(parent);
    TextFieldNavigationHandler.install(getText());
    return area;
}
// it's opportunity. in library, search() returns an object that needs to be downcasted to 
// StorageMergerDescriptor, the downcast should be able to move within search. However, to
// determine whether we can perform this refactoring, we need to look into the method search()
// to see if this method only needs to return an object of type StorageMergerDescriptor.

---------------Library-------------------
method: org.eclipse.emf.ecore.xmi.util.XMLProcessor.load(org.xml.sax.InputSource;java.util.Map;)org.eclipse.emf.ecore.resource.Resource;3
public Resource load(InputSource inputSource, Map<?, ?> options) throws IOException {
    ResourceSet resourceSet = createResourceSet();
    XMLResource resource = (XMLResource) resourceSet.createResource(XML_URI);
    if (options != null) {
        Map<Object, Object> mergedOptions = new  HashMap<Object, Object>(loadOptions);
        mergedOptions.putAll(options);
        resource.load(inputSource, mergedOptions);
    } else {
        resource.load(inputSource, loadOptions);
    }
    resourceSet.getPackageRegistry().putAll(registry);
    return resource;
}
---------------Client-------------------
method: org.eclipse.emf.ecore.xmi.util.XMLProcessor.load(java.io.InputStream;java.util.Map;)org.eclipse.emf.ecore.resource.Resource;3
public Resource load(InputStream is, Map<?, ?> options) throws IOException {
    ResourceSet resourceSet = createResourceSet();
    Resource resource = resourceSet.createResource(XML_URI);
    if (options != null) {
        Map<Object, Object> mergedOptions = new  HashMap<Object, Object>(loadOptions);
        mergedOptions.putAll(options);
        resource.load(is, mergedOptions);
    } else {
        resource.load(is, loadOptions);
    }
    resourceSet.getPackageRegistry().putAll(registry);
    return resource;
}
// it's opportunity. in library, resourceSet.createResource() returns an object that needs to be downcasted.
---------------Library-------------------
method: org.eclipse.emf.ecore.plugin.InvocationDelegateFactoryRegistryReader$InvocationDelegateFactoryDescriptor.getFactory()org.eclipse.emf.ecore.EOperation$Internal$InvocationDelegate$Factory;1
public EOperation.Internal.InvocationDelegate.Factory getFactory() {
    if (factory == null) {
        factory = (EOperation.Internal.InvocationDelegate.Factory) createInstance();
    }
    return factory;
}
---------------Client-------------------
method: org.eclipse.emf.ecore.impl.FlatEObjectImpl.eContents()org.eclipse.emf.common.util.EList;1
@Override
public EList<EObject> eContents() {
    if (eContents == null) {
        eContents = EContentsEList.createEContentsEList(this);
    }
    return eContents;
}
// it's opportunity. in library, createInstance() returns an object that needs to be downcasted.

---------------Library-------------------
method: org.eclipse.e4.core.di.internal.extensions.DIEActivator.getPreferencesService()org.eclipse.core.runtime.preferences.IPreferencesService;1
public IPreferencesService getPreferencesService() {
    if (preferencesTracker == null) {
        if (bundleContext == null)
            return null;
        preferencesTracker = new  ServiceTracker<IPreferencesService, IPreferencesService>(bundleContext, IPreferencesService.class, null);
        preferencesTracker.open();
    }
    return preferencesTracker.getService();
}
---------------Client-------------------
method: org.eclipse.pde.internal.junit.runtime.PDEJUnitRuntimePlugin.getTestableObject()java.lang.Object;1
public Object getTestableObject() {
    if (bundleContext == null)
        return null;
    if (testableTracker == null) {
        testableTracker = new  ServiceTracker(bundleContext, TESTABLE_OBJECT_SERVICE_NAME, null);
        testableTracker.open();
    }
    return testableTracker.getService();
}
// not opportunity. There's no downcast in the library. According to the rule in concretisation 
//￼(Vq[methodinvoke_checkcast] - Vc[methodinvoke_checkcast] > 0), the possible reason that these
// two are matched is the generic<> results to checkcast instuction.

---------------Library-------------------
method: org.apache.lucene.analysis.Token.clone()java.lang.Object;1
@Override
public Object clone() {
    Token t = (Token) super.clone();
    if (payload != null) {
        t.payload = (Payload) payload.clone();
    }
    return t;
}
---------------Client-------------------
method: org.eclipse.ui.internal.WorkbenchWindowConfigurer.getTitle()java.lang.String;1
@Override
public String getTitle() {
    Shell shell = window.getShell();
    if (shell != null) {
        windowTitle = shell.getText();
    }
    return windowTitle;
}
// The first downcast in library is not an opportunity. Clearly, the clone() method of
// superclass can not return an object of its subclass, we can not perform this refactoring.

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.ctxhelp.CtxHelpPage.dispose()V1
public void dispose() {
    CtxHelpModel model = (CtxHelpModel) getModel();
    if (model != null) {
        model.removeModelChangedListener(this);
    }
    super.dispose();
}
---------------Client-------------------
method: org.eclipse.pde.internal.ui.editor.product.AboutSection.dispose()V1
public void dispose() {
    IProductModel model = getModel();
    if (model != null) {
        model.removeModelChangedListener(this);
    }
    super.dispose();
}
//it's opportunity. in library, getModel() returns an object that needs to be downcasted.

---------------Library-------------------
method: org.eclipse.e4.core.internal.services.ServicesActivator.getLogService()org.osgi.service.log.LogService;1
public LogService getLogService() {
    if (logTracker == null) {
        if (bundleContext == null)
            return null;
        logTracker = new  ServiceTracker<LogService, LogService>(bundleContext, LogService.class, null);
        logTracker.open();
    }
    return logTracker.getService();
}
---------------Client-------------------
method: org.eclipse.pde.internal.junit.runtime.PDEJUnitRuntimePlugin.getTestableObject()java.lang.Object;1
public Object getTestableObject() {
    if (bundleContext == null)
        return null;
    if (testableTracker == null) {
        testableTracker = new  ServiceTracker(bundleContext, TESTABLE_OBJECT_SERVICE_NAME, null);
        testableTracker.open();
    }
    return testableTracker.getService();
}
// not opportunity.
---------------Library-------------------
method: org.eclipse.debug.ui.RefreshTab.selectResources()V1
private void selectResources() {
    IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
    if (fWorkingSet == null) {
        fWorkingSet = workingSetManager.createWorkingSet(StringSubstitutionMessages.RefreshTab_40, new IAdaptable[0]);
    }
    IWorkingSetEditWizard wizard = workingSetManager.createWorkingSetEditWizard(fWorkingSet);
    WizardDialog dialog = new  WizardDialog(((LaunchConfigurationsDialog) LaunchConfigurationsDialog.getCurrentlyVisibleLaunchConfigurationDialog()).getShell(), wizard);
    dialog.create();
    if (dialog.open() == Window.CANCEL) {
        return;
    }
    fWorkingSet = wizard.getSelection();
    updateLaunchConfigurationDialog();
}
---------------Client-------------------
method: org.eclipse.ui.externaltools.internal.launchConfigurations.ExternalToolsBuilderTab.selectResources()V1
private void selectResources() {
    IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
    if (workingSet == null) {
        workingSet = workingSetManager.createWorkingSet(ExternalToolsLaunchConfigurationMessages.ExternalToolsBuilderTab_15, new IAdaptable[0]);
    }
    IWorkingSetEditWizard wizard = workingSetManager.createWorkingSetEditWizard(workingSet);
    WizardDialog dialog = new  WizardDialog(ExternalToolsPlugin.getStandardDisplay().getActiveShell(), wizard);
    dialog.create();
    if (dialog.open() == Window.CANCEL) {
        return;
    }
    workingSet = wizard.getSelection();
    updateLaunchConfigurationDialog();
}
//it's opportunity. in library, getCurrentlyVisibleLaunchConfigurationDialog()
//returns an object that needs to be downcasted.

---------------Library-------------------
method: org.eclipse.e4.ui.model.application.descriptor.basic.impl.BasicFactoryImpl.create(org.eclipse.emf.ecore.EClass;)org.eclipse.emf.ecore.EObject;2
@Override
public EObject create(EClass eClass) {
    switch(eClass.getClassifierID()) {
        case BasicPackageImpl.PART_DESCRIPTOR:
            return (EObject) createPartDescriptor();
        default:
            throw new  IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
}
---------------Client-------------------
method: org.eclipse.emf.ecore.xml.namespace.impl.XMLNamespaceFactoryImpl.create(org.eclipse.emf.ecore.EClass;)org.eclipse.emf.ecore.EObject;2
@Override
public EObject create(EClass eClass) {
    switch(eClass.getClassifierID()) {
        case XMLNamespacePackage.XML_NAMESPACE_DOCUMENT_ROOT:
            return createXMLNamespaceDocumentRoot();
        default:
            throw new  IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
}
//it's opportunity. in library createPartDescriptor() returns an object that needs to be downcasted.

---------------Library-------------------
method: org.eclipse.e4.core.di.internal.extensions.DIEActivator.getEventAdmin()org.osgi.service.event.EventAdmin;1
public EventAdmin getEventAdmin() {
    if (eventAdminTracker == null) {
        if (bundleContext == null)
            return null;
        eventAdminTracker = new  ServiceTracker<EventAdmin, EventAdmin>(bundleContext, EventAdmin.class, null);
        eventAdminTracker.open();
    }
    return eventAdminTracker.getService();
}
---------------Client-------------------
method: org.eclipse.pde.internal.junit.runtime.PDEJUnitRuntimePlugin.getTestableObject()java.lang.Object;1
public Object getTestableObject() {
    if (bundleContext == null)
        return null;
    if (testableTracker == null) {
        testableTracker = new  ServiceTracker(bundleContext, TESTABLE_OBJECT_SERVICE_NAME, null);
        testableTracker.open();
    }
    return testableTracker.getService();
}
// not refactoring.
