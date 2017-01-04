package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.ExperienceDao;
import com.sherpa.model.Experience;

@Repository
public class ExperienceDaoImpl extends GenericDaoImpl<Experience> implements ExperienceDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Experience transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Experience persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public Experience merge(Experience detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Experience findById(Class<Experience> clazz, long id) {
		return super.findById(clazz, id);
	}

}
