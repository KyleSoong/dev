package com.song.dev.service;

import com.song.dev.model.UserInfo;

public interface IUserService {
    public UserInfo getUserById(Integer userId);
    public String createUser();
}
