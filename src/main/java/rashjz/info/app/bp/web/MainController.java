package rashjz.info.app.bp.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rashjz.info.app.bp.domain.PagingResult;
import rashjz.info.app.bp.service.ContentService;

import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class MainController implements Serializable {

    private static final Logger LOG = Logger.getLogger(MainController.class.getName());

    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getPagingList(Model model, @RequestParam(value = "keyValue", required = false) String keyValue,
            Integer offset, Integer maxResults) {
//        LOG.info("******** keyValue offset ******* " + keyValue + " " + offset);
        PagingResult pagingData = new PagingResult();
        Map<String, Object> filters = new HashMap<String, Object>();
        if (offset == null) {
            offset = 0;
        }
        if (offset != null) {
            if (keyValue != null && !keyValue.equals("")) {
                filters.put("title", keyValue.toString());
            }
            pagingData = contentService.lazyLoadContent(offset.intValue(), 10, null, SortOrder.UNSORTED, null);
            LOG.info(" ****** getList().size **** "+pagingData.getList().size());
        }
        contentService.lazyLoadContentCount(offset.intValue(), 10, null, SortOrder.UNSORTED, null, pagingData);
        model.addAttribute("contents", pagingData.getList());
        model.addAttribute("count", pagingData.getTotalResult());
        model.addAttribute("keyValue", keyValue);
        model.addAttribute("offset", offset);

        return "admin/main";
    }

//    @RequestMapping(value = "/springPaginationDataTables.web", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
//    public @ResponseBody
//    String springPaginationDataTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //Fetch the page number from client 
//        LOG.info(" Start : " + request.getParameter("iDisplayStart")
//                + " sSearch : " + request.getParameter("sSearch")
//                + " iDisplayLength : " + request.getParameter("iDisplayLength")
//                + " keyValue " + request.getParameter("keyValue"));
//        Integer pageNumber, start = 0;
//        if (null != request.getParameter("iDisplayStart")) {
//            start = Integer.valueOf(request.getParameter("iDisplayStart"));
//            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart")) / 10) + 1;
//        }
//
//        //Fetch search parameter
//        String searchParameter = request.getParameter("sSearch");
//        //Fetch Page display length
//        Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
//
//        //Search functionality: Returns filtered list based on search parameter
//        Map<String, Object> searchMap = new HashMap<>();
//        if (searchParameter != null && !searchParameter.equals("")) {
//            searchMap.put("title", searchParameter);
//        }
//        PagingResult p = contentService.lazyLoadContent(start, pageDisplayLength, null, SortOrder.ASCENDING, searchMap);
////        LOG.info("list size is ... "+p.getTotalResult());
//        ContentJsonModel contentJsonModel = new ContentJsonModel();
//        //Set Total display record
//        contentJsonModel.setiTotalDisplayRecords(p.getTotalResult());
//        //Set Total record
//        contentJsonModel.setiTotalRecords(p.getTotalResult());
//        contentJsonModel.setAaData(p.getList());
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        
//        String json2 = gson.toJson(contentJsonModel);
////        response.setCharacterEncoding("UTF-8");
////        LOG.info(json2);
//        response.setCharacterEncoding("UTF-8");
//        return json2;
//    }
}
