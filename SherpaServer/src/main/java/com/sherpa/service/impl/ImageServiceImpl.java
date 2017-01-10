package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ImageDao;
import com.sherpa.model.Image;
import com.sherpa.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public void add(Image transientInstance) {
		imageDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		imageDao.remove(Image.class, id);
	}

	@Override
	public Image update(Image detachedInstance) {
		return imageDao.merge(detachedInstance);
	}

	@Override
	public Image findById(long id) {
		return imageDao.findById(Image.class, id);
	}

}
