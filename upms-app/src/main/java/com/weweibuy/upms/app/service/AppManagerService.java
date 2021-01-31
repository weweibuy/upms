package com.weweibuy.upms.app.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.app.model.dto.req.AppGenerateReqDTO;
import com.weweibuy.upms.app.model.dto.resp.AppRespDTO;
import com.weweibuy.upms.app.model.po.App;
import com.weweibuy.upms.app.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/1/31 17:03
 **/
@Service
@RequiredArgsConstructor
public class AppManagerService {

    private final AppRepository appRepository;

    public AppRespDTO generateApp(AppGenerateReqDTO generateReqDTO) {
        App app = generateReqDTO.toApp();
        appRepository.insertApp(app);
        AppRespDTO dto = BeanCopyUtils.copy(app, AppRespDTO.class);
        dto.setCreateTime(LocalDateTime.now());
        dto.setUpdateTime(LocalDateTime.now());
        return dto;
    }

}
