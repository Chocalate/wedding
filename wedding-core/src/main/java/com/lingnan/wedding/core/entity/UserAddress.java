package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户地址表(UserAddress)实体类
 *
 * @author makejava
 * @since 2021-03-31 23:03:49
 */
@Data
public class UserAddress implements Serializable {
    private static final long serialVersionUID = -10165381585733417L;
    /**
    * 用户地址id
    */
    private Integer id;
    /**
    * 用户id
    */
    private Integer uid;

    private String phone;
    /**
    * 收货人姓名
    */
    private String realName;
    /**
    * 省市区
    */
    private String proCity;
    /**
    * 收货人详细地址
    */
    private String detail;
    /**
    * 经度
    */
    private String longitude;
    /**
    * 纬度
    */
    private String latitude;
    /**
    * 是否默认
    */
    private Integer isDefault;
    /**
    * 是否删除
    */
    private Integer isDel;



}
