package com.weweibuy.upms.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author durenhao
 * @date 2020/10/24 21:18
 **/
@FeignClient(contextId = "userQueryClient")
public interface UserQueryClient {
}
