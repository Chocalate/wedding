package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.admin.service.RoleUserService;
import com.lingnan.wedding.core.entity.Role;
import com.lingnan.wedding.mapper.RoleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色：后台管理员的权限角色(Role)表服务实现类
 *
 * @author makejava
 * @since 2021-03-08 16:05:05
 */
@Service("roleService")
public class RoleServiceImpl implements RoleUserService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    @Override
    public Role queryById(Integer id) {
        return this.roleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    @Override
    public List<Role> queryAllByLimit(int offset, int limit) {
        return this.roleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */

    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */

    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    @Override
    public boolean deleteById(Integer id) {
        return this.roleDao.deleteById(id) > 0;
    }

    @Override
    public List<Role> queryAllRole() {
        return roleDao.queryAll();
    }

    @Override
    public Integer queryRoleCount() {
        return roleDao.queryRoleCount();
    }
}