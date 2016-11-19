package com.sherpa.dao;

import com.sherpa.dto.AchievementUserCross;
import com.sherpa.dto.AchievementUserCrossId;

public interface AchievementUserCrossDao {

	void persist(AchievementUserCross transientInstance);

	void remove(AchievementUserCross persistentInstance);

	AchievementUserCross merge(AchievementUserCross detachedInstance);

	AchievementUserCross findById(AchievementUserCrossId id);

}
