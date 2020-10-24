package com.weweibuy.upms.manager;

import com.weweibuy.upms.repository.GroupRepository;
import com.weweibuy.upms.repository.UserGroupRepository;
import com.weweibuy.upms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2020/10/24 21:36
 **/
@Component
@RequiredArgsConstructor
public class UserQueryManager {

    private final UserRepository userRepository;

    private final GroupRepository groupRepository;

    private final UserGroupRepository userGroupRepository;


    

}
