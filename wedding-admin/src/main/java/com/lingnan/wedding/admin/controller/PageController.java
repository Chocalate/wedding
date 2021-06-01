package com.lingnan.wedding.admin.controller;

import com.lingnan.wedding.admin.utils.ModelUtils;
import com.lingnan.wedding.admin.utils.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-09 18:13
 **/
@Controller
@RequestMapping("/wedding/admin/page")
public class PageController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    /**
     * 跳转到错误页面
     */
    @RequestMapping("error")
    public ModelAndView error(HttpServletRequest request) {
        logger.info("------------访问了error接口");
        return ModelUtils.createModel(request, "/error");
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request) {
        if (ShiroUtil.isUser()) {
            return ModelUtils.createModel(request, "/index");
        }
        return new ModelAndView("/login");
    }

    /**
     * 跳转到首页
     */
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/index");
    }

    /**
     * 跳转到首页
     */
    @RequestMapping("businessIndex")
    public ModelAndView businessIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/businessIndex");
    }

    /**
     * 跳转到欢迎页面
     */
    @RequestMapping("welcome")
    public ModelAndView welcome(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/welcome");
    }

    /**
     * 跳转到重置密码界面
     */
    @RequestMapping("reset")
    public ModelAndView reset(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/reset");
    }

    /**
     * 跳转到管理员管理页面
     */
    @RequestMapping("systemuser/index")
    public ModelAndView managerIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/admin/index");
    }

    /**
     * 修改管理员
     */
    @RequestMapping("systemuser/edit")
    public ModelAndView managerEdit(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/system/admin/edit");
        result.addObject("id", id);
        return result;
    }

    /**
     * 管理员添加-
     */
    @RequestMapping("systemuser/add")
    public ModelAndView managerAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/admin/add");
    }

    /**
     * 跳转到登录日志管理
     */
    @RequestMapping("loginLog/index")
    public ModelAndView logIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/loginlog/index");
    }


    /**
     * 跳转到商品管理页面
     */
    @RequestMapping("good/index")
    public ModelAndView hotelIndex(HttpServletRequest request) {
        ModelAndView result = ModelUtils.createModel(request, "/good/good/index");
        return result;
    }

    /**
     * 商品信息添加
     */
    @RequestMapping("good/add")
    public ModelAndView hotelAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/good/good/add");
    }

    /**
     * 商品信息修改
     */
    @RequestMapping("good/edit")
    public ModelAndView hotelEdit(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/good/good/edit");
        result.addObject("id", id);
        return result;
    }

    /**
     * 商品详情
     */
    @RequestMapping("good/detail")
    public ModelAndView goodsInfoDetail(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/good/good/detail");
        result.addObject("id", id);
        return result;
    }

    /**
     * 跳转到角色管理页面
     */
    @RequestMapping("role/index")
    public ModelAndView roleIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/role/index");
    }

    /**
     * 角色添加
     */
    @RequestMapping("role/add")
    public ModelAndView roleAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/role/add");
    }


    /**
     * 跳转到首页封面页面
     */
    @RequestMapping("advisement/index")
    public ModelAndView adviseIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/advisement/index");
    }

    /**
     * 添加首页封面页面
     */
    @RequestMapping("advisement/add")
    public ModelAndView advisementAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/advisement/add");
    }


    /**
     * 修改首页封面
     */
    @RequestMapping("advisement/edit")
    public ModelAndView advisementEdit(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/system/advisement/edit");
        result.addObject("id", id);
        return result;
    }

    /**
     * 跳转到上传日志管理页面
     */
    @RequestMapping("uploadLog/index")
    public ModelAndView uploadLogIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/system/uploadLog/index");
    }

    /**
     * 跳转到商品评价信息页面
     */
    @RequestMapping("comment/index")
    public ModelAndView commentIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/good/comment/index");
    }

    /**
     * 商品评价信息
     */
    @RequestMapping("comment/detail")
    public ModelAndView commentDetail(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/good/comment/detail");
        result.addObject("id", id);
        return result;
    }

    /**
     * 跳转到用户管理页面
     */
    @RequestMapping("clientUser/index")
    public ModelAndView jobIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/clientUser/user/index");
    }

    /**
     * 添加用户
     */
    @RequestMapping("clientUser/add")
    public ModelAndView jobAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/clientUser/user/add");
    }


    /**
     * 修改用户
     */
    @RequestMapping("clientUser/edit")
    public ModelAndView jobEdit(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/clientUser/user/edit");
        result.addObject("id", id);
        return result;
    }



    @RequestMapping("reserveRecord/jiedan")
    public ModelAndView jieDanIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/business/jiedan");
    }

    @RequestMapping("reserveRecord/service")
    public ModelAndView service(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/business/service");
    }

    @RequestMapping("reserveRecord/serviceOver")
    public ModelAndView serviceOver(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/business/serviceOver");
    }
    @RequestMapping("reserveRecord/waitConfirm")
    public ModelAndView waitConfirm(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/business/waitConfirm");
    }

    @RequestMapping("reserveRecord/overOrder")
    public ModelAndView overOrder(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/business/overOrder");
    }

    /**
     * 跳转到预约管理页面
     */
    @RequestMapping("reserveRecord/index")
    public ModelAndView reserveRecordIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/clientUser/reserveRecord/index");
    }


    /**
     * 添加预约管理
     */
    @RequestMapping("reserveRecord/add")
    public ModelAndView reserveRecordAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/clientUser/reserveRecord/add");
    }

    /**
     * 修改预约管理
     */
    @RequestMapping("reserveRecord/edit")
    public ModelAndView reserveRecordEdit(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/clientUser/reserveRecord/edit");
        result.addObject("id", id);
        return result;
    }

    /**
     * 预约详情
     */
    @RequestMapping("reserveRecord/detail")
    public ModelAndView reserveRecordDetail(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/clientUser/reserveRecord/detail");
        result.addObject("id", id);
        return result;
    }

    /**
     * 跳转到商品类型管理页面
     */
    @RequestMapping("goodType/index")
    public ModelAndView roomTypeIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/good/goodType/index");
    }

    /**
     * 添加商品类型
     */
    @RequestMapping("goodType/add")
    public ModelAndView roomTypeAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/good/goodType/add");
    }


    /**
     * 修改商品类型
     */
    @RequestMapping("goodType/edit")
    public ModelAndView roomTypeEdit(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/good/goodType/edit");
        result.addObject("id", id);
        return result;
    }

    /**
     * 跳转到订单页面
     */
    @RequestMapping("order/index")
    public ModelAndView roomIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/order/index");
    }

    /**
     * 订单添加
     */
    @RequestMapping("order/add")
    public ModelAndView roomAdd(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/order/add");
    }


    /**
     * 修改订单
     */
    @RequestMapping("order/edit")
    public ModelAndView roomEdit(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/order/edit");
        result.addObject("id", id);
        return result;
    }


    /**
     * 订单详情
     */
    @RequestMapping("order/detail")
    public ModelAndView orderDetail(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/order/detail");
        result.addObject("id", id);
        return result;
    }


    /**
     * 跳转到留言管理页面
     */
    @RequestMapping("suggestion/index")
    public ModelAndView suggestionIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/service/suggestion/index");
    }

    /**
     * 跳转到留言管理页面
     */
    @RequestMapping("share/index")
    public ModelAndView shareIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/service/share/index");
    }

    /**
     * 客户信息
     */
    @RequestMapping("userInfo/detail")
    public ModelAndView userInfoDetail(HttpServletRequest request, Integer id) {
        ModelAndView result = ModelUtils.createModel(request, "/user/userInfo/detail");
        result.addObject("id", id);
        return result;
    }



    /**
     * 跳转到客户
     */
    @RequestMapping("orderRecord/index")
    public ModelAndView orderRecord(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/user/order_record/index");
    }



  /*  *//**
     * 跳转到留言管理页面
     *//*
    @RequestMapping("suggestion/index")
    public ModelAndView suggestionIndex(HttpServletRequest request) {
        return ModelUtils.createModel(request, "/suggestion/index");
    }
*/
}
