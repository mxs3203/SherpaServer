package com.sherpa.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.LocationDao;
import com.sherpa.model.Location;
import com.sherpa.util.Util;

@Repository
public class LocationDaoImpl extends GenericDaoImpl<Location> implements LocationDao {

	private static final Logger log = LoggerFactory.getLogger(LocationDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Location transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Location persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public Location merge(Location detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Location findById(Class<Location> clazz, long id) {
		return super.findById(clazz, id);
	}

	@Override
	public Set<Location> getRegionLocations(String region) {
		log.debug("getting Location instances with Region: " + region);
		try {
			Query query = entityManager.createQuery("FROM Location l WHERE l.region = :region").setParameter("region",
					region);
			return Util.castSet(Location.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
