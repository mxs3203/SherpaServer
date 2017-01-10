package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.AdminDao;
import com.sherpa.model.Admin;

@Repository
public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao {

	private static final Logger log = LoggerFactory.getLogger(AdminDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Admin transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Class<Admin> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public Admin merge(Admin detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Admin findById(Class<Admin> clazz, long id) {
		return super.findById(clazz, id);
	}

	public Admin verifyAdmin(String username, String password) {
		log.debug("getting Admin instance with Username: '{}' and Password: '{}'", username, password);
		try {
			Query query = entityManager
					.createQuery("FROM Admin a WHERE a.username = :username AND a.password = :password")
					.setParameter("username", username).setParameter("password", password);

			Admin admin = (Admin) query.getSingleResult();

			log.debug("get successful");
			return admin;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}

	}

}
