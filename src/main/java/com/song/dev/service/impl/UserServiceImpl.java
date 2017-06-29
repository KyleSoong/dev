package com.song.dev.service.impl;

import com.song.dev.model.User;
import com.song.dev.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public User getUserById(int userId) {
		User user = new User();
		user.setId(100);
		user.setPassword("123");
		user.setUserName("Kyle");
		user.setRole(2001);
		user.setFlag(0);
		return user;
	}

}
