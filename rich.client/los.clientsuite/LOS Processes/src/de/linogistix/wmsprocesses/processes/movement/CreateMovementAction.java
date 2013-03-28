/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.wmsprocesses.processes.movement;



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
public class CreateMovementAction extends AbstractAction {

    public String[] getAllowedRoles() {
        return new String[] {Role.ADMIN_STR,Role.INVENTORY_STR};
    }

    public CreateMovementAction() {
        super(NbBundle.getMessage(WMSProcessesBundleResolver.class, "CTL_MovementAction"));
//        putValue(SMALL_ICON, new ImageIcon(Utilities.loadImage(CreateMovementTopComponent.ICON_PATH, true)));

        LoginService login = (LoginService) Lookup.getDefault().lookup(LoginService.class);
        boolean result = login.checkRolesAllowed(getAllowedRoles());
        Logger.getLogger(CreateMovementTopComponent.class.getName()).warning(
                    "Logged in : "+ result);
        setEnabled(result);
    }

    public void actionPerformed(ActionEvent evt) {
        TopComponent win = CreateMovementTopComponent.findInstance();
        win.open();
        win.requestActive();
    }
}
