package com.lingnan.wedding.admin.config;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-09 10:51
 **/
@Configuration
public class ShiroConfig {

    /**
     * 配置自定义的Realm
     */
    @Bean
    public SystemUserRealm systemUserRealm(){
        return new SystemUserRealm();
    }

    @Bean
    public BusinessRealm businessRealm(){
        return new BusinessRealm();
    }

    /**
     * 注入 securityManager
     */
    @Bean
    public SecurityManager securityManager(@Qualifier("systemUserRealm") SystemUserRealm systemUserRealm){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm
       // securityManager.setRealm(systemUserRealm);
        //设置realm（需要在realm定义之前）
        securityManager.setAuthenticator(modularRealmAuthenticator());
        //添加多个realms
        List<Realm> realms =new ArrayList<Realm>();
        realms.add(systemUserRealm);
        realms.add(businessRealm());
        securityManager.setRealms(realms);
        return securityManager;
    }


    /**
     * 系统自带的Realm管理，主要针对多realm
     */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        //自己重写的ModularRealmAuthenticator
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        //设置认证策略
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }


    /**
     *  配置权限--登陆
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new LinkedHashMap<>();
        //管理操作需要拥有权限
        map.put("/wedding/admin/login","anon");
        map.put("/static/**","anon");
        map.put("/wedding/test/**","anon");
        map.put("/**", "user");

        //登陆
        shiroFilterFactoryBean.setLoginUrl("/wedding/admin/page/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/wedding/admin/page/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }



}
