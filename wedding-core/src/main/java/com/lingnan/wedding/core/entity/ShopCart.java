package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 购物车(ShopCart)实体类
 *
 * @author makejava
 * @since 2021-03-30 13:25:03
 */
@Data
public class ShopCart implements Serializable {
    private static final long serialVersionUID = 960905364601827023L;

    private Integer id;
    /**
    * 创建时间/注册时间
    */
    private Date createTime;
    /**
    * 最后更新时间
    */
    private Date modifyTime;
    /**
    * 数量
    */
    private Integer count;
    /**
    * 商品id
    */
    private Integer goodsId;
    /**
    * 用户id
    */
    private Integer userId;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 商品简介
     */
    private String goodsIntro;

    /**
     * 商品主图
     */
    private String goodsImg;

    /**
     * 商品价格
     */
    private Double originalPrice;
    /**
     * 商品实际售价
     */
    private Double sellingPrice;
    /**
     * 商品库存数量
     */
    private Integer stockNum;
}
