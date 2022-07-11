package com.weweibuy.upms.api.user;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.api.user.dto.request.GroupQueryReqDTO;
import com.weweibuy.upms.api.user.dto.response.GroupRespDTO;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/24 21:18
 **/
public interface GroupQueryApi {

    @GetMapping("/group/query")
    CommonDataResponse<GroupRespDTO> queryGroup(@RequestParam("groupKey") String groupKey);

    @GetMapping("/group/query/list")
    CommonDataResponse<List<GroupRespDTO>> queryGroup(@SpringQueryMap GroupQueryReqDTO queryReqDTO);

    @GetMapping("/group/query/count")
    CommonDataResponse<Long> countGroup(@SpringQueryMap GroupQueryReqDTO queryReqDTO);
}
