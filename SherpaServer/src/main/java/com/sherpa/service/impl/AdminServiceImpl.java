package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.AdminDao;
import com.sherpa.dto.AdminDto;
import com.sherpa.model.Admin;
import com.sherpa.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;

	@Override
	public void addAdmin(AdminDto transientInstance) {
		adminDao.persist(transientInstance.generateEntity());
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
	public AdminDto findById(long id) {
		return adminDao.findById(id).generateDto();
	}
	@Override
	public AdminDto verifyAdmin(String username, String password){
		return (AdminDto) adminDao.verifyAdmin(username, password);		
	}

}
