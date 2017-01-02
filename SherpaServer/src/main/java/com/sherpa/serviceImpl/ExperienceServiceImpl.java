package com.sherpa.serviceImpl;

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
	public void addExperience(Experience transientInstance) {
		experienceDao.persist(transientInstance);
	}

	@Override
	public void removeExperience(Experience persistentInstance) {
		experienceDao.remove(persistentInstance);
	}

	@Override
	public Experience updateExperience(Experience detachedInstance) {
		return experienceDao.merge(detachedInstance);
	}

	@Override
	public Experience findById(long id) {
		return experienceDao.findById(id);
	}

}