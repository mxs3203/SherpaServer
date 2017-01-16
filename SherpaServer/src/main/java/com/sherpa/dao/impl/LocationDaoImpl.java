package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sherpa.dao.LocationDao;
import com.sherpa.model.Location;

@Repository
public class LocationDaoImpl extends GenericDaoImpl<Location> implements LocationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Location transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Class<Location> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public Location merge(Location detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Location findById(Class<Location> clazz, long id) {
		return super.findById(clazz, id);
	}

}
