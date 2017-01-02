package com.sherpa.service;

import java.util.List;

import com.sherpa.dto.EventLocationDto;
import com.sherpa.model.Event;

public interface EventService {

	void addEvent(Event transientInstance);

	void removeEvent(Event persistentInstance);

	Event updateEvent(Event detachedInstance);

	Event findById(long id);

	List<EventLocationDto> getEventsByRegion(String region);

	void insertEvent(EventLocationDto eld);

}
