package com.sherpa.dao;

import java.util.Set;

import com.sherpa.model.Event;
import com.sherpa.model.User;

public interface UserDao extends GenericDao<User> {

	void persist(User transientInstance);

	void remove(Class<User> clazz, long id);

	User merge(User detachedInstance);

	User findById(Class<User> clazz, long id);

	User findByCredentials(User user);

	Set<Event> getSherpaEvents(long id);
	
	Set<User> getSherpasByRegion(String region);

	Set<User> getSherpasByRatingInRegion(String region);

}
