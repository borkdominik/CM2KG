/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.FigureUtils.Direction;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.ui.ColorFactory;
import com.archimatetool.model.IDiagramModelObject;
import com.archimatetool.model.ITextAlignment;
import com.archimatetool.model.ITextPosition;


/**
 * Box Figure Delegate
 * 
 * @author Phillip Beauvoir
 */
public class BoxFigureDelegate extends AbstractFigureDelegate {

    protected static final int FOLD_HEIGHT = 14;
    
    protected int iconOffset;
    
    public BoxFigureDelegate(IDiagramModelObjectFigure owner, int iconOffset) {
        super(owner);
        this.iconOffset = iconOffset;
    }
    
    @Override
    public void drawFigure(Graphics graphics) {
        graphics.pushState();
        
        Rectangle bounds = getBounds();
        
        // Set line width here so that the whole figure is consttained, otherwise SVG graphics will have overspill
        setLineWidth(graphics, 1, bounds);

        graphics.setAlpha(getAlpha());
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        graphics.setBackgroundColor(ColorFactory.getDarkerColor(getFillColor()));

        Path path = new Path(null);
        path.moveTo(bounds.x, bounds.y + FOLD_HEIGHT);
        path.lineTo(bounds.x + FOLD_HEIGHT, bounds.y);
        path.lineTo(bounds.x + bounds.width - 1, bounds.y);
        path.lineTo(bounds.x + bounds.width - 1, bounds.y + bounds.height - FOLD_HEIGHT - 1);
        path.lineTo(bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + bounds.height - 1);
        path.lineTo(bounds.x, bounds.y + bounds.height - 1);
        graphics.fillPath(path);
        path.dispose();
        
        // Fill front rectangle
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(getGradient() != IDiagramModelObject.GRADIENT_NONE) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor(), getAlpha(), Direction.get(getGradient()));
            graphics.setBackgroundPattern(gradient);
        }

        graphics.fillRectangle(bounds.x, bounds.y + FOLD_HEIGHT, bounds.width - FOLD_HEIGHT - 1, bounds.height - FOLD_HEIGHT - 1);

        if(gradient != null) {
            gradient.dispose();
        }

        // Outline
        graphics.setAlpha(getLineAlpha());
        graphics.setForegroundColor(getLineColor());
        
        path = new Path(null);
        
        path.moveTo(bounds.x, bounds.y + FOLD_HEIGHT);
        path.lineTo(bounds.x + FOLD_HEIGHT, bounds.y);
        path.lineTo(bounds.x + bounds.width - 1, bounds.y);
        path.lineTo(bounds.x + bounds.width - 1, bounds.y + bounds.height - FOLD_HEIGHT - 1);
        path.lineTo(bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + bounds.height - 1);
        path.lineTo(bounds.x, bounds.y + bounds.height - 1);
        path.lineTo(bounds.x, bounds.y + FOLD_HEIGHT);
        path.lineTo(bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + FOLD_HEIGHT);
        path.lineTo(bounds.x + bounds.width - 1, bounds.y);
        path.moveTo(bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + FOLD_HEIGHT);
        path.lineTo(bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + bounds.height - 1);
        
        graphics.drawPath(path);
        path.dispose();
        
        graphics.popState();
    }
    
    @Override
    public Rectangle calculateTextControlBounds() {
        Rectangle bounds = getBounds();
        
        int offset = FOLD_HEIGHT + 1;
        
        int textpos = ((ITextPosition)getOwner().getDiagramModelObject()).getTextPosition();
        int textAlignment = getOwner().getDiagramModelObject().getTextAlignment();
        
        if(textpos == ITextPosition.TEXT_POSITION_TOP) {
            bounds.y += FOLD_HEIGHT;
            
            if(textAlignment == ITextAlignment.TEXT_ALIGNMENT_CENTER) {
                bounds.x += iconOffset;
                bounds.width = bounds.width - (iconOffset * 2) - offset;
            }
            else if(textAlignment == ITextAlignment.TEXT_ALIGNMENT_RIGHT) {
                bounds.width -= offset + iconOffset;
            }
        }
        else {
            if(textAlignment == ITextAlignment.TEXT_ALIGNMENT_RIGHT) {
                bounds.width -= offset;
            }
        }

        return bounds;
    }

}
