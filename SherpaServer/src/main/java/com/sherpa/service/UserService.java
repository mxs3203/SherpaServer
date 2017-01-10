package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.model.User;

public interface UserService {

	void add(User transientInstance);

	void remove(long id);

	UserDto update(User detachedInstance);

	UserDto findById(User user);

	UserDto loginUser(User user);

	Set<EventDto> getUserEvents(User user);

	Set<UserDto> getUsersByRegion(String region);

	/* Set<UserDto> getSherpasByRegion(String region); */

	Set<UserDto> getSherpasByRatingInRegion(String region);

}
