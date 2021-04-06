package com.lingnan.wedding.client.service;

import com.lingnan.wedding.core.entity.OrderType;
import com.lingnan.wedding.core.entity.ReserveRecord;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-31 22:51
 **/

public interface ReserveOrderService {

    boolean addReserve(ReserveRecord reserveRecord);

    Map<String, List<ReserveRecord>> queryReserve(Integer userId);

    Map<String, List<OrderType>> queryStateName();

    Map<String, Integer> queryByStateName(Integer id);

}
