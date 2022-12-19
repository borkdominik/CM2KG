/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.propertysections;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;

import com.archimatetool.editor.model.IArchiveManager;
import com.archimatetool.editor.model.commands.EObjectFeatureCommand;
import com.archimatetool.model.IAdapter;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.IDiagramModelImage;
import com.archimatetool.model.IDiagramModelImageProvider;



/**
 * Property Section for a Diagram Model Image
 * 
 * @author Phillip Beauvoir
 */
public class DiagramModelImageSection extends AbstractDocumentationSection {
    
    protected static final String HELP_ID = "com.archimatetool.help.elementPropertySection"; //$NON-NLS-1$

    /**
     * Filter to show or reject this section depending on input value
     */
    public static class Filter extends ObjectFilter {
        @Override
        public boolean isRequiredType(Object object) {
            return object instanceof IDiagramModelImage;
        }

        @Override
        public Class<?> getAdaptableType() {
            return IDiagramModelImage.class;
        }
    }

    protected Button fImageButton;
    
    @Override
    protected void createControls(Composite parent) {
        createImageButton(parent);
        
        super.createControls(parent);
        
        // Help
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, HELP_ID);
    }
    
    @Override
    protected IObjectFilter getFilter() {
        return new Filter();
    }

    /**
     * Create Image button
     * @param parent
     */
    protected void createImageButton(Composite parent) {
        createLabel(parent, Messages.DiagramModelImageSection_0, ITabbedLayoutConstants.STANDARD_LABEL_WIDTH, SWT.CENTER);
        
        fImageButton = new Button(parent, SWT.PUSH);
        fImageButton.setText(" " + Messages.DiagramModelImageSection_1); //$NON-NLS-1$
        getWidgetFactory().adapt(fImageButton, true, true); // Need to do it this way for Mac
        GridData gd = new GridData(SWT.NONE, SWT.NONE, true, false);
        gd.minimumWidth = ITabbedLayoutConstants.COMBO_WIDTH;
        fImageButton.setLayoutData(gd);
        fImageButton.setAlignment(SWT.LEFT);
        fImageButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                MenuManager menuManager = new MenuManager();
                
                IAction actionChoose = new Action(Messages.DiagramModelImageSection_2) {
                    @Override
                    public void run() {
                        chooseImage();
                    }
                };
                menuManager.add(actionChoose);
                
                IAction actionClear = new Action(Messages.DiagramModelImageSection_3) {
                    @Override
                    public void run() {
                        doImagePathCommand(null);
                    }
                };
                actionClear.setEnabled(((IDiagramModelImageProvider)getFirstSelectedObject()).getImagePath() != null);
                menuManager.add(actionClear);
                
                Menu menu = menuManager.createContextMenu(fImageButton.getShell());
                Point p = fImageButton.getParent().toDisplay(fImageButton.getBounds().x, fImageButton.getBounds().y + fImageButton.getBounds().height);
                menu.setLocation(p);
                menu.setVisible(true);
            }
        });
    }
    
    @Override
    protected void notifyChanged(Notification msg) {
        super.notifyChanged(msg);
        
        if(msg.getNotifier() == getFirstSelectedObject()) {
            Object feature = msg.getFeature();
            if(feature == IArchimatePackage.Literals.LOCKABLE__LOCKED) {
                refreshButtons();
            }
        }
    }
    
    @Override
    protected void update() {
        super.update();
        refreshButtons();
    }
    
    protected void refreshButtons() {
        fImageButton.setEnabled(!isLocked(getFirstSelectedObject()));
    }
    
    protected void chooseImage() {
        IDiagramModelImageProvider dmo = (IDiagramModelImageProvider)getFirstSelectedObject();
        
        if(isAlive(dmo)) {
            ImageManagerDialog dialog = new ImageManagerDialog(getPart().getSite().getShell(), dmo);
            if(dialog.open() == Window.OK) {
                // File
                if(dialog.getUserSelectedFile() != null) {
                    setImage(dialog.getUserSelectedFile());
                }
                // Existing image which could be in this model or a different model
                else if(dialog.getUserSelectedImagePath() != null) {
                    setImagePath(dialog.getUserSelectedModel(), dialog.getUserSelectedImagePath());
                }
            }
        }
    }
    
    /**
     * Set image path from selected image path from selected model
     */
    protected void setImagePath(IArchimateModel selectedModel, String imagePath) {
        // Different models so copy the image bytes and set the image path
        if(selectedModel != getFirstSelectedObject().getArchimateModel()) {
            try {
                IArchiveManager selectedArchiveManager = (IArchiveManager)selectedModel.getAdapter(IArchiveManager.class);
                imagePath = getArchiveManager().copyImageBytes(selectedArchiveManager, imagePath);
                doImagePathCommand(imagePath);
            }
            catch(IOException ex) {
                showError(ex);
            }
        }
        // Same model so just set the image path
        else {
            doImagePathCommand(imagePath);
        }
    }
    
    /**
     * Add and set Image and path from a file
     */
    protected void setImage(File file) {
        if(!file.exists() || !file.canRead()) {
            return;
        }

        try {
            String path = getArchiveManager().addImageFromFile(file);
            doImagePathCommand(path);
        }
        catch(IOException ex) {
            showError(ex);
        }
    }
    
    protected void doImagePathCommand(String path) {
        CompoundCommand result = new CompoundCommand();

        for(EObject dmo : getEObjects()) {
            if(isAlive(dmo)) {
                Command cmd = new EObjectFeatureCommand(path == null ? Messages.DiagramModelImageSection_4 : Messages.DiagramModelImageSection_7,
                        dmo, IArchimatePackage.Literals.DIAGRAM_MODEL_IMAGE_PROVIDER__IMAGE_PATH,
                        path);
                
                if(cmd.canExecute()) {
                    result.add(cmd);
                }
            }
        }

        executeCommand(result.unwrap());
    }
    
    protected IArchiveManager getArchiveManager() {
        return (IArchiveManager)((IAdapter)getFirstSelectedObject()).getAdapter(IArchiveManager.class);
    }
    
    protected void showError(Throwable ex) {
        ex.printStackTrace();
        MessageDialog.openError(getPart().getSite().getShell(),
                Messages.DiagramModelImageSection_5,
                Messages.DiagramModelImageSection_6 + " " + ex.getMessage()); //$NON-NLS-1$
    }
}
