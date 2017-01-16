package com.sherpa.service;

import com.sherpa.dto.ExperienceDto;

public interface ExperienceService {

	void add(ExperienceDto transientInstance);

	void remove(long id);

	ExperienceDto update(ExperienceDto detachedInstance);

	ExperienceDto findById(long id);

}
