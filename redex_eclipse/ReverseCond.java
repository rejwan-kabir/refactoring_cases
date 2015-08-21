/**
* You have a conditional that would be easier to understand if you reversed its sense.
* Reverse the sense of the conditional and reorder the conditional's clauses.
*
* The results do not match the definition of Reverse Conditional Refactoring.
*/
---------------Library-------------------
method: org.eclipse.core.commands.contexts.ContextManager.removeActiveContext(java.lang.String;)V2
public final void removeActiveContext(final String contextId) {
    if (!activeContextIds.contains(contextId)) {
        return;
    }
    activeContextsChange = true;
    if (caching) {
        activeContextIds.remove(contextId);
    } else {
        final Set previouslyActiveContextIds = new  HashSet(activeContextIds);
        activeContextIds.remove(contextId);
        fireContextManagerChanged(new  ContextManagerEvent(this, null, false, true, previouslyActiveContextIds));
    }
    if (DEBUG) {
        Tracing.printTrace("CONTEXTS", activeContextIds.toString());
    }
}
---------------Client-------------------
method: org.eclipse.core.commands.contexts.ContextManager.addActiveContext(java.lang.String;)V2
public final void addActiveContext(final String contextId) {
    if (activeContextIds.contains(contextId)) {
        return;
    }
    activeContextsChange = true;
    if (caching) {
        activeContextIds.add(contextId);
    } else {
        final Set previouslyActiveContextIds = new  HashSet(activeContextIds);
        activeContextIds.add(contextId);
        fireContextManagerChanged(new  ContextManagerEvent(this, null, false, true, previouslyActiveContextIds));
    }
    if (DEBUG) {
        Tracing.printTrace("CONTEXTS", activeContextIds.toString());
    }
}
// false positive. The conditional in the Library doesn't need to be reversed.
---------------Library-------------------
method: org.eclipse.core.resources.ResourceAttributes.isArchive()Z1
public boolean isArchive() {
    return (attributes & EFS.ATTRIBUTE_ARCHIVE) != 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding.isDefault()Z1
public final boolean isDefault() {
    return (this.modifiers & (ClassFileConstants.AccPublic | ClassFileConstants.AccProtected | ClassFileConstants.AccPrivate)) == 0;
}
// false positive. The code should at least contains a complete if-then-else block.
---------------Library-------------------
method: org.eclipse.core.internal.utils.Cache$Entry.compare(org.eclipse.core.internal.utils.KeyedHashSet$KeyedElement;)Z2
public boolean compare(KeyedHashSet.KeyedElement other) {
    if (!(other instanceof Entry))
        return false;
    Entry otherEntry = (Entry) other;
    return key.equals(otherEntry.key);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.SubTypesSet.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object o) {
    if (o instanceof SubTypesSet) {
        SubTypesSet other = (SubTypesSet) o;
        return other.fUpperBounds.equals(fUpperBounds);
    } else
        return false;
}
// false positive. The code should at least contains a complete if-then-else block.
---------------Library-------------------
method: org.eclipse.core.internal.resources.ProjectDescription.getFilter(org.eclipse.core.runtime.IPath;)java.util.LinkedList;2
public synchronized LinkedList<FilterDescription> getFilter(IPath aPath) {
    if (filterDescriptions == null)
        return null;
    return filterDescriptions.get(aPath);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.MethodOverrideTester$Substitutions.getSubstArray(java.lang.String;)Ajava.lang.String;2
private String[] getSubstArray(String typeVariable) {
    if (fMap != null) {
        return fMap.get(typeVariable);
    }
    return null;
}
// false positive

---------------Library-------------------
method: org.eclipse.core.commands.common.AbstractHandleObjectEvent.isDefinedChanged()Z1
public final boolean isDefinedChanged() {
    return ((changedValues & CHANGED_DEFINED) != 0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.DefaultProblem.isWarning()Z1
public boolean isWarning() {
    return (this.severity & ProblemSeverities.Error) == 0;
}
// false positive

---------------Library-------------------
method: org.eclipse.core.internal.expressions.IterateExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof IterateExpression))
        return false;
    final IterateExpression that = (IterateExpression) object;
    return (this.fOperator == that.fOperator) && equals(this.fExpressions, that.fExpressions);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$ExceptionMarker.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (obj instanceof ExceptionMarker) {
        ExceptionMarker marker = (ExceptionMarker) obj;
        return this.pc == marker.pc && CharOperation.equals(this.constantPoolName, marker.constantPoolName);
    }
    return false;
}
// false positive 
---------------Library-------------------
method: org.eclipse.core.internal.databinding.property.set.SimplePropertyObservableSet.remove(java.lang.Object;)Z2
public boolean remove(Object o) {
    getterCalled();
    Set set = getSet();
    if (!set.contains(o))
        return false;
    SetDiff diff = Diffs.createSetDiff(Collections.EMPTY_SET, Collections.singleton(o));
    updateSet(set, diff);
    return true;
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.property.set.SimplePropertyObservableSet.add(java.lang.Object;)Z2
public boolean add(Object o) {
    checkRealm();
    Set set = getSet();
    if (set.contains(o))
        return false;
    SetDiff diff = Diffs.createSetDiff(Collections.singleton(o), Collections.EMPTY_SET);
    updateSet(set, diff);
    return true;
}
// false positive
---------------Library-------------------
method: org.eclipse.core.internal.utils.ObjectMap.isEmpty()Z1
public boolean isEmpty() {
    return count == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.InternalCompletionContext.isInJavadoc()Z1
public boolean isInJavadoc() {
    return this.javadoc != 0;
}
// false positive

---------------Library-------------------
method: org.eclipse.core.commands.Category.fireCategoryChanged(org.eclipse.core.commands.CategoryEvent;)V2
private final void fireCategoryChanged(final CategoryEvent categoryEvent) {
    if (categoryEvent == null) {
        throw new  NullPointerException();
    }
    if (categoryListeners != null) {
        final Iterator listenerItr = categoryListeners.iterator();
        while (listenerItr.hasNext()) {
            final ICategoryListener listener = (ICategoryListener) listenerItr.next();
            listener.categoryChanged(categoryEvent);
        }
    }
}
---------------Client-------------------
method: org.eclipse.core.commands.contexts.Context.fireContextChanged(org.eclipse.core.commands.contexts.ContextEvent;)V2
private final void fireContextChanged(final ContextEvent event) {
    if (event == null) {
        throw new  NullPointerException("Cannot send a null event to listeners.");
    }
    if (listeners == null) {
        return;
    }
    final Iterator listenerItr = listeners.iterator();
    while (listenerItr.hasNext()) {
        final IContextListener listener = (IContextListener) listenerItr.next();
        listener.contextChanged(event);
    }
}
// false positive

---------------Library-------------------
method: org.eclipse.core.databinding.observable.map.AbstractObservableMap.addChangeListener(org.eclipse.core.databinding.observable.IChangeListener;)V2
public synchronized void addChangeListener(IChangeListener listener) {
    if (!disposed) {
        changeSupport.addChangeListener(listener);
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.internal.workbench.swt.AnimationEngine.updateDisplay()V1
protected void updateDisplay() {
    if (animationCanceled)
        return;
    feedbackRenderer.renderStep(this);
}
// false positive

---------------Library-------------------
method: org.eclipse.core.commands.NamedHandleObjectWithState.removeState(java.lang.String;)V2
public void removeState(final String id) {
    if (id == null) {
        throw new  NullPointerException("Cannot remove a null id");
    }
    if (states != null) {
        states.remove(id);
        if (states.isEmpty()) {
            states = null;
        }
    }
}
---------------Client-------------------
method: org.eclipse.core.commands.contexts.Context.removeContextListener(org.eclipse.core.commands.contexts.IContextListener;)V2
public final void removeContextListener(final IContextListener contextListener) {
    if (contextListener == null) {
        throw new  NullPointerException("Cannot remove a null listener.");
    }
    if (listeners == null) {
        return;
    }
    listeners.remove(contextListener);
    if (listeners.isEmpty()) {
        listeners = null;
    }
}
// false positive

---------------Library-------------------
method: org.eclipse.core.runtime.Status.isOK()Z1
public boolean isOK() {
    return severity == OK;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.hasErrors()Z1
public boolean hasErrors() {
    return this.numberOfErrors != 0;
}
// false positive

---------------Library-------------------
method: org.eclipse.core.internal.registry.KeyedHashSet.isEmpty()Z1
public boolean isEmpty() {
    return elementCount == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.hasProblems()Z1
public boolean hasProblems() {
    return this.problemCount != 0;
}
// false positive

---------------Library-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.WinHttpCurrentUserIEProxyConfig.isStaticProxy()Z1
public boolean isStaticProxy() {
    return proxy != null && proxy.length() != 0;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.Profile.hasSubProfiles()Z1
public boolean hasSubProfiles() {
    return subProfileIds != null && !subProfileIds.isEmpty();
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.InternalJob.isRunCanceled()Z1
final boolean isRunCanceled() {
    return (flags & M_RUN_CANCELED) != 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding.canBeInstantiated()Z1
public boolean canBeInstantiated() {
    return (this.modifiers & (ClassFileConstants.AccAbstract | ClassFileConstants.AccInterface | ClassFileConstants.AccEnum | ClassFileConstants.AccAnnotation)) == 0;
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.Semaphore.hashCode()I1
@Override
public int hashCode() {
    return runnable == null ? 0 : runnable.hashCode();
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.CSSPropertyListImpl.getLength()I1
@Override
public int getLength() {
    return (properties != null) ? properties.size() : 0;
}

---------------Library-------------------
method: org.eclipse.core.runtime.ListenerList.isEmpty()Z1
public boolean isEmpty() {
    return listeners.length == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.PackageFragmentInfo.containsJavaResources()Z1
boolean containsJavaResources() {
    return this.children.length != 0;
}

---------------Library-------------------
method: org.eclipse.core.runtime.PerformanceStats.removeListener(org.eclipse.core.runtime.PerformanceStats$PerformanceListener;)V1
public static void removeListener(PerformanceListener listener) {
    if (ENABLED)
        PerformanceStatsProcessor.removeListener(listener);
}
---------------Client-------------------
method: org.eclipse.core.runtime.PerformanceStats.printStats(java.io.PrintWriter;)V1
public static void printStats(PrintWriter out) {
    if (!ENABLED)
        return;
    PerformanceStatsProcessor.printStats(out);
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.observable.Queue.isEmpty()Z1
public boolean isEmpty() {
    return first == null;
}
---------------Client-------------------
method: org.eclipse.core.commands.CommandManagerEvent.isCategoryChanged()Z1
public final boolean isCategoryChanged() {
    return (categoryId != null);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.ProjectDescription.getLocation()org.eclipse.core.runtime.IPath;1
public IPath getLocation() {
    if (location == null)
        return null;
    return FileUtil.toPath(location);
}
---------------Client-------------------
method: org.eclipse.equinox.p2.operations.ProfileChangeOperation.getProvisioningPlan()org.eclipse.equinox.p2.engine.IProvisioningPlan;1
public IProvisioningPlan getProvisioningPlan() {
    if (job != null)
        return job.getProvisioningPlan();
    return null;
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.DeadlockDetector.ownsRuleLocks(java.lang.Thread;)Z2
private boolean ownsRuleLocks(Thread owner) {
    int threadIndex = indexOf(owner, false);
    for (int j = 0; j < graph[threadIndex].length; j++) {
        if (graph[threadIndex][j] > NO_STATE) {
            Object lock = locks.get(j);
            if (!(lock instanceof ILock))
                return true;
        }
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.core.internal.jobs.DeadlockDetector.ownsRealLocks(java.lang.Thread;)Z2
private boolean ownsRealLocks(Thread owner) {
    int threadIndex = indexOf(owner, false);
    for (int j = 0; j < graph[threadIndex].length; j++) {
        if (graph[threadIndex][j] > NO_STATE) {
            Object lock = locks.get(j);
            if (lock instanceof ILock)
                return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.WinHttpCurrentUserIEProxyConfig.isAutoConfigUrl()Z1
public boolean isAutoConfigUrl() {
    return autoConfigUrl != null && autoConfigUrl.length() != 0;
}
---------------Client-------------------
method: org.eclipse.equinox.p2.publisher.eclipse.FeatureEntry.isUnpack()Z1
public boolean isUnpack() {
    return (unpack == null || unpack.booleanValue());
}

---------------Library-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.apt.model.AnnotationValueImpl.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object obj) {
    if (obj instanceof AnnotationValueImpl) {
        return this._value.equals(((AnnotationValueImpl) obj)._value);
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.core.commands.common.EventManager.isListenerAttached()Z1
protected final boolean isListenerAttached() {
    return listenerList != null;
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.Queue.isEmpty()Z1
public boolean isEmpty() {
    return first == null;
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.observable.DelayedObservableValue.cancelScheduledUpdate()V1
private void cancelScheduledUpdate() {
    if (updater != null) {
        updater.cancel();
        updater = null;
    }
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.addons.dndaddon.SplitDropAgent.clearFeedback()V1
private void clearFeedback() {
    if (feedback == null)
        return;
    feedback.dispose();
    feedback = null;
}

---------------Library-------------------
method: org.eclipse.core.commands.operations.TriggeredOperations.canUndo()Z1
public boolean canUndo() {
    if (triggeringOperation != null) {
        return triggeringOperation.canUndo();
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.TypeInfoFilter.getPackageFlags()I1
public int getPackageFlags() {
    if (fPackageMatcher == null)
        return SearchPattern.R_EXACT_MATCH;
    return fPackageMatcher.getMatchKind();
}

---------------Library-------------------
method: org.eclipse.core.commands.CommandEvent.isEnabledChanged()Z1
public final boolean isEnabledChanged() {
    return ((changedValues & CHANGED_ENABLED) != 0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding.isClass()Z1
public boolean isClass() {
    return (this.modifiers & (ClassFileConstants.AccInterface | ClassFileConstants.AccAnnotation | ClassFileConstants.AccEnum)) == 0;
}

---------------Library-------------------
method: org.eclipse.core.internal.expressions.SystemTestExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof SystemTestExpression))
        return false;
    final SystemTestExpression that = (SystemTestExpression) object;
    return this.fProperty.equals(that.fProperty) && this.fExpectedValue.equals(that.fExpectedValue);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetIntersection.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object o) {
    if (o instanceof TypeSetIntersection) {
        TypeSetIntersection other = (TypeSetIntersection) o;
        return other.fLHS.equals(fLHS) && other.fRHS.equals(fRHS);
    } else
        return false;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.FilterDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    FilterDescription other = (FilterDescription) obj;
    if (id != other.id)
        return false;
    return true;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.impl.LongConstant.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    LongConstant other = (LongConstant) obj;
    return this.value == other.value;
}

---------------Library-------------------
method: org.eclipse.core.expressions.EvaluationContext.getAllowPluginActivation()Z1
public boolean getAllowPluginActivation() {
    if (fAllowPluginActivation == null) {
        if (fParent != null)
            return fParent.getAllowPluginActivation();
        return false;
    }
    return fAllowPluginActivation.booleanValue();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.indexing.AddJarFileToIndex.hashCode()I1
public int hashCode() {
    if (this.resource != null)
        return this.resource.hashCode();
    if (this.containerPath != null)
        return this.containerPath.hashCode();
    return -1;
}

---------------Library-------------------
method: org.eclipse.core.internal.utils.Cache$Entry.isTail()Z1
public boolean isTail() {
    return next == null;
}
---------------Client-------------------
method: org.eclipse.core.commands.CommandManagerEvent.isCommandChanged()Z1
public final boolean isCommandChanged() {
    return (commandId != null);
}

---------------Library-------------------
method: org.eclipse.core.internal.expressions.EqualsExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof EqualsExpression))
        return false;
    final EqualsExpression that = (EqualsExpression) object;
    return this.fExpectedValue.equals(that.fExpectedValue);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.SuperTypesSet.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object o) {
    if (o instanceof SuperTypesSet) {
        SuperTypesSet other = (SuperTypesSet) o;
        return other.fLowerBounds.equals(fLowerBounds);
    } else
        return false;
}

---------------Library-------------------
method: org.eclipse.core.commands.CommandManagerEvent.isParameterTypeChanged()Z1
public final boolean isParameterTypeChanged() {
    return (parameterTypeId != null);
}
---------------Client-------------------
method: org.eclipse.core.internal.utils.Cache$Entry.isHead()Z1
public boolean isHead() {
    return previous == null;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.WorkManager.isBalanced()Z1
boolean isBalanced() {
    return nestedOperations == preparedOperations;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.nls.NLSSubstitution.hasStateChanged()Z1
public boolean hasStateChanged() {
    return fState != fInitialState;
}

---------------Library-------------------
method: org.eclipse.core.internal.dtree.NodeComparison.isUnchanged()Z1
boolean isUnchanged() {
    return userInt == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.hasTasks()Z1
public boolean hasTasks() {
    return this.taskCount != 0;
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.MarkerAttributeMap.isEmpty()Z1
public boolean isEmpty() {
    return count == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.NullAnnotationMatching.isAnyMismatch()Z1
public boolean isAnyMismatch() {
    return this.severity != 0;
}

---------------Library-------------------
method: org.eclipse.core.runtime.content.XMLContentDescriber.isNonDefaultCharset(java.lang.String;)Z2
private boolean isNonDefaultCharset(String charset) {
    if (charset == null)
        return false;
    if (charset.equalsIgnoreCase("utf8") || charset.equalsIgnoreCase("utf-8"))
        return false;
    return true;
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.properties.custom.CSSPropertyUnselectedTabsSWTHandler.isUnselectedTabsColorProp(java.lang.String;)Z2
private boolean isUnselectedTabsColorProp(String property) {
    return UNSELECTED_TABS_COLOR_PROP.equals(property) || DEPRECATED_UNSELECTED_TABS_COLOR_PROP.equals(property);
}

---------------Library-------------------
method: org.eclipse.core.commands.contexts.ContextManagerEvent.isContextChanged()Z1
public final boolean isContextChanged() {
    return (contextId != null);
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.helpers.URI.isRelative()Z1
public boolean isRelative() {
    return scheme == null;
}

---------------Library-------------------
method: org.eclipse.core.internal.dtree.NoDataDeltaNode.isEmptyDelta()Z1
boolean isEmptyDelta() {
    return this.size() == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.util.AbstractExceptionAnalyzer.visit(org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;)Z2
@Override
public boolean visit(AnnotationTypeDeclaration node) {
    if (node.isLocalTypeDeclaration())
        return false;
    return true;
}

---------------Library-------------------
method: org.eclipse.core.filebuffers.manipulation.GenericFileBufferOperationRunner.findSynchronizedFileBuffers(Aorg.eclipse.core.filebuffers.IFileBuffer;)Aorg.eclipse.core.filebuffers.IFileBuffer;2
private IFileBuffer[] findSynchronizedFileBuffers(IFileBuffer[] fileBuffers) {
    ArrayList list = new  ArrayList();
    for (int i = 0; i < fileBuffers.length; i++) {
        if (fileBuffers[i].isSynchronizationContextRequested())
            list.add(fileBuffers[i]);
    }
    return (IFileBuffer[]) list.toArray(new IFileBuffer[list.size()]);
}
---------------Client-------------------
method: org.eclipse.core.filebuffers.manipulation.GenericFileBufferOperationRunner.findUnsynchronizedFileBuffers(Aorg.eclipse.core.filebuffers.IFileBuffer;)Aorg.eclipse.core.filebuffers.IFileBuffer;2
private IFileBuffer[] findUnsynchronizedFileBuffers(IFileBuffer[] fileBuffers) {
    ArrayList list = new  ArrayList();
    for (int i = 0; i < fileBuffers.length; i++) {
        if (!fileBuffers[i].isSynchronizationContextRequested())
            list.add(fileBuffers[i]);
    }
    return (IFileBuffer[]) list.toArray(new IFileBuffer[list.size()]);
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.observable.DelayedObservableValue.handleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent;)V2
public void handleValueChange(ValueChangeEvent event) {
    if (!updating)
        makeDirty();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.compare.JavaParseTreeBuilder.endVisit(org.eclipse.jdt.core.dom.CompilationUnit;)V2
@Override
public void endVisit(CompilationUnit node) {
    if (fShowCU)
        pop();
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.Queue.isEmpty()Z1
public boolean isEmpty() {
    return tail == head;
}
---------------Client-------------------
method: org.eclipse.swt.custom.DefaultContent.gapExists()Z1
boolean gapExists() {
    return gapStart != gapEnd;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.map.MapDiff$AbstractMapEntry.hash(java.lang.Object;)I2
private int hash(Object key) {
    return key == null ? 0 : key.hashCode();
}
---------------Client-------------------
method: org.eclipse.e4.ui.bindings.internal.Util.hashCode(java.lang.Object;)I1
public static final int hashCode(final Object object) {
    return object != null ? object.hashCode() : 0;
}

---------------Library-------------------
method: org.eclipse.core.databinding.SetBinding.doUpdate(org.eclipse.core.databinding.observable.set.IObservableSet;org.eclipse.core.databinding.observable.set.IObservableSet;org.eclipse.core.databinding.observable.set.SetDiff;org.eclipse.core.databinding.UpdateSetStrategy;ZZ)V7
private void doUpdate(final IObservableSet source, final IObservableSet destination, final SetDiff diff, final UpdateSetStrategy updateSetStrategy, final boolean explicit, final boolean clearDestination) {
    final int policy = updateSetStrategy.getUpdatePolicy();
    if (policy == UpdateSetStrategy.POLICY_NEVER)
        return;
    if (policy == UpdateSetStrategy.POLICY_ON_REQUEST && !explicit)
        return;
    destination.getRealm().exec(new  Runnable() {

        public void run() {
            if (destination == getTarget()) {
                updatingTarget = true;
            } else {
                updatingModel = true;
            }
            MultiStatus multiStatus = BindingStatus.ok();
            try {
                if (clearDestination) {
                    destination.clear();
                }
                for (Iterator iterator = diff.getRemovals().iterator(); iterator.hasNext(); ) {
                    IStatus setterStatus = updateSetStrategy.doRemove(destination, updateSetStrategy.convert(iterator.next()));
                    mergeStatus(multiStatus, setterStatus);
                }
                for (Iterator iterator = diff.getAdditions().iterator(); iterator.hasNext(); ) {
                    IStatus setterStatus = updateSetStrategy.doAdd(destination, updateSetStrategy.convert(iterator.next()));
                    mergeStatus(multiStatus, setterStatus);
                }
            } finally {
                validationStatusObservable.setValue(multiStatus);
                if (destination == getTarget()) {
                    updatingTarget = false;
                } else {
                    updatingModel = false;
                }
            }
        }
    });
}
---------------Client-------------------
method: org.eclipse.core.databinding.ListBinding.doUpdate(org.eclipse.core.databinding.observable.list.IObservableList;org.eclipse.core.databinding.observable.list.IObservableList;org.eclipse.core.databinding.observable.list.ListDiff;org.eclipse.core.databinding.UpdateListStrategy;ZZ)V7
private void doUpdate(final IObservableList source, final IObservableList destination, final ListDiff diff, final UpdateListStrategy updateListStrategy, final boolean explicit, final boolean clearDestination) {
    final int policy = updateListStrategy.getUpdatePolicy();
    if (policy != UpdateListStrategy.POLICY_NEVER) {
        if (policy != UpdateListStrategy.POLICY_ON_REQUEST || explicit) {
            destination.getRealm().exec(new  Runnable() {

                public void run() {
                    if (destination == getTarget()) {
                        updatingTarget = true;
                    } else {
                        updatingModel = true;
                    }
                    final MultiStatus multiStatus = BindingStatus.ok();
                    try {
                        if (clearDestination) {
                            destination.clear();
                        }
                        diff.accept(new  ListDiffVisitor() {

                            boolean useMoveAndReplace = updateListStrategy.useMoveAndReplace();

                            public void handleAdd(int index, Object element) {
                                IStatus setterStatus = updateListStrategy.doAdd(destination, updateListStrategy.convert(element), index);
                                mergeStatus(multiStatus, setterStatus);
                            }

                            public void handleRemove(int index, Object element) {
                                IStatus setterStatus = updateListStrategy.doRemove(destination, index);
                                mergeStatus(multiStatus, setterStatus);
                            }

                            public void handleMove(int oldIndex, int newIndex, Object element) {
                                if (useMoveAndReplace) {
                                    IStatus setterStatus = updateListStrategy.doMove(destination, oldIndex, newIndex);
                                    mergeStatus(multiStatus, setterStatus);
                                } else {
                                    super.handleMove(oldIndex, newIndex, element);
                                }
                            }

                            public void handleReplace(int index, Object oldElement, Object newElement) {
                                if (useMoveAndReplace) {
                                    IStatus setterStatus = updateListStrategy.doReplace(destination, index, newElement);
                                    mergeStatus(multiStatus, setterStatus);
                                } else {
                                    super.handleReplace(index, oldElement, newElement);
                                }
                            }
                        });
                    } finally {
                        validationStatusObservable.setValue(multiStatus);
                        if (destination == getTarget()) {
                            updatingTarget = false;
                        } else {
                            updatingModel = false;
                        }
                    }
                }
            });
        }
    }
}

---------------Library-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyBypass.isLocal(java.lang.String;)Z1
private static boolean isLocal(String host) {
    return host.indexOf(".") == -1;
}
---------------Client-------------------
method: org.eclipse.core.internal.net.proxy.win32.winhttp.ProxyBypass.isBypassLocalAddresses(java.lang.String;)Z1
private static boolean isBypassLocalAddresses(String proxyBypass) {
    return proxyBypass.indexOf(BYPASS_LOCAL_ADDESSES_TOKEN) != -1;
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.set.SetDiff$DeltaSet.contains(java.lang.Object;)Z2
public boolean contains(Object o) {
    return (original.contains(o) || diff.getAdditions().contains(o)) && !diff.getRemovals().contains(o);
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.map.MapDiff$DeltaMap.containsKey(java.lang.Object;)Z2
public boolean containsKey(Object key) {
    return diff.getAddedKeys().contains(key) || (map.containsKey(key) && !diff.getRemovedKeys().contains(key));
}

---------------Library-------------------
method: org.eclipse.core.commands.common.EventManager.clearListeners()V1
protected final synchronized void clearListeners() {
    if (listenerList != null) {
        listenerList.clear();
    }
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.LazyBackupStore.discard()V1
public void discard() {
    if (delegate == null)
        return;
    delegate.discard();
}

---------------Library-------------------
method: org.eclipse.core.databinding.observable.map.MapDiff$AbstractMapEntry.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof Map.Entry))
        return false;
    Map.Entry that = (Map.Entry) obj;
    return Util.equals(this.getKey(), that.getKey()) && Util.equals(this.getValue(), that.getValue());
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.value.ValueDiff.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (obj instanceof ValueDiff) {
        ValueDiff val = (ValueDiff) obj;
        return Diffs.equals(val.getNewValue(), getNewValue()) && Diffs.equals(val.getOldValue(), getOldValue());
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.MethodVerifier.mustImplementAbstractMethods()Z1
boolean mustImplementAbstractMethods() {
    return !this.type.isInterface() && !this.type.isAbstract();
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.VariableBinding.isEffectivelyFinal()Z1
public boolean isEffectivelyFinal() {
    return (!this.binding.isFinal() && this.binding.isEffectivelyFinal());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.getTouchpointType()org.eclipse.equinox.p2.metadata.ITouchpointType;1
public ITouchpointType getTouchpointType() {
    return touchpointType != null ? touchpointType : ITouchpointType.NONE;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.CompilationResult.getLineSeparatorPositions()AI1
public int[] getLineSeparatorPositions() {
    return this.lineSeparatorPositions == null ? CompilationResult.EMPTY_LINE_ENDS : this.lineSeparatorPositions;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.dom.ElementAdapter.isStaticPseudoInstance(java.lang.String;)Z2
@Override
public boolean isStaticPseudoInstance(String s) {
    if (staticPseudoInstances == null)
        return false;
    return staticPseudoInstances.contains(s);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.Scope.deferCheck(java.lang.Runnable;)Z2
public boolean deferCheck(Runnable check) {
    if (this.parent != null)
        return this.parent.deferCheck(check);
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.indexing.IndexAllProject.equals(java.lang.Object;)Z2
public boolean equals(Object o) {
    if (o instanceof IndexAllProject)
        return this.project.equals(((IndexAllProject) o).project);
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.ClasspathChange.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof ClasspathChange))
        return false;
    return this.project.equals(((ClasspathChange) obj).project);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.query.ProfileElementWrapper.shouldWrap(java.lang.Object;)Z2
protected boolean shouldWrap(Object match) {
    if ((match instanceof IProfile))
        return true;
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.ASTMatcher.match(org.eclipse.jdt.core.dom.BlockComment;java.lang.Object;)Z3
public boolean match(BlockComment node, Object other) {
    if (!(other instanceof BlockComment)) {
        return false;
    }
    return true;
}

---------------Library-------------------
method: org.eclipse.jdt.core.Flags.isSuper(I)Z1
public static boolean isSuper(int flags) {
    return (flags & AccSuper) != 0;
}
---------------Client-------------------
method: org.eclipse.jdt.core.Flags.isPackageDefault(I)Z1
public static boolean isPackageDefault(int flags) {
    return (flags & (AccPublic | AccPrivate | AccProtected)) == 0;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.util.impl.resources.ResourcesLocatorManager.unregisterResourceLocator(org.eclipse.e4.ui.css.core.util.resources.IResourceLocator;)V2
@Override
public void unregisterResourceLocator(IResourceLocator resourceLocator) {
    if (uriResolvers == null)
        return;
    uriResolvers.remove(resourceLocator);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.Profile.removeSubProfile(java.lang.String;)V2
public void removeSubProfile(String subProfileId) throws IllegalArgumentException {
    if (subProfileIds != null)
        subProfileIds.remove(subProfileId);
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.env.APTProblem.isError()Z1
public boolean isError() {
    return _severity == Severity.ERROR;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.flow.LoopingFlowContext.isContinuedTo()Z1
public boolean isContinuedTo() {
    return this.initsOnContinue != FlowInfo.DEAD_END;
}

---------------Library-------------------
method: org.eclipse.equinox.p2.internal.repository.tools.RepositoryDescriptor.isBoth()Z1
public boolean isBoth() {
    return kind == TYPE_BOTH;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.formatter.FormatJavadocText.isHtmlTag()Z1
public boolean isHtmlTag() {
    return this.htmlTagIndex != -1;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.Modifier.isStatic()Z1
public boolean isStatic() {
    return this.modifierKeyword == ModifierKeyword.STATIC_KEYWORD;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JavaModelStatus.isMultiStatus()Z1
public boolean isMultiStatus() {
    return this.children != NO_CHILDREN;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.util.TypeInfoFilter.getPackagePattern()java.lang.String;1
public String getPackagePattern() {
    if (fPackageMatcher == null)
        return null;
    return fPackageMatcher.getPattern();
}
---------------Client-------------------
method: org.eclipse.equinox.p2.publisher.eclipse.Feature.getCopyright()java.lang.String;1
public String getCopyright() {
    if (copyright != null)
        return copyright.getAnnotation();
    return null;
}

---------------Library-------------------
method: org.eclipse.swt.internal.image.JPEGScanHeader.isFirstScan()Z1
public boolean isFirstScan() {
    return getApproxBitPositionHigh() == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.util.AbstractExceptionAnalyzer.visit(org.eclipse.jdt.core.dom.EnumDeclaration;)Z2
@Override
public boolean visit(EnumDeclaration node) {
    if (node.isLocalTypeDeclaration())
        return false;
    return true;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.ReferenceExpression.isExactMethodReference()Z1
public boolean isExactMethodReference() {
    return this.exactMethodBinding != null;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.Profile.isRootProfile()Z1
public boolean isRootProfile() {
    return parentProfile == null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.fix.LinkedProposalModel.hasLinkedPositions()Z1
public boolean hasLinkedPositions() {
    return fPositionGroups != null && !fPositionGroups.isEmpty();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.FieldReference.isTypeAccess()Z1
public boolean isTypeAccess() {
    return this.receiver != null && this.receiver.isTypeReference();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.CompletionEngine.computeRelevanceForMissingElements(Z)I2
private int computeRelevanceForMissingElements(boolean hasProblems) {
    if (!hasProblems) {
        return R_NO_PROBLEMS;
    }
    return 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.CompletionEngine.computeRelevanceForResolution(Z)I2
int computeRelevanceForResolution(boolean isResolved) {
    if (isResolved) {
        return R_RESOLVED;
    }
    return 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.MethodBinding.isOverriding()Z1
public final boolean isOverriding() {
    return (this.modifiers & ExtraCompilerModifiers.AccOverriding) != 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding.isHierarchyConnected()Z1
public boolean isHierarchyConnected() {
    return (this.modifiers & ExtraCompilerModifiers.AccUnresolved) == 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.complete.CompletionParser.consumeStatementFor()V1
protected void consumeStatementFor() {
    super.consumeStatementFor();
    if (topKnownElementKind(COMPLETION_OR_ASSIST_PARSER) == K_CONTROL_STATEMENT_DELIMITER) {
        popElement(K_CONTROL_STATEMENT_DELIMITER);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.complete.CompletionParser.consumeCaseLabel()V1
protected void consumeCaseLabel() {
    super.consumeCaseLabel();
    if (topKnownElementKind(COMPLETION_OR_ASSIST_PARSER) != K_SWITCH_LABEL) {
        pushOnElementStack(K_SWITCH_LABEL);
    }
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.All.evaluate(org.eclipse.equinox.p2.metadata.expression.IEvaluationContext;java.util.Iterator;)java.lang.Object;3
protected Object evaluate(IEvaluationContext context, Iterator<?> itor) {
    Variable variable = lambda.getItemVariable();
    while (itor.hasNext()) {
        variable.setValue(context, itor.next());
        if (lambda.evaluate(context) != Boolean.TRUE)
            return Boolean.FALSE;
    }
    return Boolean.TRUE;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.Exists.evaluate(org.eclipse.equinox.p2.metadata.expression.IEvaluationContext;java.util.Iterator;)java.lang.Object;3
protected Object evaluate(IEvaluationContext context, Iterator<?> itor) {
    Variable variable = lambda.getItemVariable();
    while (itor.hasNext()) {
        variable.setValue(context, itor.next());
        if (lambda.evaluate(context) == Boolean.TRUE)
            return Boolean.TRUE;
    }
    return Boolean.FALSE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding.computeUniqueKey(Z)AC2
public char[] computeUniqueKey(boolean isLeaf) {
    if (!isLeaf)
        return signature();
    return genericTypeSignature();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.TypeBinding.nullAnnotatedReadableName(org.eclipse.jdt.internal.compiler.impl.CompilerOptions;Z)AC3
public char[] nullAnnotatedReadableName(CompilerOptions options, boolean shortNames) {
    if (shortNames)
        return shortReadableName();
    else
        return readableName();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.SnippetFinder$Match.isEmpty()Z1
public boolean isEmpty() {
    return fNodes.isEmpty() && fLocalMappings.isEmpty();
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.TypeBinding.isTypeVariable()Z1
public boolean isTypeVariable() {
    return this.binding.isTypeVariable() && !this.binding.isCapture();
}

---------------Library-------------------
method: org.eclipse.equinox.p2.metadata.io.IUDeserializer$IUDeserializerParser$IUOnlyHandler.getInstallableUnits()Aorg.eclipse.equinox.p2.metadata.IInstallableUnit;1
public IInstallableUnit[] getInstallableUnits() {
    if (unitsHandler == null)
        return null;
    return unitsHandler.getUnits();
}
---------------Client-------------------
method: org.eclipse.equinox.p2.publisher.eclipse.Feature.getCopyrightURL()java.lang.String;1
public String getCopyrightURL() {
    if (copyright != null)
        return copyright.getURL();
    return null;
}

---------------Library-------------------
method: org.eclipse.swt.internal.mozilla.nsIInputStream.Available(AI)I2
public int Available(int[] _retval) {
    if (IsXULRunner24())
        return XPCOM.NS_COMFALSE;
    return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 2, getAddress(), _retval);
}
---------------Client-------------------
method: org.eclipse.swt.internal.mozilla.nsIInputStream.Available(AJ)I2
public int Available(long[] _retval) {
    if (!IsXULRunner24())
        return XPCOM.NS_COMFALSE;
    return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 2, getAddress(), _retval);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.setLicenses(Aorg.eclipse.equinox.p2.metadata.ILicense;)V2
public void setLicenses(ILicense[] license) {
    this.licenses = license == null ? NO_LICENSE : license;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.ds.impl.ReadOnlyDictionary.updateDelegate(java.util.Map;)V2
public void updateDelegate(Map newDelegate) {
    this.delegate = newDelegate != null ? newDelegate : Collections.EMPTY_MAP;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.phases.Unconfigure.isApplicable(org.eclipse.equinox.internal.p2.engine.InstallableUnitOperand;)Z2
protected boolean isApplicable(InstallableUnitOperand op) {
    return (op.first() != null);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.SwitchCase.isDefault()Z1
public boolean isDefault() {
    return getExpression() == null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.index.Index.getIndexLocation()org.eclipse.jdt.internal.core.index.IndexLocation;1
public IndexLocation getIndexLocation() {
    return this.diskIndex == null ? null : this.diskIndex.indexLocation;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.util.impl.tpt.timer.TimerQueue.getMin()org.eclipse.equinox.internal.util.impl.tpt.timer.TimerQueueNode;1
TimerQueueNode getMin() {
    return (first != null) ? first.node : null;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.impl.engine.CSSElementContextImpl.getData(java.lang.Object;)java.lang.Object;2
@Override
public Object getData(Object key) {
    if (datas == null)
        return null;
    return datas.get(key);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.NodeInfoStore.getPlaceholderData(org.eclipse.jdt.core.dom.ASTNode;)java.lang.Object;2
public Object getPlaceholderData(ASTNode node) {
    if (this.placeholderNodes != null) {
        return this.placeholderNodes.get(node);
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.breadcrumb.BreadcrumbItemDetails$2.paintControl(org.eclipse.swt.events.PaintEvent;)V2
public void paintControl(PaintEvent e) {
    if (fHasFocus && isTextVisible()) {
        e.gc.drawFocus(e.x, e.y, e.width, e.height);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javaeditor.breadcrumb.BreadcrumbItemDetails$1.paintControl(org.eclipse.swt.events.PaintEvent;)V2
public void paintControl(PaintEvent e) {
    if (fHasFocus && !isTextVisible()) {
        e.gc.drawFocus(e.x, e.y, e.width, e.height);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.index.Index.startQuery()V1
public void startQuery() {
    if (this.diskIndex != null)
        this.diskIndex.startQuery();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.natives.LazyBackupStore.restore()V1
public void restore() throws IOException {
    if (delegate == null)
        return;
    delegate.restore();
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.URI.hasQuery()Z1
public boolean hasQuery() {
    return query != null;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.util.impl.tpt.timer.TimerQueue.isEmpty()Z1
boolean isEmpty() {
    return first == null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.InstallableUnitEvent.isConfigure()Z1
public boolean isConfigure() {
    return type == CONFIGURE;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall.isSuperAccess()Z1
public boolean isSuperAccess() {
    return this.accessMode != ExplicitConstructorCall.This;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer.isSourceType()Z1
public boolean isSourceType() {
    return this.sourceTypes != null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.Block.isEmptyBlock()Z1
public boolean isEmptyBlock() {
    return this.statements == null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.ui.query.ArtifactKeyWrapper.shouldWrap(java.lang.Object;)Z2
protected boolean shouldWrap(Object match) {
    if ((match instanceof IArtifactKey))
        return true;
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.ASTMatcher.match(org.eclipse.jdt.core.dom.EmptyStatement;java.lang.Object;)Z3
public boolean match(EmptyStatement node, Object other) {
    if (!(other instanceof EmptyStatement)) {
        return false;
    }
    return true;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ExternalPackageFragmentRoot.equals(java.lang.Object;)Z2
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof ExternalPackageFragmentRoot) {
        ExternalPackageFragmentRoot other = (ExternalPackageFragmentRoot) o;
        return this.externalPath.equals(other.externalPath);
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.MethodBinding.isEqualTo(org.eclipse.jdt.core.dom.IBinding;)Z2
public boolean isEqualTo(IBinding other) {
    if (other == this) {
        return true;
    }
    if (other == null) {
        return false;
    }
    if (!(other instanceof MethodBinding)) {
        return false;
    }
    org.eclipse.jdt.internal.compiler.lookup.MethodBinding otherBinding = ((MethodBinding) other).binding;
    return BindingComparator.isEqual(this.binding, otherBinding);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ExternalFoldersManager.removePendingFolder(java.lang.Object;)Z2
public synchronized boolean removePendingFolder(Object externalPath) {
    if (this.pendingFolders == null)
        return false;
    return this.pendingFolders.remove(externalPath);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.dom.rewrite.NodeInfoStore.isCollapsed(org.eclipse.jdt.core.dom.ASTNode;)Z2
public boolean isCollapsed(ASTNode node) {
    if (this.collapsedNodes != null) {
        return this.collapsedNodes.contains(node);
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.impl.AssistParser.consumeNestedMethod()V1
protected void consumeNestedMethod() {
    super.consumeNestedMethod();
    if (!isInsideMethod())
        pushOnElementStack(K_METHOD_DELIMITER);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.complete.CompletionParser.consumeForceNoDiet()V1
protected void consumeForceNoDiet() {
    super.consumeForceNoDiet();
    if (isInsideMethod()) {
        pushOnElementStack(K_LOCAL_INITIALIZER_DELIMITER);
    }
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Control.gtk_style_set(JJ)J3
@Override
long gtk_style_set(long widget, long previousStyle) {
    if (backgroundImage != null) {
        setBackgroundPixmap(backgroundImage);
    }
    return 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.sendMessage(java.lang.String;)V2
public void sendMessage(String msg) {
    if (fWriter == null)
        return;
    fWriter.println(msg);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.MethodExitsFinder.isExitPoint(org.eclipse.jdt.core.dom.IMethodBinding;)Z2
private boolean isExitPoint(IMethodBinding binding) {
    if (binding == null)
        return false;
    ITypeBinding[] exceptions = binding.getExceptionTypes();
    for (int i = 0; i < exceptions.length; i++) {
        if (!isCaught(exceptions[i]))
            return true;
    }
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.OpenTypeHistory$TypeHistoryDeltaListener.processChildrenDelta(org.eclipse.jdt.core.IJavaElementDelta;)Z2
private boolean processChildrenDelta(IJavaElementDelta delta) {
    IJavaElementDelta[] children = delta.getAffectedChildren();
    for (int i = 0; i < children.length; i++) {
        if (processDelta(children[i])) {
            return true;
        }
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.InstallableUnitEvent.getResult()org.eclipse.core.runtime.IStatus;1
public IStatus getResult() {
    return (result != null ? result : Status.OK_STATUS);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.NormalAnnotation.memberValuePairs()Aorg.eclipse.jdt.internal.compiler.ast.MemberValuePair;1
public MemberValuePair[] memberValuePairs() {
    return this.memberValuePairs == null ? NoValuePairs : this.memberValuePairs;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.ExceptionOccurrencesFinder.getElementName()java.lang.String;1
public String getElementName() {
    if (fSelectedNode != null) {
        return ASTNodes.asString(fSelectedNode);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.ConstraintVariable.toResolvedString()java.lang.String;1
public String toResolvedString() {
    if (fTypeBinding == null)
        return "<NULL BINDING>";
    return Bindings.asString(fTypeBinding);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.launching.JREContainerInitializer.isExecutionEnvironment(org.eclipse.core.runtime.IPath;)Z1
public static boolean isExecutionEnvironment(IPath path) {
    return getExecutionEnvironmentId(path) != null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JarPackageFragmentRoot.isExternal()Z1
public boolean isExternal() {
    return resource() == null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.parser.RecoveryScanner.isInsertedToken()Z1
public boolean isInsertedToken() {
    return this.fakeTokenSource != null && this.isInserted;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.parser.RecoveryScanner.isReplacedToken()Z1
public boolean isReplacedToken() {
    return this.fakeTokenSource != null && !this.isInserted;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.TypeBinding.isPrimitive()Z1
public boolean isPrimitive() {
    return !isNullType() && this.binding.isBaseType();
}
---------------Client-------------------
method: org.eclipse.swt.widgets.MenuItem.isEnabled()Z1
public boolean isEnabled() {
    return getEnabled() && parent.isEnabled();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.util.xml.TagClass.getAttributes()java.lang.String;1
public String getAttributes() {
    return (fAttributes != null) ? fAttributes : "";
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.storage.friends.PasswordProviderDescription.getDescription()java.lang.String;1
public String getDescription() {
    return (description == null) ? EMPTY_STRING : description;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isDefinitelyAssigned(org.eclipse.jdt.internal.compiler.lookup.FieldBinding;)Z2
public boolean isDefinitelyAssigned(FieldBinding field) {
    return this.initsWhenTrue.isDefinitelyAssigned(field) && this.initsWhenFalse.isDefinitelyAssigned(field);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.provisional.p2.directorywatcher.CachingArtifactRepository.contains(org.eclipse.equinox.p2.metadata.IArtifactKey;)Z2
public synchronized boolean contains(IArtifactKey key) {
    return artifactMap.containsKey(key) || innerRepo.contains(key);
}

---------------Library-------------------
method: org.eclipse.swt.graphics.Transform.isDisposed()Z1
@Override
public boolean isDisposed() {
    return handle == null;
}
---------------Client-------------------
method: org.eclipse.e4.core.internal.di.Requestor.isResolved()Z1
public boolean isResolved() {
    return (actualArgs != null);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.complete.CompletionParser.consumeEnhancedForStatement()V1
protected void consumeEnhancedForStatement() {
    super.consumeEnhancedForStatement();
    if (topKnownElementKind(COMPLETION_OR_ASSIST_PARSER) == K_CONTROL_STATEMENT_DELIMITER) {
        popElement(K_CONTROL_STATEMENT_DELIMITER);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.codeassist.complete.CompletionParser.consumeNestedMethod()V1
protected void consumeNestedMethod() {
    super.consumeNestedMethod();
    if (!(topKnownElementKind(COMPLETION_OR_ASSIST_PARSER) == K_BLOCK_DELIMITER))
        pushOnElementStack(K_BLOCK_DELIMITER);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.hierarchy.ChangeCollector.needsRefresh()Z1
public boolean needsRefresh() {
    return this.changes.size() != 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.SourceType.isAnonymous()Z1
public boolean isAnonymous() {
    return this.name.length() == 0;
}

---------------Library-------------------
method: org.eclipse.jdt.launching.VMRunnerConfiguration.getVMArguments()Ajava.lang.String;1
public String[] getVMArguments() {
    if (fVMArgs == null) {
        return fgEmpty;
    }
    return fVMArgs;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.operations.ResolutionResult.getSummaryStatus()org.eclipse.core.runtime.IStatus;1
public IStatus getSummaryStatus() {
    if (summaryStatus != null)
        return summaryStatus;
    return Status.OK_STATUS;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.ScopeAnalyzer$ScopeAnalyzerVisitor.isInside(org.eclipse.jdt.core.dom.ASTNode;)Z2
private boolean isInside(ASTNode node) {
    int start = node.getStartPosition();
    int end = start + node.getLength();
    return start <= fPosition && fPosition < end;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.callhierarchy.CalleeAnalyzerVisitor.isNodeEnclosingMethod(org.eclipse.jdt.core.dom.ASTNode;)Z2
private boolean isNodeEnclosingMethod(ASTNode node) {
    int nodeStartPosition = node.getStartPosition();
    int nodeEndPosition = nodeStartPosition + node.getLength();
    if (nodeStartPosition < fMethodStartPosition && nodeEndPosition > fMethodEndPosition) {
        return true;
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.RequiredCapability.isVersionStrict(org.eclipse.equinox.p2.metadata.expression.IMatchExpression;)Z1
public static boolean isVersionStrict(IMatchExpression<IInstallableUnit> matchExpression) {
    return ExpressionUtil.getOperand(matchExpression) == strictVersionExpression;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.FieldInfo.hasConstant()Z1
public boolean hasConstant() {
    return getConstant() != Constant.NotAConstant;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsModel$HashedSet.addExisting(java.lang.Object;)java.lang.Object;2
public final E addExisting(final E object) {
    final E result = fImplementation.get(object);
    if (result != null)
        return result;
    fImplementation.put(object, object);
    return object;
}
---------------Client-------------------
method: org.eclipse.equinox.p2.core.StrongPool.add(java.lang.Object;)java.lang.Object;2
public T add(T newObject) {
    if (newObject == null) {
        return null;
    }
    T reference = pool.get(newObject);
    if (reference == null) {
        pool.put(newObject, newObject);
        return newObject;
    }
    return reference;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.updatesite.SiteModel.getCategory(java.lang.String;)org.eclipse.equinox.internal.p2.updatesite.SiteCategory;2
public SiteCategory getCategory(String name) {
    return (categories == null ? null : categories.get(name));
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties.get(java.lang.Object;)java.lang.String;2
public String get(Object key) {
    return propertyMap != null ? propertyMap.get(key) : null;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.setVersion(org.eclipse.equinox.p2.metadata.Version;)V2
public void setVersion(Version newVersion) {
    this.version = (newVersion != null ? newVersion : Version.emptyVersion);
}
---------------Client-------------------
method: org.eclipse.equinox.p2.repository.artifact.spi.ArtifactDescriptor.setProcessingSteps(Aorg.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor;)V2
public void setProcessingSteps(IProcessingStepDescriptor[] value) {
    processingSteps = value == null ? EMPTY_STEPS : value;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties.remove(java.lang.Object;)java.lang.String;2
public String remove(Object key) {
    return propertyMap != null ? propertyMap.remove(key) : null;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties.getProperty(java.lang.String;)java.lang.String;2
public String getProperty(String key) {
    return (propertyMap == null ? null : propertyMap.get(key));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BufferFactoryWrapper.createBuffer(org.eclipse.jdt.core.ICompilationUnit;)org.eclipse.jdt.core.IBuffer;2
public IBuffer createBuffer(ICompilationUnit workingCopy) {
    if (this.factory == null)
        return super.createBuffer(workingCopy);
    return this.factory.createBuffer(workingCopy);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner.createBuffer(org.eclipse.jdt.core.ICompilationUnit;)org.eclipse.jdt.core.IBuffer;2
public IBuffer createBuffer(ICompilationUnit workingCopy) {
    if (this.primaryBufferProvider != null)
        return this.primaryBufferProvider.createBuffer(workingCopy);
    return super.createBuffer(workingCopy);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.launcher.TestSearchResult.isEmpty()Z1
boolean isEmpty() {
    return getTypes().length <= 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.PackageFragment.hasChildren()Z1
public boolean hasChildren() throws JavaModelException {
    return getChildren().length > 0;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.storage.SecurePreferencesWrapper.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (obj == null)
        return false;
    if (!(obj instanceof SecurePreferencesWrapper))
        return false;
    SecurePreferencesWrapper other = (SecurePreferencesWrapper) obj;
    return container.equals(other.container) && node.equals(other.node);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetUnion.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object o) {
    if (o instanceof TypeSetUnion) {
        TypeSetUnion other = (TypeSetUnion) o;
        return other.fLHS.equals(fLHS) && other.fRHS.equals(fRHS);
    } else
        return false;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.core.serializers.CSSSerializerConfiguration.getAttributesFilter()Ajava.lang.String;1
public String[] getAttributesFilter() {
    if (attributesFilter != null)
        return (String[]) attributesFilter.toArray(EMPTY_STRING);
    return EMPTY_STRING;
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.core.dom.ElementAdapter.getStaticPseudoInstances()Ajava.lang.String;1
@Override
public String[] getStaticPseudoInstances() {
    if (staticPseudoInstances == null)
        return EMPTY_STRING;
    return (String[]) staticPseudoInstances.toArray(EMPTY_STRING);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.MethodBinding.isRawMethod()Z1
public boolean isRawMethod() {
    return (this.binding instanceof ParameterizedGenericMethodBinding) && ((ParameterizedGenericMethodBinding) this.binding).isRaw;
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.MethodBinding.isParameterizedMethod()Z1
public boolean isParameterizedMethod() {
    return (this.binding instanceof ParameterizedGenericMethodBinding) && !((ParameterizedGenericMethodBinding) this.binding).isRaw;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement.exitAnyExceptionHandler()V1
public void exitAnyExceptionHandler() {
    if (this.anyExceptionLabel != null) {
        this.anyExceptionLabel.placeEnd();
    }
}
---------------Client-------------------
method: org.eclipse.osgi.storagemanager.StorageManager.release()V1
private void release() {
    if (locker == null)
        return;
    locker.release();
}

---------------Library-------------------
method: org.eclipse.swt.internal.image.JPEGScanHeader.isDCProgressiveScan()Z1
public boolean isDCProgressiveScan() {
    return getStartOfSpectralSelection() == 0 && getEndOfSpectralSelection() == 0;
}
---------------Client-------------------
method: org.eclipse.swt.internal.image.JPEGScanHeader.isACProgressiveScan()Z1
public boolean isACProgressiveScan() {
    return getStartOfSpectralSelection() != 0 && getEndOfSpectralSelection() != 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetIntersection.contains(org.eclipse.jdt.internal.corext.refactoring.typeconstraints.types.TType;)Z2
@Override
public boolean contains(TType t) {
    return fLHS.contains(t) && fRHS.contains(t);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isPotentiallyAssigned(org.eclipse.jdt.internal.compiler.lookup.FieldBinding;)Z2
public boolean isPotentiallyAssigned(FieldBinding field) {
    return this.initsWhenTrue.isPotentiallyAssigned(field) || this.initsWhenFalse.isPotentiallyAssigned(field);
}

---------------Library-------------------
method: org.eclipse.equinox.p2.internal.repository.tools.CompositeRepositoryApplication.initializeDestination(org.eclipse.equinox.p2.internal.repository.tools.RepositoryDescriptor;org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;)org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;3
protected IMetadataRepository initializeDestination(RepositoryDescriptor toInit, IMetadataRepositoryManager mgr) throws ProvisionException {
    mgr.removeRepository(toInit.getRepoLocation());
    try {
        IMetadataRepository repository = mgr.loadRepository(toInit.getRepoLocation(), null);
        if (!validRepositoryLocation(repository) && initDestinationRepository(repository, toInit))
            throw new  ProvisionException(new  Status(IStatus.INFO, Activator.ID, NLS.bind(Messages.CompositeRepository_composite_repository_exists, toInit.getRepoLocation())));
        return repository;
    } catch (ProvisionException e) {
        if (e.getStatus().getCode() != ProvisionException.REPOSITORY_NOT_FOUND) {
            if (e.getCause() instanceof MalformedURLException)
                throw new  ProvisionException(NLS.bind(Messages.exception_invalidDestination, toInit.getRepoLocation()), e.getCause());
            throw e;
        }
    }
    IMetadataRepository source = null;
    try {
        if (toInit.getFormat() != null)
            source = mgr.loadRepository(toInit.getFormat(), 0, null);
    } catch (ProvisionException e) {
    }
    try {
        IMetadataRepository repo = mgr.createRepository(toInit.getRepoLocation(), toInit.getName() != null ? toInit.getName() : (source != null ? source.getName() : Messages.CompositeRepository_default_metadataRepo_name), IMetadataRepositoryManager.TYPE_COMPOSITE_REPOSITORY, source != null ? source.getProperties() : null);
        initRepository(repo, toInit);
        return repo;
    } catch (IllegalStateException e) {
        mgr.removeRepository(toInit.getRepoLocation());
        throw e;
    }
}
---------------Client-------------------
method: org.eclipse.equinox.p2.internal.repository.tools.CompositeRepositoryApplication.initializeDestination(org.eclipse.equinox.p2.internal.repository.tools.RepositoryDescriptor;org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;)org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;3
protected IArtifactRepository initializeDestination(RepositoryDescriptor toInit, IArtifactRepositoryManager mgr) throws ProvisionException {
    mgr.removeRepository(toInit.getRepoLocation());
    try {
        IArtifactRepository repository = mgr.loadRepository(toInit.getRepoLocation(), null);
        if (validRepositoryLocation(repository) && initDestinationRepository(repository, toInit))
            return repository;
        throw new  ProvisionException(new  Status(IStatus.INFO, Activator.ID, NLS.bind(Messages.CompositeRepository_composite_repository_exists, toInit.getRepoLocation())));
    } catch (ProvisionException e) {
        if (e.getStatus().getCode() != ProvisionException.REPOSITORY_NOT_FOUND) {
            if (e.getCause() instanceof MalformedURLException)
                throw new  ProvisionException(NLS.bind(Messages.exception_invalidDestination, toInit.getRepoLocation()), e.getCause());
            throw e;
        }
    }
    IArtifactRepository source = null;
    try {
        if (toInit.getFormat() != null)
            source = mgr.loadRepository(toInit.getFormat(), 0, null);
    } catch (ProvisionException e) {
    }
    try {
        IArtifactRepository repo = mgr.createRepository(toInit.getRepoLocation(), toInit.getName() != null ? toInit.getName() : (source != null ? source.getName() : Messages.CompositeRepository_default_artifactRepo_name), IArtifactRepositoryManager.TYPE_COMPOSITE_REPOSITORY, source != null ? source.getProperties() : null);
        initRepository(repo, toInit);
        return repo;
    } catch (IllegalStateException e) {
        mgr.removeRepository(toInit.getRepoLocation());
        throw e;
    }
}

---------------Library-------------------
method: org.eclipse.swt.accessibility.AccessibleObject.size(java.util.Vector;)I1
static int size(Vector listeners) {
    return listeners == null ? 0 : listeners.size();
}
---------------Client-------------------
method: org.eclipse.e4.ui.internal.workbench.Util.hashCode(java.lang.Object;)I1
public static final int hashCode(final Object object) {
    return object != null ? object.hashCode() : 0;
}

---------------Library-------------------
method: org.eclipse.equinox.internal.util.xml.TagClass.size()I1
public int size() {
    return (fTags == null) ? 0 : fTags.size();
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.core.impl.dom.StyleSheetListImpl.getLength()I1
@Override
public int getLength() {
    return (styleSheets != null) ? styleSheets.size() : 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.apt.util.ArchiveFileObject.equals(java.lang.Object;)Z2
public boolean equals(Object o) {
    if (!(o instanceof ArchiveFileObject)) {
        return false;
    }
    ArchiveFileObject archiveFileObject = (ArchiveFileObject) o;
    return archiveFileObject.toUri().equals(this.toUri());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.launching.environments.AccessRuleParticipant.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object obj) {
    if (obj instanceof AccessRuleParticipant) {
        AccessRuleParticipant participant = (AccessRuleParticipant) obj;
        return participant.getDelegateClassName().equals(getDelegateClassName());
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.MessageSend.innersNeedUpdate()Z1
public boolean innersNeedUpdate() {
    return this.innerInferenceHelper != null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.ui.javadocexport.JavadocLinkRef.isProjectRef()Z1
public boolean isProjectRef() {
    return fClasspathEntry == null;
}

---------------Library-------------------
method: org.eclipse.osgi.framework.eventmgr.CopyOnWriteIdentityMap.isEmpty()Z1
public boolean isEmpty() {
    return size() == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.util.AbstractExceptionAnalyzer.visit(org.eclipse.jdt.core.dom.TypeDeclaration;)Z2
@Override
public boolean visit(TypeDeclaration node) {
    if (node.isLocalTypeDeclaration())
        return false;
    return true;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.util.FieldInfo.hasConstantValueAttribute()Z1
public boolean hasConstantValueAttribute() {
    return this.constantValueAttribute != null;
}
---------------Client-------------------
method: org.eclipse.swt.dnd.Clipboard.isDisposed()Z1
public boolean isDisposed() {
    return (display == null);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.dom.Bindings.areOverriddenMethods(org.eclipse.jdt.core.dom.IMethodBinding;org.eclipse.jdt.core.dom.IMethodBinding;)Z2
public static boolean areOverriddenMethods(IMethodBinding overridden, IMethodBinding overridable) {
    if (!overridden.getName().equals(overridable.getName()))
        return false;
    return areSubTypeCompatible(overridden, overridable);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.updatesite.SiteCategory$1.compare(org.eclipse.equinox.internal.p2.updatesite.SiteCategory;org.eclipse.equinox.internal.p2.updatesite.SiteCategory;)I3
public int compare(SiteCategory cat1, SiteCategory cat2) {
    if (cat1.equals(cat2))
        return 0;
    return cat1.getName().compareTo(cat2.getName());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.CompletionEngine.isAllowingLongComputationProposals()Z1
private boolean isAllowingLongComputationProposals() {
    return this.monitor != null;
}
---------------Client-------------------
method: org.eclipse.swt.graphics.Color.isDisposed()Z1
@Override
public boolean isDisposed() {
    return handle == null;
}

---------------Library-------------------
method: org.eclipse.equinox.p2.query.CompoundQueryable$IteratorCapture.getCapturedIterator()java.util.Iterator;1
Iterator<T> getCapturedIterator() {
    return capturedIterator == null ? Collections.<T>emptySet().iterator() : capturedIterator;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties.entrySet()java.util.Set;1
public Set<Map.Entry<String, String>> entrySet() {
    return propertyMap != null ? propertyMap.entrySet() : Collections.<Map.Entry<String, String>>emptySet();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo.branches()Z1
public boolean branches() {
    return fBranches != null && !fBranches.isEmpty();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.MessageSend.isTypeAccess()Z1
public boolean isTypeAccess() {
    return this.receiver != null && this.receiver.isTypeReference();
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Composite.gtk_focus(JJ)J3
@Override
long gtk_focus(long widget, long directionType) {
    if (widget == socketHandle)
        return 0;
    return super.gtk_focus(widget, directionType);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Shell.gtk_enter_notify_event(JJ)J3
@Override
long gtk_enter_notify_event(long widget, long event) {
    if (widget != shellHandle) {
        return super.gtk_enter_notify_event(widget, event);
    }
    return 0;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTNode.supportedOnlyIn2()V1
final void supportedOnlyIn2() {
    if (this.ast.apiLevel != AST.JLS2_INTERNAL) {
        throw new  UnsupportedOperationException("Operation only supported in JLS2 AST");
    }
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.ASTNode.unsupportedIn2()V1
final void unsupportedIn2() {
    if (this.ast.apiLevel == AST.JLS2_INTERNAL) {
        throw new  UnsupportedOperationException("Operation not supported in JLS2 AST");
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.resource()org.eclipse.core.resources.IResource;1
public IResource resource() {
    if (this.resource != null)
        return this.resource;
    return super.resource();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.jdom.DOMNode.getRoot()org.eclipse.jdt.core.jdom.IDOMNode;1
protected IDOMNode getRoot() {
    if (this.fParent == null) {
        return this;
    } else {
        return this.fParent.getRoot();
    }
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.ui.X509CertificateAttribute.getValue()java.lang.Object;1
public Object getValue() {
    if (rawValue == null) {
        return stringVal;
    }
    return rawValue;
}
---------------Client-------------------
method: org.eclipse.e4.core.internal.di.Binding.getImplementationClass()java.lang.Class;1
public Class<?> getImplementationClass() {
    if (implementationClazz != null)
        return implementationClazz;
    return clazz;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isDefinitelyAssigned(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;)Z2
public boolean isDefinitelyAssigned(LocalVariableBinding local) {
    return this.initsWhenTrue.isDefinitelyAssigned(local) && this.initsWhenFalse.isDefinitelyAssigned(local);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isPotentiallyAssigned(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;)Z2
public boolean isPotentiallyAssigned(LocalVariableBinding local) {
    return this.initsWhenTrue.isPotentiallyAssigned(local) || this.initsWhenFalse.isPotentiallyAssigned(local);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer.isBinaryType()Z1
public boolean isBinaryType() {
    return this.binaryType != null;
}
---------------Client-------------------
method: org.eclipse.swt.internal.ImageList.isDisposed()Z1
public boolean isDisposed() {
    return images == null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall.innersNeedUpdate()Z1
public boolean innersNeedUpdate() {
    return this.innerInferenceHelper != null;
}
---------------Client-------------------
method: org.eclipse.swt.internal.theme.Theme.isDisposed()Z1
public boolean isDisposed() {
    return device == null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.impl.Constant.computeConstantOperationGREATER_EQUAL(org.eclipse.jdt.internal.compiler.impl.Constant;ILorg.eclipse.jdt.internal.compiler.impl.Constant;I)org.eclipse.jdt.internal.compiler.impl.Constant;4
public static final Constant computeConstantOperationGREATER_EQUAL(Constant left, int leftId, Constant right, int rightId) {
    switch(leftId) {
        case T_char:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.charValue() >= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.charValue() >= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.charValue() >= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.charValue() >= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.charValue() >= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.charValue() >= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.charValue() >= right.longValue());
            }
            break;
        case T_float:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.floatValue() >= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.floatValue() >= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.floatValue() >= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.floatValue() >= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.floatValue() >= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.floatValue() >= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.floatValue() >= right.longValue());
            }
            break;
        case T_double:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.doubleValue() >= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.doubleValue() >= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.doubleValue() >= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.doubleValue() >= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.doubleValue() >= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.doubleValue() >= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.doubleValue() >= right.longValue());
            }
            break;
        case T_byte:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.byteValue() >= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.byteValue() >= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.byteValue() >= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.byteValue() >= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.byteValue() >= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.byteValue() >= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.byteValue() >= right.longValue());
            }
            break;
        case T_short:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.shortValue() >= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.shortValue() >= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.shortValue() >= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.shortValue() >= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.shortValue() >= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.shortValue() >= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.shortValue() >= right.longValue());
            }
            break;
        case T_int:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.intValue() >= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.intValue() >= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.intValue() >= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.intValue() >= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.intValue() >= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.intValue() >= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.intValue() >= right.longValue());
            }
            break;
        case T_long:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.longValue() >= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.longValue() >= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.longValue() >= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.longValue() >= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.longValue() >= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.longValue() >= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.longValue() >= right.longValue());
            }
    }
    return NotAConstant;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.impl.Constant.computeConstantOperationLESS(org.eclipse.jdt.internal.compiler.impl.Constant;ILorg.eclipse.jdt.internal.compiler.impl.Constant;I)org.eclipse.jdt.internal.compiler.impl.Constant;4
public static final Constant computeConstantOperationLESS(Constant left, int leftId, Constant right, int rightId) {
    switch(leftId) {
        case T_char:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.charValue() < right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.charValue() < right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.charValue() < right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.charValue() < right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.charValue() < right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.charValue() < right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.charValue() < right.longValue());
            }
            break;
        case T_float:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.floatValue() < right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.floatValue() < right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.floatValue() < right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.floatValue() < right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.floatValue() < right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.floatValue() < right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.floatValue() < right.longValue());
            }
            break;
        case T_double:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.doubleValue() < right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.doubleValue() < right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.doubleValue() < right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.doubleValue() < right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.doubleValue() < right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.doubleValue() < right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.doubleValue() < right.longValue());
            }
            break;
        case T_byte:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.byteValue() < right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.byteValue() < right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.byteValue() < right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.byteValue() < right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.byteValue() < right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.byteValue() < right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.byteValue() < right.longValue());
            }
            break;
        case T_short:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.shortValue() < right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.shortValue() < right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.shortValue() < right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.shortValue() < right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.shortValue() < right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.shortValue() < right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.shortValue() < right.longValue());
            }
            break;
        case T_int:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.intValue() < right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.intValue() < right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.intValue() < right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.intValue() < right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.intValue() < right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.intValue() < right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.intValue() < right.longValue());
            }
            break;
        case T_long:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.longValue() < right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.longValue() < right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.longValue() < right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.longValue() < right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.longValue() < right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.longValue() < right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.longValue() < right.longValue());
            }
    }
    return NotAConstant;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.URI.validSegment(java.lang.String;)Z1
public static boolean validSegment(String value) {
    return value != null && !contains(value, SEGMENT_END_HI, SEGMENT_END_LO);
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.helpers.URI.validAuthority(java.lang.String;)Z1
public static boolean validAuthority(String value) {
    return value == null || !contains(value, SEGMENT_END_HI, SEGMENT_END_LO);
}

---------------Library-------------------
method: org.eclipse.swt.dnd.TreeDragSourceEffect.dragFinished(org.eclipse.swt.dnd.DragSourceEvent;)V2
@Override
public void dragFinished(DragSourceEvent event) {
    if (dragSourceImage != null)
        dragSourceImage.dispose();
    dragSourceImage = null;
}
---------------Client-------------------
method: org.eclipse.e4.ui.workbench.addons.dndaddon.SplitDropAgent2.clearFeedback()V1
private void clearFeedback() {
    if (feedback == null)
        return;
    feedback.dispose();
    feedback = null;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.matching.ImportMatchLocatorParser.consumeStaticImportOnDemandDeclarationName()V1
protected void consumeStaticImportOnDemandDeclarationName() {
    super.consumeStaticImportOnDemandDeclarationName();
    if (this.reportImportMatch) {
        this.patternLocator.match(this.astStack[this.astPtr], this.nodeSet);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.matching.MatchLocatorParser.consumeAssignment()V1
protected void consumeAssignment() {
    super.consumeAssignment();
    if (this.patternFineGrain == 0) {
        this.patternLocator.match(this.expressionStack[this.expressionPtr], this.nodeSet);
    }
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.util.Sorting.concreteFirst(Aorg.eclipse.jdt.internal.compiler.lookup.MethodBinding;I)Aorg.eclipse.jdt.internal.compiler.lookup.MethodBinding;2
public static MethodBinding[] concreteFirst(MethodBinding[] methods, int length) {
    if (length == 0 || (length > 0 && !methods[0].isAbstract()))
        return methods;
    MethodBinding[] copy = new MethodBinding[length];
    int idx = 0;
    for (int i = 0; i < length; i++) if (!methods[i].isAbstract())
        copy[idx++] = methods[i];
    for (int i = 0; i < length; i++) if (methods[i].isAbstract())
        copy[idx++] = methods[i];
    return copy;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.util.Sorting.abstractFirst(Aorg.eclipse.jdt.internal.compiler.lookup.MethodBinding;I)Aorg.eclipse.jdt.internal.compiler.lookup.MethodBinding;2
public static MethodBinding[] abstractFirst(MethodBinding[] methods, int length) {
    if (length == 0 || (length > 0 && methods[0].isAbstract()))
        return methods;
    MethodBinding[] copy = new MethodBinding[length];
    int idx = 0;
    for (int i = 0; i < length; i++) if (methods[i].isAbstract())
        copy[idx++] = methods[i];
    for (int i = 0; i < length; i++) if (!methods[i].isAbstract())
        copy[idx++] = methods[i];
    return copy;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTMatcher.match(org.eclipse.jdt.core.dom.NullLiteral;java.lang.Object;)Z3
public boolean match(NullLiteral node, Object other) {
    if (!(other instanceof NullLiteral)) {
        return false;
    }
    return true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.query.ArtifactRepositoryElementWrapper.shouldWrap(java.lang.Object;)Z2
protected boolean shouldWrap(Object match) {
    if ((match instanceof URI))
        return true;
    return false;
}

---------------Library-------------------
method: org.eclipse.swt.graphics.TextLayout.isDisposed()Z1
@Override
public boolean isDisposed() {
    return layout == 0;
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Scrollable.sendLeaveNotify()Z1
@Override
boolean sendLeaveNotify() {
    return scrolledHandle != 0;
}

---------------Library-------------------
method: org.eclipse.equinox.p2.operations.ProfileChangeOperation.getProfileChangeRequest()org.eclipse.equinox.p2.planner.IProfileChangeRequest;1
public IProfileChangeRequest getProfileChangeRequest() {
    if (job != null)
        return job.getProfileChangeRequest();
    return null;
}
---------------Client-------------------
method: org.eclipse.e4.core.internal.di.Requestor.getRequestingObject()java.lang.Object;1
public Object getRequestingObject() {
    if (objectRef == null)
        return null;
    return objectRef.get();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.PackageFragment.exists()Z1
public boolean exists() {
    return super.exists() && !Util.isExcluded(this) && isValidPackageName();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.JdtFlags.isPackageVisible(org.eclipse.jdt.core.dom.BodyDeclaration;)Z1
public static boolean isPackageVisible(BodyDeclaration bodyDeclaration) {
    return (!isPrivate(bodyDeclaration) && !isProtected(bodyDeclaration) && !isPublic(bodyDeclaration));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.JarEntryResource.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof JarEntryResource))
        return false;
    JarEntryResource other = (JarEntryResource) obj;
    return this.parent.equals(other.parent) && this.simpleName.equals(other.simpleName);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.launching.JREContainer$RuleKey.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object obj) {
    if (obj instanceof RuleKey) {
        RuleKey key = (RuleKey) obj;
        return fEnvironmentId.equals(key.fEnvironmentId) && fInstall.equals(key.fInstall);
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isDefinitelyNonNull(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;)Z2
public boolean isDefinitelyNonNull(LocalVariableBinding local) {
    return this.initsWhenTrue.isDefinitelyNonNull(local) && this.initsWhenFalse.isDefinitelyNonNull(local);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isPotentiallyUnknown(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;)Z2
public boolean isPotentiallyUnknown(LocalVariableBinding local) {
    return this.initsWhenTrue.isPotentiallyUnknown(local) || this.initsWhenFalse.isPotentiallyUnknown(local);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isDefinitelyNull(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;)Z2
public boolean isDefinitelyNull(LocalVariableBinding local) {
    return this.initsWhenTrue.isDefinitelyNull(local) && this.initsWhenFalse.isDefinitelyNull(local);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetUnion.contains(org.eclipse.jdt.internal.corext.refactoring.typeconstraints.types.TType;)Z2
@Override
public boolean contains(TType t) {
    return fLHS.contains(t) || fRHS.contains(t);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.Or.evaluate(org.eclipse.equinox.p2.metadata.expression.IEvaluationContext;)java.lang.Object;2
public Object evaluate(IEvaluationContext context) {
    for (int idx = 0; idx < operands.length; ++idx) {
        if (operands[idx].evaluate(context) == Boolean.TRUE)
            return Boolean.TRUE;
    }
    return Boolean.FALSE;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.And.evaluate(org.eclipse.equinox.p2.metadata.expression.IEvaluationContext;)java.lang.Object;2
public Object evaluate(IEvaluationContext context) {
    for (int idx = 0; idx < operands.length; ++idx) {
        if (operands[idx].evaluate(context) != Boolean.TRUE)
            return Boolean.FALSE;
    }
    return Boolean.TRUE;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.index.EntryResult.isEmpty()Z1
public boolean isEmpty() {
    return this.documentTables == null && this.documentNames == null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding.isHierarchyConnected()Z1
public boolean isHierarchyConnected() {
    return this.superclass != null && this.superInterfaces != null;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.URI.hasPath()Z1
public boolean hasPath() {
    return hasAbsolutePath() || (authority == null && device == null);
}
---------------Client-------------------
method: org.eclipse.e4.ui.css.swt.helpers.URI.hasRelativePath()Z1
public boolean hasRelativePath() {
    return authority == null && device == null && !hasAbsolutePath();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo.isProtectedNonNull(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;)Z2
public boolean isProtectedNonNull(LocalVariableBinding local) {
    return this.initsWhenTrue.isProtectedNonNull(local) && this.initsWhenFalse.isProtectedNonNull(local);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetUnion.containsAll(org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet;)Z2
@Override
public boolean containsAll(TypeSet s) {
    return fLHS.containsAll(s) || fRHS.containsAll(s);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.FieldBinding.isUsedOnlyInCompound()Z1
public final boolean isUsedOnlyInCompound() {
    return (this.modifiers & ExtraCompilerModifiers.AccLocallyUsed) == 0 && this.compoundUseFlag > 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.FieldBinding.isUsed()Z1
public final boolean isUsed() {
    return (this.modifiers & ExtraCompilerModifiers.AccLocallyUsed) != 0 || this.compoundUseFlag > 0;
}

---------------Library-------------------
method: org.eclipse.equinox.p2.query.Collector.size()I1
public int size() {
    return collected == null ? 0 : collected.size();
}
---------------Client-------------------
method: org.eclipse.equinox.internal.util.xml.impl.TagImpl.size()I1
public int size() {
    return (fTags != null) ? fTags.size() : 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.impl.Constant.computeConstantOperationAND_AND(org.eclipse.jdt.internal.compiler.impl.Constant;ILorg.eclipse.jdt.internal.compiler.impl.Constant;I)org.eclipse.jdt.internal.compiler.impl.Constant;4
public static final Constant computeConstantOperationAND_AND(Constant left, int leftId, Constant right, int rightId) {
    return BooleanConstant.fromValue(left.booleanValue() && right.booleanValue());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.impl.Constant.computeConstantOperationOR_OR(org.eclipse.jdt.internal.compiler.impl.Constant;ILorg.eclipse.jdt.internal.compiler.impl.Constant;I)org.eclipse.jdt.internal.compiler.impl.Constant;4
public static final Constant computeConstantOperationOR_OR(Constant left, int leftId, Constant right, int rightId) {
    return BooleanConstant.fromValue(left.booleanValue() || right.booleanValue());
}

---------------Library-------------------
method: org.eclipse.osgi.framework.util.KeyedHashSet$EquinoxSetIterator.hasNext()Z1
public boolean hasNext() {
    return found < elementCount;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.index.MemoryIndex.shouldMerge()Z1
boolean shouldMerge() {
    return this.docsToReferences.elementSize >= this.NUM_CHANGES;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.index.FileIndexLocation.equals(java.lang.Object;)Z2
public boolean equals(Object other) {
    if (!(other instanceof FileIndexLocation))
        return false;
    return this.indexFile.equals(((FileIndexLocation) other).indexFile);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.indexing.IndexBinaryFolder.equals(java.lang.Object;)Z2
public boolean equals(Object o) {
    if (o instanceof IndexBinaryFolder)
        return this.folder.equals(((IndexBinaryFolder) o).folder);
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTNode.supportedOnlyIn2_3_4()V1
final void supportedOnlyIn2_3_4() {
    if (this.ast.apiLevel >= AST.JLS8) {
        throw new  UnsupportedOperationException("Operation only supported in JLS2, JLS3 and JLS4 ASTs");
    }
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.ASTNode.unsupportedIn2_3_4()V1
final void unsupportedIn2_3_4() {
    if (this.ast.apiLevel < AST.JLS8) {
        throw new  UnsupportedOperationException("Operation only supported in JLS8 and later AST");
    }
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Shell.getWindowOrigin()org.eclipse.swt.graphics.Point;1
@Override
Point getWindowOrigin() {
    if (!mapped) {
        return getLocation();
    }
    return super.getWindowOrigin();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JarPackageFragmentRoot.internalPath()org.eclipse.core.runtime.IPath;1
public IPath internalPath() {
    if (isExternal()) {
        return this.jarPath;
    } else {
        return super.internalPath();
    }
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTMatcher.match(org.eclipse.jdt.core.dom.LineComment;java.lang.Object;)Z3
public boolean match(LineComment node, Object other) {
    if (!(other instanceof LineComment)) {
        return false;
    }
    return true;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.query.InstalledIUElementWrapper.shouldWrap(java.lang.Object;)Z2
protected boolean shouldWrap(Object match) {
    if (match instanceof IInstallableUnit)
        return true;
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding.isHierarchyConnected()Z1
public boolean isHierarchyConnected() {
    if (!isPrototype())
        return this.prototype.isHierarchyConnected();
    return (this.tagBits & (TagBits.HasUnresolvedSuperclass | TagBits.HasUnresolvedSuperinterfaces)) == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding.isHierarchyConnected()Z1
public boolean isHierarchyConnected() {
    if (!isPrototype())
        return this.prototype.isHierarchyConnected();
    return (this.tagBits & TagBits.EndHierarchyCheck) != 0;
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.FactoryPath.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (!(o instanceof FactoryPath)) {
        return false;
    }
    FactoryPath other = (FactoryPath) o;
    return _path.equals(other._path);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.ArraySuperTypeSet.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object obj) {
    if (obj == this)
        return true;
    if (obj instanceof ArraySuperTypeSet) {
        ArraySuperTypeSet other = (ArraySuperTypeSet) obj;
        return fElemTypeSet.equals(other.fElemTypeSet);
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.spelling.engine.AbstractSpellDictionary.isLoaded()Z1
public final synchronized boolean isLoaded() {
    return fLoaded || fHashBuckets.size() > 0;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.Limit$CountingIterator.hasNext()Z1
public boolean hasNext() {
    return counter > 0 && innerIterator.hasNext();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.text.spelling.engine.AbstractSpellDictionary.isEmpty()Z1
protected boolean isEmpty() {
    return fHashBuckets.size() == 0;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream.hasFramePositions()Z1
public boolean hasFramePositions() {
    return this.framePositions.size() != 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.callhierarchy.CallerMethodWrapper.getExpandWithConstructors()Z1
public boolean getExpandWithConstructors() {
    return fIsExpandWithConstructorsSet && fExpandWithConstructors;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.matching.VariablePattern.mustResolve()Z1
protected boolean mustResolve() {
    return this.findReferences || this.fineGrain != 0;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.impl.Constant.computeConstantOperationLESS_EQUAL(org.eclipse.jdt.internal.compiler.impl.Constant;ILorg.eclipse.jdt.internal.compiler.impl.Constant;I)org.eclipse.jdt.internal.compiler.impl.Constant;4
public static final Constant computeConstantOperationLESS_EQUAL(Constant left, int leftId, Constant right, int rightId) {
    switch(leftId) {
        case T_char:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.charValue() <= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.charValue() <= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.charValue() <= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.charValue() <= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.charValue() <= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.charValue() <= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.charValue() <= right.longValue());
            }
            break;
        case T_float:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.floatValue() <= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.floatValue() <= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.floatValue() <= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.floatValue() <= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.floatValue() <= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.floatValue() <= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.floatValue() <= right.longValue());
            }
            break;
        case T_double:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.doubleValue() <= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.doubleValue() <= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.doubleValue() <= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.doubleValue() <= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.doubleValue() <= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.doubleValue() <= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.doubleValue() <= right.longValue());
            }
            break;
        case T_byte:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.byteValue() <= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.byteValue() <= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.byteValue() <= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.byteValue() <= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.byteValue() <= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.byteValue() <= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.byteValue() <= right.longValue());
            }
            break;
        case T_short:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.shortValue() <= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.shortValue() <= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.shortValue() <= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.shortValue() <= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.shortValue() <= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.shortValue() <= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.shortValue() <= right.longValue());
            }
            break;
        case T_int:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.intValue() <= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.intValue() <= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.intValue() <= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.intValue() <= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.intValue() <= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.intValue() <= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.intValue() <= right.longValue());
            }
            break;
        case T_long:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.longValue() <= right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.longValue() <= right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.longValue() <= right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.longValue() <= right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.longValue() <= right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.longValue() <= right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.longValue() <= right.longValue());
            }
    }
    return NotAConstant;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.impl.Constant.computeConstantOperationGREATER(org.eclipse.jdt.internal.compiler.impl.Constant;ILorg.eclipse.jdt.internal.compiler.impl.Constant;I)org.eclipse.jdt.internal.compiler.impl.Constant;4
public static final Constant computeConstantOperationGREATER(Constant left, int leftId, Constant right, int rightId) {
    switch(leftId) {
        case T_char:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.charValue() > right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.charValue() > right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.charValue() > right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.charValue() > right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.charValue() > right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.charValue() > right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.charValue() > right.longValue());
            }
            break;
        case T_float:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.floatValue() > right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.floatValue() > right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.floatValue() > right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.floatValue() > right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.floatValue() > right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.floatValue() > right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.floatValue() > right.longValue());
            }
            break;
        case T_double:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.doubleValue() > right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.doubleValue() > right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.doubleValue() > right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.doubleValue() > right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.doubleValue() > right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.doubleValue() > right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.doubleValue() > right.longValue());
            }
            break;
        case T_byte:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.byteValue() > right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.byteValue() > right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.byteValue() > right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.byteValue() > right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.byteValue() > right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.byteValue() > right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.byteValue() > right.longValue());
            }
            break;
        case T_short:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.shortValue() > right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.shortValue() > right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.shortValue() > right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.shortValue() > right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.shortValue() > right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.shortValue() > right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.shortValue() > right.longValue());
            }
            break;
        case T_int:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.intValue() > right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.intValue() > right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.intValue() > right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.intValue() > right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.intValue() > right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.intValue() > right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.intValue() > right.longValue());
            }
            break;
        case T_long:
            switch(rightId) {
                case T_char:
                    return BooleanConstant.fromValue(left.longValue() > right.charValue());
                case T_float:
                    return BooleanConstant.fromValue(left.longValue() > right.floatValue());
                case T_double:
                    return BooleanConstant.fromValue(left.longValue() > right.doubleValue());
                case T_byte:
                    return BooleanConstant.fromValue(left.longValue() > right.byteValue());
                case T_short:
                    return BooleanConstant.fromValue(left.longValue() > right.shortValue());
                case T_int:
                    return BooleanConstant.fromValue(left.longValue() > right.intValue());
                case T_long:
                    return BooleanConstant.fromValue(left.longValue() > right.longValue());
            }
    }
    return NotAConstant;
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Widget.gtk_widget_get_realized(J)Z2
boolean gtk_widget_get_realized(long widget) {
    if (OS.GTK_VERSION >= OS.VERSION(2, 20, 0)) {
        return OS.gtk_widget_get_realized(widget);
    } else {
        return (OS.GTK_WIDGET_FLAGS(widget) & OS.GTK_REALIZED) != 0;
    }
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Widget.gtk_widget_get_has_window(J)Z2
boolean gtk_widget_get_has_window(long widget) {
    if (OS.GTK_VERSION >= OS.VERSION(2, 18, 0)) {
        return OS.gtk_widget_get_has_window(widget);
    } else {
        return (OS.GTK_WIDGET_FLAGS(widget) & OS.GTK_NO_WINDOW) == 0;
    }
}

---------------Library-------------------
method: org.eclipse.swt.accessibility.Accessible.checkWidget()V1
void checkWidget() {
    if (!isValidThread())
        SWT.error(SWT.ERROR_THREAD_INVALID_ACCESS);
    if (control.isDisposed())
        SWT.error(SWT.ERROR_WIDGET_DISPOSED);
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
method: org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader.isMember()Z1
public boolean isMember() {
    if (this.innerInfo == null)
        return false;
    if (this.innerInfo.getEnclosingTypeName() == null)
        return false;
    char[] innerSourceName = this.innerInfo.getSourceName();
    return (innerSourceName != null && innerSourceName.length > 0);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader.isLocal()Z1
public boolean isLocal() {
    if (this.innerInfo == null)
        return false;
    if (this.innerInfo.getEnclosingTypeName() != null)
        return false;
    char[] innerSourceName = this.innerInfo.getSourceName();
    return (innerSourceName != null && innerSourceName.length > 0);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.setTouchpointType(org.eclipse.equinox.p2.metadata.ITouchpointType;)V2
public void setTouchpointType(ITouchpointType type) {
    this.touchpointType = (type != ITouchpointType.NONE ? type : null);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.ast.LambdaExpression.setBody(org.eclipse.jdt.internal.compiler.ast.Statement;)V2
public void setBody(Statement body) {
    this.body = body == null ? NO_BODY : body;
}

