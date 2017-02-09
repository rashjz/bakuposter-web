/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.web;

import java.io.File;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import rashjz.info.app.bp.domain.Location;
import rashjz.info.app.bp.domain.Users;
import rashjz.info.app.bp.dto.LocalUser;
import rashjz.info.app.bp.dto.SecurityUtil;
import rashjz.info.app.bp.service.UserService;
import rashjz.info.app.bp.social.util.AuthorizationUtility;
import rashjz.info.app.bp.util.ExtensionParser;
import rashjz.info.app.bp.util.UserUtil;

/**
 * @author Mobby
 */
@Controller
public class AboutController implements Serializable {
//http://websystique.com/springmvc/spring-mvc-4-file-upload-example-using-multipartconfigelement/

    private static String UPLOAD_LOCATION = "/home/rashad/uploads/";
    private static final Logger LOG = Logger.getLogger(AboutController.class.getName());

    //    @Autowired
//    FileValidator fileValidator;
//    @InitBinder("fileUpload")
//    protected void initBinderFileBucket(WebDataBinder binder) {
////        binder.setValidator(fileValidator);
//    }
    @Autowired
    UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.setAllowedFields("place.placeId", "place.name", "place.description", "place.directions", "place.coordinates*", "features*", "tmpFiles*", "removeFiles*");
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView getPage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("/about");
        model.addObject("typeId", 4);
        model.addObject("message", " ");
        return model;
    }

    @RequestMapping(value = "/privacy-policy", method = RequestMethod.GET)
    public String getPrivacyPolicy() {
        return "privacy-policy";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getSingleUploadPage(Model model) {
        return "user";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getContactPage(Model model) {
//        model.addAttribute("location", new Location());
        model.addAttribute("typeId", 5);
        return "contact";
    }

    @RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
    public String doUpload(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("imagefile") MultipartFile file) {
//        @Size(min = 1, max = 10, message = "You messed up!")
        LOG.info("--------------- " + request.getParameter("name") + "  file " + file.getOriginalFilename());

        try {
            if (file != null && !file.isEmpty()) {
                String fileName = UUID.randomUUID().toString() + "." + ExtensionParser.getExt(file.getOriginalFilename());
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_LOCATION + fileName));
                //update userimage 
                Users users = userService.getbyUserName(new UserUtil().getPrincipal());
                //uploads -  url that will get image folder from mvc resources
                users.setNote("/uploads/" + fileName);
                userService.updateUser(users);

                LocalUser lu = new LocalUser(users, users.getUsername(), users.getPassword(), true, true, true, true, new AuthorizationUtility().getAuthorities(users.getUserRoleses()));
                SecurityUtil.authenticateUser(lu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user";
    }
    // @JsonView(Views.Public.class) - Optional, filters json data to display.


}
