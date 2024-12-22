package services;

import java.util.List;
import java.util.Map;

import dao.services.PiadinaComponentsServiceDao;

public class PiadinaComponentsService {
	private PiadinaComponentsServiceDao piadinaComponentsServiceDao = new PiadinaComponentsServiceDao();
	
	public Map<String, List<Object>> getPiadinaComponents() {
		return piadinaComponentsServiceDao.getPiadinaComponents();
	}
}
