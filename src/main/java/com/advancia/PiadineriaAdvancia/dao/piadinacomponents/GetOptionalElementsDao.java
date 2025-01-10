package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class GetOptionalElementsDao {
    private final String GET_OPTIONAL_ELEMENTS_BY_ID = "SELECT oe FROM OptionalElements oe WHERE oe.id = :id";

    public OptionalElements get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_OPTIONAL_ELEMENTS_BY_ID, OptionalElements.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving optional elements with ID: " + id, e);
        }
    }
}