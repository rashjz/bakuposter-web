package rashjz.info.app.bp.dto;
 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Logger;

public class SecurityUtil {

    private static final Logger LOGGER = Logger.getLogger(SecurityUtil.class.getName());

    public static void authenticateUser(LocalUser userDetails) {
        LOGGER.info("Logging in principal: {}" + userDetails);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
//        userDetails = (LocalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        LOGGER.info("User: {} has been logged in.", userDetails.getUsers().getNote());
    }

    public static SocialMediaService toSocialProvider(String providerId) {
        for (SocialMediaService socialProvider : SocialMediaService.values()) {
            if (socialProvider.getProviderType().equals(providerId)) {
                return socialProvider;
            }
        }
        return SocialMediaService.NONE;
    }
}
