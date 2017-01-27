package com.sherpa.dto;

import java.math.BigDecimal;

import com.sherpa.model.Experience;
import com.sherpa.model.User;

public class ExperienceDto {

	private long experienceId;
	private long userId;
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
		return userId;
	}

	public void setUser(long userId) {
		this.userId = userId;
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

	public Experience toModel() {
		Experience experience = new Experience();

		experience.setExperienceId(experienceId);

		User user = new User(userId);
		experience.setUser(user);

		experience.setExperience(this.experience);
		experience.setCumulativeRating(cumulativeRating);

		return experience;
	}

}
