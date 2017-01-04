package com.sherpa.dao;

import com.sherpa.model.Achievement;

public interface AchievementDao extends GenericDao<Achievement> {

	void persist(Achievement transientInstance);

	void remove(Achievement persistentInstance);

	Achievement merge(Achievement detachedInstance);

	Achievement findById(Class<Achievement> clazz, long id);

}
