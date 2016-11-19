package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AchievementDao;
import com.sherpa.dto.Achievement;

/**
 * Home object for domain model class Achievement.
 * 
 * @see .Achievement
 * @author Hibernate Tools
 */
@Repository
public class AchievementDaoImpl implements AchievementDao {

	private static final Log log = LogFactory.getLog(AchievementDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Achievement transientInstance) {
		log.debug("persisting Achievement instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Achievement persistentInstance) {
		log.debug("removing Achievement instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Achievement merge(Achievement detachedInstance) {
		log.debug("merging Achievement instance");
		try {
			Achievement result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Achievement findById(Long id) {
		log.debug("getting Achievement instance with id: " + id);
		try {
			Achievement instance = entityManager.find(Achievement.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
