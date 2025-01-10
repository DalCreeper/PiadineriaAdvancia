package com.advancia.PiadineriaAdvancia.dao.services;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.advancia.PiadineriaAdvancia.dao.AddPiadinaDao;
import com.advancia.PiadineriaAdvancia.dao.GetPiadinasDao;
import com.advancia.PiadineriaAdvancia.dao.RemovePiadinaDao;
import com.advancia.PiadineriaAdvancia.dao.utils.CloseableEntityManager;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Piadina;

public class PiadinaDaoService {
	private final GetPiadinasDao getPiadinasDao = new GetPiadinasDao();
	private final AddPiadinaDao addPiadinaDao = new AddPiadinaDao();
	private final RemovePiadinaDao removePiadinaDao = new RemovePiadinaDao();
	
	public List<Piadina> getPiadinas() {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
			EntityTransaction transaction = em.getManager().getTransaction();
			
			transaction.begin();
			List<Piadina> piadinas = getPiadinasDao.getPiadinas(em.getManager());
            transaction.commit();
            return piadinas;
		} catch(Exception e) {
            throw new DBException("Error while retrieving piadinas.", e);
        }
	}
	
	public void addPiadina(Piadina piadina) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
			EntityTransaction transaction = em.getManager().getTransaction();
			
			transaction.begin();
			addPiadinaDao.insertPiadina(em.getManager(), piadina);
            transaction.commit();
		} catch(Exception e) {
            throw new DBException("Error while adding piadina.", e);
        }
	}
	
	public void removePiadina(int piadinaId) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
			EntityTransaction transaction = em.getManager().getTransaction();
			
			transaction.begin();
			removePiadinaDao.deletePiadina(em.getManager(), piadinaId);
            transaction.commit();
		} catch(Exception e) {
            throw new DBException("Error while removing piadina.", e);
        }
	}
}