package com.lingnan.wedding.admin.service;

import com.lingnan.wedding.core.entity.OrderType;
import com.lingnan.wedding.core.entity.ReserveRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订房记录(ReserveRecord)表服务接口
 *
 * @author makejava
 * @since 2021-03-22 11:18:10
 */
public interface ReserveRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReserveRecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReserveRecord> queryAllByLimit(int offset, int limit,String account,String statusName);

    List<ReserveRecord> queryBusinessRevByLimit(int offset, int limit,String statusName,Integer businessId);

    /**
     * 新增数据
     *
     * @param reserveRecord 实例对象
     * @return 实例对象
     */
    ReserveRecord insert(ReserveRecord reserveRecord);

    /**
     * 修改数据
     *
     * @param reserveRecord 实例对象
     * @return 实例对象
     */
    ReserveRecord update(ReserveRecord reserveRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Integer queryAllCount();

    Integer queryBusinessRevCount(String statusName,Integer businessId);

    List<OrderType> queryOrderTypes();
}
