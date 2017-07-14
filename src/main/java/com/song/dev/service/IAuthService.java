package com.song.dev.service;

import com.song.dev.model.UserAuth;

public interface IAuthService {
	public String encryptPassword(String password);
	public UserAuth encryptPassword(UserAuth uAuth);
	public boolean passwordCorrect(String password, UserAuth uAuth);
}
