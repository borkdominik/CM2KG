/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui.factory.elements;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import com.archimatetool.editor.diagram.editparts.ArchimateElementEditPart;
import com.archimatetool.editor.diagram.figures.elements.InteractionFigure;
import com.archimatetool.editor.ui.ColorFactory;
import com.archimatetool.editor.ui.IArchiImages;
import com.archimatetool.model.IArchimatePackage;



/**
 * Technology Interaction UI Provider
 * 
 * @author Phillip Beauvoir
 */
public class TechnologyInteractionUIProvider extends AbstractArchimateElementUIProvider {

    @Override
    public EClass providerFor() {
        return IArchimatePackage.eINSTANCE.getTechnologyInteraction();
    }
    
    @Override
    public EditPart createEditPart() {
        return new ArchimateElementEditPart(InteractionFigure.class);
    }

    @Override
    public String getDefaultName() {
        return Messages.TechnologyInteractionUIProvider_0;
    }

    @Override
    public Image getImage() {
        return IArchiImages.ImageFactory.getImage(IArchiImages.ICON_TECHNOLOGY_INTERACTION);
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return IArchiImages.ImageFactory.getImageDescriptor(IArchiImages.ICON_TECHNOLOGY_INTERACTION);
    }
    
    @Override
    public Color getDefaultColor() {
        return ColorFactory.get(201, 231, 183);
    }
}
