package com.sherpa.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sherpa.dto.LocationDto;

@Entity
@Table(name = "location", catalog = "sherpa")
public class Location implements java.io.Serializable {

	private static final long serialVersionUID = -6732388531857850713L;

	private long locationId;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String region;
	private Set<Event> eventsForEndLocationId = new HashSet<Event>(0);
	private Set<Event> eventsForStartLocationId = new HashSet<Event>(0);
	private Set<User> users = new HashSet<User>(0);

	public Location() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "location_id", unique = true, nullable = false)
	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	@Column(name = "latitude", nullable = false, precision = 10, scale = 8)
	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = false, precision = 10, scale = 8)
	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Column(name = "region", length = 128)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locationByEndLocationId")
	public Set<Event> getEventsForEndLocationId() {
		return this.eventsForEndLocationId;
	}

	public void setEventsForEndLocationId(Set<Event> eventsForEndLocationId) {
		this.eventsForEndLocationId = eventsForEndLocationId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locationByStartLocationId")
	public Set<Event> getEventsForStartLocationId() {
		return this.eventsForStartLocationId;
	}

	public void setEventsForStartLocationId(Set<Event> eventsForStartLocationId) {
		this.eventsForStartLocationId = eventsForStartLocationId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
	@Fetch(FetchMode.JOIN)
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public LocationDto toDto() {
		LocationDto locationDto = new LocationDto();

		locationDto.setLocationId(locationId);
		locationDto.setLatitude(latitude);
		locationDto.setLongitude(longitude);
		locationDto.setRegion(region);

		/*
		 * locationDto.setEventsForEndLocationId(eventsForEndLocationId.toDto);
		 * locationDto.setEventsForStartLocationId(eventsForStartLocationId.
		 * toDto); locationDto.setUsers(users.toDto);
		 */

		return locationDto;
	}

}
