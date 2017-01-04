package com.sherpa.dao;

import com.sherpa.model.Event;

public interface EventDao extends GenericDao<Event> {

	void persist(Event transientInstance);

	void remove(Event persistentInstance);

	Event merge(Event detachedInstance);

	Event findById(Class<Event> clazz, long id);

}
