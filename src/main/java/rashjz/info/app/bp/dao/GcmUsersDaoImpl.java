package rashjz.info.app.bp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import rashjz.info.app.bp.config.HibernateUtil;
import rashjz.info.app.bp.domain.GcmUsers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mobby on 1/24/2017.
 */
@Repository
public class GcmUsersDaoImpl implements Serializable, GcmUsersDao{
    @Override
    public List<GcmUsers> getAllGcmUsers() {
        List<GcmUsers> list = new ArrayList<GcmUsers>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            list = session.createQuery("from GcmUsers ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }
}
