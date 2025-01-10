package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class UpdateDoughDao {
    public void update(int id, Dough d, EntityManager em) {
        try {
            Dough existingDough = em.find(Dough.class, id);
            if(existingDough != null) {
                existingDough.setType(d.getType());
                existingDough.setDescription(d.getDescription());
                existingDough.setPrice(d.getPrice());
                em.merge(existingDough);
            } else {
                throw new DBException("Dough with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating dough with ID: " + id, e);
        }
    }
}