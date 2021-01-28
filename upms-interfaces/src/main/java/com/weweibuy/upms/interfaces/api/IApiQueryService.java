package com.weweibuy.upms.interfaces.api;

import com.weweibuy.upms.interfaces.api.model.IApi;
import org.springframework.http.HttpMethod;

import java.util.List;
import java.util.Optional;

/**
 * api 查询接口
 *
 * @author durenhao
 * @date 2021/1/28 22:08
 **/
public interface IApiQueryService {


    /**
     * 查询 api
     *
     * @param apiCode
     * @return
     */
    Optional<IApi> queryApi(String apiCode);

    /**
     * 查询 api
     *
     * @param service
     * @param path
     * @param httpMethod
     * @return
     */
    Optional<IApi> queryApi(String service, String path, HttpMethod httpMethod);


    /**
     * 查询 api
     *
     * @param apiCodeList
     * @return
     */
    List<IApi> queryApi(List<String> apiCodeList);

}
