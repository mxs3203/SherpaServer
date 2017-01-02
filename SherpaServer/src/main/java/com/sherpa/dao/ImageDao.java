package com.sherpa.dao;

import com.sherpa.model.Image;

public interface ImageDao {

	void persist(Image transientInstance);

	void remove(Image persistentInstance);

	Image merge(Image detachedInstance);

	Image findById(long id);

}
