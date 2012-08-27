package org.mywms.service;

import javax.ejb.Remote;

import org.mywms.model.VehicleData;

@Remote
public interface VehicleDataServiceRemote{

	public VehicleData getByLabelId(String labelId);
}
