package com.advancia.PiadineriaAdvancia.model.api;

import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;

//http://localhost:8080/PiadineriaAdvancia/api/soap/piadina?wsdl

@WebService
public interface PiadinaComponentsServiceApi {
	
	@WebMethod
	Map<String, Set<Object>> loadComponents();
	
	@WebMethod
	Dough addDough(Dough newDough);
	
	@WebMethod
	MeatBase addMeatBase(MeatBase newMeatBase);
	
	@WebMethod
	Sauces addSauces(Sauces newSauces);
	
	@WebMethod
	OptionalElements addOptionalElements(OptionalElements newOptionalElement);
	
	@WebMethod
	Dough getDoughById(Integer id);
	
	@WebMethod
	MeatBase getMeatBaseById(Integer id);
	
	@WebMethod
	Sauces getSaucesById(Integer id);
	
	@WebMethod
	OptionalElements getOptionalElementsById(Integer id);
	
	@WebMethod
	Dough updateDough(Integer id, Dough updatedDough);
	
	@WebMethod
	MeatBase updateMeatBase(Integer id, MeatBase updatedMeatBase);
	
	@WebMethod
	Sauces updateSauces(Integer id, Sauces updatedSauces);
	
	@WebMethod
	OptionalElements updateOptionalElements(Integer id, OptionalElements updatedOptionalElements);
	
	@WebMethod
	void deleteDough(Integer id);
	
	@WebMethod
	void deleteMeatBase(Integer id);
	
	@WebMethod
	void deleteSauces(Integer id);
	
	@WebMethod
	void deleteOptionalElements(Integer id);
	
	@WebMethod
    String test(String name);
}
