package com.sherpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sherpa.dto.AdminDto;

@Entity
@Table(name = "admin", catalog = "sherpa", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Admin implements java.io.Serializable {

	private static final long serialVersionUID = -3478090166342381753L;
	private long adminId;
	private String username;
	private String password;

	public Admin() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admin_id", unique = true, nullable = false)
	public long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	@Column(name = "username", unique = true, nullable = false, length = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminDto toDto() {
		AdminDto adminDto = new AdminDto();
		adminDto.setAdminId(adminId);
		adminDto.setUsername(username);
		adminDto.setPassword(password);
		return adminDto;
	}

}
