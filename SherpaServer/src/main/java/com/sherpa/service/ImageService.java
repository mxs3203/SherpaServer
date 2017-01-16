package com.sherpa.service;

import com.sherpa.dto.ImageDto;

public interface ImageService {

	void add(ImageDto transientInstance);

	void remove(long id);

	ImageDto update(ImageDto detachedInstance);

	ImageDto findById(long id);

}
