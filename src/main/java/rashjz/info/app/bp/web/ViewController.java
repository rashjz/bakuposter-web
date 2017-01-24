/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rashjz.info.app.bp.domain.Content;
import rashjz.info.app.bp.domain.Location;
import rashjz.info.app.bp.service.ContentService;
import rashjz.info.app.bp.service.LocationService;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Mobby
 */
@Controller
public class ViewController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ViewController.class.getName());

    @Autowired
    ContentService contentService;

    @Autowired
    LocationService locationService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @ModelAttribute("contentTypeList")
    public Map<String, String> populateNumberList() {
        //Data referencing for java skills list box
        Map<String, String> typeList = new LinkedHashMap<String, String>();
        typeList.put("1", "Kino");
        typeList.put("2", "Konsert");
        typeList.put("3", "Teatr");
        return typeList;
    }

    @ModelAttribute("locationList")
    public List<Location> populateLocList() {
        List<Location> list = locationService.getAllLocation();
        return list;
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String getViewPage(@PathVariable("id") BigDecimal id, Model model) {
        LOG.info("--------getViewPage------ " + id);
        Content content = new Content();
        List<Content> listofData = contentService.getContentId(id.toString());
        if (listofData != null && listofData.size() > 0) {
            content = listofData.get(0);
//            LOG.info("content : : : : " + content.toString());
        }
        
        model.addAttribute("content", content);
        return "admin/view";
    }

    // delete content
    @RequestMapping(value = "/view/{id}/delete", method = RequestMethod.GET)
    public String getUpdateContent(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        LOG.info("deleteContent() : {}" + id);
        contentService.deleteContent(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Content is deleted!");
        return "redirect:/main";
    }

    @RequestMapping(value = "view", method = RequestMethod.POST)
    public String makeSomeAction(@ModelAttribute("content") Content content, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        LOG.info("save-Or-Update-Content - - - " + content.getTitle());
        if (result.hasErrors()) {
            return "admin/view";
        } else {
//            LOG.info("-- -- -- "+content.toString());
            redirectAttributes.addFlashAttribute("css", "success");
            if (content.getRecId() == null || content.getRecId() == 0) {//is new
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
                content.setInsDate(new Date());
                content.setStatus("1");
                content = contentService.addContent(content);
                LOG.info("::'' " + content.getRecId());
            } else {
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
                content.setInsDate(new Date());
                content.setStatus("1");
                content = contentService.updateContent(content);
            }
            return "redirect:/view/" + content.getRecId();
        }
    }

    @RequestMapping(value = "/view/add", method = RequestMethod.GET)
    public String getAddContent(Model model) {
        LOG.info("get new content ()");
        Content content = new Content();
        model.addAttribute("content", content);
        return "admin/view";
    }
}
