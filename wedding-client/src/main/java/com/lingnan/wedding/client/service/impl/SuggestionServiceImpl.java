package com.lingnan.wedding.client.service.impl;

import com.lingnan.wedding.core.entity.Suggestion;
import com.lingnan.wedding.mapper.SuggestionDao;
import com.lingnan.wedding.client.service.SuggestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Suggestion)表服务实现类
 *
 * @author makejava
 * @since 2021-04-24 03:39:36
 */
@Service("suggestionService")
public class SuggestionServiceImpl implements SuggestionService {
    @Resource
    private SuggestionDao suggestionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Suggestion queryById(Integer id) {
        return this.suggestionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Suggestion> queryAllByLimit(int offset, int limit) {
        return this.suggestionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param suggestion 实例对象
     * @return 实例对象
     */
    @Override
    public Suggestion insert(Suggestion suggestion) {
        this.suggestionDao.insert(suggestion);
        return suggestion;
    }

    /**
     * 修改数据
     *
     * @param suggestion 实例对象
     * @return 实例对象
     */
    @Override
    public Suggestion update(Suggestion suggestion) {
        this.suggestionDao.update(suggestion);
        return this.queryById(suggestion.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.suggestionDao.deleteById(id) > 0;
    }
}
