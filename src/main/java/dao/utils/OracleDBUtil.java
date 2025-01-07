package dao.utils;

import org.hibernate.Session;

public class OracleDBUtil {
	public static Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}