package com.lanxin.service.impl;

import com.lanxin.bean.UserExample;
import com.lanxin.dao.UserMapper;
import com.lanxin.service.UserService;
import com.lanxin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张燕彭 on 2019/9/26.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public Result findAllUser() {
        return Result.ok(userMapper.selectByExample(new UserExample()));
    }

    @Override
    public Result getPassByUsername(String username) {
        return Result.ok(userMapper.getPassByUsername(username));
    }

    @Override
    public Result getRolesByUsername(String username) {
        return Result.ok(userMapper.getRolesByUsername(username));
    }

    @Override
    public Result getPermissionsByUsername(String username) {
        return Result.ok(userMapper.getPermissionsByUsername(username));
    }
}
