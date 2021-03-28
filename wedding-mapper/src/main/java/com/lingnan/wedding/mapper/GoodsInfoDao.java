package com.lingnan.wedding.mapper;

import com.lingnan.wedding.core.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (GoodsInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-20 10:26:40
 */
public interface GoodsInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    GoodsInfo queryById(Integer goodsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<GoodsInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("goodsName") String goodsName,@Param("goodsSellStatus") Integer goodsSellStatus);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param goodsInfo 实例对象
     * @return 对象列表
     */
    List<GoodsInfo> queryAll(GoodsInfo goodsInfo);

    /**
     * 新增数据
     *
     * @param goodsInfo 实例对象
     * @return 影响行数
     */
    int insert(GoodsInfo goodsInfo);

    /**
     * 修改数据
     *
     * @param goodsInfo 实例对象
     * @return 影响行数
     */
    int update(GoodsInfo goodsInfo);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 影响行数
     */
    int deleteById(Integer goodsId);


    Integer queryAllCount();

    GoodsInfo queryDetail(Integer goodsId);

    List<GoodsInfo>  findAllByGoodsType (@Param("goodsTypeId") Integer goodsTypeId);

    List<GoodsInfo> searchHot();
}
