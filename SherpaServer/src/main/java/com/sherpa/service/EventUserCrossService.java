package com.sherpa.service;

import com.sherpa.model.EventUserCross;

public interface EventUserCrossService {

	void add(EventUserCross transientInstance);

	void remove(long id);

	EventUserCross update(EventUserCross detachedInstance);

	EventUserCross findById(long id);

}
