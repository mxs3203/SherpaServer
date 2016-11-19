package com.sherpa.daoImpl;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.Achievement;

/**
 * Home object for domain model class Achievement.
 * @see .Achievement
 * @author Hibernate Tools
 */
@Stateless
public class AchievementHome {

	private static final Log log = LogFactory.getLog(AchievementHome.class);

	@PersistenceContext
	private EntityManager entityManager;

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

	public Achievement findById(Integer id) {
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
