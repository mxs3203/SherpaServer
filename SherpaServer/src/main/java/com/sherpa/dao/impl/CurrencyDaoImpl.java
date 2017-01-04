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
public class CurrencyDaoImpl extends GenericDaoImpl<Currency> implements CurrencyDao {

	private static final Log log = LogFactory.getLog(CurrencyDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Currency transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Currency persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public Currency merge(Currency detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Currency findById(Class<Currency> clazz, long id) {
		return super.findById(clazz, id);
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
