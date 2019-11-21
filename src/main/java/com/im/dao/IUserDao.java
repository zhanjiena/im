package com.im.dao;

import com.im.entity.UserEntity;

public interface IUserDao {
    UserEntity selectUser(long id);
}
