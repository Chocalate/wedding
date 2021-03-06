package com.lingnan.wedding.client.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
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
    public ClientUserRealm clientUserRealm(){
        return new ClientUserRealm();
    }

    /**
     * 注入 securityManager
     */
    @Bean
    public SecurityManager securityManager(@Qualifier("clientUserRealm") ClientUserRealm clientUserRealm){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(clientUserRealm);
        return securityManager;
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
        map.put("/wedding/client/user/login","anon");
        map.put("/wedding/client/goods/**","anon");
        map.put("/wedding/client/goodType/**","anon");
        map.put("/static/**","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }



}
