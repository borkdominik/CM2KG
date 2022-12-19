/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;


/**
 * Figure for an Assessment
 * 
 * @author Phillip Beauvoir
 */
public class AssessmentFigure extends AbstractMotivationFigure {
    
    public AssessmentFigure() {
    }

    @Override
    protected void drawFigure(Graphics graphics) {
        super.drawFigure(graphics);
        drawIcon(graphics);
    }
    
    /**
     * Draw the icon
     */
    protected void drawIcon(Graphics graphics) {
        graphics.pushState();
        
        graphics.setLineWidth(1);
        graphics.setForegroundColor(isEnabled() ? ColorConstants.black : ColorConstants.gray);
        
        Point pt = getIconOrigin();
        graphics.drawOval(pt.x, pt.y, 8, 8);
        graphics.drawLine(pt.x + 2, pt.y + 7, pt.x - 3, pt.y + 12);
        
        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 15, bounds.y + 6);
    }
    
    @Override
    protected int getIconOffset() {
        return 21;
    }

}