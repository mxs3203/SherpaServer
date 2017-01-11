package com.sherpa.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.LocationDao;
import com.sherpa.dao.UserDao;
import com.sherpa.dto.EventDto;
import com.sherpa.dto.UserDto;
import com.sherpa.model.Event;
import com.sherpa.model.Location;
import com.sherpa.model.User;
import com.sherpa.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private LocationDao locDao;

	@Override
	public void add(User transientInstance) {
		userDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		userDao.remove(User.class, id);
	}

	@Override
	public UserDto update(User detachedInstance) {
		return userDao.merge(detachedInstance).toDto();
	}

	@Override
	public UserDto findById(User user) {
		return userDao.findById(User.class, user.getUserId()).toDto();
	}

	@Override
	public UserDto loginUser(User user) {
		return userDao.findByCredentials(user).toDto();
	}

	@Override
	public Set<EventDto> getUserEvents(User user) {

		/* TODO! Check yo self */

		Set<EventDto> events = new HashSet<EventDto>();

		Iterator<Event> iter = userDao.getUserEvents(user).iterator();

		while (iter.hasNext()) {
			events.add(iter.next().toDto());
		}

		return events;
	}

	public Set<UserDto> getUsersByRegion(String region) {

		/*
		 * Set<UserDto> usersDto = new HashSet<UserDto>();
		 * 
		 * TODO! for (Location locs : locDao.getRegionLocations(region)) { for
		 * (User user : locs.getUsers()) { usersDto.add(user.toDto()); } }
		 * return usersDto;
		 */

		/*
		 * TODO! Ovo treba preko Query-a rijesit u novoj DAO metodi (Location
		 * ili User objekta) (FROM Location l INNER JOIN User u WHERE l.region =
		 * :region AND u.isSherpa = 1)?
		 */

		Set<UserDto> users = new HashSet<UserDto>();

		Iterator<Location> locIter = locDao.getRegionLocations(region).iterator();

		Iterator<User> userIter = null;

		Set<User> userModel = new HashSet<User>();

		while (locIter.hasNext()) {

			userModel = locIter.next().getUsers();

			userIter = userModel.iterator();

			while (userIter.hasNext()) {
				users.add(userIter.next().toDto());
			}
		}

		return users;
	}

	@Override
	public Set<UserDto> getSherpasByRatingInRegion(String region) {

		/* TODO! Jel ovaj kod OK? Query je vrlo vjerojatno kriv */

		Set<UserDto> users = new HashSet<UserDto>();

		Iterator<User> iter = userDao.getSherpasByRatingInRegion(region).iterator();

		while (iter.hasNext()) {
			users.add(iter.next().toDto());
		}

		return users;
	}

}
