package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.RewardDao;
import com.sherpa.dto.RewardDto;
import com.sherpa.model.Reward;
import com.sherpa.service.RewardService;

@Service
@Transactional
public class RewardServiceImpl implements RewardService {

	@Autowired
	private RewardDao rewardDao;

	@Override
	public void add(RewardDto transientInstance) {
		rewardDao.persist(transientInstance.toModel());
	}

	@Override
	public void remove(long id) {
		rewardDao.remove(Reward.class, id);
	}

	@Override
	public RewardDto update(RewardDto detachedInstance) {
		return rewardDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public RewardDto findById(long id) {
		return rewardDao.findById(Reward.class, id).toDto();
	}

}
