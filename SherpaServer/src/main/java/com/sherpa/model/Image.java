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

import com.sherpa.dto.ImageDto;

@Entity
@Table(name = "image", catalog = "sherpa")
public class Image implements java.io.Serializable {

	private static final long serialVersionUID = -1426119706463802819L;

	private long imageId;
	private Event event;
	private String imageUrl;

	public Image() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "image_id", unique = true, nullable = false)
	public long getImageId() {
		return this.imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", nullable = false)
	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Column(name = "image_url", nullable = false, length = 256)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/* TODO! */
	public ImageDto toDto() {
		ImageDto imageDto = new ImageDto();
		imageDto.setImageId(imageId);

		/* imageDto.setEvent(event.getEventId()); */

		imageDto.setImageUrl(imageUrl);
		return imageDto;
	}

}
