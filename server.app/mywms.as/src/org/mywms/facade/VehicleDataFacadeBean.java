package org.mywms.facade;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import org.apache.log4j.Logger;
import org.mywms.model.Client;
import org.mywms.model.VehicleData;
import org.mywms.service.VehicleDataService;


@Stateless
@RolesAllowed( {
    org.mywms.globals.Role.ADMIN_STR
})
public class VehicleDataFacadeBean extends BasicFacadeBean implements VehicleDataFacade{
	private static final Logger log =
	        Logger.getLogger(BasicFacadeBean.class.getName());
	
	@EJB
	VehicleDataService vehicleDataService;
	
	public List<VehicleData> getAllVehicles(){
		 Client cc = getCallersClient();
		 List<VehicleData> vehicles = vehicleDataService.getList(cc);
		return vehicles;
	}
}
