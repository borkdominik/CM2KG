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

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.FigureUtils.Direction;
import com.archimatetool.model.IDiagramModelObject;




/**
 * Deliverable Figure
 * 
 * @author Phillip Beauvoir
 */
public class DeliverableFigure extends AbstractTextControlContainerFigure {
    
    public DeliverableFigure() {
        super(TEXT_FLOW_CONTROL);
    }
    
    @Override
    protected void drawFigure(Graphics graphics) {
        graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        bounds.width--;
        bounds.height--;
        
        // Set line width here so that the whole figure is constrained, otherwise SVG graphics will have overspill
        int lineWidth = 1;
        setLineWidth(graphics, lineWidth, bounds);
        
        int offset = 11;
        int curve_y = bounds.y + bounds.height - offset;
        
        graphics.setAlpha(getAlpha());
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Main Fill
        Path path = new Path(null);
        path.moveTo(bounds.x, bounds.y);
        path.lineTo(bounds.x, curve_y - 1);
        
        path.quadTo(bounds.x + (bounds.width / 4), bounds.y + bounds.height + offset,
                bounds.x + bounds.width / 2 + 1, curve_y);
        
        path.quadTo(bounds.x + bounds.width - (bounds.width / 4), curve_y - offset - 1,
                bounds.x + bounds.width, curve_y);
        
        path.lineTo(bounds.x + bounds.width, bounds.y);
        
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(getGradient() != IDiagramModelObject.GRADIENT_NONE) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor(), getAlpha(), Direction.get(getGradient()));
            graphics.setBackgroundPattern(gradient);
        }
        
        graphics.fillPath(path);
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Outline
        graphics.setAlpha(getLineAlpha());
        graphics.setForegroundColor(getLineColor());
        float lineOffset = (float)lineWidth / 2;
        path.lineTo(bounds.x - lineOffset, bounds.y);
        graphics.drawPath(path);
        path.dispose();
        
        graphics.popState();
    }
}
