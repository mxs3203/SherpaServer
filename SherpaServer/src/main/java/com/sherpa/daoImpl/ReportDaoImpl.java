package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.ReportDao;
import com.sherpa.model.Report;

/**
 * Home object for domain model class Report.
 * 
 * @see .Report
 * @author Hibernate Tools
 */
@Repository
public class ReportDaoImpl implements ReportDao {

	private static final Log log = LogFactory.getLog(ReportDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Report transientInstance) {
		log.debug("persisting Report instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Report persistentInstance) {
		log.debug("removing Report instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Report merge(Report detachedInstance) {
		log.debug("merging Report instance");
		try {
			Report result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Report findById(long id) {
		log.debug("getting Report instance with id: " + id);
		try {
			Report instance = entityManager.find(Report.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
