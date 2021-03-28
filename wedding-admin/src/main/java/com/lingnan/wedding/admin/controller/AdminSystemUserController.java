package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.SystemUserService;
import com.lingnan.wedding.admin.utils.ShiroUtil;
import com.lingnan.wedding.core.entity.SystemUser;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.apache.catalina.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-15 22:42
 **/

/**
 * 管理员控制器
 */

@Controller
@RequestMapping("wedding/admin/systemuser")
public class AdminSystemUserController {

    private static final Logger logger = LoggerFactory.getLogger(AdminSystemUserController.class);
    @Autowired
    private SystemUserService systemUserService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public ResultData queryAll(Integer page, Integer limit){
        logger.info("----------查询所有管理员--------------");
        try {
            List<SystemUser> systemUsers =  systemUserService.queryAllByLimit((page-1)*limit,limit);
            logger.info("page**********{},limit------------{}",page,limit);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(systemUserService.queryAllCount());
            resultData.setData(systemUsers);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有管理员信息失败:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 重置密码
     */
    @ResponseBody
    @RequestMapping("reset")
    public Object reset(@RequestBody String jsonBody) {
        try {
            logger.info("-------------重置密码-------------");

            SystemUser systemUser = (SystemUser) ShiroUtil.getSubject().getPrincipal();
            String pwd = JSONObject.parseObject(jsonBody).getString("pwd");
            //systemUser.setPassword(ShiroUtil.salt(pwd, manager.getSalt()));
            systemUser.setPassword(pwd);

            if (systemUserService.update(systemUser) != null) {
                return Response.success("");
            }
            return Response.error("重置密码失败");
        } catch (Exception e) {
            logger.error("重置密码失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }


    /**
     * 添加管理员
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addSystemUser(@RequestBody SystemUser systemUser){
        try {
            logger.info("----------添加管理员--------------");
            logger.info("-----------sytemuser------{}",systemUser);
            SystemUser user = systemUserService.queryByName(systemUser.getUsername());
            if (user != null) {
                return Response.error("账户已存在");
            }
        /*manager.setSalt(ShiroUtil.createSalt());
        manager.setPassword(ShiroUtil.salt(manager.getPassword(), manager.getSalt()));*/
            systemUser.setLockedFlag(0);
            systemUser.setCreateTime(new Date());
            user = systemUserService.insert(systemUser);
            if (user != null) {
                return Response.success(user);
            }
            return Response.error("添加失敗");
        }catch (Exception e){
            logger.error("添加管理员失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 修改管理员信息
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Object updateSystemUser(@RequestBody SystemUser systemUser) {
        try {
            logger.info("-------------修改管理员信息-------------");

            if (!StringUtils.isEmpty(systemUser.getPassword())) {
                //systemUser.setPassword(ShiroUtil.salt(systemUser.getPassword(), systemUser.getSalt()));
                systemUser.setPassword(systemUser.getPassword());
            }
            SystemUser user = systemUserService.update(systemUser);
            if (user != null) {
                return Response.success(user);
            }
            return Response.error("修改管理员信息失败");
        } catch (Exception e) {
            logger.error("修改管理员信息失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 管理员详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public Object systemUserDetail(@RequestBody JSONObject jsonBody){
        logger.info("-------------管理员详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(systemUserService.queryById(id));
        }catch (Exception e){
            logger.info("查询管理员详细信息失败");
            return Response.error(e.getMessage());
        }

    }


    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteSystemUser(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除管理员-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(systemUserService.deleteById(id));
        }catch (Exception e){
            logger.info("查询管理员详细信息失败");
            return Response.error(e.getMessage());
        }

    }



}
