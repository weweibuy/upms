package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.ApiExample;
import com.weweibuy.upms.permission.model.po.Api;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiMapper {
    long countByExample(ApiExample example);

    int deleteByExample(ApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Api record);

    int insertSelective(Api record);

    Api selectOneByExample(ApiExample example);

    Api selectOneByExampleForUpdate(ApiExample example);

    List<Api> selectByExampleForUpdate(ApiExample example);

    List<Api> selectByExample(ApiExample example);

    Api selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByExample(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByPrimaryKeySelective(Api record);

    int updateByPrimaryKey(Api record);
}