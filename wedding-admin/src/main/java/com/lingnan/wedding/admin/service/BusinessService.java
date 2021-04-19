package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.Business;
import com.lingnan.wedding.core.entity.SystemUser;

import java.util.List;

/**
 * (Business)表服务接口
 *
 * @author makejava
 * @since 2021-04-12 14:09:04
 */
public interface BusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Business queryById(Integer id);

    Business queryByName(String name);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Business> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business insert(Business business);

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business update(Business business);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
