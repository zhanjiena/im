package com.im.service.impl;

import com.im.dao.IUserDao;
import com.im.entity.UserEntity;
import com.im.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public UserEntity selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public int insert(UserEntity user) {
        return 0;
    }
}
