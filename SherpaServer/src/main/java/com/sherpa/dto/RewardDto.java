package com.sherpa.dto;

import com.sherpa.model.Reward;
import com.sherpa.model.User;

public class RewardDto {

	private long rewardId;
	private long userId;
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
		return userId;
	}

	public void setUser(long userId) {
		this.userId = userId;
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

	public Reward toModel() {
		Reward reward = new Reward();
		reward.setRewardId(rewardId);

		User user = new User(userId);
		reward.setUser(user);

		reward.setType(type);
		reward.setDescription(description);
		reward.setImageUrl(imageUrl);

		return reward;
	}

}
