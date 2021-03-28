package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(Order)实体类
 *
 * @author makejava
 * @since 2021-03-23 00:04:28
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 580241671361524944L;
    /**
    * 订单ID
    */
    private Integer id;
    /**
    * 订单号
    */
    private String orderId;
    /**
    * 用户id
    */
    private Integer uid;
    /**
    * 用户姓名
    */
    private String realName;
    /**
    * 用户电话
    */
    private String userPhone;
    /**
    * 详细地址
    */
    private String userAddress;
    /**
    * 运费金额
    */
    private Double freightPrice;
    /**
    * 订单商品总数
    */
    private Integer totalNum;
    /**
    * 订单总价
    */
    private Double totalPrice;
    /**
    * 邮费
    */
    private Double totalPostage;
    /**
    * 实际支付金额
    */
    private Double payPrice;
    /**
    * 抵扣金额
    */
    private Double deductionPrice;
    /**
    * 优惠券id
    */
    private Integer couponId;
    /**
    * 优惠券金额
    */
    private Double couponPrice;
    /**
    * 支付状态
    */
    private Integer paid;
    /**
    * 支付时间
    */
    private String payTime;
    /**
    * 支付方式
    */
    private String payType;
    /**
    * 创建时间
    */
    private String createTime;
    /**
    * 订单状态（0：待发货；1：待收货；2：已收货，待评价；3：已完成；）
    */
    private Integer status;
    /**
    * 0 未退款 1 申请中 2 已退款 3 退款中
    */
    private Integer refundStatus;
    /**
    * 退款图片
    */
    private String refundReasonWapImg;
    /**
    * 退款用户说明
    */
    private String refundReasonWapExplain;
    /**
    * 不退款的理由
    */
    private String refundReason;
    /**
    * 退款时间
    */
    private String refundReasonTime;
    /**
    * 退款金额
    */
    private Double refundPrice;
    /**
    * 消费赚取积分
    */
    private Integer gainIntegral;
    /**
    * 使用积分
    */
    private Integer useIntegral;
    /**
    * 给用户退了多少积分
    */
    private Integer backIntegral;
    /**
    * 备注
    */
    private String mark;
    /**
    * 是否删除,0为false，1为true
    */
    private Integer isDel;



}