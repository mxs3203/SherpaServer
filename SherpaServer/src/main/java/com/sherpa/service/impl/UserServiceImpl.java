package com.sherpa.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.UserDao;
import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.dto.composite.UserLocationDto;
import com.sherpa.model.Event;
import com.sherpa.model.User;
import com.sherpa.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDto add(UserDto transientInstance) {
		return userDao.persist(transientInstance.toModel()).toDto();
	}

	@Override
	public void remove(long id) {
		userDao.remove(User.class, id);
	}

	@Override
	public UserDto update(UserDto detachedInstance) {
		return userDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public UserDto findById(long id) {
		return userDao.findById(User.class, id).toDto();
	}

	@Override
	public UserDto loginUser(UserDto userDto) {
		return userDao.findByCredentials(userDto.toModel()).toDto();
	}

	@Override
	public Set<EventDto> getSherpaEvents(long id) {

		Set<EventDto> events = new HashSet<EventDto>();

		Iterator<Event> iter = userDao.getSherpaEvents(id).iterator();

		while (iter.hasNext()) {
			events.add(iter.next().toDto());
		}

		return events;
	}

	public Set<UserDto> getUsersByRegion(String region) {

		Set<UserDto> users = new HashSet<UserDto>();

		Iterator<User> userIter = userDao.getUsersByRegion(region).iterator();

		while (userIter.hasNext()) {
			users.add(userIter.next().toDto());
		}

		return users;
	}

	public Set<UserDto> getSherpasByRegion(String region) {

		Set<UserDto> users = new HashSet<UserDto>();

		Iterator<User> userIter = userDao.getSherpasByRegion(region).iterator();

		while (userIter.hasNext()) {
			users.add(userIter.next().toDto());
		}

		return users;
	}

	@Override
	public Set<UserDto> getSherpasByRatingInRegion(String region) {

		Set<UserDto> users = new HashSet<UserDto>();

		Iterator<User> iter = userDao.getSherpasByRatingInRegion(region).iterator();

		while (iter.hasNext()) {
			users.add(iter.next().toDto());
		}

		return users;
	}

	@Override
	public UserDto registerUser(UserLocationDto userLocationDto) {

		User user = userLocationDto.getUserDto().toModel();
		user.setLocation(userLocationDto.getLocationDto().toModel());

		try {
			user = userDao.persist(user);
		} catch (EntityExistsException e) {
			e.printStackTrace();
			user = null;
		}

		return user.toDto();
	}

}
