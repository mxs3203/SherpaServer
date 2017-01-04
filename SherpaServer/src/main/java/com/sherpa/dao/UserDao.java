package com.sherpa.dao;

import java.util.Set;

import com.sherpa.model.Event;
import com.sherpa.model.User;

public interface UserDao extends GenericDao<User> {

	void persist(User transientInstance);

	void remove(User persistentInstance);

	User merge(User detachedInstance);

	User findById(Class<User> clazz, long id);

	User getUserByCredentials(User user);

	Set<Event> getUserEvents(User user);

	Set<User> getSherpasByRatingInRegion(String region);

}
