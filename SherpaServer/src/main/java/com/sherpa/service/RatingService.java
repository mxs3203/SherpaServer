package com.sherpa.service;

import com.sherpa.model.Rating;

public interface RatingService {

	void add(Rating transientInstance);

	void remove(long id);

	Rating update(Rating detachedInstance);

	Rating findById(long id);

}
