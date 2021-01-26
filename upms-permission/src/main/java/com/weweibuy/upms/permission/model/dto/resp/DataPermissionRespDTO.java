package com.weweibuy.upms.permission.model.dto.resp;

import lombok.Data;

/**
 * 数据权限响应
 *
 * @author durenhao
 * @date 2021/1/26 21:43
 **/
@Data
public class DataPermissionRespDTO {

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段值
     */
    private Object fieldValue;

}
