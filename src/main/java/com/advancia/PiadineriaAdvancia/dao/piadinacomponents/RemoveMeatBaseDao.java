package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;

public class RemoveMeatBaseDao {
    public void remove(int id, EntityManager em) {
        try {
            MeatBase meatBase = em.find(MeatBase.class, id);
            if(meatBase != null) {
                em.remove(meatBase);
            } else {
                throw new DBException("MeatBase with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing meat base with ID: " + id, e);
        }
    }
    
    public void removeByType(String type, EntityManager em) {
        try {
        	MeatBase meatBase = em.createQuery("SELECT m FROM MeatBase m WHERE m.type = :type", MeatBase.class)
	                              .setParameter("type", type)
	                              .getSingleResult();
            if(meatBase != null) {
                em.remove(meatBase);
            } else {
                throw new DBException("MeatBase with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing meatBase with type: " + type, e);
        }
    }
}