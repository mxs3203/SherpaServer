package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.CurrencyDao;
import com.sherpa.model.Currency;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {

	private static final Log log = LogFactory.getLog(CurrencyDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Currency transientInstance) {
		log.debug("persisting Currency instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Currency persistentInstance) {
		log.debug("removing Currency instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Currency merge(Currency detachedInstance) {
		log.debug("merging Currency instance");
		try {
			Currency result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Currency findById(long id) {
		log.debug("getting Currency instance with id: " + id);
		try {
			Currency instance = entityManager.find(Currency.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* TODO! refactor */
	@Override
	public Currency findByCurrencyIso(String iso) {
		log.debug("getting Currency instance with iso: " + iso);
		try {
			Currency instance;
			Query query = entityManager.createQuery("FROM Currency c WHERE c.iso = :iso");
			query.setParameter("iso", iso);
			instance = (Currency) query.getSingleResult();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
