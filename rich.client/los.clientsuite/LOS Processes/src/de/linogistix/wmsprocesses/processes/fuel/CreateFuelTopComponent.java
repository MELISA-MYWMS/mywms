/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.wmsprocesses.processes.fuel;

import de.linogistix.wmsprocesses.processes.fuel.*;
import de.linogistix.common.gui.component.other.TopComponentExt;
import de.linogistix.wmsprocesses.processes.fuel.gui.component.TopComponentPanel;
import de.linogistix.wmsprocesses.res.WMSProcessesBundleResolver;
import java.io.Serializable;
import java.util.logging.Logger;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
final class CreateFuelTopComponent extends TopComponentExt {

    private static CreateFuelTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";

    private static final String PREFERRED_ID = "CreateFuelTopComponent";
    private TopComponentPanel topComponentPanel = new TopComponentPanel(this);    
    

    private CreateFuelTopComponent() {
        
        initComponents();
        setName(NbBundle.getMessage(WMSProcessesBundleResolver.class, "CTL_CreateFuelTopComponent"));
        setToolTipText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "HINT_CreateFuelTopComponent"));
        postInit();
//        setIcon(Utilities.loadImage(ICON_PATH, true));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized CreateFuelTopComponent getDefault() {
        
        if (instance == null) {
            instance = new CreateFuelTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the CreateMovementTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized CreateFuelTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(CreateFuelTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof CreateFuelTopComponent) {
            return (CreateFuelTopComponent) win;
        }
        Logger.getLogger(CreateFuelTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return CreateFuelTopComponent.getDefault();
        }
    }
    
    private void postInit() {
        add(topComponentPanel);
    }

    @Override
    public HelpCtx getHelpCtx() {
        return  new HelpCtx("de.linogistix.wmsprocesses.fuel");
    }
    
    
}
