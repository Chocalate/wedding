package com.lingnan.wedding.core.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 图片上传记录(UploadLog)实体类
 *
 * @author makejava
 * @since 2021-03-20 21:54:00
 */
@ToString
@Data
public class UploadLog implements Serializable {
    private static final long serialVersionUID = 500325460420047438L;
    
    private Integer id;
    /**
    * 图片url
    */
    private String imgUrl;
    
    private Integer roleid;
    /**
    * 操作名称
    */
    private String operationName;
    
    private Integer createUser;

    private String userName;
    
    private String createTime;

    private String role;

    /**
     * 是否删除，否为0，是为1
     */
    private Integer isDel;

}