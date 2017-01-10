package com.sherpa.service;

import com.sherpa.model.AchievementUserCross;

public interface AchievementUserCrossService {

	void add(AchievementUserCross transientInstance);

	void remove(long id);

	AchievementUserCross update(AchievementUserCross detachedInstance);

	AchievementUserCross findById(long id);

}
