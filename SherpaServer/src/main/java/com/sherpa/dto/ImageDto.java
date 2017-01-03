package com.sherpa.dto;

import com.sherpa.model.Image;

public class ImageDto {

	private long imageId;
	private long event;
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
		return event;
	}

	public void setEvent(long event) {
		this.event = event;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/* TODO! */
	public Image toModel() {
		Image image = new Image();
		return image;
	}

}
