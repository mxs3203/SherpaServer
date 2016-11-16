package com.sherpa.dao;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.Rating;

/**
 * Home object for domain model class Rating.
 * @see .Rating
 * @author Hibernate Tools
 */
@Stateless
public class RatingHome {

	private static final Log log = LogFactory.getLog(RatingHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Rating transientInstance) {
		log.debug("persisting Rating instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Rating persistentInstance) {
		log.debug("removing Rating instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Rating merge(Rating detachedInstance) {
		log.debug("merging Rating instance");
		try {
			Rating result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rating findById(Integer id) {
		log.debug("getting Rating instance with id: " + id);
		try {
			Rating instance = entityManager.find(Rating.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
