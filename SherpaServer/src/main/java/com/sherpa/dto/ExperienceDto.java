package com.sherpa.dto;

import java.math.BigDecimal;

import com.sherpa.model.Experience;

public class ExperienceDto {

	private long experienceId;
	private long user;
	private int experience;
	private BigDecimal cumulativeRating;

	public ExperienceDto() {
	}

	public long getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(long experienceId) {
		this.experienceId = experienceId;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public BigDecimal getCumulativeRating() {
		return cumulativeRating;
	}

	public void setCumulativeRating(BigDecimal cumulativeRating) {
		this.cumulativeRating = cumulativeRating;
	}

	/* TODO! */
	public Experience toModel() {
		Experience experience = new Experience();
		return experience;
	}

}
