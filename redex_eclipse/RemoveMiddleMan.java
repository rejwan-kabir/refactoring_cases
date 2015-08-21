/**
* A class is doing too much simple delegation. Get the client to call the delegate directly.
*
* 
*/
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
method: org.eclipse.team.internal.ccvs.core.client.listeners.LogEntry.getRemoteFile()org.eclipse.team.internal.ccvs.core.ICVSRemoteFile;1
public ICVSRemoteFile getRemoteFile() {
    return file;
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
method: org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field.getFieldName()java.lang.String;1
public String getFieldName() {
    return fFieldName;
}
method: org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor.getFields()Aorg.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field;1
public Field[] getFields() {
    return fFields;
}
// false positive. To perform this refactoring, the query should only inline one method, 
// and the callee should call a method of another object.
---------------Library-------------------
method: org.eclipse.jdt.internal.core.ExternalFolderChange.toString()java.lang.String;1
public String toString() {
    return "ExternalFolderChange: " + this.project.getElementName();
}
method: org.eclipse.jdt.internal.core.JavaProject.getElementName()java.lang.String;1
public String getElementName() {
    return this.project.getName();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.SuperTypeHierarchyCache$HierarchyCacheEntry.toString()java.lang.String;1
@Override
public String toString() {
    return "Super hierarchy of: " + fTypeHierarchy.getType().getElementName();
}
method: org.eclipse.jdt.internal.core.NamedMember.getElementName()java.lang.String;1
public String getElementName() {
    return this.name;
}
method: org.eclipse.jdt.internal.core.hierarchy.TypeHierarchy.getType()org.eclipse.jdt.core.IType;1
public IType getType() {
    return this.focusType;
}
// false positive. the callee should call a method of another object.

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.NewAnnotationCreationWizard.canRunForked()Z1
@Override
protected boolean canRunForked() {
    return !fPage.isEnclosingTypeSelected();    //fPage.getEnclosingTypeSelection().isSelected();
}
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.isEnclosingTypeSelected()Z1
public boolean isEnclosingTypeSelected() {
    return fEnclosingTypeSelection.isSelected();
}


---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.IgnoreLeadingPathSegmentsAction.isEnabled()Z1
public boolean isEnabled() {
    return !subscriber.getPatcher().isWorkspacePatch();
}
method: org.eclipse.compare.internal.patch.WorkspacePatcher.isWorkspacePatch()Z1
public boolean isWorkspacePatch() {
    return fIsWorkspacePatch;
}
method: org.eclipse.team.internal.ui.synchronize.patch.ApplyPatchSubscriber.getPatcher()org.eclipse.compare.internal.patch.WorkspacePatcher;1
public WorkspacePatcher getPatcher() {
    return patcher;
}
// it's opportunity. Instead of calling the fEnclosingTypeSelection.isSelected() method inside 
// fPage.isEnclosingTypeSelected(), we can have fPage to return the object fEnclosingTypeSelection
// and calls the isSelected() method on it in canRunForked(). Then the method
// isEnclosingTypeSelected() can be removed.
---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.NewClassCreationWizard.canRunForked()Z1
@Override
protected boolean canRunForked() {
    return !fPage.isEnclosingTypeSelected();
}
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.isEnclosingTypeSelected()Z1
public boolean isEnclosingTypeSelected() {
    return fEnclosingTypeSelection.isSelected();
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.IgnoreLeadingPathSegmentsAction.isEnabled()Z1
public boolean isEnabled() {
    return !subscriber.getPatcher().isWorkspacePatch();
}
method: org.eclipse.compare.internal.patch.WorkspacePatcher.isWorkspacePatch()Z1
public boolean isWorkspacePatch() {
    return fIsWorkspacePatch;
}
method: org.eclipse.team.internal.ui.synchronize.patch.ApplyPatchSubscriber.getPatcher()org.eclipse.compare.internal.patch.WorkspacePatcher;1
public WorkspacePatcher getPatcher() {
    return patcher;
}
// it's opportunity.  
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
method: org.eclipse.team.internal.ccvs.core.client.listeners.LogEntry.getRemoteFile()org.eclipse.team.internal.ccvs.core.ICVSRemoteFile;1
public ICVSRemoteFile getRemoteFile() {
    return file;
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
method: org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field.getFieldName()java.lang.String;1
public String getFieldName() {
    return fFieldName;
}
method: org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor.getFields()Aorg.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field;1
public Field[] getFields() {
    return fFields;
}
// false positive.
---------------Library-------------------
method: org.eclipse.jface.layout.RowLayoutFactory.copy()org.eclipse.jface.layout.RowLayoutFactory;1
public RowLayoutFactory copy() {
    return new  RowLayoutFactory(create());
}
method: org.eclipse.jface.layout.RowLayoutFactory.create()org.eclipse.swt.layout.RowLayout;1
public RowLayout create() {
    return copyLayout(layout);
}
---------------Client-------------------
method: org.eclipse.compare.internal.merge.DocumentMerger.toRegion(org.eclipse.jface.text.Position;)org.eclipse.jface.text.IRegion;1
private static IRegion toRegion(Position position) {
    if (position != null)
        return new  Region(position.getOffset(), position.getLength());
    return null;
}
method: org.eclipse.jface.text.Position.getLength()I1
public int getLength() {
    return length;
}
method: org.eclipse.jface.text.Position.getOffset()I1
public int getOffset() {
    return offset;
}
// false positive.
---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.SuperTypesOfSingleton.upperBound()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet;1
@Override
public TypeSet upperBound() {
    return new  SingletonTypeSet(getJavaLangObject(), getTypeSetEnvironment());
}
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet.getJavaLangObject()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.types.TType;1
protected TType getJavaLangObject() {
    return fTypeSetEnvironment.getJavaLangObject();
}
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet.getTypeSetEnvironment()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetEnvironment;1
protected TypeSetEnvironment getTypeSetEnvironment() {
    return fTypeSetEnvironment;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.fix.LinkedProposalPositionGroup$Proposal.computeEdits(ILorg.eclipse.jface.text.link.LinkedPosition;CILorg.eclipse.jface.text.link.LinkedModeModel;)org.eclipse.text.edits.TextEdit;6
public TextEdit computeEdits(int offset, LinkedPosition position, char trigger, int stateMask, LinkedModeModel model) throws CoreException {
    return new  ReplaceEdit(position.getOffset(), position.getLength(), fDisplayString);
}
method: org.eclipse.jface.text.Position.getLength()I1
public int getLength() {
    return length;
}
method: org.eclipse.jface.text.Position.getOffset()I1
public int getOffset() {
    return offset;
}
// false positive.
---------------Library-------------------
method: org.eclipse.jface.layout.GridDataFactory.copy()org.eclipse.jface.layout.GridDataFactory;1
public GridDataFactory copy() {
    return new  GridDataFactory(create());
}
method: org.eclipse.jface.layout.GridDataFactory.create()org.eclipse.swt.layout.GridData;1
public GridData create() {
    return copyData(data);
}
---------------Client-------------------
method: org.eclipse.compare.internal.merge.DocumentMerger.toRegion(org.eclipse.jface.text.Position;)org.eclipse.jface.text.IRegion;1
private static IRegion toRegion(Position position) {
    if (position != null)
        return new  Region(position.getOffset(), position.getLength());
    return null;
}
method: org.eclipse.jface.text.Position.getLength()I1
public int getLength() {
    return length;
}
method: org.eclipse.jface.text.Position.getOffset()I1
public int getOffset() {
    return offset;
}
// false positive.
---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.NewInterfaceCreationWizard.canRunForked()Z1
@Override
protected boolean canRunForked() {
    return !fPage.isEnclosingTypeSelected();
}
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.isEnclosingTypeSelected()Z1
public boolean isEnclosingTypeSelected() {
    return fEnclosingTypeSelection.isSelected();
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.IgnoreLeadingPathSegmentsAction.isEnabled()Z1
public boolean isEnabled() {
    return !subscriber.getPatcher().isWorkspacePatch();
}
method: org.eclipse.compare.internal.patch.WorkspacePatcher.isWorkspacePatch()Z1
public boolean isWorkspacePatch() {
    return fIsWorkspacePatch;
}
method: org.eclipse.team.internal.ui.synchronize.patch.ApplyPatchSubscriber.getPatcher()org.eclipse.compare.internal.patch.WorkspacePatcher;1
public WorkspacePatcher getPatcher() {
    return patcher;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.codemanipulation.StubUtility.findVariable(org.eclipse.jface.text.templates.TemplateBuffer;java.lang.String;)org.eclipse.jface.text.templates.TemplateVariable;2
private static TemplateVariable findVariable(TemplateBuffer buffer, String variable) {
    TemplateVariable[] positions = buffer.getVariables();
    for (int i = 0; i < positions.length; i++) {
        TemplateVariable curr = positions[i];
        if (variable.equals(curr.getType())) {
            return curr;
        }
    }
    return null;
}
method: org.eclipse.jface.text.templates.TemplateBuffer.getVariables()Aorg.eclipse.jface.text.templates.TemplateVariable;1
public final TemplateVariable[] getVariables() {
    return fVariables;
}
method: org.eclipse.jface.text.templates.TemplateVariable.getType()java.lang.String;1
public String getType() {
    return fType.getName();
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
method: org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field.getFieldName()java.lang.String;1
public String getFieldName() {
    return fFieldName;
}
method: org.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor.getFields()Aorg.eclipse.jdt.core.refactoring.descriptors.ExtractClassDescriptor$Field;1
public Field[] getFields() {
    return fFields;
}
// false positive
---------------Library-------------------
method: org.eclipse.jdt.internal.core.ClasspathChange.toString()java.lang.String;1
public String toString() {
    return "ClasspathChange: " + this.project.getElementName();
}
method: org.eclipse.jdt.internal.core.JavaProject.getElementName()java.lang.String;1
public String getElementName() {
    return this.project.getName();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.SuperTypeHierarchyCache$HierarchyCacheEntry.toString()java.lang.String;1
@Override
public String toString() {
    return "Super hierarchy of: " + fTypeHierarchy.getType().getElementName();
}
method: org.eclipse.jdt.internal.core.NamedMember.getElementName()java.lang.String;1
public String getElementName() {
    return this.name;
}
method: org.eclipse.jdt.internal.core.hierarchy.TypeHierarchy.getType()org.eclipse.jdt.core.IType;1
public IType getType() {
    return this.focusType;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.ArraySuperTypeSet.upperBound()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet;1
@Override
public TypeSet upperBound() {
    return new  SingletonTypeSet(getJavaLangObject(), getTypeSetEnvironment());
}
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet.getJavaLangObject()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.types.TType;1
protected TType getJavaLangObject() {
    return fTypeSetEnvironment.getJavaLangObject();
}
method: org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSet.getTypeSetEnvironment()org.eclipse.jdt.internal.corext.refactoring.typeconstraints.typesets.TypeSetEnvironment;1
protected TypeSetEnvironment getTypeSetEnvironment() {
    return fTypeSetEnvironment;
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.fix.LinkedProposalPositionGroup$Proposal.computeEdits(ILorg.eclipse.jface.text.link.LinkedPosition;CILorg.eclipse.jface.text.link.LinkedModeModel;)org.eclipse.text.edits.TextEdit;6
public TextEdit computeEdits(int offset, LinkedPosition position, char trigger, int stateMask, LinkedModeModel model) throws CoreException {
    return new  ReplaceEdit(position.getOffset(), position.getLength(), fDisplayString);
}
method: org.eclipse.jface.text.Position.getLength()I1
public int getLength() {
    return length;
}
method: org.eclipse.jface.text.Position.getOffset()I1
public int getOffset() {
    return offset;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.ui.wizards.NewEnumCreationWizard.canRunForked()Z1
@Override
protected boolean canRunForked() {
    return !fPage.isEnclosingTypeSelected();
}
method: org.eclipse.jdt.ui.wizards.NewTypeWizardPage.isEnclosingTypeSelected()Z1
public boolean isEnclosingTypeSelected() {
    return fEnclosingTypeSelection.isSelected();
}
---------------Client-------------------
method: org.eclipse.team.internal.ui.mapping.IgnoreLeadingPathSegmentsAction.isEnabled()Z1
public boolean isEnabled() {
    return !subscriber.getPatcher().isWorkspacePatch();
}
method: org.eclipse.compare.internal.patch.WorkspacePatcher.isWorkspacePatch()Z1
public boolean isWorkspacePatch() {
    return fIsWorkspacePatch;
}
method: org.eclipse.team.internal.ui.synchronize.patch.ApplyPatchSubscriber.getPatcher()org.eclipse.compare.internal.patch.WorkspacePatcher;1
public WorkspacePatcher getPatcher() {
    return patcher;
}

---------------Library-------------------
method: org.eclipse.jdt.apt.core.internal.env.APTProblem.getOriginatingFileName()AC1
public char[] getOriginatingFileName() {
    return _resource.getName().toCharArray();
}
method: org.eclipse.core.internal.resources.Resource.getName()java.lang.String;1
public String getName() {
    return path.lastSegment();
}
---------------Client-------------------
method: org.eclipse.compare.internal.MergeSourceViewer$TextEditorAdapter$1.getDocument(java.lang.Object;)org.eclipse.jface.text.IDocument;2
public IDocument getDocument(Object element) {
    return MergeSourceViewer.this.getSourceViewer().getDocument();
}
method: org.eclipse.compare.internal.MergeSourceViewer.getSourceViewer()org.eclipse.jface.text.source.SourceViewer;1
public SourceViewer getSourceViewer() {
    return fSourceViewer;
}
method: org.eclipse.jface.text.TextViewer.getDocument()org.eclipse.jface.text.IDocument;1
public IDocument getDocument() {
    return fDocument;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.targetdefinition.ContentPage.getTarget()org.eclipse.pde.core.target.ITargetDefinition;1
public ITargetDefinition getTarget() {
    return ((TargetEditor) getEditor()).getTarget();
}
method: org.eclipse.pde.internal.ui.editor.targetdefinition.TargetEditor.getTarget()org.eclipse.pde.core.target.ITargetDefinition;1
public ITargetDefinition getTarget() {
    return fInputHandler.getTarget();
}
method: org.eclipse.ui.forms.editor.FormPage.getEditor()org.eclipse.ui.forms.editor.FormEditor;1
public FormEditor getEditor() {
    return editor;
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.ProjectPathVariableManager.getWorkspaceManager()org.eclipse.core.internal.resources.PathVariableManager;1
PathVariableManager getWorkspaceManager() {
    return (PathVariableManager) resource.getWorkspace().getPathVariableManager();
}
method: org.eclipse.core.internal.resources.Resource.getWorkspace()org.eclipse.core.resources.IWorkspace;1
public IWorkspace getWorkspace() {
    return workspace;
}
method: org.eclipse.core.internal.resources.Workspace.getPathVariableManager()org.eclipse.core.resources.IPathVariableManager;1
public IPathVariableManager getPathVariableManager() {
    return pathVariableManager;
}

---------------Library-------------------
method: org.eclipse.jdt.internal.core.ProjectReferenceChange.toString()java.lang.String;1
public String toString() {
    return "ProjectRefenceChange: " + this.project.getElementName();
}
method: org.eclipse.jdt.internal.core.JavaProject.getElementName()java.lang.String;1
public String getElementName() {
    return this.project.getName();
}
---------------Client-------------------
method: org.eclipse.jdt.internal.corext.util.SuperTypeHierarchyCache$HierarchyCacheEntry.toString()java.lang.String;1
@Override
public String toString() {
    return "Super hierarchy of: " + fTypeHierarchy.getType().getElementName();
}
method: org.eclipse.jdt.internal.core.NamedMember.getElementName()java.lang.String;1
public String getElementName() {
    return this.name;
}
method: org.eclipse.jdt.internal.core.hierarchy.TypeHierarchy.getType()org.eclipse.jdt.core.IType;1
public IType getType() {
    return this.focusType;
}

---------------Library-------------------
method: org.eclipse.pde.internal.ui.editor.targetdefinition.DefinitionPage.getTarget()org.eclipse.pde.core.target.ITargetDefinition;1
public ITargetDefinition getTarget() {
    return ((TargetEditor) getEditor()).getTarget();
}
method: org.eclipse.pde.internal.ui.editor.targetdefinition.TargetEditor.getTarget()org.eclipse.pde.core.target.ITargetDefinition;1
public ITargetDefinition getTarget() {
    return fInputHandler.getTarget();
}
method: org.eclipse.ui.forms.editor.FormPage.getEditor()org.eclipse.ui.forms.editor.FormEditor;1
public FormEditor getEditor() {
    return editor;
}
---------------Client-------------------
method: org.eclipse.core.internal.resources.ProjectPathVariableManager.getWorkspaceManager()org.eclipse.core.internal.resources.PathVariableManager;1
PathVariableManager getWorkspaceManager() {
    return (PathVariableManager) resource.getWorkspace().getPathVariableManager();
}
method: org.eclipse.core.internal.resources.Resource.getWorkspace()org.eclipse.core.resources.IWorkspace;1
public IWorkspace getWorkspace() {
    return workspace;
}
method: org.eclipse.core.internal.resources.Workspace.getPathVariableManager()org.eclipse.core.resources.IPathVariableManager;1
public IPathVariableManager getPathVariableManager() {
    return pathVariableManager;
}

