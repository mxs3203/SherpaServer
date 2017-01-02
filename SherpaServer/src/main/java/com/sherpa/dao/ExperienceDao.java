package com.sherpa.dao;

import com.sherpa.model.Experience;

public interface ExperienceDao {

	void persist(Experience transientInstance);

	void remove(Experience persistentInstance);

	Experience merge(Experience detachedInstance);

	Experience findById(long id);

}
