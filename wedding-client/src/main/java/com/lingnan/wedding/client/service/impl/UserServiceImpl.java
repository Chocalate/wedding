package com.lingnan.wedding.client.service.impl;

import com.lingnan.wedding.client.service.UserService;
import com.lingnan.wedding.core.entity.ClientUser;
import com.lingnan.wedding.core.entity.GoodsInfo;
import com.lingnan.wedding.core.util.DateUtil;
import com.lingnan.wedding.mapper.ClientUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-29 16:03
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private ClientUserDao clientUserDao;

    @Override
    public Map<String, List<ClientUser>> login(ClientUser clientUser) {
        Map<String, List<ClientUser>> map = new LinkedHashMap<>();
        List<ClientUser> clientUsers = clientUserDao.queryAll(clientUser);
        if(clientUsers!=null){
            map.put("user",clientUsers);
        }
        return map;
    }

    @Override
    public int insert(ClientUser user) {
        user.setStatus(1);
        user.setCreateTime(DateUtil.stringDate(new Date()));
        return clientUserDao.insert(user);
    }

    @Override
    public ClientUser queryByName(String account) {
        return clientUserDao.queryByName(account);
    }


}
