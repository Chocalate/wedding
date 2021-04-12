package com.lingnan.wedding.admin.config;

import com.lingnan.wedding.admin.service.SystemUserService;
import com.lingnan.wedding.core.entity.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-09 18:27
 **/

@Slf4j
public class SystemUserRealm extends AuthorizingRealm {


    @Autowired
    private SystemUserService systemUserService;

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序的用户、角色以及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return  返回封装了用户信息的 AuthenticationInfo 实例
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();

        SystemUser systemUser = systemUserService.queryByName(name);
        log.info("SystemUser..........{}",systemUser);

        if (systemUser == null){
            throw new AuthenticationException("用户不存在");
        }
       if (systemUser.getLockedFlag() != 0){
           throw new AuthenticationException("用户已冻结");
       }
      // String password = ShiroUtil.salt(token.getPassword(),systemUser.getSalt());
        char[] tokenPassword = token.getPassword();
        String password = String.valueOf(tokenPassword);
        log.info("password................{}",password);
        if(!systemUser.getPassword().equals(password)){
           throw new AuthenticationException("密码错误");
       }


        return new SimpleAuthenticationInfo(systemUser, token.getPassword(), getName());
    }

    /**
     * 授权认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SystemUser systemUser = (SystemUser)principalCollection.getPrimaryPrincipal();
        //获取角色权限
        String permissionList = systemUser.getPermission();
        //添加角色权限
        List<String> permissions = Arrays.asList(permissionList.split(","));
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

}
