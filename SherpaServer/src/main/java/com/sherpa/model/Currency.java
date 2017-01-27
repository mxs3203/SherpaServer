package com.sherpa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sherpa.dto.CurrencyDto;

@Entity
@Table(name = "currency", catalog = "sherpa", uniqueConstraints = @UniqueConstraint(columnNames = "iso"))
public class Currency implements java.io.Serializable {

	private static final long serialVersionUID = -3231399653545569101L;

	private long currencyId;
	private String iso;
	private String name;
	private Set<Event> events = new HashSet<Event>(0);

	public Currency() {
	}

	public Currency(long currencyId) {
		this.currencyId = currencyId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "currency_id", unique = true, nullable = false)
	public long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	@Column(name = "iso", unique = true, nullable = false, length = 3)
	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	/* TODO! dodat set evenata? */
	public CurrencyDto toDto() {
		CurrencyDto currencyDto = new CurrencyDto();

		currencyDto.setCurrencyId(currencyId);
		currencyDto.setIso(iso);
		currencyDto.setName(name);

		/* currencyDto.setEvents(events.toDto); */

		return currencyDto;
	}

}
