package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.EventTagCrossDao;
import com.sherpa.model.EventTagCross;
import com.sherpa.model.EventTagCrossId;
import com.sherpa.service.EventTagCrossService;

@Service
@Transactional
public class EventTagCrossServiceImpl implements EventTagCrossService {

	@Autowired
	private EventTagCrossDao imageDao;

	@Override
	public void addImage(EventTagCross transientInstance) {
		imageDao.persist(transientInstance);
	}

	@Override
	public void removeImage(EventTagCross persistentInstance) {
		imageDao.remove(persistentInstance);
	}

	@Override
	public EventTagCross updateImage(EventTagCross detachedInstance) {
		return imageDao.merge(detachedInstance);
	}

	@Override
	public EventTagCross findById(EventTagCrossId id) {
		return imageDao.findById(id);
	}

}
