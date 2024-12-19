package services;

import java.util.List;

import dao.services.DoughServiceDao;
import dao.services.PiadinaServiceDao;
import model.classes.Dough;
import model.classes.Piadina;

public class DoughService {
	private DoughServiceDao doughServiceDao = new DoughServiceDao();
	
	public List<Dough> getDoughs() {
		return doughServiceDao.getDoughs();
	}
}