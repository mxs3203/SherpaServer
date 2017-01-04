package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventLocationDto;
import com.sherpa.model.Event;

public interface EventService {

	void addEvent(Event transientInstance);

	void removeEvent(Event persistentInstance);

	Event updateEvent(Event detachedInstance);

	Event findById(long id);

	Set<EventLocationDto> getEventsByRegion(String region);

	void insertEvent(EventLocationDto eld);

}
