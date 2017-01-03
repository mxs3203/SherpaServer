package com.sherpa.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDto {

	private long userId;
	private long location;
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

	private Set<RatingDto> ratings = new HashSet<RatingDto>(0);
	private Set<RewardDto> rewards = new HashSet<RewardDto>(0);
	private Set<ReportDto> reportsForUserId = new HashSet<ReportDto>(0);
	private Set<ExperienceDto> experiences = new HashSet<ExperienceDto>(0);
	private Set<ReportDto> reportsForSherpaId = new HashSet<ReportDto>(0);
	private Set<EventDto> events = new HashSet<EventDto>(0);

	public UserDto() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getLocation() {
		return location;
	}

	public void setLocation(long location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}

	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Boolean getIsSherpa() {
		return isSherpa;
	}

	public void setIsSherpa(Boolean isSherpa) {
		this.isSherpa = isSherpa;
	}

	public Boolean getIsReported() {
		return isReported;
	}

	public void setIsReported(Boolean isReported) {
		this.isReported = isReported;
	}

	public Set<RatingDto> getRatings() {
		return ratings;
	}

	public void setRatings(Set<RatingDto> ratings) {
		this.ratings = ratings;
	}

	public Set<RewardDto> getRewards() {
		return rewards;
	}

	public void setRewards(Set<RewardDto> rewards) {
		this.rewards = rewards;
	}

	public Set<ReportDto> getReportsForUserId() {
		return reportsForUserId;
	}

	public void setReportsForUserId(Set<ReportDto> reportsForUserId) {
		this.reportsForUserId = reportsForUserId;
	}

	public Set<ExperienceDto> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<ExperienceDto> experiences) {
		this.experiences = experiences;
	}

	public Set<ReportDto> getReportsForSherpaId() {
		return reportsForSherpaId;
	}

	public void setReportsForSherpaId(Set<ReportDto> reportsForSherpaId) {
		this.reportsForSherpaId = reportsForSherpaId;
	}

	public Set<EventDto> getEvents() {
		return events;
	}

	public void setEvents(Set<EventDto> events) {
		this.events = events;
	}

}
