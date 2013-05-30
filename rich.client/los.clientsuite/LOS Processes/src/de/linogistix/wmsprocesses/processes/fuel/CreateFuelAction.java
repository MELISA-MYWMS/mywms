/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.wmsprocesses.processes.fuel;



import de.linogistix.wmsprocesses.processes.fuel.*;
import de.linogistix.common.userlogin.LoginService;
import de.linogistix.wmsprocesses.res.WMSProcessesBundleResolver;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import org.mywms.globals.Role;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * Action which shows Movement component.
 */
public class CreateFuelAction extends AbstractAction {

    public String[] getAllowedRoles() {
        return new String[] {Role.ADMIN_STR,Role.INVENTORY_STR};
    }

    public CreateFuelAction() {
        super(NbBundle.getMessage(WMSProcessesBundleResolver.class, "CTL_CreateFuelAction"));
//        putValue(SMALL_ICON, new ImageIcon(Utilities.loadImage(CreateMovementTopComponent.ICON_PATH, true)));

        LoginService login = (LoginService) Lookup.getDefault().lookup(LoginService.class);
        boolean result = login.checkRolesAllowed(getAllowedRoles());
        Logger.getLogger(CreateFuelTopComponent.class.getName()).warning(
                    "Logged in : "+ result);
        setEnabled(result);
    }

    public void actionPerformed(ActionEvent evt) {
        TopComponent win = CreateFuelTopComponent.findInstance();
        win.open();
        win.requestActive();
    }
}
