package services;

import java.util.List;

import dao.services.SaucesServiceDao;
import model.classes.Sauces;

public class SaucesService {
	private SaucesServiceDao saucesServiceDao = new SaucesServiceDao();
	
	public List<Sauces> getSauces() {
		return saucesServiceDao.getSauces();
	}
}