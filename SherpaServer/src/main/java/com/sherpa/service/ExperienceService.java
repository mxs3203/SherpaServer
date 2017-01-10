package com.sherpa.service;

import com.sherpa.model.Experience;

public interface ExperienceService {

	void add(Experience transientInstance);

	void remove(long id);

	Experience update(Experience detachedInstance);

	Experience findById(long id);

}
