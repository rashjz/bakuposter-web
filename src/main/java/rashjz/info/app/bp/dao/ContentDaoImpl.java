/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import rashjz.info.app.bp.config.HibernateUtil;
import rashjz.info.app.bp.domain.Content;
import rashjz.info.app.bp.domain.PagingResult;

/**
 *
 * @author Rashad Javadov
 */
@Repository
public class ContentDaoImpl implements Serializable, ContentDao {

    private static final Logger LOG = Logger.getLogger(ContentDaoImpl.class.getName());

//    @Autowired
//    private HibernateTemplate hibernateTemplate;

    public Content addContent(Content cust) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(cust);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cust;
    }

    public void deleteContent(int custid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Content cust = (Content) session.load(Content.class, new Integer(custid));
            session.delete(cust);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public Content updateContent(Content cust) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(cust);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cust;
    }

    public List<Content> getAllContent() {
        List<Content> users = new ArrayList<Content>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Content ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }

    public List<Content> getContentId(String custid) { 
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Content where REC_ID = :id";
            Query query = session.createQuery(queryString);
            query.setString("id", custid);
            //cust = (Customer) query.uniqueResult();
            List<Content> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }

    public PagingResult lazyLoadContent(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters) {
        PagingResult result = new PagingResult();
        LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
        Transaction trns = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Criteria crit = session.createCriteria(Content.class);
            if (sortField != null && !sortField.isEmpty()) {
                if (sortOrder.equals(sortOrder.ASCENDING)) {
                    crit = crit.addOrder(Order.asc(sortField));
                } else {
                    crit = crit.addOrder(Order.desc(sortField));
                }
            } else {
                crit = crit.addOrder(Order.desc("recId"));
            }
            if (filters != null && !filters.isEmpty()) {
                Iterator<Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<String, Object> entry = iterator.next();
//                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue().toString());
                    if (entry.getKey().equals("typeId")) {
                        crit = crit.add(Restrictions.eq(entry.getKey(), Integer.valueOf(entry.getValue().toString())));
                    } else if (entry.getKey().equals("title")) {
                        crit = crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.START));
                    }
                }
            }
            crit = crit.setFirstResult(first).setMaxResults(pageSize);
            result.setList(crit.list());
            return result;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

        return null;
    }

    public Number lazyLoadContentCount(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult) {
        PagingResult result = new PagingResult();
//        LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Criteria crit = session.createCriteria(Content.class);
//            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            crit.setProjection(Projections.rowCount());
            if (filters != null && !filters.isEmpty()) {
                Iterator<Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<String, Object> entry = iterator.next();
//                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue().toString());
                    if (entry.getKey().equals("typeId")) {
                        crit = crit.add(Restrictions.eq(entry.getKey(), Integer.valueOf(entry.getValue().toString())));
                    } else if (entry.getKey().equals("title")) {
                        crit = crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.START));
                    }
                }
            }

//            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            Long resultCount = (Long) crit.uniqueResult();
            pagingResult.setTotalResult(resultCount.intValue());
            LOG.info("****************** resultCount **** " + resultCount);
            return resultCount;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }

}
