package com.sherpa.dao;

import com.sherpa.dto.Reward;

public interface RewardDao {

	void persist(Reward transientInstance);

	void remove(Reward persistentInstance);

	Reward merge(Reward detachedInstance);

	Reward findById(Long id);

}
