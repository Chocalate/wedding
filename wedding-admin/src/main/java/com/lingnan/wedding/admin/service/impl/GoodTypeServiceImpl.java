package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.GoodType;
import com.lingnan.wedding.mapper.GoodTypeDao;
import com.lingnan.wedding.admin.service.GoodTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房间类型(GoodType)表服务实现类
 *
 * @author makejava
 * @since 2021-03-20 09:40:34
 */
@Service("goodTypeService")
public class GoodTypeServiceImpl implements GoodTypeService {
    @Resource
    private GoodTypeDao goodTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public GoodType queryById(Integer id) {
        return this.goodTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<GoodType> queryAllByLimit(int offset, int limit) {
        return this.goodTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param goodType 实例对象
     * @return 实例对象
     */
    @Override
    public GoodType insert(GoodType goodType) {
        this.goodTypeDao.insert(goodType);
        return goodType;
    }

    /**
     * 修改数据
     *
     * @param goodType 实例对象
     * @return 实例对象
     */
    @Override
    public GoodType update(GoodType goodType) {
        this.goodTypeDao.update(goodType);
        return this.queryById(goodType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.goodTypeDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryAllCount() {
        return goodTypeDao.queryAllCount();
    }

    @Override
    public List<GoodType> queryAllType() {
        return goodTypeDao.queryAllType();
    }
}