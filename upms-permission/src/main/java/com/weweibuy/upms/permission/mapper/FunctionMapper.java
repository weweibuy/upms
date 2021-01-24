package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.FunctionExample;
import com.weweibuy.upms.permission.model.po.Function;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FunctionMapper {
    long countByExample(FunctionExample example);

    int deleteByExample(FunctionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectOneByExample(FunctionExample example);

    Function selectOneByExampleForUpdate(FunctionExample example);

    List<Function> selectByExampleForUpdate(FunctionExample example);

    List<Function> selectByExample(FunctionExample example);

    Function selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByExample(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}