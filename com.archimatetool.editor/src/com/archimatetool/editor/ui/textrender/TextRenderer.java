/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui.textrender;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.archimatetool.editor.utils.StringUtils;
import com.archimatetool.model.IArchimateModelObject;
import com.archimatetool.model.IDiagramModelArchimateComponent;
import com.archimatetool.model.IDiagramModelConnection;
import com.archimatetool.model.IDiagramModelGroup;
import com.archimatetool.model.IDiagramModelNote;
import com.archimatetool.model.IDiagramModelReference;
import com.archimatetool.model.IFolder;

/**
 * Render Text for display in Text controls in diagrams
 * 
 * @author Phillip Beauvoir
 */
@SuppressWarnings("nls")
public class TextRenderer {
    
    public static final String FEATURE_NAME = "labelExpression";

    private Set<ITextRenderer> renderers = new LinkedHashSet<>();
    
    private static TextRenderer defaultTextRenderer = new TextRenderer();
    
    public static TextRenderer getDefault() {
        return defaultTextRenderer;
    }
    
    private TextRenderer() {
        // Register internal renderers
        registerRenderer(new NameRenderer());
        registerRenderer(new DocumentationRenderer());
        registerRenderer(new TypeRenderer());
        
        registerRenderer(new PropertiesRenderer());

        registerRenderer(new TextContentRenderer());
        registerRenderer(new RelationshipRenderer());
        registerRenderer(new ViewpointRenderer());
        
        registerRenderer(new WordWrapRenderer());
    }
    
    /**
     * Render an object's format expression
     * 
     * @param object The object that has the format expression string and will be rendered 
     * @return The rendered text, or the empty string "" if no rendering is performed
     */
    public String render(IArchimateModelObject object) {
        return render(object, getFormatExpression(object));
    }
    
    /**
     * Render an object's format expression with the provided format expression 
     * 
     * @param object The object that will be rendered 
     * @param formatExpression the format expression to use on the object
     * @return The rendered text, or the empty string "" if no rendering is performed
     */
    public String render(IArchimateModelObject object, String formatExpression) {
        if(!StringUtils.isSet(formatExpression)) {
            return "";
        }
        
        // Remove escapement of newline chars
        String result = renderNewLines(formatExpression);
        
        // Keep a list of results to check for circular recursion
        Set<String> resultSet = new HashSet<String>();
        
        final int MAX_RECURSION = 10; // Max recursion level
        
        do {
            // Add to result set
            resultSet.add(result);
            
            // Check for max recursion
            if(resultSet.size() == MAX_RECURSION) {
                return "*** Recursion Error in Label Expression ***";
            }

            // Iterate through all registered renderers
            for(ITextRenderer r : renderers) {
                result = r.render(object, result);
            }
            
        } while((!resultSet.contains(result)));

        return result;
    }

    /**
     * @return true if object has a format expression
     */
    public boolean hasFormatExpression(IArchimateModelObject object) {
        return getFormatExpression(object) != null;
    }

    /**
     * @return the object's text expression or null if not present
     */
    public String getFormatExpression(IArchimateModelObject object) {
        return object.getFeatures().getString(FEATURE_NAME, null);
    }
    
    /**
     * This expression used to render a label for an object given its ancestor folder's label expression, if present
     * @return The format expression from an object's ancestor folder, or null if not present
     */
    public String getFormatExpressionFromAncestorFolder(IArchimateModelObject object) {
        if(object != null && object.eContainer() instanceof IFolder) {
            String expression = null;
            IArchimateModelObject parent = (IFolder)object.eContainer();
            
            do {
                expression = getFormatExpression(parent);
                parent = (IArchimateModelObject)parent.eContainer();
            }
            while(expression == null && parent instanceof IFolder);
            
            return expression;
        }
        
        return null;
    }

    /**
     * Register a ITextRenderer
     * @param renderer
     */
    public void registerRenderer(ITextRenderer renderer) {
        renderers.add(renderer);
    }
    
    /**
     * @return true if the object has support for label expressions
     */
    public boolean isSupportedObject(Object object) {
        return object instanceof IDiagramModelArchimateComponent 
                || object instanceof IDiagramModelNote
                || object instanceof IDiagramModelGroup
                || object instanceof IDiagramModelReference
                || object instanceof IDiagramModelConnection
                || object instanceof IFolder;
    }
    
    /**
     * Remove escapement of newline chars
     */
    private String renderNewLines(String result) {
        return result.replace("\\n", "\n");
    }
}
