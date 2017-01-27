package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.dto.composite.UserLocationDto;

public interface UserService {

	void add(UserDto transientInstance);

	void remove(long id);

	UserDto update(UserDto detachedInstance);

	UserDto findById(long id);

	UserDto loginUser(UserDto user);

	Set<EventDto> getSherpaEvents(long id);

	Set<UserDto> getUsersByRegion(String region);

	Set<UserDto> getSherpasByRegion(String region);

	Set<UserDto> getSherpasByRatingInRegion(String region);

	UserDto registerUser(UserLocationDto userLocationDto);

}
