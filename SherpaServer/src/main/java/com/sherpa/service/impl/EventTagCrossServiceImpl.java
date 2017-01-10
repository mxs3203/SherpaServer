package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.EventTagCrossDao;
import com.sherpa.model.EventTagCross;
import com.sherpa.service.EventTagCrossService;

@Service
@Transactional
public class EventTagCrossServiceImpl implements EventTagCrossService {

	@Autowired
	private EventTagCrossDao imageDao;

	@Override
	public void add(EventTagCross transientInstance) {
		imageDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		imageDao.remove(EventTagCross.class, id);
	}

	@Override
	public EventTagCross update(EventTagCross detachedInstance) {
		return imageDao.merge(detachedInstance);
	}

	@Override
	public EventTagCross findById(long id) {
		return imageDao.findById(EventTagCross.class, id);
	}

}
