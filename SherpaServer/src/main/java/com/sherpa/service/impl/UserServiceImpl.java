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
	public void addUser(User transientInstance) {
		userDao.persist(transientInstance);
	}

	@Override
	public void removeUser(User persistentInstance) {
		userDao.remove(persistentInstance);
	}

	@Override
	public User updateUser(User detachedInstance) {
		return userDao.merge(detachedInstance);
	}

	@Override
	public UserDto findById(long id) {
		/* TODO! */
		return userDao.findById(id).toDto();
	}

	@Override
	public UserDto loginUser(String email, String password) {
		return userDao.getUserByCredentials(email, password);
	}

	@Override
	public Set<EventDto> getUserEvents(long id) {

		Set<EventDto> eventsDto = new HashSet<EventDto>();

		/* TODO! */
		for (Event events : userDao.getUserEvents(id)) {
			eventsDto.add(events.toDto());
		}
		return eventsDto;
	}

	public Set<UserDto> getUsersByRegion(String region) {

		Set<UserDto> usersDto = new HashSet<UserDto>();

		/* TODO! */
		for (Location locs : locDao.getRegionLocations(region)) {
			for (User user : locs.getUsers()) {
				usersDto.add(user.toDto());
			}
		}
		return usersDto;
	}

	/* TODO! Queriat odmah iz baze usere koji su sherpa */
	@Override
	public Set<UserDto> getSherpasByRegion(String region) {

		Set<UserDto> sherpasDto = this.getUsersByRegion(region);

		Iterator<UserDto> iter = sherpasDto.iterator();
		while (iter.hasNext()) {
			if (!iter.next().getIsSherpa())
				iter.remove();
		}

		return sherpasDto;
	}

	@Override
	public Set<UserDto> getSherpasByRating(String region) {

		/* TODO! get sherpas events by rating */

		userDao.getSherpasByRating(region);

		return null;
	}

}
