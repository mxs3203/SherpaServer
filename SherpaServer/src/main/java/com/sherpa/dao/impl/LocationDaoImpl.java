package com.sherpa.dao.impl;

import java.util.List;

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.LocationDao;
import com.sherpa.model.Location;

@Repository
public class LocationDaoImpl implements LocationDao {

	private static final Log log = LogFactory.getLog(LocationDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Location transientInstance) {
		log.debug("persisting Location instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Location persistentInstance) {
		log.debug("removing Location instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Location merge(Location detachedInstance) {
		log.debug("merging Location instance");
		try {
			Location result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Location findById(long id) {
		log.debug("getting Location instance with id: " + id);
		try {
			Location instance = entityManager.find(Location.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getRegionLocations(String region) {

		List<Location> locations;

		try {

			Query query = entityManager.createQuery("FROM Location l WHERE l.region = :region");
			query.setParameter("region", region);

			locations = query.getResultList();

		} catch (NoResultException nre) {
			locations = null;
		}

		return locations;
	}
}
