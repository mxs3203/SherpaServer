package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.composite.EventDetailDto;

public interface EventService {

	EventDto add(EventDto transientInstance);

	void remove(long id);

	EventDto update(EventDto detachedInstance);

	EventDto findById(long id);

	Set<EventDto> getEventsByRegion(String region);

	EventDto insertEvent(EventDetailDto edd);

}
