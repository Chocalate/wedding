package com.lingnan.wedding.client.controller;

import com.lingnan.wedding.client.service.GoodsService;
import com.lingnan.wedding.client.service.impl.GoodsServiceImpl;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.mapper.GoodsInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-28 18:25
 **/
@RestController
@RequestMapping("/wedding/client/goods")
public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsInfoDao goodsInfoDao;

    @RequestMapping("/searchHot")
    public ResultVO searchHot(){
        return ResultVOUtil.success(goodsService.searchHot());
    }

    @RequestMapping("/searchGoodsByName")
    public ResultVO searchGoodsByName(@RequestBody GoodsInfo goodsInfo){
        logger.info("-----goodsInfo---{}",goodsInfo);
        return ResultVOUtil.success(goodsService.searchGoodsByName(goodsInfo));
    }

}
