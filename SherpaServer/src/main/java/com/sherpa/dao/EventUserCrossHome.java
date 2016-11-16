package com.sherpa.dao;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.EventUserCross;
import com.sherpa.dto.EventUserCrossId;

/**
 * Home object for domain model class EventUserCross.
 * @see .EventUserCross
 * @author Hibernate Tools
 */
@Stateless
public class EventUserCrossHome {

	private static final Log log = LogFactory.getLog(EventUserCrossHome.class);

	@PersistenceContext
	private EntityManager entityManager;

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
