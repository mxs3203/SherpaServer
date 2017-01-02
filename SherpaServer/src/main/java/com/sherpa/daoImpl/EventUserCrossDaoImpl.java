package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventUserCrossDao;
import com.sherpa.model.EventUserCross;
import com.sherpa.model.EventUserCrossId;

/**
 * Home object for domain model class EventUserCross.
 * 
 * @see .EventUserCross
 * @author Hibernate Tools
 */
@Repository
public class EventUserCrossDaoImpl implements EventUserCrossDao {

	private static final Log log = LogFactory.getLog(EventUserCrossDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(EventUserCross transientInstance) {
		log.debug("persisting EventUserCross instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(EventUserCross persistentInstance) {
		log.debug("removing EventUserCross instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public EventUserCross merge(EventUserCross detachedInstance) {
		log.debug("merging EventUserCross instance");
		try {
			EventUserCross result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public EventUserCross findById(EventUserCrossId id) {
		log.debug("getting EventUserCross instance with id: " + id);
		try {
			EventUserCross instance = entityManager.find(EventUserCross.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
