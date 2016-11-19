package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.UserDao;
import com.sherpa.dto.User;
import com.sherpa.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		return userDao.findById(userId);
	}

	@Override
	public User getUserByIdABC(int userId) {
		User user = userDao.findById(userId);
		user.setLocation(null);
		user.setRatings(null);
		user.setRewards(null);
		user.setAchievementUserCrosses(null);
		user.setReportsForSherpaId(null);
		user.setReportsForUserId(null);
		user.setExperiences(null);
		user.setEventUserCrosses(null);
		user.setEvents(null);
		return user;
	}

}
