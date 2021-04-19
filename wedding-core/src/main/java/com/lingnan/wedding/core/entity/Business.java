package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Business)实体类
 *
 * @author makejava
 * @since 2021-04-12 14:05:32
 */
@Data
public class Business implements Serializable {
    private static final long serialVersionUID = -83618304132851616L;

    private Integer id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 加密盐
    */
    private String salt;
    /**
    * 所属角色id
    */
    private Integer roleid;
    /**
    * 联系电话
    */
    private String phone;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 身份证号
    */
    private String cardId;
    /**
    * 营业执照
    */
    private String supportImg;
    /**
    * 1正常，0锁定
    */
    private Integer isLocked;
    /**
    * 注册时间
    */
    private Date createTime;


    private String permission;

}
