package com.sherpa.dao;

import com.sherpa.model.AchievementUserCross;
import com.sherpa.model.AchievementUserCrossId;

public interface AchievementUserCrossDao extends GenericDao<AchievementUserCross> {

	void persist(AchievementUserCross transientInstance);

	void remove(AchievementUserCross persistentInstance);

	AchievementUserCross merge(AchievementUserCross detachedInstance);

	AchievementUserCross findById(Class<AchievementUserCross> clazz, AchievementUserCrossId id);

}
