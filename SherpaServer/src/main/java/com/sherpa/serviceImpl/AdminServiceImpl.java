package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.AdminDao;
import com.sherpa.dto.Admin;
import com.sherpa.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;

	@Override
	public void addAdmin(Admin transientInstance) {
		adminDao.persist(transientInstance);
	}
	
	@Override
	public void removeAdmin(Admin persistentInstance) {
		adminDao.remove(persistentInstance);
	}
	
	@Override
	public Admin updateAdmin(Admin detachedInstance) {
		return adminDao.merge(detachedInstance);
	}
	
	@Override
	public Admin findById(Long id) {
		return adminDao.findById(id);
	}

}
