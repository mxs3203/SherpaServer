package com.sherpa.service;

import com.sherpa.model.Reward;

public interface RewardService {

	void add(Reward transientInstance);

	void remove(long id);

	Reward update(Reward detachedInstance);

	Reward findById(long id);

}
