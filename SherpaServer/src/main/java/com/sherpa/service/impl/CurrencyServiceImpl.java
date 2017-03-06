package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.CurrencyDao;
import com.sherpa.dto.CurrencyDto;
import com.sherpa.model.Currency;
import com.sherpa.service.CurrencyService;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDao currencyDao;

	@Override
	public CurrencyDto add(CurrencyDto transientInstance) {
		return currencyDao.persist(transientInstance.toModel()).toDto();
	}

	@Override
	public void remove(long id) {
		currencyDao.remove(Currency.class, id);
	}

	@Override
	public CurrencyDto update(CurrencyDto detachedInstance) {
		return currencyDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public CurrencyDto findById(long id) {
		return currencyDao.findById(Currency.class, id).toDto();
	}

}
