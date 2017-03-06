package com.sherpa.service;

import com.sherpa.dto.RatingDto;

public interface RatingService {

	RatingDto add(RatingDto transientInstance);

	void remove(long id);

	RatingDto update(RatingDto detachedInstance);

	RatingDto findById(long id);

}
