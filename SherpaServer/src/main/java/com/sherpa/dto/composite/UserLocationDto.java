package com.sherpa.dto.composite;

import com.sherpa.dto.LocationDto;
import com.sherpa.dto.UserDto;

public class UserLocationDto {

	public UserDto userDto;
	public LocationDto locationDto;

	public UserLocationDto() {
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
