/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.archimatetool.model.IDiagramModelContainer;
import com.archimatetool.model.IDiagramModelObject;
import com.archimatetool.model.ILockable;



/**
 * Bring To Front Action
 * 
 * @author Phillip Beauvoir
 */
public class BringToFrontAction extends SelectionAction {
    
    public static final String ID = "BringToFrontAction"; //$NON-NLS-1$
    public static final String TEXT = Messages.BringToFrontAction_0;
    
    public BringToFrontAction(IWorkbenchPart part) {
        super(part);
        setText(TEXT);
        setId(ID);
    }

    @Override
    protected boolean calculateEnabled() {
        List<?> selected = getSelectedObjects();
        
        // Quick checks
        if(selected.isEmpty()) {
            return false;
        }
        
        for(Object object : selected) {
            if(!(object instanceof EditPart)) {
                return false;
            }
        }

        Command command = createCommand(selected);
        if(command == null) {
            return false;
        }
        return command.canExecute();
    }

    @Override
    public void run() {
        execute(createCommand(getSelectedObjects()));
    }
    
    private Command createCommand(List<?> selection) {
        CompoundCommand result = new CompoundCommand(Messages.BringToFrontAction_0);
        
        for(Object object : selection) {
            if(object instanceof EditPart) {
                Object model = ((EditPart)object).getModel();
                
                if(model instanceof ILockable && ((ILockable)model).isLocked()) {
                    continue;
                }

                if(model instanceof IDiagramModelObject) {
                    result.add(new BringToFrontCommand((IDiagramModelObject)model));
                }
            }
        }

        return result.unwrap();
    }

    private static class BringToFrontCommand extends Command {
        private IDiagramModelContainer fParent;
        private IDiagramModelObject fDiagramObject;
        private int fNewPos, fOldPos = -1;
        
        /*
         * Parent can be null when objects are selected (with marquee tool) and transferred from one container
         * to another and the Diagram Editor updates the enablement state of Actions.
         */

        public BringToFrontCommand(IDiagramModelObject diagramObject) {
            fDiagramObject = diagramObject;
            fParent = (IDiagramModelContainer)fDiagramObject.eContainer();
            if(fParent != null) {
                fNewPos = fParent.getChildren().size() - 1;
                fOldPos = fParent.getChildren().indexOf(fDiagramObject);
            }
            setLabel(Messages.BringToFrontAction_0);
        }

        @Override
        public boolean canExecute() {
            return fParent != null && fOldPos < fNewPos;
        }
        
        @Override
        public void execute() {
            fParent.getChildren().move(fNewPos, fOldPos);
        }
        
        @Override
        public void undo() {
            fParent.getChildren().move(fOldPos, fNewPos);
        }
        
        @Override
        public void dispose() {
            fParent = null;
            fDiagramObject = null;
        }
    }
}
