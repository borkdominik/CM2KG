/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.canvas.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;

/**
 * Tooltip Figure
 * 
 * @author Phillip Beauvoir
 */
public class MultiToolTipFigure extends Figure {
    
    private TextFlow fTextFlow;

    public MultiToolTipFigure() {
        setBorder(new MarginBorder(3));
        
        ToolbarLayout layout = new ToolbarLayout();
        setLayoutManager(layout);
        
        FlowPage page = new FlowPage() {
            @Override
            public Dimension getPreferredSize(int wHint, int hHint) {
                Dimension d = FigureUtilities.getTextExtents(fTextFlow.getText(), fTextFlow.getFont());
                if(d.width > 400) {
                    d.width = 400;
                }
                return d;
            }
        };
        
        fTextFlow = new TextFlow();
        fTextFlow.setLayoutManager(new ParagraphTextLayout(fTextFlow, ParagraphTextLayout.WORD_WRAP_HARD));
        page.add(fTextFlow);
        add(page);
    }
    
    public MultiToolTipFigure(String text) {
        this();
        setText(text);
    }

    public void setText(String text) {
        fTextFlow.setText(text);
    }
}