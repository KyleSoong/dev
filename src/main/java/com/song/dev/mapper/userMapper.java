package com.song.dev.mapper;

import java.util.List;

import com.song.dev.model.User;

public interface userMapper {
	public Integer insert(User user);
	public List<User> getUserByName(String userName);
	public void delete(int id);
	public List<User> getUserList();
	public void update(User u);
	public List<User> getUserById(int id);
}
