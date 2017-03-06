package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.LocationDao;
import com.sherpa.dto.LocationDto;
import com.sherpa.model.Location;
import com.sherpa.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;

	@Override
	public LocationDto add(LocationDto transientInstance) {
		return locationDao.persist(transientInstance.toModel()).toDto();
	}

	@Override
	public void remove(long id) {
		locationDao.remove(Location.class, id);
	}

	@Override
	public LocationDto update(LocationDto detachedInstance) {
		return locationDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public LocationDto findById(long id) {
		return locationDao.findById(Location.class, id).toDto();
	}

}
