package com.sherpa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sherpa.dto.UserDto;

@Entity
@Table(name = "user", catalog = "sherpa", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 4786791258478439634L;

	private long userId;
	private Location location;
	private String email;
	private String password;
	private String fullName;
	private int gender;
	private String profileImageUrl;
	private String backgroundImageUrl;
	private String description;
	private String country;
	private String hometown;
	private String address;
	private String telephone;
	private Boolean isSherpa;
	private Boolean isReported;
	private Set<Rating> ratings = new HashSet<Rating>(0);
	private Set<Reward> rewards = new HashSet<Reward>(0);
	private Set<AchievementUserCross> achievementUserCrosses = new HashSet<AchievementUserCross>(0);
	private Set<Report> reportsForUserId = new HashSet<Report>(0);
	private Set<Experience> experiences = new HashSet<Experience>(0);
	private Set<Report> reportsForSherpaId = new HashSet<Report>(0);
	private Set<EventUserCross> eventUserCrosses = new HashSet<EventUserCross>(0);
	private Set<Event> events = new HashSet<Event>(0);

	public User() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Column(name = "email", unique = true, nullable = false, length = 320)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name", nullable = false, length = 64)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "gender", nullable = false)
	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Column(name = "profile_image_url", nullable = false, length = 256)
	public String getProfileImageUrl() {
		return this.profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	@Column(name = "background_image_url", nullable = false, length = 256)
	public String getBackgroundImageUrl() {
		return this.backgroundImageUrl;
	}

	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}

	@Column(name = "description", length = 128)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "country", length = 128)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "hometown", length = 128)
	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	@Column(name = "address", length = 128)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "telephone", length = 64)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "is_sherpa")
	public Boolean getIsSherpa() {
		return this.isSherpa;
	}

	public void setIsSherpa(Boolean isSherpa) {
		this.isSherpa = isSherpa;
	}

	@Column(name = "is_reported")
	public Boolean getIsReported() {
		return this.isReported;
	}

	public void setIsReported(Boolean isReported) {
		this.isReported = isReported;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Reward> getRewards() {
		return this.rewards;
	}

	public void setRewards(Set<Reward> rewards) {
		this.rewards = rewards;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<AchievementUserCross> getAchievementUserCrosses() {
		return this.achievementUserCrosses;
	}

	public void setAchievementUserCrosses(Set<AchievementUserCross> achievementUserCrosses) {
		this.achievementUserCrosses = achievementUserCrosses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByUserId")
	public Set<Report> getReportsForUserId() {
		return this.reportsForUserId;
	}

	public void setReportsForUserId(Set<Report> reportsForUserId) {
		this.reportsForUserId = reportsForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userBySherpaId")
	public Set<Report> getReportsForSherpaId() {
		return this.reportsForSherpaId;
	}

	public void setReportsForSherpaId(Set<Report> reportsForSherpaId) {
		this.reportsForSherpaId = reportsForSherpaId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<EventUserCross> getEventUserCrosses() {
		return this.eventUserCrosses;
	}

	public void setEventUserCrosses(Set<EventUserCross> eventUserCrosses) {
		this.eventUserCrosses = eventUserCrosses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@Fetch(FetchMode.JOIN)
	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	/* TODO! */
	public UserDto toDto() {
		UserDto userDto = new UserDto();

		userDto.setUserId(userId);

		/* userDto.setLocation(location.getLocationId()); */

		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setFullName(fullName);
		userDto.setGender(gender);
		userDto.setProfileImageUrl(profileImageUrl);
		userDto.setBackgroundImageUrl(backgroundImageUrl);
		userDto.setDescription(description);
		userDto.setCountry(country);
		userDto.setHometown(hometown);
		userDto.setAddress(address);
		userDto.setTelephone(telephone);
		userDto.setIsSherpa(isSherpa);
		userDto.setIsReported(isReported);

		/*
		 * userDto.setRatings(ratings.toDto); userDto.setRewards(rewards.toDto);
		 * userDto.setReportsForUserId(reportsForUserId.toDto);
		 * userDto.setExperiences(experiences.toDto);
		 * userDto.setReportsForSherpaId(reportsForSherpaId.toDto);
		 * userDto.setEvents(events.toDto);
		 */

		return userDto;
	}

}
