/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.social.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import rashjz.info.app.bp.domain.UserRoles;

/**
 *
 * @author rasha_000
 */
public class AuthorizationUtility implements Serializable{

    public Collection<GrantedAuthority> getAuthorities(Set set) {
        //make everyone ROLE_USER
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if (set == null) {
            GrantedAuthority grantedAuthority = new GrantedAuthority() {
                //anonymous inner type
                public String getAuthority() {
                    return "ROLE_USER";
                }
            };
            grantedAuthorities.add(grantedAuthority);
            return grantedAuthorities;
        } else {
            for (Iterator<UserRoles> it = new HashSet<UserRoles>(set).iterator(); it.hasNext();) {
                UserRoles ur = it.next();
                GrantedAuthority grantedAuthority = new GrantedAuthority() {
                    //anonymous inner type
                    public String getAuthority() {
                        return "ROLE_USER";
                    }
                };
                grantedAuthorities.add(grantedAuthority);
            }
            return grantedAuthorities;
        }
    }
}
