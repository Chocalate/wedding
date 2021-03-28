package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.CommentService;
import com.lingnan.wedding.admin.service.GoodsInfoService;
import com.lingnan.wedding.admin.service.UploadLogService;
import com.lingnan.wedding.admin.utils.ShiroUtil;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.core.entity.UploadLog;
import com.lingnan.wedding.core.util.DateUtil;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (GoodsInfo)表控制层
 *
 * @author lily
 * @since 2021-03-19 17:10:26
 */
@RestController
@RequestMapping("/wedding/admin/good")
public class GoodsInfoController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsInfoService goodsInfoService;

    @Resource
    private UploadLogService uploadLogService;

    @Resource
    private CommentService commentService;

    Logger logger = LoggerFactory.getLogger(GoodsInfoController.class);

    @ResponseBody
    @RequestMapping("/list")
    public Object goodInfoList(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,String goodsName,Integer goodsSellStatus){
        try {
            logger.info("----------查询商品信息--------------");
            List<GoodsInfo> goodInfos =  goodsInfoService.queryAllByLimit((page-1)*limit,limit,goodsName,goodsSellStatus);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(goodsInfoService.queryAllCount());
            resultData.setData(goodInfos);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有商品信息失败:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 添加商品信息
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addGoodInfo(@RequestBody GoodsInfo goodInfo){
        try {
            logger.info("----------添加商品信息--------------");
            goodInfo.setGoodsSellStatus(1);
            GoodsInfo type = goodsInfoService.insert(goodInfo);
            UploadLog log = new UploadLog();
            log.setImgUrl(goodInfo.getGoodsImg());
            log.setRoleid(ShiroUtil.getRoleId());
            logger.info("**********************username***********************{}",ShiroUtil.getUserName());
            log.setOperationName("添加商品信息");
            log.setCreateUser(ShiroUtil.getUserId());
            log.setCreateTime(DateUtil.stringDate(new Date()));
            UploadLog insert = uploadLogService.insert(log);
            if (type != null) {
                return Response.success(type);
            }
            return Response.error("添加商品信息失敗");
        }catch (Exception e){
            logger.error("添加商品信息失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 修改商品类型信息
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Object updateGoodInfo(@RequestBody GoodsInfo goodInfo) {
        try {
            logger.info("-------------修改商品信息-------------");
            GoodsInfo bean = goodsInfoService.update(goodInfo);
            if (bean != null) {
                return Response.success(bean);
            }
            return Response.error("修改商品信息失败");
        } catch (Exception e) {
            logger.error("修改商品信息失败：" + e.getMessage());
            return Response.error(e.getMessage());
        }
    }

    /**
     * 商品类型详情
     */
    @ResponseBody
    @RequestMapping("/detail")
    public Object goodInfoDetail(@RequestBody JSONObject jsonBody){
        logger.info("-------------商品详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(goodsInfoService.queryById(id));
        }catch (Exception e){
            logger.info("查询商品详细信息失败");
            return Response.error(e.getMessage());
        }

    }
    /**
     * 商品类型详情
     */
    @ResponseBody
    @RequestMapping("/detailList")
    public Object goodInfoDetailList(@RequestBody JSONObject jsonBody){
        logger.info("-------------商品详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(goodsInfoService.queryDetail(id));
        }catch (Exception e){
            logger.info("查询商品详细信息失败");
            return Response.error(e.getMessage());
        }

    }

    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping("/del")
    @Transactional
    public Object deleteGoodInfo(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除商品详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            commentService.deleteByGoodsId(id);
            return Response.success(goodsInfoService.deleteById(id));
        }catch (Exception e){
            logger.info("删除商品详细信息失败");
            return Response.error(e.getMessage());
        }

    }


}