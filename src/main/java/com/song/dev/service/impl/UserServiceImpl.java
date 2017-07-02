package com.song.dev.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.dev.dao.BaseDao;
import com.song.dev.mapper.UserMapper;
import com.song.dev.model.User;
import com.song.dev.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private BaseDao<User> baseDao;
	
	@Override
	public User getUserById(String userId) {
		/*User u = new User();
		u.setAge(11);
		u.setUserName("mybatis");
		userMapper.insert(u);
		
		u.setId(null);
		u.setUserName("hiber");
		baseDao.save(u);
		throw new RuntimeException("编号已经存在");*/
		return baseDao.getById(User.class, userId);
	}

	@Override
	public String createUser() {
		User u = new User();
		u.setAge(21);
		u.setUserName("mybatis");
		userMapper.insert(u);
		u.setId(null);
		u.setUserName("hibernate");
		baseDao.saveOrUpdate(u);
		//throw new RuntimeException("编号已经存在");
		return null;
	}

}
