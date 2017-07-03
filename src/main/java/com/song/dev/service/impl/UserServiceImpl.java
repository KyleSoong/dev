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
	public UserInfo getUserById(String userId) {
		/*User u = new User();
		u.setAge(11);
		u.setUserName("mybatis");
		userMapper.insert(u);
		
		u.setId(null);
		u.setUserName("hiber");
		baseDao.save(u);
		throw new RuntimeException("编号已经存在");*/
		return baseDao.getById(UserInfo.class, userId);
	}

	@Override
	public String createUser() {
		UserInfo u = new UserInfo();
		u.setAge(21);
		u.setUserName("mybatis");
		Integer um = userMapper.insertUserInfo(u);
		System.out.println("数量："+um.toString()+">>>id:"+u.getId());
		/*u.setId(null);
		u.setUserName("hibernate");
		Serializable uh = baseDao.save(u);
		System.out.println(u.getId());*/
		//throw new RuntimeException("编号已经存在");
		return u.getId();
	}

}
