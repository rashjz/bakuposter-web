/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rashjz.info.app.bp.domain.GcmUsers;
import rashjz.info.app.bp.domain.UserRoles;
import rashjz.info.app.bp.domain.Users;
import rashjz.info.app.bp.dto.UserRegistrationForm;
import rashjz.info.app.bp.service.GcmUsersService;
import rashjz.info.app.bp.service.UserService;
import rashjz.info.app.bp.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Mobby
 */
@Controller
public class AdminController implements Serializable {

    private static final Logger LOG = Logger.getLogger(AdminController.class.getName());

    @Autowired
    UserService userService;

    @Autowired
    GcmUsersService gcmUsersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get2MainPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("userReg", new UserRegistrationForm());
        return "redirect:/projects?typeId=1";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", new UserUtil().getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String adminUsersPage(ModelMap model) {
        List<GcmUsers> usersList = gcmUsersService.getAllGcmUsers();
        model.addAttribute("users", usersList);
        return "admin/users";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String makeSomeAction(@ModelAttribute("userReg") UserRegistrationForm form,
                                 BindingResult result, Model model,
                                 final RedirectAttributes redirectAttributes) {
        LOG.info("register - - - " + form.toString());
        if (result.hasErrors()) {
            return "login";
        } else {
            Users user = new Users();
            user.setFirstname(form.getFirstName());
            user.setLastname(form.getLastName());
            user.setPassword(form.getPasswd());
            user.setUsername(form.getEmail());
            user.setEnabled((byte) 1);

            UserRoles roles = new UserRoles();
            roles.setRole("ROLE_USER");
            roles.setUsers(user);

            final HashSet<UserRoles> userRoleses = new HashSet<UserRoles>();
            userRoleses.add(roles);
            user.setUserRoleses(userRoleses);

            userService.addUser(user);

        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("userReg", new UserRegistrationForm());
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        //You can redirect wherever you want, but generally it's a good idea to show login screen again.
        return "redirect:/login?logout";
    }


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg", "You do not have permission to access this page!");
        }
        model.setViewName("403");
        return model;

    }

}
