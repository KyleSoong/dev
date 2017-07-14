package com.song.dev.model;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = -4209005819498609052L;
	private Long userId;
	private Long roleId;
	private Boolean isActivated;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Boolean getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
}
