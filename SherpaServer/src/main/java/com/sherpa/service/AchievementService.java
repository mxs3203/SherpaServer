package com.sherpa.service;

import com.sherpa.model.Achievement;

public interface AchievementService {

	void addAchievement(Achievement transientInstance);

	void removeAchievement(Achievement persistentInstance);

	Achievement updateAchievement(Achievement detachedInstance);

	Achievement findById(long id);

}
