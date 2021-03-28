package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.UploadLog;
import com.lingnan.wedding.mapper.UploadLogDao;
import com.lingnan.wedding.admin.service.UploadLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图片上传记录(UploadLog)表服务实现类
 *
 * @author makejava
 * @since 2021-03-20 21:58:04
 */
@Service("uploadLogService")
public class UploadLogServiceImpl implements UploadLogService {
    @Resource
    private UploadLogDao uploadLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UploadLog queryById(Integer id) {
        return this.uploadLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UploadLog> queryAllByLimit(int offset, int limit) {
        return this.uploadLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param uploadLog 实例对象
     * @return 实例对象
     */
    @Override
    public UploadLog insert(UploadLog uploadLog) {
        this.uploadLogDao.insert(uploadLog);
        return uploadLog;
    }

    /**
     * 修改数据
     *
     * @param uploadLog 实例对象
     * @return 实例对象
     */
    @Override
    public UploadLog update(UploadLog uploadLog) {
        this.uploadLogDao.update(uploadLog);
        return this.queryById(uploadLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.uploadLogDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryAllCount() {
        return uploadLogDao.queryAllCount();
    }

    @Override
    public boolean clear() {
        return uploadLogDao.clear();
    }
}