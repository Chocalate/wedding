package com.lingnan.wedding.client.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lingnan.wedding.core.entity.Advisement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-27 13:04
 **/
@Data
public class GoodTypeVo {

    List<GoodTypeDataVo> navList;

    List<GoodsInfoVO> goods;

    List<Advisement> swiperImg;
}
