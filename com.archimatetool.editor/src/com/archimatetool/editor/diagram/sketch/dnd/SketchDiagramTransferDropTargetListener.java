/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.sketch.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.swt.dnd.DND;

import com.archimatetool.editor.diagram.dnd.AbstractDiagramTransferDropTargetListener;
import com.archimatetool.model.IDiagramModel;


/**
 * Native DnD listener for Sketch View
 * 
 * @author Phillip Beauvoir
 */
public class SketchDiagramTransferDropTargetListener extends AbstractDiagramTransferDropTargetListener {

    public SketchDiagramTransferDropTargetListener(EditPartViewer viewer) {
        super(viewer);
    }
    
    @Override
    protected void updateTargetRequest() {
        super.updateTargetRequest();
        getCurrentEvent().detail = DND.DROP_LINK; // Show link cursor
    }

    @Override
    protected boolean isEnabled(Object element) {
        // Only allow (other) Diagram Model References
        return (element instanceof IDiagramModel) && (element != getTargetDiagramModel());
    }
}
