package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.CurrencyDao;
import com.sherpa.model.Currency;
import com.sherpa.service.CurrencyService;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDao currencyDao;

	@Override
	public void add(Currency transientInstance) {
		currencyDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		currencyDao.remove(Currency.class, id);
	}

	@Override
	public Currency update(Currency detachedInstance) {
		return currencyDao.merge(detachedInstance);
	}

	@Override
	public Currency findById(long id) {
		return currencyDao.findById(Currency.class, id);
	}

}
