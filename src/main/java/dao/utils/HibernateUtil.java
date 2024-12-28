package dao.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Logger log = LogManager.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            log.info("Hibernate session to DB created.");
        } catch(Throwable ex) {
        	log.fatal("Hibernate SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
    	log.info("Hibernate session to DB closed.");
        getSessionFactory().close();
    }
}