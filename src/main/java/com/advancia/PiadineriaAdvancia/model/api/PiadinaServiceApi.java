package com.advancia.PiadineriaAdvancia.model.api;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.advancia.PiadineriaAdvancia.model.classes.Piadina;

//http://localhost:8080/PiadineriaAdvancia/api/soap/piadinas?wsdl

@WebService
public interface PiadinaServiceApi {
	
	@WebMethod
	List<Piadina> getPiadinas();
	
	@WebMethod
    String test(String name);
}
