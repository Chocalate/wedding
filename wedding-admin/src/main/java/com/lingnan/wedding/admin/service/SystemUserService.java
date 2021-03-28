package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.SystemUser;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-03-08 16:05:07
 */
public interface SystemUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SystemUser queryById(Integer id);

    /**
     * 通过NAME查询单条数据
     *
     * @param name 主键
     * @return 实例对象
     */
    SystemUser queryByName(String name);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SystemUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    SystemUser insert(SystemUser user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    SystemUser update(SystemUser user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Integer queryAllCount();


}