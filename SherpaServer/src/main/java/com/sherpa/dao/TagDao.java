package com.sherpa.dao;

import com.sherpa.model.Tag;

public interface TagDao extends GenericDao<Tag> {

	Tag persist(Tag transientInstance);

	void remove(Class<Tag> clazz, long id);

	Tag merge(Tag detachedInstance);

	Tag findById(Class<Tag> clazz, long id);

	Tag findByTagName(String tagName);

}
