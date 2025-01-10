package com.advancia.PiadineriaAdvancia.dao.user;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class EmployeeByIDDao {
    public Employee getEmployeeByID(EntityManager em, int UID) {
        try {
            return em.find(Employee.class, UID);
        } catch(Exception e) {
            throw new DBException("Error while getting employee by UID: " + UID, e);
        }
    }
}
