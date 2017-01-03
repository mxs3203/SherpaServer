package com.sherpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.sherpa.dto.RatingDto;
import com.sherpa.util.Util;

@Entity
@Table(name = "rating", catalog = "sherpa")
public class Rating implements java.io.Serializable {

	private static final long serialVersionUID = 5140115175512178962L;

	private long ratingId;
	private Event event;
	private User user;
	private DateTime date;
	private String comment;
	private Integer rating;

	public Rating() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rating_id", unique = true, nullable = false)
	public long getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", nullable = false)
	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "date", nullable = false, length = 19)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getDate() {
		return this.date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	@Column(name = "comment", length = 512)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "rating")
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/* TODO! */
	public RatingDto toDto() {
		RatingDto ratingDto = new RatingDto();

		ratingDto.setRatingId(ratingId);

		/*
		 * ratingDto.setEvent(event); ratingDto.setUser(user);
		 */

		ratingDto.setDate(Util.getDateString(date));
		ratingDto.setComment(comment);
		ratingDto.setRating(rating);

		return ratingDto;
	}

}
