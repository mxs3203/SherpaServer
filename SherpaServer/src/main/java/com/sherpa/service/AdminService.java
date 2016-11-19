package com.sherpa.service;

import com.sherpa.dto.Admin;

public interface AdminService {

	void addAdmin(Admin transientInstance);

	void removeAdmin(Admin persistentInstance);

	Admin updateAdmin(Admin detachedInstance);

	Admin findById(Long id);

}
