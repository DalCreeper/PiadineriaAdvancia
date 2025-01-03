package dao.utils;

import javax.persistence.EntityManager;

public class OracleDBUtil {
	public static EntityManager getEntityManager() {
        return JPAUtil.getEntityManager();
    }
}