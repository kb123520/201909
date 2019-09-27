package com.lanxin.shiroconfig;

import com.lanxin.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by 张燕彭 on 2019/9/25.
 */
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;
    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       String username= (String) principalCollection.getPrimaryPrincipal();
       List<String> roles= (List<String>) userService.getRolesByUsername(username).getData();
        List<String> permissions= (List<String>) userService.getPermissionsByUsername(username).getData();
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        simpleAuthorizationInfo.addRoles(roles);
        return simpleAuthorizationInfo;
    }




    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        String password=(String)userService.getPassByUsername(username).getData();
        if(password!=null){
            SimpleAuthenticationInfo simpleAuthenticationInfo=
                    new SimpleAuthenticationInfo(username,password,"customRealm");
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("lanxin"));
            return simpleAuthenticationInfo;
        }


        return null;
    }


}
