package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.RewardDao;
import com.sherpa.dto.Reward;

/**
 * Home object for domain model class Reward.
 * 
 * @see .Reward
 * @author Hibernate Tools
 */
@Repository
public class RewardDaoImpl implements RewardDao {

	private static final Log log = LogFactory.getLog(RewardDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Reward transientInstance) {
		log.debug("persisting Reward instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Reward persistentInstance) {
		log.debug("removing Reward instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Reward merge(Reward detachedInstance) {
		log.debug("merging Reward instance");
		try {
			Reward result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Reward findById(Long id) {
		log.debug("getting Reward instance with id: " + id);
		try {
			Reward instance = entityManager.find(Reward.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
