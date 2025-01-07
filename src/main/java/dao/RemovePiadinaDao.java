package dao;

import javax.persistence.EntityManager;
import exceptions.DBException;
import model.classes.Piadina;

public class RemovePiadinaDao {
	public void deletePiadina(EntityManager em, int piadinaId) {
		try {
			Piadina piadina = em.find(Piadina.class, piadinaId);
            if (piadina != null) {
                piadina.getMeatBase().clear();
                piadina.getSauces().clear();
                piadina.getOptionalElements().clear();
                em.remove(piadina);
            } else {
                throw new DBException("Piadina with ID " + piadinaId + " not found.");
            }
		} catch(Exception e) {
			throw new DBException("Error while deleting piadina from DB.", e);
        }
	}
}