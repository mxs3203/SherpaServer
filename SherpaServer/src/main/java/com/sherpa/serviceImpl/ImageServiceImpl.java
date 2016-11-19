package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ImageDao;
import com.sherpa.dto.Image;
import com.sherpa.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
    private ImageDao imageDao;

	@Override
	public void addImage(Image transientInstance) {
		imageDao.persist(transientInstance);
	}
	
	@Override
	public void removeImage(Image persistentInstance) {
		imageDao.remove(persistentInstance);
	}
	
	@Override
	public Image updateImage(Image detachedInstance) {
		return imageDao.merge(detachedInstance);
	}
	
	@Override
	public Image findById(Long id) {
		return imageDao.findById(id);
	}
	
}
