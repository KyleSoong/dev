package com.song.dev.mapper;

import java.util.List;

import com.song.dev.model.UserAuth;
import com.song.dev.model.UserInfo;

public interface UserMapper {
	public Integer insertUserInfo(UserInfo userInfo);
	public List<UserAuth> getUserByName(String userName);
	public void delete(int id);
	public List<UserAuth> getUserList();
	public void update(UserAuth u);
	public List<UserAuth> getUserById(int id);
}
