/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import rashjz.info.app.bp.config.HibernateUtil;
import rashjz.info.app.bp.domain.Content;
import rashjz.info.app.bp.domain.Location;

/**
 *
 * @author Mobby
 */
@Repository
public class LocationDaoImpl implements Serializable, LocationDao {

    @Override
    public List<Location> getAllLocation() {
        List<Location> list = new ArrayList<Location>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            list = session.createQuery("from Location ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    @Override
    public Location getLocationByID(Integer id) {
       Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Location where REC_ID = :id";
            Query query = session.createQuery(queryString);
            query.setString("id", id.toString());
            //cust = (Customer) query.uniqueResult();
            List<Location> list = query.list();
            if (list.size() > 0) {
                return list.get(0);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }

    @Override
    public Location addLocation(Location location) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(location);
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
        return location;
    }

}
