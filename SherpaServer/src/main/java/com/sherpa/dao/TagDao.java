package com.sherpa.dao;

import com.sherpa.dto.Tag;

public interface TagDao {

	void persist(Tag transientInstance);

	void remove(Tag persistentInstance);

	Tag merge(Tag detachedInstance);

	Tag findById(Long id);

}
