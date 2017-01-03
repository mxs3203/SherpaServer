package com.sherpa.dao;

import java.util.List;

public interface GenericDao<T> {

	void persist(T transientInstance);

	void remove(T persistentInstance);

	T merge(T detachedInstance);

	T findById(Class<T> clazz, long id);

	List<T> getAll(Class<T> clazz);
	
	/* TODO! Dal je ovo potrebno? Dal mogu ovdje extendat GenericDao<Admin>? */

}
