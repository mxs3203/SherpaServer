package com.sherpa.dao;

import com.sherpa.model.EventTagCross;
import com.sherpa.model.EventTagCrossId;

public interface EventTagCrossDao {

	void persist(EventTagCross transientInstance);

	void remove(EventTagCross persistentInstance);

	EventTagCross merge(EventTagCross detachedInstance);

	EventTagCross findById(EventTagCrossId id);

}
