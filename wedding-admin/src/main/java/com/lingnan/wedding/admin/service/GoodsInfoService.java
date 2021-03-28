package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.GoodsInfo;
import java.util.List;

/**
 * (GoodsInfo)表服务接口
 *
 * @author makejava
 * @since 2021-03-20 10:31:24
 */
public interface GoodsInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    GoodsInfo queryById(Integer goodsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<GoodsInfo> queryAllByLimit(int offset, int limit,String goodsName,Integer goodsSellStatus);

    /**
     * 新增数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    GoodsInfo insert(GoodsInfo goodsInfo);

    /**
     * 修改数据
     *
     * @param goodsInfo 实例对象
     * @return 实例对象
     */
    GoodsInfo update(GoodsInfo goodsInfo);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsId);

    Integer queryAllCount();

    GoodsInfo queryDetail(Integer goodsId);
}