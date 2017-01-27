package com.sherpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sherpa.dto.RewardDto;

@Entity
@Table(name = "reward", catalog = "sherpa")
public class Reward implements java.io.Serializable {

	private static final long serialVersionUID = -6558505191072952798L;

	private long rewardId;
	private User user;
	private int type;
	private String description;
	private String imageUrl;

	public Reward() {
	}

	public Reward(long rewardId) {
		this.rewardId = rewardId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "reward_id", unique = true, nullable = false)
	public long getRewardId() {
		return this.rewardId;
	}

	public void setRewardId(long rewardId) {
		this.rewardId = rewardId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "description", nullable = false, length = 256)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image_url", nullable = false, length = 256)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/* TODO! */
	public RewardDto toDto() {
		RewardDto rewardDto = new RewardDto();

		rewardDto.setRewardId(rewardId);

		/* rewardDto.setUser(user.getUserId()); */

		rewardDto.setType(type);
		rewardDto.setDescription(description);
		rewardDto.setImageUrl(imageUrl);

		return rewardDto;
	}

}
