package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.GoodTypeService;
import com.lingnan.wedding.core.entity.GoodType;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类型(GoodType)表控制层
 *
 * @author lily
 * @since 2021-03-19 10:47:23
 */
@Controller
@RequestMapping("/wedding/admin/goodType")
public class GoodTypeController {

    Logger logger = LoggerFactory.getLogger(GoodTypeController.class);

    /**
     * 服务对象
     */
    @Resource
    private GoodTypeService goodTypeService;

    @ResponseBody
    @RequestMapping("/list")
    public Object goodTypeList(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        try {
            logger.info("----------查询商品类型--------------");
            List<GoodType> goodTypes =  goodTypeService.queryAllByLimit((page-1)*limit,limit);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(goodTypeService.queryAllCount());
            resultData.setData(goodTypes);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有商品类型信息失败:{}", e.getMessage());
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public Object goodTypeAll(){
        try {
            logger.info("----------查询商品类型--------------");
            List<GoodType> goodTypes =  goodTypeService.queryAllType();
            return Response.success(goodTypes);
        }catch (Exception e){
            logger.info("查询所有商品类型信息失败:{}", e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 添加商品类型
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addGoodType(@RequestBody GoodType goodType){
        try {
            logger.info("----------添加商品类型--------------");
            GoodType type = goodTypeService.insert(goodType);
            if (type != null) {
                return Response.success(type);
            }
            return Response.error("添加失敗");
        }catch (Exception e){
            logger.error("添加商品类型失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 修改商品类型信息
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Object updateGoodType(@RequestBody GoodType goodType) {
        try {
            logger.info("-------------修改商品类型信息-------------");
            GoodType bean = goodTypeService.update(goodType);
            if (bean != null) {
                return Response.success(bean);
            }
            return Response.error("修改商品类型失败");
        } catch (Exception e) {
            logger.error("修改商品类型失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 商品类型详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public Object goodTypeDetail(@RequestBody JSONObject jsonBody){
        logger.info("-------------管理员详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(goodTypeService.queryById(id));
        }catch (Exception e){
            logger.info("查询管理员详细信息失败");
            return Response.error(e.getMessage());
        }

    }


    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object deleteGoodType(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除管理员-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(goodTypeService.deleteById(id));
        }catch (Exception e){
            logger.info("查询管理员详细信息失败");
            return Response.error(e.getMessage());
        }

    }



}