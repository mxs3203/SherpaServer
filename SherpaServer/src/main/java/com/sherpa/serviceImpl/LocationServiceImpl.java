package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.LocationDao;
import com.sherpa.dto.Location;
import com.sherpa.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;

	@Override
	public void addLocation(Location transientInstance) {
		locationDao.persist(transientInstance);
	}

	@Override
	public void removeLocation(Location persistentInstance) {
		locationDao.remove(persistentInstance);
	}

	@Override
	public Location updateLocation(Location detachedInstance) {
		return locationDao.merge(detachedInstance);
	}

	@Override
	public Location findById(Long id) {
		return locationDao.findById(id);
	}

}
