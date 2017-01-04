package com.sherpa.dao;

import com.sherpa.model.EventUserCross;
import com.sherpa.model.EventUserCrossId;

public interface EventUserCrossDao extends GenericDao<EventUserCross> {

	void persist(EventUserCross transientInstance);

	void remove(EventUserCross persistentInstance);

	EventUserCross merge(EventUserCross detachedInstance);

	EventUserCross findById(Class<EventUserCross> clazz, EventUserCrossId id);

}
