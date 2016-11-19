package com.sherpa.dao;

import com.sherpa.dto.Rating;

public interface RatingDao {

	void persist(Rating transientInstance);

	void remove(Rating persistentInstance);

	Rating merge(Rating detachedInstance);

	Rating findById(Long id);

}
