/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import rashjz.info.app.bp.config.HibernateUtil;
import rashjz.info.app.bp.domain.UserRoles;
import rashjz.info.app.bp.domain.Users;

/**
 *
 * @author Rashad Javadov
 */
@Repository
public class UserDaoImpl implements Serializable, UserDao {
    
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());

//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    @Override
    public Users getbyUserName(String username) {
        List<Users> users = new ArrayList<Users>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Query query = session.getNamedQuery("findByUsername").setString("username", username);
            users = query.list();
//            LOG.info(" # # # "+users.get(0).getUserRoleses().size()+" "+username);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        if (users != null && users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
        
    }
    
    @Override
    public void addUser(Users user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
            for (UserRoles roles : (Set<UserRoles>) user.getUserRoleses()) {
                session.save(roles);
            }
            
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
    
    @Override
    public void deleteUser(int custid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Users cust = (Users) session.load(Users.class, new Integer(custid));
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
    
    @Override
    public void updateUser(Users cust) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(cust);
//            for (UserRoles roles : (Set<UserRoles>) cust.getUserRoleses()) {
//                session.persist(roles);
//            }
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
    
    @Override
    public List<Users> getAllUser() {
        List<Users> users = new ArrayList<Users>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Users ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
    @Override
    public Users findByUsernamePassword(String username, String password) {
        LOG.info("username :::: " + username + " password :::: " + password);
        List<Users> users = new ArrayList<Users>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Query query = session.getNamedQuery("findByUsernamePassword").setString("username", username).setString("password", password);
            users = query.list();            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        if (users != null && users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
    
}
