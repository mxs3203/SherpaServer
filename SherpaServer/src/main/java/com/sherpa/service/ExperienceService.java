package com.sherpa.service;

import com.sherpa.dto.Experience;

public interface ExperienceService {

	void addExperience(Experience transientInstance);

	void removeExperience(Experience persistentInstance);

	Experience updateExperience(Experience detachedInstance);

	Experience findById(Long id);

}
