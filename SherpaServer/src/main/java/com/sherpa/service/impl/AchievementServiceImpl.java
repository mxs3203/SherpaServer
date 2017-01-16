package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.AchievementDao;
import com.sherpa.dto.AchievementDto;
import com.sherpa.model.Achievement;
import com.sherpa.service.AchievementService;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService {

	@Autowired
	private AchievementDao achievementDao;

	@Override
	public void add(AchievementDto transientInstance) {
		achievementDao.persist(transientInstance.toModel());
	}

	@Override
	public void remove(long id) {
		achievementDao.remove(Achievement.class, id);
	}

	@Override
	public AchievementDto update(AchievementDto detachedInstance) {
		return achievementDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public AchievementDto findById(long id) {
		return achievementDao.findById(Achievement.class, id).toDto();
	}

}
