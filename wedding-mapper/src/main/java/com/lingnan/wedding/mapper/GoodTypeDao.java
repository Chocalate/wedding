package com.lingnan.wedding.mapper;

import com.lingnan.wedding.core.entity.GoodType;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 房间类型(GoodType)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-20 09:38:12
 */
public interface GoodTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GoodType queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<GoodType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param goodType 实例对象
     * @return 对象列表
     */
    List<GoodType> queryAll(GoodType goodType);

    /**
     * 新增数据
     *
     * @param goodType 实例对象
     * @return 影响行数
     */
    int insert(GoodType goodType);

    /**
     * 修改数据
     *
     * @param goodType 实例对象
     * @return 影响行数
     */
    int update(GoodType goodType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 统计数量
     */
    Integer queryAllCount();

    List<GoodType> queryAllType();


    List<GoodType> queryAll();

}
