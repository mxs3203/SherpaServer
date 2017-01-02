package com.sherpa.dao;

import com.sherpa.model.Currency;

public interface CurrencyDao {

	void persist(Currency transientInstance);

	void remove(Currency persistentInstance);

	Currency merge(Currency detachedInstance);

	Currency findById(long id);

	Currency findByCurrencyIso(String iso);

}
