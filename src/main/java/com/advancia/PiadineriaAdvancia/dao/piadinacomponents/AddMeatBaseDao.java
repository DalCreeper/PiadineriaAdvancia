package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class AddMeatBaseDao {
    public void add(MeatBase mt, EntityManager em) {
        try {
            em.persist(mt);
        } catch(Exception e) {
            throw new DBException("Error while adding meat base.", e);
        }
    }
}