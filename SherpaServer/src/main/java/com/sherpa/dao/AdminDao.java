package com.sherpa.dao;

import com.sherpa.dto.AdminDto;
import com.sherpa.model.Admin;

public interface AdminDao {

	void persist(Admin transientInstance);

	void remove(Admin persistentInstance);

	Admin merge(Admin detachedInstance);

	Admin findById(long id);

	AdminDto verifyAdmin(String username, String password);
}
