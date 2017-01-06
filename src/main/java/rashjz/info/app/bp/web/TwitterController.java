package rashjz.info.app.bp.web;

import java.io.Serializable;
import java.util.HashSet;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import rashjz.info.app.bp.domain.UserRoles;
import rashjz.info.app.bp.domain.Users;
import rashjz.info.app.bp.dto.LocalUser;
import rashjz.info.app.bp.dto.SecurityUtil;
import rashjz.info.app.bp.service.UserService;
import rashjz.info.app.bp.social.util.AuthorizationUtility;

@RequestMapping(value = "/twitter")
@Controller
public class TwitterController<TwitterApi> implements Serializable {

    private static final Logger LOG = Logger.getLogger(TwitterController.class.getName());

    private static final String PUBLISH_SUCCESS = "success";

    private static final String TWITTER = "twitter";
    @Autowired
    private UserService userService;
    
    @Autowired
    private ConnectionFactoryRegistry connectionFactoryRegistry;

    @Autowired
    private OAuth1Parameters oAuth1Parameters;
//
    @Value("${twitter.api.callback}")
    private String callback;
//    @Value("spring.social.twitter.key")
//    private String twitterAppId;
//    @Value("spring.social.twitter.secret")
//    private String twitterAppSecret;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        TwitterConnectionFactory twitterConnectionFactory = (TwitterConnectionFactory) connectionFactoryRegistry.getConnectionFactory(TWITTER);
        OAuth1Operations oauthOperations = twitterConnectionFactory.getOAuthOperations();

        OAuthToken oAuthToken = oauthOperations.fetchRequestToken(callback, oAuth1Parameters);
        String authorizeUrl = oauthOperations.buildAuthenticateUrl(oAuthToken.getValue(), oAuth1Parameters);
        RedirectView redirectView = new RedirectView(authorizeUrl, true, true, true);

        return new ModelAndView(redirectView);
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
//    @ResponseBody
    public String springSocialCallback(
            @RequestParam("oauth_token") String oauthToken,
            @RequestParam("oauth_verifier") String oauthVerifier,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LOG.info(": : : " + oauthToken + " -- " + oauthVerifier);
        Twitter twitterTemplate = new TwitterTemplate("EkR44UcvGNzzAgOd9oOEwAurk", "9eN2TrLBukEh5Yd9zRWHjleFErHs3UENXvHHZ4nL3oWpODdLpq", "1090072945-5yhTfmw2hrSxmYGHphZXJ7UsOagttiD744VhOZP", "dNjGEbDbaaWN5w5O0NDTQuNb6adXrsyV44EYqfRn4X3BM");

        TwitterProfile twitterProfile = twitterTemplate.userOperations().getUserProfile();
        LOG.info(twitterProfile.getId() + "getScreenName : " + twitterProfile.getScreenName() + " getProfileImageUrl- " + twitterProfile.getProfileImageUrl() + " getProfileUrl- " + twitterProfile.getProfileUrl() + " getName -  " + twitterProfile.getName() + " getDescription -  " + twitterProfile.getDescription());
        //getting email from twitter
//        RestOperations restTemplate = twitterTemplate.restOperations();
//        String response1 = restTemplate.getForObject("https://api.twitter.com/1.1/account/verify_credentials.json?include_email=true", String.class);
//        System.out.println("Profile Info with Email: " + response1);

        Users user = new Users();
        user.setNote(twitterProfile.getProfileImageUrl());
        user.setFirstname(twitterProfile.getName());
        user.setPassword(twitterProfile.getId() + "");
        user.setUsername(twitterProfile.getProfileUrl() + "");

//        TimelineOperations timelineOperations = twitterTemplate.timelineOperations();
//        timelineOperations.updateStatus("Hello Twitter!");
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
}
