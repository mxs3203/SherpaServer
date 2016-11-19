package com.sherpa.service;

import com.sherpa.dto.EventUserCross;
import com.sherpa.dto.EventUserCrossId;

public interface EventUserCrossService {

	void addEventUserCross(EventUserCross transientInstance);

	void removeEventUserCross(EventUserCross persistentInstance);

	EventUserCross updateEventUserCross(EventUserCross detachedInstance);

	EventUserCross findById(EventUserCrossId id);

}
