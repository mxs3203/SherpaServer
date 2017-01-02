package com.sherpa.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.CurrencyDao;
import com.sherpa.dao.EventDao;
import com.sherpa.dao.LocationDao;
import com.sherpa.dao.UserDao;
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
	public Event findById(long id) {
		return eventDao.findById(id);
	}
	
	/* TODO! refactor za novi objekt */
	@Override
	public List<EventLocationDto> getEventsByRegion(String region){
		
		List<EventLocationDto> events = new ArrayList<EventLocationDto>();
		List<Location> locations = locationDao.getRegionLocations(region);
		
		for(Location loc : locations){
			
			Set<Event> eventsForLoc =  loc.getEventsForStartLocationId();
			Iterator<Event> iter = eventsForLoc.iterator();
			while(iter.hasNext()){
				Event event = (Event) iter.next();
				if(event != null && event.getIsFinished() == false){			
					EventLocationDto eventLocation = new EventLocationDto(event.generateDto(), loc.generateDto());
					events.add(eventLocation);
				}	
			}				
		}	
		return events;
	}
	
	/* TODO! refactor */
	@Override
	public void insertEvent(EventLocationDto eld){
		
		Location location = eld.getLocation().generateEntity();		
		Event event = eld.getEvent().generateEntity();
		
		/* unused? */
		/*List<String> tags = eld.getTags();*/
		
		String currencyIso = eld.getCurrency();
		Currency currency = currencyDao.findByCurrencyIso(currencyIso);
		event.setIsFinished(false);
		event.setCurrency(currency);
		User user = userDao.findById(eld.getEvent().getUserId());
		locationDao.persist(location);
		event.setLocationByStartLocationId(location);
		event.setUser(user);
		eventDao.persist(event);
	}
}
