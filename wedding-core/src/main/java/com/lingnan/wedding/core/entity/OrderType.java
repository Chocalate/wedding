package com.lingnan.wedding.core.entity;

import java.io.Serializable;

/**
 * (OrderType)实体类
 *
 * @author makejava
 * @since 2021-03-22 21:31:40
 */
public class OrderType implements Serializable {
    private static final long serialVersionUID = -49578544883372001L;
    
    private Integer id;
    
    private String statusName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}