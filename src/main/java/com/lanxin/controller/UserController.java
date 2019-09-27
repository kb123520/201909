package com.lanxin.controller;

import com.lanxin.service.UserService;
import com.lanxin.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张燕彭 on 2019/9/26.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public Result login(String username,String password){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            return Result.ok("登陆成功");
        } catch (IncorrectCredentialsException e1){
            return Result.failed(10001,"密码错误");
        }catch (AuthenticationException e) {
            return Result.failed(10000,"用户不存在");
        }catch (Exception e2){
            return Result.failed(10003,"登陆失败");
        }

    }

    @RequestMapping(value = "/logout")
    public Result logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();//退出
        return Result.ok("退出成功");
    }

    @RequestMapping(value = "/unauth")
    public Result unauth(){
        return Result.failed(10001,"未登录");
    }
}
