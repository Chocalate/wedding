package com.lingnan.wedding.mapper;

import com.lingnan.wedding.core.entity.UserAddress;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户地址表(UserAddress)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-31 23:04:06
 */
public interface UserAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserAddress queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserAddress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userAddress 实例对象
     * @return 对象列表
     */
    List<UserAddress> queryAll(UserAddress userAddress);

    /**
     * 新增数据
     *
     * @param userAddress 实例对象
     * @return 影响行数
     */
    boolean insert(UserAddress userAddress);

    /**
     * 修改数据
     *
     * @param userAddress 实例对象
     * @return 影响行数
     */
    int update(UserAddress userAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
