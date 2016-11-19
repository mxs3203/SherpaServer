package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.EventTagCrossDao;
import com.sherpa.dto.EventTagCross;
import com.sherpa.dto.EventTagCrossId;

/**
 * Home object for domain model class EventTagCross.
 * 
 * @see .EventTagCross
 * @author Hibernate Tools
 */
@Repository
public class EventTagCrossDaoImpl implements EventTagCrossDao {

	private static final Log log = LogFactory.getLog(EventTagCrossDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(EventTagCross transientInstance) {
		log.debug("persisting EventTagCross instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(EventTagCross persistentInstance) {
		log.debug("removing EventTagCross instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public EventTagCross merge(EventTagCross detachedInstance) {
		log.debug("merging EventTagCross instance");
		try {
			EventTagCross result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public EventTagCross findById(EventTagCrossId id) {
		log.debug("getting EventTagCross instance with id: " + id);
		try {
			EventTagCross instance = entityManager.find(EventTagCross.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
