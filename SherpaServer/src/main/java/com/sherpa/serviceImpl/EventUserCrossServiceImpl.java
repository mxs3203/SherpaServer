package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.EventUserCrossDao;
import com.sherpa.dto.EventUserCross;
import com.sherpa.dto.EventUserCrossId;
import com.sherpa.service.EventUserCrossService;

@Service
@Transactional
public class EventUserCrossServiceImpl implements EventUserCrossService {

	@Autowired
	private EventUserCrossDao eventUserCrossDao;

	@Override
	public void addEventUserCross(EventUserCross transientInstance) {
		eventUserCrossDao.persist(transientInstance);
	}

	@Override
	public void removeEventUserCross(EventUserCross persistentInstance) {
		eventUserCrossDao.remove(persistentInstance);
	}

	@Override
	public EventUserCross updateEventUserCross(EventUserCross detachedInstance) {
		return eventUserCrossDao.merge(detachedInstance);
	}

	@Override
	public EventUserCross findById(EventUserCrossId id) {
		return eventUserCrossDao.findById(id);
	}

}
