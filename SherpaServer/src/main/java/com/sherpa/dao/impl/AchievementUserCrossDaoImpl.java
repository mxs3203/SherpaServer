package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AchievementUserCrossDao;
import com.sherpa.model.AchievementUserCross;
import com.sherpa.model.AchievementUserCrossId;

@Repository
public class AchievementUserCrossDaoImpl extends GenericDaoImpl<AchievementUserCross>
		implements AchievementUserCrossDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(AchievementUserCross transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(AchievementUserCross persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public AchievementUserCross merge(AchievementUserCross detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public AchievementUserCross findById(Class<AchievementUserCross> clazz, AchievementUserCrossId id) {
		return super.findById(clazz, id.getAchievementUserId());
	}

}
