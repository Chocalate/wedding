package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 前台公告栏(Notice)实体类
 *
 * @author makejava
 * @since 2021-03-18 12:19:38
 */
@ToString
@Data
public class  Notice implements Serializable {
    private static final long serialVersionUID = -28828327710957888L;
    
    private Integer id;
    /**
    * 标题
    */
    private String title;
    /**
    * 内容
    */
    private String content;
    /**
    * 发布时间
    */
    private Date createTime;


}