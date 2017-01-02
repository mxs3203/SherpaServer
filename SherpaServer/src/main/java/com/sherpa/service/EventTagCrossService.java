package com.sherpa.service;

import com.sherpa.model.EventTagCross;
import com.sherpa.model.EventTagCrossId;

public interface EventTagCrossService {

	void addImage(EventTagCross transientInstance);

	void removeImage(EventTagCross persistentInstance);

	EventTagCross updateImage(EventTagCross detachedInstance);

	EventTagCross findById(EventTagCrossId id);

}
