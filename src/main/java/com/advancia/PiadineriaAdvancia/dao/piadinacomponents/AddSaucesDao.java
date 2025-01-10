package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.Sauces;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class AddSaucesDao {
    public void add(Sauces s, EntityManager em) {
        try {
            em.persist(s);
        } catch(Exception e) {
            throw new DBException("Error while adding sauces.", e);
        }
    }
}