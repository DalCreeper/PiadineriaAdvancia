package services;

import java.util.Map;
import java.util.Set;

import dao.services.PiadinaComponentsDaoService;

public class PiadinaComponentsService {
	private PiadinaComponentsDaoService piadinaComponentsDaoService = new PiadinaComponentsDaoService();
	
	public Map<String, Set<Object>> getPiadinaComponents() {
		return piadinaComponentsDaoService.getAllComponents();
	}
}