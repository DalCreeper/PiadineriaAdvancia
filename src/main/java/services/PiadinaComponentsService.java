package services;

import java.util.List;
import java.util.Map;

import dao.PiadinaComponentsDao;

public class PiadinaComponentsService {
	private PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();
	
	public Map<String, List<Object>> getPiadinaComponents() {
		return piadinaComponentsDao.getAllComponents();
	}
}