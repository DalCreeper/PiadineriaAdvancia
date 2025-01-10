package com.advancia.PiadineriaAdvancia.dao.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class EmployeesDao {
    private final String GET_ALL_EMPLOYEES = "SELECT e FROM Employee e";

    public List<Employee> getEmployees(EntityManager em) {
        try {
            TypedQuery<Employee> query = em.createQuery(GET_ALL_EMPLOYEES, Employee.class);
            return query.getResultList();
        } catch(Exception e) {
            throw new DBException("Error while getting the list of employees", e);
        }
    }
}
