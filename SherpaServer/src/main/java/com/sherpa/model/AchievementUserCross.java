package com.sherpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "achievement_user_cross", catalog = "sherpa")
public class AchievementUserCross implements java.io.Serializable {

	private static final long serialVersionUID = 8285861460157082151L;
	
	private AchievementUserCrossId id;
	private Achievement achievement;
	private User user;

	public AchievementUserCross() {
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "achievementUserId", column = @Column(name = "achievement_user_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
			@AttributeOverride(name = "achievementId", column = @Column(name = "achievement_id", nullable = false)) })
	public AchievementUserCrossId getId() {
		return this.id;
	}

	public void setId(AchievementUserCrossId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "achievement_id", nullable = false, insertable = false, updatable = false)
	public Achievement getAchievement() {
		return this.achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
