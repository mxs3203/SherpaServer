package com.sherpa.dao;

import com.sherpa.model.Reward;

public interface RewardDao extends GenericDao<Reward> {

	Reward persist(Reward transientInstance);

	void remove(Class<Reward> clazz, long id);

	Reward merge(Reward detachedInstance);

	Reward findById(Class<Reward> clazz, long id);

}
