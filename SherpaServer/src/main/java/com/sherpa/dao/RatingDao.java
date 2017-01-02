package com.sherpa.dao;

import com.sherpa.model.Rating;

public interface RatingDao {

	void persist(Rating transientInstance);

	void remove(Rating persistentInstance);

	Rating merge(Rating detachedInstance);

	Rating findById(long id);

}
