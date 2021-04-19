package com.lingnan.wedding.admin.controller;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-08 17:08
 **/

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.config.UserToken;
import com.lingnan.wedding.admin.utils.ShiroUtil;
import com.lingnan.wedding.core.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 */

@Controller
@RequestMapping("/wedding/admin")
@Slf4j
public class AdminLoginController {

    private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello world!";
    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping("login")
    public Object login(HttpServletRequest request, HttpSession session, @RequestBody String jsonBody) {
        try {
            logger.info("-------------登录-------------");
            JSONObject params = (JSONObject) JSONObject.parse(jsonBody);
            String account = params.getString("username");
            String pwd = params.getString("pwd");
            String role = params.getString("role");
            Subject subject = SecurityUtils.getSubject();
            UserToken token = new UserToken(account,pwd,role);

            //shiro验证登录
            subject.login(token);
            session.setAttribute("username",ShiroUtil.getUserName());
            //service.insert(LoginLogFactory.success(ShiroUtil.getUserId()));
            return Response.success(role);
        } catch (Exception e) {
            //service.insert(LoginLogFactory.error(e.getMessage()));
            logger.error("登录失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 登出
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        //service.insert(LoginLogFactory.logout(ShiroUtil.getUserId(), request.getRemoteAddr()));
        ShiroUtil.getSubject().logout();
        return "/login";
    }


}
