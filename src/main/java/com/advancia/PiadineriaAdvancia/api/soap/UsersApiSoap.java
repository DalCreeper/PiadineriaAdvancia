package com.advancia.PiadineriaAdvancia.api.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.api.UsersServiceApi;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;
import com.advancia.PiadineriaAdvancia.services.UserService;

@WebService
public class UsersApiSoap implements UsersServiceApi {
	private UserService userService = new UserService();
	
	@Override
	@WebMethod
	public List<Employee> getAllEmployees() {
		try {
            List<Employee> employees = userService.getUsers();
            if(employees == null || employees.isEmpty()) {
                throw new DBException("No employees found");
            }
            return employees;
        } catch(Exception e) {
            throw new DBException("An error occurred while retrieving employees: " + e.getMessage());
        }
	}
	
	@Override
	public Employee getEmployeeById(@WebParam(name = "id") Integer id) {
		if(id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        Employee employee = userService.getUserByID(id);
        if(employee == null) {
            throw new DBException("Employee not found with ID: " + id);
        }
        return employee;
	}

	@Override
	public Employee createEmployee(@WebParam(name = "newEmployee") Employee newEmployee) {
		try {
            userService.createUser(newEmployee);
            return newEmployee;
        } catch(Exception e) {
            throw new DBException("An error occurred while creating the employee: " + e.getMessage());
        }
	}

	@Override
	public Employee updateEmployee(
			@WebParam(name = "id") Integer id, 
            @WebParam(name = "updatedEmployee") Employee updatedEmployee
    ) {
		if(id == null || updatedEmployee == null) {
            throw new IllegalArgumentException("ID and updatedEmployee must not be null");
        }
        Employee existingEmployee = userService.getUserByID(id);
        if(existingEmployee == null) {
            throw new DBException("Employee not found with ID: " + id);
        }
        userService.updateUser(id, updatedEmployee);
        return updatedEmployee;
	}

	@Override
	public void deleteEmployee(@WebParam(name = "id") Integer id) {
		if(id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        Employee existingEmployee = userService.getUserByID(id);
        if(existingEmployee == null) {
            throw new DBException("Employee not found with ID: " + id);
        }
        userService.deleteUser(id);
	}
	
	@Override
	@WebMethod
	public String test(@WebParam(name = "message") String message) {
		return "Message test -> " + message + "!";
	}
}