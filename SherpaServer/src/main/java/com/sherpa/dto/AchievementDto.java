package com.sherpa.dto;

import java.math.BigDecimal;

import com.sherpa.model.Achievement;

public class AchievementDto {

	private long achievementId;
	private String imageUrl;
	private String description;
	private BigDecimal requirement;

	public AchievementDto() {
	}

	public long getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(long achievementId) {
		this.achievementId = achievementId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getRequirement() {
		return requirement;
	}

	public void setRequirement(BigDecimal requirement) {
		this.requirement = requirement;
	}

	/* TODO! */
	public Achievement toModel() {
		Achievement achievement = new Achievement();
		return achievement;
	}

}
