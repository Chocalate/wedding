package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.CommentService;
import com.lingnan.wedding.core.entity.Comment;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品评价管理(Comment)表控制层
 *
 * @author makejava
 * @since 2021-03-21 13:45:09
 */
@Controller
@RequestMapping("/wedding/admin/comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    Logger logger = LoggerFactory.getLogger(CommentController.class);

    @ResponseBody
    @RequestMapping("/list")
    public Object commentList(Integer page,Integer limit,String goodsName){
        try {
            logger.info("----------查询商品评价--------------");
            List<Comment> bean =  commentService.queryAllByLimit((page-1)*limit,limit,goodsName);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(commentService.queryAllCount());
            resultData.setData(bean);
            return resultData;
        }catch (Exception e){
            logger.info("查询商品评价管理失败:{}", e.getMessage());
            return null;
        }
    }


    /**
     * 商品类型详情
     */
    @ResponseBody
    @RequestMapping("/detailList")
    public Object commentDetailList(@RequestBody JSONObject jsonBody){
        logger.info("-------------商品评价详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(commentService.queryAll(id));
        }catch (Exception e){
            logger.info("查询商品评价详细信息失败");
            return Response.error(e.getMessage());
        }

    }

    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteGoodInfo(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除商品评价-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(commentService.deleteById(id));
        }catch (Exception e){
            logger.info("删除商品评价失败");
            return Response.error(e.getMessage());
        }

    }




}