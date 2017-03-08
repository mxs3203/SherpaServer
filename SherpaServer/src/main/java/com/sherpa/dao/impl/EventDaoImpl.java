package com.sherpa.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventDao;
import com.sherpa.model.Event;
import com.sherpa.util.Util;

@Repository
public class EventDaoImpl extends GenericDaoImpl<Event> implements EventDao {

	private static final Logger log = LoggerFactory.getLogger(EventDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Event persist(Event transientInstance) {
		return super.persist(transientInstance);
	}

	@Override
	public void remove(Class<Event> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public Event merge(Event detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Event findById(Class<Event> clazz, long id) {
		return super.findById(clazz, id);
	}

	@Override
	public Set<Event> getByRegion(String region) {
		log.debug("getting Event instances with their Locations by Region: '{}'", region);
		try {
			Query query = entityManager
					.createQuery("SELECT l.eventsForStartLocationId FROM Location l WHERE l.region = :region")
					.setParameter("region", region);
			log.debug("get successful");
			return Util.castSet(Event.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
