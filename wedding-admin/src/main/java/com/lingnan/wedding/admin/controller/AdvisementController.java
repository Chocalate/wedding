package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.core.entity.Advisement;
import com.lingnan.wedding.admin.service.AdvisementService;
import com.lingnan.wedding.core.util.DateUtil;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 首页封面(Advisement)表控制层
 *
 * @author lily
 * @since 2021-03-18 15:15:00
 */
@RestController
@RequestMapping("/wedding/admin/advisement")
public class AdvisementController {

    Logger logger = LoggerFactory.getLogger(AdvisementController.class);

    /**
     * 服务对象
     */
    @Resource
    private AdvisementService advisementService;

    /**
     * 查询全部首页封面信息
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object queryAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        try{
            logger.info("-------------查询所有首页封面信息----------");
            ResultData data = new ResultData();
            data.setCode(0);
            data.setMsg("");
            data.setCount(advisementService.queryAllCount());
            List<Advisement> advisements = advisementService.queryAllByLimit((page-1) * limit, limit);
            data.setData(advisements);
            return data;
        }catch (Exception e){
            logger.info("-------------查询所有首页封面信息失败----------");
            return null;
        }
    }

    /**
     * 添加首页封面信息
     * @param advisement
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object addAdvisement(@RequestBody Advisement advisement){
        try {
            logger.info("-------------查询所有首页封面信息----------");
             advisement.setCreateTime(DateUtil.stringDate(new Date()));
             Advisement advisement1 = advisementService.insert(advisement);
             if(advisement1 != null){
             return Response.success(advisement1);
             }
            return Response.error("添加失敗");
        }catch (Exception e){
            logger.info("-------------查询所有首页封面信息失败----------");
            return Response.error(e.getMessage());
        }
    }

    /**
     * 修改所有首页封面信息
     * @param advisement
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object updateAdvisement(@RequestBody Advisement advisement){
        try{
            logger.info("-------------修改所有首页封面信息----------");
            return Response.success(advisementService.update(advisement));
        }catch (Exception e){
            logger.info("-------------修改所有首页封面信息失败----------");
            return Response.error(e.getMessage());
        }
    }

    /**
     * 首页封面信息详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public Object advisementDetail(@RequestBody JSONObject jsonObject){
        try{
            logger.info("-------------页封面信息详情----------");
            return Response.success(advisementService.queryById(jsonObject.getInteger("id")));
        }catch (Exception e){
            logger.info("-------------页封面信息详情失败----------");
            return Response.error(e.getMessage());
        }
    }

    /**
     * 删除首页封面信息
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteAdvisement(@RequestBody JSONObject jsonObject){
        try{
            logger.info("-------------删除首页封面信息----------");
            return Response.success(advisementService.deleteById(jsonObject.getInteger("id")));
        }catch (Exception e){
            logger.info("-------------删除首页封面信息失败----------");
            return Response.error(e.getMessage());
        }
    }

    /**
     * 首现首页封面
     */
    @ResponseBody
    @RequestMapping("/isShow")
    public Object showAdvisement(@RequestBody JSONObject jsonObject){
        try{
            logger.info("-------------首现首页封面----------");
            return Response.success(advisementService.updateById(jsonObject.getInteger("id")));
        }catch (Exception e){
            logger.info("-------------首现首页封面失败----------");
            return Response.error(e.getMessage());
        }
    }

}