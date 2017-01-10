package com.sherpa.service;

import com.sherpa.model.Achievement;

public interface AchievementService {

	void add(Achievement transientInstance);

	void remove(long id);

	Achievement update(Achievement detachedInstance);

	Achievement findById(long id);

}
