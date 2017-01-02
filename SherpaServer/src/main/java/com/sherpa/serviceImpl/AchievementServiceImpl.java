package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.AchievementDao;
import com.sherpa.model.Achievement;
import com.sherpa.service.AchievementService;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService {

	@Autowired
	private AchievementDao achievementDao;

	@Override
	public void addAchievement(Achievement transientInstance) {
		achievementDao.persist(transientInstance);
	}

	@Override
	public void removeAchievement(Achievement persistentInstance) {
		achievementDao.remove(persistentInstance);
	}

	@Override
	public Achievement updateAchievement(Achievement detachedInstance) {
		return achievementDao.merge(detachedInstance);
	}

	@Override
	public Achievement findById(long id) {
		return achievementDao.findById(id);
	}

}
