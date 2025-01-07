package dao.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.AddPiadinaDao;
import dao.GetPiadinasDao;
import dao.RemovePiadinaDao;
import dao.utils.HibernateUtil;
import exceptions.DBException;
import model.classes.Piadina;

public class PiadinaDaoService {
	private final GetPiadinasDao getPiadinasDao = new GetPiadinasDao();
	private final AddPiadinaDao addPiadinaDao = new AddPiadinaDao();
	private final RemovePiadinaDao removePiadinaDao = new RemovePiadinaDao();
	
	public List<Piadina> getPiadinas() {
		Transaction transaction = null;
		
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Piadina> piadinas = getPiadinasDao.getPiadinas(session);
            transaction.commit();
            return piadinas;
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while retrieving piadinas.", e);
        }
	}
	
	public void addPiadina(Piadina piadina) {
		Transaction transaction = null;
		
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            addPiadinaDao.insertPiadina(session, piadina);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while adding piadina.", e);
        }
	}
	
	public void removePiadina(int piadinaId) {
		Transaction transaction = null;
		
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            removePiadinaDao.deletePiadina(session, piadinaId);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while removing piadina with ID: " + piadinaId, e);
        }
	}
}
