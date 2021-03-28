package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 订房记录(ReserveRecord)实体类
 *
 * @author makejava
 * @since 2021-03-22 11:15:56
 */
@Data
public class ReserveRecord implements Serializable {
    private static final long serialVersionUID = 841839304735831445L;
    
    private Integer id;
    /**
    * 预定商品id
    */
    private String goodsId;
    /**
    * 预约服务时间
    */
    private String reserveTime;
    /**
    * 收货人名字
    */
    private String getPersonName;
    /**
    * 联系方式
    */
    private String phone;
    /**
    * 收货地址
    */
    private Integer adressid;
    /**
    * 生成时间
    */
    private String createTime;
    /**
    * 订单状态id
    */
    private Integer flag;
    /**
    * 预约客户ID
    */
    private Integer clientId;
    /**
    * 预约进度
    */
    private Integer progressid;

    private String account;

    private String goodsName;

    private String statusName;

    private String address;



}