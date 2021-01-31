package com.weweibuy.upms.app.repository;

import com.weweibuy.upms.app.mapper.AppApiRelationMapper;
import com.weweibuy.upms.app.mapper.AppMapper;
import com.weweibuy.upms.app.model.example.AppApiRelationExample;
import com.weweibuy.upms.app.model.example.AppExample;
import com.weweibuy.upms.app.model.po.App;
import com.weweibuy.upms.app.model.po.AppApiRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2021/1/28 22:03
 **/
@Repository
@RequiredArgsConstructor
public class AppRepository {

    private final AppMapper appMapper;

    private final AppApiRelationMapper appApiRelationMapper;

    public Optional<App> selectApp(String appKey) {
        return Optional.ofNullable(appMapper.selectOneByExample(AppExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andAppKeyEqualTo(appKey)
                .example()));
    }

    public Optional<AppApiRelation> selectAppApi(String appKey, String apiCode) {
        return Optional.ofNullable(appApiRelationMapper.selectOneByExample(AppApiRelationExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andAppKeyEqualTo(appKey)
                .andApiCodeEqualTo(apiCode)
                .example()));
    }


    public List<AppApiRelation> selectAppApi(String appKey) {
        return appApiRelationMapper.selectByExample(AppApiRelationExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andAppKeyEqualTo(appKey)
                .example());
    }


    public int insertApp(App app) {
        return appMapper.insertSelective(app);
    }

}
