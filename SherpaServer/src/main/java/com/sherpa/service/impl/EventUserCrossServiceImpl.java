package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.EventUserCrossDao;
import com.sherpa.model.EventUserCross;
import com.sherpa.service.EventUserCrossService;

@Service
@Transactional
public class EventUserCrossServiceImpl implements EventUserCrossService {

	@Autowired
	private EventUserCrossDao eventUserCrossDao;

	@Override
	public EventUserCross add(EventUserCross transientInstance) {
		return eventUserCrossDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		eventUserCrossDao.remove(EventUserCross.class, id);
	}

	@Override
	public EventUserCross update(EventUserCross detachedInstance) {
		return eventUserCrossDao.merge(detachedInstance);
	}

	@Override
	public EventUserCross findById(long id) {
		return eventUserCrossDao.findById(EventUserCross.class, id);
	}

}
