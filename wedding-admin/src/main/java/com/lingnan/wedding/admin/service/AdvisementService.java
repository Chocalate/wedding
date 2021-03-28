package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.Advisement;
import java.util.List;

/**
 * 前台公告栏(Advisement)表服务接口
 *
 * @author makejava
 * @since 2021-03-18 15:15:00
 */
public interface AdvisementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Advisement queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Advisement> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param advisement 实例对象
     * @return 实例对象
     */
    Advisement insert(Advisement advisement);

    /**
     * 修改数据
     *
     * @param advisement 实例对象
     * @return 实例对象
     */
    Advisement update(Advisement advisement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询数量
     * @return 是否成功
     */
    Integer queryAllCount();

    /**
     * 首现
     */
    Integer updateById(Integer id);
}