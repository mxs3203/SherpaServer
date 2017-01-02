package com.sherpa.dao;

import com.sherpa.model.Tag;

public interface TagDao {

	void persist(Tag transientInstance);

	void remove(Tag persistentInstance);

	Tag merge(Tag detachedInstance);

	Tag findById(long id);

	Tag findByTagName(String tagName);

}
