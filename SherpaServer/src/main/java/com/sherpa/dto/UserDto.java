package com.sherpa.dto;

import com.sherpa.model.User;

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
	
	public UserDto() {
	}
	
	public UserDto(long userId, long location, String email, String password, String fullName, int gender,
			String profileImageUrl, String backgroundImageUrl, String description, String country, String hometown,
			String address, String telephone, Boolean isSherpa, Boolean isReported) {
		this.userId = userId;
		this.location = location;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.profileImageUrl = profileImageUrl;
		this.backgroundImageUrl = backgroundImageUrl;
		this.description = description;
		this.country = country;
		this.hometown = hometown;
		this.address = address;
		this.telephone = telephone;
		this.isSherpa = isSherpa;
		this.isReported = isReported;
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
	
	public User generateEntity(){

		User user = new User(this.getFullName(), this.getEmail(), this.getPassword(), this.getGender(), this.getHometown());
		return user;
	}

}

