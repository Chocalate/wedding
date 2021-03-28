package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.Advisement;
import com.lingnan.wedding.mapper.AdvisementDao;
import com.lingnan.wedding.admin.service.AdvisementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前台公告栏(Advisement)表服务实现类
 *
 * @author makejava
 * @since 2021-03-18 15:15:00
 */
@Service("advisementService")
public class AdvisementServiceImpl implements AdvisementService {
    @Resource
    private AdvisementDao advisementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Advisement queryById(Integer id) {
        return this.advisementDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Advisement> queryAllByLimit(int offset, int limit) {
        return this.advisementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param advisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advisement insert(Advisement advisement) {
        this.advisementDao.insert(advisement);
        return advisement;
    }

    /**
     * 修改数据
     *
     * @param advisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advisement update(Advisement advisement) {
        this.advisementDao.update(advisement);
        return this.queryById(advisement.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.advisementDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryAllCount() {
        return advisementDao.queryAllCount();
    }

    @Override
    public Integer updateById(Integer id) {
        return advisementDao.updateById(id);
    }


}