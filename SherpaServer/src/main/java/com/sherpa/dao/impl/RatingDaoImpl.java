package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.RatingDao;
import com.sherpa.model.Rating;

@Repository
public class RatingDaoImpl extends GenericDaoImpl<Rating> implements RatingDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Rating persist(Rating transientInstance) {
		return super.persist(transientInstance);
	}

	@Override
	public void remove(Class<Rating> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public Rating merge(Rating detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Rating findById(Class<Rating> clazz, long id) {
		return super.findById(clazz, id);
	}

}
