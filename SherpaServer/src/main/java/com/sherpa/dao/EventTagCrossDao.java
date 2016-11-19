package com.sherpa.dao;

import com.sherpa.dto.EventTagCross;
import com.sherpa.dto.EventTagCrossId;

public interface EventTagCrossDao {

	void persist(EventTagCross transientInstance);

	void remove(EventTagCross persistentInstance);

	EventTagCross merge(EventTagCross detachedInstance);

	EventTagCross findById(EventTagCrossId id);

}
