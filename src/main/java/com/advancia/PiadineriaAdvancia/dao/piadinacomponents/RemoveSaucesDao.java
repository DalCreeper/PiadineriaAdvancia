package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;

public class RemoveSaucesDao {
    public void remove(int id, EntityManager em) {
        try {
            Sauces sauces = em.find(Sauces.class, id);
            if(sauces != null) {
                em.remove(sauces);
            } else {
                throw new DBException("Sauces with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing sauces with ID: " + id, e);
        }
    }
}