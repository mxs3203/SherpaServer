package com.sherpa.dao;

import com.sherpa.model.AchievementUserCross;
import com.sherpa.model.AchievementUserCrossId;

public interface AchievementUserCrossDao {

	void persist(AchievementUserCross transientInstance);

	void remove(AchievementUserCross persistentInstance);

	AchievementUserCross merge(AchievementUserCross detachedInstance);

	AchievementUserCross findById(AchievementUserCrossId id);

}
