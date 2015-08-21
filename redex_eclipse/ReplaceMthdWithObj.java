/**
* You have a long method that uses local variables in such a way
* that you cannot apply Extract Method.
* Turn the method into its own object so that all the local variables
* become fields on that object. You can then decompose the method into
* other methods on the same object.
*
* This refactoring operation is too complex, the query can not 
* find results that match the description, possible reasons: 
* 1. The code to perform this refactoring should be long enough, but 
* long codes are unlikely to match.
* 2. This refactoring involves creating a new class, this information 
* can not be captured. 
*/
---------------Library-------------------
method: org.eclipse.core.internal.resources.Workspace.getRuleFactory()org.eclipse.core.resources.IResourceRuleFactory;1
public IResourceRuleFactory getRuleFactory() {
    if (ruleFactory == null)
        ruleFactory = new  Rules(this);
    return ruleFactory;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive. 
---------------Library-------------------
method: org.eclipse.jface.viewers.DialogCellEditor.getButtonFocusListener()org.eclipse.swt.events.FocusListener;1
private FocusListener getButtonFocusListener() {
    if (buttonFocusListener == null) {
        buttonFocusListener = new  FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                DialogCellEditor.this.focusLost();
            }
        };
    }
    return buttonFocusListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive.
---------------Library-------------------
method: org.eclipse.ui.internal.ActivateEditorHandler.getEnabledWhenExpression()org.eclipse.core.expressions.Expression;1
@Override
protected Expression getEnabledWhenExpression() {
    if (enabledWhen == null) {
        enabledWhen = new  Expression() {

            @Override
            public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
                IWorkbenchWindow window = InternalHandlerUtil.getActiveWorkbenchWindow(context);
                if (window != null) {
                    if (window.getActivePage() != null) {
                        return EvaluationResult.TRUE;
                    }
                }
                return EvaluationResult.FALSE;
            }

            @Override
            public void collectExpressionInfo(ExpressionInfo info) {
                info.addVariableNameAccess(ISources.ACTIVE_WORKBENCH_WINDOW_NAME);
            }
        };
    }
    return enabledWhen;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive.

---------------Library-------------------
method: org.eclipse.pde.internal.ds.ui.editor.contentassist.TypePackageCompletionProcessor.getComparator()java.util.Comparator;1
private Comparator getComparator() {
    if (fComparator == null) {
        fComparator = new  Comparator() {

            public int compare(Object arg0, Object arg1) {
                ICompletionProposal p1 = (ICompletionProposal) arg0;
                ICompletionProposal p2 = (ICompletionProposal) arg1;
                return getSortKey(p1).compareToIgnoreCase(getSortKey(p2));
            }

            protected String getSortKey(ICompletionProposal p) {
                return p.getDisplayString();
            }
        };
    }
    return fComparator;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive.

---------------Library-------------------
method: org.eclipse.jface.viewers.TextCellEditor.getModifyListener()org.eclipse.swt.events.ModifyListener;1
private ModifyListener getModifyListener() {
    if (modifyListener == null) {
        modifyListener = new  ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                editOccured(e);
            }
        };
    }
    return modifyListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive.

