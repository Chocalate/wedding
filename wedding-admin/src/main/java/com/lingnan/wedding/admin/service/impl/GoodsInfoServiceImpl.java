package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.admin.service.GoodsInfoService;
import com.lingnan.wedding.mapper.GoodsInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsInfo)表服务实现类
 *
 * @author lily
 * @since 2021-03-19 17:10:26
 */
@Service("goodsInfoService")
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Resource
    private GoodsInfoDao goodsInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public GoodsInfo queryById(Integer goodsId) {
        return this.goodsInfoDao.queryById(goodsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<GoodsInfo> queryAllByLimit(int offset, int limit,String goodsName,Integer goodsSellStatus) {
        return this.goodsInfoDao.queryAllByLimit(offset, limit,goodsName,goodsSellStatus);
    }

    /**
     * 新增数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsInfo insert(GoodsInfo goodsInfo) {
        this.goodsInfoDao.insert(goodsInfo);
        return goodsInfo;
    }

    /**
     * 修改数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    @Override
    public GoodsInfo update(GoodsInfo goodsInfo) {
        this.goodsInfoDao.update(goodsInfo);
        return this.queryById(goodsInfo.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodsId) {
        return this.goodsInfoDao.deleteById(goodsId) > 0;
    }

    @Override
    public Integer queryAllCount() {
        return goodsInfoDao.queryAllCount();
    }

    @Override
    public GoodsInfo queryDetail(Integer goodsId) {
        return goodsInfoDao.queryDetail(goodsId);
    }
}