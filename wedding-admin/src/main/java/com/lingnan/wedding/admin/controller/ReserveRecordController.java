package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.ReserveRecordService;
import com.lingnan.wedding.admin.utils.ShiroUtil;
import com.lingnan.wedding.core.entity.ReserveRecord;
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
 * 预约控制器
 */

@Controller
@RequestMapping("wedding/admin/reserve")
public class ReserveRecordController {

    private static final Logger logger = LoggerFactory.getLogger(ReserveRecordController.class);
    @Autowired
    private ReserveRecordService reserveRecordService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public ResultData queryAll(Integer page, Integer limit,String account,String statusName){
        logger.info("----------查询所有订单预约--------------{}",statusName);
        try {
            ResultData resultData = new ResultData();
            List<ReserveRecord> reserveRecords ;
            Integer roleId = ShiroUtil.getRoleId();
            logger.info("roleId--------------{}",roleId);
            if(roleId ==2){
                Integer businessId = ShiroUtil.getUserId();
                reserveRecords = reserveRecordService.queryBusinessRevByLimit((page - 1) * limit, limit, statusName,businessId);
                resultData.setCount(reserveRecordService.queryBusinessRevCount(statusName,businessId));
            }else {
                reserveRecords = reserveRecordService.queryAllByLimit((page - 1) * limit, limit, account, statusName);
                logger.info("page**********{},limit------------{}", page, limit);
                resultData.setCount(reserveRecordService.queryAllCount());
            }
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setData(reserveRecords);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有订单预约失败:{}", e.getMessage());
            return null;
        }
    }


    /**
     * 添加管理员
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addReserveRecord(@RequestBody ReserveRecord reserveRecord){
        try {
            logger.info("----------添加订单预约--------------");
            logger.info("-----------reserveRecord------{}",reserveRecord);
            reserveRecord.setFlag(1);
            ReserveRecord bean = reserveRecordService.insert(reserveRecord);
            if (bean != null) {
                return Response.success(bean);
            }
            return Response.error("添加失敗");
        }catch (Exception e){
            logger.error("添加订单预约失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 修改管理员信息
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Object updateReserveRecord(@RequestBody ReserveRecord reserveRecord) {
        try {
            logger.info("-------------修改订单预约信息-------------");
            ReserveRecord bean = reserveRecordService.update(reserveRecord);
            if (bean != null) {
                return Response.success(bean);
            }
            return Response.error("修改订单预约信息失败");
        } catch (Exception e) {
            logger.error("修改订单预约信息失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 管理员详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public Object reserveRecordDetail(@RequestBody JSONObject jsonBody){
        logger.info("-------------订单预约详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(reserveRecordService.queryById(id));
        }catch (Exception e){
            logger.info("查询订单预约详细信息失败");
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
            return Response.success(reserveRecordService.deleteById(id));
        }catch (Exception e){
            logger.info("查询订单预约详细信息失败");
            return Response.error(e.getMessage());
        }

    }

    /**
     * 查询预约状态
     */
    @ResponseBody
    @RequestMapping("/orderTypes")
    public Object OrderType(){
        logger.info("-------------查询预约状态-------------");
        try {
            return Response.success(reserveRecordService.queryOrderTypes());
        }catch (Exception e){
            logger.info("查询预约状态失败");
            return Response.error(e.getMessage());
        }

    }


}
