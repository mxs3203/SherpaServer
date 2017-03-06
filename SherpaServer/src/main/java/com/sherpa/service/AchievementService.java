package com.sherpa.service;

import com.sherpa.dto.AchievementDto;

public interface AchievementService {

	AchievementDto add(AchievementDto transientInstance);

	void remove(long id);

	AchievementDto update(AchievementDto detachedInstance);

	AchievementDto findById(long id);

}
