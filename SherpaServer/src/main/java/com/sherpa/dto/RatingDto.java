package com.sherpa.dto;

public class RatingDto {

	private long ratingId;
	private long event;
	private long user;
	private String date;
	private String comment;
	private int rating;

	public RatingDto() {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public void setRating(int rating) {
		this.rating = rating;
	}

}
