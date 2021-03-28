package com.lingnan.wedding.client.service.impl;

import com.lingnan.wedding.client.service.GoodTypeService;
import com.lingnan.wedding.client.util.GoodsUtil;
import com.lingnan.wedding.client.vo.GoodTypeDataVo;
import com.lingnan.wedding.client.vo.GoodTypeVo;
import com.lingnan.wedding.client.vo.GoodsInfoVO;
import com.lingnan.wedding.core.entity.Advisement;
import com.lingnan.wedding.core.entity.GoodType;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.mapper.AdvisementDao;
import com.lingnan.wedding.mapper.GoodTypeDao;
import com.lingnan.wedding.mapper.GoodsInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-27 13:02
 **/
@Service("goodTypeService")
public class GoodTypeServiceImpl  implements GoodTypeService {

    Logger logger = LoggerFactory.getLogger(GoodTypeServiceImpl.class);

    @Autowired
    private GoodTypeDao goodTypeDao;

    @Resource
    private GoodsInfoDao goodsInfoDao;

    @Resource
    private AdvisementDao advisementDao;

    @Override
    public GoodTypeVo queryAll() {
        //类型
        GoodTypeVo goodTypeVo = new GoodTypeVo();
        List<GoodType> goodTypes = goodTypeDao.queryAll();
        List<GoodTypeDataVo> goodTypeVoList = goodTypes.stream().map(e -> new GoodTypeDataVo(
                e.getId(),
                e.getType()
        )).collect(Collectors.toList());

        goodTypeVo.setNavList(goodTypeVoList);

        //商品
        List<GoodsInfo> goodsInfoList = goodsInfoDao.findAllByGoodsType(goodTypeVoList.get(0).getId());

        List<GoodsInfoVO> goodsInfoVOList = goodsInfoList.stream().map(
                e -> new GoodsInfoVO(
                        e.getGoodsId(),
                        e.getGoodsName(),
                        e.getSellingPrice()+"",
                        e.getGoodsIntro(),
                        GoodsUtil.createTag(e.getTag()),
                        e.getGoodsImg()
                )).collect(Collectors.toList());

        goodTypeVo.setGoods(goodsInfoVOList);

        // 轮播图
        List<Advisement> advisementsList = advisementDao.queryByIsShow();
        goodTypeVo.setSwiperImg(advisementsList);

        return  goodTypeVo;
    }

    @Override
    public List<GoodsInfoVO> findGoodsInfoVOByCategoryType(Integer goodsTypeId) {
        List<GoodsInfo> goodsInfoList = goodsInfoDao.findAllByGoodsType(goodsTypeId);
        List<GoodsInfoVO> goodsInfoVOList = goodsInfoList.stream()
                .map(e -> new GoodsInfoVO(
                        e.getGoodsId(),
                        e.getGoodsName(),
                        e.getSellingPrice()+".00",
                        e.getGoodsIntro(),
                        GoodsUtil.createTag(e.getTag()),
                        e.getGoodsImg()
                )).collect(Collectors.toList());
        return goodsInfoVOList;
    }




}
