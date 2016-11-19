package com.sherpa.dao;

import com.sherpa.dto.Admin;

public interface AdminDao {

	void persist(Admin transientInstance);

	void remove(Admin persistentInstance);

	Admin merge(Admin detachedInstance);

	Admin findById(Long id);

}
