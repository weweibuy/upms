package com.weweibuy.upms.interfaces.user;

import com.weweibuy.upms.interfaces.user.model.IUserGroup;

import java.util.List;

/**
 * 用户相关接口
 *
 * @author durenhao
 * @date 2021/1/24 21:54
 **/
public interface IUserService {

    /**
     * 用户名 查询组关关联信息
     *
     * @param username
     * @return
     */
    List<IUserGroup> queryUserGroup(String username);

}
