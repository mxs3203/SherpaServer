package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ExperienceDao;
import com.sherpa.dto.ExperienceDto;
import com.sherpa.model.Experience;
import com.sherpa.service.ExperienceService;

@Service
@Transactional
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceDao experienceDao;

	@Override
	public void add(ExperienceDto transientInstance) {
		experienceDao.persist(transientInstance.toModel());
	}

	@Override
	public void remove(long id) {
		experienceDao.remove(Experience.class, id);
	}

	@Override
	public ExperienceDto update(ExperienceDto detachedInstance) {
		return experienceDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public ExperienceDto findById(long id) {
		return experienceDao.findById(Experience.class, id).toDto();
	}

}
