package com.lingnan.wedding.admin.controller;

import com.lingnan.wedding.admin.service.NoticeService;
import com.lingnan.wedding.core.entity.Notice;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 前台公告栏(Notice)表控制层
 *
 * @author lily
 * @since 2021-03-18 14:26:51
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Notice selectOne(Integer id) {
        return this.noticeService.queryById(id);
    }

}