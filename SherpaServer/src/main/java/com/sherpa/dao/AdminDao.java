package com.sherpa.dao;

import com.sherpa.model.Admin;

public interface AdminDao extends GenericDao<Admin> {

	void persist(Admin transientInstance);

	void remove(Class<Admin> clazz, long id);

	Admin merge(Admin detachedInstance);

	Admin findById(Class<Admin> clazz, long id);

	Admin findByCredentials(String username, String password);

}
