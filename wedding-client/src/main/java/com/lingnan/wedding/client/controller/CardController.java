package com.lingnan.wedding.client.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.client.service.CardService;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.util.ShiroUtil;
import com.lingnan.wedding.client.vo.CardInfoVo;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.ClientUser;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.core.entity.ShopCart;
import org.apache.shiro.SecurityUtils;
import org.beetl.ext.fn.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-30 13:59
 **/
@RestController
@RequestMapping("/wedding/client/cart")
public class CardController {

    Logger logger = LoggerFactory.getLogger(CardController.class);
    @Resource
    private CardService cardService;

    @RequestMapping("/listById")
    public ResultVO listById(String userId){
        logger.info("userId::::::::{}",userId);
        try {
            Map<String, List<CardInfoVo>> stringListMap = cardService.listById(Integer.valueOf(userId));
            return ResultVOUtil.success(stringListMap);
        }catch (Exception e){
            return ResultVOUtil.error(e.getMessage());
        }
        }

        @RequestMapping("/batchDelete")
     public ResultVO batchDelete(@RequestBody Map<String,Map<String,Object>> params) {

            ResultVO resultVO= new ResultVO();
            try {
                String id = params.get("params").get("userId").toString();
                Integer userId = Integer.valueOf(id);
                ArrayList<Integer> o = (ArrayList<Integer>) params.get("params").get("ids");
                if(o.size()!=0) {
                    List<Integer> idsList = new ArrayList<>();
                    for (int i = 0; i < o.size(); i++) {
                        idsList.add(o.get(i));
                    }
                    boolean flag = cardService.batchDelete(idsList, userId);
                    if (flag) {
                        resultVO = ResultVOUtil.success("删除成功");
                    } else {
                        resultVO =  ResultVOUtil.error("删除失败");
                    }
                }
            }catch (Exception e){
                logger.info(e.getMessage());
                resultVO = ResultVOUtil.error("删除失败,程序异常");
            }
            return resultVO;
        }

    @RequestMapping("/addCart")

    public ResultVO addCart(@RequestBody Map<String,Map<String,Integer>> params){
        try {
            logger.info("params-----{}",params);
            Integer goodsId = params.get("params").get("goodsList");
            Integer userId = params.get("params").get("userId");
            boolean insert = cardService.insert(goodsId, userId);
            return ResultVOUtil.success(insert);
        }catch (Exception e){
            logger.info("ddddddddd{}",e);
            return ResultVOUtil.error(e.getMessage());
        }
    }


}
