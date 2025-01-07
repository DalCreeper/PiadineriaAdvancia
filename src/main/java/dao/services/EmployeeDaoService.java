package dao.services;

import javax.persistence.EntityTransaction;

import dao.EmployeeDao;
import dao.utils.CloseableEntityManager;
import exceptions.DBException;
import model.classes.Employee;

public class EmployeeDaoService {
	private final EmployeeDao employeeDao = new EmployeeDao();

    public Employee getEmployee(String username, String password) {
        try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            Employee employee = employeeDao.getEmployee(em.getManager(), username, password);
            
            transaction.commit();
            return employee;
        } catch(Exception e) {
            throw new DBException("Error while retrieving employee with username: " + username, e);
        }
    }
}
