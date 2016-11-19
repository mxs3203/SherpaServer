package com.sherpa.service;

import com.sherpa.dto.Rating;

public interface RatingService {

	void addRating(Rating transientInstance);

	void removeRating(Rating persistentInstance);

	Rating updateRating(Rating detachedInstance);

	Rating findById(Long id);

}
