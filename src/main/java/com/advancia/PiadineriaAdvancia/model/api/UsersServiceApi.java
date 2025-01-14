package com.advancia.PiadineriaAdvancia.model.api;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.advancia.PiadineriaAdvancia.model.classes.Employee;

// http://localhost:8080/PiadineriaAdvancia/api/soap/users?wsdl

@WebService
public interface UsersServiceApi {
	@WebMethod
	List<Employee> getAllEmployees();
	
	@WebMethod
	Employee getEmployeeById(Integer id);
	
	@WebMethod
	Employee createEmployee(Employee newEmployee);
	
	@WebMethod
	Employee updateEmployee(Integer id, Employee updatedEmployee);
	
	@WebMethod
	void deleteEmployee(Integer id);
	
	@WebMethod
    String test(String name);
}