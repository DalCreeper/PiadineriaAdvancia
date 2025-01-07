package services;

import dao.services.EmployeeDaoService;
import model.classes.Employee;

public class UserService {
	private EmployeeDaoService employeeDaoService = new EmployeeDaoService();
	
	public Employee getUser(String username, String password) {
		return employeeDaoService.getEmployee(username, password);
	}
}