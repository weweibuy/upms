package com.weweibuy.upms.app.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.app.model.dto.resp.AppRespDTO;
import com.weweibuy.upms.app.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2021/1/31 13:28
 **/
@Service
@RequiredArgsConstructor
public class AppQueryService {

    private final AppRepository appRepository;

    public AppRespDTO queryByAppId(String appId) {
        return appRepository.selectApp(appId)
                .map(a -> BeanCopyUtils.copy(a, AppRespDTO.class))
                .orElse(null);
    }
}
