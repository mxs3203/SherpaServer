package com.sherpa.service;

import com.sherpa.dto.AdminDto;

public interface AdminService {

	void add(AdminDto transientInstance);

	void remove(long id);

	AdminDto update(AdminDto detachedInstance);

	AdminDto findById(long id);

	AdminDto loginAdmin(AdminDto adminDto);

}
