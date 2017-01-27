package com.sherpa.dto;

import java.util.HashSet;
import java.util.Set;

import com.sherpa.model.Currency;

public class CurrencyDto {

	private long currencyId;
	private String iso;
	private String name;
	private Set<EventDto> events = new HashSet<EventDto>(0);

	public CurrencyDto() {
	}

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EventDto> getEvents() {
		return events;
	}

	public void setEvents(Set<EventDto> events) {
		this.events = events;
	}

	public Currency toModel() {
		Currency currency = new Currency();
		
		currency.setCurrencyId(currencyId);
		currency.setIso(iso);
		currency.setName(name);
		
		/* TODO! Setovi */
		
		return currency;
	}

}
