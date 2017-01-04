package com.sherpa.dto;

import java.util.Set;

public class EventLocationDto {

	public EventDto event;
	public LocationDto location;
	public Set<String> tags;
	public String currency;

	public EventLocationDto() {
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
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

	/* TODO! Dal ova klasa treba uopce? */

}
