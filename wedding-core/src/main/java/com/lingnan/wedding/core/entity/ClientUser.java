package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(ClientUser)实体类
 *
 * @author makejava
 * @since 2021-03-21 21:32:19
 */
@ToString
@Data
public class ClientUser implements Serializable {
    private static final long serialVersionUID = 200932490996325263L;
    /**
    * 用户id
    */
    private Integer id;
    /**
    * 用户账号
    */
    private String account;
    /**
    * 用户昵称
    */
    private String nickname;
    /**
    * 加密盐
    */
    private String salt;
    /**
    * 密码
    */
    private String password;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 生日
    */
    private String birthday;
    /**
    * 身份证号码
    */
    private String cardId;
    /**
    * 用户角色id
    */
    private Integer roleId;
    /**
    * 用户头像
    */
    private String avatar;
    /**
    * 手机号码
    */
    private String phone;
    /**
    * 用户剩余积分
    */
    private Integer integral;
    /**
    * 1为正常，0为禁止
    */
    private Integer status;
    /**
    * 等级
    */
    private Integer level;
    /**
    * 详细地址
    */
    private String addres;
    /**
    * 创建时间
    */
    private String createTime;

    /**
    * 性别，0未知，1男，2女，3保密
    */
    private Integer sex;


    private String permission;
}
