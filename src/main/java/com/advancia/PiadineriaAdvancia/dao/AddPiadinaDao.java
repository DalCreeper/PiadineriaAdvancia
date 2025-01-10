package com.advancia.PiadineriaAdvancia.dao;

import javax.persistence.EntityManager;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Piadina;

public class AddPiadinaDao {
	public void insertPiadina(EntityManager em, Piadina piadina) {
		try {
			em.merge(piadina);
		} catch(Exception e) {
            throw new DBException("Error while inserting piadina into DB.", e);
        }
	}
}