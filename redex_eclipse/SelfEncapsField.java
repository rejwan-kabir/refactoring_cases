/**
* Create getting and setting methods for the field and use only those to access the field.
*
* Most cases detected indicate opportunities for Self Encapsulate Field refactoring. 
* But it is checking by requiring the query has one more field access and one less 
* method invoke than the target, so it will miss some opportunities and fail to indicate
* the location of the opportunity.
*/
---------------Library-------------------
method: org.eclipse.core.internal.resources.BuildConfiguration.hashCode()I1
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((project == null) ? 0 : project.hashCode());
    return result;
}
---------------Client-------------------
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.hashCode()I1
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
    return result;
}
method: org.eclipse.equinox.internal.p2.metadata.InstallableUnit.getVersion()org.eclipse.equinox.p2.metadata.Version;1
public Version getVersion() {
    return version;
}
// The Client indicates that the access to the field project in Library can be replaced by
// a getter method. But there is another access to the field name in Library, which is not
// indicated by this match.

---------------Library-------------------
method: org.eclipse.jdt.core.dom.Javadoc.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChildren(visitor, this.tags);
    }
    visitor.endVisit(this);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.BreakStatement.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getLabel());
    }
    visitor.endVisit(this);
}
method: org.eclipse.jdt.core.dom.BreakStatement.getLabel()org.eclipse.jdt.core.dom.SimpleName;1
public SimpleName getLabel() {
    return this.optionalLabel;
}
// it's opportunity. the access to this.tags in Library can be replaced by a getter method.
---------------Library-------------------
method: org.eclipse.jdt.core.dom.SuperConstructorInvocation.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getExpression());
        if (this.ast.apiLevel >= AST.JLS3_INTERNAL) {
            acceptChildren(visitor, this.typeArguments);
        }
        acceptChildren(visitor, this.arguments);
    }
    visitor.endVisit(this);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.Initializer.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getJavadoc());
        if (this.ast.apiLevel >= AST.JLS3_INTERNAL) {
            acceptChildren(visitor, this.modifiers);
        }
        acceptChild(visitor, getBody());
    }
    visitor.endVisit(this);
}
method: org.eclipse.jdt.core.dom.BodyDeclaration.getJavadoc()org.eclipse.jdt.core.dom.Javadoc;1
public Javadoc getJavadoc() {
    return this.optionalDocComment;
}
// There are direct access to field in the Library, but the Client doesn't indicate them clearly.
---------------Library-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.localVariableRedundantCheckOnNull(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;org.eclipse.jdt.internal.compiler.ast.ASTNode;)V3
public void localVariableRedundantCheckOnNull(LocalVariableBinding local, ASTNode location) {
    int severity = computeSeverity(IProblem.RedundantNullCheckOnNullLocalVariable);
    if (severity == ProblemSeverities.Ignore)
        return;
    String[] arguments = new String[] { new  String(local.name) };
    this.handle(IProblem.RedundantNullCheckOnNullLocalVariable, arguments, arguments, severity, nodeSourceStart(local, location), nodeSourceEnd(local, location));
}
---------------Client-------------------
method: org.eclipse.jdt.internal.compiler.problem.ProblemReporter.parameterAssignment(org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;org.eclipse.jdt.internal.compiler.ast.ASTNode;)V3
public void parameterAssignment(LocalVariableBinding local, ASTNode location) {
    int severity = computeSeverity(IProblem.ParameterAssignment);
    if (severity == ProblemSeverities.Ignore)
        return;
    String[] arguments = new String[] { new  String(local.readableName()) };
    this.handle(IProblem.ParameterAssignment, arguments, arguments, severity, nodeSourceStart(local, location), nodeSourceEnd(local, location));
}
method: org.eclipse.jdt.internal.compiler.lookup.VariableBinding.readableName()AC1
public char[] readableName() {
    return this.name;
}
// The access to local.name in the query is an access to the filed of another
// object, and in the targe it's replaced by a method. This is Encapsulate Field
// refactoring rather than Self Encapsulate.

---------------Library-------------------
method: org.eclipse.jdt.core.dom.UnionType.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChildren(visitor, this.types);
    }
    visitor.endVisit(this);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.BreakStatement.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getLabel());
    }
    visitor.endVisit(this);
}
method: org.eclipse.jdt.core.dom.BreakStatement.getLabel()org.eclipse.jdt.core.dom.SimpleName;1
public SimpleName getLabel() {
    return this.optionalLabel;
}
// it's opportunity. the access to this.types in Library can be replaced by a getter method.

---------------Library-------------------
method: org.eclipse.jdt.core.dom.TypeParameter.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        if (this.ast.apiLevel >= AST.JLS8) {
            acceptChildren(visitor, this.modifiers);
        }
        acceptChild(visitor, getName());
        acceptChildren(visitor, this.typeBounds);
    }
    visitor.endVisit(this);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.VariableDeclarationFragment.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getName());
        if (this.ast.apiLevel >= AST.JLS8) {
            acceptChildren(visitor, this.extraDimensions);
        }
        acceptChild(visitor, getInitializer());
    }
    visitor.endVisit(this);
}
method: org.eclipse.jdt.core.dom.VariableDeclaration.getInitializer()org.eclipse.jdt.core.dom.Expression;1
public Expression getInitializer() {
    return this.optionalInitializer;
}
// it's opportunity. the access to this.typeBounds in Library can be replaced by a getter method.

---------------Library-------------------
method: org.eclipse.jdt.core.dom.AnonymousClassDeclaration.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChildren(visitor, this.bodyDeclarations);
    }
    visitor.endVisit(this);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.BreakStatement.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getLabel());
    }
    visitor.endVisit(this);
}
method: org.eclipse.jdt.core.dom.BreakStatement.getLabel()org.eclipse.jdt.core.dom.SimpleName;1
public SimpleName getLabel() {
    return this.optionalLabel;
}
// it's opportunity. the access to this.bodyDeclarations in Library
// can be replaced by a getter method.

---------------Library-------------------
method: org.eclipse.jdt.core.dom.LambdaExpression.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChildren(visitor, this.parameters);
        acceptChild(visitor, getBody());
    }
    visitor.endVisit(this);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.AssertStatement.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getExpression());
        acceptChild(visitor, getMessage());
    }
    visitor.endVisit(this);
}
method: org.eclipse.jdt.core.dom.AssertStatement.getMessage()org.eclipse.jdt.core.dom.Expression;1
public Expression getMessage() {
    return this.optionalMessageExpression;
}
// it's opportunity. the access to this.bodyDeclarations in Library
// can be replaced by a getter method.

---------------Library-------------------
method: org.eclipse.jdt.core.dom.SuperMethodReference.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getQualifier());
        acceptChildren(visitor, this.typeArguments);
        acceptChild(visitor, getName());
    }
    visitor.endVisit(this);
}
---------------Client-------------------
method: org.eclipse.jdt.core.dom.IfStatement.accept0(org.eclipse.jdt.core.dom.ASTVisitor;)V2
void accept0(ASTVisitor visitor) {
    boolean visitChildren = visitor.visit(this);
    if (visitChildren) {
        acceptChild(visitor, getExpression());
        acceptChild(visitor, getThenStatement());
        acceptChild(visitor, getElseStatement());
    }
    visitor.endVisit(this);
}
method: org.eclipse.jdt.core.dom.IfStatement.getElseStatement()org.eclipse.jdt.core.dom.Statement;1
public Statement getElseStatement() {
    return this.optionalElseStatement;
}
// it's opportunity. the access to this.typeArguments in Library
// can be replaced by a getter method.

