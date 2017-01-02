package com.sherpa.dto;

import java.math.BigDecimal;


public class ExperienceDto {

	private long experienceId;
	private long user;
	private int experience;
	private BigDecimal cumulativeRating;
		
	public ExperienceDto(long experienceId, long user, int experience, BigDecimal cumulativeRating) {
		this.experienceId = experienceId;
		this.user = user;
		this.experience = experience;
		this.cumulativeRating = cumulativeRating;
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
	
}
