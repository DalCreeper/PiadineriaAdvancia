package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class GetDoughDao {
    private final String GET_DOUGH_BY_ID = "SELECT d FROM Dough d WHERE d.id = :id";

    public Dough get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_DOUGH_BY_ID, Dough.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving dough with ID: " + id, e);
        }
    }
}
