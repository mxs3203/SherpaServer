package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventLocationDto;
import com.sherpa.model.Event;

public interface EventService {

	void add(Event transientInstance);

	void remove(long id);

	Event update(Event detachedInstance);

	Event findById(long id);

	Set<EventLocationDto> getEventsByRegion(String region);

	void insertEvent(EventLocationDto eld);

}
