package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import exceptions.DBException;
import model.classes.Employee;

public class EmployeeDao {
	private final String GET_USER_BY_USERNAME_PASSWORD = "FROM Employee WHERE username = :username AND password = :password";
    
	public Employee getEmployee(Session session, String username, String password) {
        try {
            Query<Employee> query = session.createQuery(GET_USER_BY_USERNAME_PASSWORD, Employee.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.uniqueResult();
        } catch(Exception e) {
            throw new DBException("Error while getting user with username: " + username, e);
        }
    }
}