---------------Library-------------------
method: org.eclipse.team.internal.ui.synchronize.AbstractTreeViewerAdvisor.getNavigatable()org.eclipse.compare.INavigatable;1
private synchronized INavigatable getNavigatable() {
    if (navigatable == null) {
        navigatable = new  INavigatable() {

            public boolean selectChange(int flag) {
                if (flag == INavigatable.FIRST_CHANGE) {
                    getViewer().setSelection(StructuredSelection.EMPTY);
                    flag = INavigatable.NEXT_CHANGE;
                } else if (flag == INavigatable.LAST_CHANGE) {
                    getViewer().setSelection(StructuredSelection.EMPTY);
                    flag = INavigatable.PREVIOUS_CHANGE;
                }
                return navigate((TreeViewer) getViewer(), flag == INavigatable.NEXT_CHANGE, true, false);
            }

            public boolean openSelectedChange() {
                Viewer v = getViewer();
                if (v instanceof ITreeViewerAccessor && !v.getControl().isDisposed()) {
                    ITreeViewerAccessor tva = (ITreeViewerAccessor) v;
                    tva.openSelection();
                    return true;
                }
                return false;
            }

            public boolean hasChange(int changeFlag) {
                return AbstractTreeViewerAdvisor.this.hasChange(changeFlag == INavigatable.NEXT_CHANGE);
            }

            public Object getInput() {
                return getViewer().getInput();
            }
        };
    }
    return navigatable;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive.

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntContentProvider.getComparator()org.eclipse.jface.viewers.ViewerComparator;1
protected ViewerComparator getComparator() {
    if (fComparator == null) {
        fComparator = new  ViewerComparator() {

            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                return e1.toString().compareToIgnoreCase(e2.toString());
            }
        };
    }
    return fComparator;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive.

---------------Library-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.getResources()org.eclipse.emf.common.util.EList;1
public EList<Resource> getResources() {
    if (resources == null) {
        resources = new  ResourcesEList<Resource>();
    }
    return resources;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.getResourceFactoryRegistry()org.eclipse.emf.ecore.resource.Resource$Factory$Registry;1
public Resource.Factory.Registry getResourceFactoryRegistry() {
    if (resourceFactoryRegistry == null) {
        resourceFactoryRegistry = new  ResourceFactoryRegistryImpl() {

            @Override
            protected Resource.Factory delegatedGetFactory(URI uri, String contentTypeIdentifier) {
                return convert(getFactory(uri, Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap(), Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap(), Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap(), contentTypeIdentifier, false));
            }

            @Override
            protected URIConverter getURIConverter() {
                return ResourceSetImpl.this.getURIConverter();
            }

            @Override
            protected Map<?, ?> getContentDescriptionOptions() {
                return new  ExtensibleURIConverterImpl.OptionsMap(ContentHandler.OPTION_REQUESTED_PROPERTIES, CONTENT_TYPE_REQUESTED_PROPERTIES, getLoadOptions());
            }
        };
    }
    return resourceFactoryRegistry;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}
// false positive.

---------------Library-------------------
method: org.eclipse.emf.common.notify.impl.NotifierImpl.eAdapters()org.eclipse.emf.common.util.EList;1
@Override
public EList<Adapter> eAdapters() {
    if (eAdapters == null) {
        eAdapters = new  EAdapterList<Adapter>(this);
    }
    return eAdapters;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.menus.CommandContributionItem.getCommandListener()org.eclipse.core.commands.ICommandListener;1
private ICommandListener getCommandListener() {
    if (commandListener == null) {
        commandListener = new  ICommandListener() {

            @Override
            public void commandChanged(CommandEvent commandEvent) {
                if (commandEvent.isHandledChanged() || commandEvent.isEnabledChanged() || commandEvent.isDefinedChanged()) {
                    updateCommandProperties(commandEvent);
                }
            }
        };
    }
    return commandListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ActionSetManager.getContextListener()org.eclipse.ui.IPropertyListener;1
private IPropertyListener getContextListener() {
    if (contextListener == null) {
        contextListener = new  IPropertyListener() {

            @Override
            public void propertyChanged(Object source, int propId) {
                if (source instanceof IActionSetDescriptor) {
                    IActionSetDescriptor desc = (IActionSetDescriptor) source;
                    String id = desc.getId();
                    if (propId == PROP_VISIBLE) {
                        activationsById.put(id, contextService.activateContext(id));
                    } else if (propId == PROP_HIDDEN) {
                        IContextActivation act = (IContextActivation) activationsById.remove(id);
                        if (act != null) {
                            contextService.deactivateContext(act);
                        }
                    }
                }
            }
        };
    }
    return contextListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.AbstractTextEditor.getRulerMouseListener()org.eclipse.swt.events.MouseListener;1
protected final MouseListener getRulerMouseListener() {
    if (fMouseListener == null) {
        fMouseListener = new  MouseListener() {

            private boolean fDoubleClicked = false;

            private final int fDoubleClickTime = getSite().getShell().getDisplay().getDoubleClickTime();

            private long fMouseUpDelta = 0;

            private void triggerAction(String actionID, MouseEvent e) {
                IAction action = getAction(actionID);
                if (action != null) {
                    if (action instanceof IUpdate)
                        ((IUpdate) action).update();
                    if (action.isEnabled()) {
                        Event event = new  Event();
                        event.type = fDoubleClicked ? SWT.MouseDoubleClick : SWT.MouseUp;
                        event.display = e.display;
                        event.widget = e.widget;
                        event.time = e.time;
                        event.data = e.data;
                        event.x = e.x;
                        event.y = e.y;
                        event.button = e.button;
                        event.stateMask = e.stateMask;
                        event.count = e.count;
                        action.runWithEvent(event);
                    }
                }
            }

            public void mouseUp(final MouseEvent e) {
                setFocus();
                final int delay = fMouseUpDelta == 0 ? 0 : fDoubleClickTime - (int) (System.currentTimeMillis() - fMouseUpDelta);
                if (1 != e.button)
                    return;
                Runnable runnable = new  Runnable() {

                    public void run() {
                        if (!fDoubleClicked)
                            triggerAction(ITextEditorActionConstants.RULER_CLICK, e);
                    }
                };
                if (delay <= 0)
                    runnable.run();
                else
                    e.widget.getDisplay().timerExec(delay, runnable);
            }

            public void mouseDoubleClick(MouseEvent e) {
                if (1 == e.button) {
                    fDoubleClicked = true;
                    triggerAction(ITextEditorActionConstants.RULER_DOUBLE_CLICK, e);
                }
            }

            public void mouseDown(MouseEvent e) {
                fMouseUpDelta = System.currentTimeMillis();
                fDoubleClicked = false;
                if (fRulerContextMenu != null && !fRulerContextMenu.isDisposed()) {
                    Display display = fRulerContextMenu.getDisplay();
                    Point location = display.getCursorLocation();
                    fRulerContextMenu.setLocation(location.x, location.y);
                }
            }
        };
    }
    return fMouseListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ant.internal.ui.preferences.AntEditorPreferencePage.getSelectionListener()org.eclipse.swt.events.SelectionListener;1
protected SelectionListener getSelectionListener() {
    if (fSelectionListener == null) {
        fSelectionListener = new  SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                controlChanged(e.widget);
            }
        };
    }
    return fSelectionListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.breakpoints.BreakpointsView.getModelPresentation()org.eclipse.debug.ui.IDebugModelPresentation;1
@Override
protected IDebugModelPresentation getModelPresentation() {
    if (fModelPresentation == null) {
        fModelPresentation = new  VariablesViewModelPresentation() {

            @Override
            public String getText(Object element) {
                IDebugModelPresentation lp = getConfiguredPresentation(element);
                if (lp != null) {
                    return lp.getText(element);
                }
                return getDefaultText(element);
            }
        };
    }
    return fModelPresentation;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.part.MultiPageEditorSite.getSelectionChangedListener()org.eclipse.jface.viewers.ISelectionChangedListener;1
private ISelectionChangedListener getSelectionChangedListener() {
    if (selectionChangedListener == null) {
        selectionChangedListener = new  ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                MultiPageEditorSite.this.handleSelectionChanged(event);
            }
        };
    }
    return selectionChangedListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.menus.FocusControlSourceProvider.getFocusListener()org.eclipse.swt.events.FocusListener;1
private FocusListener getFocusListener() {
    if (focusListener == null) {
        focusListener = new  FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                focusIn(e.widget);
            }

            @Override
            public void focusLost(FocusEvent e) {
                focusIn(null);
            }
        };
    }
    return focusListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.team.internal.ccvs.ui.wizards.CommitWizardParticipant.getChangeSetCapability()org.eclipse.team.internal.ui.synchronize.ChangeSetCapability;1
public ChangeSetCapability getChangeSetCapability() {
    if (capability == null) {
        capability = new  WorkspaceChangeSetCapability() {

            public boolean supportsCheckedInChangeSets() {
                return false;
            }

            public boolean enableActiveChangeSetsFor(ISynchronizePageConfiguration configuration) {
                return false;
            }

            ;
        };
    }
    return capability;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.CompCSBlock.modelChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
public void modelChanged(IModelChangedEvent event) {
    if (fMasterSection != null) {
        fMasterSection.modelChanged(event);
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.subscriber.CVSChangeSetActionGroup.initialize(org.eclipse.team.ui.synchronize.ISynchronizePageConfiguration;)V2
public void initialize(ISynchronizePageConfiguration configuration) {
    super.initialize(configuration);
    openCommitSet = new  OpenChangeSetAction(configuration);
}
method: org.eclipse.team.ui.synchronize.SynchronizePageActionGroup.initialize(org.eclipse.team.ui.synchronize.ISynchronizePageConfiguration;)V2
public void initialize(ISynchronizePageConfiguration configuration) {
    this.configuration = configuration;
    if (visibleRootSelectionProvider != null) {
        configuration.addActionContribution(visibleRootSelectionProvider);
    }
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.importexport.internal.wizard.AbstractPage.getContentProvider()org.eclipse.jface.viewers.ITreeContentProvider;1
protected ITreeContentProvider getContentProvider() {
    ProvElementContentProvider provider = new  ProvElementContentProvider() {

        @Override
        public boolean hasChildren(Object element) {
            if (element instanceof InstalledIUElement)
                return false;
            return super.hasChildren(element);
        }

        @Override
        public Object[] getChildren(Object parent) {
            if (parent instanceof InstalledIUElement)
                return new Object[0];
            return super.getChildren(parent);
        }
    };
    return provider;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

---------------Library-------------------
method: org.eclipse.debug.internal.ui.views.variables.VariablesView.getTreeSelectionChangedListener()org.eclipse.jface.viewers.ISelectionChangedListener;1
protected ISelectionChangedListener getTreeSelectionChangedListener() {
    if (fTreeSelectionChangedListener == null) {
        fTreeSelectionChangedListener = new  ISelectionChangedListener() {

            @Override
            public void selectionChanged(final SelectionChangedEvent event) {
                if (event.getSelectionProvider().equals(getViewer())) {
                    clearStatusLine();
                    if (fSashForm.getMaximizedControl() == getViewer().getControl()) {
                        return;
                    }
                    refreshDetailPaneContents();
                    treeSelectionChanged(event);
                }
            }
        };
    }
    return fTreeSelectionChangedListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jface.action.ActionContributionItem.getMenuItemListener()org.eclipse.swt.widgets.Listener;1
private Listener getMenuItemListener() {
    if (menuItemListener == null) {
        menuItemListener = new  Listener() {

            @Override
            public void handleEvent(Event event) {
                switch(event.type) {
                    case SWT.Dispose:
                        handleWidgetDispose(event);
                        break;
                    case SWT.Selection:
                        Widget ew = event.widget;
                        if (ew != null) {
                            handleWidgetSelection(event, ((MenuItem) ew).getSelection());
                        }
                        break;
                }
            }
        };
    }
    return menuItemListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceImpl.getContents()org.eclipse.emf.common.util.EList;1
public EList<EObject> getContents() {
    if (contents == null) {
        contents = new  ContentsEList<EObject>();
    }
    return contents;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.apt.ui.internal.preferences.BaseConfigurationBlock.getTextModifyListener()org.eclipse.swt.events.ModifyListener;1
protected ModifyListener getTextModifyListener() {
    if (fTextModifyListener == null) {
        fTextModifyListener = new  ModifyListener() {

            public void modifyText(ModifyEvent e) {
                textChanged((Text) e.widget);
            }
        };
    }
    return fTextModifyListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.comp.details.CompCSDetails.updateFields()V1
public void updateFields() {
    if (fDataCheatSheet == null) {
        return;
    }
    updateNameEntry(isEditableElement());
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.CommonViewerAdvisor$NavigableCommonViewer.openSelection()V1
public void openSelection() {
    fireOpen(new  OpenEvent(this, getSelection()));
}
method: org.eclipse.ui.navigator.CommonViewer.getSelection()org.eclipse.jface.viewers.ISelection;1
public ISelection getSelection() {
    if (cachedSelection == null) {
        cachedSelection = super.getSelection();
    }
    return cachedSelection;
}

---------------Library-------------------
method: org.eclipse.ui.internal.CloseOthersHandler.getEnabledWhenExpression()org.eclipse.core.expressions.Expression;1
@Override
protected Expression getEnabledWhenExpression() {
    if (enabledWhen == null) {
        enabledWhen = new  Expression() {

            @Override
            public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
                IWorkbenchWindow window = InternalHandlerUtil.getActiveWorkbenchWindow(context);
                if (window != null) {
                    IWorkbenchPage page = window.getActivePage();
                    if (page != null) {
                        IEditorReference[] refArray = page.getEditorReferences();
                        if (refArray != null && refArray.length > 1) {
                            return EvaluationResult.TRUE;
                        }
                    }
                }
                return EvaluationResult.FALSE;
            }

            @Override
            public void collectExpressionInfo(ExpressionInfo info) {
                info.addVariableNameAccess(ISources.ACTIVE_WORKBENCH_WINDOW_NAME);
            }
        };
    }
    return enabledWhen;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
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
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSFileStore.getChild(org.eclipse.core.filesystem.IFileInfo;)org.eclipse.core.filesystem.IFileStore;2
private IFileStore getChild(IFileInfo info) {
    return new  CVSFileStore(uri.append(info.getName()), info);
}
method: org.eclipse.team.internal.ccvs.core.filesystem.CVSURI.append(java.lang.String;)org.eclipse.team.internal.ccvs.core.filesystem.CVSURI;2
public CVSURI append(String name) {
    return new  CVSURI(repository, path.append(name), tag);
}

---------------Library-------------------
method: org.eclipse.ecf.core.security.ConnectContextFactory$2.getCallbackHandler()org.eclipse.ecf.core.security.CallbackHandler;1
public CallbackHandler getCallbackHandler() {
    return new  CallbackHandler() {

        public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
            if (callbacks == null)
                return;
            for (int i = 0; i < callbacks.length; i++) {
                if (callbacks[i] instanceof ObjectCallback) {
                    ObjectCallback ocb = (ObjectCallback) callbacks[i];
                    ocb.setObject(password);
                } else if (callbacks[i] instanceof PasswordCallback) {
                    PasswordCallback pc = (PasswordCallback) callbacks[i];
                    pc.setPassword(password);
                } else if (callbacks[i] instanceof PassphraseCallback) {
                    PassphraseCallback pc = (PassphraseCallback) callbacks[i];
                    pc.setPassphrase(password);
                }
            }
        }
    };
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

---------------Library-------------------
method: org.eclipse.jface.text.source.projection.ProjectionAnnotationHover.getInformationPresenterControlCreator()org.eclipse.jface.text.IInformationControlCreator;1
public IInformationControlCreator getInformationPresenterControlCreator() {
    if (fInformationPresenterControlCreator == null) {
        fInformationPresenterControlCreator = new  IInformationControlCreator() {

            public IInformationControl createInformationControl(Shell parent) {
                return new  SourceViewerInformationControl(parent, true, JFaceResources.TEXT_FONT, null);
            }
        };
    }
    return fInformationPresenterControlCreator;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.handlers.HandlerProxy.getEnablementListener()org.eclipse.jface.util.IPropertyChangeListener;1
private IPropertyChangeListener getEnablementListener() {
    if (enablementListener == null) {
        enablementListener = new  IPropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getProperty() == PROP_ENABLED) {
                    setProxyEnabled(event.getNewValue() == null ? false : ((Boolean) event.getNewValue()).booleanValue());
                    fireHandlerChanged(new  HandlerEvent(HandlerProxy.this, true, false));
                }
            }
        };
    }
    return enablementListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.contentassist.XMLCompletionProposal.getInformationControlCreator()org.eclipse.jface.text.IInformationControlCreator;1
public IInformationControlCreator getInformationControlCreator() {
    if (fCreator == null) {
        fCreator = new  AbstractReusableInformationControlCreator() {

            public IInformationControl doCreateInformationControl(Shell parent) {
                if (BrowserInformationControl.isAvailable(parent))
                    return new  BrowserInformationControl(parent, JFaceResources.DIALOG_FONT, false);
                return new  DefaultInformationControl(parent, false);
            }
        };
    }
    return fCreator;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.ProvSDKUIActivator.getPreferenceListener()org.eclipse.jface.util.IPropertyChangeListener;1
private IPropertyChangeListener getPreferenceListener() {
    if (preferenceListener == null) {
        preferenceListener = new  IPropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent event) {
                updateWithPreferences(getPolicy());
            }
        };
    }
    return preferenceListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.ESuperAdapter.getSubclasses()org.eclipse.emf.common.util.EList;1
public EList<EClass> getSubclasses() {
    if (subclasses == null) {
        subclasses = new  UniqueEList<EClass>() {

            private static final long serialVersionUID = 1L;

            @Override
            protected Object[] newData(int capacity) {
                return new EClass[capacity];
            }

            @Override
            protected boolean useEquals() {
                return false;
            }
        };
    }
    return subclasses;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.WorkbenchPartReference.createContextEventHandler()org.osgi.service.event.EventHandler;1
private EventHandler createContextEventHandler() {
    if (contextEventHandler == null) {
        contextEventHandler = new  EventHandler() {

            @Override
            public void handleEvent(Event event) {
                Object element = event.getProperty(UIEvents.EventTags.ELEMENT);
                MPart part = getModel();
                if (element == part) {
                    if (part.getContext() != null) {
                        part.getContext().set(getClass().getName(), this);
                        unsubscribe();
                    }
                }
            }
        };
    }
    return contextEventHandler;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.ComboDialogField.setItems(Ajava.lang.String;)V2
public void setItems(String[] items) {
    fItems = items;
    if (isOkToUse(fComboControl)) {
        fComboControl.setItems(items);
    }
    dialogFieldChanged();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.preferences.CodeTemplateBlock.postSetSelection(java.lang.Object;)V2
public void postSetSelection(Object element) {
    fCodeTemplateTree.postSetSelection(new  StructuredSelection(element));
}
method: org.eclipse.jdt.internal.ui.wizards.dialogfields.TreeListDialogField.postSetSelection(org.eclipse.jface.viewers.ISelection;)V2
public void postSetSelection(final ISelection selection) {
    if (isOkToUse(fTreeControl)) {
        Display d = fTreeControl.getDisplay();
        d.asyncExec(new  Runnable() {

            public void run() {
                if (isOkToUse(fTreeControl)) {
                    selectElements(selection);
                }
            }
        });
    }
}

---------------Library-------------------
method: org.eclipse.jface.text.source.projection.ProjectionAnnotationHover.getHoverControlCreator()org.eclipse.jface.text.IInformationControlCreator;1
public IInformationControlCreator getHoverControlCreator() {
    if (fInformationControlCreator == null) {
        fInformationControlCreator = new  IInformationControlCreator() {

            public IInformationControl createInformationControl(Shell parent) {
                return new  SourceViewerInformationControl(parent, false, JFaceResources.TEXT_FONT, null);
            }
        };
    }
    return fInformationControlCreator;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.diagnose.DiagnoseParser$PrimaryRepairInfo.copy()org.eclipse.jdt.internal.compiler.parser.diagnose.DiagnoseParser$PrimaryRepairInfo;1
public PrimaryRepairInfo copy() {
    PrimaryRepairInfo c = new  PrimaryRepairInfo();
    c.distance = this.distance;
    c.misspellIndex = this.misspellIndex;
    c.code = this.code;
    c.bufferPosition = this.bufferPosition;
    c.symbol = this.symbol;
    return c;
}
---------------Client-------------------
method: org.eclipse.jface.layout.GridDataFactory.createFrom(org.eclipse.swt.layout.GridData;)org.eclipse.jface.layout.GridDataFactory;1
public static GridDataFactory createFrom(GridData data) {
    return new  GridDataFactory(copyData(data));
}
method: org.eclipse.jface.layout.GridDataFactory.copyData(org.eclipse.swt.layout.GridData;)org.eclipse.swt.layout.GridData;1
public static GridData copyData(GridData data) {
    GridData newData = new  GridData(data.horizontalAlignment, data.verticalAlignment, data.grabExcessHorizontalSpace, data.grabExcessVerticalSpace, data.horizontalSpan, data.verticalSpan);
    newData.exclude = data.exclude;
    newData.heightHint = data.heightHint;
    newData.horizontalIndent = data.horizontalIndent;
    newData.minimumHeight = data.minimumHeight;
    newData.minimumWidth = data.minimumWidth;
    newData.verticalIndent = data.verticalIndent;
    newData.widthHint = data.widthHint;
    return newData;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.sdk.scheduler.migration.MigrationPage.getContentProvider()org.eclipse.jface.viewers.ITreeContentProvider;1
protected ITreeContentProvider getContentProvider() {
    ProvElementContentProvider provider = new  ProvElementContentProvider() {

        @Override
        public boolean hasChildren(Object element) {
            if (element instanceof InstalledIUElement)
                return false;
            return super.hasChildren(element);
        }

        @Override
        public Object[] getChildren(Object parent) {
            if (parent instanceof InstalledIUElement)
                return new Object[0];
            return super.getChildren(parent);
        }
    };
    return provider;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

---------------Library-------------------
method: org.eclipse.ui.internal.WorkbenchWindowConfigurer.getActionBarConfigurer()org.eclipse.ui.application.IActionBarConfigurer;1
@Override
public IActionBarConfigurer getActionBarConfigurer() {
    if (actionBarConfigurer == null) {
        actionBarConfigurer = new  WindowActionBarConfigurer();
    }
    return actionBarConfigurer;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.OptionsConfigurationBlock.getTextModifyListener()org.eclipse.swt.events.ModifyListener;1
protected ModifyListener getTextModifyListener() {
    if (fTextModifyListener == null) {
        fTextModifyListener = new  ModifyListener() {

            public void modifyText(ModifyEvent e) {
                textChanged((Text) e.widget);
            }
        };
    }
    return fTextModifyListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.tostringgeneration.ToStringGenerationSettings.getCustomBuilderSettings()org.eclipse.jdt.internal.corext.codemanipulation.tostringgeneration.ToStringGenerationSettings$CustomBuilderSettings;1
public CustomBuilderSettings getCustomBuilderSettings() {
    CustomBuilderSettings result = new  CustomBuilderSettings();
    result.className = customBuilderSettings.className;
    result.variableName = customBuilderSettings.variableName;
    result.appendMethod = customBuilderSettings.appendMethod;
    result.resultMethod = customBuilderSettings.resultMethod;
    result.chainCalls = customBuilderSettings.chainCalls;
    return result;
}
---------------Client-------------------
method: org.eclipse.jface.layout.RowLayoutFactory.createFrom(org.eclipse.swt.layout.RowLayout;)org.eclipse.jface.layout.RowLayoutFactory;1
public static RowLayoutFactory createFrom(RowLayout layout) {
    return new  RowLayoutFactory(copyLayout(layout));
}
method: org.eclipse.jface.layout.RowLayoutFactory.copyLayout(org.eclipse.swt.layout.RowLayout;)org.eclipse.swt.layout.RowLayout;1
public static RowLayout copyLayout(RowLayout layout) {
    RowLayout result = new  RowLayout(layout.type);
    result.marginBottom = layout.marginBottom;
    result.marginTop = layout.marginTop;
    result.marginLeft = layout.marginLeft;
    result.marginRight = layout.marginRight;
    result.marginHeight = layout.marginHeight;
    result.marginWidth = layout.marginWidth;
    result.fill = layout.fill;
    result.justify = layout.justify;
    result.pack = layout.pack;
    result.spacing = layout.spacing;
    result.wrap = layout.wrap;
    result.type = layout.type;
    return result;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.typehierarchy.HierarchyInformationControl.getKeyAdapter()org.eclipse.swt.events.KeyAdapter;1
private KeyAdapter getKeyAdapter() {
    if (fKeyAdapter == null) {
        fKeyAdapter = new  KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(e);
                KeySequence keySequence = KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
                KeySequence[] sequences = getInvokingCommandKeySequences();
                if (sequences == null)
                    return;
                for (int i = 0; i < sequences.length; i++) {
                    if (sequences[i].equals(keySequence)) {
                        e.doit = false;
                        toggleHierarchy();
                        return;
                    }
                }
            }
        };
    }
    return fKeyAdapter;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.impl.EObjectImpl.eAdapters()org.eclipse.emf.common.util.EList;1
@Override
public EList<Adapter> eAdapters() {
    if (eAdapters == null) {
        eAdapters = new  EAdapterList<Adapter>(this);
    }
    return eAdapters;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.NewNameQueries.createPackageNameValidator(org.eclipse.jdt.core.IPackageFragment;)org.eclipse.jface.dialogs.IInputValidator;1
private static IInputValidator createPackageNameValidator(final IPackageFragment pack) {
    IInputValidator validator = new  IInputValidator() {

        public String isValid(String newText) {
            if (newText == null || "".equals(newText))
                return INVALID_NAME_NO_MESSAGE;
            IStatus status = JavaConventionsUtil.validatePackageName(newText, pack);
            if (status.getSeverity() == IStatus.ERROR)
                return status.getMessage();
            IJavaElement parent = pack.getParent();
            try {
                if (parent instanceof IPackageFragmentRoot) {
                    if (!RenamePackageProcessor.isPackageNameOkInRoot(newText, (IPackageFragmentRoot) parent))
                        return ReorgMessages.ReorgQueries_packagewithThatNameexistsMassage;
                }
            } catch (CoreException e) {
                return INVALID_NAME_NO_MESSAGE;
            }
            if (pack.getElementName().equalsIgnoreCase(newText))
                return ReorgMessages.ReorgQueries_resourceExistsWithDifferentCaseMassage;
            return null;
        }
    };
    return validator;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

---------------Library-------------------
method: org.eclipse.ui.internal.themes.Theme.getCascadeListener()org.eclipse.jface.util.IPropertyChangeListener;1
private IPropertyChangeListener getCascadeListener() {
    if (themeListener == null) {
        themeListener = new  IPropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                firePropertyChange(event);
            }
        };
    }
    return themeListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.NavigatorContentService.getExtensionStateService()org.eclipse.ui.internal.navigator.NavigatorExtensionStateService;1
public NavigatorExtensionStateService getExtensionStateService() {
    if (navigatorExtensionStateService == null) {
        navigatorExtensionStateService = new  NavigatorExtensionStateService(this);
    }
    return navigatorExtensionStateService;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.getAdapterFactories()org.eclipse.emf.common.util.EList;1
public EList<AdapterFactory> getAdapterFactories() {
    if (adapterFactories == null) {
        adapterFactories = new  BasicEList<AdapterFactory>() {

            private static final long serialVersionUID = 1L;

            @Override
            protected boolean useEquals() {
                return false;
            }

            @Override
            protected boolean isUnique() {
                return true;
            }

            @Override
            protected Object[] newData(int capacity) {
                return new AdapterFactory[capacity];
            }
        };
    }
    return adapterFactories;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.navigator.NavigatorContentService.getActivationService()org.eclipse.ui.navigator.INavigatorActivationService;1
public INavigatorActivationService getActivationService() {
    if (navigatorActivationService == null) {
        navigatorActivationService = new  NavigatorActivationService(this);
    }
    return navigatorActivationService;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceImpl.getErrors()org.eclipse.emf.common.util.EList;1
public EList<Diagnostic> getErrors() {
    if (errors == null) {
        errors = new  NotifyingListImpl<Diagnostic>() {

            private static final long serialVersionUID = 1L;

            @Override
            protected boolean isNotificationRequired() {
                return ResourceImpl.this.eNotificationRequired();
            }

            @Override
            public Object getNotifier() {
                return ResourceImpl.this;
            }

            @Override
            public int getFeatureID() {
                return RESOURCE__ERRORS;
            }
        };
    }
    return errors;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.contentassist.TypePackageCompletionProcessor.getComparator()java.util.Comparator;1
private Comparator<Object> getComparator() {
    if (fComparator == null) {
        fComparator = new  Comparator<Object>() {

            public int compare(Object arg0, Object arg1) {
                if (arg0 instanceof ICompletionProposal && arg1 instanceof ICompletionProposal) {
                    ICompletionProposal p1 = (ICompletionProposal) arg0;
                    ICompletionProposal p2 = (ICompletionProposal) arg1;
                    return getSortKey(p1).compareToIgnoreCase(getSortKey(p2));
                }
                return 0;
            }

            protected String getSortKey(ICompletionProposal p) {
                return p.getDisplayString();
            }
        };
    }
    return fComparator;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.quickaccess.QuickAccessDialog.getKeyAdapter()org.eclipse.swt.events.KeyAdapter;1
private KeyAdapter getKeyAdapter() {
    if (keyAdapter == null) {
        keyAdapter = new  KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(e);
                KeySequence keySequence = KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
                TriggerSequence[] sequences = getInvokingCommandKeySequences();
                if (sequences == null)
                    return;
                for (int i = 0; i < sequences.length; i++) {
                    if (sequences[i].equals(keySequence)) {
                        e.doit = false;
                        contents.setShowAllMatches(!contents.getShowAllMatches());
                        return;
                    }
                }
            }
        };
    }
    return keyAdapter;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
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
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ShowPartPaneMenuHandler.getEnabledWhenExpression()org.eclipse.core.expressions.Expression;1
@Override
protected Expression getEnabledWhenExpression() {
    if (enabledWhen == null) {
        enabledWhen = new  Expression() {

            @Override
            public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
                IWorkbenchPart part = InternalHandlerUtil.getActivePart(context);
                if (part != null) {
                    return EvaluationResult.TRUE;
                }
                return EvaluationResult.FALSE;
            }

            @Override
            public void collectExpressionInfo(ExpressionInfo info) {
                info.addVariableNameAccess(ISources.ACTIVE_PART_NAME);
            }
        };
    }
    return enabledWhen;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jface.action.ActionContributionItem.getToolItemListener()org.eclipse.swt.widgets.Listener;1
private Listener getToolItemListener() {
    if (toolItemListener == null) {
        toolItemListener = new  Listener() {

            @Override
            public void handleEvent(Event event) {
                switch(event.type) {
                    case SWT.Dispose:
                        handleWidgetDispose(event);
                        break;
                    case SWT.Selection:
                        Widget ew = event.widget;
                        if (ew != null) {
                            handleWidgetSelection(event, ((ToolItem) ew).getSelection());
                        }
                        break;
                }
            }
        };
    }
    return toolItemListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.actions.CommandAction.getCommandListener()org.eclipse.core.commands.ICommandListener;1
protected ICommandListener getCommandListener() {
    if (commandListener == null) {
        commandListener = new  ICommandListener() {

            @Override
            public void commandChanged(CommandEvent commandEvent) {
                if (commandEvent.isHandledChanged() || commandEvent.isEnabledChanged()) {
                    if (commandEvent.getCommand().isDefined()) {
                        setEnabled(commandEvent.getCommand().isEnabled());
                    }
                }
            }
        };
    }
    return commandListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jface.action.ContributionManager.getOverrides()org.eclipse.jface.action.IContributionManagerOverrides;1
@Override
public IContributionManagerOverrides getOverrides() {
    if (overrides == null) {
        overrides = new  IContributionManagerOverrides() {

            @Override
            public Boolean getEnabled(IContributionItem item) {
                return null;
            }

            @Override
            public Integer getAccelerator(IContributionItem item) {
                return null;
            }

            @Override
            public String getAcceleratorText(IContributionItem item) {
                return null;
            }

            @Override
            public String getText(IContributionItem item) {
                return null;
            }

            @Override
            public Boolean getVisible(IContributionItem item) {
                return null;
            }
        };
    }
    return overrides;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.ShowViewMenuHandler.getEnabledWhenExpression()org.eclipse.core.expressions.Expression;1
@Override
protected Expression getEnabledWhenExpression() {
    if (enabledWhen == null) {
        enabledWhen = new  Expression() {

            @Override
            public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
                return EvaluationResult.TRUE;
            }

            @Override
            public void collectExpressionInfo(ExpressionInfo info) {
                info.addVariableNameAccess(ISources.ACTIVE_PART_NAME);
            }
        };
    }
    return enabledWhen;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.layout.TrimToolBarBase.getDockingContribution()org.eclipse.jface.action.ContributionItem;1
private ContributionItem getDockingContribution() {
    if (dockContributionItem == null) {
        dockContributionItem = new  ContributionItem() {

            @Override
            public void fill(Menu menu, int index) {
                super.fill(menu, index);
                if (isCloseable()) {
                    MenuItem closeItem = new  MenuItem(menu, SWT.PUSH, index++);
                    closeItem.setText(WorkbenchMessages.TrimCommon_Close);
                    closeItem.addSelectionListener(new  SelectionListener() {

                        @Override
                        public void widgetSelected(SelectionEvent e) {
                            handleCloseTrim();
                        }

                        @Override
                        public void widgetDefaultSelected(SelectionEvent e) {
                        }
                    });
                    new  MenuItem(menu, SWT.SEPARATOR, index++);
                }
                dockCascade = new  MenuItem(menu, SWT.CASCADE, index++);
                {
                    dockCascade.setText(WorkbenchMessages.TrimCommon_DockOn);
                    sidesMenu = new  Menu(dockCascade);
                    radioButtons = new  RadioMenu(sidesMenu, radioVal);
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Top, new  Integer(SWT.TOP));
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Bottom, new  Integer(SWT.BOTTOM));
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Left, new  Integer(SWT.LEFT));
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Right, new  Integer(SWT.RIGHT));
                    dockCascade.setMenu(sidesMenu);
                }
                radioVal.addChangeListener(new  IChangeListener() {

                    @Override
                    public void update(boolean changed) {
                        if (changed) {
                            handleShowOnChange();
                        }
                    }
                });
            }
        };
    }
    return dockContributionItem;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.AbstractTextEditor.getCursorListener()org.eclipse.ui.texteditor.AbstractTextEditor$ICursorListener;1
protected final ICursorListener getCursorListener() {
    if (fCursorListener == null) {
        fCursorListener = new  ICursorListener() {

            public void keyPressed(KeyEvent e) {
                handleCursorPositionChanged();
            }

            public void keyReleased(KeyEvent e) {
            }

            public void mouseDoubleClick(MouseEvent e) {
            }

            public void mouseDown(MouseEvent e) {
            }

            public void mouseUp(MouseEvent e) {
                handleCursorPositionChanged();
            }
        };
    }
    return fCursorListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.core.commands.Command.getHandlerListener()org.eclipse.core.commands.IHandlerListener;1
private IHandlerListener getHandlerListener() {
    if (handlerListener == null) {
        handlerListener = new  IHandlerListener() {

            public void handlerChanged(HandlerEvent handlerEvent) {
                boolean enabledChanged = handlerEvent.isEnabledChanged();
                boolean handledChanged = handlerEvent.isHandledChanged();
                fireCommandChanged(new  CommandEvent(Command.this, false, false, false, handledChanged, false, false, false, false, enabledChanged));
            }
        };
    }
    return handlerListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jface.action.ActionContributionItem.getButtonListener()org.eclipse.swt.widgets.Listener;1
private Listener getButtonListener() {
    if (buttonListener == null) {
        buttonListener = new  Listener() {

            @Override
            public void handleEvent(Event event) {
                switch(event.type) {
                    case SWT.Dispose:
                        handleWidgetDispose(event);
                        break;
                    case SWT.Selection:
                        Widget ew = event.widget;
                        if (ew != null) {
                            handleWidgetSelection(event, ((Button) ew).getSelection());
                        }
                        break;
                }
            }
        };
    }
    return buttonListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.CloseEditorHandler.getEnabledWhenExpression()org.eclipse.core.expressions.Expression;1
@Override
protected Expression getEnabledWhenExpression() {
    if (enabledWhen == null) {
        enabledWhen = new  Expression() {

            @Override
            public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
                IEditorPart part = InternalHandlerUtil.getActiveEditor(context);
                if (part != null) {
                    return EvaluationResult.TRUE;
                }
                return EvaluationResult.FALSE;
            }

            @Override
            public void collectExpressionInfo(ExpressionInfo info) {
                info.addVariableNameAccess(ISources.ACTIVE_EDITOR_NAME);
            }
        };
    }
    return enabledWhen;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.texteditor.AbstractTextEditor.getSelectionChangedListener()org.eclipse.jface.viewers.ISelectionChangedListener;1
protected final ISelectionChangedListener getSelectionChangedListener() {
    if (fSelectionChangedListener == null) {
        fSelectionChangedListener = new  ISelectionChangedListener() {

            private Runnable fRunnable = new  Runnable() {

                public void run() {
                    if (fSourceViewer != null && fSourceViewer.getDocument() != null) {
                        handleCursorPositionChanged();
                        updateSelectionDependentActions();
                    }
                }
            };

            private Display fDisplay;

            public void selectionChanged(SelectionChangedEvent event) {
                if (fDisplay == null)
                    fDisplay = getSite().getShell().getDisplay();
                if (Display.getCurrent() == fDisplay)
                    fRunnable.run();
                else
                    fDisplay.asyncExec(fRunnable);
            }
        };
    }
    return fSelectionChangedListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.JavaOutlineInformationControl.getKeyAdapter()org.eclipse.swt.events.KeyAdapter;1
private KeyAdapter getKeyAdapter() {
    if (fKeyAdapter == null) {
        fKeyAdapter = new  KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(e);
                KeySequence keySequence = KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
                KeySequence[] sequences = getInvokingCommandKeySequences();
                if (sequences == null)
                    return;
                for (int i = 0; i < sequences.length; i++) {
                    if (sequences[i].equals(keySequence)) {
                        e.doit = false;
                        toggleShowInheritedMembers();
                        return;
                    }
                }
            }
        };
    }
    return fKeyAdapter;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.change.impl.ChangePackageImpl$1.getEValidator()org.eclipse.emf.ecore.EValidator;1
public EValidator getEValidator() {
    return new  EObjectValidator() {

        @Override
        protected EPackage getEPackage() {
            return changePackage;
        }

        @Override
        protected boolean validate_MultiplicityConforms(EObject eObject, EStructuralFeature eStructuralFeature, DiagnosticChain diagnostics, Map<Object, Object> context) {
            return eStructuralFeature == ChangePackage.Literals.FEATURE_CHANGE__FEATURE && ((FeatureChange) eObject).getFeature() != null || super.validate_MultiplicityConforms(eObject, eStructuralFeature, diagnostics, context);
        }
    };
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

---------------Library-------------------
method: org.eclipse.ui.internal.handlers.AbstractSaveHandler.getEnabledWhenExpression()org.eclipse.core.expressions.Expression;1
@Override
protected Expression getEnabledWhenExpression() {
    if (enabledWhen == null) {
        enabledWhen = new  Expression() {

            @Override
            public EvaluationResult evaluate(IEvaluationContext context) {
                return AbstractSaveHandler.this.evaluate(context);
            }

            @Override
            public void collectExpressionInfo(ExpressionInfo info) {
                info.addVariableNameAccess(ISources.ACTIVE_PART_NAME);
            }
        };
    }
    return enabledWhen;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.dialogs.TableTextCellEditor.getModifyListener()org.eclipse.swt.events.ModifyListener;1
private ModifyListener getModifyListener() {
    if (fModifyListener == null) {
        fModifyListener = new  ModifyListener() {

            public void modifyText(ModifyEvent e) {
                editOccured(e);
            }
        };
    }
    return fModifyListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jface.text.AbstractInformationControlManager.getSubjectControlDisposeListener()org.eclipse.swt.events.DisposeListener;1
private DisposeListener getSubjectControlDisposeListener() {
    if (fSubjectControlDisposeListener == null) {
        fSubjectControlDisposeListener = new  DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                handleSubjectControlDisposed();
            }
        };
    }
    return fSubjectControlDisposeListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElementAttribute.copy()org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElementAttribute;1
public CPListElementAttribute copy() {
    CPListElementAttribute result = new  CPListElementAttribute(fBuiltIn);
    result.fParent = fParent;
    result.fKey = fKey;
    result.fValue = fValue;
    result.fStatus = fStatus;
    return result;
}
---------------Client-------------------
method: org.eclipse.jface.layout.GridLayoutFactory.createFrom(org.eclipse.swt.layout.GridLayout;)org.eclipse.jface.layout.GridLayoutFactory;1
public static GridLayoutFactory createFrom(GridLayout l) {
    return new  GridLayoutFactory(copyLayout(l));
}
method: org.eclipse.jface.layout.GridLayoutFactory.copyLayout(org.eclipse.swt.layout.GridLayout;)org.eclipse.swt.layout.GridLayout;1
public static GridLayout copyLayout(GridLayout l) {
    GridLayout result = new  GridLayout(l.numColumns, l.makeColumnsEqualWidth);
    result.horizontalSpacing = l.horizontalSpacing;
    result.marginBottom = l.marginBottom;
    result.marginHeight = l.marginHeight;
    result.marginLeft = l.marginLeft;
    result.marginRight = l.marginRight;
    result.marginTop = l.marginTop;
    result.marginWidth = l.marginWidth;
    result.verticalSpacing = l.verticalSpacing;
    return result;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElementAttribute.getClasspathAttributeAccess()org.eclipse.jdt.ui.wizards.ClasspathAttributeConfiguration$ClasspathAttributeAccess;1
public ClasspathAttributeAccess getClasspathAttributeAccess() {
    if (fCachedAccess == null) {
        fCachedAccess = new  ClasspathAttributeAccess() {

            @Override
            public IClasspathAttribute getClasspathAttribute() {
                return CPListElementAttribute.this.getClasspathAttribute();
            }

            @Override
            public IJavaProject getJavaProject() {
                return getParent().getJavaProject();
            }

            @Override
            public IClasspathEntry getParentClasspassEntry() {
                return getParent().getClasspathEntry();
            }
        };
    }
    return fCachedAccess;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.themes.Theme.getPropertyListener()org.eclipse.jface.util.IPropertyChangeListener;1
private IPropertyChangeListener getPropertyListener() {
    if (propertyListener == null) {
        propertyListener = new  IPropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                String[] split = ThemeElementHelper.splitPropertyName(Theme.this, event.getProperty());
                String key = split[1];
                String theme = split[0];
                if (key.equals(IWorkbenchPreferenceConstants.CURRENT_THEME_ID)) {
                    return;
                }
                try {
                    String thisTheme = getId();
                    if (Util.equals(thisTheme, theme)) {
                        if (getFontRegistry().hasValueFor(key)) {
                            FontData[] data = PreferenceConverter.basicGetFontData((String) event.getNewValue());
                            getFontRegistry().put(key, data);
                            processDefaultsTo(key, data);
                            return;
                        } else if (getColorRegistry().hasValueFor(key)) {
                            RGB rgb = StringConverter.asRGB((String) event.getNewValue());
                            getColorRegistry().put(key, rgb);
                            processDefaultsTo(key, rgb);
                            return;
                        }
                    }
                } catch (DataFormatException e) {
                }
            }

            private void processDefaultsTo(String key, FontData[] fd) {
                FontDefinition[] defs = WorkbenchPlugin.getDefault().getThemeRegistry().getFontsFor(getId());
                for (int i = 0; i < defs.length; i++) {
                    String defaultsTo = defs[i].getDefaultsTo();
                    if (defaultsTo != null && defaultsTo.equals(key)) {
                        IPreferenceStore store = WorkbenchPlugin.getDefault().getPreferenceStore();
                        if (store.isDefault(ThemeElementHelper.createPreferenceKey(Theme.this, defs[i].getId()))) {
                            getFontRegistry().put(defs[i].getId(), fd);
                            processDefaultsTo(defs[i].getId(), fd);
                        }
                    }
                }
            }

            private void processDefaultsTo(String key, RGB rgb) {
                ColorDefinition[] defs = WorkbenchPlugin.getDefault().getThemeRegistry().getColorsFor(getId());
                for (int i = 0; i < defs.length; i++) {
                    String defaultsTo = defs[i].getDefaultsTo();
                    if (defaultsTo != null && defaultsTo.equals(key)) {
                        IPreferenceStore store = WorkbenchPlugin.getDefault().getPreferenceStore();
                        if (store.isDefault(ThemeElementHelper.createPreferenceKey(Theme.this, defs[i].getId()))) {
                            getColorRegistry().put(defs[i].getId(), rgb);
                            processDefaultsTo(defs[i].getId(), rgb);
                        }
                    }
                }
            }
        };
    }
    return propertyListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.emf.ecore.resource.impl.ResourceImpl.getWarnings()org.eclipse.emf.common.util.EList;1
public EList<Diagnostic> getWarnings() {
    if (warnings == null) {
        warnings = new  NotifyingListImpl<Diagnostic>() {

            private static final long serialVersionUID = 1L;

            @Override
            protected boolean isNotificationRequired() {
                return ResourceImpl.this.eNotificationRequired();
            }

            @Override
            public Object getNotifier() {
                return ResourceImpl.this;
            }

            @Override
            public int getFeatureID() {
                return RESOURCE__WARNINGS;
            }
        };
    }
    return warnings;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.part.MultiPageEditorSite.getPostSelectionChangedListener()org.eclipse.jface.viewers.ISelectionChangedListener;1
private ISelectionChangedListener getPostSelectionChangedListener() {
    if (postSelectionChangedListener == null) {
        postSelectionChangedListener = new  ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                MultiPageEditorSite.this.handlePostSelectionChanged(event);
            }
        };
    }
    return postSelectionChangedListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.apt.ui.internal.preferences.BaseConfigurationBlock.getSelectionListener()org.eclipse.swt.events.SelectionListener;1
protected SelectionListener getSelectionListener() {
    if (fSelectionListener == null) {
        fSelectionListener = new  SelectionListener() {

            public void widgetDefaultSelected(SelectionEvent e) {
            }

            public void widgetSelected(SelectionEvent e) {
                controlChanged(e.widget);
            }
        };
    }
    return fSelectionListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.views.properties.PropertySheetPage.getCellEditorActivationListener()org.eclipse.ui.views.properties.ICellEditorActivationListener;1
private ICellEditorActivationListener getCellEditorActivationListener() {
    if (cellEditorActivationListener == null) {
        cellEditorActivationListener = new  ICellEditorActivationListener() {

            public void cellEditorActivated(CellEditor cellEditor) {
                if (cellEditorActionHandler != null) {
                    cellEditorActionHandler.addCellEditor(cellEditor);
                }
            }

            public void cellEditorDeactivated(CellEditor cellEditor) {
                if (cellEditorActionHandler != null) {
                    cellEditorActionHandler.removeCellEditor(cellEditor);
                }
            }
        };
    }
    return cellEditorActivationListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.handlers.HandlerProxy.getHandlerListener()org.eclipse.core.commands.IHandlerListener;1
private IHandlerListener getHandlerListener() {
    if (handlerListener == null) {
        handlerListener = new  IHandlerListener() {

            @Override
            public void handlerChanged(HandlerEvent handlerEvent) {
                fireHandlerChanged(new  HandlerEvent(HandlerProxy.this, handlerEvent.isEnabledChanged(), handlerEvent.isHandledChanged()));
            }
        };
    }
    return handlerListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.NewNameQueries.createCompilationUnitNameValidator(org.eclipse.jdt.core.ICompilationUnit;)org.eclipse.jface.dialogs.IInputValidator;1
private static IInputValidator createCompilationUnitNameValidator(final ICompilationUnit cu) {
    IInputValidator validator = new  IInputValidator() {

        public String isValid(String newText) {
            if (newText == null || "".equals(newText))
                return INVALID_NAME_NO_MESSAGE;
            String newCuName = JavaModelUtil.getRenamedCUName(cu, newText);
            IStatus status = JavaConventionsUtil.validateCompilationUnitName(newCuName, cu);
            if (status.getSeverity() == IStatus.ERROR)
                return status.getMessage();
            RefactoringStatus refStatus;
            refStatus = Checks.checkCompilationUnitNewName(cu, newText);
            if (refStatus.hasFatalError())
                return refStatus.getMessageMatchingSeverity(RefactoringStatus.FATAL);
            if (cu.getElementName().equalsIgnoreCase(newCuName))
                return ReorgMessages.ReorgQueries_resourceExistsWithDifferentCaseMassage;
            return null;
        }
    };
    return validator;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.preferences.OptionsConfigurationBlock.getSelectionListener()org.eclipse.swt.events.SelectionListener;1
protected SelectionListener getSelectionListener() {
    if (fSelectionListener == null) {
        fSelectionListener = new  SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                controlChanged(e.widget);
            }
        };
    }
    return fSelectionListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.menus.FocusControlSourceProvider.getDisposeListener()org.eclipse.swt.events.DisposeListener;1
private DisposeListener getDisposeListener() {
    if (disposeListener == null) {
        disposeListener = new  DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                controlToId.remove(e.widget);
                if (currentControl == e.widget) {
                    focusIn(null);
                }
            }
        };
    }
    return disposeListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ua.ui.editor.cheatsheet.simple.SimpleCSBlock.modelChanged(org.eclipse.pde.core.IModelChangedEvent;)V2
public void modelChanged(IModelChangedEvent event) {
    if (fMasterSection != null) {
        fMasterSection.modelChanged(event);
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ccvs.ui.subscriber.CVSChangeSetActionGroup.initialize(org.eclipse.team.ui.synchronize.ISynchronizePageConfiguration;)V2
public void initialize(ISynchronizePageConfiguration configuration) {
    super.initialize(configuration);
    openCommitSet = new  OpenChangeSetAction(configuration);
}
method: org.eclipse.team.ui.synchronize.SynchronizePageActionGroup.initialize(org.eclipse.team.ui.synchronize.ISynchronizePageConfiguration;)V2
public void initialize(ISynchronizePageConfiguration configuration) {
    this.configuration = configuration;
    if (visibleRootSelectionProvider != null) {
        configuration.addActionContribution(visibleRootSelectionProvider);
    }
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.UnionSet.getterCalled()V1
protected void getterCalled() {
    super.getterCalled();
    if (refCounts == null) {
        setWrappedSet(computeElements());
    }
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.CommonViewerAdvisor$NavigableCommonViewer.initDragAndDrop()V1
protected void initDragAndDrop() {
    getNavigatorContentService().getDnDService().bindDragAssistant(new  ResourceDragAdapterAssistant());
    super.initDragAndDrop();
}
method: org.eclipse.ui.internal.navigator.NavigatorContentService.getDnDService()org.eclipse.ui.navigator.INavigatorDnDService;1
public INavigatorDnDService getDnDService() {
    if (navigatorDnDService == null) {
        navigatorDnDService = new  NavigatorDnDService(this);
    }
    return navigatorDnDService;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.refactoring.reorg.NewNameQueries.createResourceNameValidator(org.eclipse.core.resources.IResource;)org.eclipse.jface.dialogs.IInputValidator;1
private static IInputValidator createResourceNameValidator(final IResource res) {
    IInputValidator validator = new  IInputValidator() {

        public String isValid(String newText) {
            if (newText == null || "".equals(newText) || res.getParent() == null)
                return INVALID_NAME_NO_MESSAGE;
            if (res.getParent().findMember(newText) != null)
                return ReorgMessages.ReorgQueries_resourceWithThisNameAlreadyExists;
            if (!res.getParent().getFullPath().isValidSegment(newText))
                return ReorgMessages.ReorgQueries_invalidNameMessage;
            IStatus status = res.getParent().getWorkspace().validateName(newText, res.getType());
            if (status.getSeverity() == IStatus.ERROR)
                return status.getMessage();
            if (res.getName().equalsIgnoreCase(newText))
                return ReorgMessages.ReorgQueries_resourceExistsWithDifferentCaseMassage;
            return null;
        }
    };
    return validator;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

---------------Library-------------------
method: org.eclipse.ui.menus.CommandContributionItem.getItemListener()org.eclipse.swt.widgets.Listener;1
private Listener getItemListener() {
    if (menuItemListener == null) {
        menuItemListener = new  Listener() {

            @Override
            public void handleEvent(Event event) {
                switch(event.type) {
                    case SWT.Dispose:
                        handleWidgetDispose(event);
                        break;
                    case SWT.Selection:
                        if (event.widget != null) {
                            handleWidgetSelection(event);
                        }
                        break;
                }
            }
        };
    }
    return menuItemListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.ui.internal.layout.TrimCommonUIHandle.getDockingContribution()org.eclipse.jface.action.ContributionItem;1
public ContributionItem getDockingContribution() {
    if (dockContributionItem == null) {
        dockContributionItem = new  ContributionItem() {

            @Override
            public void fill(Menu menu, int index) {
                super.fill(menu, index);
                if (trim.isCloseable()) {
                    MenuItem closeItem = new  MenuItem(menu, SWT.PUSH, index++);
                    closeItem.setText(WorkbenchMessages.TrimCommon_Close);
                    closeItem.addSelectionListener(new  SelectionListener() {

                        @Override
                        public void widgetSelected(SelectionEvent e) {
                            handleCloseTrim();
                        }

                        @Override
                        public void widgetDefaultSelected(SelectionEvent e) {
                        }
                    });
                    new  MenuItem(menu, SWT.SEPARATOR, index++);
                }
                dockCascade = new  MenuItem(menu, SWT.CASCADE, index++);
                {
                    dockCascade.setText(WorkbenchMessages.TrimCommon_DockOn);
                    sidesMenu = new  Menu(dockCascade);
                    radioButtons = new  RadioMenu(sidesMenu, radioVal);
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Top, new  Integer(SWT.TOP));
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Bottom, new  Integer(SWT.BOTTOM));
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Left, new  Integer(SWT.LEFT));
                    radioButtons.addMenuItem(WorkbenchMessages.TrimCommon_Right, new  Integer(SWT.RIGHT));
                    dockCascade.setMenu(sidesMenu);
                }
                radioVal.addChangeListener(new  IChangeListener() {

                    @Override
                    public void update(boolean changed) {
                        if (changed) {
                            handleShowOnChange();
                        }
                    }
                });
            }
        };
    }
    return dockContributionItem;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jface.action.ActionContributionItem.getMenuCreatorListener()org.eclipse.swt.widgets.Listener;1
private Listener getMenuCreatorListener() {
    if (menuCreatorListener == null) {
        menuCreatorListener = new  Listener() {

            @Override
            public void handleEvent(Event event) {
                switch(event.type) {
                    case SWT.Show:
                        handleShowProxy((Menu) event.widget);
                        break;
                    case SWT.Hide:
                        handleHideProxy((Menu) event.widget);
                        break;
                }
            }
        };
    }
    return menuCreatorListener;
}
---------------Client-------------------
method: org.eclipse.pde.internal.core.feature.FeatureFactory.createChild()org.eclipse.pde.internal.core.ifeature.IFeatureChild;1
public IFeatureChild createChild() {
    FeatureChild child = new  FeatureChild();
    child.model = model;
    child.parent = model.getFeature();
    return child;
}
method: org.eclipse.pde.internal.core.feature.AbstractFeatureModel.getFeature()org.eclipse.pde.internal.core.ifeature.IFeature;1
public IFeature getFeature() {
    if (feature == null) {
        Feature f = new  Feature();
        f.model = this;
        this.feature = f;
    }
    return feature;
}

---------------Library-------------------
method: org.eclipse.jdt.junit.launcher.JUnitLaunchConfigurationTab$14.getFilterExtension()org.eclipse.jdt.ui.dialogs.ITypeInfoFilterExtension;1
@Override
public ITypeInfoFilterExtension getFilterExtension() {
    return new  ITypeInfoFilterExtension() {

        public boolean select(ITypeInfoRequestor requestor) {
            StringBuffer buf = new  StringBuffer();
            buf.append(requestor.getPackageName()).append('/');
            String enclosingName = requestor.getEnclosingName();
            if (enclosingName.length() > 0)
                buf.append(enclosingName).append('.');
            buf.append(requestor.getTypeName());
            return typeLookup.contains(buf.toString());
        }
    };
}
---------------Client-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openWriter()java.io.Writer;1
@Override
public Writer openWriter() throws IOException {
    return new  PrintWriter(openOutputStream());
}
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeOutputJavaFileObject.openOutputStream()java.io.OutputStream;1
@Override
public OutputStream openOutputStream() throws IOException {
    return new  IdeJavaSourceOutputStream(_env, _name, _parentFiles);
}

