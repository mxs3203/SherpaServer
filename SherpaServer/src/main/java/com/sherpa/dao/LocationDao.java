package com.sherpa.dao;


import java.util.List;

import com.sherpa.model.Location;

public interface LocationDao {

	void persist(Location transientInstance);

	void remove(Location persistentInstance);

	Location merge(Location detachedInstance);

	Location findById(long id);

	List<Location> getRegionLocations(String region);

}
