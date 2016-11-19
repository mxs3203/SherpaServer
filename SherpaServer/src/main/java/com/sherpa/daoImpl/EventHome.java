package com.sherpa.daoImpl;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.Event;

/**
 * Home object for domain model class Event.
 * @see .Event
 * @author Hibernate Tools
 */
@Stateless
public class EventHome {

	private static final Log log = LogFactory.getLog(EventHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Event transientInstance) {
		log.debug("persisting Event instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Event persistentInstance) {
		log.debug("removing Event instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Event merge(Event detachedInstance) {
		log.debug("merging Event instance");
		try {
			Event result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Event findById(Integer id) {
		log.debug("getting Event instance with id: " + id);
		try {
			Event instance = entityManager.find(Event.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
