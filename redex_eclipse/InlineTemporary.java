/**
* You have a temp that is assigned to once with a simple expression,
* and the temp is getting in the way of other refactoring. Replace 
* all references to that temp with the expression.
*
* Most cases indicate a temporary variable that can be inlined, but 
* do not suggest a good reason for the refactoring.
*/
---------------Library-------------------
method: org.eclipse.core.internal.utils.Cache$Entry.compare(org.eclipse.core.internal.utils.KeyedHashSet$KeyedElement;)Z2
public boolean compare(KeyedHashSet.KeyedElement other) {
    if (!(other instanceof Entry))
        return false;
    Entry otherEntry = (Entry) other;
    return key.equals(otherEntry.key);
    //return key.equals(((Entry) other).key);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}
//it's opportunity. The library can be refactored as the client shows.

---------------Library-------------------
method: org.eclipse.core.databinding.property.map.MapProperty.doSetMap(java.lang.Object;java.util.Map;)V3
protected void doSetMap(Object source, Map map) {
    MapDiff diff = Diffs.computeMapDiff(doGetMap(source), map);
    doUpdateMap(source, diff);
    //doUpdateMap(source, Diffs.computeMapDiff(doGetMap(source), map));
}
---------------Client-------------------
method: org.eclipse.core.databinding.property.list.ListProperty.doSetList(java.lang.Object;java.util.List;)V3
protected void doSetList(Object source, List list) {
    doUpdateList(source, Diffs.computeListDiff(doGetList(source), list));
}
---------------Library-------------------
method: org.eclipse.core.internal.expressions.EqualsExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof EqualsExpression))
        return false;
    final EqualsExpression that = (EqualsExpression) object;
    return this.fExpectedValue.equals(that.fExpectedValue);
    // return this.fExpectedValue.equals(((EqualsExpression)object).fExpectedValue);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}
//it's opportunity.

---------------Library-------------------
method: org.eclipse.core.internal.expressions.InstanceofExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof InstanceofExpression))
        return false;
    final InstanceofExpression that = (InstanceofExpression) object;
    return this.fTypeName.equals(that.fTypeName);
    //return this.fTypeName.equals(((InstanceofExpression) object).fTypeName);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}

---------------Library-------------------
method: org.eclipse.core.commands.Command.getParameterType(java.lang.String;)org.eclipse.core.commands.ParameterType;2
public final ParameterType getParameterType(final String parameterId) throws NotDefinedException {
    final IParameter parameter = getParameter(parameterId);
    if (parameter instanceof ITypedParameter) {
        final ITypedParameter parameterWithType = (ITypedParameter) parameter;
        return parameterWithType.getParameterType();
        //return ((ITypedParameter) parameter).getParameterType();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.beans.AnonymousBeanValueProperty.inferValueType(java.lang.Object;)java.lang.Object;2
private Object inferValueType(Object masterObservableValueType) {
    if (masterObservableValueType instanceof Class) {
        return getClassDelegate((Class) masterObservableValueType).getValueType();
    }
    return null;
}
---------------Library-------------------
method: org.eclipse.core.runtime.RegistryFactory.getRegistry()org.eclipse.core.runtime.IExtensionRegistry;0
public static IExtensionRegistry getRegistry() {
    IRegistryProvider defaultRegistryProvider = RegistryProviderFactory.getDefault();
    if (defaultRegistryProvider == null)
        return null;
    return defaultRegistryProvider.getRegistry();
}
---------------Client-------------------
method: org.eclipse.core.filesystem.EFS.getLocalFileSystem()org.eclipse.core.filesystem.IFileSystem;0
public static IFileSystem getLocalFileSystem() {
    return InternalFileSystemCore.getInstance().getLocalFileSystem();
}
// false positive.
---------------Library-------------------
method: org.eclipse.core.internal.expressions.EqualsExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof EqualsExpression))
        return false;
    final EqualsExpression that = (EqualsExpression) object;
    return this.fExpectedValue.equals(that.fExpectedValue);
    //return this.fExpectedValue.equals(((EqualsExpression)object).fExpectedValue);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}
//it's opportunity.
---------------Library-------------------
method: org.eclipse.core.expressions.Expression.computeExpressionInfo()org.eclipse.core.expressions.ExpressionInfo;1
public final ExpressionInfo computeExpressionInfo() {
    ExpressionInfo result = new  ExpressionInfo();
    collectExpressionInfo(result);
    //collectExpressionInfo(new ExpressionInfo());
    return result;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.reorg.SourceReferenceUtil.sortByOffset(Aorg.eclipse.jdt.core.ISourceReference;)Aorg.eclipse.jdt.core.ISourceReference;1
public static ISourceReference[] sortByOffset(ISourceReference[] methods) {
    Arrays.sort(methods, new  Comparator<ISourceReference>() {

        public int compare(ISourceReference o1, ISourceReference o2) {
            try {
                return o2.getSourceRange().getOffset() - o1.getSourceRange().getOffset();
            } catch (JavaModelException e) {
                return o2.hashCode() - o1.hashCode();
            }
        }
    });
    return methods;
}
//it's opportunity.
---------------Library-------------------
method: org.eclipse.core.internal.content.ContentTypeHandler.removeFileSpec(java.lang.String;I)V3
public void removeFileSpec(String fileSpec, int type) throws CoreException {
    final IContentType target = getTarget();
    if (target != null)
        target.removeFileSpec(fileSpec, type);
}
---------------Client-------------------
method: org.eclipse.osgi.internal.service.security.KeyStoreTrustEngine.loadStore(java.security.KeyStore;java.io.InputStream;)V3
private void loadStore(KeyStore store, InputStream is) throws IOException, GeneralSecurityException {
    store.load(is, getPassword());
}
//false posititve
---------------Library-------------------
method: org.eclipse.core.internal.expressions.InstanceofExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof InstanceofExpression))
        return false;
    final InstanceofExpression that = (InstanceofExpression) object;
    return this.fTypeName.equals(that.fTypeName);
    //return this.fTypeName.equals(((InstanceofExpression) object).fTypeName);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}
//it's opportunity.
---------------Library-------------------
method: org.eclipse.core.internal.content.ContentTypeHandler.addFileSpec(java.lang.String;I)V3
public void addFileSpec(String fileSpec, int type) throws CoreException {
    final IContentType target = getTarget();
    if (target != null)
        target.addFileSpec(fileSpec, type);
}
---------------Client-------------------
method: org.eclipse.osgi.internal.service.security.KeyStoreTrustEngine.loadStore(java.security.KeyStore;java.io.InputStream;)V3
private void loadStore(KeyStore store, InputStream is) throws IOException, GeneralSecurityException {
    store.load(is, getPassword());
}
//false postitive

