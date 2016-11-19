package com.sherpa.service;

import com.sherpa.dto.Image;

public interface ImageService {

	void addImage(Image transientInstance);

	void removeImage(Image persistentInstance);

	Image updateImage(Image detachedInstance);

	Image findById(Long id);

}
