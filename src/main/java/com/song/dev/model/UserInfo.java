package com.song.dev.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.song.dev.util.Constants;


public class UserInfo implements Serializable {
	private static final long serialVersionUID = -1487396999413471117L;
	
	private Long id;
	private String username;
	private String nickname;
	private String email;
	private String mobile;
	private Integer age;
	private LocalDate birthday;
	private Integer gender;
	private String avatar;
	private String introduce;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	private Boolean isDelete;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	@Override
	public String toString(){
		return "UserInfo{" +
                "id=" + id +
                ", userName=" + username + '\'' +
                ", nickname=" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", age='" + age + '\'' +
                ", birthday=" + birthday + '\'' +
                ", gender=" + gender + '\'' +
                ", createTime=" + createTime + '\'' +
                ", updateTime=" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                '}';
	}
	
	public static UserInfo newUser(){
		LocalDateTime now = LocalDateTime.now();
		UserInfo u = new UserInfo();
		u.setAge(18);
		u.setBirthday(LocalDate.of(1992, 2, 28));
		
		//u.setCreateTime(now);
		//u.setUpdateTime(now);
		u.setEmail("songkh@live.com");
		u.setGender(Constants.Gender.FEMALE);
		u.setIntroduce("爱吃爱玩~");
		u.setMobile("17098996233");
		u.setNickname("张大帅");
		u.setUsername("zhangd");
		return u;
	}
}
