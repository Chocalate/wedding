package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.CommentService;
import com.lingnan.wedding.admin.service.GoodsInfoService;
import com.lingnan.wedding.admin.service.UploadLogService;
import com.lingnan.wedding.admin.utils.ShiroUtil;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.core.entity.UploadLog;
import com.lingnan.wedding.core.util.UploadUtil;
import com.lingnan.wedding.core.util.DateUtil;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
    public static final String BASE_PATH = "/static/imgs/goodsInfo/";

    Logger logger = LoggerFactory.getLogger(GoodsInfoController.class);

    @ResponseBody
    @RequestMapping("/list")
    public Object goodInfoList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String goodsName, Integer goodsSellStatus) {
        try {
            logger.info("----------查询商品信息--------------");
            List<GoodsInfo> goodInfos = goodsInfoService.queryAllByLimit((page - 1) * limit, limit, goodsName, goodsSellStatus);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(goodsInfoService.queryAllCount());
            resultData.setData(goodInfos);
            return resultData;
        } catch (Exception e) {
            logger.info("查询所有商品信息失败:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 添加商品信息
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object addGoodInfo(@RequestBody GoodsInfo goodInfo) {
        try {
            logger.info("----------添加商品信息--------------{}",goodInfo);
            goodInfo.setGoodsSellStatus(1);
            goodInfo.setBusinessId(ShiroUtil.getUserId());
            GoodsInfo type = goodsInfoService.insert(goodInfo);
            UploadLog log = new UploadLog();
            log.setImgUrl(goodInfo.getGoodsImg());
            log.setRoleid(ShiroUtil.getRoleId());
            logger.info("**********************username***********************{}", ShiroUtil.getUserName());
            log.setOperationName("添加商品信息");
            log.setCreateUser(ShiroUtil.getUserId());
            log.setCreateTime(DateUtil.stringDate(new Date()));
            UploadLog insert = uploadLogService.insert(log);
            if (type != null) {
                return Response.success(type);
            }
            return Response.error("添加商品信息失敗");
        } catch (Exception e) {
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
    public Object goodInfoDetail(@RequestBody JSONObject jsonBody) {
        logger.info("-------------商品详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(goodsInfoService.queryById(id));
        } catch (Exception e) {
            logger.info("查询商品详细信息失败");
            return Response.error(e.getMessage());
        }

    }

    /**
     * 商品类型详情
     */
    @ResponseBody
    @RequestMapping("/detailList")
    public Object goodInfoDetailList(@RequestBody JSONObject jsonBody) {
        logger.info("-------------商品详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(goodsInfoService.queryDetail(id));
        } catch (Exception e) {
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
    public Object deleteGoodInfo(@RequestBody JSONObject jsonBody) {
        logger.info("-------------删除商品详细信息-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            commentService.deleteByGoodsId(id);
            return Response.success(goodsInfoService.deleteById(id));
        } catch (Exception e) {
            logger.info("删除商品详细信息失败");
            return Response.error(e.getMessage());
        }

    }


    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "public/static/goodsInfo/";


    /**
     * 文件上传
     */
    @RequestMapping("/upload")
    public Response upload(HttpServletRequest request, @RequestParam("file") MultipartFile uploadFile) throws FileNotFoundException {
        if (uploadFile.isEmpty()) {
            //返回选择文件提示
            Response.error("请选择上传文件");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("wedding-vue/" + UPLOAD_PATH_PREFIX);
        logger.info("-----------上传文件保存的路径【" + realPath + "】-----------");

        //存放上传文件的文件夹
        File file = new File(realPath);
        logger.info("-----------存放上传文件的文件夹【" + file + "】-----------");
        logger.info("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【" + file.getAbsolutePath() + "】-----------");
        if (!file.isDirectory()) {
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        logger.info("-----------文件原始的名字【" + oldName + "】-----------");

        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + oldName);
            logger.info("-----------newFile【" + newFile + "】-----------");
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = "../static/goodsInfo/" + oldName;
            return Response.success(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.error("上传失败!");
    }
}



