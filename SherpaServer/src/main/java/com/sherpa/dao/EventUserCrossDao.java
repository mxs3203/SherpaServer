package com.sherpa.dao;

import com.sherpa.dto.EventUserCross;
import com.sherpa.dto.EventUserCrossId;

public interface EventUserCrossDao {

	void persist(EventUserCross transientInstance);

	void remove(EventUserCross persistentInstance);

	EventUserCross merge(EventUserCross detachedInstance);

	EventUserCross findById(EventUserCrossId id);

}
