package com.sherpa.dto;

import java.math.BigDecimal;

import com.sherpa.model.Location;

public class LocationDto {

	private long locationId;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String region;
	
	public LocationDto(){}
	
	public LocationDto(BigDecimal latitude, BigDecimal longitude, String region){
		this.latitude=latitude;
		this.longitude=longitude;
		this.region=region;	
	}
	
	public LocationDto(long locationId, BigDecimal latitude, BigDecimal longitude, String region) {
		this.locationId = locationId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.region = region;
	}
	
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public Location generateEntity(){
		Location location = new Location(this.getLatitude(), this.getLongitude(), this.getRegion());
		return location;	
	}
}
