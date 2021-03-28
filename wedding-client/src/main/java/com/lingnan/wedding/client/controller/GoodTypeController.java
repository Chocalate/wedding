package com.lingnan.wedding.client.controller;

import com.lingnan.wedding.client.service.GoodTypeService;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.GoodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类型(GoodType)表控制层
 *
 * @author lily
 * @since 2021-03-19 10:47:23
 */
@RestController
@RequestMapping("/wedding/client/goodType")
public class GoodTypeController {

    Logger logger = LoggerFactory.getLogger(GoodTypeController.class);

    /**
     * 服务对象
     */
    @Resource
    private GoodTypeService goodTypeService;



    @RequestMapping("/list")
    public ResultVO goodTypeList(){
        return ResultVOUtil.success(goodTypeService.queryAll());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(
            @PathVariable("categoryType") Integer categoryType){
        return ResultVOUtil.success(goodTypeService.findGoodsInfoVOByCategoryType(categoryType));
    }


}
