/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.secure;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Repository;
import rashjz.info.app.bp.dao.UserDao;
import rashjz.info.app.bp.dao.UserDaoImpl;
import rashjz.info.app.bp.domain.Users;
import rashjz.info.app.bp.dto.LocalUser;
import rashjz.info.app.bp.dto.SecurityUtil;
import rashjz.info.app.bp.service.UserService;
import rashjz.info.app.bp.social.util.AuthorizationUtility;

//@Repository
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger LOG = Logger.getLogger(UserLoginSuccessHandler.class.getName());

//    @Autowired
//    UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //do some logic here if you want something to be done whenever
        //the user successfully logs in.
        UserDao dao = new UserDaoImpl();

        HttpSession session = httpServletRequest.getSession();
        UserDetails authUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Users users = dao.getbyUserName(authUser.getUsername());
        if (users.getNote()==null) {
            users.setNote("http://www.brentfordfc.co.uk/images/common/bg_player_profile_default_big.png");
        }
        LocalUser localUser = new LocalUser(users, users.getUsername(), users.getPassword(), true, true, true, true, new AuthorizationUtility().getAuthorities(null));
        SecurityUtil.authenticateUser(localUser);

        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());
//        LOG.info("*** username  " + authUser.getUsername() + " authorities  " + authUser.getAuthorities());
        //set our response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        //since we have created our custom success handler, its up to us to where
        //we will redirect the user after successfully login
        if (httpServletRequest.getContextPath().equals("/SPRBakuposter")) {
            httpServletResponse.sendRedirect("main");
        } else {
            httpServletResponse.sendRedirect("/main");
        }

    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

}
