package com.weweibuy.upms.app.model.dto.resp;

import com.weweibuy.framework.common.core.utils.DateTimeUtils;
import com.weweibuy.upms.app.model.po.AppToken;
import lombok.Data;

/**
 * 获取token 响应
 *
 * @author durenhao
 * @date 2021/2/8 21:28
 **/
@Data
public class AppAccessTokenRespDTO {

    private String accessToken;

    /**
     * 失效时间 (毫秒)
     */
    private Long expireAt;

    public static AppAccessTokenRespDTO fromAppToken(AppToken appToken) {
        AppAccessTokenRespDTO tokenRespDTO = new AppAccessTokenRespDTO();
        tokenRespDTO.setAccessToken(appToken.getAccessToken());
        tokenRespDTO.setExpireAt(
                DateTimeUtils.localDateTimeToTimestampMilli(appToken.getAccessTokenExpireAt()));
        return tokenRespDTO;

    }

}
