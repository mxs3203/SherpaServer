package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.AchievementUserCrossDao;
import com.sherpa.model.AchievementUserCross;
import com.sherpa.model.AchievementUserCrossId;
import com.sherpa.service.AchievementUserCrossService;

@Service
@Transactional
public class AchievementUserCrossServiceImpl implements AchievementUserCrossService {

	@Autowired
	private AchievementUserCrossDao achievementUserCrossDao;

	@Override
	public void addAchievementUserCross(AchievementUserCross transientInstance) {
		achievementUserCrossDao.persist(transientInstance);
	}

	@Override
	public void removeAchievementUserCross(AchievementUserCross persistentInstance) {
		achievementUserCrossDao.remove(persistentInstance);
	}

	@Override
	public AchievementUserCross updateAchievementUserCross(AchievementUserCross detachedInstance) {
		return achievementUserCrossDao.merge(detachedInstance);
	}

	@Override
	public AchievementUserCross findById(AchievementUserCrossId id) {
		return achievementUserCrossDao.findById(id);
	}

}
