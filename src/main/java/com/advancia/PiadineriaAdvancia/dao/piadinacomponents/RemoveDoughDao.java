package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Dough;

public class RemoveDoughDao {
    public void remove(int id, EntityManager em) {
        try {
            Dough dough = em.find(Dough.class, id);
            if(dough != null) {
                em.remove(dough);
            } else {
                throw new DBException("Dough with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing dough with ID: " + id, e);
        }
    }
    
    public void removeByType(String type, EntityManager em) {
        try {
            Dough dough = em.createQuery("SELECT d FROM Dough d WHERE d.type = :type", Dough.class)
                            .setParameter("type", type)
                            .getSingleResult();
            if(dough != null) {
                em.remove(dough);
            } else {
                throw new DBException("Dough with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing dough with type: " + type, e);
        }
    }
}