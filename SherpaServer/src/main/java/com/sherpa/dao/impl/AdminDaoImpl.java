package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AdminDao;
import com.sherpa.model.Admin;

@Repository
public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao {

	private static final Log log = LogFactory.getLog(AdminDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persist(Admin transientInstance) {
		
		super.persist(transientInstance);
		
		/*
		log.debug("persisting Admin instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		*/
	}

	public void remove(Admin persistentInstance) {
		
		super.remove(persistentInstance);
		
		/*log.debug("removing Admin instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
		*/
	}

	public Admin merge(Admin detachedInstance) {
		
		return super.merge(detachedInstance);
		
		/*
		log.debug("merging Admin instance");
		try {
			Admin result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
		*/
	}

	public Admin findById(long id) {
		
		return super.findById(Admin.class, id);
		
		/*
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = entityManager.find(Admin.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		*/
	}

	public Admin verifyAdmin(String username, String password) {
		log.debug("getting Admin instance with username: " + username + " password: " + password);
		try {
			Query query = entityManager
					.createQuery("FROM Admin a WHERE a.username = :username AND a.password = :password")
					.setParameter("email", username).setParameter("password", password);

			Admin admin = (Admin) query.getSingleResult();

			log.debug("get successful");
			return admin;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}
}
