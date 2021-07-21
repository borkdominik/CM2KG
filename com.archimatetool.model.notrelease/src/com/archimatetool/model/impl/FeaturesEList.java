/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IFeature;
import com.archimatetool.model.IFeaturesEList;

/**
 * Convenience class to set and get IFeature names and values
 * 
 * @author Phillip Beauvoir
 */
public class FeaturesEList extends EObjectContainmentEList<IFeature> implements IFeaturesEList {
    
    public FeaturesEList(Class<?> dataClass, InternalEObject owner, int featureID) {
        super(dataClass, owner, featureID);
    }

    @Override
    public IFeature putString(String name, String value) {
        return putString(name, value, null);
    }
    
    @Override
    public IFeature putString(String name, String value, String defaultValue) {
        checkNull(name);
        checkNull(value);
        
        IFeature feature = getFeature(name);

        // New one
        if(feature == null) {
            feature = IArchimateFactory.eINSTANCE.createFeature();
            feature.setName(name);
            feature.setValue(value);
            add(feature);
        }
        // Value equals default value so remove it
        else if(value.equals(defaultValue)) {
            remove(feature);
        }
        // Different value
        else if(!value.equals(feature.getValue())) {
            feature.setValue(value);
        }
        
        return feature;
    }
    
    @Override
    public IFeature putInt(String name, int value) {
        return putString(name, Integer.toString(value), null);
    }
    
    @Override
    public IFeature putInt(String name, int value, int defaultValue) {
        return putString(name, Integer.toString(value), Integer.toString(defaultValue));
    }
    
    @Override
    public IFeature putBoolean(String name, boolean value) {
        return putString(name, Boolean.toString(value), null);
    }
    
    @Override
    public IFeature putBoolean(String name, boolean value, boolean defaultValue) {
        return putString(name, Boolean.toString(value), Boolean.toString(defaultValue));
    }
    
    @Override
    public String getString(String name, String defaultValue) {
        IFeature feature = getFeature(name);
        return feature == null ? defaultValue : feature.getValue();
    }

    @Override
    public int getInt(String name, int defaultValue) {
        String val = getString(name, String.valueOf(defaultValue));
        try {
            return Integer.valueOf(val);
        }
        catch(NumberFormatException ex) {
            return defaultValue;
        }
    }

    @Override
    public boolean getBoolean(String name, boolean defaultValue) {
        String val = getString(name, Boolean.toString(defaultValue));
        return Boolean.valueOf(val);
    }

    @Override
    public boolean remove(String name) {
        checkNull(name);
        
        IFeature feature = getFeature(name);
        if(feature != null) {
            return remove(feature);
        }
        
        return false;
    }
    
    @Override
    public boolean has(String name) {
        return getFeature(name) != null;
    }

    @Override
    public IFeature getFeature(String name) {
        checkNull(name);
        
        for(IFeature f : this) {
            if(f.getName().equals(name)) {
                return f;
            }
        }
        
        return null;
    }

    private void checkNull(String s) {
        if(s == null) {
            throw new IllegalArgumentException("key or value cannot be null"); //$NON-NLS-1$
        }
    }
    
    /**
     * Return true so that {@link #contains(Object)} checks {@link Feature#equals(Object)}
     * For unique entries keyed by name
     */
    @Override
    protected boolean useEquals() {
        return true;
    }
}
