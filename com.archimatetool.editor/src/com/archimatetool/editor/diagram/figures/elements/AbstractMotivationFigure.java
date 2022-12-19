/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.FigureUtils.Direction;
import com.archimatetool.model.IDiagramModelObject;


/**
 * Figure for a Motiviation Element
 * 
 * @author Phillip Beauvoir
 */
public abstract class AbstractMotivationFigure extends AbstractTextControlContainerFigure {
    
    protected static final int FLANGE = 10;
    
    protected AbstractMotivationFigure() {
        super(TEXT_FLOW_CONTROL);
    }
    
    @Override
    protected void drawFigure(Graphics graphics) {
        if(getFigureDelegate() != null) {
            getFigureDelegate().drawFigure(graphics);
            return;
        }

        graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        bounds.width--;
        bounds.height--;
        
        // Set line width here so that the whole figure is constrained, otherwise SVG graphics will have overspill
        setLineWidth(graphics, 1, bounds);
       
        PointList points = new PointList();
        points.addPoint(bounds.x + FLANGE, bounds.y);
        points.addPoint(bounds.x + bounds.width - FLANGE, bounds.y);
        points.addPoint(bounds.x + bounds.width, bounds.y + FLANGE);
        points.addPoint(bounds.x + bounds.width, bounds.y + bounds.height - FLANGE);
        points.addPoint(bounds.x + bounds.width - FLANGE, bounds.y + bounds.height);
        points.addPoint(bounds.x + FLANGE, bounds.y + bounds.height);
        points.addPoint(bounds.x, bounds.y + bounds.height - FLANGE);
        points.addPoint(bounds.x, bounds.y + FLANGE);
        
        graphics.setAlpha(getAlpha());
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Fill
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(getGradient() != IDiagramModelObject.GRADIENT_NONE) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor(), getAlpha(), Direction.get(getGradient()));
            graphics.setBackgroundPattern(gradient);
        }
        
        //graphics.fillPolygon(points);
        Path path = FigureUtils.createPathFromPoints(points);
        graphics.fillPath(path);
        path.dispose();
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Line
        graphics.setAlpha(getLineAlpha());
        graphics.setForegroundColor(getLineColor());
        graphics.drawPolygon(points);
        
        graphics.popState();
    }
}