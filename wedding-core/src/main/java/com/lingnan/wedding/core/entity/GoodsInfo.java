package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (GoodsInfo)实体类
 *
 * @author makejava
 * @since 2021-03-20 10:25:36
 */
@ToString
@Data
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = 427117716205458415L;
    /**
    * 商品表主键id
    */
    private Integer goodsId;
    /**
    * 商品名
    */
    private String goodsName;
    /**
    * 商品简介
    */
    private String goodsIntro;
    /**
    * 关联分类id
    */
    private Integer goodsTypeId;
    /**
    * 商品主图
    */
    private String goodsImg;
    /**
    * 商品详情
    */
    private String goodsDetailContent;
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
    /**
    * 商品标签
    */
    private String tag;
    /**
    * 商品上架状态 0-下架 1-上架
    */
    private Integer goodsSellStatus;

    private String goodsType;

    private Integer sellNum;



}
