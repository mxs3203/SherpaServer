package com.sherpa.dao;

import java.util.Set;

public interface GenericDao<T> {

	T persist(T transientInstance);

	void remove(Class<T> clazz, long id);

	T merge(T detachedInstance);

	T findById(Class<T> clazz, long id);

	Set<T> getAll(Class<T> clazz);

}
