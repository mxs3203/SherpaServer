package com.sherpa.dao;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.Location;

/**
 * Home object for domain model class Location.
 * @see .Location
 * @author Hibernate Tools
 */
@Stateless
public class LocationHome {

	private static final Log log = LogFactory.getLog(LocationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

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

	public Location findById(Integer id) {
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
}
