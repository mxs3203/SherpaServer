package com.sherpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDto {
	
	/* TODO! Provjerit dal radi i dalje */

	// @JsonProperty("locationDto")
	public LocationDto locationDto = new LocationDto();

	// @JsonProperty("userDto")
	public UserDto userDto = new UserDto();

	public RegisterDto() {
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
