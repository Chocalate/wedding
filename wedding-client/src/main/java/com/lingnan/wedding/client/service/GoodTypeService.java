package com.lingnan.wedding.client.service;

import com.lingnan.wedding.client.vo.GoodTypeVo;
import com.lingnan.wedding.client.vo.GoodsInfoVO;
import com.lingnan.wedding.core.entity.GoodType;

import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-27 13:02
 **/

public interface GoodTypeService {

    GoodTypeVo queryAll();


    List<GoodsInfoVO> findGoodsInfoVOByCategoryType(Integer goodsTypeId);


}
