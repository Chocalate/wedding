package com.lingnan.wedding.client.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-30 13:44
 **/
@Data
@AllArgsConstructor
public class CardInfoVo {
    @JsonProperty("id")
    private Integer goodsId;
    @JsonProperty("title")
    private String goodsName;
    @JsonProperty("price")
    private String sellingPrice;
    @JsonProperty("desc")
    private String goodsIntro;
    @JsonProperty("thumb")
    private String goodsImg;
    @JsonProperty("num")
    private Integer count;
    @JsonProperty("max")
    private Integer stockNum;
    private boolean flag;
}
