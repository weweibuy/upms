package com.weweibuy.upms.user.model.vo;

import com.weweibuy.framework.common.core.utils.Jdk9Option;
import com.weweibuy.upms.api.user.dto.request.GroupQueryReqDTO;
import com.weweibuy.upms.user.manager.UserGroupManager;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/25 9:38
 **/
@Data
public class GroupQueryVO {

    private String groupKey;

    private List<String> groupKeyList;

    private String name;

    private String nameLike;


    public static GroupQueryVO fromDto(GroupQueryReqDTO queryReqDTO, UserGroupManager userGroupManager) {
        GroupQueryVO groupQueryVO = new GroupQueryVO();
        groupQueryVO.setGroupKey(queryReqDTO.getGroupKey());
        groupQueryVO.setName(queryReqDTO.getName());
        groupQueryVO.setNameLike(queryReqDTO.getNameLike());

        if (ArrayUtils.isNotEmpty(queryReqDTO.getGroupKeyList())) {
            groupQueryVO.setGroupKeyList(Arrays.asList(queryReqDTO.getGroupKeyList()));
        }

        List<String> usernameList = queryReqDTO.username();
        if (CollectionUtils.isNotEmpty(usernameList)) {
            List<String> groupKeyList = userGroupManager.usernameToGroupKey(usernameList);
            Jdk9Option.ofNullable(groupQueryVO.getGroupKeyList())
                    .ifPresentOrElse(list -> list.addAll(groupKeyList),
                            () -> groupQueryVO.setGroupKeyList(groupKeyList));
        }

        return groupQueryVO;
    }

    public Boolean isAllEmpty() {
        return StringUtils.isAllBlank(nameLike, groupKey, name)
                && CollectionUtils.isEmpty(groupKeyList);
    }

}
