package com.sherpa.dao;

import com.sherpa.model.Image;

public interface ImageDao extends GenericDao<Image> {

	Image persist(Image transientInstance);

	void remove(Class<Image> clazz, long id);

	Image merge(Image detachedInstance);

	Image findById(Class<Image> clazz, long id);

}
