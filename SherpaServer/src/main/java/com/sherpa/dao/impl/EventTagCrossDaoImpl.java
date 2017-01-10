package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventTagCrossDao;
import com.sherpa.model.EventTagCross;

@Repository
public class EventTagCrossDaoImpl extends GenericDaoImpl<EventTagCross> implements EventTagCrossDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(EventTagCross transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Class<EventTagCross> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public EventTagCross merge(EventTagCross detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public EventTagCross findById(Class<EventTagCross> clazz, long id) {
		return super.findById(clazz, id);
	}

}
