package services;

import dao.EmployeeDao;
import model.classes.Employee;

public class UserService {
	private EmployeeDao employeeDao = new EmployeeDao();
	
	public Employee getUser(String username, String password) {
		return employeeDao.getEmployee(username, password);
	}
}