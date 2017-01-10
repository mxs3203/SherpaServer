package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AchievementDao;
import com.sherpa.model.Achievement;

@Repository
public class AchievementDaoImpl extends GenericDaoImpl<Achievement> implements AchievementDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Achievement transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Class<Achievement> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public Achievement merge(Achievement detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Achievement findById(Class<Achievement> clazz, long id) {
		return super.findById(clazz, id);
	}

}
