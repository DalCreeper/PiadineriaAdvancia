package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import exceptions.DBException;
import model.classes.Employee;

public class EmployeeDao {
	private final String GET_USER_BY_USERNAME_PASSWORD = "SELECT e FROM Employee e WHERE e.username = :username AND e.password = :password";

    public Employee getEmployee(EntityManager em, String username, String password) {
        try {
        	TypedQuery<Employee> query = em.createQuery(GET_USER_BY_USERNAME_PASSWORD, Employee.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
           
            return query.getSingleResult();
        } catch(Exception e) {
        	throw new DBException("Error while getting user with username: " + username, e);
        }
    }
}