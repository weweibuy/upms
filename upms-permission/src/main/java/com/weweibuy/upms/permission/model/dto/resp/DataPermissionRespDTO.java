package com.weweibuy.upms.permission.model.dto.resp;

import com.weweibuy.upms.permission.model.po.ApiDataPermission;
import com.weweibuy.upms.permission.model.po.ApiDataPermissionField;
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
    private String fieldValue;

    /**
     * 请求参数类型 0: query; 1: body
     */
    private Integer reqParamType;

    /**
     * 字段类型
     */
    private Integer fieldType;

    public static DataPermissionRespDTO fromDataPermission(ApiDataPermission dataPermission,
                                                           ApiDataPermissionField dataPermissionField) {
        DataPermissionRespDTO respDTO = new DataPermissionRespDTO();
        respDTO.setFieldName(dataPermissionField.getFieldName());
        respDTO.setFieldValue(dataPermission.getDataValue());
        respDTO.setReqParamType(dataPermissionField.getReqParamType());
        respDTO.setFieldType(dataPermissionField.getFieldType());
        return respDTO;
    }

}
