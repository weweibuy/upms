package com.weweibuy.upms.user.service;

import com.weweibuy.upms.user.model.dto.request.LoginReqDTO;
import com.weweibuy.upms.user.model.ldap.LdapUser;
import com.weweibuy.upms.user.support.LdapUserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author durenhao
 * @date 2021/5/22 18:11
 **/
@Service
@RequiredArgsConstructor
public class LoginService {

    private LdapShaPasswordEncoder ldapShaPasswordEncoder = new LdapShaPasswordEncoder();

    private LdapUserAttributesMapper ldapUserAttributesMapper = new LdapUserAttributesMapper();

    private final LdapTemplate ldapTemplate;


    public boolean login(LoginReqDTO loginReqDTO) {
        String username = loginReqDTO.getUsername();
        String password = loginReqDTO.getPassword();
        EqualsFilter filter = new EqualsFilter("uid", username);
        List<LdapUser> search = ldapTemplate.search("",
                filter.toString(),
                ldapUserAttributesMapper);
        if (CollectionUtils.isNotEmpty(search) && matchPassword(password, search.get(0).getPassword())) {
            return true;
        }
        return false;
    }


    private boolean matchPassword(String ori, String encodePwd) {
        return ldapShaPasswordEncoder.matches(ori, encodePwd);
    }
}
