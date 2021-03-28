package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.ClientUser;
import com.lingnan.wedding.mapper.ClientUserDao;
import com.lingnan.wedding.admin.service.ClientUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(ClientUser)表服务实现类
 *
 * @author makejava
 * @since 2021-03-21 21:35:48
 */
@Service("clientUserService")
public class ClientUserServiceImpl implements ClientUserService {
    @Resource
    private ClientUserDao clientUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ClientUser queryById(Integer id) {
        return this.clientUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ClientUser> queryAllByLimit(int offset, int limit,String account,String nickname) {
        return this.clientUserDao.queryAllByLimit(offset, limit,account,nickname);
    }

    /**
     * 新增数据
     *
     * @param clientUser 实例对象
     * @return 实例对象
     */
    @Override
    public ClientUser insert(ClientUser clientUser) {
        this.clientUserDao.insert(clientUser);
        return clientUser;
    }

    /**
     * 修改数据
     *
     * @param clientUser 实例对象
     * @return 实例对象
     */
    @Override
    public ClientUser update(ClientUser clientUser) {
        this.clientUserDao.update(clientUser);
        return this.queryById(clientUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.clientUserDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryAllCount() {
        return clientUserDao.queryAllCount();
    }

    @Override
    public ClientUser queryByName(String account) {
        return clientUserDao.queryByName(account);
    }
}