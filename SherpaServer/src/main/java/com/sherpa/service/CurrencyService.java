package com.sherpa.service;

import com.sherpa.dto.Currency;

public interface CurrencyService {

	void addCurrency(Currency transientInstance);

	void removeCurrency(Currency persistentInstance);

	Currency updateCurrency(Currency detachedInstance);

	Currency findById(Long id);

}
