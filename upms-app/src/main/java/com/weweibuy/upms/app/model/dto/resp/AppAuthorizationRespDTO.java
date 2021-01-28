package com.weweibuy.upms.app.model.dto.resp;

import com.weweibuy.upms.app.model.dto.req.AppAuthorizationReqDTO;
import com.weweibuy.upms.app.model.po.App;
import lombok.Data;

/**
 * App 鉴权请求
 *
 * @author durenhao
 * @date 2020/2/24 21:24
 **/
@Data
public class AppAuthorizationRespDTO {

    private String appId;

    private String appName;

    // TODO 脱敏
    private String appKey;

    private String appSecret;

    /**
     * 请求服务
     */
    private String service;

    public static AppAuthorizationRespDTO appAuthorizationRespDTO(AppAuthorizationReqDTO reqDTO, App app) {
        AppAuthorizationRespDTO respDTO = new AppAuthorizationRespDTO();
        respDTO.setService(reqDTO.getService());
        respDTO.setAppId(app.getAppId());
        respDTO.setAppKey(app.getAppKey());
        respDTO.setAppSecret(app.getAppSecret());
        respDTO.setAppName(app.getAppName());
        return respDTO;

    }

}
