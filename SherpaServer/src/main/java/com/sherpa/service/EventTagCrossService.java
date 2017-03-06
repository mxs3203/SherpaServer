package com.sherpa.service;

import com.sherpa.model.EventTagCross;

public interface EventTagCrossService {

	EventTagCross add(EventTagCross transientInstance);

	void remove(long id);

	EventTagCross update(EventTagCross detachedInstance);

	EventTagCross findById(long id);

}
