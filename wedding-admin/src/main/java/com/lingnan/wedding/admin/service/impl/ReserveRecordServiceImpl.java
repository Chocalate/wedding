package com.lingnan.wedding.admin.service.impl;

import com.lingnan.wedding.core.entity.OrderType;
import com.lingnan.wedding.core.entity.ReserveRecord;
import com.lingnan.wedding.mapper.ReserveRecordDao;
import com.lingnan.wedding.admin.service.ReserveRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订房记录(ReserveRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-03-22 11:18:11
 */
@Service("reserveRecordService")
public class ReserveRecordServiceImpl implements ReserveRecordService {
    @Resource
    private ReserveRecordDao reserveRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReserveRecord queryById(Integer id) {
        return this.reserveRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ReserveRecord> queryAllByLimit(int offset, int limit,String account,String statusName) {
        return this.reserveRecordDao.queryAllByLimit(offset, limit,account,statusName);
    }

    /**
     * 新增数据
     *
     * @param reserveRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ReserveRecord insert(ReserveRecord reserveRecord) {
        this.reserveRecordDao.insert(reserveRecord);
        return reserveRecord;
    }

    /**
     * 修改数据
     *
     * @param reserveRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ReserveRecord update(ReserveRecord reserveRecord) {
        this.reserveRecordDao.update(reserveRecord);
        return this.queryById(reserveRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.reserveRecordDao.deleteById(id);
    }

    @Override
    public Integer queryAllCount() {
        return reserveRecordDao.queryAllCount();
    }

    @Override
    public List<OrderType> queryOrderTypes() {
        return reserveRecordDao.queryOrderTypes();
    }


}
