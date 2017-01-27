package com.sherpa.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sherpa.dto.AchievementDto;

@Entity
@Table(name = "achievement", catalog = "sherpa")
public class Achievement implements java.io.Serializable {

	private static final long serialVersionUID = -617289165341633079L;

	private long achievementId;
	private String imageUrl;
	private String description;
	private BigDecimal requirement;
	private Set<AchievementUserCross> achievementUserCrosses = new HashSet<AchievementUserCross>(0);

	public Achievement() {
	}

	public Achievement(long achievementId) {
		this.achievementId = achievementId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "achievement_id", unique = true, nullable = false)
	public long getAchievementId() {
		return this.achievementId;
	}

	public void setAchievementId(long achievementId) {
		this.achievementId = achievementId;
	}

	@Column(name = "image_url", nullable = false, length = 256)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "description", nullable = false, length = 128)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "requirement", nullable = false, precision = 7)
	public BigDecimal getRequirement() {
		return this.requirement;
	}

	public void setRequirement(BigDecimal requirement) {
		this.requirement = requirement;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "achievement")
	public Set<AchievementUserCross> getAchievementUserCrosses() {
		return this.achievementUserCrosses;
	}

	public void setAchievementUserCrosses(Set<AchievementUserCross> achievementUserCrosses) {
		this.achievementUserCrosses = achievementUserCrosses;
	}

	public AchievementDto toDto() {
		AchievementDto achievementDto = new AchievementDto();

		achievementDto.setAchievementId(achievementId);
		achievementDto.setImageUrl(imageUrl);
		achievementDto.setDescription(description);
		achievementDto.setRequirement(requirement);

		return achievementDto;
	}

}
