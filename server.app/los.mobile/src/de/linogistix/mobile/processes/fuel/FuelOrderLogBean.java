package de.linogistix.mobile.processes.fuel;

import de.linogistix.los.util.entityservice.LOSSystemPropertyServiceRemote;
import de.linogistix.mobile.common.gui.bean.BasicDialogBean;
import de.linogistix.mobile.common.system.JSFHelper;

public class FuelOrderLogBean extends BasicDialogBean {
    Logger log = Logger.getLogger(FuelBean.class);

    private LOSSystemPropertyServiceRemote propertyService;

    public FuelBean() {
        super();
        propertyService = super.getStateless(LOSSystemPropertyServiceRemote.class);
    }

    public String getNavigationKey() {
        if(!isRolesAllowed()){
        	currentMode = "";
            return FuelNavigationEnum.FUEL_BACK_TO_MENU.name();
		}

        if( currentMode == MODE_OUT ) {
            return FuelNavigationEnum.FUEL_CHOOSE_VEHICLE.name();
        }
        return FuelNavigationEnum.FUEL_CHOOSE_ITEM.name();
    }


    public String getTitle() {
        if( currentMode == MODE_OUT ) {
            return resolve("TitleFuelOut");
        }
        return resolve("TitleFuelIn");
    }

    @Override
    public void init(String[] args) {
        super.init(args);

        currentMode = MODE_OUT;

        if( args != null && args.length>0 ) {
            String s = args[0];
            if(s.startsWith(MODE_IN) ) {
                currentMode = MODE_IN;
            }
        }

    }

    @Override
    public boolean isRolesAllowed() {
        String[] allowed;
        String[] roles;

        allowed = getRolesAllowed();
        if (allowed == null || allowed.length == 0) {
            return false;
        }

        roles = getPrincipalRoles();

        if ((allowed == null || allowed.length == 0)
                && (roles == null || roles.length == 0)) {
            return true;
        }

        for (String allow : allowed) {
            for (String role : roles) {
                if (allow.equals(role)) {
                    return true;
                }
            }
        }

        return false;

    }

    @Override
    public String[] getRolesAllowed () {
        return new String[] {org.mywms.globals.Role.FUEL_STR};
    }
}
