package com.weweibuy.upms.api.user.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2020/10/25 9:19
 **/
@Data
public class GroupRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 组名
     */
    private String groupKey;

    /**
     * 组描述
     */
    private String groupDesc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
