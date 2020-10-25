package com.weweibuy.upms.api.user.dto.request;

import com.weweibuy.framework.common.core.utils.Jdk9Option;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/10/24 22:00
 **/
@Data
public class UserQueryReqDTO {

    private String username;

    private String[] usernameList;

    private String name;

    private String email;

    private String groupKey;

    private String[] groupKeyList;

    public Boolean isAllEmpty() {
        return StringUtils.isAllBlank(username, name, email, groupKey)
                && ArrayUtils.isEmpty(usernameList)
                && ArrayUtils.isEmpty(groupKeyList);
    }

    public List<String> groupKey() {
        if (ArrayUtils.isNotEmpty(groupKeyList) || StringUtils.isNotBlank(groupKey)) {
            return Jdk9Option.ofNullable(groupKeyList)
                    .map(Arrays::asList)
                    .peek(list ->
                            Optional.ofNullable(groupKey)
                                    .ifPresent(list::add))
                    .orElse(Collections.singletonList(groupKey));
        }
        return Collections.emptyList();
    }

}
