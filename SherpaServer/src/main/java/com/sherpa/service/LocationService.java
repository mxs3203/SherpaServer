package com.sherpa.service;

import com.sherpa.dto.Location;

public interface LocationService {

	void addLocation(Location transientInstance);

	void removeLocation(Location persistentInstance);

	Location updateLocation(Location detachedInstance);

	Location findById(Long id);

}
