package com.sherpa.dao;

import com.sherpa.model.Currency;

public interface CurrencyDao extends GenericDao<Currency> {

	void persist(Currency transientInstance);

	void remove(Class<Currency> clazz, long id);

	Currency merge(Currency detachedInstance);

	Currency findById(Class<Currency> clazz, long id);

	Currency findByCurrencyIso(String iso);

}
