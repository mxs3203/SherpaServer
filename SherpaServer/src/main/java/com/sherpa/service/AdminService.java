package com.sherpa.service;

import com.sherpa.dto.AdminDto;

public interface AdminService {

	void addAdmin(AdminDto transientInstance);

	void removeAdmin(AdminDto persistentInstance);

	AdminDto updateAdmin(AdminDto detachedInstance);

	AdminDto findById(long id);

	AdminDto verifyAdmin(AdminDto adminDto);

}
