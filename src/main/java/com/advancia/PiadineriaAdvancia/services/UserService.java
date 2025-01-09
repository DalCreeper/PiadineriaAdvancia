package com.advancia.PiadineriaAdvancia.services;

import com.advancia.PiadineriaAdvancia.dao.EmployeeDao;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class UserService {
	private EmployeeDao employeeDao = new EmployeeDao();
	
	public Employee getUser(String username, String password) {
		return employeeDao.getEmployee(username, password);
	}
}