package com.sherpa.service;


import com.sherpa.dto.AdminDto;
import com.sherpa.model.Admin;

public interface AdminService {

	void addAdmin(Admin transientInstance);

	void removeAdmin(Admin persistentInstance);

	Admin updateAdmin(Admin detachedInstance);

	AdminDto findById(long id);
	
	AdminDto verifyAdmin(String username, String passwword);
	
}	
