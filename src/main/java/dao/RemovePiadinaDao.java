package dao;

import org.hibernate.Session;
import exceptions.DBException;
import model.classes.Piadina;

public class RemovePiadinaDao {
	public void deletePiadina(Session session, int piadinaId) {
        try {
            Piadina piadina = session.get(Piadina.class, piadinaId);
            
            if(piadina != null) {
                piadina.getMeatBase().clear();
                piadina.getSauces().clear();
                piadina.getOptionalElements().clear();
                session.delete(piadina);
            } else {
                throw new DBException("Piadina with ID " + piadinaId + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while deleting piadina from DB.", e);
        }
    }
}
