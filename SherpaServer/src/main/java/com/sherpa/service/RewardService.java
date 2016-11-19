package com.sherpa.service;

import com.sherpa.dto.Reward;

public interface RewardService {

	void addReward(Reward transientInstance);

	void removeReward(Reward persistentInstance);

	Reward updateReward(Reward detachedInstance);

	Reward findById(Long id);

}
