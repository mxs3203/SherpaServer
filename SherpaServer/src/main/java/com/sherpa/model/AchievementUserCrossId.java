package com.sherpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AchievementUserCrossId implements java.io.Serializable {

	private static final long serialVersionUID = -5583825163881349033L;
	private int achievementUserId;
	private int userId;
	private int achievementId;

	public AchievementUserCrossId() {
	}

	@Column(name = "achievement_user_id", nullable = false)
	public int getAchievementUserId() {
		return this.achievementUserId;
	}

	public void setAchievementUserId(int achievementUserId) {
		this.achievementUserId = achievementUserId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "achievement_id", nullable = false)
	public int getAchievementId() {
		return this.achievementId;
	}

	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AchievementUserCrossId))
			return false;
		AchievementUserCrossId castOther = (AchievementUserCrossId) other;

		return (this.getAchievementUserId() == castOther.getAchievementUserId())
				&& (this.getUserId() == castOther.getUserId())
				&& (this.getAchievementId() == castOther.getAchievementId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getAchievementUserId();
		result = 37 * result + this.getUserId();
		result = 37 * result + this.getAchievementId();
		return result;
	}

}
