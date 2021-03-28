package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.Share;
import com.lingnan.wedding.mapper.ShareDao;
import com.lingnan.wedding.admin.service.ShareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Share)表服务实现类
 *
 * @author makejava
 * @since 2021-03-23 02:33:37
 */
@Service("shareService")
public class ShareServiceImpl implements ShareService {
    @Resource
    private ShareDao shareDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Share queryById(Integer id) {
        return this.shareDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Share> queryAllByLimit(int offset, int limit) {
        return this.shareDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param share 实例对象
     * @return 实例对象
     */
    @Override
    public Share insert(Share share) {
        this.shareDao.insert(share);
        return share;
    }

    /**
     * 修改数据
     *
     * @param share 实例对象
     * @return 实例对象
     */
    @Override
    public Share update(Share share) {
        this.shareDao.update(share);
        return this.queryById(share.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shareDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryAllcount() {
        return shareDao.queryAllcount();
    }
}