package org.mywms.facade;

import java.util.List;

import javax.ejb.Remote;

import org.mywms.model.Zone;


@Remote
public interface ZoneFacade {
	 List<Zone> getAllZones();
}
