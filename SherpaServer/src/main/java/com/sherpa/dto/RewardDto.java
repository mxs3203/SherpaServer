package com.sherpa.dto;

public class RewardDto {

	private long rewardId;
	private long user;
	private int type;
	private String description;
	private String imageUrl;

	public RewardDto() {
	}

	public long getRewardId() {
		return rewardId;
	}

	public void setRewardId(long rewardId) {
		this.rewardId = rewardId;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
