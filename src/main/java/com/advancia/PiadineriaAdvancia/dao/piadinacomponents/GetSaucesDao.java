package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.Sauces;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class GetSaucesDao {
    private final String GET_SAUCES_BY_ID = "SELECT s FROM Sauces s WHERE s.id = :id";

    public Sauces get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_SAUCES_BY_ID, Sauces.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces with ID: " + id, e);
        }
    }
}
