package dao.utils;

import javax.persistence.EntityManager;

import exceptions.DBException;

public class CloseableEntityManager implements AutoCloseable  {
	private EntityManager em = JPAUtil.getEntityManager();
	
	public EntityManager getManager() {
		return em;
	}
	
	@Override
	public void close() {
		try {
			em.close();
		} catch(Exception e) {
			throw new DBException("Error while closing EntityManager.", e);
		}
	}
}