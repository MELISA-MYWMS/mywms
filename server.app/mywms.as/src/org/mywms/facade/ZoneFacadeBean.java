package org.mywms.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import org.mywms.model.Client;
import org.mywms.model.User;
import org.mywms.model.Zone;
import org.mywms.service.ZoneService;


@Stateless
@RolesAllowed( {
    org.mywms.globals.Role.ADMIN_STR
})
public class ZoneFacadeBean extends BasicFacadeBean
implements ZoneFacade {
	private static final Logger log =
	        Logger.getLogger(BasicFacadeBean.class.getName());
	
	@EJB
	ZoneService zoneService;
	
	public List<Zone> getAllZones(){
		 Client cc = getCallersClient();
		 List<Zone> zones = zoneService.getList(cc);
		return zones;
	}
}
