package com.sherpa.dao.impl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventDao;
import com.sherpa.model.Event;

/**
 * Home object for domain model class Event.
 * 
 * @see .Event
 * @author Hibernate Tools
 */
@Repository
public class EventDaoImpl implements EventDao {

	private static final Log log = LogFactory.getLog(EventDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
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

	@Override
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

	@Override
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

	@Override
	public Event findById(long id) {
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
