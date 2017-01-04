package com.sherpa.dao;

import com.sherpa.model.Admin;

public interface AdminDao extends GenericDao<Admin> {

	void persist(Admin transientInstance);

	void remove(Admin persistentInstance);

	Admin merge(Admin detachedInstance);

	Admin findById(Class<Admin> clazz, long id);

	Admin verifyAdmin(String username, String password);

}
