package com.lingnan.wedding.client.service.impl;

import com.lingnan.wedding.client.service.ReserveOrderService;
import com.lingnan.wedding.client.util.OrderIdUtil;
import com.lingnan.wedding.client.vo.CardInfoVo;
import com.lingnan.wedding.core.entity.OrderType;
import com.lingnan.wedding.core.entity.ReserveRecord;
import com.lingnan.wedding.core.entity.UserAddress;
import com.lingnan.wedding.core.util.DateUtil;
import com.lingnan.wedding.mapper.OrderTypeDao;
import com.lingnan.wedding.mapper.ReserveRecordDao;
import com.lingnan.wedding.mapper.UserAddressDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-31 22:53
 **/
@Service("reserveOrderService")
public class ReserveOrderServiceImpl implements ReserveOrderService {

    @Resource
    private ReserveRecordDao reserveRecordDao;

    @Resource
    private UserAddressDao userAddressDao;

    @Resource
    private OrderTypeDao orderTypeDao;

    @Override
    public boolean addReserve(ReserveRecord reserveRecord) {


        //插入预约记录
        reserveRecord.setOrderId(OrderIdUtil.getBillCode());
        reserveRecord.setCreateTime(DateUtil.stringDate(new Date()));
        reserveRecord.setFlag(0);
        reserveRecord.setProgressId(1);
        boolean b = reserveRecordDao.insert(reserveRecord);

         if(b) {
             //插入用户地址表
             UserAddress userAddress = new UserAddress();
             String[] address = reserveRecord.getAddress().split("&");
             userAddress.setUid(reserveRecord.getClientId());
             userAddress.setRealName(reserveRecord.getGetPersonName());
             userAddress.setPhone(reserveRecord.getPhone());
             userAddress.setProCity(address[0]);
             userAddress.setDetail(address[1]);
             List<UserAddress> userAddresses = userAddressDao.queryAll(userAddress);
             if (userAddresses == null) {
                 userAddress.setIsDel(0);
                 userAddress.setIsDefault(0);
                 userAddressDao.insert(userAddress);
             }
         }
        return b;
    }

    @Override
    public Map<String, List<ReserveRecord>> queryReserve(Integer userId) {
        Map<String, List<ReserveRecord>> map = new LinkedHashMap<>();
        List<ReserveRecord> reserveRecords = reserveRecordDao.queryReserve(userId);
        map.put("reserveOrderList",reserveRecords);
        return map;
    }

    @Override
    public Map<String, List<OrderType>> queryStateName() {
        Map<String, List<OrderType>> map = new LinkedHashMap<>();
        List<OrderType> orderTypes = orderTypeDao.queryAll();
        map.put("steps",orderTypes);
        return map;
    }

    @Override
    public Map<String, Integer> queryByStateName(Integer id) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Integer ids = reserveRecordDao.queryByStateName(id);
        map.put("active",ids);
        return map;
    }
}
