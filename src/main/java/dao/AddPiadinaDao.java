package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.utils.HibernateUtil;
import exceptions.DBException;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Piadina;
import model.classes.Sauces;

public class AddPiadinaDao {
	public void insertPiadina(Piadina piadina) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

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
                transaction.commit();
            } catch(Exception e) {
                transaction.rollback();
                throw new DBException("Error while inserting piadina into DB.", e);
            }
        } catch(Exception e) {
            throw new DBException("Error while starting session for inserting piadina.", e);
        }
    }
}
