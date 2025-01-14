package com.advancia.PiadineriaAdvancia.api.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.api.UserLoginServiceApi;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;
import com.advancia.PiadineriaAdvancia.services.UserService;

@WebService
public class UserLoginApiSoap implements UserLoginServiceApi {
	private UserService userService = new UserService();
	
	@Override
	@WebMethod
	public Employee login(
		@WebParam(name = "username") String username,
		@WebParam(name = "password") String password
	) {
		Employee employee = userService.getUser(username, password);
		if(employee == null) {
			throw new DBException("Invalid credentials");
	    }
	    return employee;
	}
	
	@Override
	@WebMethod
	public String test(@WebParam(name = "message") String message) {
		return "Message test -> " + message + "!";
	}
}