package com.weweibuy.upms.repository;

import com.weweibuy.upms.mapper.GroupMapper;
import com.weweibuy.upms.model.example.GroupExample;
import com.weweibuy.upms.model.po.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/10/24 21:34
 **/
@Repository
@RequiredArgsConstructor
public class GroupRepository {

    private final GroupMapper groupMapper;

    public Optional<Group> selectGroup(String groupKey) {
        return Optional.ofNullable(groupMapper.selectOneByExample(GroupExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andGroupKeyEqualTo(groupKey)
                .example()));
    }

}
