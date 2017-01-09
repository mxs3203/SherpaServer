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

	private static final Logger log = LoggerFactory.getLogger(TagDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(final T transientInstance) {
		log.debug("persisting " + transientInstance.getClass().getName() + " instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(final T persistentInstance) {
		log.debug("removing " + persistentInstance.getClass().getName() + " instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public T merge(final T detachedInstance) {
		log.debug("merging " + detachedInstance.getClass().getName() + " instance");
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
		log.debug("getting " + clazz.getName() + " instance with id: " + id);
		try {
			T instance = entityManager.find(clazz, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Set<T> getAll(final Class<T> clazz) {
		return Util.castSet(clazz,
				entityManager.createQuery("FROM " + clazz + " i WHERE i.deleted = 0").getResultList());
	}

}
