package rashjz.info.app.bp.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import rashjz.info.app.bp.domain.UserRoles;
import rashjz.info.app.bp.domain.Users;
import rashjz.info.app.bp.dto.LocalUser;
import rashjz.info.app.bp.secure.UserLoginSuccessHandler;
//import rashjz.info.app.bp.util.FacebookUtil;
import rashjz.info.app.bp.social.util.OAuthServiceProvider;
import rashjz.info.app.bp.dto.SecurityUtil;
import rashjz.info.app.bp.service.UserService;
import rashjz.info.app.bp.social.util.AuthorizationUtility;

@RequestMapping(value = "/facebook")
@Component
public class FacebookController<FacebookApi> implements Serializable {

    private static final Logger LOG = Logger.getLogger(FacebookController.class.getName());
    private static final String FACEBOOK = "facebook";
    private static final String PUBLISH_SUCCESS = "success";
    private static final String PUBLISH_ERROR = "error";

    @Autowired
    private ConnectionFactoryRegistry connectionFactoryRegistry;

    @Autowired
    private OAuth2Parameters oAuth2Parameters;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("facebookServiceProvider")
    private OAuthServiceProvider<FacebookApi> facebookServiceProvider;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        FacebookConnectionFactory facebookConnectionFactory = (FacebookConnectionFactory) connectionFactoryRegistry.getConnectionFactory(FACEBOOK);
        OAuth2Operations oauthOperations = facebookConnectionFactory.getOAuthOperations();
        oAuth2Parameters.setState("recivedfromfacebooktoken");
        String authorizeUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
        RedirectView redirectView = new RedirectView(authorizeUrl, true, true, true);

        return new ModelAndView(redirectView);
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
//    @ResponseBody//String type was changed to
    public String postOnWall(@RequestParam("code") String code,
            @RequestParam("state") String state, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        OAuthService oAuthService = facebookServiceProvider.getService();

        Verifier verifier = new Verifier(code);
        Token accessToken = oAuthService.getAccessToken(Token.empty(), verifier);

        FacebookTemplate template = new FacebookTemplate(accessToken.getToken());

        User facebookProfile = template.userOperations().getUserProfile();

        String imgURL = "http://graph.facebook.com/" + facebookProfile.getId() + "/picture?type=square";
        LOG.info("Logged in user " + facebookProfile.getFirstName() + " " + facebookProfile.getLastName() + " " + imgURL);
        //create new object
        Users user = new Users();
        user.setFirstname(facebookProfile.getFirstName());
        user.setLastname(facebookProfile.getLastName());
        user.setNote(imgURL);
        user.setPassword(facebookProfile.getId());
        user.setUsername(facebookProfile.getEmail());
        user.setEnabled((byte) 1);

        UserRoles roles = new UserRoles();
        roles.setRole("ROLE_USER");
        roles.setUsers(user);

        final HashSet<UserRoles> userRoleses = new HashSet<UserRoles>();
        userRoleses.add(roles);
        user.setUserRoleses(userRoleses);

        //log new object
        Users checkusers = userService.getbyUserName(user.getUsername());

        if (checkusers == null) {
            userService.addUser(user);
        } else {
            LOG.info("== checkusers == " + checkusers.toString());
            userService.updateUser(user);
        }
        LocalUser lu = new LocalUser(user, user.getUsername(), user.getPassword(), true, true, true, true, new AuthorizationUtility().getAuthorities(user.getUserRoleses()));
        SecurityUtil.authenticateUser(lu);
        return "redirect:/main";
    }

    @RequestMapping(value = "/callback", params = "error_reason", method = RequestMethod.GET)
    @ResponseBody
    public void error(@RequestParam("error_reason") String errorReason,
            @RequestParam("error") String error,
            @RequestParam("error_description") String description,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            LOG.info("Error occurred while validating user, reason is : {} " + errorReason);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
