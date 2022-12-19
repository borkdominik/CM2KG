/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.views.tree.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.archimatetool.editor.actions.AbstractDropDownAction;
import com.archimatetool.editor.model.IEditorModelManager;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;
import com.archimatetool.editor.ui.ArchiLabelProvider;
import com.archimatetool.editor.ui.IArchiImages;
import com.archimatetool.editor.ui.components.GlobalActionDisablementHandler;
import com.archimatetool.editor.utils.PlatformUtils;
import com.archimatetool.editor.utils.StringUtils;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IProperty;
import com.archimatetool.model.util.ArchimateModelUtils;



/**
 * Search Widget
 * 
 * @author Phillip Beauvoir
 */
public class SearchWidget extends Composite {

    private Text fSearchText;
    
    private SearchFilter fSearchFilter;
    
    private IAction fActionFilterName;
    private IAction fActionFilterDoc;
    
    private MenuManager fPropertiesMenu;
    
    private List<IAction> fObjectActions = new ArrayList<IAction>();
    
    private Timer fKeyDelayTimer;
    private int fTimerDelay = 600;
    
    // Hook into the global edit Action Handlers and null them when the text control has the focus
    private Listener textControlListener = new Listener() {
        private GlobalActionDisablementHandler globalActionHandler;
        
        @Override
        public void handleEvent(Event event) {
            switch(event.type) {
                case SWT.Activate:
                    globalActionHandler = new GlobalActionDisablementHandler();
                    globalActionHandler.clearGlobalActions();
                    break;

                case SWT.Deactivate:
                    if(globalActionHandler != null) {
                        globalActionHandler.restoreGlobalActions();
                    }
                    break;

                default:
                    break;
            }
        }
    };
    
    public SearchWidget(Composite parent, SearchFilter filter) {
        super(parent, SWT.NULL);
        
        fSearchFilter = filter;
        
        GridLayout layout = new GridLayout(2, false);
        setLayout(layout);
        setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        setupToolBar();
        setupSearchTextWidget();
        
        fSearchFilter.saveState();
    }
    
    @Override
    public boolean setFocus() {
        // On Linux the text control can be disposed at this point
        return fSearchText.isDisposed() ? false : fSearchText.setFocus();
    }