---------------Library-------------------
method: org.eclipse.core.commands.Command.getParameterType(java.lang.String;)org.eclipse.core.commands.ParameterType;2
public final ParameterType getParameterType(final String parameterId) throws NotDefinedException {
    final IParameter parameter = getParameter(parameterId);
    if (parameter instanceof ITypedParameter) {
        final ITypedParameter parameterWithType = (ITypedParameter) parameter;
        return parameterWithType.getParameterType();
        //return ((ITypedParameter) parameter).getParameterType();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.beans.AnonymousBeanValueProperty.inferValueType(java.lang.Object;)java.lang.Object;2
private Object inferValueType(Object masterObservableValueType) {
    if (masterObservableValueType instanceof Class) {
        return getClassDelegate((Class) masterObservableValueType).getValueType();
    }
    return null;
}

---------------Library-------------------
method: org.eclipse.core.internal.jobs.OrderedLock.forceRelease()I1
protected int forceRelease() {
    int oldDepth = depth;
    doRelease();
    return oldDepth;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.ObservableList.isStale()Z1
public boolean isStale() {
    getterCalled();
    return stale;
}

---------------Library-------------------
method: org.eclipse.core.internal.expressions.NotExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof NotExpression))
        return false;
    final NotExpression that = (NotExpression) object;
    return this.fExpression.equals(that.fExpression);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}

