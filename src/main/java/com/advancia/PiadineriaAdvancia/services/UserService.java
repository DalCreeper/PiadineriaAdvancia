package com.advancia.PiadineriaAdvancia.services;

import java.util.List;

import com.advancia.PiadineriaAdvancia.dao.services.EmployeeDaoService;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;

public class UserService {
	private EmployeeDaoService employeeDaoService = new EmployeeDaoService();
	
	public Employee getUser(String username, String password) {
		return employeeDaoService.getEmployee(username, password);
	}
	
	public List<Employee> getUsers() {
		return employeeDaoService.getEmployees();
	}
	
	public Employee getUserByID(int UID) {
		return employeeDaoService.getEmployee(UID);
	}
	
	public void createUser(Employee em) {
		employeeDaoService.createEmployee(em);
	}
	
	public void updateUser(int UID, Employee emUpdated) {
		employeeDaoService.updateEmployee(UID, emUpdated);
	}
	
	public void deleteUser(int UID) {
		employeeDaoService.deleteEmployee(UID);
	}
}