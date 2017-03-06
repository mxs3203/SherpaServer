package com.sherpa.service;

import com.sherpa.dto.LocationDto;

public interface LocationService {

	LocationDto add(LocationDto transientInstance);

	void remove(long id);

	LocationDto update(LocationDto detachedInstance);

	LocationDto findById(long id);

}
