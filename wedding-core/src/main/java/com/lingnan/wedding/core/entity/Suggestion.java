package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Suggestion)实体类
 *
 * @author makejava
 * @since 2021-03-23 02:33:08
 */
@Data
public class Suggestion implements Serializable {
    private static final long serialVersionUID = -32824173962870510L;
    
    private Integer id;
    /**
    * 留言内容
    */
    private String content;
    /**
    * 建议人
    */
    private Integer userId;
    /**
    * 角色
    */
    private Integer roleId;
    
    private String createTime;



}