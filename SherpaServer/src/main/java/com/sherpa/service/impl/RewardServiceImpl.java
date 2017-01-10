package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.RewardDao;
import com.sherpa.model.Reward;
import com.sherpa.service.RewardService;

@Service
@Transactional
public class RewardServiceImpl implements RewardService {

	@Autowired
	private RewardDao rewardDao;

	@Override
	public void add(Reward transientInstance) {
		rewardDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		rewardDao.remove(Reward.class, id);
	}

	@Override
	public Reward update(Reward detachedInstance) {
		return rewardDao.merge(detachedInstance);
	}

	@Override
	public Reward findById(long id) {
		return rewardDao.findById(Reward.class, id);
	}

}
