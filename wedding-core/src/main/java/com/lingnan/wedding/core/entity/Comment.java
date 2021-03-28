package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2021-03-21 14:15:02
 */
@ToString
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -96900395171422120L;
    
    private Integer id;
    /**
    * 评价内容
    */
    private String content;
    /**
    * 图片
    */
    private String img;
    /**
    * 商品id
    */
    private Integer goodsId;
    /**
    * 用户名
    */
    private String username;
    /**
    * 浏览次数
    */
    private Integer lookedTime;
    /**
    * 评论星级，>=3为中好评，<3为差评
    */
    private Integer commentStar;
    /**
    * 赞同次数
    */
    private Integer approveTime;
    /**
    * 日期
    */
    private String assessTime;

    private String goodsName;

    private String goodsImg;

}