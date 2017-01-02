package com.sherpa.dto;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

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
	private DateTime dateCreated;
	private DateTime startTime;
	private DateTime endTime;
	private Boolean isFinished;
	

	private List<String> images = null;
	private String dateCreatedString;
	private String startTimeString;
	private String endTimeString;

	public EventDto() {}
	
	public EventDto(long eventId, long currency, long locationByEndLocationId, long locationByStartLocationId,
			long userId, String name, String description, BigDecimal price, BigDecimal cumulativeRating,
			DateTime dateCreated, DateTime startTime, DateTime endTime, Boolean isFinished) {
		this.eventId = eventId;
		this.currency = currency;
		this.locationByEndLocationId = locationByEndLocationId;
		this.locationByStartLocationId = locationByStartLocationId;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.cumulativeRating = cumulativeRating;
		this.dateCreated = dateCreated;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isFinished = isFinished;
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

	public DateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	public String getDateCreatedString() {
		return dateCreatedString;
	}


	public void setDateCreatedString(String dateCreatedString) {
		setDateCreated(new DateTime(dateCreatedString));
	}

	public String getStartTimeString() {
		return startTimeString;
	}

	public void setStartTimeString(String startTimeString) {
		setStartTime(new DateTime(startTimeString));
	}

	public String getEndTimeString() {
		return endTimeString;
	}

	public void setEndTimeString(String endTimeString) {
		setEndTime(new DateTime(endTimeString));
	}
	
	public Event generateEntity(){
		return new Event(null, null,this.getName(), this.getDescription(), this.getDateCreated(), this.getStartTime(), this.getEndTime());
	}
	
}
