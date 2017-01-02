package com.sherpa.service;

import com.sherpa.model.Image;

public interface ImageService {

	void addImage(Image transientInstance);

	void removeImage(Image persistentInstance);

	Image updateImage(Image detachedInstance);

	Image findById(long id);

}
