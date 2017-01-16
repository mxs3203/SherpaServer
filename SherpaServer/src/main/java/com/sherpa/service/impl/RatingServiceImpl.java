package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.RatingDao;
import com.sherpa.dto.RatingDto;
import com.sherpa.model.Rating;
import com.sherpa.service.RatingService;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;

	@Override
	public void add(RatingDto transientInstance) {
		ratingDao.persist(transientInstance.toModel());
	}

	@Override
	public void remove(long id) {
		ratingDao.remove(Rating.class, id);
	}

	@Override
	public RatingDto update(RatingDto detachedInstance) {
		return ratingDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public RatingDto findById(long id) {
		return ratingDao.findById(Rating.class, id).toDto();
	}
}
