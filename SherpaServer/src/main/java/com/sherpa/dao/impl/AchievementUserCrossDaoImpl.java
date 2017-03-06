package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AchievementUserCrossDao;
import com.sherpa.model.AchievementUserCross;

@Repository
public class AchievementUserCrossDaoImpl extends GenericDaoImpl<AchievementUserCross>
		implements AchievementUserCrossDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AchievementUserCross persist(AchievementUserCross transientInstance) {
		return super.persist(transientInstance);
	}

	@Override
	public void remove(Class<AchievementUserCross> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public AchievementUserCross merge(AchievementUserCross detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public AchievementUserCross findById(Class<AchievementUserCross> clazz, long id) {
		return super.findById(clazz, id);
	}

}
