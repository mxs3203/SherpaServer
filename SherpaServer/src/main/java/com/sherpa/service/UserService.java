package com.sherpa.service;

import com.sherpa.dto.User;

public interface UserService {
	
	User getUserById(int userId);

	User getUserByIdABC(int userId);
}
