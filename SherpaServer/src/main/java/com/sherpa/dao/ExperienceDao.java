package com.sherpa.dao;

import com.sherpa.model.Experience;

public interface ExperienceDao extends GenericDao<Experience> {

	void persist(Experience transientInstance);

	void remove(Experience persistentInstance);

	Experience merge(Experience detachedInstance);

	Experience findById(Class<Experience> clazz, long id);

}
