package com.weweibuy.upms.permission.manager;

import com.weweibuy.upms.permission.model.po.Api;
import com.weweibuy.upms.permission.repository.FunctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 权限信息查询
 *
 * @author durenhao
 * @date 2021/1/24 21:31
 **/
@Component
@RequiredArgsConstructor
public class PermissionInfoQueryManager {


    private final FunctionRepository functionRepository;


    /**
     * 查询已有权限的api
     *
     * @param userName
     * @return
     */
    public Set<Api> queryAuthorizedApi(String userName) {
        return null;
    }


}
