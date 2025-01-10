package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;

public class RemoveOptionalElementsDao {
    public void remove(int id, EntityManager em) {
        try {
            OptionalElements oe = em.find(OptionalElements.class, id);
            if(oe != null) {
                em.remove(oe);
            } else {
                throw new DBException("Optional element with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing optional element with ID: " + id, e);
        }
    }
}