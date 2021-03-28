package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 登录日志(LoginLog)实体类
 *
 * @author makejava
 * @since 2021-03-17 18:03:52
 */

@ToString
@Data
public class LoginLog implements Serializable {
    private static final long serialVersionUID = -51205838891206945L;
    
    private Integer id;
    /**
    * 登录情况
    */
    private String msg;
    /**
    * 用户ID，只有不是账号不存在的情况下才记录
    */
    private Integer uId;
    /**
    * 是否成功
    */
    private String succeed;
    /**
    * 记录日期
    */
    private String createTime;
    /**
    * 是否删除，0为false，1为true
    */
    private Integer isDel;


}