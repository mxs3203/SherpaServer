package com.sherpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventTagCrossId implements java.io.Serializable {

	private static final long serialVersionUID = -4495241196899860740L;
	
	private int eventTagId;
	private int eventId;
	private int tagId;

	public EventTagCrossId() {
	}

	@Column(name = "event_tag_id", nullable = false)
	public int getEventTagId() {
		return this.eventTagId;
	}

	public void setEventTagId(int eventTagId) {
		this.eventTagId = eventTagId;
	}

	@Column(name = "event_id", nullable = false)
	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Column(name = "tag_id", nullable = false)
	public int getTagId() {
		return this.tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EventTagCrossId))
			return false;
		EventTagCrossId castOther = (EventTagCrossId) other;

		return (this.getEventTagId() == castOther.getEventTagId()) && (this.getEventId() == castOther.getEventId())
				&& (this.getTagId() == castOther.getTagId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEventTagId();
		result = 37 * result + this.getEventId();
		result = 37 * result + this.getTagId();
		return result;
	}

}
