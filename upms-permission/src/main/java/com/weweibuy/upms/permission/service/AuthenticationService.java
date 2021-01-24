package com.weweibuy.upms.permission.service;

import com.weweibuy.upms.interfaces.user.IUserService;
import com.weweibuy.upms.interfaces.user.model.IUserGroup;
import com.weweibuy.upms.permission.manager.TokenManager;
import com.weweibuy.upms.permission.model.dto.req.UserAuthorizationReq;
import com.weweibuy.upms.permission.model.vo.TokenUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 鉴权服务
 *
 * @author durenhao
 * @date 2021/1/24 20:59
 **/
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final TokenManager tokenManager;

    private final IUserService userService;

    public void authentication(UserAuthorizationReq userAuthorizationReq) {
        TokenUserInfo tokenUserInfo = tokenManager.tokenToUserInfo(userAuthorizationReq.getAuthorization());
        List<IUserGroup> userGroupList = userService.queryUserGroup(tokenUserInfo.getUsername());
        List<String> groupCodeList = userGroupList.stream()
                .map(IUserGroup::getGroupCode)
                .collect(Collectors.toList());

    }

}
