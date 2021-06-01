package com.lingnan.wedding.mapper;

import com.lingnan.wedding.core.entity.Comment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-21 14:16:27
 */
public interface CommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Comment queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("goodsName") String goodsName);





    /**
     * 通过实体作为筛选条件查询
     *
     * @param id
     * @return 对象列表
     */
    Comment queryAll(@Param("id") Integer id);



    List<Comment> queryByUserName(@Param("username") String username);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 影响行数
     */
    int insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 影响行数
     */
    int update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Integer queryAllCount();

    boolean deleteByGoodsId(Integer id);

}
