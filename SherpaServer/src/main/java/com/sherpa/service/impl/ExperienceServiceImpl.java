package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ExperienceDao;
import com.sherpa.model.Experience;
import com.sherpa.service.ExperienceService;

@Service
@Transactional
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceDao experienceDao;

	@Override
	public void add(Experience transientInstance) {
		experienceDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		experienceDao.remove(Experience.class, id);
	}

	@Override
	public Experience update(Experience detachedInstance) {
		return experienceDao.merge(detachedInstance);
	}

	@Override
	public Experience findById(long id) {
		return experienceDao.findById(Experience.class, id);
	}

}
