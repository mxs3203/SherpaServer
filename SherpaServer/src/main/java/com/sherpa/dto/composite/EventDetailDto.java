package com.sherpa.dto.composite;

import java.util.Set;

import com.sherpa.dto.CurrencyDto;
import com.sherpa.dto.EventDto;
import com.sherpa.dto.LocationDto;
import com.sherpa.dto.TagDto;

public class EventDetailDto {

	public EventDto event;
	public LocationDto locationStart;
	public LocationDto locationEnd;
	public Set<TagDto> tags;
	public CurrencyDto currency;

	public EventDetailDto() {
	}

	public Set<TagDto> getTags() {
		return tags;
	}

	public void setTags(Set<TagDto> tags) {
		this.tags = tags;
	}

	public CurrencyDto getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyDto currency) {
		this.currency = currency;
	}

	public EventDto getEvent() {
		return event;
	}

	public void setEvent(EventDto event) {
		this.event = event;
	}

	public LocationDto getLocationStart() {
		return locationStart;
	}

	public void setLocationStart(LocationDto location) {
		this.locationStart = location;
	}

	public LocationDto getLocationEnd() {
		return locationEnd;
	}

	public void setLocationEnd(LocationDto location) {
		this.locationEnd = location;
	}

}
