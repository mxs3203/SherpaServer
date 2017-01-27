package com.sherpa.dto;

import com.sherpa.model.Event;
import com.sherpa.model.Image;

public class ImageDto {

	private long imageId;
	private long eventId;
	private String imageUrl;

	public ImageDto() {
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public long getEvent() {
		return eventId;
	}

	public void setEvent(long eventId) {
		this.eventId = eventId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Image toModel() {
		Image image = new Image();

		image.setImageId(imageId);

		Event event = new Event(eventId);
		image.setEvent(event);

		image.setImageUrl(imageUrl);

		return image;
	}

}
