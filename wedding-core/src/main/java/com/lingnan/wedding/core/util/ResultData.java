package com.lingnan.wedding.core.util;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-15 22:56
 **/

@Data
@ToString
public class ResultData<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    public static ResultData success(Integer count, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(0);
        resultData.setMsg("请求成功");
        resultData.setCount(count);
        resultData.setData((List) data);
        return resultData;
    }

    public static ResultData error(){
        ResultData resultData = new ResultData();
        resultData.setCode(1);
        resultData.setMsg("请求失败");
        resultData.setCount(0);
        resultData.setData(null);
        return resultData;
    }
}
