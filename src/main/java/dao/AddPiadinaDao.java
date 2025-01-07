package dao;

import org.hibernate.Session;
import exceptions.DBException;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Piadina;
import model.classes.Sauces;

public class AddPiadinaDao {
	public void insertPiadina(Session session, Piadina piadina) {
        try {
            session.save(piadina);
            for(MeatBase meatBase : piadina.getMeatBase()) {
                session.save(meatBase);
            }
            for(Sauces sauce : piadina.getSauces()) {
                session.save(sauce);
            }
            for(OptionalElements optionalElement : piadina.getOptionalElements()) {
                session.save(optionalElement);
            }
        } catch(Exception e) {
            throw new DBException("Error while inserting piadina into DB.", e);
        }
    }
}