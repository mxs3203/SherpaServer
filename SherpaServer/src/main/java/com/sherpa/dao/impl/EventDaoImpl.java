package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventDao;
import com.sherpa.model.Event;

@Repository
public class EventDaoImpl extends GenericDaoImpl<Event> implements EventDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Event transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Event persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public Event merge(Event detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Event findById(Class<Event> clazz, long id) {
		return super.findById(clazz, id);
	}

}
