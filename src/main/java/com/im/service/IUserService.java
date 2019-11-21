package com.im.service;

import com.im.entity.UserEntity;

public interface IUserService {
    UserEntity selectUser(long userId);

    int insert(UserEntity user);
}
