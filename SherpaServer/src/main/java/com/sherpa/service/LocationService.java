package com.sherpa.service;

import com.sherpa.model.Location;

public interface LocationService {

	void add(Location transientInstance);

	void remove(long id);

	Location update(Location detachedInstance);

	Location findById(long id);

}
