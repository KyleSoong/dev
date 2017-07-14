package com.song.dev.model;

import java.io.Serializable;

public class Permission implements Serializable{

	private static final long serialVersionUID = 282573928077367275L;
	private Long id;
	private String url;
	private String description;
	private Boolean isActivated;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
