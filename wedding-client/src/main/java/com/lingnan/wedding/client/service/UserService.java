package com.lingnan.wedding.client.service;

import com.lingnan.wedding.core.entity.ClientUser;
import com.lingnan.wedding.core.entity.GoodsInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-29 16:03
 **/

public interface UserService {

    Map<String, List<ClientUser>> login(ClientUser clientUser);

    int insert(ClientUser user);

    ClientUser queryByName(String name);

}
