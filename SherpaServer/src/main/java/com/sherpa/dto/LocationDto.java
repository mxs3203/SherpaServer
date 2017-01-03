package com.sherpa.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.sherpa.model.Location;

public class LocationDto {

	private long locationId;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String region;

	private Set<EventDto> eventsForEndLocationId = new HashSet<EventDto>(0);
	private Set<EventDto> eventsForStartLocationId = new HashSet<EventDto>(0);
	private Set<UserDto> users = new HashSet<UserDto>(0);

	public LocationDto() {
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<EventDto> getEventsForEndLocationId() {
		return eventsForEndLocationId;
	}

	public void setEventsForEndLocationId(Set<EventDto> eventsForEndLocationId) {
		this.eventsForEndLocationId = eventsForEndLocationId;
	}

	public Set<EventDto> getEventsForStartLocationId() {
		return eventsForStartLocationId;
	}

	public void setEventsForStartLocationId(Set<EventDto> eventsForStartLocationId) {
		this.eventsForStartLocationId = eventsForStartLocationId;
	}

	public Set<UserDto> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDto> users) {
		this.users = users;
	}

	/* TODO! */
	public Location toModel() {
		Location location = new Location();
		return location;
	}

}
