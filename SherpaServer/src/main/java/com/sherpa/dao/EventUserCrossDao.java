package com.sherpa.dao;

import com.sherpa.model.EventUserCross;

public interface EventUserCrossDao extends GenericDao<EventUserCross> {

	EventUserCross persist(EventUserCross transientInstance);

	void remove(Class<EventUserCross> clazz, long id);

	EventUserCross merge(EventUserCross detachedInstance);

	EventUserCross findById(Class<EventUserCross> clazz, long id);

}
