package com.sherpa.service;

import com.sherpa.dto.CurrencyDto;

public interface CurrencyService {

	CurrencyDto add(CurrencyDto transientInstance);

	void remove(long id);

	CurrencyDto update(CurrencyDto detachedInstance);

	CurrencyDto findById(long id);

}
