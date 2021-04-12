package com.lingnan.wedding.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.client.service.UserService;
import com.lingnan.wedding.client.service.impl.GoodsServiceImpl;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.util.ShiroUtil;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.ClientUser;
import com.lingnan.wedding.core.vo.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-29 16:02
 **/

@RestController
@RequestMapping("/wedding/client/user")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Resource
    private UserService userService;


    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping("login")
    public Object login(HttpServletRequest request, @RequestBody String jsonBody) {
        try {
            logger.info("-------------登录-------------");
            JSONObject params = (JSONObject) JSONObject.parse(jsonBody);
            String account = params.getString("account");
            String pwd = params.getString("password");

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, pwd);

            //shiro验证登录
            subject.login(token);
            //service.insert(LoginLogFactory.success(ShiroUtil.getUserId()));
            ClientUser clientUser = new ClientUser();
            clientUser.setId(ShiroUtil.getUserId());
            clientUser.setAccount(ShiroUtil.getUserName());
            return ResultVOUtil.success(clientUser);

        }catch (UnknownAccountException e) {
            logger.error("登录失败：用户名不存在" + e.getMessage());
            return ResultVOUtil.error("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            logger.error("登录失败：密码错误" + e.getMessage());
            return ResultVOUtil.error("密码错误");
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


    @RequestMapping("/register")
    public ResultVO register(@RequestBody ClientUser user){
        int flag = userService.insert(user);
        logger.info("flag----------{}",flag);
        if(flag==1) {
            return ResultVOUtil.success(flag);
        }else {
            return ResultVOUtil.error("注册失败");
        }
    }


}
