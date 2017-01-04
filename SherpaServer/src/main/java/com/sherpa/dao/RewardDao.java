package com.sherpa.dao;

import com.sherpa.model.Reward;

public interface RewardDao extends GenericDao<Reward> {

	void persist(Reward transientInstance);

	void remove(Reward persistentInstance);

	Reward merge(Reward detachedInstance);

	Reward findById(Class<Reward> clazz, long id);

}
