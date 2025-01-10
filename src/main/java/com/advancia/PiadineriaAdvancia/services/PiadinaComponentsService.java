package com.advancia.PiadineriaAdvancia.services;

import java.util.Map;
import java.util.Set;

import com.advancia.PiadineriaAdvancia.dao.services.PiadinaComponentsDaoService;

public class PiadinaComponentsService {
	private PiadinaComponentsDaoService piadinaComponentsDaoService = new PiadinaComponentsDaoService();
	
	public Map<String, Set<Object>> getPiadinaComponents() {
		return piadinaComponentsDaoService.getAllComponents();
	}
}