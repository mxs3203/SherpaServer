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
	private EventTagCrossDao eventTagCrossDao;

	@Override
	public EventTagCross add(EventTagCross transientInstance) {
		return eventTagCrossDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		eventTagCrossDao.remove(EventTagCross.class, id);
	}

	@Override
	public EventTagCross update(EventTagCross detachedInstance) {
		return eventTagCrossDao.merge(detachedInstance);
	}

	@Override
	public EventTagCross findById(long id) {
		return eventTagCrossDao.findById(EventTagCross.class, id);
	}

}
