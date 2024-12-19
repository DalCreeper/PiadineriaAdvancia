package services;

import java.util.ArrayList;
import java.util.List;

import dao.services.PiadinaServiceDao;
import model.classes.Piadina;

public class PiadinaService {
	private PiadinaServiceDao piadinaServiceDao = new PiadinaServiceDao();
	
	public List<Piadina> getPiadinas() {
		return piadinaServiceDao.getPiadinas();
	}
	
	public void addPiadina(Piadina p) {
		List<Piadina> listTemp = new ArrayList<>(getPiadinas());
		listTemp.add(p);
	}
	
	public void removePiadina(Piadina p) {
		List<Piadina> listTemp = new ArrayList<>(getPiadinas());
		listTemp.remove(p);
	}
}
