package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class UpdateOptionalElementsDao {
    public void update(int id, OptionalElements oe, EntityManager em) {
        try {
            OptionalElements existingElement = em.find(OptionalElements.class, id);
            if(existingElement != null) {
            	existingElement.setType(oe.getType());
            	existingElement.setDescription(oe.getDescription());
            	existingElement.setPrice(oe.getPrice());
                em.merge(existingElement);
            } else {
                throw new DBException("Optional element with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating optional elements with ID: " + id, e);
        }
    }
    
    public void updateByType(String type, OptionalElements oe, EntityManager em) {
        try {
        	OptionalElements existingOptionalElements = em.createQuery("SELECT oe FROM OptionalElements oe WHERE oe.type = :type", OptionalElements.class)
				                                          .setParameter("type", type)
			                                              .getSingleResult();
            if(existingOptionalElements != null) {
            	existingOptionalElements.setType(oe.getType());
            	existingOptionalElements.setDescription(oe.getDescription());
            	existingOptionalElements.setPrice(oe.getPrice());
                em.merge(existingOptionalElements);
            } else {
                throw new DBException("OptionalElements with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating optional elements with type: " + type, e);
        }
    }
}