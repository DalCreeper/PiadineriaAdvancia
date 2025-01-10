package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.Sauces;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class UpdateSaucesDao {
    public void update(int id, Sauces s, EntityManager em) {
        try {
            Sauces existingSauce = em.find(Sauces.class, id);
            if(existingSauce != null) {
            	existingSauce.setType(s.getType());
            	existingSauce.setDescription(s.getDescription());
            	existingSauce.setPrice(s.getPrice());
                em.merge(existingSauce);
            } else {
                throw new DBException("Sauces with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating sauces with ID: " + id, e);
        }
    }
}