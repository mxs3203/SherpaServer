package com.sherpa.dao;

import com.sherpa.model.EventTagCross;

public interface EventTagCrossDao extends GenericDao<EventTagCross> {

	void persist(EventTagCross transientInstance);

	void remove(Class<EventTagCross> clazz, long id);

	EventTagCross merge(EventTagCross detachedInstance);

	EventTagCross findById(Class<EventTagCross> clazz, long id);

}
