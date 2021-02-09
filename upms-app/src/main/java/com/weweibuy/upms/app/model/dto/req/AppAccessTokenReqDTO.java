package com.weweibuy.upms.app.model.dto.req;

import com.weweibuy.framework.common.codec.aes.AESUtils;
import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
import com.weweibuy.framework.common.core.utils.DateTimeUtils;
import com.weweibuy.upms.app.config.AppAuthenticationProperties;
import com.weweibuy.upms.app.model.po.App;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 获取 token请求
 *
 * @author durenhao
 * @date 2021/2/6 11:25
 **/
@Data
public class AppAccessTokenReqDTO {

    @NotBlank(message = "appId不能为空")
    private String appId;

    @NotBlank(message = "appSecret不能为空")
    private String appSecret;


    public void validateAppSecret(App app, AppAuthenticationProperties properties) {
        String decryptSecret = null;
        try {
            decryptSecret = AESUtils.decryptHex(app.getEncryptKey(), appSecret);
        } catch (Exception e) {
            throw Exceptions.responseStatusException(HttpStatus.UNAUTHORIZED, CommonErrorCodeEum.UNAUTHORIZED, e);
        }
        int i = decryptSecret.indexOf(":");
        if (i == 0 || i == decryptSecret.length()) {
            throw Exceptions.responseStatusException(HttpStatus.UNAUTHORIZED, CommonErrorCodeEum.UNAUTHORIZED);
        }
        String timestamp = decryptSecret.substring(0, i);

        String appSecret = decryptSecret.substring(i + 1, decryptSecret.length());
        if (!StringUtils.isNumeric(timestamp)) {
            throw Exceptions.responseStatusException(HttpStatus.UNAUTHORIZED, CommonErrorCodeEum.UNAUTHORIZED);
        }
        Long timestampL = Long.valueOf(timestamp);
        LocalDateTime localDateTime = DateTimeUtils.timestampMilliToLocalDateTime(timestampL);
        boolean overInterval = DateTimeUtils.isOverInterval(LocalDateTime.now(),
                localDateTime, properties.getApplyTokenTimeIntervalMills());
        if (overInterval) {
            throw Exceptions.responseStatusException(HttpStatus.UNAUTHORIZED, CommonErrorCodeEum.UNAUTHORIZED);
        }

        if (!app.getAppSecret().equals(appSecret)) {
            throw Exceptions.responseStatusException(HttpStatus.UNAUTHORIZED, CommonErrorCodeEum.UNAUTHORIZED);
        }

    }

}
