package services;

import java.util.Map;
import java.util.Set;

import dao.PiadinaComponentsDao;

public class PiadinaComponentsService {
	private PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();
	
	public Map<String, Set<Object>> getPiadinaComponents() {
		return piadinaComponentsDao.getAllComponents();
	}
}