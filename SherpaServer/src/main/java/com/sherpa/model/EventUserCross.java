package com.sherpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event_user_cross", catalog = "sherpa")
public class EventUserCross implements java.io.Serializable {

	private static final long serialVersionUID = -1014130588011050861L;
	
	private EventUserCrossId id;
	private Event event;
	private User user;

	public EventUserCross() {
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "eventUserId", column = @Column(name = "event_user_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
			@AttributeOverride(name = "eventId", column = @Column(name = "event_id", nullable = false)) })
	public EventUserCrossId getId() {
		return this.id;
	}

	public void setId(EventUserCrossId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", nullable = false, insertable = false, updatable = false)
	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
