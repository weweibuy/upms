package com.weweibuy.upms.user.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.api.user.dto.request.UserQueryReqDTO;
import com.weweibuy.upms.api.user.dto.response.UserRespDTO;
import com.weweibuy.upms.interfaces.user.IUserService;
import com.weweibuy.upms.interfaces.user.model.IUserGroup;
import com.weweibuy.upms.user.manager.UserGroupManager;
import com.weweibuy.upms.user.model.po.User;
import com.weweibuy.upms.user.model.po.UserGroup;
import com.weweibuy.upms.user.model.vo.UserQueryVO;
import com.weweibuy.upms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/10/24 22:07
 **/
@Service
@RequiredArgsConstructor
public class UserQueryService implements IUserService {

    private final UserRepository userRepository;

    private final UserGroupManager userGroupManager;

    public UserRespDTO queryUser(String username) {
        return userRepository.selectUser(username)
                .map(user -> BeanCopyUtils.copy(user, UserRespDTO.class))
                .orElse(null);
    }

    public List<UserRespDTO> queryUser(UserQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(UserQueryVO.fromDto(queryReqDTO, userGroupManager))
                .filter(vo -> !vo.isAllEmpty())
                .map(userRepository::selectUser)
                .map(list -> BeanCopyUtils.copyCollection(list, User.class, UserRespDTO.class))
                .orElse(Collections.emptyList());
    }

    public Long countUser(UserQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(UserQueryVO.fromDto(queryReqDTO, userGroupManager))
                .filter(vo -> !vo.isAllEmpty())
                .map(userRepository::countUser)
                .orElse(0L);
    }


    @Override
    public List<IUserGroup> queryUserGroup(String username) {
        List<UserGroup> userGroupList = userGroupManager.queryByUserName(username);
        return BeanCopyUtils.copyCollection(userGroupList, UserGroup.class, IUserGroup.class);
    }
}
