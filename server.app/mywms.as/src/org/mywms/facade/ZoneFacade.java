package org.mywms.facade;

import java.util.List;

import javax.ejb.Remote;

import org.mywms.model.Zone;
import org.mywms.service.EntityNotFoundException;
import org.mywms.service.UniqueConstraintViolatedException;

@Remote
public interface ZoneFacade {
	 List<Zone> getAllZones();
}
