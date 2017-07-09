package com.song.dev.service.impl;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.dev.dao.UserAuthDaoImpl;
import com.song.dev.dao.UserInfoDaoImpl;
import com.song.dev.mapper.UserMapper;
import com.song.dev.model.UserAuth;
import com.song.dev.model.UserInfo;
import com.song.dev.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;
	@Autowired
	private UserInfoDaoImpl userInfoDao;
	@Autowired
	private UserAuthDaoImpl userAuthDao;
	
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
		Serializable uh = userInfoDao.save(u);
		System.out.println("return:" + uh + "id:" + u.getId());
		//throw new RuntimeException("编号已经存在");
		return u.getId().toString();
	}

	@Override
	public UserInfo createUser(UserInfo uInfo, UserAuth uAuth) {
		LocalDateTime nowTime = LocalDateTime.now();
		uInfo.setUpdateTime(nowTime);
		uInfo.setCreateTime(nowTime);
		uAuth.setCreateTime(nowTime);
		uAuth.setUpdateTime(nowTime);
		userInfoDao.save(uInfo);
		uAuth.setUserId(uInfo.getId());
		uAuth.setIsDelete(false);
		uAuth.setLocked(false);
		userAuthDao.save(uAuth);
		return uInfo;
	}

	@Override
	public UserAuth getUserAuthByIdentifier(String identifier) {
		return userAuthDao.getUniqueByProperties(UserAuth.class, new String[]{"identifier"} , new String[]{identifier});
	}
}
