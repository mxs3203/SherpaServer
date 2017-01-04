package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.RewardDao;
import com.sherpa.model.Reward;

@Repository
public class RewardDaoImpl extends GenericDaoImpl<Reward> implements RewardDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Reward transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Reward persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public Reward merge(Reward detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Reward findById(Class<Reward> clazz, long id) {
		return super.findById(clazz, id);
	}

}
