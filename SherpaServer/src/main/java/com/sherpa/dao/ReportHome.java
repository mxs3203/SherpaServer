package com.sherpa.dao;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.Report;

/**
 * Home object for domain model class Report.
 * @see .Report
 * @author Hibernate Tools
 */
@Stateless
public class ReportHome {

	private static final Log log = LogFactory.getLog(ReportHome.class);

	@PersistenceContext
	private EntityManager entityManager;

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

	public Report findById(Integer id) {
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
