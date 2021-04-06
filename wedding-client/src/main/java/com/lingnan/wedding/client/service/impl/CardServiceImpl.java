package com.lingnan.wedding.client.service.impl;

import com.lingnan.wedding.client.controller.CardController;
import com.lingnan.wedding.client.service.CardService;
import com.lingnan.wedding.client.vo.CardInfoVo;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.core.entity.ShopCart;
import com.lingnan.wedding.mapper.ShopCartDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-30 13:43
 **/

@Service("cardService")
public class CardServiceImpl implements CardService {

    Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);
    @Resource
    private ShopCartDao shopCartDao;

    @Override
    public Map<String, List<CardInfoVo>> listById(Integer userId) {
        Map<String, List<CardInfoVo>> map = new HashMap<>();
        List<ShopCart> shopCartsList = shopCartDao.listById(userId);
        if(shopCartsList!=null) {
            List<CardInfoVo> cardInfoVos = shopCartsList.stream().map(
                    e -> new CardInfoVo(
                            e.getGoodsId(),
                            e.getGoodsName(),
                            e.getSellingPrice() + "",
                            e.getGoodsIntro(),
                            e.getGoodsImg(),
                            e.getCount(),
                            e.getStockNum(),
                            false
                    )).collect(Collectors.toList());
            map.put("cartList", cardInfoVos);
        }
        return map;
    }

    @Override
    public boolean batchDelete(List<Integer> ids,Integer userId) {

        return shopCartDao.batchDelete(ids, userId);
    }

    @Override
    public boolean insert(GoodsInfo goodsList) {
        ShopCart shopCart = new ShopCart();
        boolean flag;
        shopCart.setGoodsId(goodsList.getGoodsId());
        shopCart.setUserId(120);
        List<ShopCart> shopCarts = shopCartDao.queryAll(shopCart);

        if(shopCarts.size()==0){
            shopCart.setCreateTime(new Date());
            shopCart.setModifyTime(new Date());
            shopCart.setCount(1);
             flag = shopCartDao.insert(shopCart);
        }else{
            logger.info("here");
            shopCart.setId(shopCarts.get(0).getId());
            shopCart.setModifyTime(new Date());
            shopCart.setCount(shopCarts.get(0).getCount()+1);
            flag = shopCartDao.update(shopCart);
        }

        return flag;

    }
}
