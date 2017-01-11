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
	public void add(AdminDto transientInstance) {
		adminDao.persist(transientInstance.toModel());
	}

	@Override
	public void remove(long id) {
		adminDao.remove(Admin.class, id);
	}

	@Override
	public AdminDto update(AdminDto detachedInstance) {
		return adminDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public AdminDto findById(long id) {
		return adminDao.findById(Admin.class, id).toDto();
	}

	@Override
	public AdminDto loginAdmin(AdminDto adminDto) {
		return adminDao.findByCredentials(adminDto.getUsername(), adminDto.getPassword()).toDto();
	}

}
