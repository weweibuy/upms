package com.weweibuy.upms.user.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.api.user.dto.request.GroupQueryReqDTO;
import com.weweibuy.upms.api.user.dto.response.GroupRespDTO;
import com.weweibuy.upms.user.manager.UserGroupManager;
import com.weweibuy.upms.user.model.po.Group;
import com.weweibuy.upms.user.model.vo.GroupQueryVO;
import com.weweibuy.upms.user.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/10/25 9:18
 **/
@Service
@RequiredArgsConstructor
public class GroupQueryService {

    private final GroupRepository groupRepository;

    private final UserGroupManager userGroupManager;


    public GroupRespDTO queryGroup(String groupKey) {
        return groupRepository.selectGroup(groupKey)
                .map(group -> BeanCopyUtils.copy(group, GroupRespDTO.class))
                .orElse(null);
    }


    public List<GroupRespDTO> queryGroup(GroupQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(GroupQueryVO.fromDto(queryReqDTO, userGroupManager))
                .filter(vo -> !vo.isAllEmpty())
                .map(groupRepository::selectGroup)
                .map(group -> BeanCopyUtils.copyCollection(group, Group.class, GroupRespDTO.class))
                .orElse(Collections.emptyList());
    }

    public Long countGroup(GroupQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(GroupQueryVO.fromDto(queryReqDTO, userGroupManager))
                .filter(vo -> !vo.isAllEmpty())
                .map(groupRepository::countGroup)
                .orElse(0L);
    }

}
