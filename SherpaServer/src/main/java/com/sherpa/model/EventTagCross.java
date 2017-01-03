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
@Table(name = "event_tag_cross", catalog = "sherpa")
public class EventTagCross implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4096479066226219692L;
	private EventTagCrossId id;
	private Event event;
	private Tag tag;

	public EventTagCross() {
	}

	public EventTagCross(EventTagCrossId id, Event event, Tag tag) {
		this.id = id;
		this.event = event;
		this.tag = tag;
	}
	
	public EventTagCross( Event event, Tag tag) {
		this.event = event;
		this.tag = tag;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "eventTagId", column = @Column(name = "event_tag_id", nullable = false)),
			@AttributeOverride(name = "eventId", column = @Column(name = "event_id", nullable = false)),
			@AttributeOverride(name = "tagId", column = @Column(name = "tag_id", nullable = false)) })
	public EventTagCrossId getId() {
		return this.id;
	}

	public void setId(EventTagCrossId id) {
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
	@JoinColumn(name = "tag_id", nullable = false, insertable = false, updatable = false)
	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
