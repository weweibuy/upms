package com.weweibuy.upms.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.manager.UserGroupManager;
import com.weweibuy.upms.model.dto.request.UserQueryReqDTO;
import com.weweibuy.upms.model.dto.response.UserRespDTO;
import com.weweibuy.upms.model.vo.UserQueryVO;
import com.weweibuy.upms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/10/24 22:07
 **/
@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    private final UserGroupManager userGroupManager;

    public UserRespDTO queryUser(String username) {
        return userRepository.selectUser(username)
                .map(user -> BeanCopyUtils.copy(user, UserRespDTO.class))
                .orElse(null);
    }

    public List<UserRespDTO> queryUser(UserQueryReqDTO queryReqDTO) {
        return userRepository.selectUser(UserQueryVO.fromDto(queryReqDTO, userGroupManager)).stream()
                .map(user -> BeanCopyUtils.copy(user, UserRespDTO.class))
                .collect(Collectors.toList());
    }

    public Long countUser(UserQueryReqDTO queryReqDTO) {
        return userRepository.countUser(UserQueryVO.fromDto(queryReqDTO, userGroupManager));
    }


}
