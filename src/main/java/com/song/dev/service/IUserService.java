package com.song.dev.service;

import com.song.dev.model.User;

public interface IUserService {
    public User getUserById(String userId);
    public String createUser();
}
