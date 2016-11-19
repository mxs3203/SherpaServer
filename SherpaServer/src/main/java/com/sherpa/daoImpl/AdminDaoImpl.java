package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AdminDao;
import com.sherpa.dto.Admin;

/**
 * Home object for domain model class Admin.
 * 
 * @see .Admin
 * @author Hibernate Tools
 */
@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Log log = LogFactory.getLog(AdminDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Admin transientInstance) {
		log.debug("persisting Admin instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Admin persistentInstance) {
		log.debug("removing Admin instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
		try {
			Admin result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Admin findById(Long id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = entityManager.find(Admin.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
