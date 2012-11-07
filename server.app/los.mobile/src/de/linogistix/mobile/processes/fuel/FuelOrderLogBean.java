package de.linogistix.mobile.processes.fuel;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import de.linogistix.los.util.entityservice.LOSSystemPropertyServiceRemote;
import de.linogistix.mobile.common.gui.bean.BasicDialogBean;
import de.linogistix.mobile.common.system.JSFHelper;

import de.linogistix.los.location.model.LOSStorageLocation;

import de.linogistix.los.location.service.QueryStorageLocationServiceRemote;

public class FuelOrderLogBean extends BasicDialogBean {
    Logger log = Logger.getLogger(FuelBean.class);

    private Date startDateInput;
    private Date endDateInput;
    private String inputCode;

    private QueryStorageLocationServiceRemote locService;

    private LOSSystemPropertyServiceRemote propertyService;

    public FuelOrderLogBean() {
        super();
        propertyService = super.getStateless(LOSSystemPropertyServiceRemote.class);
        locService = super.getStateless(QueryStorageLocationServiceRemote.class);
    }

    public String getNavigationKey() {
        if(!isRolesAllowed()){
            return FuelNavigationEnum.FUEL_BACK_TO_MENU.name();
		}

        return FuelNavigationEnum.FUEL_CHOOSE_DATES.name();
    }


    public String getTitle() {
        return resolve("TitleFuelLog");
    }

    @Override
    public void init(String[] args) {
        super.init(args);
    }

    public String processEnterDates() {

        /*if( mat.isAdviceMandatory() ) {
            JSFHelper.getInstance().message( resolve("MsgMatAdviceMandatory") );
            return "";
        }*/

		return FuelNavigationEnum.FUEL_LOG_CHOOSE_LOC.name();
    }

    public String processEnterDatesCancel() {
        return FuelNavigationEnum.FUEL_BACK_TO_MENU.name();
    }

    public String processEnterLoc() {
        String code = inputCode == null ? "" : inputCode.trim();
        inputCode = "";
        LOSStorageLocation loc = null;

        if( code.length() == 0 ) {
            JSFHelper.getInstance().message( resolve("MsgEnterLoc") );
            return "";
        }
        loc = null;
        try {
            loc = locService.getByName(code);
        } catch( Exception e ) {
            log.error("Cannot select location="+code+". ex="+e.getMessage(), e);
        }
        if( loc == null ) {
            log.error("Wrong location entered. location="+code);
            JSFHelper.getInstance().message( resolve("MsgLocNotAccessable") );
            return "";
        }

        return FuelNavigationEnum.FUEL_GET_PDF.name();
    }

    public String processEnterLocCancel() {
        return FuelNavigationEnum.FUEL_BACK_TO_MENU.name();
    }

    @Override
    protected ResourceBundle getResourceBundle() {
        ResourceBundle bundle;
        Locale lo;
        lo = getUIViewRoot().getLocale();
        bundle = ResourceBundle.getBundle("de.linogistix.mobile.processes.fuel.FuelBundle", lo);
        return bundle;
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

	public Date getStartDateInput() {
		return startDateInput;
	}

	public void setStartDateInput(Date startDateInput) {
		this.startDateInput = startDateInput;
	}

	public Date getEndDateInput() {
		return endDateInput;
	}

	public void setEndDateInput(Date endDateInput) {
		this.endDateInput = endDateInput;
	}

    public String getInputCode() {
        return inputCode;
    }
    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }
}