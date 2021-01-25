package com.weweibuy.upms.permission.model.eum;

import lombok.Getter;

/**
 * 用户表示类型
 *
 * @author durenhao
 * @date 2021/1/24 22:02
 **/
@Getter
public enum UserSymbolTypeEum {

    /**
     * 用户
     */
    USER(0),

    /**
     * 用户组
     */
    GROUP(1),
    ;

    private Integer code;

    UserSymbolTypeEum(Integer code) {
        this.code = code;
    }
}
