package com.sherpa.dao;

import java.util.Set;

import com.sherpa.model.Location;

public interface LocationDao extends GenericDao<Location> {

	void persist(Location transientInstance);

	void remove(Class<Location> clazz, long id);

	Location merge(Location detachedInstance);

	Location findById(Class<Location> clazz, long id);

	Set<Location> getRegionLocations(String region);

}
