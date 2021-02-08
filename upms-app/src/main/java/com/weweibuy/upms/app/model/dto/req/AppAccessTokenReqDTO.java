package com.weweibuy.upms.app.model.dto.req;

import com.weweibuy.framework.common.codec.aes.AESUtils;
import com.weweibuy.upms.app.model.po.App;
import lombok.Data;

/**
 * 获取 token请求
 *
 * @author durenhao
 * @date 2021/2/6 11:25
 **/
@Data
public class AppAccessTokenReqDTO {

    private String appId;

    private String appSecret;


    public boolean validateAppSecret(App app) {
        String decryptSecret = null;
        try {
            decryptSecret = AESUtils.decryptHex(appSecret, app.getEncryptKey());
        } catch (Exception e) {
            return false;
        }
        return decryptSecret.equals(app.getAppSecret());

    }

}
