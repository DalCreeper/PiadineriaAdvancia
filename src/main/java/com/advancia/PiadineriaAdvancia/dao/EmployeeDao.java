package com.advancia.PiadineriaAdvancia.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.advancia.PiadineriaAdvancia.dao.utils.JPAUtil;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class EmployeeDao {
	private final String GET_USER_BY_USERNAME_PASSWORD = "SELECT e FROM Employee e WHERE e.username = :username AND e.password = :password";

    public Employee getEmployee(String username, String password) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Employee employee = null;

        try {
            transaction.begin();
            TypedQuery<Employee> query = em.createQuery(GET_USER_BY_USERNAME_PASSWORD, Employee.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
           
            employee = query.getSingleResult();
            transaction.commit();
        } catch(Exception e) {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while getting user with username: " + username, e);
        } finally {
            em.close();
        }
        return employee;
    }
}