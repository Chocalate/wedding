package com.lingnan.wedding.client.controller;

import com.lingnan.wedding.client.service.UserService;
import com.lingnan.wedding.client.service.impl.GoodsServiceImpl;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.ClientUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @RequestMapping("/login")
    public ResultVO login(@RequestBody ClientUser user){
        Map<String, List<ClientUser>> login = userService.login(user);
        if (login != null) {
            return ResultVOUtil.success(login);
        }else{
            return ResultVOUtil.error("没有该用户");
        }
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
