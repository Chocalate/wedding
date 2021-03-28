package com.lingnan.wedding.client.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-27 16:54
 **/
@Data
@AllArgsConstructor
public class GoodTypeDataVo {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String type;
}
