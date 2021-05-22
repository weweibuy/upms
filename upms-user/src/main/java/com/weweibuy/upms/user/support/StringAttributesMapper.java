package com.weweibuy.upms.user.support;

import com.weweibuy.upms.user.model.ldap.LdapUser;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

/**
 * @author durenhao
 * @date 2021/5/22 22:01
 **/
public class StringAttributesMapper implements AttributesMapper<LdapUser> {

    @Override
    public LdapUser mapFromAttributes(Attributes attributes) throws NamingException {
        byte[] password = (byte[]) attributes.get("userpassword").get();
        LdapUser ldapUser = new LdapUser();
        ldapUser.setSurname((String) attributes.get("sn").get());
        ldapUser.setUsername((String) attributes.get("uid").get());
        ldapUser.setCommonName((String) attributes.get("cn").get());
        ldapUser.setPassword(new String(password));
        return ldapUser;
    }
}
