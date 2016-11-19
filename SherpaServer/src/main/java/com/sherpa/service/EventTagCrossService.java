package com.sherpa.service;

import com.sherpa.dto.EventTagCross;
import com.sherpa.dto.EventTagCrossId;

public interface EventTagCrossService {

	void addImage(EventTagCross transientInstance);

	void removeImage(EventTagCross persistentInstance);

	EventTagCross updateImage(EventTagCross detachedInstance);

	EventTagCross findById(EventTagCrossId id);

}
