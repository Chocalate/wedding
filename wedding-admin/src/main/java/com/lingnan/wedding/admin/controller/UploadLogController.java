package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.UploadLogService;
import com.lingnan.wedding.core.entity.UploadLog;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 上传记录(UploadLog)表控制层
 *
 * @author makejava
 * @since 2021-03-20 21:58:04
 */
@RestController
@RequestMapping("/wedding/admin/uploadLog")
public class UploadLogController {
     Logger logger = LoggerFactory.getLogger(UploadLogController.class);
    /**
     * 服务对象
     */
    @Resource
    private UploadLogService uploadLogService;

    @ResponseBody
    @RequestMapping("/list")
    public Object uploadLogList(Integer page,Integer limit){
        try {
            logger.info("----------查询上传记录--------------");
            List<UploadLog> uploadLogs =  uploadLogService.queryAllByLimit((page-1)*limit,limit);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(uploadLogService.queryAllCount());
            resultData.setData(uploadLogs);
            return resultData;
        }catch (Exception e){
            logger.info("查询上传记录失败:{}", e.getMessage());
            return null;
        }
    }



    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteGoodInfo(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除上传记录-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(uploadLogService.deleteById(id));
        }catch (Exception e){
            logger.info("删除上传记录失败");
            return Response.error(e.getMessage());
        }

    }

    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping("/clear")
    public Object deleteAllLog(){
        logger.info("-------------删除全部上传记录-------------");
        try {
            return Response.success(uploadLogService.clear());
        }catch (Exception e){
            logger.info("删除全部上传记录失败");
            return Response.error(e.getMessage());
        }

    }




}