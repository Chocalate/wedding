package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色：后台管理员的权限角色(Role)实体类
 *
 * @author makejava
 * @since 2021-03-08 16:05:03
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -31439272704872152L;
    
    private Integer id;
    /**
    * 角色
    */
    private String role;
    /**
    * 角色等级
    */
    private String level;
    /**
    * 角色职能
    */
    private String detail;

}