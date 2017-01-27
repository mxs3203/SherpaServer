package com.sherpa.dto;

import com.sherpa.model.Event;
import com.sherpa.model.Rating;
import com.sherpa.model.User;
import com.sherpa.util.Util;

public class RatingDto {

	private long ratingId;
	private long eventId;
	private long userId;
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
		return eventId;
	}

	public void setEvent(long eventId) {
		this.eventId = eventId;
	}

	public long getUser() {
		return userId;
	}

	public void setUser(long userId) {
		this.userId = userId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Rating toModel() {
		Rating rating = new Rating();

		rating.setRatingId(ratingId);

		User user = new User(userId);
		rating.setUser(user);

		Event event = new Event(eventId);
		rating.setEvent(event);

		rating.setDate(Util.getDateJoda(date));
		rating.setComment(comment);
		rating.setRating(this.rating);

		return rating;
	}

}
