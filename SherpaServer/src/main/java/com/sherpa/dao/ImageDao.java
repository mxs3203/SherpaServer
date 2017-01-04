package com.sherpa.dao;

import com.sherpa.model.Image;

public interface ImageDao extends GenericDao<Image> {

	void persist(Image transientInstance);

	void remove(Image persistentInstance);

	Image merge(Image detachedInstance);

	Image findById(Class<Image> clazz, long id);

}
