/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Mobby
 */
public class HibernateUtil {
    private static final Logger logger = Logger.getLogger(HibernateUtil.class.getName());
    private static SessionFactory sessionFactory;
    private static InputStream inputStream;

    static {
        try {
//            Properties dbConnectionProperties = new Properties();
//            sessionFactory = new Configuration().mergeProperties(dbConnectionProperties).configure().buildSessionFactory();
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
