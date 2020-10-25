package com.weweibuy.upms.repository;

import com.weweibuy.upms.mapper.GroupMapper;
import com.weweibuy.upms.model.example.GroupExample;
import com.weweibuy.upms.model.po.Group;
import com.weweibuy.upms.model.vo.GroupQueryVO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    public List<Group> selectGroup(List<String> groupKeyList) {
        return groupMapper.selectByExample(GroupExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andGroupKeyIn(groupKeyList)
                .example());
    }

    public List<Group> selectGroup(GroupQueryVO queryVO) {
        return groupMapper.selectByExample(buildExample(queryVO));
    }

    public Long countGroup(GroupQueryVO queryVO) {
        return groupMapper.countByExample(buildExample(queryVO));
    }


    private GroupExample buildExample(GroupQueryVO queryVO) {
        GroupExample.Criteria criteria = GroupExample.newAndCreateCriteria()
                .andDeletedEqualTo(false);
        Optional.ofNullable(queryVO.getGroupKey())
                .ifPresent(criteria::andGroupKeyEqualTo);
        Optional.ofNullable(queryVO.getNameLike())
                .ifPresent(like -> criteria.andNameLike("%" + like + "%"));
        Optional.ofNullable(queryVO.getName())
                .ifPresent(criteria::andNameEqualTo);
        Optional.ofNullable(queryVO.getGroupKeyList())
                .filter(CollectionUtils::isNotEmpty)
                .ifPresent(criteria::andGroupKeyIn);
        return criteria.example();
    }

}
