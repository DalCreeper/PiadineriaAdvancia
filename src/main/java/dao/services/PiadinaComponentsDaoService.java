package dao.services;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.PiadinaComponentsDao;
import dao.utils.HibernateUtil;
import exceptions.DBException;

public class PiadinaComponentsDaoService {
	private final PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();

    public Map<String, List<Object>> getAllComponents() {
        Transaction transaction = null;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Map<String, List<Object>> components = piadinaComponentsDao.getAllComponents(session);
            transaction.commit();
            return components;
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while retrieving piadina components.", e);
        }
    }
}