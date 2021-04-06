package com.lingnan.wedding.mapper;

import com.lingnan.wedding.core.entity.OrderType;
import com.lingnan.wedding.core.entity.ReserveRecord;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订房记录(ReserveRecord)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-22 11:17:12
 */
public interface ReserveRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReserveRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReserveRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("account") String account,@Param("statusName")String statusName);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reserveRecord 实例对象
     * @return 对象列表
     */
    List<ReserveRecord> queryAll(ReserveRecord reserveRecord);

    /**
     * 新增数据
     *
     * @param reserveRecord 实例对象
     * @return 影响行数
     */
    boolean insert(ReserveRecord reserveRecord);

    /**
     * 修改数据
     *
     * @param reserveRecord 实例对象
     * @return 影响行数
     */
    boolean update(ReserveRecord reserveRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    boolean deleteById(Integer id);

    Integer queryAllCount();

    List<OrderType> queryOrderTypes();

    List<ReserveRecord> queryReserve(@Param("userId")Integer userId);

    Integer queryByStateName(Integer id);


}
