package com.advancia.PiadineriaAdvancia.dao.user;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class DeleteEmployeeDao {
    public void delete(EntityManager em, int UID) {
        try {
            Employee employee = em.find(Employee.class, UID);
            if(employee == null) {
                throw new DBException("Employee with UID: " + UID + " not found");
            }

            em.remove(employee);
        } catch(Exception e) {
            throw new DBException("Error while deleting employee with UID: " + UID, e);
        }
    }
}