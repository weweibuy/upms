package com.weweibuy.upms.permission.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.interfaces.api.IApiQueryService;
import com.weweibuy.upms.interfaces.api.model.IApi;
import com.weweibuy.upms.permission.model.po.Api;
import com.weweibuy.upms.permission.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * api 查询
 *
 * @author durenhao
 * @date 2021/1/28 22:11
 **/
@Service
@RequiredArgsConstructor
public class ApiQueryServiceImpl implements IApiQueryService {

    private final ApiRepository apiRepository;

    @Override
    public Optional<IApi> queryApi(String apiCode) {
        return apiRepository.selectApi(apiCode)
                .map(a -> BeanCopyUtils.copy(a, IApi.class));
    }

    @Override
    public Optional<IApi> queryApi(String service, String path, HttpMethod httpMethod) {
        return apiRepository.selectApi(service, path, httpMethod)
                .map(a -> BeanCopyUtils.copy(a, IApi.class));
    }

    @Override
    public List<IApi> queryApi(List<String> apiCodeList) {
        List<Api> apis = apiRepository.selectApi(apiCodeList);
        return BeanCopyUtils.copyCollection(apis, Api.class, IApi.class);
    }
}
