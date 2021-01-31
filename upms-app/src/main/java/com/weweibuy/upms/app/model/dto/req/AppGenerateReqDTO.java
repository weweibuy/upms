package com.weweibuy.upms.app.model.dto.req;

import com.weweibuy.framework.common.codec.PasswordGenerateUtils;
import com.weweibuy.framework.common.core.utils.IdWorker;
import com.weweibuy.upms.app.model.po.App;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import javax.validation.constraints.NotBlank;

/**
 * @author durenhao
 * @date 2021/1/31 17:11
 **/
@Data
public class AppGenerateReqDTO {

    @NotBlank
    private String appId;

    @NotBlank
    private String appName;


    public App toApp() {
        App app = new App();
        app.setAppId(appId);
        app.setAppName(appName);
        String hex = DigestUtils.md5Hex(IdWorker.nextStringId());
        app.setAppKey(hex);
        String generate = PasswordGenerateUtils.generate(32);
        app.setAppSecret(generate);
        return app;
    }
}
