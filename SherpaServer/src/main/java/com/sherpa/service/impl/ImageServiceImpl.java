package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ImageDao;
import com.sherpa.dto.ImageDto;
import com.sherpa.model.Image;
import com.sherpa.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public void add(ImageDto transientInstance) {
		imageDao.persist(transientInstance.toModel());
	}

	@Override
	public void remove(long id) {
		imageDao.remove(Image.class, id);
	}

	@Override
	public ImageDto update(ImageDto detachedInstance) {
		return imageDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public ImageDto findById(long id) {
		return imageDao.findById(Image.class, id).toDto();
	}

}
