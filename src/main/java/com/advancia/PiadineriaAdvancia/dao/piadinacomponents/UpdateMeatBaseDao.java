package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class UpdateMeatBaseDao {
    public void update(int id, MeatBase mt, EntityManager em) {
        try {
            MeatBase existingMeatBase = em.find(MeatBase.class, id);
            if(existingMeatBase != null) {
            	existingMeatBase.setType(mt.getType());
            	existingMeatBase.setDescription(mt.getDescription());
            	existingMeatBase.setPrice(mt.getPrice());
                em.merge(existingMeatBase);
            } else {
                throw new DBException("MeatBase with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating meat base with ID: " + id, e);
        }
    }
    
    public void updateByType(String type, MeatBase mt, EntityManager em) {
        try {
        	MeatBase existingMeatBase = em.createQuery("SELECT mt FROM MeatBase mt WHERE mt.type = :type", MeatBase.class)
	                                      .setParameter("type", type)
	                                      .getSingleResult();
            if(existingMeatBase != null) {
                existingMeatBase.setType(mt.getType());
                existingMeatBase.setDescription(mt.getDescription());
                existingMeatBase.setPrice(mt.getPrice());
                em.merge(existingMeatBase);
            } else {
                throw new DBException("MeatBase with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating meat base with type: " + type, e);
        }
    }
}