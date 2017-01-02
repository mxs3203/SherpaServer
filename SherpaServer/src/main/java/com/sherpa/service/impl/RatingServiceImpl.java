package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.RatingDao;
import com.sherpa.model.Rating;
import com.sherpa.service.RatingService;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

	@Autowired
    private RatingDao ratingDao;

	@Override
	public void addRating(Rating transientInstance) {
		ratingDao.persist(transientInstance);
	}
	
	@Override
	public void removeRating(Rating persistentInstance) {
		ratingDao.remove(persistentInstance);
	}
	
	@Override
	public Rating updateRating(Rating detachedInstance) {
		return ratingDao.merge(detachedInstance);
	}
	
	@Override
	public Rating findById(long id) {
		return ratingDao.findById(id);
	}
}
