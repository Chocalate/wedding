package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Share)实体类
 *
 * @author makejava
 * @since 2021-03-23 02:33:07
 */
@Data
public class Share implements Serializable {
    private static final long serialVersionUID = 883852426463622409L;
    
    private Integer id;
    /**
    * 用户id
    */
    private Integer uid;
    /**
    * 文章标题
    */
    private String titile;
    /**
    * 内容
    */
    private String content;
    /**
    * 图片
    */
    private String img;
    /**
    * 点赞数
    */
    private Integer approvetime;
    /**
    * 评论
    */
    private String comment;
    /**
    * 是否删除，0是，1否
    */
    private Integer isDel;
    
    private String createTime;

    private String account;



}