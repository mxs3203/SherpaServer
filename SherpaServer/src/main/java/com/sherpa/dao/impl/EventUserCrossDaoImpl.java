package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventUserCrossDao;
import com.sherpa.model.EventUserCross;
import com.sherpa.model.EventUserCrossId;

@Repository
public class EventUserCrossDaoImpl extends GenericDaoImpl<EventUserCross> implements EventUserCrossDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(EventUserCross transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(EventUserCross persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public EventUserCross merge(EventUserCross detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public EventUserCross findById(Class<EventUserCross> clazz, EventUserCrossId id) {
		return super.findById(clazz, id.getEventUserId());
	}

}
