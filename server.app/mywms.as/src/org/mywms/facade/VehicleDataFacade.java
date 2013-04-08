package org.mywms.facade;

import java.util.List;
import javax.ejb.Remote;
import org.mywms.model.VehicleData;


@Remote
public interface VehicleDataFacade {
	List<VehicleData> getAllVehicles();
}
