package com.sherpa.dao;

import com.sherpa.model.Location;

public interface LocationDao extends GenericDao<Location> {

	Location persist(Location transientInstance);

	void remove(Class<Location> clazz, long id);

	Location merge(Location detachedInstance);

	Location findById(Class<Location> clazz, long id);

}