    protected void setupSearchTextWidget() {
        // The native search test controls look like shit on Windows and Mac
        if(!PlatformUtils.isLinux()) {
            SearchTextWidget widget = new SearchTextWidget(this);
            widget.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            fSearchText = widget.getTextControl();
        }
        else {
            fSearchText = new Text(this, SWT.SEARCH | SWT.ICON_CANCEL | SWT.ICON_SEARCH);
            fSearchText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        }
        
        // Use auto search
        if(Preferences.STORE.getBoolean(IPreferenceConstants.TREE_SEARCH_AUTO)) {
            fSearchText.addModifyListener(new ModifyListener() {
                @Override
                public void modifyText(ModifyEvent e) {
                    // If we have a timer cancel it
                    if(fKeyDelayTimer != null) {
                        fKeyDelayTimer.cancel();
                    }

                    // Set this to run with a short delay to allow for key presses
                    fKeyDelayTimer = new Timer();
                    fKeyDelayTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Display.getDefault().asyncExec(new Runnable() {
                                @Override
                                public void run() {
                                    fSearchFilter.setSearchText(fSearchText.getText());
                                }
                            });
                        }
                    }, fTimerDelay);
                }
            });
        }
        // Search on Return key press
        else {
            fSearchText.addListener(SWT.DefaultSelection, new Listener() {
                @Override
                public void handleEvent(Event e) {
                    fSearchFilter.setSearchText(fSearchText.getText());
                }
            });
        }
        
        // Hook into the global edit Action Handlers and null them when the text control has the focus
        fSearchText.addListener(SWT.Activate, textControlListener);
        fSearchText.addListener(SWT.Deactivate, textControlListener);
    }

    protected void setupToolBar() {
        fActionFilterName = new Action(Messages.SearchWidget_0, IAction.AS_CHECK_BOX) {
            @Override
            public void run() {
            	fSearchFilter.setFilterOnName(isChecked());
            };
        };
        fActionFilterName.setToolTipText(Messages.SearchWidget_1);
        fActionFilterName.setChecked(true);
        fSearchFilter.setFilterOnName(true);
        
        fActionFilterDoc = new Action(Messages.SearchWidget_2, IAction.AS_CHECK_BOX) {
            @Override
            public void run() {
            	fSearchFilter.setFilterOnDocumentation(isChecked());
            }
        };
        fActionFilterDoc.setToolTipText(Messages.SearchWidget_3);

        final ToolBarManager toolBarmanager = new ToolBarManager(SWT.FLAT);
        toolBarmanager.createControl(this);

        AbstractDropDownAction dropDownAction = new AbstractDropDownAction(Messages.SearchWidget_4) {
            @Override
            public ImageDescriptor getImageDescriptor() {
                return IArchiImages.ImageFactory.getImageDescriptor(IArchiImages.ICON_FILTER);
            }
        };
        toolBarmanager.add(dropDownAction);

        // Name & Documentation
        dropDownAction.add(fActionFilterName);
        dropDownAction.add(fActionFilterDoc);
        
        // Properties
        fPropertiesMenu = new MenuManager(Messages.SearchWidget_5);
        dropDownAction.add(fPropertiesMenu);
        populatePropertiesMenu(fPropertiesMenu);
        
        dropDownAction.add(new Separator());
        
        MenuManager strategyMenu = new MenuManager(Messages.SearchWidget_15);
        dropDownAction.add(strategyMenu);
        for(EClass eClass : ArchimateModelUtils.getStrategyClasses()) {
            strategyMenu.add(createObjectAction(eClass));
        }
        
        MenuManager businessMenu = new MenuManager(Messages.SearchWidget_6);
        dropDownAction.add(businessMenu);
        for(EClass eClass : ArchimateModelUtils.getBusinessClasses()) {
            businessMenu.add(createObjectAction(eClass));
        }
        
        MenuManager applicationMenu = new MenuManager(Messages.SearchWidget_7);
        dropDownAction.add(applicationMenu);
        for(EClass eClass : ArchimateModelUtils.getApplicationClasses()) {
            applicationMenu.add(createObjectAction(eClass));
        }
        
        MenuManager technologyPhysicalMenu = new MenuManager(Messages.SearchWidget_8);
        dropDownAction.add(technologyPhysicalMenu);
        for(EClass eClass : ArchimateModelUtils.getTechnologyClasses()) {
            technologyPhysicalMenu.add(createObjectAction(eClass));
        }
        technologyPhysicalMenu.add(new Separator());
        for(EClass eClass : ArchimateModelUtils.getPhysicalClasses()) {
            technologyPhysicalMenu.add(createObjectAction(eClass));
        }
        
        MenuManager motivationMenu = new MenuManager(Messages.SearchWidget_9);
        dropDownAction.add(motivationMenu);
        for(EClass eClass : ArchimateModelUtils.getMotivationClasses()) {
            motivationMenu.add(createObjectAction(eClass));
        }

        MenuManager implementationMenu = new MenuManager(Messages.SearchWidget_10);
        dropDownAction.add(implementationMenu);
        for(EClass eClass : ArchimateModelUtils.getImplementationMigrationClasses()) {
            implementationMenu.add(createObjectAction(eClass));
        }

        MenuManager otherMenu = new MenuManager(Messages.SearchWidget_14);
        dropDownAction.add(otherMenu);
        for(EClass eClass : ArchimateModelUtils.getOtherClasses()) {
            otherMenu.add(createObjectAction(eClass));
        }
        otherMenu.add(new Separator());
        for(EClass eClass : ArchimateModelUtils.getConnectorClasses()) {
            otherMenu.add(createObjectAction(eClass));
        }

        MenuManager relationsMenu = new MenuManager(Messages.SearchWidget_11);
        dropDownAction.add(relationsMenu);
        for(EClass eClass : ArchimateModelUtils.getRelationsClasses()) {
            relationsMenu.add(createObjectAction(eClass));
        }
        
        dropDownAction.add(new Separator());
        
        IAction action = new Action(Messages.SearchWidget_12, IAction.AS_CHECK_BOX) {
            @Override
            public void run() {
            	fSearchFilter.setShowAllFolders(isChecked());
            }
        };
        action.setChecked(fSearchFilter.isShowAllFolders());
        dropDownAction.add(action);
        
        dropDownAction.add(new Separator());
        
        action = new Action(Messages.SearchWidget_13) {
            @Override
            public void run() {
            	reset();
            }
        };
        dropDownAction.add(action);
        
        toolBarmanager.update(true);
    }
    
    private void reset() {
        // Clear Documentation
        fActionFilterDoc.setChecked(false);

        // Clear Objects
        for(IAction action : fObjectActions) {
            action.setChecked(false);
        }

        // Clear & Reset Properties sub-menus
        fPropertiesMenu.removeAll();
        populatePropertiesMenu(fPropertiesMenu);

        fSearchFilter.resetFilters();

        // Default to search on Name
        fActionFilterName.setChecked(true);
        fSearchFilter.setFilterOnName(true);
    }

	private IAction createObjectAction(final EClass eClass) {
        IAction action = new Action(ArchiLabelProvider.INSTANCE.getDefaultName(eClass), IAction.AS_CHECK_BOX) {
            @Override
            public void run() {
                if(isChecked()) {
                    fSearchFilter.addObjectFilter(eClass);
                }
                else {
                    fSearchFilter.removeObjectFilter(eClass);
                }
            }
            
            @Override
            public ImageDescriptor getImageDescriptor() {
                return ArchiLabelProvider.INSTANCE.getImageDescriptor(eClass);
            }
        };
        
        fObjectActions.add(action);
        
        return action;
    }

	private void populatePropertiesMenu(MenuManager propertiesMenu) {
	    // Models that are loaded are the ones in the Models Tree
	    Set<String> set = new HashSet<String>();

	    for(IArchimateModel model : IEditorModelManager.INSTANCE.getModels()) {
	        getAllUniquePropertyKeysForModel(model, set);
	    }
	    
	    List<String> list = new ArrayList<String>(set);
	    
	    // Sort alphapetically
	    Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.toLowerCase().compareTo(s2.toLowerCase());
            }
        });

	    for(final String key : list) {
	        IAction action = new Action(key, IAction.AS_CHECK_BOX) {
	            @Override
	            public void run() {
	                if(isChecked()) {
	                    fSearchFilter.addPropertiesFilter(key);
	                }
	                else {
	                    fSearchFilter.removePropertiesFilter(key);
	                }
	            }
	        };

	        propertiesMenu.add(action);
	    }

	    propertiesMenu.update(true);
	}

    private void getAllUniquePropertyKeysForModel(IArchimateModel model, Set<String> set) {
        for(Iterator<EObject> iter = model.eAllContents(); iter.hasNext();) {
            EObject element = iter.next();
            if(element instanceof IProperty) {
            	String key = ((IProperty)element).getKey();
            	if(StringUtils.isSetAfterTrim(key)) {
            	    set.add(key);
            	}
            }
        }
    }
}
