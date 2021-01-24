package com.weweibuy.upms.permission.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Api {
    /**
     * id
     */
    private Long id;

    /**
     * 接口代码
     */
    private String apiCode;

    /**
     * 接口描述
     */
    private String apiDesc;

    /**
     * 接口服务
     */
    private String apiService;

    /**
     * 接口地址
     */
    private String apiAddress;

    /**
     * 请求方法
     */
    private String apiMethod;

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