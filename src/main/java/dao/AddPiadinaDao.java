package dao;

import javax.persistence.EntityManager;
import exceptions.DBException;
import model.classes.Piadina;

public class AddPiadinaDao {
	public void insertPiadina(EntityManager em, Piadina piadina) {
		try {
			em.merge(piadina);
		} catch(Exception e) {
            throw new DBException("Error while inserting piadina into DB.", e);
        }
	}
}