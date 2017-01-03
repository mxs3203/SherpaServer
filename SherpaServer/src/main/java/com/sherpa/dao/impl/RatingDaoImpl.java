package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.RatingDao;
import com.sherpa.model.Rating;

@Repository
public class RatingDaoImpl implements RatingDao {

	private static final Log log = LogFactory.getLog(RatingDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
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

	@Override
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

	@Override
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

	@Override
	public Rating findById(long id) {
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
