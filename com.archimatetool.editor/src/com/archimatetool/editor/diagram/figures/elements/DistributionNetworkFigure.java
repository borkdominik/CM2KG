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
import org.eclipse.swt.graphics.Path;

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;
import com.archimatetool.editor.diagram.figures.RectangleFigureDelegate;




/**
 * Material Figure
 * 
 * @author Phillip Beauvoir
 */
public class DistributionNetworkFigure extends AbstractTextControlContainerFigure {

    public DistributionNetworkFigure() {
        super(TEXT_FLOW_CONTROL);
        // Use a Rectangle Figure Delegate to Draw
        setFigureDelegate(new RectangleFigureDelegate(this, 22 - getTextControlMarginWidth()));
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
        
        graphics.setForegroundColor(isEnabled() ? ColorConstants.black : ColorConstants.gray);
        graphics.setLineWidthFloat(1.5f);
        
        Point pt = getIconOrigin();
        
        Path path = new Path(null);
        
        path.moveTo(pt.x + 1, pt.y - 2);
        path.lineTo(pt.x + 14, pt.y - 2);
        
        path.moveTo(pt.x + 1, pt.y + 2);
        path.lineTo(pt.x + 14, pt.y + 2);

        graphics.drawPath(path);
        path.dispose();
        
        path = new Path(null);
        
        path.moveTo(pt.x + 4, pt.y - 5);
        path.lineTo(pt.x - 1, pt.y);
        path.lineTo(pt.x + 4, pt.y + 5);
        
        path.moveTo(pt.x + 11, pt.y - 5);
        path.lineTo(pt.x + 16, pt.y);
        path.lineTo(pt.x + 11, pt.y + 5);
 
        graphics.drawPath(path);
        path.dispose();

        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 20, bounds.y + 12);
    }
}
