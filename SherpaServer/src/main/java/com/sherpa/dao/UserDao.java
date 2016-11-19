package com.sherpa.dao;

import com.sherpa.dto.User;

public interface UserDao {

	User findById(int userId);
	
}
