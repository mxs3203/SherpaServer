package com.sherpa.service;

import com.sherpa.model.Image;

public interface ImageService {

	void add(Image transientInstance);

	void remove(long id);

	Image update(Image detachedInstance);

	Image findById(long id);

}
