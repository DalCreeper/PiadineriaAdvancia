package com.advancia.PiadineriaAdvancia.model.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.advancia.PiadineriaAdvancia.model.classes.Employee;

// http://localhost:8080/PiadineriaAdvancia/api/soap/login?wsdl

@WebService
public interface UserLoginServiceApi {
	
	@WebMethod
    Employee login(String username, String password);
	
	@WebMethod
    String test(String name);
}
