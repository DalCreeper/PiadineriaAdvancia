package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.utils.JPAUtil;
import exceptions.DBException;
import model.classes.Piadina;

public class AddPiadinaDao {
	public void insertPiadina(Piadina piadina) {
		EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            piadina = em.merge(piadina);
            transaction.commit();
        } catch(Exception e) {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while inserting piadina into DB.", e);
        } finally {
            em.close();
        }
    }
}