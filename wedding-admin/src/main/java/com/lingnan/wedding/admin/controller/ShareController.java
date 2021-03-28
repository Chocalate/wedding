package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.ShareService;
import com.lingnan.wedding.core.entity.Share;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-15 22:42
 **/

/**
 * 分享专栏控制器
 */

@Controller
@RequestMapping("wedding/admin/share")
public class ShareController {

    private static final Logger logger = LoggerFactory.getLogger(ShareController.class);
    @Autowired
    private ShareService shareService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public ResultData queryAll(Integer page, Integer limit){
        logger.info("----------查询所有分享专栏--------------");
        try {
            List<Share> shares =  shareService.queryAllByLimit((page-1)*limit,limit);
            logger.info("page**********{},limit------------{}",page,limit);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(shareService.queryAllcount());
            resultData.setData(shares);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有分享专栏失败:{}", e.getMessage());
            return null;
        }
    }



    /**
     * 删除分享专栏
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object delete(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除分享专栏-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(shareService.deleteById(id));
        }catch (Exception e){
            logger.info("删除分享专栏失败");
            return Response.error(e.getMessage());
        }

    }



}
