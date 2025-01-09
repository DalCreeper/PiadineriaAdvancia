package com.advancia.PiadineriaAdvancia.services;

import java.util.Map;
import java.util.Set;

import com.advancia.PiadineriaAdvancia.dao.PiadinaComponentsDao;

public class PiadinaComponentsService {
	private PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();
	
	public Map<String, Set<Object>> getPiadinaComponents() {
		return piadinaComponentsDao.getAllComponents();
	}
}