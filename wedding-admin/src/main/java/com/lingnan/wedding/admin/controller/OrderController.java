package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.OrderService;
import com.lingnan.wedding.core.entity.Order;
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
 * 订单控制器
 */

@Controller
@RequestMapping("/wedding/admin/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public ResultData queryAll(Integer page, Integer limit,String orderId){
        logger.info("----------查询所有订单--------------");
        try {
            List<Order> orders =  orderService.queryAllByLimit((page-1)*limit,limit,orderId);
            logger.info("page**********{},limit------------{}",page,limit);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(orderService.queryAllCount());
            resultData.setData(orders);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有订单信息失败:{}", e.getMessage());
            return null;
        }
    }


    /**
     * 添加管理员
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Order order){
        try {
            logger.info("----------添加订单--------------");
            Order bean = orderService.insert(order);
            if (bean != null) {
                return Response.success(bean);
            }
            return Response.error("添加失敗");
        }catch (Exception e){
            logger.error("添加订单失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 修改管理员信息
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Object update(@RequestBody Order order) {
        try {
            logger.info("-------------修改订单信息-------------");
            Order bean = orderService.update(order);
            if (bean != null) {
                return Response.success(bean);
            }
            return Response.error("修改订单信息失败");
        } catch (Exception e) {
            logger.error("修改订单信息失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 管理员详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public Object OrderDetail(@RequestBody JSONObject jsonBody){
        logger.info("-------------订单详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(orderService.queryById(id));
        }catch (Exception e){
            logger.info("查询订单详细信息失败");
            return Response.error(e.getMessage());
        }

    }


    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteSystemUser(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除订单预约-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(orderService.deleteById(id));
        }catch (Exception e){
            logger.info("查询订单预约详细信息失败");
            return Response.error(e.getMessage());
        }

    }

  /*  *//**
     * 查询预约状态
     *//*
    @ResponseBody
    @RequestMapping("/orderTypes")
    public Object OrderType(){
        logger.info("-------------查询预约状态-------------");
        try {
            return Response.success(orderService.queryOrderTypes());
        }catch (Exception e){
            logger.info("查询预约状态失败");
            return Response.error(e.getMessage());
        }
    }*/


}
