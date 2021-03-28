package com.lingnan.wedding.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author makejava
 * @since 2021-03-10 15:43:33
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -46699360415196810L;
    
    private Integer roleid;
    
    private String permission;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}