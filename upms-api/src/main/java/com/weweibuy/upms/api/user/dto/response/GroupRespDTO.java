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
    private String groupName;

    /**
     * 组代码
     */
    private String groupCode;

    /**
     * 组描述
     */
    private String groupDesc;

    /**
     * 组类型
     */
    private String groupType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
