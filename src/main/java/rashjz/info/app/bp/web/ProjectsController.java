package rashjz.info.app.bp.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.SortOrder; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rashjz.info.app.bp.domain.Content;
import rashjz.info.app.bp.domain.Location;
import rashjz.info.app.bp.domain.PagingResult;
import rashjz.info.app.bp.service.ContentService;
import rashjz.info.app.bp.service.LocationService;

/**
 *
 * @author Mobby
 */
@Controller
public class ProjectsController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ProjectsController.class.getName());

    @Autowired
    ContentService contentService;
    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String getPagingList(Model model, @RequestParam(value = "keyValue", required = false) String keyValue,
            @RequestParam(value = "typeId", required = false) String typeId, Integer offset, Integer maxResults) {
        LOG.info("******** keyValue ******* " + keyValue);
        PagingResult pagingData = new PagingResult();
        Map<String, Object> filters = new HashMap<String, Object>();
        if (offset == null) {
            offset = 0;
        }
        if (offset != null) {
//            filters.put("typeId", "1");
            if (keyValue != null && !keyValue.equals("")) {
                filters.put("title", keyValue.toString());
            }
            if (typeId != null && !typeId.equals("")) {
                filters.put("typeId", typeId);
            }
            pagingData = contentService.lazyLoadContent(offset.intValue(), 9, null, SortOrder.UNSORTED, filters);
        }
        contentService.lazyLoadContentCount(offset.intValue(), 9, null, SortOrder.UNSORTED, filters, pagingData);
        model.addAttribute("clist", pagingData.getList());
        model.addAttribute("count", pagingData.getTotalResult());
        model.addAttribute("typeId", typeId);
        model.addAttribute("keyValue", keyValue);
        model.addAttribute("offset", offset);
        return "projects";
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String getEventData(@RequestParam(value = "c", required = false) Long dataID, Model model) {

        List<Content> contents = contentService.getContentId(dataID.toString());
        if (contents != null && contents.size() > 0) {
            Location location = locationService.getLocationByID(contents.get(0).getLocationId());
            LOG.info("location " + location.getTitle());
            model.addAttribute("location", location);
            model.addAttribute("content", contents.get(0));
            model.addAttribute("dataCode", contents.get(0).getRecId());
        } else {
            return "projects";
        }

        return "event";
    }

}
