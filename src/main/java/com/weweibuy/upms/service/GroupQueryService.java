package com.weweibuy.upms.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.manager.UserGroupManager;
import com.weweibuy.upms.model.dto.request.GroupQueryReqDTO;
import com.weweibuy.upms.model.dto.response.GroupRespDTO;
import com.weweibuy.upms.model.vo.GroupQueryVO;
import com.weweibuy.upms.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return groupRepository.selectGroup(GroupQueryVO.fromDto(queryReqDTO, userGroupManager)).stream()
                .map(group -> BeanCopyUtils.copy(group, GroupRespDTO.class))
                .collect(Collectors.toList());
    }

    public Long countGroup(GroupQueryReqDTO queryReqDTO) {
        return groupRepository.countGroup(GroupQueryVO.fromDto(queryReqDTO, userGroupManager));
    }

}
