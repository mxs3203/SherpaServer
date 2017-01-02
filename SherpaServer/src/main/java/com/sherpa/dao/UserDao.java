package com.sherpa.dao;

import java.util.List;
import java.util.Set;

import com.sherpa.dto.UserDto;
import com.sherpa.model.Event;
import com.sherpa.model.Rating;
import com.sherpa.model.User;

public interface UserDao {

	void persist(User transientInstance);

	void remove(User persistentInstance);

	User merge(User detachedInstance);

	User findById(long id);

	UserDto getUserByCredentials(String email, String password);
	
	Set<Event> getUserEvents(long sherpaId);

	List<Rating> getSherpasByRating(String region);

}
