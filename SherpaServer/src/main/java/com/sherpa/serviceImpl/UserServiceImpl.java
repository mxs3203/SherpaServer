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
	public User findById(Long id) {
		return userDao.findById(id);
	}
	
}
