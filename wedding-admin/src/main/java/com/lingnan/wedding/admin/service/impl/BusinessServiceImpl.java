package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.Business;
import com.lingnan.wedding.core.entity.SystemUser;
import com.lingnan.wedding.mapper.BusinessDao;
import com.lingnan.wedding.admin.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Business)表服务实现类
 *
 * @author makejava
 * @since 2021-04-12 14:09:04
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessDao businessDao;


    @Override
    public Business queryByName(String name) {
        return this.businessDao.queryByName(name);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Business queryById(Integer id) {
        return this.businessDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Business> queryAllByLimit(int offset, int limit) {
        return this.businessDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    @Override
    public Business insert(Business business) {
        this.businessDao.insert(business);
        return business;
    }

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    @Override
    public Business update(Business business) {
        this.businessDao.update(business);
        return this.queryById(business.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.businessDao.deleteById(id) > 0;
    }
}
