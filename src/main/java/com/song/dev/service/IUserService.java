package com.song.dev.service;

import com.song.dev.model.UserInfo;

public interface IUserService {
    public UserInfo getUserById(String userId);
    public String createUser();
}
