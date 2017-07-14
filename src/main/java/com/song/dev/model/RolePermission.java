package com.song.dev.model;

import java.io.Serializable;

public class RolePermission implements Serializable {

	private static final long serialVersionUID = -5219818510601192364L;
	private Long roleId;
	private Long permissionId;
	private Boolean isActivated;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
	public Boolean getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
}
