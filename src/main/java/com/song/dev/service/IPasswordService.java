package com.song.dev.service;

import com.song.dev.model.UserAuth;

public interface IPasswordService {
	public String encryptPassword(String password);
	public UserAuth encryptPassword(UserAuth uAuth);
}
