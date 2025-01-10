package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class AddDoughDao {
    public void add(Dough d, EntityManager em) {
        try {
            em.persist(d);
        } catch(Exception e) {
            throw new DBException("Error while adding dough.", e);
        }
    }
}