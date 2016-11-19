package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.RewardDao;
import com.sherpa.dto.Reward;
import com.sherpa.service.RewardService;

@Service
@Transactional
public class RewardServiceImpl implements RewardService {

	@Autowired
    private RewardDao rewardDao;

	@Override
	public void addReward(Reward transientInstance) {
		rewardDao.persist(transientInstance);
	}
	
	@Override
	public void removeReward(Reward persistentInstance) {
		rewardDao.remove(persistentInstance);
	}
	
	@Override
	public Reward updateReward(Reward detachedInstance) {
		return rewardDao.merge(detachedInstance);
	}
	
	@Override
	public Reward findById(Long id) {
		return rewardDao.findById(id);
	}
	
}
