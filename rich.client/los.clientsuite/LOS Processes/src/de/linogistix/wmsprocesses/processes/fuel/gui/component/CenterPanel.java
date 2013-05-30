/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.wmsprocesses.processes.fuel.gui.component;

import de.linogistix.wmsprocesses.processes.fuel.gui.gui_builder.AbstractCenterPanel;
import de.linogistix.common.services.J2EEServiceLocator;
import de.linogistix.inventory.gui.component.controls.ClientItemDataLotFilteringComponent;
import java.util.logging.Logger;
import org.openide.util.Lookup;

/**
 *
 * @author Paris Rozakis
 */
public class CenterPanel extends AbstractCenterPanel {

    private J2EEServiceLocator loc = (J2EEServiceLocator) Lookup.getDefault().lookup(J2EEServiceLocator.class);
    private final static Logger log = Logger.getLogger(CenterPanel.class.getName());
    private boolean initialized = false;
    TopComponentPanel topComponentPanel;
    ClientItemDataLotFilteringComponent cilComp;
     
    public CenterPanel(TopComponentPanel topComponentPanel) {
        this.topComponentPanel = topComponentPanel;
        
        
    }

    private void initAutofiltering(){
        
       
    }


    
    void clear() {
        initDefaults();
    }

     private void clearPositionDetail() {
    }

 
    public void process(boolean processAutomaticly) {
       
    }

   
    
    /** write default-values and default-selections to the fields */
    private void initDefaults() {
        
       
    }

        public void componentClosed() {
    }

    public void componentOpened() {
        if (initialized) {
            return;
        }
        initAutofiltering();
        initialized = true;
        clear();
    }

    public void componentActivated() {
    }

    public void componentDeactivated() {
    }

    public void componentHidden() {
    }

    public void componentShowing() {
    }
}
