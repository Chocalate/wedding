package com.lingnan.wedding.client.controller;

import com.lingnan.wedding.client.service.CardService;
import com.lingnan.wedding.client.service.CommentService;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.vo.CardInfoVo;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.Comment;
import com.lingnan.wedding.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-30 13:59
 **/
@RestController
@RequestMapping("/wedding/client/comment")
public class CommentController {

    Logger logger = LoggerFactory.getLogger(CommentController.class);
   @Resource
    private CommentService commentService;

    @RequestMapping("/addComment")
    public ResultVO addComment(@RequestBody Comment comment){
        try {
            logger.info("comment--------------{}",comment);
            comment.setAssessTime(DateUtil.dateToString(new Date()));
            Comment com = commentService.insert(comment);
            return ResultVOUtil.success(com);
        }catch (Exception e){
            logger.info("ddddddddd{}",e);
            return ResultVOUtil.error(e.getMessage());
        }
    }

    @RequestMapping("/queryByUserName/{username}")

    public ResultVO queryByUserName(@PathVariable("username") String username){
        try {
            logger.info("username--------------{}",username);
            List<Comment> comments = commentService.queryByUserName(username);
            return ResultVOUtil.success(comments);
        }catch (Exception e){
            logger.info("ddddddddd{}",e);
            return ResultVOUtil.error(e.getMessage());
        }
    }


}
