package com.song.dev.model;

import java.io.Serializable;
import java.util.Date;

public class UserAuth implements Serializable {
	
	private static final long serialVersionUID = -1487396999413471117L;
	
	private Long id;
	private Long userId;
	private Integer identityType;
	private String identifier;
	private String credential;
	private String salt;
	private Boolean varified;
	private Boolean locked = Boolean.FALSE;
	private Date createTime;
	private Date updateTime;
	private Boolean isDelete;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getIdentityType() {
		return identityType;
	}
	public void setIdentityType(Integer identityType) {
		this.identityType = identityType;
	}
	public Boolean getVarified() {
		return varified;
	}
	public void setVarified(Boolean varified) {
		this.varified = varified;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getCredentialsSalt() {
        return identifier + salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuth userAuth = (UserAuth) o;

        if (id != null ? !id.equals(userAuth.id) : userAuth.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", userId=" + userId + '\'' +
                ", identityType=" + identityType + '\'' +
                ", identifier='" + identifier + '\'' +
                ", credential='" + credential + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
}
