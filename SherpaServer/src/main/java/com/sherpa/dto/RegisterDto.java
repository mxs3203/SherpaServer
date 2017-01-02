package com.sherpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDto {
	
	@JsonProperty("locationDto")
	public LocationDto locationDto = new LocationDto();
	@JsonProperty("userDto")
	public UserDto userDto = new UserDto();
	
	public RegisterDto(){}
	
	public RegisterDto(LocationDto locationDto, UserDto userDto){
		this.userDto=userDto;
		this.locationDto=locationDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public LocationDto getLocationDto() {
		return locationDto;
	}

	public void setLocationDto(LocationDto locationDto) {
		this.locationDto = locationDto;
	}
	
	
}
