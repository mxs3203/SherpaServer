package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.EventLocationDto;
import com.sherpa.model.Event;

public interface EventService {

	void add(Event transientInstance);

	void remove(long id);

	EventDto update(Event detachedInstance);

	EventDto findById(long id);

	Set<EventLocationDto> getEventsByRegion(String region);

	/* TODO! ovo nevalja */
	void insertEvent(EventLocationDto eld);

}
