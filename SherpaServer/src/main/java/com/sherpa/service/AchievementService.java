package com.sherpa.service;

import com.sherpa.dto.Achievement;

public interface AchievementService {

	void addAchievement(Achievement transientInstance);

	void removeAchievement(Achievement persistentInstance);

	Achievement updateAchievement(Achievement detachedInstance);

	Achievement findById(Long id);

}
