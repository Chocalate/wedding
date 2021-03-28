package com.lingnan.wedding.admin.service.impl;


import com.lingnan.wedding.admin.service.LoginLogService;
import com.lingnan.wedding.core.entity.LoginLog;
import com.lingnan.wedding.mapper.LoginLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录日志(LoginLog)表服务实现类
 *
 * @author makejava
 * @since 2021-03-17 16:29:01
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    @Resource
    private LoginLogDao loginLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LoginLog queryById(Integer id) {
        return this.loginLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LoginLog> queryAllByLimit(int offset, int limit) {
        return this.loginLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    @Override
    public LoginLog insert(LoginLog loginLog) {
        this.loginLogDao.insert(loginLog);
        return loginLog;
    }

    /**
     * 修改数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    @Override
    public LoginLog update(LoginLog loginLog) {
        this.loginLogDao.update(loginLog);
        return this.queryById(loginLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.loginLogDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryLogCount() {
        return loginLogDao.queryLogCount();
    }

    @Override
    public boolean deleteAllLog() {
        return loginLogDao.deleteAllLog();
    }
}