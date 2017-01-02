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
	public void addCurrency(Currency transientInstance) {
		currencyDao.persist(transientInstance);
	}

	@Override
	public void removeCurrency(Currency persistentInstance) {
		currencyDao.remove(persistentInstance);
	}

	@Override
	public Currency updateCurrency(Currency detachedInstance) {
		return currencyDao.merge(detachedInstance);
	}

	@Override
	public Currency findById(long id) {
		return currencyDao.findById(id);
	}

}
