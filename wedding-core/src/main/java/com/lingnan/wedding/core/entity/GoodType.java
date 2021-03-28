package com.lingnan.wedding.core.entity;

import java.io.Serializable;

/**
 * 房间类型(GoodType)实体类
 *
 * @author makejava
 * @since 2021-03-20 09:32:15
 */
public class GoodType implements Serializable {
    private static final long serialVersionUID = 712561782598599032L;
    
    private Integer id;
    /**
    * 商品类型
    */
    private String type;
    /**
    * 类型介绍  
    */
    private String typeInfo;
    /**
    * 分类级别(1-一级分类 2-二级分类 3-三级分类)
    */
    private Integer typeLevel;
    /**
    * 父分类id，默认为一级，值为0
    */
    private Integer parentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
    }

    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}