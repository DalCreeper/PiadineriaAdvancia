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
    
    public void removeByType(String type, EntityManager em) {
        try {
        	OptionalElements oe = em.createQuery("SELECT oe FROM OptionalElements oe WHERE oe.type = :type", OptionalElements.class)
	                                .setParameter("type", type)
	                                .getSingleResult();
            if(oe != null) {
                em.remove(oe);
            } else {
                throw new DBException("OptionalElements with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing optional element with type: " + type, e);
        }
    }
}