package com.sherpa.dao;

import com.sherpa.model.Rating;

public interface RatingDao extends GenericDao<Rating> {

	void persist(Rating transientInstance);

	void remove(Rating persistentInstance);

	Rating merge(Rating detachedInstance);

	Rating findById(Class<Rating> clazz, long id);

}
