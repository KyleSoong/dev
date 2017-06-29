package com.song.dev.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.dev.mapper.UserMapper;
import com.song.dev.model.User;
import com.song.dev.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int userId) {
		List <User> userList = userMapper.getUserById(userId);
		if(userList == null ) return null;
		else return userList.get(0);
	}

}
