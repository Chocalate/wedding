package com.lingnan.wedding.mapper;

import com.lingnan.wedding.core.entity.OrderType;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OrderType)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-01 14:41:08
 */
public interface OrderTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderType queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    List<OrderType> queryAll();

    /**
     * 新增数据
     *
     * @param orderType 实例对象
     * @return 影响行数
     */
    int insert(OrderType orderType);

    /**
     * 修改数据
     *
     * @param orderType 实例对象
     * @return 影响行数
     */
    int update(OrderType orderType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


}
