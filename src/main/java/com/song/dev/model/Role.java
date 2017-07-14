package com.song.dev.model;

import java.io.Serializable;

public class Role implements Serializable{

	private static final long serialVersionUID = 5215706466001112396L;
	private Long id;
	private String role;
	private String description;
	private Boolean isActivated;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	@Override
	public String toString() {
		return "Role{"
				+ "id=" + id
				+ ",role=" + role
				+ ",description=" + description
				+ ",isActivated=" + isActivated
				+ "}";
	}
}
