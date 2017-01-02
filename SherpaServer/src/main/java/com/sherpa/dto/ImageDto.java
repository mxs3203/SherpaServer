package com.sherpa.dto;


public class ImageDto {

	private long imageId;
	private long event;
	private String imageUrl;
	
	
	public ImageDto(long imageId, long event, String imageUrl) {
		this.imageId = imageId;
		this.event = event;
		this.imageUrl = imageUrl;
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
	
	
}
