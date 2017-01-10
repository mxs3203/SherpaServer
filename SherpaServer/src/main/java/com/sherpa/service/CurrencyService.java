package com.sherpa.service;

import com.sherpa.model.Currency;

public interface CurrencyService {

	void add(Currency transientInstance);

	void remove(long id);

	Currency update(Currency detachedInstance);

	Currency findById(long id);

}
