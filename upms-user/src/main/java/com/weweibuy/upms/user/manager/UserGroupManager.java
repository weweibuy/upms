package com.weweibuy.upms.user.manager;

import com.weweibuy.upms.user.model.po.UserGroup;
import com.weweibuy.upms.user.repository.UserGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/10/25 9:27
 **/
@Component
@RequiredArgsConstructor
public class UserGroupManager {

    private final UserGroupRepository userGroupRepository;


    public List<String> groupKeyToUsername(List<String> groupKeyList) {
        return userGroupRepository.selectByGroupKey(groupKeyList).stream()
                .map(UserGroup::getUserName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> usernameToGroupKey(List<String> usernameList) {
        return userGroupRepository.selectByUserName(usernameList).stream()
                .map(UserGroup::getGroupKey)
                .distinct()
                .collect(Collectors.toList());
    }

}
