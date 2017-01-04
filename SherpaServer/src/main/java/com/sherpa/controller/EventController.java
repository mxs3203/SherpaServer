package com.sherpa.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sherpa.dto.EventLocationDto;
import com.sherpa.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
		
	@RequestMapping(method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }
	
	@RequestMapping(value = "/region/{regionName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<EventLocationDto>> loginUser(@PathVariable("regionName") String region) {
        System.out.println("Fetching Events with region: " + region);
        
        Set<EventLocationDto> events = eventService.getEventsByRegion(region);        
        if (events == null) {
            System.out.println("User with region: " + region);
            return new ResponseEntity<Set<EventLocationDto>>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Set<EventLocationDto>>(events, HttpStatus.OK);
    }
	
	
	/* TODO! refactor */
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces="text/plain")
    public ResponseEntity<String> insertEvent(@RequestBody EventLocationDto eventBody) {
        
		System.out.println("Inserting event with name: " + eventBody.getEvent().getName());
        
        eventService.insertEvent(eventBody);

        if (eventBody.getLocation() == null) {
            System.out.println("Failed to insert event with name: " + eventBody.getEvent().getName());
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<String>(HttpStatus.OK);
    }
	
}
