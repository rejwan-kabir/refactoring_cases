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

/** not refactoring. In this case, it looks like the method body in the Client can
 be extracted in the same way as the Library does, but the reason the code is 
 written in this way is beacause that part of logic belongs to its superclass, 
 also there is no reason to extract the if-clause as a method. */
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
/* it's refactoring. we can extract the body from removeListener and name it
 as removeListernerInternal(). One question is that is this refactoring 
 meaningful? If this piece of code for removing listener is not needed elsewhere,
 then there is no need to extract it, because the original method is short enough
 and only has this one functionality.
 It also makes sense to inline the addListenerInternal back to addListener(). But
 it's possible that addListenerInternal() will be called in different places, and
 passed in differnet filters, in this case it should not be inlined.*/

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
/*not refactoring. The extract method suggested by requestMarketUpdate() can not 
 be performed on updateControl(). The pair is matched because the instructions of each
 method become the same after inlining.*/

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
/*not refactoring. The setMemberFilter() in Library doesn't suggest a way to perform
 extract method on refreshTag(). */

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
/*not refactoring. In this case, the consumeEmptyArgumentListop() trivially calls
 pushOnExpressionStackLengthStack() and becomes the same as the Client method after
 inlining. There is nothing to extract from the Client method, because it's already
 the same as the callee in Library.*/

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
/*refactoring. the two statements accepted.add(license.getUUID()) and return true in Client 
can be extracted as in the Library.*/

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

/*not refactoring. The method body in the Client method can not be seperated, and it doesn't
make sense to extract the whole body into a new method.*/