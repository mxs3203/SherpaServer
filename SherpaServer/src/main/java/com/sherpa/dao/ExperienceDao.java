package com.sherpa.dao;

import com.sherpa.model.Experience;

public interface ExperienceDao extends GenericDao<Experience> {

	Experience persist(Experience transientInstance);

	void remove(Class<Experience> clazz, long id);

	Experience merge(Experience detachedInstance);

	Experience findById(Class<Experience> clazz, long id);

}
