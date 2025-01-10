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
}