package com.weweibuy.upms.interfaces.api.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/1/28 22:08
 **/
@Data
public class IApi {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
