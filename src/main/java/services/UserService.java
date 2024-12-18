package services;

import dao.services.EmployeeServiceDao;
import model.classes.Employee;

public class UserService {
	private EmployeeServiceDao employeeServiceDao = new EmployeeServiceDao();
	
	public Employee getUser(String username, String password) {
		return employeeServiceDao.getUser(username, password);
	}
}