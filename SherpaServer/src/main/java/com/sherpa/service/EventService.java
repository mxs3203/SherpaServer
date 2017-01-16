package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.composite.EventLocationDto;

public interface EventService {

	void add(EventDto transientInstance);

	void remove(long id);

	EventDto update(EventDto detachedInstance);

	EventDto findById(long id);

	Set<EventLocationDto> getEventsByRegion(String region);

	/* TODO! ovo nevalja */
	void insertEvent(EventLocationDto eld);

}
