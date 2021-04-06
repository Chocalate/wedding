package com.lingnan.wedding.client.controller;

import com.lingnan.wedding.client.service.ReserveOrderService;
import com.lingnan.wedding.client.service.impl.GoodsServiceImpl;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.OrderType;
import com.lingnan.wedding.core.entity.ReserveRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-31 23:44
 **/
@RestController
@RequestMapping("/wedding/client/reserve")
public class ReserveOrderServiceController {
    Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Resource
    private ReserveOrderService reserveOrderService;

    @RequestMapping("/addReserve")
    public ResultVO addReserve(@RequestBody ReserveRecord reserveRecord){

            boolean flag = reserveOrderService.addReserve(reserveRecord);
            if (flag){
              return   ResultVOUtil.success(flag);
            }else{
                logger.info("添加预约失败");
                return  ResultVOUtil.error("添加预约失败");
            }
    }
    @RequestMapping("/queryReserve")
    public ResultVO queryReserve(Integer userId){
        Map<String, List<ReserveRecord>> stringListMap = reserveOrderService.queryReserve(userId);
        return ResultVOUtil.success(stringListMap);
    }

    @RequestMapping("/queryStateName")
    public ResultVO queryStateName(){
        Map<String, List<OrderType>> stringListMap = reserveOrderService.queryStateName();
        return ResultVOUtil.success(stringListMap);
    }

    @RequestMapping("/queryByStateName")
    public ResultVO queryByStateName(Integer id){
        Map<String, Integer> stringListMap = reserveOrderService.queryByStateName(id);
        return ResultVOUtil.success(stringListMap);
    }
}
