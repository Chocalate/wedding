package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.UploadLog;
import java.util.List;

/**
 * 图片上传记录(UploadLog)表服务接口
 *
 * @author makejava
 * @since 2021-03-20 21:58:04
 */
public interface UploadLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UploadLog queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UploadLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param uploadLog 实例对象
     * @return 实例对象
     */
    UploadLog insert(UploadLog uploadLog);

    /**
     * 修改数据
     *
     * @param uploadLog 实例对象
     * @return 实例对象
     */
    UploadLog update(UploadLog uploadLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Integer queryAllCount();

    boolean clear();

}