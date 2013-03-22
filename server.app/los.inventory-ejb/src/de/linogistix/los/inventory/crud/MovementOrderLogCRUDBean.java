package de.linogistix.los.inventory.crud;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.mywms.service.BasicService;

import de.linogistix.los.crud.BusinessObjectCRUDBean;
import de.linogistix.los.inventory.model.MovementOrderLog;
import de.linogistix.los.inventory.service.MovementOrderLogService;

@Stateless
public class MovementOrderLogCRUDBean extends BusinessObjectCRUDBean<MovementOrderLog> implements MovementOrderLogCRUDRemote {

	@EJB 
	MovementOrderLogService service;

    @Override
    protected BasicService<MovementOrderLog> getBasicService() {
        return service;
    }
	
	
}
