package dao.services;

import java.util.Map;
import java.util.Set;

import javax.persistence.EntityTransaction;

import dao.PiadinaComponentsDao;
import dao.utils.CloseableEntityManager;
import exceptions.DBException;

public class PiadinaComponentsDaoService {
	private final PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();

    public Map<String, Set<Object>> getAllComponents() {
        try (CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            Map<String, Set<Object>> components = piadinaComponentsDao.getAllComponents(em.getManager());
            
            transaction.commit();
            return components;
        } catch(Exception e) {
            throw new DBException("Error while retrieving piadina components.", e);
        }
    }
}
