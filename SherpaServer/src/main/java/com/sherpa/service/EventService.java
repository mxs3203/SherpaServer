package com.sherpa.service;

import com.sherpa.dto.Event;

public interface EventService {

	void addEvent(Event transientInstance);

	void removeEvent(Event persistentInstance);

	Event updateEvent(Event detachedInstance);

	Event findById(Long id);

}
