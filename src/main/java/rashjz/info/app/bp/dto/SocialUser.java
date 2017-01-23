package rashjz.info.app.bp.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SocialUser extends org.springframework.social.security.SocialUser {

    private String userId;

    public SocialUser(final String userId, final String username, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
