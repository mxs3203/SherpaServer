package com.sherpa.service;

import com.sherpa.dto.User;

public interface UserService {

	void addUser(User transientInstance);

	void removeUser(User persistentInstance);

	User updateUser(User detachedInstance);

	User findById(Long id);

}
