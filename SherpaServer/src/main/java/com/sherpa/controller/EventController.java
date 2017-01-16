package com.sherpa.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.composite.EventLocationDto;
import com.sherpa.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}

	@RequestMapping(value = "/region/{regionName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<EventLocationDto>> getEventsByRegion(@PathVariable("regionName") String region) {
		log.debug("Fetching Events in Region: {}", region);

		Set<EventLocationDto> events = eventService.getEventsByRegion(region);

		if (events == null) {
			log.debug("Events in Region: '{}' Not Found!", region);
			return new ResponseEntity<Set<EventLocationDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Set<EventLocationDto>>(events, HttpStatus.OK);
	}

	/* TODO! refactor */
	/*@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/plain")
	public ResponseEntity<String> insertEvent(@RequestBody EventLocationDto eventBody) {
		log.debug("Inserting Event with Name: '{}'", eventBody.getEvent().getName());

		 TODO! WAT? ovo nevalja, tj. trazi mozganje i refactor 
		eventService.insertEvent(eventBody);

		if (eventBody.getLocation() == null) {
			log.debug("Failed to Insert Event with Name: '{}'", eventBody.getEvent().getName());
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>(HttpStatus.OK);
	}*/

}
