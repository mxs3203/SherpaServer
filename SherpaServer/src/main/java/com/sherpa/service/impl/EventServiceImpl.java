package com.sherpa.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.EventDao;
import com.sherpa.dao.LocationDao;
import com.sherpa.dao.UserDao;
import com.sherpa.dto.EventDto;
import com.sherpa.dto.ImageDto;
import com.sherpa.dto.RatingDto;
import com.sherpa.dto.ReportDto;
import com.sherpa.dto.TagDto;
import com.sherpa.dto.composite.EventDetailDto;
import com.sherpa.model.Event;
import com.sherpa.model.EventTagCross;
import com.sherpa.model.Image;
import com.sherpa.model.Location;
import com.sherpa.model.Rating;
import com.sherpa.model.Report;
import com.sherpa.model.User;
import com.sherpa.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private LocationDao locationDao;

	@Override
	public EventDto add(EventDto transientInstance) {
		return eventDao.persist(transientInstance.toModel()).toDto();
	}

	@Override
	public void remove(long id) {
		eventDao.remove(Event.class, id);
	}

	@Override
	public EventDto update(EventDto detachedInstance) {
		return eventDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public EventDto findById(long id) {
		return eventDao.findById(Event.class, id).toDto();
	}

	/*
	 * TODO! refactor, mozganje! da li ic po regiji ili po lat + long + radius?
	 */
	@Override
	public Set<EventDto> getEventsByRegion(String region) {

		Iterator<Event> iter = eventDao.getByRegion(region).iterator();

		Set<EventDto> events = new HashSet<EventDto>();
		Event event = new Event();
		EventDto eventDto = new EventDto();

		while (iter.hasNext()) {

			event = iter.next();
			eventDto = event.toDto();

			// TODO! linija ispod je tmp dok se ne rjese to dto metode
			eventDto.setLocationByStartLocationId(event.getLocationByStartLocationId().getLocationId());

			events.add(eventDto);
		}

		return events;

	}

	/* TODO! refactor ili je ok? */
	@Override
	public EventDto insertEvent(EventDetailDto edd) {

		Location locationStart = locationDao.persist(edd.getLocationStart().toModel());
		Location locationEnd = locationDao.persist(edd.getLocationEnd().toModel());
		Event event = edd.getEvent().toModel();
		event.setLocationByStartLocationId(locationStart);
		event.setLocationByEndLocationId(locationEnd);
		event.setUser(userDao.findById(User.class, edd.getEvent().getUserId()));
		event.setCurrency(edd.getCurrency().toModel());
		event.setIsFinished(false);

		/* Prepare Event Tag Cross Model */
		Iterator<TagDto> iter = edd.getTags().iterator();
		EventTagCross etc = new EventTagCross();
		TagDto tagDto = new TagDto();
		Set<EventTagCross> eventTagCrosses = new HashSet<EventTagCross>(0);

		while (iter.hasNext()) {
			tagDto = iter.next();
			etc.setEvent(event);
			etc.setTag(tagDto.toModel());
			eventTagCrosses.add(etc);
		}

		event.setEventTagCrosses(eventTagCrosses);

		return eventDao.persist(event).toDto();

	}
	
	@Override
	public EventDto getEventById(Integer eventId) {

		Event event = eventDao.findById(Event.class, eventId.longValue());

		EventDto eventDto = event.toDto();
		if(event.getLocationByEndLocationId() != null){
			eventDto.setLocationByEndLocationId(event.getLocationByEndLocationId().getLocationId());
			
		}if(event.getLocationByStartLocationId() != null){
			eventDto.setLocationByStartLocationId(event.getLocationByStartLocationId().getLocationId());
			
		}
		if(event.getImages() != null){
			Set<ImageDto> images = new HashSet<ImageDto>();
			Iterator<Image> iter = event.getImages().iterator();
			while(iter.hasNext()){
				
				Image img = iter.next();
				images.add(img.toDto());
				
			}
			eventDto.setImages(images);
		}
		if(event.getRatings() != null){
			Set<RatingDto> ratings = new HashSet<RatingDto>();
			Iterator<Rating> iter = event.getRatings().iterator();
			while(iter.hasNext()){
				
				Rating rating = iter.next();
				ratings.add(rating.toDto());
				
			}
			eventDto.setRatings(ratings);
		}
		if(event.getReports() != null){
			Set<ReportDto> reports = new HashSet<ReportDto>();
			Iterator<Report> iter = event.getReports().iterator();
			while(iter.hasNext()){
				Report report = iter.next();
				reports.add(report.toDto());		
			}
			eventDto.setReports(reports);
		}
		if(event.getEventTagCrosses() != null){
			Set<TagDto> tags = new HashSet<TagDto>();
			Iterator<EventTagCross> iter = event.getEventTagCrosses().iterator();
			while(iter.hasNext()){
				EventTagCross etc = iter.next();
				tags.add(etc.getTag().toDto());			
			}
			eventDto.setTags(tags);
		}
		if(event.getCurrency() != null){
			eventDto.setCurrencyIso(event.getCurrency().getIso());		
		}
		return eventDto;
	}

}
