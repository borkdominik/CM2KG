/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.modelimporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

import com.archimatetool.canvas.model.ICanvasModel;
import com.archimatetool.canvas.model.ICanvasPackage;
import com.archimatetool.editor.diagram.commands.ConnectionRouterTypeCommand;
import com.archimatetool.editor.model.IArchiveManager;
import com.archimatetool.editor.model.commands.EObjectFeatureCommand;
import com.archimatetool.model.IArchimateConcept;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.IArchimateRelationship;
import com.archimatetool.model.IConnectable;
import com.archimatetool.model.IDiagramModel;
import com.archimatetool.model.IDiagramModelArchimateComponent;
import com.archimatetool.model.IDiagramModelArchimateConnection;
import com.archimatetool.model.IDiagramModelArchimateObject;
import com.archimatetool.model.IDiagramModelConnection;
import com.archimatetool.model.IDiagramModelContainer;
import com.archimatetool.model.IDiagramModelImageProvider;
import com.archimatetool.model.IDiagramModelObject;
import com.archimatetool.model.ISketchModel;
import com.archimatetool.modelimporter.StatusMessage.StatusMessageLevel;

/**
 * View Importer
 * 
 * @author Phillip Beauvoir
 */
class ViewImporter extends AbstractImporter {
    
    private IDiagramModel importedView;
    private IDiagramModel targetView;
    
    ViewImporter(ModelImporter importer) {
        super(importer);
    }

    IDiagramModel importView(IDiagramModel importedView) throws ImportException, IOException {
        this.importedView = importedView;
        
        // Do we have this View given its ID?
        targetView = findObjectInTargetModel(importedView);
        
        // We don't have it, so create a new view
        if(targetView == null) {
            targetView = cloneObject(importedView);
            createChildren();
            addToParentFolder(importedView, targetView);
            logMessage(StatusMessageLevel.INFO, Messages.ViewImporter_0, targetView);
        }
        // We have it so update it
        else if(shouldUpdate()) {
            updateView();
            createChildren();
            addToParentFolder(importedView, targetView);
            logMessage(StatusMessageLevel.INFO, Messages.ViewImporter_1, targetView);
        }
        else {
            logMessage(StatusMessageLevel.INFO, Messages.ViewImporter_3, targetView);
        }
        
        return targetView;
    }
    
    private void updateView() {
        updateObject(importedView, targetView);
        
        // Connection Router
        addCommand(new ConnectionRouterTypeCommand(targetView, importedView.getConnectionRouterType()));
        
        // Sketch View
        if(targetView instanceof ISketchModel) {
            // Background
            addCommand(new EObjectFeatureCommand(null, targetView, IArchimatePackage.Literals.SKETCH_MODEL__BACKGROUND,
                    ((ISketchModel)importedView).getBackground()));
        }
        
        // Canvas View
        if(targetView instanceof ICanvasModel) {
            // Hint title
            addCommand(new EObjectFeatureCommand(null, targetView, ICanvasPackage.Literals.HINT_PROVIDER__HINT_TITLE,
                    ((ICanvasModel)importedView).getHintTitle()));
            
            // Hint content
            addCommand(new EObjectFeatureCommand(null, targetView, ICanvasPackage.Literals.HINT_PROVIDER__HINT_CONTENT,
                    ((ICanvasModel)importedView).getHintContent()));
        }
    }
    
    /**
     * Create and sdd new child diagram objects and connections
     */
    private void createChildren() throws ImportException, IOException {
        // Create all child objects now
        List<IDiagramModelObject> newChildren = createChildObjects(importedView.getChildren(), new ArrayList<>());
        
        // Add these to a Command so they can be undone
        addCommand(new SetViewChildrenCommand(targetView, newChildren));
        
        // Create connections.
        createConnections();
    }
    
    private List<IDiagramModelObject> createChildObjects(List<IDiagramModelObject> importedChildren, List<IDiagramModelObject> targetChildren) throws ImportException, IOException {
        for(IDiagramModelObject importedObject : importedChildren) {
            IDiagramModelObject targetObject = cloneObject(importedObject);
            targetChildren.add(targetObject);
            
            // Archimate object so set Archimate concept
            if(targetObject instanceof IDiagramModelArchimateObject) {
                setArchimateConcept((IDiagramModelArchimateObject)importedObject, (IDiagramModelArchimateObject)targetObject);
            }
            
            // Image
            if(importedObject instanceof IDiagramModelImageProvider) {
                importImageBytes((IDiagramModelImageProvider)importedObject, (IDiagramModelImageProvider)targetObject);
            }
            
            // Recurse child objects
            if(importedObject instanceof IDiagramModelContainer) {
                createChildObjects(((IDiagramModelContainer)importedObject).getChildren(), ((IDiagramModelContainer)targetObject).getChildren());
            }
        }
        
        return targetChildren;
    }

