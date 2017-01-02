package com.sherpa.dto;

import java.math.BigDecimal;

public class AchievementDto {
	private long achievementId;
	private String imageUrl;
	private String description;
	private BigDecimal requirement;
	
	
	public AchievementDto(long achievementId, String imageUrl, String description, BigDecimal requirement) {
		this.achievementId = achievementId;
		this.imageUrl = imageUrl;
		this.description = description;
		this.requirement = requirement;
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
	
	
}
