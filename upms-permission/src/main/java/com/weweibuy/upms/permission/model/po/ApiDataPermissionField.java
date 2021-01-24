package com.weweibuy.upms.permission.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ApiDataPermissionField {
    /**
     * id
     */
    private Long id;

    /**
     * 数据代码
     */
    private String dataCode;

    /**
     * 数据描述
     */
    private String dataDesc;

    /**
     * 接口代码
     */
    private String apiCode;

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 字段输入类型(前端输入类型)
     */
    private String inputType;

    /**
     * 字段字典类型
     */
    private String fieldDictType;

    /**
     * 是否删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}