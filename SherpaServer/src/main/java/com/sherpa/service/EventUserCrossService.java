package com.sherpa.service;

import com.sherpa.model.EventUserCross;
import com.sherpa.model.EventUserCrossId;

public interface EventUserCrossService {

	void addEventUserCross(EventUserCross transientInstance);

	void removeEventUserCross(EventUserCross persistentInstance);

	EventUserCross updateEventUserCross(EventUserCross detachedInstance);

	EventUserCross findById(EventUserCrossId id);

}
