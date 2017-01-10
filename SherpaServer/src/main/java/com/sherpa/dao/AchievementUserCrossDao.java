package com.sherpa.dao;

import com.sherpa.model.AchievementUserCross;

public interface AchievementUserCrossDao extends GenericDao<AchievementUserCross> {

	void persist(AchievementUserCross transientInstance);

	void remove(Class<AchievementUserCross> clazz, long id);

	AchievementUserCross merge(AchievementUserCross detachedInstance);

	AchievementUserCross findById(Class<AchievementUserCross> clazz, long id);

}
