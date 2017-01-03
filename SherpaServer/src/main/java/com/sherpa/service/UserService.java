package com.sherpa.service;

import java.util.Set;

import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.model.User;

public interface UserService {

	void addUser(User transientInstance);

	void removeUser(User persistentInstance);

	User updateUser(User detachedInstance);

	UserDto findById(long id);

	UserDto loginUser(String email, String password);

	Set<EventDto> getUserEvents(long id);

	Set<UserDto> getUsersByRegion(String region);

	Set<UserDto> getSherpasByRegion(String region);

	Set<UserDto> getSherpasByRating(String region);

}
