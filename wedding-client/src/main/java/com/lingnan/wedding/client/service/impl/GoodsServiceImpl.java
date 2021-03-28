package com.lingnan.wedding.client.service.impl;

import com.lingnan.wedding.client.service.GoodsService;
import com.lingnan.wedding.client.util.GoodsUtil;
import com.lingnan.wedding.client.vo.GoodsInfoVO;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.mapper.GoodsInfoDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-28 18:14
 **/
@Service("goodsService")
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Resource
    private GoodsInfoDao goodsInfoDao;

    @Override
    public Map<String, List<GoodsInfoVO>> searchHot() {
        Map<String, List<GoodsInfoVO>> map = new LinkedHashMap<>();
        List<GoodsInfo> goodsInfoList = goodsInfoDao.searchHot();
        map.put("goodsList",getGoodInfoVo(goodsInfoList));
        return map;
    }

    @Override
    public Map<String, List<GoodsInfoVO>> searchGoodsByName(GoodsInfo goodsInfo) {
        Map<String, List<GoodsInfoVO>> map = new LinkedHashMap<>();
        List<GoodsInfo> goodsInfoList = goodsInfoDao.queryAll(goodsInfo);
        map.put("goodsList",getGoodInfoVo(goodsInfoList));
        return map;
    }

public List<GoodsInfoVO> getGoodInfoVo( List<GoodsInfo> goodsInfoList){
    List<GoodsInfoVO> goodsInfoVOList = goodsInfoList.stream().map(
            e -> new GoodsInfoVO(
                    e.getGoodsId(),
                    e.getGoodsName(),
                    e.getSellingPrice()+"",
                    e.getGoodsIntro(),
                    GoodsUtil.createTag(e.getTag()),
                    e.getGoodsImg()
            )).collect(Collectors.toList());
       return goodsInfoVOList;
}
}
