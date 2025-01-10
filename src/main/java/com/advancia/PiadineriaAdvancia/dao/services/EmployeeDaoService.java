package com.advancia.PiadineriaAdvancia.dao.services;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.advancia.PiadineriaAdvancia.dao.CreateEmployeeDao;
import com.advancia.PiadineriaAdvancia.dao.DeleteEmployeeDao;
import com.advancia.PiadineriaAdvancia.dao.EmployeeByIDDao;
import com.advancia.PiadineriaAdvancia.dao.EmployeeDao;
import com.advancia.PiadineriaAdvancia.dao.EmployeesDao;
import com.advancia.PiadineriaAdvancia.dao.UpdateEmployeeDao;
import com.advancia.PiadineriaAdvancia.dao.utils.CloseableEntityManager;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class EmployeeDaoService {
	private final EmployeeDao employeeDao = new EmployeeDao();
	private final EmployeesDao employeesDao = new EmployeesDao();
	private final EmployeeByIDDao employeeByIDDao = new EmployeeByIDDao();
	private final CreateEmployeeDao createEmployeeDao = new CreateEmployeeDao();
	private final UpdateEmployeeDao updateEmployeeDao = new UpdateEmployeeDao();
	private final DeleteEmployeeDao deleteEmployeeDao = new DeleteEmployeeDao();

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
    
    public List<Employee> getEmployees() {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();

            List<Employee> employees = employeesDao.getEmployees(em.getManager());

            transaction.commit();
            return employees;
        } catch(Exception e) {
            throw new DBException("Error while retrieving employees list", e);
        }
    }
    
	public Employee getEmployee(int UID) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();

            Employee employee = employeeByIDDao.getEmployeeByID(em.getManager(), UID);

            transaction.commit();
            return employee;
        } catch(Exception e) {
            throw new DBException("Error while retrieving employee with UID: " + UID, e);
        }
    }
	
	public void createEmployee(Employee em) {
		try(CloseableEntityManager emManager = new CloseableEntityManager()) {
            EntityTransaction transaction = emManager.getManager().getTransaction();
            transaction.begin();

            createEmployeeDao.create(emManager.getManager(), em);

            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while creating employee", e);
        }
	}
	
	public void updateEmployee(int UID, Employee emUpdated) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();

            updateEmployeeDao.update(em.getManager(), UID, emUpdated);

            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while updating employee with UID: " + UID, e);
        }
	}
	
	public void deleteEmployee(int UID) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();

            deleteEmployeeDao.delete(em.getManager(), UID);

            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while deleting employee with UID: " + UID, e);
        }
	}
}
