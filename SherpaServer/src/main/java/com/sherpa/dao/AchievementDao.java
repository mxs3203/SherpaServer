package com.sherpa.dao;

import com.sherpa.model.Achievement;

public interface AchievementDao {

	void persist(Achievement transientInstance);

	void remove(Achievement persistentInstance);

	Achievement merge(Achievement detachedInstance);

	Achievement findById(long id);

}
