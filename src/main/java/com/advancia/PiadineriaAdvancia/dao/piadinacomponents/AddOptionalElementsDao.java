package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class AddOptionalElementsDao {
    public void add(OptionalElements oe, EntityManager em) {
        try {
            em.persist(oe);
        } catch(Exception e) {
            throw new DBException("Error while adding optional elements.", e);
        }
    }
}