package com.sherpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventUserCrossId implements java.io.Serializable {

	private static final long serialVersionUID = -7153913808373622209L;
	
	private int eventUserId;
	private int userId;
	private int eventId;

	public EventUserCrossId() {
	}

	@Column(name = "event_user_id", nullable = false)
	public int getEventUserId() {
		return this.eventUserId;
	}

	public void setEventUserId(int eventUserId) {
		this.eventUserId = eventUserId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "event_id", nullable = false)
	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EventUserCrossId))
			return false;
		EventUserCrossId castOther = (EventUserCrossId) other;

		return (this.getEventUserId() == castOther.getEventUserId()) && (this.getUserId() == castOther.getUserId())
				&& (this.getEventId() == castOther.getEventId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEventUserId();
		result = 37 * result + this.getUserId();
		result = 37 * result + this.getEventId();
		return result;
	}

}
