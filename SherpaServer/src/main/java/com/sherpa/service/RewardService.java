package com.sherpa.service;

import com.sherpa.model.Reward;

public interface RewardService {

	void addReward(Reward transientInstance);

	void removeReward(Reward persistentInstance);

	Reward updateReward(Reward detachedInstance);

	Reward findById(long id);

}
