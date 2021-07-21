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
import com.archimatetool.editor.diagram.figures.IFigureDelegate;
import com.archimatetool.editor.diagram.figures.RectangleFigureDelegate;
import com.archimatetool.model.IDiagramModelArchimateObject;


/**
 * Figure for a Node
 * 
 * @author Phillip Beauvoir
 */
public class NodeFigure extends AbstractTextControlContainerFigure {
    
    protected IFigureDelegate fFigureDelegate1;
    protected IFigureDelegate fFigureDelegate2;
    
    public NodeFigure() {
        super(TEXT_FLOW_CONTROL);
        fFigureDelegate1 = new BoxFigureDelegate(this, 0);
        fFigureDelegate2 = new RectangleFigureDelegate(this, 20 - getTextControlMarginWidth());
    }
    
    @Override
    protected void drawFigure(Graphics graphics) {
        super.drawFigure(graphics);
        
        int type = getDiagramModelObject().getType();
        if(type == 1) {
            drawIcon(graphics);
        }
    }
    
    /**
     * Draw the icon
     */
    protected void drawIcon(Graphics graphics) {
        graphics.pushState();
        
        graphics.setLineWidth(1);
        graphics.setForegroundColor(isEnabled() ? ColorConstants.black : ColorConstants.gray);
        
        Point pt = getIconOrigin();
        
        Path path = new Path(null);
        
        path.addRectangle(pt.x, pt.y, 11, 11);
        
        path.moveTo(pt.x - 0.2f, pt.y);
        path.lineTo(pt.x + 3.2f, pt.y - 3);
        
        path.moveTo(pt.x + 11, pt.y);
        path.lineTo(pt.x + 14, pt.y - 3);
        
        path.moveTo(pt.x + 11.2f, pt.y + 11);
        path.lineTo(pt.x + 14.2f, pt.y + 8);
        
        
        path.moveTo(pt.x + 3, pt.y - 2.8f);
        path.lineTo(pt.x + 14.3f, pt.y - 2.8f);
        
        path.moveTo(pt.x + 14, pt.y - 3);
        path.lineTo(pt.x + 14, pt.y + 8.2f);

        graphics.drawPath(path);
        path.dispose();
        
        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 18, bounds.y + 9);
    }
    
    @Override
    public IFigureDelegate getFigureDelegate() {
        int type = getDiagramModelObject().getType();
        return type == 0 ? fFigureDelegate1 : fFigureDelegate2;
    }
    
    @Override
    public IDiagramModelArchimateObject getDiagramModelObject() {
        return (IDiagramModelArchimateObject)super.getDiagramModelObject();
    }

}