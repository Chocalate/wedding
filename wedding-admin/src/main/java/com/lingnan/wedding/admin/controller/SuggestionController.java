package com.lingnan.wedding.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingnan.wedding.admin.service.SuggestionService;
import com.lingnan.wedding.core.entity.Suggestion;
import com.lingnan.wedding.core.util.ResultData;
import com.lingnan.wedding.core.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-15 22:42
 **/

/**
 * 留言建议控制器
 */

@Controller
@RequestMapping("wedding/admin/suggestion")
public class SuggestionController {

    private static final Logger logger = LoggerFactory.getLogger(SuggestionController.class);
    @Autowired
    private SuggestionService suggestionService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public ResultData queryAll(Integer page, Integer limit){
        logger.info("----------查询所有留言建议--------------");
        try {
            List<Suggestion> suggestions =  suggestionService.queryAllByLimit((page-1)*limit,limit);
            logger.info("page**********{},limit------------{}",page,limit);
            ResultData resultData = new ResultData();
            resultData.setCode(0);
            resultData.setMsg("");
            resultData.setCount(suggestionService.queryAllcount());
            resultData.setData(suggestions);
            return resultData;
        }catch (Exception e){
            logger.info("查询所有留言建议失败:{}", e.getMessage());
            return null;
        }
    }



    /**
     * 删除分享专栏
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object delete(@RequestBody JSONObject jsonBody){
        logger.info("-------------删除留言建议-------------");
        try {
            Integer id = jsonBody.getInteger("id");
            return Response.success(suggestionService.deleteById(id));
        }catch (Exception e){
            logger.info("删除留言建议失败");
            return Response.error(e.getMessage());
        }

    }



}
