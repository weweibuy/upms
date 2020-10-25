package com.weweibuy.upms.user.model.vo;

import com.weweibuy.framework.common.core.utils.Jdk9Option;
import com.weweibuy.upms.api.user.dto.request.UserQueryReqDTO;
import com.weweibuy.upms.user.manager.UserGroupManager;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/24 22:52
 **/
@Data
public class UserQueryVO {

    /**
     * 姓名
     */
    private String nameLike;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 邮箱
     */
    private String email;

    private List<String> usernameList;


    public static UserQueryVO fromDto(UserQueryReqDTO queryReqDTO, UserGroupManager userGroupManager) {
        UserQueryVO userQueryVO = new UserQueryVO();
        userQueryVO.setUsername(queryReqDTO.getUsername());
        userQueryVO.setNameLike(queryReqDTO.getName());
        userQueryVO.setEmail(queryReqDTO.getEmail());
        if (ArrayUtils.isNotEmpty(queryReqDTO.getUsernameList())) {
            userQueryVO.setUsernameList(Arrays.asList(queryReqDTO.getUsernameList()));
        }
        List<String> groupKeyList = queryReqDTO.groupKey();
        if (CollectionUtils.isNotEmpty(groupKeyList)) {
            List<String> usernameList = userGroupManager.groupKeyToUsername(groupKeyList);
            Jdk9Option.ofNullable(userQueryVO.getUsernameList())
                    .ifPresentOrElse(list -> list.addAll(usernameList),
                            () -> userQueryVO.setUsernameList(usernameList));
        }
        return userQueryVO;
    }

    public Boolean isAllEmpty() {
        return StringUtils.isAllBlank(nameLike, username, phoneNo, email)
                && CollectionUtils.isEmpty(usernameList);
    }
}
