package com.sherpa.dao;

import com.sherpa.model.EventTagCross;
import com.sherpa.model.EventTagCrossId;

public interface EventTagCrossDao extends GenericDao<EventTagCross> {

	void persist(EventTagCross transientInstance);

	void remove(EventTagCross persistentInstance);

	EventTagCross merge(EventTagCross detachedInstance);

	EventTagCross findById(Class<EventTagCross> clazz, EventTagCrossId id);

}
