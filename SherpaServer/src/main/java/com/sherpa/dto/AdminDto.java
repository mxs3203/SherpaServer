package com.sherpa.dto;

public class AdminDto {
	
	private long adminId;
	private String username;
	private String password;	
	
	public AdminDto(long adminId, String username, String password) {
		this.adminId = adminId;
		this.username = username;
		this.password = password;
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
	
	
}
