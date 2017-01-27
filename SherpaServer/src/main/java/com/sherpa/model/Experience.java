package com.sherpa.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sherpa.dto.ExperienceDto;

@Entity
@Table(name = "experience", catalog = "sherpa", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class Experience implements java.io.Serializable {

	private static final long serialVersionUID = -4642570910310904770L;

	private long experienceId;
	private User user;
	private int experience;
	private BigDecimal cumulativeRating;

	public Experience() {
	}

	public Experience(long experienceId) {
		this.experienceId = experienceId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "experience_id", unique = true, nullable = false)
	public long getExperienceId() {
		return this.experienceId;
	}

	public void setExperienceId(long experienceId) {
		this.experienceId = experienceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", unique = true, nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "experience", nullable = false)
	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Column(name = "cumulative_rating", nullable = false, precision = 1, scale = 1)
	public BigDecimal getCumulativeRating() {
		return this.cumulativeRating;
	}

	public void setCumulativeRating(BigDecimal cumulativeRating) {
		this.cumulativeRating = cumulativeRating;
	}

	/* TODO! */
	public ExperienceDto toDto() {
		ExperienceDto experienceDto = new ExperienceDto();
		experienceDto.setExperienceId(experienceId);

		/* experienceDto.setUser(user.getUserId()); */

		experienceDto.setExperience(experience);
		experienceDto.setUser(user.getUserId());
		experienceDto.setCumulativeRating(cumulativeRating);
		return experienceDto;
	}

}
