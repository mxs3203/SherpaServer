package com.sherpa.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.sherpa.model.Event;

public class EventDto {

	private long eventId;
	private long currency;
	private long locationByEndLocationId;
	private long locationByStartLocationId;
	private long userId;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal cumulativeRating;
	private String dateCreated;
	private String startTime;
	private String endTime;
	private Boolean isFinished;

	private Set<ReportDto> reports = new HashSet<ReportDto>(0);
	private Set<RatingDto> ratings = new HashSet<RatingDto>(0);
	private Set<ImageDto> images = new HashSet<ImageDto>(0);

	public EventDto() {
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getCurrency() {
		return currency;
	}

	public void setCurrency(long currency) {
		this.currency = currency;
	}

	public long getLocationByEndLocationId() {
		return locationByEndLocationId;
	}

	public void setLocationByEndLocationId(long locationByEndLocationId) {
		this.locationByEndLocationId = locationByEndLocationId;
	}

	public long getLocationByStartLocationId() {
		return locationByStartLocationId;
	}

	public void setLocationByStartLocationId(long locationByStartLocationId) {
		this.locationByStartLocationId = locationByStartLocationId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCumulativeRating() {
		return cumulativeRating;
	}

	public void setCumulativeRating(BigDecimal cumulativeRating) {
		this.cumulativeRating = cumulativeRating;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Set<ReportDto> getReports() {
		return reports;
	}

	public void setReports(Set<ReportDto> reports) {
		this.reports = reports;
	}

	public Set<RatingDto> getRatings() {
		return ratings;
	}

	public void setRatings(Set<RatingDto> ratings) {
		this.ratings = ratings;
	}

	public Set<ImageDto> getImages() {
		return images;
	}

	public void setImages(Set<ImageDto> images) {
		this.images = images;
	}

	/* TODO! Mozgat o ovom */
	public Event generateEntity() {
		Event event = new Event();
		event.setEventId(eventId);
		return event;
	}

}
