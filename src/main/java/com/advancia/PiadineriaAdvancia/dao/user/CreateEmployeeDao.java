package com.advancia.PiadineriaAdvancia.dao.user;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class CreateEmployeeDao {
    public void create(EntityManager em, Employee employee) {
        try {
            em.persist(employee);
        } catch(Exception e) {
            throw new DBException("Error while creating a new employee", e);
        }
    }
}