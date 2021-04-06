package com.lingnan.wedding.mapper;

import com.lingnan.wedding.core.entity.ShopCart;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 购物车(ShopCart)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-30 13:26:02
 */
public interface ShopCartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShopCart queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ShopCart> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shopCart 实例对象
     * @return 对象列表
     */
    List<ShopCart> queryAll(ShopCart shopCart);

    /**
     * 新增数据
     *
     * @param shopCart 实例对象
     * @return 影响行数
     */
    boolean insert(ShopCart shopCart);

    /**
     * 修改数据
     *
     * @param shopCart 实例对象
     * @return 影响行数
     */
    boolean update(ShopCart shopCart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    boolean batchDelete(@Param("id") List<Integer> id,@Param("userId") Integer userId);

    List<ShopCart> listById(Integer userId);

}