    /**
     * Create and add new diagram connections
     * Do this in two passes in case there are connection -> connections
     */
    private void createConnections() throws ImportException {
        Hashtable<IDiagramModelConnection, IDiagramModelConnection> connections = new Hashtable<>();
        
        // Create new connections. They will be cached in ModelImporter
        for(Iterator<EObject> iter = importedView.eAllContents(); iter.hasNext();) {
            EObject importedObject = iter.next();
            if(importedObject instanceof IDiagramModelConnection) {
                connections.put((IDiagramModelConnection)importedObject, cloneObject((IDiagramModelConnection)importedObject));
            }
        }
        
        // Now connect the source and target ends
        for(Entry<IDiagramModelConnection, IDiagramModelConnection> entry : connections.entrySet()) {
            IDiagramModelConnection importedConnection = entry.getKey();
            IDiagramModelConnection targetConnection = entry.getValue();
            
            IConnectable targetSource = findObjectInTargetModel(importedConnection.getSource());
            if(targetSource == null) {
                throw new ImportException("Could not find source component: " + importedConnection.getSource().getId()); //$NON-NLS-1$
            }
            
            IConnectable targetTarget = findObjectInTargetModel(importedConnection.getTarget());
            if(targetTarget == null) {
                throw new ImportException("Could not find target component: " + importedConnection.getTarget().getId()); //$NON-NLS-1$
            }
            
            // It's an Archimate connection
            if(targetConnection instanceof IDiagramModelArchimateConnection) {
                // Set the connections's relationship first before connecting source and target otherwise we end up with duplicate relationships
                setArchimateConcept((IDiagramModelArchimateConnection)importedConnection, (IDiagramModelArchimateConnection)targetConnection);
                // Need a Command for this
                addCommand(new ArchimateConnectionCommand((IDiagramModelArchimateConnection)targetConnection, targetSource, targetTarget));
            }
            // Other connection
            else {
                targetConnection.connect(targetSource, targetTarget);
            }
        }
    }
    
    /**
     * Set the Archimate concept in the IDiagramModelArchimateComponent
     */
    private void setArchimateConcept(IDiagramModelArchimateComponent importedComponent, IDiagramModelArchimateComponent targetComponent) throws ImportException {
        // Set ArchiMate Concept
        IArchimateConcept targetConcept = findObjectInTargetModel(importedComponent.getArchimateConcept());
        
        if(targetConcept == null) {
            throw new ImportException("Could not find concept in target: " + importedComponent.getId()); //$NON-NLS-1$
        }
        
        targetComponent.setArchimateConcept(targetConcept);
    }
    
    /**
     * Import an image bytes from imported model to target model
     */
    private void importImageBytes(IDiagramModelImageProvider importedObject, IDiagramModelImageProvider targetObject) throws IOException {
        String importedImagePath = importedObject.getImagePath();
        if(importedImagePath != null) {
            IArchiveManager importedArchiveManager = (IArchiveManager)getImportedModel().getAdapter(IArchiveManager.class);
            IArchiveManager targetArchiveManager = (IArchiveManager)getTargetModel().getAdapter(IArchiveManager.class);
            importedImagePath = targetArchiveManager.copyImageBytes(importedArchiveManager, importedImagePath);
            targetObject.setImagePath(importedImagePath);
        }
    }
    
    // ====================================================================================================
    // Commands
    // ====================================================================================================

    private static class SetViewChildrenCommand extends Command {
        private IDiagramModel view;
        private List<IDiagramModelObject> oldChildren;
        private List<IDiagramModelObject> newChildren;
        
        private SetViewChildrenCommand(IDiagramModel view, List<IDiagramModelObject> newChildren) {
            this.view = view;
            this.newChildren = newChildren;
            oldChildren = new ArrayList<>(view.getChildren());
        }
        
        @Override
        public void execute() {
            view.getChildren().clear();
            view.getChildren().addAll(newChildren);
        }
        
        @Override
        public void undo() {
            view.getChildren().clear();
            view.getChildren().addAll(oldChildren);
        }
        
        @Override
        public void dispose() {
            view = null;
            oldChildren = null;
            newChildren = null;
        }
    }
    
    /**
     * If, when importing, "update" is off then any relationship source/target ends will not be updated.
     * However, if a new View is added, when a connection is made it calls DiagramModelArchimateConnection#connect() which calls DiagramModelArchimateConnection#reconnect()
     * This will then re-assign the source/target of the connection's relationship if it has changed.
     * So we need to hook into this for an undo/redo action to reset the relationship ends
     */
    private class ArchimateConnectionCommand extends Command {
        private IDiagramModelArchimateConnection connection;
        private IConnectable connectionSource, connectionTarget;
        private IArchimateRelationship relationship;
        private IArchimateConcept oldSource, oldTarget;
        private IArchimateConcept newSource, newTarget;
        
        private ArchimateConnectionCommand(IDiagramModelArchimateConnection connection, IConnectable connectionSource, IConnectable connectionTarget) {
            this.connection = connection;
            this.connectionSource = connectionSource;
            this.connectionTarget = connectionTarget;
            relationship = connection.getArchimateRelationship();
        }
        
        @Override
        public void execute() {
            oldSource = relationship.getSource();
            oldTarget = relationship.getTarget();
            
            connection.connect(connectionSource, connectionTarget);
            
            newSource = relationship.getSource();
            newTarget = relationship.getTarget();
            
            if(oldSource != newSource || oldTarget != newTarget) {
                logMessage(StatusMessageLevel.WARNING, Messages.ViewImporter_2, relationship, newSource, newTarget);
            }
        }
        
        @Override
        public void undo() {
            if(oldSource != newSource) {
                relationship.setSource(oldSource);
            }
            if(oldTarget != newTarget) {
                relationship.setTarget(oldTarget);
            }
        }

        @Override
        public void redo() {
            if(oldSource != newSource) {
                relationship.setSource(newSource);
            }
            if(oldTarget != newTarget) {
                relationship.setTarget(newTarget);
            }
        }
        
        @Override
        public void dispose() {
            connection = null;
            connectionSource = null;
            connectionTarget = null;
            relationship = null;
            oldSource = null;
            oldTarget = null;
            newSource = null;
            newTarget = null;
        }
    }
}
