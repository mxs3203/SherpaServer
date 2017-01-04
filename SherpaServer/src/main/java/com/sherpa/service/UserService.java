package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.model.User;

public interface UserService {

	void addUser(User transientInstance);

	void removeUser(User persistentInstance);

	UserDto updateUser(User detachedInstance);

	UserDto findById(User user);

	UserDto loginUser(User user);

	Set<EventDto> getUserEvents(User user);

	Set<UserDto> getUsersByRegion(String region);

//	Set<UserDto> getSherpasByRegion(String region);

	Set<UserDto> getSherpasByRatingInRegion(String region);

}
