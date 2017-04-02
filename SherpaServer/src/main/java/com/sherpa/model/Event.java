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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.sherpa.dto.EventDto;
import com.sherpa.util.Util;

@Entity
@Table(name = "event", catalog = "sherpa")
public class Event implements java.io.Serializable {

	private static final long serialVersionUID = -4100434289243179544L;

	private long eventId;
	private Currency currency;
	private Location locationByEndLocationId;
	private Location locationByStartLocationId;
	private User user;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal cumulativeRating;
	private DateTime dateCreated;
	private DateTime startTime;
	private DateTime endTime;
	private Boolean isFinished;
	private Set<EventUserCross> eventUserCrosses = new HashSet<EventUserCross>(0);
	private Set<Report> reports = new HashSet<Report>(0);
	private Set<Rating> ratings = new HashSet<Rating>(0);
	private Set<Image> images = new HashSet<Image>(0);
	private Set<EventTagCross> eventTagCrosses = new HashSet<EventTagCross>(0);

	public Event() {
	}

	public Event(long eventId) {
		this.eventId = eventId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "event_id", unique = true, nullable = false)
	public long getEventId() {
		return this.eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id")
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "end_location_id")
	public Location getLocationByEndLocationId() {
		return this.locationByEndLocationId;
	}

	public void setLocationByEndLocationId(Location locationByEndLocationId) {
		this.locationByEndLocationId = locationByEndLocationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "start_location_id", nullable = false)
	public Location getLocationByStartLocationId() {
		return this.locationByStartLocationId;
	}

	public void setLocationByStartLocationId(Location locationByStartLocationId) {
		this.locationByStartLocationId = locationByStartLocationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", nullable = false, length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 512)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price", scale = 4)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "cumulative_rating", precision = 1, scale = 1)
	public BigDecimal getCumulativeRating() {
		return this.cumulativeRating;
	}

	public void setCumulativeRating(BigDecimal cumulativeRating) {
		this.cumulativeRating = cumulativeRating;
	}

	@Column(name = "date_created", nullable = false, length = 19)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "start_time", nullable = false, length = 19)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getStartTime() {
		return this.startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false, length = 19)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getEndTime() {
		return this.endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	@Column(name = "is_finished")
	public Boolean getIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public Set<EventUserCross> getEventUserCrosses() {
		return this.eventUserCrosses;
	}

	public void setEventUserCrosses(Set<EventUserCross> eventUserCrosses) {
		this.eventUserCrosses = eventUserCrosses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public Set<Report> getReports() {
		return this.reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public Set<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public Set<EventTagCross> getEventTagCrosses() {
		return this.eventTagCrosses;
	}

	public void setEventTagCrosses(Set<EventTagCross> eventTagCrosses) {
		this.eventTagCrosses = eventTagCrosses;
	}

	/* TODO! Ovo ce triggerat proxy i radit "nepotreban" call za getById() */
	public EventDto toDto() {
		EventDto eventDto = new EventDto();
		eventDto.setEventId(eventId);

		/*
		 * eventDto.setCurrency(currency.getCurrencyId());
		 * eventDto.setLocationByStartLocationId(locationByStartLocationId.
		 * getLocationId());
		 * eventDto.setLocationByEndLocationId(locationByEndLocationId.
		 * getLocationId()); eventDto.setUserId(user.getUserId());
		 */

		eventDto.setName(name);
		eventDto.setDescription(description);
		eventDto.setPrice(price);
		eventDto.setCumulativeRating(cumulativeRating);
		eventDto.setDateCreated(Util.getDateString(dateCreated));
		eventDto.setStartTime(Util.getDateString(startTime));
		eventDto.setEndTime(Util.getDateString(endTime));
		eventDto.setIsFinished(isFinished);
		if(this.getUser() != null){
			eventDto.setUserId(this.getUser().getUserId());
		}
		return eventDto;
	}

}
