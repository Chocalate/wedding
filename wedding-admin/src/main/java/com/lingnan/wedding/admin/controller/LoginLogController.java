package com.lingnan.wedding.admin.controller;

import com.lingnan.wedding.admin.service.LoginLogService;
import com.lingnan.wedding.core.entity.LoginLog;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录日志(LoginLog)表控制层
 *
 * @author lily
 * @since 2021-03-17 16:29:23
 */
@RestController
@RequestMapping("/wedding/admin/log")
public class LoginLogController {
    /**
     * 服务对象
     */
    @Resource
    private LoginLogService loginLogService;

    Logger logger = LoggerFactory.getLogger(LoginLogController.class);

    /**
     * 查询所有登录日志
     */
    @ResponseBody
    @RequestMapping("/loginLogList")
    public Object loginLogList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        try {
            logger.info("------------查询所有登录日志---------");
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(loginLogService.queryLogCount());
            List<LoginLog> loginLogs = loginLogService.queryAllByLimit((page - 1) * limit, limit);
            resultData.setData(loginLogs);
            return resultData;
        }catch(Exception e){
            logger.info("------------查询所有登录日志失败---------");
            return null;
        }
    }

    /**
     *  删除单条数据
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteLog(@RequestBody String id){
        try {
            logger.info("------------删除单条登录日志---------");
            return Response.success(loginLogService.deleteById(Integer.parseInt(id)));
        }catch (Exception e){
            logger.info("------------删除单条登录日志失败---------");
            return Response.error(e.getMessage());
        }
    }

    /**
     * 删除所有记录
     */
    @ResponseBody
    @RequestMapping("/delAll")
    public Object deleteAllLog(){
        try{
            logger.info("------------删除所有登录日志---------");
            return Response.success(loginLogService.deleteAllLog());
        }catch (Exception e){
            logger.info("------------删除所有登录日志失败---------");
            return Response.error(e.getMessage());
        }
    }
}