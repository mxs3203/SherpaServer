package com.sherpa.dao;

import com.sherpa.dto.Event;

public interface EventDao {

	void persist(Event transientInstance);

	void remove(Event persistentInstance);

	Event merge(Event detachedInstance);

	Event findById(Long id);

}
