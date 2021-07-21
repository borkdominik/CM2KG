/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.preferences;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;

import com.archimatetool.model.IArchimatePackage;




/**
 * Connection Preferences Manager
 * Convenience class
 * 
 * 1. Create a Relation when Adding a New Element to a Parent Element
 * A new relation is created when creating a new element from the palette into a parent element
 * 
 * 2. Create Relation(s) when dragging ModelTree Element(s) to a Parent Element
 * A new relation is created when dragging an element from the model tree into a parent element if one does not already exist
 *  
 * 3. Create Relation(s) when dragging Element(s) to Parent Element
 * A new relation is created when dragging an element in a View into a parent element if one does not already exist
 * 
 * 4. Create View Connection(s) when Moving Element(s) from Parent Element
 * A new diagram connection is created when moving an element in a View out of a parent element. (Substitute a connection for nested)
 * 
 * 5. Delete existing View Connection(s) When Moving Element(s) to Parent Element
 * An existing diagram connection is deleted when moving an element in a View into the parent element at the source of the connection. (Substitute nested for a connection) 
 * 
 * @author Phillip Beauvoir
 */
public class ConnectionPreferences extends Preferences {
    
    static Map<EClass, Integer> RELATION_KEYMAP = new LinkedHashMap<EClass, Integer>();
    static {
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getCompositionRelationship(), 1 << 9);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getAggregationRelationship(), 1 << 8);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getAssignmentRelationship(), 1 << 7);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getSpecializationRelationship(), 1 << 6);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getRealizationRelationship(), 1 << 5);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getTriggeringRelationship(), 1 << 4);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getFlowRelationship(), 1 << 3);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getServingRelationship(), 1 << 2);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getAccessRelationship(), 1 << 1);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getAssociationRelationship(), 1 << 0);
        RELATION_KEYMAP.put(IArchimatePackage.eINSTANCE.getInfluenceRelationship(), 1 << 10);
    }
    
    private static EClass[] fRelationClassesForNew = null;
    private static EClass[] fRelationClassesForNewReverse = null;
    private static EClass[] fRelationClassesForHiding = null;
    
    /**
     * @return true if we should use nested connection logic
     */
    public static boolean useNestedConnections() {
        return STORE.getBoolean(USE_NESTED_CONNECTIONS);
    }
    
    /**
     * @return true if we should offer to create a new relation when adding a new child element into a parent element
     *         from the palette
     */
    public static boolean createRelationWhenAddingNewElement() {
        return useNestedConnections() && STORE.getBoolean(CREATE_RELATION_WHEN_ADDING_NEW_ELEMENT_TO_CONTAINER);
    }
    
    /**
     * @return true if we should offer to create a new relation when adding a child element from the model tree into a parent element
     */
    public static boolean createRelationWhenAddingModelTreeElement() {
        return useNestedConnections() && STORE.getBoolean(CREATE_RELATION_WHEN_ADDING_MODEL_TREE_ELEMENT_TO_CONTAINER);
    }
    
    /**
     * @return true if we should offer to create a new relation when moving a child element into a parent element
     */
    public static boolean createRelationWhenMovingElement() {
        return useNestedConnections() && STORE.getBoolean(CREATE_RELATION_WHEN_MOVING_ELEMENT_TO_CONTAINER);
    }
    
    /**
     * @return The list of relation classes to consider when creating new nested-type relations
     */
    public static EClass[] getRelationsClassesForNewRelations() {
        if(fRelationClassesForNew == null) {
            fRelationClassesForNew = getRelationsClasses(NEW_RELATIONS_TYPES);
        }
        return fRelationClassesForNew;
    }

    /**
     * @return The list of relation classes to consider when creating new reverse nested-type relations
     */
    public static EClass[] getRelationsClassesForNewReverseRelations() {
        if(fRelationClassesForNewReverse == null) {
            fRelationClassesForNewReverse = getRelationsClasses(NEW_REVERSE_RELATIONS_TYPES);
        }
        return fRelationClassesForNewReverse;
    }

    /**
     * @return The list of relation classes to consider as a nested-type relation without explicit connections
     */
    public static EClass[] getRelationsClassesForHiding() {
        if(fRelationClassesForHiding == null) {
            fRelationClassesForHiding = getRelationsClasses(HIDDEN_RELATIONS_TYPES);
        }
        return fRelationClassesForHiding;
    }
    
    private static EClass[] getRelationsClasses(String type) {
        int val = STORE.getInt(type);
        
        List<EClass> list = new ArrayList<EClass>();
        
        for(Entry<EClass, Integer> entry : RELATION_KEYMAP.entrySet()) {
            if((entry.getValue() & val) != 0) {
                list.add(entry.getKey());
            }
        }
        
        return list.toArray(new EClass[list.size()]);   
    }

    /*
     * Reset the cached values
     */
    static void reset() {
        fRelationClassesForNew = null;
        fRelationClassesForNewReverse = null;
        fRelationClassesForHiding = null;
    }
}
