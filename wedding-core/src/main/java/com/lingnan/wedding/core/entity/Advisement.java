package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 前台公告栏(Advisement)实体类
 *
 * @author makejava
 * @since 2021-03-18 15:13:16
 */
@ToString
@Data
public class Advisement implements Serializable {
    private static final long serialVersionUID = 114785359798877179L;

    private Integer id;
    /**
    * 商品名称
    */
    private String name;
    /**
    * 内容
    */
    private String content;
    /**
    * 图片链接
    */
    private String imgUrl;
    /**
    * 所属商家
    */
    private String businessOwer;
    /**
    * 发布时间
    */
    private String createTime;
    /**
    * 是否显示，是为0，否为1
    */
    private Integer isShow;

}
