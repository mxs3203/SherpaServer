package com.sherpa.dao;

import com.sherpa.model.Event;

public interface EventDao extends GenericDao<Event> {

	void persist(Event transientInstance);

	void remove(Class<Event> clazz, long id);

	Event merge(Event detachedInstance);

	Event findById(Class<Event> clazz, long id);

}
