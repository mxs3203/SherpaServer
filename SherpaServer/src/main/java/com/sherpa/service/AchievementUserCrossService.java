package com.sherpa.service;

import com.sherpa.dto.AchievementUserCross;
import com.sherpa.dto.AchievementUserCrossId;

public interface AchievementUserCrossService {

	void addAchievementUserCross(AchievementUserCross transientInstance);

	void removeAchievementUserCross(AchievementUserCross persistentInstance);

	AchievementUserCross updateAchievementUserCross(AchievementUserCross detachedInstance);

	AchievementUserCross findById(AchievementUserCrossId id);

}
