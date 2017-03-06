package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventUserCrossDao;
import com.sherpa.model.EventUserCross;

@Repository
public class EventUserCrossDaoImpl extends GenericDaoImpl<EventUserCross> implements EventUserCrossDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EventUserCross persist(EventUserCross transientInstance) {
		return super.persist(transientInstance);
	}

	@Override
	public void remove(Class<EventUserCross> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public EventUserCross merge(EventUserCross detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public EventUserCross findById(Class<EventUserCross> clazz, long id) {
		return super.findById(clazz, id);
	}

}
