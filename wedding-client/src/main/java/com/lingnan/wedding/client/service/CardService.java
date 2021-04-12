package com.lingnan.wedding.client.service;

import com.lingnan.wedding.client.vo.CardInfoVo;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.core.entity.ShopCart;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-30 13:43
 **/

public interface CardService {

    Map<String,List<CardInfoVo>> listById(Integer userId);

    boolean batchDelete(List<Integer> ids,Integer userId);


    boolean insert(Integer goodsList,Integer userId);
}
