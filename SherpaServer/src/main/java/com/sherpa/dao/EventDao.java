package com.sherpa.dao;

import com.sherpa.model.Event;

public interface EventDao {

	void persist(Event transientInstance);

	void remove(Event persistentInstance);

	Event merge(Event detachedInstance);

	Event findById(long id);

}
