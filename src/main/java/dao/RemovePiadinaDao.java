package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.utils.JPAUtil;
import exceptions.DBException;
import model.classes.Piadina;

public class RemovePiadinaDao {
	public void deletePiadina(int piadinaId) {
		EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Piadina piadina = em.find(Piadina.class, piadinaId);
            if(piadina != null) {
                piadina.getMeatBase().clear();
                piadina.getSauces().clear();
                piadina.getOptionalElements().clear();
                em.remove(piadina);
                transaction.commit();
            } else {
                throw new DBException("Piadina with ID " + piadinaId + " not found.");
            }
        } catch(Exception e) {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while deleting piadina from DB.", e);
        } finally {
            em.close();
        }
    }
}