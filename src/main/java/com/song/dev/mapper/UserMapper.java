package com.song.dev.mapper;

import java.util.List;

import com.song.dev.model.UserAuth;
import com.song.dev.model.UserInfo;

public interface UserMapper {
	public Integer insertUserInfo(UserInfo userInfo);
	public UserInfo getUserInfoById(int id);
	public List<UserInfo> getUserInfoByName(String userName);
	public List<UserInfo> getUserInfoList();
	public void delete(int id);
	public void update(UserAuth u);
}
