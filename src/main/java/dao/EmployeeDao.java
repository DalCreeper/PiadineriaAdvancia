package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.utils.HibernateUtil;
import exceptions.DBException;
import model.classes.Employee;

public class EmployeeDao {
	private final String GET_USER_BY_USERNAME_PASSWORD = "FROM Employee WHERE username = :username AND password = :password";
    
    public Employee getEmployee(String username, String password) {
        Transaction transaction = null;
        Employee employee = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            Query<Employee> query = session.createQuery(GET_USER_BY_USERNAME_PASSWORD, Employee.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            employee = query.uniqueResult();
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null) transaction.rollback();
            throw new DBException("Error while getting user with username: " + username, e);
        }
        return employee;
    }
}