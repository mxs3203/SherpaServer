package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AchievementUserCrossDao;
import com.sherpa.model.AchievementUserCross;
import com.sherpa.model.AchievementUserCrossId;

/**
 * Home object for domain model class AchievementUserCross.
 * 
 * @see .AchievementUserCross
 * @author Hibernate Tools
 */
@Repository
public class AchievementUserCrossDaoImpl implements AchievementUserCrossDao {

	private static final Log log = LogFactory.getLog(AchievementUserCrossDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(AchievementUserCross transientInstance) {
		log.debug("persisting AchievementUserCross instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(AchievementUserCross persistentInstance) {
		log.debug("removing AchievementUserCross instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public AchievementUserCross merge(AchievementUserCross detachedInstance) {
		log.debug("merging AchievementUserCross instance");
		try {
			AchievementUserCross result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AchievementUserCross findById(AchievementUserCrossId id) {
		log.debug("getting AchievementUserCross instance with id: " + id);
		try {
			AchievementUserCross instance = entityManager.find(AchievementUserCross.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
