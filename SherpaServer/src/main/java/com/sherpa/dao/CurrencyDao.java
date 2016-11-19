package com.sherpa.dao;

import com.sherpa.dto.Currency;

public interface CurrencyDao {

	void persist(Currency transientInstance);

	void remove(Currency persistentInstance);

	Currency merge(Currency detachedInstance);

	Currency findById(Long id);

}
