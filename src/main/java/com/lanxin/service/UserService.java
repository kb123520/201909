package com.lanxin.service;

import com.lanxin.util.Result;

import java.util.List;
import java.util.Set;

/**
 * Created by 张燕彭 on 2019/9/26.
 */
public interface UserService {
    Result findAllUser();

    Result getPassByUsername(String username);


    Result getRolesByUsername(String username);

    Result getPermissionsByUsername(String username);
}
