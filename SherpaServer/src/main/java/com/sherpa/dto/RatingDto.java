package com.sherpa.dto;

import org.joda.time.DateTime;


public class RatingDto {
	private long ratingId;
	private long event;
	private long user;
	private DateTime date;
	private String comment;
	private Integer rating;
	
	
	public RatingDto(long ratingId, long event, long user, DateTime date, String comment, Integer rating) {
		this.ratingId = ratingId;
		this.event = event;
		this.user = user;
		this.date = date;
		this.comment = comment;
		this.rating = rating;
	}
	
	public long getRatingId() {
		return ratingId;
	}
	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
	}
	public long getEvent() {
		return event;
	}
	public void setEvent(long event) {
		this.event = event;
	}
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
