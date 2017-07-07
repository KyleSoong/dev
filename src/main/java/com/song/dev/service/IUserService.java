package com.song.dev.service;

import com.song.dev.model.UserAuth;
import com.song.dev.model.UserInfo;

public interface IUserService {
    public UserInfo getUserById(Integer userId);
    public String createUser();
    public UserInfo createUser(UserInfo uInfo, UserAuth uAuth);
}