---------------Library-------------------
method: org.eclipse.core.internal.resources.projectvariables.WorkspaceParentLocationVariableResolver.getValue(java.lang.String;org.eclipse.core.resources.IResource;)java.lang.String;3
public String getValue(String variable, IResource resource) {
    IContainer parent = resource.getParent();
    if (parent != null) {
        URI locationURI = parent.getLocationURI();
        if (locationURI != null)
            return locationURI.toASCIIString();
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.template.java.SignatureUtil.getLowerBound(java.lang.String;)java.lang.String;1
public static String getLowerBound(String signature) {
    return String.valueOf(getLowerBound(signature.toCharArray()));
}

---------------Library-------------------
method: org.eclipse.core.internal.events.ResourceDelta.toDebugString()java.lang.String;1
public String toDebugString() {
    final StringBuffer buffer = new  StringBuffer();
    writeDebugString(buffer);
    return buffer.toString();
}
---------------Client-------------------
method: org.eclipse.jdt.core.Signature.createArraySignature(java.lang.String;I)java.lang.String;2
public static String createArraySignature(String typeSignature, int arrayCount) {
    return new  String(createArraySignature(typeSignature.toCharArray(), arrayCount));
}

---------------Library-------------------
method: org.eclipse.core.internal.databinding.property.value.ListSimpleValueObservableList.get(I)java.lang.Object;2
public Object get(int index) {
    getterCalled();
    Object masterElement = masterList.get(index);
    return detailProperty.getValue(masterElement);
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.property.value.MapSimpleValueObservableMap.get(java.lang.Object;)java.lang.Object;2
public Object get(Object key) {
    getterCalled();
    return detailProperty.getValue(masterMap.get(key));
}

---------------Library-------------------
method: org.eclipse.core.internal.filebuffers.ExtensionsRegistry.log(org.eclipse.core.runtime.IStatus;)V2
private void log(IStatus status) {
    ILog log = FileBuffersPlugin.getDefault().getLog();
    log.log(status);
}
---------------Client-------------------
method: org.eclipse.jdt.junit.JUnitCore.addTestRunListener(org.eclipse.jdt.junit.TestRunListener;)V1
public static void addTestRunListener(TestRunListener listener) {
    JUnitCorePlugin.getDefault().getNewTestRunListeners().add(listener);
}

---------------Library-------------------
method: org.eclipse.core.internal.expressions.ReferenceExpression.equals(java.lang.Object;)Z2
public boolean equals(final Object object) {
    if (!(object instanceof ReferenceExpression))
        return false;
    final ReferenceExpression that = (ReferenceExpression) object;
    return this.fDefinitionId.equals(that.fDefinitionId);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.util.FloatUtil.valueOfHexDoubleLiteral(AC)D1
public static double valueOfHexDoubleLiteral(char[] source) {
    long bits = convertHexFloatingPointLiteralToBits(source);
    return Double.longBitsToDouble(bits);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.util.io.PDataStream.readDouble(java.io.InputStream;)D1
public static double readDouble(InputStream is) throws IOException {
    return Double.longBitsToDouble(readLong(is));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BatchInitializationMonitor.isCanceled()Z1
public boolean isCanceled() {
    IProgressMonitor monitor = getMonitor();
    if (monitor != null)
        return monitor.isCanceled();
    return false;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.ComputedList.doGetSize()I1
protected int doGetSize() {
    return doGetList().size();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.search.ExceptionOccurrencesFinder.matches(org.eclipse.jdt.core.dom.IMethodBinding;)Z2
private boolean matches(IMethodBinding binding) {
    if (binding == null)
        return false;
    ITypeBinding[] exceptions = binding.getExceptionTypes();
    for (int i = 0; i < exceptions.length; i++) {
        ITypeBinding exception = exceptions[i];
        if (matches(exception))
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
method: org.eclipse.swt.widgets.MenuItem.addArmListener(org.eclipse.swt.events.ArmListener;)V2
public void addArmListener(ArmListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    TypedListener typedListener = new  TypedListener(listener);
    addListener(SWT.Arm, typedListener);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Combo.addSegmentListener(org.eclipse.swt.events.SegmentListener;)V2
public void addSegmentListener(SegmentListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    addListener(SWT.Segments, new  TypedListener(listener));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryType.isAnonymous()Z1
public boolean isAnonymous() throws JavaModelException {
    IBinaryType info = (IBinaryType) getElementInfo();
    return info.isAnonymous();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMember.isStructureKnown()Z1
public boolean isStructureKnown() throws JavaModelException {
    return ((IJavaElement) getOpenableParent()).isStructureKnown();
}

---------------Library-------------------
method: org.eclipse.core.internal.utils.Cache$Entry.compare(org.eclipse.core.internal.utils.KeyedHashSet$KeyedElement;)Z2
public boolean compare(KeyedHashSet.KeyedElement other) {
    if (!(other instanceof Entry))
        return false;
    Entry otherEntry = (Entry) other;
    return key.equals(otherEntry.key);
}
---------------Client-------------------
method: org.eclipse.core.internal.content.DefaultDescription.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    if (!(obj instanceof DefaultDescription))
        return false;
    return contentTypeInfo.equals(((DefaultDescription) obj).contentTypeInfo);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryType.isLocal()Z1
public boolean isLocal() throws JavaModelException {
    IBinaryType info = (IBinaryType) getElementInfo();
    return info.isLocal();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMember.isStructureKnown()Z1
public boolean isStructureKnown() throws JavaModelException {
    return ((IJavaElement) getOpenableParent()).isStructureKnown();
}

---------------Library-------------------
method: org.eclipse.swt.browser.Mozilla.SetStatus(IJ)I3
int SetStatus(int statusType, long status) {
    if (statusTextListeners.length == 0)
        return XPCOM.NS_OK;
    StatusTextEvent event = new  StatusTextEvent(browser);
    event.display = browser.getDisplay();
    event.widget = browser;
    int length = XPCOM.strlen_PRUnichar(status);
    char[] dest = new char[length];
    XPCOM.memmove(dest, status, length * 2);
    String string = new  String(dest);
    event.text = string;
    for (int i = 0; i < statusTextListeners.length; i++) {
        statusTextListeners[i].changed(event);
    }
    return XPCOM.NS_OK;
}
---------------Client-------------------
method: org.eclipse.swt.browser.Mozilla.OnStatusChange(JJIJ)I5
int OnStatusChange(long aWebProgress, long aRequest, int aStatus, long aMessage) {
    if (statusTextListeners.length == 0)
        return XPCOM.NS_OK;
    StatusTextEvent event = new  StatusTextEvent(browser);
    event.display = browser.getDisplay();
    event.widget = browser;
    int length = XPCOM.strlen_PRUnichar(aMessage);
    char[] dest = new char[length];
    XPCOM.memmove(dest, aMessage, length * 2);
    event.text = new  String(dest);
    for (int i = 0; i < statusTextListeners.length; i++) {
        statusTextListeners[i].changed(event);
    }
    return XPCOM.NS_OK;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTFontHelper.getFont(org.eclipse.e4.ui.css.core.dom.properties.css2.CSS2FontProperties;org.eclipse.swt.graphics.FontData;org.eclipse.swt.widgets.Display;)org.eclipse.swt.graphics.Font;3
public static Font getFont(CSS2FontProperties fontProperties, FontData oldFontData, Display display) {
    FontData newFontData = getFontData(fontProperties, oldFontData);
    return new  Font(display, newFontData);
}
---------------Client-------------------
method: org.eclipse.equinox.p2.engine.ProvisioningContext.getArtifactRepositories(org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.equinox.p2.query.IQueryable;2
public IQueryable<IArtifactRepository> getArtifactRepositories(IProgressMonitor monitor) {
    return new  ArtifactRepositoryQueryable(getLoadedArtifactRepositories(monitor));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.DocumentElementParser.consumeConstructorDeclaration()V1
protected void consumeConstructorDeclaration() {
    super.consumeConstructorDeclaration();
    if (isLocalDeclaration()) {
        return;
    }
    ConstructorDeclaration cd = (ConstructorDeclaration) this.astStack[this.astPtr];
    this.requestor.exitConstructor(this.endStatementPosition, cd.declarationSourceEnd);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.DocumentElementParser.consumeClassDeclaration()V1
protected void consumeClassDeclaration() {
    super.consumeClassDeclaration();
    if (isLocalDeclaration()) {
        return;
    }
    this.requestor.exitClass(this.endStatementPosition, ((TypeDeclaration) this.astStack[this.astPtr]).declarationSourceEnd);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.matching.OrLocator.setFlavors(I)V2
void setFlavors(int flavors) {
    for (int i = 0, length = this.patternLocators.length; i < length; i++) {
        this.patternLocators[i].setFlavors(flavors);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.IntersectionCastTypeBinding.collectInferenceVariables(java.util.Set;)V2
@Override
void collectInferenceVariables(Set<InferenceVariable> variables) {
    for (int i = 0; i < this.intersectingTypes.length; i++) this.intersectingTypes[i].collectInferenceVariables(variables);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.matching.MatchLocator.newTypeParameterReferenceMatch(org.eclipse.jdt.core.IJavaElement;IIILorg.eclipse.jdt.internal.compiler.ast.ASTNode;)org.eclipse.jdt.core.search.SearchMatch;6
public SearchMatch newTypeParameterReferenceMatch(IJavaElement enclosingElement, int accuracy, int offset, int length, ASTNode reference) {
    int bits = reference.bits;
    boolean insideDocComment = (bits & ASTNode.InsideJavadoc) != 0;
    SearchParticipant participant = getParticipant();
    IResource resource = this.currentPossibleMatch.resource;
    return new  TypeParameterReferenceMatch(enclosingElement, accuracy, offset, length, insideDocComment, participant, resource);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.matching.MatchLocator.newPackageReferenceMatch(org.eclipse.jdt.core.IJavaElement;IIILorg.eclipse.jdt.internal.compiler.ast.ASTNode;)org.eclipse.jdt.core.search.PackageReferenceMatch;6
public PackageReferenceMatch newPackageReferenceMatch(IJavaElement enclosingElement, int accuracy, int offset, int length, ASTNode reference) {
    SearchParticipant participant = getParticipant();
    IResource resource = this.currentPossibleMatch.resource;
    boolean insideDocComment = (reference.bits & ASTNode.InsideJavadoc) != 0;
    return new  PackageReferenceMatch(enclosingElement, accuracy, offset, length, insideDocComment, participant, resource);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.apt.model.ExecutableElementImpl.getModifiers()java.util.Set;1
@Override
public Set<Modifier> getModifiers() {
    MethodBinding binding = (MethodBinding) _binding;
    return Factory.getModifiers(binding.modifiers, getKind());
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.apt.model.ErrorTypeElement.asType()javax.lang.model.type.TypeMirror;1
@Override
public TypeMirror asType() {
    return this._env.getFactory().getErrorType((ReferenceBinding) this._binding);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.refactoring.descriptors.JavaRefactoringDescriptorUtil.getInt(java.util.Map;java.lang.String;)I2
public static int getInt(Map map, String attribute) throws IllegalArgumentException {
    String value = getString(map, attribute);
    try {
        return Integer.parseInt(value);
    } catch (NumberFormatException e) {
        throw new  IllegalArgumentException("The attribute '" + attribute + "' does not contain a valid int '" + value + "'");
    }
}
---------------Client-------------------
method: org.eclipse.core.commands.ParameterType.isInstanceOf(java.lang.Object;java.lang.String;)Z2
private static final boolean isInstanceOf(final Object element, final String type) {
    if (element == null) {
        return false;
    }
    return isSubtype(element.getClass(), type);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.util.xml.XMLParser.parseXML(java.io.InputStream;org.eclipse.equinox.internal.util.xml.ExTagListener;I)V3
public static void parseXML(InputStream aInputStream, ExTagListener aListener, int aLevel) throws IOException {
    XMLParserImpl xml = new  XMLParserImpl(aInputStream, aListener);
    xml.setLevel(aLevel);
    xml.parseXML();
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.DecoratingObservableList.fireListChange(org.eclipse.core.databinding.observable.list.ListDiff;)V2
protected void fireListChange(ListDiff diff) {
    super.fireChange();
    fireEvent(new  ListChangeEvent(this, diff));
}

---------------Library-------------------
method: org.eclipse.swt.custom.TableTree.checkStyle(I)I1
private static int checkStyle(int style) {
    int mask = SWT.LEFT_TO_RIGHT | SWT.RIGHT_TO_LEFT;
    style = style & mask;
    return style;
}
---------------Client-------------------
method: org.eclipse.swt.custom.AnimatedProgress.checkStyle(I)I1
private static int checkStyle(int style) {
    int mask = SWT.NONE;
    return style & mask;
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.helpers.CSSSWTColorHelper.getRGBColor(org.eclipse.swt.graphics.RGB;)org.w3c.dom.css.RGBColor;1
public static RGBColor getRGBColor(RGB color) {
    int red = color.red;
    int green = color.green;
    int blue = color.blue;
    return new  CSS2RGBColorImpl(red, green, blue);
}
---------------Client-------------------
method: org.eclipse.equinox.p2.publisher.eclipse.EclipseInstallAction.createRootIUAction()org.eclipse.equinox.p2.publisher.IPublisherAction;1
protected IPublisherAction createRootIUAction() {
    return new  RootIUAction(id, version, name);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsCreator.endVisit(org.eclipse.jdt.core.dom.SingleVariableDeclaration;)V2
@Override
public final void endVisit(final SingleVariableDeclaration node) {
    final ConstraintVariable2 ancestor = (ConstraintVariable2) node.getType().getProperty(PROPERTY_CONSTRAINT_VARIABLE);
    if (ancestor != null) {
        node.setProperty(PROPERTY_CONSTRAINT_VARIABLE, ancestor);
        final Expression expression = node.getInitializer();
        if (expression != null) {
            final ConstraintVariable2 descendant = (ConstraintVariable2) expression.getProperty(PROPERTY_CONSTRAINT_VARIABLE);
            if (descendant != null)
                fModel.createSubtypeConstraint(descendant, ancestor);
        }
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsCreator.endVisit(org.eclipse.jdt.core.dom.Assignment;)V2
@Override
public final void endVisit(final Assignment node) {
    final ConstraintVariable2 ancestor = (ConstraintVariable2) node.getLeftHandSide().getProperty(PROPERTY_CONSTRAINT_VARIABLE);
    final ConstraintVariable2 descendant = (ConstraintVariable2) node.getRightHandSide().getProperty(PROPERTY_CONSTRAINT_VARIABLE);
    node.setProperty(PROPERTY_CONSTRAINT_VARIABLE, ancestor);
    if (ancestor != null && descendant != null)
        fModel.createSubtypeConstraint(descendant, ancestor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.classfmt.FieldInfoWithAnnotation.initialize()V1
protected void initialize() {
    if (this.annotations != null)
        for (int i = 0, max = this.annotations.length; i < max; i++) this.annotations[i].initialize();
    super.initialize();
}
---------------Client-------------------
method: org.eclipse.core.runtime.model.ExtensionModel.markReadOnly()V1
public void markReadOnly() {
    super.markReadOnly();
    if (elements != null)
        for (int i = 0; i < elements.length; i++) elements[i].markReadOnly();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.util.xml.XMLParser.parseXML(java.io.Reader;org.eclipse.equinox.internal.util.xml.ExTagListener;I)V3
public static void parseXML(Reader aReader, ExTagListener aListener, int aLevel) throws IOException {
    XMLParserImpl xml = new  XMLParserImpl(aReader, aListener);
    xml.setLevel(aLevel);
    xml.parseXML();
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.DecoratingObservableList.fireListChange(org.eclipse.core.databinding.observable.list.ListDiff;)V2
protected void fireListChange(ListDiff diff) {
    super.fireChange();
    fireEvent(new  ListChangeEvent(this, diff));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.TypeSystem.getDerivedTypes(org.eclipse.jdt.internal.compiler.lookup.TypeBinding;)Aorg.eclipse.jdt.internal.compiler.lookup.TypeBinding;2
protected final TypeBinding[] getDerivedTypes(TypeBinding keyType) {
    keyType = getUnannotatedType(keyType);
    return this.types[keyType.id];
}
---------------Client-------------------
method: org.eclipse.core.internal.utils.Queue.peekTail()java.lang.Object;1
public T peekTail() {
    return (T) elements[decrement(tail)];
}

---------------Library-------------------
method: org.eclipse.equinox.internal.util.xml.XMLReader.parseXML(java.io.Reader;org.eclipse.equinox.internal.util.xml.TagListener;I)V3
public static void parseXML(Reader aReader, TagListener aListener, int aLevel) throws IOException {
    XMLReader xml = new  XMLReader(aReader, aListener);
    xml.setLevel(aLevel);
    xml.parseXML();
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.DecoratingObservableList.fireListChange(org.eclipse.core.databinding.observable.list.ListDiff;)V2
protected void fireListChange(ListDiff diff) {
    super.fireChange();
    fireEvent(new  ListChangeEvent(this, diff));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration$1.compare(java.lang.Object;java.lang.Object;)I3
public int compare(Object o1, Object o2) {
    StringLiteral literal1 = (StringLiteral) o1;
    StringLiteral literal2 = (StringLiteral) o2;
    return literal1.sourceStart - literal2.sourceStart;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.matching.MatchingNodeSet$1.compare(java.lang.Object;java.lang.Object;)I3
public int compare(Object o1, Object o2) {
    return ((ASTNode) o1).sourceStart - ((ASTNode) o2).sourceStart;
}

---------------Library-------------------
method: org.eclipse.core.databinding.property.map.MapProperty.doSetMap(java.lang.Object;java.util.Map;)V3
protected void doSetMap(Object source, Map map) {
    MapDiff diff = Diffs.computeMapDiff(doGetMap(source), map);
    doUpdateMap(source, diff);
}
---------------Client-------------------
method: org.eclipse.core.databinding.property.list.ListProperty.doSetList(java.lang.Object;java.util.List;)V3
protected void doSetList(Object source, List list) {
    doUpdateList(source, Diffs.computeListDiff(doGetList(source), list));
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.eclipse.AggregatedBundleRepository.query(org.eclipse.equinox.p2.query.IQuery;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.equinox.p2.query.IQueryResult;3
public IQueryResult<IArtifactKey> query(IQuery<IArtifactKey> query, IProgressMonitor monitor) {
    IQueryable<IArtifactKey> queryable = QueryUtil.compoundQueryable(bundleRepositories);
    return queryable.query(query, monitor);
}
---------------Client-------------------
method: org.eclipse.core.internal.databinding.IdentityMap.put(java.lang.Object;java.lang.Object;)java.lang.Object;3
public Object put(Object key, Object value) {
    return wrappedMap.put(IdentityWrapper.wrap(key), value);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope.problemReporter()org.eclipse.jdt.internal.compiler.problem.ProblemReporter;1
public ProblemReporter problemReporter() {
    ProblemReporter problemReporter = this.referenceContext.problemReporter;
    problemReporter.referenceContext = this.referenceContext;
    return problemReporter;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.DocumentElementParser.problemReporter()org.eclipse.jdt.internal.compiler.problem.ProblemReporter;1
public ProblemReporter problemReporter() {
    this.problemReporter.referenceContext = this.referenceContext;
    return this.problemReporter;
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.AbstractTypeDeclaration.isLocalTypeDeclaration()Z1
public boolean isLocalTypeDeclaration() {
    ASTNode parent = getParent();
    return (parent instanceof TypeDeclarationStatement);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.TagElement.isNested()Z1
public boolean isNested() {
    return (getParent() instanceof TagElement);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.junit.runner.junit3.JUnit3Identifier.equals(java.lang.Object;)Z2
public boolean equals(Object obj) {
    JUnit3Identifier id = (JUnit3Identifier) obj;
    return ref.equals(id.ref);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.security.storage.friends.ReEncrypter.switchToNewPassword()Z1
public boolean switchToNewPassword() {
    return ((SecurePreferencesWrapper) root).passwordChanging(moduleID);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.builder.ReferenceCollection.includes(AC)Z2
public boolean includes(char[] simpleName) {
    for (int i = 0, l = this.simpleNameReferences.length; i < l; i++) if (simpleName == this.simpleNameReferences[i])
        return true;
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.SnippetFinder.isSnippetNode(org.eclipse.jdt.core.dom.ASTNode;)Z2
private boolean isSnippetNode(ASTNode node) {
    for (int i = 0; i < fSnippet.length; i++) {
        if (node == fSnippet[i])
            return true;
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.matching.OrLocator.initializePolymorphicSearch(org.eclipse.jdt.internal.core.search.matching.MatchLocator;)V2
public void initializePolymorphicSearch(MatchLocator locator) {
    for (int i = 0, length = this.patternLocators.length; i < length; i++) this.patternLocators[i].initializePolymorphicSearch(locator);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.IntersectionCastTypeBinding.collectInferenceVariables(java.util.Set;)V2
@Override
void collectInferenceVariables(Set<InferenceVariable> variables) {
    for (int i = 0; i < this.intersectingTypes.length; i++) this.intersectingTypes[i].collectInferenceVariables(variables);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.matching.AndLocator.initializePolymorphicSearch(org.eclipse.jdt.internal.core.search.matching.MatchLocator;)V2
public void initializePolymorphicSearch(MatchLocator locator) {
    for (int i = 0, length = this.patternLocators.length; i < length; i++) {
        this.patternLocators[i].initializePolymorphicSearch(locator);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.lookup.IntersectionCastTypeBinding.collectInferenceVariables(java.util.Set;)V2
@Override
void collectInferenceVariables(Set<InferenceVariable> variables) {
    for (int i = 0; i < this.intersectingTypes.length; i++) this.intersectingTypes[i].collectInferenceVariables(variables);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.search.indexing.IndexManager.getIndex(org.eclipse.core.runtime.IPath;ZZ)org.eclipse.jdt.internal.core.index.Index;4
public synchronized Index getIndex(IPath containerPath, boolean reuseExistingFile, boolean createIfMissing) {
    IndexLocation indexLocation = computeIndexLocation(containerPath);
    return getIndex(containerPath, indexLocation, reuseExistingFile, createIfMissing);
}
---------------Client-------------------
method: org.eclipse.jdt.ui.CodeGeneration.getCompilationUnitContent(org.eclipse.jdt.core.ICompilationUnit;java.lang.String;java.lang.String;java.lang.String;)java.lang.String;4
public static String getCompilationUnitContent(ICompilationUnit cu, String typeComment, String typeContent, String lineDelimiter) throws CoreException {
    return getCompilationUnitContent(cu, getFileComment(cu, lineDelimiter), typeComment, typeContent, lineDelimiter);
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.ASTConverter.convert(org.eclipse.jdt.internal.compiler.ast.DoStatement;)org.eclipse.jdt.core.dom.DoStatement;2
public DoStatement convert(org.eclipse.jdt.internal.compiler.ast.DoStatement statement) {
    DoStatement doStatement = new  DoStatement(this.ast);
    doStatement.setSourceRange(statement.sourceStart, statement.sourceEnd - statement.sourceStart + 1);
    doStatement.setExpression(convert(statement.condition));
    final Statement action = convert(statement.action);
    if (action == null)
        return null;
    doStatement.setBody(action);
    return doStatement;
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.ASTConverter.convert(org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;)org.eclipse.jdt.core.dom.SynchronizedStatement;2
public SynchronizedStatement convert(org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement statement) {
    SynchronizedStatement synchronizedStatement = new  SynchronizedStatement(this.ast);
    synchronizedStatement.setSourceRange(statement.sourceStart, statement.sourceEnd - statement.sourceStart + 1);
    synchronizedStatement.setBody(convert(statement.block));
    synchronizedStatement.setExpression(convert(statement.expression));
    return synchronizedStatement;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.builder.ReferenceCollection.insideRoot(AC)Z2
public boolean insideRoot(char[] rootName) {
    for (int i = 0, l = this.rootReferences.length; i < l; i++) if (rootName == this.rootReferences[i])
        return true;
    return false;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.code.SnippetFinder.isSnippetNode(org.eclipse.jdt.core.dom.ASTNode;)Z2
private boolean isSnippetNode(ASTNode node) {
    for (int i = 0; i < fSnippet.length; i++) {
        if (node == fSnippet[i])
            return true;
    }
    return false;
}

---------------Library-------------------
method: org.eclipse.swt.custom.CCombo.addModifyListener(org.eclipse.swt.events.ModifyListener;)V2
public void addModifyListener(ModifyListener listener) {
    checkWidget();
    if (listener == null)
        SWT.error(SWT.ERROR_NULL_ARGUMENT);
    TypedListener typedListener = new  TypedListener(listener);
    addListener(SWT.Modify, typedListener);
}
---------------Client-------------------
method: org.eclipse.swt.custom.StyledText.addModifyListener(org.eclipse.swt.events.ModifyListener;)V2
public void addModifyListener(ModifyListener modifyListener) {
    checkWidget();
    if (modifyListener == null)
        SWT.error(SWT.ERROR_NULL_ARGUMENT);
    addListener(SWT.Modify, new  TypedListener(modifyListener));
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.VersionFormatParser$Qualifier.toString()java.lang.String;1
public String toString() {
    StringBuffer sb = new  StringBuffer();
    toString(sb);
    return sb.toString();
}
---------------Client-------------------
method: org.eclipse.jdt.core.Signature.createArraySignature(java.lang.String;I)java.lang.String;2
public static String createArraySignature(String typeSignature, int arrayCount) {
    return new  String(createArraySignature(typeSignature.toCharArray(), arrayCount));
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Combo.addModifyListener(org.eclipse.swt.events.ModifyListener;)V2
public void addModifyListener(ModifyListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    TypedListener typedListener = new  TypedListener(listener);
    addListener(SWT.Modify, typedListener);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Combo.addSegmentListener(org.eclipse.swt.events.SegmentListener;)V2
public void addSegmentListener(SegmentListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    addListener(SWT.Segments, new  TypedListener(listener));
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.dom.WidgetElement.applyStyles(org.eclipse.swt.widgets.Widget;Z)V2
public static void applyStyles(Widget widget, boolean applyStylesToChildNodes) {
    CSSEngine engine = getEngine(widget);
    if (engine != null) {
        engine.applyStyles(widget, applyStylesToChildNodes);
    }
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.SaveContext.map(org.eclipse.core.runtime.IPath;org.eclipse.core.runtime.IPath;)V3
public void map(IPath file, IPath location) {
    getFileTable().map(file, location);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryType.getChildren()Aorg.eclipse.jdt.core.IJavaElement;1
public IJavaElement[] getChildren() throws JavaModelException {
    ClassFileInfo cfi = getClassFileInfo();
    return cfi.binaryChildren;
}
---------------Client-------------------
method: org.eclipse.core.commands.ParameterizedCommand.getId()java.lang.String;1
public final String getId() {
    return command.getId();
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.properties.AbstractCSSPropertySWTHandler.retrieveCSSProperty(java.lang.Object;java.lang.String;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)java.lang.String;5
@Override
public String retrieveCSSProperty(Object element, String property, String pseudo, CSSEngine engine) throws Exception {
    Control control = SWTElementHelpers.getControl(element);
    if (control != null) {
        return retrieveCSSProperty(control, property, pseudo, engine);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.launching.environments.AccessRuleParticipant.getAccessRules(org.eclipse.jdt.launching.environments.IExecutionEnvironment;org.eclipse.jdt.launching.IVMInstall;Aorg.eclipse.jdt.launching.LibraryLocation;org.eclipse.jdt.core.IJavaProject;)AAorg.eclipse.jdt.core.IAccessRule;5
public IAccessRule[][] getAccessRules(IExecutionEnvironment environment, IVMInstall vm, LibraryLocation[] libraries, IJavaProject project) {
    try {
        return getDelegate().getAccessRules(environment, vm, libraries, project);
    } catch (CoreException e) {
        LaunchingPlugin.log(e.getStatus());
    }
    IAccessRule[][] rules = new IAccessRule[libraries.length][];
    for (int i = 0; i < rules.length; i++) {
        rules[i] = new IAccessRule[0];
    }
    return rules;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ImportDeclaration.getNameRange()org.eclipse.jdt.core.ISourceRange;1
public ISourceRange getNameRange() throws JavaModelException {
    ImportDeclarationElementInfo info = (ImportDeclarationElementInfo) getElementInfo();
    return info.getNameRange();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JarPackageFragment.storedNonJavaResources()Ajava.lang.Object;1
protected Object[] storedNonJavaResources() throws JavaModelException {
    return ((JarPackageFragmentInfo) getElementInfo()).getNonJavaResources();
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Table.select(I)V2
public void select(int index) {
    checkWidget();
    if (!(0 <= index && index < itemCount))
        return;
    boolean fixColumn = showFirstColumn();
    long selection = OS.gtk_tree_view_get_selection(handle);
    OS.g_signal_handlers_block_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
    TableItem item = _getItem(index);
    OS.gtk_tree_selection_select_iter(selection, item.handle);
    OS.g_signal_handlers_unblock_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
    if (fixColumn)
        hideFirstColumn();
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Table.deselect(I)V2
public void deselect(int index) {
    checkWidget();
    if (index < 0 || index >= itemCount)
        return;
    boolean fixColumn = showFirstColumn();
    long selection = OS.gtk_tree_view_get_selection(handle);
    OS.g_signal_handlers_block_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
    OS.gtk_tree_selection_unselect_iter(selection, _getItem(index).handle);
    OS.g_signal_handlers_unblock_matched(selection, OS.G_SIGNAL_MATCH_DATA, 0, 0, 0, 0, CHANGED);
    if (fixColumn)
        hideFirstColumn();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.PackageFragmentRoot.delete(IILorg.eclipse.core.runtime.IProgressMonitor;)V4
public void delete(int updateResourceFlags, int updateModelFlags, IProgressMonitor monitor) throws JavaModelException {
    DeletePackageFragmentRootOperation op = new  DeletePackageFragmentRootOperation(this, updateResourceFlags, updateModelFlags);
    op.runOperation(monitor);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.indexing.IndexManager.remove(java.lang.String;org.eclipse.core.runtime.IPath;)V3
public void remove(String containerRelativePath, IPath indexedContainer) {
    request(new  RemoveFromIndex(containerRelativePath, indexedContainer, this));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceRefElement.getAnnotations()Aorg.eclipse.jdt.core.IAnnotation;1
public IAnnotation[] getAnnotations() throws JavaModelException {
    AnnotatableInfo info = (AnnotatableInfo) getElementInfo();
    return info.annotations;
}
---------------Client-------------------
method: org.eclipse.core.internal.localstore.UnifiedTree.getWorkspace()org.eclipse.core.internal.resources.Workspace;1
protected Workspace getWorkspace() {
    return (Workspace) root.getWorkspace();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceMethod.getExceptionTypes()Ajava.lang.String;1
public String[] getExceptionTypes() throws JavaModelException {
    SourceMethodElementInfo info = (SourceMethodElementInfo) getElementInfo();
    char[][] exs = info.getExceptionTypeNames();
    return CompilationUnitStructureRequestor.convertTypeNamesToSigs(exs);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryField.getConstant()java.lang.Object;1
public Object getConstant() throws JavaModelException {
    IBinaryField info = (IBinaryField) getElementInfo();
    return convertConstant(info.getConstant());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.util.xml.impl.XMLParserImpl.parseXML(java.io.InputStream;org.eclipse.equinox.internal.util.xml.ExTagListener;I)V3
public static void parseXML(InputStream aInputStream, ExTagListener aListener, int aLevel) throws IOException {
    XMLParserImpl xml = new  XMLParserImpl(aInputStream, aListener);
    xml.setLevel(aLevel);
    xml.parseXML();
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.DecoratingObservableList.fireListChange(org.eclipse.core.databinding.observable.list.ListDiff;)V2
protected void fireListChange(ListDiff diff) {
    super.fireChange();
    fireEvent(new  ListChangeEvent(this, diff));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.Member.getFlags()I1
public int getFlags() throws JavaModelException {
    MemberElementInfo info = (MemberElementInfo) getElementInfo();
    return info.getModifiers();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMember.isStructureKnown()Z1
public boolean isStructureKnown() throws JavaModelException {
    return ((IJavaElement) getOpenableParent()).isStructureKnown();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsCreator.endVisit(org.eclipse.jdt.core.dom.FieldAccess;)V2
@Override
public final void endVisit(final FieldAccess node) {
    final IVariableBinding binding = node.resolveFieldBinding();
    if (binding != null)
        endVisit(binding, node.getExpression(), node);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsCreator.endVisit(org.eclipse.jdt.core.dom.FieldDeclaration;)V2
@Override
public final void endVisit(final FieldDeclaration node) {
    endVisit(node.fragments(), node.getType(), node);
}

---------------Library-------------------
method: org.eclipse.jdt.launching.AbstractVMInstallType.getVMInstalls()Aorg.eclipse.jdt.launching.IVMInstall;1
public synchronized IVMInstall[] getVMInstalls() {
    IVMInstall[] vms = new IVMInstall[fVMs.size()];
    return fVMs.toArray(vms);
}
---------------Client-------------------
method: org.eclipse.core.commands.CommandManager.getDefinedCommands()Aorg.eclipse.core.commands.Command;1
public final Command[] getDefinedCommands() {
    return (Command[]) definedHandleObjects.toArray(new Command[definedHandleObjects.size()]);
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Spinner.addModifyListener(org.eclipse.swt.events.ModifyListener;)V2
public void addModifyListener(ModifyListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    TypedListener typedListener = new  TypedListener(listener);
    addListener(SWT.Modify, typedListener);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Combo.addSegmentListener(org.eclipse.swt.events.SegmentListener;)V2
public void addSegmentListener(SegmentListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    addListener(SWT.Segments, new  TypedListener(listener));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsModel.getVariableUsage(org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;)java.util.Collection;1
public static Collection<ITypeConstraint2> getVariableUsage(final ConstraintVariable2 variable) {
    final Object data = variable.getData(DATA_USAGE);
    if (data == null) {
        return Collections.emptyList();
    } else if (data instanceof Collection) {
        @SuppressWarnings("unchecked") Collection<ITypeConstraint2> collection = (Collection<ITypeConstraint2>) data;
        return Collections.unmodifiableCollection(collection);
    } else {
        return Collections.singletonList((ITypeConstraint2) data);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.generics.InferTypeArgumentsTCModel.getUsedIn(org.eclipse.jdt.internal.corext.refactoring.typeconstraints2.ConstraintVariable2;)java.util.List;2
@SuppressWarnings("unchecked")
public List<ITypeConstraint2> getUsedIn(ConstraintVariable2 cv) {
    Object usedIn = cv.getData(USED_IN);
    if (usedIn == null)
        return Collections.emptyList();
    else if (usedIn instanceof ArrayList)
        return Collections.unmodifiableList((ArrayList<ITypeConstraint2>) usedIn);
    else
        return Collections.singletonList((ITypeConstraint2) usedIn);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.rename.TempOccurrenceAnalyzer.perform()V1
public void perform() {
    ASTNode cuNode = ASTNodes.getParent(fTempDeclaration, CompilationUnit.class);
    cuNode.accept(this);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.batch.Main$Logger.compiling()V1
public void compiling() {
    printlnOut(this.main.bind("progress.compiling"));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsCreator.endVisit(org.eclipse.jdt.core.dom.VariableDeclarationFragment;)V2
@Override
public final void endVisit(final VariableDeclarationFragment node) {
    final Expression initializer = node.getInitializer();
    if (initializer != null)
        node.setProperty(PROPERTY_CONSTRAINT_VARIABLE, initializer.getProperty(PROPERTY_CONSTRAINT_VARIABLE));
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.refactoring.structure.constraints.SuperTypeConstraintsCreator.endVisit(org.eclipse.jdt.core.dom.ArrayAccess;)V2
@Override
public final void endVisit(final ArrayAccess node) {
    node.setProperty(PROPERTY_CONSTRAINT_VARIABLE, node.getArray().getProperty(PROPERTY_CONSTRAINT_VARIABLE));
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.phases.Collect.initializeOperand(org.eclipse.equinox.p2.engine.IProfile;org.eclipse.equinox.internal.p2.engine.InstallableUnitOperand;java.util.Map;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.IStatus;5
protected IStatus initializeOperand(IProfile profile, InstallableUnitOperand operand, Map<String, Object> parameters, IProgressMonitor monitor) {
    IStatus status = super.initializeOperand(profile, operand, parameters, monitor);
    IInstallableUnit iu = operand.second();
    parameters.put(PARM_IU, iu);
    return status;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.engine.phases.CheckTrust.initializeOperand(org.eclipse.equinox.p2.engine.IProfile;org.eclipse.equinox.internal.p2.engine.InstallableUnitOperand;java.util.Map;org.eclipse.core.runtime.IProgressMonitor;)org.eclipse.core.runtime.IStatus;5
protected IStatus initializeOperand(IProfile profile, InstallableUnitOperand operand, Map<String, Object> parameters, IProgressMonitor monitor) {
    IInstallableUnit iu = operand.second();
    parameters.put(PARM_IU, iu);
    return super.initializeOperand(profile, operand, parameters, monitor);
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BinaryType.isMember()Z1
public boolean isMember() throws JavaModelException {
    IBinaryType info = (IBinaryType) getElementInfo();
    return info.isMember();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.BinaryMember.isStructureKnown()Z1
public boolean isStructureKnown() throws JavaModelException {
    return ((IJavaElement) getOpenableParent()).isStructureKnown();
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Text.addVerifyListener(org.eclipse.swt.events.VerifyListener;)V2
public void addVerifyListener(VerifyListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    TypedListener typedListener = new  TypedListener(listener);
    addListener(SWT.Verify, typedListener);
}
---------------Client-------------------
method: org.eclipse.swt.widgets.Combo.addSegmentListener(org.eclipse.swt.events.SegmentListener;)V2
public void addSegmentListener(SegmentListener listener) {
    checkWidget();
    if (listener == null)
        error(SWT.ERROR_NULL_ARGUMENT);
    addListener(SWT.Segments, new  TypedListener(listener));
}

---------------Library-------------------
method: org.eclipse.jdt.core.dom.AbstractTypeDeclaration.isPackageMemberTypeDeclaration()Z1
public boolean isPackageMemberTypeDeclaration() {
    ASTNode parent = getParent();
    return (parent instanceof CompilationUnit);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.TagElement.isNested()Z1
public boolean isNested() {
    return (getParent() instanceof TagElement);
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.engine.ParameterizedProvisioningAction.execute(java.util.Map;)org.eclipse.core.runtime.IStatus;2
public IStatus execute(Map<String, Object> parameters) {
    parameters = processActionParameters(parameters);
    return action.execute(parameters);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.expression.Member$DynamicMember.evaluate(org.eclipse.equinox.p2.metadata.expression.IEvaluationContext;)java.lang.Object;2
public Object evaluate(IEvaluationContext context) {
    return invoke(operand.evaluate(context));
}

---------------Library-------------------
method: org.eclipse.jdt.core.Signature.getTypeParameterBounds(java.lang.String;)Ajava.lang.String;1
public static String[] getTypeParameterBounds(String formalTypeParameterSignature) throws IllegalArgumentException {
    char[][] bounds = getTypeParameterBounds(formalTypeParameterSignature.toCharArray());
    return CharOperation.toStrings(bounds);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.touchpoint.eclipse.WhatIsRunning.getBundlesBeingRun()Aorg.eclipse.equinox.frameworkadmin.BundleInfo;1
public BundleInfo[] getBundlesBeingRun() {
    return getFrameworkManipulator().getConfigData().getBundles();
}

---------------Library-------------------
method: org.eclipse.e4.ui.css.swt.properties.css2.CSSPropertyFontSWTHandler.retrieveCSSProperty(java.lang.Object;java.lang.String;java.lang.String;org.eclipse.e4.ui.css.core.engine.CSSEngine;)java.lang.String;5
@Override
public String retrieveCSSProperty(Object element, String property, String pseudo, CSSEngine engine) throws Exception {
    Widget widget = SWTElementHelpers.getWidget(element);
    if (widget != null) {
        return super.retrieveCSSProperty(widget, property, pseudo, engine);
    }
    return null;
}
---------------Client-------------------
method: org.eclipse.jdt.ui.CodeGeneration.getGetterMethodBodyContent(org.eclipse.jdt.core.ICompilationUnit;java.lang.String;java.lang.String;java.lang.String;java.lang.String;)java.lang.String;5
public static String getGetterMethodBodyContent(ICompilationUnit cu, String declaringTypeName, String methodName, String fieldName, String lineDelimiter) throws CoreException {
    return StubUtility.getGetterMethodBodyContent(cu.getJavaProject(), declaringTypeName, methodName, fieldName, lineDelimiter);
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
method: org.eclipse.jdt.internal.corext.util.JavaElementResourceMapping.equals(java.lang.Object;)Z2
@Override
public boolean equals(Object obj) {
    if (!(obj instanceof JavaElementResourceMapping))
        return false;
    return getJavaElement().equals(((JavaElementResourceMapping) obj).getJavaElement());
}

---------------Library-------------------
method: org.eclipse.equinox.internal.p2.metadata.EnumDefinition.toString()java.lang.String;1
@Override
public String toString() {
    StringBuffer bld = new  StringBuffer();
    toString(bld);
    return bld.toString();
}
---------------Client-------------------
method: org.eclipse.jdt.core.Signature.createArraySignature(java.lang.String;I)java.lang.String;2
public static String createArraySignature(String typeSignature, int arrayCount) {
    return new  String(createArraySignature(typeSignature.toCharArray(), arrayCount));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.codeassist.SelectionEngine.findMethodWithAttachedDocInHierarchy(org.eclipse.jdt.internal.compiler.lookup.MethodBinding;)java.lang.Object;2
private Object findMethodWithAttachedDocInHierarchy(final MethodBinding method) throws JavaModelException {
    ReferenceBinding type = method.declaringClass;
    final SelectionRequestor requestor1 = (SelectionRequestor) this.requestor;
    return new  InheritDocVisitor() {

        public Object visit(ReferenceBinding currType) throws JavaModelException {
            MethodBinding overridden = findOverriddenMethodInType(currType, method);
            if (overridden == null)
                return InheritDocVisitor.CONTINUE;
            TypeBinding args[] = overridden.parameters;
            String names[] = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                names[i] = Signature.createTypeSignature(args[i].sourceName(), false);
            }
            IMember member = (IMember) requestor1.findMethodFromBinding(overridden, names, overridden.declaringClass);
            if (member == null)
                return InheritDocVisitor.CONTINUE;
            if (member.getAttachedJavadoc(null) != null) {
                return overridden;
            }
            IOpenable openable = member.getOpenable();
            if (openable == null)
                return InheritDocVisitor.CONTINUE;
            IBuffer buf = openable.getBuffer();
            if (buf == null) {
                return InheritDocVisitor.STOP_BRANCH;
            }
            ISourceRange javadocRange = member.getJavadocRange();
            if (javadocRange == null)
                return InheritDocVisitor.CONTINUE;
            String rawJavadoc = buf.getText(javadocRange.getOffset(), javadocRange.getLength());
            if (rawJavadoc != null) {
                return overridden;
            }
            return InheritDocVisitor.CONTINUE;
        }
    }.visitInheritDoc(type);
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.ui.query.ArtifactKeyWrapper.wrap(java.lang.Object;)java.lang.Object;2
protected Object wrap(Object item) {
    return super.wrap(new  ArtifactElement(parent, (IArtifactKey) item, repo));
}

---------------Library-------------------
method: org.eclipse.swt.widgets.Table.getSelectionCount()I1
public int getSelectionCount() {
    checkWidget();
    long selection = OS.gtk_tree_view_get_selection(handle);
    return OS.gtk_tree_selection_count_selected_rows(selection);
}
---------------Client-------------------
method: org.eclipse.swt.graphics.TextLayout.getSpacing()I1
public int getSpacing() {
    checkLayout();
    return OS.PANGO_PIXELS(OS.pango_layout_get_spacing(layout));
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.SourceField.getTypeSignature()java.lang.String;1
public String getTypeSignature() throws JavaModelException {
    SourceFieldElementInfo info = (SourceFieldElementInfo) getElementInfo();
    return info.getTypeSignature();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JarPackageFragment.storedNonJavaResources()Ajava.lang.Object;1
protected Object[] storedNonJavaResources() throws JavaModelException {
    return ((JarPackageFragmentInfo) getElementInfo()).getNonJavaResources();
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.util.FactoryPath.removeVarJar(org.eclipse.core.runtime.IPath;)V2
public void removeVarJar(IPath jarPath) {
    FactoryContainer fc = FactoryPathUtil.newVarJarFactoryContainer(jarPath);
    _path.remove(fc);
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.ClassFileWorkingCopy.toStringName(java.lang.StringBuffer;)V2
protected void toStringName(StringBuffer buffer) {
    buffer.append(this.classFile.getElementName());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.util.Resources.isReadOnly(org.eclipse.core.resources.IResource;)Z1
public static boolean isReadOnly(IResource resource) {
    ResourceAttributes resourceAttributes = resource.getResourceAttributes();
    if (resourceAttributes == null)
        return false;
    return resourceAttributes.isReadOnly();
}
---------------Client-------------------
method: org.eclipse.core.internal.registry.BaseExtensionHandle.shouldPersist()Z1
protected boolean shouldPersist() {
    return getExtension().shouldPersist();
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.delegates.DelegateMethodCreator.getDeclarationBinding()org.eclipse.jdt.core.dom.IBinding;1
@Override
protected IBinding getDeclarationBinding() {
    final MethodDeclaration declaration = (MethodDeclaration) getDeclaration();
    return declaration.resolveBinding();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.JarPackageFragment.storedNonJavaResources()Ajava.lang.Object;1
protected Object[] storedNonJavaResources() throws JavaModelException {
    return ((JarPackageFragmentInfo) getElementInfo()).getNonJavaResources();
}

---------------Library-------------------
method: org.eclipse.equinox.internal.security.storage.PasswordProviderSelector$1.compare(java.lang.Object;java.lang.Object;)I3
public int compare(Object o1, Object o2) {
    int p1 = ((ExtStorageModule) o1).priority;
    int p2 = ((ExtStorageModule) o2).priority;
    return p2 - p1;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.core.search.matching.MatchingNodeSet$1.compare(java.lang.Object;java.lang.Object;)I3
public int compare(Object o1, Object o2) {
    return ((ASTNode) o1).sourceStart - ((ASTNode) o2).sourceStart;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.codegen.MultiCatchExceptionLabel.getCount()I1
public int getCount() {
    int temp = 0;
    for (int i = 0, max = this.exceptionLabels.length; i < max; i++) {
        temp += this.exceptionLabels[i].getCount();
    }
    return temp;
}
---------------Client-------------------
method: org.eclipse.core.databinding.observable.list.ListDiff$ConcatList.size()I1
public int size() {
    int size = 0;
    for (int i = 0; i < subLists.length; i++) {
        size += subLists[i].size();
    }
    return size;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.BatchInitializationMonitor.beginTask(java.lang.String;I)V3
public void beginTask(String name, int totalWork) {
    IProgressMonitor monitor = getMonitor();
    if (monitor != null)
        monitor.beginTask(name, totalWork);
}
---------------Client-------------------
method: org.eclipse.osgi.internal.service.security.KeyStoreTrustEngine.loadStore(java.security.KeyStore;java.io.InputStream;)V3
private void loadStore(KeyStore store, InputStream is) throws IOException, GeneralSecurityException {
    store.load(is, getPassword());
}

---------------Library-------------------
method: org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeInputFileObject.getCharContent(Z)java.lang.CharSequence;2
@Override
public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
    try {
        char[] chars = Util.getResourceContentsAsCharArray(this._file);
        return new  String(chars);
    } catch (CoreException e) {
        throw new  IOException(e);
    }
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.PackageBinding.getKey()java.lang.String;1
public String getKey() {
    return new  String(this.binding.computeUniqueKey());
}

---------------Library-------------------
method: o