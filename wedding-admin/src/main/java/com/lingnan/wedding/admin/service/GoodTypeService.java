package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.GoodType;
import java.util.List;

/**
 * 房间类型(GoodType)表服务接口
 *
 * @author makejava
 * @since 2021-03-20 09:40:32
 */
public interface GoodTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GoodType queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<GoodType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param goodType 实例对象
     * @return 实例对象
     */
    GoodType insert(GoodType goodType);

    /**
     * 修改数据
     *
     * @param goodType 实例对象
     * @return 实例对象
     */
    GoodType update(GoodType goodType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 统计数量
     */
    Integer queryAllCount();

    List<GoodType> queryAllType();
}