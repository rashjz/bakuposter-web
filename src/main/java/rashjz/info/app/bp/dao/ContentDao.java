/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.dao;

import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import rashjz.info.app.bp.domain.Content;
import rashjz.info.app.bp.domain.PagingResult;

/**
 *
 * @author Rashad Javadov
 */
public interface ContentDao {

    public Content addContent(Content cust);

    public void deleteContent(int custid);

    public Content updateContent(Content cust);

    public List<Content> getAllContent();

    public List<Content> getContentId(String custid);

    public PagingResult lazyLoadContent(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters);

    public Number lazyLoadContentCount(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult);
                 
}
