package com.weweibuy.upms.user.service;

import com.weweibuy.upms.user.model.dto.request.LoginReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2021/5/22 18:11
 **/
@Service
@RequiredArgsConstructor
public class LoginService {

    private final LdapTemplate ldapTemplate;

    public boolean login(LoginReqDTO loginReqDTO) {
        EqualsFilter filter = new EqualsFilter("cn", loginReqDTO.getUsername());
        return ldapTemplate.authenticate("", filter.toString(), loginReqDTO.getPassword());
    }
}
