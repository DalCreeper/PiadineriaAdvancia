package dao.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.EmployeeDao;
import dao.utils.HibernateUtil;
import exceptions.DBException;
import model.classes.Employee;

public class EmployeeDaoService {
	private final EmployeeDao employeeDao = new EmployeeDao();

    public Employee getEmployee(String username, String password) {
        Transaction transaction = null;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = employeeDao.getEmployee(session, username, password);
            transaction.commit();
            return employee;
        } catch(Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DBException("Error while retrieving employee.", e);
        }
    }
}