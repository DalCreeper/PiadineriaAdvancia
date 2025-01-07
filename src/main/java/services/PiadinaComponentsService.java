package services;

import java.util.List;
import java.util.Map;

import dao.services.PiadinaComponentsDaoService;

public class PiadinaComponentsService {
	private PiadinaComponentsDaoService piadinaComponentsDaoService = new PiadinaComponentsDaoService();
	
	public Map<String, List<Object>> getPiadinaComponents() {
		return piadinaComponentsDaoService.getAllComponents();
	}
}