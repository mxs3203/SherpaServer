package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.AchievementUserCrossDao;
import com.sherpa.model.AchievementUserCross;
import com.sherpa.service.AchievementUserCrossService;

@Service
@Transactional
public class AchievementUserCrossServiceImpl implements AchievementUserCrossService {

	@Autowired
	private AchievementUserCrossDao achievementUserCrossDao;

	@Override
	public AchievementUserCross add(AchievementUserCross transientInstance) {
		return achievementUserCrossDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		achievementUserCrossDao.remove(AchievementUserCross.class, id);
	}

	@Override
	public AchievementUserCross update(AchievementUserCross detachedInstance) {
		return achievementUserCrossDao.merge(detachedInstance);
	}

	@Override
	public AchievementUserCross findById(long id) {
		return achievementUserCrossDao.findById(AchievementUserCross.class, id);
	}

}
