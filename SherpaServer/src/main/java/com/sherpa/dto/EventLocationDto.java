package com.sherpa.dto;

import java.util.ArrayList;

public class EventLocationDto {
	
	public EventDto event;
	
	public LocationDto location;
	
	public ArrayList<String> tags;
	
	public String currency;
	
	public EventLocationDto(){}
	
	public EventLocationDto(EventDto eventDto, LocationDto locDto) {
		this.event = eventDto;
		this.location = locDto;
	}

	public EventLocationDto(EventDto event, LocationDto location,ArrayList<String> tags,String currency) {
		this.event = event;
		this.location = location;
		this.tags = tags;
		this.currency=currency;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public EventDto getEvent() {
		return event;
	}

	public void setEvent(EventDto event) {
		this.event = event;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}
	
}
