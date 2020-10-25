package com.weweibuy.upms.model.dto.request;

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
 * @date 2020/10/25 9:20
 **/
@Data
public class GroupQueryReqDTO {

    private String groupKey;

    private String[] groupKeyList;

    private String name;

    private String nameLike;

    private String userName;

    private String[] usernameList;


    public Boolean isAllEmpty() {
        return StringUtils.isAllBlank(groupKey, name, nameLike, userName)
                || ArrayUtils.isNotEmpty(groupKeyList)
                || ArrayUtils.isEmpty(usernameList);
    }

    public List<String> username() {
        if (ArrayUtils.isNotEmpty(usernameList) || StringUtils.isNotBlank(userName)) {
            return Jdk9Option.ofNullable(usernameList)
                    .map(Arrays::asList)
                    .peek(list ->
                            Optional.ofNullable(userName)
                                    .ifPresent(list::add))
                    .orElse(Collections.singletonList(userName));
        }
        return Collections.emptyList();

    }
}
