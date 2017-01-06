/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.service;

import rashjz.info.app.bp.dao.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rashjz.info.app.bp.domain.Content;
import rashjz.info.app.bp.domain.PagingResult;

/**
 *
 * @author Rashad Javadov
 */
@Service
public class ContentServiceImpl implements Serializable, ContentService {

//    private static final Logger LOG = Logger.getLogger(ContentServiceImpl.class.getName());
    @Autowired
    ContentDao contentDao;

    public Content addContent(Content cust) {
       return contentDao.addContent(cust);
    }

    public void deleteContent(int custid) {
        contentDao.deleteContent(custid);
    }

    public Content updateContent(Content cust) {
       return   contentDao.updateContent(cust);
    }

    public List<Content> getAllContent() {
        return contentDao.getAllContent();
    }

    public List<Content> getContentId(String custid) {
        return contentDao.getContentId(custid);
    }

    public PagingResult lazyLoadContent(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters) {
        return contentDao.lazyLoadContent(first, pageSize, sortField, sortOrder, filters);
    }

    public Number lazyLoadContentCount(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult) {
        return contentDao.lazyLoadContentCount(first, pageSize, sortField, sortOrder, filters, pagingResult);
    }
;

}
