package services;

import java.util.List;

import dao.services.PiadinaServiceDao;
import model.classes.Piadina;

public class PiadinaService {
	private PiadinaServiceDao piadinaServiceDao = new PiadinaServiceDao();
	
	public List<Piadina> getPiadinas() {
		return piadinaServiceDao.getPiadinas();
	}
	
	public void addPiadina(Piadina piadina) {
		piadinaServiceDao.addPiadina(piadina);
	}
	
	public void removePiadina(int piadinaId) {
		piadinaServiceDao.removePiadina(piadinaId);
	}
}
