package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-03-08 16:05:07
 */
@Data
@ToString
public class SystemUser implements Serializable {
    private static final long serialVersionUID = -19063571109269427L;
    /**
    * 用户主键id
    */
    private Integer id;
    /**
    * 用户昵称
    */
    private String nickname;
    /**
    * 登陆名称
    */
    private String username;
    /**
    * MD5加密后的密码
    */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
    * 加密盐
    */
    private String salt;
    /**
    * 所属角色
    */
    private Integer roleid;
    /**
    * 注销标识字段(0-正常 1-已注销)
    */
    private int isDeleted;
    /**
    * 锁定标识字段(0-未锁定 1-已锁定)
    */
    private int lockedFlag;
    /**
    * 注册时间
    */
    private Date createTime;

    private String roleName;

    private String permission;

}