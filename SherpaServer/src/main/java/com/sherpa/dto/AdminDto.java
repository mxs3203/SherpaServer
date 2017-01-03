package com.sherpa.dto;

import com.sherpa.model.Admin;

public class AdminDto {

	private long adminId;
	private String username;
	private String password;

	public AdminDto() {
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin toModel() {
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setUsername(username);
		admin.setPassword(password);
		return admin;
	}

}
