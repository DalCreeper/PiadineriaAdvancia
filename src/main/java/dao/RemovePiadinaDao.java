package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.utils.HibernateUtil;
import exceptions.DBException;
import model.classes.Piadina;

public class RemovePiadinaDao {
	public void deletePiadina(int piadinaId) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Piadina piadina = session.get(Piadina.class, piadinaId);
                
                if(piadina != null) {
                	piadina.getSauces().clear();
                    session.delete(piadina);
                    transaction.commit();
                } else {
                    throw new DBException("Piadina with ID " + piadinaId + " not found.");
                }
            } catch(Exception e) {
                transaction.rollback();
                throw new DBException("Error while deleting piadina from DB.", e);
            }
        } catch(Exception e) {
            throw new DBException("Error while deleting piadina from DB.", e);
        }
    }
}
