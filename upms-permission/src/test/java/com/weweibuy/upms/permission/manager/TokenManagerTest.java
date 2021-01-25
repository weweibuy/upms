package com.weweibuy.upms.permission.manager;

import com.weweibuy.upms.permission.model.vo.TokenUserInfo;
import org.junit.Test;

public class TokenManagerTest {

   private TokenManager tokenManager = new TokenManager();



    @Test
    public void generate() throws Exception {
        TokenUserInfo tokenUserInfo = new TokenUserInfo();
        tokenUserInfo.setUsername("tom");
        String generate = tokenManager.generate(tokenUserInfo);
        // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSJ9.hODNJhkQiEVMlBVg5dneVWLhsYwSjy6kIRMLQGy93K8
        System.err.println(generate);
    }


}