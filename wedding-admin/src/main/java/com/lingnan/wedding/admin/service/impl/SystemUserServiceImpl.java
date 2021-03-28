package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.admin.service.SystemUserService;
import com.lingnan.wedding.core.entity.SystemUser;
import com.lingnan.wedding.mapper.SystemUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-03-08 16:05:07
 */
@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService {
    @Resource
    private SystemUserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    @Override
    public SystemUser queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 通过NAME查询单条数据
     *
     * @param name 主键
     * @return 实例对象
     */

    @Override
    public SystemUser queryByName(String name) {
        return this.userDao.queryByName(name);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    @Override
    public List<SystemUser> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */

    @Override
    public SystemUser insert(SystemUser user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */

    @Override
    public SystemUser update(SystemUser user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    /**
     * 查询所有管理员数量
     * @return
     */
    @Override
    public Integer queryAllCount() {
        return userDao.queryAllCount();
    }
}