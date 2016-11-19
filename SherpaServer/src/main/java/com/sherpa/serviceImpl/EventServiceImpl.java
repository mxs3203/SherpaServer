package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.EventDao;
import com.sherpa.dto.Event;
import com.sherpa.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public void addEvent(Event transientInstance) {
		eventDao.persist(transientInstance);
	}

	@Override
	public void removeEvent(Event persistentInstance) {
		eventDao.remove(persistentInstance);
	}

	@Override
	public Event updateEvent(Event detachedInstance) {
		return eventDao.merge(detachedInstance);
	}

	@Override
	public Event findById(Long id) {
		return eventDao.findById(id);
	}

}
