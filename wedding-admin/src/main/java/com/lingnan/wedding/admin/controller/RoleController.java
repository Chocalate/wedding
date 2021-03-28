package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.RoleUserService;
import com.lingnan.wedding.core.entity.Role;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-16 16:02
 **/

@Controller
@RequestMapping("/wedding/admin/role")
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
   private RoleUserService roleUserService;

    /**
     * 查询所有角色
     * @return
     */
    @ResponseBody
    @RequestMapping("/rolesList")
    public Object getAllRole(@RequestParam("page") Integer page , @RequestParam("limit") Integer limit){
        try {
            logger.info("-------------查询所有角色信息-------------");
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(roleUserService.queryRoleCount());
            List<Role> roles = roleUserService.queryAllByLimit((page - 1) * limit, limit);
            resultData.setData(roles);
            return resultData;

        }catch (Exception e){
            logger.info("-----------添查询所有角色信息失败---------");
            return Response.error(e.getMessage());
        }
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object AddRole(@RequestBody Role role){
        try {
            logger.info("-------------添加角色信息-------------");
            Role role1 = roleUserService.insert(role);
            if(role1 != null){
                return Response.success(role);
            }
            return Response.error("添加失败");
        }catch (Exception e){
            logger.info("-----------添加角色失败---------");
            return Response.error(e.getMessage());
        }
    }
    /**
     * 删除角色
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object DeleteRole(@RequestBody JSONObject jsonObject){
        try {
            logger.info("-------------删除角色信息-------------");
            return Response.success(roleUserService.deleteById(jsonObject.getInteger("id")));
        }catch (Exception e){
            logger.info("-----------添加角色失败---------");
            return Response.error(e.getMessage());
        }

    }

    /**
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/roles")
    public Object getRoles(){
        try {
            logger.info("-------------添加角色信息-------------");
                return Response.success(roleUserService.queryAllRole());

        }catch (Exception e){
            logger.info("-----------添加角色失败---------");
            return Response.error(e.getMessage());
        }
    }
}
