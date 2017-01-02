package com.sherpa.service;

import com.sherpa.model.AchievementUserCross;
import com.sherpa.model.AchievementUserCrossId;

public interface AchievementUserCrossService {

	void addAchievementUserCross(AchievementUserCross transientInstance);

	void removeAchievementUserCross(AchievementUserCross persistentInstance);

	AchievementUserCross updateAchievementUserCross(AchievementUserCross detachedInstance);

	AchievementUserCross findById(AchievementUserCrossId id);

}
