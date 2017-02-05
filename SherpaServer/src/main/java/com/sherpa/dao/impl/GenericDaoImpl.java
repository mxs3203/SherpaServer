package com.sherpa.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.GenericDao;
import com.sherpa.util.Util;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

	private static final Logger log = LoggerFactory.getLogger(GenericDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(final T transientInstance) {
		log.debug("persisting {} instance", transientInstance.getClass().getName());
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(final Class<T> clazz, long id) {
		log.debug("removing {} instance with ID: {}", clazz.getName(), id);
		try {
			entityManager.remove(entityManager.getReference(clazz, id));
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* OLD remove method - throws exception */
	/*
	 * @Override public void remove(final T persistentInstance) {
	 * log.debug("removing {} instance",
	 * persistentInstance.getClass().getName()); try {
	 * entityManager.remove(persistentInstance); log.debug("remove successful");
	 * } catch (RuntimeException re) { log.error("remove failed", re); throw re;
	 * } }
	 */

	@Override
	public T merge(final T detachedInstance) {
		log.debug("merging {} instance", detachedInstance.getClass().getName());
		try {
			T result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public T findById(final Class<T> clazz, long id) {
		log.debug("getting {} instance with ID: {}", clazz.getName(), id);
		try {
			T instance = entityManager.find(clazz, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* TODO! named parameter u FROM :clazz? */
	@Override
	public Set<T> getAll(final Class<T> clazz) {
		log.debug("getting all instances of model: {}", clazz.getName());
		return Util.castSet(clazz, entityManager.createQuery("FROM " + clazz.getName()).getResultList());
	}

}
