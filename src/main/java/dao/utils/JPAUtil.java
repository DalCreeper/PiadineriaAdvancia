package dao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JPAUtil {
	private static final Logger log = LogManager.getLogger(JPAUtil.class);
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
            log.info("EntityManagerFactory created successfully.");
        } catch(Throwable ex) {
            log.fatal("EntityManagerFactory creation failed.", ex);
            throw new ExceptionInInitializerError("EntityManagerFactory creation failed: " + ex);
        }
    }
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void shutdown() {
        if(emf != null && emf.isOpen()) {
            log.info("JPA persistence session to DB closed.");
            emf.close();
        }
    }
}