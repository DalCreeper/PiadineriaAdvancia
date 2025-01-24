package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;

public class GetMeatBaseDao {
    private final String GET_MEAT_BASE_BY_ID = "SELECT m FROM MeatBase m WHERE m.id = :id";
    private final String GET_MEATBASE_BY_TYPE = "SELECT m FROM MeatBase m WHERE m.type = :type";

    public MeatBase get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_MEAT_BASE_BY_ID, MeatBase.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving meat base with ID: " + id, e);
        }
    }
    
    public MeatBase getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_MEATBASE_BY_TYPE, MeatBase.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving meatBase with type: " + type, e);
        }
    }
}