package com.sherpa.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.CurrencyDao;
import com.sherpa.dao.EventDao;
import com.sherpa.dao.LocationDao;
import com.sherpa.dao.UserDao;
import com.sherpa.dto.EventDto;
import com.sherpa.dto.EventLocationDto;
import com.sherpa.model.Currency;
import com.sherpa.model.Event;
import com.sherpa.model.Location;
import com.sherpa.model.User;
import com.sherpa.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Autowired
	private LocationDao locationDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CurrencyDao currencyDao;

	@Override
	public void add(Event transientInstance) {
		eventDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		eventDao.remove(Event.class, id);
	}

	@Override
	public EventDto update(Event detachedInstance) {
		return eventDao.merge(detachedInstance).toDto();
	}

	@Override
	public EventDto findById(long id) {
		return eventDao.findById(Event.class, id).toDto();
	}

	/* TODO! refactor za novi objekt */
	@Override
	public Set<EventLocationDto> getEventsByRegion(String region) {

		Set<EventLocationDto> events = new HashSet<EventLocationDto>();
		Set<Location> locations = locationDao.getByRegion(region);

		for (Location loc : locations) {

			Set<Event> eventsForLoc = loc.getEventsForStartLocationId();
			Iterator<Event> iter = eventsForLoc.iterator();

			/* TODO! */
			while (iter.hasNext()) {
				Event event = (Event) iter.next();
				if (event != null && event.getIsFinished() == false) {
					EventLocationDto eventLocation = new EventLocationDto();

					eventLocation.setEvent(event.toDto());
					eventLocation.setLocation(loc.toDto());

					events.add(eventLocation);
				}
			}
		}
		return events;
	}

	/* TODO! refactor */
	@Override
	public void insertEvent(EventLocationDto eld) {

		/* TODO! */
		Location location = eld.getLocation().toModel();
		Event event = eld.getEvent().toModel();

		Currency currency = currencyDao.findByCurrencyIso(eld.getCurrency());
		event.setCurrency(currency);

		event.setIsFinished(false);

		User user = userDao.findById(User.class, eld.getEvent().getUserId());

		locationDao.persist(location);

		event.setLocationByStartLocationId(location);
		event.setUser(user);

		eventDao.persist(event);
	}

}
