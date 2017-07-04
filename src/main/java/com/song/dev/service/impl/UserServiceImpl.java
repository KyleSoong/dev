package com.song.dev.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.dev.dao.BaseDao;
import com.song.dev.mapper.UserMapper;
import com.song.dev.model.UserInfo;
import com.song.dev.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private BaseDao<UserInfo> baseDao;
	
	@Override
	public UserInfo getUserById(Integer userId) {
		UserInfo ui = userMapper.getUserInfoById(Integer.valueOf(userId));
		//UserInfo ui = baseDao.getById(UserInfo.class, userId);
		//throw new RuntimeException("编号已经存在");
		return ui;
	}

	@Override
	public String createUser() {
		UserInfo u = UserInfo.newUser();
		u.setIntroduce("我来自MyBatis！");
		Integer um = userMapper.insertUserInfo(u);
		System.out.println("数量："+um.toString()+">>>id:"+u.getId());
		u.setId(null);
		u.setIntroduce("我来自Hibernate！");
		Serializable uh = baseDao.save(u);
		System.out.println("return:" + uh + "id:" + u.getId());
		//throw new RuntimeException("编号已经存在");
		return u.getId().toString();
	}
}
