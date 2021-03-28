package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.ClientUserService;
import com.lingnan.wedding.admin.utils.ShiroUtil;
import com.lingnan.wedding.core.entity.ClientUser;
import com.lingnan.wedding.core.util.DateUtil;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户表(ClientUser)表控制层
 *
 * @author makejava
 * @since 2021-03-21 21:35:48
 */
@RestController
@RequestMapping("/wedding/admin/clientUser")
public class ClientUserController {
    /**
     * 服务对象
     */
    @Resource
    private ClientUserService clientUserService;

    private static final Logger logger = LoggerFactory.getLogger(AdminSystemUserController.class);


    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public ResultData queryAll(Integer page, Integer limit,String account,String nickname){
        logger.info("----------查询所有用户--------------");
        try {
            List<ClientUser> bean =  clientUserService.queryAllByLimit((page-1)*limit,limit,account,nickname);
            logger.info("page**********{},limit------------{}",page,limit);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(clientUserService.queryAllCount());
            resultData.setData(bean);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有用户信息失败:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 添加用户
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addClientUser(@RequestBody ClientUser clientUser){
        try {
            logger.info("----------添加用户--------------");
            ClientUser bean = clientUserService.queryByName(clientUser.getAccount());
            if (bean != null) {
                return Response.error("账户已存在");
            }
            clientUser.setSalt(ShiroUtil.createSalt());
            clientUser.setPassword(clientUser.getPassword());
            clientUser.setStatus(1);
            clientUser.setRoleId(4);
        //manager.setPassword(ShiroUtil.salt(manager.getPassword(), manager.getSalt()));*/
            clientUser.setCreateTime(DateUtil.stringDate(new Date()));
            bean = clientUserService.insert(clientUser);
            if (bean != null) {
                return Response.success(bean);
            }
            return Response.error("添加失敗");
        }catch (Exception e){
            logger.error("添加用户失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 修改管理员信息
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Object updateClientUser(@RequestBody ClientUser clientUser) {
        try {
            logger.info("-------------修改用户信息-------------");

            if (!StringUtils.isEmpty(clientUser.getPassword())) {
                //systemUser.setPassword(ShiroUtil.salt(systemUser.getPassword(), systemUser.getSalt()));
                clientUser.setPassword(clientUser.getPassword());
            }
            ClientUser user = clientUserService.update(clientUser);
            if (user != null) {
                return Response.success(user);
            }
            return Response.error("修改用户信息失败");
        } catch (Exception e) {
            logger.error("修改用户信息失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 用户详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public Object clientUserDetail(@RequestBody JSONObject jsonBody){
        logger.info("-------------用户详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(clientUserService.queryById(id));
        }catch (Exception e){
            logger.info("查询用户详细信息失败");
            return Response.error(e.getMessage());
        }

    }


    /**
     * 删除用户
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteSystemUser(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除用户-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(clientUserService.deleteById(id));
        }catch (Exception e){
            logger.info("查询用户详细信息失败");
            return Response.error(e.getMessage());
        }

    }

}