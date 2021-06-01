package com.lingnan.wedding.client.controller;

import com.lingnan.wedding.client.service.CommentService;
import com.lingnan.wedding.client.service.SuggestionService;
import com.lingnan.wedding.client.util.ResultVOUtil;
import com.lingnan.wedding.client.vo.ResultVO;
import com.lingnan.wedding.core.entity.Comment;
import com.lingnan.wedding.core.entity.Suggestion;
import com.lingnan.wedding.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-30 13:59
 **/
@RestController
@RequestMapping("/wedding/client/suggestion")
public class SuggestionController {

    Logger logger = LoggerFactory.getLogger(SuggestionController.class);
   @Resource
    private SuggestionService suggestionService;

    @RequestMapping("/addSuggestion")
    public ResultVO addComment(@RequestBody Suggestion suggestion){
        try {
            logger.info("suggestion--------------{}",suggestion);
            suggestion.setCreateTime(DateUtil.dateToString(new Date()));
            Suggestion s = suggestionService.insert(suggestion);
            return ResultVOUtil.success(s);
        }catch (Exception e){
            logger.info("ddddddddd{}",e);
            return ResultVOUtil.error(e.getMessage());
        }
    }



}
