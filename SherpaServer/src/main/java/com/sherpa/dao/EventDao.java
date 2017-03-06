package com.sherpa.dao;

import java.util.Set;

import com.sherpa.model.Event;

public interface EventDao extends GenericDao<Event> {

	Event persist(Event transientInstance);

	void remove(Class<Event> clazz, long id);

	Event merge(Event detachedInstance);

	Event findById(Class<Event> clazz, long id);

	Set<Event> getByRegion(String region);

}
