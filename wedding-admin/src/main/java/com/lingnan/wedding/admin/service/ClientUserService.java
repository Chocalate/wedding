package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.ClientUser;
import java.util.List;

/**
 * 用户表(ClientUser)表服务接口
 *
 * @author makejava
 * @since 2021-03-21 21:35:48
 */
public interface ClientUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClientUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ClientUser> queryAllByLimit(int offset, int limit,String account,String nickname);

    /**
     * 新增数据
     *
     * @param clientUser 实例对象
     * @return 实例对象
     */
    ClientUser insert(ClientUser clientUser);

    /**
     * 修改数据
     *
     * @param clientUser 实例对象
     * @return 实例对象
     */
    ClientUser update(ClientUser clientUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Integer queryAllCount();

    ClientUser queryByName(String account);



}