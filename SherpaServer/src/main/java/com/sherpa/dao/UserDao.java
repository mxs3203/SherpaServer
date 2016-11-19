package com.sherpa.dao;

import com.sherpa.dto.User;

public interface UserDao {

	void persist(User transientInstance);

	void remove(User persistentInstance);

	User merge(User detachedInstance);

	User findById(Long id);

}
