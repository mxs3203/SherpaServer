package com.sherpa.dao;

import com.sherpa.model.Achievement;

public interface AchievementDao extends GenericDao<Achievement> {

	Achievement persist(Achievement transientInstance);

	void remove(Class<Achievement> clazz, long id);

	Achievement merge(Achievement detachedInstance);

	Achievement findById(Class<Achievement> clazz, long id);

}
