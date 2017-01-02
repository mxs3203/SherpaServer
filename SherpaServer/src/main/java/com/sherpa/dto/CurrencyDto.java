package com.sherpa.dto;

public class CurrencyDto {
	
	private long currencyId;
	private String iso;
	private String name;
	
	
	
	public CurrencyDto(long currencyId, String iso, String name) {
		this.currencyId = currencyId;
		this.iso = iso;
		this.name = name;
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
	
	
}
