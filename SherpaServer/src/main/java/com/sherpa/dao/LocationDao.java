package com.sherpa.dao;

import com.sherpa.dto.Location;

public interface LocationDao {

	void persist(Location transientInstance);

	void remove(Location persistentInstance);

	Location merge(Location detachedInstance);

	Location findById(Long id);

}
