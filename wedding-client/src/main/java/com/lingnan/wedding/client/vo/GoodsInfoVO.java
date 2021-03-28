package com.lingnan.wedding.client.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-27 18:33
 **/
@Data
@AllArgsConstructor
public class GoodsInfoVO {
    @JsonProperty("id")
    private Integer goodsId;
    @JsonProperty("title")
    private String goodsName;
    @JsonProperty("price")
    private String sellingPrice;
    @JsonProperty("desc")
    private String goodsIntro;
    private List<Map<String,String>> tag;
    @JsonProperty("thumb")
    private String goodsImg;
}
