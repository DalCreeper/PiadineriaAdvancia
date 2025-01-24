package com.advancia.PiadineriaAdvancia.services;

import java.util.Map;
import java.util.Set;

import com.advancia.PiadineriaAdvancia.dao.services.PiadinaComponentsDaoService;
import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;

public class PiadinaComponentsService {
	private PiadinaComponentsDaoService piadinaComponentsDaoService = new PiadinaComponentsDaoService();
	
	public Map<String, Set<Object>> getPiadinaComponents() {
		return piadinaComponentsDaoService.getAllComponents();
	}
	
	public void addDough(Dough d) {
		piadinaComponentsDaoService.addDough(d);
	}

	public void addMeatBase(MeatBase mt) {
		piadinaComponentsDaoService.addMeatBase(mt);
	}
	
	public void addSauces(Sauces s) {
		piadinaComponentsDaoService.addSauces(s);
	}
	
	public void addOptionalElements(OptionalElements oe) {
		piadinaComponentsDaoService.addOptionalElements(oe);
	}
	
	public Dough getDoughById(int id) {
		return piadinaComponentsDaoService.getDough(id);
	}
	
	public MeatBase getMeatBaseById(int id) {
		return piadinaComponentsDaoService.getMeatBase(id);
	}
	
	public Sauces getSaucesById(int id) {
		return piadinaComponentsDaoService.getSauces(id);
	}
	
	public OptionalElements getOptionalElementsById(int id) {
		return piadinaComponentsDaoService.getOptionalElements(id);
	}
	
	public void updateDough(int id, Dough d) {
		piadinaComponentsDaoService.updateDough(id, d);
	}
	
	public void updateMeatBase(int id, MeatBase mt) {
		piadinaComponentsDaoService.updateMeatBase(id, mt);
	}
	
	public void updateSauces(int id, Sauces s) {
		piadinaComponentsDaoService.updateSauces(id, s);
	}
	
	public void updateOptionalElements(int id, OptionalElements oe) {
		piadinaComponentsDaoService.updateOptionalElements(id, oe);
	}
	
	public void deleteDough(int id) {
		piadinaComponentsDaoService.deleteDough(id);
	}
	
	public void deleteMeatBase(int id) {
		piadinaComponentsDaoService.deleteMeatBase(id);
	}
	
	public void deleteSauces(int id) {
		piadinaComponentsDaoService.deleteSauces(id);
	}
	
	public void deleteOptionalElements(int id) {
		piadinaComponentsDaoService.deleteOptionalElements(id);
	}
	
	public Dough getDoughByType(String type) {
		return piadinaComponentsDaoService.getDoughByType(type);
	}
	
	public MeatBase getMeatBaseByType(String type) {
		return piadinaComponentsDaoService.getMeatBaseByType(type);
	}
	
	public Sauces getSaucesByType(String type) {
		return piadinaComponentsDaoService.getSaucesByType(type);
	}
	
	public OptionalElements getOptionalElementsByType(String type) {
		return piadinaComponentsDaoService.getOptionalElementsByType(type);
	}
	
	public void updateDoughByType(String type, Dough d) {
		piadinaComponentsDaoService.updateDoughByType(type, d);
	}
	
	public void updateMeatBaseByType(String type, MeatBase mt) {
		piadinaComponentsDaoService.updateMeatBaseByType(type, mt);
	}
	
	public void updateSaucesByType(String type, Sauces s) {
		piadinaComponentsDaoService.updateSaucesByType(type, s);
	}
	
	public void updateOptionalElementsByType(String type, OptionalElements oe) {
		piadinaComponentsDaoService.updateOptionalElementsByType(type, oe);
	}
	
	public void deleteDoughByType(String type) {
		piadinaComponentsDaoService.deleteDoughByType(type);
	}
	
	public void deleteMeatBaseByType(String type) {
		piadinaComponentsDaoService.deleteMeatBaseByType(type);
	}
	
	public void deleteSaucesByType(String type) {
		piadinaComponentsDaoService.deleteSaucesByType(type);
	}
	
	public void deleteOptionalElementsByType(String type) {
		piadinaComponentsDaoService.deleteOptionalElementsByType(type);
	}
}