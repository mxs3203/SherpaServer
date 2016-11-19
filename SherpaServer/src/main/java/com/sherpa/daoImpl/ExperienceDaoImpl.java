package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.ExperienceDao;
import com.sherpa.dto.Experience;

/**
 * Home object for domain model class Experience.
 * 
 * @see .Experience
 * @author Hibernate Tools
 */
@Repository
public class ExperienceDaoImpl implements ExperienceDao {

	private static final Log log = LogFactory.getLog(ExperienceDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Experience transientInstance) {
		log.debug("persisting Experience instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Experience persistentInstance) {
		log.debug("removing Experience instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Experience merge(Experience detachedInstance) {
		log.debug("merging Experience instance");
		try {
			Experience result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Experience findById(Long id) {
		log.debug("getting Experience instance with id: " + id);
		try {
			Experience instance = entityManager.find(Experience.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
