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
     * 字段类型(0:STRING; 1:NUMBER; 2: BOOLEAN; 3: COLLECTION_STRING; 4: COLLECTION_NUMBER)
     */
    private Integer fieldType;

    /**
     * 字段输入类型(前端输入类型, 0: 输入框输入; 1:字典选择)
     */
    private Integer inputType;

    /**
     * 字段字典类型
     */
    private String fieldDictType;

    /**
     * 请求参数类型(0: query; 1: body)
     */
    private Integer reqParamType;

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