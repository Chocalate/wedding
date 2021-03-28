package com.lingnan.wedding.client.service;

import com.lingnan.wedding.client.vo.GoodsInfoVO;
import com.lingnan.wedding.core.entity.GoodsInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-28 18:12
 **/

public interface GoodsService {
    Map<String, List<GoodsInfoVO>> searchHot();

    Map<String, List<GoodsInfoVO>> searchGoodsByName(GoodsInfo goodsInfo);
}
