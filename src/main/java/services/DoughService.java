package services;

import java.util.List;

import dao.services.DoughServiceDao;
import model.classes.Dough;

public class DoughService {
	private DoughServiceDao doughServiceDao = new DoughServiceDao();
	
	public List<Dough> getDoughs() {
		return doughServiceDao.getDoughs();
	}
}