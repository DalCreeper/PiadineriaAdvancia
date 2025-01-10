package com.advancia.PiadineriaAdvancia.dao;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class UpdateEmployeeDao {
    public void update(EntityManager em, int UID, Employee emUpdated) {
        try {
            Employee existingEmployee = em.find(Employee.class, UID);
            if(existingEmployee == null) {
                throw new DBException("Employee with UID: " + UID + " not found");
            }

            existingEmployee.setName(emUpdated.getName());
            existingEmployee.setSurname(emUpdated.getSurname());
            existingEmployee.setUsername(emUpdated.getUsername());
            existingEmployee.setYob(emUpdated.getYob());
            existingEmployee.setRole(emUpdated.getRole());

            em.merge(existingEmployee);
        } catch(Exception e) {
            throw new DBException("Error while updating employee with UID: " + UID, e);
        }
    }
}